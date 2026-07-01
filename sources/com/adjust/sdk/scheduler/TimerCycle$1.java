package com.adjust.sdk.scheduler;

/* JADX INFO: loaded from: classes.dex */
public class TimerCycle$1 implements Runnable {
    public final /* synthetic */ TimerCycle this$0;

    public TimerCycle$1(TimerCycle timerCycle) {
        this.this$0 = timerCycle;
    }

    @Override // java.lang.Runnable
    public void run() {
        TimerCycle.access$100(this.this$0).verbose("%s fired", TimerCycle.access$000(this.this$0));
        TimerCycle.access$200(this.this$0).run();
    }
}
