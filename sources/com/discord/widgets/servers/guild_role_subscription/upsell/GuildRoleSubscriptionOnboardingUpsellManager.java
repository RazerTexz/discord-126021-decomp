package com.discord.widgets.servers.guild_role_subscription.upsell;

import android.content.SharedPreferences;
import com.discord.api.guild.GuildFeature;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.servers.creator_monetization_eligibility.CreatorMonetizationCountryAllowlist;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GuildRoleSubscriptionOnboardingUpsellManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionOnboardingUpsellManager {
    public static final String SHOWN_CACHE_KEY = "HAS_GUILD_ROLE_SUBSCRIPTION_UPSELL_BEEN_SHOWN";
    private final CreatorMonetizationCountryAllowlist countryAllowlist;
    private final GuildRoleSubscriptionsFeatureFlag featureFlag;
    private final SharedPreferences sharedPreferences;
    private final StorePermissions storePermissions;
    private final StoreUser storeUser;

    public GuildRoleSubscriptionOnboardingUpsellManager(SharedPreferences sharedPreferences, StorePermissions storePermissions, StoreUser storeUser, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.sharedPreferences = sharedPreferences;
        this.storePermissions = storePermissions;
        this.storeUser = storeUser;
        this.featureFlag = new GuildRoleSubscriptionsFeatureFlag(storeExperiments, storeGuilds, storeUser, storePermissions, null, 16, null);
        this.countryAllowlist = new CreatorMonetizationCountryAllowlist(storeExperiments);
    }

    private final boolean hasBeenShown() {
        return this.sharedPreferences.getBoolean(SHOWN_CACHE_KEY, false);
    }

    public final boolean canShow(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return (hasBeenShown() || guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE) || guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE_DISABLED) || !this.featureFlag.canGuildSeeGuildRoleSubscriptionSettings(guild.getId(), this.countryAllowlist)) ? false : true;
    }

    public final void setHasBeenShown() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(SHOWN_CACHE_KEY, true);
        editorEdit.apply();
    }
}
