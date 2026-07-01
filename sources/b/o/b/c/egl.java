package b.o.b.c;

import android.opengl.EGLConfig;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.c.a, reason: use source file name */
/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class egl {
    public final EGLConfig a;

    public egl(EGLConfig eGLConfig) {
        Intrinsics3.checkNotNullParameter(eGLConfig, "native");
        this.a = eGLConfig;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof egl) && Intrinsics3.areEqual(this.a, ((egl) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("EglConfig(native=");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
