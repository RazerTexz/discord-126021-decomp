package com.discord.widgets.user.phone;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage$phoneVerificationLauncher$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ WidgetUserPhoneManage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneManage$phoneVerificationLauncher$1(WidgetUserPhoneManage widgetUserPhoneManage) {
        super(0);
        this.this$0 = widgetUserPhoneManage;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        if (fragmentActivityRequireActivity.getCallingActivity() != null) {
            FragmentActivity fragmentActivityM95e = this.this$0.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.setResult(-1);
            }
            FragmentActivity fragmentActivityM95e2 = this.this$0.m95e();
            if (fragmentActivityM95e2 != null) {
                fragmentActivityM95e2.finish();
            }
        }
    }
}
