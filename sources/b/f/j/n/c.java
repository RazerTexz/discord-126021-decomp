package b.f.j.n;

import android.annotation.TargetApi;
import android.graphics.Bitmap$Config;
import android.graphics.BitmapFactory$Options;
import android.graphics.ColorSpace;
import androidx.core.util.Pools$SynchronizedPool;

/* JADX INFO: compiled from: OreoDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(26)
public class c extends b {
    public c(b.f.j.l.d dVar, int i, Pools$SynchronizedPool pools$SynchronizedPool) {
        super(dVar, i, pools$SynchronizedPool);
    }

    @Override // b.f.j.n.b
    public int d(int i, int i2, BitmapFactory$Options bitmapFactory$Options) {
        ColorSpace colorSpace = bitmapFactory$Options.outColorSpace;
        if ((colorSpace == null || !colorSpace.isWideGamut() || bitmapFactory$Options.inPreferredConfig == Bitmap$Config.RGBA_F16) ? false : true) {
            return i * i2 * 8;
        }
        Bitmap$Config bitmap$Config = bitmapFactory$Options.inPreferredConfig;
        if (bitmap$Config == null) {
            bitmap$Config = Bitmap$Config.ARGB_8888;
        }
        return b.f.k.a.c(i, i2, bitmap$Config);
    }
}
