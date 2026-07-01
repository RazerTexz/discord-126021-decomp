package com.discord.widgets.guild_role_subscriptions;

import com.discord.api.guild.GuildFeature;
import com.discord.models.guild.Guild;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionsFeatureFlag$Companion {
    private GuildRoleSubscriptionsFeatureFlag$Companion() {
    }

    public static final /* synthetic */ boolean access$isCreatorMonetizable$p(GuildRoleSubscriptionsFeatureFlag$Companion guildRoleSubscriptionsFeatureFlag$Companion, Guild guild) {
        return guildRoleSubscriptionsFeatureFlag$Companion.isCreatorMonetizable(guild);
    }

    private final boolean isCreatorMonetizable(Guild guild) {
        return guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE) && !guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE_DISABLED);
    }

    public final GuildRoleSubscriptionsFeatureFlag getINSTANCE() {
        Lazy lazyAccess$getINSTANCE$cp = GuildRoleSubscriptionsFeatureFlag.access$getINSTANCE$cp();
        GuildRoleSubscriptionsFeatureFlag$Companion guildRoleSubscriptionsFeatureFlag$Companion = GuildRoleSubscriptionsFeatureFlag.Companion;
        return (GuildRoleSubscriptionsFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
    }

    public /* synthetic */ GuildRoleSubscriptionsFeatureFlag$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
