package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.d.o;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.restapi.RestAPIParams$UpdateGuild;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.views.CheckedSetting;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.u;
import d0.z.d.m;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureUI$7 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsOverview$Model $this_configureUI;
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$configureUI$7(WidgetServerSettingsOverview widgetServerSettingsOverview, WidgetServerSettingsOverview$Model widgetServerSettingsOverview$Model) {
        this.this$0 = widgetServerSettingsOverview;
        this.$this_configureUI = widgetServerSettingsOverview$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        CheckedSetting checkedSetting = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelJoin");
        int id2 = checkedSetting.getId();
        CheckedSetting checkedSetting2 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.d;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelJoin");
        int i = !((Boolean) statefulViewsAccess$getState$p.get(id2, Boolean.valueOf(checkedSetting2.isChecked()))).booleanValue() ? 1 : 0;
        StatefulViews statefulViewsAccess$getState$p2 = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        CheckedSetting checkedSetting3 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.e;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelJoinReplies");
        int id3 = checkedSetting3.getId();
        CheckedSetting checkedSetting4 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.e;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.systemChannel.systemChannelJoinReplies");
        if (!((Boolean) statefulViewsAccess$getState$p2.get(id3, Boolean.valueOf(checkedSetting4.isChecked()))).booleanValue()) {
            i |= 8;
        }
        StatefulViews statefulViewsAccess$getState$p3 = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        CheckedSetting checkedSetting5 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.c;
        m.checkNotNullExpressionValue(checkedSetting5, "binding.systemChannel.systemChannelBoost");
        int id4 = checkedSetting5.getId();
        CheckedSetting checkedSetting6 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.c;
        m.checkNotNullExpressionValue(checkedSetting6, "binding.systemChannel.systemChannelBoost");
        if (!((Boolean) statefulViewsAccess$getState$p3.get(id4, Boolean.valueOf(checkedSetting6.isChecked()))).booleanValue()) {
            i |= 2;
        }
        RestAPI apiSerializeNulls = RestAPI.Companion.getApiSerializeNulls();
        long id5 = this.$this_configureUI.getGuild().getId();
        StatefulViews statefulViewsAccess$getState$p4 = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        TextView textView = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).f2582b.f242b;
        m.checkNotNullExpressionValue(textView, "binding.afk.afkChannel");
        Channel channel = (Channel) statefulViewsAccess$getState$p4.get(textView.getId(), this.$this_configureUI.getAfkChannelModel());
        Long lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
        StatefulViews statefulViewsAccess$getState$p5 = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        LinearLayout linearLayout = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).f2582b.e;
        m.checkNotNullExpressionValue(linearLayout, "binding.afk.afkTimeoutWrap");
        Integer num = (Integer) statefulViewsAccess$getState$p5.get(linearLayout.getId(), Integer.valueOf(this.$this_configureUI.getGuild().getAfkTimeout()));
        StatefulViews statefulViewsAccess$getState$p6 = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        TextView textView2 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).g.f153b;
        m.checkNotNullExpressionValue(textView2, "binding.systemChannel.systemChannel");
        Channel channel2 = (Channel) statefulViewsAccess$getState$p6.get(textView2.getId(), this.$this_configureUI.getSystemChannelModel());
        Long lValueOf2 = channel2 != null ? Long.valueOf(channel2.getId()) : null;
        Integer num2 = (Integer) WidgetServerSettingsOverview.access$getState$p(this.this$0).get(90001, Integer.valueOf(this.$this_configureUI.getGuild().getDefaultMessageNotifications()));
        StatefulViews statefulViewsAccess$getState$p7 = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        SimpleDraweeView simpleDraweeView = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).c.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.header.serverSettingsOverviewIcon");
        String str = (String) statefulViewsAccess$getState$p7.get(simpleDraweeView.getId(), IconUtils.getForGuild$default(this.$this_configureUI.getGuild(), null, false, null, 14, null));
        StatefulViews statefulViewsAccess$getState$p8 = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        TextInputLayout textInputLayout = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).c.c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.header.overviewName");
        String str2 = (String) statefulViewsAccess$getState$p8.get(textInputLayout.getId(), this.$this_configureUI.getGuild().getName());
        GuildVerificationLevel verificationLevel = this.$this_configureUI.getGuild().getVerificationLevel();
        GuildExplicitContentFilter explicitContentFilter = this.$this_configureUI.getGuild().getExplicitContentFilter();
        StatefulViews statefulViewsAccess$getState$p9 = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        SimpleDraweeView simpleDraweeView2 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).i.e;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadSplash.uploadSplash");
        String str3 = (String) statefulViewsAccess$getState$p9.get(simpleDraweeView2.getId(), this.$this_configureUI.getGuild().getSplash());
        StatefulViews statefulViewsAccess$getState$p10 = WidgetServerSettingsOverview.access$getState$p(this.this$0);
        SimpleDraweeView simpleDraweeView3 = WidgetServerSettingsOverview.access$getBinding$p(this.this$0).h.e;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadBanner.uploadBanner");
        Observable observableY = ObservableExtensionsKt.restSubscribeOn$default(apiSerializeNulls.updateGuild(id5, new RestAPIParams$UpdateGuild(lValueOf, num, lValueOf2, num2, str, str2, verificationLevel, explicitContentFilter, str3, (String) statefulViewsAccess$getState$p10.get(simpleDraweeView3.getId(), this.$this_configureUI.getGuild().getBanner()), Integer.valueOf(i), u.toList(this.$this_configureUI.getGuild().getFeatures()), this.$this_configureUI.getGuild().getRulesChannelId(), this.$this_configureUI.getGuild().getPublicUpdatesChannelId(), this.$this_configureUI.getGuild().getPreferredLocale())), false, 1, null).Y(WidgetServerSettingsOverview$configureUI$7$1.INSTANCE).Y(WidgetServerSettingsOverview$configureUI$7$2.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "RestAPI\n          .apiSe…atedGuild.id)\n          }");
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null), this.this$0, null, 2, null).k(o.i(new WidgetServerSettingsOverview$configureUI$7$3(this), this.this$0));
    }
}
