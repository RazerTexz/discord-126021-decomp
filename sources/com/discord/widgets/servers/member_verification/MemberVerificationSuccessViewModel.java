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

/* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessViewModel extends d0<MemberVerificationSuccessViewModel$ViewState> {
    public static final MemberVerificationSuccessViewModel$Companion Companion = new MemberVerificationSuccessViewModel$Companion(null);
    private final PublishSubject<MemberVerificationSuccessViewModel$Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;

    public /* synthetic */ MemberVerificationSuccessViewModel(long j, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 4) != 0 ? MemberVerificationSuccessViewModel$Companion.access$observeStores(Companion, j) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(MemberVerificationSuccessViewModel memberVerificationSuccessViewModel) {
        return memberVerificationSuccessViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(MemberVerificationSuccessViewModel memberVerificationSuccessViewModel, MemberVerificationSuccessViewModel$StoreState memberVerificationSuccessViewModel$StoreState) {
        memberVerificationSuccessViewModel.handleStoreState(memberVerificationSuccessViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(MemberVerificationSuccessViewModel$StoreState storeState) {
        if (storeState.getLastSeen() != null) {
            updateViewState(MemberVerificationSuccessViewModel$ViewState$Acked.INSTANCE);
        } else {
            updateViewState(new MemberVerificationSuccessViewModel$ViewState$Loaded(storeState.getGuildName()));
        }
    }

    public final void ackGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationSuccessViewModel.class, (Context) null, (Function1) null, new MemberVerificationSuccessViewModel$ackGuildJoinRequest$1(this), (Function0) null, (Function0) null, new MemberVerificationSuccessViewModel$ackGuildJoinRequest$2(this), 54, (Object) null);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationSuccessViewModel(long j, RestAPI restAPI, Observable<MemberVerificationSuccessViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        PublishSubject<MemberVerificationSuccessViewModel$Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), MemberVerificationSuccessViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new MemberVerificationSuccessViewModel$1(this), 62, (Object) null);
    }
}
