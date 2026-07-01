package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ShapePath {
    public static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;

    @Deprecated
    public float currentShadowAngle;

    @Deprecated
    public float endShadowAngle;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;
    private final List<ShapePath$PathOperation> operations = new ArrayList();
    private final List<ShapePath$d> shadowCompatOperations = new ArrayList();

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float f) {
        if (getCurrentShadowAngle() == f) {
            return;
        }
        float currentShadowAngle = ((f - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (currentShadowAngle > 180.0f) {
            return;
        }
        ShapePath$PathArcOperation shapePath$PathArcOperation = new ShapePath$PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        ShapePath$PathArcOperation.access$600(shapePath$PathArcOperation, getCurrentShadowAngle());
        ShapePath$PathArcOperation.access$700(shapePath$PathArcOperation, currentShadowAngle);
        this.shadowCompatOperations.add(new ShapePath$b(shapePath$PathArcOperation));
        setCurrentShadowAngle(f);
    }

    private void addShadowCompatOperation(ShapePath$d shapePath$d, float f, float f2) {
        addConnectingShadowIfNecessary(f);
        this.shadowCompatOperations.add(shapePath$d);
        setCurrentShadowAngle(f2);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float f) {
        this.currentShadowAngle = f;
    }

    private void setEndShadowAngle(float f) {
        this.endShadowAngle = f;
    }

    private void setEndX(float f) {
        this.endX = f;
    }

    private void setEndY(float f) {
        this.endY = f;
    }

    private void setStartX(float f) {
        this.startX = f;
    }

    private void setStartY(float f) {
        this.startY = f;
    }

    public void addArc(float f, float f2, float f3, float f4, float f5, float f6) {
        ShapePath$PathArcOperation shapePath$PathArcOperation = new ShapePath$PathArcOperation(f, f2, f3, f4);
        ShapePath$PathArcOperation.access$600(shapePath$PathArcOperation, f5);
        ShapePath$PathArcOperation.access$700(shapePath$PathArcOperation, f6);
        this.operations.add(shapePath$PathArcOperation);
        ShapePath$b shapePath$b = new ShapePath$b(shapePath$PathArcOperation);
        float f7 = f5 + f6;
        boolean z2 = f6 < 0.0f;
        if (z2) {
            f5 = (f5 + 180.0f) % 360.0f;
        }
        addShadowCompatOperation(shapePath$b, f5, z2 ? (180.0f + f7) % 360.0f : f7);
        double d = f7;
        setEndX((((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))) + ((f + f3) * 0.5f));
        setEndY((((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))) + ((f2 + f4) * 0.5f));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i = 0; i < size; i++) {
            this.operations.get(i).applyToPath(matrix, path);
        }
    }

    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    @NonNull
    public ShapePath$d createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        return new ShapePath$a(this, new ArrayList(this.shadowCompatOperations), new Matrix(matrix));
    }

    @RequiresApi(21)
    public void cubicToPoint(float f, float f2, float f3, float f4, float f5, float f6) {
        this.operations.add(new ShapePath$PathCubicOperation(f, f2, f3, f4, f5, f6));
        this.containsIncompatibleShadowOp = true;
        setEndX(f5);
        setEndY(f6);
    }

    public float getEndX() {
        return this.endX;
    }

    public float getEndY() {
        return this.endY;
    }

    public float getStartX() {
        return this.startX;
    }

    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float f, float f2) {
        ShapePath$PathLineOperation shapePath$PathLineOperation = new ShapePath$PathLineOperation();
        ShapePath$PathLineOperation.access$002(shapePath$PathLineOperation, f);
        ShapePath$PathLineOperation.access$102(shapePath$PathLineOperation, f2);
        this.operations.add(shapePath$PathLineOperation);
        ShapePath$c shapePath$c = new ShapePath$c(shapePath$PathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(shapePath$c, shapePath$c.b() + ANGLE_UP, shapePath$c.b() + ANGLE_UP);
        setEndX(f);
        setEndY(f2);
    }

    @RequiresApi(21)
    public void quadToPoint(float f, float f2, float f3, float f4) {
        ShapePath$PathQuadOperation shapePath$PathQuadOperation = new ShapePath$PathQuadOperation();
        ShapePath$PathQuadOperation.access$200(shapePath$PathQuadOperation, f);
        ShapePath$PathQuadOperation.access$300(shapePath$PathQuadOperation, f2);
        ShapePath$PathQuadOperation.access$400(shapePath$PathQuadOperation, f3);
        ShapePath$PathQuadOperation.access$500(shapePath$PathQuadOperation, f4);
        this.operations.add(shapePath$PathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f3);
        setEndY(f4);
    }

    public void reset(float f, float f2) {
        reset(f, f2, ANGLE_UP, 0.0f);
    }

    public void reset(float f, float f2, float f3, float f4) {
        setStartX(f);
        setStartY(f2);
        setEndX(f);
        setEndY(f2);
        setCurrentShadowAngle(f3);
        setEndShadowAngle((f3 + f4) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public ShapePath(float f, float f2) {
        reset(f, f2);
    }
}
