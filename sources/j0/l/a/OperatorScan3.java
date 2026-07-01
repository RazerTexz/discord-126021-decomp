package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.l.a.OperatorScan;
import java.util.Objects;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.q1, reason: use source file name */
/* JADX INFO: compiled from: OperatorScan.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorScan3<T> extends Subscriber<T> {
    public R j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ OperatorScan.b l;
    public final /* synthetic */ OperatorScan m;

    /* JADX WARN: Multi-variable type inference failed */
    public OperatorScan3(OperatorScan operatorScan, Object obj, OperatorScan.b bVar) {
        this.m = operatorScan;
        this.k = obj;
        this.l = bVar;
        this.j = obj;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.l.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        OperatorScan.b bVar = this.l;
        bVar.r = th;
        bVar.q = true;
        bVar.b();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [R, java.lang.Object] */
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
        try {
            ?? Call = this.m.l.call(this.j, t);
            this.j = Call;
            this.l.onNext(Call);
        } catch (Throwable th) {
            b.i.a.f.e.o.f.p1(th, this, t);
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        long j;
        OperatorScan.b bVar = this.l;
        Objects.requireNonNull(bVar);
        Objects.requireNonNull(producer);
        synchronized (bVar.o) {
            if (bVar.p != null) {
                throw new IllegalStateException("Can't set more than one Producer!");
            }
            j = bVar.n;
            if (j != RecyclerView.FOREVER_NS) {
                j--;
            }
            bVar.n = 0L;
            bVar.p = producer;
        }
        if (j > 0) {
            producer.j(j);
        }
        bVar.b();
    }
}
