package p007b.p452o.p453a.p455n.p460s;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.p461t.C5170a;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p469t.InterfaceC5212c;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.n.s.a */
/* JADX INFO: compiled from: Camera1MeteringTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5168a implements InterfaceC5212c<Camera.Area> {

    /* JADX INFO: renamed from: a */
    public static final C5103b f13985a = new C5103b(C5168a.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    public final int f13986b;

    /* JADX INFO: renamed from: c */
    public final C5236b f13987c;

    public C5168a(@NonNull C5170a c5170a, @NonNull C5236b c5236b) {
        this.f13986b = -c5170a.m7358c(EnumC5171b.SENSOR, EnumC5171b.VIEW, 1);
        this.f13987c = c5236b;
    }

    @Override // p007b.p452o.p453a.p469t.InterfaceC5212c
    @NonNull
    /* JADX INFO: renamed from: a */
    public Camera.Area mo7354a(@NonNull RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new Camera.Area(rect, i);
    }

    @Override // p007b.p452o.p453a.p469t.InterfaceC5212c
    @NonNull
    /* JADX INFO: renamed from: b */
    public PointF mo7355b(@NonNull PointF pointF) {
        PointF pointF2 = new PointF();
        float f = pointF.x;
        C5236b c5236b = this.f13987c;
        pointF2.x = ((f / c5236b.f14251j) * 2000.0f) - 1000.0f;
        pointF2.y = ((pointF.y / c5236b.f14252k) * 2000.0f) - 1000.0f;
        PointF pointF3 = new PointF();
        double d = (((double) this.f13986b) * 3.141592653589793d) / 180.0d;
        pointF3.x = (float) ((Math.cos(d) * ((double) pointF2.x)) - (Math.sin(d) * ((double) pointF2.y)));
        pointF3.y = (float) ((Math.cos(d) * ((double) pointF2.y)) + (Math.sin(d) * ((double) pointF2.x)));
        f13985a.m7159a(1, "scaled:", pointF2, "rotated:", pointF3);
        return pointF3;
    }
}
