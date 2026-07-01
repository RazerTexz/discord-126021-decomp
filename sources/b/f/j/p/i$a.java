package b.f.j.p;

import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: BitmapPrepareProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$a extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> {
    public final int c;
    public final int d;

    public i$a(l<CloseableReference<b.f.j.j.c>> lVar, int i, int i2) {
        super(lVar);
        this.c = i;
        this.d = i2;
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
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v2 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // b.f.j.p.b
    public void i(java.lang.Object r4, int r5) {
        /*
            r3 = this;
            com.facebook.common.references.CloseableReference r4 = (com.facebook.common.references.CloseableReference) r4
            if (r4 == 0) goto L3a
            boolean r0 = r4.x()
            if (r0 != 0) goto Lb
            goto L3a
        Lb:
            java.lang.Object r0 = r4.u()
            b.f.j.j.c r0 = (b.f.j.j.c) r0
            boolean r1 = r0.isClosed()
            if (r1 == 0) goto L18
            goto L3a
        L18:
            boolean r1 = r0 instanceof b.f.j.j.d
            if (r1 == 0) goto L3a
            b.f.j.j.d r0 = (b.f.j.j.d) r0
            android.graphics.Bitmap r0 = r0.m
            if (r0 != 0) goto L23
            goto L3a
        L23:
            int r1 = r0.getRowBytes()
            int r2 = r0.getHeight()
            int r2 = r2 * r1
            int r1 = r3.c
            if (r2 >= r1) goto L32
            goto L3a
        L32:
            int r1 = r3.d
            if (r2 <= r1) goto L37
            goto L3a
        L37:
            r0.prepareToDraw()
        L3a:
            b.f.j.p.l<O> r0 = r3.f632b
            r0.b(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.i$a.i(java.lang.Object, int):void");
    }
}
