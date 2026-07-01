package com.discord.widgets.chat.list;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.stores.StoreChannelFollowerStats;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialogViewModel extends d0<PublishActionDialogViewModel$ViewState> {
    public static final PublishActionDialogViewModel$Companion Companion = new PublishActionDialogViewModel$Companion(null);
    private final long channelId;
    private final PublishSubject<PublishActionDialogViewModel$Event> eventSubject;
    private final long messageId;
    private final RestAPI restAPI;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PublishActionDialogViewModel(long j, long j2, RestAPI restAPI, StoreChannelFollowerStats storeChannelFollowerStats, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI;
        StoreChannelFollowerStats channelFollowerStats = (i & 8) != 0 ? StoreStream.Companion.getChannelFollowerStats() : storeChannelFollowerStats;
        this(j, j2, api, channelFollowerStats, (i & 16) != 0 ? PublishActionDialogViewModel$Companion.access$observeChannelFollowerStatsStoreState(Companion, j2, channelFollowerStats) : observable);
    }

    public static final /* synthetic */ void access$emitFailureEvent(PublishActionDialogViewModel publishActionDialogViewModel) {
        publishActionDialogViewModel.emitFailureEvent();
    }

    public static final /* synthetic */ void access$emitSuccessActionEvent(PublishActionDialogViewModel publishActionDialogViewModel) {
        publishActionDialogViewModel.emitSuccessActionEvent();
    }

    public static final /* synthetic */ void access$handleStoreState(PublishActionDialogViewModel publishActionDialogViewModel, PublishActionDialogViewModel$StoreState publishActionDialogViewModel$StoreState) {
        publishActionDialogViewModel.handleStoreState(publishActionDialogViewModel$StoreState);
    }

    private final void emitFailureEvent() {
        PublishSubject<PublishActionDialogViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new PublishActionDialogViewModel$Event$Failure(2131888366));
    }

    private final void emitSuccessActionEvent() {
        PublishSubject<PublishActionDialogViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new PublishActionDialogViewModel$Event$Success(2131892965));
    }

    private final void handleStoreState(PublishActionDialogViewModel$StoreState storeState) {
        Integer guildsFollowing;
        ModelChannelFollowerStats followerStats = storeState.getFollowerStats();
        int iIntValue = (followerStats == null || (guildsFollowing = followerStats.getGuildsFollowing()) == null) ? 0 : guildsFollowing.intValue();
        if ((followerStats != null ? followerStats.getGuildsFollowing() : null) == null || iIntValue <= 0) {
            updateViewState(PublishActionDialogViewModel$ViewState$LoadedNoFollowers.INSTANCE);
        } else {
            updateViewState(new PublishActionDialogViewModel$ViewState$LoadedHasFollowers(followerStats));
        }
    }

    public final Observable<PublishActionDialogViewModel$Event> observeEvents() {
        PublishSubject<PublishActionDialogViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void publishMessage() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.crosspostMessage(this.channelId, Long.valueOf(this.messageId)), false, 1, null), this, null, 2, null), PublishActionDialogViewModel.class, (Context) null, (Function1) null, new PublishActionDialogViewModel$publishMessage$2(this), (Function0) null, (Function0) null, new PublishActionDialogViewModel$publishMessage$1(this), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishActionDialogViewModel(long j, long j2, RestAPI restAPI, StoreChannelFollowerStats storeChannelFollowerStats, Observable<PublishActionDialogViewModel$StoreState> observable) {
        super(PublishActionDialogViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeChannelFollowerStats, "storeChannelFollowerStats");
        m.checkNotNullParameter(observable, "storeObservable");
        this.messageId = j;
        this.channelId = j2;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        storeChannelFollowerStats.fetchChannelFollowerStats(j2);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), PublishActionDialogViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new PublishActionDialogViewModel$1(this), 62, (Object) null);
    }
}
