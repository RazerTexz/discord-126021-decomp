package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import com.discord.models.user.CoreUser;
import com.discord.stores.StorePendingReplies$PendingReply;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$getPendingReplyStateObservable$1<T, R> implements b<StorePendingReplies$PendingReply, Observable<? extends ChatInputViewModel$StoreState$Loaded$PendingReply>> {
    public static final ChatInputViewModel$Companion$getPendingReplyStateObservable$1 INSTANCE = new ChatInputViewModel$Companion$getPendingReplyStateObservable$1();

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatInputViewModel$StoreState$Loaded$PendingReply> call2(StorePendingReplies$PendingReply storePendingReplies$PendingReply) {
        Observable<R> kVar;
        if (storePendingReplies$PendingReply == null) {
            return new k(null);
        }
        if (storePendingReplies$PendingReply.getOriginalMessage().isWebhook()) {
            User author = storePendingReplies$PendingReply.getOriginalMessage().getAuthor();
            m.checkNotNull(author);
            return new k(new ChatInputViewModel$StoreState$Loaded$PendingReply(storePendingReplies$PendingReply, new CoreUser(author), null));
        }
        User author2 = storePendingReplies$PendingReply.getOriginalMessage().getAuthor();
        m.checkNotNull(author2);
        long id2 = author2.getId();
        Long guildId = storePendingReplies$PendingReply.getMessageReference().getGuildId();
        if (guildId != null) {
            kVar = StoreStream.Companion.getGuilds().observeComputed(guildId.longValue()).G(new ChatInputViewModel$Companion$getPendingReplyStateObservable$1$$special$$inlined$let$lambda$1(id2)).r();
        } else {
            kVar = new k(null);
        }
        return Observable.j(StoreStream.Companion.getUsers().observeUser(id2), kVar, new ChatInputViewModel$Companion$getPendingReplyStateObservable$1$1(storePendingReplies$PendingReply));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ChatInputViewModel$StoreState$Loaded$PendingReply> call(StorePendingReplies$PendingReply storePendingReplies$PendingReply) {
        return call2(storePendingReplies$PendingReply);
    }
}
