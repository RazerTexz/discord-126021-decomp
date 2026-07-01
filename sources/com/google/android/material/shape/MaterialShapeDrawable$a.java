package com.google.android.material.shape;

import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialShapeDrawable$a implements ShapeAppearancePathProvider$PathListener {
    public final /* synthetic */ MaterialShapeDrawable a;

    public MaterialShapeDrawable$a(MaterialShapeDrawable materialShapeDrawable) {
        this.a = materialShapeDrawable;
    }

    @Override // com.google.android.material.shape.ShapeAppearancePathProvider$PathListener
    public void onCornerPathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i) {
        MaterialShapeDrawable.access$000(this.a).set(i, shapePath.containsIncompatibleShadowOp());
        MaterialShapeDrawable.access$100(this.a)[i] = shapePath.createShadowCompatOperation(matrix);
    }

    @Override // com.google.android.material.shape.ShapeAppearancePathProvider$PathListener
    public void onEdgePathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i) {
        MaterialShapeDrawable.access$000(this.a).set(i + 4, shapePath.containsIncompatibleShadowOp());
        MaterialShapeDrawable.access$200(this.a)[i] = shapePath.createShadowCompatOperation(matrix);
    }
}
