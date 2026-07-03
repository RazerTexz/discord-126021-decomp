package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.Iterator;
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
    private final List<PathOperation> operations = new ArrayList();
    private final List<AbstractC10974d> shadowCompatOperations = new ArrayList();

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    public static class PathArcOperation extends PathOperation {
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

        public PathArcOperation(float f, float f2, float f3, float f4) {
            setLeft(f);
            setTop(f2);
            setRight(f3);
            setBottom(f4);
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

        @Override // com.google.android.material.shape.ShapePath.PathOperation
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

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float f, float f2, float f3, float f4, float f5, float f6) {
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

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {

        /* JADX INFO: renamed from: x */
        private float f21098x;

        /* JADX INFO: renamed from: y */
        private float f21099y;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f21098x, this.f21099y);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {
        public final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    public static class PathQuadOperation extends PathOperation {

        @Deprecated
        public float controlX;

        @Deprecated
        public float controlY;

        @Deprecated
        public float endX;

        @Deprecated
        public float endY;

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

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.shape.ShapePath$a */
    public class C10971a extends AbstractC10974d {

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ List f21100b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ Matrix f21101c;

        public C10971a(ShapePath shapePath, List list, Matrix matrix) {
            this.f21100b = list;
            this.f21101c = matrix;
        }

        @Override // com.google.android.material.shape.ShapePath.AbstractC10974d
        /* JADX INFO: renamed from: a */
        public void mo9146a(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            Iterator it = this.f21100b.iterator();
            while (it.hasNext()) {
                ((AbstractC10974d) it.next()).mo9146a(this.f21101c, shadowRenderer, i, canvas);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.shape.ShapePath$b */
    public static class C10972b extends AbstractC10974d {

        /* JADX INFO: renamed from: b */
        public final PathArcOperation f21102b;

        public C10972b(PathArcOperation pathArcOperation) {
            this.f21102b = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.AbstractC10974d
        /* JADX INFO: renamed from: a */
        public void mo9146a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i, @NonNull Canvas canvas) {
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.f21102b.getLeft(), this.f21102b.getTop(), this.f21102b.getRight(), this.f21102b.getBottom()), i, this.f21102b.getStartAngle(), this.f21102b.getSweepAngle());
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.shape.ShapePath$c */
    public static class C10973c extends AbstractC10974d {

        /* JADX INFO: renamed from: b */
        public final PathLineOperation f21103b;

        /* JADX INFO: renamed from: c */
        public final float f21104c;

        /* JADX INFO: renamed from: d */
        public final float f21105d;

        public C10973c(PathLineOperation pathLineOperation, float f, float f2) {
            this.f21103b = pathLineOperation;
            this.f21104c = f;
            this.f21105d = f2;
        }

        @Override // com.google.android.material.shape.ShapePath.AbstractC10974d
        /* JADX INFO: renamed from: a */
        public void mo9146a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f21103b.f21099y - this.f21105d, this.f21103b.f21098x - this.f21104c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f21104c, this.f21105d);
            matrix2.preRotate(m9147b());
            shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i);
        }

        /* JADX INFO: renamed from: b */
        public float m9147b() {
            return (float) Math.toDegrees(Math.atan((this.f21103b.f21099y - this.f21105d) / (this.f21103b.f21098x - this.f21104c)));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.shape.ShapePath$d */
    public static abstract class AbstractC10974d {

        /* JADX INFO: renamed from: a */
        public static final Matrix f21106a = new Matrix();

        /* JADX INFO: renamed from: a */
        public abstract void mo9146a(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas);
    }

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
        PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        pathArcOperation.setStartAngle(getCurrentShadowAngle());
        pathArcOperation.setSweepAngle(currentShadowAngle);
        this.shadowCompatOperations.add(new C10972b(pathArcOperation));
        setCurrentShadowAngle(f);
    }

    private void addShadowCompatOperation(AbstractC10974d abstractC10974d, float f, float f2) {
        addConnectingShadowIfNecessary(f);
        this.shadowCompatOperations.add(abstractC10974d);
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
        PathArcOperation pathArcOperation = new PathArcOperation(f, f2, f3, f4);
        pathArcOperation.setStartAngle(f5);
        pathArcOperation.setSweepAngle(f6);
        this.operations.add(pathArcOperation);
        C10972b c10972b = new C10972b(pathArcOperation);
        float f7 = f5 + f6;
        boolean z2 = f6 < 0.0f;
        if (z2) {
            f5 = (f5 + 180.0f) % 360.0f;
        }
        addShadowCompatOperation(c10972b, f5, z2 ? (180.0f + f7) % 360.0f : f7);
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
    public AbstractC10974d createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        return new C10971a(this, new ArrayList(this.shadowCompatOperations), new Matrix(matrix));
    }

    @RequiresApi(21)
    public void cubicToPoint(float f, float f2, float f3, float f4, float f5, float f6) {
        this.operations.add(new PathCubicOperation(f, f2, f3, f4, f5, f6));
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
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f21098x = f;
        pathLineOperation.f21099y = f2;
        this.operations.add(pathLineOperation);
        C10973c c10973c = new C10973c(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(c10973c, c10973c.m9147b() + ANGLE_UP, c10973c.m9147b() + ANGLE_UP);
        setEndX(f);
        setEndY(f2);
    }

    @RequiresApi(21)
    public void quadToPoint(float f, float f2, float f3, float f4) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(f);
        pathQuadOperation.setControlY(f2);
        pathQuadOperation.setEndX(f3);
        pathQuadOperation.setEndY(f4);
        this.operations.add(pathQuadOperation);
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
