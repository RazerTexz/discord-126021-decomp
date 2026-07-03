package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11354a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11356c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11399y;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f */
/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11306f extends AbstractC11288h {

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ KProperty<Object>[] f22640f = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11306f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};

    /* JADX INFO: renamed from: g */
    public Function0<b> f22641g;

    /* JADX INFO: renamed from: h */
    public final InterfaceC11900j f22642h;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$a */
    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public enum a {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$b */
    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final InterfaceC11325c0 f22647a;

        /* JADX INFO: renamed from: b */
        public final boolean f22648b;

        public b(InterfaceC11325c0 interfaceC11325c0, boolean z2) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "ownerModuleDescriptor");
            this.f22647a = interfaceC11325c0;
            this.f22648b = z2;
        }

        public final InterfaceC11325c0 getOwnerModuleDescriptor() {
            return this.f22647a;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.f22648b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$c */
    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class c extends AbstractC12240o implements Function0<C11307g> {
        public final /* synthetic */ InterfaceC11905o $storageManager;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$c$a */
        /* JADX INFO: compiled from: JvmBuiltIns.kt */
        public static final class a extends AbstractC12240o implements Function0<b> {
            public final /* synthetic */ C11306f this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(C11306f c11306f) {
                super(0);
                this.this$0 = c11306f;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                Function0 function0 = this.this$0.f22641g;
                if (function0 == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                b bVar = (b) function0.invoke();
                this.this$0.f22641g = null;
                return bVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC11905o interfaceC11905o) {
            super(0);
            this.$storageManager = interfaceC11905o;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C11307g invoke() {
            C11399y builtInsModule = C11306f.this.getBuiltInsModule();
            C12238m.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
            return new C11307g(builtInsModule, this.$storageManager, new a(C11306f.this));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$d */
    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class d extends AbstractC12240o implements Function0<b> {
        public final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
        public final /* synthetic */ InterfaceC11325c0 $moduleDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC11325c0 interfaceC11325c0, boolean z2) {
            super(0);
            this.$moduleDescriptor = interfaceC11325c0;
            this.$isAdditionalBuiltInsFeatureSupported = z2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new b(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11306f(InterfaceC11905o interfaceC11905o, a aVar) {
        super(interfaceC11905o);
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(aVar, "kind");
        this.f22642h = interfaceC11905o.createLazyValue(new c(interfaceC11905o));
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            m9361d(false);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            m9361d(true);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h
    /* JADX INFO: renamed from: e */
    public InterfaceC11354a mo9362e() {
        return getCustomizer();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h
    /* JADX INFO: renamed from: g */
    public Iterable mo9364g() {
        Iterable<InterfaceC11355b> iterableMo9364g = super.mo9364g();
        C12238m.checkNotNullExpressionValue(iterableMo9364g, "super.getClassDescriptorFactories()");
        InterfaceC11905o interfaceC11905o = this.f22463e;
        if (interfaceC11905o == null) {
            AbstractC11288h.m9355a(5);
            throw null;
        }
        C12238m.checkNotNullExpressionValue(interfaceC11905o, "storageManager");
        C11399y builtInsModule = getBuiltInsModule();
        C12238m.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
        return C12163u.plus(iterableMo9364g, new C11305e(interfaceC11905o, builtInsModule, null, 4, null));
    }

    public final C11307g getCustomizer() {
        return (C11307g) C11904n.getValue(this.f22642h, this, (KProperty<?>) f22640f[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h
    /* JADX INFO: renamed from: h */
    public InterfaceC11356c mo9365h() {
        return getCustomizer();
    }

    public final void initialize(InterfaceC11325c0 interfaceC11325c0, boolean z2) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "moduleDescriptor");
        setPostponedSettingsComputation(new d(interfaceC11325c0, z2));
    }

    public final void setPostponedSettingsComputation(Function0<b> function0) {
        C12238m.checkNotNullParameter(function0, "computation");
        Function0<b> function1 = this.f22641g;
        this.f22641g = function0;
    }
}
