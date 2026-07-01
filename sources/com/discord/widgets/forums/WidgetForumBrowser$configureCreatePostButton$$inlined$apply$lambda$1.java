package com.discord.widgets.forums;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowser$configureCreatePostButton$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ boolean $hasForumGuidelines;
    public final /* synthetic */ WidgetForumBrowserViewModel$ViewState$Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    public WidgetForumBrowser$configureCreatePostButton$$inlined$apply$lambda$1(boolean z2, WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel$ViewState$Loaded widgetForumBrowserViewModel$ViewState$Loaded) {
        this.$hasForumGuidelines = z2;
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = widgetForumBrowserViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetForumBrowser.access$onCreatePostClick(this.this$0, this.$viewState$inlined.getGuildId(), this.$viewState$inlined.getChannelId(), this.$hasForumGuidelines);
    }
}
