package com.discord.widgets.user.phone;

import com.discord.models.user.MeUser;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage$onViewBoundOrOnResume$1 extends o implements Function1<MeUser, Unit> {
    public final /* synthetic */ WidgetUserPhoneManage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneManage$onViewBoundOrOnResume$1(WidgetUserPhoneManage widgetUserPhoneManage) {
        super(1);
        this.this$0 = widgetUserPhoneManage;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
        invoke2(meUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MeUser meUser) {
        m.checkNotNullParameter(meUser, "it");
        WidgetUserPhoneManage.access$configureUI(this.this$0, meUser);
    }
}
