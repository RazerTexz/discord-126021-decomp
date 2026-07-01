package j0.l.a;

import rx.Observable;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorZip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q2$c extends Subscriber<Observable[]> {
    public final Subscriber<? super R> j;
    public final q2$a<R> k;
    public final q2$b<R> l;
    public boolean m;

    public q2$c(q2 q2Var, Subscriber<? super R> subscriber, q2$a<R> q2_a, q2$b<R> q2_b) {
        this.j = subscriber;
        this.k = q2_a;
        this.l = q2_b;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.m) {
            return;
        }
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // j0.g
    public void onNext(Object obj) {
        Observable[] observableArr = (Observable[]) obj;
        if (observableArr == null || observableArr.length == 0) {
            this.j.onCompleted();
        } else {
            this.m = true;
            this.k.a(observableArr, this.l);
        }
    }
}
