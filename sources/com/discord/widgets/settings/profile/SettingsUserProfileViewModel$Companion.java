package com.discord.widgets.settings.profile;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$Companion {
    private SettingsUserProfileViewModel$Companion() {
    }

    private final Observable<SettingsUserProfileViewModel$StoreState> observeStoreState(Long guildId, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserProfile storeUserProfile) {
        Observable<SettingsUserProfileViewModel$StoreState> observableY = Observable.j(StoreUser.observeMe$default(storeUser, false, 1, null), storeGuilds.observeGuild(guildId != null ? guildId.longValue() : -1L), SettingsUserProfileViewModel$Companion$observeStoreState$1.INSTANCE).Y(new SettingsUserProfileViewModel$Companion$observeStoreState$2(storeUserProfile, storeGuilds, guildId));
        m.checkNotNullExpressionValue(observableY, "Observable.combineLatest…      )\n        }\n      }");
        return observableY;
    }

    public static /* synthetic */ Observable observeStoreState$default(SettingsUserProfileViewModel$Companion settingsUserProfileViewModel$Companion, Long l, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserProfile storeUserProfile, int i, Object obj) {
        if ((i & 2) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        if ((i & 4) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        if ((i & 8) != 0) {
            storeUserProfile = StoreStream.Companion.getUserProfile();
        }
        return settingsUserProfileViewModel$Companion.observeStoreState(l, storeUser, storeGuilds, storeUserProfile);
    }

    public /* synthetic */ SettingsUserProfileViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
