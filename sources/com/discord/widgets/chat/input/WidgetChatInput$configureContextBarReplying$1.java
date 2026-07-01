package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.i18n.RenderContext;
import com.discord.models.member.GuildMember;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureContextBarReplying$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying $model;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$configureContextBarReplying$1(Context context, ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying) {
        super(1);
        this.$context = context;
        this.$model = chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.boldColor = Integer.valueOf(GuildMember.Companion.getColor(this.$model.getRepliedAuthorGuildMember(), ColorCompat.getThemedColor(this.$context, 2130968989)));
    }
}
