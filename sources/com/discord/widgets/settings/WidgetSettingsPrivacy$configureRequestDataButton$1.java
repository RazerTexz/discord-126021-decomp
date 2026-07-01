package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.rest.RestAPI$HarvestState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configureRequestDataButton$1 implements View$OnClickListener {
    public final /* synthetic */ RestAPI$HarvestState $harvestState;
    public final /* synthetic */ boolean $isMeVerified;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$configureRequestDataButton$1(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2, RestAPI$HarvestState restAPI$HarvestState) {
        this.this$0 = widgetSettingsPrivacy;
        this.$isMeVerified = z2;
        this.$harvestState = restAPI$HarvestState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        RestAPI$HarvestState restAPI$HarvestState;
        Context context = this.this$0.getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
            if (!this.$isMeVerified || (restAPI$HarvestState = this.$harvestState) == null) {
                b.a.d.m.i(this.this$0, 2131888347, 0, 4);
            } else {
                WidgetSettingsPrivacy.access$onRequestDataClick(this.this$0, context, restAPI$HarvestState);
            }
        }
    }
}
