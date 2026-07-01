package b.o.b.c;

import android.opengl.EGLSurface;
import d0.z.d.m;

/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public final EGLSurface a;

    public e(EGLSurface eGLSurface) {
        this.a = eGLSurface;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && m.areEqual(this.a, ((e) obj).a);
    }

    public int hashCode() {
        EGLSurface eGLSurface = this.a;
        if (eGLSurface == null) {
            return 0;
        }
        return eGLSurface.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("EglSurface(native=");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
