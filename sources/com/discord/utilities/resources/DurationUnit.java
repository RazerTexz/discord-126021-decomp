package com.discord.utilities.resources;

import com.discord.R$plurals;

/* JADX INFO: compiled from: DurationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum DurationUnit {
    SECONDS(2131888616, R$plurals.duration_seconds_seconds),
    MINUTES(2131888611, R$plurals.duration_minutes_minutes),
    MINS(2131888610, R$plurals.duration_mins_mins),
    HOURS(2131888606, R$plurals.duration_hours_hours),
    DAYS(2131888603, R$plurals.duration_days_days),
    WEEKS(2131888620, R$plurals.duration_weeks_weeks),
    MONTHS(2131888614, R$plurals.duration_months_months);

    private final int quantityPluralRes;
    private final int stringRes;

    DurationUnit(int i, int i2) {
        this.stringRes = i;
        this.quantityPluralRes = i2;
    }

    /* JADX INFO: renamed from: getQuantityPluralRes$app_productionGoogleRelease, reason: from getter */
    public final int getQuantityPluralRes() {
        return this.quantityPluralRes;
    }

    /* JADX INFO: renamed from: getStringRes$app_productionGoogleRelease, reason: from getter */
    public final int getStringRes() {
        return this.stringRes;
    }
}
