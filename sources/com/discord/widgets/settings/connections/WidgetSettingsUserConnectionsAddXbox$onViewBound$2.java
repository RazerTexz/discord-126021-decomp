package com.discord.widgets.settings.connections;

import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.platform.Platform;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAddXbox$onViewBound$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetSettingsUserConnectionsAddXbox this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnectionsAddXbox$onViewBound$2(WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox) {
        super(1);
        this.this$0 = widgetSettingsUserConnectionsAddXbox;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "verificationCode");
        if (str.length() == 6) {
            WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox = this.this$0;
            Platform platform = Platform.XBOX;
            DimmerView dimmerView = WidgetSettingsUserConnectionsAddXbox.access$getBinding$p(widgetSettingsUserConnectionsAddXbox).d;
            WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox2 = this.this$0;
            widgetSettingsUserConnectionsAddXbox.submitPinCode(str, platform, dimmerView, widgetSettingsUserConnectionsAddXbox2, widgetSettingsUserConnectionsAddXbox2.getActivity(), new WidgetSettingsUserConnectionsAddXbox$onViewBound$2$1(this));
        }
    }
}
