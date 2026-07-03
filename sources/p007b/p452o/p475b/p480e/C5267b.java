package p007b.p452o.p475b.p480e;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import p007b.p452o.p475b.p476a.C5249a;
import p007b.p452o.p475b.p476a.C5252d;
import p007b.p452o.p475b.p478c.C5256a;
import p007b.p452o.p475b.p478c.C5258c;
import p007b.p452o.p475b.p478c.C5259d;
import p007b.p452o.p475b.p478c.C5260e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.e.b */
/* JADX INFO: compiled from: EglWindowSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C5267b extends AbstractC5266a {
    public C5267b(C5249a c5249a, SurfaceTexture surfaceTexture) {
        C12238m.checkNotNullParameter(c5249a, "eglCore");
        C12238m.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        C12238m.checkNotNullParameter(surfaceTexture, "surface");
        int[] iArr = {C5259d.f14275e};
        C5258c c5258c = c5249a.f14260a;
        C5256a c5256a = c5249a.f14262c;
        C12238m.checkNotNull(c5256a);
        C5260e c5260e = new C5260e(EGL14.eglCreateWindowSurface(c5258c.f14270a, c5256a.f14268a, surfaceTexture, iArr, 0));
        C5252d.m7456a("eglCreateWindowSurface");
        if (c5260e == C5259d.f14273c) {
            throw new RuntimeException("surface was null");
        }
        C12238m.checkNotNullParameter(c5249a, "eglCore");
        C12238m.checkNotNullParameter(c5260e, "eglSurface");
        super(c5249a, c5260e);
    }
}
