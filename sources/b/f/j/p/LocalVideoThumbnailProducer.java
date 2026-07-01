package b.f.j.p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import b.f.d.d.ImmutableMap;
import b.f.d.l.UriUtil;
import b.f.j.b.SimpleBitmapReleaser;
import b.f.j.d.ResizeOptions;
import b.f.j.j.CloseableImage;
import b.f.j.j.CloseableStaticBitmap;
import b.f.j.j.ImmutableQualityInfo;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: renamed from: b.f.j.p.k0, reason: use source file name */
/* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class LocalVideoThumbnailProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f621b;

    /* JADX INFO: renamed from: b.f.j.p.k0$a */
    /* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
    public class a extends StatefulProducerRunnable<CloseableReference<CloseableImage>> {
        public final /* synthetic */ ProducerListener2 o;
        public final /* synthetic */ ProducerContext p;
        public final /* synthetic */ ImageRequest q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ProducerListener2 producerListener3, ProducerContext producerContext2, ImageRequest imageRequest) {
            super(consumer2, producerListener2, producerContext, str);
            this.o = producerListener3;
            this.p = producerContext2;
            this.q = imageRequest;
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

        /* JADX WARN: Code duplicated, block: B:18:0x0027  */
        @Override // b.f.j.p.StatefulProducerRunnable
        public CloseableReference<CloseableImage> d() throws Exception {
            String strC;
            Bitmap frameAtTime;
            int i;
            try {
                strC = LocalVideoThumbnailProducer.c(LocalVideoThumbnailProducer.this, this.q);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                ResizeOptions resizeOptions = this.q.j;
                if ((resizeOptions != null ? resizeOptions.a : 2048) > 96) {
                    i = 1;
                } else {
                    if ((resizeOptions != null ? resizeOptions.f566b : 2048) > 96) {
                        i = 1;
                    } else {
                        i = 3;
                    }
                }
                frameAtTime = ThumbnailUtils.createVideoThumbnail(strC, i);
            } else {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = LocalVideoThumbnailProducer.this.f621b.openFileDescriptor(this.q.c, "r");
                    Objects.requireNonNull(parcelFileDescriptorOpenFileDescriptor);
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
                } catch (FileNotFoundException unused2) {
                    frameAtTime = null;
                }
            }
            if (frameAtTime == null) {
                return null;
            }
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(frameAtTime, SimpleBitmapReleaser.a(), ImmutableQualityInfo.a, 0);
            this.p.d("image_format", "thumbnail");
            closeableStaticBitmap.e(this.p.a());
            return CloseableReference.A(closeableStaticBitmap);
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public void f(Exception exc) {
            super.f(exc);
            this.o.c(this.p, "VideoThumbnailProducer", false);
            this.p.n("local");
        }

        @Override // b.f.j.p.StatefulProducerRunnable
        public void g(CloseableReference<CloseableImage> closeableReference) {
            CloseableReference<CloseableImage> closeableReference2 = closeableReference;
            super.g(closeableReference2);
            this.o.c(this.p, "VideoThumbnailProducer", closeableReference2 != null);
            this.p.n("local");
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.k0$b */
    /* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
    public class b extends BaseProducerContextCallbacks {
        public final /* synthetic */ StatefulProducerRunnable a;

        public b(LocalVideoThumbnailProducer localVideoThumbnailProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.a = statefulProducerRunnable;
        }

        @Override // b.f.j.p.ProducerContextCallbacks
        public void a() {
            this.a.a();
        }
    }

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.a = executor;
        this.f621b = contentResolver;
    }

    public static String c(LocalVideoThumbnailProducer localVideoThumbnailProducer, ImageRequest imageRequest) {
        Uri uri;
        String str;
        String[] strArr;
        Objects.requireNonNull(localVideoThumbnailProducer);
        Uri uri2 = imageRequest.c;
        if (UriUtil.d(uri2)) {
            return imageRequest.a().getPath();
        }
        if (UriUtil.c(uri2)) {
            if ("com.android.providers.media.documents".equals(uri2.getAuthority())) {
                String documentId = DocumentsContract.getDocumentId(uri2);
                Objects.requireNonNull(documentId);
                Uri uri3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                Objects.requireNonNull(uri3);
                str = "_id=?";
                uri = uri3;
                strArr = new String[]{documentId.split(":")[1]};
            } else {
                uri = uri2;
                str = null;
                strArr = null;
            }
            Cursor cursorQuery = localVideoThumbnailProducer.f621b.query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return null;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2O = producerContext.o();
        ImageRequest imageRequestE = producerContext.e();
        producerContext.i("local", MediaStreamTrack.VIDEO_TRACK_KIND);
        a aVar = new a(consumer2, producerListener2O, producerContext, "VideoThumbnailProducer", producerListener2O, producerContext, imageRequestE);
        producerContext.f(new b(this, aVar));
        this.a.execute(aVar);
    }
}
