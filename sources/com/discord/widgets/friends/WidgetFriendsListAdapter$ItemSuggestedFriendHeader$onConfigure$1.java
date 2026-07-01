package com.discord.widgets.friends;

import com.discord.i18n.RenderContext;
import com.discord.widgets.friends.FriendsListViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$1 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ FriendsListViewModel.Item $data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$1(FriendsListViewModel.Item item) {
        super(1);
        this.$data = item;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("count", String.valueOf(((FriendsListViewModel.Item.SuggestedFriendsHeader) this.$data).getCount()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
