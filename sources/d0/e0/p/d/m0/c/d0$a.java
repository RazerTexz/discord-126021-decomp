package d0.e0.p.d.m0.c;

import java.util.List;

/* JADX INFO: compiled from: NotFoundClasses.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0$a {
    public final d0.e0.p.d.m0.g.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f3244b;

    public d0$a(d0.e0.p.d.m0.g.a aVar, List<Integer> list) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        d0.z.d.m.checkNotNullParameter(list, "typeParametersCount");
        this.a = aVar;
        this.f3244b = list;
    }

    public final d0.e0.p.d.m0.g.a component1() {
        return this.a;
    }

    public final List<Integer> component2() {
        return this.f3244b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0$a)) {
            return false;
        }
        d0$a d0_a = (d0$a) obj;
        return d0.z.d.m.areEqual(this.a, d0_a.a) && d0.z.d.m.areEqual(this.f3244b, d0_a.f3244b);
    }

    public int hashCode() {
        return this.f3244b.hashCode() + (this.a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ClassRequest(classId=");
        sbU.append(this.a);
        sbU.append(", typeParametersCount=");
        sbU.append(this.f3244b);
        sbU.append(')');
        return sbU.toString();
    }
}
