package com.discord.widgets.auth;

import android.content.Intent;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelPhoneVerificationToken;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify$evaluateCode$2 extends o implements Function1<ModelPhoneVerificationToken, Unit> {
    public final /* synthetic */ WidgetAuthPhoneVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthPhoneVerify$evaluateCode$2(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        super(1);
        this.this$0 = widgetAuthPhoneVerify;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
        invoke2(modelPhoneVerificationToken);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
        m.checkNotNullParameter(modelPhoneVerificationToken, "it");
        Intent intent = new Intent();
        intent.putExtra("RESULT_EXTRA_TOKEN", modelPhoneVerificationToken.getToken());
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(-1, intent);
        }
        AppActivity appActivity2 = this.this$0.getAppActivity();
        if (appActivity2 != null) {
            appActivity2.finish();
        }
    }
}
