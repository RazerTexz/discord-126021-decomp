package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StorePendingReplies$PendingReply;
import rx.functions.Func2;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$getPendingReplyStateObservable$1$1<T1, T2, R> implements Func2<User, GuildMember, ChatInputViewModel$StoreState$Loaded$PendingReply> {
    public final /* synthetic */ StorePendingReplies$PendingReply $pendingReply;

    public ChatInputViewModel$Companion$getPendingReplyStateObservable$1$1(StorePendingReplies$PendingReply storePendingReplies$PendingReply) {
        this.$pendingReply = storePendingReplies$PendingReply;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ChatInputViewModel$StoreState$Loaded$PendingReply call(User user, GuildMember guildMember) {
        return call2(user, guildMember);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ChatInputViewModel$StoreState$Loaded$PendingReply call2(User user, GuildMember guildMember) {
        return new ChatInputViewModel$StoreState$Loaded$PendingReply(this.$pendingReply, user, guildMember);
    }
}
