package p007b.p109f.p161j.p181p;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Size;
import androidx.annotation.RequiresApi;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p161j.p167b.C1851b;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1918d;
import p007b.p109f.p161j.p175j.C1922h;

/* JADX INFO: renamed from: b.f.j.p.j0 */
/* JADX INFO: compiled from: LocalThumbnailBitmapProducer.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
public class C1990j0 implements InterfaceC2018w0<CloseableReference<AbstractC1917c>> {

    /* JADX INFO: renamed from: a */
    public final Executor f4103a;

    /* JADX INFO: renamed from: b */
    public final ContentResolver f4104b;

    /* JADX INFO: renamed from: b.f.j.p.j0$a */
    /* JADX INFO: compiled from: LocalThumbnailBitmapProducer.java */
    public class a extends AbstractRunnableC1976e1<CloseableReference<AbstractC1917c>> {

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ InterfaceC2024z0 f4105o;

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ InterfaceC2020x0 f4106p;

        /* JADX INFO: renamed from: q */
        public final /* synthetic */ ImageRequest f4107q;

        /* JADX INFO: renamed from: r */
        public final /* synthetic */ CancellationSignal f4108r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC1995l interfaceC1995l, InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, String str, InterfaceC2024z0 interfaceC2024z1, InterfaceC2020x0 interfaceC2020x1, ImageRequest imageRequest, CancellationSignal cancellationSignal) {
            super(interfaceC1995l, interfaceC2024z0, interfaceC2020x0, str);
            this.f4105o = interfaceC2024z1;
            this.f4106p = interfaceC2020x1;
            this.f4107q = imageRequest;
            this.f4108r = cancellationSignal;
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: b */
        public void mo1465b(CloseableReference<AbstractC1917c> closeableReference) {
            CloseableReference<AbstractC1917c> closeableReference2 = closeableReference;
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: c */
        public Map mo1466c(CloseableReference<AbstractC1917c> closeableReference) {
            return C1683f.m967of("createdThumbnail", String.valueOf(closeableReference != null));
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: d */
        public CloseableReference<AbstractC1917c> mo1467d() throws Exception {
            ContentResolver contentResolver = C1990j0.this.f4104b;
            Uri uri = this.f4107q.f19585c;
            C1884e c1884e = this.f4107q.f19592j;
            Bitmap bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new Size(c1884e != null ? c1884e.f3717a : 2048, c1884e != null ? c1884e.f3718b : 2048), this.f4108r);
            if (bitmapLoadThumbnail == null) {
                return null;
            }
            C1918d c1918d = new C1918d(bitmapLoadThumbnail, C1851b.m1207a(), C1922h.f3908a, 0);
            this.f4106p.mo1446d("image_format", "thumbnail");
            c1918d.m1335e(this.f4106p.mo1443a());
            return CloseableReference.m8632A(c1918d);
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: e */
        public void mo1468e() {
            super.mo1468e();
            this.f4108r.cancel();
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: f */
        public void mo1469f(Exception exc) {
            super.mo1469f(exc);
            this.f4105o.mo1356c(this.f4106p, "LocalThumbnailBitmapProducer", false);
            this.f4106p.mo1456n("local");
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: g */
        public void mo1470g(CloseableReference<AbstractC1917c> closeableReference) {
            CloseableReference<AbstractC1917c> closeableReference2 = closeableReference;
            super.mo1470g(closeableReference2);
            this.f4105o.mo1356c(this.f4106p, "LocalThumbnailBitmapProducer", closeableReference2 != null);
            this.f4106p.mo1456n("local");
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.j0$b */
    /* JADX INFO: compiled from: LocalThumbnailBitmapProducer.java */
    public class b extends C1974e {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ AbstractRunnableC1976e1 f4110a;

        public b(C1990j0 c1990j0, AbstractRunnableC1976e1 abstractRunnableC1976e1) {
            this.f4110a = abstractRunnableC1976e1;
        }

        @Override // p007b.p109f.p161j.p181p.InterfaceC2022y0
        /* JADX INFO: renamed from: a */
        public void mo1438a() {
            this.f4110a.m1464a();
        }
    }

    public C1990j0(Executor executor, ContentResolver contentResolver) {
        this.f4103a = executor;
        this.f4104b = contentResolver;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
        ImageRequest imageRequestMo1447e = interfaceC2020x0.mo1447e();
        interfaceC2020x0.mo1451i("local", "thumbnail_bitmap");
        a aVar = new a(interfaceC1995l, interfaceC2024z0Mo1457o, interfaceC2020x0, "LocalThumbnailBitmapProducer", interfaceC2024z0Mo1457o, interfaceC2020x0, imageRequestMo1447e, new CancellationSignal());
        interfaceC2020x0.mo1448f(new b(this, aVar));
        this.f4103a.execute(aVar);
    }
}
