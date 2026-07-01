package androidx.view;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleRegistry$ObserverWithState {
    public LifecycleEventObserver mLifecycleObserver;
    public Lifecycle$State mState;

    public LifecycleRegistry$ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle$State lifecycle$State) {
        this.mLifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
        this.mState = lifecycle$State;
    }

    public void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        Lifecycle$State targetState = lifecycle$Event.getTargetState();
        this.mState = LifecycleRegistry.min(this.mState, targetState);
        this.mLifecycleObserver.onStateChanged(lifecycleOwner, lifecycle$Event);
        this.mState = targetState;
    }
}
