package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.i.ViewChatActionItemBinding;
import com.discord.R;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChatActionItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatActionItem extends CardView {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewChatActionItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatActionItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_chat_action_item, this);
        int i = R.id.chat_action_item_image;
        ImageView imageView = (ImageView) findViewById(R.id.chat_action_item_image);
        if (imageView != null) {
            i = R.id.chat_action_item_text;
            TextView textView = (TextView) findViewById(R.id.chat_action_item_text);
            if (textView != null) {
                ViewChatActionItemBinding viewChatActionItemBinding = new ViewChatActionItemBinding(this, imageView, textView);
                Intrinsics3.checkNotNullExpressionValue(viewChatActionItemBinding, "ViewChatActionItemBindin…ater.from(context), this)");
                this.binding = viewChatActionItemBinding;
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.ChatActionItem, 0, 0);
                Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…hatActionItem, 0, 0\n    )");
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatActionItemText");
                textView.setText(typedArrayObtainStyledAttributes.getString(1));
                imageView.setImageResource(typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.drawable_circle_white_1));
                typedArrayObtainStyledAttributes.recycle();
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
