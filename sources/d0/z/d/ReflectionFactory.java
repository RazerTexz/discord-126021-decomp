package d0.z.d;

import d0.e0.KClass;
import d0.e0.KProperty2;
import d0.e0.KProperty3;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty5;
import kotlin.reflect.KProperty6;

/* JADX INFO: renamed from: d0.z.d.b0, reason: use source file name */
/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReflectionFactory {
    public KFunction function(FunctionReference functionReference) {
        return functionReference;
    }

    public KClass getOrCreateKotlinClass(Class cls) {
        return new ClassReference(cls);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new PackageReference(cls, str);
    }

    public KProperty5 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public KProperty2 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public KProperty6 property0(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public KProperty3 property1(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public String renderLambdaToString(Lambda lambda) {
        return renderLambdaToString((FunctionBase) lambda);
    }

    public String renderLambdaToString(FunctionBase functionBase) {
        String string = functionBase.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
