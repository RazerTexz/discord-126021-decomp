package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import com.discord.R$plurals;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.PayoutStatus;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.permission.Permission;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.ModelSubscription$SubscriptionItem;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.widgets.servers.guild_role_subscription.model.PayoutStatusMedia;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtilsKt {
    public static final CharSequence getFormattedLabel(SubscriptionTrialInterval subscriptionTrialInterval, Context context) {
        m.checkNotNullParameter(subscriptionTrialInterval, "$this$getFormattedLabel");
        m.checkNotNullParameter(context, "context");
        int iOrdinal = subscriptionTrialInterval.getInterval().ordinal();
        if (iOrdinal == 0) {
            return StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_months_capitalize_months, subscriptionTrialInterval.getIntervalCount(), Integer.valueOf(subscriptionTrialInterval.getIntervalCount()));
        }
        if (iOrdinal == 1) {
            return StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_years_capitalize_years, subscriptionTrialInterval.getIntervalCount(), Integer.valueOf(subscriptionTrialInterval.getIntervalCount()));
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (subscriptionTrialInterval.getIntervalCount() <= 0 || subscriptionTrialInterval.getIntervalCount() % 7 != 0) {
            return StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_days_capitalize_days, subscriptionTrialInterval.getIntervalCount(), Integer.valueOf(subscriptionTrialInterval.getIntervalCount()));
        }
        int intervalCount = subscriptionTrialInterval.getIntervalCount() / 7;
        return StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_weeks_capitalize_weeks, intervalCount, Integer.valueOf(intervalCount));
    }

    public static final Boolean getFullServerGatingOverwrite(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Map<Long, GuildRole> map) {
        Boolean boolValueOf;
        m.checkNotNullParameter(guildRoleSubscriptionGroupListing, "$this$getFullServerGatingOverwrite");
        List<GuildRoleSubscriptionTierListing> listH = guildRoleSubscriptionGroupListing.h();
        if (listH != null) {
            boolean z2 = false;
            if (!listH.isEmpty()) {
                Iterator<T> it = listH.iterator();
                while (it.hasNext()) {
                    if (((GuildRoleSubscriptionTierListing) it.next()).getPublished()) {
                        z2 = true;
                        break;
                    }
                }
            }
            boolValueOf = Boolean.valueOf(z2);
        } else {
            boolValueOf = null;
        }
        if (boolValueOf == null || !boolValueOf.booleanValue()) {
            return null;
        }
        return Boolean.valueOf(!PermissionUtils.INSTANCE.canRole(Permission.VIEW_CHANNEL, map != null ? map.get(Long.valueOf(guildRoleSubscriptionGroupListing.getGuildId())) : null, null));
    }

    public static final int getPrice(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        m.checkNotNullParameter(guildRoleSubscriptionTierListing, "$this$getPrice");
        SubscriptionPlan subscriptionPlan = (SubscriptionPlan) u.getOrNull(guildRoleSubscriptionTierListing.i(), 0);
        if (subscriptionPlan != null) {
            return subscriptionPlan.getPrice();
        }
        return 0;
    }

    public static final PayoutStatusMedia getStatusMedia(PayoutStatus payoutStatus) {
        m.checkNotNullParameter(payoutStatus, "$this$getStatusMedia");
        switch (payoutStatus) {
            case UNKNOWN:
            case ERROR:
                return new PayoutStatusMedia(2131231677, 2131890478);
            case OPEN:
            case PENDING:
            case MANUAL:
            case PROCESSING:
            case SUBMITTED:
            case PENDING_FUNDS:
                return new PayoutStatusMedia(2131231997, 2131890483);
            case PAID:
                return new PayoutStatusMedia(2131231994, 2131890479);
            case CANCELED:
                return new PayoutStatusMedia(2131231677, 2131890476);
            case DEFERRED:
                return new PayoutStatusMedia(2131231677, 2131890476);
            case DEFERRED_INTERNAL:
                return new PayoutStatusMedia(2131231677, 2131890477);
            case REJECTED:
                return new PayoutStatusMedia(2131231677, 2131890481);
            case RISK_REVIEW:
                return new PayoutStatusMedia(2131231677, 2131890482);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean hasUserActiveSubscriptionFor(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<ModelSubscription> list) {
        m.checkNotNullParameter(guildRoleSubscriptionGroupListing, "$this$hasUserActiveSubscriptionFor");
        m.checkNotNullParameter(list, "userSubscriptions");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ModelSubscription$SubscriptionItem modelSubscription$SubscriptionItem = (ModelSubscription$SubscriptionItem) u.getOrNull(((ModelSubscription) it.next()).getItems(), 0);
            Long lValueOf = modelSubscription$SubscriptionItem != null ? Long.valueOf(modelSubscription$SubscriptionItem.getPlanId()) : null;
            if (lValueOf != null) {
                arrayList.add(lValueOf);
            }
        }
        Set set = u.toSet(arrayList);
        List<GuildRoleSubscriptionTierListing> listH = guildRoleSubscriptionGroupListing.h();
        if (listH != null) {
            Iterator<T> it2 = listH.iterator();
            while (it2.hasNext()) {
                SubscriptionPlan subscriptionPlan = (SubscriptionPlan) u.getOrNull(((GuildRoleSubscriptionTierListing) it2.next()).i(), 0);
                Long lValueOf2 = subscriptionPlan != null ? Long.valueOf(subscriptionPlan.getId()) : null;
                if (lValueOf2 != null && set.contains(lValueOf2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
