package androidx.recyclerview.widget;

import android.util.Log;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class MessageThreadUtil$2$1 implements Runnable {
    public final /* synthetic */ MessageThreadUtil$2 this$1;

    public MessageThreadUtil$2$1(MessageThreadUtil$2 messageThreadUtil$2) {
        this.this$1 = messageThreadUtil$2;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            MessageThreadUtil$SyncQueueItem next = this.this$1.mQueue.next();
            if (next == null) {
                this.this$1.mBackgroundRunning.set(false);
                return;
            }
            int i = next.what;
            if (i == 1) {
                this.this$1.mQueue.removeMessages(1);
                this.this$1.val$callback.refresh(next.arg1);
            } else if (i == 2) {
                this.this$1.mQueue.removeMessages(2);
                this.this$1.mQueue.removeMessages(3);
                this.this$1.val$callback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
            } else if (i == 3) {
                this.this$1.val$callback.loadTile(next.arg1, next.arg2);
            } else if (i != 4) {
                StringBuilder sbU = a.U("Unsupported message, what=");
                sbU.append(next.what);
                Log.e("ThreadUtil", sbU.toString());
            } else {
                this.this$1.val$callback.recycleTile((TileList$Tile) next.data);
            }
        }
    }
}
