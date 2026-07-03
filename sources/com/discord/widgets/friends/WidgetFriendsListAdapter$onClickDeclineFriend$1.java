package com.discord.widgets.friends;

import com.discord.models.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$onClickDeclineFriend$1 extends AbstractC12240o implements Function2<User, Integer, Unit> {
    public static final WidgetFriendsListAdapter$onClickDeclineFriend$1 INSTANCE = new WidgetFriendsListAdapter$onClickDeclineFriend$1();

    public WidgetFriendsListAdapter$onClickDeclineFriend$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(User user, Integer num) {
        invoke(user, num.intValue());
        return Unit.f27425a;
    }

    public final void invoke(User user, int i) {
        C12238m.checkNotNullParameter(user, "<anonymous parameter 0>");
    }
}
