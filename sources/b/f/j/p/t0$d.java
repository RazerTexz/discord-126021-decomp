package b.f.j.p;

import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class t0$d extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> {
    public t0$d(t0 t0Var, t0$b t0_b, t0$a t0_a) {
        super(t0_b);
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
    public void i(java.lang.Object r2, int r3) {
        /*
            r1 = this;
            com.facebook.common.references.CloseableReference r2 = (com.facebook.common.references.CloseableReference) r2
            boolean r0 = b.f.j.p.b.f(r3)
            if (r0 == 0) goto L9
            goto Le
        L9:
            b.f.j.p.l<O> r0 = r1.f632b
            r0.b(r2, r3)
        Le:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.t0$d.i(java.lang.Object, int):void");
    }
}
