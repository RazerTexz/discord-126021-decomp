package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p161j.p168c.C1867n;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.p.v */
/* JADX INFO: compiled from: EncodedMemoryCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2015v implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1876w<CacheKey, PooledByteBuffer> f4238a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1862i f4239b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2018w0<C1919e> f4240c;

    /* JADX INFO: renamed from: b.f.j.p.v$a */
    /* JADX INFO: compiled from: EncodedMemoryCacheProducer.java */
    public static class a extends AbstractC2003p<C1919e, C1919e> {

        /* JADX INFO: renamed from: c */
        public final InterfaceC1876w<CacheKey, PooledByteBuffer> f4241c;

        /* JADX INFO: renamed from: d */
        public final CacheKey f4242d;

        /* JADX INFO: renamed from: e */
        public final boolean f4243e;

        /* JADX INFO: renamed from: f */
        public final boolean f4244f;

        public a(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC1876w<CacheKey, PooledByteBuffer> interfaceC1876w, CacheKey cacheKey, boolean z2, boolean z3) {
            super(interfaceC1995l);
            this.f4241c = interfaceC1876w;
            this.f4242d = cacheKey;
            this.f4243e = z2;
            this.f4244f = z3;
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
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(java.lang.Object r4, int r5) {
            /*
                r3 = this;
                b.f.j.j.e r4 = (p007b.p109f.p161j.p175j.C1919e) r4
                p007b.p109f.p161j.p183r.C2030b.m1527b()     // Catch: java.lang.Throwable -> L74
                boolean r0 = p007b.p109f.p161j.p181p.AbstractC1965b.m1420f(r5)     // Catch: java.lang.Throwable -> L74
                if (r0 != 0) goto L6b
                if (r4 == 0) goto L6b
                r0 = 10
                boolean r0 = p007b.p109f.p161j.p181p.AbstractC1965b.m1421l(r5, r0)     // Catch: java.lang.Throwable -> L74
                if (r0 != 0) goto L6b
                r4.m1347x()     // Catch: java.lang.Throwable -> L74
                b.f.i.c r0 = r4.f3893l     // Catch: java.lang.Throwable -> L74
                b.f.i.c r1 = p007b.p109f.p160i.C1832c.f3597a     // Catch: java.lang.Throwable -> L74
                if (r0 != r1) goto L1f
                goto L6b
            L1f:
                com.facebook.common.references.CloseableReference r0 = r4.m1340c()     // Catch: java.lang.Throwable -> L74
                if (r0 == 0) goto L65
                r1 = 0
                boolean r2 = r3.f4244f     // Catch: java.lang.Throwable -> L60
                if (r2 == 0) goto L36
                boolean r2 = r3.f4243e     // Catch: java.lang.Throwable -> L60
                if (r2 == 0) goto L36
                b.f.j.c.w<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> r1 = r3.f4241c     // Catch: java.lang.Throwable -> L60
                com.facebook.cache.common.CacheKey r2 = r3.f4242d     // Catch: java.lang.Throwable -> L60
                com.facebook.common.references.CloseableReference r1 = r1.mo1235a(r2, r0)     // Catch: java.lang.Throwable -> L60
            L36:
                r0.close()     // Catch: java.lang.Throwable -> L74
                if (r1 == 0) goto L65
                b.f.j.j.e r0 = new b.f.j.j.e     // Catch: java.lang.Throwable -> L5b
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L5b
                r0.m1339b(r4)     // Catch: java.lang.Throwable -> L5b
                r1.close()     // Catch: java.lang.Throwable -> L74
                b.f.j.p.l<O> r4 = r3.f4179b     // Catch: java.lang.Throwable -> L56
                r1 = 1065353216(0x3f800000, float:1.0)
                r4.mo1423a(r1)     // Catch: java.lang.Throwable -> L56
                b.f.j.p.l<O> r4 = r3.f4179b     // Catch: java.lang.Throwable -> L56
                r4.mo1424b(r0, r5)     // Catch: java.lang.Throwable -> L56
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
                b.f.j.p.l<O> r0 = r3.f4179b     // Catch: java.lang.Throwable -> L74
                r0.mo1424b(r4, r5)     // Catch: java.lang.Throwable -> L74
                goto L70
            L6b:
                b.f.j.p.l<O> r0 = r3.f4179b     // Catch: java.lang.Throwable -> L74
                r0.mo1424b(r4, r5)     // Catch: java.lang.Throwable -> L74
            L70:
                p007b.p109f.p161j.p183r.C2030b.m1527b()
                return
            L74:
                r4 = move-exception
                p007b.p109f.p161j.p183r.C2030b.m1527b()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C2015v.a.mo1320i(java.lang.Object, int):void");
        }
    }

    public C2015v(InterfaceC1876w<CacheKey, PooledByteBuffer> interfaceC1876w, InterfaceC1862i interfaceC1862i, InterfaceC2018w0<C1919e> interfaceC2018w0) {
        this.f4238a = interfaceC1876w;
        this.f4239b = interfaceC1862i;
        this.f4240c = interfaceC2018w0;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        try {
            C2030b.m1527b();
            InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
            interfaceC2024z0Mo1457o.mo1358e(interfaceC2020x0, "EncodedMemoryCacheProducer");
            CacheKey cacheKeyM1230b = ((C1867n) this.f4239b).m1230b(interfaceC2020x0.mo1447e(), interfaceC2020x0.mo1444b());
            CloseableReference<PooledByteBuffer> closeableReference = interfaceC2020x0.mo1447e().m8720b(4) ? this.f4238a.get(cacheKeyM1230b) : null;
            try {
                if (closeableReference != null) {
                    C1919e c1919e = new C1919e(closeableReference);
                    try {
                        interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, "EncodedMemoryCacheProducer", interfaceC2024z0Mo1457o.mo1360g(interfaceC2020x0, "EncodedMemoryCacheProducer") ? C1683f.m967of("cached_value_found", "true") : null);
                        interfaceC2024z0Mo1457o.mo1356c(interfaceC2020x0, "EncodedMemoryCacheProducer", true);
                        interfaceC2020x0.mo1456n("memory_encoded");
                        interfaceC1995l.mo1423a(1.0f);
                        interfaceC1995l.mo1424b(c1919e, 1);
                        c1919e.close();
                        closeableReference.close();
                        C2030b.m1527b();
                        return;
                    } catch (Throwable th) {
                        c1919e.close();
                        throw th;
                    }
                }
                if (interfaceC2020x0.mo1459q().m8722g() < ImageRequest.EnumC10667c.ENCODED_MEMORY_CACHE.m8722g()) {
                    a aVar = new a(interfaceC1995l, this.f4238a, cacheKeyM1230b, interfaceC2020x0.mo1447e().m8720b(8), interfaceC2020x0.mo1449g().getExperiments().f3782e);
                    interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, "EncodedMemoryCacheProducer", interfaceC2024z0Mo1457o.mo1360g(interfaceC2020x0, "EncodedMemoryCacheProducer") ? C1683f.m967of("cached_value_found", "false") : null);
                    this.f4240c.mo1417b(aVar, interfaceC2020x0);
                    Class<CloseableReference> cls = CloseableReference.f19438j;
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    C2030b.m1527b();
                    return;
                }
                interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, "EncodedMemoryCacheProducer", interfaceC2024z0Mo1457o.mo1360g(interfaceC2020x0, "EncodedMemoryCacheProducer") ? C1683f.m967of("cached_value_found", "false") : null);
                interfaceC2024z0Mo1457o.mo1356c(interfaceC2020x0, "EncodedMemoryCacheProducer", false);
                interfaceC2020x0.mo1451i("memory_encoded", "nil-result");
                interfaceC1995l.mo1424b(null, 1);
                Class<CloseableReference> cls2 = CloseableReference.f19438j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                C2030b.m1527b();
            } catch (Throwable th2) {
                Class<CloseableReference> cls3 = CloseableReference.f19438j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            C2030b.m1527b();
            throw th3;
        }
    }
}
