package com.discord.widgets.guilds.invite;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel$Companion {
    private GuildInviteShareSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(GuildInviteShareSheetViewModel$Companion guildInviteShareSheetViewModel$Companion, long j, InviteSuggestionsManager inviteSuggestionsManager, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreStageInstances storeStageInstances) {
        return guildInviteShareSheetViewModel$Companion.observeStoreState(j, inviteSuggestionsManager, storeInviteSettings, storeUser, storeChannels, storeGuilds, storeStageInstances);
    }

    private final Observable<GuildInviteShareSheetViewModel$StoreState> observeStoreState(long guildId, InviteSuggestionsManager inviteSuggestionsManager, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreStageInstances storeStageInstances) {
        Observable<GuildInviteShareSheetViewModel$StoreState> observableE = Observable.e(storeInviteSettings.getInviteSettings(), storeInviteSettings.getInvitableChannels(guildId), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannels.observeDMs(), storeGuilds.observeGuild(guildId), inviteSuggestionsManager.observeInviteSuggestions(), storeStageInstances.observeStageInstancesForGuild(guildId), GuildInviteShareSheetViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableE, "Observable.combineLatest…      )\n        }\n      }");
        return observableE;
    }

    public /* synthetic */ GuildInviteShareSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
