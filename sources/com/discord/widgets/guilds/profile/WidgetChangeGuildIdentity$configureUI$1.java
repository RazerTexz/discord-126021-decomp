package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$configureUI$1<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    public WidgetChangeGuildIdentity$configureUI$1(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel$ViewState widgetChangeGuildIdentityViewModel$ViewState) {
        this.this$0 = widgetChangeGuildIdentity;
        this.$viewState = widgetChangeGuildIdentityViewModel$ViewState;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        return Boolean.valueOf(WidgetChangeGuildIdentity.access$handleBackPressed(this.this$0, (WidgetChangeGuildIdentityViewModel$ViewState$Loaded) this.$viewState));
    }
}
