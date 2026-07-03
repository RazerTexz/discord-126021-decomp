package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import p007b.p225i.p226a.p341g.p348g.AbstractC4419e;
import p007b.p225i.p226a.p341g.p348g.AbstractC4420f;
import p007b.p225i.p226a.p341g.p348g.AbstractC4421g;
import p007b.p225i.p226a.p341g.p348g.C4415a;
import p007b.p225i.p226a.p341g.p348g.C4418d;
import p007b.p225i.p226a.p341g.p348g.C4422h;
import p007b.p225i.p226a.p341g.p348g.C4424j;
import p007b.p225i.p226a.p341g.p348g.C4426l;

/* JADX INFO: loaded from: classes3.dex */
public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends AbstractC4419e {
    private AbstractC4421g<ObjectAnimator> animatorDelegate;
    private AbstractC4420f<S> drawingDelegate;

    public IndeterminateDrawable(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec, @NonNull AbstractC4420f<S> abstractC4420f, @NonNull AbstractC4421g<ObjectAnimator> abstractC4421g) {
        super(context, baseProgressIndicatorSpec);
        setDrawingDelegate(abstractC4420f);
        setAnimatorDelegate(abstractC4421g);
    }

    @NonNull
    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new IndeterminateDrawable<>(context, circularProgressIndicatorSpec, new C4415a(circularProgressIndicatorSpec), new C4418d(circularProgressIndicatorSpec));
    }

    @NonNull
    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new IndeterminateDrawable<>(context, linearProgressIndicatorSpec, new C4422h(linearProgressIndicatorSpec), linearProgressIndicatorSpec.indeterminateAnimationType == 0 ? new C4424j(linearProgressIndicatorSpec) : new C4426l(context, linearProgressIndicatorSpec));
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        AbstractC4420f<S> abstractC4420f = this.drawingDelegate;
        float growFraction = getGrowFraction();
        abstractC4420f.f11734a.validateSpec();
        abstractC4420f.mo6117a(canvas, growFraction);
        this.drawingDelegate.mo6119c(canvas, this.paint);
        int i = 0;
        while (true) {
            AbstractC4421g<ObjectAnimator> abstractC4421g = this.animatorDelegate;
            int[] iArr = abstractC4421g.f11738c;
            if (i >= iArr.length) {
                canvas.restore();
                return;
            }
            AbstractC4420f<S> abstractC4420f2 = this.drawingDelegate;
            Paint paint = this.paint;
            float[] fArr = abstractC4421g.f11737b;
            int i2 = i * 2;
            abstractC4420f2.mo6118b(canvas, paint, fArr[i2], fArr[i2 + 1], iArr[i]);
            i++;
        }
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @NonNull
    public AbstractC4421g<ObjectAnimator> getAnimatorDelegate() {
        return this.animatorDelegate;
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

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public void setAnimatorDelegate(@NonNull AbstractC4421g<ObjectAnimator> abstractC4421g) {
        this.animatorDelegate = abstractC4421g;
        abstractC4421g.f11736a = this;
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public void setDrawingDelegate(@NonNull AbstractC4420f<S> abstractC4420f) {
        this.drawingDelegate = abstractC4420f;
        abstractC4420f.f11735b = this;
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3);
    }

    @Override // p007b.p225i.p226a.p341g.p348g.AbstractC4419e
    public boolean setVisibleInternal(boolean z2, boolean z3, boolean z4) {
        boolean visibleInternal = super.setVisibleInternal(z2, z3, z4);
        if (!isRunning()) {
            this.animatorDelegate.mo6123a();
        }
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (z2 && (z4 || (Build.VERSION.SDK_INT <= 21 && systemAnimatorDurationScale > 0.0f))) {
            this.animatorDelegate.mo6127f();
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
