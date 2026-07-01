package com.discord.widgets.user.search;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchModel$Companion$get$1 extends k implements Function6<WidgetGlobalSearchModel$SearchContext, WidgetGlobalSearchModel$UsersContext, WidgetGlobalSearchModel$ChannelContext, WidgetGlobalSearchGuildsModel, Function1<? super WidgetGlobalSearchModel$ItemDataPayload, ? extends Boolean>, Function1<? super WidgetGlobalSearchModel$SearchContext, ? extends Long>, WidgetGlobalSearchModel> {
    public WidgetGlobalSearchModel$Companion$get$1(WidgetGlobalSearchModel$Companion widgetGlobalSearchModel$Companion) {
        super(6, widgetGlobalSearchModel$Companion, WidgetGlobalSearchModel$Companion.class, "create", "create(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel invoke(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext, WidgetGlobalSearchModel$UsersContext widgetGlobalSearchModel$UsersContext, WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext, WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, Function1<? super WidgetGlobalSearchModel$ItemDataPayload, ? extends Boolean> function1, Function1<? super WidgetGlobalSearchModel$SearchContext, ? extends Long> function2) {
        return invoke2(widgetGlobalSearchModel$SearchContext, widgetGlobalSearchModel$UsersContext, widgetGlobalSearchModel$ChannelContext, widgetGlobalSearchGuildsModel, (Function1<? super WidgetGlobalSearchModel$ItemDataPayload, Boolean>) function1, (Function1<? super WidgetGlobalSearchModel$SearchContext, Long>) function2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel invoke2(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext, WidgetGlobalSearchModel$UsersContext widgetGlobalSearchModel$UsersContext, WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext, WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, Function1<? super WidgetGlobalSearchModel$ItemDataPayload, Boolean> function1, Function1<? super WidgetGlobalSearchModel$SearchContext, Long> function2) {
        m.checkNotNullParameter(widgetGlobalSearchModel$SearchContext, "p1");
        m.checkNotNullParameter(widgetGlobalSearchModel$UsersContext, "p2");
        m.checkNotNullParameter(widgetGlobalSearchModel$ChannelContext, "p3");
        m.checkNotNullParameter(widgetGlobalSearchGuildsModel, "p4");
        m.checkNotNullParameter(function2, "p6");
        return ((WidgetGlobalSearchModel$Companion) this.receiver).create(widgetGlobalSearchModel$SearchContext, widgetGlobalSearchModel$UsersContext, widgetGlobalSearchModel$ChannelContext, widgetGlobalSearchGuildsModel, function1, function2);
    }
}
