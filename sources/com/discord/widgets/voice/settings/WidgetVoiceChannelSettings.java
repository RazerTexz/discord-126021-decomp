package com.discord.widgets.voice.settings;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.SelectorDialog;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.i.WidgetChannelSettingsDeleteBinding;
import b.a.k.FormatUtils;
import b.a.y.OnSeekBarChangeListenerAdapter;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceChannelSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildVoiceRegions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.voice.Bitrate;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceChannelSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;

    /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long channelId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetVoiceChannelSettings.INTENT_EXTRA_CHANNEL_ID, channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT…RA_CHANNEL_ID, channelId)");
            AppScreen2.d(context, WidgetVoiceChannelSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageChannel;
        private final boolean canManagePermissions;
        private final Channel channel;
        private final long guildID;
        private final int maxBitrate;
        private final List<ModelVoiceRegion> regions;

        /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                StoreChannels channels = companion.getChannels();
                StoreGuilds guilds = companion.getGuilds();
                StoreUser users = companion.getUsers();
                StorePermissions permissions = companion.getPermissions();
                StoreGuildVoiceRegions guildVoiceRegions = companion.getGuildVoiceRegions();
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{channels, guilds, StoreUser.INSTANCE.getMeUpdate(), permissions, guildVoiceRegions, companion.getExperiments()}, false, null, null, new WidgetVoiceChannelSettings2(channels, channelId, guilds, permissions, users, guildVoiceRegions), 14, null)).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Channel channel, boolean z2, boolean z3, int i, List<? extends ModelVoiceRegion> list, long j) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(list, "regions");
            this.channel = channel;
            this.canManageChannel = z2;
            this.canManagePermissions = z3;
            this.maxBitrate = i;
            this.regions = list;
            this.guildID = j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, Channel channel, boolean z2, boolean z3, int i, List list, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                channel = model.channel;
            }
            if ((i2 & 2) != 0) {
                z2 = model.canManageChannel;
            }
            boolean z4 = z2;
            if ((i2 & 4) != 0) {
                z3 = model.canManagePermissions;
            }
            boolean z5 = z3;
            if ((i2 & 8) != 0) {
                i = model.maxBitrate;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                list = model.regions;
            }
            List list2 = list;
            if ((i2 & 32) != 0) {
                j = model.guildID;
            }
            return model.copy(channel, z4, z5, i3, list2, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getCanManagePermissions() {
            return this.canManagePermissions;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getMaxBitrate() {
            return this.maxBitrate;
        }

        public final List<ModelVoiceRegion> component5() {
            return this.regions;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getGuildID() {
            return this.guildID;
        }

        public final Model copy(Channel channel, boolean canManageChannel, boolean canManagePermissions, int maxBitrate, List<? extends ModelVoiceRegion> regions, long guildID) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(regions, "regions");
            return new Model(channel, canManageChannel, canManagePermissions, maxBitrate, regions, guildID);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.channel, model.channel) && this.canManageChannel == model.canManageChannel && this.canManagePermissions == model.canManagePermissions && this.maxBitrate == model.maxBitrate && Intrinsics3.areEqual(this.regions, model.regions) && this.guildID == model.guildID;
        }

        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        public final boolean getCanManagePermissions() {
            return this.canManagePermissions;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final long getGuildID() {
            return this.guildID;
        }

        public final int getMaxBitrate() {
            return this.maxBitrate;
        }

        public final List<ModelVoiceRegion> getRegions() {
            return this.regions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.canManageChannel;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            boolean z3 = this.canManagePermissions;
            int i2 = (((i + (z3 ? 1 : z3)) * 31) + this.maxBitrate) * 31;
            List<ModelVoiceRegion> list = this.regions;
            return b.a(this.guildID) + ((i2 + (list != null ? list.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", canManageChannel=");
            sbU.append(this.canManageChannel);
            sbU.append(", canManagePermissions=");
            sbU.append(this.canManagePermissions);
            sbU.append(", maxBitrate=");
            sbU.append(this.maxBitrate);
            sbU.append(", regions=");
            sbU.append(this.regions);
            sbU.append(", guildID=");
            return outline.C(sbU, this.guildID, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetVoiceChannelSettings.this.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$saveChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            AppToast.g(WidgetVoiceChannelSettings.this.getContext(), R.string.channel_settings_have_been_updated, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$showRegionDialog$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ List $regions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list) {
            super(1);
            this.$regions = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            if (i == 0) {
                StatefulViews statefulViews = WidgetVoiceChannelSettings.this.state;
                TextView textView = WidgetVoiceChannelSettings.this.getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
                statefulViews.put(textView.getId(), null);
                TextView textView2 = WidgetVoiceChannelSettings.this.getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelSettingsRegionOverride");
                textView2.setText(FormatUtils.e(WidgetVoiceChannelSettings.this, R.string.automatic_region, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
            } else {
                StatefulViews statefulViews2 = WidgetVoiceChannelSettings.this.state;
                TextView textView3 = WidgetVoiceChannelSettings.this.getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelSettingsRegionOverride");
                int i2 = i - 1;
                statefulViews2.put(textView3.getId(), ((ModelVoiceRegion) this.$regions.get(i2)).getId());
                TextView textView4 = WidgetVoiceChannelSettings.this.getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.channelSettingsRegionOverride");
                textView4.setText(((ModelVoiceRegion) this.$regions.get(i2)).getName());
            }
            WidgetVoiceChannelSettings.this.state.configureSaveActionView(WidgetVoiceChannelSettings.this.getBinding().j);
        }
    }

    public WidgetVoiceChannelSettings() {
        super(R.layout.widget_voice_channel_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceChannelSettings3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.channel_settings_edit_name, R.id.channel_settings_edit_topic, R.id.current_user_limit_display, R.id.current_bitrate_display, R.id.channel_settings_region_override, R.id.channel_settings_nsfw);
    }

    private final void configureRegionOverrideVisibility(boolean isVisible) {
        View view = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.regionOverrideDivider");
        view.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsRegionOverrideContainer");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverrideHelp");
        textView.setVisibility(isVisible ? 0 : 8);
    }

    private final void configureUI(final Model model) {
        Object next;
        String string;
        if (model == null || !(model.getCanManageChannel() || model.getCanManagePermissions())) {
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
                return;
            }
            return;
        }
        this.state.clear(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.e(model.getChannel(), requireContext(), false, 2));
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_voice_channel_settings, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != R.id.menu_channel_settings_delete) {
                    return;
                }
                WidgetVoiceChannelSettings.this.confirmDelete(model.getChannel());
            }
        }, null, 4, null);
        TextView textView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.currentUserLimitDisplay");
        StatefulViews statefulViews = this.state;
        TextView textView2 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        textView.setText((CharSequence) statefulViews.get(textView2.getId(), getUserLimitDisplayString(model.getChannel().getUserLimit())));
        TextView textView3 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.settingsUserLimitHelp");
        FormatUtils.m(textView3, R.string.form_help_user_limit, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        SeekBar seekBar = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.userLimitSeekbar");
        seekBar.setProgress(model.getChannel().getUserLimit());
        getBinding().t.setOnSeekBarChangeListener(new OnSeekBarChangeListenerAdapter() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.2
            @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                Intrinsics3.checkNotNullParameter(seekBar2, "seekBar");
                TextView textView4 = WidgetVoiceChannelSettings.this.getBinding().n;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.currentUserLimitDisplay");
                textView4.setText(WidgetVoiceChannelSettings.this.getUserLimitDisplayString(progress));
            }
        });
        configureUserLimitVisibility(model.getChannel().getType() == 2);
        int bitrate = model.getChannel().getBitrate() / 1000;
        TextView textView4 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.currentBitrateDisplay");
        StatefulViews statefulViews2 = this.state;
        TextView textView5 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.currentBitrateDisplay");
        textView4.setText((CharSequence) statefulViews2.get(textView5.getId(), getBitrateDisplayString(bitrate)));
        TextView textView6 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.settingsBitrateHelp");
        FormatUtils.m(textView6, R.string.form_help_bitrate, new Object[]{"64"}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        SeekBar seekBar2 = getBinding().f2702b;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.bitrateSeekbar");
        int maxBitrate = model.getMaxBitrate();
        Bitrate bitrate2 = Bitrate.MIN;
        seekBar2.setMax(maxBitrate - bitrate2.getKbps());
        SeekBar seekBar3 = getBinding().f2702b;
        Intrinsics3.checkNotNullExpressionValue(seekBar3, "binding.bitrateSeekbar");
        seekBar3.setProgress(bitrate - bitrate2.getKbps());
        getBinding().f2702b.setOnSeekBarChangeListener(new OnSeekBarChangeListenerAdapter() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.3
            @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar4, int progress, boolean fromUser) {
                Intrinsics3.checkNotNullParameter(seekBar4, "seekBar");
                TextView textView7 = WidgetVoiceChannelSettings.this.getBinding().m;
                Intrinsics3.checkNotNullExpressionValue(textView7, "binding.currentBitrateDisplay");
                textView7.setText(WidgetVoiceChannelSettings.this.getBitrateDisplayString(Bitrate.MIN.getKbps() + progress));
            }
        });
        StatefulViews statefulViews3 = this.state;
        TextView textView7 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.channelSettingsRegionOverride");
        String str = (String) statefulViews3.get(textView7.getId(), model.getChannel().getRtcRegion());
        Iterator<T> it = model.getRegions().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics3.areEqual(((ModelVoiceRegion) next).getId(), str));
        ModelVoiceRegion modelVoiceRegion = (ModelVoiceRegion) next;
        if (modelVoiceRegion == null || (string = modelVoiceRegion.getName()) == null) {
            string = getString(R.string.automatic_region);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.automatic_region)");
        }
        TextView textView8 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.channelSettingsRegionOverride");
        textView8.setText(string);
        TextView textView9 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.channelSettingsRegionOverrideHelp");
        FormatUtils.m(textView9, R.string.form_help_region_override, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceChannelSettings.this.showRegionDialog(model.getRegions());
            }
        });
        configureRegionOverrideVisibility(model.getCanManageChannel());
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews4 = this.state;
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews4.get(textInputLayout2.getId(), ChannelUtils.c(model.getChannel())));
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        textInputLayout3.setVisibility(8);
        TextInputLayout textInputLayout4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews5 = this.state;
        TextInputLayout textInputLayout5 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout5.getId();
        String topic = model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout4, (CharSequence) statefulViews5.get(id2, topic));
        LinearLayout linearLayout = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsSectionUserManagement");
        linearLayout.setVisibility(model.getCanManagePermissions() ? 0 : 8);
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSettingsPermissionsOverview.INSTANCE.launch(WidgetVoiceChannelSettings.this.requireContext(), model.getChannel().getId());
            }
        });
        LinearLayout linearLayout2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsSectionPrivacySafety");
        linearLayout2.setVisibility(model.getCanManageChannel() && ChannelUtils.J(model.getChannel()) && TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(model.getChannel().getGuildId())) ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        checkedSetting.setVisibility(model.getCanManageChannel() ? 0 : 8);
        StatefulViews statefulViews6 = this.state;
        CheckedSetting checkedSetting2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.channelSettingsNsfw");
        getBinding().e.g(((Boolean) statefulViews6.get(checkedSetting2.getId(), Boolean.valueOf(model.getChannel().getNsfw()))).booleanValue(), false);
        getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceChannelSettings widgetVoiceChannelSettings = WidgetVoiceChannelSettings.this;
                long id3 = model.getChannel().getId();
                StatefulViews statefulViews7 = WidgetVoiceChannelSettings.this.state;
                TextInputLayout textInputLayout6 = WidgetVoiceChannelSettings.this.getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.channelSettingsEditName");
                String str2 = (String) statefulViews7.get(textInputLayout6.getId(), ChannelUtils.c(model.getChannel()));
                StatefulViews statefulViews8 = WidgetVoiceChannelSettings.this.state;
                TextInputLayout textInputLayout7 = WidgetVoiceChannelSettings.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.channelSettingsEditTopic");
                int id4 = textInputLayout7.getId();
                String topic2 = model.getChannel().getTopic();
                if (topic2 == null) {
                    topic2 = "";
                }
                String str3 = (String) statefulViews8.get(id4, topic2);
                CheckedSetting checkedSetting3 = WidgetVoiceChannelSettings.this.getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.channelSettingsNsfw");
                Boolean boolValueOf = Boolean.valueOf(checkedSetting3.isChecked());
                int type = model.getChannel().getType();
                SeekBar seekBar4 = WidgetVoiceChannelSettings.this.getBinding().t;
                Intrinsics3.checkNotNullExpressionValue(seekBar4, "binding.userLimitSeekbar");
                int progress = seekBar4.getProgress();
                SeekBar seekBar5 = WidgetVoiceChannelSettings.this.getBinding().f2702b;
                Intrinsics3.checkNotNullExpressionValue(seekBar5, "binding.bitrateSeekbar");
                int kbps = (Bitrate.MIN.getKbps() + seekBar5.getProgress()) * 1000;
                StatefulViews statefulViews9 = WidgetVoiceChannelSettings.this.state;
                TextView textView10 = WidgetVoiceChannelSettings.this.getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView10, "binding.channelSettingsRegionOverride");
                widgetVoiceChannelSettings.saveChannel(id3, str2, type, str3, boolValueOf, progress, kbps, (String) statefulViews9.get(textView10.getId(), model.getChannel().getRtcRegion()));
            }
        });
        this.state.configureSaveActionView(getBinding().j);
    }

    private final void configureUserLimitVisibility(boolean isVisible) {
        View view = getBinding().f2703s;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.userLimitDivider");
        view.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().u;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userLimitTitle");
        textView.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsUserLimit");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView2 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsUserLimitHelp");
        textView2.setVisibility(isVisible ? 0 : 8);
    }

    private final void confirmDelete(final Channel channel) {
        WidgetChannelSettingsDeleteBinding widgetChannelSettingsDeleteBindingA = WidgetChannelSettingsDeleteBinding.a(LayoutInflater.from(getContext()), null, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsDeleteBindingA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = widgetChannelSettingsDeleteBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(widgetChannelSettingsDeleteBindingA.a).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        widgetChannelSettingsDeleteBindingA.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.confirmDelete.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        widgetChannelSettingsDeleteBindingA.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.confirmDelete.2

            /* JADX INFO: renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
            public static final class C03672 extends Lambda implements Function1<Channel, Unit> {
                public C03672() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                    invoke2(channel);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Channel channel) {
                    Intrinsics3.checkNotNullParameter(channel, "channel");
                    Integer numB = ChannelUtils.b(channel);
                    if (numB != null) {
                        AppToast.i(WidgetVoiceChannelSettings.this, numB.intValue(), 0, 4);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(channel.getId()), false, 1, null), WidgetVoiceChannelSettings.this, null, 2, null);
                Intrinsics3.checkNotNullExpressionValue(view, "v");
                ObservableExtensionsKt.appSubscribe(observableUi$default, (117 & 1) != 0 ? null : view.getContext(), "javaClass", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C03672(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
            }
        });
        TextView textView = widgetChannelSettingsDeleteBindingA.f199b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        LinearLayout linearLayout2 = widgetChannelSettingsDeleteBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.root");
        Context context = linearLayout2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        FormatUtils.m(textView, R.string.delete_channel_body, new Object[]{ChannelUtils.e(channel, context, false, 2)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
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
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            return FormatUtils.c(resources, R.string.no_user_limit, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
        }
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        return StringResourceUtils.getQuantityString(resources2, requireContext(), R.plurals.num_users_num, userLimit, Integer.valueOf(userLimit));
    }

    public static final void launch(long j, Context context) {
        INSTANCE.launch(j, context);
    }

    private final void saveChannel(long channelId, String channelName, int channelType, String channelTopic, Boolean nsfw, int userLimit, int bitrate, String rtcRegion) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApiSerializeNulls().editVoiceChannel(channelId, channelName, channelTopic, nsfw, Integer.valueOf(channelType), Integer.valueOf(bitrate), Integer.valueOf(userLimit), rtcRegion), this, null, 2, null).k(o.a.g(getContext(), new AnonymousClass1(), null));
    }

    private final void showRegionDialog(List<? extends ModelVoiceRegion> regions) {
        SelectorDialog.Companion companion = SelectorDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceE = FormatUtils.e(this, R.string.form_label_region_override, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
        List listListOf = CollectionsJVM.listOf(FormatUtils.e(this, R.string.automatic_region, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(regions, 10));
        Iterator<T> it = regions.iterator();
        while (it.hasNext()) {
            arrayList.add(((ModelVoiceRegion) it.next()).getName());
        }
        Object[] array = _Collections.plus((Collection) listListOf, (Iterable) arrayList).toArray(new CharSequence[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        companion.a(parentFragmentManager, charSequenceE, (CharSequence[]) array, new AnonymousClass2(regions));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditTopic");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
        statefulViews2.addOptionalFields(textView);
        StatefulViews statefulViews3 = this.state;
        FloatingActionButton floatingActionButton = getBinding().j;
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        TextView textView2 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        TextView textView3 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.currentBitrateDisplay");
        CheckedSetting checkedSetting = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        statefulViews3.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3, textView2, textView3, checkedSetting);
        TextInputLayout textInputLayout4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), (Class<?>) WidgetVoiceChannelSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
