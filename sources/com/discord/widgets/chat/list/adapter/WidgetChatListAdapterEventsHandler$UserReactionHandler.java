package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.app.AppFragment;
import com.discord.models.domain.emoji.Emoji;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreMessages;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import j0.l.a.l2;
import j0.l.a.r;
import j0.p.a;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$UserReactionHandler {
    public static final WidgetChatListAdapterEventsHandler$UserReactionHandler$Companion Companion = new WidgetChatListAdapterEventsHandler$UserReactionHandler$Companion(null);
    private static final long REQUEST_RATE_LIMIT_MILLIS = 250;
    private final Function1<MessageReactionUpdate, Unit> commitReactionAdd;
    private final Function1<MessageReactionUpdate, Unit> commitReactionRemove;
    private final AppFragment host;
    private final Subject<WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest, WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest> requestStream;
    private final StoreEmoji storeEmoji;
    private final StoreMessages storeMessages;

    public WidgetChatListAdapterEventsHandler$UserReactionHandler(AppFragment appFragment, StoreMessages storeMessages, StoreEmoji storeEmoji) {
        m.checkNotNullParameter(appFragment, "host");
        m.checkNotNullParameter(storeMessages, "storeMessages");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        this.host = appFragment;
        this.storeMessages = storeMessages;
        this.storeEmoji = storeEmoji;
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.requestStream = publishSubjectK0;
        this.commitReactionAdd = new WidgetChatListAdapterEventsHandler$UserReactionHandler$commitReactionAdd$1(this);
        this.commitReactionRemove = new WidgetChatListAdapterEventsHandler$UserReactionHandler$commitReactionRemove$1(this);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Objects.requireNonNull(publishSubjectK0);
        Observable observableH0 = Observable.h0(new r(publishSubjectK0.j, new l2(REQUEST_RATE_LIMIT_MILLIS, timeUnit, a.a())));
        m.checkNotNullExpressionValue(observableH0, "requestStream\n          …S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableH0, appFragment.getClass(), appFragment.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatListAdapterEventsHandler$UserReactionHandler$1(this), 60, (Object) null);
    }

    public static final /* synthetic */ StoreEmoji access$getStoreEmoji$p(WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandler) {
        return widgetChatListAdapterEventsHandler$UserReactionHandler.storeEmoji;
    }

    public static final /* synthetic */ StoreMessages access$getStoreMessages$p(WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandler) {
        return widgetChatListAdapterEventsHandler$UserReactionHandler.storeMessages;
    }

    public static final /* synthetic */ void access$requestReactionUpdate(WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandler, WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest) {
        widgetChatListAdapterEventsHandler$UserReactionHandler.requestReactionUpdate(widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest);
    }

    private final void requestReactionUpdate(WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest updateRequest) {
        String name;
        long userId = updateRequest.getUserId();
        long channelId = updateRequest.getChannelId();
        long messageId = updateRequest.getMessageId();
        MessageReaction reaction = updateRequest.getReaction();
        MessageReactionUpdate messageReactionUpdate = new MessageReactionUpdate(userId, channelId, messageId, reaction.getEmoji());
        if (reaction.getEmoji().e()) {
            name = reaction.getEmoji().getName() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + reaction.getEmoji().getId();
        } else {
            name = reaction.getEmoji().getName();
            if (name == null) {
                name = "";
            }
        }
        Observable<Void> observableRemoveSelfReaction = reaction.getMe() ? RestAPI.Companion.getApi().removeSelfReaction(channelId, messageId, name) : RestAPI.Companion.getApi().addReaction(channelId, messageId, name);
        Function1<MessageReactionUpdate, Unit> function1 = reaction.getMe() ? this.commitReactionRemove : this.commitReactionAdd;
        Function1<MessageReactionUpdate, Unit> function2 = reaction.getMe() ? this.commitReactionAdd : this.commitReactionRemove;
        function1.invoke(messageReactionUpdate);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableRemoveSelfReaction, false, 1, null), this.host, null, 2, null), this.host.getClass(), this.host.getContext(), (Function1) null, new WidgetChatListAdapterEventsHandler$UserReactionHandler$requestReactionUpdate$2(function2, messageReactionUpdate), (Function0) null, (Function0) null, new WidgetChatListAdapterEventsHandler$UserReactionHandler$requestReactionUpdate$1(this, reaction), 52, (Object) null);
    }

    public final void addNewReaction(Emoji emoji, long channelId, long messageId) {
        m.checkNotNullParameter(emoji, "emoji");
        RestAPI api = RestAPI.Companion.getApi();
        String reactionKey = emoji.getReactionKey();
        m.checkNotNullExpressionValue(reactionKey, "emoji.reactionKey");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.addReaction(channelId, messageId, reactionKey), false, 1, null), this.host, null, 2, null), this.host.getClass(), this.host.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetChatListAdapterEventsHandler$UserReactionHandler$addNewReaction$1.INSTANCE, 60, (Object) null);
    }

    public final void toggleReaction(long userId, long channelId, long messageId, MessageReaction reaction) {
        m.checkNotNullParameter(reaction, "reaction");
        this.requestStream.onNext(new WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest(userId, channelId, messageId, reaction));
    }
}
