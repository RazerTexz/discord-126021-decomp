package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$8 */
/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7460x3de5455f extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChannelsListItemChannelActions.Model $this_configureUI$inlined;
    public final /* synthetic */ WidgetChannelsListItemChannelActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7460x3de5455f(WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions, WidgetChannelsListItemChannelActions.Model model) {
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
        Context context = view.getContext();
        C12238m.checkNotNullExpressionValue(context, "it.context");
        C0876m.m165c(context, String.valueOf(this.$this_configureUI$inlined.getChannel().getId()), 0, 4);
    }
}
