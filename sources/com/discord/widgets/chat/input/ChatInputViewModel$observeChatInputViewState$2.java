package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import rx.functions.Func2;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$observeChatInputViewState$2<T1, T2, R> implements Func2<Long, ChatInputViewModel$ViewState, ChatInputViewModel$ViewState> {
    public final /* synthetic */ ChatInputViewModel this$0;

    public ChatInputViewModel$observeChatInputViewState$2(ChatInputViewModel chatInputViewModel) {
        this.this$0 = chatInputViewModel;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ChatInputViewModel$ViewState call(Long l, ChatInputViewModel$ViewState chatInputViewModel$ViewState) {
        return call2(l, chatInputViewModel$ViewState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ChatInputViewModel$ViewState call2(Long l, ChatInputViewModel$ViewState chatInputViewModel$ViewState) {
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) (!(chatInputViewModel$ViewState instanceof ChatInputViewModel$ViewState$Loaded) ? null : chatInputViewModel$ViewState);
        if (chatInputViewModel$ViewState$Loaded == null) {
            return chatInputViewModel$ViewState;
        }
        if (ChatInputViewModel.access$getUseTimeoutUpdateInterval$p(this.this$0)) {
            long jAccess$calculateTimeoutLeftMs = ChatInputViewModel.access$calculateTimeoutLeftMs(this.this$0, chatInputViewModel$ViewState$Loaded.getMeGuildMember());
            GuildMember meGuildMember = chatInputViewModel$ViewState$Loaded.getMeGuildMember();
            ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$LoadedCopy$default = ChatInputViewModel$ViewState$Loaded.copy$default(chatInputViewModel$ViewState$Loaded, null, 0L, null, null, null, false, null, false, false, false, 0, false, null, false, false, false, false, false, false, meGuildMember != null && meGuildMember.isCommunicationDisabled(), jAccess$calculateTimeoutLeftMs, null, false, null, null, false, 65535999, null);
            if (chatInputViewModel$ViewState$Loaded.getMeGuildMember() != null && chatInputViewModel$ViewState$Loaded.isCommunicationDisabled() && !chatInputViewModel$ViewState$LoadedCopy$default.isCommunicationDisabled()) {
                ChatInputViewModel.access$getStoreGuilds$p(this.this$0).handleGuildMemberCommunicationEnabled(chatInputViewModel$ViewState$Loaded.getMeGuildMember().getGuildId(), chatInputViewModel$ViewState$Loaded.getMeGuildMember().getUserId());
            }
            chatInputViewModel$ViewState$Loaded = chatInputViewModel$ViewState$LoadedCopy$default;
        }
        return chatInputViewModel$ViewState$Loaded != null ? chatInputViewModel$ViewState$Loaded : chatInputViewModel$ViewState;
    }
}
