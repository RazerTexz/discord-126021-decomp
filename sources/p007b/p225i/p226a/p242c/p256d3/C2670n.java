package p007b.p225i.p226a.p242c.p256d3;

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

/* JADX INFO: renamed from: b.i.a.c.d3.n */
/* JADX INFO: compiled from: SubtitlePainter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2670n {

    /* JADX INFO: renamed from: A */
    public int f6366A;

    /* JADX INFO: renamed from: B */
    public int f6367B;

    /* JADX INFO: renamed from: C */
    public int f6368C;

    /* JADX INFO: renamed from: D */
    public int f6369D;

    /* JADX INFO: renamed from: E */
    public StaticLayout f6370E;

    /* JADX INFO: renamed from: F */
    public StaticLayout f6371F;

    /* JADX INFO: renamed from: G */
    public int f6372G;

    /* JADX INFO: renamed from: H */
    public int f6373H;

    /* JADX INFO: renamed from: I */
    public int f6374I;

    /* JADX INFO: renamed from: J */
    public Rect f6375J;

    /* JADX INFO: renamed from: a */
    public final float f6376a;

    /* JADX INFO: renamed from: b */
    public final float f6377b;

    /* JADX INFO: renamed from: c */
    public final float f6378c;

    /* JADX INFO: renamed from: d */
    public final float f6379d;

    /* JADX INFO: renamed from: e */
    public final float f6380e;

    /* JADX INFO: renamed from: f */
    public final TextPaint f6381f;

    /* JADX INFO: renamed from: g */
    public final Paint f6382g;

    /* JADX INFO: renamed from: h */
    public final Paint f6383h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public CharSequence f6384i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public Layout.Alignment f6385j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public Bitmap f6386k;

    /* JADX INFO: renamed from: l */
    public float f6387l;

    /* JADX INFO: renamed from: m */
    public int f6388m;

    /* JADX INFO: renamed from: n */
    public int f6389n;

    /* JADX INFO: renamed from: o */
    public float f6390o;

    /* JADX INFO: renamed from: p */
    public int f6391p;

    /* JADX INFO: renamed from: q */
    public float f6392q;

    /* JADX INFO: renamed from: r */
    public float f6393r;

    /* JADX INFO: renamed from: s */
    public int f6394s;

    /* JADX INFO: renamed from: t */
    public int f6395t;

    /* JADX INFO: renamed from: u */
    public int f6396u;

    /* JADX INFO: renamed from: v */
    public int f6397v;

    /* JADX INFO: renamed from: w */
    public int f6398w;

    /* JADX INFO: renamed from: x */
    public float f6399x;

    /* JADX INFO: renamed from: y */
    public float f6400y;

    /* JADX INFO: renamed from: z */
    public float f6401z;

    public C2670n(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f6380e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f6379d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f6376a = fRound;
        this.f6377b = fRound;
        this.f6378c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f6381f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f6382g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f6383h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    /* JADX INFO: renamed from: a */
    public final void m2760a(Canvas canvas, boolean z2) {
        if (!z2) {
            Objects.requireNonNull(this.f6375J);
            Objects.requireNonNull(this.f6386k);
            canvas.drawBitmap(this.f6386k, (Rect) null, this.f6375J, this.f6383h);
            return;
        }
        StaticLayout staticLayout = this.f6370E;
        StaticLayout staticLayout2 = this.f6371F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.f6372G, this.f6373H);
        if (Color.alpha(this.f6396u) > 0) {
            this.f6382g.setColor(this.f6396u);
            canvas.drawRect(-this.f6374I, 0.0f, staticLayout.getWidth() + this.f6374I, staticLayout.getHeight(), this.f6382g);
        }
        int i = this.f6398w;
        if (i == 1) {
            this.f6381f.setStrokeJoin(Paint.Join.ROUND);
            this.f6381f.setStrokeWidth(this.f6376a);
            this.f6381f.setColor(this.f6397v);
            this.f6381f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i == 2) {
            TextPaint textPaint = this.f6381f;
            float f = this.f6377b;
            float f2 = this.f6378c;
            textPaint.setShadowLayer(f, f2, f2, this.f6397v);
        } else if (i == 3 || i == 4) {
            boolean z3 = i == 3;
            int i2 = z3 ? -1 : this.f6397v;
            int i3 = z3 ? this.f6397v : -1;
            float f3 = this.f6377b / 2.0f;
            this.f6381f.setColor(this.f6394s);
            this.f6381f.setStyle(Paint.Style.FILL);
            float f4 = -f3;
            this.f6381f.setShadowLayer(this.f6377b, f4, f4, i2);
            staticLayout2.draw(canvas);
            this.f6381f.setShadowLayer(this.f6377b, f3, f3, i3);
        }
        this.f6381f.setColor(this.f6394s);
        this.f6381f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f6381f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }
}
