package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowRenderer;

/* JADX INFO: loaded from: classes3.dex */
public class ShapePath$c extends ShapePath$d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShapePath$PathLineOperation f3060b;
    public final float c;
    public final float d;

    public ShapePath$c(ShapePath$PathLineOperation shapePath$PathLineOperation, float f, float f2) {
        this.f3060b = shapePath$PathLineOperation;
        this.c = f;
        this.d = f2;
    }

    @Override // com.google.android.material.shape.ShapePath$d
    public void a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i, @NonNull Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(ShapePath$PathLineOperation.access$100(this.f3060b) - this.d, ShapePath$PathLineOperation.access$000(this.f3060b) - this.c), 0.0f);
        Matrix matrix2 = new Matrix(matrix);
        matrix2.preTranslate(this.c, this.d);
        matrix2.preRotate(b());
        shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i);
    }

    public float b() {
        return (float) Math.toDegrees(Math.atan((ShapePath$PathLineOperation.access$100(this.f3060b) - this.d) / (ShapePath$PathLineOperation.access$000(this.f3060b) - this.c)));
    }
}
