package d0.z.d;

import d0.e0.KClass;
import d0.e0.KProperty2;
import d0.e0.KProperty3;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty5;
import kotlin.reflect.KProperty6;

/* JADX INFO: renamed from: d0.z.d.a0, reason: use source file name */
/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes3.dex */
public class Reflection2 {
    public static final ReflectionFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KClass[] f3592b;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("d0.e0.p.d.d0").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        a = reflectionFactory;
        f3592b = new KClass[0];
    }

    public static KFunction function(FunctionReference functionReference) {
        return a.function(functionReference);
    }

    public static KClass getOrCreateKotlinClass(Class cls) {
        return a.getOrCreateKotlinClass(cls);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls) {
        return a.getOrCreateKotlinPackage(cls, "");
    }

    public static KProperty5 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return a.mutableProperty0(mutablePropertyReference0);
    }

    public static KProperty2 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return a.mutableProperty1(mutablePropertyReference1);
    }

    public static KProperty6 property0(PropertyReference0 propertyReference0) {
        return a.property0(propertyReference0);
    }

    public static KProperty3 property1(PropertyReference1 propertyReference1) {
        return a.property1(propertyReference1);
    }

    public static String renderLambdaToString(Lambda lambda) {
        return a.renderLambdaToString(lambda);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return a.getOrCreateKotlinPackage(cls, str);
    }

    public static String renderLambdaToString(FunctionBase functionBase) {
        return a.renderLambdaToString(functionBase);
    }
}
