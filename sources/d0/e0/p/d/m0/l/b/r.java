package d0.e0.p.d.m0.l.b;

/* JADX INFO: compiled from: IncompatibleVersionErrorData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f3507b;
    public final String c;
    public final d0.e0.p.d.m0.g.a d;

    public r(T t, T t2, String str, d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(str, "filePath");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        this.a = t;
        this.f3507b = t2;
        this.c = str;
        this.d = aVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return d0.z.d.m.areEqual(this.a, rVar.a) && d0.z.d.m.areEqual(this.f3507b, rVar.f3507b) && d0.z.d.m.areEqual(this.c, rVar.c) && d0.z.d.m.areEqual(this.d, rVar.d);
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f3507b;
        return this.d.hashCode() + b.d.b.a.a.m(this.c, (iHashCode + (t2 != null ? t2.hashCode() : 0)) * 31, 31);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("IncompatibleVersionErrorData(actualVersion=");
        sbU.append(this.a);
        sbU.append(", expectedVersion=");
        sbU.append(this.f3507b);
        sbU.append(", filePath=");
        sbU.append(this.c);
        sbU.append(", classId=");
        sbU.append(this.d);
        sbU.append(')');
        return sbU.toString();
    }
}
