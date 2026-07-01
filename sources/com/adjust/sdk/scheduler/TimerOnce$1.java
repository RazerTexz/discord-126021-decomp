package com.adjust.sdk.scheduler;

/* JADX INFO: loaded from: classes.dex */
public class TimerOnce$1 implements Runnable {
    public final /* synthetic */ TimerOnce this$0;

    public TimerOnce$1(TimerOnce timerOnce) {
        this.this$0 = timerOnce;
    }

    @Override // java.lang.Runnable
    public void run() {
        TimerOnce.access$100(this.this$0).verbose("%s fired", TimerOnce.access$000(this.this$0));
        TimerOnce.access$200(this.this$0).run();
        TimerOnce.access$302(this.this$0, null);
    }
}
