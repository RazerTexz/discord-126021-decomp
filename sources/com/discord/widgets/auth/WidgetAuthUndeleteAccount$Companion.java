package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import b.a.d.j;
import com.discord.app.AppFragment;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthUndeleteAccount$Companion {
    private WidgetAuthUndeleteAccount$Companion() {
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher, boolean disabled) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        Intent intentPutExtra = new Intent().putExtra("ARG_DISABLED_KEY", disabled);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(ARG_DISABLED_KEY, disabled)");
        j.g.f(context, launcher, WidgetAuthUndeleteAccount.class, intentPutExtra);
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetAuthUndeleteAccount$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetAuthUndeleteAccount$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
