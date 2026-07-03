package p637j0.p642l.p643a;

import java.util.ArrayList;
import java.util.Collection;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.C12651n0;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.m0 */
/* JADX INFO: compiled from: OperatorBufferWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12647m0 implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12651n0.a f26910j;

    public C12647m0(C12651n0.a aVar) {
        this.f26910j = aVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // p658rx.functions.Action0
    public void call() {
        C12651n0.a aVar = this.f26910j;
        synchronized (aVar) {
            if (aVar.f26939m) {
                return;
            }
            Collection collection = aVar.f26938l;
            aVar.f26938l = new ArrayList();
            try {
                aVar.f26936j.onNext(collection);
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                aVar.onError(th);
            }
        }
    }
}
