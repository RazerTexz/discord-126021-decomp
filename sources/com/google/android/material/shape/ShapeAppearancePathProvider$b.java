package com.google.android.material.shape;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ShapeAppearancePathProvider$b {

    @NonNull
    public final ShapeAppearanceModel a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Path f3055b;

    @NonNull
    public final RectF c;

    @Nullable
    public final ShapeAppearancePathProvider$PathListener d;
    public final float e;

    public ShapeAppearancePathProvider$b(@NonNull ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, @Nullable ShapeAppearancePathProvider$PathListener shapeAppearancePathProvider$PathListener, Path path) {
        this.d = shapeAppearancePathProvider$PathListener;
        this.a = shapeAppearanceModel;
        this.e = f;
        this.c = rectF;
        this.f3055b = path;
    }
}
