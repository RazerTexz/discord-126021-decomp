package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.k0 */
/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11937k0 extends AbstractC11934j0 {

    /* JADX INFO: renamed from: k */
    public final InterfaceC12008u0 f24791k;

    /* JADX INFO: renamed from: l */
    public final List<InterfaceC12012w0> f24792l;

    /* JADX INFO: renamed from: m */
    public final boolean f24793m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC11770i f24794n;

    /* JADX INFO: renamed from: o */
    public final Function1<AbstractC11947g, AbstractC11934j0> f24795o;

    /* JADX WARN: Multi-variable type inference failed */
    public C11937k0(InterfaceC12008u0 interfaceC12008u0, List<? extends InterfaceC12012w0> list, boolean z2, InterfaceC11770i interfaceC11770i, Function1<? super AbstractC11947g, ? extends AbstractC11934j0> function1) {
        C12238m.checkNotNullParameter(interfaceC12008u0, "constructor");
        C12238m.checkNotNullParameter(list, "arguments");
        C12238m.checkNotNullParameter(interfaceC11770i, "memberScope");
        C12238m.checkNotNullParameter(function1, "refinedTypeFactory");
        this.f24791k = interfaceC12008u0;
        this.f24792l = list;
        this.f24793m = z2;
        this.f24794n = interfaceC11770i;
        this.f24795o = function1;
        if (getMemberScope() instanceof C12005t.d) {
            StringBuilder sbM833U = C1643a.m833U("SimpleTypeImpl should not be created for error type: ");
            sbM833U.append(getMemberScope());
            sbM833U.append('\n');
            sbM833U.append(getConstructor());
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return InterfaceC11344g.f22735f.getEMPTY();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public List<InterfaceC12012w0> getArguments() {
        return this.f24792l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC12008u0 getConstructor() {
        return this.f24791k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC11770i getMemberScope() {
        return this.f24794n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public boolean isMarkedNullable() {
        return this.f24793m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11934j0 makeNullableAsSpecified(boolean z2) {
        if (z2 == isMarkedNullable()) {
            return this;
        }
        return z2 ? new C11928h0(this) : new C11925g0(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11934j0 replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return interfaceC11344g.isEmpty() ? this : new C11927h(this, interfaceC11344g);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public AbstractC11934j0 refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        AbstractC11934j0 abstractC11934j0Invoke = this.f24795o.invoke(abstractC11947g);
        return abstractC11934j0Invoke == null ? this : abstractC11934j0Invoke;
    }
}
