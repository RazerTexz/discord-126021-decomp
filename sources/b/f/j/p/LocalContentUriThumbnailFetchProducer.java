package b.f.j.p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.e.FLog;
import b.f.d.g.PooledByteBufferFactory;
import b.f.d.l.UriUtil;
import b.f.j.d.ResizeOptions;
import b.f.j.j.EncodedImage2;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.f0, reason: use source file name */
/* JADX INFO: compiled from: LocalContentUriThumbnailFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage2> {
    public static final String[] c = {"_id", "_data"};
    public static final String[] d = {"_data"};
    public static final Rect e = new Rect(0, 0, 512, 384);
    public static final Rect f = new Rect(0, 0, 96, 96);
    public final ContentResolver g;

    public LocalContentUriThumbnailFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.g = contentResolver;
    }

    @Override // b.f.j.p.ThumbnailProducer
    public boolean a(ResizeOptions resizeOptions) {
        Rect rect = e;
        return AnimatableValueParser.S0(rect.width(), rect.height(), resizeOptions);
    }

    @Override // b.f.j.p.LocalFetchProducer
    public EncodedImage2 d(ImageRequest imageRequest) throws IOException {
        ResizeOptions resizeOptions;
        Cursor cursorQuery;
        EncodedImage2 encodedImage2F;
        Uri uri = imageRequest.c;
        if (!UriUtil.b(uri) || (resizeOptions = imageRequest.j) == null || (cursorQuery = this.g.query(uri, c, null, null, null)) == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst() || (encodedImage2F = f(resizeOptions, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")))) == null) {
                cursorQuery.close();
                return null;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
            int iS0 = 0;
            if (string != null) {
                try {
                    iS0 = AnimatableValueParser.s0(new ExifInterface(string).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
                } catch (IOException e2) {
                    FLog.d(LocalContentUriThumbnailFetchProducer.class, e2, "Unable to retrieve thumbnail rotation for %s", string);
                }
            }
            encodedImage2F.m = iS0;
            cursorQuery.close();
            return encodedImage2F;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    @Override // b.f.j.p.LocalFetchProducer
    public String e() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    public final EncodedImage2 f(ResizeOptions resizeOptions, long j) throws IOException {
        int i;
        Cursor cursorQueryMiniThumbnail;
        Rect rect = f;
        if (AnimatableValueParser.S0(rect.width(), rect.height(), resizeOptions)) {
            i = 3;
        } else {
            Rect rect2 = e;
            i = AnimatableValueParser.S0(rect2.width(), rect2.height(), resizeOptions) ? 1 : 0;
        }
        if (i == 0 || (cursorQueryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.g, j, i, d)) == null) {
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
