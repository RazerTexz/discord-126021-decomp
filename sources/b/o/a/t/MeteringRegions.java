package b.o.a.t;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.t.b, reason: use source file name */
/* JADX INFO: compiled from: MeteringRegions.java */
/* JADX INFO: loaded from: classes3.dex */
public class MeteringRegions {

    @VisibleForTesting
    public final List<MeteringRegion> a;

    public MeteringRegions(@NonNull List<MeteringRegion> list) {
        this.a = list;
    }

    @NonNull
    public static RectF a(@NonNull PointF pointF, float f, float f2) {
        float f3 = pointF.x;
        float f4 = f / 2.0f;
        float f5 = pointF.y;
        float f6 = f2 / 2.0f;
        return new RectF(f3 - f4, f5 - f6, f3 + f4, f5 + f6);
    }

    @NonNull
    public <T> List<T> b(int i, @NonNull MeteringTransform<T> meteringTransform) {
        ArrayList arrayList = new ArrayList();
        Collections.sort(this.a);
        for (MeteringRegion meteringRegion : this.a) {
            arrayList.add(meteringTransform.a(meteringRegion.j, meteringRegion.k));
        }
        return arrayList.subList(0, Math.min(i, arrayList.size()));
    }

    @NonNull
    public MeteringRegions c(@NonNull MeteringTransform meteringTransform) {
        ArrayList arrayList = new ArrayList();
        for (MeteringRegion meteringRegion : this.a) {
            Objects.requireNonNull(meteringRegion);
            RectF rectF = new RectF(Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38f, -3.4028235E38f);
            PointF pointF = new PointF();
            RectF rectF2 = meteringRegion.j;
            pointF.set(rectF2.left, rectF2.top);
            PointF pointFB = meteringTransform.b(pointF);
            meteringRegion.f(rectF, pointFB);
            RectF rectF3 = meteringRegion.j;
            pointFB.set(rectF3.right, rectF3.top);
            PointF pointFB2 = meteringTransform.b(pointFB);
            meteringRegion.f(rectF, pointFB2);
            RectF rectF4 = meteringRegion.j;
            pointFB2.set(rectF4.right, rectF4.bottom);
            PointF pointFB3 = meteringTransform.b(pointFB2);
            meteringRegion.f(rectF, pointFB3);
            RectF rectF5 = meteringRegion.j;
            pointFB3.set(rectF5.left, rectF5.bottom);
            meteringRegion.f(rectF, meteringTransform.b(pointFB3));
            arrayList.add(new MeteringRegion(rectF, meteringRegion.k));
        }
        return new MeteringRegions(arrayList);
    }
}
