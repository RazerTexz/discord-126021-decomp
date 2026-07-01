package com.discord.widgets.user.profile;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView$updateViewState$1 extends o implements Function3<String, Integer, String, Unit> {
    public final /* synthetic */ Function3 $onConnectedAccountClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileConnectionsView$updateViewState$1(Function3 function3) {
        super(3);
        this.$onConnectedAccountClick = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
        invoke(str, num.intValue(), str2);
        return Unit.a;
    }

    public final void invoke(String str, int i, String str2) {
        m.checkNotNullParameter(str, "username");
        this.$onConnectedAccountClick.invoke(str, Integer.valueOf(i), str2);
    }
}
