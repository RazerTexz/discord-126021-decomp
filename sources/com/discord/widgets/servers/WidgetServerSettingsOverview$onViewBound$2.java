package com.discord.widgets.servers;

import com.discord.R$id;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$onViewBound$2 extends o implements Function2<Long, String, Unit> {
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsOverview$onViewBound$2(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        super(2);
        this.this$0 = widgetServerSettingsOverview;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
        invoke(l.longValue(), str);
        return Unit.a;
    }

    public final void invoke(long j, String str) {
        m.checkNotNullParameter(str, "<anonymous parameter 1>");
        Channel channel = StoreStream.Companion.getChannels().getChannel(j);
        WidgetServerSettingsOverview.access$getState$p(this.this$0).put(R$id.system_channel, channel);
        WidgetServerSettingsOverview.access$getState$p(this.this$0).configureSaveActionView(WidgetServerSettingsOverview.access$getBinding$p(this.this$0).e);
        WidgetServerSettingsOverview.access$configureSystemChannel(this.this$0, channel);
    }
}
