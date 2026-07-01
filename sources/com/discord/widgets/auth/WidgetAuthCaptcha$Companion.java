package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import b.a.d.j;
import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetAuthCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthCaptcha$Companion {
    private WidgetAuthCaptcha$Companion() {
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher, CaptchaErrorBody captchaErrorBody) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        Intent intent = new Intent();
        intent.putExtra("EXTRA_CAPTCHA_ERROR_BODY", captchaErrorBody);
        j.g.f(context, launcher, WidgetAuthCaptcha.class, intent);
    }

    public final void processErrorsForCaptcha(Context context, ActivityResultLauncher<Intent> launcher, List<String> unhandledErrors, Error error) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        m.checkNotNullParameter(unhandledErrors, "unhandledErrors");
        m.checkNotNullParameter(error, "error");
        if (unhandledErrors.remove(CaptchaHelper.CAPTCHA_KEY)) {
            launch(context, launcher, CaptchaErrorBody.Companion.createFromError(error));
            error.setShowErrorToasts(false);
        }
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function1<? super CaptchaHelper$CaptchaPayload, Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetAuthCaptcha$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetAuthCaptcha$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
