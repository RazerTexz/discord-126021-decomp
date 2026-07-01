package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ShapePath$PathCubicOperation extends ShapePath$PathOperation {
    private float controlX1;
    private float controlX2;
    private float controlY1;
    private float controlY2;
    private float endX;
    private float endY;

    public ShapePath$PathCubicOperation(float f, float f2, float f3, float f4, float f5, float f6) {
        setControlX1(f);
        setControlY1(f2);
        setControlX2(f3);
        setControlY2(f4);
        setEndX(f5);
        setEndY(f6);
    }

    private float getControlX1() {
        return this.controlX1;
    }

    private float getControlX2() {
        return this.controlX2;
    }

    private float getControlY1() {
        return this.controlY1;
    }

    private float getControlY2() {
        return this.controlY1;
    }

    private float getEndX() {
        return this.endX;
    }

    private float getEndY() {
        return this.endY;
    }

    private void setControlX1(float f) {
        this.controlX1 = f;
    }

    private void setControlX2(float f) {
        this.controlX2 = f;
    }

    private void setControlY1(float f) {
        this.controlY1 = f;
    }

    private void setControlY2(float f) {
        this.controlY2 = f;
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
        path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
        path.transform(matrix);
    }
}
