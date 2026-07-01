package b.f.k;

import android.graphics.ColorSpace;
import android.util.Pair;

/* JADX INFO: compiled from: ImageMetaData.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public final Pair<Integer, Integer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorSpace f646b;

    public b(int i, int i2, ColorSpace colorSpace) {
        this.a = (i == -1 || i2 == -1) ? null : new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        this.f646b = colorSpace;
    }
}
