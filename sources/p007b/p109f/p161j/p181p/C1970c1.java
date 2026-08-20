package p007b.p109f.p161j.p181p;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p184s.C2031a;
import p007b.p109f.p161j.p184s.InterfaceC2033c;

/* JADX INFO: renamed from: b.f.j.p.c1 */
/* JADX INFO: compiled from: ResizeAndRotateProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1970c1 implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final Executor f4011a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1700g f4012b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2018w0<C1919e> f4013c;

    /* JADX INFO: renamed from: d */
    public final boolean f4014d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2033c f4015e;

    /* JADX INFO: renamed from: b.f.j.p.c1$a */
    /* JADX INFO: compiled from: ResizeAndRotateProducer.java */
    public class a extends AbstractC2003p<C1919e, C1919e> {

        /* JADX INFO: renamed from: c */
        public final boolean f4016c;

        /* JADX INFO: renamed from: d */
        public final InterfaceC2033c f4017d;

        /* JADX INFO: renamed from: e */
        public final InterfaceC2020x0 f4018e;

        /* JADX INFO: renamed from: f */
        public boolean f4019f;

        /* JADX INFO: renamed from: g */
        public final C1969c0 f4020g;

        /* JADX INFO: renamed from: b.f.j.p.c1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ResizeAndRotateProducer.java */
        public class C13220a implements C1969c0.c {
            public C13220a(C1970c1 c1970c1) {
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
            @Override // p007b.p109f.p161j.p181p.C1969c0.c
            /* JADX INFO: renamed from: a */
            public void mo1436a(p007b.p109f.p161j.p175j.C1919e r14, int r15) {
                /*
                    r13 = this;
                    b.f.j.p.c1$a r0 = p007b.p109f.p161j.p181p.C1970c1.a.this
                    b.f.j.s.c r1 = r0.f4017d
                    r14.m1347x()
                    b.f.i.c r2 = r14.f3893l
                    b.f.j.p.c1$a r3 = p007b.p109f.p161j.p181p.C1970c1.a.this
                    boolean r3 = r3.f4016c
                    b.f.j.s.b r1 = r1.createImageTranscoder(r2, r3)
                    java.util.Objects.requireNonNull(r1)
                    b.f.j.p.x0 r2 = r0.f4018e
                    b.f.j.p.z0 r2 = r2.mo1457o()
                    b.f.j.p.x0 r3 = r0.f4018e
                    java.lang.String r11 = "ResizeAndRotateProducer"
                    r2.mo1358e(r3, r11)
                    b.f.j.p.x0 r2 = r0.f4018e
                    com.facebook.imagepipeline.request.ImageRequest r2 = r2.mo1447e()
                    b.f.j.p.c1 r3 = p007b.p109f.p161j.p181p.C1970c1.this
                    b.f.d.g.g r3 = r3.f4012b
                    b.f.d.g.i r3 = r3.mo993a()
                    r12 = 0
                    b.f.j.d.f r7 = r2.f19593k     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    b.f.j.d.e r8 = r2.f19592j     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    r9 = 0
                    r4 = 85
                    java.lang.Integer r10 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    r4 = r1
                    r5 = r14
                    r6 = r3
                    b.f.j.s.a r4 = r4.mo1530c(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    int r5 = r4.f4267a     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    r6 = 2
                    if (r5 == r6) goto L94
                    b.f.j.d.e r2 = r2.f19592j     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    java.lang.String r1 = r1.mo1528a()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    java.util.Map r12 = r0.m1437n(r14, r2, r4, r1)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    r14 = r3
                    com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream r14 = (com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream) r14     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    b.f.j.l.t r14 = r14.m8707b()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    com.facebook.common.references.CloseableReference r14 = com.facebook.common.references.CloseableReference.m8632A(r14)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
                    b.f.j.j.e r1 = new b.f.j.j.e     // Catch: java.lang.Throwable -> L8d
                    r1.<init>(r14)     // Catch: java.lang.Throwable -> L8d
                    b.f.i.c r2 = p007b.p109f.p160i.C1831b.f3585a     // Catch: java.lang.Throwable -> L8d
                    r1.f3893l = r2     // Catch: java.lang.Throwable -> L8d
                    r1.m1345q()     // Catch: java.lang.Throwable -> L88
                    b.f.j.p.x0 r2 = r0.f4018e     // Catch: java.lang.Throwable -> L88
                    b.f.j.p.z0 r2 = r2.mo1457o()     // Catch: java.lang.Throwable -> L88
                    b.f.j.p.x0 r5 = r0.f4018e     // Catch: java.lang.Throwable -> L88
                    r2.mo1363j(r5, r11, r12)     // Catch: java.lang.Throwable -> L88
                    int r2 = r4.f4267a     // Catch: java.lang.Throwable -> L88
                    r4 = 1
                    if (r2 == r4) goto L7a
                    r15 = r15 | 16
                L7a:
                    b.f.j.p.l<O> r2 = r0.f4179b     // Catch: java.lang.Throwable -> L88
                    r2.mo1424b(r1, r15)     // Catch: java.lang.Throwable -> L88
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
                    b.f.j.p.x0 r1 = r0.f4018e     // Catch: java.lang.Throwable -> L9c
                    b.f.j.p.z0 r1 = r1.mo1457o()     // Catch: java.lang.Throwable -> L9c
                    b.f.j.p.x0 r2 = r0.f4018e     // Catch: java.lang.Throwable -> L9c
                    r1.mo1364k(r2, r11, r14, r12)     // Catch: java.lang.Throwable -> L9c
                    boolean r15 = p007b.p109f.p161j.p181p.AbstractC1965b.m1419e(r15)     // Catch: java.lang.Throwable -> L9c
                    if (r15 == 0) goto Lb5
                    b.f.j.p.l<O> r15 = r0.f4179b     // Catch: java.lang.Throwable -> L9c
                    r15.mo1425c(r14)     // Catch: java.lang.Throwable -> L9c
                Lb5:
                    r3.close()
                    return
                Lb9:
                    r3.close()
                    throw r14
                */
                throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C1970c1.a.C13220a.mo1436a(b.f.j.j.e, int):void");
            }
        }

        /* JADX INFO: renamed from: b.f.j.p.c1$a$b */
        /* JADX INFO: compiled from: ResizeAndRotateProducer.java */
        public class b extends C1974e {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ InterfaceC1995l f4023a;

            public b(C1970c1 c1970c1, InterfaceC1995l interfaceC1995l) {
                this.f4023a = interfaceC1995l;
            }

            @Override // p007b.p109f.p161j.p181p.InterfaceC2022y0
            /* JADX INFO: renamed from: a */
            public void mo1438a() {
                a.this.f4020g.m1431a();
                a.this.f4019f = true;
                this.f4023a.mo1426d();
            }

            @Override // p007b.p109f.p161j.p181p.C1974e, p007b.p109f.p161j.p181p.InterfaceC2022y0
            /* JADX INFO: renamed from: b */
            public void mo1439b() {
                if (a.this.f4018e.mo1458p()) {
                    a.this.f4020g.m1434d();
                }
            }
        }

        public a(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0, boolean z2, InterfaceC2033c interfaceC2033c) {
            super(interfaceC1995l);
            this.f4019f = false;
            this.f4018e = interfaceC2020x0;
            Objects.requireNonNull(interfaceC2020x0.mo1447e());
            this.f4016c = z2;
            this.f4017d = interfaceC2033c;
            this.f4020g = new C1969c0(C1970c1.this.f4011a, new C13220a(C1970c1.this), 100);
            interfaceC2020x0.mo1448f(new b(C1970c1.this, interfaceC1995l));
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v10 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(java.lang.Object r10, int r11) {
            /*
                Method dump skipped, instruction units count: 258
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C1970c1.a.mo1320i(java.lang.Object, int):void");
        }

        /* JADX INFO: renamed from: n */
        public final Map<String, String> m1437n(C1919e c1919e, C1884e c1884e, C2031a c2031a, String str) {
            String str2;
            long j;
            if (!this.f4018e.mo1457o().mo1360g(this.f4018e, "ResizeAndRotateProducer")) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            c1919e.m1347x();
            sb.append(c1919e.f3896o);
            sb.append("x");
            c1919e.m1347x();
            sb.append(c1919e.f3897p);
            String string = sb.toString();
            if (c1884e != null) {
                str2 = c1884e.f3717a + "x" + c1884e.f3718b;
            } else {
                str2 = "Unspecified";
            }
            HashMap map = new HashMap();
            c1919e.m1347x();
            map.put("Image format", String.valueOf(c1919e.f3893l));
            map.put("Original size", string);
            map.put("Requested size", str2);
            C1969c0 c1969c0 = this.f4020g;
            synchronized (c1969c0) {
                j = c1969c0.f4008j - c1969c0.f4007i;
            }
            map.put("queueTime", String.valueOf(j));
            map.put("Transcoder id", str);
            map.put("Transcoding result", String.valueOf(c2031a));
            return new C1683f(map);
        }
    }

    public C1970c1(Executor executor, InterfaceC1700g interfaceC1700g, InterfaceC2018w0<C1919e> interfaceC2018w0, boolean z2, InterfaceC2033c interfaceC2033c) {
        Objects.requireNonNull(executor);
        this.f4011a = executor;
        Objects.requireNonNull(interfaceC1700g);
        this.f4012b = interfaceC1700g;
        Objects.requireNonNull(interfaceC2018w0);
        this.f4013c = interfaceC2018w0;
        Objects.requireNonNull(interfaceC2033c);
        this.f4015e = interfaceC2033c;
        this.f4014d = z2;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        this.f4013c.mo1417b(new a(interfaceC1995l, interfaceC2020x0, this.f4014d, this.f4015e), interfaceC2020x0);
    }
}
