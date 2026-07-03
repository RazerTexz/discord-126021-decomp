package p007b.p109f.p161j.p181p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.webrtc.MediaStreamTrack;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p115d.p127l.C1717b;
import p007b.p109f.p161j.p167b.C1851b;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p175j.C1918d;
import p007b.p109f.p161j.p175j.C1922h;

/* JADX INFO: renamed from: b.f.j.p.k0 */
/* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1993k0 implements InterfaceC2018w0<CloseableReference<AbstractC1917c>> {

    /* JADX INFO: renamed from: a */
    public final Executor f4120a;

    /* JADX INFO: renamed from: b */
    public final ContentResolver f4121b;

    /* JADX INFO: renamed from: b.f.j.p.k0$a */
    /* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
    public class a extends AbstractRunnableC1976e1<CloseableReference<AbstractC1917c>> {

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ InterfaceC2024z0 f4122o;

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ InterfaceC2020x0 f4123p;

        /* JADX INFO: renamed from: q */
        public final /* synthetic */ ImageRequest f4124q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC1995l interfaceC1995l, InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, String str, InterfaceC2024z0 interfaceC2024z1, InterfaceC2020x0 interfaceC2020x1, ImageRequest imageRequest) {
            super(interfaceC1995l, interfaceC2024z0, interfaceC2020x0, str);
            this.f4122o = interfaceC2024z1;
            this.f4123p = interfaceC2020x1;
            this.f4124q = imageRequest;
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

        /* JADX WARN: Code duplicated, block: B:18:0x0027  */
        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: d */
        public CloseableReference<AbstractC1917c> mo1467d() throws Exception {
            String strM1481c;
            Bitmap frameAtTime;
            int i;
            try {
                strM1481c = C1993k0.m1481c(C1993k0.this, this.f4124q);
            } catch (IllegalArgumentException unused) {
                strM1481c = null;
            }
            if (strM1481c != null) {
                C1884e c1884e = this.f4124q.f19592j;
                if ((c1884e != null ? c1884e.f3717a : 2048) > 96) {
                    i = 1;
                } else {
                    if ((c1884e != null ? c1884e.f3718b : 2048) > 96) {
                        i = 1;
                    } else {
                        i = 3;
                    }
                }
                frameAtTime = ThumbnailUtils.createVideoThumbnail(strM1481c, i);
            } else {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = C1993k0.this.f4121b.openFileDescriptor(this.f4124q.f19585c, "r");
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
            C1918d c1918d = new C1918d(frameAtTime, C1851b.m1207a(), C1922h.f3908a, 0);
            this.f4123p.mo1446d("image_format", "thumbnail");
            c1918d.m1335e(this.f4123p.mo1443a());
            return CloseableReference.m8632A(c1918d);
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: f */
        public void mo1469f(Exception exc) {
            super.mo1469f(exc);
            this.f4122o.mo1356c(this.f4123p, "VideoThumbnailProducer", false);
            this.f4123p.mo1456n("local");
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: g */
        public void mo1470g(CloseableReference<AbstractC1917c> closeableReference) {
            CloseableReference<AbstractC1917c> closeableReference2 = closeableReference;
            super.mo1470g(closeableReference2);
            this.f4122o.mo1356c(this.f4123p, "VideoThumbnailProducer", closeableReference2 != null);
            this.f4123p.mo1456n("local");
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.k0$b */
    /* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
    public class b extends C1974e {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ AbstractRunnableC1976e1 f4126a;

        public b(C1993k0 c1993k0, AbstractRunnableC1976e1 abstractRunnableC1976e1) {
            this.f4126a = abstractRunnableC1976e1;
        }

        @Override // p007b.p109f.p161j.p181p.InterfaceC2022y0
        /* JADX INFO: renamed from: a */
        public void mo1438a() {
            this.f4126a.m1464a();
        }
    }

    public C1993k0(Executor executor, ContentResolver contentResolver) {
        this.f4120a = executor;
        this.f4121b = contentResolver;
    }

    /* JADX INFO: renamed from: c */
    public static String m1481c(C1993k0 c1993k0, ImageRequest imageRequest) {
        Uri uri;
        String str;
        String[] strArr;
        Objects.requireNonNull(c1993k0);
        Uri uri2 = imageRequest.f19585c;
        if (C1717b.m1008d(uri2)) {
            return imageRequest.m8719a().getPath();
        }
        if (C1717b.m1007c(uri2)) {
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
            Cursor cursorQuery = c1993k0.f4121b.query(uri, new String[]{"_data"}, str, strArr, null);
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

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
        ImageRequest imageRequestMo1447e = interfaceC2020x0.mo1447e();
        interfaceC2020x0.mo1451i("local", MediaStreamTrack.VIDEO_TRACK_KIND);
        a aVar = new a(interfaceC1995l, interfaceC2024z0Mo1457o, interfaceC2020x0, "VideoThumbnailProducer", interfaceC2024z0Mo1457o, interfaceC2020x0, imageRequestMo1447e);
        interfaceC2020x0.mo1448f(new b(this, aVar));
        this.f4120a.execute(aVar);
    }
}
