package b.o.a.n.s;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.d.b.a.outline;
import b.o.a.CameraLogger;
import b.o.a.n.t.Angles;
import b.o.a.n.t.Reference2;
import b.o.a.t.MeteringTransform;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;

/* JADX INFO: renamed from: b.o.a.n.s.b, reason: use source file name */
/* JADX INFO: compiled from: Camera2MeteringTransform.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class Camera2MeteringTransform implements MeteringTransform<MeteringRectangle> {
    public static final CameraLogger a = new CameraLogger(Camera2MeteringTransform.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Angles f1939b;
    public final Size3 c;
    public final Size3 d;
    public final boolean e;
    public final CameraCharacteristics f;
    public final CaptureRequest.Builder g;

    public Camera2MeteringTransform(@NonNull Angles angles, @NonNull Size3 size3, @NonNull Size3 size4, boolean z2, @NonNull CameraCharacteristics cameraCharacteristics, @NonNull CaptureRequest.Builder builder) {
        this.f1939b = angles;
        this.c = size3;
        this.d = size4;
        this.e = z2;
        this.f = cameraCharacteristics;
        this.g = builder;
    }

    @Override // b.o.a.t.MeteringTransform
    @NonNull
    public MeteringRectangle a(@NonNull RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new MeteringRectangle(rect, i);
    }

    @Override // b.o.a.t.MeteringTransform
    @NonNull
    public PointF b(@NonNull PointF pointF) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        Size3 size3 = this.c;
        Size3 size4 = this.d;
        int iRound = size3.j;
        int iRound2 = size3.k;
        AspectRatio2 aspectRatio2G = AspectRatio2.g(size4);
        AspectRatio2 aspectRatio2F = AspectRatio2.f(size3.j, size3.k);
        if (this.e) {
            if (aspectRatio2G.i() > aspectRatio2F.i()) {
                float fI = aspectRatio2G.i() / aspectRatio2F.i();
                float f = pointF2.x;
                float f2 = size3.j;
                pointF2.x = (((fI - 1.0f) * f2) / 2.0f) + f;
                iRound = Math.round(f2 * fI);
            } else {
                float fI2 = aspectRatio2F.i() / aspectRatio2G.i();
                float f3 = pointF2.y;
                float f4 = size3.k;
                pointF2.y = (((fI2 - 1.0f) * f4) / 2.0f) + f3;
                iRound2 = Math.round(f4 * fI2);
            }
        }
        Size3 size3F = this.d;
        pointF2.x = (size3F.j / iRound) * pointF2.x;
        pointF2.y = (size3F.k / iRound2) * pointF2.y;
        int iC = this.f1939b.c(Reference2.SENSOR, Reference2.VIEW, 1);
        boolean z2 = iC % 180 != 0;
        float f5 = pointF2.x;
        float f6 = pointF2.y;
        if (iC == 0) {
            pointF2.x = f5;
            pointF2.y = f6;
        } else if (iC == 90) {
            pointF2.x = f6;
            pointF2.y = size3F.j - f5;
        } else if (iC == 180) {
            pointF2.x = size3F.j - f5;
            pointF2.y = size3F.k - f6;
        } else {
            if (iC != 270) {
                throw new IllegalStateException(outline.q("Unexpected angle ", iC));
            }
            pointF2.x = size3F.k - f6;
            pointF2.y = f5;
        }
        if (z2) {
            size3F = size3F.f();
        }
        Rect rect = (Rect) this.g.get(CaptureRequest.SCALER_CROP_REGION);
        int iWidth = rect == null ? size3F.j : rect.width();
        int iHeight = rect == null ? size3F.k : rect.height();
        pointF2.x = ((iWidth - size3F.j) / 2.0f) + pointF2.x;
        pointF2.y = ((iHeight - size3F.k) / 2.0f) + pointF2.y;
        Rect rect2 = (Rect) this.g.get(CaptureRequest.SCALER_CROP_REGION);
        pointF2.x += rect2 == null ? 0.0f : rect2.left;
        pointF2.y += rect2 == null ? 0.0f : rect2.top;
        Rect rect3 = (Rect) this.f.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect3 == null) {
            rect3 = new Rect(0, 0, iWidth, iHeight);
        }
        int iWidth2 = rect3.width();
        int iHeight2 = rect3.height();
        CameraLogger cameraLogger = a;
        cameraLogger.a(1, "input:", pointF, "output (before clipping):", pointF2);
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
        cameraLogger.a(1, "input:", pointF, "output (after clipping):", pointF2);
        return pointF2;
    }
}
