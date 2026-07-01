package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel$Companion$observeStores$1 extends o implements Function0<ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $guilds;
    public final /* synthetic */ StoreUser $users;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel$Companion$observeStores$1(StoreGuilds storeGuilds, long j, StoreUser storeUser) {
        super(0);
        this.$guilds = storeGuilds;
        this.$guildId = j;
        this.$users = storeUser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState invoke() {
        Guild guild = this.$guilds.getGuild(this.$guildId);
        return new ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState(guild, guild != null && guild.isOwner(this.$users.getMeSnapshot().getId()));
    }
}
