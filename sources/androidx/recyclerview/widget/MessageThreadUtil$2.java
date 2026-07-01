package androidx.recyclerview.widget;

import android.os.AsyncTask;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
public class MessageThreadUtil$2<T> implements ThreadUtil$BackgroundCallback<T> {
    public static final int LOAD_TILE = 3;
    public static final int RECYCLE_TILE = 4;
    public static final int REFRESH = 1;
    public static final int UPDATE_RANGE = 2;
    public final /* synthetic */ MessageThreadUtil this$0;
    public final /* synthetic */ ThreadUtil$BackgroundCallback val$callback;
    public final MessageThreadUtil$MessageQueue mQueue = new MessageThreadUtil$MessageQueue();
    private final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
    public AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
    private Runnable mBackgroundRunnable = new MessageThreadUtil$2$1(this);

    public MessageThreadUtil$2(MessageThreadUtil messageThreadUtil, ThreadUtil$BackgroundCallback threadUtil$BackgroundCallback) {
        this.this$0 = messageThreadUtil;
        this.val$callback = threadUtil$BackgroundCallback;
    }

    private void maybeExecuteBackgroundRunnable() {
        if (this.mBackgroundRunning.compareAndSet(false, true)) {
            this.mExecutor.execute(this.mBackgroundRunnable);
        }
    }

    private void sendMessage(MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem) {
        this.mQueue.sendMessage(messageThreadUtil$SyncQueueItem);
        maybeExecuteBackgroundRunnable();
    }

    private void sendMessageAtFrontOfQueue(MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem) {
        this.mQueue.sendMessageAtFrontOfQueue(messageThreadUtil$SyncQueueItem);
        maybeExecuteBackgroundRunnable();
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void loadTile(int i, int i2) {
        sendMessage(MessageThreadUtil$SyncQueueItem.obtainMessage(3, i, i2));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void recycleTile(TileList$Tile<T> tileList$Tile) {
        sendMessage(MessageThreadUtil$SyncQueueItem.obtainMessage(4, 0, tileList$Tile));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void refresh(int i) {
        sendMessageAtFrontOfQueue(MessageThreadUtil$SyncQueueItem.obtainMessage(1, i, (Object) null));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void updateRange(int i, int i2, int i3, int i4, int i5) {
        sendMessageAtFrontOfQueue(MessageThreadUtil$SyncQueueItem.obtainMessage(2, i, i2, i3, i4, i5, null));
    }
}
