package p007b.p452o.p475b.p478c;

import android.opengl.EGLDisplay;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.c.c */
/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5258c {

    /* JADX INFO: renamed from: a */
    public final EGLDisplay f14270a;

    public C5258c(EGLDisplay eGLDisplay) {
        this.f14270a = eGLDisplay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C5258c) && C12238m.areEqual(this.f14270a, ((C5258c) obj).f14270a);
    }

    public int hashCode() {
        EGLDisplay eGLDisplay = this.f14270a;
        if (eGLDisplay == null) {
            return 0;
        }
        return eGLDisplay.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EglDisplay(native=");
        sbM833U.append(this.f14270a);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
