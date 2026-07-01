package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildScheduledEventItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventItemView$descriptionParser$2 extends o implements Function0<GuildScheduledEventDescriptionParser> {
    public final /* synthetic */ GuildScheduledEventItemView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventItemView$descriptionParser$2(GuildScheduledEventItemView guildScheduledEventItemView) {
        super(0);
        this.this$0 = guildScheduledEventItemView;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEventDescriptionParser invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventDescriptionParser invoke() {
        LinkifiedTextView linkifiedTextView = GuildScheduledEventItemView.access$getBinding$p(this.this$0).f;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventListItemDescText");
        return new GuildScheduledEventDescriptionParser(linkifiedTextView);
    }
}
