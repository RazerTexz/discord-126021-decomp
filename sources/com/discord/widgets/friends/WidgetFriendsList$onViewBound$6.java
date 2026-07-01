package com.discord.widgets.friends;

import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList$onViewBound$6 extends o implements Function2<User, Integer, Unit> {
    public final /* synthetic */ WidgetFriendsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsList$onViewBound$6(WidgetFriendsList widgetFriendsList) {
        super(2);
        this.this$0 = widgetFriendsList;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(User user, Integer num) {
        invoke(user, num.intValue());
        return Unit.a;
    }

    public final void invoke(User user, int i) {
        m.checkNotNullParameter(user, "user");
        WidgetFriendsList.access$getViewModel$p(this.this$0).removeFriendRequest(user.getId(), i);
    }
}
