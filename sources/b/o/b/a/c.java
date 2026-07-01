package b.o.b.a;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import b.o.b.c.e;
import d0.z.d.m;

/* JADX INFO: compiled from: EglNativeCore.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public b.o.b.c.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.o.b.c.b f1959b;
    public b.o.b.c.a c;

    public c(b.o.b.c.b bVar, int i) {
        b.o.b.c.a aVarA;
        m.checkNotNullParameter(bVar, "sharedContext");
        b.o.b.c.c cVar = b.o.b.c.d.f1961b;
        this.a = cVar;
        this.f1959b = b.o.b.c.d.a;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        b.o.b.c.c cVar2 = new b.o.b.c.c(eGLDisplayEglGetDisplay);
        this.a = cVar2;
        if (cVar2 == cVar) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0)) {
            throw new RuntimeException("unable to initialize EGL14");
        }
        b bVar2 = new b();
        boolean z2 = (i & 1) != 0;
        if (((i & 2) != 0) && (aVarA = bVar2.a(this.a, 3, z2)) != null) {
            b.o.b.c.b bVar3 = new b.o.b.c.b(EGL14.eglCreateContext(this.a.a, aVarA.a, bVar.a, new int[]{b.o.b.c.d.i, 3, b.o.b.c.d.e}, 0));
            try {
                d.a("eglCreateContext (3)");
                this.c = aVarA;
                this.f1959b = bVar3;
            } catch (Exception unused) {
            }
        }
        if (this.f1959b == b.o.b.c.d.a) {
            b.o.b.c.a aVarA2 = bVar2.a(this.a, 2, z2);
            if (aVarA2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            b.o.b.c.b bVar4 = new b.o.b.c.b(EGL14.eglCreateContext(this.a.a, aVarA2.a, bVar.a, new int[]{b.o.b.c.d.i, 2, b.o.b.c.d.e}, 0));
            d.a("eglCreateContext (2)");
            this.c = aVarA2;
            this.f1959b = bVar4;
        }
    }

    public final int a(e eVar, int i) {
        m.checkNotNullParameter(eVar, "eglSurface");
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.a.a, eVar.a, i, iArr, 0);
        return iArr[0];
    }
}
