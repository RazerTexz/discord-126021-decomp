package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import b.d.b.a.a;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout$DevModeDraw {
    private static final int DEBUG_PATH_TICKS_PER_MS = 16;
    public DashPathEffect mDashPathEffect;
    public Paint mFillPaint;
    public int mKeyFrameCount;
    public float[] mKeyFramePoints;
    public Paint mPaint;
    public Paint mPaintGraph;
    public Paint mPaintKeyframes;
    public Path mPath;
    public int[] mPathMode;
    public float[] mPoints;
    private float[] mRectangle;
    public int mShadowTranslate;
    public Paint mTextPaint;
    public final /* synthetic */ MotionLayout this$0;
    public final int RED_COLOR = -21965;
    public final int KEYFRAME_COLOR = -2067046;
    public final int GRAPH_COLOR = -13391360;
    public final int SHADOW_COLOR = 1996488704;
    public final int DIAMOND_SIZE = 10;
    public Rect mBounds = new Rect();
    public boolean mPresentationMode = false;

    public MotionLayout$DevModeDraw(MotionLayout motionLayout) {
        this.this$0 = motionLayout;
        this.mShadowTranslate = 1;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-21965);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setStyle(Paint$Style.STROKE);
        Paint paint2 = new Paint();
        this.mPaintKeyframes = paint2;
        paint2.setAntiAlias(true);
        this.mPaintKeyframes.setColor(-2067046);
        this.mPaintKeyframes.setStrokeWidth(2.0f);
        this.mPaintKeyframes.setStyle(Paint$Style.STROKE);
        Paint paint3 = new Paint();
        this.mPaintGraph = paint3;
        paint3.setAntiAlias(true);
        this.mPaintGraph.setColor(-13391360);
        this.mPaintGraph.setStrokeWidth(2.0f);
        this.mPaintGraph.setStyle(Paint$Style.STROKE);
        Paint paint4 = new Paint();
        this.mTextPaint = paint4;
        paint4.setAntiAlias(true);
        this.mTextPaint.setColor(-13391360);
        this.mTextPaint.setTextSize(motionLayout.getContext().getResources().getDisplayMetrics().density * 12.0f);
        this.mRectangle = new float[8];
        Paint paint5 = new Paint();
        this.mFillPaint = paint5;
        paint5.setAntiAlias(true);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.mDashPathEffect = dashPathEffect;
        this.mPaintGraph.setPathEffect(dashPathEffect);
        this.mKeyFramePoints = new float[100];
        this.mPathMode = new int[50];
        if (this.mPresentationMode) {
            this.mPaint.setStrokeWidth(8.0f);
            this.mFillPaint.setStrokeWidth(8.0f);
            this.mPaintKeyframes.setStrokeWidth(8.0f);
            this.mShadowTranslate = 4;
        }
    }

    private void drawBasicPath(Canvas canvas) {
        canvas.drawLines(this.mPoints, this.mPaint);
    }

    private void drawPathAsConfigured(Canvas canvas) {
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < this.mKeyFrameCount; i++) {
            int[] iArr = this.mPathMode;
            if (iArr[i] == 1) {
                z2 = true;
            }
            if (iArr[i] == 2) {
                z3 = true;
            }
        }
        if (z2) {
            drawPathRelative(canvas);
        }
        if (z3) {
            drawPathCartesian(canvas);
        }
    }

    private void drawPathCartesian(Canvas canvas) {
        float[] fArr = this.mPoints;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[fArr.length - 2];
        float f4 = fArr[fArr.length - 1];
        canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.mPaintGraph);
        canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.mPaintGraph);
    }

    private void drawPathCartesianTicks(Canvas canvas, float f, float f2) {
        float[] fArr = this.mPoints;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[fArr.length - 2];
        float f6 = fArr[fArr.length - 1];
        float fMin = Math.min(f3, f5);
        float fMax = Math.max(f4, f6);
        float fMin2 = f - Math.min(f3, f5);
        float fMax2 = Math.max(f4, f6) - f2;
        StringBuilder sbU = a.U("");
        sbU.append(((int) (((double) ((fMin2 * 100.0f) / Math.abs(f5 - f3))) + 0.5d)) / 100.0f);
        String string = sbU.toString();
        getTextBounds(string, this.mTextPaint);
        canvas.drawText(string, ((fMin2 / 2.0f) - (this.mBounds.width() / 2)) + fMin, f2 - 20.0f, this.mTextPaint);
        canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.mPaintGraph);
        StringBuilder sbU2 = a.U("");
        sbU2.append(((int) (((double) ((fMax2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d)) / 100.0f);
        String string2 = sbU2.toString();
        getTextBounds(string2, this.mTextPaint);
        canvas.drawText(string2, f + 5.0f, fMax - ((fMax2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
        canvas.drawLine(f, f2, f, Math.max(f4, f6), this.mPaintGraph);
    }

    private void drawPathRelative(Canvas canvas) {
        float[] fArr = this.mPoints;
        canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
    }

    private void drawPathRelativeTicks(Canvas canvas, float f, float f2) {
        float[] fArr = this.mPoints;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[fArr.length - 2];
        float f6 = fArr[fArr.length - 1];
        float fHypot = (float) Math.hypot(f3 - f5, f4 - f6);
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        float f9 = (((f2 - f4) * f8) + ((f - f3) * f7)) / (fHypot * fHypot);
        float f10 = f3 + (f7 * f9);
        float f11 = f4 + (f9 * f8);
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f10, f11);
        float fHypot2 = (float) Math.hypot(f10 - f, f11 - f2);
        StringBuilder sbU = a.U("");
        sbU.append(((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
        String string = sbU.toString();
        getTextBounds(string, this.mTextPaint);
        canvas.drawTextOnPath(string, path, (fHypot2 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
        canvas.drawLine(f, f2, f10, f11, this.mPaintGraph);
    }

    private void drawPathScreenTicks(Canvas canvas, float f, float f2, int i, int i2) {
        StringBuilder sbU = a.U("");
        sbU.append(((int) (((double) (((f - (i / 2)) * 100.0f) / (this.this$0.getWidth() - i))) + 0.5d)) / 100.0f);
        String string = sbU.toString();
        getTextBounds(string, this.mTextPaint);
        canvas.drawText(string, ((f / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, f2 - 20.0f, this.mTextPaint);
        canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.mPaintGraph);
        StringBuilder sbU2 = a.U("");
        sbU2.append(((int) (((double) (((f2 - (i2 / 2)) * 100.0f) / (this.this$0.getHeight() - i2))) + 0.5d)) / 100.0f);
        String string2 = sbU2.toString();
        getTextBounds(string2, this.mTextPaint);
        canvas.drawText(string2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
        canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.mPaintGraph);
    }

    private void drawRectangle(Canvas canvas, MotionController motionController) {
        this.mPath.reset();
        for (int i = 0; i <= 50; i++) {
            motionController.buildRect(i / 50, this.mRectangle, 0);
            Path path = this.mPath;
            float[] fArr = this.mRectangle;
            path.moveTo(fArr[0], fArr[1]);
            Path path2 = this.mPath;
            float[] fArr2 = this.mRectangle;
            path2.lineTo(fArr2[2], fArr2[3]);
            Path path3 = this.mPath;
            float[] fArr3 = this.mRectangle;
            path3.lineTo(fArr3[4], fArr3[5]);
            Path path4 = this.mPath;
            float[] fArr4 = this.mRectangle;
            path4.lineTo(fArr4[6], fArr4[7]);
            this.mPath.close();
        }
        this.mPaint.setColor(1140850688);
        canvas.translate(2.0f, 2.0f);
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.translate(-2.0f, -2.0f);
        this.mPaint.setColor(-65536);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void drawTicks(Canvas canvas, int i, int i2, MotionController motionController) {
        int width;
        int height;
        int i3;
        View view = motionController.mView;
        if (view != null) {
            width = view.getWidth();
            height = motionController.mView.getHeight();
        } else {
            width = 0;
            height = 0;
        }
        for (int i4 = 1; i4 < i2 - 1; i4++) {
            if (i != 4 || this.mPathMode[i4 - 1] != 0) {
                float[] fArr = this.mKeyFramePoints;
                int i5 = i4 * 2;
                float f = fArr[i5];
                float f2 = fArr[i5 + 1];
                this.mPath.reset();
                this.mPath.moveTo(f, f2 + 10.0f);
                this.mPath.lineTo(f + 10.0f, f2);
                this.mPath.lineTo(f, f2 - 10.0f);
                this.mPath.lineTo(f - 10.0f, f2);
                this.mPath.close();
                int i6 = i4 - 1;
                motionController.getKeyFrame(i6);
                if (i == 4) {
                    int[] iArr = this.mPathMode;
                    if (iArr[i6] == 1) {
                        drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                    } else if (iArr[i6] == 2) {
                        drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                    } else {
                        if (iArr[i6] == 3) {
                            i3 = 3;
                            drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, width, height);
                        }
                        canvas.drawPath(this.mPath, this.mFillPaint);
                    }
                    i3 = 3;
                    canvas.drawPath(this.mPath, this.mFillPaint);
                } else {
                    f2 = f2;
                    f = f;
                    i3 = 3;
                }
                if (i == 2) {
                    drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                }
                if (i == i3) {
                    drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                }
                if (i == 6) {
                    drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, width, height);
                }
                canvas.drawPath(this.mPath, this.mFillPaint);
            }
        }
        float[] fArr2 = this.mPoints;
        if (fArr2.length > 1) {
            canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
            float[] fArr3 = this.mPoints;
            canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
        }
    }

    private void drawTranslation(Canvas canvas, float f, float f2, float f3, float f4) {
        canvas.drawRect(f, f2, f3, f4, this.mPaintGraph);
        canvas.drawLine(f, f2, f3, f4, this.mPaintGraph);
    }

    public void draw(Canvas canvas, HashMap<View, MotionController> map, int i, int i2) {
        if (map == null || map.size() == 0) {
            return;
        }
        canvas.save();
        if (!this.this$0.isInEditMode() && (i2 & 1) == 2) {
            String str = this.this$0.getContext().getResources().getResourceName(MotionLayout.access$000(this.this$0)) + ":" + this.this$0.getProgress();
            canvas.drawText(str, 10.0f, this.this$0.getHeight() - 30, this.mTextPaint);
            canvas.drawText(str, 11.0f, this.this$0.getHeight() - 29, this.mPaint);
        }
        for (MotionController motionController : map.values()) {
            int drawPath = motionController.getDrawPath();
            if (i2 > 0 && drawPath == 0) {
                drawPath = 1;
            }
            if (drawPath != 0) {
                this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                if (drawPath >= 1) {
                    int i3 = i / 16;
                    float[] fArr = this.mPoints;
                    if (fArr == null || fArr.length != i3 * 2) {
                        this.mPoints = new float[i3 * 2];
                        this.mPath = new Path();
                    }
                    int i4 = this.mShadowTranslate;
                    canvas.translate(i4, i4);
                    this.mPaint.setColor(1996488704);
                    this.mFillPaint.setColor(1996488704);
                    this.mPaintKeyframes.setColor(1996488704);
                    this.mPaintGraph.setColor(1996488704);
                    motionController.buildPath(this.mPoints, i3);
                    drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                    this.mPaint.setColor(-21965);
                    this.mPaintKeyframes.setColor(-2067046);
                    this.mFillPaint.setColor(-2067046);
                    this.mPaintGraph.setColor(-13391360);
                    int i5 = this.mShadowTranslate;
                    canvas.translate(-i5, -i5);
                    drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                    if (drawPath == 5) {
                        drawRectangle(canvas, motionController);
                    }
                }
            }
        }
        canvas.restore();
    }

    public void drawAll(Canvas canvas, int i, int i2, MotionController motionController) {
        if (i == 4) {
            drawPathAsConfigured(canvas);
        }
        if (i == 2) {
            drawPathRelative(canvas);
        }
        if (i == 3) {
            drawPathCartesian(canvas);
        }
        drawBasicPath(canvas);
        drawTicks(canvas, i, i2, motionController);
    }

    public void getTextBounds(String str, Paint paint) {
        paint.getTextBounds(str, 0, str.length(), this.mBounds);
    }
}
