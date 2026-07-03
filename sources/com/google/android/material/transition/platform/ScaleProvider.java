package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public final class ScaleProvider implements VisibilityAnimatorProvider {
    private boolean growing;
    private float incomingEndScale;
    private float incomingStartScale;
    private float outgoingEndScale;
    private float outgoingStartScale;
    private boolean scaleOnDisappear;

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.ScaleProvider$a */
    public static class C11062a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f21396a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ float f21397b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ float f21398c;

        public C11062a(View view, float f, float f2) {
            this.f21396a = view;
            this.f21397b = f;
            this.f21398c = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f21396a.setScaleX(this.f21397b);
            this.f21396a.setScaleY(this.f21398c);
        }
    }

    public ScaleProvider() {
        this(true);
    }

    private static Animator createScaleAnimator(View view, float f, float f2) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX * f, scaleX * f2), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f * scaleY, f2 * scaleY));
        objectAnimatorOfPropertyValuesHolder.addListener(new C11062a(view, scaleX, scaleY));
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return this.growing ? createScaleAnimator(view, this.incomingStartScale, this.incomingEndScale) : createScaleAnimator(view, this.outgoingEndScale, this.outgoingStartScale);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.scaleOnDisappear) {
            return this.growing ? createScaleAnimator(view, this.outgoingStartScale, this.outgoingEndScale) : createScaleAnimator(view, this.incomingEndScale, this.incomingStartScale);
        }
        return null;
    }

    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    public void setGrowing(boolean z2) {
        this.growing = z2;
    }

    public void setIncomingEndScale(float f) {
        this.incomingEndScale = f;
    }

    public void setIncomingStartScale(float f) {
        this.incomingStartScale = f;
    }

    public void setOutgoingEndScale(float f) {
        this.outgoingEndScale = f;
    }

    public void setOutgoingStartScale(float f) {
        this.outgoingStartScale = f;
    }

    public void setScaleOnDisappear(boolean z2) {
        this.scaleOnDisappear = z2;
    }

    public ScaleProvider(boolean z2) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.growing = z2;
    }
}
