package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import b.a.d.j;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact$onViewBound$1<R> implements Func0<Boolean> {
    public final /* synthetic */ boolean $isNuxFlow;
    public final /* synthetic */ WidgetGuildInviteShareCompact this$0;

    public WidgetGuildInviteShareCompact$onViewBound$1(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, boolean z2) {
        this.this$0 = widgetGuildInviteShareCompact;
        this.$isNuxFlow = z2;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        if (WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(this.this$0).getState() != 5) {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(this.this$0).setState(5);
            return Boolean.TRUE;
        }
        if (!this.$isNuxFlow) {
            return Boolean.FALSE;
        }
        j.c(this.this$0.requireContext(), false, null, 6);
        return Boolean.TRUE;
    }
}
