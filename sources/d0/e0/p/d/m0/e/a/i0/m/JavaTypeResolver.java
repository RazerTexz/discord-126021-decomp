package d0.e0.p.d.m0.e.a.i0.m;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.e.a.g0.TypeUsage;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.a, reason: use source file name */
/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeResolver {
    public final TypeUsage a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JavaTypeResolver2 f3339b;
    public final boolean c;
    public final TypeParameterDescriptor d;

    public JavaTypeResolver(TypeUsage typeUsage, JavaTypeResolver2 javaTypeResolver2, boolean z2, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics3.checkNotNullParameter(javaTypeResolver2, "flexibility");
        this.a = typeUsage;
        this.f3339b = javaTypeResolver2;
        this.c = z2;
        this.d = typeParameterDescriptor;
    }

    public static /* synthetic */ JavaTypeResolver copy$default(JavaTypeResolver javaTypeResolver, TypeUsage typeUsage, JavaTypeResolver2 javaTypeResolver2, boolean z2, TypeParameterDescriptor typeParameterDescriptor, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = javaTypeResolver.a;
        }
        if ((i & 2) != 0) {
            javaTypeResolver2 = javaTypeResolver.f3339b;
        }
        if ((i & 4) != 0) {
            z2 = javaTypeResolver.c;
        }
        if ((i & 8) != 0) {
            typeParameterDescriptor = javaTypeResolver.d;
        }
        return javaTypeResolver.copy(typeUsage, javaTypeResolver2, z2, typeParameterDescriptor);
    }

    public final JavaTypeResolver copy(TypeUsage typeUsage, JavaTypeResolver2 javaTypeResolver2, boolean z2, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics3.checkNotNullParameter(javaTypeResolver2, "flexibility");
        return new JavaTypeResolver(typeUsage, javaTypeResolver2, z2, typeParameterDescriptor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaTypeResolver)) {
            return false;
        }
        JavaTypeResolver javaTypeResolver = (JavaTypeResolver) obj;
        return this.a == javaTypeResolver.a && this.f3339b == javaTypeResolver.f3339b && this.c == javaTypeResolver.c && Intrinsics3.areEqual(this.d, javaTypeResolver.d);
    }

    public final JavaTypeResolver2 getFlexibility() {
        return this.f3339b;
    }

    public final TypeUsage getHowThisTypeIsUsed() {
        return this.a;
    }

    public final TypeParameterDescriptor getUpperBoundOfTypeParameter() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        int iHashCode = (this.f3339b.hashCode() + (this.a.hashCode() * 31)) * 31;
        boolean z2 = this.c;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode + r0) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.d;
        return i + (typeParameterDescriptor == null ? 0 : typeParameterDescriptor.hashCode());
    }

    public final boolean isForAnnotationParameter() {
        return this.c;
    }

    public String toString() {
        StringBuilder sbU = outline.U("JavaTypeAttributes(howThisTypeIsUsed=");
        sbU.append(this.a);
        sbU.append(", flexibility=");
        sbU.append(this.f3339b);
        sbU.append(", isForAnnotationParameter=");
        sbU.append(this.c);
        sbU.append(", upperBoundOfTypeParameter=");
        sbU.append(this.d);
        sbU.append(')');
        return sbU.toString();
    }

    public final JavaTypeResolver withFlexibility(JavaTypeResolver2 javaTypeResolver2) {
        Intrinsics3.checkNotNullParameter(javaTypeResolver2, "flexibility");
        return copy$default(this, null, javaTypeResolver2, false, null, 13, null);
    }

    public /* synthetic */ JavaTypeResolver(TypeUsage typeUsage, JavaTypeResolver2 javaTypeResolver2, boolean z2, TypeParameterDescriptor typeParameterDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i & 2) != 0 ? JavaTypeResolver2.INFLEXIBLE : javaTypeResolver2, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : typeParameterDescriptor);
    }
}
