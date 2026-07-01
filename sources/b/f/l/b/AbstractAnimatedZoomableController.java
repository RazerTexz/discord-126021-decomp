package b.f.l.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import b.f.d.e.FLog;
import b.f.l.a.TransformGestureDetector;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: renamed from: b.f.l.b.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractAnimatedZoomableController.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractAnimatedZoomableController extends DefaultZoomableController {
    public boolean m;
    public final float[] n;
    public final float[] o;
    public final float[] p;
    public final Matrix q;
    public final Matrix r;

    public AbstractAnimatedZoomableController(TransformGestureDetector transformGestureDetector) {
        super(transformGestureDetector);
        this.n = new float[9];
        this.o = new float[9];
        this.p = new float[9];
        this.q = new Matrix();
        this.r = new Matrix();
    }

    @Override // b.f.l.b.DefaultZoomableController, b.f.l.b.ZoomableController
    public boolean a() {
        return !this.m && super.a();
    }

    @Override // b.f.l.b.DefaultZoomableController, b.f.l.a.TransformGestureDetector.a
    public void b(TransformGestureDetector transformGestureDetector) {
        m();
        boolean z2 = this.m;
        int i = FLog.a;
        if (z2) {
            return;
        }
        super.b(transformGestureDetector);
    }

    @Override // b.f.l.b.DefaultZoomableController, b.f.l.a.TransformGestureDetector.a
    public void c(TransformGestureDetector transformGestureDetector) {
        FLog.i(m(), "onGestureBegin");
        o();
        super.c(transformGestureDetector);
    }

    @Override // b.f.l.b.DefaultZoomableController
    public void j() {
        FLog.i(m(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET);
        o();
        this.r.reset();
        this.q.reset();
        super.j();
    }

    public abstract Class<?> m();

    public abstract void n(Matrix matrix, long j, @Nullable Runnable runnable);

    public abstract void o();

    public void p(float f, PointF pointF, PointF pointF2, int i, long j, @Nullable Runnable runnable) {
        m();
        int i2 = FLog.a;
        Matrix matrix = this.q;
        float[] fArr = this.j;
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = i3 * 2;
            int i5 = i4 + 0;
            float fWidth = this.e.width() * fArr[i5];
            RectF rectF = this.e;
            fArr[i5] = fWidth + rectF.left;
            int i6 = i4 + 1;
            fArr[i6] = (rectF.height() * fArr[i6]) + this.e.top;
        }
        float f2 = pointF2.x - fArr[0];
        float f3 = pointF2.y - fArr[1];
        matrix.setScale(f, f, fArr[0], fArr[1]);
        f(matrix, fArr[0], fArr[1], i);
        matrix.postTranslate(f2, f3);
        g(matrix, i);
        Matrix matrix2 = this.q;
        m();
        int i7 = FLog.a;
        if (j > 0) {
            n(matrix2, j, null);
            return;
        }
        FLog.i(m(), "setTransformImmediate");
        o();
        this.r.set(matrix2);
        FLog.i(DefaultZoomableController.class, "setTransform");
        this.h.set(matrix2);
        i();
        this.a.d();
    }
}
