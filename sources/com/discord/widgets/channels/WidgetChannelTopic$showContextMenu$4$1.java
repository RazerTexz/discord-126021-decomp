package com.discord.widgets.channels;

import android.content.Context;
import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$showContextMenu$4$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChannelTopic$showContextMenu$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopic$showContextMenu$4$1(WidgetChannelTopic$showContextMenu$4 widgetChannelTopic$showContextMenu$4) {
        super(1);
        this.this$0 = widgetChannelTopic$showContextMenu$4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "v");
        WidgetChannelTopicViewModel widgetChannelTopicViewModelAccess$getViewModel$p = WidgetChannelTopic.access$getViewModel$p(this.this$0.this$0);
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "v.context");
        widgetChannelTopicViewModelAccess$getViewModel$p.handleClosePrivateChannel(context);
    }
}
