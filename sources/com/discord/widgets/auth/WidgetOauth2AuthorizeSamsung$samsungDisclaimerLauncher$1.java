package com.discord.widgets.auth;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.app.AppActivity;
import com.discord.samsung.SamsungConnectActivity;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung$samsungDisclaimerLauncher$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    public WidgetOauth2AuthorizeSamsung$samsungDisclaimerLauncher$1(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Bundle extras;
        Bundle extras2;
        m.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1) {
            SamsungConnectActivity.b(this.this$0.requireContext(), WidgetOauth2AuthorizeSamsung.access$getSamsungConnectLauncher$p(this.this$0), 5459);
            return;
        }
        Intent data = activityResult.getData();
        Object obj = (data == null || (extras2 = data.getExtras()) == null) ? null : extras2.get("error_message");
        Intent data2 = activityResult.getData();
        Object obj2 = (data2 == null || (extras = data2.getExtras()) == null) ? null : extras.get("error_code");
        WidgetOauth2AuthorizeSamsung$Companion.logW$default(WidgetOauth2AuthorizeSamsung.Companion, "Connection requires disclaimer acceptance. [" + obj2 + "] " + obj, null, 2, null);
        b.a.d.m.i(this.this$0, 2131888997, 0, 4);
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }
}
