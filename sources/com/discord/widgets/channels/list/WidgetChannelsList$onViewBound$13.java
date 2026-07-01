package com.discord.widgets.channels.list;

import com.discord.widgets.channels.list.items.ChannelListItem;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$13 extends o implements Function2<List<? extends ChannelListItem>, List<? extends ChannelListItem>, Unit> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$13(WidgetChannelsList widgetChannelsList) {
        super(2);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChannelListItem> list, List<? extends ChannelListItem> list2) {
        invoke2(list, list2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends ChannelListItem> list, List<? extends ChannelListItem> list2) {
        m.checkNotNullParameter(list, "<anonymous parameter 0>");
        m.checkNotNullParameter(list2, "newData");
        WidgetChannelListUnreads widgetChannelListUnreadsAccess$getChannelListUnreads$p = WidgetChannelsList.access$getChannelListUnreads$p(this.this$0);
        if (widgetChannelListUnreadsAccess$getChannelListUnreads$p != null) {
            widgetChannelListUnreadsAccess$getChannelListUnreads$p.onDatasetChanged(list2);
        }
    }
}
