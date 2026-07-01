package com.discord.widgets.chat.list.adapter;

import com.discord.i18n.Hook;
import com.discord.utilities.textprocessing.FontColorSpan;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1$1(WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1 widgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1) {
        super(1);
        this.this$0 = widgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.styles.add(new FontColorSpan(this.this$0.$authorRoleColor));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}
