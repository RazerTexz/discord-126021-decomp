package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public interface ThreadUtil<T> {
    ThreadUtil$BackgroundCallback<T> getBackgroundProxy(ThreadUtil$BackgroundCallback<T> threadUtil$BackgroundCallback);

    ThreadUtil$MainThreadCallback<T> getMainThreadProxy(ThreadUtil$MainThreadCallback<T> threadUtil$MainThreadCallback);
}
