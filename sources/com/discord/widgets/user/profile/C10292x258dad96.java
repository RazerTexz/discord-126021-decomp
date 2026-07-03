package com.discord.widgets.user.profile;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileConnectionsView$ConnectedAccountsAdapter$onConnectedAccountClick$1 */
/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10292x258dad96 extends AbstractC12240o implements Function3<String, Integer, String, Unit> {
    public static final C10292x258dad96 INSTANCE = new C10292x258dad96();

    public C10292x258dad96() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
        invoke(str, num.intValue(), str2);
        return Unit.f27425a;
    }

    public final void invoke(String str, int i, String str2) {
        C12238m.checkNotNullParameter(str, "<anonymous parameter 0>");
    }
}
