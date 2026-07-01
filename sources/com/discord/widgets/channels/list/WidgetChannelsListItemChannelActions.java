package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelsListItemActionsBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelsListItemChannelActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", 0)};
    public static final WidgetChannelsListItemChannelActions$Companion Companion = new WidgetChannelsListItemChannelActions$Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetChannelsListItemChannelActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelsListItemChannelActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions, WidgetChannelsListItemChannelActions$Model widgetChannelsListItemChannelActions$Model) {
        widgetChannelsListItemChannelActions.configureUI(widgetChannelsListItemChannelActions$Model);
    }

    private final void configureUI(WidgetChannelsListItemChannelActions$Model widgetChannelsListItemChannelActions$Model) {
        Guild guild;
        if (widgetChannelsListItemChannelActions$Model == null) {
            dismiss();
            return;
        }
        if (widgetChannelsListItemChannelActions$Model.getGuild() != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, widgetChannelsListItemChannelActions$Model.getGuild(), 0, (MGImages$ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, widgetChannelsListItemChannelActions$Model.getChannel(), 0, (MGImages$ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.channelsListItemTextActionsTitle");
        Channel channel = widgetChannelsListItemChannelActions$Model.getChannel();
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.e(channel, contextRequireContext, false, 2));
        User userA = ChannelUtils.a(widgetChannelsListItemChannelActions$Model.getChannel());
        TextView textView2 = getBinding().i;
        boolean z2 = true;
        textView2.setVisibility(userA != null ? 0 : 8);
        textView2.setOnClickListener(new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$1(this, userA));
        TextView textView3 = getBinding().e;
        textView3.setVisibility(widgetChannelsListItemChannelActions$Model.getCanCreateInstantInvite() ? 0 : 8);
        setOnClickAndDismissListener(textView3, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$2(textView3, this, widgetChannelsListItemChannelActions$Model));
        TextView textView4 = getBinding().k;
        textView4.setVisibility(ChannelUtils.F(widgetChannelsListItemChannelActions$Model.getChannel()) || ChannelUtils.k(widgetChannelsListItemChannelActions$Model.getChannel()) ? 0 : 8);
        setOnClickAndDismissListener(textView4, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$3(textView4, this, widgetChannelsListItemChannelActions$Model));
        Context context = textView4.getContext();
        m.checkNotNullExpressionValue(context, "context");
        textView4.setCompoundDrawablesWithIntrinsicBounds(widgetChannelsListItemChannelActions$Model.getMuteIconResId(context), 0, 0, 0);
        Context context2 = textView4.getContext();
        m.checkNotNullExpressionValue(context2, "context");
        textView4.setText(widgetChannelsListItemChannelActions$Model.getMuteChannelText(context2, widgetChannelsListItemChannelActions$Model.getChannel()));
        TextView textView5 = getBinding().l;
        textView5.setVisibility(ThreadUtils.INSTANCE.isThreadsEnabled(widgetChannelsListItemChannelActions$Model.getChannel().getGuildId()) && ChannelUtils.I(widgetChannelsListItemChannelActions$Model.getChannel()) && !ChannelUtils.q(widgetChannelsListItemChannelActions$Model.getChannel()) && !widgetChannelsListItemChannelActions$Model.getChannel().getNsfw() ? 0 : 8);
        setOnClickAndDismissListener(textView5, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$4(textView5, this, widgetChannelsListItemChannelActions$Model));
        TextView textView6 = getBinding().c;
        textView6.setVisibility(widgetChannelsListItemChannelActions$Model.getCanManageChannel() ? 0 : 8);
        setOnClickAndDismissListener(textView6, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$5(this, widgetChannelsListItemChannelActions$Model));
        textView6.setText(getSettingsText(widgetChannelsListItemChannelActions$Model.getChannel(), widgetChannelsListItemChannelActions$Model.getCanManageChannel()));
        TextView textView7 = getBinding().f2283b;
        textView7.setVisibility(ChannelUtils.v(widgetChannelsListItemChannelActions$Model.getChannel()) || ChannelUtils.k(widgetChannelsListItemChannelActions$Model.getChannel()) || (ChannelUtils.D(widgetChannelsListItemChannelActions$Model.getChannel()) && (guild = widgetChannelsListItemChannelActions$Model.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY)) ? 0 : 8);
        textView7.setOnClickListener(new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6(widgetChannelsListItemChannelActions$Model));
        View view = getBinding().j;
        if (!ChannelUtils.F(widgetChannelsListItemChannelActions$Model.getChannel()) && !ChannelUtils.k(widgetChannelsListItemChannelActions$Model.getChannel())) {
            z2 = false;
        }
        view.setVisibility(z2 ? 0 : 8);
        setOnClickAndDismissListener(view, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$7(this, widgetChannelsListItemChannelActions$Model));
        View view2 = getBinding().h;
        m.checkNotNullExpressionValue(view2, "binding.developerDivider");
        view2.setVisibility(widgetChannelsListItemChannelActions$Model.getIsDeveloper() ? 0 : 8);
        View view3 = getBinding().d;
        view3.setVisibility(widgetChannelsListItemChannelActions$Model.getIsDeveloper() ? 0 : 8);
        setOnClickAndDismissListener(view3, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$8(this, widgetChannelsListItemChannelActions$Model));
    }

    private final WidgetChannelsListItemActionsBinding getBinding() {
        return (WidgetChannelsListItemActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getSettingsText(Channel channel, boolean z2) {
        int i;
        if (ChannelUtils.k(channel)) {
            i = 2131888627;
        } else if (z2) {
            i = 2131888628;
        } else {
            i = !z2 ? 2131887604 : 2131895198;
        }
        String string = getString(i);
        m.checkNotNullExpressionValue(string, "getString(\n      when {\n…_empty_string\n      }\n  )");
        return string;
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        Companion.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetChannelsListItemChannelActions$Model.Companion.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetChannelsListItemChannelActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelsListItemChannelActions$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_channels_list_item_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
