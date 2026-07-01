package b.o.b.a;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import b.o.b.c.egl2;
import b.o.b.c.egl3;
import b.o.b.c.egl4;
import b.o.b.c.egl5;

/* JADX INFO: renamed from: b.o.b.a.a, reason: use source file name */
/* JADX INFO: compiled from: EglCore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EglCore extends EglNativeCore {
    public EglCore(EGLContext eGLContext, int i) {
        super(new egl2(eGLContext), i);
    }

    public void b() {
        egl3 egl3Var = this.a;
        egl3 egl3Var2 = egl4.f1961b;
        if (egl3Var != egl3Var2) {
            egl5 egl5Var = egl4.c;
            egl2 egl2Var = egl4.a;
            EGLDisplay eGLDisplay = egl3Var.a;
            EGLSurface eGLSurface = egl5Var.a;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, egl2Var.a);
            EGL14.eglDestroyContext(this.a.a, this.f1959b.a);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.a.a);
        }
        this.a = egl3Var2;
        this.f1959b = egl4.a;
        this.c = null;
    }

    public final void finalize() {
        b();
    }
}
