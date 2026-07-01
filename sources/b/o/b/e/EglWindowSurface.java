package b.o.b.e;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import b.o.b.a.EglCore;
import b.o.b.a.Egloo;
import b.o.b.c.egl;
import b.o.b.c.egl3;
import b.o.b.c.egl4;
import b.o.b.c.egl5;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.e.b, reason: use source file name */
/* JADX INFO: compiled from: EglWindowSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
public class EglWindowSurface extends EglSurface {
    public EglWindowSurface(EglCore eglCore, SurfaceTexture surfaceTexture) {
        Intrinsics3.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics3.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        Intrinsics3.checkNotNullParameter(surfaceTexture, "surface");
        int[] iArr = {egl4.e};
        egl3 egl3Var = eglCore.a;
        egl eglVar = eglCore.c;
        Intrinsics3.checkNotNull(eglVar);
        egl5 egl5Var = new egl5(EGL14.eglCreateWindowSurface(egl3Var.a, eglVar.a, surfaceTexture, iArr, 0));
        Egloo.a("eglCreateWindowSurface");
        if (egl5Var == egl4.c) {
            throw new RuntimeException("surface was null");
        }
        Intrinsics3.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        super(eglCore, egl5Var);
    }
}
