package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ShapePath$PathOperation {
    public final Matrix matrix = new Matrix();

    public abstract void applyToPath(Matrix matrix, Path path);
}
