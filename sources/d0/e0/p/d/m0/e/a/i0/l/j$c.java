package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.e.a.k0.c0;
import d0.e0.p.d.m0.e.a.s$a;
import d0.e0.p.d.m0.e.b.n$a;
import d0.e0.p.d.m0.e.b.n$a$a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$c extends d0.z.d.o implements Function1<j$a, d0.e0.p.d.m0.c.e> {
    public final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g $c;
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$c(j jVar, d0.e0.p.d.m0.e.a.i0.g gVar) {
        super(1);
        this.this$0 = jVar;
        this.$c = gVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke(j$a j_a) {
        return invoke2(j_a);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0091  */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.c.e invoke2(j$a j_a) {
        byte[] content;
        d0.z.d.m.checkNotNullParameter(j_a, "request");
        d0.e0.p.d.m0.g.a aVar = new d0.e0.p.d.m0.g.a(this.this$0.o.getFqName(), j_a.getName());
        n$a n_aFindKotlinClassOrContent = j_a.getJavaClass() != null ? this.$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(j_a.getJavaClass()) : this.$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(aVar);
        d0.e0.p.d.m0.e.b.p kotlinJvmBinaryClass = n_aFindKotlinClassOrContent == null ? null : n_aFindKotlinClassOrContent.toKotlinJvmBinaryClass();
        d0.e0.p.d.m0.g.a classId = kotlinJvmBinaryClass == null ? null : kotlinJvmBinaryClass.getClassId();
        if (classId != null && (classId.isNestedClass() || classId.isLocal())) {
            return null;
        }
        j$b j_bAccess$resolveKotlinBinaryClass = j.access$resolveKotlinBinaryClass(this.this$0, kotlinJvmBinaryClass);
        if (j_bAccess$resolveKotlinBinaryClass instanceof j$b$a) {
            return ((j$b$a) j_bAccess$resolveKotlinBinaryClass).getDescriptor();
        }
        if (j_bAccess$resolveKotlinBinaryClass instanceof j$b$c) {
            return null;
        }
        if (!(j_bAccess$resolveKotlinBinaryClass instanceof j$b$b)) {
            throw new NoWhenBranchMatchedException();
        }
        d0.e0.p.d.m0.e.a.k0.g javaClass = j_a.getJavaClass();
        if (javaClass == null) {
            d0.e0.p.d.m0.e.a.s finder = this.$c.getComponents().getFinder();
            if (n_aFindKotlinClassOrContent != null) {
                if (!(n_aFindKotlinClassOrContent instanceof n$a$a)) {
                    n_aFindKotlinClassOrContent = null;
                }
                n$a$a n_a_a = (n$a$a) n_aFindKotlinClassOrContent;
                if (n_a_a == null) {
                    content = null;
                } else {
                    content = n_a_a.getContent();
                }
            } else {
                content = null;
            }
            javaClass = finder.findClass(new s$a(aVar, content, null, 4, null));
        }
        d0.e0.p.d.m0.e.a.k0.g gVar = javaClass;
        if ((gVar == null ? null : gVar.getLightClassOriginKind()) != c0.BINARY) {
            d0.e0.p.d.m0.g.b fqName = gVar == null ? null : gVar.getFqName();
            if (fqName == null || fqName.isRoot() || !d0.z.d.m.areEqual(fqName.parent(), this.this$0.o.getFqName())) {
                return null;
            }
            f fVar = new f(this.$c, this.this$0.o, gVar, null, 8, null);
            this.$c.getComponents().getJavaClassesTracker().reportClass(fVar);
            return fVar;
        }
        throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + aVar + "\nfindKotlinClass(JavaClass) = " + d0.e0.p.d.m0.e.b.o.findKotlinClass(this.$c.getComponents().getKotlinClassFinder(), gVar) + "\nfindKotlinClass(ClassId) = " + d0.e0.p.d.m0.e.b.o.findKotlinClass(this.$c.getComponents().getKotlinClassFinder(), aVar) + '\n');
    }
}
