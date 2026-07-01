package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1 extends o implements Function1<GuildScheduledEventDescriptionParser$MessageRenderContextModel, Unit> {
    public final /* synthetic */ List $descriptionAst$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ LinkifiedTextView $this_apply;
    public final /* synthetic */ GuildScheduledEventDescriptionParser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1(LinkifiedTextView linkifiedTextView, GuildScheduledEventDescriptionParser guildScheduledEventDescriptionParser, List list, long j) {
        super(1);
        this.$this_apply = linkifiedTextView;
        this.this$0 = guildScheduledEventDescriptionParser;
        this.$descriptionAst$inlined = list;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDescriptionParser$MessageRenderContextModel guildScheduledEventDescriptionParser$MessageRenderContextModel) {
        invoke2(guildScheduledEventDescriptionParser$MessageRenderContextModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEventDescriptionParser$MessageRenderContextModel guildScheduledEventDescriptionParser$MessageRenderContextModel) {
        Context context = this.$this_apply.getContext();
        m.checkNotNullExpressionValue(context, "context");
        GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1$1 guildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1$1 = new GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1$1(this);
        this.$this_apply.setDraweeSpanStringBuilder(AstRenderer.render(this.$descriptionAst$inlined, new MessageRenderContext(context, 0L, false, guildScheduledEventDescriptionParser$MessageRenderContextModel.getUserNames(), guildScheduledEventDescriptionParser$MessageRenderContextModel.getChannelNames(), guildScheduledEventDescriptionParser$MessageRenderContextModel.getRoles(), 0, null, null, 0, 0, guildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1$1, null, null, 14272, null)));
    }
}
