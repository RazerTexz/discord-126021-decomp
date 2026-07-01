package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class MessageThreadUtil<T> implements ThreadUtil<T> {
    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil$BackgroundCallback<T> getBackgroundProxy(ThreadUtil$BackgroundCallback<T> threadUtil$BackgroundCallback) {
        return new MessageThreadUtil$2(this, threadUtil$BackgroundCallback);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil$MainThreadCallback<T> getMainThreadProxy(ThreadUtil$MainThreadCallback<T> threadUtil$MainThreadCallback) {
        return new MessageThreadUtil$1(this, threadUtil$MainThreadCallback);
    }
}
