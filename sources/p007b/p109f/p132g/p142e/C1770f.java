package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p132g.p139c.C1753a;
import p007b.p109f.p148h.p158b.p159a.InterfaceC1829d;

/* JADX INFO: renamed from: b.f.g.e.f */
/* JADX INFO: compiled from: FadeDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1770f extends C1762b {

    /* JADX INFO: renamed from: A */
    @VisibleForTesting
    public int f3344A;

    /* JADX INFO: renamed from: B */
    @VisibleForTesting
    public boolean[] f3345B;

    /* JADX INFO: renamed from: C */
    @VisibleForTesting
    public int f3346C;

    /* JADX INFO: renamed from: D */
    public InterfaceC1829d f3347D;

    /* JADX INFO: renamed from: E */
    public boolean f3348E;

    /* JADX INFO: renamed from: F */
    public boolean f3349F;

    /* JADX INFO: renamed from: r */
    public final Drawable[] f3350r;

    /* JADX INFO: renamed from: s */
    public final boolean f3351s;

    /* JADX INFO: renamed from: t */
    public final int f3352t;

    /* JADX INFO: renamed from: u */
    public final int f3353u;

    /* JADX INFO: renamed from: v */
    @VisibleForTesting
    public int f3354v;

    /* JADX INFO: renamed from: w */
    @VisibleForTesting
    public int f3355w;

    /* JADX INFO: renamed from: x */
    @VisibleForTesting
    public long f3356x;

    /* JADX INFO: renamed from: y */
    @VisibleForTesting
    public int[] f3357y;

    /* JADX INFO: renamed from: z */
    @VisibleForTesting
    public int[] f3358z;

    public C1770f(Drawable[] drawableArr, boolean z2, int i) {
        super(drawableArr);
        this.f3349F = true;
        C1460d.m423C(drawableArr.length >= 1, "At least one layer required!");
        this.f3350r = drawableArr;
        int[] iArr = new int[drawableArr.length];
        this.f3357y = iArr;
        this.f3358z = new int[drawableArr.length];
        this.f3344A = 255;
        this.f3345B = new boolean[drawableArr.length];
        this.f3346C = 0;
        this.f3351s = z2;
        int i2 = z2 ? 255 : 0;
        this.f3352t = i2;
        this.f3353u = i;
        this.f3354v = 2;
        Arrays.fill(iArr, i2);
        this.f3357y[0] = 255;
        Arrays.fill(this.f3358z, i2);
        this.f3358z[0] = 255;
        Arrays.fill(this.f3345B, z2);
        this.f3345B[0] = true;
    }

    @Override // p007b.p109f.p132g.p142e.C1762b, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean zM1101i;
        int i;
        int i2 = this.f3354v;
        if (i2 == 0) {
            System.arraycopy(this.f3358z, 0, this.f3357y, 0, this.f3350r.length);
            this.f3356x = SystemClock.uptimeMillis();
            zM1101i = m1101i(this.f3355w == 0 ? 1.0f : 0.0f);
            if (!this.f3348E && (i = this.f3353u) >= 0) {
                boolean[] zArr = this.f3345B;
                if (i < zArr.length && zArr[i]) {
                    this.f3348E = true;
                    InterfaceC1829d interfaceC1829d = this.f3347D;
                    if (interfaceC1829d != null) {
                        Objects.requireNonNull(((C1753a) interfaceC1829d).f3291a);
                    }
                }
            }
            this.f3354v = zM1101i ? 2 : 1;
        } else if (i2 != 1) {
            zM1101i = true;
        } else {
            C1460d.m419B(this.f3355w > 0);
            zM1101i = m1101i((SystemClock.uptimeMillis() - this.f3356x) / this.f3355w);
            this.f3354v = zM1101i ? 2 : 1;
        }
        int i3 = 0;
        while (true) {
            Drawable[] drawableArr = this.f3350r;
            if (i3 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i3];
            int iCeil = (int) Math.ceil(((double) (this.f3358z[i3] * this.f3344A)) / 255.0d);
            if (drawable != null && iCeil > 0) {
                this.f3346C++;
                if (this.f3349F) {
                    drawable.mutate();
                }
                drawable.setAlpha(iCeil);
                this.f3346C--;
                drawable.draw(canvas);
            }
            i3++;
        }
        if (!zM1101i) {
            invalidateSelf();
            return;
        }
        if (this.f3348E) {
            this.f3348E = false;
            InterfaceC1829d interfaceC1829d2 = this.f3347D;
            if (interfaceC1829d2 != null) {
                Objects.requireNonNull(((C1753a) interfaceC1829d2).f3291a);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public void m1098e() {
        this.f3346C++;
    }

    /* JADX INFO: renamed from: f */
    public void m1099f() {
        this.f3346C--;
        invalidateSelf();
    }

    /* JADX INFO: renamed from: g */
    public void m1100g() {
        this.f3354v = 2;
        for (int i = 0; i < this.f3350r.length; i++) {
            this.f3358z[i] = this.f3345B[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3344A;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m1101i(float f) {
        boolean z2 = true;
        for (int i = 0; i < this.f3350r.length; i++) {
            boolean[] zArr = this.f3345B;
            int i2 = zArr[i] ? 1 : -1;
            int[] iArr = this.f3358z;
            iArr[i] = (int) ((i2 * 255 * f) + this.f3357y[i]);
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
        if (this.f3346C == 0) {
            super.invalidateSelf();
        }
    }

    @Override // p007b.p109f.p132g.p142e.C1762b, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f3344A != i) {
            this.f3344A = i;
            invalidateSelf();
        }
    }
}
