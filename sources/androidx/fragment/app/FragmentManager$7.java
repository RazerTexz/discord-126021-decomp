package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$7 extends AnimatorListenerAdapter {
    public final /* synthetic */ FragmentManager this$0;
    public final /* synthetic */ View val$animatingView;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ Fragment val$fragment;

    public FragmentManager$7(FragmentManager fragmentManager, ViewGroup viewGroup, View view, Fragment fragment) {
        this.this$0 = fragmentManager;
        this.val$container = viewGroup;
        this.val$animatingView = view;
        this.val$fragment = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.val$container.endViewTransition(this.val$animatingView);
        animator.removeListener(this);
        Fragment fragment = this.val$fragment;
        View view = fragment.mView;
        if (view == null || !fragment.mHidden) {
            return;
        }
        view.setVisibility(8);
    }
}
