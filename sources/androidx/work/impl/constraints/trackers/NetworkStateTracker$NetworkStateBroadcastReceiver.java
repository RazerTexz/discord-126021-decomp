package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes.dex */
public class NetworkStateTracker$NetworkStateBroadcastReceiver extends BroadcastReceiver {
    public final /* synthetic */ NetworkStateTracker this$0;

    public NetworkStateTracker$NetworkStateBroadcastReceiver(NetworkStateTracker networkStateTracker) {
        this.this$0 = networkStateTracker;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            return;
        }
        Logger.get().debug(NetworkStateTracker.TAG, "Network broadcast received", new Throwable[0]);
        NetworkStateTracker networkStateTracker = this.this$0;
        networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
    }
}
