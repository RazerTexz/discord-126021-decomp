package com.discord.utilities.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppFragment;
import com.discord.widgets.hubs.AddServerConfirmationArgs;
import com.discord.widgets.hubs.DescriptionResult;
import com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: HubUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HubUtilsKt {
    public static final ActivityResultLauncher<Intent> getAddServerActivityResultHandler(final AppFragment appFragment) {
        C12238m.checkNotNullParameter(appFragment, "$this$getAddServerActivityResultHandler");
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
                    C12238m.checkNotNullParameter(data, "$this$getArgsFromIntent");
                    DescriptionResult descriptionResult = (DescriptionResult) data.getParcelableExtra("intent_args_key");
                    if (descriptionResult != null) {
                        WidgetHubAddServerConfirmationDialog.Companion companion = WidgetHubAddServerConfirmationDialog.INSTANCE;
                        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
                        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        companion.show(parentFragmentManager, new AddServerConfirmationArgs(descriptionResult.getGuildId(), descriptionResult.getHubName()));
                    }
                }
            }
        });
        C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…      )\n          }\n    }");
        return activityResultLauncherRegisterForActivityResult;
    }
}
