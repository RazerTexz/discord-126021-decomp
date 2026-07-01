package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialShapeDrawable$b implements ShapeAppearanceModel$CornerSizeUnaryOperator {
    public final /* synthetic */ float a;

    public MaterialShapeDrawable$b(MaterialShapeDrawable materialShapeDrawable, float f) {
        this.a = f;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel$CornerSizeUnaryOperator
    @NonNull
    public CornerSize apply(@NonNull CornerSize cornerSize) {
        return cornerSize instanceof RelativeCornerSize ? cornerSize : new AdjustedCornerSize(this.a, cornerSize);
    }
}
