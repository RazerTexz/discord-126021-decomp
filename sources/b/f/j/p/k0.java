package b.f.j.p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore$Video$Media;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class k0 implements w0<CloseableReference<b.f.j.j.c>> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f621b;

    public k0(Executor executor, ContentResolver contentResolver) {
        this.a = executor;
        this.f621b = contentResolver;
    }

    public static String c(k0 k0Var, ImageRequest imageRequest) {
        Uri uri;
        String str;
        String[] strArr;
        Objects.requireNonNull(k0Var);
        Uri uri2 = imageRequest.c;
        if (b.f.d.l.b.d(uri2)) {
            return imageRequest.a().getPath();
        }
        if (b.f.d.l.b.c(uri2)) {
            if ("com.android.providers.media.documents".equals(uri2.getAuthority())) {
                String documentId = DocumentsContract.getDocumentId(uri2);
                Objects.requireNonNull(documentId);
                Uri uri3 = MediaStore$Video$Media.EXTERNAL_CONTENT_URI;
                Objects.requireNonNull(uri3);
                str = "_id=?";
                uri = uri3;
                strArr = new String[]{documentId.split(":")[1]};
            } else {
                uri = uri2;
                str = null;
                strArr = null;
            }
            Cursor cursorQuery = k0Var.f621b.query(uri, new String[]{"_data"}, str, strArr, null);
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

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        ImageRequest imageRequestE = x0Var.e();
        x0Var.i("local", MediaStreamTrack.VIDEO_TRACK_KIND);
        k0$a k0_a = new k0$a(this, lVar, z0VarO, x0Var, "VideoThumbnailProducer", z0VarO, x0Var, imageRequestE);
        x0Var.f(new k0$b(this, k0_a));
        this.a.execute(k0_a);
    }
}
