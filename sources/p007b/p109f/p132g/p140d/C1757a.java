package p007b.p109f.p132g.p140d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p132g.p140d.p141b.InterfaceC1759b;

/* JADX INFO: renamed from: b.f.g.d.a */
/* JADX INFO: compiled from: DebugControllerOverlayDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1757a extends Drawable implements InterfaceC1759b {

    /* JADX INFO: renamed from: A */
    public int f3299A;

    /* JADX INFO: renamed from: B */
    public long f3300B;

    /* JADX INFO: renamed from: C */
    public String f3301C;

    /* JADX INFO: renamed from: j */
    public String f3303j;

    /* JADX INFO: renamed from: k */
    public int f3304k;

    /* JADX INFO: renamed from: l */
    public int f3305l;

    /* JADX INFO: renamed from: m */
    public int f3306m;

    /* JADX INFO: renamed from: n */
    public ScalingUtils$ScaleType f3307n;

    /* JADX INFO: renamed from: p */
    public int f3309p;

    /* JADX INFO: renamed from: q */
    public int f3310q;

    /* JADX INFO: renamed from: w */
    public int f3316w;

    /* JADX INFO: renamed from: x */
    public int f3317x;

    /* JADX INFO: renamed from: y */
    public int f3318y;

    /* JADX INFO: renamed from: z */
    public int f3319z;

    /* JADX INFO: renamed from: o */
    public HashMap<String, String> f3308o = new HashMap<>();

    /* JADX INFO: renamed from: r */
    public int f3311r = 80;

    /* JADX INFO: renamed from: s */
    public final Paint f3312s = new Paint(1);

    /* JADX INFO: renamed from: t */
    public final Matrix f3313t = new Matrix();

    /* JADX INFO: renamed from: u */
    public final Rect f3314u = new Rect();

    /* JADX INFO: renamed from: v */
    public final RectF f3315v = new RectF();

    /* JADX INFO: renamed from: D */
    public int f3302D = -1;

    public C1757a() {
        m1089c();
    }

    /* JADX INFO: renamed from: b */
    public static String m1087b(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* JADX INFO: renamed from: a */
    public final void m1088a(Canvas canvas, String str, String str2, int i) {
        String strM883w = C1643a.m883w(str, ": ");
        float fMeasureText = this.f3312s.measureText(strM883w);
        float fMeasureText2 = this.f3312s.measureText(str2);
        this.f3312s.setColor(1711276032);
        int i2 = this.f3319z;
        int i3 = this.f3299A;
        canvas.drawRect(i2 - 4, i3 + 8, i2 + fMeasureText + fMeasureText2 + 4.0f, i3 + this.f3318y + 8, this.f3312s);
        this.f3312s.setColor(-1);
        canvas.drawText(strM883w, this.f3319z, this.f3299A, this.f3312s);
        this.f3312s.setColor(i);
        canvas.drawText(str2, this.f3319z + fMeasureText, this.f3299A, this.f3312s);
        this.f3299A += this.f3318y;
    }

    /* JADX INFO: renamed from: c */
    public void m1089c() {
        this.f3304k = -1;
        this.f3305l = -1;
        this.f3306m = -1;
        this.f3308o = new HashMap<>();
        this.f3309p = -1;
        this.f3310q = -1;
        this.f3303j = "none";
        invalidateSelf();
        this.f3300B = -1L;
        this.f3301C = null;
        this.f3302D = -1;
        invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x013d  */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        int i2;
        Rect bounds = getBounds();
        this.f3312s.setStyle(Paint.Style.STROKE);
        this.f3312s.setStrokeWidth(2.0f);
        this.f3312s.setColor(-26624);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f3312s);
        this.f3312s.setStyle(Paint.Style.FILL);
        this.f3312s.setColor(0);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f3312s);
        this.f3312s.setStyle(Paint.Style.FILL);
        this.f3312s.setStrokeWidth(0.0f);
        this.f3312s.setColor(-1);
        this.f3319z = this.f3316w;
        this.f3299A = this.f3317x;
        m1088a(canvas, "ID", this.f3303j, -1);
        m1088a(canvas, "D", m1087b("%dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height())), -1);
        int i3 = this.f3304k;
        int i4 = this.f3305l;
        ScalingUtils$ScaleType scalingUtils$ScaleType = this.f3307n;
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        if (iWidth <= 0 || iHeight <= 0 || i3 <= 0 || i4 <= 0) {
            i = -65536;
        } else {
            if (scalingUtils$ScaleType != null) {
                Rect rect = this.f3314u;
                rect.top = 0;
                rect.left = 0;
                rect.right = iWidth;
                rect.bottom = iHeight;
                this.f3313t.reset();
                scalingUtils$ScaleType.mo1121a(this.f3313t, this.f3314u, i3, i4, 0.0f, 0.0f);
                RectF rectF = this.f3315v;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                rectF.right = i3;
                rectF.bottom = i4;
                this.f3313t.mapRect(rectF);
                int iWidth2 = (int) this.f3315v.width();
                int iHeight2 = (int) this.f3315v.height();
                iWidth = Math.min(iWidth, iWidth2);
                iHeight = Math.min(iHeight, iHeight2);
            }
            float f = iWidth;
            float f2 = f * 0.1f;
            float f3 = f * 0.5f;
            float f4 = iHeight;
            float f5 = 0.1f * f4;
            float f6 = f4 * 0.5f;
            int iAbs = Math.abs(i3 - iWidth);
            int iAbs2 = Math.abs(i4 - iHeight);
            float f7 = iAbs;
            if (f7 < f2 && iAbs2 < f5) {
                i = -16711936;
            } else if (f7 >= f3 || iAbs2 >= f6) {
                i = -65536;
            } else {
                i = InputDeviceCompat.SOURCE_ANY;
            }
        }
        m1088a(canvas, "I", m1087b("%dx%d", Integer.valueOf(this.f3304k), Integer.valueOf(this.f3305l)), i);
        m1088a(canvas, "I", m1087b("%d KiB", Integer.valueOf(this.f3306m / 1024)), -1);
        int i5 = this.f3309p;
        if (i5 > 0) {
            i2 = -1;
            m1088a(canvas, "anim", m1087b("f %d, l %d", Integer.valueOf(i5), Integer.valueOf(this.f3310q)), -1);
        } else {
            i2 = -1;
        }
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = this.f3307n;
        if (scalingUtils$ScaleType2 != null) {
            m1088a(canvas, "scale", String.valueOf(scalingUtils$ScaleType2), i2);
        }
        long j = this.f3300B;
        if (j >= 0) {
            m1088a(canvas, "t", m1087b("%d ms", Long.valueOf(j)), -1);
        }
        String str = this.f3301C;
        if (str != null) {
            m1088a(canvas, "origin", str, this.f3302D);
        }
        for (Map.Entry<String, String> entry : this.f3308o.entrySet()) {
            m1088a(canvas, entry.getKey(), entry.getValue(), -1);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iMin = Math.min(40, Math.max(10, Math.min(rect.width() / 8, rect.height() / 9)));
        this.f3312s.setTextSize(iMin);
        int i = iMin + 8;
        this.f3318y = i;
        int i2 = this.f3311r;
        if (i2 == 80) {
            this.f3318y = i * (-1);
        }
        this.f3316w = rect.left + 10;
        this.f3317x = i2 == 80 ? rect.bottom - 10 : rect.top + 10 + 10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
