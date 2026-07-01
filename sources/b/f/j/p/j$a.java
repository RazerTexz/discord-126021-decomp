package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: BitmapProbeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class j$a extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> {
    public final x0 c;
    public final b.f.j.c.w<CacheKey, PooledByteBuffer> d;
    public final b.f.j.c.f e;
    public final b.f.j.c.f f;
    public final b.f.j.c.i g;
    public final b.f.j.c.d<CacheKey> h;
    public final b.f.j.c.d<CacheKey> i;

    public j$a(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var, b.f.j.c.w<CacheKey, PooledByteBuffer> wVar, b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, b.f.j.c.d<CacheKey> dVar, b.f.j.c.d<CacheKey> dVar2) {
        super(lVar);
        this.c = x0Var;
        this.d = wVar;
        this.e = fVar;
        this.f = fVar2;
        this.g = iVar;
        this.h = dVar;
        this.i = dVar2;
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
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v3 boolean
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
            b.f.j.r.b.b()     // Catch: java.lang.Throwable -> L66
            boolean r0 = b.f.j.p.b.f(r5)     // Catch: java.lang.Throwable -> L66
            if (r0 != 0) goto L5d
            if (r4 == 0) goto L5d
            r0 = 8
            boolean r0 = b.f.j.p.b.l(r5, r0)     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L16
            goto L5d
        L16:
            b.f.j.p.x0 r0 = r3.c     // Catch: java.lang.Throwable -> L66
            com.facebook.imagepipeline.request.ImageRequest r0 = r0.e()     // Catch: java.lang.Throwable -> L66
            b.f.j.c.i r1 = r3.g     // Catch: java.lang.Throwable -> L66
            b.f.j.p.x0 r2 = r3.c     // Catch: java.lang.Throwable -> L66
            java.lang.Object r2 = r2.b()     // Catch: java.lang.Throwable -> L66
            b.f.j.c.n r1 = (b.f.j.c.n) r1     // Catch: java.lang.Throwable -> L66
            r1.b(r0, r2)     // Catch: java.lang.Throwable -> L66
            b.f.j.p.x0 r0 = r3.c     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = "origin"
            java.lang.Object r0 = r0.l(r1)     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L57
            java.lang.String r1 = "memory_bitmap"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L57
            b.f.j.p.x0 r0 = r3.c     // Catch: java.lang.Throwable -> L66
            b.f.j.e.k r0 = r0.g()     // Catch: java.lang.Throwable -> L66
            b.f.j.e.l r0 = r0.getExperiments()     // Catch: java.lang.Throwable -> L66
            java.util.Objects.requireNonNull(r0)     // Catch: java.lang.Throwable -> L66
            b.f.j.p.x0 r0 = r3.c     // Catch: java.lang.Throwable -> L66
            b.f.j.e.k r0 = r0.g()     // Catch: java.lang.Throwable -> L66
            b.f.j.e.l r0 = r0.getExperiments()     // Catch: java.lang.Throwable -> L66
            java.util.Objects.requireNonNull(r0)     // Catch: java.lang.Throwable -> L66
        L57:
            b.f.j.p.l<O> r0 = r3.f632b     // Catch: java.lang.Throwable -> L66
            r0.b(r4, r5)     // Catch: java.lang.Throwable -> L66
            goto L62
        L5d:
            b.f.j.p.l<O> r0 = r3.f632b     // Catch: java.lang.Throwable -> L66
            r0.b(r4, r5)     // Catch: java.lang.Throwable -> L66
        L62:
            b.f.j.r.b.b()
            return
        L66:
            r4 = move-exception
            b.f.j.r.b.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.j$a.i(java.lang.Object, int):void");
    }
}
