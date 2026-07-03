package p007b.p109f.p161j.p181p;

import android.os.SystemClock;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;
import p007b.p109f.p115d.p122g.AbstractC1702i;
import p007b.p109f.p115d.p122g.InterfaceC1694a;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p169d.C1880a;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p175j.EnumC1920f;
import p007b.p109f.p161j.p181p.C1963a0;
import p007b.p109f.p161j.p181p.InterfaceC2002o0;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.p.n0 */
/* JADX INFO: compiled from: NetworkFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2000n0 implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1700g f4169a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1694a f4170b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2002o0 f4171c;

    /* JADX INFO: renamed from: b.f.j.p.n0$a */
    /* JADX INFO: compiled from: NetworkFetchProducer.java */
    public class a implements InterfaceC2002o0.a {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ C2019x f4172a;

        public a(C2019x c2019x) {
            this.f4172a = c2019x;
        }

        /* JADX INFO: renamed from: a */
        public void m1508a(Throwable th) {
            C2000n0 c2000n0 = C2000n0.this;
            C2019x c2019x = this.f4172a;
            Objects.requireNonNull(c2000n0);
            c2019x.m1524a().mo1364k(c2019x.f4259b, "NetworkFetchProducer", th, null);
            c2019x.m1524a().mo1356c(c2019x.f4259b, "NetworkFetchProducer", false);
            c2019x.f4259b.mo1456n("network");
            c2019x.f4258a.mo1425c(th);
        }

        /* JADX INFO: renamed from: b */
        public void m1509b(InputStream inputStream, int i) throws Throwable {
            C2030b.m1527b();
            C2000n0 c2000n0 = C2000n0.this;
            C2019x c2019x = this.f4172a;
            AbstractC1702i abstractC1702iMo997e = i > 0 ? c2000n0.f4169a.mo997e(i) : c2000n0.f4169a.mo993a();
            byte[] bArr = c2000n0.f4170b.get(16384);
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 < 0) {
                        InterfaceC2002o0 interfaceC2002o0 = c2000n0.f4171c;
                        int i3 = ((MemoryPooledByteBufferOutputStream) abstractC1702iMo997e).f19562l;
                        C1963a0 c1963a0 = (C1963a0) interfaceC2002o0;
                        Objects.requireNonNull(c1963a0);
                        ((C1963a0.a) c2019x).f3992f = c1963a0.f3989c.now();
                        c2000n0.m1506c(abstractC1702iMo997e, c2019x);
                        c2000n0.f4170b.release(bArr);
                        abstractC1702iMo997e.close();
                        C2030b.m1527b();
                        return;
                    }
                    if (i2 > 0) {
                        abstractC1702iMo997e.write(bArr, 0, i2);
                        c2000n0.m1507d(abstractC1702iMo997e, c2019x);
                        int i4 = ((MemoryPooledByteBufferOutputStream) abstractC1702iMo997e).f19562l;
                        c2019x.f4258a.mo1423a(i > 0 ? i4 / i : 1.0f - ((float) Math.exp(((double) (-i4)) / 50000.0d)));
                    }
                } catch (Throwable th) {
                    c2000n0.f4170b.release(bArr);
                    abstractC1702iMo997e.close();
                    throw th;
                }
            }
        }
    }

    public C2000n0(InterfaceC1700g interfaceC1700g, InterfaceC1694a interfaceC1694a, InterfaceC2002o0 interfaceC2002o0) {
        this.f4169a = interfaceC1700g;
        this.f4170b = interfaceC1694a;
        this.f4171c = interfaceC2002o0;
    }

    /* JADX INFO: renamed from: e */
    public static void m1505e(AbstractC1702i abstractC1702i, int i, C1880a c1880a, InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) throws Throwable {
        CloseableReference closeableReferenceM8632A = CloseableReference.m8632A(((MemoryPooledByteBufferOutputStream) abstractC1702i).m8707b());
        C1919e c1919e = null;
        try {
            C1919e c1919e2 = new C1919e(closeableReferenceM8632A);
            try {
                c1919e2.f3900s = null;
                c1919e2.m1345q();
                interfaceC2020x0.mo1450h(EnumC1920f.NETWORK);
                interfaceC1995l.mo1424b(c1919e2, i);
                c1919e2.close();
                if (closeableReferenceM8632A != null) {
                    closeableReferenceM8632A.close();
                }
            } catch (Throwable th) {
                th = th;
                c1919e = c1919e2;
                if (c1919e != null) {
                    c1919e.close();
                }
                if (closeableReferenceM8632A != null) {
                    closeableReferenceM8632A.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        interfaceC2020x0.mo1457o().mo1358e(interfaceC2020x0, "NetworkFetchProducer");
        Objects.requireNonNull((C1963a0) this.f4171c);
        C1963a0.a aVar = new C1963a0.a(interfaceC1995l, interfaceC2020x0);
        InterfaceC2002o0 interfaceC2002o0 = this.f4171c;
        a aVar2 = new a(aVar);
        C1963a0 c1963a0 = (C1963a0) interfaceC2002o0;
        Objects.requireNonNull(c1963a0);
        aVar.f3990d = c1963a0.f3989c.now();
        interfaceC2020x0.mo1448f(new C2023z(c1963a0, c1963a0.f3988b.submit(new RunnableC2021y(c1963a0, aVar, aVar2)), aVar2));
    }

    /* JADX INFO: renamed from: c */
    public void m1506c(AbstractC1702i abstractC1702i, C2019x c2019x) throws Throwable {
        HashMap map;
        int i = ((MemoryPooledByteBufferOutputStream) abstractC1702i).f19562l;
        if (c2019x.m1524a().mo1360g(c2019x.f4259b, "NetworkFetchProducer")) {
            Objects.requireNonNull((C1963a0) this.f4171c);
            C1963a0.a aVar = (C1963a0.a) c2019x;
            map = new HashMap(4);
            map.put("queue_time", Long.toString(aVar.f3991e - aVar.f3990d));
            map.put("fetch_time", Long.toString(aVar.f3992f - aVar.f3991e));
            map.put("total_time", Long.toString(aVar.f3992f - aVar.f3990d));
            map.put("image_size", Integer.toString(i));
        } else {
            map = null;
        }
        InterfaceC2024z0 interfaceC2024z0M1524a = c2019x.m1524a();
        interfaceC2024z0M1524a.mo1363j(c2019x.f4259b, "NetworkFetchProducer", map);
        interfaceC2024z0M1524a.mo1356c(c2019x.f4259b, "NetworkFetchProducer", true);
        c2019x.f4259b.mo1456n("network");
        m1505e(abstractC1702i, 1, null, c2019x.f4258a, c2019x.f4259b);
    }

    /* JADX INFO: renamed from: d */
    public void m1507d(AbstractC1702i abstractC1702i, C2019x c2019x) throws Throwable {
        boolean z2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (c2019x.f4259b.mo1458p()) {
            Objects.requireNonNull(this.f4171c);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || jUptimeMillis - c2019x.f4260c < 100) {
            return;
        }
        c2019x.f4260c = jUptimeMillis;
        c2019x.m1524a().mo1354a(c2019x.f4259b, "NetworkFetchProducer", "intermediate_result");
        m1505e(abstractC1702i, 0, null, c2019x.f4258a, c2019x.f4259b);
    }
}
