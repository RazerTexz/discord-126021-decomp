package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.i.b2;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import d0.z.d.m;

/* JADX INFO: compiled from: ChatActionItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatActionItem extends CardView {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final b2 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatActionItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.view_chat_action_item, this);
        int i = R$id.chat_action_item_image;
        ImageView imageView = (ImageView) findViewById(R$id.chat_action_item_image);
        if (imageView != null) {
            i = R$id.chat_action_item_text;
            TextView textView = (TextView) findViewById(R$id.chat_action_item_text);
            if (textView != null) {
                b2 b2Var = new b2(this, imageView, textView);
                m.checkNotNullExpressionValue(b2Var, "ViewChatActionItemBindin…ater.from(context), this)");
                this.binding = b2Var;
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$a.ChatActionItem, 0, 0);
                m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…hatActionItem, 0, 0\n    )");
                m.checkNotNullExpressionValue(textView, "binding.chatActionItemText");
                textView.setText(typedArrayObtainStyledAttributes.getString(1));
                imageView.setImageResource(typedArrayObtainStyledAttributes.getResourceId(0, 2131231192));
                typedArrayObtainStyledAttributes.recycle();
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
