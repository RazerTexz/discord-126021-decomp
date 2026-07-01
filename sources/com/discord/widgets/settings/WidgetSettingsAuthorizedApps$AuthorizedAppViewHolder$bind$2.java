package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelOAuth2Token;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder$bind$2 implements View$OnClickListener {
    public final /* synthetic */ ModelOAuth2Token $data;
    public final /* synthetic */ WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder this$0;

    public WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder$bind$2(WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder widgetSettingsAuthorizedApps$AuthorizedAppViewHolder, ModelOAuth2Token modelOAuth2Token) {
        this.this$0 = widgetSettingsAuthorizedApps$AuthorizedAppViewHolder;
        this.$data = modelOAuth2Token;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder.access$getOnDeauthorizeClick$p(this.this$0).invoke(this.$data);
    }
}
