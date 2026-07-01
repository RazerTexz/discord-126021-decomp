package b.o.b.a;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.util.Log;
import b.d.b.a.outline;
import b.o.b.c.egl4;
import b.o.b.c.gl;
import d0.UInt;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.a.d, reason: use source file name */
/* JADX INFO: compiled from: Egloo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Egloo {
    public static final float[] a;

    static {
        float[] fArr = new float[16];
        Intrinsics3.checkNotNullParameter(fArr, "<this>");
        Intrinsics3.checkNotNullParameter(fArr, "matrix");
        Matrix.setIdentityM(fArr, 0);
        a = fArr;
    }

    public static final void a(String str) {
        Intrinsics3.checkNotNullParameter(str, "opName");
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == egl4.d) {
            return;
        }
        StringBuilder sbY = outline.Y("Error during ", str, ": EGL error 0x");
        String hexString = Integer.toHexString(iEglGetError);
        Intrinsics3.checkNotNullExpressionValue(hexString, "toHexString(value)");
        sbY.append(hexString);
        String string = sbY.toString();
        Log.e("Egloo", string);
        throw new RuntimeException(string);
    }

    public static final void b(String str) {
        Intrinsics3.checkNotNullParameter(str, "opName");
        int iM105constructorimpl = UInt.m105constructorimpl(GLES20.glGetError());
        int i = gl.a;
        if (iM105constructorimpl == 0) {
            return;
        }
        StringBuilder sbY = outline.Y("Error during ", str, ": glError 0x");
        String hexString = Integer.toHexString(iM105constructorimpl);
        Intrinsics3.checkNotNullExpressionValue(hexString, "toHexString(value)");
        sbY.append(hexString);
        sbY.append(": ");
        String strGluErrorString = GLU.gluErrorString(iM105constructorimpl);
        Intrinsics3.checkNotNullExpressionValue(strGluErrorString, "gluErrorString(value)");
        sbY.append(strGluErrorString);
        String string = sbY.toString();
        Log.e("Egloo", string);
        throw new RuntimeException(string);
    }
}
