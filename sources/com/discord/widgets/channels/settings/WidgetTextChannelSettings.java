package com.discord.widgets.channels.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.f;
import b.a.i.r4;
import b.a.i.s4;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTextChannelSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.threads.ThreadUtils$ThreadArchiveDurations;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.o;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings extends AppFragment {
    public static final int ONE_DAY = 86400;
    public static final int ONE_HOUR = 3600;
    public static final int ONE_MINUTE = 60;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetTextChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextChannelSettingsBinding;", 0)};
    public static final WidgetTextChannelSettings$Companion Companion = new WidgetTextChannelSettings$Companion(null);
    private static final List<Integer> SLOWMODE_COOLDOWN_VALUES = n.listOf((Object[]) new Integer[]{0, 5, 10, 15, 30, 60, 120, 300, 600, 900, Integer.valueOf(ModelInvite$Settings.HALF_HOUR), 3600, 7200, Integer.valueOf(ModelInvite$Settings.SIX_HOURS)});

    public WidgetTextChannelSettings() {
        super(R$layout.widget_text_channel_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTextChannelSettings$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R$id.channel_settings_edit_name, R$id.channel_settings_edit_topic, R$id.channel_settings_slow_mode_cooldown_slider, R$id.duration_selector, R$id.channel_settings_announcement);
    }

    public static final /* synthetic */ void access$cannotDeleteWarn(WidgetTextChannelSettings widgetTextChannelSettings, boolean z2) {
        widgetTextChannelSettings.cannotDeleteWarn(z2);
    }

    public static final /* synthetic */ void access$configureUI(WidgetTextChannelSettings widgetTextChannelSettings, WidgetTextChannelSettings$Model widgetTextChannelSettings$Model) {
        widgetTextChannelSettings.configureUI(widgetTextChannelSettings$Model);
    }

    public static final /* synthetic */ void access$confirmDelete(WidgetTextChannelSettings widgetTextChannelSettings, Channel channel) {
        widgetTextChannelSettings.confirmDelete(channel);
    }

    public static final /* synthetic */ WidgetTextChannelSettingsBinding access$getBinding$p(WidgetTextChannelSettings widgetTextChannelSettings) {
        return widgetTextChannelSettings.getBinding();
    }

    public static final /* synthetic */ List access$getSLOWMODE_COOLDOWN_VALUES$cp() {
        return SLOWMODE_COOLDOWN_VALUES;
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetTextChannelSettings widgetTextChannelSettings) {
        return widgetTextChannelSettings.state;
    }

    public static final /* synthetic */ void access$setSlowmodeLabel(WidgetTextChannelSettings widgetTextChannelSettings, int i) {
        widgetTextChannelSettings.setSlowmodeLabel(i);
    }

    public static final /* synthetic */ void access$updateRadioState(WidgetTextChannelSettings widgetTextChannelSettings, Map map, int i) {
        widgetTextChannelSettings.updateRadioState(map, i);
    }

    private final void cannotDeleteWarn(boolean isPublicGuildRulesChannel) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.widget_channel_settings_cannot_delete, (ViewGroup) null, false);
        int i = R$id.channel_settings_cannot_delete_body;
        TextView textView = (TextView) viewInflate.findViewById(R$id.channel_settings_cannot_delete_body);
        if (textView != null) {
            i = R$id.channel_settings_cannot_delete_confirm;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R$id.channel_settings_cannot_delete_confirm);
            if (materialButton != null) {
                i = R$id.channel_settings_cannot_delete_title;
                TextView textView2 = (TextView) viewInflate.findViewById(R$id.channel_settings_cannot_delete_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    m.checkNotNullExpressionValue(new r4(linearLayout, textView, materialButton, textView2), "WidgetChannelSettingsCan…om(context), null, false)");
                    m.checkNotNullExpressionValue(linearLayout, "binding.root");
                    AlertDialog alertDialogCreate = new AlertDialog$Builder(linearLayout.getContext()).setView(linearLayout).create();
                    m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
                    textView.setText(isPublicGuildRulesChannel ? 2131888397 : 2131888405);
                    materialButton.setOnClickListener(new WidgetTextChannelSettings$cannotDeleteWarn$1(alertDialogCreate));
                    alertDialogCreate.show();
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void configureUI(WidgetTextChannelSettings$Model widgetTextChannelSettings$Model) {
        if (widgetTextChannelSettings$Model == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(ChannelUtils.F(widgetTextChannelSettings$Model.getChannel()) ? 2131887604 : 2131887472);
        setActionBarSubtitle(ChannelUtils.e(widgetTextChannelSettings$Model.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(ChannelUtils.F(widgetTextChannelSettings$Model.getChannel()) ? R$menu.menu_text_channel_settings : R$menu.menu_category_settings, new WidgetTextChannelSettings$configureUI$1(this, widgetTextChannelSettings$Model), new WidgetTextChannelSettings$configureUI$2(widgetTextChannelSettings$Model));
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), ChannelUtils.c(widgetTextChannelSettings$Model.getChannel())));
        getBinding().c.setHint(ChannelUtils.F(widgetTextChannelSettings$Model.getChannel()) ? 2131889147 : 2131887468);
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout4 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout4.getId();
        String topic = widgetTextChannelSettings$Model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout3, (CharSequence) statefulViews2.get(id2, topic));
        TextInputLayout textInputLayout5 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        textInputLayout5.setVisibility(ChannelUtils.F(widgetTextChannelSettings$Model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout = getBinding().e;
        m.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsEditWrap");
        linearLayout.setVisibility(widgetTextChannelSettings$Model.getCanManageChannel() ? 0 : 8);
        getBinding().k.setOnClickListener(new WidgetTextChannelSettings$configureUI$3(this, widgetTextChannelSettings$Model));
        this.state.configureSaveActionView(getBinding().k);
        LinearLayout linearLayout2 = getBinding().i;
        m.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsPinnedMessagesContainer");
        linearLayout2.setVisibility(ChannelUtils.F(widgetTextChannelSettings$Model.getChannel()) ? 0 : 8);
        TextView textView = getBinding().h;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsPinnedMessages");
        textView.setEnabled(widgetTextChannelSettings$Model.isPinsEnabled());
        getBinding().h.setOnClickListener(new WidgetTextChannelSettings$configureUI$5(widgetTextChannelSettings$Model));
        View view = getBinding().j;
        m.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(widgetTextChannelSettings$Model.isPinsEnabled() ^ true ? 0 : 8);
        getBinding().j.setOnClickListener(WidgetTextChannelSettings$configureUI$6.INSTANCE);
        TextView textView2 = getBinding().g;
        m.checkNotNullExpressionValue(textView2, "binding.channelSettingsPermissions");
        textView2.setVisibility(widgetTextChannelSettings$Model.getCanManagePermissions() ? 0 : 8);
        getBinding().g.setOnClickListener(new WidgetTextChannelSettings$configureUI$7(widgetTextChannelSettings$Model));
        CheckedSetting checkedSetting = getBinding().f2665b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsAnnouncement");
        checkedSetting.setVisibility((ChannelUtils.u(widgetTextChannelSettings$Model.getChannel()) || ChannelUtils.i(widgetTextChannelSettings$Model.getChannel())) && widgetTextChannelSettings$Model.getCanManageChannel() && widgetTextChannelSettings$Model.isCommunityGuild() && !widgetTextChannelSettings$Model.isPublicGuildRulesChannel() && !widgetTextChannelSettings$Model.isPublicGuildUpdatesChannel() ? 0 : 8);
        getBinding().f2665b.g(ChannelUtils.i(widgetTextChannelSettings$Model.getChannel()), false);
        CheckedSetting checkedSetting2 = getBinding().f2665b;
        Context context = getContext();
        checkedSetting2.h(context != null ? b.h(context, 2131889102, new Object[]{f.a.a(360032008192L, null)}, null, 4) : null, true);
        getBinding().f2665b.e(new WidgetTextChannelSettings$configureUI$8(this, widgetTextChannelSettings$Model));
        LinearLayout linearLayout3 = getBinding().o;
        m.checkNotNullExpressionValue(linearLayout3, "binding.channelSettingsSectionUserManagement");
        linearLayout3.setVisibility(widgetTextChannelSettings$Model.getCanManageChannel() || widgetTextChannelSettings$Model.getCanManagePermissions() ? 0 : 8);
        LinearLayout linearLayout4 = getBinding().m;
        m.checkNotNullExpressionValue(linearLayout4, "binding.channelSettingsSectionPrivacySafety");
        linearLayout4.setVisibility(widgetTextChannelSettings$Model.getCanManageChannel() && ChannelUtils.F(widgetTextChannelSettings$Model.getChannel()) ? 0 : 8);
        CheckedSetting checkedSetting3 = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.channelSettingsNsfw");
        checkedSetting3.setVisibility(widgetTextChannelSettings$Model.getCanManageChannel() ? 0 : 8);
        getBinding().f.g(widgetTextChannelSettings$Model.getChannel().getNsfw(), false);
        getBinding().f.e(new WidgetTextChannelSettings$configureUI$9(this, widgetTextChannelSettings$Model));
        LinearLayout linearLayout5 = getBinding().n;
        m.checkNotNullExpressionValue(linearLayout5, "binding.channelSettingsSectionSlowMode");
        linearLayout5.setVisibility(widgetTextChannelSettings$Model.getCanManageChannel() && ChannelUtils.F(widgetTextChannelSettings$Model.getChannel()) && !ChannelUtils.i(widgetTextChannelSettings$Model.getChannel()) ? 0 : 8);
        int iIntValue = ((Number) this.state.get(R$id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(widgetTextChannelSettings$Model.getChannel().getRateLimitPerUser()))).intValue();
        setSlowmodeLabel(iIntValue);
        Iterator<Integer> it = SLOWMODE_COOLDOWN_VALUES.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else {
                if (it.next().intValue() >= iIntValue) {
                    break;
                } else {
                    i++;
                }
            }
        }
        SeekBar seekBar = getBinding().q;
        m.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        this.state.configureSaveActionView(getBinding().k);
        SeekBar seekBar2 = getBinding().q;
        m.checkNotNullExpressionValue(seekBar2, "binding.channelSettingsSlowModeCooldownSlider");
        TextView textView3 = getBinding().p;
        m.checkNotNullExpressionValue(textView3, "binding.channelSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView3.getText());
        LinearLayout linearLayout6 = getBinding().l;
        m.checkNotNullExpressionValue(linearLayout6, "binding.channelSettingsS…efaultAutoArchiveDuration");
        linearLayout6.setVisibility(widgetTextChannelSettings$Model.getCanManageChannel() && ChannelUtils.I(widgetTextChannelSettings$Model.getChannel()) && ThreadUtils.INSTANCE.isThreadsEnabled(widgetTextChannelSettings$Model.getGuild().getId()) ? 0 : 8);
        Integer num = (Integer) this.state.get(R$id.duration_selector, widgetTextChannelSettings$Model.getChannel().getDefaultAutoArchiveDuration());
        int iIntValue2 = num != null ? num.intValue() : 1440;
        this.state.configureSaveActionView(getBinding().k);
        Map<MaterialRadioButton, Integer> mapMapOf = h0.mapOf(o.to(getBinding().r.e, 60), o.to(getBinding().r.k, 1440), o.to(getBinding().r.i, Integer.valueOf(ThreadUtils$ThreadArchiveDurations.THREE_DAYS_IN_MINUTES)), o.to(getBinding().r.g, Integer.valueOf(ThreadUtils$ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES)));
        getBinding().r.d.setOnClickListener(new WidgetTextChannelSettings$configureUI$10(this, mapMapOf));
        getBinding().r.j.setOnClickListener(new WidgetTextChannelSettings$configureUI$11(this, mapMapOf));
        getBinding().r.h.setOnClickListener(new WidgetTextChannelSettings$configureUI$12(this, mapMapOf));
        getBinding().r.f.setOnClickListener(new WidgetTextChannelSettings$configureUI$13(this, mapMapOf));
        updateRadioState(mapMapOf, iIntValue2);
    }

    private final void confirmDelete(Channel channel) {
        s4 s4VarA = s4.a(LayoutInflater.from(getContext()), null, false);
        m.checkNotNullExpressionValue(s4VarA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = s4VarA.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog$Builder(linearLayout.getContext()).setView(s4VarA.a).create();
        m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        s4VarA.e.setText(ChannelUtils.F(channel) ? 2131888377 : 2131888376);
        s4VarA.c.setOnClickListener(new WidgetTextChannelSettings$confirmDelete$1(alertDialogCreate));
        s4VarA.d.setOnClickListener(new WidgetTextChannelSettings$confirmDelete$2(this, channel));
        TextView textView = s4VarA.f199b;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        b.n(textView, 2131888378, new Object[]{ChannelUtils.e(channel, requireContext(), false, 2)}, null, 4);
        alertDialogCreate.show();
    }

    private final WidgetTextChannelSettingsBinding getBinding() {
        return (WidgetTextChannelSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(long j, Context context) {
        Companion.launch(j, context);
    }

    private final void saveChannel(long id2, String name, Integer type, String topic, Boolean nsfw, Integer rateLimit, Integer defaultAutoArchiveDuration) {
        ObservableExtensionsKt.ui$default(RestAPI.Companion.getApi().editTextChannel(id2, name, type, topic, nsfw, rateLimit, defaultAutoArchiveDuration), this, null, 2, null).k(b.a.d.o.a.g(getContext(), new WidgetTextChannelSettings$saveChannel$1(this), null));
    }

    public static /* synthetic */ void saveChannel$default(WidgetTextChannelSettings widgetTextChannelSettings, long j, String str, Integer num, String str2, Boolean bool, Integer num2, Integer num3, int i, Object obj) {
        widgetTextChannelSettings.saveChannel(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3);
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        WidgetTextChannelSettings$Companion widgetTextChannelSettings$Companion = Companion;
        TextView textView = getBinding().p;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
        widgetTextChannelSettings$Companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), 2131889270);
    }

    private final void updateRadioState(Map<MaterialRadioButton, Integer> durationMap, int newDuration) {
        for (Map$Entry<MaterialRadioButton, Integer> map$Entry : durationMap.entrySet()) {
            map$Entry.getKey().setChecked(map$Entry.getValue().intValue() == newDuration);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditTopic");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        FloatingActionButton floatingActionButton = getBinding().k;
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3);
        SeekBar seekBar = getBinding().q;
        m.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setMax(n.getLastIndex(SLOWMODE_COOLDOWN_VALUES));
        getBinding().q.setOnSeekBarChangeListener(new WidgetTextChannelSettings$onViewBound$1(this));
        TextInputLayout textInputLayout4 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetTextChannelSettings$Model.Companion.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)), this, null, 2, null), WidgetTextChannelSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetTextChannelSettings$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
