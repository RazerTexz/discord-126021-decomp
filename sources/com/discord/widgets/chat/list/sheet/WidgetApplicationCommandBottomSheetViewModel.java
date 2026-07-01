package com.discord.widgets.chat.list.sheet;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationInteractions$State;
import com.discord.stores.StoreApplicationInteractions$State$Failure;
import com.discord.stores.StoreApplicationInteractions$State$Fetching;
import com.discord.stores.StoreApplicationInteractions$State$Loaded;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel extends d0<WidgetApplicationCommandBottomSheetViewModel$ViewState> {
    public static final WidgetApplicationCommandBottomSheetViewModel$Companion Companion = new WidgetApplicationCommandBottomSheetViewModel$Companion(null);
    private final long applicationId;
    private final long channelId;
    private final Long guildId;
    private final long interactionId;
    private final long interactionUserId;
    private final long messageId;
    private final String messageNonce;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetApplicationCommandBottomSheetViewModel(long j, long j2, long j3, Long l, long j4, long j5, String str, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        if ((i & 128) != 0) {
            WidgetApplicationCommandBottomSheetViewModel$Companion widgetApplicationCommandBottomSheetViewModel$Companion = Companion;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableAccess$observeStores = WidgetApplicationCommandBottomSheetViewModel$Companion.access$observeStores(widgetApplicationCommandBottomSheetViewModel$Companion, observationDeck, j, l, j4, j5, storeStream$Companion.getGuilds(), storeStream$Companion.getChannels(), storeStream$Companion.getUsers(), storeStream$Companion.getInteractions(), storeStream$Companion.getApplicationCommands());
        } else {
            observableAccess$observeStores = observable;
        }
        this(j, j2, j3, l, j4, j5, str, observableAccess$observeStores);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetApplicationCommandBottomSheetViewModel widgetApplicationCommandBottomSheetViewModel, WidgetApplicationCommandBottomSheetViewModel$StoreState widgetApplicationCommandBottomSheetViewModel$StoreState) {
        widgetApplicationCommandBottomSheetViewModel.handleStoreState(widgetApplicationCommandBottomSheetViewModel$StoreState);
    }

    private final void handleStoreState(WidgetApplicationCommandBottomSheetViewModel$StoreState storeState) {
        String username;
        StoreApplicationInteractions$State interactionState = storeState.getInteractionState();
        if (m.areEqual(interactionState, StoreApplicationInteractions$State$Failure.INSTANCE)) {
            updateViewState(WidgetApplicationCommandBottomSheetViewModel$ViewState$Failed.INSTANCE);
            return;
        }
        if (m.areEqual(interactionState, StoreApplicationInteractions$State$Fetching.INSTANCE)) {
            updateViewState(WidgetApplicationCommandBottomSheetViewModel$ViewState$Loading.INSTANCE);
            return;
        }
        if (interactionState instanceof StoreApplicationInteractions$State$Loaded) {
            if (storeState.getMentionedUsers().size() == storeState.getUsers().size()) {
                int size = storeState.getMentionedUsers().size();
                Map<Long, GuildMember> guildMembers = storeState.getGuildMembers();
                if (guildMembers != null && size == guildMembers.size()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Iterator<T> it = storeState.getMentionedUsers().iterator();
                    while (it.hasNext()) {
                        long jLongValue = ((Number) it.next()).longValue();
                        GuildMember guildMember = storeState.getGuildMembers().get(Long.valueOf(jLongValue));
                        if (guildMember == null || (username = guildMember.getNick()) == null) {
                            User user = storeState.getUsers().get(Long.valueOf(jLongValue));
                            username = user != null ? user.getUsername() : null;
                        }
                        if (username == null) {
                            username = "";
                        }
                        linkedHashMap.put(Long.valueOf(jLongValue), username);
                    }
                    updateViewState(new WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded(this.interactionId, storeState.getUser(), storeState.getInteractionUser(), storeState.getApplication(), ((StoreApplicationInteractions$State$Loaded) storeState.getInteractionState()).getCommandOptions(), this.guildId, Long.valueOf(this.channelId), storeState.getGuildMembers(), storeState.getGuildRoles(), storeState.getChannels(), linkedHashMap, storeState.getCommandValues()));
                    return;
                }
            }
            updateViewState(WidgetApplicationCommandBottomSheetViewModel$ViewState$Loading.INSTANCE);
        }
    }

    private final void requestInteractionData() {
        StoreStream.Companion.getInteractions().fetchInteractionDataIfNonExisting(this.interactionId, this.channelId, this.messageId, this.messageNonce);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final long getInteractionId() {
        return this.interactionId;
    }

    public final long getInteractionUserId() {
        return this.interactionUserId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final String getMessageNonce() {
        return this.messageNonce;
    }

    public final void retry() {
        requestInteractionData();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheetViewModel(long j, long j2, long j3, Long l, long j4, long j5, String str, Observable<WidgetApplicationCommandBottomSheetViewModel$StoreState> observable) {
        super(WidgetApplicationCommandBottomSheetViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(observable, "storeObservable");
        this.interactionId = j;
        this.messageId = j2;
        this.channelId = j3;
        this.guildId = l;
        this.interactionUserId = j4;
        this.applicationId = j5;
        this.messageNonce = str;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetApplicationCommandBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetApplicationCommandBottomSheetViewModel$1(this), 62, (Object) null);
        requestInteractionData();
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).G(WidgetApplicationCommandBottomSheetViewModel$2.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "storeObservable.computat…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetApplicationCommandBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetApplicationCommandBottomSheetViewModel$3(this), 62, (Object) null);
    }
}
