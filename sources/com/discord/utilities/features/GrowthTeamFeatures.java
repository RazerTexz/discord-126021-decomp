package com.discord.utilities.features;

import com.discord.app.AppLog;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: GrowthTeamFeatures.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GrowthTeamFeatures {
    public static final GrowthTeamFeatures INSTANCE = new GrowthTeamFeatures();

    private GrowthTeamFeatures() {
    }

    private final boolean isBucketEnabled(Integer num, String str, int i, boolean z2) {
        AppLog.i("Experiment triggered: " + str + " | Track Exposure: " + z2 + " | Assigned Bucket: " + num);
        return num != null && num.intValue() == i;
    }

    public static /* synthetic */ boolean isBucketEnabled$default(GrowthTeamFeatures growthTeamFeatures, Integer num, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return growthTeamFeatures.isBucketEnabled(num, str, i, z2);
    }

    private final boolean isGuildExperimentEnabled(String str, int i, long j, boolean z2) {
        Experiment guildExperiment = StoreStream.INSTANCE.getExperiments().getGuildExperiment(str, j, z2);
        return isBucketEnabled(guildExperiment != null ? Integer.valueOf(guildExperiment.getBucket()) : null, str, i, z2);
    }

    private final boolean isUserExperimentEnabled(String str, int i, boolean z2) {
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment(str, z2);
        return isBucketEnabled(userExperiment != null ? Integer.valueOf(userExperiment.getBucket()) : null, str, i, z2);
    }

    public static /* synthetic */ boolean isUserExperimentEnabled$default(GrowthTeamFeatures growthTeamFeatures, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return growthTeamFeatures.isUserExperimentEnabled(str, i, z2);
    }

    public final boolean hubEventsEnabled(long guildId, boolean trackExposure) {
        return isGuildExperimentEnabled("2021-11_hub_events", 1, guildId, trackExposure);
    }

    public final boolean hubStudyGroupEnabled() {
        return isUserExperimentEnabled$default(this, "2021-10_study_group", 0, false, 3, null);
    }

    public final boolean imbalancedAndroidSplashNoop() {
        return isUserExperimentEnabled$default(this, "2021-09_imbalanced_android_splash_noop", 0, false, 3, null);
    }

    public final boolean isAndroidSmsAutofillEnabled() {
        return isUserExperimentEnabled$default(this, "2021-09_android_sms_autofill", 0, false, 3, null);
    }

    public final boolean isHighlightsSettingsEnabled() {
        return isUserExperimentEnabled$default(this, "2022-03_highlights_settings", 0, false, 3, null);
    }

    public final boolean isHubDiscoveryEnabled() {
        return isUserExperimentEnabled$default(this, "2021-06_hub_discovery", 1, false, 2, null) || isUserExperimentEnabled$default(this, "2021-06_hub_discovery", 2, false, 2, null);
    }

    public final boolean isHubDiscoverySparkleEnabled() {
        return isUserExperimentEnabled$default(this, "2021-06_hub_discovery", 1, false, 2, null);
    }

    public final boolean isHubEmailConnectionEnabled() {
        return isUserExperimentEnabled$default(this, "2021-06_hub_email_connection", 0, false, 3, null);
    }

    public final boolean isHubEnabled() {
        return isUserExperimentEnabled$default(this, "2021-06_desktop_school_hubs", 0, false, 3, null);
    }

    public final boolean isHubNameKillSwitchEnabled() {
        return isUserExperimentEnabled$default(this, "2021-09_hub_name_popup_kill_switch", 0, false, 3, null);
    }

    public final boolean isHubOnboardingEnabled() {
        return isUserExperimentEnabled$default(this, "2021-08_hubs_in_organic_onboarding", 0, false, 3, null);
    }

    public final boolean isImpressionLoggingEnabled() {
        return isUserExperimentEnabled$default(this, "2021-08_impression_logging_enabled_android", 0, false, 3, null);
    }

    public final boolean isMultiDomainEnabled() {
        return isUserExperimentEnabled$default(this, "2021-08_hub_multi_domain_mobile", 0, false, 3, null);
    }

    public final boolean isNetworkActionLoggingEnabled() {
        return isUserExperimentEnabled$default(this, "2021-07_network_action_logging_android", 0, false, 3, null);
    }

    public final boolean isPhoneVerifyCaptchaEnabled() {
        return isUserExperimentEnabled$default(this, "2021-11_phone_verify_captcha", 0, false, 3, null);
    }
}
