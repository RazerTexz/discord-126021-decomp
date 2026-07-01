package com.discord.widgets.user.phone;

import android.view.View;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage$removePhoneNumber$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetUserPhoneManage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneManage$removePhoneNumber$1(WidgetUserPhoneManage widgetUserPhoneManage) {
        super(1);
        this.this$0 = widgetUserPhoneManage;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetUserPasswordVerify.Companion.launchRemovePhoneNumber(this.this$0.requireContext(), WidgetUserPhoneManage.access$getPasswordVerifyLauncher$p(this.this$0));
    }
}
