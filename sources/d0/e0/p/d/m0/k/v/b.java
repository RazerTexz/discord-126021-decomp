package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends g<List<? extends g<?>>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<ModuleDescriptor2, KotlinType> f3471b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends g<?>> list, Function1<? super ModuleDescriptor2, ? extends KotlinType> function1) {
        super(list);
        Intrinsics3.checkNotNullParameter(list, "value");
        Intrinsics3.checkNotNullParameter(function1, "computeType");
        this.f3471b = function1;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType kotlinTypeInvoke = this.f3471b.invoke(moduleDescriptor2);
        if (!KotlinBuiltIns.isArray(kotlinTypeInvoke) && !KotlinBuiltIns.isPrimitiveArray(kotlinTypeInvoke)) {
            KotlinBuiltIns.isUnsignedArrayType(kotlinTypeInvoke);
        }
        return kotlinTypeInvoke;
    }
}
