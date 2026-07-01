package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements LifecycleEventObserver {
    private final FullLifecycleObserver mFullLifecycleObserver;
    private final LifecycleEventObserver mLifecycleEventObserver;

    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver, LifecycleEventObserver lifecycleEventObserver) {
        this.mFullLifecycleObserver = fullLifecycleObserver;
        this.mLifecycleEventObserver = lifecycleEventObserver;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle$Event lifecycle$Event) {
        switch (lifecycle$Event) {
            case ON_CREATE:
                this.mFullLifecycleObserver.onCreate(lifecycleOwner);
                break;
            case ON_START:
                this.mFullLifecycleObserver.onStart(lifecycleOwner);
                break;
            case ON_RESUME:
                this.mFullLifecycleObserver.onResume(lifecycleOwner);
                break;
            case ON_PAUSE:
                this.mFullLifecycleObserver.onPause(lifecycleOwner);
                break;
            case ON_STOP:
                this.mFullLifecycleObserver.onStop(lifecycleOwner);
                break;
            case ON_DESTROY:
                this.mFullLifecycleObserver.onDestroy(lifecycleOwner);
                break;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        LifecycleEventObserver lifecycleEventObserver = this.mLifecycleEventObserver;
        if (lifecycleEventObserver != null) {
            lifecycleEventObserver.onStateChanged(lifecycleOwner, lifecycle$Event);
        }
    }
}
