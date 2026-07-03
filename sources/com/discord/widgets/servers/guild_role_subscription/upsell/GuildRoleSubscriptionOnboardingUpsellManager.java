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
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
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
        C12238m.checkNotNullParameter(guild, "guild");
        return (hasBeenShown() || guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE) || guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE_DISABLED) || !this.featureFlag.canGuildSeeGuildRoleSubscriptionSettings(guild.getId(), this.countryAllowlist)) ? false : true;
    }

    public final void setHasBeenShown() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(SHOWN_CACHE_KEY, true);
        editorEdit.apply();
    }
}
