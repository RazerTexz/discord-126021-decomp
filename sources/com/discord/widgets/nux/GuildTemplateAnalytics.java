package com.discord.widgets.nux;

import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildTemplateAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateAnalytics {
    private static final String FLOW_TYPE_POST_REG = "Mobile NUX Post Reg";
    public static final GuildTemplateAnalytics INSTANCE = new GuildTemplateAnalytics();
    public static final String IN_APP_LOCATION_TEMPLATE = "Create or Join Guild Modal";
    public static final String STEP_CREATION_INTENT = "Server Intent Discovery";
    private static final String STEP_FRIENDS_LIST = "Friends List";
    public static final String STEP_GUILD_CREATE = "Guild Create";
    public static final String STEP_GUILD_JOIN = "Guild Join";
    public static final String STEP_GUILD_TEMPLATE = "Guild Template";
    public static final String STEP_REGISTRATION = "Registration";

    private GuildTemplateAnalytics() {
    }

    public final void postRegistrationSkip$app_productionGoogleRelease(String fromStep) {
        m.checkNotNullParameter(fromStep, "fromStep");
        AnalyticsTracker.newUserOnboarding$default(AnalyticsTracker.INSTANCE, FLOW_TYPE_POST_REG, fromStep, STEP_FRIENDS_LIST, null, true, 8, null);
    }

    public final void postRegistrationTransition$app_productionGoogleRelease(String fromStep, String toStep) {
        m.checkNotNullParameter(fromStep, "fromStep");
        m.checkNotNullParameter(toStep, "toStep");
        AnalyticsTracker.newUserOnboarding$default(AnalyticsTracker.INSTANCE, FLOW_TYPE_POST_REG, fromStep, toStep, null, false, 24, null);
    }
}
