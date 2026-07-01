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
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.i.WidgetChannelSettingsCannotDeleteBinding;
import b.a.i.WidgetChannelSettingsDeleteBinding;
import b.a.k.FormatUtils;
import b.a.y.OnSeekBarChangeListenerAdapter;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.resources.DurationUtils2;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings extends AppFragment {
    public static final int ONE_DAY = 86400;
    public static final int ONE_HOUR = 3600;
    public static final int ONE_MINUTE = 60;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTextChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextChannelSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Integer> SLOWMODE_COOLDOWN_VALUES = Collections2.listOf((Object[]) new Integer[]{0, 5, 10, 15, 30, 60, 120, 300, 600, 900, Integer.valueOf(ModelInvite.Settings.HALF_HOUR), 3600, 7200, Integer.valueOf(ModelInvite.Settings.SIX_HOURS)});

    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void setDurationSecondsLabel$default(Companion companion, TextView textView, int i, Context context, int i2, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                i2 = R.string.form_label_slowmode_off;
            }
            companion.setDurationSecondsLabel(textView, i, context, i2);
        }

        public final List<Integer> getSLOWMODE_COOLDOWN_VALUES() {
            return WidgetTextChannelSettings.SLOWMODE_COOLDOWN_VALUES;
        }

        public final void launch(long channelId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
            AppScreen2.d(context, WidgetTextChannelSettings.class, intentPutExtra);
        }

        public final void setDurationSecondsLabel(TextView textView, int seconds, Context context, int zeroLabel) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            Intrinsics3.checkNotNullParameter(context, "context");
            if (seconds == 0) {
                textView.setText(context.getString(zeroLabel));
                return;
            }
            if (1 <= seconds && 60 > seconds) {
                DurationUtils3.setDurationText(textView, DurationUtils2.SECONDS, seconds);
                return;
            }
            if (60 <= seconds && 3600 > seconds) {
                DurationUtils3.setDurationText(textView, DurationUtils2.MINS, seconds / 60);
            } else if (3600 <= seconds && 86400 > seconds) {
                DurationUtils3.setDurationText(textView, DurationUtils2.HOURS, seconds / 3600);
            } else {
                DurationUtils3.setDurationText(textView, DurationUtils2.DAYS, seconds / 86400);
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
                Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new Func1<Channel, Observable<? extends Model>>() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetTextChannelSettings.Model> call(final Channel channel) {
                        if (channel == null || ChannelUtils.H(channel)) {
                            return new ScalarSynchronousObservable(null);
                        }
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return Observable.i(companion.getGuilds().observeGuild(channel.getGuildId()), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForChannel(channelId), new Func3<Guild, MeUser, Long, WidgetTextChannelSettings.Model>() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings$Model$Companion$get$1.1
                            @Override // rx.functions.Func3
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
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel) && this.canManageChannel == model.canManageChannel && this.canManagePermissions == model.canManagePermissions && this.isPinsEnabled == model.isPinsEnabled && this.isPublicGuildRulesChannel == model.isPublicGuildRulesChannel && this.isPublicGuildUpdatesChannel == model.isPublicGuildUpdatesChannel && this.isCommunityGuild == model.isCommunityGuild;
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
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", canManageChannel=");
            sbU.append(this.canManageChannel);
            sbU.append(", canManagePermissions=");
            sbU.append(this.canManagePermissions);
            sbU.append(", isPinsEnabled=");
            sbU.append(this.isPinsEnabled);
            sbU.append(", isPublicGuildRulesChannel=");
            sbU.append(this.isPublicGuildRulesChannel);
            sbU.append(", isPublicGuildUpdatesChannel=");
            sbU.append(this.isPublicGuildUpdatesChannel);
            sbU.append(", isCommunityGuild=");
            return outline.O(sbU, this.isCommunityGuild, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
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
            WidgetTextChannelSettings.this.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$saveChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
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
            Context context = WidgetTextChannelSettings.this.getContext();
            Intrinsics3.checkNotNullExpressionValue(channel, "it");
            AppToast.g(context, ChannelUtils.k(channel) ? R.string.category_settings_have_been_updated : R.string.channel_settings_have_been_updated, 0, null, 12);
        }
    }

    public WidgetTextChannelSettings() {
        super(R.layout.widget_text_channel_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTextChannelSettings3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.channel_settings_edit_name, R.id.channel_settings_edit_topic, R.id.channel_settings_slow_mode_cooldown_slider, R.id.duration_selector, R.id.channel_settings_announcement);
    }

    private final void cannotDeleteWarn(boolean isPublicGuildRulesChannel) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.widget_channel_settings_cannot_delete, (ViewGroup) null, false);
        int i = R.id.channel_settings_cannot_delete_body;
        TextView textView = (TextView) viewInflate.findViewById(R.id.channel_settings_cannot_delete_body);
        if (textView != null) {
            i = R.id.channel_settings_cannot_delete_confirm;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.channel_settings_cannot_delete_confirm);
            if (materialButton != null) {
                i = R.id.channel_settings_cannot_delete_title;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.channel_settings_cannot_delete_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    Intrinsics3.checkNotNullExpressionValue(new WidgetChannelSettingsCannotDeleteBinding(linearLayout, textView, materialButton, textView2), "WidgetChannelSettingsCan…om(context), null, false)");
                    Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                    final AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).create();
                    Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
                    textView.setText(isPublicGuildRulesChannel ? R.string.delete_rules_channel_body : R.string.delete_updates_channel_body);
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
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
                return;
            }
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(ChannelUtils.F(model.getChannel()) ? R.string.channel_settings : R.string.category_settings);
        setActionBarSubtitle(ChannelUtils.e(model.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(ChannelUtils.F(model.getChannel()) ? R.menu.menu_text_channel_settings : R.menu.menu_category_settings, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case R.id.menu_channel_settings_delete /* 2131364369 */:
                        if (model.isPublicGuildRulesChannel() || model.isPublicGuildUpdatesChannel()) {
                            WidgetTextChannelSettings.this.cannotDeleteWarn(model.isPublicGuildRulesChannel());
                        } else {
                            WidgetTextChannelSettings.this.confirmDelete(model.getChannel());
                        }
                        break;
                    case R.id.menu_channel_settings_reset /* 2131364370 */:
                        StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                        Intrinsics3.checkNotNullExpressionValue(context, "context");
                        userGuildSettings.setChannelNotificationsDefault(context, model.getChannel());
                        break;
                }
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.2
            @Override // rx.functions.Action1
            public final void call(Menu menu) {
                MenuItem menuItemFindItem = menu.findItem(R.id.menu_channel_settings_delete);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
                menuItemFindItem.setVisible(model.getCanManageChannel());
            }
        });
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), ChannelUtils.c(model.getChannel())));
        getBinding().c.setHint(ChannelUtils.F(model.getChannel()) ? R.string.form_label_channel_name : R.string.category_name);
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout4.getId();
        String topic = model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout3, (CharSequence) statefulViews2.get(id2, topic));
        TextInputLayout textInputLayout5 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        textInputLayout5.setVisibility(ChannelUtils.F(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsEditWrap");
        linearLayout.setVisibility(model.getCanManageChannel() ? 0 : 8);
        getBinding().k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetTextChannelSettings widgetTextChannelSettings = WidgetTextChannelSettings.this;
                long id3 = model.getChannel().getId();
                StatefulViews statefulViews3 = WidgetTextChannelSettings.this.state;
                TextInputLayout textInputLayout6 = WidgetTextChannelSettings.this.getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.channelSettingsEditName");
                String str = (String) statefulViews3.getIfChanged(textInputLayout6.getId());
                StatefulViews statefulViews4 = WidgetTextChannelSettings.this.state;
                TextInputLayout textInputLayout7 = WidgetTextChannelSettings.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.channelSettingsEditTopic");
                String str2 = (String) statefulViews4.getIfChanged(textInputLayout7.getId());
                StatefulViews statefulViews5 = WidgetTextChannelSettings.this.state;
                SeekBar seekBar = WidgetTextChannelSettings.this.getBinding().q;
                Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
                WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id3, str, null, str2, null, (Integer) statefulViews5.getIfChanged(seekBar.getId()), (Integer) WidgetTextChannelSettings.this.state.getIfChanged(R.id.duration_selector), 20, null);
            }
        });
        this.state.configureSaveActionView(getBinding().k);
        LinearLayout linearLayout2 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsPinnedMessagesContainer");
        linearLayout2.setVisibility(ChannelUtils.F(model.getChannel()) ? 0 : 8);
        TextView textView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsPinnedMessages");
        textView.setEnabled(model.isPinsEnabled());
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelPinnedMessages.INSTANCE.show(outline.x(view, "it", "it.context"), model.getChannel().getId());
            }
        });
        View view = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(model.isPinsEnabled() ^ true ? 0 : 8);
        getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                AppToast.g(view2.getContext(), R.string.pins_disabled_nsfw, 0, null, 12);
            }
        });
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelSettingsPermissions");
        textView2.setVisibility(model.getCanManagePermissions() ? 0 : 8);
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChannelSettingsPermissionsOverview.INSTANCE.launch(outline.x(view2, "it", "it.context"), model.getChannel().getId());
            }
        });
        CheckedSetting checkedSetting = getBinding().f2665b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsAnnouncement");
        checkedSetting.setVisibility((ChannelUtils.u(model.getChannel()) || ChannelUtils.i(model.getChannel())) && model.getCanManageChannel() && model.isCommunityGuild() && !model.isPublicGuildRulesChannel() && !model.isPublicGuildUpdatesChannel() ? 0 : 8);
        getBinding().f2665b.g(ChannelUtils.i(model.getChannel()), false);
        CheckedSetting checkedSetting2 = getBinding().f2665b;
        Context context = getContext();
        checkedSetting2.h(context != null ? FormatUtils.b(context, R.string.form_help_news_android, new Object[]{AppHelpDesk.a.a(360032008192L, null)}, (4 & 4) != 0 ? FormatUtils.b.j : null) : null, true);
        getBinding().f2665b.e(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (ChannelUtils.i(model.getChannel())) {
                    WidgetTextChannelSettings.saveChannel$default(WidgetTextChannelSettings.this, model.getChannel().getId(), null, 0, null, null, null, null, 122, null);
                } else {
                    WidgetTextChannelSettings.saveChannel$default(WidgetTextChannelSettings.this, model.getChannel().getId(), null, 5, null, null, null, null, 122, null);
                }
            }
        });
        LinearLayout linearLayout3 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.channelSettingsSectionUserManagement");
        linearLayout3.setVisibility(model.getCanManageChannel() || model.getCanManagePermissions() ? 0 : 8);
        LinearLayout linearLayout4 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.channelSettingsSectionPrivacySafety");
        linearLayout4.setVisibility(model.getCanManageChannel() && ChannelUtils.F(model.getChannel()) ? 0 : 8);
        CheckedSetting checkedSetting3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.channelSettingsNsfw");
        checkedSetting3.setVisibility(model.getCanManageChannel() ? 0 : 8);
        getBinding().f.g(model.getChannel().getNsfw(), false);
        getBinding().f.e(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextChannelSettings widgetTextChannelSettings = WidgetTextChannelSettings.this;
                long id3 = model.getChannel().getId();
                CheckedSetting checkedSetting4 = WidgetTextChannelSettings.this.getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.channelSettingsNsfw");
                WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id3, null, null, null, Boolean.valueOf(!checkedSetting4.isChecked()), null, null, 110, null);
            }
        });
        LinearLayout linearLayout5 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(linearLayout5, "binding.channelSettingsSectionSlowMode");
        linearLayout5.setVisibility(model.getCanManageChannel() && ChannelUtils.F(model.getChannel()) && !ChannelUtils.i(model.getChannel()) ? 0 : 8);
        int iIntValue = ((Number) this.state.get(R.id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(model.getChannel().getRateLimitPerUser()))).intValue();
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
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        this.state.configureSaveActionView(getBinding().k);
        SeekBar seekBar2 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.channelSettingsSlowModeCooldownSlider");
        TextView textView3 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView3.getText());
        LinearLayout linearLayout6 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout6, "binding.channelSettingsS…efaultAutoArchiveDuration");
        linearLayout6.setVisibility(model.getCanManageChannel() && ChannelUtils.I(model.getChannel()) && ThreadUtils.INSTANCE.isThreadsEnabled(model.getGuild().getId()) ? 0 : 8);
        Integer num = (Integer) this.state.get(R.id.duration_selector, model.getChannel().getDefaultAutoArchiveDuration());
        int iIntValue2 = num != null ? num.intValue() : 1440;
        this.state.configureSaveActionView(getBinding().k);
        final Map<MaterialRadioButton, Integer> mapMapOf = Maps6.mapOf(Tuples.to(getBinding().r.e, 60), Tuples.to(getBinding().r.k, 1440), Tuples.to(getBinding().r.i, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES)), Tuples.to(getBinding().r.g, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES)));
        getBinding().r.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextChannelSettings.this.state.put(R.id.duration_selector, 60);
                WidgetTextChannelSettings.this.state.configureSaveActionView(WidgetTextChannelSettings.this.getBinding().k);
                WidgetTextChannelSettings.this.updateRadioState(mapMapOf, 60);
            }
        });
        getBinding().r.j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextChannelSettings.this.state.put(R.id.duration_selector, 1440);
                WidgetTextChannelSettings.this.state.configureSaveActionView(WidgetTextChannelSettings.this.getBinding().k);
                WidgetTextChannelSettings.this.updateRadioState(mapMapOf, 1440);
            }
        });
        getBinding().r.h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextChannelSettings.this.state.put(R.id.duration_selector, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES));
                WidgetTextChannelSettings.this.state.configureSaveActionView(WidgetTextChannelSettings.this.getBinding().k);
                WidgetTextChannelSettings.this.updateRadioState(mapMapOf, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
            }
        });
        getBinding().r.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.configureUI.13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextChannelSettings.this.state.put(R.id.duration_selector, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES));
                WidgetTextChannelSettings.this.state.configureSaveActionView(WidgetTextChannelSettings.this.getBinding().k);
                WidgetTextChannelSettings.this.updateRadioState(mapMapOf, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
            }
        });
        updateRadioState(mapMapOf, iIntValue2);
    }

    private final void confirmDelete(final Channel channel) {
        WidgetChannelSettingsDeleteBinding widgetChannelSettingsDeleteBindingA = WidgetChannelSettingsDeleteBinding.a(LayoutInflater.from(getContext()), null, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsDeleteBindingA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = widgetChannelSettingsDeleteBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(widgetChannelSettingsDeleteBindingA.a).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        widgetChannelSettingsDeleteBindingA.e.setText(ChannelUtils.F(channel) ? R.string.delete_channel : R.string.delete_category);
        widgetChannelSettingsDeleteBindingA.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.confirmDelete.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        widgetChannelSettingsDeleteBindingA.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.confirmDelete.2

            /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
            public static final class C02502 extends Lambda implements Function1<Channel, Unit> {
                public C02502() {
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
                        AppToast.i(WidgetTextChannelSettings.this, numB.intValue(), 0, 4);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(channel.getId()), false, 1, null), WidgetTextChannelSettings.this, null, 2, null);
                Intrinsics3.checkNotNullExpressionValue(view, "v");
                ObservableExtensionsKt.appSubscribe(observableUi$default, (117 & 1) != 0 ? null : view.getContext(), "javaClass", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C02502(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
            }
        });
        TextView textView = widgetChannelSettingsDeleteBindingA.f199b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        FormatUtils.m(textView, R.string.delete_channel_body, new Object[]{ChannelUtils.e(channel, requireContext(), false, 2)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        alertDialogCreate.show();
    }

    private final WidgetTextChannelSettingsBinding getBinding() {
        return (WidgetTextChannelSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(long j, Context context) {
        INSTANCE.launch(j, context);
    }

    private final void saveChannel(long id2, String name, Integer type, String topic, Boolean nsfw, Integer rateLimit, Integer defaultAutoArchiveDuration) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().editTextChannel(id2, name, type, topic, nsfw, rateLimit, defaultAutoArchiveDuration), this, null, 2, null).k(o.a.g(getContext(), new AnonymousClass1(), null));
    }

    public static /* synthetic */ void saveChannel$default(WidgetTextChannelSettings widgetTextChannelSettings, long j, String str, Integer num, String str2, Boolean bool, Integer num2, Integer num3, int i, Object obj) {
        widgetTextChannelSettings.saveChannel(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3);
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        Companion companion = INSTANCE;
        TextView textView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
        companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), R.string.form_label_slowmode_off);
    }

    private final void updateRadioState(Map<MaterialRadioButton, Integer> durationMap, int newDuration) {
        for (Map.Entry<MaterialRadioButton, Integer> entry : durationMap.entrySet()) {
            entry.getKey().setChecked(entry.getValue().intValue() == newDuration);
        }
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
        FloatingActionButton floatingActionButton = getBinding().k;
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3);
        SeekBar seekBar = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setMax(Collections2.getLastIndex(SLOWMODE_COOLDOWN_VALUES));
        getBinding().q.setOnSeekBarChangeListener(new OnSeekBarChangeListenerAdapter() { // from class: com.discord.widgets.channels.settings.WidgetTextChannelSettings.onViewBound.1
            @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                Intrinsics3.checkNotNullParameter(seekBar2, "seekBar");
                super.onProgressChanged(seekBar2, progress, fromUser);
                if (fromUser) {
                    int iIntValue = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
                    WidgetTextChannelSettings.this.setSlowmodeLabel(iIntValue);
                    WidgetTextChannelSettings.this.state.put(R.id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(iIntValue));
                    WidgetTextChannelSettings.this.state.configureSaveActionView(WidgetTextChannelSettings.this.getBinding().k);
                    TextView textView = WidgetTextChannelSettings.this.getBinding().p;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
                    seekBar2.setContentDescription(textView.getText());
                }
            }
        });
        TextInputLayout textInputLayout4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)), this, null, 2, null), (Class<?>) WidgetTextChannelSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
