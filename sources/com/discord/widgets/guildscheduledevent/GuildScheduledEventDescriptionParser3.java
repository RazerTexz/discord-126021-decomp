package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDescriptionParser;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser3 extends Lambda implements Function1<GuildScheduledEventDescriptionParser.MessageRenderContextModel, Unit> {
    public final /* synthetic */ List $descriptionAst$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ LinkifiedTextView $this_apply;
    public final /* synthetic */ GuildScheduledEventDescriptionParser this$0;

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<SpoilerNode<?>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            Intrinsics3.checkNotNullParameter(spoilerNode, "spoilerNode");
            GuildScheduledEventDescriptionParser3 guildScheduledEventDescriptionParser3 = GuildScheduledEventDescriptionParser3.this;
            guildScheduledEventDescriptionParser3.this$0.handleSpoilerClicked(spoilerNode, guildScheduledEventDescriptionParser3.$guildId$inlined);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDescriptionParser3(LinkifiedTextView linkifiedTextView, GuildScheduledEventDescriptionParser guildScheduledEventDescriptionParser, List list, long j) {
        super(1);
        this.$this_apply = linkifiedTextView;
        this.this$0 = guildScheduledEventDescriptionParser;
        this.$descriptionAst$inlined = list;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDescriptionParser.MessageRenderContextModel messageRenderContextModel) {
        invoke2(messageRenderContextModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEventDescriptionParser.MessageRenderContextModel messageRenderContextModel) {
        Context context = this.$this_apply.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.$this_apply.setDraweeSpanStringBuilder(AstRenderer.render(this.$descriptionAst$inlined, new MessageRenderContext(context, 0L, false, messageRenderContextModel.getUserNames(), messageRenderContextModel.getChannelNames(), messageRenderContextModel.getRoles(), 0, null, null, 0, 0, anonymousClass1, null, null, 14272, null)));
    }
}
