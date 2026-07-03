package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.o0 */
/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11991o0 extends AbstractC12014x0 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11477z0 f24848a;

    /* JADX INFO: renamed from: b */
    public final Lazy f24849b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.o0$a */
    /* JADX INFO: compiled from: StarProjectionImpl.kt */
    public static final class a extends AbstractC12240o implements Function0<AbstractC11913c0> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AbstractC11913c0 invoke() {
            return C11994p0.starProjectionType(C11991o0.this.f24848a);
        }
    }

    public C11991o0(InterfaceC11477z0 interfaceC11477z0) {
        C12238m.checkNotNullParameter(interfaceC11477z0, "typeParameter");
        this.f24848a = interfaceC11477z0;
        this.f24849b = C12083g.lazy(EnumC12110i.PUBLICATION, new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public EnumC11935j1 getProjectionKind() {
        return EnumC11935j1.OUT_VARIANCE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public AbstractC11913c0 getType() {
        return (AbstractC11913c0) this.f24849b.getValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public boolean isStarProjection() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public InterfaceC12012w0 refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return this;
    }
}
