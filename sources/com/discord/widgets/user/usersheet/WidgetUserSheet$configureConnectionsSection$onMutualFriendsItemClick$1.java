package com.discord.widgets.user.usersheet;

import android.content.Context;
import com.discord.models.user.User;
import com.discord.widgets.user.WidgetUserMutualFriends;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureConnectionsSection$onMutualFriendsItemClick$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ User $user;
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$configureConnectionsSection$onMutualFriendsItemClick$1(WidgetUserSheet widgetUserSheet, User user) {
        super(0);
        this.this$0 = widgetUserSheet;
        this.$user = user;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetUserMutualFriends.Companion companion = WidgetUserMutualFriends.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.show(contextRequireContext, this.$user);
    }
}
