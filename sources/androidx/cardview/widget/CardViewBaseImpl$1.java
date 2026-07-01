package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class CardViewBaseImpl$1 implements RoundRectDrawableWithShadow$RoundRectHelper {
    public final /* synthetic */ CardViewBaseImpl this$0;

    public CardViewBaseImpl$1(CardViewBaseImpl cardViewBaseImpl) {
        this.this$0 = cardViewBaseImpl;
    }

    @Override // androidx.cardview.widget.RoundRectDrawableWithShadow$RoundRectHelper
    public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
        float f2 = 2.0f * f;
        float fWidth = (rectF.width() - f2) - 1.0f;
        float fHeight = (rectF.height() - f2) - 1.0f;
        if (f >= 1.0f) {
            float f3 = f + 0.5f;
            float f4 = -f3;
            this.this$0.mCornerRect.set(f4, f4, f3, f3);
            int iSave = canvas.save();
            canvas.translate(rectF.left + f3, rectF.top + f3);
            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
            canvas.translate(fWidth, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
            canvas.translate(fHeight, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
            canvas.translate(fWidth, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint);
            canvas.restoreToCount(iSave);
            float f5 = (rectF.left + f3) - 1.0f;
            float f6 = rectF.top;
            canvas.drawRect(f5, f6, (rectF.right - f3) + 1.0f, f6 + f3, paint);
            float f7 = (rectF.left + f3) - 1.0f;
            float f8 = rectF.bottom;
            canvas.drawRect(f7, f8 - f3, (rectF.right - f3) + 1.0f, f8, paint);
        }
        canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
    }
}
