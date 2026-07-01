package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider;
import d0.e0.p.d.m0.c.h1.ClassDescriptorFactory;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter;
import d0.e0.p.d.m0.c.i1.ModuleDescriptorImpl3;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltIns extends KotlinBuiltIns {
    public static final /* synthetic */ KProperty<Object>[] f = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    public Function0<b> g;
    public final storage5 h;

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
        public final ModuleDescriptor2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3239b;

        public b(ModuleDescriptor2 moduleDescriptor2, boolean z2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "ownerModuleDescriptor");
            this.a = moduleDescriptor2;
            this.f3239b = z2;
        }

        public final ModuleDescriptor2 getOwnerModuleDescriptor() {
            return this.a;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.f3239b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$c */
    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class c extends Lambda implements Function0<JvmBuiltInsCustomizer2> {
        public final /* synthetic */ StorageManager $storageManager;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$c$a */
        /* JADX INFO: compiled from: JvmBuiltIns.kt */
        public static final class a extends Lambda implements Function0<b> {
            public final /* synthetic */ JvmBuiltIns this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(JvmBuiltIns jvmBuiltIns) {
                super(0);
                this.this$0 = jvmBuiltIns;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                Function0 function0 = this.this$0.g;
                if (function0 == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                b bVar = (b) function0.invoke();
                this.this$0.g = null;
                return bVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(StorageManager storageManager) {
            super(0);
            this.$storageManager = storageManager;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final JvmBuiltInsCustomizer2 invoke() {
            ModuleDescriptorImpl3 builtInsModule = JvmBuiltIns.this.getBuiltInsModule();
            Intrinsics3.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
            return new JvmBuiltInsCustomizer2(builtInsModule, this.$storageManager, new a(JvmBuiltIns.this));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$d */
    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class d extends Lambda implements Function0<b> {
        public final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
        public final /* synthetic */ ModuleDescriptor2 $moduleDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ModuleDescriptor2 moduleDescriptor2, boolean z2) {
            super(0);
            this.$moduleDescriptor = moduleDescriptor2;
            this.$isAdditionalBuiltInsFeatureSupported = z2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new b(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(StorageManager storageManager, a aVar) {
        super(storageManager);
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        this.h = storageManager.createLazyValue(new c(storageManager));
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            d(false);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            d(true);
        }
    }

    @Override // d0.e0.p.d.m0.b.KotlinBuiltIns
    public AdditionalClassPartsProvider e() {
        return getCustomizer();
    }

    @Override // d0.e0.p.d.m0.b.KotlinBuiltIns
    public Iterable g() {
        Iterable<ClassDescriptorFactory> iterableG = super.g();
        Intrinsics3.checkNotNullExpressionValue(iterableG, "super.getClassDescriptorFactories()");
        StorageManager storageManager = this.e;
        if (storageManager == null) {
            KotlinBuiltIns.a(5);
            throw null;
        }
        Intrinsics3.checkNotNullExpressionValue(storageManager, "storageManager");
        ModuleDescriptorImpl3 builtInsModule = getBuiltInsModule();
        Intrinsics3.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
        return _Collections.plus(iterableG, new JvmBuiltInClassDescriptorFactory(storageManager, builtInsModule, null, 4, null));
    }

    public final JvmBuiltInsCustomizer2 getCustomizer() {
        return (JvmBuiltInsCustomizer2) storage7.getValue(this.h, this, (KProperty<?>) f[0]);
    }

    @Override // d0.e0.p.d.m0.b.KotlinBuiltIns
    public PlatformDependentDeclarationFilter h() {
        return getCustomizer();
    }

    public final void initialize(ModuleDescriptor2 moduleDescriptor2, boolean z2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        setPostponedSettingsComputation(new d(moduleDescriptor2, z2));
    }

    public final void setPostponedSettingsComputation(Function0<b> function0) {
        Intrinsics3.checkNotNullParameter(function0, "computation");
        Function0<b> function1 = this.g;
        this.g = function0;
    }
}
