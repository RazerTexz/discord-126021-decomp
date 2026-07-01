package com.discord.widgets.servers;

import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotificationsOverrideSelector$onViewBoundOrOnResume$1 extends o implements Function1<List<? extends CategoricalDragAndDropAdapter$Payload>, Unit> {
    public final /* synthetic */ WidgetServerNotificationsOverrideSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerNotificationsOverrideSelector$onViewBoundOrOnResume$1(WidgetServerNotificationsOverrideSelector widgetServerNotificationsOverrideSelector) {
        super(1);
        this.this$0 = widgetServerNotificationsOverrideSelector;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends CategoricalDragAndDropAdapter$Payload> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends CategoricalDragAndDropAdapter$Payload> list) {
        SettingsChannelListAdapter settingsChannelListAdapterAccess$getChannelsAdapter$p = WidgetServerNotificationsOverrideSelector.access$getChannelsAdapter$p(this.this$0);
        m.checkNotNullExpressionValue(list, "it");
        settingsChannelListAdapterAccess$getChannelsAdapter$p.setData(u.toMutableList((Collection) list));
    }
}
