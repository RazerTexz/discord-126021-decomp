package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.f0 */
/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11922f0 extends AbstractC11938k1 {

    /* JADX INFO: renamed from: k */
    public final InterfaceC11905o f24769k;

    /* JADX INFO: renamed from: l */
    public final Function0<AbstractC11913c0> f24770l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC11900j<AbstractC11913c0> f24771m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.f0$a */
    /* JADX INFO: compiled from: SpecialTypes.kt */
    public static final class a extends AbstractC12240o implements Function0<AbstractC11913c0> {
        public final /* synthetic */ AbstractC11947g $kotlinTypeRefiner;
        public final /* synthetic */ C11922f0 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC11947g abstractC11947g, C11922f0 c11922f0) {
            super(0);
            this.$kotlinTypeRefiner = abstractC11947g;
            this.this$0 = c11922f0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AbstractC11913c0 invoke() {
            return this.$kotlinTypeRefiner.refineType((AbstractC11913c0) this.this$0.f24770l.invoke());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11922f0(InterfaceC11905o interfaceC11905o, Function0<? extends AbstractC11913c0> function0) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(function0, "computation");
        this.f24769k = interfaceC11905o;
        this.f24770l = function0;
        this.f24771m = interfaceC11905o.createLazyValue(function0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11938k1
    /* JADX INFO: renamed from: a */
    public AbstractC11913c0 mo10011a() {
        return this.f24771m.invoke();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11938k1
    public boolean isComputed() {
        return ((C11896f.h) this.f24771m).isComputed();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public C11922f0 refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return new C11922f0(this.f24769k, new a(abstractC11947g, this));
    }
}
