package androidx.vectordrawable.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.Path;
import android.graphics.Path$FillType;
import android.graphics.PathMeasure;
import android.graphics.Shader;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;

/* JADX INFO: loaded from: classes.dex */
public class VectorDrawableCompat$VPathRenderer {
    private static final Matrix IDENTITY_MATRIX = new Matrix();
    public float mBaseHeight;
    public float mBaseWidth;
    private int mChangingConfigurations;
    public Paint mFillPaint;
    private final Matrix mFinalPathMatrix;
    public Boolean mIsStateful;
    private final Path mPath;
    private PathMeasure mPathMeasure;
    private final Path mRenderPath;
    public int mRootAlpha;
    public final VectorDrawableCompat$VGroup mRootGroup;
    public String mRootName;
    public Paint mStrokePaint;
    public final ArrayMap<String, Object> mVGTargetsMap;
    public float mViewportHeight;
    public float mViewportWidth;

    public VectorDrawableCompat$VPathRenderer() {
        this.mFinalPathMatrix = new Matrix();
        this.mBaseWidth = 0.0f;
        this.mBaseHeight = 0.0f;
        this.mViewportWidth = 0.0f;
        this.mViewportHeight = 0.0f;
        this.mRootAlpha = 255;
        this.mRootName = null;
        this.mIsStateful = null;
        this.mVGTargetsMap = new ArrayMap<>();
        this.mRootGroup = new VectorDrawableCompat$VGroup();
        this.mPath = new Path();
        this.mRenderPath = new Path();
    }

    private static float cross(float f, float f2, float f3, float f4) {
        return (f * f4) - (f2 * f3);
    }

    private void drawGroupTree(VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        vectorDrawableCompat$VGroup.mStackedMatrix.set(matrix);
        vectorDrawableCompat$VGroup.mStackedMatrix.preConcat(vectorDrawableCompat$VGroup.mLocalMatrix);
        canvas.save();
        for (int i3 = 0; i3 < vectorDrawableCompat$VGroup.mChildren.size(); i3++) {
            VectorDrawableCompat$VObject vectorDrawableCompat$VObject = vectorDrawableCompat$VGroup.mChildren.get(i3);
            if (vectorDrawableCompat$VObject instanceof VectorDrawableCompat$VGroup) {
                drawGroupTree((VectorDrawableCompat$VGroup) vectorDrawableCompat$VObject, vectorDrawableCompat$VGroup.mStackedMatrix, canvas, i, i2, colorFilter);
            } else if (vectorDrawableCompat$VObject instanceof VectorDrawableCompat$VPath) {
                drawPath(vectorDrawableCompat$VGroup, (VectorDrawableCompat$VPath) vectorDrawableCompat$VObject, canvas, i, i2, colorFilter);
            }
        }
        canvas.restore();
    }

