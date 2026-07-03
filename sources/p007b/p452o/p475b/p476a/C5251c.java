package p007b.p452o.p475b.p476a;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import p007b.p452o.p475b.p478c.C5256a;
import p007b.p452o.p475b.p478c.C5257b;
import p007b.p452o.p475b.p478c.C5258c;
import p007b.p452o.p475b.p478c.C5259d;
import p007b.p452o.p475b.p478c.C5260e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.a.c */
/* JADX INFO: compiled from: EglNativeCore.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C5251c {

    /* JADX INFO: renamed from: a */
    public C5258c f14260a;

    /* JADX INFO: renamed from: b */
    public C5257b f14261b;

    /* JADX INFO: renamed from: c */
    public C5256a f14262c;

    public C5251c(C5257b c5257b, int i) {
        C5256a c5256aM7454a;
        C12238m.checkNotNullParameter(c5257b, "sharedContext");
        C5258c c5258c = C5259d.f14272b;
        this.f14260a = c5258c;
        this.f14261b = C5259d.f14271a;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        C5258c c5258c2 = new C5258c(eGLDisplayEglGetDisplay);
        this.f14260a = c5258c2;
        if (c5258c2 == c5258c) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0)) {
            throw new RuntimeException("unable to initialize EGL14");
        }
        C5250b c5250b = new C5250b();
        boolean z2 = (i & 1) != 0;
        if (((i & 2) != 0) && (c5256aM7454a = c5250b.m7454a(this.f14260a, 3, z2)) != null) {
            C5257b c5257b2 = new C5257b(EGL14.eglCreateContext(this.f14260a.f14270a, c5256aM7454a.f14268a, c5257b.f14269a, new int[]{C5259d.f14279i, 3, C5259d.f14275e}, 0));
            try {
                C5252d.m7456a("eglCreateContext (3)");
                this.f14262c = c5256aM7454a;
                this.f14261b = c5257b2;
            } catch (Exception unused) {
            }
        }
        if (this.f14261b == C5259d.f14271a) {
            C5256a c5256aM7454a2 = c5250b.m7454a(this.f14260a, 2, z2);
            if (c5256aM7454a2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            C5257b c5257b3 = new C5257b(EGL14.eglCreateContext(this.f14260a.f14270a, c5256aM7454a2.f14268a, c5257b.f14269a, new int[]{C5259d.f14279i, 2, C5259d.f14275e}, 0));
            C5252d.m7456a("eglCreateContext (2)");
            this.f14262c = c5256aM7454a2;
            this.f14261b = c5257b3;
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m7455a(C5260e c5260e, int i) {
        C12238m.checkNotNullParameter(c5260e, "eglSurface");
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f14260a.f14270a, c5260e.f14290a, i, iArr, 0);
        return iArr[0];
    }
}
