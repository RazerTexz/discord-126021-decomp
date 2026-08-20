package p007b.p109f.p161j.p181p;

import android.graphics.Bitmap;
import androidx.core.os.EnvironmentCompat;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p122g.InterfaceC1694a;
import p007b.p109f.p115d.p127l.C1717b;
import p007b.p109f.p160i.C1831b;
import p007b.p109f.p160i.C1832c;
import p007b.p109f.p161j.p169d.C1881b;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p170e.C1886a;
import p007b.p109f.p161j.p173h.C1912e;
import p007b.p109f.p161j.p173h.InterfaceC1909b;
import p007b.p109f.p161j.p173h.InterfaceC1911d;
import p007b.p109f.p161j.p175j.AbstractC1916b;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1918d;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p175j.C1922h;
import p007b.p109f.p161j.p175j.InterfaceC1923i;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.p.n */
/* JADX INFO: compiled from: DecodeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1999n implements InterfaceC2018w0<CloseableReference<AbstractC1917c>> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1694a f4143a;

    /* JADX INFO: renamed from: b */
    public final Executor f4144b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1909b f4145c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1911d f4146d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2018w0<C1919e> f4147e;

    /* JADX INFO: renamed from: f */
    public final boolean f4148f;

    /* JADX INFO: renamed from: g */
    public final boolean f4149g;

    /* JADX INFO: renamed from: h */
    public final boolean f4150h;

    /* JADX INFO: renamed from: i */
    public final int f4151i;

    /* JADX INFO: renamed from: j */
    public final C1886a f4152j;

    /* JADX INFO: renamed from: k */
    public final Runnable f4153k;

    /* JADX INFO: renamed from: l */
    public final Supplier<Boolean> f4154l;

    /* JADX INFO: renamed from: b.f.j.p.n$a */
    /* JADX INFO: compiled from: DecodeProducer.java */
    public class a extends c {
        public a(C1999n c1999n, InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0, boolean z2, int i) {
            super(interfaceC1995l, interfaceC2020x0, z2, i);
        }

        @Override // p007b.p109f.p161j.p181p.C1999n.c
        /* JADX INFO: renamed from: o */
        public int mo1495o(C1919e c1919e) {
            return c1919e.m1344n();
        }

        @Override // p007b.p109f.p161j.p181p.C1999n.c
        /* JADX INFO: renamed from: p */
        public InterfaceC1923i mo1496p() {
            return new C1922h(0, false, false);
        }

        @Override // p007b.p109f.p161j.p181p.C1999n.c
        /* JADX INFO: renamed from: w */
        public synchronized boolean mo1497w(C1919e c1919e, int i) {
            if (AbstractC1965b.m1420f(i)) {
                return false;
            }
            return this.f4162g.m1435f(c1919e, i);
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.n$b */
    /* JADX INFO: compiled from: DecodeProducer.java */
    public class b extends c {

        /* JADX INFO: renamed from: i */
        public final C1912e f4155i;

        /* JADX INFO: renamed from: j */
        public final InterfaceC1911d f4156j;

        /* JADX INFO: renamed from: k */
        public int f4157k;

        public b(C1999n c1999n, InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0, C1912e c1912e, InterfaceC1911d interfaceC1911d, boolean z2, int i) {
            super(interfaceC1995l, interfaceC2020x0, z2, i);
            this.f4155i = c1912e;
            Objects.requireNonNull(interfaceC1911d);
            this.f4156j = interfaceC1911d;
            this.f4157k = 0;
        }

        @Override // p007b.p109f.p161j.p181p.C1999n.c
        /* JADX INFO: renamed from: o */
        public int mo1495o(C1919e c1919e) {
            return this.f4155i.f3878f;
        }

        @Override // p007b.p109f.p161j.p181p.C1999n.c
        /* JADX INFO: renamed from: p */
        public InterfaceC1923i mo1496p() {
            return this.f4156j.mo1324a(this.f4155i.f3877e);
        }

        @Override // p007b.p109f.p161j.p181p.C1999n.c
        /* JADX INFO: renamed from: w */
        public synchronized boolean mo1497w(C1919e c1919e, int i) {
            boolean zM1435f = this.f4162g.m1435f(c1919e, i);
            if ((AbstractC1965b.m1420f(i) || AbstractC1965b.m1422m(i, 8)) && !AbstractC1965b.m1422m(i, 4) && C1919e.m1338u(c1919e)) {
                c1919e.m1347x();
                if (c1919e.f3893l == C1831b.f3585a) {
                    if (!this.f4155i.m1327b(c1919e)) {
                        return false;
                    }
                    int i2 = this.f4155i.f3877e;
                    int i3 = this.f4157k;
                    if (i2 <= i3) {
                        return false;
                    }
                    if (i2 < this.f4156j.mo1325b(i3) && !this.f4155i.f3879g) {
                        return false;
                    }
                    this.f4157k = i2;
                }
            }
            return zM1435f;
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.n$c */
    /* JADX INFO: compiled from: DecodeProducer.java */
    public abstract class c extends AbstractC2003p<C1919e, CloseableReference<AbstractC1917c>> {

        /* JADX INFO: renamed from: c */
        public final InterfaceC2020x0 f4158c;

        /* JADX INFO: renamed from: d */
        public final InterfaceC2024z0 f4159d;

        /* JADX INFO: renamed from: e */
        public final C1881b f4160e;

        /* JADX INFO: renamed from: f */
        public boolean f4161f;

        /* JADX INFO: renamed from: g */
        public final C1969c0 f4162g;

        /* JADX INFO: renamed from: b.f.j.p.n$c$a */
        /* JADX INFO: compiled from: DecodeProducer.java */
        public class a implements C1969c0.c {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ InterfaceC2020x0 f4164a;

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ int f4165b;

            public a(C1999n c1999n, InterfaceC2020x0 interfaceC2020x0, int i) {
                this.f4164a = interfaceC2020x0;
                this.f4165b = i;
            }

            @Override // p007b.p109f.p161j.p181p.C1969c0.c
            /* JADX INFO: renamed from: a */
            public void mo1436a(C1919e c1919e, int i) {
                boolean z2;
                String str;
                long j;
                AbstractC1917c abstractC1917cM1502t;
                int i2 = i;
                if (c1919e != null) {
                    InterfaceC2020x0 interfaceC2020x0 = c.this.f4158c;
                    c1919e.m1347x();
                    interfaceC2020x0.mo1446d("image_format", c1919e.f3893l.f3598b);
                    if (C1999n.this.f4148f || !AbstractC1965b.m1422m(i2, 16)) {
                        ImageRequest imageRequestMo1447e = this.f4164a.mo1447e();
                        if (C1999n.this.f4149g || !C1717b.m1009e(imageRequestMo1447e.f19585c)) {
                            c1919e.f3898q = C1460d.m496a0(imageRequestMo1447e.f19593k, imageRequestMo1447e.f19592j, c1919e, this.f4165b);
                        }
                    }
                    Objects.requireNonNull(this.f4164a.mo1449g().getExperiments());
                    c cVar = c.this;
                    Objects.requireNonNull(cVar);
                    c1919e.m1347x();
                    if (c1919e.f3893l == C1831b.f3585a || !AbstractC1965b.m1420f(i)) {
                        synchronized (cVar) {
                            z2 = cVar.f4161f;
                        }
                        if (z2 || !C1919e.m1338u(c1919e)) {
                            return;
                        }
                        c1919e.m1347x();
                        C1832c c1832c = c1919e.f3893l;
                        String str2 = c1832c != null ? c1832c.f3598b : EnvironmentCompat.MEDIA_UNKNOWN;
                        StringBuilder sb = new StringBuilder();
                        c1919e.m1347x();
                        sb.append(c1919e.f3896o);
                        sb.append("x");
                        c1919e.m1347x();
                        sb.append(c1919e.f3897p);
                        String string = sb.toString();
                        String strValueOf = String.valueOf(c1919e.f3898q);
                        boolean zM1419e = AbstractC1965b.m1419e(i);
                        boolean z3 = zM1419e && !AbstractC1965b.m1422m(i2, 8);
                        boolean zM1422m = AbstractC1965b.m1422m(i2, 4);
                        C1884e c1884e = cVar.f4158c.mo1447e().f19592j;
                        if (c1884e != null) {
                            str = c1884e.f3717a + "x" + c1884e.f3718b;
                        } else {
                            str = EnvironmentCompat.MEDIA_UNKNOWN;
                        }
                        String str3 = str;
                        try {
                            C1969c0 c1969c0 = cVar.f4162g;
                            synchronized (c1969c0) {
                                j = c1969c0.f4008j - c1969c0.f4007i;
                            }
                            String strValueOf2 = String.valueOf(cVar.f4158c.mo1447e().f19585c);
                            int iM1344n = (z3 || zM1422m) ? c1919e.m1344n() : cVar.mo1495o(c1919e);
                            InterfaceC1923i interfaceC1923iMo1496p = (z3 || zM1422m) ? C1922h.f3908a : cVar.mo1496p();
                            cVar.f4159d.mo1358e(cVar.f4158c, "DecodeProducer");
                            try {
                                try {
                                    abstractC1917cM1502t = cVar.m1502t(c1919e, iM1344n, interfaceC1923iMo1496p);
                                    try {
                                        if (c1919e.f3898q != 1) {
                                            i2 |= 16;
                                        }
                                        cVar.f4159d.mo1363j(cVar.f4158c, "DecodeProducer", cVar.m1498n(abstractC1917cM1502t, j, interfaceC1923iMo1496p, zM1419e, str2, string, str3, strValueOf));
                                        cVar.m1504v(c1919e, abstractC1917cM1502t);
                                        cVar.m1501s(abstractC1917cM1502t, i2);
                                    } catch (Exception e) {
                                        e = e;
                                        cVar.f4159d.mo1364k(cVar.f4158c, "DecodeProducer", e, cVar.m1498n(abstractC1917cM1502t, j, interfaceC1923iMo1496p, zM1419e, str2, string, str3, strValueOf));
                                        cVar.m1503u(true);
                                        cVar.f4179b.mo1425c(e);
                                    }
                                } catch (DecodeException e2) {
                                    C1919e c1919eM8696a = e2.m8696a();
                                    C1691a.m987o("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e2.getMessage(), strValueOf2, c1919eM8696a.m1341d(10), Integer.valueOf(c1919eM8696a.m1344n()));
                                    throw e2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                abstractC1917cM1502t = null;
                            }
                            c1919e.close();
                        } catch (Throwable th) {
                            c1919e.close();
                            throw th;
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: b.f.j.p.n$c$b */
        /* JADX INFO: compiled from: DecodeProducer.java */
        public class b extends C1974e {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ boolean f4167a;

            public b(C1999n c1999n, boolean z2) {
                this.f4167a = z2;
            }

            @Override // p007b.p109f.p161j.p181p.InterfaceC2022y0
            /* JADX INFO: renamed from: a */
            public void mo1438a() {
                if (this.f4167a) {
                    c cVar = c.this;
                    cVar.m1503u(true);
                    cVar.f4179b.mo1426d();
                }
            }

            @Override // p007b.p109f.p161j.p181p.C1974e, p007b.p109f.p161j.p181p.InterfaceC2022y0
            /* JADX INFO: renamed from: b */
            public void mo1439b() {
                if (c.this.f4158c.mo1458p()) {
                    c.this.f4162g.m1434d();
                }
            }
        }

        public c(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0, boolean z2, int i) {
            super(interfaceC1995l);
            this.f4158c = interfaceC2020x0;
            this.f4159d = interfaceC2020x0.mo1457o();
            C1881b c1881b = interfaceC2020x0.mo1447e().f19591i;
            this.f4160e = c1881b;
            this.f4161f = false;
            this.f4162g = new C1969c0(C1999n.this.f4144b, new a(C1999n.this, interfaceC2020x0, i), c1881b.f3707b);
            interfaceC2020x0.mo1448f(new b(C1999n.this, z2));
        }

        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: g */
        public void mo1318g() {
            m1499q();
        }

        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            m1500r(th);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0034 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:3:0x0002, B:7:0x000e, B:8:0x001e, B:10:0x0024, B:11:0x0034, B:15:0x003f, B:18:0x0047, B:20:0x004f), top: B:26:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:14:0x003e  */
        /* JADX WARN: Code duplicated, block: B:20:0x004f A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:3:0x0002, B:7:0x000e, B:8:0x001e, B:10:0x0024, B:11:0x0034, B:15:0x003f, B:18:0x0047, B:20:0x004f), top: B:26:0x0002 }] */
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            C1919e c1919e = (C1919e) obj;
            try {
                C2030b.m1527b();
                boolean zM1419e = AbstractC1965b.m1419e(i);
                if (zM1419e) {
                    if (c1919e == null) {
                        ExceptionWithNoStacktrace exceptionWithNoStacktrace = new ExceptionWithNoStacktrace("Encoded image is null.");
                        m1503u(true);
                        this.f4179b.mo1425c(exceptionWithNoStacktrace);
                    } else if (!c1919e.m1346t()) {
                        ExceptionWithNoStacktrace exceptionWithNoStacktrace2 = new ExceptionWithNoStacktrace("Encoded image is not valid.");
                        m1503u(true);
                        this.f4179b.mo1425c(exceptionWithNoStacktrace2);
                    } else if (mo1497w(c1919e, i)) {
                        boolean zM1422m = AbstractC1965b.m1422m(i, 4);
                        if (zM1419e) {
                            this.f4162g.m1434d();
                        } else {
                            this.f4162g.m1434d();
                        }
                    }
                } else if (mo1497w(c1919e, i)) {
                    boolean zM1422m2 = AbstractC1965b.m1422m(i, 4);
                    if (zM1419e || zM1422m2 || this.f4158c.mo1458p()) {
                        this.f4162g.m1434d();
                    }
                }
            } finally {
                C2030b.m1527b();
            }
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
        @Override // p007b.p109f.p161j.p181p.AbstractC2003p, p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: j */
        public void mo1321j(float f) {
            this.f4179b.mo1423a(f * 0.99f);
        }

        /* JADX INFO: renamed from: n */
        public final Map<String, String> m1498n(AbstractC1917c abstractC1917c, long j, InterfaceC1923i interfaceC1923i, boolean z2, String str, String str2, String str3, String str4) {
            if (!this.f4159d.mo1360g(this.f4158c, "DecodeProducer")) {
                return null;
            }
            String strValueOf = String.valueOf(j);
            String strValueOf2 = String.valueOf(((C1922h) interfaceC1923i).f3910c);
            String strValueOf3 = String.valueOf(z2);
            if (!(abstractC1917c instanceof C1918d)) {
                HashMap map = new HashMap(7);
                map.put("queueTime", strValueOf);
                map.put("hasGoodQuality", strValueOf2);
                map.put("isFinal", strValueOf3);
                map.put("encodedImageSize", str2);
                map.put("imageFormat", str);
                map.put("requestedImageSize", str3);
                map.put("sampleSize", str4);
                return new C1683f(map);
            }
            Bitmap bitmap = ((C1918d) abstractC1917c).f3887m;
            Objects.requireNonNull(bitmap);
            String str5 = bitmap.getWidth() + "x" + bitmap.getHeight();
            HashMap map2 = new HashMap(8);
            map2.put("bitmapSize", str5);
            map2.put("queueTime", strValueOf);
            map2.put("hasGoodQuality", strValueOf2);
            map2.put("isFinal", strValueOf3);
            map2.put("encodedImageSize", str2);
            map2.put("imageFormat", str);
            map2.put("requestedImageSize", str3);
            map2.put("sampleSize", str4);
            map2.put("byteCount", bitmap.getByteCount() + "");
            return new C1683f(map2);
        }

        /* JADX INFO: renamed from: o */
        public abstract int mo1495o(C1919e c1919e);

        /* JADX INFO: renamed from: p */
        public abstract InterfaceC1923i mo1496p();

        /* JADX INFO: renamed from: q */
        public final void m1499q() {
            m1503u(true);
            this.f4179b.mo1426d();
        }

        /* JADX INFO: renamed from: r */
        public final void m1500r(Throwable th) {
            m1503u(true);
            this.f4179b.mo1425c(th);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: s */
        public final void m1501s(AbstractC1917c abstractC1917c, int i) {
            CloseableReference.InterfaceC10637c interfaceC10637c = C1999n.this.f4152j.f3725a;
            Class<CloseableReference> cls = CloseableReference.f19438j;
            CloseableReference closeableReferenceM8635I = null;
            if (abstractC1917c != null) {
                closeableReferenceM8635I = CloseableReference.m8635I(abstractC1917c, CloseableReference.f19440l, interfaceC10637c, interfaceC10637c.mo1253b() ? new Throwable() : null);
            }
            try {
                m1503u(AbstractC1965b.m1419e(i));
                this.f4179b.mo1424b(closeableReferenceM8635I, i);
            } finally {
                if (closeableReferenceM8635I != null) {
                    closeableReferenceM8635I.close();
                }
            }
        }

        /* JADX INFO: renamed from: t */
        public final AbstractC1917c m1502t(C1919e c1919e, int i, InterfaceC1923i interfaceC1923i) {
            C1999n c1999n = C1999n.this;
            boolean z2 = c1999n.f4153k != null && c1999n.f4154l.get().booleanValue();
            try {
                return C1999n.this.f4145c.mo1322a(c1919e, i, interfaceC1923i, this.f4160e);
            } catch (OutOfMemoryError e) {
                if (!z2) {
                    throw e;
                }
                C1999n.this.f4153k.run();
                System.gc();
                return C1999n.this.f4145c.mo1322a(c1919e, i, interfaceC1923i, this.f4160e);
            }
        }

        /* JADX INFO: renamed from: u */
        public final void m1503u(boolean z2) {
            synchronized (this) {
                if (z2) {
                    if (!this.f4161f) {
                        this.f4179b.mo1423a(1.0f);
                        this.f4161f = true;
                        this.f4162g.m1431a();
                    }
                }
            }
        }

        /* JADX INFO: renamed from: v */
        public final void m1504v(C1919e c1919e, AbstractC1917c abstractC1917c) {
            InterfaceC2020x0 interfaceC2020x0 = this.f4158c;
            c1919e.m1347x();
            interfaceC2020x0.mo1446d("encoded_width", Integer.valueOf(c1919e.f3896o));
            InterfaceC2020x0 interfaceC2020x1 = this.f4158c;
            c1919e.m1347x();
            interfaceC2020x1.mo1446d("encoded_height", Integer.valueOf(c1919e.f3897p));
            this.f4158c.mo1446d("encoded_size", Integer.valueOf(c1919e.m1344n()));
            if (abstractC1917c instanceof AbstractC1916b) {
                Bitmap bitmapMo1332f = ((AbstractC1916b) abstractC1917c).mo1332f();
                this.f4158c.mo1446d("bitmap_config", String.valueOf(bitmapMo1332f == null ? null : bitmapMo1332f.getConfig()));
            }
            if (abstractC1917c != null) {
                abstractC1917c.m1335e(this.f4158c.mo1443a());
            }
        }

        /* JADX INFO: renamed from: w */
        public abstract boolean mo1497w(C1919e c1919e, int i);
    }

    public C1999n(InterfaceC1694a interfaceC1694a, Executor executor, InterfaceC1909b interfaceC1909b, InterfaceC1911d interfaceC1911d, boolean z2, boolean z3, boolean z4, InterfaceC2018w0<C1919e> interfaceC2018w0, int i, C1886a c1886a, Runnable runnable, Supplier<Boolean> supplier) {
        Objects.requireNonNull(interfaceC1694a);
        this.f4143a = interfaceC1694a;
        Objects.requireNonNull(executor);
        this.f4144b = executor;
        Objects.requireNonNull(interfaceC1909b);
        this.f4145c = interfaceC1909b;
        Objects.requireNonNull(interfaceC1911d);
        this.f4146d = interfaceC1911d;
        this.f4148f = z2;
        this.f4149g = z3;
        Objects.requireNonNull(interfaceC2018w0);
        this.f4147e = interfaceC2018w0;
        this.f4150h = z4;
        this.f4151i = i;
        this.f4152j = c1886a;
        this.f4153k = null;
        this.f4154l = supplier;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        try {
            C2030b.m1527b();
            this.f4147e.mo1417b(!C1717b.m1009e(interfaceC2020x0.mo1447e().f19585c) ? new a(this, interfaceC1995l, interfaceC2020x0, this.f4150h, this.f4151i) : new b(this, interfaceC1995l, interfaceC2020x0, new C1912e(this.f4143a), this.f4146d, this.f4150h, this.f4151i), interfaceC2020x0);
        } finally {
            C2030b.m1527b();
        }
    }
}
