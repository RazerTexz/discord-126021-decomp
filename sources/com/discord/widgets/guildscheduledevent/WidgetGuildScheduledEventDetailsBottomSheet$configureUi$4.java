package com.discord.widgets.guildscheduledevent;

import com.discord.i18n.RenderContext;
import com.discord.models.guild.UserGuildMember;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ UserGuildMember $creator;
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet, UserGuildMember userGuildMember) {
        super(1);
        this.this$0 = widgetGuildScheduledEventDetailsBottomSheet;
        this.$creator = userGuildMember;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("usernameHook", new WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4$1(this));
    }
}
