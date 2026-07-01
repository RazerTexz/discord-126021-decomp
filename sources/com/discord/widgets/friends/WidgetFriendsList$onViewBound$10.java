package com.discord.widgets.friends;

import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList$onViewBound$10 extends o implements Function1<User, Unit> {
    public final /* synthetic */ WidgetFriendsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsList$onViewBound$10(WidgetFriendsList widgetFriendsList) {
        super(1);
        this.this$0 = widgetFriendsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        m.checkNotNullParameter(user, "user");
        FriendsListViewModel.acceptFriendSuggestion$default(WidgetFriendsList.access$getViewModel$p(this.this$0), user.getUsername(), user.getDiscriminator(), null, 4, null);
    }
}
