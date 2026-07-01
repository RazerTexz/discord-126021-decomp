package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import b.c.a.j;
import b.c.a.o;
import b.c.a.w.c.p;

/* JADX INFO: compiled from: SolidLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends b {
    public final Path A;
    public final e B;

    @Nullable
    public b.c.a.w.c.a<ColorFilter, ColorFilter> C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RectF f441x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Paint f442y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float[] f443z;

    public h(j jVar, e eVar) {
        super(jVar, eVar);
        this.f441x = new RectF();
        b.c.a.w.a aVar = new b.c.a.w.a();
        this.f442y = aVar;
        this.f443z = new float[8];
        this.A = new Path();
        this.B = eVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint$Style.FILL);
        aVar.setColor(eVar.l);
    }

    @Override // b.c.a.y.m.b, b.c.a.w.b.e
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        RectF rectF2 = this.f441x;
        e eVar = this.B;
        rectF2.set(0.0f, 0.0f, eVar.j, eVar.k);
        this.m.mapRect(this.f441x);
        rectF.set(this.f441x);
    }

    @Override // b.c.a.y.m.b, b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        this.v.c(t, cVar);
        if (t == o.C) {
            if (cVar == null) {
                this.C = null;
            } else {
                this.C = new p(cVar, null);
            }
        }
    }

    @Override // b.c.a.y.m.b
    public void j(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.B.l);
        if (iAlpha == 0) {
            return;
        }
        b.c.a.w.c.a<Integer, Integer> aVar = this.v.j;
        int iIntValue = (int) ((((iAlpha / 255.0f) * (aVar == null ? 100 : aVar.e().intValue())) / 100.0f) * (i / 255.0f) * 255.0f);
        this.f442y.setAlpha(iIntValue);
        b.c.a.w.c.a<ColorFilter, ColorFilter> aVar2 = this.C;
        if (aVar2 != null) {
            this.f442y.setColorFilter(aVar2.e());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f443z;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            e eVar = this.B;
            int i2 = eVar.j;
            fArr[2] = i2;
            fArr[3] = 0.0f;
            fArr[4] = i2;
            int i3 = eVar.k;
            fArr[5] = i3;
            fArr[6] = 0.0f;
            fArr[7] = i3;
            matrix.mapPoints(fArr);
            this.A.reset();
            Path path = this.A;
            float[] fArr2 = this.f443z;
            path.moveTo(fArr2[0], fArr2[1]);
            Path path2 = this.A;
            float[] fArr3 = this.f443z;
            path2.lineTo(fArr3[2], fArr3[3]);
            Path path3 = this.A;
            float[] fArr4 = this.f443z;
            path3.lineTo(fArr4[4], fArr4[5]);
            Path path4 = this.A;
            float[] fArr5 = this.f443z;
            path4.lineTo(fArr5[6], fArr5[7]);
            Path path5 = this.A;
            float[] fArr6 = this.f443z;
            path5.lineTo(fArr6[0], fArr6[1]);
            this.A.close();
            canvas.drawPath(this.A, this.f442y);
        }
    }
}
