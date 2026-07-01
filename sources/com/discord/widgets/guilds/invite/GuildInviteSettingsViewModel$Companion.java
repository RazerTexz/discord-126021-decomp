package com.discord.widgets.guilds.invite;

import com.discord.stores.StoreInviteSettings;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteSettingsViewModel$Companion {
    private GuildInviteSettingsViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(GuildInviteSettingsViewModel$Companion guildInviteSettingsViewModel$Companion, long j, StoreInviteSettings storeInviteSettings) {
        return guildInviteSettingsViewModel$Companion.observeStoreState(j, storeInviteSettings);
    }

    private final Observable<GuildInviteSettingsViewModel$StoreState> observeStoreState(long guildId, StoreInviteSettings storeInviteSettings) {
        Observable<GuildInviteSettingsViewModel$StoreState> observableJ = Observable.j(storeInviteSettings.getInviteSettings(), storeInviteSettings.getInvitableChannels(guildId), GuildInviteSettingsViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…hannels\n        )\n      }");
        return observableJ;
    }

    public /* synthetic */ GuildInviteSettingsViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
