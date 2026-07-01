package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity$registerViaPhone$3 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity$registerViaPhone$3(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        super(1);
        this.this$0 = widgetAuthRegisterIdentity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        if (!GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled() || !WidgetCaptchaKt.isCaptchaError(error)) {
            RegistrationFlowRepo.Companion.getINSTANCE().trackTransition("Account Identity", "response_error", d0.t.m.listOf("phone"));
            return;
        }
        WidgetAuthCaptcha$Companion widgetAuthCaptcha$Companion = WidgetAuthCaptcha.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        ActivityResultLauncher<Intent> activityResultLauncherAccess$getCaptchaLauncher$p = WidgetAuthRegisterIdentity.access$getCaptchaLauncher$p(this.this$0);
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        widgetAuthCaptcha$Companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncherAccess$getCaptchaLauncher$p, u.toMutableList((Collection) response.getMessages().keySet()), error);
    }
}
