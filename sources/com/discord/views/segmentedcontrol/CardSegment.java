package com.discord.views.segmentedcontrol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import b.a.i.CardSegmentViewBinding;
import b.a.y.n0.SegmentedControlSegment;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.gifpicker.ViewScalingOnTouchListener;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: CardSegment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CardSegment extends CardView implements SegmentedControlSegment {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final CardSegmentViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardSegment(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.card_segment_view, this);
        int i = R.id.card_segment_badge;
        TextView textView = (TextView) findViewById(R.id.card_segment_badge);
        if (textView != null) {
            i = R.id.card_segment_text;
            TextView textView2 = (TextView) findViewById(R.id.card_segment_text);
            if (textView2 != null) {
                CardSegmentViewBinding cardSegmentViewBinding = new CardSegmentViewBinding(this, textView, textView2);
                Intrinsics3.checkNotNullExpressionValue(cardSegmentViewBinding, "CardSegmentViewBinding.i…ater.from(context), this)");
                this.binding = cardSegmentViewBinding;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.CardSegment, 0, 0);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…leable.CardSegment, 0, 0)");
                    try {
                        setText(typedArrayObtainStyledAttributes.getString(0));
                        typedArrayObtainStyledAttributes.recycle();
                    } catch (Throwable th) {
                        typedArrayObtainStyledAttributes.recycle();
                        throw th;
                    }
                }
                setOnTouchListener(new ViewScalingOnTouchListener(0.9f));
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    @Override // b.a.y.n0.SegmentedControlSegment
    public void a(boolean selected) {
        int themedColor = selected ? ColorCompat.getThemedColor(this, R.attr.colorBackgroundAccent) : ColorCompat.getColor(this, R.color.transparent);
        int color = selected ? ColorCompat.getColor(this, R.color.white) : ColorCompat.getThemedColor(this, R.attr.colorInteractiveMuted);
        setCardBackgroundColor(themedColor);
        this.binding.c.setTextColor(color);
    }

    public final View getCardText() {
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cardSegmentText");
        return textView;
    }

    public final void setBadgeText(CharSequence text) {
        TextView textView = this.binding.f109b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cardSegmentBadge");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    public final void setText(CharSequence text) {
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cardSegmentText");
        textView.setText(text);
    }
}
