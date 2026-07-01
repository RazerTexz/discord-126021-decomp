package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import b.a.d.j;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions$onViewBound$1<R> implements Func0<Boolean> {
    public final /* synthetic */ boolean $isNuxFlow;
    public final /* synthetic */ WidgetGuildInviteShareEmptySuggestions this$0;

    public WidgetGuildInviteShareEmptySuggestions$onViewBound$1(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions, boolean z2) {
        this.this$0 = widgetGuildInviteShareEmptySuggestions;
        this.$isNuxFlow = z2;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        if (WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(this.this$0).getState() != 5) {
            WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(this.this$0).setState(5);
            return Boolean.TRUE;
        }
        if (!this.$isNuxFlow) {
            return Boolean.FALSE;
        }
        j.c(this.this$0.requireContext(), false, null, 6);
        return Boolean.TRUE;
    }
}
