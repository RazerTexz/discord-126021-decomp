package d0.e0.p.d;

import java.io.IOException;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: ReflectionFactoryImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class d0 extends d0.z.d.b0 {
    public static i a(d0.z.d.d dVar) {
        KDeclarationContainer owner = dVar.getOwner();
        return owner instanceof i ? (i) owner : b.m;
    }

    @Override // d0.z.d.b0
    public KFunction function(d0.z.d.j jVar) {
        return new j(a(jVar), jVar.getName(), jVar.getSignature(), jVar.getBoundReceiver());
    }

    @Override // d0.z.d.b0
    public d0.e0.c getOrCreateKotlinClass(Class cls) {
        return g.getOrCreateKotlinClass(cls);
    }

    @Override // d0.z.d.b0
    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new n(cls, str);
    }

    @Override // d0.z.d.b0
    public KMutableProperty0 mutableProperty0(d0.z.d.p pVar) {
        return new k(a(pVar), pVar.getName(), pVar.getSignature(), pVar.getBoundReceiver());
    }

    @Override // d0.z.d.b0
    public d0.e0.e mutableProperty1(d0.z.d.r rVar) {
        return new l(a(rVar), rVar.getName(), rVar.getSignature(), rVar.getBoundReceiver());
    }

    @Override // d0.z.d.b0
    public KProperty0 property0(d0.z.d.v vVar) {
        return new p(a(vVar), vVar.getName(), vVar.getSignature(), vVar.getBoundReceiver());
    }

    @Override // d0.z.d.b0
    public d0.e0.g property1(d0.z.d.x xVar) {
        return new q(a(xVar), xVar.getName(), xVar.getSignature(), xVar.getBoundReceiver());
    }

    @Override // d0.z.d.b0
    public String renderLambdaToString(d0.z.d.o oVar) {
        return renderLambdaToString((d0.z.d.i) oVar);
    }

    @Override // d0.z.d.b0
    public String renderLambdaToString(d0.z.d.i iVar) throws IOException {
        j jVarAsKFunctionImpl;
        KFunction kFunctionReflect = d0.e0.p.c.reflect(iVar);
        return (kFunctionReflect == null || (jVarAsKFunctionImpl = j0.asKFunctionImpl(kFunctionReflect)) == null) ? super.renderLambdaToString(iVar) : e0.f3197b.renderLambda(jVarAsKFunctionImpl.getDescriptor());
    }
}
