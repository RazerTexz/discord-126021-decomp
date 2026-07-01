package j0.l.a;

import rx.Emitter;
import rx.Emitter$BackpressureMode;
import rx.Observable$a;
import rx.Subscriber;
import rx.functions.Action1;

/* JADX INFO: compiled from: OnSubscribeCreate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i<T> implements Observable$a<T> {
    public final Action1<Emitter<T>> j;
    public final Emitter$BackpressureMode k;

    public i(Action1<Emitter<T>> action1, Emitter$BackpressureMode emitter$BackpressureMode) {
        this.j = action1;
        this.k = emitter$BackpressureMode;
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
    @Override // rx.functions.Action1
    public void call(Object obj) {
        i$a i_g;
        Subscriber subscriber = (Subscriber) obj;
        int iOrdinal = this.k.ordinal();
        if (iOrdinal == 0) {
            i_g = new i$g(subscriber);
        } else if (iOrdinal == 1) {
            i_g = new i$d(subscriber);
        } else if (iOrdinal != 3) {
            i_g = iOrdinal != 4 ? new i$b(subscriber, j0.l.e.i.j) : new i$e(subscriber);
        } else {
            i_g = new i$c(subscriber);
        }
        subscriber.add(i_g);
        subscriber.setProducer(i_g);
        this.j.call(i_g);
    }
}
