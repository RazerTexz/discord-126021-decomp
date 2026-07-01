package s.a.c2;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v$a {
    public final Throwable a;

    public v$a(Throwable th) {
        this.a = th;
    }

    public boolean equals(Object obj) {
        return (obj instanceof v$a) && d0.z.d.m.areEqual(this.a, ((v$a) obj).a);
    }

    public int hashCode() {
        Throwable th = this.a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Closed(");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
