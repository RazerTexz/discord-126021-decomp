package b.i.a.c.d3;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.d3.n, reason: use source file name */
/* JADX INFO: compiled from: SubtitlePainter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SubtitlePainter {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;
    public final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f918b;
    public final float c;
    public final float d;
    public final float e;
    public final TextPaint f;
    public final Paint g;
    public final Paint h;

    @Nullable
    public CharSequence i;

    @Nullable
    public Layout.Alignment j;

    @Nullable
    public Bitmap k;
    public float l;
    public int m;
    public int n;
    public float o;
    public int p;
    public float q;
    public float r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f919s;
    public int t;
    public int u;
    public int v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f920x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f921y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f922z;

    public SubtitlePainter(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.a = fRound;
        this.f918b = fRound;
        this.c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public final void a(Canvas canvas, boolean z2) {
        if (!z2) {
            Objects.requireNonNull(this.J);
            Objects.requireNonNull(this.k);
            canvas.drawBitmap(this.k, (Rect) null, this.J, this.h);
            return;
        }
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.u) > 0) {
            this.g.setColor(this.u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.g);
        }
        int i = this.w;
        if (i == 1) {
            this.f.setStrokeJoin(Paint.Join.ROUND);
            this.f.setStrokeWidth(this.a);
            this.f.setColor(this.v);
            this.f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i == 2) {
            TextPaint textPaint = this.f;
            float f = this.f918b;
            float f2 = this.c;
            textPaint.setShadowLayer(f, f2, f2, this.v);
        } else if (i == 3 || i == 4) {
            boolean z3 = i == 3;
            int i2 = z3 ? -1 : this.v;
            int i3 = z3 ? this.v : -1;
            float f3 = this.f918b / 2.0f;
            this.f.setColor(this.f919s);
            this.f.setStyle(Paint.Style.FILL);
            float f4 = -f3;
            this.f.setShadowLayer(this.f918b, f4, f4, i2);
            staticLayout2.draw(canvas);
            this.f.setShadowLayer(this.f918b, f3, f3, i3);
        }
        this.f.setColor(this.f919s);
        this.f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }
}
