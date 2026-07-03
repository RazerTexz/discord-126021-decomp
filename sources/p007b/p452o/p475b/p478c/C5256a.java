package p007b.p452o.p475b.p478c;

import android.opengl.EGLConfig;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.c.a */
/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5256a {

    /* JADX INFO: renamed from: a */
    public final EGLConfig f14268a;

    public C5256a(EGLConfig eGLConfig) {
        C12238m.checkNotNullParameter(eGLConfig, "native");
        this.f14268a = eGLConfig;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C5256a) && C12238m.areEqual(this.f14268a, ((C5256a) obj).f14268a);
    }

    public int hashCode() {
        return this.f14268a.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EglConfig(native=");
        sbM833U.append(this.f14268a);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
