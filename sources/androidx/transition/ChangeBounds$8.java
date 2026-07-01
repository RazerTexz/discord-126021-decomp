package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds$8 extends AnimatorListenerAdapter {
    private boolean mIsCanceled;
    public final /* synthetic */ ChangeBounds this$0;
    public final /* synthetic */ int val$endBottom;
    public final /* synthetic */ int val$endLeft;
    public final /* synthetic */ int val$endRight;
    public final /* synthetic */ int val$endTop;
    public final /* synthetic */ Rect val$finalClip;
    public final /* synthetic */ View val$view;

    public ChangeBounds$8(ChangeBounds changeBounds, View view, Rect rect, int i, int i2, int i3, int i4) {
        this.this$0 = changeBounds;
        this.val$view = view;
        this.val$finalClip = rect;
        this.val$endLeft = i;
        this.val$endTop = i2;
        this.val$endRight = i3;
        this.val$endBottom = i4;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.mIsCanceled = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.mIsCanceled) {
            return;
        }
        ViewCompat.setClipBounds(this.val$view, this.val$finalClip);
        ViewUtils.setLeftTopRightBottom(this.val$view, this.val$endLeft, this.val$endTop, this.val$endRight, this.val$endBottom);
    }
}
