package b.o.b.e;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import b.o.b.c.c;
import b.o.b.c.d;
import b.o.b.c.e;
import d0.z.d.m;

/* JADX INFO: compiled from: EglWindowSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b extends a {
    public b(b.o.b.a.a aVar, SurfaceTexture surfaceTexture) {
        m.checkNotNullParameter(aVar, "eglCore");
        m.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        m.checkNotNullParameter(surfaceTexture, "surface");
        int[] iArr = {d.e};
        c cVar = aVar.a;
        b.o.b.c.a aVar2 = aVar.c;
        m.checkNotNull(aVar2);
        e eVar = new e(EGL14.eglCreateWindowSurface(cVar.a, aVar2.a, surfaceTexture, iArr, 0));
        b.o.b.a.d.a("eglCreateWindowSurface");
        if (eVar == d.c) {
            throw new RuntimeException("surface was null");
        }
        m.checkNotNullParameter(aVar, "eglCore");
        m.checkNotNullParameter(eVar, "eglSurface");
        super(aVar, eVar);
    }
}
