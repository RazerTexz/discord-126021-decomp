package b.f.j.p;

import android.util.Pair;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ThrottlingProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class i1$b<T> extends p<T, T> {
    public final /* synthetic */ i1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1$b(i1 i1Var, l lVar, i1$a i1_a) {
        super(lVar);
        this.c = i1Var;
    }

    @Override // b.f.j.p.p, b.f.j.p.b
    public void g() {
        this.f632b.d();
        n();
    }

    @Override // b.f.j.p.p, b.f.j.p.b
    public void h(Throwable th) {
        this.f632b.c(th);
        n();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v2 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // b.f.j.p.b
    public void i(T r2, int r3) {
        /*
            r1 = this;
            b.f.j.p.l<O> r0 = r1.f632b
            r0.b(r2, r3)
            boolean r2 = b.f.j.p.b.e(r3)
            if (r2 == 0) goto Le
            r1.n()
        Le:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.i1$b.i(java.lang.Object, int):void");
    }

    public final void n() {
        Pair<l<T>, x0> pairPoll;
        synchronized (this.c) {
            pairPoll = this.c.c.poll();
            if (pairPoll == null) {
                this.c.f616b--;
            }
        }
        if (pairPoll != null) {
            this.c.d.execute(new i1$b$a(this, pairPoll));
        }
    }
}
