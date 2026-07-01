package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.b.ReflectionTypes;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.e0.p.d.m0.o.b;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements b {
    public static final e a = new e();

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        ValueParameterDescriptor valueParameterDescriptor = functionDescriptor.getValueParameters().get(1);
        ReflectionTypes.b bVar = ReflectionTypes.a;
        Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "secondParameter");
        KotlinType kotlinTypeCreateKPropertyStarType = bVar.createKPropertyStarType(DescriptorUtils2.getModule(valueParameterDescriptor));
        if (kotlinTypeCreateKPropertyStarType == null) {
            return false;
        }
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "secondParameter.type");
        return TypeUtils2.isSubtypeOf(kotlinTypeCreateKPropertyStarType, TypeUtils2.makeNotNullable(type));
    }

    @Override // d0.e0.p.d.m0.o.b
    public String getDescription() {
        return "second parameter must be of type KProperty<*> or its supertype";
    }

    @Override // d0.e0.p.d.m0.o.b
    public String invoke(FunctionDescriptor functionDescriptor) {
        return b.a.invoke(this, functionDescriptor);
    }
}
