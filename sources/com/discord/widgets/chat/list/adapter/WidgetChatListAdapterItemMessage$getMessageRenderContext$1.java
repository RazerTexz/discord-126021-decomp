package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$getMessageRenderContext$1 extends o implements Function3<Context, String, String, Unit> {
    public static final WidgetChatListAdapterItemMessage$getMessageRenderContext$1 INSTANCE = new WidgetChatListAdapterItemMessage$getMessageRenderContext$1();

    public WidgetChatListAdapterItemMessage$getMessageRenderContext$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
        invoke2(context, str, str2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str, String str2) {
        m.checkNotNullParameter(context, "clickContext");
        m.checkNotNullParameter(str, "url");
        UriHandler.handleOrUntrusted(context, str, str2);
    }
}
