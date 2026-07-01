package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ShapePath$PathLineOperation extends ShapePath$PathOperation {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f3056x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f3057y;

    public static /* synthetic */ float access$000(ShapePath$PathLineOperation shapePath$PathLineOperation) {
        return shapePath$PathLineOperation.f3056x;
    }

    public static /* synthetic */ float access$002(ShapePath$PathLineOperation shapePath$PathLineOperation, float f) {
        shapePath$PathLineOperation.f3056x = f;
        return f;
    }

    public static /* synthetic */ float access$100(ShapePath$PathLineOperation shapePath$PathLineOperation) {
        return shapePath$PathLineOperation.f3057y;
    }

    public static /* synthetic */ float access$102(ShapePath$PathLineOperation shapePath$PathLineOperation, float f) {
        shapePath$PathLineOperation.f3057y = f;
        return f;
    }

    @Override // com.google.android.material.shape.ShapePath$PathOperation
    public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
        Matrix matrix2 = this.matrix;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f3056x, this.f3057y);
        path.transform(matrix);
    }
}
