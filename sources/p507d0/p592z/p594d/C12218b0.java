package p507d0.p592z.p594d;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p513e0.InterfaceC11232e;
import p507d0.p513e0.InterfaceC11234g;

/* JADX INFO: renamed from: d0.z.d.b0 */
/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12218b0 {
    public KFunction function(C12235j c12235j) {
        return c12235j;
    }

    public InterfaceC11230c getOrCreateKotlinClass(Class cls) {
        return new C12225f(cls);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new C12246u(cls, str);
    }

    public KMutableProperty0 mutableProperty0(AbstractC12241p abstractC12241p) {
        return abstractC12241p;
    }

    public InterfaceC11232e mutableProperty1(AbstractC12243r abstractC12243r) {
        return abstractC12243r;
    }

    public KProperty0 property0(AbstractC12247v abstractC12247v) {
        return abstractC12247v;
    }

    public InterfaceC11234g property1(AbstractC12249x abstractC12249x) {
        return abstractC12249x;
    }

    public String renderLambdaToString(AbstractC12240o abstractC12240o) {
        return renderLambdaToString((InterfaceC12234i) abstractC12240o);
    }

    public String renderLambdaToString(InterfaceC12234i interfaceC12234i) {
        String string = interfaceC12234i.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
