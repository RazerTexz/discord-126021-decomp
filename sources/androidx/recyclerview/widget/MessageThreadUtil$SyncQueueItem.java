package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class MessageThreadUtil$SyncQueueItem {
    private static MessageThreadUtil$SyncQueueItem sPool;
    private static final Object sPoolLock = new Object();
    public int arg1;
    public int arg2;
    public int arg3;
    public int arg4;
    public int arg5;
    public Object data;
    public MessageThreadUtil$SyncQueueItem next;
    public int what;

    public static MessageThreadUtil$SyncQueueItem obtainMessage(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem;
        synchronized (sPoolLock) {
            messageThreadUtil$SyncQueueItem = sPool;
            if (messageThreadUtil$SyncQueueItem == null) {
                messageThreadUtil$SyncQueueItem = new MessageThreadUtil$SyncQueueItem();
            } else {
                sPool = messageThreadUtil$SyncQueueItem.next;
                messageThreadUtil$SyncQueueItem.next = null;
            }
            messageThreadUtil$SyncQueueItem.what = i;
            messageThreadUtil$SyncQueueItem.arg1 = i2;
            messageThreadUtil$SyncQueueItem.arg2 = i3;
            messageThreadUtil$SyncQueueItem.arg3 = i4;
            messageThreadUtil$SyncQueueItem.arg4 = i5;
            messageThreadUtil$SyncQueueItem.arg5 = i6;
            messageThreadUtil$SyncQueueItem.data = obj;
        }
        return messageThreadUtil$SyncQueueItem;
    }

    public void recycle() {
        this.next = null;
        this.arg5 = 0;
        this.arg4 = 0;
        this.arg3 = 0;
        this.arg2 = 0;
        this.arg1 = 0;
        this.what = 0;
        this.data = null;
        synchronized (sPoolLock) {
            MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem = sPool;
            if (messageThreadUtil$SyncQueueItem != null) {
                this.next = messageThreadUtil$SyncQueueItem;
            }
            sPool = this;
        }
    }

    public static MessageThreadUtil$SyncQueueItem obtainMessage(int i, int i2, int i3) {
        return obtainMessage(i, i2, i3, 0, 0, 0, null);
    }

    public static MessageThreadUtil$SyncQueueItem obtainMessage(int i, int i2, Object obj) {
        return obtainMessage(i, i2, 0, 0, 0, 0, obj);
    }
}
