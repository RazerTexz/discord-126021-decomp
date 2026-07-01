package b.f.g.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import b.d.b.a.outline;
import b.f.g.d.b.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: renamed from: b.f.g.d.a, reason: use source file name */
/* JADX INFO: compiled from: DebugControllerOverlayDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    public int A;
    public long B;
    public String C;
    public String j;
    public int k;
    public int l;
    public int m;
    public ScalingUtils$ScaleType n;
    public int p;
    public int q;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f502x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f503y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f504z;
    public HashMap<String, String> o = new HashMap<>();
    public int r = 80;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f501s = new Paint(1);
    public final Matrix t = new Matrix();
    public final Rect u = new Rect();
    public final RectF v = new RectF();
    public int D = -1;

    public DebugControllerOverlayDrawable() {
        c();
    }

    public static String b(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void a(Canvas canvas, String str, String str2, int i) {
        String strW = outline.w(str, ": ");
        float fMeasureText = this.f501s.measureText(strW);
        float fMeasureText2 = this.f501s.measureText(str2);
        this.f501s.setColor(1711276032);
        int i2 = this.f504z;
        int i3 = this.A;
        canvas.drawRect(i2 - 4, i3 + 8, i2 + fMeasureText + fMeasureText2 + 4.0f, i3 + this.f503y + 8, this.f501s);
        this.f501s.setColor(-1);
        canvas.drawText(strW, this.f504z, this.A, this.f501s);
        this.f501s.setColor(i);
        canvas.drawText(str2, this.f504z + fMeasureText, this.A, this.f501s);
        this.A += this.f503y;
    }

    public void c() {
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.o = new HashMap<>();
        this.p = -1;
        this.q = -1;
        this.j = "none";
        invalidateSelf();
        this.B = -1L;
        this.C = null;
        this.D = -1;
        invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x013d  */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        int i2;
        Rect bounds = getBounds();
        this.f501s.setStyle(Paint.Style.STROKE);
        this.f501s.setStrokeWidth(2.0f);
        this.f501s.setColor(-26624);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f501s);
        this.f501s.setStyle(Paint.Style.FILL);
        this.f501s.setColor(0);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f501s);
        this.f501s.setStyle(Paint.Style.FILL);
        this.f501s.setStrokeWidth(0.0f);
        this.f501s.setColor(-1);
        this.f504z = this.w;
        this.A = this.f502x;
        a(canvas, "ID", this.j, -1);
        a(canvas, "D", b("%dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height())), -1);
        int i3 = this.k;
        int i4 = this.l;
        ScalingUtils$ScaleType scalingUtils$ScaleType = this.n;
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        if (iWidth <= 0 || iHeight <= 0 || i3 <= 0 || i4 <= 0) {
            i = -65536;
        } else {
            if (scalingUtils$ScaleType != null) {
                Rect rect = this.u;
                rect.top = 0;
                rect.left = 0;
                rect.right = iWidth;
                rect.bottom = iHeight;
                this.t.reset();
                scalingUtils$ScaleType.a(this.t, this.u, i3, i4, 0.0f, 0.0f);
                RectF rectF = this.v;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                rectF.right = i3;
                rectF.bottom = i4;
                this.t.mapRect(rectF);
                int iWidth2 = (int) this.v.width();
                int iHeight2 = (int) this.v.height();
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
        a(canvas, "I", b("%dx%d", Integer.valueOf(this.k), Integer.valueOf(this.l)), i);
        a(canvas, "I", b("%d KiB", Integer.valueOf(this.m / 1024)), -1);
        int i5 = this.p;
        if (i5 > 0) {
            i2 = -1;
            a(canvas, "anim", b("f %d, l %d", Integer.valueOf(i5), Integer.valueOf(this.q)), -1);
        } else {
            i2 = -1;
        }
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = this.n;
        if (scalingUtils$ScaleType2 != null) {
            a(canvas, "scale", String.valueOf(scalingUtils$ScaleType2), i2);
        }
        long j = this.B;
        if (j >= 0) {
            a(canvas, "t", b("%d ms", Long.valueOf(j)), -1);
        }
        String str = this.C;
        if (str != null) {
            a(canvas, "origin", str, this.D);
        }
        for (Map.Entry<String, String> entry : this.o.entrySet()) {
            a(canvas, entry.getKey(), entry.getValue(), -1);
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
        this.f501s.setTextSize(iMin);
        int i = iMin + 8;
        this.f503y = i;
        int i2 = this.r;
        if (i2 == 80) {
            this.f503y = i * (-1);
        }
        this.w = rect.left + 10;
        this.f502x = i2 == 80 ? rect.bottom - 10 : rect.top + 10 + 10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
