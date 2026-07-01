package androidx.core.app;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCompat$SharedElementCallback21Impl$1 implements SharedElementCallback$OnSharedElementsReadyListener {
    public final /* synthetic */ ActivityCompat$SharedElementCallback21Impl this$0;
    public final /* synthetic */ android.app.SharedElementCallback$OnSharedElementsReadyListener val$listener;

    public ActivityCompat$SharedElementCallback21Impl$1(ActivityCompat$SharedElementCallback21Impl activityCompat$SharedElementCallback21Impl, android.app.SharedElementCallback$OnSharedElementsReadyListener sharedElementCallback$OnSharedElementsReadyListener) {
        this.this$0 = activityCompat$SharedElementCallback21Impl;
        this.val$listener = sharedElementCallback$OnSharedElementsReadyListener;
    }

    @Override // androidx.core.app.SharedElementCallback$OnSharedElementsReadyListener
    public void onSharedElementsReady() {
        this.val$listener.onSharedElementsReady();
    }
}
