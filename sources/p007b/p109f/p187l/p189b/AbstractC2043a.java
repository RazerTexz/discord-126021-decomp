package p007b.p109f.p187l.p189b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p187l.p188a.C2042b;

/* JADX INFO: renamed from: b.f.l.b.a */
/* JADX INFO: compiled from: AbstractAnimatedZoomableController.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2043a extends C2045c {

    /* JADX INFO: renamed from: m */
    public boolean f4289m;

    /* JADX INFO: renamed from: n */
    public final float[] f4290n;

    /* JADX INFO: renamed from: o */
    public final float[] f4291o;

    /* JADX INFO: renamed from: p */
    public final float[] f4292p;

    /* JADX INFO: renamed from: q */
    public final Matrix f4293q;

    /* JADX INFO: renamed from: r */
    public final Matrix f4294r;

    public AbstractC2043a(C2042b c2042b) {
        super(c2042b);
        this.f4290n = new float[9];
        this.f4291o = new float[9];
        this.f4292p = new float[9];
        this.f4293q = new Matrix();
        this.f4294r = new Matrix();
    }

    @Override // p007b.p109f.p187l.p189b.C2045c, p007b.p109f.p187l.p189b.InterfaceC2047e
    /* JADX INFO: renamed from: a */
    public boolean mo1551a() {
        return !this.f4289m && super.mo1551a();
    }

    @Override // p007b.p109f.p187l.p189b.C2045c, p007b.p109f.p187l.p188a.C2042b.a
    /* JADX INFO: renamed from: b */
    public void mo1549b(C2042b c2042b) {
        mo1553m();
        boolean z2 = this.f4289m;
        int i = C1691a.f3102a;
        if (z2) {
            return;
        }
        super.mo1549b(c2042b);
    }

    @Override // p007b.p109f.p187l.p189b.C2045c, p007b.p109f.p187l.p188a.C2042b.a
    /* JADX INFO: renamed from: c */
    public void mo1550c(C2042b c2042b) {
        C1691a.m981i(mo1553m(), "onGestureBegin");
        mo1555o();
        super.mo1550c(c2042b);
    }

    @Override // p007b.p109f.p187l.p189b.C2045c
    /* JADX INFO: renamed from: j */
    public void mo1552j() {
        C1691a.m981i(mo1553m(), ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET);
        mo1555o();
        this.f4294r.reset();
        this.f4293q.reset();
        super.mo1552j();
    }

    /* JADX INFO: renamed from: m */
    public abstract Class<?> mo1553m();

    /* JADX INFO: renamed from: n */
    public abstract void mo1554n(Matrix matrix, long j, @Nullable Runnable runnable);

    /* JADX INFO: renamed from: o */
    public abstract void mo1555o();

    /* JADX INFO: renamed from: p */
    public void m1556p(float f, PointF pointF, PointF pointF2, int i, long j, @Nullable Runnable runnable) {
        mo1553m();
        int i2 = C1691a.f3102a;
        Matrix matrix = this.f4293q;
        float[] fArr = this.f4308j;
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = i3 * 2;
            int i5 = i4 + 0;
            float fWidth = this.f4303e.width() * fArr[i5];
            RectF rectF = this.f4303e;
            fArr[i5] = fWidth + rectF.left;
            int i6 = i4 + 1;
            fArr[i6] = (rectF.height() * fArr[i6]) + this.f4303e.top;
        }
        float f2 = pointF2.x - fArr[0];
        float f3 = pointF2.y - fArr[1];
        matrix.setScale(f, f, fArr[0], fArr[1]);
        m1560f(matrix, fArr[0], fArr[1], i);
        matrix.postTranslate(f2, f3);
        m1561g(matrix, i);
        Matrix matrix2 = this.f4293q;
        mo1553m();
        int i7 = C1691a.f3102a;
        if (j > 0) {
            mo1554n(matrix2, j, null);
            return;
        }
        C1691a.m981i(mo1553m(), "setTransformImmediate");
        mo1555o();
        this.f4294r.set(matrix2);
        C1691a.m981i(C2045c.class, "setTransform");
        this.f4306h.set(matrix2);
        m1563i();
        this.f4299a.m1548d();
    }
}
