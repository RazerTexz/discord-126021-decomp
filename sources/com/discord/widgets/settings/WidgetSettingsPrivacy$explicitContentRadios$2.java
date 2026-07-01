package com.discord.widgets.settings;

import com.discord.views.CheckedSetting;
import d0.t.n;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$explicitContentRadios$2 extends o implements Function0<List<? extends CheckedSetting>> {
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$explicitContentRadios$2(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        super(0);
        this.this$0 = widgetSettingsPrivacy;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends CheckedSetting> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends CheckedSetting> invoke2() {
        return n.listOf((Object[]) new CheckedSetting[]{WidgetSettingsPrivacy.access$getBinding$p(this.this$0).o, WidgetSettingsPrivacy.access$getBinding$p(this.this$0).p, WidgetSettingsPrivacy.access$getBinding$p(this.this$0).q});
    }
}
