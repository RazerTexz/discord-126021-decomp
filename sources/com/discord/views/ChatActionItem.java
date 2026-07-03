package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.C5419R;
import p007b.p008a.p025i.C0922b2;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChatActionItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatActionItem extends CardView {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0922b2 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatActionItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.view_chat_action_item, this);
        int i = C5419R.id.chat_action_item_image;
        ImageView imageView = (ImageView) findViewById(C5419R.id.chat_action_item_image);
        if (imageView != null) {
            i = C5419R.id.chat_action_item_text;
            TextView textView = (TextView) findViewById(C5419R.id.chat_action_item_text);
            if (textView != null) {
                C0922b2 c0922b2 = new C0922b2(this, imageView, textView);
                C12238m.checkNotNullExpressionValue(c0922b2, "ViewChatActionItemBindin…ater.from(context), this)");
                this.binding = c0922b2;
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5419R.a.ChatActionItem, 0, 0);
                C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…hatActionItem, 0, 0\n    )");
                C12238m.checkNotNullExpressionValue(textView, "binding.chatActionItemText");
                textView.setText(typedArrayObtainStyledAttributes.getString(1));
                imageView.setImageResource(typedArrayObtainStyledAttributes.getResourceId(0, C5419R.drawable.drawable_circle_white_1));
                typedArrayObtainStyledAttributes.recycle();
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
