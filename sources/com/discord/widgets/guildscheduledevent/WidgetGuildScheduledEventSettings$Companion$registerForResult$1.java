package com.discord.widgets.guildscheduledevent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$Companion$registerForResult$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function0 $onFinished;
    public final /* synthetic */ Function0 $onQuit;

    public WidgetGuildScheduledEventSettings$Companion$registerForResult$1(Function0 function0, Function0 function1) {
        this.$onFinished = function0;
        this.$onQuit = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* JADX INFO: renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        m.checkNotNullExpressionValue(activityResult, "result");
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            this.$onFinished.invoke();
        } else {
            if (resultCode != 2) {
                return;
            }
            this.$onQuit.invoke();
        }
    }
}
