package b.o.b.c;

import android.opengl.EGLContext;
import d0.z.d.m;

/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final EGLContext a;

    public b(EGLContext eGLContext) {
        this.a = eGLContext;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && m.areEqual(this.a, ((b) obj).a);
    }

    public int hashCode() {
        EGLContext eGLContext = this.a;
        if (eGLContext == null) {
            return 0;
        }
        return eGLContext.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("EglContext(native=");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
