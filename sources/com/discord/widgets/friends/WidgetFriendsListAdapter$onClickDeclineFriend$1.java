package com.discord.widgets.friends;

import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$onClickDeclineFriend$1 extends Lambda implements Function2<User, Integer, Unit> {
    public static final WidgetFriendsListAdapter$onClickDeclineFriend$1 INSTANCE = new WidgetFriendsListAdapter$onClickDeclineFriend$1();

    public WidgetFriendsListAdapter$onClickDeclineFriend$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(User user, Integer num) {
        invoke(user, num.intValue());
        return Unit.a;
    }

    public final void invoke(User user, int i) {
        Intrinsics3.checkNotNullParameter(user, "<anonymous parameter 0>");
    }
}
