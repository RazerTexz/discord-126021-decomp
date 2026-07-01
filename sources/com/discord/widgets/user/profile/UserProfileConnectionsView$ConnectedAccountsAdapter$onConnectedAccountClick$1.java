package com.discord.widgets.user.profile;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView$ConnectedAccountsAdapter$onConnectedAccountClick$1 extends o implements Function3<String, Integer, String, Unit> {
    public static final UserProfileConnectionsView$ConnectedAccountsAdapter$onConnectedAccountClick$1 INSTANCE = new UserProfileConnectionsView$ConnectedAccountsAdapter$onConnectedAccountClick$1();

    public UserProfileConnectionsView$ConnectedAccountsAdapter$onConnectedAccountClick$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
        invoke(str, num.intValue(), str2);
        return Unit.a;
    }

    public final void invoke(String str, int i, String str2) {
        m.checkNotNullParameter(str, "<anonymous parameter 0>");
    }
}
