package com.discord.widgets.friends;

import android.view.View;
import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$onClickUserProfile$1 extends o implements Function2<View, User, Unit> {
    public static final WidgetFriendsListAdapter$onClickUserProfile$1 INSTANCE = new WidgetFriendsListAdapter$onClickUserProfile$1();

    public WidgetFriendsListAdapter$onClickUserProfile$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, User user) {
        invoke2(view, user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, User user) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        m.checkNotNullParameter(user, "<anonymous parameter 1>");
    }
}
