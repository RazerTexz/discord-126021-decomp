package b.f.g.e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: FadeDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends b {

    @VisibleForTesting
    public int A;

    @VisibleForTesting
    public boolean[] B;

    @VisibleForTesting
    public int C;
    public b.f.h.b.a.d D;
    public boolean E;
    public boolean F;
    public final Drawable[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f507s;
    public final int t;
    public final int u;

    @VisibleForTesting
    public int v;

    @VisibleForTesting
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @VisibleForTesting
    public long f508x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @VisibleForTesting
    public int[] f509y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @VisibleForTesting
    public int[] f510z;

    public f(Drawable[] drawableArr, boolean z2, int i) {
        super(drawableArr);
        this.F = true;
        b.c.a.a0.d.C(drawableArr.length >= 1, "At least one layer required!");
        this.r = drawableArr;
        int[] iArr = new int[drawableArr.length];
        this.f509y = iArr;
        this.f510z = new int[drawableArr.length];
        this.A = 255;
        this.B = new boolean[drawableArr.length];
        this.C = 0;
        this.f507s = z2;
        int i2 = z2 ? 255 : 0;
        this.t = i2;
        this.u = i;
        this.v = 2;
        Arrays.fill(iArr, i2);
        this.f509y[0] = 255;
        Arrays.fill(this.f510z, i2);
        this.f510z[0] = 255;
        Arrays.fill(this.B, z2);
        this.B[0] = true;
    }

    @Override // b.f.g.e.b, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean zI;
        int i;
        int i2 = this.v;
        if (i2 == 0) {
            System.arraycopy(this.f510z, 0, this.f509y, 0, this.r.length);
            this.f508x = SystemClock.uptimeMillis();
            zI = i(this.w == 0 ? 1.0f : 0.0f);
            if (!this.E && (i = this.u) >= 0) {
                boolean[] zArr = this.B;
                if (i < zArr.length && zArr[i]) {
                    this.E = true;
                    b.f.h.b.a.d dVar = this.D;
                    if (dVar != null) {
                        Objects.requireNonNull(((b.f.g.c.a) dVar).a);
                    }
                }
            }
            this.v = zI ? 2 : 1;
        } else if (i2 != 1) {
            zI = true;
        } else {
            b.c.a.a0.d.B(this.w > 0);
            zI = i((SystemClock.uptimeMillis() - this.f508x) / this.w);
            this.v = zI ? 2 : 1;
        }
        int i3 = 0;
        while (true) {
            Drawable[] drawableArr = this.r;
            if (i3 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i3];
            int iCeil = (int) Math.ceil(((double) (this.f510z[i3] * this.A)) / 255.0d);
            if (drawable != null && iCeil > 0) {
                this.C++;
                if (this.F) {
                    drawable.mutate();
                }
                drawable.setAlpha(iCeil);
                this.C--;
                drawable.draw(canvas);
            }
            i3++;
        }
        if (!zI) {
            invalidateSelf();
            return;
        }
        if (this.E) {
            this.E = false;
            b.f.h.b.a.d dVar2 = this.D;
            if (dVar2 != null) {
                Objects.requireNonNull(((b.f.g.c.a) dVar2).a);
            }
        }
    }

    public void e() {
        this.C++;
    }

    public void f() {
        this.C--;
        invalidateSelf();
    }

    public void g() {
        this.v = 2;
        for (int i = 0; i < this.r.length; i++) {
            this.f510z[i] = this.B[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.A;
    }

    public final boolean i(float f) {
        boolean z2 = true;
        for (int i = 0; i < this.r.length; i++) {
            boolean[] zArr = this.B;
            int i2 = zArr[i] ? 1 : -1;
            int[] iArr = this.f510z;
            iArr[i] = (int) ((i2 * 255 * f) + this.f509y[i]);
            if (iArr[i] < 0) {
                iArr[i] = 0;
            }
            if (iArr[i] > 255) {
                iArr[i] = 255;
            }
            if (zArr[i] && iArr[i] < 255) {
                z2 = false;
            }
            if (!zArr[i] && iArr[i] > 0) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.C == 0) {
            super.invalidateSelf();
        }
    }

    @Override // b.f.g.e.b, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.A != i) {
            this.A = i;
            invalidateSelf();
        }
    }
}
