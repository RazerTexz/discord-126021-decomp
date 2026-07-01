package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import android.animation.ValueAnimator;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public class ItemTouchHelper$RecoverAnimation implements Animator$AnimatorListener {
    public final int mActionState;
    public final int mAnimationType;
    private float mFraction;
    public boolean mIsPendingCleanup;
    public final float mStartDx;
    public final float mStartDy;
    public final float mTargetX;
    public final float mTargetY;

    @VisibleForTesting
    public final ValueAnimator mValueAnimator;
    public final RecyclerView$ViewHolder mViewHolder;
    public float mX;
    public float mY;
    public boolean mOverridden = false;
    public boolean mEnded = false;

    public ItemTouchHelper$RecoverAnimation(RecyclerView$ViewHolder recyclerView$ViewHolder, int i, int i2, float f, float f2, float f3, float f4) {
        this.mActionState = i2;
        this.mAnimationType = i;
        this.mViewHolder = recyclerView$ViewHolder;
        this.mStartDx = f;
        this.mStartDy = f2;
        this.mTargetX = f3;
        this.mTargetY = f4;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mValueAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ItemTouchHelper$RecoverAnimation$1(this));
        valueAnimatorOfFloat.setTarget(recyclerView$ViewHolder.itemView);
        valueAnimatorOfFloat.addListener(this);
        setFraction(0.0f);
    }

    public void cancel() {
        this.mValueAnimator.cancel();
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        setFraction(1.0f);
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.mEnded) {
            this.mViewHolder.setIsRecyclable(true);
        }
        this.mEnded = true;
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public void setDuration(long j) {
        this.mValueAnimator.setDuration(j);
    }

    public void setFraction(float f) {
        this.mFraction = f;
    }

    public void start() {
        this.mViewHolder.setIsRecyclable(false);
        this.mValueAnimator.start();
    }

    public void update() {
        float f = this.mStartDx;
        float f2 = this.mTargetX;
        if (f == f2) {
            this.mX = this.mViewHolder.itemView.getTranslationX();
        } else {
            this.mX = a.a(f2, f, this.mFraction, f);
        }
        float f3 = this.mStartDy;
        float f4 = this.mTargetY;
        if (f3 == f4) {
            this.mY = this.mViewHolder.itemView.getTranslationY();
        } else {
            this.mY = a.a(f4, f3, this.mFraction, f3);
        }
    }
}
