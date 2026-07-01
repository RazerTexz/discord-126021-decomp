package com.discord.widgets.chat.list.adapter;

import android.text.style.StyleSpan;
import com.discord.i18n.Hook;
import com.discord.utilities.spans.ClickableSpan;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$2 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$2(WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1 widgetChatListAdapterItemApplicationCommand$onConfigure$content$1) {
        super(1);
        this.this$0 = widgetChatListAdapterItemApplicationCommand$onConfigure$content$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.styles.add(new StyleSpan(1));
        hook.styles.add(new ClickableSpan(Integer.valueOf(this.this$0.$cmdColor), false, null, WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$2$1.INSTANCE, 4, null));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}
