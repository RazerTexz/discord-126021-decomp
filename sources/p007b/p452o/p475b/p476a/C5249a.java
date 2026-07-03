package p007b.p452o.p475b.p476a;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import p007b.p452o.p475b.p478c.C5257b;
import p007b.p452o.p475b.p478c.C5258c;
import p007b.p452o.p475b.p478c.C5259d;
import p007b.p452o.p475b.p478c.C5260e;

/* JADX INFO: renamed from: b.o.b.a.a */
/* JADX INFO: compiled from: EglCore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5249a extends C5251c {
    public C5249a(EGLContext eGLContext, int i) {
        super(new C5257b(eGLContext), i);
    }

    /* JADX INFO: renamed from: b */
    public void m7453b() {
        C5258c c5258c = this.f14260a;
        C5258c c5258c2 = C5259d.f14272b;
        if (c5258c != c5258c2) {
            C5260e c5260e = C5259d.f14273c;
            C5257b c5257b = C5259d.f14271a;
            EGLDisplay eGLDisplay = c5258c.f14270a;
            EGLSurface eGLSurface = c5260e.f14290a;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, c5257b.f14269a);
            EGL14.eglDestroyContext(this.f14260a.f14270a, this.f14261b.f14269a);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f14260a.f14270a);
        }
        this.f14260a = c5258c2;
        this.f14261b = C5259d.f14271a;
        this.f14262c = null;
    }

    public final void finalize() {
        m7453b();
    }
}
