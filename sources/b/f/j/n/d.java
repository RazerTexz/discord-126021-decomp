package b.f.j.n;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import b.f.j.j.e;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: PlatformDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public interface d {
    CloseableReference<Bitmap> a(e eVar, Bitmap$Config bitmap$Config, Rect rect, ColorSpace colorSpace);

    CloseableReference<Bitmap> b(e eVar, Bitmap$Config bitmap$Config, Rect rect, int i, ColorSpace colorSpace);
}
