package com.discord.widgets.chat.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.discord.R$a;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: ViewReplySpline.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewReplySpline extends View {
    private static final int BOTTOM_TO_END = 0;
    private static final int CAP_LONG = 1;
    private static final int CAP_LONG_AND_SHORT = 0;
    public static final ViewReplySpline$Companion Companion = new ViewReplySpline$Companion(null);
    private static final int TOP_TO_END = 1;
    private final float arcPercent;
    private RectF arcRectLocal;
    private int capStyle;
    private final float endX;
    private final float endY;
    private final float halfStrokeWidth;
    private int orientation;
    private final Paint paint;
    private final Path path;
    private final RectF pathRect;
    private RectF pathRectLocal;
    private int spineEndPadding;
    private int spineStartPadding;
    private final float startX;
    private final float startY;
    private final float strokeWidth;
    private Matrix transformMatrix;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewReplySpline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.paint = paint;
        this.path = new Path();
        this.halfStrokeWidth = 3.0f;
        float f = 3.0f * 2;
        this.strokeWidth = f;
        this.arcPercent = 0.25f;
        this.startY = 1.0f;
        this.endX = 1.0f;
        this.pathRect = new RectF(this.startX, this.endY, 1.0f, 1.0f);
        this.pathRectLocal = new RectF();
        this.arcRectLocal = new RectF();
        this.transformMatrix = new Matrix();
        paint.setStyle(Paint$Style.STROKE);
        paint.setStrokeCap(Paint$Cap.ROUND);
        paint.setStrokeWidth(f);
        paint.setColor(ColorCompat.getThemedColor(this, 2130968896));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.ViewReplySpline, 0, 0);
            m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…* defStyleRes */0\n      )");
            float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
            float dimension2 = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
            this.orientation = typedArrayObtainStyledAttributes.getInteger(2, 0);
            this.capStyle = typedArrayObtainStyledAttributes.getInteger(0, 0);
            float f2 = 0;
            if (dimension > f2) {
                this.spineStartPadding = DimenUtils.dpToPixels(dimension);
            }
            if (dimension2 > f2) {
                this.spineEndPadding = DimenUtils.dpToPixels(dimension2);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void createPath() {
        this.path.reset();
        int i = this.orientation;
        if (i == 0) {
            Path path = this.path;
            RectF rectF = this.pathRectLocal;
            path.moveTo(rectF.left, rectF.bottom + getLongPathOffset());
            this.path.arcTo(this.arcRectLocal, 180.0f, 90.0f, false);
            Path path2 = this.path;
            RectF rectF2 = this.pathRectLocal;
            path2.lineTo(rectF2.right, rectF2.top);
            return;
        }
        if (i != 1) {
            return;
        }
        Path path3 = this.path;
        RectF rectF3 = this.pathRectLocal;
        path3.moveTo(rectF3.left, rectF3.top - getLongPathOffset());
        this.path.arcTo(this.arcRectLocal, 180.0f, -90.0f, false);
        Path path4 = this.path;
        RectF rectF4 = this.pathRectLocal;
        path4.lineTo(rectF4.right, rectF4.bottom);
    }

    public final int getLongPathOffset() {
        int i = this.capStyle;
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return DimenUtils.dpToPixels(1);
        }
        throw new IllegalStateException("Unknown cap style");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawPath(this.path, this.paint);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        RectF rectF;
        super.onSizeChanged(w, h, oldw, oldh);
        if (w == oldw && h == oldh) {
            return;
        }
        this.transformMatrix.reset();
        Matrix matrix = this.transformMatrix;
        float f = this.halfStrokeWidth;
        matrix.preTranslate(f, f);
        Matrix matrix2 = this.transformMatrix;
        float f2 = this.strokeWidth;
        matrix2.preScale((w - f2) - this.spineEndPadding, (h - f2) - this.spineStartPadding);
        this.transformMatrix.mapRect(this.pathRectLocal, this.pathRect);
        float f3 = this.arcPercent;
        RectF rectF2 = this.pathRectLocal;
        float f4 = (rectF2.right - rectF2.left) * f3 * 2;
        int i = this.orientation;
        if (i == 0) {
            RectF rectF3 = this.pathRectLocal;
            float f5 = rectF3.left;
            float f6 = rectF3.top;
            rectF = new RectF(f5, f6, f5 + f4, f4 + f6);
        } else {
            if (i != 1) {
                throw new IllegalStateException("Unknown orientation");
            }
            RectF rectF4 = this.pathRectLocal;
            float f7 = rectF4.left;
            float f8 = rectF4.bottom;
            rectF = new RectF(f7, f8 - f4, f4 + f7, f8);
        }
        this.arcRectLocal = rectF;
        createPath();
    }
}
