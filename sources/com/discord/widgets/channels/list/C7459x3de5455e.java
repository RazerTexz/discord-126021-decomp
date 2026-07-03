package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.stores.StoreStream;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$7 */
/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7459x3de5455e extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChannelsListItemChannelActions.Model $this_configureUI$inlined;
    public final /* synthetic */ WidgetChannelsListItemChannelActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7459x3de5455e(WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions, WidgetChannelsListItemChannelActions.Model model) {
        super(1);
        this.this$0 = widgetChannelsListItemChannelActions;
        this.$this_configureUI$inlined = model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        StoreStream.INSTANCE.getMessageAck().ack(this.$this_configureUI$inlined.getChannel().getId(), false, true);
    }
}
