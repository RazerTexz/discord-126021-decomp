package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import b.a.d.j;
import com.discord.app.AppFragment;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday$Companion {
    private WidgetAuthBirthday$Companion() {
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        j.g.f(context, launcher, WidgetAuthBirthday.class, null);
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function1<? super Long, Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetAuthBirthday$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…ay)\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetAuthBirthday$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
