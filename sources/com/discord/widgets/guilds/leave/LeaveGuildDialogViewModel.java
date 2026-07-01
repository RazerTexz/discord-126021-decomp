package com.discord.widgets.guilds.leave;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeaveGuildDialogViewModel extends d0<LeaveGuildDialogViewModel$ViewState> {
    public static final LeaveGuildDialogViewModel$Companion Companion = new LeaveGuildDialogViewModel$Companion(null);
    private final PublishSubject<LeaveGuildDialogViewModel$Event> eventSubject;
    private final long guildId;
    private final StoreLurking lurkingStore;
    private final RestAPI restAPI;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LeaveGuildDialogViewModel(long j, RestAPI restAPI, StoreLurking storeLurking, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI;
        StoreLurking lurking = (i & 4) != 0 ? StoreStream.Companion.getLurking() : storeLurking;
        this(j, api, lurking, (i & 8) != 0 ? LeaveGuildDialogViewModel$Companion.access$observeStoreState(Companion, j, StoreStream.Companion.getGuilds(), lurking) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(LeaveGuildDialogViewModel leaveGuildDialogViewModel, LeaveGuildDialogViewModel$StoreState leaveGuildDialogViewModel$StoreState) {
        leaveGuildDialogViewModel.handleStoreState(leaveGuildDialogViewModel$StoreState);
    }

    public static final /* synthetic */ void access$onLeaveFailed(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
        leaveGuildDialogViewModel.onLeaveFailed();
    }

    public static final /* synthetic */ void access$onLeaveSucceeded(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
        leaveGuildDialogViewModel.onLeaveSucceeded();
    }

    @MainThread
    private final void handleStoreState(LeaveGuildDialogViewModel$StoreState storeState) {
        LeaveGuildDialogViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof LeaveGuildDialogViewModel$ViewState$Valid)) {
            viewState = null;
        }
        LeaveGuildDialogViewModel$ViewState$Valid leaveGuildDialogViewModel$ViewState$Valid = (LeaveGuildDialogViewModel$ViewState$Valid) viewState;
        boolean zIsLoading = leaveGuildDialogViewModel$ViewState$Valid != null ? leaveGuildDialogViewModel$ViewState$Valid.isLoading() : false;
        if (storeState instanceof LeaveGuildDialogViewModel$StoreState$Valid) {
            LeaveGuildDialogViewModel$StoreState$Valid leaveGuildDialogViewModel$StoreState$Valid = (LeaveGuildDialogViewModel$StoreState$Valid) storeState;
            updateViewState(new LeaveGuildDialogViewModel$ViewState$Valid(leaveGuildDialogViewModel$StoreState$Valid.getGuild(), zIsLoading, leaveGuildDialogViewModel$StoreState$Valid.isLurking()));
        } else if (m.areEqual(storeState, LeaveGuildDialogViewModel$StoreState$Invalid.INSTANCE)) {
            updateViewState(LeaveGuildDialogViewModel$ViewState$Invalid.INSTANCE);
        }
    }

    @MainThread
    private final void onLeaveFailed() {
        LeaveGuildDialogViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof LeaveGuildDialogViewModel$ViewState$Valid)) {
            viewState = null;
        }
        LeaveGuildDialogViewModel$ViewState$Valid leaveGuildDialogViewModel$ViewState$Valid = (LeaveGuildDialogViewModel$ViewState$Valid) viewState;
        if (leaveGuildDialogViewModel$ViewState$Valid != null) {
            updateViewState(LeaveGuildDialogViewModel$ViewState$Valid.copy$default(leaveGuildDialogViewModel$ViewState$Valid, null, false, false, 5, null));
        }
    }

    @MainThread
    private final void onLeaveSucceeded() {
        PublishSubject<LeaveGuildDialogViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(LeaveGuildDialogViewModel$Event$Dismiss.INSTANCE);
    }

    @MainThread
    public final void leaveGuild() {
        LeaveGuildDialogViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof LeaveGuildDialogViewModel$ViewState$Valid)) {
            viewState = null;
        }
        LeaveGuildDialogViewModel$ViewState$Valid leaveGuildDialogViewModel$ViewState$Valid = (LeaveGuildDialogViewModel$ViewState$Valid) viewState;
        if (leaveGuildDialogViewModel$ViewState$Valid != null) {
            updateViewState(LeaveGuildDialogViewModel$ViewState$Valid.copy$default(leaveGuildDialogViewModel$ViewState$Valid, null, true, false, 5, null));
            if (leaveGuildDialogViewModel$ViewState$Valid.isLurking()) {
                this.lurkingStore.stopLurking(leaveGuildDialogViewModel$ViewState$Valid.getGuild().getId(), new LeaveGuildDialogViewModel$leaveGuild$1(this), new LeaveGuildDialogViewModel$leaveGuild$2(this));
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(this.guildId), false, 1, null), this, null, 2, null), LeaveGuildDialogViewModel.class, (Context) null, (Function1) null, new LeaveGuildDialogViewModel$leaveGuild$4(this), (Function0) null, (Function0) null, new LeaveGuildDialogViewModel$leaveGuild$3(this), 54, (Object) null);
        }
    }

    public final Observable<LeaveGuildDialogViewModel$Event> observeEvents() {
        PublishSubject<LeaveGuildDialogViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaveGuildDialogViewModel(long j, RestAPI restAPI, StoreLurking storeLurking, Observable<LeaveGuildDialogViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeLurking, "lurkingStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        this.lurkingStore = storeLurking;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), LeaveGuildDialogViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new LeaveGuildDialogViewModel$1(this), 62, (Object) null);
    }
}
