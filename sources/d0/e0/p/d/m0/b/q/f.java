package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.c0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.y;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends d0.e0.p.d.m0.b.h {
    public static final /* synthetic */ KProperty<Object>[] f = {a0.property1(new y(a0.getOrCreateKotlinClass(f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    public Function0<f$b> g;
    public final d0.e0.p.d.m0.m.j h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d0.e0.p.d.m0.m.o oVar, f$a f_a) {
        super(oVar);
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(f_a, "kind");
        this.h = oVar.createLazyValue(new f$c(this, oVar));
        int iOrdinal = f_a.ordinal();
        if (iOrdinal == 1) {
            d(false);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            d(true);
        }
    }

    public static final /* synthetic */ Function0 access$getSettingsComputation$p(f fVar) {
        return fVar.g;
    }

    public static final /* synthetic */ void access$setSettingsComputation$p(f fVar, Function0 function0) {
        fVar.g = function0;
    }

    @Override // d0.e0.p.d.m0.b.h
    public d0.e0.p.d.m0.c.h1.a e() {
        return getCustomizer();
    }

    @Override // d0.e0.p.d.m0.b.h
    public Iterable g() {
        Iterable<d0.e0.p.d.m0.c.h1.b> iterableG = super.g();
        d0.z.d.m.checkNotNullExpressionValue(iterableG, "super.getClassDescriptorFactories()");
        d0.e0.p.d.m0.m.o oVar = this.e;
        if (oVar == null) {
            d0.e0.p.d.m0.b.h.a(5);
            throw null;
        }
        d0.z.d.m.checkNotNullExpressionValue(oVar, "storageManager");
        d0.e0.p.d.m0.c.i1.y builtInsModule = getBuiltInsModule();
        d0.z.d.m.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
        return u.plus(iterableG, new e(oVar, builtInsModule, null, 4, null));
    }

    public final g getCustomizer() {
        return (g) d0.e0.p.d.m0.m.n.getValue(this.h, this, (KProperty<?>) f[0]);
    }

    @Override // d0.e0.p.d.m0.b.h
    public d0.e0.p.d.m0.c.h1.c h() {
        return getCustomizer();
    }

    public final void initialize(c0 c0Var, boolean z2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
        setPostponedSettingsComputation(new f$d(c0Var, z2));
    }

    public final void setPostponedSettingsComputation(Function0<f$b> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "computation");
        Function0<f$b> function1 = this.g;
        this.g = function0;
    }
}
