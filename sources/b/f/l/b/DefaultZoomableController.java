package b.f.l.b;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import b.f.d.e.FLog;
import b.f.l.a.MultiPointerGestureDetector;
import b.f.l.a.TransformGestureDetector;
import b.f.l.b.ZoomableController;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.l.b.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultZoomableController.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultZoomableController implements ZoomableController, TransformGestureDetector.a {
    public TransformGestureDetector a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ZoomableController.a f651b = null;
    public boolean c = false;
    public final RectF d = new RectF();
    public final RectF e = new RectF();
    public final RectF f = new RectF();
    public final Matrix g = new Matrix();
    public final Matrix h = new Matrix();
    public final Matrix i = new Matrix();
    public final float[] j = new float[9];
    public final RectF k = new RectF();
    public boolean l;

    static {
        new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    }

    public DefaultZoomableController(TransformGestureDetector transformGestureDetector) {
        this.a = transformGestureDetector;
        transformGestureDetector.f648b = this;
    }

    public static boolean l(int i, int i2) {
        return (i & i2) != 0;
    }

    @Override // b.f.l.b.ZoomableController
    public boolean a() {
        this.h.getValues(this.j);
        float[] fArr = this.j;
        fArr[0] = fArr[0] - 1.0f;
        fArr[4] = fArr[4] - 1.0f;
        fArr[8] = fArr[8] - 1.0f;
        for (int i = 0; i < 9; i++) {
            if (Math.abs(this.j[i]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    public void b(TransformGestureDetector transformGestureDetector) {
        float fHypot;
        FLog.i(DefaultZoomableController.class, "onGestureUpdate");
        Matrix matrix = this.h;
        TransformGestureDetector transformGestureDetector2 = this.a;
        matrix.set(this.g);
        MultiPointerGestureDetector multiPointerGestureDetector = transformGestureDetector2.a;
        if (multiPointerGestureDetector.f647b < 2) {
            fHypot = 1.0f;
        } else {
            float[] fArr = multiPointerGestureDetector.d;
            float f = fArr[1] - fArr[0];
            float[] fArr2 = multiPointerGestureDetector.e;
            float f2 = fArr2[1] - fArr2[0];
            float[] fArr3 = multiPointerGestureDetector.f;
            float f3 = fArr3[1] - fArr3[0];
            float[] fArr4 = multiPointerGestureDetector.g;
            fHypot = ((float) Math.hypot(f3, fArr4[1] - fArr4[0])) / ((float) Math.hypot(f, f2));
        }
        matrix.postScale(fHypot, fHypot, transformGestureDetector2.b(), transformGestureDetector2.c());
        boolean zF = f(matrix, transformGestureDetector2.b(), transformGestureDetector2.c(), 7) | false;
        MultiPointerGestureDetector multiPointerGestureDetector2 = transformGestureDetector2.a;
        float fA = transformGestureDetector2.a(multiPointerGestureDetector2.f, multiPointerGestureDetector2.f647b);
        MultiPointerGestureDetector multiPointerGestureDetector3 = transformGestureDetector2.a;
        float fA2 = fA - transformGestureDetector2.a(multiPointerGestureDetector3.d, multiPointerGestureDetector3.f647b);
        MultiPointerGestureDetector multiPointerGestureDetector4 = transformGestureDetector2.a;
        float fA3 = transformGestureDetector2.a(multiPointerGestureDetector4.g, multiPointerGestureDetector4.f647b);
        MultiPointerGestureDetector multiPointerGestureDetector5 = transformGestureDetector2.a;
        matrix.postTranslate(fA2, fA3 - transformGestureDetector2.a(multiPointerGestureDetector5.e, multiPointerGestureDetector5.f647b));
        boolean zG = g(matrix, 7) | zF;
        i();
        if (zG) {
            this.a.d();
        }
        this.l = zG;
    }

    public void c(TransformGestureDetector transformGestureDetector) {
        FLog.i(DefaultZoomableController.class, "onGestureBegin");
        this.g.set(this.h);
        RectF rectF = this.f;
        float f = rectF.left;
        RectF rectF2 = this.d;
        this.l = !(f < rectF2.left - 0.001f && rectF.top < rectF2.top - 0.001f && rectF.right > rectF2.right + 0.001f && rectF.bottom > rectF2.bottom + 0.001f);
    }

    public final float d(float f, float f2, float f3, float f4, float f5) {
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

    public float e() {
        this.h.getValues(this.j);
        return this.j[0];
    }

    public final boolean f(Matrix matrix, float f, float f2, int i) {
        if (!l(i, 4)) {
            return false;
        }
        matrix.getValues(this.j);
        float f3 = this.j[0];
        float fMin = Math.min(Math.max(1.0f, f3), 2.0f);
        if (fMin == f3) {
            return false;
        }
        float f4 = fMin / f3;
        matrix.postScale(f4, f4, f, f2);
        return true;
    }

    public final boolean g(Matrix matrix, int i) {
        float fD;
        float fD2;
        if (!l(i, 3)) {
            return false;
        }
        RectF rectF = this.k;
        rectF.set(this.e);
        matrix.mapRect(rectF);
        if (l(i, 1)) {
            float f = rectF.left;
            float f2 = rectF.right;
            RectF rectF2 = this.d;
            fD = d(f, f2, rectF2.left, rectF2.right, this.e.centerX());
        } else {
            fD = 0.0f;
        }
        if (l(i, 2)) {
            float f3 = rectF.top;
            float f4 = rectF.bottom;
            RectF rectF3 = this.d;
            fD2 = d(f3, f4, rectF3.top, rectF3.bottom, this.e.centerY());
        } else {
            fD2 = 0.0f;
        }
        if (fD == 0.0f && fD2 == 0.0f) {
            return false;
        }
        matrix.postTranslate(fD, fD2);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006d  */
    /* JADX WARN: Code duplicated, block: B:34:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0093  */
    /* JADX WARN: Code duplicated, block: B:44:0x0096  */
    /* JADX WARN: Code duplicated, block: B:45:0x009b  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c7  */
    public boolean h(MotionEvent motionEvent) {
        int pointerCount;
        int i;
        MultiPointerGestureDetector.a aVar;
        TransformGestureDetector transformGestureDetector;
        TransformGestureDetector.a aVar2;
        motionEvent.getAction();
        int i2 = FLog.a;
        int i3 = 0;
        if (!this.c) {
            return false;
        }
        MultiPointerGestureDetector multiPointerGestureDetector = this.a.a;
        Objects.requireNonNull(multiPointerGestureDetector);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 1) {
            motionEvent.getPointerCount();
            motionEvent.getActionMasked();
            multiPointerGestureDetector.c();
            multiPointerGestureDetector.f647b = 0;
            while (i3 < 2) {
                pointerCount = motionEvent.getPointerCount();
                int actionMasked2 = motionEvent.getActionMasked();
                i = ((actionMasked2 != 1 || actionMasked2 == 6) && i3 >= motionEvent.getActionIndex()) ? i3 + 1 : i3;
                if (i >= pointerCount) {
                    i = -1;
                }
                if (i == -1) {
                    multiPointerGestureDetector.c[i3] = -1;
                } else {
                    multiPointerGestureDetector.c[i3] = motionEvent.getPointerId(i);
                    float[] fArr = multiPointerGestureDetector.f;
                    float[] fArr2 = multiPointerGestureDetector.d;
                    float x2 = motionEvent.getX(i);
                    fArr2[i3] = x2;
                    fArr[i3] = x2;
                    float[] fArr3 = multiPointerGestureDetector.g;
                    float[] fArr4 = multiPointerGestureDetector.e;
                    float y2 = motionEvent.getY(i);
                    fArr4[i3] = y2;
                    fArr3[i3] = y2;
                    multiPointerGestureDetector.f647b++;
                }
                i3++;
            }
            if (multiPointerGestureDetector.f647b > 0) {
                multiPointerGestureDetector.b();
            }
        } else if (actionMasked == 2) {
            while (i3 < 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(multiPointerGestureDetector.c[i3]);
                if (iFindPointerIndex != -1) {
                    multiPointerGestureDetector.f[i3] = motionEvent.getX(iFindPointerIndex);
                    multiPointerGestureDetector.g[i3] = motionEvent.getY(iFindPointerIndex);
                }
                i3++;
            }
            if (!multiPointerGestureDetector.a && multiPointerGestureDetector.f647b > 0) {
                multiPointerGestureDetector.b();
            }
            if (multiPointerGestureDetector.a && (aVar = multiPointerGestureDetector.h) != null && (aVar2 = (transformGestureDetector = (TransformGestureDetector) aVar).f648b) != null) {
                aVar2.b(transformGestureDetector);
            }
        } else if (actionMasked == 3) {
            multiPointerGestureDetector.c();
            multiPointerGestureDetector.a();
        } else if (actionMasked == 5 || actionMasked == 6) {
            motionEvent.getPointerCount();
            motionEvent.getActionMasked();
            multiPointerGestureDetector.c();
            multiPointerGestureDetector.f647b = 0;
            while (i3 < 2) {
                pointerCount = motionEvent.getPointerCount();
                int actionMasked3 = motionEvent.getActionMasked();
                if (actionMasked3 != 1) {
                }
                if (i >= pointerCount) {
                    i = -1;
                }
                if (i == -1) {
                    multiPointerGestureDetector.c[i3] = -1;
                } else {
                    multiPointerGestureDetector.c[i3] = motionEvent.getPointerId(i);
                    float[] fArr5 = multiPointerGestureDetector.f;
                    float[] fArr6 = multiPointerGestureDetector.d;
                    float x3 = motionEvent.getX(i);
                    fArr6[i3] = x3;
                    fArr5[i3] = x3;
                    float[] fArr7 = multiPointerGestureDetector.g;
                    float[] fArr8 = multiPointerGestureDetector.e;
                    float y3 = motionEvent.getY(i);
                    fArr8[i3] = y3;
                    fArr7[i3] = y3;
                    multiPointerGestureDetector.f647b++;
                }
                i3++;
            }
            if (multiPointerGestureDetector.f647b > 0) {
                multiPointerGestureDetector.b();
            }
        }
        return true;
    }

    public final void i() {
        this.h.mapRect(this.f, this.e);
        ZoomableController.a aVar = this.f651b;
        if (aVar == null || !this.c) {
            return;
        }
        ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
        zoomableDraweeView.getLogTag();
        zoomableDraweeView.hashCode();
        int i = FLog.a;
        if (zoomableDraweeView.n != null && ((DefaultZoomableController) zoomableDraweeView.o).e() > 1.1f) {
            zoomableDraweeView.a(zoomableDraweeView.n, null);
        }
        zoomableDraweeView.invalidate();
    }

    public void j() {
        FLog.i(DefaultZoomableController.class, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET);
        this.a.a.a();
        this.g.reset();
        this.h.reset();
        i();
    }

    public void k(boolean z2) {
        this.c = z2;
        if (z2) {
            return;
        }
        j();
    }
}
