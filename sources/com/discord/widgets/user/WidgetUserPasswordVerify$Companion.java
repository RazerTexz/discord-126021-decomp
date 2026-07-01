package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.d.j;
import com.discord.app.AppFragment;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPasswordVerify$Companion {
    private WidgetUserPasswordVerify$Companion() {
    }

    private final void launch(Context context, ActivityResultLauncher<Intent> launcher, Bundle extras) {
        AnalyticsTracker.openModal$default("Account Settings Password Verification", "", null, 4, null);
        j.g.f(context, launcher, WidgetUserPasswordVerify.class, new Intent().putExtras(extras));
    }

    public static /* synthetic */ void launchUpdateAccountSettings$default(WidgetUserPasswordVerify$Companion widgetUserPasswordVerify$Companion, Context context, ActivityResultLauncher activityResultLauncher, String str, String str2, String str3, String str4, int i, Object obj) {
        widgetUserPasswordVerify$Companion.launchUpdateAccountSettings(context, activityResultLauncher, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }

    public final void launchRemovePhoneNumber(Context context, ActivityResultLauncher<Intent> launcher) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        Bundle bundle = new Bundle();
        bundle.putSerializable("INTENT_EXTRA_ACTION", WidgetUserPasswordVerify$Companion$Action.RemovePhoneNumber);
        launch(context, launcher, bundle);
    }

    public final void launchUpdateAccountSettings(Context context, ActivityResultLauncher<Intent> launcher, String email, String username, String discriminator, String email_token) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        Bundle bundle = new Bundle();
        bundle.putSerializable("INTENT_EXTRA_ACTION", WidgetUserPasswordVerify$Companion$Action.UpdateAccountInfo);
        bundle.putString("INTENT_EXTRA_EMAIL", email);
        bundle.putString("INTENT_EXTRA_USERNAME", username);
        bundle.putString("INTENT_EXTRA_DISCRIMINATOR", discriminator);
        bundle.putString("INTENT_EXTRA_EMAIL_TOKEN", email_token);
        launch(context, launcher, bundle);
    }

    public final void launchUpdatePhoneNumber(Context context, ActivityResultLauncher<Intent> launcher, String phoneToken, String source) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        m.checkNotNullParameter(phoneToken, "phoneToken");
        m.checkNotNullParameter(source, "source");
        Bundle bundle = new Bundle();
        bundle.putSerializable("INTENT_EXTRA_ACTION", WidgetUserPasswordVerify$Companion$Action.UpdatePhoneNumber);
        bundle.putString("INTENT_EXTRA_PHONE_TOKEN", phoneToken);
        bundle.putString("INTENT_EXTRA_SOURCE_TYPE", source);
        launch(context, launcher, bundle);
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetUserPasswordVerify$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetUserPasswordVerify$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
