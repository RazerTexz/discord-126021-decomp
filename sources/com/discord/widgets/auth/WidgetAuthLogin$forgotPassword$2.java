package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.view.validators.ValidationManager;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$forgotPassword$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ String $login;
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$forgotPassword$2(WidgetAuthLogin widgetAuthLogin, String str) {
        super(1);
        this.this$0 = widgetAuthLogin;
        this.$login = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        if (response.getCode() != 70007) {
            ValidationManager validationManagerAccess$getValidationManager$p = WidgetAuthLogin.access$getValidationManager$p(this.this$0);
            Error$Response response2 = error.getResponse();
            m.checkNotNullExpressionValue(response2, "error.response");
            Map<String, List<String>> messages = response2.getMessages();
            m.checkNotNullExpressionValue(messages, "error.response.messages");
            List<String> mutableList = u.toMutableList((Collection) validationManagerAccess$getValidationManager$p.setErrors(messages));
            WidgetAuthCaptcha.Companion.processErrorsForCaptcha(this.this$0.requireContext(), WidgetAuthLogin.access$getCaptchaForgotPasswordLauncher$p(this.this$0), mutableList, error);
            error.setShowErrorToasts(!mutableList.isEmpty());
            return;
        }
        WidgetAuthPhoneVerify$Companion widgetAuthPhoneVerify$Companion = WidgetAuthPhoneVerify.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        ActivityResultLauncher<Intent> activityResultLauncherAccess$getPhoneVerifyPasswordLauncher$p = WidgetAuthLogin.access$getPhoneVerifyPasswordLauncher$p(this.this$0);
        String str = this.$login;
        String string = this.this$0.getString(2131893659);
        m.checkNotNullExpressionValue(string, "getString(R.string.passw…overy_verify_phone_title)");
        String string2 = this.this$0.getString(2131893657);
        m.checkNotNullExpressionValue(string2, "getString(R.string.passw…ry_verify_phone_subtitle)");
        widgetAuthPhoneVerify$Companion.launch(contextRequireContext, activityResultLauncherAccess$getPhoneVerifyPasswordLauncher$p, str, string, string2);
        error.setShowErrorToasts(false);
    }
}
