package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.captcha.WidgetCaptcha$Companion;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage$updatePhoneNumber$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetUserPhoneManage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneManage$updatePhoneNumber$1(WidgetUserPhoneManage widgetUserPhoneManage) {
        super(1);
        this.this$0 = widgetUserPhoneManage;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        if (GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled()) {
            WidgetCaptcha$Companion widgetCaptcha$Companion = WidgetCaptcha.Companion;
            Context contextRequireContext = this.this$0.requireContext();
            ActivityResultLauncher<Intent> activityResultLauncherAccess$getCaptchaLauncher$p = WidgetUserPhoneManage.access$getCaptchaLauncher$p(this.this$0);
            Error$Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            widgetCaptcha$Companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncherAccess$getCaptchaLauncher$p, u.toMutableList((Collection) response.getMessages().keySet()), error);
        }
    }
}
