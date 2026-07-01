package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.u0;

/* JADX INFO: compiled from: ClassData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public final d0.e0.p.d.m0.f.z.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.f.c f3499b;
    public final d0.e0.p.d.m0.f.z.a c;
    public final u0 d;

    public f(d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.c cVar2, d0.e0.p.d.m0.f.z.a aVar, u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(cVar2, "classProto");
        d0.z.d.m.checkNotNullParameter(aVar, "metadataVersion");
        d0.z.d.m.checkNotNullParameter(u0Var, "sourceElement");
        this.a = cVar;
        this.f3499b = cVar2;
        this.c = aVar;
        this.d = u0Var;
    }

    public final d0.e0.p.d.m0.f.z.c component1() {
        return this.a;
    }

    public final d0.e0.p.d.m0.f.c component2() {
        return this.f3499b;
    }

    public final d0.e0.p.d.m0.f.z.a component3() {
        return this.c;
    }

    public final u0 component4() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return d0.z.d.m.areEqual(this.a, fVar.a) && d0.z.d.m.areEqual(this.f3499b, fVar.f3499b) && d0.z.d.m.areEqual(this.c, fVar.c) && d0.z.d.m.areEqual(this.d, fVar.d);
    }

    public int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.f3499b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ClassData(nameResolver=");
        sbU.append(this.a);
        sbU.append(", classProto=");
        sbU.append(this.f3499b);
        sbU.append(", metadataVersion=");
        sbU.append(this.c);
        sbU.append(", sourceElement=");
        sbU.append(this.d);
        sbU.append(')');
        return sbU.toString();
    }
}
