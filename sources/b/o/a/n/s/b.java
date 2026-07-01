package b.o.a.n.s;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest$Builder;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.t.c;

/* JADX INFO: compiled from: Camera2MeteringTransform.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class b implements c<MeteringRectangle> {
    public static final b.o.a.b a = new b.o.a.b(b.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.o.a.n.t.a f1939b;
    public final b.o.a.x.b c;
    public final b.o.a.x.b d;
    public final boolean e;
    public final CameraCharacteristics f;
    public final CaptureRequest$Builder g;

    public b(@NonNull b.o.a.n.t.a aVar, @NonNull b.o.a.x.b bVar, @NonNull b.o.a.x.b bVar2, boolean z2, @NonNull CameraCharacteristics cameraCharacteristics, @NonNull CaptureRequest$Builder captureRequest$Builder) {
        this.f1939b = aVar;
        this.c = bVar;
        this.d = bVar2;
        this.e = z2;
        this.f = cameraCharacteristics;
        this.g = captureRequest$Builder;
    }

    @Override // b.o.a.t.c
    @NonNull
    public MeteringRectangle a(@NonNull RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new MeteringRectangle(rect, i);
    }

    @Override // b.o.a.t.c
    @NonNull
    public PointF b(@NonNull PointF pointF) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        b.o.a.x.b bVar = this.c;
        b.o.a.x.b bVar2 = this.d;
        int iRound = bVar.j;
        int iRound2 = bVar.k;
        b.o.a.x.a aVarG = b.o.a.x.a.g(bVar2);
        b.o.a.x.a aVarF = b.o.a.x.a.f(bVar.j, bVar.k);
        if (this.e) {
            if (aVarG.i() > aVarF.i()) {
                float fI = aVarG.i() / aVarF.i();
                float f = pointF2.x;
                float f2 = bVar.j;
                pointF2.x = (((fI - 1.0f) * f2) / 2.0f) + f;
                iRound = Math.round(f2 * fI);
            } else {
                float fI2 = aVarF.i() / aVarG.i();
                float f3 = pointF2.y;
                float f4 = bVar.k;
                pointF2.y = (((fI2 - 1.0f) * f4) / 2.0f) + f3;
                iRound2 = Math.round(f4 * fI2);
            }
        }
        b.o.a.x.b bVarF = this.d;
        pointF2.x = (bVarF.j / iRound) * pointF2.x;
        pointF2.y = (bVarF.k / iRound2) * pointF2.y;
        int iC = this.f1939b.c(b.o.a.n.t.b.SENSOR, b.o.a.n.t.b.VIEW, 1);
        boolean z2 = iC % 180 != 0;
        float f5 = pointF2.x;
        float f6 = pointF2.y;
        if (iC == 0) {
            pointF2.x = f5;
            pointF2.y = f6;
        } else if (iC == 90) {
            pointF2.x = f6;
            pointF2.y = bVarF.j - f5;
        } else if (iC == 180) {
            pointF2.x = bVarF.j - f5;
            pointF2.y = bVarF.k - f6;
        } else {
            if (iC != 270) {
                throw new IllegalStateException(b.d.b.a.a.q("Unexpected angle ", iC));
            }
            pointF2.x = bVarF.k - f6;
            pointF2.y = f5;
        }
        if (z2) {
            bVarF = bVarF.f();
        }
        Rect rect = (Rect) this.g.get(CaptureRequest.SCALER_CROP_REGION);
        int iWidth = rect == null ? bVarF.j : rect.width();
        int iHeight = rect == null ? bVarF.k : rect.height();
        pointF2.x = ((iWidth - bVarF.j) / 2.0f) + pointF2.x;
        pointF2.y = ((iHeight - bVarF.k) / 2.0f) + pointF2.y;
        Rect rect2 = (Rect) this.g.get(CaptureRequest.SCALER_CROP_REGION);
        pointF2.x += rect2 == null ? 0.0f : rect2.left;
        pointF2.y += rect2 == null ? 0.0f : rect2.top;
        Rect rect3 = (Rect) this.f.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect3 == null) {
            rect3 = new Rect(0, 0, iWidth, iHeight);
        }
        int iWidth2 = rect3.width();
        int iHeight2 = rect3.height();
        b.o.a.b bVar3 = a;
        bVar3.a(1, "input:", pointF, "output (before clipping):", pointF2);
        if (pointF2.x < 0.0f) {
            pointF2.x = 0.0f;
        }
        if (pointF2.y < 0.0f) {
            pointF2.y = 0.0f;
        }
        float f7 = iWidth2;
        if (pointF2.x > f7) {
            pointF2.x = f7;
        }
        float f8 = iHeight2;
        if (pointF2.y > f8) {
            pointF2.y = f8;
        }
        bVar3.a(1, "input:", pointF, "output (after clipping):", pointF2);
        return pointF2;
    }
}
