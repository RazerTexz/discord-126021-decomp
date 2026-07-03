package p007b.p452o.p475b.p476a;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.util.Log;
import java.util.Iterator;
import org.webrtc.EglBase;
import p007b.p452o.p475b.p478c.C5256a;
import p007b.p452o.p475b.p478c.C5258c;
import p007b.p452o.p475b.p478c.C5259d;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.a.b */
/* JADX INFO: compiled from: EglNativeConfigChooser.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C5250b {
    /* JADX INFO: renamed from: a */
    public final C5256a m7454a(C5258c c5258c, int i, boolean z2) {
        C12238m.checkNotNullParameter(c5258c, "display");
        int i2 = i >= 3 ? C5259d.f14280j | C5259d.f14281k : C5259d.f14280j;
        int[] iArr = new int[15];
        iArr[0] = C5259d.f14282l;
        iArr[1] = 8;
        iArr[2] = C5259d.f14283m;
        iArr[3] = 8;
        iArr[4] = C5259d.f14284n;
        iArr[5] = 8;
        iArr[6] = C5259d.f14285o;
        iArr[7] = 8;
        iArr[8] = C5259d.f14286p;
        iArr[9] = C5259d.f14287q | C5259d.f14288r;
        iArr[10] = C5259d.f14289s;
        iArr[11] = i2;
        iArr[12] = z2 ? EglBase.EGL_RECORDABLE_ANDROID : C5259d.f14275e;
        iArr[13] = z2 ? 1 : 0;
        iArr[14] = C5259d.f14275e;
        C5256a[] c5256aArr = new C5256a[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(c5258c.f14270a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0);
        if (zEglChooseConfig) {
            Iterator<Integer> it = C12141k.getIndices(c5256aArr).iterator();
            while (it.hasNext()) {
                int iNextInt = ((AbstractC12126c0) it).nextInt();
                EGLConfig eGLConfig = eGLConfigArr[iNextInt];
                c5256aArr[iNextInt] = eGLConfig == null ? null : new C5256a(eGLConfig);
            }
        }
        if (zEglChooseConfig) {
            return c5256aArr[0];
        }
        Log.w("EglConfigChooser", "Unable to find RGB8888 / " + i + " EGLConfig");
        return null;
    }
}
