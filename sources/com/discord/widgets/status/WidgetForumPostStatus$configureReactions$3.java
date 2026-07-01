package com.discord.widgets.status;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatus$configureReactions$3 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetForumPostStatusViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetForumPostStatus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatus$configureReactions$3(WidgetForumPostStatus widgetForumPostStatus, WidgetForumPostStatusViewModel$ViewState$Valid widgetForumPostStatusViewModel$ViewState$Valid) {
        super(1);
        this.this$0 = widgetForumPostStatus;
        this.$viewState = widgetForumPostStatusViewModel$ViewState$Valid;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetForumPostStatusViewModel widgetForumPostStatusViewModelAccess$getViewModel$p = WidgetForumPostStatus.access$getViewModel$p(this.this$0);
        Context contextRequireContext = this.this$0.requireContext();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetForumPostStatusViewModelAccess$getViewModel$p.onReactionLongPress(contextRequireContext, parentFragmentManager, this.$viewState.getMessageId().longValue(), this.$viewState.getGuildId(), this.$viewState.getChannelId(), this.$viewState.isArchivedThread(), this.$viewState.getReaction());
    }
}
