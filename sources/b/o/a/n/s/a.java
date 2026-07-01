package b.o.a.n.s;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera$Area;
import androidx.annotation.NonNull;
import b.o.a.t.c;

/* JADX INFO: compiled from: Camera1MeteringTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements c<Camera$Area> {
    public static final b.o.a.b a = new b.o.a.b(a.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1938b;
    public final b.o.a.x.b c;

    public a(@NonNull b.o.a.n.t.a aVar, @NonNull b.o.a.x.b bVar) {
        this.f1938b = -aVar.c(b.o.a.n.t.b.SENSOR, b.o.a.n.t.b.VIEW, 1);
        this.c = bVar;
    }

    @Override // b.o.a.t.c
    @NonNull
    public Camera$Area a(@NonNull RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new Camera$Area(rect, i);
    }

    @Override // b.o.a.t.c
    @NonNull
    public PointF b(@NonNull PointF pointF) {
        PointF pointF2 = new PointF();
        float f = pointF.x;
        b.o.a.x.b bVar = this.c;
        pointF2.x = ((f / bVar.j) * 2000.0f) - 1000.0f;
        pointF2.y = ((pointF.y / bVar.k) * 2000.0f) - 1000.0f;
        PointF pointF3 = new PointF();
        double d = (((double) this.f1938b) * 3.141592653589793d) / 180.0d;
        pointF3.x = (float) ((Math.cos(d) * ((double) pointF2.x)) - (Math.sin(d) * ((double) pointF2.y)));
        pointF3.y = (float) ((Math.cos(d) * ((double) pointF2.y)) + (Math.sin(d) * ((double) pointF2.x)));
        a.a(1, "scaled:", pointF2, "rotated:", pointF3);
        return pointF3;
    }
}
