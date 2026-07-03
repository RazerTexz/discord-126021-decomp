package p007b.p452o.p475b.p478c;

import android.opengl.EGLContext;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.c.b */
/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5257b {

    /* JADX INFO: renamed from: a */
    public final EGLContext f14269a;

    public C5257b(EGLContext eGLContext) {
        this.f14269a = eGLContext;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C5257b) && C12238m.areEqual(this.f14269a, ((C5257b) obj).f14269a);
    }

    public int hashCode() {
        EGLContext eGLContext = this.f14269a;
        if (eGLContext == null) {
            return 0;
        }
        return eGLContext.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EglContext(native=");
        sbM833U.append(this.f14269a);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
