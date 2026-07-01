package com.discord.widgets.guilds.contextmenu;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildContextMenuViewModel extends d0<GuildContextMenuViewModel$ViewState> {
    public static final GuildContextMenuViewModel$Companion Companion = new GuildContextMenuViewModel$Companion(null);
    private final PublishSubject<GuildContextMenuViewModel$Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;
    private final Observable<GuildContextMenuViewModel$StoreState> storeStateObservable;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildContextMenuViewModel(long j, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        restAPI = (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI;
        if ((i & 4) != 0) {
            GuildContextMenuViewModel$Companion guildContextMenuViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = GuildContextMenuViewModel$Companion.access$observeStoreState(guildContextMenuViewModel$Companion, j, storeStream$Companion.getGuilds(), storeStream$Companion.getUsers(), storeStream$Companion.getReadStates(), storeStream$Companion.getGuildSelected());
        }
        this(j, restAPI, observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(GuildContextMenuViewModel guildContextMenuViewModel) {
        return guildContextMenuViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(GuildContextMenuViewModel guildContextMenuViewModel, GuildContextMenuViewModel$StoreState guildContextMenuViewModel$StoreState) {
        guildContextMenuViewModel.handleStoreState(guildContextMenuViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(GuildContextMenuViewModel$StoreState storeState) {
        if (storeState instanceof GuildContextMenuViewModel$StoreState$Valid) {
            GuildContextMenuViewModel$StoreState$Valid guildContextMenuViewModel$StoreState$Valid = (GuildContextMenuViewModel$StoreState$Valid) storeState;
            updateViewState(new GuildContextMenuViewModel$ViewState$Valid(guildContextMenuViewModel$StoreState$Valid.getGuild(), guildContextMenuViewModel$StoreState$Valid.isGuildUnread(), guildContextMenuViewModel$StoreState$Valid.getGuild().getOwnerId() != guildContextMenuViewModel$StoreState$Valid.getMyUserId(), guildContextMenuViewModel$StoreState$Valid.getSelectedGuildId() == guildContextMenuViewModel$StoreState$Valid.getGuild().getId()));
        } else if (m.areEqual(storeState, GuildContextMenuViewModel$StoreState$Invalid.INSTANCE)) {
            updateViewState(GuildContextMenuViewModel$ViewState$Invalid.INSTANCE);
        }
    }

    public final Observable<GuildContextMenuViewModel$StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final Observable<GuildContextMenuViewModel$Event> observeEvents() {
        PublishSubject<GuildContextMenuViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onMarkAsReadClicked() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(this.guildId), false, 1, null), this, null, 2, null), GuildContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildContextMenuViewModel$onMarkAsReadClicked$1(this), 62, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildContextMenuViewModel(long j, RestAPI restAPI, Observable<GuildContextMenuViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), GuildContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildContextMenuViewModel$1(this), 62, (Object) null);
    }
}
