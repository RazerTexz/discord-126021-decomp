package b.o.a.t;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: MeteringRegions.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    @VisibleForTesting
    public final List<a> a;

    public b(@NonNull List<a> list) {
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
    public <T> List<T> b(int i, @NonNull c<T> cVar) {
        ArrayList arrayList = new ArrayList();
        Collections.sort(this.a);
        for (a aVar : this.a) {
            arrayList.add(cVar.a(aVar.j, aVar.k));
        }
        return arrayList.subList(0, Math.min(i, arrayList.size()));
    }

    @NonNull
    public b c(@NonNull c cVar) {
        ArrayList arrayList = new ArrayList();
        for (a aVar : this.a) {
            Objects.requireNonNull(aVar);
            RectF rectF = new RectF(Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38f, -3.4028235E38f);
            PointF pointF = new PointF();
            RectF rectF2 = aVar.j;
            pointF.set(rectF2.left, rectF2.top);
            PointF pointFB = cVar.b(pointF);
            aVar.f(rectF, pointFB);
            RectF rectF3 = aVar.j;
            pointFB.set(rectF3.right, rectF3.top);
            PointF pointFB2 = cVar.b(pointFB);
            aVar.f(rectF, pointFB2);
            RectF rectF4 = aVar.j;
            pointFB2.set(rectF4.right, rectF4.bottom);
            PointF pointFB3 = cVar.b(pointFB2);
            aVar.f(rectF, pointFB3);
            RectF rectF5 = aVar.j;
            pointFB3.set(rectF5.left, rectF5.bottom);
            aVar.f(rectF, cVar.b(pointFB3));
            arrayList.add(new a(rectF, aVar.k));
        }
        return new b(arrayList);
    }
}
