package com.discord.widgets.servers;

import com.discord.views.CheckedSetting;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$expiryBehaviorRadios$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration4 extends Lambda implements Function0<List<? extends CheckedSetting>> {
    public final /* synthetic */ WidgetServerSettingsEditIntegration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditIntegration4(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        super(0);
        this.this$0 = widgetServerSettingsEditIntegration;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends CheckedSetting> invoke() {
        return Collections2.listOf((Object[]) new CheckedSetting[]{this.this$0.getBinding().f, this.this$0.getBinding().e});
    }
}
