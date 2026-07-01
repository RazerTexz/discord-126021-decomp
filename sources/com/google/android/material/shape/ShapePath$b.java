package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowRenderer;

/* JADX INFO: loaded from: classes3.dex */
public class ShapePath$b extends ShapePath$d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShapePath$PathArcOperation f3059b;

    public ShapePath$b(ShapePath$PathArcOperation shapePath$PathArcOperation) {
        this.f3059b = shapePath$PathArcOperation;
    }

    @Override // com.google.android.material.shape.ShapePath$d
    public void a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i, @NonNull Canvas canvas) {
        shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(ShapePath$PathArcOperation.access$1000(this.f3059b), ShapePath$PathArcOperation.access$1100(this.f3059b), ShapePath$PathArcOperation.access$1200(this.f3059b), ShapePath$PathArcOperation.access$1300(this.f3059b)), i, ShapePath$PathArcOperation.access$800(this.f3059b), ShapePath$PathArcOperation.access$900(this.f3059b));
    }
}
