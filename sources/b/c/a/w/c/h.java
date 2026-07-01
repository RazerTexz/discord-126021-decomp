package b.c.a.w.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: PathKeyframe.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends b.c.a.c0.a<PointF> {

    @Nullable
    public Path o;
    public final b.c.a.c0.a<PointF> p;

    public h(b.c.a.d dVar, b.c.a.c0.a<PointF> aVar) {
        super(dVar, aVar.f347b, aVar.c, aVar.d, aVar.e, aVar.f);
        this.p = aVar;
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e() {
        T t;
        T t2 = this.c;
        boolean z2 = (t2 == 0 || (t = this.f347b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.c;
        if (t3 == 0 || z2) {
            return;
        }
        PointF pointF = (PointF) this.f347b;
        PointF pointF2 = (PointF) t3;
        b.c.a.c0.a<PointF> aVar = this.p;
        PointF pointF3 = aVar.m;
        PointF pointF4 = aVar.n;
        PathMeasure pathMeasure = b.c.a.b0.g.a;
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f = pointF3.x + pointF.x;
            float f2 = pointF.y + pointF3.y;
            float f3 = pointF2.x;
            float f4 = f3 + pointF4.x;
            float f5 = pointF2.y;
            path.cubicTo(f, f2, f4, f5 + pointF4.y, f3, f5);
        }
        this.o = path;
    }
}
