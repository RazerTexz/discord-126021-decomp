package s.a.c2;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v<T> {
    public final Object a;

    public /* synthetic */ v(Object obj) {
        this.a = obj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof v) && d0.z.d.m.areEqual(this.a, ((v) obj).a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.a;
        if (obj instanceof v$a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }
}
