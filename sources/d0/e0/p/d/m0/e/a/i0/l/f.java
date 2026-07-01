package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.f1;
import d0.e0.p.d.m0.c.r0;
import d0.e0.p.d.m0.c.t;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.f0;
import d0.e0.p.d.m0.e.a.g0.g$a;
import d0.e0.p.d.m0.e.a.w;
import d0.e0.p.d.m0.n.u0;
import d0.t.n0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends d0.e0.p.d.m0.c.i1.h implements d0.e0.p.d.m0.e.a.h0.d {
    public final h A;
    public final r0<h> B;
    public final d0.e0.p.d.m0.k.a0.g C;
    public final o D;
    public final d0.e0.p.d.m0.c.g1.g E;
    public final d0.e0.p.d.m0.m.j<List<z0>> F;
    public final d0.e0.p.d.m0.e.a.i0.g r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d0.e0.p.d.m0.e.a.k0.g f3328s;
    public final d0.e0.p.d.m0.c.e t;
    public final d0.e0.p.d.m0.e.a.i0.g u;
    public final d0.e0.p.d.m0.c.f v;
    public final z w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f1 f3329x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f3330y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f$b f3331z;

    static {
        new f$a(null);
        n0.setOf((Object[]) new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    public /* synthetic */ f(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.e.a.k0.g gVar2, d0.e0.p.d.m0.c.e eVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, mVar, gVar2, (i & 8) != 0 ? null : eVar);
    }

    public static final /* synthetic */ d0.e0.p.d.m0.c.e access$getAdditionalSupertypeClassDescriptor$p(f fVar) {
        return fVar.t;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g access$getC$p(f fVar) {
        return fVar.u;
    }

    public static final /* synthetic */ h access$getUnsubstitutedMemberScope$p(f fVar) {
        return fVar.A;
    }

    public final f copy$descriptors_jvm(d0.e0.p.d.m0.e.a.g0.g gVar, d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "javaResolverCache");
        d0.e0.p.d.m0.e.a.i0.g gVar2 = this.u;
        d0.e0.p.d.m0.e.a.i0.g gVarReplaceComponents = d0.e0.p.d.m0.e.a.i0.a.replaceComponents(gVar2, gVar2.getComponents().replace(gVar));
        d0.e0.p.d.m0.c.m containingDeclaration = getContainingDeclaration();
        d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        return new f(gVarReplaceComponents, containingDeclaration, this.f3328s, eVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return this.E;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.e getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        return this.F.invoke();
    }

    public final d0.e0.p.d.m0.e.a.k0.g getJClass() {
        return this.f3328s;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.f getKind() {
        return this.v;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
    public z getModality() {
        return this.w;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.e> getSealedSubclasses() {
        if (this.w != z.SEALED) {
            return d0.t.n.emptyList();
        }
        d0.e0.p.d.m0.e.a.i0.m.a attributes$default = d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, false, null, 3, null);
        Collection<d0.e0.p.d.m0.e.a.k0.j> permittedTypes = this.f3328s.getPermittedTypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = permittedTypes.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.h declarationDescriptor = this.u.getTypeResolver().transformJavaType((d0.e0.p.d.m0.e.a.k0.j) it.next(), attributes$default).getConstructor().getDeclarationDescriptor();
            d0.e0.p.d.m0.c.e eVar = declarationDescriptor instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) declarationDescriptor : null;
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getStaticScope() {
        return this.D;
    }

    @Override // d0.e0.p.d.m0.c.h
    public u0 getTypeConstructor() {
        return this.f3331z;
    }

    @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedInnerClassesScope() {
        return this.C;
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return (h) this.B.getScope(gVar);
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.d getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public u getVisibility() {
        if (!d0.z.d.m.areEqual(this.f3329x, t.a) || this.f3328s.getOuterClass() != null) {
            return f0.toDescriptorVisibility(this.f3329x);
        }
        u uVar = w.a;
        d0.z.d.m.checkNotNullExpressionValue(uVar, "{\n            JavaDescriptorVisibilities.PACKAGE_VISIBILITY\n        }");
        return uVar;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isCompanionObject() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isData() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isFun() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i
    public boolean isInner() {
        return this.f3330y;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isValue() {
        return false;
    }

    public String toString() {
        return d0.z.d.m.stringPlus("Lazy Java class ", d0.e0.p.d.m0.k.x.a.getFqNameUnsafe(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.e.a.k0.g gVar2, d0.e0.p.d.m0.c.e eVar) {
        z zVarConvertFromFlags;
        super(gVar.getStorageManager(), mVar, gVar2.getName(), gVar.getComponents().getSourceElementFactory().source(gVar2), false);
        d0.z.d.m.checkNotNullParameter(gVar, "outerContext");
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar2, "jClass");
        this.r = gVar;
        this.f3328s = gVar2;
        this.t = eVar;
        d0.e0.p.d.m0.e.a.i0.g gVarChildForClassOrPackage$default = d0.e0.p.d.m0.e.a.i0.a.childForClassOrPackage$default(gVar, this, gVar2, 0, 4, null);
        this.u = gVarChildForClassOrPackage$default;
        ((g$a) gVarChildForClassOrPackage$default.getComponents().getJavaResolverCache()).recordClass(gVar2, this);
        gVar2.getLightClassOriginKind();
        this.v = gVar2.isAnnotationType() ? d0.e0.p.d.m0.c.f.ANNOTATION_CLASS : gVar2.isInterface() ? d0.e0.p.d.m0.c.f.INTERFACE : gVar2.isEnum() ? d0.e0.p.d.m0.c.f.ENUM_CLASS : d0.e0.p.d.m0.c.f.CLASS;
        if (gVar2.isAnnotationType() || gVar2.isEnum()) {
            zVarConvertFromFlags = z.FINAL;
        } else {
            zVarConvertFromFlags = z.j.convertFromFlags(false, gVar2.isSealed() || gVar2.isAbstract() || gVar2.isInterface(), !gVar2.isFinal());
        }
        this.w = zVarConvertFromFlags;
        this.f3329x = gVar2.getVisibility();
        this.f3330y = (gVar2.getOuterClass() == null || gVar2.isStatic()) ? false : true;
        this.f3331z = new f$b(this);
        h hVar = new h(gVarChildForClassOrPackage$default, this, gVar2, eVar != null, null, 16, null);
        this.A = hVar;
        this.B = r0.a.create(this, gVarChildForClassOrPackage$default.getStorageManager(), gVarChildForClassOrPackage$default.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new f$d(this));
        this.C = new d0.e0.p.d.m0.k.a0.g(hVar);
        this.D = new o(gVarChildForClassOrPackage$default, gVar2, this);
        this.E = d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(gVarChildForClassOrPackage$default, gVar2);
        this.F = gVarChildForClassOrPackage$default.getStorageManager().createLazyValue(new f$c(this));
    }

    @Override // d0.e0.p.d.m0.c.e
    public List<d0.e0.p.d.m0.c.d> getConstructors() {
        return this.A.getConstructors$descriptors_jvm().invoke();
    }

    @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope() {
        return getUnsubstitutedMemberScope();
    }

    @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.e
    public h getUnsubstitutedMemberScope() {
        return (h) super.getUnsubstitutedMemberScope();
    }
}
