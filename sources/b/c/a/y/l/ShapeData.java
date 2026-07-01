package b.c.a.y.l;

import android.graphics.PointF;
import b.c.a.y.CubicCurveData;
import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.l.k, reason: use source file name */
/* JADX INFO: compiled from: ShapeData.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeData {
    public final List<CubicCurveData> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f424b;
    public boolean c;

    public ShapeData(PointF pointF, boolean z2, List<CubicCurveData> list) {
        this.f424b = pointF;
        this.c = z2;
        this.a = new ArrayList(list);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ShapeData{numCurves=");
        sbU.append(this.a.size());
        sbU.append("closed=");
        sbU.append(this.c);
        sbU.append('}');
        return sbU.toString();
    }

    public ShapeData() {
        this.a = new ArrayList();
    }
}
