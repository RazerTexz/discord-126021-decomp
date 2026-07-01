package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.widgets.hubs.HubEmailArgs;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite$configureResolvedUI$4$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemInvite$configureResolvedUI$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInvite$configureResolvedUI$4$1(WidgetChatListAdapterItemInvite$configureResolvedUI$4 widgetChatListAdapterItemInvite$configureResolvedUI$4) {
        super(1);
        this.this$0 = widgetChatListAdapterItemInvite$configureResolvedUI$4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChatListAdapterItemInvite.access$launchHubsEmail(this.this$0.this$0, new HubEmailArgs(null, 0, null, 7, null));
    }
}
