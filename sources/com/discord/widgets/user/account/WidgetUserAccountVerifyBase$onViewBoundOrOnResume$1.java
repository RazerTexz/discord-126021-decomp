package com.discord.widgets.user.account;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserAccountVerifyBase.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserAccountVerifyBase$onViewBoundOrOnResume$1 extends k implements Function1<Boolean, Unit> {
    public WidgetUserAccountVerifyBase$onViewBoundOrOnResume$1(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase) {
        super(1, widgetUserAccountVerifyBase, WidgetUserAccountVerifyBase.class, "handleIsAuthorized", "handleIsAuthorized(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetUserAccountVerifyBase.access$handleIsAuthorized((WidgetUserAccountVerifyBase) this.receiver, z2);
    }
}
