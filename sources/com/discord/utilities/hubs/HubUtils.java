package com.discord.utilities.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppFragment;
import com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog;
import com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog2;
import com.discord.widgets.hubs.WidgetHubDescription2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.hubs.HubUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: HubUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HubUtils {
    public static final ActivityResultLauncher<Intent> getAddServerActivityResultHandler(final AppFragment appFragment) {
        Intrinsics3.checkNotNullParameter(appFragment, "$this$getAddServerActivityResultHandler");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = appFragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.utilities.hubs.HubUtilsKt.getAddServerActivityResultHandler.1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(ActivityResult activityResult) {
                Intent data;
                if (activityResult == null || (data = activityResult.getData()) == null) {
                    return;
                }
                if (!(activityResult.getResultCode() == -1)) {
                    data = null;
                }
                if (data != null) {
                    Intrinsics3.checkNotNullParameter(data, "$this$getArgsFromIntent");
                    WidgetHubDescription2 widgetHubDescription2 = (WidgetHubDescription2) data.getParcelableExtra("intent_args_key");
                    if (widgetHubDescription2 != null) {
                        WidgetHubAddServerConfirmationDialog.Companion companion = WidgetHubAddServerConfirmationDialog.INSTANCE;
                        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        companion.show(parentFragmentManager, new WidgetHubAddServerConfirmationDialog2(widgetHubDescription2.getGuildId(), widgetHubDescription2.getHubName()));
                    }
                }
            }
        });
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…      )\n          }\n    }");
        return activityResultLauncherRegisterForActivityResult;
    }
}
