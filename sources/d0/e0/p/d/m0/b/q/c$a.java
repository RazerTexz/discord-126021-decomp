package d0.e0.p.d.m0.b.q;

/* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public final d0.e0.p.d.m0.g.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.g.a f3237b;
    public final d0.e0.p.d.m0.g.a c;

    public c$a(d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.a aVar2, d0.e0.p.d.m0.g.a aVar3) {
        d0.z.d.m.checkNotNullParameter(aVar, "javaClass");
        d0.z.d.m.checkNotNullParameter(aVar2, "kotlinReadOnly");
        d0.z.d.m.checkNotNullParameter(aVar3, "kotlinMutable");
        this.a = aVar;
        this.f3237b = aVar2;
        this.c = aVar3;
    }

    public final d0.e0.p.d.m0.g.a component1() {
        return this.a;
    }

    public final d0.e0.p.d.m0.g.a component2() {
        return this.f3237b;
    }

    public final d0.e0.p.d.m0.g.a component3() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c$a)) {
            return false;
        }
        c$a c_a = (c$a) obj;
        return d0.z.d.m.areEqual(this.a, c_a.a) && d0.z.d.m.areEqual(this.f3237b, c_a.f3237b) && d0.z.d.m.areEqual(this.c, c_a.c);
    }

    public final d0.e0.p.d.m0.g.a getJavaClass() {
        return this.a;
    }

    public int hashCode() {
        return this.c.hashCode() + ((this.f3237b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("PlatformMutabilityMapping(javaClass=");
        sbU.append(this.a);
        sbU.append(", kotlinReadOnly=");
        sbU.append(this.f3237b);
        sbU.append(", kotlinMutable=");
        sbU.append(this.c);
        sbU.append(')');
        return sbU.toString();
    }
}
