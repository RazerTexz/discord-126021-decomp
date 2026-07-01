package com.discord.widgets.settings;

import com.discord.views.CheckedSetting;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onViewBoundOrOnResume$2 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$onViewBoundOrOnResume$2(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        super(1);
        this.this$0 = widgetSettingsPrivacy;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(this.this$0).f2638y;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyScreenreaderDetection");
        checkedSetting.setChecked(z2);
    }
}
