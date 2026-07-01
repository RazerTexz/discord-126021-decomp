package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$configureUI$8 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChannelsListItemThreadActions$Model $this_configureUI;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListItemThreadActions$configureUI$8(WidgetChannelsListItemThreadActions$Model widgetChannelsListItemThreadActions$Model) {
        super(1);
        this.$this_configureUI = widgetChannelsListItemThreadActions$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        b.a.d.m.c(context, String.valueOf(this.$this_configureUI.getChannel().getId()), 0, 4);
    }
}
