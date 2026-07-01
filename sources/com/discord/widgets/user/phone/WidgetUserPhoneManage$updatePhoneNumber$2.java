package com.discord.widgets.user.phone;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage$updatePhoneNumber$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ String $phoneNumber;
    public final /* synthetic */ WidgetUserPhoneManage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneManage$updatePhoneNumber$2(WidgetUserPhoneManage widgetUserPhoneManage, String str) {
        super(1);
        this.this$0 = widgetUserPhoneManage;
        this.$phoneNumber = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r7) {
        WidgetUserPhoneVerify.Companion.launch(this.this$0.requireContext(), WidgetUserPhoneManage.access$getPhoneVerificationLauncher$p(this.this$0), WidgetUserPhoneManage.access$getMode$p(this.this$0), this.$phoneNumber, WidgetUserPhoneManage.access$getSource$p(this.this$0));
    }
}
