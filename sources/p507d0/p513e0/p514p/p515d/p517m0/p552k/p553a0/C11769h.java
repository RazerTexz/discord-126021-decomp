package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.h */
/* JADX INFO: compiled from: LazyScopeAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11769h extends AbstractC11762a {

    /* JADX INFO: renamed from: b */
    public final InterfaceC11900j<InterfaceC11770i> f24368b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.h$a */
    /* JADX INFO: compiled from: LazyScopeAdapter.kt */
    public static final class a extends AbstractC12240o implements Function0<InterfaceC11770i> {
        public final /* synthetic */ Function0<InterfaceC11770i> $getScope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends InterfaceC11770i> function0) {
            super(0);
            this.$getScope = function0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC11770i invoke() {
            InterfaceC11770i interfaceC11770iInvoke = this.$getScope.invoke();
            return interfaceC11770iInvoke instanceof AbstractC11762a ? ((AbstractC11762a) interfaceC11770iInvoke).getActualScope() : interfaceC11770iInvoke;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C11769h(InterfaceC11905o interfaceC11905o, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            interfaceC11905o = C11896f.f24710b;
            C12238m.checkNotNullExpressionValue(interfaceC11905o, "NO_LOCKS");
        }
        this(interfaceC11905o, function0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C11769h(Function0<? extends InterfaceC11770i> function0) {
        this(null, function0, 1, 0 == true ? 1 : 0);
        C12238m.checkNotNullParameter(function0, "getScope");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11762a
    /* JADX INFO: renamed from: a */
    public InterfaceC11770i mo9910a() {
        return this.f24368b.invoke();
    }

    public C11769h(InterfaceC11905o interfaceC11905o, Function0<? extends InterfaceC11770i> function0) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(function0, "getScope");
        this.f24368b = interfaceC11905o.createLazyValue(new a(function0));
    }
}
