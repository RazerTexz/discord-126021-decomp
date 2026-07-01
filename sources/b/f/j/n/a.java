package b.f.j.n;

import android.annotation.TargetApi;
import android.graphics.Bitmap$Config;
import android.graphics.BitmapFactory$Options;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: ArtDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class a extends b {
    public a(b.f.j.l.d dVar, int i, Pools$SynchronizedPool pools$SynchronizedPool) {
        super(dVar, i, pools$SynchronizedPool);
    }

    @Override // b.f.j.n.b
    public int d(int i, int i2, BitmapFactory$Options bitmapFactory$Options) {
        return b.f.k.a.c(i, i2, (Bitmap$Config) Preconditions.checkNotNull(bitmapFactory$Options.inPreferredConfig));
    }
}
