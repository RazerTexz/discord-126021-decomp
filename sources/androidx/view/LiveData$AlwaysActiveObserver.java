package androidx.view;

/* JADX INFO: loaded from: classes.dex */
public class LiveData$AlwaysActiveObserver extends LiveData<T>.LiveData$ObserverWrapper {
    public final /* synthetic */ LiveData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveData$AlwaysActiveObserver(LiveData liveData, Observer<? super T> observer) {
        super(liveData, observer);
        this.this$0 = liveData;
    }

    @Override // androidx.view.LiveData$ObserverWrapper
    public boolean shouldBeActive() {
        return true;
    }
}
