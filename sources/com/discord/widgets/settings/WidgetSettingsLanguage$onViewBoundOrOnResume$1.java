package com.discord.widgets.settings;

import com.discord.stores.StoreUserSettingsSystem$Settings;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage$onViewBoundOrOnResume$1 extends o implements Function1<StoreUserSettingsSystem$Settings, Unit> {
    public final /* synthetic */ WidgetSettingsLanguage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsLanguage$onViewBoundOrOnResume$1(WidgetSettingsLanguage widgetSettingsLanguage) {
        super(1);
        this.this$0 = widgetSettingsLanguage;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings) {
        invoke2(storeUserSettingsSystem$Settings);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings) {
        m.checkNotNullParameter(storeUserSettingsSystem$Settings, "settings");
        WidgetSettingsLanguage.access$configureUI(this.this$0, storeUserSettingsSystem$Settings.getLocale());
    }
}
