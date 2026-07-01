package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ShapePath$PathArcOperation extends ShapePath$PathOperation {
    private static final RectF rectF = new RectF();

    @Deprecated
    public float bottom;

    @Deprecated
    public float left;

    @Deprecated
    public float right;

    @Deprecated
    public float startAngle;

    @Deprecated
    public float sweepAngle;

    @Deprecated
    public float top;

    public ShapePath$PathArcOperation(float f, float f2, float f3, float f4) {
        setLeft(f);
        setTop(f2);
        setRight(f3);
        setBottom(f4);
    }

    public static /* synthetic */ float access$1000(ShapePath$PathArcOperation shapePath$PathArcOperation) {
        return shapePath$PathArcOperation.getLeft();
    }

    public static /* synthetic */ float access$1100(ShapePath$PathArcOperation shapePath$PathArcOperation) {
        return shapePath$PathArcOperation.getTop();
    }

    public static /* synthetic */ float access$1200(ShapePath$PathArcOperation shapePath$PathArcOperation) {
        return shapePath$PathArcOperation.getRight();
    }

    public static /* synthetic */ float access$1300(ShapePath$PathArcOperation shapePath$PathArcOperation) {
        return shapePath$PathArcOperation.getBottom();
    }

    public static /* synthetic */ void access$600(ShapePath$PathArcOperation shapePath$PathArcOperation, float f) {
        shapePath$PathArcOperation.setStartAngle(f);
    }

    public static /* synthetic */ void access$700(ShapePath$PathArcOperation shapePath$PathArcOperation, float f) {
        shapePath$PathArcOperation.setSweepAngle(f);
    }

    public static /* synthetic */ float access$800(ShapePath$PathArcOperation shapePath$PathArcOperation) {
        return shapePath$PathArcOperation.getStartAngle();
    }

    public static /* synthetic */ float access$900(ShapePath$PathArcOperation shapePath$PathArcOperation) {
        return shapePath$PathArcOperation.getSweepAngle();
    }

    private float getBottom() {
        return this.bottom;
    }

    private float getLeft() {
        return this.left;
    }

    private float getRight() {
        return this.right;
    }

    private float getStartAngle() {
        return this.startAngle;
    }

    private float getSweepAngle() {
        return this.sweepAngle;
    }

    private float getTop() {
        return this.top;
    }

    private void setBottom(float f) {
        this.bottom = f;
    }

    private void setLeft(float f) {
        this.left = f;
    }

    private void setRight(float f) {
        this.right = f;
    }

    private void setStartAngle(float f) {
        this.startAngle = f;
    }

    private void setSweepAngle(float f) {
        this.sweepAngle = f;
    }

    private void setTop(float f) {
        this.top = f;
    }

    @Override // com.google.android.material.shape.ShapePath$PathOperation
    public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
        Matrix matrix2 = this.matrix;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF2 = rectF;
        rectF2.set(getLeft(), getTop(), getRight(), getBottom());
        path.arcTo(rectF2, getStartAngle(), getSweepAngle(), false);
        path.transform(matrix);
    }
}
