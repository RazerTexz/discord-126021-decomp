package p007b.p109f.p161j.p181p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p115d.p127l.C1717b;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.f0 */
/* JADX INFO: compiled from: LocalContentUriThumbnailFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1978f0 extends AbstractC1981g0 implements InterfaceC1994k1<C1919e> {

    /* JADX INFO: renamed from: c */
    public static final String[] f4046c = {"_id", "_data"};

    /* JADX INFO: renamed from: d */
    public static final String[] f4047d = {"_data"};

    /* JADX INFO: renamed from: e */
    public static final Rect f4048e = new Rect(0, 0, 512, 384);

    /* JADX INFO: renamed from: f */
    public static final Rect f4049f = new Rect(0, 0, 96, 96);

    /* JADX INFO: renamed from: g */
    public final ContentResolver f4050g;

    public C1978f0(Executor executor, InterfaceC1700g interfaceC1700g, ContentResolver contentResolver) {
        super(executor, interfaceC1700g);
        this.f4050g = contentResolver;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1994k1
    /* JADX INFO: renamed from: a */
    public boolean mo1474a(C1884e c1884e) {
        Rect rect = f4048e;
        return C1460d.m472S0(rect.width(), rect.height(), c1884e);
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: d */
    public C1919e mo1428d(ImageRequest imageRequest) throws IOException {
        C1884e c1884e;
        Cursor cursorQuery;
        C1919e c1919eM1475f;
        Uri uri = imageRequest.f19585c;
        if (!C1717b.m1006b(uri) || (c1884e = imageRequest.f19592j) == null || (cursorQuery = this.f4050g.query(uri, f4046c, null, null, null)) == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst() || (c1919eM1475f = m1475f(c1884e, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")))) == null) {
                cursorQuery.close();
                return null;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
            int iM568s0 = 0;
            if (string != null) {
                try {
                    iM568s0 = C1460d.m568s0(new ExifInterface(string).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
                } catch (IOException e) {
                    C1691a.m976d(C1978f0.class, e, "Unable to retrieve thumbnail rotation for %s", string);
                }
            }
            c1919eM1475f.f3894m = iM568s0;
            cursorQuery.close();
            return c1919eM1475f;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    /* JADX INFO: renamed from: f */
    public final C1919e m1475f(C1884e c1884e, long j) throws IOException {
        int i;
        Cursor cursorQueryMiniThumbnail;
        Rect rect = f4049f;
        if (C1460d.m472S0(rect.width(), rect.height(), c1884e)) {
            i = 3;
        } else {
            Rect rect2 = f4048e;
            i = C1460d.m472S0(rect2.width(), rect2.height(), c1884e) ? 1 : 0;
        }
        if (i == 0 || (cursorQueryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.f4050g, j, i, f4047d)) == null) {
            return null;
        }
        try {
            if (cursorQueryMiniThumbnail.moveToFirst()) {
                String string = cursorQueryMiniThumbnail.getString(cursorQueryMiniThumbnail.getColumnIndex("_data"));
                Objects.requireNonNull(string);
                if (new File(string).exists()) {
                    return m1478c(new FileInputStream(string), (int) new File(string).length());
                }
            }
            return null;
        } finally {
            cursorQueryMiniThumbnail.close();
        }
    }
}
