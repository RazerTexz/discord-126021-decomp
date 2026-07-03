package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.s */
/* JADX INFO: compiled from: JavaClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11625s {
    InterfaceC11574g findClass(a aVar);

    InterfaceC11588u findPackage(C11713b c11713b);

    Set<String> knownClassNamesInPackage(C11713b c11713b);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.s$a */
    /* JADX INFO: compiled from: JavaClassFinder.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C11712a f23518a;

        /* JADX INFO: renamed from: b */
        public final byte[] f23519b;

        /* JADX INFO: renamed from: c */
        public final InterfaceC11574g f23520c;

        public a(C11712a c11712a, byte[] bArr, InterfaceC11574g interfaceC11574g) {
            C12238m.checkNotNullParameter(c11712a, "classId");
            this.f23518a = c11712a;
            this.f23519b = bArr;
            this.f23520c = interfaceC11574g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return C12238m.areEqual(this.f23518a, aVar.f23518a) && C12238m.areEqual(this.f23519b, aVar.f23519b) && C12238m.areEqual(this.f23520c, aVar.f23520c);
        }

        public final C11712a getClassId() {
            return this.f23518a;
        }

        public int hashCode() {
            int iHashCode = this.f23518a.hashCode() * 31;
            byte[] bArr = this.f23519b;
            int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            InterfaceC11574g interfaceC11574g = this.f23520c;
            return iHashCode2 + (interfaceC11574g != null ? interfaceC11574g.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Request(classId=");
            sbM833U.append(this.f23518a);
            sbM833U.append(", previouslyFoundClassFileContent=");
            sbM833U.append(Arrays.toString(this.f23519b));
            sbM833U.append(", outerClass=");
            sbM833U.append(this.f23520c);
            sbM833U.append(')');
            return sbM833U.toString();
        }

        public /* synthetic */ a(C11712a c11712a, byte[] bArr, InterfaceC11574g interfaceC11574g, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(c11712a, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : interfaceC11574g);
        }
    }
}
