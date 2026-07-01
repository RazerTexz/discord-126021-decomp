package com.discord.widgets.status;

import androidx.media.AudioAttributesCompat;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel$toggleFollowPost$3 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetForumPostStatusViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetForumPostStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatusViewModel$toggleFollowPost$3(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel, WidgetForumPostStatusViewModel$ViewState$Valid widgetForumPostStatusViewModel$ViewState$Valid) {
        super(0);
        this.this$0 = widgetForumPostStatusViewModel;
        this.$viewState = widgetForumPostStatusViewModel$ViewState$Valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetForumPostStatusViewModel.access$setFollowRequestInProgress$p(this.this$0, false);
        WidgetForumPostStatusViewModel.access$updateViewState(this.this$0, WidgetForumPostStatusViewModel$ViewState$Valid.copy$default(this.$viewState, 0L, 0L, 0L, false, false, null, null, false, 0, false, false, AudioAttributesCompat.FLAG_ALL, null));
    }
}
