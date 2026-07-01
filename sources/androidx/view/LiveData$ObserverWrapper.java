package androidx.view;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData$ObserverWrapper {
    public boolean mActive;
    public int mLastVersion = -1;
    public final Observer<? super T> mObserver;
    public final /* synthetic */ LiveData this$0;

    public LiveData$ObserverWrapper(LiveData liveData, Observer<? super T> observer) {
        this.this$0 = liveData;
        this.mObserver = observer;
    }

    public void activeStateChanged(boolean z2) {
        if (z2 == this.mActive) {
            return;
        }
        this.mActive = z2;
        this.this$0.changeActiveCounter(z2 ? 1 : -1);
        if (this.mActive) {
            this.this$0.dispatchingValue(this);
        }
    }

    public void detachObserver() {
    }

    public boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
        return false;
    }

    public abstract boolean shouldBeActive();
}
