package p637j0;

/* JADX INFO: renamed from: j0.f */
/* JADX INFO: compiled from: Notification.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12580f<T> {

    /* JADX INFO: renamed from: a */
    public static final C12580f<Void> f26688a = new C12580f<>(a.OnCompleted, null, null);

    /* JADX INFO: renamed from: b */
    public final a f26689b;

    /* JADX INFO: renamed from: c */
    public final Throwable f26690c;

    /* JADX INFO: renamed from: d */
    public final T f26691d;

    /* JADX INFO: renamed from: j0.f$a */
    /* JADX INFO: compiled from: Notification.java */
    public enum a {
        OnNext,
        OnError,
        OnCompleted
    }

    public C12580f(a aVar, T t, Throwable th) {
        this.f26691d = t;
        this.f26690c = th;
        this.f26689b = aVar;
    }

    /* JADX INFO: renamed from: a */
    public boolean m10733a() {
        return (this.f26689b == a.OnError) && this.f26690c != null;
    }

    /* JADX INFO: renamed from: b */
    public boolean m10734b() {
        return (this.f26689b == a.OnNext) && this.f26691d != null;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != C12580f.class) {
            return false;
        }
        C12580f c12580f = (C12580f) obj;
        if (c12580f.f26689b != this.f26689b) {
            return false;
        }
        T t = this.f26691d;
        T t2 = c12580f.f26691d;
        if (t != t2 && (t == null || !t.equals(t2))) {
            return false;
        }
        Throwable th = this.f26690c;
        Throwable th2 = c12580f.f26690c;
        return th == th2 || (th != null && th.equals(th2));
    }

    public int hashCode() {
        int iHashCode = this.f26689b.hashCode();
        if (m10734b()) {
            iHashCode = (iHashCode * 31) + this.f26691d.hashCode();
        }
        return m10733a() ? (iHashCode * 31) + this.f26690c.hashCode() : iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        sb.append(this.f26689b);
        if (m10734b()) {
            sb.append(' ');
            sb.append(this.f26691d);
        }
        if (m10733a()) {
            sb.append(' ');
            sb.append(this.f26690c.getMessage());
        }
        sb.append(']');
        return sb.toString();
    }
}
