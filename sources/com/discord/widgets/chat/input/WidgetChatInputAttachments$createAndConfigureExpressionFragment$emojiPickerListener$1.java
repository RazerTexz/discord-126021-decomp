package com.discord.widgets.chat.input;

import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1 implements EmojiPickerListener {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    public WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1(WidgetChatInputAttachments widgetChatInputAttachments) {
        this.this$0 = widgetChatInputAttachments;
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
    public void onEmojiPicked(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        FlexInputFragment flexInputFragmentAccess$getFlexInputFragment$p = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0);
        String chatInputText = emoji.getChatInputText();
        m.checkNotNullExpressionValue(chatInputText, "emoji.chatInputText");
        Objects.requireNonNull(flexInputFragmentAccess$getFlexInputFragment$p);
        m.checkNotNullParameter(chatInputText, "emojiText");
        FlexInputViewModel flexInputViewModel = flexInputFragmentAccess$getFlexInputFragment$p.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onInputTextAppended(chatInputText + ' ');
        }
    }
}
