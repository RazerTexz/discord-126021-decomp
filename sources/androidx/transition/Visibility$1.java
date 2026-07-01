package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class Visibility$1 extends TransitionListenerAdapter {
    public final /* synthetic */ Visibility this$0;
    public final /* synthetic */ View val$finalOverlayView;
    public final /* synthetic */ ViewGroup val$overlayHost;
    public final /* synthetic */ View val$startView;

    public Visibility$1(Visibility visibility, ViewGroup viewGroup, View view, View view2) {
        this.this$0 = visibility;
        this.val$overlayHost = viewGroup;
        this.val$finalOverlayView = view;
        this.val$startView = view2;
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        this.val$startView.setTag(R$id.save_overlay_view, null);
        ViewGroupUtils.getOverlay(this.val$overlayHost).remove(this.val$finalOverlayView);
        transition.removeListener(this);
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionPause(@NonNull Transition transition) {
        ViewGroupUtils.getOverlay(this.val$overlayHost).remove(this.val$finalOverlayView);
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionResume(@NonNull Transition transition) {
        if (this.val$finalOverlayView.getParent() == null) {
            ViewGroupUtils.getOverlay(this.val$overlayHost).add(this.val$finalOverlayView);
        } else {
            this.this$0.cancel();
        }
    }
}
