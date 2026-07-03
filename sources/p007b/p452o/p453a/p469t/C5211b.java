package p007b.p452o.p453a.p469t;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.t.b */
/* JADX INFO: compiled from: MeteringRegions.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5211b {

    /* JADX INFO: renamed from: a */
    @VisibleForTesting
    public final List<C5210a> f14142a;

    public C5211b(@NonNull List<C5210a> list) {
        this.f14142a = list;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static RectF m7409a(@NonNull PointF pointF, float f, float f2) {
        float f3 = pointF.x;
        float f4 = f / 2.0f;
        float f5 = pointF.y;
        float f6 = f2 / 2.0f;
        return new RectF(f3 - f4, f5 - f6, f3 + f4, f5 + f6);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public <T> List<T> m7410b(int i, @NonNull InterfaceC5212c<T> interfaceC5212c) {
        ArrayList arrayList = new ArrayList();
        Collections.sort(this.f14142a);
        for (C5210a c5210a : this.f14142a) {
            arrayList.add(interfaceC5212c.mo7354a(c5210a.f14140j, c5210a.f14141k));
        }
        return arrayList.subList(0, Math.min(i, arrayList.size()));
    }

    @NonNull
    /* JADX INFO: renamed from: c */
    public C5211b m7411c(@NonNull InterfaceC5212c interfaceC5212c) {
        ArrayList arrayList = new ArrayList();
        for (C5210a c5210a : this.f14142a) {
            Objects.requireNonNull(c5210a);
            RectF rectF = new RectF(Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38f, -3.4028235E38f);
            PointF pointF = new PointF();
            RectF rectF2 = c5210a.f14140j;
            pointF.set(rectF2.left, rectF2.top);
            PointF pointFMo7355b = interfaceC5212c.mo7355b(pointF);
            c5210a.m7408f(rectF, pointFMo7355b);
            RectF rectF3 = c5210a.f14140j;
            pointFMo7355b.set(rectF3.right, rectF3.top);
            PointF pointFMo7355b2 = interfaceC5212c.mo7355b(pointFMo7355b);
            c5210a.m7408f(rectF, pointFMo7355b2);
            RectF rectF4 = c5210a.f14140j;
            pointFMo7355b2.set(rectF4.right, rectF4.bottom);
            PointF pointFMo7355b3 = interfaceC5212c.mo7355b(pointFMo7355b2);
            c5210a.m7408f(rectF, pointFMo7355b3);
            RectF rectF5 = c5210a.f14140j;
            pointFMo7355b3.set(rectF5.left, rectF5.bottom);
            c5210a.m7408f(rectF, interfaceC5212c.mo7355b(pointFMo7355b3));
            arrayList.add(new C5210a(rectF, c5210a.f14141k));
        }
        return new C5211b(arrayList);
    }
}
