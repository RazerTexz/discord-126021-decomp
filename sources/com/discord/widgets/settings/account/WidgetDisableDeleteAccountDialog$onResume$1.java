package com.discord.widgets.settings.account;

import com.discord.models.user.MeUser;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDisableDeleteAccountDialog$onResume$1 extends k implements Function1<MeUser, Unit> {
    public WidgetDisableDeleteAccountDialog$onResume$1(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog) {
        super(1, widgetDisableDeleteAccountDialog, WidgetDisableDeleteAccountDialog.class, "configureUI", "configureUI(Lcom/discord/models/user/MeUser;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
        invoke2(meUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MeUser meUser) {
        m.checkNotNullParameter(meUser, "p1");
        WidgetDisableDeleteAccountDialog.access$configureUI((WidgetDisableDeleteAccountDialog) this.receiver, meUser);
    }
}
