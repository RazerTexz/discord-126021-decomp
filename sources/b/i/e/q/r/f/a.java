package b.i.e.q.r.f;

/* JADX INFO: compiled from: ExpandedPair.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final b.i.e.q.r.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.e.q.r.b f1865b;
    public final b.i.e.q.r.c c;

    public a(b.i.e.q.r.b bVar, b.i.e.q.r.b bVar2, b.i.e.q.r.c cVar, boolean z2) {
        this.a = bVar;
        this.f1865b = bVar2;
        this.c = cVar;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a(this.a, aVar.a) && a(this.f1865b, aVar.f1865b) && a(this.c, aVar.c);
    }

    public int hashCode() {
        return (b(this.a) ^ b(this.f1865b)) ^ b(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.a);
        sb.append(" , ");
        sb.append(this.f1865b);
        sb.append(" : ");
        b.i.e.q.r.c cVar = this.c;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.a));
        sb.append(" ]");
        return sb.toString();
    }
}
