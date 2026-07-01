package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import d0.t.n;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel$Companion$getTypingObservableForDraft$1<T, R> implements b<Integer, Observable<? extends ChatTypingModel>> {
    public final /* synthetic */ Channel $parentChannel;

    public ChatTypingModel$Companion$getTypingObservableForDraft$1(Channel channel) {
        this.$parentChannel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(Integer num) {
        List listEmptyList = n.emptyList();
        int rateLimitPerUser = this.$parentChannel.getRateLimitPerUser();
        m.checkNotNullExpressionValue(num, "cooldownSecs");
        return new k(new ChatTypingModel$Typing(listEmptyList, rateLimitPerUser, num.intValue()));
    }
}
