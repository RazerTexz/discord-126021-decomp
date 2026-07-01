package b.o.b.c;

import android.opengl.EGLConfig;
import d0.z.d.m;

/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final EGLConfig a;

    public a(EGLConfig eGLConfig) {
        m.checkNotNullParameter(eGLConfig, "native");
        this.a = eGLConfig;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && m.areEqual(this.a, ((a) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("EglConfig(native=");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
