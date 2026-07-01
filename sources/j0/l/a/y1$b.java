package j0.l.a;

import rx.Producer;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y1$b<T> extends Subscriber<T> {
    public final long j;
    public final y1$c<T> k;

    public y1$b(long j, y1$c<T> y1_c) {
        this.j = j;
        this.k = y1_c;
    }

    @Override // j0.g
    public void onCompleted() {
        y1$c<T> y1_c = this.k;
        long j = this.j;
        synchronized (y1_c) {
            if (y1_c.n.get() != j) {
                return;
            }
            y1_c.v = false;
            y1_c.f3783s = null;
            y1_c.b();
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        boolean zC;
        y1$c<T> y1_c = this.k;
        long j = this.j;
        synchronized (y1_c) {
            if (y1_c.n.get() == j) {
                zC = y1_c.c(th);
                y1_c.v = false;
                y1_c.f3783s = null;
            } else {
                zC = true;
            }
        }
        if (zC) {
            y1_c.b();
        } else {
            j0.o.l.b(th);
        }
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
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to j0.l.a.y1$b<T> for r6v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // j0.g
    public void onNext(T r7) {
        /*
            r6 = this;
            j0.l.a.y1$c<T> r0 = r6.k
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicLong r1 = r0.n     // Catch: java.lang.Throwable -> L1f
            long r1 = r1.get()     // Catch: java.lang.Throwable -> L1f
            long r3 = r6.j     // Catch: java.lang.Throwable -> L1f
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
            goto L1e
        L11:
            j0.l.e.n.e<java.lang.Object> r1 = r0.o     // Catch: java.lang.Throwable -> L1f
            if (r7 != 0) goto L17
            java.lang.Object r7 = j0.l.a.e.f3771b     // Catch: java.lang.Throwable -> L1f
        L17:
            r1.e(r6, r7)     // Catch: java.lang.Throwable -> L1f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
            r0.b()
        L1e:
            return
        L1f:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.l.a.y1$b.onNext(java.lang.Object):void");
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        y1$c<T> y1_c = this.k;
        long j = this.j;
        synchronized (y1_c) {
            if (y1_c.n.get() != j) {
                return;
            }
            long j2 = y1_c.r;
            y1_c.f3783s = producer;
            producer.j(j2);
        }
    }
}
