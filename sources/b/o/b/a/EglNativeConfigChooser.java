package b.o.b.a;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.util.Log;
import b.o.b.c.egl;
import b.o.b.c.egl3;
import b.o.b.c.egl4;
import d0.t.Iterators4;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import org.webrtc.EglBase;

/* JADX INFO: renamed from: b.o.b.a.b, reason: use source file name */
/* JADX INFO: compiled from: EglNativeConfigChooser.kt */
/* JADX INFO: loaded from: classes3.dex */
public class EglNativeConfigChooser {
    public final egl a(egl3 egl3Var, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(egl3Var, "display");
        int i2 = i >= 3 ? egl4.j | egl4.k : egl4.j;
        int[] iArr = new int[15];
        iArr[0] = egl4.l;
        iArr[1] = 8;
        iArr[2] = egl4.m;
        iArr[3] = 8;
        iArr[4] = egl4.n;
        iArr[5] = 8;
        iArr[6] = egl4.o;
        iArr[7] = 8;
        iArr[8] = egl4.p;
        iArr[9] = egl4.q | egl4.r;
        iArr[10] = egl4.f1962s;
        iArr[11] = i2;
        iArr[12] = z2 ? EglBase.EGL_RECORDABLE_ANDROID : egl4.e;
        iArr[13] = z2 ? 1 : 0;
        iArr[14] = egl4.e;
        egl[] eglVarArr = new egl[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(egl3Var.a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0);
        if (zEglChooseConfig) {
            Iterator<Integer> it = _Arrays.getIndices(eglVarArr).iterator();
            while (it.hasNext()) {
                int iNextInt = ((Iterators4) it).nextInt();
                EGLConfig eGLConfig = eGLConfigArr[iNextInt];
                eglVarArr[iNextInt] = eGLConfig == null ? null : new egl(eGLConfig);
            }
        }
        if (zEglChooseConfig) {
            return eglVarArr[0];
        }
        Log.w("EglConfigChooser", "Unable to find RGB8888 / " + i + " EGLConfig");
        return null;
    }
}
