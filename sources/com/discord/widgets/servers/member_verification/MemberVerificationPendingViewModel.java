package com.discord.widgets.servers.member_verification;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingViewModel extends d0<MemberVerificationPendingViewModel$ViewState> {
    public static final MemberVerificationPendingViewModel$Companion Companion = new MemberVerificationPendingViewModel$Companion(null);
    private final MemberVerificationPendingViewModel$DialogState dialogState;
    private final PublishSubject<MemberVerificationPendingViewModel$Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;

    public /* synthetic */ MemberVerificationPendingViewModel(long j, MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, memberVerificationPendingViewModel$DialogState, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 8) != 0 ? MemberVerificationPendingViewModel$Companion.access$observeStores(Companion, j) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(MemberVerificationPendingViewModel memberVerificationPendingViewModel) {
        return memberVerificationPendingViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(MemberVerificationPendingViewModel memberVerificationPendingViewModel, MemberVerificationPendingViewModel$StoreState memberVerificationPendingViewModel$StoreState) {
        memberVerificationPendingViewModel.handleStoreState(memberVerificationPendingViewModel$StoreState);
    }

    public static final /* synthetic */ void access$onResetSuccess(MemberVerificationPendingViewModel memberVerificationPendingViewModel) {
        memberVerificationPendingViewModel.onResetSuccess();
    }

    @MainThread
    private final void handleStoreState(MemberVerificationPendingViewModel$StoreState storeState) {
        MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState = this.dialogState;
        if (memberVerificationPendingViewModel$DialogState == null) {
            int iOrdinal = storeState.getApplicationStatus().ordinal();
            if (iOrdinal != 1) {
                memberVerificationPendingViewModel$DialogState = iOrdinal != 2 ? null : MemberVerificationPendingViewModel$DialogState.REJECTED;
            } else {
                memberVerificationPendingViewModel$DialogState = storeState.isPreviewEnabled() ? MemberVerificationPendingViewModel$DialogState.CANCEL : MemberVerificationPendingViewModel$DialogState.PENDING;
            }
        }
        MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState2 = memberVerificationPendingViewModel$DialogState;
        if (storeState.isFormOutdated()) {
            updateViewState(new MemberVerificationPendingViewModel$ViewState$Loaded(MemberVerificationPendingViewModel$DialogState.UPGRADE, true, false, storeState.isPreviewEnabled(), storeState.getRejectionReason()));
        } else if (memberVerificationPendingViewModel$DialogState2 != null) {
            updateViewState(new MemberVerificationPendingViewModel$ViewState$Loaded(memberVerificationPendingViewModel$DialogState2, true, false, storeState.isPreviewEnabled(), storeState.getRejectionReason()));
        }
    }

    private final void onResetSuccess() {
        PublishSubject<MemberVerificationPendingViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(MemberVerificationPendingViewModel$Event$Success.INSTANCE);
    }

    public final void deleteGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.deleteGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new MemberVerificationPendingViewModel$deleteGuildJoinRequest$1(this), (Function0) null, (Function0) null, new MemberVerificationPendingViewModel$deleteGuildJoinRequest$2(this), 54, (Object) null);
    }

    public final void leaveGuild() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new MemberVerificationPendingViewModel$leaveGuild$1(this), (Function0) null, (Function0) null, new MemberVerificationPendingViewModel$leaveGuild$2(this), 54, (Object) null);
    }

    public final Observable<MemberVerificationPendingViewModel$Event> observeEvents() {
        return this.eventSubject;
    }

    public final void resetGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.resetGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new MemberVerificationPendingViewModel$resetGuildJoinRequest$1(this), (Function0) null, (Function0) null, new MemberVerificationPendingViewModel$resetGuildJoinRequest$2(this), 54, (Object) null);
    }

    public final void updateDialogState(MemberVerificationPendingViewModel$DialogState dialogState) {
        m.checkNotNullParameter(dialogState, "dialogState");
        MemberVerificationPendingViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof MemberVerificationPendingViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        MemberVerificationPendingViewModel$ViewState$Loaded memberVerificationPendingViewModel$ViewState$Loaded = (MemberVerificationPendingViewModel$ViewState$Loaded) viewState;
        if (memberVerificationPendingViewModel$ViewState$Loaded != null) {
            MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState = MemberVerificationPendingViewModel$DialogState.PENDING;
            updateViewState(MemberVerificationPendingViewModel$ViewState$Loaded.copy$default(memberVerificationPendingViewModel$ViewState$Loaded, dialogState, dialogState == memberVerificationPendingViewModel$DialogState, dialogState == memberVerificationPendingViewModel$DialogState && !memberVerificationPendingViewModel$ViewState$Loaded.isPreviewEnabled(), false, null, 24, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingViewModel(long j, MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState, RestAPI restAPI, Observable<MemberVerificationPendingViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.dialogState = memberVerificationPendingViewModel$DialogState;
        this.restAPI = restAPI;
        PublishSubject<MemberVerificationPendingViewModel$Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new MemberVerificationPendingViewModel$1(this), 62, (Object) null);
    }
}
