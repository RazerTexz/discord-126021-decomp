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

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify$Companion {
    private WidgetAuthPhoneVerify$Companion() {
    }

    public final void launch(Context context, ActivityResultLauncher<Intent> launcher, String phone, CharSequence title, CharSequence subtitle) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(launcher, "launcher");
        m.checkNotNullParameter(phone, "phone");
        m.checkNotNullParameter(title, "title");
        m.checkNotNullParameter(subtitle, "subtitle");
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_PHONE", phone);
        intent.putExtra("INTENT_EXTRA_TITLE", title);
        intent.putExtra("INTENT_EXTRA_SUBTITLE", subtitle);
        j.g.f(context, launcher, WidgetAuthPhoneVerify.class, intent);
    }

    public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function1<? super WidgetAuthPhoneVerify$Result, Unit> callback) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetAuthPhoneVerify$Companion$registerForResult$1(callback));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…ed)\n          }\n        }");
        return activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ WidgetAuthPhoneVerify$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
