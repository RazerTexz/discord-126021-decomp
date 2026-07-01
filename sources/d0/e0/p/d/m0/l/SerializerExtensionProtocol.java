package d0.e0.p.d.m0.l;

import d0.e0.p.d.m0.f.b;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.d;
import d0.e0.p.d.m0.f.g;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.u;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.a, reason: use source file name */
/* JADX INFO: compiled from: SerializerExtensionProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SerializerExtensionProtocol {
    public final ExtensionRegistryLite a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GeneratedMessageLite.f<d, List<b>> f3480b;
    public final GeneratedMessageLite.f<c, List<b>> c;
    public final GeneratedMessageLite.f<i, List<b>> d;
    public final GeneratedMessageLite.f<n, List<b>> e;
    public final GeneratedMessageLite.f<n, List<b>> f;
    public final GeneratedMessageLite.f<n, List<b>> g;
    public final GeneratedMessageLite.f<g, List<b>> h;
    public final GeneratedMessageLite.f<n, b.C0393b.c> i;
    public final GeneratedMessageLite.f<u, List<b>> j;
    public final GeneratedMessageLite.f<q, List<b>> k;
    public final GeneratedMessageLite.f<s, List<b>> l;

    public SerializerExtensionProtocol(ExtensionRegistryLite extensionRegistryLite, GeneratedMessageLite.f<l, Integer> fVar, GeneratedMessageLite.f<d, List<b>> fVar2, GeneratedMessageLite.f<c, List<b>> fVar3, GeneratedMessageLite.f<i, List<b>> fVar4, GeneratedMessageLite.f<n, List<b>> fVar5, GeneratedMessageLite.f<n, List<b>> fVar6, GeneratedMessageLite.f<n, List<b>> fVar7, GeneratedMessageLite.f<g, List<b>> fVar8, GeneratedMessageLite.f<n, b.C0393b.c> fVar9, GeneratedMessageLite.f<u, List<b>> fVar10, GeneratedMessageLite.f<q, List<b>> fVar11, GeneratedMessageLite.f<s, List<b>> fVar12) {
        Intrinsics3.checkNotNullParameter(extensionRegistryLite, "extensionRegistry");
        Intrinsics3.checkNotNullParameter(fVar, "packageFqName");
        Intrinsics3.checkNotNullParameter(fVar2, "constructorAnnotation");
        Intrinsics3.checkNotNullParameter(fVar3, "classAnnotation");
        Intrinsics3.checkNotNullParameter(fVar4, "functionAnnotation");
        Intrinsics3.checkNotNullParameter(fVar5, "propertyAnnotation");
        Intrinsics3.checkNotNullParameter(fVar6, "propertyGetterAnnotation");
        Intrinsics3.checkNotNullParameter(fVar7, "propertySetterAnnotation");
        Intrinsics3.checkNotNullParameter(fVar8, "enumEntryAnnotation");
        Intrinsics3.checkNotNullParameter(fVar9, "compileTimeValue");
        Intrinsics3.checkNotNullParameter(fVar10, "parameterAnnotation");
        Intrinsics3.checkNotNullParameter(fVar11, "typeAnnotation");
        Intrinsics3.checkNotNullParameter(fVar12, "typeParameterAnnotation");
        this.a = extensionRegistryLite;
        this.f3480b = fVar2;
        this.c = fVar3;
        this.d = fVar4;
        this.e = fVar5;
        this.f = fVar6;
        this.g = fVar7;
        this.h = fVar8;
        this.i = fVar9;
        this.j = fVar10;
        this.k = fVar11;
        this.l = fVar12;
    }

    public final GeneratedMessageLite.f<c, List<b>> getClassAnnotation() {
        return this.c;
    }

    public final GeneratedMessageLite.f<n, b.C0393b.c> getCompileTimeValue() {
        return this.i;
    }

    public final GeneratedMessageLite.f<d, List<b>> getConstructorAnnotation() {
        return this.f3480b;
    }

    public final GeneratedMessageLite.f<g, List<b>> getEnumEntryAnnotation() {
        return this.h;
    }

    public final ExtensionRegistryLite getExtensionRegistry() {
        return this.a;
    }

    public final GeneratedMessageLite.f<i, List<b>> getFunctionAnnotation() {
        return this.d;
    }

    public final GeneratedMessageLite.f<u, List<b>> getParameterAnnotation() {
        return this.j;
    }

    public final GeneratedMessageLite.f<n, List<b>> getPropertyAnnotation() {
        return this.e;
    }

    public final GeneratedMessageLite.f<n, List<b>> getPropertyGetterAnnotation() {
        return this.f;
    }

    public final GeneratedMessageLite.f<n, List<b>> getPropertySetterAnnotation() {
        return this.g;
    }

    public final GeneratedMessageLite.f<q, List<b>> getTypeAnnotation() {
        return this.k;
    }

    public final GeneratedMessageLite.f<s, List<b>> getTypeParameterAnnotation() {
        return this.l;
    }
}
