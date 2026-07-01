package b.c.a.y.l;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ShapeData.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public final List<b.c.a.y.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f424b;
    public boolean c;

    public k(PointF pointF, boolean z2, List<b.c.a.y.a> list) {
        this.f424b = pointF;
        this.c = z2;
        this.a = new ArrayList(list);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ShapeData{numCurves=");
        sbU.append(this.a.size());
        sbU.append("closed=");
        sbU.append(this.c);
        sbU.append('}');
        return sbU.toString();
    }

    public k() {
        this.a = new ArrayList();
    }
}
