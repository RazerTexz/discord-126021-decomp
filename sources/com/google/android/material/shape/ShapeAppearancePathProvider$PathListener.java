package com.google.android.material.shape;

import android.graphics.Matrix;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public interface ShapeAppearancePathProvider$PathListener {
    void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i);

    void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i);
}
