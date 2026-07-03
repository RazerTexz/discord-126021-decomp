package com.discord.widgets.friends;

import android.view.View;
import com.discord.models.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$onClickUserProfile$1 extends AbstractC12240o implements Function2<View, User, Unit> {
    public static final WidgetFriendsListAdapter$onClickUserProfile$1 INSTANCE = new WidgetFriendsListAdapter$onClickUserProfile$1();

    public WidgetFriendsListAdapter$onClickUserProfile$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, User user) {
        invoke2(view, user);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, User user) {
        C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(user, "<anonymous parameter 1>");
    }
}
