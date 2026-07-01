package com.discord.widgets.settings;

import com.discord.views.CheckedSetting;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$explicitContentRadios$2 extends Lambda implements Function0<List<? extends CheckedSetting>> {
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$explicitContentRadios$2(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        super(0);
        this.this$0 = widgetSettingsPrivacy;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends CheckedSetting> invoke() {
        return Collections2.listOf((Object[]) new CheckedSetting[]{this.this$0.getBinding().o, this.this$0.getBinding().p, this.this$0.getBinding().q});
    }
}
