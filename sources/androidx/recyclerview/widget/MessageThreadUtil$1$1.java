package androidx.recyclerview.widget;

import android.util.Log;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class MessageThreadUtil$1$1 implements Runnable {
    public final /* synthetic */ MessageThreadUtil$1 this$1;

    public MessageThreadUtil$1$1(MessageThreadUtil$1 messageThreadUtil$1) {
        this.this$1 = messageThreadUtil$1;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageThreadUtil$SyncQueueItem next = this.this$1.mQueue.next();
        while (next != null) {
            int i = next.what;
            if (i == 1) {
                this.this$1.val$callback.updateItemCount(next.arg1, next.arg2);
            } else if (i == 2) {
                this.this$1.val$callback.addTile(next.arg1, (TileList$Tile) next.data);
            } else if (i != 3) {
                StringBuilder sbU = a.U("Unsupported message, what=");
                sbU.append(next.what);
                Log.e("ThreadUtil", sbU.toString());
            } else {
                this.this$1.val$callback.removeTile(next.arg1, next.arg2);
            }
            next = this.this$1.mQueue.next();
        }
    }
}
