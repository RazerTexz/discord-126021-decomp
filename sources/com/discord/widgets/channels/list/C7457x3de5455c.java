package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import com.discord.api.channel.ChannelUtils;
import com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.voice.settings.WidgetVoiceChannelSettings;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$5 */
/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7457x3de5455c extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChannelsListItemChannelActions.Model $this_configureUI$inlined;
    public final /* synthetic */ WidgetChannelsListItemChannelActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7457x3de5455c(WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions, WidgetChannelsListItemChannelActions.Model model) {
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
        C12238m.checkNotNullParameter(view, "view");
        if (ChannelUtils.m7702z(this.$this_configureUI$inlined.getChannel())) {
            WidgetChannelGroupDMSettings.Companion companion = WidgetChannelGroupDMSettings.INSTANCE;
            long id2 = this.$this_configureUI$inlined.getChannel().getId();
            Context context = view.getContext();
            C12238m.checkNotNullExpressionValue(context, "view.context");
            companion.create(id2, context);
            return;
        }
        if (ChannelUtils.m7699w(this.$this_configureUI$inlined.getChannel())) {
            WidgetVoiceChannelSettings.Companion companion2 = WidgetVoiceChannelSettings.INSTANCE;
            long id3 = this.$this_configureUI$inlined.getChannel().getId();
            Context context2 = view.getContext();
            C12238m.checkNotNullExpressionValue(context2, "view.context");
            companion2.launch(id3, context2);
            return;
        }
        WidgetTextChannelSettings.Companion companion3 = WidgetTextChannelSettings.INSTANCE;
        long id4 = this.$this_configureUI$inlined.getChannel().getId();
        Context context3 = view.getContext();
        C12238m.checkNotNullExpressionValue(context3, "view.context");
        companion3.launch(id4, context3);
    }
}
