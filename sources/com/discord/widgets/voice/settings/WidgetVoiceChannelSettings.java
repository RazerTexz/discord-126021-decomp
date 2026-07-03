package com.discord.widgets.voice.settings;

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
import com.discord.C5419R;
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
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.voice.Bitrate;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
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
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p009a.C0837n;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p025i.C1049s4;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.C1337j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetVoiceChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceChannelSettingsBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetVoiceChannelSettings.INTENT_EXTRA_CHANNEL_ID, channelId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT…RA_CHANNEL_ID, channelId)");
            C0870j.m156d(context, WidgetVoiceChannelSettings.class, intentPutExtra);
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
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{channels, guilds, StoreUser.INSTANCE.getMeUpdate(), permissions, guildVoiceRegions, companion.getExperiments()}, false, null, null, new WidgetVoiceChannelSettings$Model$Companion$get$1(channels, channelId, guilds, permissions, users, guildVoiceRegions), 14, null)).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "ObservationDeckProvider.…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Channel channel, boolean z2, boolean z3, int i, List<? extends ModelVoiceRegion> list, long j) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(list, "regions");
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
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(regions, "regions");
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
            return C12238m.areEqual(this.channel, model.channel) && this.canManageChannel == model.canManageChannel && this.canManagePermissions == model.canManagePermissions && this.maxBitrate == model.maxBitrate && C12238m.areEqual(this.regions, model.regions) && this.guildID == model.guildID;
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
            return C0002b.m3a(this.guildID) + ((i2 + (list != null ? list.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", canManageChannel=");
            sbM833U.append(this.canManageChannel);
            sbM833U.append(", canManagePermissions=");
            sbM833U.append(this.canManagePermissions);
            sbM833U.append(", maxBitrate=");
            sbM833U.append(this.maxBitrate);
            sbM833U.append(", regions=");
            sbM833U.append(this.regions);
            sbM833U.append(", guildID=");
            return C1643a.m815C(sbM833U, this.guildID, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
    public static final class C105691 extends AbstractC12240o implements Function1<Model, Unit> {
        public C105691() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetVoiceChannelSettings.this.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$saveChannel$1 */
    /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
    public static final class C105701 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C105701() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C0876m.m169g(WidgetVoiceChannelSettings.this.getContext(), C5419R.string.channel_settings_have_been_updated, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$showRegionDialog$2 */
    /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
    public static final class C105712 extends AbstractC12240o implements Function1<Integer, Unit> {
        public final /* synthetic */ List $regions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105712(List list) {
            super(1);
            this.$regions = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            if (i == 0) {
                StatefulViews statefulViews = WidgetVoiceChannelSettings.this.state;
                TextView textView = WidgetVoiceChannelSettings.this.getBinding().f18464g;
                C12238m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
                statefulViews.put(textView.getId(), null);
                TextView textView2 = WidgetVoiceChannelSettings.this.getBinding().f18464g;
                C12238m.checkNotNullExpressionValue(textView2, "binding.channelSettingsRegionOverride");
                textView2.setText(C1107b.m213e(WidgetVoiceChannelSettings.this, C5419R.string.automatic_region, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
            } else {
                StatefulViews statefulViews2 = WidgetVoiceChannelSettings.this.state;
                TextView textView3 = WidgetVoiceChannelSettings.this.getBinding().f18464g;
                C12238m.checkNotNullExpressionValue(textView3, "binding.channelSettingsRegionOverride");
                int i2 = i - 1;
                statefulViews2.put(textView3.getId(), ((ModelVoiceRegion) this.$regions.get(i2)).getId());
                TextView textView4 = WidgetVoiceChannelSettings.this.getBinding().f18464g;
                C12238m.checkNotNullExpressionValue(textView4, "binding.channelSettingsRegionOverride");
                textView4.setText(((ModelVoiceRegion) this.$regions.get(i2)).getName());
            }
            WidgetVoiceChannelSettings.this.state.configureSaveActionView(WidgetVoiceChannelSettings.this.getBinding().f18467j);
        }
    }

    public WidgetVoiceChannelSettings() {
        super(C5419R.layout.widget_voice_channel_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetVoiceChannelSettings$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(C5419R.id.channel_settings_edit_name, C5419R.id.channel_settings_edit_topic, C5419R.id.current_user_limit_display, C5419R.id.current_bitrate_display, C5419R.id.channel_settings_region_override, C5419R.id.channel_settings_nsfw);
    }

    private final void configureRegionOverrideVisibility(boolean isVisible) {
        View view = getBinding().f18472o;
        C12238m.checkNotNullExpressionValue(view, "binding.regionOverrideDivider");
        view.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().f18465h;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsRegionOverrideContainer");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().f18466i;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverrideHelp");
        textView.setVisibility(isVisible ? 0 : 8);
    }

    private final void configureUI(final Model model) {
        Object next;
        String string;
        if (model == null || !(model.getCanManageChannel() || model.getCanManagePermissions())) {
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
                return;
            }
            return;
        }
        this.state.clear(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.m7681e(model.getChannel(), requireContext(), false, 2));
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_voice_channel_settings, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_channel_settings_delete) {
                    return;
                }
                WidgetVoiceChannelSettings.this.confirmDelete(model.getChannel());
            }
        }, null, 4, null);
        TextView textView = getBinding().f18471n;
        C12238m.checkNotNullExpressionValue(textView, "binding.currentUserLimitDisplay");
        StatefulViews statefulViews = this.state;
        TextView textView2 = getBinding().f18471n;
        C12238m.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        textView.setText((CharSequence) statefulViews.get(textView2.getId(), getUserLimitDisplayString(model.getChannel().getUserLimit())));
        TextView textView3 = getBinding().f18475r;
        C12238m.checkNotNullExpressionValue(textView3, "binding.settingsUserLimitHelp");
        C1107b.m221m(textView3, C5419R.string.form_help_user_limit, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        SeekBar seekBar = getBinding().f18477t;
        C12238m.checkNotNullExpressionValue(seekBar, "binding.userLimitSeekbar");
        seekBar.setProgress(model.getChannel().getUserLimit());
        getBinding().f18477t.setOnSeekBarChangeListener(new C1337j() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.2
            @Override // p007b.p008a.p062y.C1337j, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                C12238m.checkNotNullParameter(seekBar2, "seekBar");
                TextView textView4 = WidgetVoiceChannelSettings.this.getBinding().f18471n;
                C12238m.checkNotNullExpressionValue(textView4, "binding.currentUserLimitDisplay");
                textView4.setText(WidgetVoiceChannelSettings.this.getUserLimitDisplayString(progress));
            }
        });
        configureUserLimitVisibility(model.getChannel().getType() == 2);
        int bitrate = model.getChannel().getBitrate() / 1000;
        TextView textView4 = getBinding().f18470m;
        C12238m.checkNotNullExpressionValue(textView4, "binding.currentBitrateDisplay");
        StatefulViews statefulViews2 = this.state;
        TextView textView5 = getBinding().f18470m;
        C12238m.checkNotNullExpressionValue(textView5, "binding.currentBitrateDisplay");
        textView4.setText((CharSequence) statefulViews2.get(textView5.getId(), getBitrateDisplayString(bitrate)));
        TextView textView6 = getBinding().f18473p;
        C12238m.checkNotNullExpressionValue(textView6, "binding.settingsBitrateHelp");
        C1107b.m221m(textView6, C5419R.string.form_help_bitrate, new Object[]{"64"}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        SeekBar seekBar2 = getBinding().f18459b;
        C12238m.checkNotNullExpressionValue(seekBar2, "binding.bitrateSeekbar");
        int maxBitrate = model.getMaxBitrate();
        Bitrate bitrate2 = Bitrate.MIN;
        seekBar2.setMax(maxBitrate - bitrate2.getKbps());
        SeekBar seekBar3 = getBinding().f18459b;
        C12238m.checkNotNullExpressionValue(seekBar3, "binding.bitrateSeekbar");
        seekBar3.setProgress(bitrate - bitrate2.getKbps());
        getBinding().f18459b.setOnSeekBarChangeListener(new C1337j() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.3
            @Override // p007b.p008a.p062y.C1337j, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar4, int progress, boolean fromUser) {
                C12238m.checkNotNullParameter(seekBar4, "seekBar");
                TextView textView7 = WidgetVoiceChannelSettings.this.getBinding().f18470m;
                C12238m.checkNotNullExpressionValue(textView7, "binding.currentBitrateDisplay");
                textView7.setText(WidgetVoiceChannelSettings.this.getBitrateDisplayString(Bitrate.MIN.getKbps() + progress));
            }
        });
        StatefulViews statefulViews3 = this.state;
        TextView textView7 = getBinding().f18464g;
        C12238m.checkNotNullExpressionValue(textView7, "binding.channelSettingsRegionOverride");
        String str = (String) statefulViews3.get(textView7.getId(), model.getChannel().getRtcRegion());
        Iterator<T> it = model.getRegions().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!C12238m.areEqual(((ModelVoiceRegion) next).getId(), str));
        ModelVoiceRegion modelVoiceRegion = (ModelVoiceRegion) next;
        if (modelVoiceRegion == null || (string = modelVoiceRegion.getName()) == null) {
            string = getString(C5419R.string.automatic_region);
            C12238m.checkNotNullExpressionValue(string, "getString(R.string.automatic_region)");
        }
        TextView textView8 = getBinding().f18464g;
        C12238m.checkNotNullExpressionValue(textView8, "binding.channelSettingsRegionOverride");
        textView8.setText(string);
        TextView textView9 = getBinding().f18466i;
        C12238m.checkNotNullExpressionValue(textView9, "binding.channelSettingsRegionOverrideHelp");
        C1107b.m221m(textView9, C5419R.string.form_help_region_override, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f18465h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceChannelSettings.this.showRegionDialog(model.getRegions());
            }
        });
        configureRegionOverrideVisibility(model.getCanManageChannel());
        TextInputLayout textInputLayout = getBinding().f18460c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews4 = this.state;
        TextInputLayout textInputLayout2 = getBinding().f18460c;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews4.get(textInputLayout2.getId(), ChannelUtils.m7679c(model.getChannel())));
        TextInputLayout textInputLayout3 = getBinding().f18461d;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        textInputLayout3.setVisibility(8);
        TextInputLayout textInputLayout4 = getBinding().f18461d;
        C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews5 = this.state;
        TextInputLayout textInputLayout5 = getBinding().f18461d;
        C12238m.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout5.getId();
        String topic = model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout4, (CharSequence) statefulViews5.get(id2, topic));
        LinearLayout linearLayout = getBinding().f18469l;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsSectionUserManagement");
        linearLayout.setVisibility(model.getCanManagePermissions() ? 0 : 8);
        getBinding().f18463f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSettingsPermissionsOverview.INSTANCE.launch(WidgetVoiceChannelSettings.this.requireContext(), model.getChannel().getId());
            }
        });
        LinearLayout linearLayout2 = getBinding().f18468k;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsSectionPrivacySafety");
        linearLayout2.setVisibility(model.getCanManageChannel() && ChannelUtils.m7675J(model.getChannel()) && TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(model.getChannel().getGuildId())) ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().f18462e;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        checkedSetting.setVisibility(model.getCanManageChannel() ? 0 : 8);
        StatefulViews statefulViews6 = this.state;
        CheckedSetting checkedSetting2 = getBinding().f18462e;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.channelSettingsNsfw");
        getBinding().f18462e.m8529g(((Boolean) statefulViews6.get(checkedSetting2.getId(), Boolean.valueOf(model.getChannel().getNsfw()))).booleanValue(), false);
        getBinding().f18467j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceChannelSettings widgetVoiceChannelSettings = WidgetVoiceChannelSettings.this;
                long id3 = model.getChannel().getId();
                StatefulViews statefulViews7 = WidgetVoiceChannelSettings.this.state;
                TextInputLayout textInputLayout6 = WidgetVoiceChannelSettings.this.getBinding().f18460c;
                C12238m.checkNotNullExpressionValue(textInputLayout6, "binding.channelSettingsEditName");
                String str2 = (String) statefulViews7.get(textInputLayout6.getId(), ChannelUtils.m7679c(model.getChannel()));
                StatefulViews statefulViews8 = WidgetVoiceChannelSettings.this.state;
                TextInputLayout textInputLayout7 = WidgetVoiceChannelSettings.this.getBinding().f18461d;
                C12238m.checkNotNullExpressionValue(textInputLayout7, "binding.channelSettingsEditTopic");
                int id4 = textInputLayout7.getId();
                String topic2 = model.getChannel().getTopic();
                if (topic2 == null) {
                    topic2 = "";
                }
                String str3 = (String) statefulViews8.get(id4, topic2);
                CheckedSetting checkedSetting3 = WidgetVoiceChannelSettings.this.getBinding().f18462e;
                C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.channelSettingsNsfw");
                Boolean boolValueOf = Boolean.valueOf(checkedSetting3.isChecked());
                int type = model.getChannel().getType();
                SeekBar seekBar4 = WidgetVoiceChannelSettings.this.getBinding().f18477t;
                C12238m.checkNotNullExpressionValue(seekBar4, "binding.userLimitSeekbar");
                int progress = seekBar4.getProgress();
                SeekBar seekBar5 = WidgetVoiceChannelSettings.this.getBinding().f18459b;
                C12238m.checkNotNullExpressionValue(seekBar5, "binding.bitrateSeekbar");
                int kbps = (Bitrate.MIN.getKbps() + seekBar5.getProgress()) * 1000;
                StatefulViews statefulViews9 = WidgetVoiceChannelSettings.this.state;
                TextView textView10 = WidgetVoiceChannelSettings.this.getBinding().f18464g;
                C12238m.checkNotNullExpressionValue(textView10, "binding.channelSettingsRegionOverride");
                widgetVoiceChannelSettings.saveChannel(id3, str2, type, str3, boolValueOf, progress, kbps, (String) statefulViews9.get(textView10.getId(), model.getChannel().getRtcRegion()));
            }
        });
        this.state.configureSaveActionView(getBinding().f18467j);
    }

    private final void configureUserLimitVisibility(boolean isVisible) {
        View view = getBinding().f18476s;
        C12238m.checkNotNullExpressionValue(view, "binding.userLimitDivider");
        view.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().f18478u;
        C12238m.checkNotNullExpressionValue(textView, "binding.userLimitTitle");
        textView.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().f18474q;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.settingsUserLimit");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView2 = getBinding().f18475r;
        C12238m.checkNotNullExpressionValue(textView2, "binding.settingsUserLimitHelp");
        textView2.setVisibility(isVisible ? 0 : 8);
    }

    private final void confirmDelete(final Channel channel) {
        C1049s4 c1049s4M206a = C1049s4.m206a(LayoutInflater.from(getContext()), null, false);
        C12238m.checkNotNullExpressionValue(c1049s4M206a, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = c1049s4M206a.f1214a;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(c1049s4M206a.f1214a).create();
        C12238m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        c1049s4M206a.f1216c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.confirmDelete.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        c1049s4M206a.f1217d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings.confirmDelete.2

            /* JADX INFO: renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
            public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Channel, Unit> {
                public AnonymousClass2() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                    invoke2(channel);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Channel channel) {
                    C12238m.checkNotNullParameter(channel, "channel");
                    Integer numM7678b = ChannelUtils.m7678b(channel);
                    if (numM7678b != null) {
                        C0876m.m171i(WidgetVoiceChannelSettings.this, numM7678b.intValue(), 0, 4);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(channel.getId()), false, 1, null), WidgetVoiceChannelSettings.this, null, 2, null);
                C12238m.checkNotNullExpressionValue(view, "v");
                ObservableExtensionsKt.appSubscribe(observableUi$default, (117 & 1) != 0 ? null : view.getContext(), "javaClass", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass2(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
            }
        });
        TextView textView = c1049s4M206a.f1215b;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        LinearLayout linearLayout2 = c1049s4M206a.f1214a;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.root");
        Context context = linearLayout2.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.root.context");
        C1107b.m221m(textView, C5419R.string.delete_channel_body, new Object[]{ChannelUtils.m7681e(channel, context, false, 2)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
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
            C12238m.checkNotNullExpressionValue(resources, "resources");
            return C1107b.m211c(resources, C5419R.string.no_user_limit, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null);
        }
        Resources resources2 = getResources();
        C12238m.checkNotNullExpressionValue(resources2, "resources");
        return StringResourceUtilsKt.getQuantityString(resources2, requireContext(), C5419R.plurals.num_users_num, userLimit, Integer.valueOf(userLimit));
    }

    public static final void launch(long j, Context context) {
        INSTANCE.launch(j, context);
    }

    private final void saveChannel(long channelId, String channelName, int channelType, String channelTopic, Boolean nsfw, int userLimit, int bitrate, String rtcRegion) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApiSerializeNulls().editVoiceChannel(channelId, channelName, channelTopic, nsfw, Integer.valueOf(channelType), Integer.valueOf(bitrate), Integer.valueOf(userLimit), rtcRegion), this, null, 2, null).m11108k(C0879o.f566a.m184g(getContext(), new C105701(), null));
    }

    private final void showRegionDialog(List<? extends ModelVoiceRegion> regions) {
        C0837n.Companion companion = C0837n.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceM213e = C1107b.m213e(this, C5419R.string.form_label_region_override, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
        List listListOf = C12145m.listOf(C1107b.m213e(this, C5419R.string.automatic_region, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(regions, 10));
        Iterator<T> it = regions.iterator();
        while (it.hasNext()) {
            arrayList.add(((ModelVoiceRegion) it.next()).getName());
        }
        Object[] array = C12163u.plus((Collection) listListOf, (Iterable) arrayList).toArray(new CharSequence[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        companion.m142a(parentFragmentManager, charSequenceM213e, (CharSequence[]) array, new C105712(regions));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().f18461d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditTopic");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        TextView textView = getBinding().f18464g;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
        statefulViews2.addOptionalFields(textView);
        StatefulViews statefulViews3 = this.state;
        FloatingActionButton floatingActionButton = getBinding().f18467j;
        TextInputLayout textInputLayout2 = getBinding().f18460c;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().f18461d;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        TextView textView2 = getBinding().f18471n;
        C12238m.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        TextView textView3 = getBinding().f18470m;
        C12238m.checkNotNullExpressionValue(textView3, "binding.currentBitrateDisplay");
        CheckedSetting checkedSetting = getBinding().f18462e;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        statefulViews3.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3, textView2, textView3, checkedSetting);
        TextInputLayout textInputLayout4 = getBinding().f18461d;
        C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), (Class<?>) WidgetVoiceChannelSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C105691());
    }
}
