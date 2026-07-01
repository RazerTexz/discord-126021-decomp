package com.discord.widgets.settings;

import com.discord.models.domain.ModelUserSettings;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onViewBound$1$1$1 extends o implements Function1<ModelUserSettings, Unit> {
    public static final WidgetSettingsPrivacy$onViewBound$1$1$1 INSTANCE = new WidgetSettingsPrivacy$onViewBound$1$1$1();

    public WidgetSettingsPrivacy$onViewBound$1$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
        invoke2(modelUserSettings);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserSettings modelUserSettings) {
        m.checkNotNullParameter(modelUserSettings, "it");
    }
}
