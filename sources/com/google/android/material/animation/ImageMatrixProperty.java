package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {
    private final Matrix matrix;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.matrix = new Matrix();
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Matrix get(@NonNull ImageView imageView) {
        return get2(imageView);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull ImageView imageView, @NonNull Matrix matrix) {
        set2(imageView, matrix);
    }

    @NonNull
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Matrix get2(@NonNull ImageView imageView) {
        this.matrix.set(imageView.getImageMatrix());
        return this.matrix;
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull ImageView imageView, @NonNull Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
