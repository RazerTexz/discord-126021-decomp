package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleDrawableCompat extends Drawable implements Shapeable, TintAwareDrawable {
    private C10963b drawableState;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        C10963b c10963b = this.drawableState;
        if (c10963b.f21066b) {
            c10963b.f21065a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.drawableState.f21065a.getOpacity();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.f21065a.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.drawableState.f21065a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.drawableState.f21065a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zShouldDrawRippleCompat = RippleUtils.shouldDrawRippleCompat(iArr);
        C10963b c10963b = this.drawableState;
        if (c10963b.f21066b == zShouldDrawRippleCompat) {
            return zOnStateChange;
        }
        c10963b.f21066b = zShouldDrawRippleCompat;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.drawableState.f21065a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.drawableState.f21065a.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.f21065a.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i) {
        this.drawableState.f21065a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.drawableState.f21065a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.drawableState.f21065a.setTintMode(mode);
    }

    public RippleDrawableCompat(ShapeAppearanceModel shapeAppearanceModel) {
        this(new C10963b(new MaterialShapeDrawable(shapeAppearanceModel)));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public RippleDrawableCompat mutate() {
        this.drawableState = new C10963b(this.drawableState);
        return this;
    }

    /* JADX INFO: renamed from: com.google.android.material.ripple.RippleDrawableCompat$b */
    public static final class C10963b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        @NonNull
        public MaterialShapeDrawable f21065a;

        /* JADX INFO: renamed from: b */
        public boolean f21066b;

        public C10963b(MaterialShapeDrawable materialShapeDrawable) {
            this.f21065a = materialShapeDrawable;
            this.f21066b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new RippleDrawableCompat(new C10963b(this));
        }

        public C10963b(@NonNull C10963b c10963b) {
            this.f21065a = (MaterialShapeDrawable) c10963b.f21065a.getConstantState().newDrawable();
            this.f21066b = c10963b.f21066b;
        }
    }

    private RippleDrawableCompat(C10963b c10963b) {
        this.drawableState = c10963b;
    }
}
