package p007b.p452o.p453a.p455n.p460s;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.p461t.C5170a;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p469t.InterfaceC5212c;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.n.s.b */
/* JADX INFO: compiled from: Camera2MeteringTransform.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5169b implements InterfaceC5212c<MeteringRectangle> {

    /* JADX INFO: renamed from: a */
    public static final C5103b f13988a = new C5103b(C5169b.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    public final C5170a f13989b;

    /* JADX INFO: renamed from: c */
    public final C5236b f13990c;

    /* JADX INFO: renamed from: d */
    public final C5236b f13991d;

    /* JADX INFO: renamed from: e */
    public final boolean f13992e;

    /* JADX INFO: renamed from: f */
    public final CameraCharacteristics f13993f;

    /* JADX INFO: renamed from: g */
    public final CaptureRequest.Builder f13994g;

    public C5169b(@NonNull C5170a c5170a, @NonNull C5236b c5236b, @NonNull C5236b c5236b2, boolean z2, @NonNull CameraCharacteristics cameraCharacteristics, @NonNull CaptureRequest.Builder builder) {
        this.f13989b = c5170a;
        this.f13990c = c5236b;
        this.f13991d = c5236b2;
        this.f13992e = z2;
        this.f13993f = cameraCharacteristics;
        this.f13994g = builder;
    }

    @Override // p007b.p452o.p453a.p469t.InterfaceC5212c
    @NonNull
    /* JADX INFO: renamed from: a */
    public MeteringRectangle mo7354a(@NonNull RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new MeteringRectangle(rect, i);
    }

    @Override // p007b.p452o.p453a.p469t.InterfaceC5212c
    @NonNull
    /* JADX INFO: renamed from: b */
    public PointF mo7355b(@NonNull PointF pointF) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        C5236b c5236b = this.f13990c;
        C5236b c5236b2 = this.f13991d;
        int iRound = c5236b.f14251j;
        int iRound2 = c5236b.f14252k;
        C5235a c5235aM7448g = C5235a.m7448g(c5236b2);
        C5235a c5235aM7447f = C5235a.m7447f(c5236b.f14251j, c5236b.f14252k);
        if (this.f13992e) {
            if (c5235aM7448g.m7450i() > c5235aM7447f.m7450i()) {
                float fM7450i = c5235aM7448g.m7450i() / c5235aM7447f.m7450i();
                float f = pointF2.x;
                float f2 = c5236b.f14251j;
                pointF2.x = (((fM7450i - 1.0f) * f2) / 2.0f) + f;
                iRound = Math.round(f2 * fM7450i);
            } else {
                float fM7450i2 = c5235aM7447f.m7450i() / c5235aM7448g.m7450i();
                float f3 = pointF2.y;
                float f4 = c5236b.f14252k;
                pointF2.y = (((fM7450i2 - 1.0f) * f4) / 2.0f) + f3;
                iRound2 = Math.round(f4 * fM7450i2);
            }
        }
        C5236b c5236bM7451f = this.f13991d;
        pointF2.x = (c5236bM7451f.f14251j / iRound) * pointF2.x;
        pointF2.y = (c5236bM7451f.f14252k / iRound2) * pointF2.y;
        int iM7358c = this.f13989b.m7358c(EnumC5171b.SENSOR, EnumC5171b.VIEW, 1);
        boolean z2 = iM7358c % 180 != 0;
        float f5 = pointF2.x;
        float f6 = pointF2.y;
        if (iM7358c == 0) {
            pointF2.x = f5;
            pointF2.y = f6;
        } else if (iM7358c == 90) {
            pointF2.x = f6;
            pointF2.y = c5236bM7451f.f14251j - f5;
        } else if (iM7358c == 180) {
            pointF2.x = c5236bM7451f.f14251j - f5;
            pointF2.y = c5236bM7451f.f14252k - f6;
        } else {
            if (iM7358c != 270) {
                throw new IllegalStateException(C1643a.m871q("Unexpected angle ", iM7358c));
            }
            pointF2.x = c5236bM7451f.f14252k - f6;
            pointF2.y = f5;
        }
        if (z2) {
            c5236bM7451f = c5236bM7451f.m7451f();
        }
        Rect rect = (Rect) this.f13994g.get(CaptureRequest.SCALER_CROP_REGION);
        int iWidth = rect == null ? c5236bM7451f.f14251j : rect.width();
        int iHeight = rect == null ? c5236bM7451f.f14252k : rect.height();
        pointF2.x = ((iWidth - c5236bM7451f.f14251j) / 2.0f) + pointF2.x;
        pointF2.y = ((iHeight - c5236bM7451f.f14252k) / 2.0f) + pointF2.y;
        Rect rect2 = (Rect) this.f13994g.get(CaptureRequest.SCALER_CROP_REGION);
        pointF2.x += rect2 == null ? 0.0f : rect2.left;
        pointF2.y += rect2 == null ? 0.0f : rect2.top;
        Rect rect3 = (Rect) this.f13993f.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect3 == null) {
            rect3 = new Rect(0, 0, iWidth, iHeight);
        }
        int iWidth2 = rect3.width();
        int iHeight2 = rect3.height();
        C5103b c5103b = f13988a;
        c5103b.m7159a(1, "input:", pointF, "output (before clipping):", pointF2);
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
        c5103b.m7159a(1, "input:", pointF, "output (after clipping):", pointF2);
        return pointF2;
    }
}
