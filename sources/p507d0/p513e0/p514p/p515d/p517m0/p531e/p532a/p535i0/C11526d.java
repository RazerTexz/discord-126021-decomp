package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.C11500c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11899i;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.d */
/* JADX INFO: compiled from: LazyJavaAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11526d implements InterfaceC11344g {

    /* JADX INFO: renamed from: j */
    public final C11529g f23304j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC11570d f23305k;

    /* JADX INFO: renamed from: l */
    public final boolean f23306l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC11899i<InterfaceC11564a, InterfaceC11340c> f23307m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.d$a */
    /* JADX INFO: compiled from: LazyJavaAnnotations.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11564a, InterfaceC11340c> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11340c invoke(InterfaceC11564a interfaceC11564a) {
            C12238m.checkNotNullParameter(interfaceC11564a, "annotation");
            return C11500c.f23230a.mapOrResolveJavaAnnotation(interfaceC11564a, C11526d.this.f23304j, C11526d.this.f23306l);
        }
    }

    public C11526d(C11529g c11529g, InterfaceC11570d interfaceC11570d, boolean z2) {
        C12238m.checkNotNullParameter(c11529g, "c");
        C12238m.checkNotNullParameter(interfaceC11570d, "annotationOwner");
        this.f23304j = c11529g;
        this.f23305k = interfaceC11570d;
        this.f23306l = z2;
        this.f23307m = c11529g.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public InterfaceC11340c findAnnotation(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        InterfaceC11564a interfaceC11564aFindAnnotation = this.f23305k.findAnnotation(c11713b);
        InterfaceC11340c interfaceC11340cInvoke = interfaceC11564aFindAnnotation == null ? null : this.f23307m.invoke(interfaceC11564aFindAnnotation);
        return interfaceC11340cInvoke == null ? C11500c.f23230a.findMappedJavaAnnotation(c11713b, this.f23305k, this.f23304j) : interfaceC11340cInvoke;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean hasAnnotation(C11713b c11713b) {
        return InterfaceC11344g.b.hasAnnotation(this, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean isEmpty() {
        return this.f23305k.getAnnotations().isEmpty() && !this.f23305k.isDeprecatedInJavaDoc();
    }

    @Override // java.lang.Iterable
    public Iterator<InterfaceC11340c> iterator() {
        return C12078q.filterNotNull(C12078q.plus((Sequence<? extends InterfaceC11340c>) C12078q.map(C12163u.asSequence(this.f23305k.getAnnotations()), this.f23307m), C11500c.f23230a.findMappedJavaAnnotation(C11291k.a.f22566u, this.f23305k, this.f23304j))).iterator();
    }

    public /* synthetic */ C11526d(C11529g c11529g, InterfaceC11570d interfaceC11570d, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c11529g, interfaceC11570d, (i & 4) != 0 ? false : z2);
    }
}
