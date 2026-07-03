package p637j0.p642l.p643a;

import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.t0 */
/* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12673t0<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public U f27050j;

    /* JADX INFO: renamed from: k */
    public boolean f27051k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Subscriber f27052l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C12676u0 f27053m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12673t0(C12676u0 c12676u0, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f27053m = c12676u0;
        this.f27052l = subscriber2;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27052l.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27052l.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [U, java.lang.Object] */
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
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v2 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // p637j0.InterfaceC12581g
    public void onNext(T r4) {
        /*
            r3 = this;
            j0.l.a.u0 r0 = r3.f27053m     // Catch: java.lang.Throwable -> L3c
            j0.k.b<? super T, ? extends U> r0 = r0.f27057j     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r0 = r0.call(r4)     // Catch: java.lang.Throwable -> L3c
            U r1 = r3.f27050j
            r3.f27050j = r0
            boolean r2 = r3.f27051k
            if (r2 == 0) goto L33
            j0.l.a.u0 r2 = r3.f27053m     // Catch: java.lang.Throwable -> L2c
            rx.functions.Func2<? super U, ? super U, java.lang.Boolean> r2 = r2.f27058k     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r1 = r2.call(r1, r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L2c
            boolean r0 = r1.booleanValue()     // Catch: java.lang.Throwable -> L2c
            if (r0 != 0) goto L26
            rx.Subscriber r0 = r3.f27052l
            r0.onNext(r4)
            goto L3b
        L26:
            r0 = 1
            r3.request(r0)
            goto L3b
        L2c:
            r4 = move-exception
            rx.Subscriber r1 = r3.f27052l
            p007b.p225i.p226a.p288f.p299e.p308o.C3404f.m4329p1(r4, r1, r0)
            return
        L33:
            r0 = 1
            r3.f27051k = r0
            rx.Subscriber r0 = r3.f27052l
            r0.onNext(r4)
        L3b:
            return
        L3c:
            r0 = move-exception
            rx.Subscriber r1 = r3.f27052l
            p007b.p225i.p226a.p288f.p299e.p308o.C3404f.m4329p1(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p637j0.p642l.p643a.C12673t0.onNext(java.lang.Object):void");
    }
}
