package b.f.j.a.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import b.f.j.a.a.e;
import java.util.Objects;

/* JADX INFO: compiled from: AnimatedDrawableBackendImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements b.f.j.a.a.a {
    public final b.f.j.a.d.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f548b;
    public final b.f.j.a.a.c c;
    public final Rect d;
    public final int[] e;
    public final b.f.j.a.a.b[] f;
    public final Rect g = new Rect();
    public final Rect h = new Rect();
    public final boolean i;
    public Bitmap j;

    public a(b.f.j.a.d.a aVar, e eVar, Rect rect, boolean z2) {
        this.a = aVar;
        this.f548b = eVar;
        b.f.j.a.a.c cVar = eVar.a;
        this.c = cVar;
        int[] iArrI = cVar.i();
        this.e = iArrI;
        Objects.requireNonNull(aVar);
        for (int i = 0; i < iArrI.length; i++) {
            if (iArrI[i] < 11) {
                iArrI[i] = 100;
            }
        }
        b.f.j.a.d.a aVar2 = this.a;
        int[] iArr = this.e;
        Objects.requireNonNull(aVar2);
        for (int i2 : iArr) {
        }
        b.f.j.a.d.a aVar3 = this.a;
        int[] iArr2 = this.e;
        Objects.requireNonNull(aVar3);
        int[] iArr3 = new int[iArr2.length];
        int i3 = 0;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            iArr3[i4] = i3;
            i3 += iArr2[i4];
        }
        this.d = a(this.c, rect);
        this.i = z2;
        this.f = new b.f.j.a.a.b[this.c.a()];
        for (int i5 = 0; i5 < this.c.a(); i5++) {
            this.f[i5] = this.c.g(i5);
        }
    }

    public static Rect a(b.f.j.a.a.c cVar, Rect rect) {
        return rect == null ? new Rect(0, 0, cVar.getWidth(), cVar.getHeight()) : new Rect(0, 0, Math.min(rect.width(), cVar.getWidth()), Math.min(rect.height(), cVar.getHeight()));
    }

    public int b() {
        return this.c.a();
    }

    public final synchronized Bitmap c(int i, int i2) {
        Bitmap bitmap = this.j;
        if (bitmap != null && (bitmap.getWidth() < i || this.j.getHeight() < i2)) {
            synchronized (this) {
                Bitmap bitmap2 = this.j;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                    this.j = null;
                }
            }
        }
        if (this.j == null) {
            this.j = Bitmap.createBitmap(i, i2, Bitmap$Config.ARGB_8888);
        }
        this.j.eraseColor(0);
        return this.j;
    }

    public void d(int i, Canvas canvas) {
        b.f.j.a.a.d dVarE = this.c.e(i);
        try {
            if (dVarE.getWidth() > 0 && dVarE.getHeight() > 0) {
                if (this.c.f()) {
                    f(canvas, dVarE);
                } else {
                    e(canvas, dVarE);
                }
            }
        } finally {
            dVarE.dispose();
        }
    }

    public final void e(Canvas canvas, b.f.j.a.a.d dVar) {
        int width;
        int height;
        int iB;
        int iC;
        if (this.i) {
            float fMax = Math.max(dVar.getWidth() / Math.min(dVar.getWidth(), canvas.getWidth()), dVar.getHeight() / Math.min(dVar.getHeight(), canvas.getHeight()));
            width = (int) (dVar.getWidth() / fMax);
            height = (int) (dVar.getHeight() / fMax);
            iB = (int) (dVar.b() / fMax);
            iC = (int) (dVar.c() / fMax);
        } else {
            width = dVar.getWidth();
            height = dVar.getHeight();
            iB = dVar.b();
            iC = dVar.c();
        }
        synchronized (this) {
            Bitmap bitmapC = c(width, height);
            this.j = bitmapC;
            dVar.a(width, height, bitmapC);
            canvas.save();
            canvas.translate(iB, iC);
            canvas.drawBitmap(this.j, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }

    public final void f(Canvas canvas, b.f.j.a.a.d dVar) {
        double dWidth = ((double) this.d.width()) / ((double) this.c.getWidth());
        double dHeight = ((double) this.d.height()) / ((double) this.c.getHeight());
        int iRound = (int) Math.round(((double) dVar.getWidth()) * dWidth);
        int iRound2 = (int) Math.round(((double) dVar.getHeight()) * dHeight);
        int iB = (int) (((double) dVar.b()) * dWidth);
        int iC = (int) (((double) dVar.c()) * dHeight);
        synchronized (this) {
            int iWidth = this.d.width();
            int iHeight = this.d.height();
            c(iWidth, iHeight);
            Bitmap bitmap = this.j;
            if (bitmap != null) {
                dVar.a(iRound, iRound2, bitmap);
            }
            this.g.set(0, 0, iWidth, iHeight);
            this.h.set(iB, iC, iWidth + iB, iHeight + iC);
            Bitmap bitmap2 = this.j;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, this.g, this.h, (Paint) null);
            }
        }
    }
}
