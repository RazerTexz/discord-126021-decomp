package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public final class LocalBroadcastManager$ReceiverRecord {
    public boolean broadcasting;
    public boolean dead;
    public final IntentFilter filter;
    public final BroadcastReceiver receiver;

    public LocalBroadcastManager$ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.filter = intentFilter;
        this.receiver = broadcastReceiver;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.receiver);
        sb.append(" filter=");
        sb.append(this.filter);
        if (this.dead) {
            sb.append(" DEAD");
        }
        sb.append("}");
        return sb.toString();
    }
}
