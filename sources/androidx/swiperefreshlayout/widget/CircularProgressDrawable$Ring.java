package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Style;
import android.graphics.Path;
import android.graphics.Path$FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressDrawable$Ring {
    public int mAlpha;
    public Path mArrow;
    public int mArrowHeight;
    public final Paint mArrowPaint;
    public float mArrowScale;
    public int mArrowWidth;
    public final Paint mCirclePaint;
    public int mColorIndex;
    public int[] mColors;
    public int mCurrentColor;
    public float mEndTrim;
    public final Paint mPaint;
    public float mRingCenterRadius;
    public float mRotation;
    public boolean mShowArrow;
    public float mStartTrim;
    public float mStartingEndTrim;
    public float mStartingRotation;
    public float mStartingStartTrim;
    public float mStrokeWidth;
    public final RectF mTempBounds = new RectF();

    public CircularProgressDrawable$Ring() {
        Paint paint = new Paint();
        this.mPaint = paint;
        Paint paint2 = new Paint();
        this.mArrowPaint = paint2;
        Paint paint3 = new Paint();
        this.mCirclePaint = paint3;
        this.mStartTrim = 0.0f;
        this.mEndTrim = 0.0f;
        this.mRotation = 0.0f;
        this.mStrokeWidth = 5.0f;
        this.mArrowScale = 1.0f;
        this.mAlpha = 255;
        paint.setStrokeCap(Paint$Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint$Style.STROKE);
        paint2.setStyle(Paint$Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    public void draw(Canvas canvas, Rect rect) {
        RectF rectF = this.mTempBounds;
        float f = this.mRingCenterRadius;
        float fMin = (this.mStrokeWidth / 2.0f) + f;
        if (f <= 0.0f) {
            fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
        }
        rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
        float f2 = this.mStartTrim;
        float f3 = this.mRotation;
        float f4 = (f2 + f3) * 360.0f;
        float f5 = ((this.mEndTrim + f3) * 360.0f) - f4;
        this.mPaint.setColor(this.mCurrentColor);
        this.mPaint.setAlpha(this.mAlpha);
        float f6 = this.mStrokeWidth / 2.0f;
        rectF.inset(f6, f6);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.mCirclePaint);
        float f7 = -f6;
        rectF.inset(f7, f7);
        canvas.drawArc(rectF, f4, f5, false, this.mPaint);
        drawTriangle(canvas, f4, f5, rectF);
    }

    public void drawTriangle(Canvas canvas, float f, float f2, RectF rectF) {
        if (this.mShowArrow) {
            Path path = this.mArrow;
            if (path == null) {
                Path path2 = new Path();
                this.mArrow = path2;
                path2.setFillType(Path$FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f3 = (this.mArrowWidth * this.mArrowScale) / 2.0f;
            this.mArrow.moveTo(0.0f, 0.0f);
            this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
            Path path3 = this.mArrow;
            float f4 = this.mArrowWidth;
            float f5 = this.mArrowScale;
            path3.lineTo((f4 * f5) / 2.0f, this.mArrowHeight * f5);
            this.mArrow.offset((rectF.centerX() + fMin) - f3, (this.mStrokeWidth / 2.0f) + rectF.centerY());
            this.mArrow.close();
            this.mArrowPaint.setColor(this.mCurrentColor);
            this.mArrowPaint.setAlpha(this.mAlpha);
            canvas.save();
            canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
            canvas.drawPath(this.mArrow, this.mArrowPaint);
            canvas.restore();
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public float getArrowHeight() {
        return this.mArrowHeight;
    }

    public float getArrowScale() {
        return this.mArrowScale;
    }

    public float getArrowWidth() {
        return this.mArrowWidth;
    }

    public int getBackgroundColor() {
        return this.mCirclePaint.getColor();
    }

    public float getCenterRadius() {
        return this.mRingCenterRadius;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float getEndTrim() {
        return this.mEndTrim;
    }

    public int getNextColor() {
        return this.mColors[getNextColorIndex()];
    }

    public int getNextColorIndex() {
        return (this.mColorIndex + 1) % this.mColors.length;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public boolean getShowArrow() {
        return this.mShowArrow;
    }

    public float getStartTrim() {
        return this.mStartTrim;
    }

    public int getStartingColor() {
        return this.mColors[this.mColorIndex];
    }

    public float getStartingEndTrim() {
        return this.mStartingEndTrim;
    }

    public float getStartingRotation() {
        return this.mStartingRotation;
    }

    public float getStartingStartTrim() {
        return this.mStartingStartTrim;
    }

    public Paint$Cap getStrokeCap() {
        return this.mPaint.getStrokeCap();
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void goToNextColor() {
        setColorIndex(getNextColorIndex());
    }

    public void resetOriginals() {
        this.mStartingStartTrim = 0.0f;
        this.mStartingEndTrim = 0.0f;
        this.mStartingRotation = 0.0f;
        setStartTrim(0.0f);
        setEndTrim(0.0f);
        setRotation(0.0f);
    }

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setArrowDimensions(float f, float f2) {
        this.mArrowWidth = (int) f;
        this.mArrowHeight = (int) f2;
    }

    public void setArrowScale(float f) {
        if (f != this.mArrowScale) {
            this.mArrowScale = f;
        }
    }

    public void setBackgroundColor(int i) {
        this.mCirclePaint.setColor(i);
    }

    public void setCenterRadius(float f) {
        this.mRingCenterRadius = f;
    }

    public void setColor(int i) {
        this.mCurrentColor = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setColorIndex(int i) {
        this.mColorIndex = i;
        this.mCurrentColor = this.mColors[i];
    }

    public void setColors(@NonNull int[] iArr) {
        this.mColors = iArr;
        setColorIndex(0);
    }

    public void setEndTrim(float f) {
        this.mEndTrim = f;
    }

    public void setRotation(float f) {
        this.mRotation = f;
    }

    public void setShowArrow(boolean z2) {
        if (this.mShowArrow != z2) {
            this.mShowArrow = z2;
        }
    }

    public void setStartTrim(float f) {
        this.mStartTrim = f;
    }

    public void setStrokeCap(Paint$Cap paint$Cap) {
        this.mPaint.setStrokeCap(paint$Cap);
    }

    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        this.mPaint.setStrokeWidth(f);
    }

    public void storeOriginals() {
        this.mStartingStartTrim = this.mStartTrim;
        this.mStartingEndTrim = this.mEndTrim;
        this.mStartingRotation = this.mRotation;
    }
}
