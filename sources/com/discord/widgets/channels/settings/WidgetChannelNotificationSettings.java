package com.discord.widgets.channels.settings;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelNotificationSettingsBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import com.discord.widgets.servers.NotificationMuteSettingsView$ViewState;
import d0.t.n;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelNotificationSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelNotificationSettingsBinding;", 0)};
    public static final WidgetChannelNotificationSettings$Companion Companion = new WidgetChannelNotificationSettings$Companion(null);
    private static final String INTENT_SHOW_SYSTEM_SETTINGS = "SHOW_SYSTEM_SETTING";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager notificationSettingsRadioManager;

    public WidgetChannelNotificationSettings() {
        super(R$layout.widget_channel_notification_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelNotificationSettings$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelNotificationSettings widgetChannelNotificationSettings, WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model) {
        widgetChannelNotificationSettings.configureUI(widgetChannelNotificationSettings$Model);
    }

    public static final /* synthetic */ WidgetChannelNotificationSettingsBinding access$getBinding$p(WidgetChannelNotificationSettings widgetChannelNotificationSettings) {
        return widgetChannelNotificationSettings.getBinding();
    }

    public static final /* synthetic */ RadioManager access$getNotificationSettingsRadioManager$p(WidgetChannelNotificationSettings widgetChannelNotificationSettings) {
        RadioManager radioManager = widgetChannelNotificationSettings.notificationSettingsRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("notificationSettingsRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ void access$setNotificationSettingsRadioManager$p(WidgetChannelNotificationSettings widgetChannelNotificationSettings, RadioManager radioManager) {
        widgetChannelNotificationSettings.notificationSettingsRadioManager = radioManager;
    }

    private final void configureChannel(WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model) {
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.forumChannelNotificationSettings");
        linearLayout.setVisibility(8);
        TextView textView = getBinding().i;
        m.checkNotNullExpressionValue(textView, "binding.frequencySubheader");
        textView.setVisibility(8);
        getBinding().i.setText(2131889228);
    }

    private final void configureGuildForumChannel(WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model) {
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.forumChannelNotificationSettings");
        boolean z2 = false;
        linearLayout.setVisibility(0);
        TextView textView = getBinding().i;
        m.checkNotNullExpressionValue(textView, "binding.frequencySubheader");
        textView.setVisibility(0);
        getBinding().e.setText(2131889373);
        getBinding().i.setText(2131889374);
        Integer parentNotificationSetting = widgetChannelNotificationSettings$Model.getParentNotificationSetting();
        boolean z3 = parentNotificationSetting != null && parentNotificationSetting.intValue() == ModelNotificationSettings.FREQUENCY_ALL;
        Integer forumPostNotificationSetting = widgetChannelNotificationSettings$Model.getForumPostNotificationSetting();
        int iIntValue = forumPostNotificationSetting != null ? forumPostNotificationSetting.intValue() : ModelNotificationSettings.FREQUENCY_UNSET;
        CheckedSetting checkedSetting = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.frequencyAllPosts");
        if (iIntValue == ModelNotificationSettings.FREQUENCY_UNSET) {
            z2 = z3;
        } else if (iIntValue == ModelNotificationSettings.FORUM_THREAD_CREATED_ON) {
            z2 = true;
        }
        checkedSetting.setChecked(z2);
        getBinding().d.setOnCheckedListener(new WidgetChannelNotificationSettings$configureGuildForumChannel$1(this, widgetChannelNotificationSettings$Model));
    }

    private final void configureNotificationRadios(WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model) {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = widgetChannelNotificationSettings$Model.getNotificationSetting();
        if (ChannelUtils.D(widgetChannelNotificationSettings$Model.getChannel()) && ref$IntRef.element == ModelNotificationSettings.FREQUENCY_ALL) {
            ref$IntRef.element = ModelNotificationSettings.FREQUENCY_MENTIONS;
        }
        WidgetChannelNotificationSettings$configureNotificationRadios$1 widgetChannelNotificationSettings$configureNotificationRadios$1 = new WidgetChannelNotificationSettings$configureNotificationRadios$1(this, ref$IntRef);
        CheckedSetting checkedSetting = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting, "binding.frequencyRadioAll");
        checkedSetting.setVisibility(ChannelUtils.F(widgetChannelNotificationSettings$Model.getChannel()) || ChannelUtils.k(widgetChannelNotificationSettings$Model.getChannel()) ? 0 : 8);
        CheckedSetting checkedSetting2 = getBinding().g;
        String string = requireContext().getString(ChannelUtils.D(widgetChannelNotificationSettings$Model.getChannel()) ? 2131889182 : 2131889232);
        m.checkNotNullExpressionValue(string, "requireContext().getStri…s\n            }\n        )");
        checkedSetting2.setText(b.l(string, new Object[0], null, 2));
        CheckedSetting checkedSetting3 = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.frequencyRadioAll");
        widgetChannelNotificationSettings$configureNotificationRadios$1.invoke(widgetChannelNotificationSettings$Model, checkedSetting3, ModelNotificationSettings.FREQUENCY_ALL);
        CheckedSetting checkedSetting4 = getBinding().g;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.frequencyRadioMentions");
        widgetChannelNotificationSettings$configureNotificationRadios$1.invoke(widgetChannelNotificationSettings$Model, checkedSetting4, ModelNotificationSettings.FREQUENCY_MENTIONS);
        CheckedSetting checkedSetting5 = getBinding().h;
        m.checkNotNullExpressionValue(checkedSetting5, "binding.frequencyRadioNothing");
        widgetChannelNotificationSettings$configureNotificationRadios$1.invoke(widgetChannelNotificationSettings$Model, checkedSetting5, ModelNotificationSettings.FREQUENCY_NOTHING);
    }

    private final void configureUI(WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model) {
        setActionBarSubtitle(ChannelUtils.e(widgetChannelNotificationSettings$Model.getChannel(), requireContext(), false, 2));
        boolean z2 = true;
        NotificationMuteSettingsView$ViewState notificationMuteSettingsView$ViewState = new NotificationMuteSettingsView$ViewState(widgetChannelNotificationSettings$Model.getChannelIsMuted(), widgetChannelNotificationSettings$Model.getChannelMuteEndTime(), ChannelUtils.F(widgetChannelNotificationSettings$Model.getChannel()) ? b.h(requireContext(), 2131893139, new Object[]{ChannelUtils.e(widgetChannelNotificationSettings$Model.getChannel(), requireContext(), false, 2)}, null, 4) : b.h(requireContext(), 2131893138, new Object[0], null, 4), ChannelUtils.F(widgetChannelNotificationSettings$Model.getChannel()) ? b.h(requireContext(), 2131896589, new Object[]{ChannelUtils.e(widgetChannelNotificationSettings$Model.getChannel(), requireContext(), false, 2)}, null, 4) : b.h(requireContext(), 2131896588, new Object[0], null, 4), b.h(requireContext(), 2131889193, new Object[0], null, 4), ChannelUtils.F(widgetChannelNotificationSettings$Model.getChannel()) ? 2131889194 : 2131889191, ChannelUtils.F(widgetChannelNotificationSettings$Model.getChannel()) ? b.h(requireContext(), 2131889197, new Object[0], null, 4) : b.h(requireContext(), 2131889192, new Object[0], null, 4));
        WidgetChannelNotificationSettings$configureUI$onMute$1 widgetChannelNotificationSettings$configureUI$onMute$1 = new WidgetChannelNotificationSettings$configureUI$onMute$1(this, widgetChannelNotificationSettings$Model);
        WidgetChannelNotificationSettings$configureUI$onUnmute$1 widgetChannelNotificationSettings$configureUI$onUnmute$1 = new WidgetChannelNotificationSettings$configureUI$onUnmute$1(this, widgetChannelNotificationSettings$Model);
        if (!ChannelUtils.F(widgetChannelNotificationSettings$Model.getChannel()) && !ChannelUtils.k(widgetChannelNotificationSettings$Model.getChannel())) {
            z2 = false;
        }
        NotificationMuteSettingsView notificationMuteSettingsView = getBinding().k;
        notificationMuteSettingsView.setVisibility(z2 ? 0 : 8);
        notificationMuteSettingsView.updateView(notificationMuteSettingsView$ViewState, widgetChannelNotificationSettings$configureUI$onMute$1, widgetChannelNotificationSettings$configureUI$onUnmute$1);
        View view = getBinding().j;
        m.checkNotNullExpressionValue(view, "binding.frequencyTopDivider");
        view.setVisibility(z2 ? 0 : 8);
        configureNotificationRadios(widgetChannelNotificationSettings$Model);
        if (ChannelUtils.q(widgetChannelNotificationSettings$Model.getChannel()) && widgetChannelNotificationSettings$Model.getCanAccessRedesignedForumChannels()) {
            configureGuildForumChannel(widgetChannelNotificationSettings$Model);
        } else {
            configureChannel(widgetChannelNotificationSettings$Model);
        }
    }

    private final WidgetChannelNotificationSettingsBinding getBinding() {
        return (WidgetChannelNotificationSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131893382);
        this.notificationSettingsRadioManager = new RadioManager(n.listOf((Object[]) new CheckedSetting[]{getBinding().f, getBinding().g, getBinding().h}));
        LinearLayout linearLayout = getBinding().f2262b;
        m.checkNotNullExpressionValue(linearLayout, "binding.channelNotificationSettingsSystem");
        linearLayout.setVisibility(getMostRecentIntent().getBooleanExtra(INTENT_SHOW_SYSTEM_SETTINGS, false) ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        getBinding().f2262b.setOnClickListener(new WidgetChannelNotificationSettings$onViewBoundOrOnResume$1(this));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetChannelNotificationSettings$Model.Companion.get(longExtra), this, null, 2, null), WidgetChannelNotificationSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelNotificationSettings$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
