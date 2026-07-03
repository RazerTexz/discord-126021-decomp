package p507d0.p513e0.p514p.p515d;

import java.io.IOException;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p513e0.InterfaceC11232e;
import p507d0.p513e0.InterfaceC11234g;
import p507d0.p513e0.p514p.C11245c;
import p507d0.p592z.p594d.AbstractC12221d;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.AbstractC12241p;
import p507d0.p592z.p594d.AbstractC12243r;
import p507d0.p592z.p594d.AbstractC12247v;
import p507d0.p592z.p594d.AbstractC12249x;
import p507d0.p592z.p594d.C12218b0;
import p507d0.p592z.p594d.C12235j;
import p507d0.p592z.p594d.InterfaceC12234i;

/* JADX INFO: renamed from: d0.e0.p.d.d0 */
/* JADX INFO: compiled from: ReflectionFactoryImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11253d0 extends C12218b0 {
    /* JADX INFO: renamed from: a */
    public static AbstractC11262i m9333a(AbstractC12221d abstractC12221d) {
        KDeclarationContainer owner = abstractC12221d.getOwner();
        return owner instanceof AbstractC11262i ? (AbstractC11262i) owner : C11248b.f22320m;
    }

    @Override // p507d0.p592z.p594d.C12218b0
    public KFunction function(C12235j c12235j) {
        return new C11264j(m9333a(c12235j), c12235j.getName(), c12235j.getSignature(), c12235j.getBoundReceiver());
    }

    @Override // p507d0.p592z.p594d.C12218b0
    public InterfaceC11230c getOrCreateKotlinClass(Class cls) {
        return C11258g.getOrCreateKotlinClass(cls);
    }

    @Override // p507d0.p592z.p594d.C12218b0
    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new C12043n(cls, str);
    }

    @Override // p507d0.p592z.p594d.C12218b0
    public KMutableProperty0 mutableProperty0(AbstractC12241p abstractC12241p) {
        return new C11266k(m9333a(abstractC12241p), abstractC12241p.getName(), abstractC12241p.getSignature(), abstractC12241p.getBoundReceiver());
    }

    @Override // p507d0.p592z.p594d.C12218b0
    public InterfaceC11232e mutableProperty1(AbstractC12243r abstractC12243r) {
        return new C11268l(m9333a(abstractC12243r), abstractC12243r.getName(), abstractC12243r.getSignature(), abstractC12243r.getBoundReceiver());
    }

    @Override // p507d0.p592z.p594d.C12218b0
    public KProperty0 property0(AbstractC12247v abstractC12247v) {
        return new C12050p(m9333a(abstractC12247v), abstractC12247v.getName(), abstractC12247v.getSignature(), abstractC12247v.getBoundReceiver());
    }

    @Override // p507d0.p592z.p594d.C12218b0
    public InterfaceC11234g property1(AbstractC12249x abstractC12249x) {
        return new C12051q(m9333a(abstractC12249x), abstractC12249x.getName(), abstractC12249x.getSignature(), abstractC12249x.getBoundReceiver());
    }

    @Override // p507d0.p592z.p594d.C12218b0
    public String renderLambdaToString(AbstractC12240o abstractC12240o) {
        return renderLambdaToString((InterfaceC12234i) abstractC12240o);
    }

    @Override // p507d0.p592z.p594d.C12218b0
    public String renderLambdaToString(InterfaceC12234i interfaceC12234i) throws IOException {
        C11264j c11264jAsKFunctionImpl;
        KFunction kFunctionReflect = C11245c.reflect(interfaceC12234i);
        return (kFunctionReflect == null || (c11264jAsKFunctionImpl = C11265j0.asKFunctionImpl(kFunctionReflect)) == null) ? super.renderLambdaToString(interfaceC12234i) : C11255e0.f22349b.renderLambda(c11264jAsKFunctionImpl.getDescriptor());
    }
}
