package com.discord.widgets.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentActivity;
import com.discord.stores.StoreStream;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow$activityResultHandler$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    public WidgetHubEmailFlow$activityResultHandler$1(WidgetHubEmailFlow widgetHubEmailFlow) {
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
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
            MultipleDomainResult multipleDomainResult = (MultipleDomainResult) data.getParcelableExtra("intent_args_key");
            if (multipleDomainResult != null) {
                if (multipleDomainResult instanceof HubWaitlistResult) {
                    WidgetHubEmailFlow.access$getViewModel$p(this.this$0).setHubWaitlistResult((HubWaitlistResult) multipleDomainResult);
                    return;
                }
                if (!(multipleDomainResult instanceof AuthenticationResult)) {
                    FragmentActivity activity = this.this$0.getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                StoreStream.Companion.getGuildSelected().set(((AuthenticationResult) multipleDomainResult).getGuildId());
                FragmentActivity activity2 = this.this$0.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
    }
}
