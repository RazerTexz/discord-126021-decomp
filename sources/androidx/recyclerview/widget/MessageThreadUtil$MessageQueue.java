package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class MessageThreadUtil$MessageQueue {
    private MessageThreadUtil$SyncQueueItem mRoot;

    public synchronized MessageThreadUtil$SyncQueueItem next() {
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem = this.mRoot;
        if (messageThreadUtil$SyncQueueItem == null) {
            return null;
        }
        this.mRoot = messageThreadUtil$SyncQueueItem.next;
        return messageThreadUtil$SyncQueueItem;
    }

    public synchronized void removeMessages(int i) {
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem;
        while (true) {
            messageThreadUtil$SyncQueueItem = this.mRoot;
            if (messageThreadUtil$SyncQueueItem == null || messageThreadUtil$SyncQueueItem.what != i) {
                break;
            }
            this.mRoot = messageThreadUtil$SyncQueueItem.next;
            messageThreadUtil$SyncQueueItem.recycle();
        }
        if (messageThreadUtil$SyncQueueItem != null) {
            MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem2 = messageThreadUtil$SyncQueueItem.next;
            while (messageThreadUtil$SyncQueueItem2 != null) {
                MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem3 = messageThreadUtil$SyncQueueItem2.next;
                if (messageThreadUtil$SyncQueueItem2.what == i) {
                    messageThreadUtil$SyncQueueItem.next = messageThreadUtil$SyncQueueItem3;
                    messageThreadUtil$SyncQueueItem2.recycle();
                } else {
                    messageThreadUtil$SyncQueueItem = messageThreadUtil$SyncQueueItem2;
                }
                messageThreadUtil$SyncQueueItem2 = messageThreadUtil$SyncQueueItem3;
            }
        }
    }

    public synchronized void sendMessage(MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem) {
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem2 = this.mRoot;
        if (messageThreadUtil$SyncQueueItem2 == null) {
            this.mRoot = messageThreadUtil$SyncQueueItem;
            return;
        }
        while (true) {
            MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem3 = messageThreadUtil$SyncQueueItem2.next;
            if (messageThreadUtil$SyncQueueItem3 == null) {
                messageThreadUtil$SyncQueueItem2.next = messageThreadUtil$SyncQueueItem;
                return;
            }
            messageThreadUtil$SyncQueueItem2 = messageThreadUtil$SyncQueueItem3;
        }
    }

    public synchronized void sendMessageAtFrontOfQueue(MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem) {
        messageThreadUtil$SyncQueueItem.next = this.mRoot;
        this.mRoot = messageThreadUtil$SyncQueueItem;
    }
}
