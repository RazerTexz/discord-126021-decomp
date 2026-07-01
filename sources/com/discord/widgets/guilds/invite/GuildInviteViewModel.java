package com.discord.widgets.guilds.invite;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.app.AppComponent;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings$InviteCode;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildInviteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteViewModel extends d0<GuildInviteViewModel$ViewState> implements AppComponent {
    public static final GuildInviteViewModel$Companion Companion = new GuildInviteViewModel$Companion(null);
    private final StoreInstantInvites instantInvitesStore;
    private final StoreInviteSettings$InviteCode inviteCode;
    private boolean inviteResolved;
    private final Observable<GuildInviteViewModel$StoreState> storeStateObservable;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildInviteViewModel(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, StoreInstantInvites storeInstantInvites, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeInstantInvites = (i & 2) != 0 ? StoreStream.Companion.getInstantInvites() : storeInstantInvites;
        this(storeInviteSettings$InviteCode, storeInstantInvites, (i & 4) != 0 ? GuildInviteViewModel$Companion.access$observeStoreState(Companion, storeInstantInvites, storeInviteSettings$InviteCode) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildInviteViewModel guildInviteViewModel, GuildInviteViewModel$StoreState guildInviteViewModel$StoreState) {
        guildInviteViewModel.handleStoreState(guildInviteViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(GuildInviteViewModel$StoreState storeState) {
        if (storeState instanceof GuildInviteViewModel$StoreState$Loading) {
            updateViewState(GuildInviteViewModel$ViewState$Loading.INSTANCE);
        } else if (storeState instanceof GuildInviteViewModel$StoreState$Invalid) {
            updateViewState(GuildInviteViewModel$ViewState$Invalid.INSTANCE);
        } else if (storeState instanceof GuildInviteViewModel$StoreState$Loaded) {
            updateViewState(new GuildInviteViewModel$ViewState$Loaded(((GuildInviteViewModel$StoreState$Loaded) storeState).getInvite()));
        }
    }

    public final void fetchInviteIfNotLoaded() {
        if (this.inviteCode == null) {
            return;
        }
        StoreStream.Companion.getInstantInvites().fetchInviteIfNotLoaded(this.inviteCode.getInviteCode(), this.inviteCode.getEventId(), this.inviteCode.getSource(), Boolean.valueOf(this.inviteResolved), new GuildInviteViewModel$fetchInviteIfNotLoaded$1(this));
    }

    public final StoreInviteSettings$InviteCode getInviteCode() {
        return this.inviteCode;
    }

    public final boolean getInviteResolved() {
        return this.inviteResolved;
    }

    public final Observable<GuildInviteViewModel$StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final void setInviteResolved(boolean z2) {
        this.inviteResolved = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteViewModel(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, StoreInstantInvites storeInstantInvites, Observable<GuildInviteViewModel$StoreState> observable) {
        super(GuildInviteViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeInstantInvites, "instantInvitesStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.inviteCode = storeInviteSettings$InviteCode;
        this.instantInvitesStore = storeInstantInvites;
        this.storeStateObservable = observable;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildInviteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildInviteViewModel$1(this), 62, (Object) null);
    }
}
