package d0.e0.p.d.m0.e.a;

import b.d.b.a.outline;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.s, reason: use source file name */
/* JADX INFO: compiled from: JavaClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface JavaClassFinder {
    d0.e0.p.d.m0.e.a.k0.g findClass(a aVar);

    d0.e0.p.d.m0.e.a.k0.u findPackage(FqName fqName);

    Set<String> knownClassNamesInPackage(FqName fqName);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.s$a */
    /* JADX INFO: compiled from: JavaClassFinder.kt */
    public static final class a {
        public final ClassId a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f3357b;
        public final d0.e0.p.d.m0.e.a.k0.g c;

        public a(ClassId classId, byte[] bArr, d0.e0.p.d.m0.e.a.k0.g gVar) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            this.a = classId;
            this.f3357b = bArr;
            this.c = gVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && Intrinsics3.areEqual(this.f3357b, aVar.f3357b) && Intrinsics3.areEqual(this.c, aVar.c);
        }

        public final ClassId getClassId() {
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
            StringBuilder sbU = outline.U("Request(classId=");
            sbU.append(this.a);
            sbU.append(", previouslyFoundClassFileContent=");
            sbU.append(Arrays.toString(this.f3357b));
            sbU.append(", outerClass=");
            sbU.append(this.c);
            sbU.append(')');
            return sbU.toString();
        }

        public /* synthetic */ a(ClassId classId, byte[] bArr, d0.e0.p.d.m0.e.a.k0.g gVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(classId, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : gVar);
        }
    }
}
