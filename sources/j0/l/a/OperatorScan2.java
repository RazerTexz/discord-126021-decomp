package j0.l.a;

import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.p1, reason: use source file name */
/* JADX INFO: compiled from: OperatorScan.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorScan2<T> extends Subscriber<T> {
    public boolean j;
    public R k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ OperatorScan m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorScan2(OperatorScan operatorScan, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.m = operatorScan;
        this.l = subscriber2;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.l.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.l.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // j0.Observer2
    public void onNext(T t) {
        R r;
        if (this.j) {
            try {
                r = (T) this.m.l.call(this.k, t);
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, this.l, t);
                return;
            }
        } else {
            this.j = true;
            r = t;
        }
        this.k = r;
        this.l.onNext(r);
    }
}
