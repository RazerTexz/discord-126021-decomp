package com.discord.widgets.chat;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies$PendingReply;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.messagesend.MessageResult$Slowmode;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageManager$sendMessage$messageResultObservable$1<T, R> implements b<Integer, Observable<? extends MessageResult>> {
    public final /* synthetic */ MessageAllowedMentions $allowedMentions;
    public final /* synthetic */ List $attachments;
    public final /* synthetic */ String $content;
    public final /* synthetic */ MeUser $me;
    public final /* synthetic */ List $mentions;
    public final /* synthetic */ long $nonNullChannelId;
    public final /* synthetic */ StorePendingReplies$PendingReply $pendingReply;
    public final /* synthetic */ List $stickers;
    public final /* synthetic */ MessageManager this$0;

    public MessageManager$sendMessage$messageResultObservable$1(MessageManager messageManager, StorePendingReplies$PendingReply storePendingReplies$PendingReply, long j, MeUser meUser, String str, List list, List list2, List list3, MessageAllowedMentions messageAllowedMentions) {
        this.this$0 = messageManager;
        this.$pendingReply = storePendingReplies$PendingReply;
        this.$nonNullChannelId = j;
        this.$me = meUser;
        this.$content = str;
        this.$mentions = list;
        this.$attachments = list2;
        this.$stickers = list3;
        this.$allowedMentions = messageAllowedMentions;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends MessageResult> call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends MessageResult> call2(Integer num) {
        if (num.intValue() > 0) {
            return new k(new MessageResult$Slowmode(((long) num.intValue()) * 1000));
        }
        if (this.$pendingReply != null) {
            MessageManager.access$getStorePendingReplies$p(this.this$0).onDeletePendingReply(this.$nonNullChannelId);
        }
        StoreMessages storeMessagesAccess$getStoreMessages$p = MessageManager.access$getStoreMessages$p(this.this$0);
        long j = this.$nonNullChannelId;
        MeUser meUser = this.$me;
        String str = this.$content;
        List list = this.$mentions;
        List list2 = this.$attachments;
        List list3 = this.$stickers;
        StorePendingReplies$PendingReply storePendingReplies$PendingReply = this.$pendingReply;
        return StoreMessages.sendMessage$default(storeMessagesAccess$getStoreMessages$p, j, meUser, str, list, list2, list3, storePendingReplies$PendingReply != null ? storePendingReplies$PendingReply.getMessageReference() : null, this.$allowedMentions, null, null, null, null, null, null, null, 32512, null);
    }
}
