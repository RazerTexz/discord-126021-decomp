package com.discord.widgets.chat.managereactions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetManageReactionsEmojiBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.EmojiNode$Companion;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import d0.z.d.m;

/* JADX INFO: compiled from: ManageReactionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsEmojisAdapter$ReactionEmojiViewHolder extends MGRecyclerViewHolder<ManageReactionsEmojisAdapter, ManageReactionsEmojisAdapter$ReactionEmojiItem> {
    public static final ManageReactionsEmojisAdapter$ReactionEmojiViewHolder$Companion Companion = new ManageReactionsEmojisAdapter$ReactionEmojiViewHolder$Companion(null);
    private static final int emojiSizePx = DimenUtils.dpToPixels(20);
    private final WidgetManageReactionsEmojiBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsEmojisAdapter$ReactionEmojiViewHolder(ManageReactionsEmojisAdapter manageReactionsEmojisAdapter) {
        super(R$layout.widget_manage_reactions_emoji, manageReactionsEmojisAdapter);
        m.checkNotNullParameter(manageReactionsEmojisAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.manage_reactions_emoji_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.manage_reactions_emoji_container);
        if (linearLayout != null) {
            i = R$id.manage_reactions_emoji_counter;
            TextView textView = (TextView) view.findViewById(R$id.manage_reactions_emoji_counter);
            if (textView != null) {
                i = R$id.manage_reactions_emoji_emoji_textview;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R$id.manage_reactions_emoji_emoji_textview);
                if (simpleDraweeSpanTextView != null) {
                    i = R$id.manage_reactions_emoji_selected_indicator;
                    View viewFindViewById = view.findViewById(R$id.manage_reactions_emoji_selected_indicator);
                    if (viewFindViewById != null) {
                        WidgetManageReactionsEmojiBinding widgetManageReactionsEmojiBinding = new WidgetManageReactionsEmojiBinding((RelativeLayout) view, linearLayout, textView, simpleDraweeSpanTextView, viewFindViewById);
                        m.checkNotNullExpressionValue(widgetManageReactionsEmojiBinding, "WidgetManageReactionsEmojiBinding.bind(itemView)");
                        this.binding = widgetManageReactionsEmojiBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ ManageReactionsEmojisAdapter access$getAdapter$p(ManageReactionsEmojisAdapter$ReactionEmojiViewHolder manageReactionsEmojisAdapter$ReactionEmojiViewHolder) {
        return (ManageReactionsEmojisAdapter) manageReactionsEmojisAdapter$ReactionEmojiViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ManageReactionsEmojisAdapter$ReactionEmojiItem manageReactionsEmojisAdapter$ReactionEmojiItem) {
        onConfigure2(i, manageReactionsEmojisAdapter$ReactionEmojiItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ManageReactionsEmojisAdapter$ReactionEmojiItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        EmojiNode$Companion emojiNode$Companion = EmojiNode.Companion;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.manageReactionsEmojiEmojiTextview");
        emojiNode$Companion.renderEmoji(simpleDraweeSpanTextView, data.getReaction().getEmoji(), true, emojiSizePx);
        TextView textView = this.binding.f2483b;
        m.checkNotNullExpressionValue(textView, "binding.manageReactionsEmojiCounter");
        textView.setText(String.valueOf(data.getReaction().getCount()));
        View view = this.binding.d;
        m.checkNotNullExpressionValue(view, "binding.manageReactionsEmojiSelectedIndicator");
        view.setVisibility(data.isSelected() ? 0 : 4);
        this.binding.a.setOnClickListener(new ManageReactionsEmojisAdapter$ReactionEmojiViewHolder$onConfigure$1(this, data));
    }
}
