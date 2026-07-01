package com.discord.widgets.settings.account.mfa;

import com.discord.app.AppFragment;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFASteps$showPasswordModal$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetEnableMFASteps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEnableMFASteps$showPasswordModal$1(WidgetEnableMFASteps widgetEnableMFASteps) {
        super(1);
        this.this$0 = widgetEnableMFASteps;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "newPassword");
        WidgetEnableMFASteps.access$getViewModel$p(this.this$0).setPassword(str);
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
    }
}
