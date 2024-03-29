package me.seat.fb.event;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager {
    public final ConcurrentHashMap<Class<? extends Event>, List<Handler>> events = new ConcurrentHashMap<>();
    public static EventManager instance = new EventManager();
    public final MethodHandles.Lookup lookup = MethodHandles.lookup();

    public static EventManager getInstance() {
        return instance;
    }

    public <E extends Event> E call(E event){
        List<Handler> events = this.events.get(event.getClass());
        if(events != null && !events.isEmpty()){
            for (Handler handler : events){
                try{
                    handler.handle.invokeExact(handler.parent,event);
                }catch (Throwable throwable){
                    throwable.printStackTrace();
                }
            }
        }
        return event;
    }


    public void register(Object... objects){
        for (Object object: objects){
            for (Method method : object.getClass().getDeclaredMethods()){
                if(method.getParameterCount() == 1 && method.isAnnotationPresent(EventTarget.class)){
                    Class<?> eventClass = method.getParameterTypes()[0];
                    if(!this.events.containsKey(eventClass)){
                        this.events.put((Class<? extends Event>)eventClass, new CopyOnWriteArrayList<>());
                    }
                    this.events.get(eventClass).add(new Handler(method,object,method.getDeclaredAnnotation(EventTarget.class).priority()));
                    this.events.get(eventClass).sort(Comparator.comparingInt(e -> e.priority));
                }
            }
        }
    }

    public void unregister(Object... objects){
        for (Object object : objects){
            for (List<Handler> events : this.events.values()){
                for (Handler handler : events){
                    if(handler.parent != object) continue;
                    events.remove(handler);
                }
            }
        }
    }
    public static class Handler{
        public MethodHandle handle;
        public final Object parent;
        public final byte priority;

        public Handler(Method method,Object parent,byte priority){
            if(!method.isAccessible()){
                method.setAccessible(true);
            }
            MethodHandle methodHandle = null;
            try {
                methodHandle = EventManager.instance.lookup.unreflect(method);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(methodHandle != null){
                this.handle = methodHandle.asType(methodHandle.type().changeParameterType(0,Object.class).changeParameterType(1,Event.class));
            }
            this.parent = parent;
            this.priority = priority;
        }
    }
}