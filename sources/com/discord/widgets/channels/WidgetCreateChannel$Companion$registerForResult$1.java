package com.discord.widgets.channels;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$Companion$registerForResult$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function3 $callback;

    public WidgetCreateChannel$Companion$registerForResult$1(Function3 function3) {
        this.$callback = function3;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intent data;
        m.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null) {
            return;
        }
        long longExtra = data.getLongExtra("RESULT_EXTRA_CHANNEL_ID", -1L);
        String stringExtra = data.getStringExtra("RESULT_EXTRA_CHANNEL_NAME");
        int intExtra = data.getIntExtra("RESULT_EXTRA_CHANNEL_ICON_RES_ID", -1);
        if (longExtra != -1) {
            if ((stringExtra == null || t.isBlank(stringExtra)) || intExtra == -1) {
                return;
            }
            this.$callback.invoke(Long.valueOf(longExtra), stringExtra, Integer.valueOf(intExtra));
        }
    }
}
