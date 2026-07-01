package com.discord.widgets.status;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatStatus$getUnreadMessageText$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $count;
    public final /* synthetic */ String $utcDateTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatStatus$getUnreadMessageText$1(int i, String str) {
        super(1);
        this.$count = i;
        this.$utcDateTime = str;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("count", String.valueOf(this.$count));
        renderContext.args.put("timestamp", this.$utcDateTime);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
