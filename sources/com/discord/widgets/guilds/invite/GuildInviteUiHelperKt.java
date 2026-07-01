package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import b.a.d.m;
import b.a.k.b;
import com.discord.BuildConfig;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.duration.DurationUtilsKt;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;

/* JADX INFO: compiled from: GuildInviteUiHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteUiHelperKt {
    private static final void copyLink(Context context, String str) {
        m.a(context, str, 2131892298);
    }

    public static final void copyLinkClick(Context context, ModelInvite modelInvite, Intent intent) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        d0.z.d.m.checkNotNullParameter(intent, "mostRecentIntent");
        String stringExtra = intent.getStringExtra("com.discord.intent.ORIGIN_SOURCE");
        if (stringExtra == null) {
            stringExtra = "";
        }
        copyLinkClick(context, modelInvite, stringExtra);
    }

    private static final String getInviteLink(ModelInvite modelInvite, Resources resources) {
        if (modelInvite == null) {
            return BuildConfig.HOST_INVITE;
        }
        String link = modelInvite.toLink(resources, BuildConfig.HOST_INVITE);
        d0.z.d.m.checkNotNullExpressionValue(link, "inviteModel.toLink(resou… BuildConfig.HOST_INVITE)");
        return link;
    }

    public static final CharSequence getInviteLinkText(Context context, Experiment experiment) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        return b.h(context, 2131892302, new Object[]{(experiment == null || experiment.getBucket() != 1) ? StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_days_days, 1, 1) : StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_days_days, 7, 7)}, null, 4);
    }

    public static final CharSequence getInviteSettingsText(Context context, long j, int i) {
        Object quantityString;
        d0.z.d.m.checkNotNullParameter(context, "context");
        if (i == 0) {
            quantityString = context.getString(2131892769);
            d0.z.d.m.checkNotNullExpressionValue(quantityString, "context.getString(R.stri…scription_unlimited_uses)");
        } else {
            Resources resources = context.getResources();
            d0.z.d.m.checkNotNullExpressionValue(resources, "context.resources");
            quantityString = StringResourceUtilsKt.getQuantityString(resources, context, R$plurals.max_uses_description_mobile_maxUses, i, Integer.valueOf(i));
        }
        return j <= 0 ? b.h(context, 2131892323, new Object[]{context.getString(2131892764), quantityString}, null, 4) : b.h(context, 2131892324, new Object[]{DurationUtilsKt.humanizeDurationRounded(context, j), quantityString}, null, 4);
    }

    private static final void shareLink(Context context, String str) {
        String string = context.getResources().getString(2131896415);
        d0.z.d.m.checkNotNullExpressionValue(string, "context.resources.getStr…ip_instant_invite_title3)");
        IntentUtils.performChooserSendIntent(context, str, string);
    }

    public static final void shareLinkClick(Context context, ModelInvite modelInvite) {
        d0.z.d.m.checkNotNullParameter(modelInvite, "invite");
        AnalyticsTracker.inviteShareClicked(modelInvite);
        if (context != null) {
            Resources resources = context.getResources();
            d0.z.d.m.checkNotNullExpressionValue(resources, "context.resources");
            shareLink(context, getInviteLink(modelInvite, resources));
        }
    }

    public static final void copyLinkClick(Context context, ModelInvite modelInvite, String str) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        d0.z.d.m.checkNotNullParameter(str, "analyticsSource");
        AnalyticsTracker.inviteCopied(modelInvite, str);
        Resources resources = context.getResources();
        d0.z.d.m.checkNotNullExpressionValue(resources, "context.resources");
        copyLink(context, getInviteLink(modelInvite, resources));
    }

    public static final void shareLinkClick(Context context, GuildInvite guildInvite, Channel channel) {
        d0.z.d.m.checkNotNullParameter(guildInvite, "guildInvite");
        AnalyticsTracker.INSTANCE.inviteShareClicked(guildInvite, channel);
        if (context != null) {
            shareLink(context, guildInvite.toLink());
        }
    }

    public static final void copyLinkClick(Context context, GuildInvite guildInvite, Channel channel, String str) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        d0.z.d.m.checkNotNullParameter(guildInvite, "guildInvite");
        d0.z.d.m.checkNotNullParameter(str, "analyticsSource");
        AnalyticsTracker.INSTANCE.inviteCopied(guildInvite, channel, str);
        copyLink(context, guildInvite.toLink());
    }

    public static final CharSequence getInviteSettingsText(Context context, long j) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        if (j <= 0) {
            return b.h(context, 2131892764, new Object[0], null, 4);
        }
        return b.h(context, 2131892278, new Object[]{DurationUtilsKt.humanizeDurationRounded(context, j)}, null, 4);
    }
}
