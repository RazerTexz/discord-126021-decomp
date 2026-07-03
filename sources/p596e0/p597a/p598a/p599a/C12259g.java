package p596e0.p597a.p598a.p599a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import me.dm7.barcodescanner.core.C12923R;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: e0.a.a.a.g */
/* JADX INFO: compiled from: ViewFinderView.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12259g extends View implements InterfaceC12258f {

    /* JADX INFO: renamed from: j */
    public static final int[] f25335j = {0, 64, 128, Opcodes.CHECKCAST, 255, Opcodes.CHECKCAST, 128, 64};

    /* JADX INFO: renamed from: k */
    public Rect f25336k;

    /* JADX INFO: renamed from: l */
    public int f25337l;

    /* JADX INFO: renamed from: m */
    public final int f25338m;

    /* JADX INFO: renamed from: n */
    public final int f25339n;

    /* JADX INFO: renamed from: o */
    public final int f25340o;

    /* JADX INFO: renamed from: p */
    public final int f25341p;

    /* JADX INFO: renamed from: q */
    public final int f25342q;

    /* JADX INFO: renamed from: r */
    public Paint f25343r;

    /* JADX INFO: renamed from: s */
    public Paint f25344s;

    /* JADX INFO: renamed from: t */
    public Paint f25345t;

    /* JADX INFO: renamed from: u */
    public int f25346u;

    /* JADX INFO: renamed from: v */
    public boolean f25347v;

    /* JADX INFO: renamed from: w */
    public boolean f25348w;

    /* JADX INFO: renamed from: x */
    public int f25349x;

    public C12259g(Context context) {
        super(context);
        int color = getResources().getColor(C12923R.a.viewfinder_laser);
        this.f25338m = color;
        int color2 = getResources().getColor(C12923R.a.viewfinder_mask);
        this.f25339n = color2;
        int color3 = getResources().getColor(C12923R.a.viewfinder_border);
        this.f25340o = color3;
        int integer = getResources().getInteger(C12923R.b.viewfinder_border_width);
        this.f25341p = integer;
        int integer2 = getResources().getInteger(C12923R.b.viewfinder_border_length);
        this.f25342q = integer2;
        this.f25349x = 0;
        Paint paint = new Paint();
        this.f25343r = paint;
        paint.setColor(color);
        this.f25343r.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f25344s = paint2;
        paint2.setColor(color2);
        Paint paint3 = new Paint();
        this.f25345t = paint3;
        paint3.setColor(color3);
        this.f25345t.setStyle(Paint.Style.STROKE);
        this.f25345t.setStrokeWidth(integer);
        this.f25345t.setAntiAlias(true);
        this.f25346u = integer2;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m10100a() {
        int width;
        int height;
        Point point = new Point(getWidth(), getHeight());
        int iM4332q0 = C3404f.m4332q0(getContext());
        if (this.f25347v) {
            width = (int) ((iM4332q0 != 1 ? getHeight() : getWidth()) * 0.625f);
            height = width;
        } else if (iM4332q0 != 1) {
            int height2 = (int) (getHeight() * 0.625f);
            height = height2;
            width = (int) (height2 * 1.4f);
        } else {
            width = (int) (getWidth() * 0.75f);
            height = (int) (width * 0.75f);
        }
        if (width > getWidth()) {
            width = getWidth() - 50;
        }
        if (height > getHeight()) {
            height = getHeight() - 50;
        }
        int i = (point.x - width) / 2;
        int i2 = (point.y - height) / 2;
        int i3 = this.f25349x;
        this.f25336k = new Rect(i + i3, i2 + i3, (i + width) - i3, (i2 + height) - i3);
    }

    public Rect getFramingRect() {
        return this.f25336k;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (getFramingRect() == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Rect framingRect = getFramingRect();
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, framingRect.top, this.f25344s);
        canvas.drawRect(0.0f, framingRect.top, framingRect.left, framingRect.bottom + 1, this.f25344s);
        canvas.drawRect(framingRect.right + 1, framingRect.top, f, framingRect.bottom + 1, this.f25344s);
        canvas.drawRect(0.0f, framingRect.bottom + 1, f, height, this.f25344s);
        Rect framingRect2 = getFramingRect();
        Path path = new Path();
        path.moveTo(framingRect2.left, framingRect2.top + this.f25346u);
        path.lineTo(framingRect2.left, framingRect2.top);
        path.lineTo(framingRect2.left + this.f25346u, framingRect2.top);
        canvas.drawPath(path, this.f25345t);
        path.moveTo(framingRect2.right, framingRect2.top + this.f25346u);
        path.lineTo(framingRect2.right, framingRect2.top);
        path.lineTo(framingRect2.right - this.f25346u, framingRect2.top);
        canvas.drawPath(path, this.f25345t);
        path.moveTo(framingRect2.right, framingRect2.bottom - this.f25346u);
        path.lineTo(framingRect2.right, framingRect2.bottom);
        path.lineTo(framingRect2.right - this.f25346u, framingRect2.bottom);
        canvas.drawPath(path, this.f25345t);
        path.moveTo(framingRect2.left, framingRect2.bottom - this.f25346u);
        path.lineTo(framingRect2.left, framingRect2.bottom);
        path.lineTo(framingRect2.left + this.f25346u, framingRect2.bottom);
        canvas.drawPath(path, this.f25345t);
        if (this.f25348w) {
            Rect framingRect3 = getFramingRect();
            Paint paint = this.f25343r;
            int[] iArr = f25335j;
            paint.setAlpha(iArr[this.f25337l]);
            this.f25337l = (this.f25337l + 1) % iArr.length;
            int iHeight = (framingRect3.height() / 2) + framingRect3.top;
            canvas.drawRect(framingRect3.left + 2, iHeight - 1, framingRect3.right - 1, iHeight + 2, this.f25343r);
            postInvalidateDelayed(80L, framingRect3.left - 10, framingRect3.top - 10, framingRect3.right + 10, framingRect3.bottom + 10);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m10100a();
    }

    public void setBorderAlpha(float f) {
        this.f25345t.setAlpha((int) (f * 255.0f));
    }

    public void setBorderColor(int i) {
        this.f25345t.setColor(i);
    }

    public void setBorderCornerRadius(int i) {
        this.f25345t.setPathEffect(new CornerPathEffect(i));
    }

    public void setBorderCornerRounded(boolean z2) {
        if (z2) {
            this.f25345t.setStrokeJoin(Paint.Join.ROUND);
        } else {
            this.f25345t.setStrokeJoin(Paint.Join.BEVEL);
        }
    }

    public void setBorderLineLength(int i) {
        this.f25346u = i;
    }

    public void setBorderStrokeWidth(int i) {
        this.f25345t.setStrokeWidth(i);
    }

    public void setLaserColor(int i) {
        this.f25343r.setColor(i);
    }

    public void setLaserEnabled(boolean z2) {
        this.f25348w = z2;
    }

    public void setMaskColor(int i) {
        this.f25344s.setColor(i);
    }

    public void setSquareViewFinder(boolean z2) {
        this.f25347v = z2;
    }

    public void setViewFinderOffset(int i) {
        this.f25349x = i;
    }
}
