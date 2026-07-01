package com.discord.widgets.settings.premium;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsPremiumViewModel$Event$ErrorToast extends SettingsPremiumViewModel$Event {
    private final int errorStringResId;

    public SettingsPremiumViewModel$Event$ErrorToast(@StringRes int i) {
        super(null);
        this.errorStringResId = i;
    }

    public static /* synthetic */ SettingsPremiumViewModel$Event$ErrorToast copy$default(SettingsPremiumViewModel$Event$ErrorToast settingsPremiumViewModel$Event$ErrorToast, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = settingsPremiumViewModel$Event$ErrorToast.errorStringResId;
        }
        return settingsPremiumViewModel$Event$ErrorToast.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getErrorStringResId() {
        return this.errorStringResId;
    }

    public final SettingsPremiumViewModel$Event$ErrorToast copy(@StringRes int errorStringResId) {
        return new SettingsPremiumViewModel$Event$ErrorToast(errorStringResId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SettingsPremiumViewModel$Event$ErrorToast) && this.errorStringResId == ((SettingsPremiumViewModel$Event$ErrorToast) other).errorStringResId;
        }
        return true;
    }

    public final int getErrorStringResId() {
        return this.errorStringResId;
    }

    public int hashCode() {
        return this.errorStringResId;
    }

    public String toString() {
        return a.B(a.U("ErrorToast(errorStringResId="), this.errorStringResId, ")");
    }
}
