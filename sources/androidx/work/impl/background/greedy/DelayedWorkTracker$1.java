package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: classes.dex */
public class DelayedWorkTracker$1 implements Runnable {
    public final /* synthetic */ DelayedWorkTracker this$0;
    public final /* synthetic */ WorkSpec val$workSpec;

    public DelayedWorkTracker$1(DelayedWorkTracker delayedWorkTracker, WorkSpec workSpec) {
        this.this$0 = delayedWorkTracker;
        this.val$workSpec = workSpec;
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger.get().debug(DelayedWorkTracker.TAG, String.format("Scheduling work %s", this.val$workSpec.f38id), new Throwable[0]);
        this.this$0.mGreedyScheduler.schedule(this.val$workSpec);
    }
}
