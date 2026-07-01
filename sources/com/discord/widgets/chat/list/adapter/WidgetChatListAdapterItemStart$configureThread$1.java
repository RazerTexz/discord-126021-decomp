package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import com.discord.i18n.RenderContext;
import com.discord.models.member.GuildMember;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStart$configureThread$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ GuildMember $threadCreatorMember;
    public final /* synthetic */ String $threadCreatorName;
    public final /* synthetic */ WidgetChatListAdapterItemStart this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStart$configureThread$1(WidgetChatListAdapterItemStart widgetChatListAdapterItemStart, String str, Context context, GuildMember guildMember) {
        super(1);
        this.this$0 = widgetChatListAdapterItemStart;
        this.$threadCreatorName = str;
        this.$context = context;
        this.$threadCreatorMember = guildMember;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("usernameHook", new WidgetChatListAdapterItemStart$configureThread$1$1(this));
    }
}
