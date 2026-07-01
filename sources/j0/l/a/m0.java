package j0.l.a;

import java.util.ArrayList;
import java.util.Collection;
import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorBufferWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public class m0 implements Action0 {
    public final /* synthetic */ n0$a j;

    public m0(n0$a n0_a) {
        this.j = n0_a;
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
    @Override // rx.functions.Action0
    public void call() {
        n0$a n0_a = this.j;
        synchronized (n0_a) {
            if (n0_a.m) {
                return;
            }
            Collection collection = n0_a.l;
            n0_a.l = new ArrayList();
            try {
                n0_a.j.onNext(collection);
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                n0_a.onError(th);
            }
        }
    }
}
