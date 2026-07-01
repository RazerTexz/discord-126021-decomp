package com.discord.utilities.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppFragment;
import com.discord.widgets.hubs.AddServerConfirmationArgs;
import com.discord.widgets.hubs.DescriptionResult;
import com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog;
import com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: HubUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HubUtilsKt$getAddServerActivityResultHandler$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ AppFragment $this_getAddServerActivityResultHandler;

    public HubUtilsKt$getAddServerActivityResultHandler$1(AppFragment appFragment) {
        this.$this_getAddServerActivityResultHandler = appFragment;
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intent data;
        if (activityResult == null || (data = activityResult.getData()) == null) {
            return;
        }
        if (!(activityResult.getResultCode() == -1)) {
            data = null;
        }
        if (data != null) {
            m.checkNotNullParameter(data, "$this$getArgsFromIntent");
            DescriptionResult descriptionResult = (DescriptionResult) data.getParcelableExtra("intent_args_key");
            if (descriptionResult != null) {
                WidgetHubAddServerConfirmationDialog$Companion widgetHubAddServerConfirmationDialog$Companion = WidgetHubAddServerConfirmationDialog.Companion;
                FragmentManager parentFragmentManager = this.$this_getAddServerActivityResultHandler.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                widgetHubAddServerConfirmationDialog$Companion.show(parentFragmentManager, new AddServerConfirmationArgs(descriptionResult.getGuildId(), descriptionResult.getHubName()));
            }
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }
}
