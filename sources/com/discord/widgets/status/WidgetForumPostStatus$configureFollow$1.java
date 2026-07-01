package com.discord.widgets.status;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatus$configureFollow$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetForumPostStatusViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetForumPostStatus this$0;

    public WidgetForumPostStatus$configureFollow$1(WidgetForumPostStatus widgetForumPostStatus, WidgetForumPostStatusViewModel$ViewState$Valid widgetForumPostStatusViewModel$ViewState$Valid) {
        this.this$0 = widgetForumPostStatus;
        this.$viewState = widgetForumPostStatusViewModel$ViewState$Valid;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$viewState.getFollowRequestInProgress()) {
            return;
        }
        WidgetForumPostStatusViewModel widgetForumPostStatusViewModelAccess$getViewModel$p = WidgetForumPostStatus.access$getViewModel$p(this.this$0);
        Context contextRequireContext = this.this$0.requireContext();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetForumPostStatusViewModelAccess$getViewModel$p.onFollowPress(contextRequireContext, parentFragmentManager, this.$viewState.getGuildId(), this.$viewState.getChannelId(), this.$viewState.isArchivedThread(), this.$viewState.isFollowedThread());
    }
}
