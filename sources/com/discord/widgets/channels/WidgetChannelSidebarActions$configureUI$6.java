package com.discord.widgets.channels;

import android.content.Context;
import android.view.View;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions$configureUI$6 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetChannelSidebarActionsViewModel$ViewState $viewState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSidebarActions$configureUI$6(Context context, WidgetChannelSidebarActionsViewModel$ViewState widgetChannelSidebarActionsViewModel$ViewState) {
        super(1);
        this.$context = context;
        this.$viewState = widgetChannelSidebarActionsViewModel$ViewState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetThreadBrowser.Companion.show(this.$context, ((WidgetChannelSidebarActionsViewModel$ViewState$Guild) this.$viewState).getGuildId(), ((WidgetChannelSidebarActionsViewModel$ViewState$Guild) this.$viewState).getChannelId(), "Channel Side Bar");
    }
}
