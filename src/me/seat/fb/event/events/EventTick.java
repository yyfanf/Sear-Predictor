package me.seat.fb.event.events;

import me.seat.fb.event.Event;

public class EventTick extends Event {
    private final int tick;

    public int getTick() {
        return tick;
    }

    public EventTick(int tick){
        this.tick = tick;
    }
}
