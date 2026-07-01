package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform$3 extends AnimatorListenerAdapter {
    private boolean mIsCanceled;
    private Matrix mTempMatrix = new Matrix();
    public final /* synthetic */ ChangeTransform this$0;
    public final /* synthetic */ Matrix val$finalEndMatrix;
    public final /* synthetic */ boolean val$handleParentChange;
    public final /* synthetic */ ChangeTransform$PathAnimatorMatrix val$pathAnimatorMatrix;
    public final /* synthetic */ ChangeTransform$Transforms val$transforms;
    public final /* synthetic */ View val$view;

    public ChangeTransform$3(ChangeTransform changeTransform, boolean z2, Matrix matrix, View view, ChangeTransform$Transforms changeTransform$Transforms, ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix) {
        this.this$0 = changeTransform;
        this.val$handleParentChange = z2;
        this.val$finalEndMatrix = matrix;
        this.val$view = view;
        this.val$transforms = changeTransform$Transforms;
        this.val$pathAnimatorMatrix = changeTransform$PathAnimatorMatrix;
    }

    private void setCurrentMatrix(Matrix matrix) {
        this.mTempMatrix.set(matrix);
        this.val$view.setTag(R$id.transition_transform, this.mTempMatrix);
        this.val$transforms.restore(this.val$view);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.mIsCanceled = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.mIsCanceled) {
            if (this.val$handleParentChange && this.this$0.mUseOverlay) {
                setCurrentMatrix(this.val$finalEndMatrix);
            } else {
                this.val$view.setTag(R$id.transition_transform, null);
                this.val$view.setTag(R$id.parent_matrix, null);
            }
        }
        ViewUtils.setAnimationMatrix(this.val$view, null);
        this.val$transforms.restore(this.val$view);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        setCurrentMatrix(this.val$pathAnimatorMatrix.getMatrix());
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        ChangeTransform.setIdentityTransforms(this.val$view);
    }
}
