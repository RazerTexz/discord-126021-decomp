package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Shader.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(Shader shader, Function1<? super Matrix, Unit> function1) {
        C12238m.checkNotNullParameter(shader, "<this>");
        C12238m.checkNotNullParameter(function1, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        function1.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
