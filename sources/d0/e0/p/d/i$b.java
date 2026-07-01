package d0.e0.p.d;

import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i$b {
    public static final /* synthetic */ KProperty[] a = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(i$b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0$a f3199b = c0.lazySoft(new i$b$a(this));
    public final /* synthetic */ i c;

    public i$b(i iVar) {
        this.c = iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d0.e0.p.d.m0.c.k1.a.k getModuleData() {
        return (d0.e0.p.d.m0.c.k1.a.k) this.f3199b.getValue(this, a[0]);
    }
}
