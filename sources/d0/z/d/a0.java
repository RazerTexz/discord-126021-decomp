package d0.z.d;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes3.dex */
public class a0 {
    public static final b0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0.e0.c[] f3592b;

    static {
        b0 b0Var = null;
        try {
            b0Var = (b0) Class.forName("d0.e0.p.d.d0").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (b0Var == null) {
            b0Var = new b0();
        }
        a = b0Var;
        f3592b = new d0.e0.c[0];
    }

    public static KFunction function(j jVar) {
        return a.function(jVar);
    }

    public static d0.e0.c getOrCreateKotlinClass(Class cls) {
        return a.getOrCreateKotlinClass(cls);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls) {
        return a.getOrCreateKotlinPackage(cls, "");
    }

    public static KMutableProperty0 mutableProperty0(p pVar) {
        return a.mutableProperty0(pVar);
    }

    public static d0.e0.e mutableProperty1(r rVar) {
        return a.mutableProperty1(rVar);
    }

    public static KProperty0 property0(v vVar) {
        return a.property0(vVar);
    }

    public static d0.e0.g property1(x xVar) {
        return a.property1(xVar);
    }

    public static String renderLambdaToString(o oVar) {
        return a.renderLambdaToString(oVar);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return a.getOrCreateKotlinPackage(cls, str);
    }

    public static String renderLambdaToString(i iVar) {
        return a.renderLambdaToString(iVar);
    }
}
