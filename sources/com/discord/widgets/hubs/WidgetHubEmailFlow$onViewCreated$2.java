package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.discord.stores.StoreStream;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.nux.WidgetGuildTemplates;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow$onViewCreated$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    public WidgetHubEmailFlow$onViewCreated$2(WidgetHubEmailFlow widgetHubEmailFlow) {
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            m.checkNotNullExpressionValue(activity, "activity ?: return@setOnClickListener");
            if (WidgetHubEmailFlow.access$getArgs$p(this.this$0).getEntryPoint() == HubEmailEntryPoint.Onboarding) {
                StoreStream.Companion.getNux().updateNux(WidgetHubEmailFlow$onViewCreated$2$1.INSTANCE);
                WidgetGuildTemplates.Companion.launch(activity, CreateGuildTrigger.NUF, true);
            }
            activity.finish();
        }
    }
}
