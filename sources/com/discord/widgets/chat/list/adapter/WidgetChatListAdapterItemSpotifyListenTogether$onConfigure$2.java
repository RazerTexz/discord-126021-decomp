package com.discord.widgets.chat.list.adapter;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether$onConfigure$2 extends o implements Function1<WidgetChatListAdapterItemSpotifyListenTogether$Model, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogether this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSpotifyListenTogether$onConfigure$2(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether) {
        super(1);
        this.this$0 = widgetChatListAdapterItemSpotifyListenTogether;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListAdapterItemSpotifyListenTogether$Model widgetChatListAdapterItemSpotifyListenTogether$Model) {
        invoke2(widgetChatListAdapterItemSpotifyListenTogether$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListAdapterItemSpotifyListenTogether$Model widgetChatListAdapterItemSpotifyListenTogether$Model) {
        m.checkNotNullParameter(widgetChatListAdapterItemSpotifyListenTogether$Model, "it");
        WidgetChatListAdapterItemSpotifyListenTogether.access$configureUI(this.this$0, widgetChatListAdapterItemSpotifyListenTogether$Model);
    }
}
