package com.discord.widgets.chat.list.adapter;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $authorRoleColor;
    public final /* synthetic */ int $otherRoleColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1(int i, int i2) {
        super(1);
        this.$authorRoleColor = i;
        this.$otherRoleColor = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("usernameOnClick", new WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1$1(this));
        renderContext.a("otherUsernameOnClick", new WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1$2(this));
    }
}
