package b.f.j.n;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import b.f.j.j.EncodedImage2;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.j.n.d, reason: use source file name */
/* JADX INFO: compiled from: PlatformDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public interface PlatformDecoder {
    CloseableReference<Bitmap> a(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, ColorSpace colorSpace);

    CloseableReference<Bitmap> b(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, int i, ColorSpace colorSpace);
}
