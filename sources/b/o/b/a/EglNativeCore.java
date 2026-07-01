package b.o.b.a;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import b.o.b.c.egl;
import b.o.b.c.egl2;
import b.o.b.c.egl3;
import b.o.b.c.egl4;
import b.o.b.c.egl5;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.a.c, reason: use source file name */
/* JADX INFO: compiled from: EglNativeCore.kt */
/* JADX INFO: loaded from: classes3.dex */
public class EglNativeCore {
    public egl3 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public egl2 f1959b;
    public egl c;

    public EglNativeCore(egl2 egl2Var, int i) {
        egl eglVarA;
        Intrinsics3.checkNotNullParameter(egl2Var, "sharedContext");
        egl3 egl3Var = egl4.f1961b;
        this.a = egl3Var;
        this.f1959b = egl4.a;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        egl3 egl3Var2 = new egl3(eGLDisplayEglGetDisplay);
        this.a = egl3Var2;
        if (egl3Var2 == egl3Var) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0)) {
            throw new RuntimeException("unable to initialize EGL14");
        }
        EglNativeConfigChooser eglNativeConfigChooser = new EglNativeConfigChooser();
        boolean z2 = (i & 1) != 0;
        if (((i & 2) != 0) && (eglVarA = eglNativeConfigChooser.a(this.a, 3, z2)) != null) {
            egl2 egl2Var2 = new egl2(EGL14.eglCreateContext(this.a.a, eglVarA.a, egl2Var.a, new int[]{egl4.i, 3, egl4.e}, 0));
            try {
                Egloo.a("eglCreateContext (3)");
                this.c = eglVarA;
                this.f1959b = egl2Var2;
            } catch (Exception unused) {
            }
        }
        if (this.f1959b == egl4.a) {
            egl eglVarA2 = eglNativeConfigChooser.a(this.a, 2, z2);
            if (eglVarA2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            egl2 egl2Var3 = new egl2(EGL14.eglCreateContext(this.a.a, eglVarA2.a, egl2Var.a, new int[]{egl4.i, 2, egl4.e}, 0));
            Egloo.a("eglCreateContext (2)");
            this.c = eglVarA2;
            this.f1959b = egl2Var3;
        }
    }

    public final int a(egl5 egl5Var, int i) {
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.a.a, egl5Var.a, i, iArr, 0);
        return iArr[0];
    }
}
