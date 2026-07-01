package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable$ConstantState;
import androidx.collection.ArrayMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState extends Drawable$ConstantState {
    public AnimatorSet mAnimatorSet;
    public ArrayList<Animator> mAnimators;
    public int mChangingConfigurations;
    public ArrayMap<Animator, String> mTargetNameMap;
    public VectorDrawableCompat mVectorDrawable;

    public AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState, Drawable$Callback drawable$Callback, Resources resources) {
        if (animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState != null) {
            this.mChangingConfigurations = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mChangingConfigurations;
            VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mVectorDrawable;
            if (vectorDrawableCompat != null) {
                Drawable$ConstantState constantState = vectorDrawableCompat.getConstantState();
                if (resources != null) {
                    this.mVectorDrawable = (VectorDrawableCompat) constantState.newDrawable(resources);
                } else {
                    this.mVectorDrawable = (VectorDrawableCompat) constantState.newDrawable();
                }
                VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.mVectorDrawable.mutate();
                this.mVectorDrawable = vectorDrawableCompat2;
                vectorDrawableCompat2.setCallback(drawable$Callback);
                this.mVectorDrawable.setBounds(animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mVectorDrawable.getBounds());
                this.mVectorDrawable.setAllowCaching(false);
            }
            ArrayList<Animator> arrayList = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mAnimators;
            if (arrayList != null) {
                int size = arrayList.size();
                this.mAnimators = new ArrayList<>(size);
                this.mTargetNameMap = new ArrayMap<>(size);
                for (int i = 0; i < size; i++) {
                    Animator animator = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mAnimators.get(i);
                    Animator animatorClone = animator.clone();
                    String str = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mTargetNameMap.get(animator);
                    animatorClone.setTarget(this.mVectorDrawable.getTargetByName(str));
                    this.mAnimators.add(animatorClone);
                    this.mTargetNameMap.put(animatorClone, str);
                }
                setupAnimatorSet();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    public void setupAnimatorSet() {
        if (this.mAnimatorSet == null) {
            this.mAnimatorSet = new AnimatorSet();
        }
        this.mAnimatorSet.playTogether(this.mAnimators);
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
}
