package b.c.a.w.c;

import android.graphics.Path;
import android.graphics.PointF;
import b.c.a.b0.Logger2;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.Keyframe;
import b.c.a.y.CubicCurveData;
import b.c.a.y.l.ShapeData;
import b.d.b.a.outline;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.c.l, reason: use source file name */
/* JADX INFO: compiled from: ShapeKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
    public final ShapeData i;
    public final Path j;

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
        this.i = new ShapeData();
        this.j = new Path();
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Path f(Keyframe<ShapeData> keyframe, float f) {
        ShapeData shapeData = keyframe.f347b;
        ShapeData shapeData2 = keyframe.c;
        ShapeData shapeData3 = this.i;
        if (shapeData3.f424b == null) {
            shapeData3.f424b = new PointF();
        }
        shapeData3.c = shapeData.c || shapeData2.c;
        if (shapeData.a.size() != shapeData2.a.size()) {
            StringBuilder sbU = outline.U("Curves must have the same number of control points. Shape 1: ");
            sbU.append(shapeData.a.size());
            sbU.append("\tShape 2: ");
            sbU.append(shapeData2.a.size());
            Logger2.b(sbU.toString());
        }
        int iMin = Math.min(shapeData.a.size(), shapeData2.a.size());
        if (shapeData3.a.size() < iMin) {
            for (int size = shapeData3.a.size(); size < iMin; size++) {
                shapeData3.a.add(new CubicCurveData());
            }
        } else if (shapeData3.a.size() > iMin) {
            for (int size2 = shapeData3.a.size() - 1; size2 >= iMin; size2--) {
                List<CubicCurveData> list = shapeData3.a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointF = shapeData.f424b;
        PointF pointF2 = shapeData2.f424b;
        float fE = MiscUtils.e(pointF.x, pointF2.x, f);
        float fE2 = MiscUtils.e(pointF.y, pointF2.y, f);
        if (shapeData3.f424b == null) {
            shapeData3.f424b = new PointF();
        }
        shapeData3.f424b.set(fE, fE2);
        for (int size3 = shapeData3.a.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = shapeData.a.get(size3);
            CubicCurveData cubicCurveData2 = shapeData2.a.get(size3);
            PointF pointF3 = cubicCurveData.a;
            PointF pointF4 = cubicCurveData.f399b;
            PointF pointF5 = cubicCurveData.c;
            PointF pointF6 = cubicCurveData2.a;
            PointF pointF7 = cubicCurveData2.f399b;
            PointF pointF8 = cubicCurveData2.c;
            shapeData3.a.get(size3).a.set(MiscUtils.e(pointF3.x, pointF6.x, f), MiscUtils.e(pointF3.y, pointF6.y, f));
            shapeData3.a.get(size3).f399b.set(MiscUtils.e(pointF4.x, pointF7.x, f), MiscUtils.e(pointF4.y, pointF7.y, f));
            shapeData3.a.get(size3).c.set(MiscUtils.e(pointF5.x, pointF8.x, f), MiscUtils.e(pointF5.y, pointF8.y, f));
        }
        ShapeData shapeData4 = this.i;
        Path path = this.j;
        path.reset();
        PointF pointF9 = shapeData4.f424b;
        path.moveTo(pointF9.x, pointF9.y);
        MiscUtils.a.set(pointF9.x, pointF9.y);
        for (int i = 0; i < shapeData4.a.size(); i++) {
            CubicCurveData cubicCurveData3 = shapeData4.a.get(i);
            PointF pointF10 = cubicCurveData3.a;
            PointF pointF11 = cubicCurveData3.f399b;
            PointF pointF12 = cubicCurveData3.c;
            if (pointF10.equals(MiscUtils.a) && pointF11.equals(pointF12)) {
                path.lineTo(pointF12.x, pointF12.y);
            } else {
                path.cubicTo(pointF10.x, pointF10.y, pointF11.x, pointF11.y, pointF12.x, pointF12.y);
            }
            MiscUtils.a.set(pointF12.x, pointF12.y);
        }
        if (shapeData4.c) {
            path.close();
        }
        return this.j;
    }
}
