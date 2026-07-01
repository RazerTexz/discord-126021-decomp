package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.o.b;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements b {
    public static final h a = new h();

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "functionDescriptor.valueParameters");
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
                Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                if (!(!DescriptorUtils2.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // d0.e0.p.d.m0.o.b
    public String getDescription() {
        return "should not have varargs or parameters with default values";
    }

    @Override // d0.e0.p.d.m0.o.b
    public String invoke(FunctionDescriptor functionDescriptor) {
        return b.a.invoke(this, functionDescriptor);
    }
}
