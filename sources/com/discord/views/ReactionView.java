package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import b.a.i.i1;
import com.discord.R$a;
import com.discord.R$anim;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.EmojiNode$Companion;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import d0.z.d.m;

/* JADX INFO: compiled from: ReactionView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReactionView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public int curCount;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Long curMessageId;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public MessageReaction reaction;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public ColorStateList textColor;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public ColorStateList meTextColor;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final i1 binding;

    public ReactionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ReactionView(Context context, AttributeSet attributeSet, int i, int i2) {
        attributeSet = (i2 & 2) != 0 ? null : attributeSet;
        i = (i2 & 4) != 0 ? 0 : i;
        m.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R$layout.reaction_view, this);
        int i3 = R$id.counter_text_1;
        TextView textView = (TextView) findViewById(R$id.counter_text_1);
        if (textView != null) {
            i3 = R$id.counter_text_2;
            TextView textView2 = (TextView) findViewById(R$id.counter_text_2);
            if (textView2 != null) {
                i3 = R$id.counter_text_switcher;
                TextSwitcher textSwitcher = (TextSwitcher) findViewById(R$id.counter_text_switcher);
                if (textSwitcher != null) {
                    i3 = R$id.emoji_text_view;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R$id.emoji_text_view);
                    if (simpleDraweeSpanTextView != null) {
                        i1 i1Var = new i1(this, textView, textView2, textSwitcher, simpleDraweeSpanTextView);
                        m.checkNotNullExpressionValue(i1Var, "ReactionViewBinding.infl…ater.from(context), this)");
                        this.binding = i1Var;
                        int[] iArr = R$a.ReactionView;
                        m.checkNotNullExpressionValue(iArr, "R.styleable.ReactionView");
                        Context context2 = getContext();
                        m.checkNotNullExpressionValue(context2, "context");
                        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
                        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
                        this.meTextColor = typedArrayObtainStyledAttributes.getColorStateList(0);
                        this.textColor = typedArrayObtainStyledAttributes.getColorStateList(1);
                        typedArrayObtainStyledAttributes.recycle();
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i3)));
    }

    private final void setIsMe(boolean isMe) {
        setActivated(isMe);
        setSelected(isMe);
        TextView textView = this.binding.f132b;
        m.checkNotNullExpressionValue(textView, "binding.counterText1");
        textView.setActivated(isMe);
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.counterText2");
        textView2.setActivated(isMe);
    }

    private final void setTextColor(boolean isMe) {
        ColorStateList colorStateList = isMe ? this.meTextColor : this.textColor;
        if (colorStateList != null) {
            this.binding.f132b.setTextColor(colorStateList);
            this.binding.c.setTextColor(colorStateList);
        }
    }

    public final void a(MessageReaction reaction, long messageId, boolean animateEmojis) {
        m.checkNotNullParameter(reaction, "reaction");
        Long l = this.curMessageId;
        boolean z2 = l == null || l == null || l.longValue() != messageId;
        MessageReaction messageReaction = this.reaction;
        int count = reaction.getCount();
        i1 i1Var = this.binding;
        int i = this.curCount;
        if (count != i) {
            if (z2) {
                i1Var.d.setCurrentText(String.valueOf(count));
            } else {
                if (count > i) {
                    TextSwitcher textSwitcher = i1Var.d;
                    textSwitcher.setInAnimation(textSwitcher.getContext(), R$anim.anim_slide_in_up);
                    textSwitcher.setOutAnimation(textSwitcher.getContext(), R$anim.anim_slide_out_up);
                } else {
                    TextSwitcher textSwitcher2 = i1Var.d;
                    textSwitcher2.setInAnimation(textSwitcher2.getContext(), R$anim.anim_slide_in_down);
                    textSwitcher2.setOutAnimation(textSwitcher2.getContext(), R$anim.anim_slide_out_down);
                }
                i1Var.d.setText(String.valueOf(count));
            }
            this.curCount = count;
        }
        if (messageReaction == null || (!m.areEqual(reaction.getEmoji(), messageReaction.getEmoji()))) {
            EmojiNode$Companion emojiNode$Companion = EmojiNode.Companion;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.e;
            m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.emojiTextView");
            EmojiNode$Companion.renderEmoji$default(emojiNode$Companion, simpleDraweeSpanTextView, reaction.getEmoji(), animateEmojis, 0, 4, null);
        }
        setIsMe(reaction.getMe());
        setTextColor(reaction.getMe());
        this.reaction = reaction;
        this.curMessageId = Long.valueOf(messageId);
    }

    public final MessageReaction getReaction() {
        return this.reaction;
    }

    public final void setMeTextColor(ColorStateList color) {
        m.checkNotNullParameter(color, ModelAuditLogEntry.CHANGE_KEY_COLOR);
        this.meTextColor = color;
    }
}
