package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ShapePath$PathQuadOperation extends ShapePath$PathOperation {

    @Deprecated
    public float controlX;

    @Deprecated
    public float controlY;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;

    public static /* synthetic */ void access$200(ShapePath$PathQuadOperation shapePath$PathQuadOperation, float f) {
        shapePath$PathQuadOperation.setControlX(f);
    }

    public static /* synthetic */ void access$300(ShapePath$PathQuadOperation shapePath$PathQuadOperation, float f) {
        shapePath$PathQuadOperation.setControlY(f);
    }

    public static /* synthetic */ void access$400(ShapePath$PathQuadOperation shapePath$PathQuadOperation, float f) {
        shapePath$PathQuadOperation.setEndX(f);
    }

    public static /* synthetic */ void access$500(ShapePath$PathQuadOperation shapePath$PathQuadOperation, float f) {
        shapePath$PathQuadOperation.setEndY(f);
    }

    private float getControlX() {
        return this.controlX;
    }

    private float getControlY() {
        return this.controlY;
    }

    private float getEndX() {
        return this.endX;
    }

    private float getEndY() {
        return this.endY;
    }

    private void setControlX(float f) {
        this.controlX = f;
    }

    private void setControlY(float f) {
        this.controlY = f;
    }

    private void setEndX(float f) {
        this.endX = f;
    }

    private void setEndY(float f) {
        this.endY = f;
    }

    @Override // com.google.android.material.shape.ShapePath$PathOperation
    public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
        Matrix matrix2 = this.matrix;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
        path.transform(matrix);
    }
}
