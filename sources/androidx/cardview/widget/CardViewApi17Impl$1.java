package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class CardViewApi17Impl$1 implements RoundRectDrawableWithShadow$RoundRectHelper {
    public final /* synthetic */ CardViewApi17Impl this$0;

    public CardViewApi17Impl$1(CardViewApi17Impl cardViewApi17Impl) {
        this.this$0 = cardViewApi17Impl;
    }

    @Override // androidx.cardview.widget.RoundRectDrawableWithShadow$RoundRectHelper
    public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
