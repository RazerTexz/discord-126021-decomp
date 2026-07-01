package d0;

import java.io.Serializable;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$b implements Serializable {
    public final Throwable exception;

    public k$b(Throwable th) {
        d0.z.d.m.checkNotNullParameter(th, "exception");
        this.exception = th;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k$b) && d0.z.d.m.areEqual(this.exception, ((k$b) obj).exception);
    }

    public int hashCode() {
        return this.exception.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Failure(");
        sbU.append(this.exception);
        sbU.append(')');
        return sbU.toString();
    }
}
