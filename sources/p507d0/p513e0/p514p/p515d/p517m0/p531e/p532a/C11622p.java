package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.C11515f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.C11558f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.C11559g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11793k;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.InterfaceC11788f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.p */
/* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11622p implements InterfaceC11788f {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.p$a */
    /* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f23514a;

        static {
            C11793k.d.a.values();
            f23514a = new int[]{1, 0, 0};
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.p$b */
    /* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC11326c1, AbstractC11913c0> {

        /* JADX INFO: renamed from: j */
        public static final b f23515j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final AbstractC11913c0 invoke(InterfaceC11326c1 interfaceC11326c1) {
            return interfaceC11326c1.getType();
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.InterfaceC11788f
    public InterfaceC11788f.a getContract() {
        return InterfaceC11788f.a.SUCCESS_ONLY;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.InterfaceC11788f
    public InterfaceC11788f.b isOverridable(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2, InterfaceC11330e interfaceC11330e) {
        boolean z2;
        InterfaceC11318a interfaceC11318aSubstitute;
        InterfaceC11788f.b bVar = InterfaceC11788f.b.UNKNOWN;
        C12238m.checkNotNullParameter(interfaceC11318a, "superDescriptor");
        C12238m.checkNotNullParameter(interfaceC11318a2, "subDescriptor");
        if (!(interfaceC11318a2 instanceof C11515f)) {
            return bVar;
        }
        C11515f c11515f = (C11515f) interfaceC11318a2;
        List<InterfaceC11477z0> typeParameters = c11515f.getTypeParameters();
        C12238m.checkNotNullExpressionValue(typeParameters, "subDescriptor.typeParameters");
        if (!typeParameters.isEmpty()) {
            return bVar;
        }
        C11793k.d basicOverridabilityProblem = C11793k.getBasicOverridabilityProblem(interfaceC11318a, interfaceC11318a2);
        if ((basicOverridabilityProblem == null ? null : basicOverridabilityProblem.getResult()) != null) {
            return bVar;
        }
        List<InterfaceC11326c1> valueParameters = c11515f.getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters, "subDescriptor.valueParameters");
        Sequence map = C12078q.map(C12163u.asSequence(valueParameters), b.f23515j);
        AbstractC11913c0 returnType = c11515f.getReturnType();
        C12238m.checkNotNull(returnType);
        Sequence sequencePlus = C12078q.plus((Sequence<? extends AbstractC11913c0>) map, returnType);
        InterfaceC11459q0 extensionReceiverParameter = c11515f.getExtensionReceiverParameter();
        Iterator it = C12078q.plus(sequencePlus, (Iterable) C12147n.listOfNotNull(extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null)).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            AbstractC11913c0 abstractC11913c0 = (AbstractC11913c0) it.next();
            if ((abstractC11913c0.getArguments().isEmpty() ^ true) && !(abstractC11913c0.unwrap() instanceof C11559g)) {
                z2 = true;
                break;
            }
        }
        if (z2 || (interfaceC11318aSubstitute = interfaceC11318a.substitute(C11558f.f23432b.buildSubstitutor())) == null) {
            return bVar;
        }
        if (interfaceC11318aSubstitute instanceof InterfaceC11465t0) {
            InterfaceC11465t0 interfaceC11465t0 = (InterfaceC11465t0) interfaceC11318aSubstitute;
            List<InterfaceC11477z0> typeParameters2 = interfaceC11465t0.getTypeParameters();
            C12238m.checkNotNullExpressionValue(typeParameters2, "erasedSuper.typeParameters");
            if (!typeParameters2.isEmpty()) {
                interfaceC11318aSubstitute = (InterfaceC11465t0) interfaceC11465t0.newCopyBuilder().setTypeParameters(C12147n.emptyList()).build();
                C12238m.checkNotNull(interfaceC11318aSubstitute);
            }
        }
        C11793k.d.a result = C11793k.f24411b.isOverridableByWithoutExternalConditions(interfaceC11318aSubstitute, interfaceC11318a2, false).getResult();
        C12238m.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).result");
        return a.f23514a[result.ordinal()] == 1 ? InterfaceC11788f.b.OVERRIDABLE : bVar;
    }
}
