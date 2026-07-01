package b.o.b.a;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.util.Log;
import b.o.b.c.f;
import d0.p;
import d0.z.d.m;

/* JADX INFO: compiled from: Egloo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final float[] a;

    static {
        float[] fArr = new float[16];
        m.checkNotNullParameter(fArr, "<this>");
        m.checkNotNullParameter(fArr, "matrix");
        Matrix.setIdentityM(fArr, 0);
        a = fArr;
    }

    public static final void a(String str) {
        m.checkNotNullParameter(str, "opName");
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == b.o.b.c.d.d) {
            return;
        }
        StringBuilder sbY = b.d.b.a.a.Y("Error during ", str, ": EGL error 0x");
        String hexString = Integer.toHexString(iEglGetError);
        m.checkNotNullExpressionValue(hexString, "toHexString(value)");
        sbY.append(hexString);
        String string = sbY.toString();
        Log.e("Egloo", string);
        throw new RuntimeException(string);
    }

    public static final void b(String str) {
        m.checkNotNullParameter(str, "opName");
        int iM105constructorimpl = p.m105constructorimpl(GLES20.glGetError());
        int i = f.a;
        if (iM105constructorimpl == 0) {
            return;
        }
        StringBuilder sbY = b.d.b.a.a.Y("Error during ", str, ": glError 0x");
        String hexString = Integer.toHexString(iM105constructorimpl);
        m.checkNotNullExpressionValue(hexString, "toHexString(value)");
        sbY.append(hexString);
        sbY.append(": ");
        String strGluErrorString = GLU.gluErrorString(iM105constructorimpl);
        m.checkNotNullExpressionValue(strGluErrorString, "gluErrorString(value)");
        sbY.append(strGluErrorString);
        String string = sbY.toString();
        Log.e("Egloo", string);
        throw new RuntimeException(string);
    }
}
