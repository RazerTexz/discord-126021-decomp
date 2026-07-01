package com.discord.widgets.voice.settings;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.n;
import b.a.a.n$a;
import b.a.d.o;
import b.a.i.s4;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceChannelSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.voice.Bitrate;
import com.discord.views.CheckedSetting;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetVoiceChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceChannelSettingsBinding;", 0)};
    public static final WidgetVoiceChannelSettings$Companion Companion = new WidgetVoiceChannelSettings$Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;

    public WidgetVoiceChannelSettings() {
        super(R$layout.widget_voice_channel_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetVoiceChannelSettings$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R$id.channel_settings_edit_name, R$id.channel_settings_edit_topic, R$id.current_user_limit_display, R$id.current_bitrate_display, R$id.channel_settings_region_override, R$id.channel_settings_nsfw);
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceChannelSettings widgetVoiceChannelSettings, WidgetVoiceChannelSettings$Model widgetVoiceChannelSettings$Model) {
        widgetVoiceChannelSettings.configureUI(widgetVoiceChannelSettings$Model);
    }

    public static final /* synthetic */ void access$confirmDelete(WidgetVoiceChannelSettings widgetVoiceChannelSettings, Channel channel) {
        widgetVoiceChannelSettings.confirmDelete(channel);
    }

    public static final /* synthetic */ WidgetVoiceChannelSettingsBinding access$getBinding$p(WidgetVoiceChannelSettings widgetVoiceChannelSettings) {
        return widgetVoiceChannelSettings.getBinding();
    }

    public static final /* synthetic */ String access$getBitrateDisplayString(WidgetVoiceChannelSettings widgetVoiceChannelSettings, int i) {
        return widgetVoiceChannelSettings.getBitrateDisplayString(i);
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetVoiceChannelSettings widgetVoiceChannelSettings) {
        return widgetVoiceChannelSettings.state;
    }

    public static final /* synthetic */ CharSequence access$getUserLimitDisplayString(WidgetVoiceChannelSettings widgetVoiceChannelSettings, int i) {
        return widgetVoiceChannelSettings.getUserLimitDisplayString(i);
    }

    public static final /* synthetic */ void access$saveChannel(WidgetVoiceChannelSettings widgetVoiceChannelSettings, long j, String str, int i, String str2, Boolean bool, int i2, int i3, String str3) {
        widgetVoiceChannelSettings.saveChannel(j, str, i, str2, bool, i2, i3, str3);
    }

    public static final /* synthetic */ void access$showRegionDialog(WidgetVoiceChannelSettings widgetVoiceChannelSettings, List list) {
        widgetVoiceChannelSettings.showRegionDialog(list);
    }

    private final void configureRegionOverrideVisibility(boolean isVisible) {
        View view = getBinding().o;
        m.checkNotNullExpressionValue(view, "binding.regionOverrideDivider");
        view.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().h;
        m.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsRegionOverrideContainer");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().i;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverrideHelp");
        textView.setVisibility(isVisible ? 0 : 8);
    }

    private final void configureUI(WidgetVoiceChannelSettings$Model widgetVoiceChannelSettings$Model) {
        Object next;
        String string;
        if (widgetVoiceChannelSettings$Model == null || !(widgetVoiceChannelSettings$Model.getCanManageChannel() || widgetVoiceChannelSettings$Model.getCanManagePermissions())) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this.state.clear(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131887604);
        setActionBarSubtitle(ChannelUtils.e(widgetVoiceChannelSettings$Model.getChannel(), requireContext(), false, 2));
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_voice_channel_settings, new WidgetVoiceChannelSettings$configureUI$1(this, widgetVoiceChannelSettings$Model), null, 4, null);
        TextView textView = getBinding().n;
        m.checkNotNullExpressionValue(textView, "binding.currentUserLimitDisplay");
        StatefulViews statefulViews = this.state;
        TextView textView2 = getBinding().n;
        m.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        textView.setText((CharSequence) statefulViews.get(textView2.getId(), getUserLimitDisplayString(widgetVoiceChannelSettings$Model.getChannel().getUserLimit())));
        TextView textView3 = getBinding().r;
        m.checkNotNullExpressionValue(textView3, "binding.settingsUserLimitHelp");
        b.n(textView3, 2131889121, new Object[0], null, 4);
        SeekBar seekBar = getBinding().t;
        m.checkNotNullExpressionValue(seekBar, "binding.userLimitSeekbar");
        seekBar.setProgress(widgetVoiceChannelSettings$Model.getChannel().getUserLimit());
        getBinding().t.setOnSeekBarChangeListener(new WidgetVoiceChannelSettings$configureUI$2(this));
        configureUserLimitVisibility(widgetVoiceChannelSettings$Model.getChannel().getType() == 2);
        int bitrate = widgetVoiceChannelSettings$Model.getChannel().getBitrate() / 1000;
        TextView textView4 = getBinding().m;
        m.checkNotNullExpressionValue(textView4, "binding.currentBitrateDisplay");
        StatefulViews statefulViews2 = this.state;
        TextView textView5 = getBinding().m;
        m.checkNotNullExpressionValue(textView5, "binding.currentBitrateDisplay");
        textView4.setText((CharSequence) statefulViews2.get(textView5.getId(), getBitrateDisplayString(bitrate)));
        TextView textView6 = getBinding().p;
        m.checkNotNullExpressionValue(textView6, "binding.settingsBitrateHelp");
        b.n(textView6, 2131889083, new Object[]{"64"}, null, 4);
        SeekBar seekBar2 = getBinding().f2702b;
        m.checkNotNullExpressionValue(seekBar2, "binding.bitrateSeekbar");
        int maxBitrate = widgetVoiceChannelSettings$Model.getMaxBitrate();
        Bitrate bitrate2 = Bitrate.MIN;
        seekBar2.setMax(maxBitrate - bitrate2.getKbps());
        SeekBar seekBar3 = getBinding().f2702b;
        m.checkNotNullExpressionValue(seekBar3, "binding.bitrateSeekbar");
        seekBar3.setProgress(bitrate - bitrate2.getKbps());
        getBinding().f2702b.setOnSeekBarChangeListener(new WidgetVoiceChannelSettings$configureUI$3(this));
        StatefulViews statefulViews3 = this.state;
        TextView textView7 = getBinding().g;
        m.checkNotNullExpressionValue(textView7, "binding.channelSettingsRegionOverride");
        String str = (String) statefulViews3.get(textView7.getId(), widgetVoiceChannelSettings$Model.getChannel().getRtcRegion());
        Iterator<T> it = widgetVoiceChannelSettings$Model.getRegions().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!m.areEqual(((ModelVoiceRegion) next).getId(), str));
        ModelVoiceRegion modelVoiceRegion = (ModelVoiceRegion) next;
        if (modelVoiceRegion == null || (string = modelVoiceRegion.getName()) == null) {
            string = getString(2131886954);
            m.checkNotNullExpressionValue(string, "getString(R.string.automatic_region)");
        }
        TextView textView8 = getBinding().g;
        m.checkNotNullExpressionValue(textView8, "binding.channelSettingsRegionOverride");
        textView8.setText(string);
        TextView textView9 = getBinding().i;
        m.checkNotNullExpressionValue(textView9, "binding.channelSettingsRegionOverrideHelp");
        b.n(textView9, 2131889106, new Object[0], null, 4);
        getBinding().h.setOnClickListener(new WidgetVoiceChannelSettings$configureUI$4(this, widgetVoiceChannelSettings$Model));
        configureRegionOverrideVisibility(widgetVoiceChannelSettings$Model.getCanManageChannel());
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews4 = this.state;
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews4.get(textInputLayout2.getId(), ChannelUtils.c(widgetVoiceChannelSettings$Model.getChannel())));
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        textInputLayout3.setVisibility(8);
        TextInputLayout textInputLayout4 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews5 = this.state;
        TextInputLayout textInputLayout5 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout5.getId();
        String topic = widgetVoiceChannelSettings$Model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout4, (CharSequence) statefulViews5.get(id2, topic));
        LinearLayout linearLayout = getBinding().l;
        m.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsSectionUserManagement");
        linearLayout.setVisibility(widgetVoiceChannelSettings$Model.getCanManagePermissions() ? 0 : 8);
        getBinding().f.setOnClickListener(new WidgetVoiceChannelSettings$configureUI$5(this, widgetVoiceChannelSettings$Model));
        LinearLayout linearLayout2 = getBinding().k;
        m.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsSectionPrivacySafety");
        linearLayout2.setVisibility(widgetVoiceChannelSettings$Model.getCanManageChannel() && ChannelUtils.J(widgetVoiceChannelSettings$Model.getChannel()) && TextInVoiceFeatureFlag.Companion.getINSTANCE().isEnabled(Long.valueOf(widgetVoiceChannelSettings$Model.getChannel().getGuildId())) ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        checkedSetting.setVisibility(widgetVoiceChannelSettings$Model.getCanManageChannel() ? 0 : 8);
        StatefulViews statefulViews6 = this.state;
        CheckedSetting checkedSetting2 = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.channelSettingsNsfw");
        getBinding().e.g(((Boolean) statefulViews6.get(checkedSetting2.getId(), Boolean.valueOf(widgetVoiceChannelSettings$Model.getChannel().getNsfw()))).booleanValue(), false);
        getBinding().j.setOnClickListener(new WidgetVoiceChannelSettings$configureUI$6(this, widgetVoiceChannelSettings$Model));
        this.state.configureSaveActionView(getBinding().j);
    }

    private final void configureUserLimitVisibility(boolean isVisible) {
        View view = getBinding().f2703s;
        m.checkNotNullExpressionValue(view, "binding.userLimitDivider");
        view.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().u;
        m.checkNotNullExpressionValue(textView, "binding.userLimitTitle");
        textView.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().q;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsUserLimit");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView2 = getBinding().r;
        m.checkNotNullExpressionValue(textView2, "binding.settingsUserLimitHelp");
        textView2.setVisibility(isVisible ? 0 : 8);
    }

    private final void confirmDelete(Channel channel) {
        s4 s4VarA = s4.a(LayoutInflater.from(getContext()), null, false);
        m.checkNotNullExpressionValue(s4VarA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = s4VarA.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog$Builder(linearLayout.getContext()).setView(s4VarA.a).create();
        m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        s4VarA.c.setOnClickListener(new WidgetVoiceChannelSettings$confirmDelete$1(alertDialogCreate));
        s4VarA.d.setOnClickListener(new WidgetVoiceChannelSettings$confirmDelete$2(this, channel));
        TextView textView = s4VarA.f199b;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        LinearLayout linearLayout2 = s4VarA.a;
        m.checkNotNullExpressionValue(linearLayout2, "binding.root");
        Context context = linearLayout2.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        b.n(textView, 2131888378, new Object[]{ChannelUtils.e(channel, context, false, 2)}, null, 4);
        alertDialogCreate.show();
    }

    private final WidgetVoiceChannelSettingsBinding getBinding() {
        return (WidgetVoiceChannelSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getBitrateDisplayString(int bitrate) {
        return bitrate + " Kbps";
    }

    private final CharSequence getUserLimitDisplayString(int userLimit) {
        if (userLimit == 0) {
            Resources resources = getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            return b.i(resources, 2131893290, new Object[0], null, 4);
        }
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        return StringResourceUtilsKt.getQuantityString(resources2, requireContext(), R$plurals.num_users_num, userLimit, Integer.valueOf(userLimit));
    }

    public static final void launch(long j, Context context) {
        Companion.launch(j, context);
    }

    private final void saveChannel(long channelId, String channelName, int channelType, String channelTopic, Boolean nsfw, int userLimit, int bitrate, String rtcRegion) {
        ObservableExtensionsKt.ui$default(RestAPI.Companion.getApiSerializeNulls().editVoiceChannel(channelId, channelName, channelTopic, nsfw, Integer.valueOf(channelType), Integer.valueOf(bitrate), Integer.valueOf(userLimit), rtcRegion), this, null, 2, null).k(o.a.g(getContext(), new WidgetVoiceChannelSettings$saveChannel$1(this), null));
    }

    public static /* synthetic */ void saveChannel$default(WidgetVoiceChannelSettings widgetVoiceChannelSettings, long j, String str, int i, String str2, Boolean bool, int i2, int i3, String str3, int i4, Object obj) {
        widgetVoiceChannelSettings.saveChannel(j, str, i, str2, (i4 & 16) != 0 ? null : bool, i2, i3, str3);
    }

    private final void showRegionDialog(List<? extends ModelVoiceRegion> regions) {
        n$a n_a = n.k;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceK = b.k(this, 2131889247, new Object[0], null, 4);
        List listListOf = d0.t.m.listOf(b.k(this, 2131886954, new Object[0], null, 4));
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(regions, 10));
        Iterator<T> it = regions.iterator();
        while (it.hasNext()) {
            arrayList.add(((ModelVoiceRegion) it.next()).getName());
        }
        Object[] array = u.plus((Collection) listListOf, (Iterable) arrayList).toArray(new CharSequence[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        n_a.a(parentFragmentManager, charSequenceK, (CharSequence[]) array, new WidgetVoiceChannelSettings$showRegionDialog$2(this, regions));
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
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
        statefulViews2.addOptionalFields(textView);
        StatefulViews statefulViews3 = this.state;
        FloatingActionButton floatingActionButton = getBinding().j;
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        TextView textView2 = getBinding().n;
        m.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        TextView textView3 = getBinding().m;
        m.checkNotNullExpressionValue(textView3, "binding.currentBitrateDisplay");
        CheckedSetting checkedSetting = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        statefulViews3.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3, textView2, textView3, checkedSetting);
        TextInputLayout textInputLayout4 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetVoiceChannelSettings$Model.Companion.get(getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetVoiceChannelSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceChannelSettings$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
