package com.discord.widgets.channels.list;

import com.discord.models.guild.Guild;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$configureUI$5 extends o implements Function1<Float, Unit> {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ boolean $hasBanner;
    public final /* synthetic */ WidgetChannelListModel $list;
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$configureUI$5(WidgetChannelsList widgetChannelsList, Guild guild, WidgetChannelListModel widgetChannelListModel, boolean z2) {
        super(1);
        this.this$0 = widgetChannelsList;
        this.$guild = guild;
        this.$list = widgetChannelListModel;
        this.$hasBanner = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
        invoke(f.floatValue());
        return Unit.a;
    }

    public final void invoke(float f) {
        SimpleDraweeView simpleDraweeView = WidgetChannelsList.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListBanner");
        simpleDraweeView.setAlpha(1.0f - f);
        boolean zA = WidgetChannelsList.access$getBinding$p(this.this$0).f2282b.a();
        if (WidgetChannelsList.access$isCollapsed$p(this.this$0) != zA) {
            WidgetChannelsList.access$setCollapsed$p(this.this$0, zA);
            WidgetChannelsList widgetChannelsList = this.this$0;
            WidgetChannelsList.access$configureHeaderIcons(widgetChannelsList, this.$guild, WidgetChannelsList.access$isCollapsed$p(widgetChannelsList));
            WidgetChannelsList.access$configureHeaderColors(this.this$0, this.$list.getSelectedGuild(), this.$hasBanner);
        }
    }
}
