package androidx.core.graphics;

import android.graphics.Matrix;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.core.graphics.ShaderKt, reason: use source file name */
/* JADX INFO: compiled from: Shader.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Shader {
    public static final void transform(android.graphics.Shader shader, Function1<? super Matrix, Unit> function1) {
        Intrinsics3.checkNotNullParameter(shader, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        function1.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
