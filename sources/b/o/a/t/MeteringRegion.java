package b.o.a.t;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.t.a, reason: use source file name */
/* JADX INFO: compiled from: MeteringRegion.java */
/* JADX INFO: loaded from: classes3.dex */
public class MeteringRegion implements Comparable<MeteringRegion> {
    public final RectF j;
    public final int k;

    public MeteringRegion(@NonNull RectF rectF, int i) {
        this.j = rectF;
        this.k = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MeteringRegion meteringRegion) {
        return -Integer.valueOf(this.k).compareTo(Integer.valueOf(meteringRegion.k));
    }

    public final void f(@NonNull RectF rectF, @NonNull PointF pointF) {
        rectF.left = Math.min(rectF.left, pointF.x);
        rectF.top = Math.min(rectF.top, pointF.y);
        rectF.right = Math.max(rectF.right, pointF.x);
        rectF.bottom = Math.max(rectF.bottom, pointF.y);
    }
}
