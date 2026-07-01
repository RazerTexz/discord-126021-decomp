package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;

/* JADX INFO: compiled from: EncodedMemoryCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class v$a extends p<b.f.j.j.e, b.f.j.j.e> {
    public final b.f.j.c.w<CacheKey, PooledByteBuffer> c;
    public final CacheKey d;
    public final boolean e;
    public final boolean f;

    public v$a(l<b.f.j.j.e> lVar, b.f.j.c.w<CacheKey, PooledByteBuffer> wVar, CacheKey cacheKey, boolean z2, boolean z3) {
        super(lVar);
        this.c = wVar;
        this.d = cacheKey;
        this.e = z2;
        this.f = z3;
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
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v8 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // b.f.j.p.b
    public void i(java.lang.Object r4, int r5) {
        /*
            r3 = this;
            b.f.j.j.e r4 = (b.f.j.j.e) r4
            b.f.j.r.b.b()     // Catch: java.lang.Throwable -> L74
            boolean r0 = b.f.j.p.b.f(r5)     // Catch: java.lang.Throwable -> L74
            if (r0 != 0) goto L6b
            if (r4 == 0) goto L6b
            r0 = 10
            boolean r0 = b.f.j.p.b.l(r5, r0)     // Catch: java.lang.Throwable -> L74
            if (r0 != 0) goto L6b
            r4.x()     // Catch: java.lang.Throwable -> L74
            b.f.i.c r0 = r4.l     // Catch: java.lang.Throwable -> L74
            b.f.i.c r1 = b.f.i.c.a     // Catch: java.lang.Throwable -> L74
            if (r0 != r1) goto L1f
            goto L6b
        L1f:
            com.facebook.common.references.CloseableReference r0 = r4.c()     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L65
            r1 = 0
            boolean r2 = r3.f     // Catch: java.lang.Throwable -> L60
            if (r2 == 0) goto L36
            boolean r2 = r3.e     // Catch: java.lang.Throwable -> L60
            if (r2 == 0) goto L36
            b.f.j.c.w<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> r1 = r3.c     // Catch: java.lang.Throwable -> L60
            com.facebook.cache.common.CacheKey r2 = r3.d     // Catch: java.lang.Throwable -> L60
            com.facebook.common.references.CloseableReference r1 = r1.a(r2, r0)     // Catch: java.lang.Throwable -> L60
        L36:
            r0.close()     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L65
            b.f.j.j.e r0 = new b.f.j.j.e     // Catch: java.lang.Throwable -> L5b
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L5b
            r0.b(r4)     // Catch: java.lang.Throwable -> L5b
            r1.close()     // Catch: java.lang.Throwable -> L74
            b.f.j.p.l<O> r4 = r3.f632b     // Catch: java.lang.Throwable -> L56
            r1 = 1065353216(0x3f800000, float:1.0)
            r4.a(r1)     // Catch: java.lang.Throwable -> L56
            b.f.j.p.l<O> r4 = r3.f632b     // Catch: java.lang.Throwable -> L56
            r4.b(r0, r5)     // Catch: java.lang.Throwable -> L56
            r0.close()     // Catch: java.lang.Throwable -> L74
            goto L70
        L56:
            r4 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L74
            throw r4     // Catch: java.lang.Throwable -> L74
        L5b:
            r4 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L74
            throw r4     // Catch: java.lang.Throwable -> L74
        L60:
            r4 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L74
            throw r4     // Catch: java.lang.Throwable -> L74
        L65:
            b.f.j.p.l<O> r0 = r3.f632b     // Catch: java.lang.Throwable -> L74
            r0.b(r4, r5)     // Catch: java.lang.Throwable -> L74
            goto L70
        L6b:
            b.f.j.p.l<O> r0 = r3.f632b     // Catch: java.lang.Throwable -> L74
            r0.b(r4, r5)     // Catch: java.lang.Throwable -> L74
        L70:
            b.f.j.r.b.b()
            return
        L74:
            r4 = move-exception
            b.f.j.r.b.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.v$a.i(java.lang.Object, int):void");
    }
}
