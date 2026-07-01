package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.a.d.j;
import com.discord.app.AppFragment;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify$Companion {
    private WidgetUserPhoneVerify$Companion() {
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher, WidgetUserAccountVerifyBase$Mode mode, String phoneNumber, String source) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        m.checkNotNullParameter(mode, "mode");
        m.checkNotNullParameter(source, "source");
        Intent launchIntent = WidgetUserAccountVerifyBase.Companion.getLaunchIntent(mode, true, false);
        if (mode == WidgetUserAccountVerifyBase$Mode.NO_HISTORY_FROM_USER_SETTINGS) {
            launchIntent.addFlags(BasicMeasure.EXACTLY);
        }
        launchIntent.putExtra("INTENT_EXTRA_PHONE_NUMBER", phoneNumber);
        launchIntent.putExtra("INTENT_EXTRA_SOURCE_TYPE", source);
        j.g.f(context, launcher, WidgetUserPhoneVerify.class, launchIntent);
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetUserPhoneVerify$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetUserPhoneVerify$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
