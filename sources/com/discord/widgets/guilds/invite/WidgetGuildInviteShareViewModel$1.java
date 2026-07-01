package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel$1<T> implements Action1<WidgetGuildInviteShareViewModel$ViewState$Loaded> {
    public final /* synthetic */ WidgetGuildInviteShareViewModel this$0;

    public WidgetGuildInviteShareViewModel$1(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        this.this$0 = widgetGuildInviteShareViewModel;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded) {
        call2(widgetGuildInviteShareViewModel$ViewState$Loaded);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded) {
        WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetGuildInviteShareViewModel$ViewState$Loaded, "viewState");
        WidgetGuildInviteShareViewModel.access$generateInviteLinkFromViewState(widgetGuildInviteShareViewModel, widgetGuildInviteShareViewModel$ViewState$Loaded);
    }
}
