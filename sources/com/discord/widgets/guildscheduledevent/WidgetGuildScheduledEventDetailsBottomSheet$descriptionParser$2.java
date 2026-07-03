package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.view.text.LinkifiedTextView;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet$descriptionParser$2 extends AbstractC12240o implements Function0<GuildScheduledEventDescriptionParser> {
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventDetailsBottomSheet$descriptionParser$2(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        super(0);
        this.this$0 = widgetGuildScheduledEventDetailsBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventDescriptionParser invoke() {
        LinkifiedTextView linkifiedTextView = this.this$0.getBinding().f16986h;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventDetailsDescText");
        return new GuildScheduledEventDescriptionParser(linkifiedTextView);
    }
}
