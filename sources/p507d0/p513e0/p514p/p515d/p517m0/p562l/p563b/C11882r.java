package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.r */
/* JADX INFO: compiled from: IncompatibleVersionErrorData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11882r<T> {

    /* JADX INFO: renamed from: a */
    public final T f24678a;

    /* JADX INFO: renamed from: b */
    public final T f24679b;

    /* JADX INFO: renamed from: c */
    public final String f24680c;

    /* JADX INFO: renamed from: d */
    public final C11712a f24681d;

    public C11882r(T t, T t2, String str, C11712a c11712a) {
        C12238m.checkNotNullParameter(str, "filePath");
        C12238m.checkNotNullParameter(c11712a, "classId");
        this.f24678a = t;
        this.f24679b = t2;
        this.f24680c = str;
        this.f24681d = c11712a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11882r)) {
            return false;
        }
        C11882r c11882r = (C11882r) obj;
        return C12238m.areEqual(this.f24678a, c11882r.f24678a) && C12238m.areEqual(this.f24679b, c11882r.f24679b) && C12238m.areEqual(this.f24680c, c11882r.f24680c) && C12238m.areEqual(this.f24681d, c11882r.f24681d);
    }

    public int hashCode() {
        T t = this.f24678a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f24679b;
        return this.f24681d.hashCode() + C1643a.m863m(this.f24680c, (iHashCode + (t2 != null ? t2.hashCode() : 0)) * 31, 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("IncompatibleVersionErrorData(actualVersion=");
        sbM833U.append(this.f24678a);
        sbM833U.append(", expectedVersion=");
        sbM833U.append(this.f24679b);
        sbM833U.append(", filePath=");
        sbM833U.append(this.f24680c);
        sbM833U.append(", classId=");
        sbM833U.append(this.f24681d);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
