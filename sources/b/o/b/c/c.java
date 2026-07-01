package b.o.b.c;

import android.opengl.EGLDisplay;
import d0.z.d.m;

/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final EGLDisplay a;

    public c(EGLDisplay eGLDisplay) {
        this.a = eGLDisplay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && m.areEqual(this.a, ((c) obj).a);
    }

    public int hashCode() {
        EGLDisplay eGLDisplay = this.a;
        if (eGLDisplay == null) {
            return 0;
        }
        return eGLDisplay.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("EglDisplay(native=");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
