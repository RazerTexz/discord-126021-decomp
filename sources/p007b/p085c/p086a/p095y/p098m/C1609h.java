package p007b.p085c.p086a.p095y.p098m;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.C1524a;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1559p;

/* JADX INFO: renamed from: b.c.a.y.m.h */
/* JADX INFO: compiled from: SolidLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class C1609h extends AbstractC1603b {

    /* JADX INFO: renamed from: A */
    public final Path f2899A;

    /* JADX INFO: renamed from: B */
    public final C1606e f2900B;

    /* JADX INFO: renamed from: C */
    @Nullable
    public AbstractC1544a<ColorFilter, ColorFilter> f2901C;

    /* JADX INFO: renamed from: x */
    public final RectF f2902x;

    /* JADX INFO: renamed from: y */
    public final Paint f2903y;

    /* JADX INFO: renamed from: z */
    public final float[] f2904z;

    public C1609h(C1511j c1511j, C1606e c1606e) {
        super(c1511j, c1606e);
        this.f2902x = new RectF();
        C1524a c1524a = new C1524a();
        this.f2903y = c1524a;
        this.f2904z = new float[8];
        this.f2899A = new Path();
        this.f2900B = c1606e;
        c1524a.setAlpha(0);
        c1524a.setStyle(Paint.Style.FILL);
        c1524a.setColor(c1606e.f2879l);
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b, p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        super.mo712d(rectF, matrix, z2);
        RectF rectF2 = this.f2902x;
        C1606e c1606e = this.f2900B;
        rectF2.set(0.0f, 0.0f, c1606e.f2877j, c1606e.f2878k);
        this.f2848m.mapRect(this.f2902x);
        rectF.set(this.f2902x);
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b, p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        this.f2857v.m745c(t, c1503c);
        if (t == InterfaceC1516o.f2421C) {
            if (c1503c == null) {
                this.f2901C = null;
            } else {
                this.f2901C = new C1559p(c1503c, null);
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b
    /* JADX INFO: renamed from: j */
    public void mo780j(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.f2900B.f2879l);
        if (iAlpha == 0) {
            return;
        }
        AbstractC1544a<Integer, Integer> abstractC1544a = this.f2857v.f2636j;
        int iIntValue = (int) ((((iAlpha / 255.0f) * (abstractC1544a == null ? 100 : abstractC1544a.mo727e().intValue())) / 100.0f) * (i / 255.0f) * 255.0f);
        this.f2903y.setAlpha(iIntValue);
        AbstractC1544a<ColorFilter, ColorFilter> abstractC1544a2 = this.f2901C;
        if (abstractC1544a2 != null) {
            this.f2903y.setColorFilter(abstractC1544a2.mo727e());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f2904z;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            C1606e c1606e = this.f2900B;
            int i2 = c1606e.f2877j;
            fArr[2] = i2;
            fArr[3] = 0.0f;
            fArr[4] = i2;
            int i3 = c1606e.f2878k;
            fArr[5] = i3;
            fArr[6] = 0.0f;
            fArr[7] = i3;
            matrix.mapPoints(fArr);
            this.f2899A.reset();
            Path path = this.f2899A;
            float[] fArr2 = this.f2904z;
            path.moveTo(fArr2[0], fArr2[1]);
            Path path2 = this.f2899A;
            float[] fArr3 = this.f2904z;
            path2.lineTo(fArr3[2], fArr3[3]);
            Path path3 = this.f2899A;
            float[] fArr4 = this.f2904z;
            path3.lineTo(fArr4[4], fArr4[5]);
            Path path4 = this.f2899A;
            float[] fArr5 = this.f2904z;
            path4.lineTo(fArr5[6], fArr5[7]);
            Path path5 = this.f2899A;
            float[] fArr6 = this.f2904z;
            path5.lineTo(fArr6[0], fArr6[1]);
            this.f2899A.close();
            canvas.drawPath(this.f2899A, this.f2903y);
        }
    }
}
