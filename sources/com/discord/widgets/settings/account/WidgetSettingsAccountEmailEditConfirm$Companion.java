package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.core.app.NotificationCompat;
import b.a.d.j;
import com.discord.app.AppFragment;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm$Companion {
    private WidgetSettingsAccountEmailEditConfirm$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetSettingsAccountEmailEditConfirm$Companion widgetSettingsAccountEmailEditConfirm$Companion, Context context, ActivityResultLauncher activityResultLauncher, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        widgetSettingsAccountEmailEditConfirm$Companion.launch(context, activityResultLauncher, str);
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher, String email) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        Intent intent = new Intent();
        intent.putExtra("extra_email", email);
        j.g.f(context, launcher, WidgetSettingsAccountEmailEditConfirm.class, intent);
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetSettingsAccountEmailEditConfirm$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetSettingsAccountEmailEditConfirm$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
