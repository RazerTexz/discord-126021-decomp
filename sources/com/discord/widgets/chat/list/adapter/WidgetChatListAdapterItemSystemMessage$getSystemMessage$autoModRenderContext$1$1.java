package com.discord.widgets.chat.list.adapter;

import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.discord.i18n.Hook;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$1(WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1 widgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1) {
        super(1);
        this.this$0 = widgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.styles.add(new ForegroundColorSpan(ColorCompat.getColor(this.this$0.$context, 2131099763)));
        hook.styles.add(new StyleSpan(1));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}
