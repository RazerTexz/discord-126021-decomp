package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastReceiverConstraintTracker$1 extends BroadcastReceiver {
    public final /* synthetic */ BroadcastReceiverConstraintTracker this$0;

    public BroadcastReceiverConstraintTracker$1(BroadcastReceiverConstraintTracker broadcastReceiverConstraintTracker) {
        this.this$0 = broadcastReceiverConstraintTracker;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.this$0.onBroadcastReceive(context, intent);
        }
    }
}
