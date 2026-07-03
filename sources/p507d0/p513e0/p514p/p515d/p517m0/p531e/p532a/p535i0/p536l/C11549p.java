package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.p */
/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11549p implements C12034b.c<InterfaceC11330e> {

    /* JADX INFO: renamed from: a */
    public static final C11549p f23413a = new C11549p();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.p$a */
    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    public static final class a extends AbstractC12240o implements Function1<AbstractC11913c0, InterfaceC11330e> {

        /* JADX INFO: renamed from: j */
        public static final a f23414j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11330e invoke(AbstractC11913c0 abstractC11913c0) {
            InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof InterfaceC11330e) {
                return (InterfaceC11330e) declarationDescriptor;
            }
            return null;
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.c
    public final Iterable<InterfaceC11330e> getNeighbors(InterfaceC11330e interfaceC11330e) {
        Collection<AbstractC11913c0> supertypes = interfaceC11330e.getTypeConstructor().getSupertypes();
        C12238m.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        return C12078q.asIterable(C12078q.mapNotNull(C12163u.asSequence(supertypes), a.f23414j));
    }
}
