package com.discord.widgets.guilds.invite;

import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings$InviteCode;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildInviteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteViewModel$Companion {
    private GuildInviteViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(GuildInviteViewModel$Companion guildInviteViewModel$Companion, StoreInstantInvites storeInstantInvites, StoreInviteSettings$InviteCode storeInviteSettings$InviteCode) {
        return guildInviteViewModel$Companion.observeStoreState(storeInstantInvites, storeInviteSettings$InviteCode);
    }

    private final Observable<GuildInviteViewModel$StoreState> observeStoreState(StoreInstantInvites instantInvitesStore, StoreInviteSettings$InviteCode inviteCode) {
        if (inviteCode == null) {
            k kVar = new k(GuildInviteViewModel$StoreState$Invalid.INSTANCE);
            m.checkNotNullExpressionValue(kVar, "Observable.just(StoreState.Invalid)");
            return kVar;
        }
        Observable observableG = instantInvitesStore.observeInvite(ModelInvite.getInviteStoreKey(inviteCode.getInviteCode(), inviteCode.getEventId())).G(GuildInviteViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "instantInvitesStore\n    …            }\n          }");
        return observableG;
    }

    public /* synthetic */ GuildInviteViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
