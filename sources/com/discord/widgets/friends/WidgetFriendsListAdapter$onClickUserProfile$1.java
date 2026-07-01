package com.discord.widgets.friends;

import android.view.View;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$onClickUserProfile$1 extends Lambda implements Function2<View, User, Unit> {
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
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(user, "<anonymous parameter 1>");
    }
}
