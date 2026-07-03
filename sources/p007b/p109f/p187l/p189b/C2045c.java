package p007b.p109f.p187l.p189b;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import java.util.Objects;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p187l.p188a.C2041a;
import p007b.p109f.p187l.p188a.C2042b;
import p007b.p109f.p187l.p189b.InterfaceC2047e;

/* JADX INFO: renamed from: b.f.l.b.c */
/* JADX INFO: compiled from: DefaultZoomableController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2045c implements InterfaceC2047e, C2042b.a {

    /* JADX INFO: renamed from: a */
    public C2042b f4299a;

    /* JADX INFO: renamed from: b */
    public InterfaceC2047e.a f4300b = null;

    /* JADX INFO: renamed from: c */
    public boolean f4301c = false;

    /* JADX INFO: renamed from: d */
    public final RectF f4302d = new RectF();

    /* JADX INFO: renamed from: e */
    public final RectF f4303e = new RectF();

    /* JADX INFO: renamed from: f */
    public final RectF f4304f = new RectF();

    /* JADX INFO: renamed from: g */
    public final Matrix f4305g = new Matrix();

    /* JADX INFO: renamed from: h */
    public final Matrix f4306h = new Matrix();

    /* JADX INFO: renamed from: i */
    public final Matrix f4307i = new Matrix();

    /* JADX INFO: renamed from: j */
    public final float[] f4308j = new float[9];

    /* JADX INFO: renamed from: k */
    public final RectF f4309k = new RectF();

    /* JADX INFO: renamed from: l */
    public boolean f4310l;

    static {
        new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    }

    public C2045c(C2042b c2042b) {
        this.f4299a = c2042b;
        c2042b.f4288b = this;
    }

    /* JADX INFO: renamed from: l */
    public static boolean m1557l(int i, int i2) {
        return (i & i2) != 0;
    }

    @Override // p007b.p109f.p187l.p189b.InterfaceC2047e
    /* JADX INFO: renamed from: a */
    public boolean mo1551a() {
        this.f4306h.getValues(this.f4308j);
        float[] fArr = this.f4308j;
        fArr[0] = fArr[0] - 1.0f;
        fArr[4] = fArr[4] - 1.0f;
        fArr[8] = fArr[8] - 1.0f;
        for (int i = 0; i < 9; i++) {
            if (Math.abs(this.f4308j[i]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public void mo1549b(C2042b c2042b) {
        float fHypot;
        C1691a.m981i(C2045c.class, "onGestureUpdate");
        Matrix matrix = this.f4306h;
        C2042b c2042b2 = this.f4299a;
        matrix.set(this.f4305g);
        C2041a c2041a = c2042b2.f4287a;
        if (c2041a.f4280b < 2) {
            fHypot = 1.0f;
        } else {
            float[] fArr = c2041a.f4282d;
            float f = fArr[1] - fArr[0];
            float[] fArr2 = c2041a.f4283e;
            float f2 = fArr2[1] - fArr2[0];
            float[] fArr3 = c2041a.f4284f;
            float f3 = fArr3[1] - fArr3[0];
            float[] fArr4 = c2041a.f4285g;
            fHypot = ((float) Math.hypot(f3, fArr4[1] - fArr4[0])) / ((float) Math.hypot(f, f2));
        }
        matrix.postScale(fHypot, fHypot, c2042b2.m1546b(), c2042b2.m1547c());
        boolean zM1560f = m1560f(matrix, c2042b2.m1546b(), c2042b2.m1547c(), 7) | false;
        C2041a c2041a2 = c2042b2.f4287a;
        float fM1545a = c2042b2.m1545a(c2041a2.f4284f, c2041a2.f4280b);
        C2041a c2041a3 = c2042b2.f4287a;
        float fM1545a2 = fM1545a - c2042b2.m1545a(c2041a3.f4282d, c2041a3.f4280b);
        C2041a c2041a4 = c2042b2.f4287a;
        float fM1545a3 = c2042b2.m1545a(c2041a4.f4285g, c2041a4.f4280b);
        C2041a c2041a5 = c2042b2.f4287a;
        matrix.postTranslate(fM1545a2, fM1545a3 - c2042b2.m1545a(c2041a5.f4283e, c2041a5.f4280b));
        boolean zM1561g = m1561g(matrix, 7) | zM1560f;
        m1563i();
        if (zM1561g) {
            this.f4299a.m1548d();
        }
        this.f4310l = zM1561g;
    }

    /* JADX INFO: renamed from: c */
    public void mo1550c(C2042b c2042b) {
        C1691a.m981i(C2045c.class, "onGestureBegin");
        this.f4305g.set(this.f4306h);
        RectF rectF = this.f4304f;
        float f = rectF.left;
        RectF rectF2 = this.f4302d;
        this.f4310l = !(f < rectF2.left - 0.001f && rectF.top < rectF2.top - 0.001f && rectF.right > rectF2.right + 0.001f && rectF.bottom > rectF2.bottom + 0.001f);
    }

    /* JADX INFO: renamed from: d */
    public final float m1558d(float f, float f2, float f3, float f4, float f5) {
        float f6 = f2 - f;
        float f7 = f4 - f3;
        if (f6 < Math.min(f5 - f3, f4 - f5) * 2.0f) {
            return f5 - ((f2 + f) / 2.0f);
        }
        if (f6 < f7) {
            return f5 < (f3 + f4) / 2.0f ? f3 - f : f4 - f2;
        }
        if (f > f3) {
            return f3 - f;
        }
        if (f2 < f4) {
            return f4 - f2;
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: e */
    public float m1559e() {
        this.f4306h.getValues(this.f4308j);
        return this.f4308j[0];
    }

    /* JADX INFO: renamed from: f */
    public final boolean m1560f(Matrix matrix, float f, float f2, int i) {
        if (!m1557l(i, 4)) {
            return false;
        }
        matrix.getValues(this.f4308j);
        float f3 = this.f4308j[0];
        float fMin = Math.min(Math.max(1.0f, f3), 2.0f);
        if (fMin == f3) {
            return false;
        }
        float f4 = fMin / f3;
        matrix.postScale(f4, f4, f, f2);
        return true;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m1561g(Matrix matrix, int i) {
        float fM1558d;
        float fM1558d2;
        if (!m1557l(i, 3)) {
            return false;
        }
        RectF rectF = this.f4309k;
        rectF.set(this.f4303e);
        matrix.mapRect(rectF);
        if (m1557l(i, 1)) {
            float f = rectF.left;
            float f2 = rectF.right;
            RectF rectF2 = this.f4302d;
            fM1558d = m1558d(f, f2, rectF2.left, rectF2.right, this.f4303e.centerX());
        } else {
            fM1558d = 0.0f;
        }
        if (m1557l(i, 2)) {
            float f3 = rectF.top;
            float f4 = rectF.bottom;
            RectF rectF3 = this.f4302d;
            fM1558d2 = m1558d(f3, f4, rectF3.top, rectF3.bottom, this.f4303e.centerY());
        } else {
            fM1558d2 = 0.0f;
        }
        if (fM1558d == 0.0f && fM1558d2 == 0.0f) {
            return false;
        }
        matrix.postTranslate(fM1558d, fM1558d2);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006d  */
    /* JADX WARN: Code duplicated, block: B:34:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0093  */
    /* JADX WARN: Code duplicated, block: B:44:0x0096  */
    /* JADX WARN: Code duplicated, block: B:45:0x009b  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c7  */
    /* JADX INFO: renamed from: h */
    public boolean m1562h(MotionEvent motionEvent) {
        int pointerCount;
        int i;
        C2041a.a aVar;
        C2042b c2042b;
        C2042b.a aVar2;
        motionEvent.getAction();
        int i2 = C1691a.f3102a;
        int i3 = 0;
        if (!this.f4301c) {
            return false;
        }
        C2041a c2041a = this.f4299a.f4287a;
        Objects.requireNonNull(c2041a);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 1) {
            motionEvent.getPointerCount();
            motionEvent.getActionMasked();
            c2041a.m1544c();
            c2041a.f4280b = 0;
            while (i3 < 2) {
                pointerCount = motionEvent.getPointerCount();
                int actionMasked2 = motionEvent.getActionMasked();
                i = ((actionMasked2 != 1 || actionMasked2 == 6) && i3 >= motionEvent.getActionIndex()) ? i3 + 1 : i3;
                if (i >= pointerCount) {
                    i = -1;
                }
                if (i == -1) {
                    c2041a.f4281c[i3] = -1;
                } else {
                    c2041a.f4281c[i3] = motionEvent.getPointerId(i);
                    float[] fArr = c2041a.f4284f;
                    float[] fArr2 = c2041a.f4282d;
                    float x2 = motionEvent.getX(i);
                    fArr2[i3] = x2;
                    fArr[i3] = x2;
                    float[] fArr3 = c2041a.f4285g;
                    float[] fArr4 = c2041a.f4283e;
                    float y2 = motionEvent.getY(i);
                    fArr4[i3] = y2;
                    fArr3[i3] = y2;
                    c2041a.f4280b++;
                }
                i3++;
            }
            if (c2041a.f4280b > 0) {
                c2041a.m1543b();
            }
        } else if (actionMasked == 2) {
            while (i3 < 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(c2041a.f4281c[i3]);
                if (iFindPointerIndex != -1) {
                    c2041a.f4284f[i3] = motionEvent.getX(iFindPointerIndex);
                    c2041a.f4285g[i3] = motionEvent.getY(iFindPointerIndex);
                }
                i3++;
            }
            if (!c2041a.f4279a && c2041a.f4280b > 0) {
                c2041a.m1543b();
            }
            if (c2041a.f4279a && (aVar = c2041a.f4286h) != null && (aVar2 = (c2042b = (C2042b) aVar).f4288b) != null) {
                aVar2.mo1549b(c2042b);
            }
        } else if (actionMasked == 3) {
            c2041a.m1544c();
            c2041a.m1542a();
        } else if (actionMasked == 5 || actionMasked == 6) {
            motionEvent.getPointerCount();
            motionEvent.getActionMasked();
            c2041a.m1544c();
            c2041a.f4280b = 0;
            while (i3 < 2) {
                pointerCount = motionEvent.getPointerCount();
                int actionMasked3 = motionEvent.getActionMasked();
                if (actionMasked3 != 1) {
                }
                if (i >= pointerCount) {
                    i = -1;
                }
                if (i == -1) {
                    c2041a.f4281c[i3] = -1;
                } else {
                    c2041a.f4281c[i3] = motionEvent.getPointerId(i);
                    float[] fArr5 = c2041a.f4284f;
                    float[] fArr6 = c2041a.f4282d;
                    float x3 = motionEvent.getX(i);
                    fArr6[i3] = x3;
                    fArr5[i3] = x3;
                    float[] fArr7 = c2041a.f4285g;
                    float[] fArr8 = c2041a.f4283e;
                    float y3 = motionEvent.getY(i);
                    fArr8[i3] = y3;
                    fArr7[i3] = y3;
                    c2041a.f4280b++;
                }
                i3++;
            }
            if (c2041a.f4280b > 0) {
                c2041a.m1543b();
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: i */
    public final void m1563i() {
        this.f4306h.mapRect(this.f4304f, this.f4303e);
        InterfaceC2047e.a aVar = this.f4300b;
        if (aVar == null || !this.f4301c) {
            return;
        }
        ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
        zoomableDraweeView.getLogTag();
        zoomableDraweeView.hashCode();
        int i = C1691a.f3102a;
        if (zoomableDraweeView.f19632n != null && ((C2045c) zoomableDraweeView.f19633o).m1559e() > 1.1f) {
            zoomableDraweeView.m8725a(zoomableDraweeView.f19632n, null);
        }
        zoomableDraweeView.invalidate();
    }

    /* JADX INFO: renamed from: j */
    public void mo1552j() {
        C1691a.m981i(C2045c.class, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET);
        this.f4299a.f4287a.m1542a();
        this.f4305g.reset();
        this.f4306h.reset();
        m1563i();
    }

    /* JADX INFO: renamed from: k */
    public void m1564k(boolean z2) {
        this.f4301c = z2;
        if (z2) {
            return;
        }
        mo1552j();
    }
}
