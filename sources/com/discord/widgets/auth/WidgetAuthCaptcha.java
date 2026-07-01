package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import b.a.d.AppScreen2;
import com.discord.app.AppFragment;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.widgets.captcha.WidgetCaptcha;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetAuthCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthCaptcha extends WidgetCaptcha {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CAPTCHA_ERROR_BODY = "EXTRA_CAPTCHA_ERROR_BODY";
    private static final String RESULT_EXTRA_RQTOKEN = "RESULT_EXTRA_RQTOKEN";
    private static final String RESULT_EXTRA_TOKEN = "RESULT_EXTRA_TOKEN";

    /* JADX INFO: compiled from: WidgetAuthCaptcha.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, CaptchaErrorBody captchaErrorBody) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthCaptcha.EXTRA_CAPTCHA_ERROR_BODY, captchaErrorBody);
            AppScreen2.g.f(context, launcher, WidgetAuthCaptcha.class, intent);
        }

        public final void processErrorsForCaptcha(Context context, ActivityResultLauncher<Intent> launcher, List<String> unhandledErrors, Error error) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(unhandledErrors, "unhandledErrors");
            Intrinsics3.checkNotNullParameter(error, "error");
            if (unhandledErrors.remove(CaptchaHelper.CAPTCHA_KEY)) {
                launch(context, launcher, CaptchaErrorBody.INSTANCE.createFromError(error));
                error.setShowErrorToasts(false);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function1<? super CaptchaHelper.CaptchaPayload, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.auth.WidgetAuthCaptcha$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() == -1) {
                        Intent data = activityResult.getData();
                        String stringExtra = data != null ? data.getStringExtra("RESULT_EXTRA_TOKEN") : null;
                        Intent data2 = activityResult.getData();
                        String stringExtra2 = data2 != null ? data2.getStringExtra("RESULT_EXTRA_RQTOKEN") : null;
                        if (stringExtra != null) {
                            callback.invoke(new CaptchaHelper.CaptchaPayload(stringExtra, stringExtra2));
                        }
                    }
                }
            });
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.discord.widgets.captcha.WidgetCaptcha
    public void trackTransition(String action, List<String> details) {
        Intrinsics3.checkNotNullParameter(action, "action");
        RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Captcha", action, details);
    }
}
