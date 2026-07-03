package p007b.p485q.p486a.p491l;

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
import com.yalantis.ucrop.UCropActivity;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p485q.p486a.p488i.C5297b;
import p007b.p485q.p486a.p490k.C5301a;

/* JADX INFO: renamed from: b.q.a.l.c */
/* JADX INFO: compiled from: TransformImageView.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5307c extends AppCompatImageView {

    /* JADX INFO: renamed from: j */
    public final float[] f14484j;

    /* JADX INFO: renamed from: k */
    public final float[] f14485k;

    /* JADX INFO: renamed from: l */
    public final float[] f14486l;

    /* JADX INFO: renamed from: m */
    public Matrix f14487m;

    /* JADX INFO: renamed from: n */
    public int f14488n;

    /* JADX INFO: renamed from: o */
    public int f14489o;

    /* JADX INFO: renamed from: p */
    public a f14490p;

    /* JADX INFO: renamed from: q */
    public float[] f14491q;

    /* JADX INFO: renamed from: r */
    public float[] f14492r;

    /* JADX INFO: renamed from: s */
    public boolean f14493s;

    /* JADX INFO: renamed from: t */
    public boolean f14494t;

    /* JADX INFO: renamed from: u */
    public int f14495u;

    /* JADX INFO: renamed from: v */
    public String f14496v;

    /* JADX INFO: renamed from: w */
    public String f14497w;

    /* JADX INFO: renamed from: x */
    public C5297b f14498x;

    /* JADX INFO: renamed from: b.q.a.l.c$a */
    /* JADX INFO: compiled from: TransformImageView.java */
    public interface a {
    }

    public C5307c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: renamed from: a */
    public float m7484a(@NonNull Matrix matrix) {
        matrix.getValues(this.f14486l);
        float[] fArr = this.f14486l;
        double d = fArr[1];
        matrix.getValues(fArr);
        return (float) (-(Math.atan2(d, this.f14486l[0]) * 57.29577951308232d));
    }

    /* JADX INFO: renamed from: b */
    public float m7485b(@NonNull Matrix matrix) {
        matrix.getValues(this.f14486l);
        double dPow = Math.pow(this.f14486l[0], 2.0d);
        matrix.getValues(this.f14486l);
        return (float) Math.sqrt(Math.pow(this.f14486l[3], 2.0d) + dPow);
    }

    /* JADX INFO: renamed from: c */
    public void mo7486c() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* JADX INFO: renamed from: d */
    public void mo7477d() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        Log.d("TransformImageView", String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
        RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.f14491q = C3404f.m4288f0(rectF);
        this.f14492r = C3404f.m4280d0(rectF);
        this.f14494t = true;
        a aVar = this.f14490p;
        if (aVar != null) {
            UCropActivity.C11200a c11200a = (UCropActivity.C11200a) aVar;
            UCropActivity.this.f22193v.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.f22175H.setClickable(false);
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.f22192u = false;
            uCropActivity.supportInvalidateOptionsMenu();
        }
    }

    /* JADX INFO: renamed from: e */
    public void m7487e(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.f14487m.postRotate(f, f2, f3);
            setImageMatrix(this.f14487m);
            a aVar = this.f14490p;
            if (aVar != null) {
                ((UCropActivity.C11200a) aVar).m9322a(m7484a(this.f14487m));
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public void mo7478f(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.f14487m.postScale(f, f, f2, f3);
            setImageMatrix(this.f14487m);
            a aVar = this.f14490p;
            if (aVar != null) {
                ((UCropActivity.C11200a) aVar).m9323b(m7485b(this.f14487m));
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public void m7488g(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.f14487m.postTranslate(f, f2);
        setImageMatrix(this.f14487m);
    }

    public float getCurrentAngle() {
        return m7484a(this.f14487m);
    }

    public float getCurrentScale() {
        return m7485b(this.f14487m);
    }

    public C5297b getExifInfo() {
        return this.f14498x;
    }

    public String getImageInputPath() {
        return this.f14496v;
    }

    public String getImageOutputPath() {
        return this.f14497w;
    }

    public int getMaxBitmapSize() {
        int iM4316m0;
        if (this.f14495u <= 0) {
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
                iM4316m0 = C3404f.m4316m0();
            } catch (Exception e) {
                Log.d("EglUtils", "getMaxTextureSize: ", e);
                iM4316m0 = 0;
            }
            if (iM4316m0 > 0) {
                iSqrt = Math.min(iSqrt, iM4316m0);
            }
            C1643a.m866n0("maxBitmapSize: ", iSqrt, "BitmapLoadUtils");
            this.f14495u = iSqrt;
        }
        return this.f14495u;
    }

    @Nullable
    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof C5301a)) {
            return null;
        }
        return ((C5301a) getDrawable()).f14436b;
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (z2 || (this.f14493s && !this.f14494t)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.f14488n = width - paddingLeft;
            this.f14489o = height - paddingTop;
            mo7477d();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new C5301a(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f14487m.set(matrix);
        this.f14487m.mapPoints(this.f14484j, this.f14491q);
        this.f14487m.mapPoints(this.f14485k, this.f14492r);
    }

    public void setMaxBitmapSize(int i) {
        this.f14495u = i;
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
        this.f14490p = aVar;
    }

    public C5307c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14484j = new float[8];
        this.f14485k = new float[2];
        this.f14486l = new float[9];
        this.f14487m = new Matrix();
        this.f14493s = false;
        this.f14494t = false;
        this.f14495u = 0;
        mo7486c();
    }
}
