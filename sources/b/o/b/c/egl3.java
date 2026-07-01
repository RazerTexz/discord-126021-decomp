package b.o.b.c;

import android.opengl.EGLDisplay;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.c.c, reason: use source file name */
/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class egl3 {
    public final EGLDisplay a;

    public egl3(EGLDisplay eGLDisplay) {
        this.a = eGLDisplay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof egl3) && Intrinsics3.areEqual(this.a, ((egl3) obj).a);
    }

    public int hashCode() {
        EGLDisplay eGLDisplay = this.a;
        if (eGLDisplay == null) {
            return 0;
        }
        return eGLDisplay.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("EglDisplay(native=");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
