package androidx.localbroadcastmanager.content;

import android.content.Intent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class LocalBroadcastManager$BroadcastRecord {
    public final Intent intent;
    public final ArrayList<LocalBroadcastManager$ReceiverRecord> receivers;

    public LocalBroadcastManager$BroadcastRecord(Intent intent, ArrayList<LocalBroadcastManager$ReceiverRecord> arrayList) {
        this.intent = intent;
        this.receivers = arrayList;
    }
}
