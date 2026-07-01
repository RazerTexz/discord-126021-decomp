package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.stores.StoreStream;
import com.discord.utilities.handoff.MobileWebHandoff;
import com.discord.utilities.intent.StaticChannelRoutes;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: RoleSubscriptionsLinkingUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleSubscriptionsLinkingUtil {
    public static final RoleSubscriptionsLinkingUtil INSTANCE = new RoleSubscriptionsLinkingUtil();

    /* JADX INFO: compiled from: RoleSubscriptionsLinkingUtil.kt */
    public enum HandoffEligibility {
        ELIGIBLE,
        UNKNOWN_GUILD,
        INELIGIBLE_FOR_ROLE_SUBSCRIPTIONS,
        INELIGIBLE_FOR_MOBILE_WEB_PURCHASE
    }

    /* JADX INFO: compiled from: RoleSubscriptionsLinkingUtil.kt */
    public enum HandoffResult {
        SUCCESS,
        FAILURE,
        INELIGIBLE
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            HandoffEligibility.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[HandoffEligibility.UNKNOWN_GUILD.ordinal()] = 1;
            iArr[HandoffEligibility.INELIGIBLE_FOR_ROLE_SUBSCRIPTIONS.ordinal()] = 2;
            iArr[HandoffEligibility.INELIGIBLE_FOR_MOBILE_WEB_PURCHASE.ordinal()] = 3;
            iArr[HandoffEligibility.ELIGIBLE.ordinal()] = 4;
        }
    }

    private RoleSubscriptionsLinkingUtil() {
    }

    private final HandoffEligibility getHandoffEligibility(long guildId) {
        if (guildId == 0 || StoreStream.INSTANCE.getGuilds().getGuild(guildId) == null) {
            return HandoffEligibility.UNKNOWN_GUILD;
        }
        GuildRoleSubscriptionsFeatureFlag.Companion companion = GuildRoleSubscriptionsFeatureFlag.INSTANCE;
        if (companion.getINSTANCE().canGuildSeePremiumMemberships(guildId)) {
            return !companion.getINSTANCE().canGuildAccessMobileWebPurchases(guildId) ? HandoffEligibility.INELIGIBLE_FOR_MOBILE_WEB_PURCHASE : HandoffEligibility.ELIGIBLE;
        }
        return HandoffEligibility.INELIGIBLE_FOR_ROLE_SUBSCRIPTIONS;
    }

    private final boolean performHandoff(Context context, String url) {
        return MobileWebHandoff.tryLaunchRedirectTo$default(new MobileWebHandoff(context, null, null, null, 14, null), url, false, true, 2, null);
    }

    public final HandoffResult handoffToGuildRoleSubscriptions(Context context, long guildId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        int iOrdinal = getHandoffEligibility(guildId).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2) {
                AppToast.g(context, R.string.inaccessible_channel_link_title, 0, null, 12);
                return HandoffResult.INELIGIBLE;
            }
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            WidgetGuildRoleSubscriptionEntryPoint.INSTANCE.launch(context, guildId, "Role Subscriptions Tab");
            return HandoffResult.INELIGIBLE;
        }
        boolean zPerformHandoff = performHandoff(context, "/channels/" + guildId + MentionUtils.SLASH_CHAR + StaticChannelRoutes.ROLE_SUBSCRIPTIONS.getRoute());
        if (zPerformHandoff) {
            return HandoffResult.SUCCESS;
        }
        if (zPerformHandoff) {
            throw new NoWhenBranchMatchedException();
        }
        return HandoffResult.FAILURE;
    }

    public final boolean tryPerformHandoff(Context context, Uri uri) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        StaticChannelRoutes.WithGuild withGuildExtractStaticRoute = StaticChannelRoutes.INSTANCE.extractStaticRoute(uri);
        if (withGuildExtractStaticRoute != null) {
            return withGuildExtractStaticRoute.getRoute() == StaticChannelRoutes.ROLE_SUBSCRIPTIONS && handoffToGuildRoleSubscriptions(context, withGuildExtractStaticRoute.getGuildId()) != HandoffResult.FAILURE;
        }
        return false;
    }
}
