package com.discord.views.segmentedcontrol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.i.f;
import b.a.y.n0.a;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.gifpicker.ViewScalingOnTouchListener;
import d0.z.d.m;

/* JADX INFO: compiled from: CardSegment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CardSegment extends CardView implements a {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final f binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardSegment(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.card_segment_view, this);
        int i = R$id.card_segment_badge;
        TextView textView = (TextView) findViewById(R$id.card_segment_badge);
        if (textView != null) {
            i = R$id.card_segment_text;
            TextView textView2 = (TextView) findViewById(R$id.card_segment_text);
            if (textView2 != null) {
                f fVar = new f(this, textView, textView2);
                m.checkNotNullExpressionValue(fVar, "CardSegmentViewBinding.i…ater.from(context), this)");
                this.binding = fVar;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$a.CardSegment, 0, 0);
                    m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…leable.CardSegment, 0, 0)");
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

    @Override // b.a.y.n0.a
    public void a(boolean selected) {
        int themedColor = selected ? ColorCompat.getThemedColor(this, 2130968896) : ColorCompat.getColor(this, 2131100438);
        int color = selected ? ColorCompat.getColor(this, 2131100487) : ColorCompat.getThemedColor(this, 2130969007);
        setCardBackgroundColor(themedColor);
        this.binding.c.setTextColor(color);
    }

    public final View getCardText() {
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.cardSegmentText");
        return textView;
    }

    public final void setBadgeText(CharSequence text) {
        TextView textView = this.binding.f109b;
        m.checkNotNullExpressionValue(textView, "binding.cardSegmentBadge");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    public final void setText(CharSequence text) {
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.cardSegmentText");
        textView.setText(text);
    }
}
