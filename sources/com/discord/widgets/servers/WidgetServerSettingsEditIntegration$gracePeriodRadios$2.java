package com.discord.widgets.servers;

import com.discord.views.CheckedSetting;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$gracePeriodRadios$2 extends AbstractC12240o implements Function0<List<? extends CheckedSetting>> {
    public final /* synthetic */ WidgetServerSettingsEditIntegration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditIntegration$gracePeriodRadios$2(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        super(0);
        this.this$0 = widgetServerSettingsEditIntegration;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends CheckedSetting> invoke() {
        return C12147n.listOf((Object[]) new CheckedSetting[]{this.this$0.getBinding().f17618h, this.this$0.getBinding().f17620j, this.this$0.getBinding().f17621k, this.this$0.getBinding().f17617g, this.this$0.getBinding().f17619i});
    }
}
