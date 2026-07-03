package p007b.p109f.p161j.p179n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import androidx.core.util.Preconditions;
import p007b.p109f.p161j.p177l.InterfaceC1932d;
import p007b.p109f.p186k.C2038a;

/* JADX INFO: renamed from: b.f.j.n.a */
/* JADX INFO: compiled from: ArtDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class C1957a extends AbstractC1958b {
    public C1957a(InterfaceC1932d interfaceC1932d, int i, Pools.SynchronizedPool synchronizedPool) {
        super(interfaceC1932d, i, synchronizedPool);
    }

    @Override // p007b.p109f.p161j.p179n.AbstractC1958b
    /* JADX INFO: renamed from: d */
    public int mo1412d(int i, int i2, BitmapFactory.Options options) {
        return C2038a.m1540c(i, i2, (Bitmap.Config) Preconditions.checkNotNull(options.inPreferredConfig));
    }
}
