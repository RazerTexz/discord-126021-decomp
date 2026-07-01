package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchModel$Companion$get$1 extends FunctionReferenceImpl implements Function6<WidgetGlobalSearchModel.SearchContext, WidgetGlobalSearchModel.UsersContext, WidgetGlobalSearchModel.ChannelContext, WidgetGlobalSearchGuildsModel, Function1<? super WidgetGlobalSearchModel.ItemDataPayload, ? extends Boolean>, Function1<? super WidgetGlobalSearchModel.SearchContext, ? extends Long>, WidgetGlobalSearchModel> {
    public WidgetGlobalSearchModel$Companion$get$1(WidgetGlobalSearchModel.Companion companion) {
        super(6, companion, WidgetGlobalSearchModel.Companion.class, "create", "create(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel invoke(WidgetGlobalSearchModel.SearchContext searchContext, WidgetGlobalSearchModel.UsersContext usersContext, WidgetGlobalSearchModel.ChannelContext channelContext, WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, Function1<? super WidgetGlobalSearchModel.ItemDataPayload, ? extends Boolean> function1, Function1<? super WidgetGlobalSearchModel.SearchContext, ? extends Long> function2) {
        return invoke2(searchContext, usersContext, channelContext, widgetGlobalSearchGuildsModel, (Function1<? super WidgetGlobalSearchModel.ItemDataPayload, Boolean>) function1, (Function1<? super WidgetGlobalSearchModel.SearchContext, Long>) function2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel invoke2(WidgetGlobalSearchModel.SearchContext searchContext, WidgetGlobalSearchModel.UsersContext usersContext, WidgetGlobalSearchModel.ChannelContext channelContext, WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, Function1<? super WidgetGlobalSearchModel.ItemDataPayload, Boolean> function1, Function1<? super WidgetGlobalSearchModel.SearchContext, Long> function2) {
        Intrinsics3.checkNotNullParameter(searchContext, "p1");
        Intrinsics3.checkNotNullParameter(usersContext, "p2");
        Intrinsics3.checkNotNullParameter(channelContext, "p3");
        Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsModel, "p4");
        Intrinsics3.checkNotNullParameter(function2, "p6");
        return ((WidgetGlobalSearchModel.Companion) this.receiver).create(searchContext, usersContext, channelContext, widgetGlobalSearchGuildsModel, function1, function2);
    }
}
