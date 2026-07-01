package com.discord.widgets.servers.community;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunityViewModel$Companion {
    private WidgetServerSettingsEnableCommunityViewModel$Companion() {
    }

    private final Observable<WidgetServerSettingsEnableCommunityViewModel$StoreState> observeStoreState(long guildId, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, StoreUser storeUsers) {
        Observable observableY = storeGuilds.observeGuild(guildId).Y(new WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1(storeUsers, storePermissions, guildId, storeChannels));
        m.checkNotNullExpressionValue(observableY, "storeGuilds.observeGuild…      }\n        }\n      }");
        return observableY;
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetServerSettingsEnableCommunityViewModel$Companion widgetServerSettingsEnableCommunityViewModel$Companion, long j, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, StoreUser storeUser, int i, Object obj) {
        if ((i & 2) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        StoreGuilds storeGuilds2 = storeGuilds;
        if ((i & 4) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        StoreChannels storeChannels2 = storeChannels;
        if ((i & 8) != 0) {
            storePermissions = StoreStream.Companion.getPermissions();
        }
        StorePermissions storePermissions2 = storePermissions;
        if ((i & 16) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        return widgetServerSettingsEnableCommunityViewModel$Companion.observeStoreState(j, storeGuilds2, storeChannels2, storePermissions2, storeUser);
    }

    public /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
