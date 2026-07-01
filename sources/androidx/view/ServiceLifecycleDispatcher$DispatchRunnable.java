package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ServiceLifecycleDispatcher$DispatchRunnable implements Runnable {
    public final Lifecycle$Event mEvent;
    private final LifecycleRegistry mRegistry;
    private boolean mWasExecuted = false;

    public ServiceLifecycleDispatcher$DispatchRunnable(@NonNull LifecycleRegistry lifecycleRegistry, Lifecycle$Event lifecycle$Event) {
        this.mRegistry = lifecycleRegistry;
        this.mEvent = lifecycle$Event;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mWasExecuted) {
            return;
        }
        this.mRegistry.handleLifecycleEvent(this.mEvent);
        this.mWasExecuted = true;
    }
}
