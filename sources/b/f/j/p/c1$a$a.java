package b.f.j.p;

/* JADX INFO: compiled from: ResizeAndRotateProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class c1$a$a implements c0$c {
    public final /* synthetic */ c1$a a;

    public c1$a$a(c1$a c1_a, c1 c1Var) {
        this.a = c1_a;
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
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v8 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // b.f.j.p.c0$c
    public void a(b.f.j.j.e r14, int r15) {
        /*
            r13 = this;
            b.f.j.p.c1$a r0 = r13.a
            b.f.j.s.c r1 = r0.d
            r14.x()
            b.f.i.c r2 = r14.l
            b.f.j.p.c1$a r3 = r13.a
            boolean r3 = r3.c
            b.f.j.s.b r1 = r1.createImageTranscoder(r2, r3)
            java.util.Objects.requireNonNull(r1)
            b.f.j.p.x0 r2 = r0.e
            b.f.j.p.z0 r2 = r2.o()
            b.f.j.p.x0 r3 = r0.e
            java.lang.String r11 = "ResizeAndRotateProducer"
            r2.e(r3, r11)
            b.f.j.p.x0 r2 = r0.e
            com.facebook.imagepipeline.request.ImageRequest r2 = r2.e()
            b.f.j.p.c1 r3 = r0.h
            b.f.d.g.g r3 = r3.f607b
            b.f.d.g.i r3 = r3.a()
            r12 = 0
            b.f.j.d.f r7 = r2.k     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            b.f.j.d.e r8 = r2.j     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r9 = 0
            r4 = 85
            java.lang.Integer r10 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r4 = r1
            r5 = r14
            r6 = r3
            b.f.j.s.a r4 = r4.c(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            int r5 = r4.a     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r6 = 2
            if (r5 == r6) goto L94
            b.f.j.d.e r2 = r2.j     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r1 = r1.a()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.util.Map r12 = r0.n(r14, r2, r4, r1)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r14 = r3
            com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream r14 = (com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream) r14     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            b.f.j.l.t r14 = r14.b()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            com.facebook.common.references.CloseableReference r14 = com.facebook.common.references.CloseableReference.A(r14)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            b.f.j.j.e r1 = new b.f.j.j.e     // Catch: java.lang.Throwable -> L8d
            r1.<init>(r14)     // Catch: java.lang.Throwable -> L8d
            b.f.i.c r2 = b.f.i.b.a     // Catch: java.lang.Throwable -> L8d
            r1.l = r2     // Catch: java.lang.Throwable -> L8d
            r1.q()     // Catch: java.lang.Throwable -> L88
            b.f.j.p.x0 r2 = r0.e     // Catch: java.lang.Throwable -> L88
            b.f.j.p.z0 r2 = r2.o()     // Catch: java.lang.Throwable -> L88
            b.f.j.p.x0 r5 = r0.e     // Catch: java.lang.Throwable -> L88
            r2.j(r5, r11, r12)     // Catch: java.lang.Throwable -> L88
            int r2 = r4.a     // Catch: java.lang.Throwable -> L88
            r4 = 1
            if (r2 == r4) goto L7a
            r15 = r15 | 16
        L7a:
            b.f.j.p.l<O> r2 = r0.f632b     // Catch: java.lang.Throwable -> L88
            r2.b(r1, r15)     // Catch: java.lang.Throwable -> L88
            r1.close()     // Catch: java.lang.Throwable -> L8d
            if (r14 == 0) goto Lb5
            r14.close()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            goto Lb5
        L88:
            r2 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L8d
            throw r2     // Catch: java.lang.Throwable -> L8d
        L8d:
            r1 = move-exception
            if (r14 == 0) goto L93
            r14.close()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
        L93:
            throw r1     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
        L94:
            java.lang.RuntimeException r14 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r1 = "Error while transcoding the image"
            r14.<init>(r1)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            throw r14     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
        L9c:
            r14 = move-exception
            goto Lb9
        L9e:
            r14 = move-exception
            b.f.j.p.x0 r1 = r0.e     // Catch: java.lang.Throwable -> L9c
            b.f.j.p.z0 r1 = r1.o()     // Catch: java.lang.Throwable -> L9c
            b.f.j.p.x0 r2 = r0.e     // Catch: java.lang.Throwable -> L9c
            r1.k(r2, r11, r14, r12)     // Catch: java.lang.Throwable -> L9c
            boolean r15 = b.f.j.p.b.e(r15)     // Catch: java.lang.Throwable -> L9c
            if (r15 == 0) goto Lb5
            b.f.j.p.l<O> r15 = r0.f632b     // Catch: java.lang.Throwable -> L9c
            r15.c(r14)     // Catch: java.lang.Throwable -> L9c
        Lb5:
            r3.close()
            return
        Lb9:
            r3.close()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.c1$a$a.a(b.f.j.j.e, int):void");
    }
}
