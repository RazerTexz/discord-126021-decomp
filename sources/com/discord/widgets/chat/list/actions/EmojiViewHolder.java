package com.discord.widgets.chat.list.actions;

import android.view.View;
import com.discord.R$layout;
import com.discord.databinding.ViewChatListActionsEmojiItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiViewHolder extends MGRecyclerViewHolder<WidgetChatListActionsEmojisAdapter, EmojiItem> {
    private final ViewChatListActionsEmojiItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiViewHolder(WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter) {
        super(R$layout.view_chat_list_actions_emoji_item, widgetChatListActionsEmojisAdapter);
        m.checkNotNullParameter(widgetChatListActionsEmojisAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
        ViewChatListActionsEmojiItemBinding viewChatListActionsEmojiItemBinding = new ViewChatListActionsEmojiItemBinding(simpleDraweeView, simpleDraweeView);
        m.checkNotNullExpressionValue(viewChatListActionsEmojiItemBinding, "ViewChatListActionsEmojiItemBinding.bind(itemView)");
        this.binding = viewChatListActionsEmojiItemBinding;
    }

    public static final /* synthetic */ WidgetChatListActionsEmojisAdapter access$getAdapter$p(EmojiViewHolder emojiViewHolder) {
        return (WidgetChatListActionsEmojisAdapter) emojiViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, EmojiItem emojiItem) {
        onConfigure2(i, emojiItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, EmojiItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        EmojiItem$EmojiData emojiItem$EmojiData = (EmojiItem$EmojiData) data;
        SimpleDraweeView simpleDraweeView = this.binding.f2178b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.emojiIv");
        int i = simpleDraweeView.getLayoutParams().width;
        SimpleDraweeView simpleDraweeView2 = this.binding.f2178b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.emojiIv");
        int paddingStart = i - simpleDraweeView2.getPaddingStart();
        SimpleDraweeView simpleDraweeView3 = this.binding.f2178b;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.emojiIv");
        int mediaProxySize = IconUtils.getMediaProxySize(DimenUtils.pixelsToDp(paddingStart - simpleDraweeView3.getPaddingEnd()) * 2);
        this.itemView.setOnClickListener(new EmojiViewHolder$onConfigure$1(this, data));
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        view.setContentDescription(emojiItem$EmojiData.getEmoji().getFirstName());
        SimpleDraweeView simpleDraweeView4 = this.binding.f2178b;
        m.checkNotNullExpressionValue(simpleDraweeView4, "binding.emojiIv");
        Emoji emoji = emojiItem$EmojiData.getEmoji();
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        MGImages.setImage$default(simpleDraweeView4, emoji.getImageUri(true, mediaProxySize, view2.getContext()), 0, 0, false, null, null, 124, null);
    }
}
