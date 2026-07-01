package com.discord.widgets.user.phone;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$phoneVerificationLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetUserPhoneManage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneManage5(WidgetUserPhoneManage widgetUserPhoneManage) {
        super(0);
        this.this$0 = widgetUserPhoneManage;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        if (fragmentActivityRequireActivity.getCallingActivity() != null) {
            FragmentActivity fragmentActivityE = this.this$0.e();
            if (fragmentActivityE != null) {
                fragmentActivityE.setResult(-1);
            }
            FragmentActivity fragmentActivityE2 = this.this$0.e();
            if (fragmentActivityE2 != null) {
                fragmentActivityE2.finish();
            }
        }
    }
}
