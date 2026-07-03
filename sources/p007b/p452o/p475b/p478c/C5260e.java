package p007b.p452o.p475b.p478c;

import android.opengl.EGLSurface;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.c.e */
/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5260e {

    /* JADX INFO: renamed from: a */
    public final EGLSurface f14290a;

    public C5260e(EGLSurface eGLSurface) {
        this.f14290a = eGLSurface;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C5260e) && C12238m.areEqual(this.f14290a, ((C5260e) obj).f14290a);
    }

    public int hashCode() {
        EGLSurface eGLSurface = this.f14290a;
        if (eGLSurface == null) {
            return 0;
        }
        return eGLSurface.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EglSurface(native=");
        sbM833U.append(this.f14290a);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
