package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform$GhostListener extends TransitionListenerAdapter {
    private GhostView mGhostView;
    private View mView;

    public ChangeTransform$GhostListener(View view, GhostView ghostView) {
        this.mView = view;
        this.mGhostView = ghostView;
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        transition.removeListener(this);
        GhostViewUtils.removeGhost(this.mView);
        this.mView.setTag(R$id.transition_transform, null);
        this.mView.setTag(R$id.parent_matrix, null);
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionPause(@NonNull Transition transition) {
        this.mGhostView.setVisibility(4);
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition$TransitionListener
    public void onTransitionResume(@NonNull Transition transition) {
        this.mGhostView.setVisibility(0);
    }
}
