package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.i18n.Hook;
import com.discord.i18n.Hook$a;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemEphemeralMessage$onConfigure$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1(WidgetChatListAdapterItemEphemeralMessage$onConfigure$2 widgetChatListAdapterItemEphemeralMessage$onConfigure$2) {
        super(1);
        this.this$0 = widgetChatListAdapterItemEphemeralMessage$onConfigure$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        View view = this.this$0.this$0.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Integer numValueOf = Integer.valueOf(ColorCompat.getColor(view, 2131099724));
        WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1$1 widgetChatListAdapterItemEphemeralMessage$onConfigure$2$1$1 = new WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1$1(this);
        Objects.requireNonNull(hook);
        m.checkNotNullParameter(widgetChatListAdapterItemEphemeralMessage$onConfigure$2$1$1, "onClick");
        hook.clickHandler = new Hook$a(numValueOf, widgetChatListAdapterItemEphemeralMessage$onConfigure$2$1$1);
    }
}
