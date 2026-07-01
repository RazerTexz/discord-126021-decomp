package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds$10 extends AnimatorListenerAdapter {
    public final /* synthetic */ ChangeBounds this$0;
    public final /* synthetic */ BitmapDrawable val$drawable;
    public final /* synthetic */ ViewGroup val$sceneRoot;
    public final /* synthetic */ float val$transitionAlpha;
    public final /* synthetic */ View val$view;

    public ChangeBounds$10(ChangeBounds changeBounds, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
        this.this$0 = changeBounds;
        this.val$sceneRoot = viewGroup;
        this.val$drawable = bitmapDrawable;
        this.val$view = view;
        this.val$transitionAlpha = f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ViewUtils.getOverlay(this.val$sceneRoot).remove(this.val$drawable);
        ViewUtils.setTransitionAlpha(this.val$view, this.val$transitionAlpha);
    }
}
