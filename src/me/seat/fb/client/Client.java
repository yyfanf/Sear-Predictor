package me.seat.fb.client;

import me.seat.fb.SeatPre;
import me.seat.fb.event.EventManager;
import me.seat.fb.event.events.EventTick;
import me.seat.fb.frames.MainFrame;
import me.seat.fb.util.DelayUtil;

public class Client extends Thread{
    private DelayUtil tickDelayer = new DelayUtil();
    private static int ticks = 0;

    public static int getTicks() {
        return ticks;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            //tick
            if(tickDelayer.hasTimePassed(50)){
                ticks++;
                if(ticks >= 20)ticks = 0;
                EventManager.getInstance().call(new EventTick(ticks));
                tickDelayer.reset();

                new RunTick().onTick();
            }

            //loop
        }
    }
}
