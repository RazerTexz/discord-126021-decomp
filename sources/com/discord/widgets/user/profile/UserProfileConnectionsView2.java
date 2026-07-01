package com.discord.widgets.user.profile;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileConnectionsView$ConnectedAccountsAdapter$onConnectedAccountClick$1, reason: use source file name */
/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView2 extends Lambda implements Function3<String, Integer, String, Unit> {
    public static final UserProfileConnectionsView2 INSTANCE = new UserProfileConnectionsView2();

    public UserProfileConnectionsView2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
        invoke(str, num.intValue(), str2);
        return Unit.a;
    }

    public final void invoke(String str, int i, String str2) {
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
    }
}
