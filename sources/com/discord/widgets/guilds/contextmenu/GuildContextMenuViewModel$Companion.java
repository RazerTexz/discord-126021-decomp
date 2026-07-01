package com.discord.widgets.guilds.contextmenu;

import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildContextMenuViewModel$Companion {
    private GuildContextMenuViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(GuildContextMenuViewModel$Companion guildContextMenuViewModel$Companion, long j, StoreGuilds storeGuilds, StoreUser storeUser, StoreReadStates storeReadStates, StoreGuildSelected storeGuildSelected) {
        return guildContextMenuViewModel$Companion.observeStoreState(j, storeGuilds, storeUser, storeReadStates, storeGuildSelected);
    }

    private final Observable<GuildContextMenuViewModel$StoreState> observeStoreState(long guildId, StoreGuilds guildStore, StoreUser userStore, StoreReadStates readStateStore, StoreGuildSelected selectedGuildStore) {
        Observable<GuildContextMenuViewModel$StoreState> observableH = Observable.h(guildStore.observeGuild(guildId), StoreUser.observeMe$default(userStore, false, 1, null), readStateStore.getIsUnread(guildId), selectedGuildStore.observeSelectedGuildId(), GuildContextMenuViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…      )\n        }\n      }");
        return observableH;
    }

    public /* synthetic */ GuildContextMenuViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
