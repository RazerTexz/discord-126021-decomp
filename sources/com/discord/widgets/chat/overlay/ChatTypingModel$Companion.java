package com.discord.widgets.chat.overlay;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreSlowMode$Type$ThreadCreate;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import j0.l.a.r;
import j0.l.a.u0;
import j0.l.e.k;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel$Companion {
    private ChatTypingModel$Companion() {
    }

    public static final /* synthetic */ Observable access$getTypingObservableForChannel(ChatTypingModel$Companion chatTypingModel$Companion, Channel channel) {
        return chatTypingModel$Companion.getTypingObservableForChannel(channel);
    }

    public static final /* synthetic */ Observable access$getTypingObservableForDraft(ChatTypingModel$Companion chatTypingModel$Companion, Channel channel) {
        return chatTypingModel$Companion.getTypingObservableForDraft(channel);
    }

    public static final /* synthetic */ Observable access$getTypingUsers(ChatTypingModel$Companion chatTypingModel$Companion, Channel channel) {
        return chatTypingModel$Companion.getTypingUsers(channel);
    }

    private final Observable<ChatTypingModel> getTypingObservableForChannel(Channel resolvedChannel) {
        k kVar = new k(resolvedChannel);
        Observable<ChatTypingModel> observableY = Observable.h0(new r(kVar.j, new u0(ChatTypingModel$Companion$getTypingObservableForChannel$1.INSTANCE))).Y(ChatTypingModel$Companion$getTypingObservableForChannel$2.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "Observable.just(resolved…          }\n            }");
        return observableY;
    }

    private final Observable<ChatTypingModel> getTypingObservableForDraft(Channel parentChannel) {
        Observable observableY = StoreStream.Companion.getSlowMode().observeCooldownSecs(Long.valueOf(parentChannel.getId()), StoreSlowMode$Type$ThreadCreate.INSTANCE).Y(new ChatTypingModel$Companion$getTypingObservableForDraft$1(parentChannel));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …ldownSecs))\n            }");
        return observableY;
    }

    private final Observable<List<CharSequence>> getTypingUsers(Channel channel) {
        Observable<List<CharSequence>> observableR = StoreStream.Companion.getUsersTyping().observeTypingUsers(channel.getId()).Y(new ChatTypingModel$Companion$getTypingUsers$1(channel)).G(ChatTypingModel$Companion$getTypingUsers$2.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<ChatTypingModel> get() {
        Observable<ChatTypingModel> observableR = StoreStream.Companion.getChannelsSelected().observeResolvedSelectedChannel().Y(ChatTypingModel$Companion$get$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream.getChannelsS…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ ChatTypingModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
