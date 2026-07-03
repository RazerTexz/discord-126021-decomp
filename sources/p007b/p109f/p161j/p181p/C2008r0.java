package p007b.p109f.p161j.p181p;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p109f.p111b.p112a.C1656f;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p122g.AbstractC1702i;
import p007b.p109f.p115d.p122g.InterfaceC1694a;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p160i.C1832c;
import p007b.p109f.p161j.p168c.C1859f;
import p007b.p109f.p161j.p168c.C1867n;
import p007b.p109f.p161j.p168c.CallableC1860g;
import p007b.p109f.p161j.p168c.InterfaceC1862i;
import p007b.p109f.p161j.p169d.C1880a;
import p007b.p109f.p161j.p175j.C1919e;
import p686z.C13202g;

/* JADX INFO: renamed from: b.f.j.p.r0 */
/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2008r0 implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final C1859f f4191a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1862i f4192b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1700g f4193c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1694a f4194d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2018w0<C1919e> f4195e;

    /* JADX INFO: renamed from: b.f.j.p.r0$a */
    /* JADX INFO: compiled from: PartialDiskCacheProducer.java */
    public static class a extends AbstractC2003p<C1919e, C1919e> {

        /* JADX INFO: renamed from: c */
        public final C1859f f4196c;

        /* JADX INFO: renamed from: d */
        public final CacheKey f4197d;

        /* JADX INFO: renamed from: e */
        public final InterfaceC1700g f4198e;

        /* JADX INFO: renamed from: f */
        public final InterfaceC1694a f4199f;

        /* JADX INFO: renamed from: g */
        public final C1919e f4200g;

        /* JADX INFO: renamed from: h */
        public final boolean f4201h;

        public a(InterfaceC1995l interfaceC1995l, C1859f c1859f, CacheKey cacheKey, InterfaceC1700g interfaceC1700g, InterfaceC1694a interfaceC1694a, C1919e c1919e, boolean z2, C2004p0 c2004p0) {
            super(interfaceC1995l);
            this.f4196c = c1859f;
            this.f4197d = cacheKey;
            this.f4198e = interfaceC1700g;
            this.f4199f = interfaceC1694a;
            this.f4200g = c1919e;
            this.f4201h = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [b.f.j.c.f] */
        /* JADX WARN: Type inference failed for: r3v0, types: [b.f.j.p.p, b.f.j.p.r0$a] */
        /* JADX WARN: Type inference failed for: r4v1, types: [b.f.j.j.e, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v2, types: [b.f.j.j.e] */
        /* JADX WARN: Type inference failed for: r4v5, types: [b.f.j.c.f, java.lang.Object] */
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
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            ?? r4 = (C1919e) obj;
            if (AbstractC1965b.m1420f(i)) {
                return;
            }
            C1919e c1919e = this.f4200g;
            if (c1919e != null && r4 != 0) {
                try {
                    if (r4.f3900s != null) {
                        try {
                            m1515p(m1514o(c1919e, r4));
                        } catch (IOException e) {
                            C1691a.m978f("PartialDiskCacheProducer", "Error while merging image data", e);
                            this.f4179b.mo1425c(e);
                        }
                        r4.close();
                        this.f4200g.close();
                        r4 = this.f4196c;
                        CacheKey cacheKey = this.f4197d;
                        Objects.requireNonNull(r4);
                        Objects.requireNonNull(cacheKey);
                        r4.f3666f.m1210c(cacheKey);
                        try {
                            C13202g.m11366a(new CallableC1860g(r4, null, cacheKey), r4.f3665e);
                            return;
                        } catch (Exception e2) {
                            C1691a.m986n(C1859f.class, e2, "Failed to schedule disk-cache remove for %s", cacheKey.mo930b());
                            C13202g.m11367c(e2);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    r4.close();
                    this.f4200g.close();
                    throw th;
                }
            }
            if (this.f4201h && AbstractC1965b.m1422m(i, 8) && AbstractC1965b.m1419e(i) && r4 != 0) {
                r4.m1347x();
                if (r4.f3893l != C1832c.f3597a) {
                    this.f4196c.m1220f(this.f4197d, r4);
                    this.f4179b.mo1424b(r4, i);
                    return;
                }
            }
            this.f4179b.mo1424b(r4, i);
        }

        /* JADX INFO: renamed from: n */
        public final void m1513n(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.f4199f.get(16384);
            int i2 = i;
            while (i2 > 0) {
                try {
                    int i3 = inputStream.read(bArr, 0, Math.min(16384, i2));
                    if (i3 < 0) {
                        break;
                    } else if (i3 > 0) {
                        outputStream.write(bArr, 0, i3);
                        i2 -= i3;
                    }
                } catch (Throwable th) {
                    this.f4199f.release(bArr);
                    throw th;
                }
            }
            this.f4199f.release(bArr);
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        /* JADX INFO: renamed from: o */
        public final AbstractC1702i m1514o(C1919e c1919e, C1919e c1919e2) throws IOException {
            C1880a c1880a = c1919e2.f3900s;
            Objects.requireNonNull(c1880a);
            int i = c1880a.f3704a;
            AbstractC1702i abstractC1702iMo997e = this.f4198e.mo997e(c1919e2.m1344n() + i);
            m1513n(c1919e.m1343f(), abstractC1702iMo997e, i);
            m1513n(c1919e2.m1343f(), abstractC1702iMo997e, c1919e2.m1344n());
            return abstractC1702iMo997e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2, types: [b.f.j.j.e] */
        /* JADX WARN: Type inference failed for: r1v3, types: [b.f.j.j.e, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: p */
        public final void m1515p(AbstractC1702i abstractC1702i) throws Throwable {
            ?? c1919e;
            Throwable th;
            CloseableReference closeableReferenceM8632A = CloseableReference.m8632A(((MemoryPooledByteBufferOutputStream) abstractC1702i).m8707b());
            try {
                c1919e = new C1919e(closeableReferenceM8632A);
                try {
                    c1919e.m1345q();
                    this.f4179b.mo1424b((O) c1919e, 1);
                    c1919e.close();
                    if (closeableReferenceM8632A != null) {
                        closeableReferenceM8632A.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c1919e != null) {
                        c1919e.close();
                    }
                    if (closeableReferenceM8632A != null) {
                        closeableReferenceM8632A.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                c1919e = null;
                th = th3;
            }
        }
    }

    public C2008r0(C1859f c1859f, InterfaceC1862i interfaceC1862i, InterfaceC1700g interfaceC1700g, InterfaceC1694a interfaceC1694a, InterfaceC2018w0<C1919e> interfaceC2018w0) {
        this.f4191a = c1859f;
        this.f4192b = interfaceC1862i;
        this.f4193c = interfaceC1700g;
        this.f4194d = interfaceC1694a;
        this.f4195e = interfaceC2018w0;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: c */
    public static Map<String, String> m1511c(InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, boolean z2, int i) {
        if (interfaceC2024z0.mo1360g(interfaceC2020x0, "PartialDiskCacheProducer")) {
            return z2 ? C1683f.m968of("cached_value_found", String.valueOf(z2), "encodedImageSize", String.valueOf(i)) : C1683f.m967of("cached_value_found", String.valueOf(z2));
        }
        return null;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        ImageRequest imageRequestMo1447e = interfaceC2020x0.mo1447e();
        boolean zM8720b = interfaceC2020x0.mo1447e().m8720b(16);
        InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
        interfaceC2024z0Mo1457o.mo1358e(interfaceC2020x0, "PartialDiskCacheProducer");
        Uri uriBuild = imageRequestMo1447e.f19585c.buildUpon().appendQueryParameter("fresco_partial", "true").build();
        InterfaceC1862i interfaceC1862i = this.f4192b;
        interfaceC2020x0.mo1444b();
        Objects.requireNonNull((C1867n) interfaceC1862i);
        C1656f c1656f = new C1656f(uriBuild.toString());
        if (!zM8720b) {
            interfaceC2024z0Mo1457o.mo1363j(interfaceC2020x0, "PartialDiskCacheProducer", m1511c(interfaceC2024z0Mo1457o, interfaceC2020x0, false, 0));
            m1512d(interfaceC1995l, interfaceC2020x0, c1656f, null);
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.f4191a.m1219e(c1656f, atomicBoolean).m11368b(new C2004p0(this, interfaceC2020x0.mo1457o(), interfaceC2020x0, interfaceC1995l, c1656f));
            interfaceC2020x0.mo1448f(new C2006q0(this, atomicBoolean));
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m1512d(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0, CacheKey cacheKey, C1919e c1919e) {
        this.f4195e.mo1417b(new a(interfaceC1995l, this.f4191a, cacheKey, this.f4193c, this.f4194d, c1919e, interfaceC2020x0.mo1447e().m8720b(32), null), interfaceC2020x0);
    }
}
