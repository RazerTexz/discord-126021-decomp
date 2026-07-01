package b.o.b.c;

import android.opengl.EGLContext;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.c.b, reason: use source file name */
/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class egl2 {
    public final EGLContext a;

    public egl2(EGLContext eGLContext) {
        this.a = eGLContext;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof egl2) && Intrinsics3.areEqual(this.a, ((egl2) obj).a);
    }

    public int hashCode() {
        EGLContext eGLContext = this.a;
        if (eGLContext == null) {
            return 0;
        }
        return eGLContext.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("EglContext(native=");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
