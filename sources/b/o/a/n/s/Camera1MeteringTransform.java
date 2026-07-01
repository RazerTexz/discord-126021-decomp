package b.o.a.n.s;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import b.o.a.CameraLogger;
import b.o.a.n.t.Angles;
import b.o.a.n.t.Reference2;
import b.o.a.t.MeteringTransform;
import b.o.a.x.Size3;

/* JADX INFO: renamed from: b.o.a.n.s.a, reason: use source file name */
/* JADX INFO: compiled from: Camera1MeteringTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class Camera1MeteringTransform implements MeteringTransform<Camera.Area> {
    public static final CameraLogger a = new CameraLogger(Camera1MeteringTransform.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1938b;
    public final Size3 c;

    public Camera1MeteringTransform(@NonNull Angles angles, @NonNull Size3 size3) {
        this.f1938b = -angles.c(Reference2.SENSOR, Reference2.VIEW, 1);
        this.c = size3;
    }

    @Override // b.o.a.t.MeteringTransform
    @NonNull
    public Camera.Area a(@NonNull RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new Camera.Area(rect, i);
    }

    @Override // b.o.a.t.MeteringTransform
    @NonNull
    public PointF b(@NonNull PointF pointF) {
        PointF pointF2 = new PointF();
        float f = pointF.x;
        Size3 size3 = this.c;
        pointF2.x = ((f / size3.j) * 2000.0f) - 1000.0f;
        pointF2.y = ((pointF.y / size3.k) * 2000.0f) - 1000.0f;
        PointF pointF3 = new PointF();
        double d = (((double) this.f1938b) * 3.141592653589793d) / 180.0d;
        pointF3.x = (float) ((Math.cos(d) * ((double) pointF2.x)) - (Math.sin(d) * ((double) pointF2.y)));
        pointF3.y = (float) ((Math.cos(d) * ((double) pointF2.y)) + (Math.sin(d) * ((double) pointF2.x)));
        a.a(1, "scaled:", pointF2, "rotated:", pointF3);
        return pointF3;
    }
}
