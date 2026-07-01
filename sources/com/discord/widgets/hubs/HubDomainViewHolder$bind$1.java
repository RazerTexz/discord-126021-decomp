package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HubDomainViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ DomainGuildInfo $data;
    public final /* synthetic */ HubDomainViewHolder this$0;

    public HubDomainViewHolder$bind$1(HubDomainViewHolder hubDomainViewHolder, DomainGuildInfo domainGuildInfo) {
        this.this$0 = hubDomainViewHolder;
        this.$data = domainGuildInfo;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getOnClickListener().invoke(this.$data);
    }
}
