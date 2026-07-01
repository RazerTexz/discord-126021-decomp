package com.discord.widgets.settings;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.restapi.RestAPIParams$Consents$Type;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configurePrivacyControls$2<T> implements Action1<Boolean> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$configurePrivacyControls$2(WidgetSettingsPrivacy widgetSettingsPrivacy, Context context) {
        this.this$0 = widgetSettingsPrivacy;
        this.$context = context;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(this.this$0).v;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
        checkedSetting.setEnabled(false);
        m.checkNotNullExpressionValue(bool, "consented");
        if (!bool.booleanValue()) {
            WidgetSettingsPrivacy.access$confirmConsent(this.this$0, this.$context, new WidgetSettingsPrivacy$configurePrivacyControls$2$1(this, bool));
            return;
        }
        WidgetSettingsPrivacy widgetSettingsPrivacy = this.this$0;
        boolean zBooleanValue = bool.booleanValue();
        CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(this.this$0).v;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
        WidgetSettingsPrivacy.access$toggleConsent(widgetSettingsPrivacy, zBooleanValue, RestAPIParams$Consents$Type.PERSONALIZATION, checkedSetting2);
    }
}
