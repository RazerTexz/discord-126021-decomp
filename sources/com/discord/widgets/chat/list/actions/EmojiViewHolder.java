package com.discord.widgets.chat.list.actions;

import android.view.View;
import com.discord.C5419R;
import com.discord.databinding.ViewChatListActionsEmojiItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiViewHolder extends MGRecyclerViewHolder<WidgetChatListActionsEmojisAdapter, EmojiItem> {
    private final ViewChatListActionsEmojiItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiViewHolder(WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter) {
        super(C5419R.layout.view_chat_list_actions_emoji_item, widgetChatListActionsEmojisAdapter);
        C12238m.checkNotNullParameter(widgetChatListActionsEmojisAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
        ViewChatListActionsEmojiItemBinding viewChatListActionsEmojiItemBinding = new ViewChatListActionsEmojiItemBinding(simpleDraweeView, simpleDraweeView);
        C12238m.checkNotNullExpressionValue(viewChatListActionsEmojiItemBinding, "ViewChatListActionsEmojiItemBinding.bind(itemView)");
        this.binding = viewChatListActionsEmojiItemBinding;
    }

    public static final /* synthetic */ WidgetChatListActionsEmojisAdapter access$getAdapter$p(EmojiViewHolder emojiViewHolder) {
        return (WidgetChatListActionsEmojisAdapter) emojiViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, final EmojiItem data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        EmojiItem.EmojiData emojiData = (EmojiItem.EmojiData) data;
        SimpleDraweeView simpleDraweeView = this.binding.f15396b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.emojiIv");
        int i = simpleDraweeView.getLayoutParams().width;
        SimpleDraweeView simpleDraweeView2 = this.binding.f15396b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.emojiIv");
        int paddingStart = i - simpleDraweeView2.getPaddingStart();
        SimpleDraweeView simpleDraweeView3 = this.binding.f15396b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.emojiIv");
        int mediaProxySize = IconUtils.getMediaProxySize(DimenUtils.pixelsToDp(paddingStart - simpleDraweeView3.getPaddingEnd()) * 2);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.EmojiViewHolder.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmojiViewHolder.access$getAdapter$p(EmojiViewHolder.this).getOnClickEmoji().invoke(((EmojiItem.EmojiData) data).getEmoji());
            }
        });
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        view.setContentDescription(emojiData.getEmoji().getFirstName());
        SimpleDraweeView simpleDraweeView4 = this.binding.f15396b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.emojiIv");
        Emoji emoji = emojiData.getEmoji();
        View view2 = this.itemView;
        C12238m.checkNotNullExpressionValue(view2, "itemView");
        MGImages.setImage$default(simpleDraweeView4, emoji.getImageUri(true, mediaProxySize, view2.getContext()), 0, 0, false, null, null, 124, null);
    }
}
