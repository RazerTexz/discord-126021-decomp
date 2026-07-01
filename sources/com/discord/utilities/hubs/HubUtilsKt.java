package com.discord.utilities.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import com.discord.app.AppFragment;
import d0.z.d.m;

/* JADX INFO: compiled from: HubUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HubUtilsKt {
    public static final ActivityResultLauncher<Intent> getAddServerActivityResultHandler(AppFragment appFragment) {
        m.checkNotNullParameter(appFragment, "$this$getAddServerActivityResultHandler");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = appFragment.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new HubUtilsKt$getAddServerActivityResultHandler$1(appFragment));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…      )\n          }\n    }");
        return activityResultLauncherRegisterForActivityResult;
    }
}
