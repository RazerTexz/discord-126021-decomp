package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.EnumC11508k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.a */
/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11553a {

    /* JADX INFO: renamed from: a */
    public final EnumC11508k f23421a;

    /* JADX INFO: renamed from: b */
    public final EnumC11554b f23422b;

    /* JADX INFO: renamed from: c */
    public final boolean f23423c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC11477z0 f23424d;

    public C11553a(EnumC11508k enumC11508k, EnumC11554b enumC11554b, boolean z2, InterfaceC11477z0 interfaceC11477z0) {
        C12238m.checkNotNullParameter(enumC11508k, "howThisTypeIsUsed");
        C12238m.checkNotNullParameter(enumC11554b, "flexibility");
        this.f23421a = enumC11508k;
        this.f23422b = enumC11554b;
        this.f23423c = z2;
        this.f23424d = interfaceC11477z0;
    }

    public static /* synthetic */ C11553a copy$default(C11553a c11553a, EnumC11508k enumC11508k, EnumC11554b enumC11554b, boolean z2, InterfaceC11477z0 interfaceC11477z0, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC11508k = c11553a.f23421a;
        }
        if ((i & 2) != 0) {
            enumC11554b = c11553a.f23422b;
        }
        if ((i & 4) != 0) {
            z2 = c11553a.f23423c;
        }
        if ((i & 8) != 0) {
            interfaceC11477z0 = c11553a.f23424d;
        }
        return c11553a.copy(enumC11508k, enumC11554b, z2, interfaceC11477z0);
    }

    public final C11553a copy(EnumC11508k enumC11508k, EnumC11554b enumC11554b, boolean z2, InterfaceC11477z0 interfaceC11477z0) {
        C12238m.checkNotNullParameter(enumC11508k, "howThisTypeIsUsed");
        C12238m.checkNotNullParameter(enumC11554b, "flexibility");
        return new C11553a(enumC11508k, enumC11554b, z2, interfaceC11477z0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11553a)) {
            return false;
        }
        C11553a c11553a = (C11553a) obj;
        return this.f23421a == c11553a.f23421a && this.f23422b == c11553a.f23422b && this.f23423c == c11553a.f23423c && C12238m.areEqual(this.f23424d, c11553a.f23424d);
    }

    public final EnumC11554b getFlexibility() {
        return this.f23422b;
    }

    public final EnumC11508k getHowThisTypeIsUsed() {
        return this.f23421a;
    }

    public final InterfaceC11477z0 getUpperBoundOfTypeParameter() {
        return this.f23424d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        int iHashCode = (this.f23422b.hashCode() + (this.f23421a.hashCode() * 31)) * 31;
        boolean z2 = this.f23423c;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode + r0) * 31;
        InterfaceC11477z0 interfaceC11477z0 = this.f23424d;
        return i + (interfaceC11477z0 == null ? 0 : interfaceC11477z0.hashCode());
    }

    public final boolean isForAnnotationParameter() {
        return this.f23423c;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("JavaTypeAttributes(howThisTypeIsUsed=");
        sbM833U.append(this.f23421a);
        sbM833U.append(", flexibility=");
        sbM833U.append(this.f23422b);
        sbM833U.append(", isForAnnotationParameter=");
        sbM833U.append(this.f23423c);
        sbM833U.append(", upperBoundOfTypeParameter=");
        sbM833U.append(this.f23424d);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    public final C11553a withFlexibility(EnumC11554b enumC11554b) {
        C12238m.checkNotNullParameter(enumC11554b, "flexibility");
        return copy$default(this, null, enumC11554b, false, null, 13, null);
    }

    public /* synthetic */ C11553a(EnumC11508k enumC11508k, EnumC11554b enumC11554b, boolean z2, InterfaceC11477z0 interfaceC11477z0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enumC11508k, (i & 2) != 0 ? EnumC11554b.INFLEXIBLE : enumC11554b, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : interfaceC11477z0);
    }
}
