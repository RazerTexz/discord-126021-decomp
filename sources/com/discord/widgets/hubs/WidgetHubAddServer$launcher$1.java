package com.discord.widgets.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.widgets.guilds.create.WidgetGuildCreate$Result;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer$launcher$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ WidgetHubAddServer this$0;

    public WidgetHubAddServer$launcher$1(WidgetHubAddServer widgetHubAddServer) {
        this.this$0 = widgetHubAddServer;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        WidgetGuildCreate$Result widgetGuildCreate$Result;
        m.checkNotNullExpressionValue(activityResult, "activityResult");
        Intent data = activityResult.getData();
        if (data != null) {
            if (!(activityResult.getResultCode() == -1)) {
                data = null;
            }
            if (data == null || (widgetGuildCreate$Result = (WidgetGuildCreate$Result) data.getParcelableExtra("intent_args_key")) == null) {
                return;
            }
            WidgetHubAddServer.access$onServerClickListener(this.this$0, widgetGuildCreate$Result.getGuildId(), true);
        }
    }
}
