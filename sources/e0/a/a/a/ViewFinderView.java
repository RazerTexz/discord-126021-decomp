package e0.a.a.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import me.dm7.barcodescanner.core.R;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: e0.a.a.a.g, reason: use source file name */
/* JADX INFO: compiled from: ViewFinderView.java */
/* JADX INFO: loaded from: classes3.dex */
public class ViewFinderView extends View implements IViewFinder {
    public static final int[] j = {0, 64, 128, Opcodes.CHECKCAST, 255, Opcodes.CHECKCAST, 128, 64};
    public Rect k;
    public int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public Paint r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Paint f3599s;
    public Paint t;
    public int u;
    public boolean v;
    public boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3600x;

    public ViewFinderView(Context context) {
        super(context);
        int color = getResources().getColor(R.a.viewfinder_laser);
        this.m = color;
        int color2 = getResources().getColor(R.a.viewfinder_mask);
        this.n = color2;
        int color3 = getResources().getColor(R.a.viewfinder_border);
        this.o = color3;
        int integer = getResources().getInteger(R.b.viewfinder_border_width);
        this.p = integer;
        int integer2 = getResources().getInteger(R.b.viewfinder_border_length);
        this.q = integer2;
        this.f3600x = 0;
        Paint paint = new Paint();
        this.r = paint;
        paint.setColor(color);
        this.r.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f3599s = paint2;
        paint2.setColor(color2);
        Paint paint3 = new Paint();
        this.t = paint3;
        paint3.setColor(color3);
        this.t.setStyle(Paint.Style.STROKE);
        this.t.setStrokeWidth(integer);
        this.t.setAntiAlias(true);
        this.u = integer2;
    }

    public synchronized void a() {
        int width;
        int height;
        Point point = new Point(getWidth(), getHeight());
        int iQ0 = b.i.a.f.e.o.f.q0(getContext());
        if (this.v) {
            width = (int) ((iQ0 != 1 ? getHeight() : getWidth()) * 0.625f);
            height = width;
        } else if (iQ0 != 1) {
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
        int i3 = this.f3600x;
        this.k = new Rect(i + i3, i2 + i3, (i + width) - i3, (i2 + height) - i3);
    }

    public Rect getFramingRect() {
        return this.k;
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
        canvas.drawRect(0.0f, 0.0f, f, framingRect.top, this.f3599s);
        canvas.drawRect(0.0f, framingRect.top, framingRect.left, framingRect.bottom + 1, this.f3599s);
        canvas.drawRect(framingRect.right + 1, framingRect.top, f, framingRect.bottom + 1, this.f3599s);
        canvas.drawRect(0.0f, framingRect.bottom + 1, f, height, this.f3599s);
        Rect framingRect2 = getFramingRect();
        Path path = new Path();
        path.moveTo(framingRect2.left, framingRect2.top + this.u);
        path.lineTo(framingRect2.left, framingRect2.top);
        path.lineTo(framingRect2.left + this.u, framingRect2.top);
        canvas.drawPath(path, this.t);
        path.moveTo(framingRect2.right, framingRect2.top + this.u);
        path.lineTo(framingRect2.right, framingRect2.top);
        path.lineTo(framingRect2.right - this.u, framingRect2.top);
        canvas.drawPath(path, this.t);
        path.moveTo(framingRect2.right, framingRect2.bottom - this.u);
        path.lineTo(framingRect2.right, framingRect2.bottom);
        path.lineTo(framingRect2.right - this.u, framingRect2.bottom);
        canvas.drawPath(path, this.t);
        path.moveTo(framingRect2.left, framingRect2.bottom - this.u);
        path.lineTo(framingRect2.left, framingRect2.bottom);
        path.lineTo(framingRect2.left + this.u, framingRect2.bottom);
        canvas.drawPath(path, this.t);
        if (this.w) {
            Rect framingRect3 = getFramingRect();
            Paint paint = this.r;
            int[] iArr = j;
            paint.setAlpha(iArr[this.l]);
            this.l = (this.l + 1) % iArr.length;
            int iHeight = (framingRect3.height() / 2) + framingRect3.top;
            canvas.drawRect(framingRect3.left + 2, iHeight - 1, framingRect3.right - 1, iHeight + 2, this.r);
            postInvalidateDelayed(80L, framingRect3.left - 10, framingRect3.top - 10, framingRect3.right + 10, framingRect3.bottom + 10);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        a();
    }

    public void setBorderAlpha(float f) {
        this.t.setAlpha((int) (f * 255.0f));
    }

    public void setBorderColor(int i) {
        this.t.setColor(i);
    }

    public void setBorderCornerRadius(int i) {
        this.t.setPathEffect(new CornerPathEffect(i));
    }

    public void setBorderCornerRounded(boolean z2) {
        if (z2) {
            this.t.setStrokeJoin(Paint.Join.ROUND);
        } else {
            this.t.setStrokeJoin(Paint.Join.BEVEL);
        }
    }

    public void setBorderLineLength(int i) {
        this.u = i;
    }

    public void setBorderStrokeWidth(int i) {
        this.t.setStrokeWidth(i);
    }

    public void setLaserColor(int i) {
        this.r.setColor(i);
    }

    public void setLaserEnabled(boolean z2) {
        this.w = z2;
    }

    public void setMaskColor(int i) {
        this.f3599s.setColor(i);
    }

    public void setSquareViewFinder(boolean z2) {
        this.v = z2;
    }

    public void setViewFinderOffset(int i) {
        this.f3600x = i;
    }
}
