package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTextChannelSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.resources.DurationUnit;
import com.discord.utilities.resources.DurationUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p025i.C1042r4;
import p007b.p008a.p025i.C1049s4;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.C1337j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Action2;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings extends AppFragment {
    public static final int ONE_DAY = 86400;
    public static final int ONE_HOUR = 3600;
    public static final int ONE_MINUTE = 60;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetTextChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextChannelSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Integer> SLOWMODE_COOLDOWN_VALUES = C12147n.listOf((Object[]) new Integer[]{0, 5, 10, 15, 30, 60, 120, 300, 600, 900, Integer.valueOf(ModelInvite.Settings.HALF_HOUR), 3600, 7200, Integer.valueOf(ModelInvite.Settings.SIX_HOURS)});

    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void setDurationSecondsLabel$default(Companion companion, TextView textView, int i, Context context, int i2, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                i2 = C5419R.string.form_label_slowmode_off;
            }
            companion.setDurationSecondsLabel(textView, i, context, i2);
        }

        public final List<Integer> getSLOWMODE_COOLDOWN_VALUES() {
            return WidgetTextChannelSettings.SLOWMODE_COOLDOWN_VALUES;
        }

        public final void launch(long channelId, Context context) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
            C0870j.m156d(context, WidgetTextChannelSettings.class, intentPutExtra);
        }

        public final void setDurationSecondsLabel(TextView textView, int seconds, Context context, int zeroLabel) {
            C12238m.checkNotNullParameter(textView, "textView");
            C12238m.checkNotNullParameter(context, "context");
            if (seconds == 0) {
                textView.setText(context.getString(zeroLabel));
                return;
            }
            if (1 <= seconds && 60 > seconds) {
                DurationUtilsKt.setDurationText(textView, DurationUnit.SECONDS, seconds);
                return;
            }
            if (60 <= seconds && 3600 > seconds) {
                DurationUtilsKt.setDurationText(textView, DurationUnit.MINS, seconds / 60);
            } else if (3600 <= seconds && 86400 > seconds) {
                DurationUtilsKt.setDurationText(textView, DurationUnit.HOURS, seconds / 3600);
            } else {
                DurationUtilsKt.setDurationText(textView, DurationUnit.DAYS, seconds / 86400);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageChannel;
        private final boolean canManagePermissions;
        private final Channel channel;
        private final Guild guild;
        private final boolean isCommunityGuild;
        private final boolean isPinsEnabled;
        private final boolean isPublicGuildRulesChannel;
        private final boolean isPublicGuildUpdatesChannel;

        /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(final long channelId) {
                Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new InterfaceC12589b<Channel, Observable<? extends Model>>() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings$Model$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetTextChannelSettings.Model> call(final Channel channel) {
                        if (channel == null || ChannelUtils.m7673H(channel)) {
                            return new C12721k(null);
                        }
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return Observable.m11075i(companion.getGuilds().observeGuild(channel.getGuildId()), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForChannel(channelId), new Func3<Guild, MeUser, Long, WidgetTextChannelSettings.Model>() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings$Model$Companion$get$1.1
                            @Override // p658rx.functions.Func3
                            public final WidgetTextChannelSettings.Model call(Guild guild, MeUser meUser, Long l) {
                                Long publicUpdatesChannelId;
                                Long rulesChannelId;
                                if (guild == null) {
                                    return null;
                                }
                                boolean zCanAndIsElevated = PermissionUtils.canAndIsElevated(16L, l, meUser.getMfaEnabled(), guild.getMfaLevel());
                                boolean zCanAndIsElevated2 = PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, meUser.getMfaEnabled(), guild.getMfaLevel());
                                boolean z2 = !channel.getNsfw() || StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(channel.getGuildId());
                                boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
                                return new WidgetTextChannelSettings.Model(guild, channel, zCanAndIsElevated, zCanAndIsElevated2, z2, zContains && (rulesChannelId = guild.getRulesChannelId()) != null && rulesChannelId.longValue() == channelId, zContains && (publicUpdatesChannelId = guild.getPublicUpdatesChannelId()) != null && publicUpdatesChannelId.longValue() == channelId, zContains);
                            }
                        });
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        }\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(channel, "channel");
            this.guild = guild;
            this.channel = channel;
            this.canManageChannel = z2;
            this.canManagePermissions = z3;
            this.isPinsEnabled = z4;
            this.isPublicGuildRulesChannel = z5;
            this.isPublicGuildUpdatesChannel = z6;
            this.isCommunityGuild = z7;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getCanManagePermissions() {
            return this.canManagePermissions;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsPinsEnabled() {
            return this.isPinsEnabled;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsPublicGuildRulesChannel() {
            return this.isPublicGuildRulesChannel;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsPublicGuildUpdatesChannel() {
            return this.isPublicGuildUpdatesChannel;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getIsCommunityGuild() {
            return this.isCommunityGuild;
        }

        public final Model copy(Guild guild, Channel channel, boolean canManageChannel, boolean canManagePermissions, boolean isPinsEnabled, boolean isPublicGuildRulesChannel, boolean isPublicGuildUpdatesChannel, boolean isCommunityGuild) {
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(channel, "channel");
            return new Model(guild, channel, canManageChannel, canManagePermissions, isPinsEnabled, isPublicGuildRulesChannel, isPublicGuildUpdatesChannel, isCommunityGuild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.guild, model.guild) && C12238m.areEqual(this.channel, model.channel) && this.canManageChannel == model.canManageChannel && this.canManagePermissions == model.canManagePermissions && this.isPinsEnabled == model.isPinsEnabled && this.isPublicGuildRulesChannel == model.isPublicGuildRulesChannel && this.isPublicGuildUpdatesChannel == model.isPublicGuildUpdatesChannel && this.isCommunityGuild == model.isCommunityGuild;
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

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z2 = this.canManageChannel;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode2 + r1) * 31;
            boolean z3 = this.canManagePermissions;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.isPinsEnabled;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.isPublicGuildRulesChannel;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            boolean z6 = this.isPublicGuildUpdatesChannel;
            ?? r5 = z6;
            if (z6) {
                r5 = 1;
            }
            int i5 = (i4 + r5) * 31;
            boolean z7 = this.isCommunityGuild;
            return i5 + (z7 ? 1 : z7);
        }

        public final boolean isCommunityGuild() {
            return this.isCommunityGuild;
        }

        public final boolean isPinsEnabled() {
            return this.isPinsEnabled;
        }

        public final boolean isPublicGuildRulesChannel() {
            return this.isPublicGuildRulesChannel;
        }

        public final boolean isPublicGuildUpdatesChannel() {
            return this.isPublicGuildUpdatesChannel;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", canManageChannel=");
            sbM833U.append(this.canManageChannel);
            sbM833U.append(", canManagePermissions=");
            sbM833U.append(this.canManagePermissions);
            sbM833U.append(", isPinsEnabled=");
            sbM833U.append(this.isPinsEnabled);
            sbM833U.append(", isPublicGuildRulesChannel=");
            sbM833U.append(this.isPublicGuildRulesChannel);
            sbM833U.append(", isPublicGuildUpdatesChannel=");
            sbM833U.append(this.isPublicGuildUpdatesChannel);
            sbM833U.append(", isCommunityGuild=");
            return C1643a.m827O(sbM833U, this.isCommunityGuild, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class C76071 extends AbstractC12240o implements Function1<Model, Unit> {
        public C76071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetTextChannelSettings.this.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$saveChannel$1 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class C76081 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C76081() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Context context = WidgetTextChannelSettings.this.getContext();
            C12238m.checkNotNullExpressionValue(channel, "it");
            C0876m.m169g(context, ChannelUtils.m7687k(channel) ? C5419R.string.category_settings_have_been_updated : C5419R.string.channel_settings_have_been_updated, 0, null, 12);
        }
    }

    public WidgetTextChannelSettings() {
        super(C5419R.layout.widget_text_channel_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTextChannelSettings$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(C5419R.id.channel_settings_edit_name, C5419R.id.channel_settings_edit_topic, C5419R.id.channel_settings_slow_mode_cooldown_slider, C5419R.id.duration_selector, C5419R.id.channel_settings_announcement);
    }

    private final void cannotDeleteWarn(boolean isPublicGuildRulesChannel) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.widget_channel_settings_cannot_delete, (ViewGroup) null, false);
        int i = C5419R.id.channel_settings_cannot_delete_body;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.channel_settings_cannot_delete_body);
        if (textView != null) {
            i = C5419R.id.channel_settings_cannot_delete_confirm;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.channel_settings_cannot_delete_confirm);
            if (materialButton != null) {
                i = C5419R.id.channel_settings_cannot_delete_title;
                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.channel_settings_cannot_delete_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    C12238m.checkNotNullExpressionValue(new C1042r4(linearLayout, textView, materialButton, textView2), "WidgetChannelSettingsCan…om(context), null, false)");
                    C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
                    final AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).create();
                    C12238m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
                    textView.setText(isPublicGuildRulesChannel ? C5419R.string.delete_rules_channel_body : C5419R.string.delete_updates_channel_body);
                    materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.cannotDeleteWarn.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            alertDialogCreate.dismiss();
                        }
                    });
                    alertDialogCreate.show();
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void configureUI(final Model model) {
        if (model == null) {
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
                return;
            }
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(ChannelUtils.m7671F(model.getChannel()) ? C5419R.string.channel_settings : C5419R.string.category_settings);
        setActionBarSubtitle(ChannelUtils.m7681e(model.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(ChannelUtils.m7671F(model.getChannel()) ? C5419R.menu.menu_text_channel_settings : C5419R.menu.menu_category_settings, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case C5419R.id.menu_channel_settings_delete /* 2131364369 */:
                        if (model.isPublicGuildRulesChannel() || model.isPublicGuildUpdatesChannel()) {
                            WidgetTextChannelSettings.this.cannotDeleteWarn(model.isPublicGuildRulesChannel());
                        } else {
                            WidgetTextChannelSettings.this.confirmDelete(model.getChannel());
                        }
                        break;
                    case C5419R.id.menu_channel_settings_reset /* 2131364370 */:
                        StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                        C12238m.checkNotNullExpressionValue(context, "context");
                        userGuildSettings.setChannelNotificationsDefault(context, model.getChannel());
                        break;
                }
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.2
            @Override // p658rx.functions.Action1
            public final void call(Menu menu) {
                MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_channel_settings_delete);
                C12238m.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
                menuItemFindItem.setVisible(model.getCanManageChannel());
            }
        });
        TextInputLayout textInputLayout = getBinding().f18229c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f18229c;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), ChannelUtils.m7679c(model.getChannel())));
        getBinding().f18229c.setHint(ChannelUtils.m7671F(model.getChannel()) ? C5419R.string.form_label_channel_name : C5419R.string.category_name);
        TextInputLayout textInputLayout3 = getBinding().f18230d;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout4 = getBinding().f18230d;
        C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout4.getId();
        String topic = model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout3, (CharSequence) statefulViews2.get(id2, topic));
        TextInputLayout textInputLayout5 = getBinding().f18230d;
        C12238m.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        textInputLayout5.setVisibility(ChannelUtils.m7671F(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout = getBinding().f18231e;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsEditWrap");
        linearLayout.setVisibility(model.getCanManageChannel() ? 0 : 8);
        getBinding().f18237k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetTextChannelSettings widgetTextChannelSettings = WidgetTextChannelSettings.this;
                long id3 = model.getChannel().getId();
                StatefulViews statefulViews3 = WidgetTextChannelSettings.this.state;
                TextInputLayout textInputLayout6 = WidgetTextChannelSettings.this.getBinding().f18229c;
                C12238m.checkNotNullExpressionValue(textInputLayout6, "binding.channelSettingsEditName");
                String str = (String) statefulViews3.getIfChanged(textInputLayout6.getId());
                StatefulViews statefulViews4 = WidgetTextChannelSettings.this.state;
                TextInputLayout textInputLayout7 = WidgetTextChannelSettings.this.getBinding().f18230d;
                C12238m.checkNotNullExpressionValue(textInputLayout7, "binding.channelSettingsEditTopic");
                String str2 = (String) statefulViews4.getIfChanged(textInputLayout7.getId());
                StatefulViews statefulViews5 = WidgetTextChannelSettings.this.state;
                SeekBar seekBar = WidgetTextChannelSettings.this.getBinding().f18243q;
                C12238m.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
                WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id3, str, null, str2, null, (Integer) statefulViews5.getIfChanged(seekBar.getId()), (Integer) WidgetTextChannelSettings.this.state.getIfChanged(C5419R.id.duration_selector), 20, null);
            }
        });
        this.state.configureSaveActionView(getBinding().f18237k);
        LinearLayout linearLayout2 = getBinding().f18235i;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsPinnedMessagesContainer");
        linearLayout2.setVisibility(ChannelUtils.m7671F(model.getChannel()) ? 0 : 8);
        TextView textView = getBinding().f18234h;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelSettingsPinnedMessages");
        textView.setEnabled(model.isPinsEnabled());
        getBinding().f18234h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelPinnedMessages.INSTANCE.show(C1643a.m885x(view, "it", "it.context"), model.getChannel().getId());
            }
        });
        View view = getBinding().f18236j;
        C12238m.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(model.isPinsEnabled() ^ true ? 0 : 8);
        getBinding().f18236j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C12238m.checkNotNullExpressionValue(view2, "it");
                C0876m.m169g(view2.getContext(), C5419R.string.pins_disabled_nsfw, 0, null, 12);
            }
        });
        TextView textView2 = getBinding().f18233g;
        C12238m.checkNotNullExpressionValue(textView2, "binding.channelSettingsPermissions");
        textView2.setVisibility(model.getCanManagePermissions() ? 0 : 8);
        getBinding().f18233g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChannelSettingsPermissionsOverview.INSTANCE.launch(C1643a.m885x(view2, "it", "it.context"), model.getChannel().getId());
            }
        });
        CheckedSetting checkedSetting = getBinding().f18228b;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsAnnouncement");
        checkedSetting.setVisibility((ChannelUtils.m7697u(model.getChannel()) || ChannelUtils.m7685i(model.getChannel())) && model.getCanManageChannel() && model.isCommunityGuild() && !model.isPublicGuildRulesChannel() && !model.isPublicGuildUpdatesChannel() ? 0 : 8);
        getBinding().f18228b.m8529g(ChannelUtils.m7685i(model.getChannel()), false);
        CheckedSetting checkedSetting2 = getBinding().f18228b;
        Context context = getContext();
        checkedSetting2.m8530h(context != null ? C1107b.m210b(context, C5419R.string.form_help_news_android, new Object[]{C0862f.f507a.m149a(360032008192L, null)}, (4 & 4) != 0 ? C1107b.b.f1491j : null) : null, true);
        getBinding().f18228b.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (ChannelUtils.m7685i(model.getChannel())) {
                    WidgetTextChannelSettings.saveChannel$default(WidgetTextChannelSettings.this, model.getChannel().getId(), null, 0, null, null, null, null, 122, null);
                } else {
                    WidgetTextChannelSettings.saveChannel$default(WidgetTextChannelSettings.this, model.getChannel().getId(), null, 5, null, null, null, null, 122, null);
                }
            }
        });
        LinearLayout linearLayout3 = getBinding().f18241o;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.channelSettingsSectionUserManagement");
        linearLayout3.setVisibility(model.getCanManageChannel() || model.getCanManagePermissions() ? 0 : 8);
        LinearLayout linearLayout4 = getBinding().f18239m;
        C12238m.checkNotNullExpressionValue(linearLayout4, "binding.channelSettingsSectionPrivacySafety");
        linearLayout4.setVisibility(model.getCanManageChannel() && ChannelUtils.m7671F(model.getChannel()) ? 0 : 8);
        CheckedSetting checkedSetting3 = getBinding().f18232f;
        C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.channelSettingsNsfw");
        checkedSetting3.setVisibility(model.getCanManageChannel() ? 0 : 8);
        getBinding().f18232f.m8529g(model.getChannel().getNsfw(), false);
        getBinding().f18232f.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextChannelSettings widgetTextChannelSettings = WidgetTextChannelSettings.this;
                long id3 = model.getChannel().getId();
                CheckedSetting checkedSetting4 = WidgetTextChannelSettings.this.getBinding().f18232f;
                C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.channelSettingsNsfw");
                WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id3, null, null, null, Boolean.valueOf(!checkedSetting4.isChecked()), null, null, 110, null);
            }
        });
        LinearLayout linearLayout5 = getBinding().f18240n;
        C12238m.checkNotNullExpressionValue(linearLayout5, "binding.channelSettingsSectionSlowMode");
        linearLayout5.setVisibility(model.getCanManageChannel() && ChannelUtils.m7671F(model.getChannel()) && !ChannelUtils.m7685i(model.getChannel()) ? 0 : 8);
        int iIntValue = ((Number) this.state.get(C5419R.id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(model.getChannel().getRateLimitPerUser()))).intValue();
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
        SeekBar seekBar = getBinding().f18243q;
        C12238m.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        this.state.configureSaveActionView(getBinding().f18237k);
        SeekBar seekBar2 = getBinding().f18243q;
        C12238m.checkNotNullExpressionValue(seekBar2, "binding.channelSettingsSlowModeCooldownSlider");
        TextView textView3 = getBinding().f18242p;
        C12238m.checkNotNullExpressionValue(textView3, "binding.channelSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView3.getText());
        LinearLayout linearLayout6 = getBinding().f18238l;
        C12238m.checkNotNullExpressionValue(linearLayout6, "binding.channelSettingsS…efaultAutoArchiveDuration");
        linearLayout6.setVisibility(model.getCanManageChannel() && ChannelUtils.m7674I(model.getChannel()) && ThreadUtils.INSTANCE.isThreadsEnabled(model.getGuild().getId()) ? 0 : 8);
        Integer num = (Integer) this.state.get(C5419R.id.duration_selector, model.getChannel().getDefaultAutoArchiveDuration());
        int iIntValue2 = num != null ? num.intValue() : 1440;
        this.state.configureSaveActionView(getBinding().f18237k);
        final Map<MaterialRadioButton, Integer> mapMapOf = C12136h0.mapOf(C12116o.m10073to(getBinding().f18244r.f18256e, 60), C12116o.m10073to(getBinding().f18244r.f18262k, 1440), C12116o.m10073to(getBinding().f18244r.f18260i, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES)), C12116o.m10073to(getBinding().f18244r.f18258g, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES)));
        getBinding().f18244r.f18255d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextChannelSettings.this.state.put(C5419R.id.duration_selector, 60);
                WidgetTextChannelSettings.this.state.configureSaveActionView(WidgetTextChannelSettings.this.getBinding().f18237k);
                WidgetTextChannelSettings.this.updateRadioState(mapMapOf, 60);
            }
        });
        getBinding().f18244r.f18261j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextChannelSettings.this.state.put(C5419R.id.duration_selector, 1440);
                WidgetTextChannelSettings.this.state.configureSaveActionView(WidgetTextChannelSettings.this.getBinding().f18237k);
                WidgetTextChannelSettings.this.updateRadioState(mapMapOf, 1440);
            }
        });
        getBinding().f18244r.f18259h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextChannelSettings.this.state.put(C5419R.id.duration_selector, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES));
                WidgetTextChannelSettings.this.state.configureSaveActionView(WidgetTextChannelSettings.this.getBinding().f18237k);
                WidgetTextChannelSettings.this.updateRadioState(mapMapOf, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
            }
        });
        getBinding().f18244r.f18257f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextChannelSettings.this.state.put(C5419R.id.duration_selector, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES));
                WidgetTextChannelSettings.this.state.configureSaveActionView(WidgetTextChannelSettings.this.getBinding().f18237k);
                WidgetTextChannelSettings.this.updateRadioState(mapMapOf, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
            }
        });
        updateRadioState(mapMapOf, iIntValue2);
    }

    private final void confirmDelete(final Channel channel) {
        C1049s4 c1049s4M206a = C1049s4.m206a(LayoutInflater.from(getContext()), null, false);
        C12238m.checkNotNullExpressionValue(c1049s4M206a, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = c1049s4M206a.f1214a;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(c1049s4M206a.f1214a).create();
        C12238m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        c1049s4M206a.f1218e.setText(ChannelUtils.m7671F(channel) ? C5419R.string.delete_channel : C5419R.string.delete_category);
        c1049s4M206a.f1216c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.confirmDelete.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        c1049s4M206a.f1217d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.confirmDelete.2

            /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
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
                        C0876m.m171i(WidgetTextChannelSettings.this, numM7678b.intValue(), 0, 4);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(channel.getId()), false, 1, null), WidgetTextChannelSettings.this, null, 2, null);
                C12238m.checkNotNullExpressionValue(view, "v");
                ObservableExtensionsKt.appSubscribe(observableUi$default, (117 & 1) != 0 ? null : view.getContext(), "javaClass", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass2(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
            }
        });
        TextView textView = c1049s4M206a.f1215b;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        C1107b.m221m(textView, C5419R.string.delete_channel_body, new Object[]{ChannelUtils.m7681e(channel, requireContext(), false, 2)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        alertDialogCreate.show();
    }

    private final WidgetTextChannelSettingsBinding getBinding() {
        return (WidgetTextChannelSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(long j, Context context) {
        INSTANCE.launch(j, context);
    }

    private final void saveChannel(long id2, String name, Integer type, String topic, Boolean nsfw, Integer rateLimit, Integer defaultAutoArchiveDuration) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().editTextChannel(id2, name, type, topic, nsfw, rateLimit, defaultAutoArchiveDuration), this, null, 2, null).m11108k(C0879o.f566a.m184g(getContext(), new C76081(), null));
    }

    public static /* synthetic */ void saveChannel$default(WidgetTextChannelSettings widgetTextChannelSettings, long j, String str, Integer num, String str2, Boolean bool, Integer num2, Integer num3, int i, Object obj) {
        widgetTextChannelSettings.saveChannel(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3);
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        Companion companion = INSTANCE;
        TextView textView = getBinding().f18242p;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
        companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), C5419R.string.form_label_slowmode_off);
    }

    private final void updateRadioState(Map<MaterialRadioButton, Integer> durationMap, int newDuration) {
        for (Map.Entry<MaterialRadioButton, Integer> entry : durationMap.entrySet()) {
            entry.getKey().setChecked(entry.getValue().intValue() == newDuration);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().f18230d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditTopic");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        FloatingActionButton floatingActionButton = getBinding().f18237k;
        TextInputLayout textInputLayout2 = getBinding().f18229c;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().f18230d;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3);
        SeekBar seekBar = getBinding().f18243q;
        C12238m.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setMax(C12147n.getLastIndex(SLOWMODE_COOLDOWN_VALUES));
        getBinding().f18243q.setOnSeekBarChangeListener(new C1337j() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.onViewBound.1
            @Override // p007b.p008a.p062y.C1337j, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                C12238m.checkNotNullParameter(seekBar2, "seekBar");
                super.onProgressChanged(seekBar2, progress, fromUser);
                if (fromUser) {
                    int iIntValue = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
                    WidgetTextChannelSettings.this.setSlowmodeLabel(iIntValue);
                    WidgetTextChannelSettings.this.state.put(C5419R.id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(iIntValue));
                    WidgetTextChannelSettings.this.state.configureSaveActionView(WidgetTextChannelSettings.this.getBinding().f18237k);
                    TextView textView = WidgetTextChannelSettings.this.getBinding().f18242p;
                    C12238m.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
                    seekBar2.setContentDescription(textView.getText());
                }
            }
        });
        TextInputLayout textInputLayout4 = getBinding().f18230d;
        C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)), this, null, 2, null), (Class<?>) WidgetTextChannelSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76071());
    }
}
