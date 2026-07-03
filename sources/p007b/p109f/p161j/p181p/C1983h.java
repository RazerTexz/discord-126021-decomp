package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p161j.p168c.C1867n;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p168c.InterfaceC1876w;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1922h;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.p.h */
/* JADX INFO: compiled from: BitmapMemoryCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1983h implements InterfaceC2018w0<CloseableReference<AbstractC1917c>> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1876w<CacheKey, AbstractC1917c> f4067a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1862i f4068b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2018w0<CloseableReference<AbstractC1917c>> f4069c;

    /* JADX INFO: renamed from: b.f.j.p.h$a */
    /* JADX INFO: compiled from: BitmapMemoryCacheProducer.java */
    public class a extends AbstractC2003p<CloseableReference<AbstractC1917c>, CloseableReference<AbstractC1917c>> {

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ CacheKey f4070c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ boolean f4071d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC1995l interfaceC1995l, CacheKey cacheKey, boolean z2) {
            super(interfaceC1995l);
            this.f4070c = cacheKey;
            this.f4071d = z2;
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v9 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(java.lang.Object r7, int r8) {
            /*
                r6 = this;
                com.facebook.common.references.CloseableReference r7 = (com.facebook.common.references.CloseableReference) r7
                p007b.p109f.p161j.p183r.C2030b.m1527b()     // Catch: java.lang.Throwable -> La9
                boolean r0 = p007b.p109f.p161j.p181p.AbstractC1965b.m1419e(r8)     // Catch: java.lang.Throwable -> La9
                r1 = 0
                if (r7 != 0) goto L18
                if (r0 == 0) goto L13
                b.f.j.p.l<O> r7 = r6.f4179b     // Catch: java.lang.Throwable -> La9
                r7.mo1424b(r1, r8)     // Catch: java.lang.Throwable -> La9
            L13:
                p007b.p109f.p161j.p183r.C2030b.m1527b()
                goto La8
            L18:
                java.lang.Object r2 = r7.m8642u()     // Catch: java.lang.Throwable -> La9
                b.f.j.j.c r2 = (p007b.p109f.p161j.p175j.AbstractC1917c) r2     // Catch: java.lang.Throwable -> La9
                boolean r2 = r2.mo1331d()     // Catch: java.lang.Throwable -> La9
                if (r2 != 0) goto La1
                r2 = 8
                boolean r2 = p007b.p109f.p161j.p181p.AbstractC1965b.m1422m(r8, r2)     // Catch: java.lang.Throwable -> La9
                if (r2 == 0) goto L2e
                goto La1
            L2e:
                if (r0 != 0) goto L74
                b.f.j.p.h r2 = p007b.p109f.p161j.p181p.C1983h.this     // Catch: java.lang.Throwable -> La9
                b.f.j.c.w<com.facebook.cache.common.CacheKey, b.f.j.j.c> r2 = r2.f4067a     // Catch: java.lang.Throwable -> La9
                com.facebook.cache.common.CacheKey r3 = r6.f4070c     // Catch: java.lang.Throwable -> La9
                com.facebook.common.references.CloseableReference r2 = r2.get(r3)     // Catch: java.lang.Throwable -> La9
                if (r2 == 0) goto L74
                java.lang.Object r3 = r7.m8642u()     // Catch: java.lang.Throwable -> L6f
                b.f.j.j.c r3 = (p007b.p109f.p161j.p175j.AbstractC1917c) r3     // Catch: java.lang.Throwable -> L6f
                b.f.j.j.i r3 = r3.mo1334b()     // Catch: java.lang.Throwable -> L6f
                java.lang.Object r4 = r2.m8642u()     // Catch: java.lang.Throwable -> L6f
                b.f.j.j.c r4 = (p007b.p109f.p161j.p175j.AbstractC1917c) r4     // Catch: java.lang.Throwable -> L6f
                b.f.j.j.i r4 = r4.mo1334b()     // Catch: java.lang.Throwable -> L6f
                r5 = r4
                b.f.j.j.h r5 = (p007b.p109f.p161j.p175j.C1922h) r5     // Catch: java.lang.Throwable -> L6f
                boolean r5 = r5.f3911d     // Catch: java.lang.Throwable -> L6f
                if (r5 != 0) goto L66
                b.f.j.j.h r4 = (p007b.p109f.p161j.p175j.C1922h) r4     // Catch: java.lang.Throwable -> L6f
                int r4 = r4.f3909b     // Catch: java.lang.Throwable -> L6f
                b.f.j.j.h r3 = (p007b.p109f.p161j.p175j.C1922h) r3     // Catch: java.lang.Throwable -> L6f
                int r3 = r3.f3909b     // Catch: java.lang.Throwable -> L6f
                if (r4 < r3) goto L62
                goto L66
            L62:
                r2.close()     // Catch: java.lang.Throwable -> La9
                goto L74
            L66:
                b.f.j.p.l<O> r7 = r6.f4179b     // Catch: java.lang.Throwable -> L6f
                r7.mo1424b(r2, r8)     // Catch: java.lang.Throwable -> L6f
                r2.close()     // Catch: java.lang.Throwable -> La9
                goto L13
            L6f:
                r7 = move-exception
                r2.close()     // Catch: java.lang.Throwable -> La9
                throw r7     // Catch: java.lang.Throwable -> La9
            L74:
                boolean r2 = r6.f4071d     // Catch: java.lang.Throwable -> La9
                if (r2 == 0) goto L82
                b.f.j.p.h r1 = p007b.p109f.p161j.p181p.C1983h.this     // Catch: java.lang.Throwable -> La9
                b.f.j.c.w<com.facebook.cache.common.CacheKey, b.f.j.j.c> r1 = r1.f4067a     // Catch: java.lang.Throwable -> La9
                com.facebook.cache.common.CacheKey r2 = r6.f4070c     // Catch: java.lang.Throwable -> La9
                com.facebook.common.references.CloseableReference r1 = r1.mo1235a(r2, r7)     // Catch: java.lang.Throwable -> La9
            L82:
                if (r0 == 0) goto L8b
                b.f.j.p.l<O> r0 = r6.f4179b     // Catch: java.lang.Throwable -> L9a
                r2 = 1065353216(0x3f800000, float:1.0)
                r0.mo1423a(r2)     // Catch: java.lang.Throwable -> L9a
            L8b:
                b.f.j.p.l<O> r0 = r6.f4179b     // Catch: java.lang.Throwable -> L9a
                if (r1 == 0) goto L90
                r7 = r1
            L90:
                r0.mo1424b(r7, r8)     // Catch: java.lang.Throwable -> L9a
                if (r1 == 0) goto L13
                r1.close()     // Catch: java.lang.Throwable -> La9
                goto L13
            L9a:
                r7 = move-exception
                if (r1 == 0) goto La0
                r1.close()     // Catch: java.lang.Throwable -> La9
            La0:
                throw r7     // Catch: java.lang.Throwable -> La9
            La1:
                b.f.j.p.l<O> r0 = r6.f4179b     // Catch: java.lang.Throwable -> La9
                r0.mo1424b(r7, r8)     // Catch: java.lang.Throwable -> La9
                goto L13
            La8:
                return
            La9:
                r7 = move-exception
                p007b.p109f.p161j.p183r.C2030b.m1527b()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C1983h.a.mo1320i(java.lang.Object, int):void");
        }
    }

    public C1983h(InterfaceC1876w<CacheKey, AbstractC1917c> interfaceC1876w, InterfaceC1862i interfaceC1862i, InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w0) {
        this.f4067a = interfaceC1876w;
        this.f4068b = interfaceC1862i;
        this.f4069c = interfaceC2018w0;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        try {
            C2030b.m1527b();
            InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
            interfaceC2024z0Mo1457o.mo1358e(interfaceC2020x0, mo1472d());
            CacheKey cacheKeyM1229a = ((C1867n) this.f4068b).m1229a(interfaceC2020x0.mo1447e(), interfaceC2020x0.mo1444b());
            CloseableReference<AbstractC1917c> closeableReference = interfaceC2020x0.mo1447e().m8720b(1) ? this.f4067a.get(cacheKeyM1229a) : null;
            if (closeableReference != null) {
                interfaceC2020x0.mo1452j(closeableReference.m8642u().mo1333a());
                boolean z2 = ((C1922h) closeableReference.m8642u().mo1334b()).f3911d;
                if (z2) {
                    interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, mo1472d(), interfaceC2024z0Mo1457o.mo1360g(interfaceC2020x0, mo1472d()) ? C1683f.m967of("cached_value_found", "true") : null);
                    interfaceC2024z0Mo1457o.mo1356c(interfaceC2020x0, mo1472d(), true);
                    interfaceC2020x0.mo1451i("memory_bitmap", mo1471c());
                    interfaceC1995l.mo1423a(1.0f);
                }
                interfaceC1995l.mo1424b(closeableReference, z2 ? 1 : 0);
                closeableReference.close();
                if (z2) {
                    return;
                }
            }
            if (interfaceC2020x0.mo1459q().m8722g() >= ImageRequest.EnumC10667c.BITMAP_MEMORY_CACHE.m8722g()) {
                interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, mo1472d(), interfaceC2024z0Mo1457o.mo1360g(interfaceC2020x0, mo1472d()) ? C1683f.m967of("cached_value_found", "false") : null);
                interfaceC2024z0Mo1457o.mo1356c(interfaceC2020x0, mo1472d(), false);
                interfaceC2020x0.mo1451i("memory_bitmap", mo1471c());
                interfaceC1995l.mo1424b(null, 1);
                return;
            }
            InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995lMo1473e = mo1473e(interfaceC1995l, cacheKeyM1229a, interfaceC2020x0.mo1447e().m8720b(2));
            interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, mo1472d(), interfaceC2024z0Mo1457o.mo1360g(interfaceC2020x0, mo1472d()) ? C1683f.m967of("cached_value_found", "false") : null);
            C2030b.m1527b();
            this.f4069c.mo1417b(interfaceC1995lMo1473e, interfaceC2020x0);
            C2030b.m1527b();
        } finally {
            C2030b.m1527b();
        }
    }

    /* JADX INFO: renamed from: c */
    public String mo1471c() {
        return "pipe_bg";
    }

    /* JADX INFO: renamed from: d */
    public String mo1472d() {
        return "BitmapMemoryCacheProducer";
    }

    /* JADX INFO: renamed from: e */
    public InterfaceC1995l<CloseableReference<AbstractC1917c>> mo1473e(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, CacheKey cacheKey, boolean z2) {
        return new a(interfaceC1995l, cacheKey, z2);
    }
}
