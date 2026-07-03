package p007b.p109f.p161j.p181p;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p119d.C1678a;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.g0 */
/* JADX INFO: compiled from: LocalFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1981g0 implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final Executor f4060a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1700g f4061b;

    /* JADX INFO: renamed from: b.f.j.p.g0$a */
    /* JADX INFO: compiled from: LocalFetchProducer.java */
    public class a extends AbstractRunnableC1976e1<C1919e> {

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ ImageRequest f4062o;

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ InterfaceC2024z0 f4063p;

        /* JADX INFO: renamed from: q */
        public final /* synthetic */ InterfaceC2020x0 f4064q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC1995l interfaceC1995l, InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, String str, ImageRequest imageRequest, InterfaceC2024z0 interfaceC2024z1, InterfaceC2020x0 interfaceC2020x1) {
            super(interfaceC1995l, interfaceC2024z0, interfaceC2020x0, str);
            this.f4062o = imageRequest;
            this.f4063p = interfaceC2024z1;
            this.f4064q = interfaceC2020x1;
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: b */
        public void mo1465b(C1919e c1919e) {
            C1919e c1919e2 = c1919e;
            if (c1919e2 != null) {
                c1919e2.close();
            }
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: d */
        public C1919e mo1467d() throws Exception {
            C1919e c1919eMo1428d = AbstractC1981g0.this.mo1428d(this.f4062o);
            if (c1919eMo1428d == null) {
                this.f4063p.mo1356c(this.f4064q, AbstractC1981g0.this.mo1429e(), false);
                this.f4064q.mo1456n("local");
                return null;
            }
            c1919eMo1428d.m1345q();
            this.f4063p.mo1356c(this.f4064q, AbstractC1981g0.this.mo1429e(), true);
            this.f4064q.mo1456n("local");
            return c1919eMo1428d;
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.g0$b */
    /* JADX INFO: compiled from: LocalFetchProducer.java */
    public class b extends C1974e {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ AbstractRunnableC1976e1 f4066a;

        public b(AbstractC1981g0 abstractC1981g0, AbstractRunnableC1976e1 abstractRunnableC1976e1) {
            this.f4066a = abstractRunnableC1976e1;
        }

        @Override // p007b.p109f.p161j.p181p.InterfaceC2022y0
        /* JADX INFO: renamed from: a */
        public void mo1438a() {
            this.f4066a.m1464a();
        }
    }

    public AbstractC1981g0(Executor executor, InterfaceC1700g interfaceC1700g) {
        this.f4060a = executor;
        this.f4061b = interfaceC1700g;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
        ImageRequest imageRequestMo1447e = interfaceC2020x0.mo1447e();
        interfaceC2020x0.mo1451i("local", "fetch");
        a aVar = new a(interfaceC1995l, interfaceC2024z0Mo1457o, interfaceC2020x0, mo1429e(), imageRequestMo1447e, interfaceC2024z0Mo1457o, interfaceC2020x0);
        interfaceC2020x0.mo1448f(new b(this, aVar));
        this.f4060a.execute(aVar);
    }

    /* JADX INFO: renamed from: c */
    public C1919e m1478c(InputStream inputStream, int i) throws IOException {
        CloseableReference closeableReferenceM8632A = null;
        try {
            closeableReferenceM8632A = i <= 0 ? CloseableReference.m8632A(this.f4061b.mo995c(inputStream)) : CloseableReference.m8632A(this.f4061b.mo996d(inputStream, i));
            C1919e c1919e = new C1919e(closeableReferenceM8632A);
            C1678a.m966b(inputStream);
            if (closeableReferenceM8632A != null) {
                closeableReferenceM8632A.close();
            }
            return c1919e;
        } catch (Throwable th) {
            C1678a.m966b(inputStream);
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReferenceM8632A != null) {
                closeableReferenceM8632A.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    public abstract C1919e mo1428d(ImageRequest imageRequest) throws IOException;

    /* JADX INFO: renamed from: e */
    public abstract String mo1429e();
}
