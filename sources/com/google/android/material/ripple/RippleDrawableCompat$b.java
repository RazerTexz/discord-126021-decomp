package com.google.android.material.ripple;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import androidx.annotation.NonNull;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes3.dex */
public final class RippleDrawableCompat$b extends Drawable$ConstantState {

    @NonNull
    public MaterialShapeDrawable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3052b;

    public RippleDrawableCompat$b(MaterialShapeDrawable materialShapeDrawable) {
        this.a = materialShapeDrawable;
        this.f3052b = false;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    @NonNull
    public Drawable newDrawable() {
        return new RippleDrawableCompat(new RippleDrawableCompat$b(this), null);
    }

    public RippleDrawableCompat$b(@NonNull RippleDrawableCompat$b rippleDrawableCompat$b) {
        this.a = (MaterialShapeDrawable) rippleDrawableCompat$b.a.getConstantState().newDrawable();
        this.f3052b = rippleDrawableCompat$b.f3052b;
    }
}
