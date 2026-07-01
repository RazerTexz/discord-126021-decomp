package b.o.b.a;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import b.o.b.c.e;

/* JADX INFO: compiled from: EglCore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {
    public a(EGLContext eGLContext, int i) {
        super(new b.o.b.c.b(eGLContext), i);
    }

    public void b() {
        b.o.b.c.c cVar = this.a;
        b.o.b.c.c cVar2 = b.o.b.c.d.f1961b;
        if (cVar != cVar2) {
            e eVar = b.o.b.c.d.c;
            b.o.b.c.b bVar = b.o.b.c.d.a;
            EGLDisplay eGLDisplay = cVar.a;
            EGLSurface eGLSurface = eVar.a;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, bVar.a);
            EGL14.eglDestroyContext(this.a.a, this.f1959b.a);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.a.a);
        }
        this.a = cVar2;
        this.f1959b = b.o.b.c.d.a;
        this.c = null;
    }

    public final void finalize() {
        b();
    }
}
