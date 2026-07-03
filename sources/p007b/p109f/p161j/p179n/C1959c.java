package p007b.p109f.p161j.p179n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import androidx.core.util.Pools;
import p007b.p109f.p161j.p177l.InterfaceC1932d;
import p007b.p109f.p186k.C2038a;

/* JADX INFO: renamed from: b.f.j.n.c */
/* JADX INFO: compiled from: OreoDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(26)
public class C1959c extends AbstractC1958b {
    public C1959c(InterfaceC1932d interfaceC1932d, int i, Pools.SynchronizedPool synchronizedPool) {
        super(interfaceC1932d, i, synchronizedPool);
    }

    @Override // p007b.p109f.p161j.p179n.AbstractC1958b
    /* JADX INFO: renamed from: d */
    public int mo1412d(int i, int i2, BitmapFactory.Options options) {
        ColorSpace colorSpace = options.outColorSpace;
        if ((colorSpace == null || !colorSpace.isWideGamut() || options.inPreferredConfig == Bitmap.Config.RGBA_F16) ? false : true) {
            return i * i2 * 8;
        }
        Bitmap.Config config = options.inPreferredConfig;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return C2038a.m1540c(i, i2, config);
    }
}
