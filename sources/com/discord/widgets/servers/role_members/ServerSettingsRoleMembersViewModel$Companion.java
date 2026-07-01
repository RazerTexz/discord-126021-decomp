package com.discord.widgets.servers.role_members;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel$Companion {
    private ServerSettingsRoleMembersViewModel$Companion() {
    }

    private final Observable<ServerSettingsRoleMembersViewModel$StoreState> observeGuildRoleMembers(long guildId, long guildRoleId, StoreGuilds storeGuilds, StoreUser storeUser, ObservationDeck observationDeck) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeGuilds, storeUser}, false, null, null, new ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1(storeGuilds, guildId, guildRoleId, storeUser), 14, null);
    }

    public final Observable<ServerSettingsRoleMembersViewModel$StoreState> observeStoreState(long guildId, long guildRoleId, BehaviorSubject<String> searchFilterSubject, StoreGuilds storeGuilds, StoreUser storeUser, ObservationDeck observationDeck) {
        m.checkNotNullParameter(searchFilterSubject, "searchFilterSubject");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        Observable<ServerSettingsRoleMembersViewModel$StoreState> observableJ = Observable.j(searchFilterSubject.r(), observeGuildRoleMembers(guildId, guildRoleId, storeGuilds, storeUser, observationDeck), ServerSettingsRoleMembersViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…eredGuildMembers)\n      }");
        return observableJ;
    }

    public /* synthetic */ ServerSettingsRoleMembersViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
