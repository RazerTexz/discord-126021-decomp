package b.f.j.p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore$Images$Thumbnails;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: LocalContentUriThumbnailFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class f0 extends g0 implements k1<b.f.j.j.e> {
    public static final String[] c = {"_id", "_data"};
    public static final String[] d = {"_data"};
    public static final Rect e = new Rect(0, 0, 512, 384);
    public static final Rect f = new Rect(0, 0, 96, 96);
    public final ContentResolver g;

    public f0(Executor executor, b.f.d.g.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.g = contentResolver;
    }

    @Override // b.f.j.p.k1
    public boolean a(b.f.j.d.e eVar) {
        Rect rect = e;
        return b.c.a.a0.d.S0(rect.width(), rect.height(), eVar);
    }

    @Override // b.f.j.p.g0
    public b.f.j.j.e d(ImageRequest imageRequest) throws IOException {
        b.f.j.d.e eVar;
        Cursor cursorQuery;
        b.f.j.j.e eVarF;
        Uri uri = imageRequest.c;
        if (!b.f.d.l.b.b(uri) || (eVar = imageRequest.j) == null || (cursorQuery = this.g.query(uri, c, null, null, null)) == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst() || (eVarF = f(eVar, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")))) == null) {
                cursorQuery.close();
                return null;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
            int iS0 = 0;
            if (string != null) {
                try {
                    iS0 = b.c.a.a0.d.s0(new ExifInterface(string).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
                } catch (IOException e2) {
                    b.f.d.e.a.d(f0.class, e2, "Unable to retrieve thumbnail rotation for %s", string);
                }
            }
            eVarF.m = iS0;
            cursorQuery.close();
            return eVarF;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    @Override // b.f.j.p.g0
    public String e() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    public final b.f.j.j.e f(b.f.j.d.e eVar, long j) throws IOException {
        int i;
        Cursor cursorQueryMiniThumbnail;
        Rect rect = f;
        if (b.c.a.a0.d.S0(rect.width(), rect.height(), eVar)) {
            i = 3;
        } else {
            Rect rect2 = e;
            i = b.c.a.a0.d.S0(rect2.width(), rect2.height(), eVar) ? 1 : 0;
        }
        if (i == 0 || (cursorQueryMiniThumbnail = MediaStore$Images$Thumbnails.queryMiniThumbnail(this.g, j, i, d)) == null) {
            return null;
        }
        try {
            if (cursorQueryMiniThumbnail.moveToFirst()) {
                String string = cursorQueryMiniThumbnail.getString(cursorQueryMiniThumbnail.getColumnIndex("_data"));
                Objects.requireNonNull(string);
                if (new File(string).exists()) {
                    return c(new FileInputStream(string), (int) new File(string).length());
                }
            }
            return null;
        } finally {
            cursorQueryMiniThumbnail.close();
        }
    }
}
