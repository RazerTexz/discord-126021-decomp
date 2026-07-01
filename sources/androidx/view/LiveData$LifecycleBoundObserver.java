package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class LiveData$LifecycleBoundObserver extends LiveData<T>.LiveData$ObserverWrapper implements LifecycleEventObserver {

    @NonNull
    public final LifecycleOwner mOwner;
    public final /* synthetic */ LiveData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveData$LifecycleBoundObserver(@NonNull LiveData liveData, LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        super(liveData, observer);
        this.this$0 = liveData;
        this.mOwner = lifecycleOwner;
    }

    @Override // androidx.view.LiveData$ObserverWrapper
    public void detachObserver() {
        this.mOwner.getLifecycle().removeObserver(this);
    }

    @Override // androidx.view.LiveData$ObserverWrapper
    public boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
        return this.mOwner == lifecycleOwner;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        Lifecycle$State currentState = this.mOwner.getLifecycle().getCurrentState();
        if (currentState == Lifecycle$State.DESTROYED) {
            this.this$0.removeObserver(this.mObserver);
            return;
        }
        Lifecycle$State lifecycle$State = null;
        while (lifecycle$State != currentState) {
            activeStateChanged(shouldBeActive());
            lifecycle$State = currentState;
            currentState = this.mOwner.getLifecycle().getCurrentState();
        }
    }

    @Override // androidx.view.LiveData$ObserverWrapper
    public boolean shouldBeActive() {
        return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle$State.STARTED);
    }
}
