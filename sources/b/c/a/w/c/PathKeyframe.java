package b.c.a.w.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import b.c.a.LottieComposition;
import b.c.a.b0.Utils;
import b.c.a.c0.Keyframe;

/* JADX INFO: renamed from: b.c.a.w.c.h, reason: use source file name */
/* JADX INFO: compiled from: PathKeyframe.java */
/* JADX INFO: loaded from: classes.dex */
public class PathKeyframe extends Keyframe<PointF> {

    @Nullable
    public Path o;
    public final Keyframe<PointF> p;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.f347b, keyframe.c, keyframe.d, keyframe.e, keyframe.f);
        this.p = keyframe;
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
        Keyframe<PointF> keyframe = this.p;
        PointF pointF3 = keyframe.m;
        PointF pointF4 = keyframe.n;
        PathMeasure pathMeasure = Utils.a;
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
