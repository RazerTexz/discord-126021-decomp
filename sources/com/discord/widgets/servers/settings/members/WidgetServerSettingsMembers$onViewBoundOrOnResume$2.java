package com.discord.widgets.servers.settings.members;

import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreStream;
import d0.g0.s;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers$onViewBoundOrOnResume$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetServerSettingsMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsMembers$onViewBoundOrOnResume$2(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        super(1);
        this.this$0 = widgetServerSettingsMembers;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullExpressionValue(str, "filterString");
        Long longOrNull = s.toLongOrNull(str);
        StoreGatewayConnection.requestGuildMembers$default(StoreStream.Companion.getGatewaySocket(), WidgetServerSettingsMembers.access$getGuildId$p(this.this$0), str, longOrNull != null ? d0.t.m.listOf(Long.valueOf(longOrNull.longValue())) : null, null, 8, null);
    }
}
