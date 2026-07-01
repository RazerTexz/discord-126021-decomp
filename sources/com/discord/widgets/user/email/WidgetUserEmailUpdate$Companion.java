package com.discord.widgets.user.email;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import b.a.d.j;
import com.discord.app.AppFragment;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserEmailUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailUpdate$Companion {
    private WidgetUserEmailUpdate$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void launch$default(WidgetUserEmailUpdate$Companion widgetUserEmailUpdate$Companion, Context context, WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode, ActivityResultLauncher activityResultLauncher, int i, Object obj) {
        if ((i & 4) != 0) {
            activityResultLauncher = null;
        }
        widgetUserEmailUpdate$Companion.launch(context, widgetUserAccountVerifyBase$Mode, activityResultLauncher);
    }

    public final void launch(Context context, WidgetUserAccountVerifyBase$Mode mode, ActivityResultLauncher<Intent> launcher) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(mode, "mode");
        Intent launchIntent = WidgetUserAccountVerifyBase.Companion.getLaunchIntent(mode, false, true);
        if (launcher != null) {
            j.g.f(context, launcher, WidgetUserEmailUpdate.class, launchIntent);
        } else {
            j.d(context, WidgetUserEmailUpdate.class, launchIntent);
        }
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetUserEmailUpdate$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetUserEmailUpdate$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
