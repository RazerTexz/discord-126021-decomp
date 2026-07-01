package d0.e0.p.d;

import d0.e0.KClass;
import d0.e0.KProperty2;
import d0.e0.KProperty3;
import d0.e0.p.reflectLambda;
import d0.z.d.CallableReference;
import d0.z.d.FunctionBase;
import d0.z.d.FunctionReference;
import d0.z.d.Lambda;
import d0.z.d.MutablePropertyReference0;
import d0.z.d.MutablePropertyReference1;
import d0.z.d.PropertyReference0;
import d0.z.d.PropertyReference1;
import d0.z.d.ReflectionFactory;
import java.io.IOException;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty5;
import kotlin.reflect.KProperty6;

/* JADX INFO: renamed from: d0.e0.p.d.d0, reason: use source file name */
/* JADX INFO: compiled from: ReflectionFactoryImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReflectionFactoryImpl extends ReflectionFactory {
    public static KDeclarationContainerImpl a(CallableReference callableReference) {
        KDeclarationContainer owner = callableReference.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : EmptyContainerForLocal.m;
    }

    @Override // d0.z.d.ReflectionFactory
    public KFunction function(FunctionReference functionReference) {
        return new KFunctionImpl(a(functionReference), functionReference.getName(), functionReference.getSignature(), functionReference.getBoundReceiver());
    }

    @Override // d0.z.d.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class cls) {
        return kClassCache.getOrCreateKotlinClass(cls);
    }

    @Override // d0.z.d.ReflectionFactory
    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new KPackageImpl(cls, str);
    }

    @Override // d0.z.d.ReflectionFactory
    public KProperty5 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return new KProperty0Impl(a(mutablePropertyReference0), mutablePropertyReference0.getName(), mutablePropertyReference0.getSignature(), mutablePropertyReference0.getBoundReceiver());
    }

    @Override // d0.z.d.ReflectionFactory
    public KProperty2 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return new KProperty1Impl(a(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    @Override // d0.z.d.ReflectionFactory
    public KProperty6 property0(PropertyReference0 propertyReference0) {
        return new KProperty0Impl2(a(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    @Override // d0.z.d.ReflectionFactory
    public KProperty3 property1(PropertyReference1 propertyReference1) {
        return new KProperty1Impl2(a(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    @Override // d0.z.d.ReflectionFactory
    public String renderLambdaToString(Lambda lambda) {
        return renderLambdaToString((FunctionBase) lambda);
    }

    @Override // d0.z.d.ReflectionFactory
    public String renderLambdaToString(FunctionBase functionBase) throws IOException {
        KFunctionImpl kFunctionImplAsKFunctionImpl;
        KFunction kFunctionReflect = reflectLambda.reflect(functionBase);
        return (kFunctionReflect == null || (kFunctionImplAsKFunctionImpl = util2.asKFunctionImpl(kFunctionReflect)) == null) ? super.renderLambdaToString(functionBase) : ReflectionObjectRenderer.f3197b.renderLambda(kFunctionImplAsKFunctionImpl.getDescriptor());
    }
}
