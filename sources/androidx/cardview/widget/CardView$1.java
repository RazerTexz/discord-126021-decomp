package androidx.cardview.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class CardView$1 implements CardViewDelegate {
    private Drawable mCardBackground;
    public final /* synthetic */ CardView this$0;

    public CardView$1(CardView cardView) {
        this.this$0 = cardView;
    }

    @Override // androidx.cardview.widget.CardViewDelegate
    public Drawable getCardBackground() {
        return this.mCardBackground;
    }

    @Override // androidx.cardview.widget.CardViewDelegate
    public View getCardView() {
        return this.this$0;
    }

    @Override // androidx.cardview.widget.CardViewDelegate
    public boolean getPreventCornerOverlap() {
        return this.this$0.getPreventCornerOverlap();
    }

    @Override // androidx.cardview.widget.CardViewDelegate
    public boolean getUseCompatPadding() {
        return this.this$0.getUseCompatPadding();
    }

    @Override // androidx.cardview.widget.CardViewDelegate
    public void setCardBackground(Drawable drawable) {
        this.mCardBackground = drawable;
        this.this$0.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardViewDelegate
    public void setMinWidthHeightInternal(int i, int i2) {
        CardView cardView = this.this$0;
        if (i > cardView.mUserSetMinWidth) {
            CardView.access$101(cardView, i);
        }
        CardView cardView2 = this.this$0;
        if (i2 > cardView2.mUserSetMinHeight) {
            CardView.access$201(cardView2, i2);
        }
    }

    @Override // androidx.cardview.widget.CardViewDelegate
    public void setShadowPadding(int i, int i2, int i3, int i4) {
        this.this$0.mShadowBounds.set(i, i2, i3, i4);
        CardView cardView = this.this$0;
        Rect rect = cardView.mContentPadding;
        CardView.access$001(cardView, i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }
}
