package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
public class MessageThreadUtil$1<T> implements ThreadUtil$MainThreadCallback<T> {
    public static final int ADD_TILE = 2;
    public static final int REMOVE_TILE = 3;
    public static final int UPDATE_ITEM_COUNT = 1;
    public final /* synthetic */ MessageThreadUtil this$0;
    public final /* synthetic */ ThreadUtil$MainThreadCallback val$callback;
    public final MessageThreadUtil$MessageQueue mQueue = new MessageThreadUtil$MessageQueue();
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private Runnable mMainThreadRunnable = new MessageThreadUtil$1$1(this);

    public MessageThreadUtil$1(MessageThreadUtil messageThreadUtil, ThreadUtil$MainThreadCallback threadUtil$MainThreadCallback) {
        this.this$0 = messageThreadUtil;
        this.val$callback = threadUtil$MainThreadCallback;
    }

    private void sendMessage(MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem) {
        this.mQueue.sendMessage(messageThreadUtil$SyncQueueItem);
        this.mMainThreadHandler.post(this.mMainThreadRunnable);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void addTile(int i, TileList$Tile<T> tileList$Tile) {
        sendMessage(MessageThreadUtil$SyncQueueItem.obtainMessage(2, i, tileList$Tile));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void removeTile(int i, int i2) {
        sendMessage(MessageThreadUtil$SyncQueueItem.obtainMessage(3, i, i2));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void updateItemCount(int i, int i2) {
        sendMessage(MessageThreadUtil$SyncQueueItem.obtainMessage(1, i, i2));
    }
}
