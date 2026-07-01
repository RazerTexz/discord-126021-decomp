package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.error.Error;
import com.discord.views.CheckedSetting;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$toggleConsent$2<T> implements Action1<Error> {
    public final /* synthetic */ boolean $consented;
    public final /* synthetic */ CheckedSetting $toggle;

    public WidgetSettingsPrivacy$toggleConsent$2(CheckedSetting checkedSetting, boolean z2) {
        this.$toggle = checkedSetting;
        this.$consented = z2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        this.$toggle.setEnabled(true);
        this.$toggle.setChecked(true ^ this.$consented);
    }
}
