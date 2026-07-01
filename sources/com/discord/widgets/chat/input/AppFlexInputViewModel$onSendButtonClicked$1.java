package com.discord.widgets.chat.input;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFlexInputViewModel$onSendButtonClicked$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ AppFlexInputViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFlexInputViewModel$onSendButtonClicked$1(AppFlexInputViewModel appFlexInputViewModel) {
        super(1);
        this.this$0 = appFlexInputViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        if (z2) {
            AppFlexInputViewModel.clean$default(this.this$0, false, 1, null);
        }
    }
}
