package com.discord.widgets.servers.community;

import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunitySecondStep$onViewBound$1 extends o implements Function2<Long, String, Unit> {
    public final /* synthetic */ WidgetServerSettingsCommunitySecondStep this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunitySecondStep$onViewBound$1(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep) {
        super(2);
        this.this$0 = widgetServerSettingsCommunitySecondStep;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
        invoke(l.longValue(), str);
        return Unit.a;
    }

    public final void invoke(long j, String str) {
        m.checkNotNullParameter(str, "<anonymous parameter 1>");
        WidgetServerSettingsCommunitySecondStep.access$getViewModel$p(this.this$0).modifyGuildConfig(new WidgetServerSettingsCommunitySecondStep$onViewBound$1$1(j, StoreStream.Companion.getChannels().getChannel(j)));
    }
}
