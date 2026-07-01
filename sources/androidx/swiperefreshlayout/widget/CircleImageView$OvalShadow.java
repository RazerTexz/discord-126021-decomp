package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.shapes.OvalShape;

/* JADX INFO: loaded from: classes.dex */
public class CircleImageView$OvalShadow extends OvalShape {
    private CircleImageView mCircleImageView;
    private Paint mShadowPaint = new Paint();
    private int mShadowRadius;

    public CircleImageView$OvalShadow(CircleImageView circleImageView, int i) {
        this.mCircleImageView = circleImageView;
        this.mShadowRadius = i;
        updateRadialGradient((int) rect().width());
    }

    private void updateRadialGradient(int i) {
        float f = i / 2;
        this.mShadowPaint.setShader(new RadialGradient(f, f, this.mShadowRadius, new int[]{1023410176, 0}, (float[]) null, Shader$TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        int width = this.mCircleImageView.getWidth() / 2;
        float f = width;
        float height = this.mCircleImageView.getHeight() / 2;
        canvas.drawCircle(f, height, f, this.mShadowPaint);
        canvas.drawCircle(f, height, width - this.mShadowRadius, paint);
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void onResize(float f, float f2) {
        super.onResize(f, f2);
        updateRadialGradient((int) f);
    }
}
