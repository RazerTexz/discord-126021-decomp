package com.discord.widgets.chat.list.adapter;

import com.discord.i18n.Hook;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3$1(WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3 widgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3) {
        super(1);
        this.this$0 = widgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.styles.add(new SimpleRoundedBackgroundSpan(0, this.this$0.$channelNameLength, DimenUtils.dpToPixels(4), 0, ColorCompat.getThemedColor(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(this.this$0.this$0).getContext(), 2130968909), DimenUtils.dpToPixels(4), Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(this.this$0.this$0).getContext(), 2130968989)), false, null, 0, 896, null));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}
