package p007b.p452o.p453a.p469t;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.t.a */
/* JADX INFO: compiled from: MeteringRegion.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5210a implements Comparable<C5210a> {

    /* JADX INFO: renamed from: j */
    public final RectF f14140j;

    /* JADX INFO: renamed from: k */
    public final int f14141k;

    public C5210a(@NonNull RectF rectF, int i) {
        this.f14140j = rectF;
        this.f14141k = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull C5210a c5210a) {
        return -Integer.valueOf(this.f14141k).compareTo(Integer.valueOf(c5210a.f14141k));
    }

    /* JADX INFO: renamed from: f */
    public final void m7408f(@NonNull RectF rectF, @NonNull PointF pointF) {
        rectF.left = Math.min(rectF.left, pointF.x);
        rectF.top = Math.min(rectF.top, pointF.y);
        rectF.right = Math.max(rectF.right, pointF.x);
        rectF.bottom = Math.max(rectF.bottom, pointF.y);
    }
}
