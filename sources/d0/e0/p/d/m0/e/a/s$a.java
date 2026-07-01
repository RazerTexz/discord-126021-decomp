package d0.e0.p.d.m0.e.a;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: JavaClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s$a {
    public final d0.e0.p.d.m0.g.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3357b;
    public final d0.e0.p.d.m0.e.a.k0.g c;

    public s$a(d0.e0.p.d.m0.g.a aVar, byte[] bArr, d0.e0.p.d.m0.e.a.k0.g gVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        this.a = aVar;
        this.f3357b = bArr;
        this.c = gVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s$a)) {
            return false;
        }
        s$a s_a = (s$a) obj;
        return d0.z.d.m.areEqual(this.a, s_a.a) && d0.z.d.m.areEqual(this.f3357b, s_a.f3357b) && d0.z.d.m.areEqual(this.c, s_a.c);
    }

    public final d0.e0.p.d.m0.g.a getClassId() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        byte[] bArr = this.f3357b;
        int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
        d0.e0.p.d.m0.e.a.k0.g gVar = this.c;
        return iHashCode2 + (gVar != null ? gVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Request(classId=");
        sbU.append(this.a);
        sbU.append(", previouslyFoundClassFileContent=");
        sbU.append(Arrays.toString(this.f3357b));
        sbU.append(", outerClass=");
        sbU.append(this.c);
        sbU.append(')');
        return sbU.toString();
    }

    public /* synthetic */ s$a(d0.e0.p.d.m0.g.a aVar, byte[] bArr, d0.e0.p.d.m0.e.a.k0.g gVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : gVar);
    }
}
