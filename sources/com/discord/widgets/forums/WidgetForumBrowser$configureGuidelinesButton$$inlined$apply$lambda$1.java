package com.discord.widgets.forums;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowser$configureGuidelinesButton$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetForumBrowserViewModel$ViewState$Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    public WidgetForumBrowser$configureGuidelinesButton$$inlined$apply$lambda$1(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel$ViewState$Loaded widgetForumBrowserViewModel$ViewState$Loaded) {
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = widgetForumBrowserViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetForumGuidelinesBottomSheet$Companion widgetForumGuidelinesBottomSheet$Companion = WidgetForumGuidelinesBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetForumGuidelinesBottomSheet$Companion.show(parentFragmentManager, this.$viewState$inlined.getGuildId(), this.$viewState$inlined.getChannelId(), "CLOSE_FORUM_GUIDELINES_NOOP_REQUEST_KEY");
    }
}