    private void drawPath(VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup, VectorDrawableCompat$VPath vectorDrawableCompat$VPath, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        float f = i / this.mViewportWidth;
        float f2 = i2 / this.mViewportHeight;
        float fMin = Math.min(f, f2);
        Matrix matrix = vectorDrawableCompat$VGroup.mStackedMatrix;
        this.mFinalPathMatrix.set(matrix);
        this.mFinalPathMatrix.postScale(f, f2);
        float matrixScale = getMatrixScale(matrix);
        if (matrixScale == 0.0f) {
            return;
        }
        vectorDrawableCompat$VPath.toPath(this.mPath);
        Path path = this.mPath;
        this.mRenderPath.reset();
        if (vectorDrawableCompat$VPath.isClipPath()) {
            this.mRenderPath.setFillType(vectorDrawableCompat$VPath.mFillRule == 0 ? Path$FillType.WINDING : Path$FillType.EVEN_ODD);
            this.mRenderPath.addPath(path, this.mFinalPathMatrix);
            canvas.clipPath(this.mRenderPath);
            return;
        }
        VectorDrawableCompat$VFullPath vectorDrawableCompat$VFullPath = (VectorDrawableCompat$VFullPath) vectorDrawableCompat$VPath;
        float f3 = vectorDrawableCompat$VFullPath.mTrimPathStart;
        if (f3 != 0.0f || vectorDrawableCompat$VFullPath.mTrimPathEnd != 1.0f) {
            float f4 = vectorDrawableCompat$VFullPath.mTrimPathOffset;
            float f5 = (f3 + f4) % 1.0f;
            float f6 = (vectorDrawableCompat$VFullPath.mTrimPathEnd + f4) % 1.0f;
            if (this.mPathMeasure == null) {
                this.mPathMeasure = new PathMeasure();
            }
            this.mPathMeasure.setPath(this.mPath, false);
            float length = this.mPathMeasure.getLength();
            float f7 = f5 * length;
            float f8 = f6 * length;
            path.reset();
            if (f7 > f8) {
                this.mPathMeasure.getSegment(f7, length, path, true);
                this.mPathMeasure.getSegment(0.0f, f8, path, true);
            } else {
                this.mPathMeasure.getSegment(f7, f8, path, true);
            }
            path.rLineTo(0.0f, 0.0f);
        }
        this.mRenderPath.addPath(path, this.mFinalPathMatrix);
        if (vectorDrawableCompat$VFullPath.mFillColor.willDraw()) {
            ComplexColorCompat complexColorCompat = vectorDrawableCompat$VFullPath.mFillColor;
            if (this.mFillPaint == null) {
                Paint paint = new Paint(1);
                this.mFillPaint = paint;
                paint.setStyle(Paint$Style.FILL);
            }
            Paint paint2 = this.mFillPaint;
            if (complexColorCompat.isGradient()) {
                Shader shader = complexColorCompat.getShader();
                shader.setLocalMatrix(this.mFinalPathMatrix);
                paint2.setShader(shader);
                paint2.setAlpha(Math.round(vectorDrawableCompat$VFullPath.mFillAlpha * 255.0f));
            } else {
                paint2.setShader(null);
                paint2.setAlpha(255);
                paint2.setColor(VectorDrawableCompat.applyAlpha(complexColorCompat.getColor(), vectorDrawableCompat$VFullPath.mFillAlpha));
            }
            paint2.setColorFilter(colorFilter);
            this.mRenderPath.setFillType(vectorDrawableCompat$VFullPath.mFillRule == 0 ? Path$FillType.WINDING : Path$FillType.EVEN_ODD);
            canvas.drawPath(this.mRenderPath, paint2);
        }
        if (vectorDrawableCompat$VFullPath.mStrokeColor.willDraw()) {
            ComplexColorCompat complexColorCompat2 = vectorDrawableCompat$VFullPath.mStrokeColor;
            if (this.mStrokePaint == null) {
                Paint paint3 = new Paint(1);
                this.mStrokePaint = paint3;
                paint3.setStyle(Paint$Style.STROKE);
            }
            Paint paint4 = this.mStrokePaint;
            Paint$Join paint$Join = vectorDrawableCompat$VFullPath.mStrokeLineJoin;
            if (paint$Join != null) {
                paint4.setStrokeJoin(paint$Join);
            }
            Paint$Cap paint$Cap = vectorDrawableCompat$VFullPath.mStrokeLineCap;
            if (paint$Cap != null) {
                paint4.setStrokeCap(paint$Cap);
            }
            paint4.setStrokeMiter(vectorDrawableCompat$VFullPath.mStrokeMiterlimit);
            if (complexColorCompat2.isGradient()) {
                Shader shader2 = complexColorCompat2.getShader();
                shader2.setLocalMatrix(this.mFinalPathMatrix);
                paint4.setShader(shader2);
                paint4.setAlpha(Math.round(vectorDrawableCompat$VFullPath.mStrokeAlpha * 255.0f));
            } else {
                paint4.setShader(null);
                paint4.setAlpha(255);
                paint4.setColor(VectorDrawableCompat.applyAlpha(complexColorCompat2.getColor(), vectorDrawableCompat$VFullPath.mStrokeAlpha));
            }
            paint4.setColorFilter(colorFilter);
            paint4.setStrokeWidth(vectorDrawableCompat$VFullPath.mStrokeWidth * fMin * matrixScale);
            canvas.drawPath(this.mRenderPath, paint4);
        }
    }

    private float getMatrixScale(Matrix matrix) {
        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
        float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
        float fCross = cross(fArr[0], fArr[1], fArr[2], fArr[3]);
        float fMax = Math.max(fHypot, fHypot2);
        if (fMax > 0.0f) {
            return Math.abs(fCross) / fMax;
        }
        return 0.0f;
    }

    public void draw(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, canvas, i, i2, colorFilter);
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.mRootAlpha;
    }

    public boolean isStateful() {
        if (this.mIsStateful == null) {
            this.mIsStateful = Boolean.valueOf(this.mRootGroup.isStateful());
        }
        return this.mIsStateful.booleanValue();
    }

    public boolean onStateChanged(int[] iArr) {
        return this.mRootGroup.onStateChanged(iArr);
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.mRootAlpha = i;
    }

    public VectorDrawableCompat$VPathRenderer(VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer) {
        this.mFinalPathMatrix = new Matrix();
        this.mBaseWidth = 0.0f;
        this.mBaseHeight = 0.0f;
        this.mViewportWidth = 0.0f;
        this.mViewportHeight = 0.0f;
        this.mRootAlpha = 255;
        this.mRootName = null;
        this.mIsStateful = null;
        ArrayMap<String, Object> arrayMap = new ArrayMap<>();
        this.mVGTargetsMap = arrayMap;
        this.mRootGroup = new VectorDrawableCompat$VGroup(vectorDrawableCompat$VPathRenderer.mRootGroup, arrayMap);
        this.mPath = new Path(vectorDrawableCompat$VPathRenderer.mPath);
        this.mRenderPath = new Path(vectorDrawableCompat$VPathRenderer.mRenderPath);
        this.mBaseWidth = vectorDrawableCompat$VPathRenderer.mBaseWidth;
        this.mBaseHeight = vectorDrawableCompat$VPathRenderer.mBaseHeight;
        this.mViewportWidth = vectorDrawableCompat$VPathRenderer.mViewportWidth;
        this.mViewportHeight = vectorDrawableCompat$VPathRenderer.mViewportHeight;
        this.mChangingConfigurations = vectorDrawableCompat$VPathRenderer.mChangingConfigurations;
        this.mRootAlpha = vectorDrawableCompat$VPathRenderer.mRootAlpha;
        this.mRootName = vectorDrawableCompat$VPathRenderer.mRootName;
        String str = vectorDrawableCompat$VPathRenderer.mRootName;
        if (str != null) {
            arrayMap.put(str, this);
        }
        this.mIsStateful = vectorDrawableCompat$VPathRenderer.mIsStateful;
    }
}
