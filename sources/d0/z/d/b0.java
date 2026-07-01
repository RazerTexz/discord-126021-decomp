package d0.z.d;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class b0 {
    public KFunction function(j jVar) {
        return jVar;
    }

    public d0.e0.c getOrCreateKotlinClass(Class cls) {
        return new f(cls);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new u(cls, str);
    }

    public KMutableProperty0 mutableProperty0(p pVar) {
        return pVar;
    }

    public d0.e0.e mutableProperty1(r rVar) {
        return rVar;
    }

    public KProperty0 property0(v vVar) {
        return vVar;
    }

    public d0.e0.g property1(x xVar) {
        return xVar;
    }

    public String renderLambdaToString(o oVar) {
        return renderLambdaToString((i) oVar);
    }

    public String renderLambdaToString(i iVar) {
        String string = iVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
