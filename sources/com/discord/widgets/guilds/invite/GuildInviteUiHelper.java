package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.duration.DurationUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.resources.StringResourceUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteUiHelperKt, reason: use source file name */
/* JADX INFO: compiled from: GuildInviteUiHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteUiHelper {
    private static final void copyLink(Context context, String str) {
        AppToast.a(context, str, R.string.invite_link_copied);
    }

    public static final void copyLinkClick(Context context, ModelInvite modelInvite, Intent intent) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(intent, "mostRecentIntent");
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
        Intrinsics3.checkNotNullExpressionValue(link, "inviteModel.toLink(resou… BuildConfig.HOST_INVITE)");
        return link;
    }

    public static final CharSequence getInviteLinkText(Context context, Experiment experiment) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return FormatUtils.b(context, R.string.invite_links_expire_after_default, new Object[]{(experiment == null || experiment.getBucket() != 1) ? StringResourceUtils.getI18nPluralString(context, R.plurals.duration_days_days, 1, 1) : StringResourceUtils.getI18nPluralString(context, R.plurals.duration_days_days, 7, 7)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
    }

    public static final CharSequence getInviteSettingsText(Context context, long j, int i) {
        Object quantityString;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (i == 0) {
            quantityString = context.getString(R.string.max_uses_description_unlimited_uses);
            Intrinsics3.checkNotNullExpressionValue(quantityString, "context.getString(R.stri…scription_unlimited_uses)");
        } else {
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
            quantityString = StringResourceUtils.getQuantityString(resources, context, R.plurals.max_uses_description_mobile_maxUses, i, Integer.valueOf(i));
        }
        return j <= 0 ? FormatUtils.b(context, R.string.invite_settings_description_no_expiration, new Object[]{context.getString(R.string.max_age_never_description_mobile), quantityString}, (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(context, R.string.invite_settings_expired_description, new Object[]{DurationUtils.humanizeDurationRounded(context, j), quantityString}, (4 & 4) != 0 ? FormatUtils.b.j : null);
    }

    private static final void shareLink(Context context, String str) {
        String string = context.getResources().getString(R.string.tip_instant_invite_title3);
        Intrinsics3.checkNotNullExpressionValue(string, "context.resources.getStr…ip_instant_invite_title3)");
        IntentUtils.performChooserSendIntent(context, str, string);
    }

    public static final void shareLinkClick(Context context, ModelInvite modelInvite) {
        Intrinsics3.checkNotNullParameter(modelInvite, "invite");
        AnalyticsTracker.inviteShareClicked(modelInvite);
        if (context != null) {
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
            shareLink(context, getInviteLink(modelInvite, resources));
        }
    }

    public static final void copyLinkClick(Context context, ModelInvite modelInvite, String str) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(str, "analyticsSource");
        AnalyticsTracker.inviteCopied(modelInvite, str);
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
        copyLink(context, getInviteLink(modelInvite, resources));
    }

    public static final void shareLinkClick(Context context, GuildInvite guildInvite, Channel channel) {
        Intrinsics3.checkNotNullParameter(guildInvite, "guildInvite");
        AnalyticsTracker.INSTANCE.inviteShareClicked(guildInvite, channel);
        if (context != null) {
            shareLink(context, guildInvite.toLink());
        }
    }

    public static final void copyLinkClick(Context context, GuildInvite guildInvite, Channel channel, String str) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(guildInvite, "guildInvite");
        Intrinsics3.checkNotNullParameter(str, "analyticsSource");
        AnalyticsTracker.INSTANCE.inviteCopied(guildInvite, channel, str);
        copyLink(context, guildInvite.toLink());
    }

    public static final CharSequence getInviteSettingsText(Context context, long j) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return j <= 0 ? FormatUtils.b(context, R.string.max_age_never_description_mobile, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(context, R.string.invite_expired_subtext_mobile, new Object[]{DurationUtils.humanizeDurationRounded(context, j)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
    }
}
