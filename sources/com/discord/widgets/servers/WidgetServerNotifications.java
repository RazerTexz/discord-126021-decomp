package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.i.ViewAddOverrideItemBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerNotificationsBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SwipeableItemTouchHelper;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.servers.NotificationHighlightsSettingsView;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import com.discord.widgets.servers.NotificationsOverridesAdapter;
import com.discord.widgets.servers.WidgetServerNotifications;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerNotifications.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerNotificationsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager notificationSettingsRadioManager;
    private NotificationsOverridesAdapter overrideAdapter;

    /* JADX INFO: compiled from: WidgetServerNotifications.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<List<NotificationsOverridesAdapter.Item>> getNotificationOverrides(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            return Observable.i(companion.getUserGuildSettings().observeGuildSettings(guildId).G(new Func1<ModelNotificationSettings, List<ModelNotificationSettings.ChannelOverride>>() { // from class: com.discord.widgets.servers.WidgetServerNotifications$Companion$getNotificationOverrides$1
                @Override // j0.k.Func1
                public final List<ModelNotificationSettings.ChannelOverride> call(ModelNotificationSettings modelNotificationSettings) {
                    Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "it");
                    return modelNotificationSettings.getChannelOverrides();
                }
            }), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), GuildChannelsInfo.INSTANCE.get(guildId), new Func3<List<ModelNotificationSettings.ChannelOverride>, Map<Long, ? extends Channel>, GuildChannelsInfo, List<? extends NotificationsOverridesAdapter.Item>>() { // from class: com.discord.widgets.servers.WidgetServerNotifications$Companion$getNotificationOverrides$2
                @Override // rx.functions.Func3
                public /* bridge */ /* synthetic */ List<? extends NotificationsOverridesAdapter.Item> call(List<ModelNotificationSettings.ChannelOverride> list, Map<Long, ? extends Channel> map, GuildChannelsInfo guildChannelsInfo) {
                    return call2(list, (Map<Long, Channel>) map, guildChannelsInfo);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<NotificationsOverridesAdapter.Item> call2(List<ModelNotificationSettings.ChannelOverride> list, Map<Long, Channel> map, GuildChannelsInfo guildChannelsInfo) {
                    Intrinsics3.checkNotNullExpressionValue(map, "guildChannels");
                    List<Channel> sortedVisibleChannels = guildChannelsInfo.getSortedVisibleChannels(map);
                    Intrinsics3.checkNotNullExpressionValue(list, "channelOverrides");
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        ModelNotificationSettings.ChannelOverride channelOverride = (ModelNotificationSettings.ChannelOverride) next;
                        Intrinsics3.checkNotNullExpressionValue(channelOverride, "it");
                        if (channelOverride.getMessageNotifications() != ModelNotificationSettings.FREQUENCY_UNSET || channelOverride.isMuted()) {
                            arrayList.add(next);
                        }
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
                    for (Object obj : arrayList) {
                        ModelNotificationSettings.ChannelOverride channelOverride2 = (ModelNotificationSettings.ChannelOverride) obj;
                        Intrinsics3.checkNotNullExpressionValue(channelOverride2, "override");
                        linkedHashMap.put(Long.valueOf(channelOverride2.getChannelId()), obj);
                    }
                    ArrayList<Channel> arrayList2 = new ArrayList();
                    for (Object obj2 : sortedVisibleChannels) {
                        Channel channel = (Channel) obj2;
                        if (ChannelUtils.k(channel) || ChannelUtils.F(channel)) {
                            arrayList2.add(obj2);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Channel channel2 : arrayList2) {
                        ModelNotificationSettings.ChannelOverride channelOverride3 = (ModelNotificationSettings.ChannelOverride) linkedHashMap.get(Long.valueOf(channel2.getId()));
                        NotificationsOverridesAdapter.Item item = channelOverride3 != null ? new NotificationsOverridesAdapter.Item(channel2, map.get(Long.valueOf(channel2.getParentId())), channelOverride3) : null;
                        if (item != null) {
                            arrayList3.add(item);
                        }
                    }
                    return arrayList3;
                }
            });
        }

        public final void launch(long guildId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE….EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerNotifications.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerNotifications.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer approximateMemberCount;
        private final Guild guild;
        private final StoreGuildProfiles.GuildProfileData guildProfile;
        private final ModelNotificationSettings guildSettings;
        private final boolean highlightsEnabled;
        private final boolean isAboveHighlightsSize;
        private final boolean isAboveNotifyAllSize;
        private final int notificationsSetting;

        /* JADX INFO: compiled from: WidgetServerNotifications.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getGuilds().observeGuild(guildId), companion.getUserGuildSettings().observeGuildSettings(guildId), companion.getGuildProfiles().observeGuildProfile(guildId), new Func3<Guild, ModelNotificationSettings, StoreGuildProfiles.GuildProfileData, Model>() { // from class: com.discord.widgets.servers.WidgetServerNotifications$Model$Companion$get$1
                    @Override // rx.functions.Func3
                    public final WidgetServerNotifications.Model call(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData) {
                        if (guild == null || modelNotificationSettings == null) {
                            return null;
                        }
                        return new WidgetServerNotifications.Model(guild, modelNotificationSettings, guildProfileData);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n          .co…  } else null\n          }");
                Observable<Model> observableR = ObservableExtensionsKt.computationBuffered(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
                return observableR;
            }

            public final boolean isValid(Guild guild, ModelNotificationSettings guildSettings) {
                return (guild == null || guildSettings == null) ? false : true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData) {
            GuildPreview data;
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(modelNotificationSettings, "guildSettings");
            this.guild = guild;
            this.guildSettings = modelNotificationSettings;
            this.guildProfile = guildProfileData;
            this.notificationsSetting = modelNotificationSettings.getMessageNotifications() != ModelNotificationSettings.FREQUENCY_UNSET ? modelNotificationSettings.getMessageNotifications() : guild.getDefaultMessageNotifications();
            Integer approximateMemberCount = (guildProfileData == null || (data = guildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
            this.approximateMemberCount = approximateMemberCount;
            this.isAboveNotifyAllSize = approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
            boolean zIsHighlightsSettingsEnabled = GrowthTeamFeatures.INSTANCE.isHighlightsSettingsEnabled();
            this.highlightsEnabled = zIsHighlightsSettingsEnabled;
            this.isAboveHighlightsSize = zIsHighlightsSettingsEnabled && approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                modelNotificationSettings = model.guildSettings;
            }
            if ((i & 4) != 0) {
                guildProfileData = model.guildProfile;
            }
            return model.copy(guild, modelNotificationSettings, guildProfileData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ModelNotificationSettings getGuildSettings() {
            return this.guildSettings;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        public final Model copy(Guild guild, ModelNotificationSettings guildSettings, StoreGuildProfiles.GuildProfileData guildProfile) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(guildSettings, "guildSettings");
            return new Model(guild, guildSettings, guildProfile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.guildSettings, model.guildSettings) && Intrinsics3.areEqual(this.guildProfile, model.guildProfile);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        public final ModelNotificationSettings getGuildSettings() {
            return this.guildSettings;
        }

        public final boolean getHighlightsEnabled() {
            return this.highlightsEnabled;
        }

        public final int getNotificationsSetting() {
            return this.notificationsSetting;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            ModelNotificationSettings modelNotificationSettings = this.guildSettings;
            int iHashCode2 = (iHashCode + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
            StoreGuildProfiles.GuildProfileData guildProfileData = this.guildProfile;
            return iHashCode2 + (guildProfileData != null ? guildProfileData.hashCode() : 0);
        }

        /* JADX INFO: renamed from: isAboveHighlightsSize, reason: from getter */
        public final boolean getIsAboveHighlightsSize() {
            return this.isAboveHighlightsSize;
        }

        /* JADX INFO: renamed from: isAboveNotifyAllSize, reason: from getter */
        public final boolean getIsAboveNotifyAllSize() {
            return this.isAboveNotifyAllSize;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", guildSettings=");
            sbU.append(this.guildSettings);
            sbU.append(", guildProfile=");
            sbU.append(this.guildProfile);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerNotifications.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            NotificationHighlightsSettingsView notificationHighlightsSettingsView = WidgetServerNotifications.this.getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
            Context context = notificationHighlightsSettingsView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.serverNotificationsHighlights.context");
            userGuildSettings.setNotifyHighlights(context, this.$model.getGuild(), i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerNotifications.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<View, NotificationsOverridesAdapter.Item, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, NotificationsOverridesAdapter.Item item) {
            invoke2(view, item);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, NotificationsOverridesAdapter.Item item) {
            Intrinsics3.checkNotNullParameter(view, "itemView");
            Intrinsics3.checkNotNullParameter(item, "item");
            WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
            WidgetChannelNotificationSettings.Companion.launch$default(companion, context, item.getChannel().getId(), false, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerNotifications.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerNotifications.this.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerNotifications.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends NotificationsOverridesAdapter.Item>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends NotificationsOverridesAdapter.Item> list) {
            invoke2((List<NotificationsOverridesAdapter.Item>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<NotificationsOverridesAdapter.Item> list) {
            NotificationsOverridesAdapter notificationsOverridesAdapterAccess$getOverrideAdapter$p = WidgetServerNotifications.access$getOverrideAdapter$p(WidgetServerNotifications.this);
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            notificationsOverridesAdapterAccess$getOverrideAdapter$p.setData(list);
        }
    }

    public WidgetServerNotifications() {
        super(R.layout.widget_server_notifications);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerNotifications5.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ NotificationsOverridesAdapter access$getOverrideAdapter$p(WidgetServerNotifications widgetServerNotifications) {
        NotificationsOverridesAdapter notificationsOverridesAdapter = widgetServerNotifications.overrideAdapter;
        if (notificationsOverridesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overrideAdapter");
        }
        return notificationsOverridesAdapter;
    }

    private final void configureForHub() {
        View view = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.serverNotificationsFrequencyDivider");
        view.setVisibility(8);
        LinearLayout linearLayout = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverNotificationsFrequencyWrap");
        linearLayout.setVisibility(8);
        CheckedSetting checkedSetting = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting.setVisibility(8);
        View view2 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.serverNotificationsRolesDivider");
        view2.setVisibility(8);
        CheckedSetting checkedSetting2 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.serverNotificationsRolesSwitch");
        checkedSetting2.setVisibility(8);
        CheckedSetting checkedSetting3 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.serverNotificationsPushSwitch");
        checkedSetting3.setVisibility(8);
        TextView textView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverNotificationsOverrideTitle");
        textView.setVisibility(8);
        ViewAddOverrideItemBinding viewAddOverrideItemBinding = getBinding().f2538b;
        Intrinsics3.checkNotNullExpressionValue(viewAddOverrideItemBinding, "binding.addOverride");
        ConstraintLayout constraintLayout = viewAddOverrideItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.addOverride.root");
        constraintLayout.setVisibility(8);
        View view3 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(view3, "binding.serverNotificationsOverrideDivider");
        view3.setVisibility(8);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsOverrideList");
        recyclerView.setVisibility(8);
        NotificationHighlightsSettingsView notificationHighlightsSettingsView = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
        notificationHighlightsSettingsView.setVisibility(8);
        View view4 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(view4, "binding.serverNotificationsHighlightsDivider");
        view4.setVisibility(8);
    }

    @MainThread
    private final void configureRadio(CheckedSetting radio, final int type, final Model model) {
        if (model.getNotificationsSetting() == type) {
            RadioManager radioManager = this.notificationSettingsRadioManager;
            if (radioManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("notificationSettingsRadioManager");
            }
            radioManager.a(radio);
        }
        if (model.getIsAboveNotifyAllSize() && type == ModelNotificationSettings.FREQUENCY_ALL) {
            CharSequence charSequenceE = FormatUtils.e(this, R.string.large_guild_notify_all_messages_description, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
            int i = CheckedSetting.j;
            radio.h(charSequenceE, false);
        } else {
            int i2 = CheckedSetting.j;
            radio.h(null, false);
        }
        radio.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerNotifications.configureRadio.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getUserGuildSettings().setGuildFrequency(outline.x(view, "view", "view.context"), model.getGuild(), type);
            }
        });
    }

    private final void configureUI(final Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.notification_settings);
        setActionBarSubtitle(model.getGuild().getName());
        ModelNotificationSettings guildSettings = model.getGuildSettings();
        boolean zIsMuted = guildSettings.isMuted();
        long id2 = model.getGuild().getId();
        View view = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.serverNotificationsFrequencyDivider");
        view.setVisibility(zIsMuted ^ true ? 0 : 8);
        LinearLayout linearLayout = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverNotificationsFrequencyWrap");
        linearLayout.setVisibility(zIsMuted ^ true ? 0 : 8);
        getBinding().l.updateView(new NotificationMuteSettingsView.ViewState(zIsMuted, guildSettings.getMuteEndTime(), FormatUtils.b(requireContext(), R.string.form_label_mute_server, new Object[]{model.getGuild().getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(requireContext(), R.string.form_label_unmute_server, new Object[]{model.getGuild().getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(requireContext(), R.string.form_label_mobile_server_muted, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), R.string.form_label_mobile_server_muted_until, FormatUtils.b(requireContext(), R.string.form_label_mute_server_description, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null)), new WidgetServerNotifications6(this, id2), new WidgetServerNotifications7(this, id2));
        if (model.getGuild().isHub()) {
            configureForHub();
            return;
        }
        NotificationHighlightsSettingsView.ViewState viewState = new NotificationHighlightsSettingsView.ViewState(model.getGuildSettings().isMuted(), model.getGuildSettings().getNotifyHighlights(), model.getIsAboveHighlightsSize());
        NotificationHighlightsSettingsView notificationHighlightsSettingsView = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
        notificationHighlightsSettingsView.setVisibility(model.getHighlightsEnabled() ? 0 : 8);
        View view2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.serverNotificationsHighlightsDivider");
        view2.setVisibility(model.getHighlightsEnabled() ? 0 : 8);
        if (model.getHighlightsEnabled()) {
            getBinding().j.updateView(viewState, new AnonymousClass1(model));
        }
        getBinding().d.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.servers.WidgetServerNotifications.configureUI.2
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                CheckedSetting checkedSetting = WidgetServerNotifications.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
                Context context = checkedSetting.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.serverNotificationsEveryoneSwitch.context");
                userGuildSettings.setGuildToggles(context, model.getGuild(), (32 & 4) != 0 ? null : Boolean.valueOf(!model.getGuildSettings().isSuppressEveryone()), (32 & 8) != 0 ? null : null, (32 & 16) != 0 ? null : null, (32 & 32) != 0 ? null : null);
            }
        });
        CheckedSetting checkedSetting = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting.setChecked(model.getGuildSettings().isSuppressEveryone());
        CheckedSetting checkedSetting2 = getBinding().d;
        CheckedSetting checkedSetting3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting2.setText(FormatUtils.d(checkedSetting3, R.string.form_label_suppress_everyone, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
        getBinding().q.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.servers.WidgetServerNotifications.configureUI.3
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                CheckedSetting checkedSetting4 = WidgetServerNotifications.this.getBinding().q;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.serverNotificationsRolesSwitch");
                Context context = checkedSetting4.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.serverNotificationsRolesSwitch.context");
                userGuildSettings.setGuildToggles(context, model.getGuild(), (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : Boolean.valueOf(!model.getGuildSettings().isSuppressRoles()), (32 & 16) != 0 ? null : null, (32 & 32) != 0 ? null : null);
            }
        });
        CheckedSetting checkedSetting4 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.serverNotificationsRolesSwitch");
        checkedSetting4.setChecked(model.getGuildSettings().isSuppressRoles());
        CheckedSetting checkedSetting5 = getBinding().q;
        CheckedSetting checkedSetting6 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.serverNotificationsRolesSwitch");
        checkedSetting5.setText(FormatUtils.d(checkedSetting6, R.string.form_label_suppress_roles, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
        CheckedSetting checkedSetting7 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.serverNotificationsPushSwitch");
        checkedSetting7.setChecked(model.getGuildSettings().isMobilePush() && !model.getGuildSettings().isMuted());
        if (model.getGuildSettings().isMuted()) {
            CheckedSetting.d(getBinding().o, null, 1);
        } else {
            getBinding().o.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerNotifications.configureUI.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetServerNotifications.this.getBinding().o.toggle();
                    StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                    CheckedSetting checkedSetting8 = WidgetServerNotifications.this.getBinding().o;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting8, "binding.serverNotificationsPushSwitch");
                    Context context = checkedSetting8.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "binding.serverNotificationsPushSwitch.context");
                    userGuildSettings.setGuildToggles(context, model.getGuild(), null, null, null, Boolean.valueOf(!model.getGuildSettings().isMobilePush()));
                }
            });
        }
        CheckedSetting checkedSetting8 = getBinding().f;
        CheckedSetting checkedSetting9 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting9, "binding.serverNotificationsFrequency1Radio");
        checkedSetting8.setText(FormatUtils.d(checkedSetting9, R.string.form_label_only_mentions, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
        CheckedSetting checkedSetting10 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting10, "binding.serverNotificationsFrequency0Radio");
        configureRadio(checkedSetting10, ModelNotificationSettings.FREQUENCY_ALL, model);
        CheckedSetting checkedSetting11 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting11, "binding.serverNotificationsFrequency1Radio");
        configureRadio(checkedSetting11, ModelNotificationSettings.FREQUENCY_MENTIONS, model);
        CheckedSetting checkedSetting12 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting12, "binding.serverNotificationsFrequency2Radio");
        configureRadio(checkedSetting12, ModelNotificationSettings.FREQUENCY_NOTHING, model);
    }

    private final ItemTouchHelper createSwipeableItemTouchHelper() {
        final SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration = new SwipeableItemTouchHelper.SwipeRevealConfiguration(ColorCompat.getColor(this, R.color.status_red_500), ContextCompat.getDrawable(requireContext(), R.drawable.ic_delete_white_24dp), DimenUtils.dpToPixels(8));
        return new ItemTouchHelper(new SwipeableItemTouchHelper(swipeRevealConfiguration, swipeRevealConfiguration) { // from class: com.discord.widgets.servers.WidgetServerNotifications.createSwipeableItemTouchHelper.1
            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
                NotificationsOverridesAdapter.Item item = (NotificationsOverridesAdapter.Item) _Collections.getOrNull(WidgetServerNotifications.access$getOverrideAdapter$p(WidgetServerNotifications.this).getData(), viewHolder.getAdapterPosition());
                if (item != null) {
                    Channel channel = item.getChannel();
                    if (item.getOverrideSettings().isMuted()) {
                        StoreUserGuildSettings.setChannelMuted$default(StoreStream.INSTANCE.getUserGuildSettings(), WidgetServerNotifications.this.requireContext(), channel.getId(), false, null, 8, null);
                    }
                    StoreStream.INSTANCE.getUserGuildSettings().setChannelFrequency(WidgetServerNotifications.this.requireContext(), channel, ModelNotificationSettings.FREQUENCY_UNSET);
                }
            }
        });
    }

    private final WidgetServerNotificationsBinding getBinding() {
        return (WidgetServerNotificationsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.notificationSettingsRadioManager = new RadioManager(Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().e, getBinding().f, getBinding().g}));
        this.overrideAdapter = new NotificationsOverridesAdapter(AnonymousClass1.INSTANCE);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsOverrideList");
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.guildNotificationsOverrideList");
        NotificationsOverridesAdapter notificationsOverridesAdapter = this.overrideAdapter;
        if (notificationsOverridesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overrideAdapter");
        }
        recyclerView2.setAdapter(notificationsOverridesAdapter);
        createSwipeableItemTouchHelper().attachToRecyclerView(getBinding().c);
        final long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        ViewAddOverrideItemBinding viewAddOverrideItemBinding = getBinding().f2538b;
        Intrinsics3.checkNotNullExpressionValue(viewAddOverrideItemBinding, "binding.addOverride");
        viewAddOverrideItemBinding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerNotifications.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetServerNotificationsOverrideSelector.INSTANCE.launch(outline.x(view2, "it", "it.context"), longExtra);
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra), this, null, 2, null), (Class<?>) WidgetServerNotifications.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        Observable notificationOverrides = INSTANCE.getNotificationOverrides(longExtra);
        Intrinsics3.checkNotNullExpressionValue(notificationOverrides, "getNotificationOverrides(guildId)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(notificationOverrides), this, null, 2, null), (Class<?>) WidgetServerNotifications.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
