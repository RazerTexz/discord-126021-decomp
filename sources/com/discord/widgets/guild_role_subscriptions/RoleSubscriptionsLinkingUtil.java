package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.stores.StoreStream;
import com.discord.utilities.handoff.MobileWebHandoff;
import com.discord.utilities.intent.StaticChannelRoutes;
import com.discord.utilities.intent.StaticChannelRoutes$WithGuild;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: RoleSubscriptionsLinkingUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleSubscriptionsLinkingUtil {
    public static final RoleSubscriptionsLinkingUtil INSTANCE = new RoleSubscriptionsLinkingUtil();

    private RoleSubscriptionsLinkingUtil() {
    }

    private final RoleSubscriptionsLinkingUtil$HandoffEligibility getHandoffEligibility(long guildId) {
        if (guildId == 0 || StoreStream.Companion.getGuilds().getGuild(guildId) == null) {
            return RoleSubscriptionsLinkingUtil$HandoffEligibility.UNKNOWN_GUILD;
        }
        GuildRoleSubscriptionsFeatureFlag$Companion guildRoleSubscriptionsFeatureFlag$Companion = GuildRoleSubscriptionsFeatureFlag.Companion;
        if (guildRoleSubscriptionsFeatureFlag$Companion.getINSTANCE().canGuildSeePremiumMemberships(guildId)) {
            return !guildRoleSubscriptionsFeatureFlag$Companion.getINSTANCE().canGuildAccessMobileWebPurchases(guildId) ? RoleSubscriptionsLinkingUtil$HandoffEligibility.INELIGIBLE_FOR_MOBILE_WEB_PURCHASE : RoleSubscriptionsLinkingUtil$HandoffEligibility.ELIGIBLE;
        }
        return RoleSubscriptionsLinkingUtil$HandoffEligibility.INELIGIBLE_FOR_ROLE_SUBSCRIPTIONS;
    }

    private final boolean performHandoff(Context context, String url) {
        return MobileWebHandoff.tryLaunchRedirectTo$default(new MobileWebHandoff(context, null, null, null, 14, null), url, false, true, 2, null);
    }

    public final RoleSubscriptionsLinkingUtil$HandoffResult handoffToGuildRoleSubscriptions(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        int iOrdinal = getHandoffEligibility(guildId).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2) {
                b.a.d.m.g(context, 2131892026, 0, null, 12);
                return RoleSubscriptionsLinkingUtil$HandoffResult.INELIGIBLE;
            }
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            WidgetGuildRoleSubscriptionEntryPoint.Companion.launch(context, guildId, "Role Subscriptions Tab");
            return RoleSubscriptionsLinkingUtil$HandoffResult.INELIGIBLE;
        }
        boolean zPerformHandoff = performHandoff(context, "/channels/" + guildId + MentionUtilsKt.SLASH_CHAR + StaticChannelRoutes.ROLE_SUBSCRIPTIONS.getRoute());
        if (zPerformHandoff) {
            return RoleSubscriptionsLinkingUtil$HandoffResult.SUCCESS;
        }
        if (zPerformHandoff) {
            throw new NoWhenBranchMatchedException();
        }
        return RoleSubscriptionsLinkingUtil$HandoffResult.FAILURE;
    }

    public final boolean tryPerformHandoff(Context context, Uri uri) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        StaticChannelRoutes$WithGuild staticChannelRoutes$WithGuildExtractStaticRoute = StaticChannelRoutes.Companion.extractStaticRoute(uri);
        if (staticChannelRoutes$WithGuildExtractStaticRoute != null) {
            return staticChannelRoutes$WithGuildExtractStaticRoute.getRoute() == StaticChannelRoutes.ROLE_SUBSCRIPTIONS && handoffToGuildRoleSubscriptions(context, staticChannelRoutes$WithGuildExtractStaticRoute.getGuildId()) != RoleSubscriptionsLinkingUtil$HandoffResult.FAILURE;
        }
        return false;
    }
}
