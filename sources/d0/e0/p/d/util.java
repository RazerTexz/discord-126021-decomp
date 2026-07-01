package d0.e0.p.d;

import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.i1.DeclarationDescriptorVisitorEmptyBodies;
import d0.z.d.Intrinsics3;
import kotlin.Unit;

/* JADX INFO: renamed from: d0.e0.p.d.a, reason: use source file name */
/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public class util extends DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit> {
    public final KDeclarationContainerImpl a;

    public util(KDeclarationContainerImpl kDeclarationContainerImpl) {
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        this.a = kDeclarationContainerImpl;
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorVisitorEmptyBodies, d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public KCallableImpl<?> visitFunctionDescriptor(FunctionDescriptor functionDescriptor, Unit unit) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(unit, "data");
        return new KFunctionImpl(this.a, functionDescriptor);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public KCallableImpl<?> visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Unit unit) {
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(unit, "data");
        int i = (propertyDescriptor.getDispatchReceiverParameter() != null ? 1 : 0) + (propertyDescriptor.getExtensionReceiverParameter() != null ? 1 : 0);
        if (propertyDescriptor.isVar()) {
            if (i == 0) {
                return new KProperty0Impl(this.a, propertyDescriptor);
            }
            if (i == 1) {
                return new KProperty1Impl(this.a, propertyDescriptor);
            }
            if (i == 2) {
                return new KProperty2Impl(this.a, propertyDescriptor);
            }
        } else {
            if (i == 0) {
                return new KProperty0Impl2(this.a, propertyDescriptor);
            }
            if (i == 1) {
                return new KProperty1Impl2(this.a, propertyDescriptor);
            }
            if (i == 2) {
                return new KProperty2Impl2(this.a, propertyDescriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + propertyDescriptor);
    }
}
