package androidx.localbroadcastmanager.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class LocalBroadcastManager$1 extends Handler {
    public final /* synthetic */ LocalBroadcastManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalBroadcastManager$1(LocalBroadcastManager localBroadcastManager, Looper looper) {
        super(looper);
        this.this$0 = localBroadcastManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
        } else {
            this.this$0.executePendingBroadcasts();
        }
    }
}
