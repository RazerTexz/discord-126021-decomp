package p507d0.p592z.p594d;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p513e0.InterfaceC11232e;
import p507d0.p513e0.InterfaceC11234g;

/* JADX INFO: renamed from: d0.z.d.a0 */
/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12216a0 {

    /* JADX INFO: renamed from: a */
    public static final C12218b0 f25275a;

    /* JADX INFO: renamed from: b */
    public static final InterfaceC11230c[] f25276b;

    static {
        C12218b0 c12218b0 = null;
        try {
            c12218b0 = (C12218b0) Class.forName("d0.e0.p.d.d0").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c12218b0 == null) {
            c12218b0 = new C12218b0();
        }
        f25275a = c12218b0;
        f25276b = new InterfaceC11230c[0];
    }

    public static KFunction function(C12235j c12235j) {
        return f25275a.function(c12235j);
    }

    public static InterfaceC11230c getOrCreateKotlinClass(Class cls) {
        return f25275a.getOrCreateKotlinClass(cls);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls) {
        return f25275a.getOrCreateKotlinPackage(cls, "");
    }

    public static KMutableProperty0 mutableProperty0(AbstractC12241p abstractC12241p) {
        return f25275a.mutableProperty0(abstractC12241p);
    }

    public static InterfaceC11232e mutableProperty1(AbstractC12243r abstractC12243r) {
        return f25275a.mutableProperty1(abstractC12243r);
    }

    public static KProperty0 property0(AbstractC12247v abstractC12247v) {
        return f25275a.property0(abstractC12247v);
    }

    public static InterfaceC11234g property1(AbstractC12249x abstractC12249x) {
        return f25275a.property1(abstractC12249x);
    }

    public static String renderLambdaToString(AbstractC12240o abstractC12240o) {
        return f25275a.renderLambdaToString(abstractC12240o);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return f25275a.getOrCreateKotlinPackage(cls, str);
    }

    public static String renderLambdaToString(InterfaceC12234i interfaceC12234i) {
        return f25275a.renderLambdaToString(interfaceC12234i);
    }
}
