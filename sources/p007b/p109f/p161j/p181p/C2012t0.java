package p007b.p109f.p161j.p181p;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1918d;
import p007b.p109f.p161j.p182q.InterfaceC2026b;
import p007b.p109f.p161j.p182q.InterfaceC2027c;
import p007b.p109f.p161j.p182q.InterfaceC2028d;

/* JADX INFO: renamed from: b.f.j.p.t0 */
/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2012t0 implements InterfaceC2018w0<CloseableReference<AbstractC1917c>> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2018w0<CloseableReference<AbstractC1917c>> f4221a;

    /* JADX INFO: renamed from: b */
    public final PlatformBitmapFactory f4222b;

    /* JADX INFO: renamed from: c */
    public final Executor f4223c;

    /* JADX INFO: renamed from: b.f.j.p.t0$b */
    /* JADX INFO: compiled from: PostprocessorProducer.java */
    public class b extends AbstractC2003p<CloseableReference<AbstractC1917c>, CloseableReference<AbstractC1917c>> {

        /* JADX INFO: renamed from: c */
        public final InterfaceC2024z0 f4224c;

        /* JADX INFO: renamed from: d */
        public final InterfaceC2020x0 f4225d;

        /* JADX INFO: renamed from: e */
        public final InterfaceC2026b f4226e;

        /* JADX INFO: renamed from: f */
        public boolean f4227f;

        /* JADX INFO: renamed from: g */
        public CloseableReference<AbstractC1917c> f4228g;

        /* JADX INFO: renamed from: h */
        public int f4229h;

        /* JADX INFO: renamed from: i */
        public boolean f4230i;

        /* JADX INFO: renamed from: j */
        public boolean f4231j;

        /* JADX INFO: renamed from: b.f.j.p.t0$b$a */
        /* JADX INFO: compiled from: PostprocessorProducer.java */
        public class a extends C1974e {
            public a(C2012t0 c2012t0) {
            }

            @Override // p007b.p109f.p161j.p181p.InterfaceC2022y0
            /* JADX INFO: renamed from: a */
            public void mo1438a() {
                b bVar = b.this;
                if (bVar.m1518o()) {
                    bVar.f4179b.mo1426d();
                }
            }
        }

        public b(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2024z0 interfaceC2024z0, InterfaceC2026b interfaceC2026b, InterfaceC2020x0 interfaceC2020x0) {
            super(interfaceC1995l);
            this.f4228g = null;
            this.f4229h = 0;
            this.f4230i = false;
            this.f4231j = false;
            this.f4224c = interfaceC2024z0;
            this.f4226e = interfaceC2026b;
            this.f4225d = interfaceC2020x0;
            interfaceC2020x0.mo1448f(new a(C2012t0.this));
        }

        /* JADX INFO: renamed from: n */
        public static void m1517n(b bVar, CloseableReference closeableReference, int i) {
            Objects.requireNonNull(bVar);
            C1460d.m527i(Boolean.valueOf(CloseableReference.m8640y(closeableReference)));
            if (!(((AbstractC1917c) closeableReference.m8642u()) instanceof C1918d)) {
                bVar.m1520q(closeableReference, i);
                return;
            }
            bVar.f4224c.mo1358e(bVar.f4225d, "PostprocessorProducer");
            CloseableReference<AbstractC1917c> closeableReferenceM1521r = null;
            try {
                try {
                    closeableReferenceM1521r = bVar.m1521r((AbstractC1917c) closeableReference.m8642u());
                    InterfaceC2024z0 interfaceC2024z0 = bVar.f4224c;
                    InterfaceC2020x0 interfaceC2020x0 = bVar.f4225d;
                    interfaceC2024z0.mo1363j(interfaceC2020x0, "PostprocessorProducer", bVar.m1519p(interfaceC2024z0, interfaceC2020x0, bVar.f4226e));
                    bVar.m1520q(closeableReferenceM1521r, i);
                    if (closeableReferenceM1521r != null) {
                        closeableReferenceM1521r.close();
                    }
                } catch (Exception e) {
                    InterfaceC2024z0 interfaceC2024z1 = bVar.f4224c;
                    InterfaceC2020x0 interfaceC2020x1 = bVar.f4225d;
                    interfaceC2024z1.mo1364k(interfaceC2020x1, "PostprocessorProducer", e, bVar.m1519p(interfaceC2024z1, interfaceC2020x1, bVar.f4226e));
                    if (bVar.m1518o()) {
                        bVar.f4179b.mo1425c(e);
                    }
                }
            } catch (Throwable th) {
                if (closeableReferenceM1521r != null) {
                    closeableReferenceM1521r.close();
                }
                throw th;
            }
        }

        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: g */
        public void mo1318g() {
            if (m1518o()) {
                this.f4179b.mo1426d();
            }
        }

        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            if (m1518o()) {
                this.f4179b.mo1425c(th);
            }
        }

        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (!CloseableReference.m8640y(closeableReference)) {
                if (AbstractC1965b.m1419e(i)) {
                    m1520q(null, i);
                    return;
                }
                return;
            }
            synchronized (this) {
                if (!this.f4227f) {
                    CloseableReference<AbstractC1917c> closeableReference2 = this.f4228g;
                    this.f4228g = CloseableReference.m8636n(closeableReference);
                    this.f4229h = i;
                    this.f4230i = true;
                    boolean zM1522s = m1522s();
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                    if (zM1522s) {
                        C2012t0.this.f4223c.execute(new RunnableC2014u0(this));
                    }
                }
            }
        }

        /* JADX INFO: renamed from: o */
        public final boolean m1518o() {
            synchronized (this) {
                if (this.f4227f) {
                    return false;
                }
                CloseableReference<AbstractC1917c> closeableReference = this.f4228g;
                this.f4228g = null;
                this.f4227f = true;
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return true;
            }
        }

        /* JADX INFO: renamed from: p */
        public final Map<String, String> m1519p(InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, InterfaceC2026b interfaceC2026b) {
            if (interfaceC2024z0.mo1360g(interfaceC2020x0, "PostprocessorProducer")) {
                return C1683f.m967of("Postprocessor", interfaceC2026b.getName());
            }
            return null;
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v2 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        /* JADX INFO: renamed from: q */
        public final void m1520q(com.facebook.common.references.CloseableReference<p007b.p109f.p161j.p175j.AbstractC1917c> r3, int r4) {
            /*
                r2 = this;
                boolean r0 = p007b.p109f.p161j.p181p.AbstractC1965b.m1419e(r4)
                if (r0 != 0) goto L10
                monitor-enter(r2)
                boolean r1 = r2.f4227f     // Catch: java.lang.Throwable -> Ld
                monitor-exit(r2)
                if (r1 == 0) goto L18
                goto L10
            Ld:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            L10:
                if (r0 == 0) goto L1d
                boolean r0 = r2.m1518o()
                if (r0 == 0) goto L1d
            L18:
                b.f.j.p.l<O> r0 = r2.f4179b
                r0.mo1424b(r3, r4)
            L1d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C2012t0.b.m1520q(com.facebook.common.references.CloseableReference, int):void");
        }

        /* JADX INFO: renamed from: r */
        public final CloseableReference<AbstractC1917c> m1521r(AbstractC1917c abstractC1917c) {
            C1918d c1918d = (C1918d) abstractC1917c;
            CloseableReference<Bitmap> closeableReferenceProcess = this.f4226e.process(c1918d.f3887m, C2012t0.this.f4222b);
            try {
                C1918d c1918d2 = new C1918d(closeableReferenceProcess, abstractC1917c.mo1334b(), c1918d.f3889o, c1918d.f3890p);
                c1918d2.m1335e(c1918d.f3885k);
                return CloseableReference.m8632A(c1918d2);
            } finally {
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (closeableReferenceProcess != null) {
                    closeableReferenceProcess.close();
                }
            }
        }

        /* JADX INFO: renamed from: s */
        public final synchronized boolean m1522s() {
            if (this.f4227f || !this.f4230i || this.f4231j || !CloseableReference.m8640y(this.f4228g)) {
                return false;
            }
            this.f4231j = true;
            return true;
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.t0$c */
    /* JADX INFO: compiled from: PostprocessorProducer.java */
    public class c extends AbstractC2003p<CloseableReference<AbstractC1917c>, CloseableReference<AbstractC1917c>> implements InterfaceC2028d {

        /* JADX INFO: renamed from: c */
        public boolean f4234c;

        /* JADX INFO: renamed from: d */
        public CloseableReference<AbstractC1917c> f4235d;

        public c(C2012t0 c2012t0, b bVar, InterfaceC2027c interfaceC2027c, InterfaceC2020x0 interfaceC2020x0, a aVar) {
            super(bVar);
            this.f4234c = false;
            this.f4235d = null;
            interfaceC2027c.m1525a(this);
            interfaceC2020x0.mo1448f(new C2016v0(this, c2012t0));
        }

        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: g */
        public void mo1318g() {
            if (m1523n()) {
                this.f4179b.mo1426d();
            }
        }

        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            if (m1523n()) {
                this.f4179b.mo1425c(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (AbstractC1965b.m1420f(i)) {
                return;
            }
            synchronized (this) {
                if (!this.f4234c) {
                    CloseableReference<AbstractC1917c> closeableReference2 = this.f4235d;
                    this.f4235d = CloseableReference.m8636n(closeableReference);
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                }
            }
            synchronized (this) {
                if (!this.f4234c) {
                    CloseableReference closeableReferenceM8636n = CloseableReference.m8636n(this.f4235d);
                    try {
                        this.f4179b.mo1424b((O) closeableReferenceM8636n, 0);
                    } finally {
                        if (closeableReferenceM8636n != null) {
                            closeableReferenceM8636n.close();
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: n */
        public final boolean m1523n() {
            synchronized (this) {
                if (this.f4234c) {
                    return false;
                }
                CloseableReference<AbstractC1917c> closeableReference = this.f4235d;
                this.f4235d = null;
                this.f4234c = true;
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return true;
            }
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.t0$d */
    /* JADX INFO: compiled from: PostprocessorProducer.java */
    public class d extends AbstractC2003p<CloseableReference<AbstractC1917c>, CloseableReference<AbstractC1917c>> {
        public d(C2012t0 c2012t0, b bVar, a aVar) {
            super(bVar);
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
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(java.lang.Object r2, int r3) {
            /*
                r1 = this;
                com.facebook.common.references.CloseableReference r2 = (com.facebook.common.references.CloseableReference) r2
                boolean r0 = p007b.p109f.p161j.p181p.AbstractC1965b.m1420f(r3)
                if (r0 == 0) goto L9
                goto Le
            L9:
                b.f.j.p.l<O> r0 = r1.f4179b
                r0.mo1424b(r2, r3)
            Le:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C2012t0.d.mo1320i(java.lang.Object, int):void");
        }
    }

    public C2012t0(InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w0, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        Objects.requireNonNull(interfaceC2018w0);
        this.f4221a = interfaceC2018w0;
        this.f4222b = platformBitmapFactory;
        Objects.requireNonNull(executor);
        this.f4223c = executor;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
        InterfaceC2026b interfaceC2026b = interfaceC2020x0.mo1447e().f19601s;
        Objects.requireNonNull(interfaceC2026b);
        b bVar = new b(interfaceC1995l, interfaceC2024z0Mo1457o, interfaceC2026b, interfaceC2020x0);
        this.f4221a.mo1417b(interfaceC2026b instanceof InterfaceC2027c ? new c(this, bVar, (InterfaceC2027c) interfaceC2026b, interfaceC2020x0, null) : new d(this, bVar, null), interfaceC2020x0);
    }
}
