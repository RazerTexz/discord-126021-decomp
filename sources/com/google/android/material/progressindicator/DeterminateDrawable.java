package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import p007b.p225i.p226a.p341g.p348g.AbstractC4419e;
import p007b.p225i.p226a.p341g.p348g.AbstractC4420f;
import p007b.p225i.p226a.p341g.p348g.C4415a;
import p007b.p225i.p226a.p341g.p348g.C4422h;

/* JADX INFO: loaded from: classes3.dex */
public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends AbstractC4419e {
    private static final FloatPropertyCompat<DeterminateDrawable> INDICATOR_LENGTH_IN_LEVEL = new C10959a("indicatorLevel");
    private static final int MAX_DRAWABLE_LEVEL = 10000;
    private static final float SPRING_FORCE_STIFFNESS = 50.0f;
    private AbstractC4420f<S> drawingDelegate;
    private float indicatorFraction;
    private boolean skipAnimationOnLevelChange;
    private final SpringAnimation springAnimator;
    private final SpringForce springForce;

    /* JADX INFO: renamed from: com.google.android.material.progressindicator.DeterminateDrawable$a */
    public static class C10959a extends FloatPropertyCompat<DeterminateDrawable> {
        public C10959a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.getIndicatorFraction() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(DeterminateDrawable determinateDrawable, float f) {
            determinateDrawable.setIndicatorFraction(f / 10000.0f);
        }
    }

    public DeterminateDrawable(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec, @NonNull AbstractC4420f<S> abstractC4420f) {
        super(context, baseProgressIndicatorSpec);
        this.skipAnimationOnLevelChange = false;
        setDrawingDelegate(abstractC4420f);
        SpringForce springForce = new SpringForce();
        this.springForce = springForce;
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, (FloatPropertyCompat<DeterminateDrawable<S>>) INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimator = springAnimation;
        springAnimation.setSpring(springForce);
        setGrowFraction(1.0f);
    }

    @NonNull
    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, circularProgressIndicatorSpec, new C4415a(circularProgressIndicatorSpec));
    }

    @NonNull
    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, linearProgressIndicatorSpec, new C4422h(linearProgressIndicatorSpec));
    }

    private float getIndicatorFraction() {
        return this.indicatorFraction;
    }

    private void setIndicatorFraction(float f) {
        this.indicatorFraction = f;
        invalidateSelf();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            AbstractC4420f<S> abstractC4420f = this.drawingDelegate;
            float growFraction = getGrowFraction();
            abstractC4420f.f11734a.validateSpec();
            abstractC4420f.mo6117a(canvas, growFraction);
            this.drawingDelegate.mo6119c(canvas, this.paint);
            this.drawingDelegate.mo6118b(canvas, this.paint, 0.0f, getIndicatorFraction(), MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], getAlpha()));
            canvas.restore();
        }
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @NonNull
    public AbstractC4420f<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawingDelegate.mo6120d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawingDelegate.mo6121e();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e
    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e
    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e
    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.springAnimator.cancel();
        setIndicatorFraction(getLevel() / 10000.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        if (this.skipAnimationOnLevelChange) {
            this.springAnimator.cancel();
            setIndicatorFraction(i / 10000.0f);
            return true;
        }
        this.springAnimator.setStartValue(getIndicatorFraction() * 10000.0f);
        this.springAnimator.animateToFinalPosition(i);
        return true;
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public void setDrawingDelegate(@NonNull AbstractC4420f<S> abstractC4420f) {
        this.drawingDelegate = abstractC4420f;
        abstractC4420f.f11735b = this;
    }

    public void setLevelByFraction(float f) {
        setLevel((int) (f * 10000.0f));
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3);
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e
    public boolean setVisibleInternal(boolean z2, boolean z3, boolean z4) {
        boolean visibleInternal = super.setVisibleInternal(z2, z3, z4);
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (systemAnimatorDurationScale == 0.0f) {
            this.skipAnimationOnLevelChange = true;
        } else {
            this.skipAnimationOnLevelChange = false;
            this.springForce.setStiffness(50.0f / systemAnimatorDurationScale);
        }
        return visibleInternal;
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z2, boolean z3, boolean z4) {
        return super.setVisible(z2, z3, z4);
    }
}
