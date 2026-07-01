package b.q.a.l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.q.a.i.ExifInfo;
import b.q.a.k.FastBitmapDrawable;
import com.yalantis.ucrop.UCropActivity;

/* JADX INFO: renamed from: b.q.a.l.c, reason: use source file name */
/* JADX INFO: compiled from: TransformImageView.java */
/* JADX INFO: loaded from: classes3.dex */
public class TransformImageView2 extends AppCompatImageView {
    public final float[] j;
    public final float[] k;
    public final float[] l;
    public Matrix m;
    public int n;
    public int o;
    public a p;
    public float[] q;
    public float[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1990s;
    public boolean t;
    public int u;
    public String v;
    public String w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ExifInfo f1991x;

    /* JADX INFO: renamed from: b.q.a.l.c$a */
    /* JADX INFO: compiled from: TransformImageView.java */
    public interface a {
    }

    public TransformImageView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public float a(@NonNull Matrix matrix) {
        matrix.getValues(this.l);
        float[] fArr = this.l;
        double d = fArr[1];
        matrix.getValues(fArr);
        return (float) (-(Math.atan2(d, this.l[0]) * 57.29577951308232d));
    }

    public float b(@NonNull Matrix matrix) {
        matrix.getValues(this.l);
        double dPow = Math.pow(this.l[0], 2.0d);
        matrix.getValues(this.l);
        return (float) Math.sqrt(Math.pow(this.l[3], 2.0d) + dPow);
    }

    public void c() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void d() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        Log.d("TransformImageView", String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
        RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.q = f.f0(rectF);
        this.r = f.d0(rectF);
        this.t = true;
        a aVar = this.p;
        if (aVar != null) {
            UCropActivity.a aVar2 = (UCropActivity.a) aVar;
            UCropActivity.this.v.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.H.setClickable(false);
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.u = false;
            uCropActivity.supportInvalidateOptionsMenu();
        }
    }

    public void e(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.m.postRotate(f, f2, f3);
            setImageMatrix(this.m);
            a aVar = this.p;
            if (aVar != null) {
                ((UCropActivity.a) aVar).a(a(this.m));
            }
        }
    }

    public void f(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.m.postScale(f, f, f2, f3);
            setImageMatrix(this.m);
            a aVar = this.p;
            if (aVar != null) {
                ((UCropActivity.a) aVar).b(b(this.m));
            }
        }
    }

    public void g(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.m.postTranslate(f, f2);
        setImageMatrix(this.m);
    }

    public float getCurrentAngle() {
        return a(this.m);
    }

    public float getCurrentScale() {
        return b(this.m);
    }

    public ExifInfo getExifInfo() {
        return this.f1991x;
    }

    public String getImageInputPath() {
        return this.v;
    }

    public String getImageOutputPath() {
        return this.w;
    }

    public int getMaxBitmapSize() {
        int iM0;
        if (this.u <= 0) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            Point point = new Point();
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getSize(point);
            }
            int i = point.x;
            int iSqrt = (int) Math.sqrt(Math.pow(point.y, 2.0d) + Math.pow(i, 2.0d));
            Canvas canvas = new Canvas();
            int iMin = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
            if (iMin > 0) {
                iSqrt = Math.min(iSqrt, iMin);
            }
            try {
                iM0 = f.m0();
            } catch (Exception e) {
                Log.d("EglUtils", "getMaxTextureSize: ", e);
                iM0 = 0;
            }
            if (iM0 > 0) {
                iSqrt = Math.min(iSqrt, iM0);
            }
            outline.n0("maxBitmapSize: ", iSqrt, "BitmapLoadUtils");
            this.u = iSqrt;
        }
        return this.u;
    }

    @Nullable
    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof FastBitmapDrawable)) {
            return null;
        }
        return ((FastBitmapDrawable) getDrawable()).f1984b;
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (z2 || (this.f1990s && !this.t)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.n = width - paddingLeft;
            this.o = height - paddingTop;
            d();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new FastBitmapDrawable(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.m.set(matrix);
        this.m.mapPoints(this.j, this.q);
        this.m.mapPoints(this.k, this.r);
    }

    public void setMaxBitmapSize(int i) {
        this.u = i;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(a aVar) {
        this.p = aVar;
    }

    public TransformImageView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new float[8];
        this.k = new float[2];
        this.l = new float[9];
        this.m = new Matrix();
        this.f1990s = false;
        this.t = false;
        this.u = 0;
        c();
    }
}
