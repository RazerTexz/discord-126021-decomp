package com.google.android.material.shape;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.Paint$Style;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.elevation.ElevationOverlayProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialShapeDrawable$c extends Drawable$ConstantState {

    @NonNull
    public ShapeAppearanceModel a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public ElevationOverlayProvider f3053b;

    @Nullable
    public ColorFilter c;

    @Nullable
    public ColorStateList d;

    @Nullable
    public ColorStateList e;

    @Nullable
    public ColorStateList f;

    @Nullable
    public ColorStateList g;

    @Nullable
    public PorterDuff$Mode h;

    @Nullable
    public Rect i;
    public float j;
    public float k;
    public float l;
    public int m;
    public float n;
    public float o;
    public float p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3054s;
    public int t;
    public boolean u;
    public Paint$Style v;

    public MaterialShapeDrawable$c(ShapeAppearanceModel shapeAppearanceModel, ElevationOverlayProvider elevationOverlayProvider) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = PorterDuff$Mode.SRC_IN;
        this.i = null;
        this.j = 1.0f;
        this.k = 1.0f;
        this.m = 255;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.f3054s = 0;
        this.t = 0;
        this.u = false;
        this.v = Paint$Style.FILL_AND_STROKE;
        this.a = shapeAppearanceModel;
        this.f3053b = null;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    @NonNull
    public Drawable newDrawable() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this, null);
        MaterialShapeDrawable.access$402(materialShapeDrawable, true);
        return materialShapeDrawable;
    }

    public MaterialShapeDrawable$c(@NonNull MaterialShapeDrawable$c materialShapeDrawable$c) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = PorterDuff$Mode.SRC_IN;
        this.i = null;
        this.j = 1.0f;
        this.k = 1.0f;
        this.m = 255;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.f3054s = 0;
        this.t = 0;
        this.u = false;
        this.v = Paint$Style.FILL_AND_STROKE;
        this.a = materialShapeDrawable$c.a;
        this.f3053b = materialShapeDrawable$c.f3053b;
        this.l = materialShapeDrawable$c.l;
        this.c = materialShapeDrawable$c.c;
        this.d = materialShapeDrawable$c.d;
        this.e = materialShapeDrawable$c.e;
        this.h = materialShapeDrawable$c.h;
        this.g = materialShapeDrawable$c.g;
        this.m = materialShapeDrawable$c.m;
        this.j = materialShapeDrawable$c.j;
        this.f3054s = materialShapeDrawable$c.f3054s;
        this.q = materialShapeDrawable$c.q;
        this.u = materialShapeDrawable$c.u;
        this.k = materialShapeDrawable$c.k;
        this.n = materialShapeDrawable$c.n;
        this.o = materialShapeDrawable$c.o;
        this.p = materialShapeDrawable$c.p;
        this.r = materialShapeDrawable$c.r;
        this.t = materialShapeDrawable$c.t;
        this.f = materialShapeDrawable$c.f;
        this.v = materialShapeDrawable$c.v;
        if (materialShapeDrawable$c.i != null) {
            this.i = new Rect(materialShapeDrawable$c.i);
        }
    }
}
