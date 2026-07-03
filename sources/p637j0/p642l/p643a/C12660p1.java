package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.p1 */
/* JADX INFO: compiled from: OperatorScan.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12660p1<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public boolean f26981j;

    /* JADX INFO: renamed from: k */
    public R f26982k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Subscriber f26983l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C12656o1 f26984m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12660p1(C12656o1 c12656o1, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f26984m = c12656o1;
        this.f26983l = subscriber2;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f26983l.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f26983l.onError(th);
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
    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        R r;
        if (this.f26981j) {
            try {
                r = (T) this.f26984m.f26959l.call(this.f26982k, t);
            } catch (Throwable th) {
                C3404f.m4329p1(th, this.f26983l, t);
                return;
            }
        } else {
            this.f26981j = true;
            r = t;
        }
        this.f26982k = r;
        this.f26983l.onNext(r);
    }
}
