package b.f.j.p;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Size;
import androidx.annotation.RequiresApi;
import b.f.d.d.ImmutableMap;
import b.f.j.b.SimpleBitmapReleaser;
import b.f.j.d.ResizeOptions;
import b.f.j.j.CloseableImage;
import b.f.j.j.CloseableStaticBitmap;
import b.f.j.j.ImmutableQualityInfo;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.j0, reason: use source file name */
/* JADX INFO: compiled from: LocalThumbnailBitmapProducer.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
public class LocalThumbnailBitmapProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f618b;

    /* JADX INFO: renamed from: b.f.j.p.j0$a */
    /* JADX INFO: compiled from: LocalThumbnailBitmapProducer.java */
    public class a extends StatefulProducerRunnable<CloseableReference<CloseableImage>> {
        public final /* synthetic */ ProducerListener2 o;
        public final /* synthetic */ ProducerContext p;
        public final /* synthetic */ ImageRequest q;
        public final /* synthetic */ CancellationSignal r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ProducerListener2 producerListener3, ProducerContext producerContext2, ImageRequest imageRequest, CancellationSignal cancellationSignal) {
            super(consumer2, producerListener2, producerContext, str);
            this.o = producerListener3;
            this.p = producerContext2;
            this.q = imageRequest;
            this.r = cancellationSignal;
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public void b(CloseableReference<CloseableImage> closeableReference) {
            CloseableReference<CloseableImage> closeableReference2 = closeableReference;
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public Map c(CloseableReference<CloseableImage> closeableReference) {
            return ImmutableMap.of("createdThumbnail", String.valueOf(closeableReference != null));
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public CloseableReference<CloseableImage> d() throws Exception {
            ContentResolver contentResolver = LocalThumbnailBitmapProducer.this.f618b;
            Uri uri = this.q.c;
            ResizeOptions resizeOptions = this.q.j;
            Bitmap bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new Size(resizeOptions != null ? resizeOptions.a : 2048, resizeOptions != null ? resizeOptions.f566b : 2048), this.r);
            if (bitmapLoadThumbnail == null) {
                return null;
            }
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(bitmapLoadThumbnail, SimpleBitmapReleaser.a(), ImmutableQualityInfo.a, 0);
            this.p.d("image_format", "thumbnail");
            closeableStaticBitmap.e(this.p.a());
            return CloseableReference.A(closeableStaticBitmap);
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public void e() {
            super.e();
            this.r.cancel();
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public void f(Exception exc) {
            super.f(exc);
            this.o.c(this.p, "LocalThumbnailBitmapProducer", false);
            this.p.n("local");
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public void g(CloseableReference<CloseableImage> closeableReference) {
            CloseableReference<CloseableImage> closeableReference2 = closeableReference;
            super.g(closeableReference2);
            this.o.c(this.p, "LocalThumbnailBitmapProducer", closeableReference2 != null);
            this.p.n("local");
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.j0$b */
    /* JADX INFO: compiled from: LocalThumbnailBitmapProducer.java */
    public class b extends BaseProducerContextCallbacks {
        public final /* synthetic */ StatefulProducerRunnable a;

        public b(LocalThumbnailBitmapProducer localThumbnailBitmapProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.a = statefulProducerRunnable;
        }

        @Override // b.f.j.p.ProducerContextCallbacks
        public void a() {
            this.a.a();
        }
    }

    public LocalThumbnailBitmapProducer(Executor executor, ContentResolver contentResolver) {
        this.a = executor;
        this.f618b = contentResolver;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2O = producerContext.o();
        ImageRequest imageRequestE = producerContext.e();
        producerContext.i("local", "thumbnail_bitmap");
        a aVar = new a(consumer2, producerListener2O, producerContext, "LocalThumbnailBitmapProducer", producerListener2O, producerContext, imageRequestE, new CancellationSignal());
        producerContext.f(new b(this, aVar));
        this.a.execute(aVar);
    }
}
