package b.o.b.a;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.util.Log;
import d0.t.c0;
import d0.t.k;
import d0.z.d.m;
import java.util.Iterator;
import org.webrtc.EglBase;

/* JADX INFO: compiled from: EglNativeConfigChooser.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public final b.o.b.c.a a(b.o.b.c.c cVar, int i, boolean z2) {
        m.checkNotNullParameter(cVar, "display");
        int i2 = i >= 3 ? b.o.b.c.d.j | b.o.b.c.d.k : b.o.b.c.d.j;
        int[] iArr = new int[15];
        iArr[0] = b.o.b.c.d.l;
        iArr[1] = 8;
        iArr[2] = b.o.b.c.d.m;
        iArr[3] = 8;
        iArr[4] = b.o.b.c.d.n;
        iArr[5] = 8;
        iArr[6] = b.o.b.c.d.o;
        iArr[7] = 8;
        iArr[8] = b.o.b.c.d.p;
        iArr[9] = b.o.b.c.d.q | b.o.b.c.d.r;
        iArr[10] = b.o.b.c.d.f1962s;
        iArr[11] = i2;
        iArr[12] = z2 ? EglBase.EGL_RECORDABLE_ANDROID : b.o.b.c.d.e;
        iArr[13] = z2 ? 1 : 0;
        iArr[14] = b.o.b.c.d.e;
        b.o.b.c.a[] aVarArr = new b.o.b.c.a[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(cVar.a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0);
        if (zEglChooseConfig) {
            Iterator<Integer> it = k.getIndices(aVarArr).iterator();
            while (it.hasNext()) {
                int iNextInt = ((c0) it).nextInt();
                EGLConfig eGLConfig = eGLConfigArr[iNextInt];
                aVarArr[iNextInt] = eGLConfig == null ? null : new b.o.b.c.a(eGLConfig);
            }
        }
        if (zEglChooseConfig) {
            return aVarArr[0];
        }
        Log.w("EglConfigChooser", "Unable to find RGB8888 / " + i + " EGLConfig");
        return null;
    }
}
