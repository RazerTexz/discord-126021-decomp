package androidx.core.graphics;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.graphics.MatrixKt, reason: use source file name */
/* JADX INFO: compiled from: Matrix.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Matrix {
    public static final android.graphics.Matrix rotationMatrix(float f, float f2, float f3) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(f, f2, f3);
        return matrix;
    }

    public static /* synthetic */ android.graphics.Matrix rotationMatrix$default(float f, float f2, float f3, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        return rotationMatrix(f, f2, f3);
    }

    public static final android.graphics.Matrix scaleMatrix(float f, float f2) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setScale(f, f2);
        return matrix;
    }

    public static /* synthetic */ android.graphics.Matrix scaleMatrix$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        return scaleMatrix(f, f2);
    }

    public static final android.graphics.Matrix times(android.graphics.Matrix matrix, android.graphics.Matrix matrix2) {
        Intrinsics3.checkNotNullParameter(matrix, "<this>");
        Intrinsics3.checkNotNullParameter(matrix2, "m");
        android.graphics.Matrix matrix3 = new android.graphics.Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    public static final android.graphics.Matrix translationMatrix(float f, float f2) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setTranslate(f, f2);
        return matrix;
    }

    public static /* synthetic */ android.graphics.Matrix translationMatrix$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        return translationMatrix(f, f2);
    }

    public static final float[] values(android.graphics.Matrix matrix) {
        Intrinsics3.checkNotNullParameter(matrix, "<this>");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
