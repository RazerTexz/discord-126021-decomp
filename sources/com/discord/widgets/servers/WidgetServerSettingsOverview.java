package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppActivity;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsOverviewAfkTimeoutBinding;
import com.discord.databinding.WidgetServerSettingsOverviewBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsOverview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsOverviewBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_OPEN_AVATAR_PICKER = "INTENT_EXTRA_OPEN_AVATAR_PICKER";
    private static final String REQUEST_KEY_AFK_CHANNEL = "REQUEST_KEY_AFK_CHANNEL";
    private static final String REQUEST_KEY_SYSTEM_CHANNEL = "REQUEST_KEY_SYSTEM_CHANNEL";
    private static final int STATE_ID_NOTIFICATION_DEFAULT = 90001;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean hasOpenedAvatarPicker;
    private Action1<String> imageSelectedResult;
    private final AppLogger2 loggingConfig;
    private final StatefulViews state;

    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class AfkBottomSheet extends AppBottomSheet {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(AfkBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsOverviewAfkTimeoutBinding;", 0)};

        /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;

        public AfkBottomSheet() {
            super(false, 1, null);
            this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsOverview2.INSTANCE, null, 2, null);
        }

        private final WidgetServerSettingsOverviewAfkTimeoutBinding getBinding() {
            return (WidgetServerSettingsOverviewAfkTimeoutBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        private final List<TextView> getTimeouts() {
            TextView textView = getBinding().f2581b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsOverviewAfkTimeout01");
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsOverviewAfkTimeout05");
            TextView textView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsOverviewAfkTimeout15");
            TextView textView4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.serverSettingsOverviewAfkTimeout30");
            TextView textView5 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.serverSettingsOverviewAfkTimeout60");
            return Collections2.listOf((Object[]) new TextView[]{textView, textView2, textView3, textView4, textView5});
        }

        @Override // com.discord.app.AppBottomSheet
        public int getContentViewResId() {
            return R.layout.widget_server_settings_overview_afk_timeout;
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle savedInstanceState) {
            Intrinsics3.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            Fragment parentFragment = getParentFragment();
            if (!(parentFragment instanceof WidgetServerSettingsOverview)) {
                parentFragment = null;
            }
            final WidgetServerSettingsOverview widgetServerSettingsOverview = (WidgetServerSettingsOverview) parentFragment;
            if (widgetServerSettingsOverview == null) {
                dismiss();
                return;
            }
            for (TextView textView : getTimeouts()) {
                Object tag = textView.getTag();
                Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
                final int i = Integer.parseInt((String) tag);
                Model.Companion companion = Model.INSTANCE;
                Context context = textView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                final CharSequence afkTimeout = companion.getAfkTimeout(context, i);
                textView.setText(afkTimeout);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview$AfkBottomSheet$onViewCreated$$inlined$forEach$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        WidgetServerSettingsOverview widgetServerSettingsOverview2 = widgetServerSettingsOverview;
                        StatefulViews statefulViews = widgetServerSettingsOverview2.state;
                        TextView textView2 = widgetServerSettingsOverview2.getBinding().f2582b.d;
                        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.afk.afkTimeout");
                        statefulViews.put(textView2.getId(), afkTimeout);
                        StatefulViews statefulViews2 = widgetServerSettingsOverview2.state;
                        LinearLayout linearLayout = widgetServerSettingsOverview2.getBinding().f2582b.e;
                        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.afk.afkTimeoutWrap");
                        statefulViews2.put(linearLayout.getId(), Integer.valueOf(i));
                        TextView textView3 = widgetServerSettingsOverview2.getBinding().f2582b.d;
                        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.afk.afkTimeout");
                        textView3.setText(afkTimeout);
                        LinearLayout linearLayout2 = widgetServerSettingsOverview2.getBinding().f2582b.e;
                        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.afk.afkTimeoutWrap");
                        linearLayout2.setTag(afkTimeout);
                        this.dismiss();
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void create$default(Companion companion, Context context, long j, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.create(context, j, z2);
        }

        public final void create(Context context, long guildId, boolean openAvatarPicker) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("OVERVIEW", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId).putExtra(WidgetServerSettingsOverview.INTENT_EXTRA_OPEN_AVATAR_PICKER, openAvatarPicker);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…PICKER, openAvatarPicker)");
            AppScreen2.d(context, WidgetServerSettingsOverview.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel afkChannelModel;
        private final Integer approximateMemberCount;
        private final boolean canManage;
        private final Guild guild;
        private final boolean isAboveNotifyAllSize;
        private final boolean isOwner;
        private final Channel systemChannelModel;

        /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(final long guildId) {
                Observable<R> observableY = StoreStream.INSTANCE.getGuilds().observeGuild(guildId).Y(new Func1<Guild, Observable<? extends Model>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetServerSettingsOverview.Model> call(final Guild guild) {
                        if (guild == null) {
                            return new ScalarSynchronousObservable(null);
                        }
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
                        StoreChannels channels = companion.getChannels();
                        Long afkChannelId = guild.getAfkChannelId();
                        Observable<Channel> observableObserveChannel = channels.observeChannel(afkChannelId != null ? afkChannelId.longValue() : 0L);
                        StoreChannels channels2 = companion.getChannels();
                        Long systemChannelId = guild.getSystemChannelId();
                        return Observable.g(observableObserveMe$default, observableObserveChannel, channels2.observeChannel(systemChannelId != null ? systemChannelId.longValue() : 0L), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuildProfiles().observeGuildProfile(guildId), new Func5<MeUser, Channel, Channel, Long, StoreGuildProfiles.GuildProfileData, WidgetServerSettingsOverview.Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview$Model$Companion$get$1.1
                            @Override // rx.functions.Func5
                            public final WidgetServerSettingsOverview.Model call(MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles.GuildProfileData guildProfileData) {
                                Guild guild2 = guild;
                                Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                                return new WidgetServerSettingsOverview.Model(guild2, meUser, channel, channel2, l, guildProfileData);
                            }
                        });
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public final CharSequence getAfkTimeout(Context context, int afkTimeout) {
                Intrinsics3.checkNotNullParameter(context, "context");
                if (afkTimeout == 60) {
                    Resources resources = context.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
                    return StringResourceUtils.getQuantityString(resources, context, R.plurals.duration_minutes_minutes, 1, 1);
                }
                if (afkTimeout == 300) {
                    Resources resources2 = context.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources2, "context.resources");
                    return StringResourceUtils.getQuantityString(resources2, context, R.plurals.duration_minutes_minutes, 5, 5);
                }
                if (afkTimeout == 900) {
                    Resources resources3 = context.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources3, "context.resources");
                    return StringResourceUtils.getQuantityString(resources3, context, R.plurals.duration_minutes_minutes, 15, 15);
                }
                if (afkTimeout == 1800) {
                    Resources resources4 = context.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources4, "context.resources");
                    return StringResourceUtils.getQuantityString(resources4, context, R.plurals.duration_minutes_minutes, 30, 30);
                }
                if (afkTimeout != 3600) {
                    return "";
                }
                Resources resources5 = context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources5, "context.resources");
                return StringResourceUtils.getQuantityString(resources5, context, R.plurals.duration_hours_hours, 1, 1);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles.GuildProfileData guildProfileData) {
            GuildPreview data;
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.guild = guild;
            this.afkChannelModel = channel;
            this.systemChannelModel = channel2;
            boolean zIsOwner = guild.isOwner(meUser.getId());
            this.isOwner = zIsOwner;
            boolean z2 = false;
            this.canManage = zIsOwner || PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel());
            Integer approximateMemberCount = (guildProfileData == null || (data = guildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
            this.approximateMemberCount = approximateMemberCount;
            if (approximateMemberCount != null && approximateMemberCount.intValue() > 2500) {
                z2 = true;
            }
            this.isAboveNotifyAllSize = z2;
        }

        public final Channel getAfkChannelModel() {
            return this.afkChannelModel;
        }

        public final boolean getCanManage() {
            return this.canManage;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Channel getSystemChannelModel() {
            return this.systemChannelModel;
        }

        /* JADX INFO: renamed from: isAboveNotifyAllSize, reason: from getter */
        public final boolean getIsAboveNotifyAllSize() {
            return this.isAboveNotifyAllSize;
        }

        /* JADX INFO: renamed from: isOwner, reason: from getter */
        public final boolean getIsOwner() {
            return this.isOwner;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerSection$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Guild $guild;

        /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerSection$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
        public static final class C03121 extends Lambda implements Function1<View, Unit> {
            public C03121() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetGuildBoost.Companion companion = WidgetGuildBoost.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                companion.create(context, AnonymousClass1.this.$guild.getId());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Guild guild) {
            super(1);
            this.$guild = guild;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("tierStatus", new C03121());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureSplashSection$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Guild $guild;

        /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureSplashSection$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
        public static final class C03141 extends Lambda implements Function1<View, Unit> {
            public C03141() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetGuildBoost.Companion companion = WidgetGuildBoost.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                companion.create(context, AnonymousClass1.this.$guild.getId());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Guild guild) {
            super(1);
            this.$guild = guild;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("tierInfo", new C03141());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            Channel channel = StoreStream.INSTANCE.getChannels().getChannel(j);
            WidgetServerSettingsOverview.this.state.put(R.id.afk_channel, channel);
            WidgetServerSettingsOverview.this.state.configureSaveActionView(WidgetServerSettingsOverview.this.getBinding().e);
            WidgetServerSettingsOverview.this.configureAfkChannel(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            Channel channel = StoreStream.INSTANCE.getChannels().getChannel(j);
            WidgetServerSettingsOverview.this.state.put(R.id.system_channel, channel);
            WidgetServerSettingsOverview.this.state.configureSaveActionView(WidgetServerSettingsOverview.this.getBinding().e);
            WidgetServerSettingsOverview.this.configureSystemChannel(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
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
            WidgetServerSettingsOverview.this.configureUI(model);
        }
    }

    public WidgetServerSettingsOverview() {
        super(R.layout.widget_server_settings_overview);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsOverview5.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.server_settings_overview_icon, R.id.overview_name, R.id.afk_channel, R.id.afk_timeout, R.id.afk_timeout_wrap, R.id.system_channel, R.id.upload_splash, R.id.upload_banner, R.id.system_channel_join, R.id.system_channel_join_replies, R.id.system_channel_boost, STATE_ID_NOTIFICATION_DEFAULT);
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsOverview7.INSTANCE, 3);
    }

    private final void configureAfkChannel(Channel selectedChannel) {
        TextView textView = getBinding().f2582b.f242b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.afk.afkChannel");
        configureChannel(textView, selectedChannel, R.string.no_afk_channel, R.drawable.ic_channel_voice_16dp);
    }

    private final void configureAnimatedBannerUpsellSection(final Guild guild) {
        int premiumTier = guild.getPremiumTier();
        Integer minimumBoostTierForGuildFeature = PremiumUtils.INSTANCE.getMinimumBoostTierForGuildFeature(GuildFeature.ANIMATED_BANNER);
        boolean z2 = premiumTier == (minimumBoostTierForGuildFeature != null ? minimumBoostTierForGuildFeature.intValue() : 0) - 1;
        boolean zCanHaveAnimatedBanner = guild.canHaveAnimatedBanner();
        LinearLayout linearLayout = getBinding().h.f167b.c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.uploadBanner.ani…atedBannerUpsellContainer");
        linearLayout.setVisibility(zCanHaveAnimatedBanner || z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().h.f167b.f160b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.uploadBanner.ani…nimatedBannerUpsellButton");
        materialButton.setVisibility(z2 ? 0 : 8);
        TextView textView = getBinding().h.f167b.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.uploadBanner.ani….animatedBannerUpsellText");
        FormatUtils.m(textView, zCanHaveAnimatedBanner ? R.string.guild_settings_animated_banner_try_it : R.string.guild_settings_animated_banner_upsell, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        MaterialButton materialButton2 = getBinding().h.f167b.f160b;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.uploadBanner.ani…nimatedBannerUpsellButton");
        if (materialButton2.getVisibility() == 0) {
            getBinding().h.f167b.f160b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureAnimatedBannerUpsellSection.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildBoost.INSTANCE.create(outline.x(view, "it", "it.context"), guild.getId());
                }
            });
        }
    }

    private final void configureBannerImage(final String bannerOriginalUrl, String bannerUpdatedUrl, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().h.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.uploadBanner.uploadBanner");
            statefulViews.put(simpleDraweeView.getId(), bannerUpdatedUrl != null ? bannerUpdatedUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().h.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadBanner.uploadBanner");
            bannerUpdatedUrl = (String) statefulViews2.get(simpleDraweeView2.getId(), bannerOriginalUrl);
        }
        getBinding().h.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureBannerImage.1

            /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerImage$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
            public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetServerSettingsOverview.this.openMediaChooser();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.imageSelectedResult = new Action1<String>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureBannerImage.1.1
                    @Override // rx.functions.Action1
                    public final void call(String str) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        WidgetServerSettingsOverview.this.configureBannerImage(bannerOriginalUrl, str, true);
                    }
                };
                WidgetServerSettingsOverview.this.requestMedia(new AnonymousClass2());
            }
        });
        SimpleDraweeView simpleDraweeView3 = getBinding().h.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadBanner.uploadBanner");
        IconUtils.setIcon$default(simpleDraweeView3, bannerUpdatedUrl, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView = getBinding().h.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.uploadBanner.ser…verviewUploadBannerRemove");
        textView.setVisibility((bannerUpdatedUrl == null || StringsJVM.isBlank(bannerUpdatedUrl)) ^ true ? 0 : 8);
        getBinding().h.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureBannerImage.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.configureBannerImage(bannerOriginalUrl, null, true);
            }
        });
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureBannerSection(final Guild guild) {
        boolean z2 = true;
        if (!guild.canHaveBanner()) {
            TextView textView = getBinding().h.h;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.uploadBanner.uploadBannerNitroTier");
            FormatUtils.m(textView, R.string.guild_settings_overview_tier_info, new Object[]{ExifInterface.GPS_MEASUREMENT_2D, "tierStatus"}, new AnonymousClass1(guild));
            TextView textView2 = getBinding().h.h;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.uploadBanner.uploadBannerNitroTier");
            textView2.setVisibility(0);
            FloatingActionButton floatingActionButton = getBinding().h.f;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.uploadBanner.uploadBannerFab");
            ViewExtensions.setEnabledAlpha$default(floatingActionButton, false, 0.0f, 2, null);
            int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guild.getId(), 2, null, null, 12, null) - guild.getPremiumSubscriptionCount();
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            CharSequence quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.guild_settings_overview_boost_unlock_boosts, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default));
            TextView textView3 = getBinding().h.i;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.uploadBanner.uploadBannerUnlock");
            ViewExtensions.setTextAndVisibilityBy(textView3, FormatUtils.e(this, R.string.guild_settings_overview_boost_unlock, new Object[]{quantityString}, (4 & 4) != 0 ? FormatUtils.a.j : null));
            TextView textView4 = getBinding().h.i;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.uploadBanner.uploadBannerUnlock");
            DrawableCompat.setCompoundDrawablesCompat$default(textView4, 0, R.drawable.ic_perk_lock, 0, 0, 13, (Object) null);
            getBinding().h.i.setTextColor(ColorCompat.getThemedColor(requireContext(), R.attr.primary_300));
            getBinding().h.e.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), R.attr.primary_630));
            getBinding().h.h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureBannerSection.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildBoost.INSTANCE.create(outline.x(view, "it", "it.context"), guild.getId());
                }
            });
            return;
        }
        getBinding().h.e.setBackgroundResource(R.drawable.drawable_bg_nitro_gradient);
        TextView textView5 = getBinding().h.h;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.uploadBanner.uploadBannerNitroTier");
        textView5.setVisibility(8);
        TextView textView6 = getBinding().h.i;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.uploadBanner.uploadBannerUnlock");
        FormatUtils.m(textView6, R.string.guild_settings_overview_boost_unlocked, new Object[]{ExifInterface.GPS_MEASUREMENT_2D}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView7 = getBinding().h.i;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.uploadBanner.uploadBannerUnlock");
        DrawableCompat.setCompoundDrawablesCompat$default(textView7, 0, R.drawable.ic_perk_tier_1_boosted, 0, 0, 13, (Object) null);
        getBinding().h.i.setTextColor(ColorCompat.getColor(requireContext(), R.color.white));
        TextView textView8 = getBinding().h.i;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.uploadBanner.uploadBannerUnlock");
        String banner = guild.getBanner();
        if (banner != null && banner.length() != 0) {
            z2 = false;
        }
        textView8.setVisibility(z2 ? 0 : 8);
        IconUtils iconUtils = IconUtils.INSTANCE;
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        configureBannerImage(IconUtils.getBannerForGuild$default(iconUtils, guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null, false, 4, null), null, false);
    }

    private final void configureChannel(TextView textView, Channel channel, @StringRes int i, @DrawableRes int i2) {
        CharSequence charSequenceB;
        if (channel != null) {
            charSequenceB = ChannelUtils.c(channel);
        } else {
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            charSequenceB = FormatUtils.b(context, i, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        textView.setText(charSequenceB);
        DrawableCompat.setCompoundDrawablesCompat$default(textView, channel == null ? 0 : i2, 0, 0, 0, 14, (Object) null);
    }

    private final void configureIcon(final String guildShortName, final String iconOriginal, String iconUpdated, boolean stateShouldUpdate) {
        boolean z2 = true;
        if (!this.hasOpenedAvatarPicker && getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_OPEN_AVATAR_PICKER, false)) {
            openAvatarPicker(guildShortName, iconOriginal);
        }
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().c.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.header.serverSettingsOverviewIcon");
            statefulViews.put(simpleDraweeView.getId(), iconUpdated != null ? iconUpdated : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().c.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.header.serverSettingsOverviewIcon");
            iconUpdated = (String) statefulViews2.get(simpleDraweeView2.getId(), iconOriginal);
        }
        getBinding().c.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureIcon.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.openAvatarPicker(guildShortName, iconOriginal);
            }
        });
        SimpleDraweeView simpleDraweeView3 = getBinding().c.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.header.serverSettingsOverviewIcon");
        IconUtils.setIcon$default(simpleDraweeView3, iconUpdated, R.dimen.avatar_size_extra_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        if (iconUpdated != null && !StringsJVM.isBlank(iconUpdated)) {
            z2 = false;
        }
        TextView textView = getBinding().c.f140b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.header.iconLabel");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = getBinding().c.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.header.serverSettingsOverviewIconRemove");
        textView2.setVisibility(z2 ^ true ? 0 : 8);
        getBinding().c.e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureIcon.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.configureIcon(guildShortName, iconOriginal, null, true);
            }
        });
        TextView textView3 = getBinding().c.f;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.header.serverSettingsOverviewIconText");
        textView3.setVisibility(z2 ? 0 : 8);
        TextView textView4 = getBinding().c.f;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.header.serverSettingsOverviewIconText");
        textView4.setText(guildShortName);
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureRadios(final int stateId, final int activeRadioIndex, final boolean isAboveNotifyAllSize, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            this.state.put(stateId, Integer.valueOf(activeRadioIndex));
        }
        final int i = 0;
        for (Object obj : Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().d.f147b, getBinding().d.c})) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "checkedSetting");
            checkedSetting.setChecked(i == activeRadioIndex);
            if (isAboveNotifyAllSize && checkedSetting.getId() == R.id.server_settings_overview_notification_all) {
                checkedSetting.h(FormatUtils.e(this, R.string.guild_settings_default_notifications_large_guild_notify_all, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), false);
            } else {
                checkedSetting.h(null, false);
            }
            checkedSetting.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview$configureRadios$$inlined$forEachIndexed$lambda$1
                @Override // rx.functions.Action1
                public final void call(Boolean bool) {
                    this.configureRadios(stateId, i, isAboveNotifyAllSize, true);
                }
            });
            i = i2;
        }
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureSplashImage(final String splashOriginalUrl, String splashUpdatedUrl, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().i.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.uploadSplash.uploadSplash");
            statefulViews.put(simpleDraweeView.getId(), splashUpdatedUrl != null ? splashUpdatedUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().i.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadSplash.uploadSplash");
            splashUpdatedUrl = (String) statefulViews2.get(simpleDraweeView2.getId(), splashOriginalUrl);
        }
        getBinding().i.f174b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureSplashImage.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.imageSelectedResult = new Action1<String>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureSplashImage.1.1
                    @Override // rx.functions.Action1
                    public final void call(String str) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        WidgetServerSettingsOverview.this.configureSplashImage(splashOriginalUrl, str, true);
                    }
                };
                WidgetServerSettingsOverview.this.openMediaChooser();
            }
        });
        SimpleDraweeView simpleDraweeView3 = getBinding().i.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadSplash.uploadSplash");
        IconUtils.setIcon$default(simpleDraweeView3, splashUpdatedUrl, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView = getBinding().i.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.uploadSplash.ser…verviewUploadSplashRemove");
        textView.setVisibility((splashUpdatedUrl == null || StringsJVM.isBlank(splashUpdatedUrl)) ^ true ? 0 : 8);
        getBinding().i.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureSplashImage.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.configureSplashImage(splashOriginalUrl, null, true);
            }
        });
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureSplashSection(final Guild guild) {
        boolean z2 = true;
        if (!guild.canHaveSplash()) {
            TextView textView = getBinding().i.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.uploadSplash.uploadSplashNitroTier");
            FormatUtils.m(textView, R.string.guild_settings_overview_tier_info, new Object[]{"1", "tierInfo"}, new AnonymousClass1(guild));
            TextView textView2 = getBinding().i.g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.uploadSplash.uploadSplashNitroTier");
            textView2.setVisibility(0);
            FloatingActionButton floatingActionButton = getBinding().i.c;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.uploadSplash.ser…gsOverviewUploadSplashFab");
            ViewExtensions.setEnabledAlpha$default(floatingActionButton, false, 0.0f, 2, null);
            int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guild.getId(), 1, null, null, 12, null) - guild.getPremiumSubscriptionCount();
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            CharSequence quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.guild_settings_overview_boost_unlock_boosts, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default));
            TextView textView3 = getBinding().i.h;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.uploadSplash.uploadSplashUnlock");
            ViewExtensions.setTextAndVisibilityBy(textView3, FormatUtils.e(this, R.string.guild_settings_overview_boost_unlock, new Object[]{quantityString}, (4 & 4) != 0 ? FormatUtils.a.j : null));
            TextView textView4 = getBinding().i.h;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.uploadSplash.uploadSplashUnlock");
            DrawableCompat.setCompoundDrawablesCompat$default(textView4, 0, R.drawable.ic_perk_lock, 0, 0, 13, (Object) null);
            getBinding().i.h.setTextColor(ColorCompat.getThemedColor(requireContext(), R.attr.primary_300));
            getBinding().i.e.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), R.attr.primary_630));
            getBinding().i.g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureSplashSection.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildBoost.INSTANCE.create(outline.x(view, "it", "it.context"), guild.getId());
                }
            });
            return;
        }
        TextView textView5 = getBinding().i.g;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.uploadSplash.uploadSplashNitroTier");
        textView5.setVisibility(8);
        getBinding().i.e.setBackgroundResource(R.drawable.drawable_bg_nitro_gradient);
        TextView textView6 = getBinding().i.h;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.uploadSplash.uploadSplashUnlock");
        FormatUtils.m(textView6, R.string.guild_settings_overview_boost_unlocked, new Object[]{"1"}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView7 = getBinding().i.h;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.uploadSplash.uploadSplashUnlock");
        DrawableCompat.setCompoundDrawablesCompat$default(textView7, 0, R.drawable.ic_perk_tier_1_boosted, 0, 0, 13, (Object) null);
        getBinding().i.h.setTextColor(ColorCompat.getColor(requireContext(), R.color.white));
        TextView textView8 = getBinding().i.h;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.uploadSplash.uploadSplashUnlock");
        String splash = guild.getSplash();
        if (splash != null && splash.length() != 0) {
            z2 = false;
        }
        textView8.setVisibility(z2 ? 0 : 8);
        IconUtils iconUtils = IconUtils.INSTANCE;
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        configureSplashImage(iconUtils.getGuildSplashUrl(guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null), null, false);
    }

    private final void configureSystemChannel(Channel selectedChannel) {
        TextView textView = getBinding().g.f153b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.systemChannel.systemChannel");
        configureChannel(textView, selectedChannel, R.string.no_system_channel, R.drawable.ic_channel_text_16dp);
    }

    private final void configureUI(final Model model) {
        if (model == null || !model.getCanManage()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        configureIcon(model.getGuild().getShortName(), IconUtils.getForGuild$default(model.getGuild(), null, true, null, 10, null), null, false);
        TextInputLayout textInputLayout = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.header.overviewName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.header.overviewName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), model.getGuild().getName()));
        StatefulViews statefulViews2 = this.state;
        TextView textView = getBinding().f2582b.f242b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.afk.afkChannel");
        configureAfkChannel((Channel) statefulViews2.get(textView.getId(), model.getAfkChannelModel()));
        getBinding().f2582b.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSelector.INSTANCE.launchForVoice(WidgetServerSettingsOverview.this, model.getGuild().getId(), WidgetServerSettingsOverview.REQUEST_KEY_AFK_CHANNEL, true, R.string.no_afk_channel);
            }
        });
        TextView textView2 = getBinding().f2582b.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.afk.afkTimeout");
        StatefulViews statefulViews3 = this.state;
        TextView textView3 = getBinding().f2582b.d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.afk.afkTimeout");
        textView2.setText((CharSequence) statefulViews3.get(textView3.getId(), Model.INSTANCE.getAfkTimeout(outline.I(getBinding().f2582b.d, "binding.afk.afkTimeout", "binding.afk.afkTimeout.context"), model.getGuild().getAfkTimeout())));
        getBinding().f2582b.e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AfkBottomSheet afkBottomSheet = new AfkBottomSheet();
                FragmentManager childFragmentManager = WidgetServerSettingsOverview.this.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                afkBottomSheet.show(childFragmentManager, Reflection2.getOrCreateKotlinClass(AfkBottomSheet.class).toString());
            }
        });
        LinearLayout linearLayout = getBinding().f2582b.e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.afk.afkTimeoutWrap");
        linearLayout.setTag(Integer.valueOf(model.getGuild().getAfkTimeout()));
        StatefulViews statefulViews4 = this.state;
        TextView textView4 = getBinding().g.f153b;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.systemChannel.systemChannel");
        configureSystemChannel((Channel) statefulViews4.get(textView4.getId(), model.getSystemChannelModel()));
        getBinding().g.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSelector.INSTANCE.launchForText(WidgetServerSettingsOverview.this, model.getGuild().getId(), WidgetServerSettingsOverview.REQUEST_KEY_SYSTEM_CHANNEL, true, R.string.no_system_channel);
            }
        });
        LinearLayout linearLayout2 = getBinding().g.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.systemChannel.systemChannelWrap");
        StatefulViews statefulViews5 = this.state;
        LinearLayout linearLayout3 = getBinding().g.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.systemChannel.systemChannelWrap");
        linearLayout2.setTag(statefulViews5.get(linearLayout3.getId(), model.getGuild().getSystemChannelId()));
        configureRadios(STATE_ID_NOTIFICATION_DEFAULT, ((Number) this.state.get(STATE_ID_NOTIFICATION_DEFAULT, Integer.valueOf(model.getGuild().getDefaultMessageNotifications()))).intValue(), model.getIsAboveNotifyAllSize(), false);
        configureSplashSection(model.getGuild());
        configureBannerSection(model.getGuild());
        configureAnimatedBannerUpsellSection(model.getGuild());
        boolean z2 = (model.getGuild().getSystemChannelFlags() & 1) == 0;
        CheckedSetting checkedSetting = getBinding().g.d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelJoin");
        StatefulViews statefulViews6 = this.state;
        CheckedSetting checkedSetting2 = getBinding().g.d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelJoin");
        checkedSetting.setChecked(((Boolean) statefulViews6.get(checkedSetting2.getId(), Boolean.valueOf(z2))).booleanValue());
        if (model.getSystemChannelModel() != null) {
            getBinding().g.d.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting3 = WidgetServerSettingsOverview.this.getBinding().g.d;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelJoin");
                    CheckedSetting checkedSetting4 = WidgetServerSettingsOverview.this.getBinding().g.d;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.systemChannel.systemChannelJoin");
                    checkedSetting3.setChecked(!checkedSetting4.isChecked());
                    StatefulViews statefulViews7 = WidgetServerSettingsOverview.this.state;
                    CheckedSetting checkedSetting5 = WidgetServerSettingsOverview.this.getBinding().g.d;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.systemChannel.systemChannelJoin");
                    int id2 = checkedSetting5.getId();
                    CheckedSetting checkedSetting6 = WidgetServerSettingsOverview.this.getBinding().g.d;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.systemChannel.systemChannelJoin");
                    statefulViews7.put(id2, Boolean.valueOf(checkedSetting6.isChecked()));
                    WidgetServerSettingsOverview.this.state.configureSaveActionView(WidgetServerSettingsOverview.this.getBinding().e);
                }
            });
        } else {
            CheckedSetting.d(getBinding().g.d, null, 1);
        }
        boolean z3 = (model.getGuild().getSystemChannelFlags() & 2) == 0;
        CheckedSetting checkedSetting3 = getBinding().g.c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelBoost");
        StatefulViews statefulViews7 = this.state;
        CheckedSetting checkedSetting4 = getBinding().g.c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.systemChannel.systemChannelBoost");
        checkedSetting3.setChecked(((Boolean) statefulViews7.get(checkedSetting4.getId(), Boolean.valueOf(z3))).booleanValue());
        if (model.getSystemChannelModel() != null) {
            getBinding().g.c.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting5 = WidgetServerSettingsOverview.this.getBinding().g.c;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.systemChannel.systemChannelBoost");
                    CheckedSetting checkedSetting6 = WidgetServerSettingsOverview.this.getBinding().g.c;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.systemChannel.systemChannelBoost");
                    checkedSetting5.setChecked(!checkedSetting6.isChecked());
                    StatefulViews statefulViews8 = WidgetServerSettingsOverview.this.state;
                    CheckedSetting checkedSetting7 = WidgetServerSettingsOverview.this.getBinding().g.c;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.systemChannel.systemChannelBoost");
                    int id2 = checkedSetting7.getId();
                    CheckedSetting checkedSetting8 = WidgetServerSettingsOverview.this.getBinding().g.c;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting8, "binding.systemChannel.systemChannelBoost");
                    statefulViews8.put(id2, Boolean.valueOf(checkedSetting8.isChecked()));
                    WidgetServerSettingsOverview.this.state.configureSaveActionView(WidgetServerSettingsOverview.this.getBinding().e);
                }
            });
        } else {
            CheckedSetting.d(getBinding().g.c, null, 1);
        }
        boolean z4 = (model.getGuild().getSystemChannelFlags() & 8) == 0;
        CheckedSetting checkedSetting5 = getBinding().g.e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.systemChannel.systemChannelJoinReplies");
        StatefulViews statefulViews8 = this.state;
        CheckedSetting checkedSetting6 = getBinding().g.e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.systemChannel.systemChannelJoinReplies");
        checkedSetting5.setChecked(((Boolean) statefulViews8.get(checkedSetting6.getId(), Boolean.valueOf(z4))).booleanValue());
        if (model.getSystemChannelModel() != null) {
            getBinding().g.e.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting7 = WidgetServerSettingsOverview.this.getBinding().g.e;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.systemChannel.systemChannelJoinReplies");
                    CheckedSetting checkedSetting8 = WidgetServerSettingsOverview.this.getBinding().g.e;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting8, "binding.systemChannel.systemChannelJoinReplies");
                    checkedSetting7.setChecked(!checkedSetting8.isChecked());
                    StatefulViews statefulViews9 = WidgetServerSettingsOverview.this.state;
                    CheckedSetting checkedSetting9 = WidgetServerSettingsOverview.this.getBinding().g.e;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting9, "binding.systemChannel.systemChannelJoinReplies");
                    int id2 = checkedSetting9.getId();
                    CheckedSetting checkedSetting10 = WidgetServerSettingsOverview.this.getBinding().g.e;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting10, "binding.systemChannel.systemChannelJoinReplies");
                    statefulViews9.put(id2, Boolean.valueOf(checkedSetting10.isChecked()));
                    WidgetServerSettingsOverview.this.state.configureSaveActionView(WidgetServerSettingsOverview.this.getBinding().e);
                }
            });
        } else {
            CheckedSetting.d(getBinding().g.e, null, 1);
        }
        this.state.configureSaveActionView(getBinding().e);
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatefulViews statefulViews9 = WidgetServerSettingsOverview.this.state;
                CheckedSetting checkedSetting7 = WidgetServerSettingsOverview.this.getBinding().g.d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.systemChannel.systemChannelJoin");
                int id2 = checkedSetting7.getId();
                CheckedSetting checkedSetting8 = WidgetServerSettingsOverview.this.getBinding().g.d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting8, "binding.systemChannel.systemChannelJoin");
                int i = !((Boolean) statefulViews9.get(id2, Boolean.valueOf(checkedSetting8.isChecked()))).booleanValue() ? 1 : 0;
                StatefulViews statefulViews10 = WidgetServerSettingsOverview.this.state;
                CheckedSetting checkedSetting9 = WidgetServerSettingsOverview.this.getBinding().g.e;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting9, "binding.systemChannel.systemChannelJoinReplies");
                int id3 = checkedSetting9.getId();
                CheckedSetting checkedSetting10 = WidgetServerSettingsOverview.this.getBinding().g.e;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting10, "binding.systemChannel.systemChannelJoinReplies");
                if (!((Boolean) statefulViews10.get(id3, Boolean.valueOf(checkedSetting10.isChecked()))).booleanValue()) {
                    i |= 8;
                }
                StatefulViews statefulViews11 = WidgetServerSettingsOverview.this.state;
                CheckedSetting checkedSetting11 = WidgetServerSettingsOverview.this.getBinding().g.c;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting11, "binding.systemChannel.systemChannelBoost");
                int id4 = checkedSetting11.getId();
                CheckedSetting checkedSetting12 = WidgetServerSettingsOverview.this.getBinding().g.c;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting12, "binding.systemChannel.systemChannelBoost");
                if (!((Boolean) statefulViews11.get(id4, Boolean.valueOf(checkedSetting12.isChecked()))).booleanValue()) {
                    i |= 2;
                }
                RestAPI apiSerializeNulls = RestAPI.INSTANCE.getApiSerializeNulls();
                long id5 = model.getGuild().getId();
                StatefulViews statefulViews12 = WidgetServerSettingsOverview.this.state;
                TextView textView5 = WidgetServerSettingsOverview.this.getBinding().f2582b.f242b;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.afk.afkChannel");
                Channel channel = (Channel) statefulViews12.get(textView5.getId(), model.getAfkChannelModel());
                Long lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
                StatefulViews statefulViews13 = WidgetServerSettingsOverview.this.state;
                LinearLayout linearLayout4 = WidgetServerSettingsOverview.this.getBinding().f2582b.e;
                Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.afk.afkTimeoutWrap");
                Integer num = (Integer) statefulViews13.get(linearLayout4.getId(), Integer.valueOf(model.getGuild().getAfkTimeout()));
                StatefulViews statefulViews14 = WidgetServerSettingsOverview.this.state;
                TextView textView6 = WidgetServerSettingsOverview.this.getBinding().g.f153b;
                Intrinsics3.checkNotNullExpressionValue(textView6, "binding.systemChannel.systemChannel");
                Channel channel2 = (Channel) statefulViews14.get(textView6.getId(), model.getSystemChannelModel());
                Long lValueOf2 = channel2 != null ? Long.valueOf(channel2.getId()) : null;
                Integer num2 = (Integer) WidgetServerSettingsOverview.this.state.get(WidgetServerSettingsOverview.STATE_ID_NOTIFICATION_DEFAULT, Integer.valueOf(model.getGuild().getDefaultMessageNotifications()));
                StatefulViews statefulViews15 = WidgetServerSettingsOverview.this.state;
                SimpleDraweeView simpleDraweeView = WidgetServerSettingsOverview.this.getBinding().c.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.header.serverSettingsOverviewIcon");
                String str = (String) statefulViews15.get(simpleDraweeView.getId(), IconUtils.getForGuild$default(model.getGuild(), null, false, null, 14, null));
                StatefulViews statefulViews16 = WidgetServerSettingsOverview.this.state;
                TextInputLayout textInputLayout3 = WidgetServerSettingsOverview.this.getBinding().c.c;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.header.overviewName");
                String str2 = (String) statefulViews16.get(textInputLayout3.getId(), model.getGuild().getName());
                GuildVerificationLevel verificationLevel = model.getGuild().getVerificationLevel();
                GuildExplicitContentFilter explicitContentFilter = model.getGuild().getExplicitContentFilter();
                StatefulViews statefulViews17 = WidgetServerSettingsOverview.this.state;
                SimpleDraweeView simpleDraweeView2 = WidgetServerSettingsOverview.this.getBinding().i.e;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadSplash.uploadSplash");
                String str3 = (String) statefulViews17.get(simpleDraweeView2.getId(), model.getGuild().getSplash());
                StatefulViews statefulViews18 = WidgetServerSettingsOverview.this.state;
                SimpleDraweeView simpleDraweeView3 = WidgetServerSettingsOverview.this.getBinding().h.e;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadBanner.uploadBanner");
                Observable observableY = ObservableExtensionsKt.restSubscribeOn$default(apiSerializeNulls.updateGuild(id5, new RestAPIParams.UpdateGuild(lValueOf, num, lValueOf2, num2, str, str2, verificationLevel, explicitContentFilter, str3, (String) statefulViews18.get(simpleDraweeView3.getId(), model.getGuild().getBanner()), Integer.valueOf(i), _Collections.toList(model.getGuild().getFeatures()), model.getGuild().getRulesChannelId(), model.getGuild().getPublicUpdatesChannelId(), model.getGuild().getPreferredLocale())), false, 1, null).Y(new Func1<com.discord.api.guild.Guild, Observable<? extends Guild>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.7.1
                    @Override // j0.k.Func1
                    public final Observable<? extends Guild> call(com.discord.api.guild.Guild guild) {
                        Observable<R> observableG = StoreStream.INSTANCE.getGuilds().observeGuild(guild.getId()).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
                        return observableG;
                    }
                }).Y(new Func1<Guild, Observable<? extends Model>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.7.2
                    @Override // j0.k.Func1
                    public final Observable<? extends Model> call(Guild guild) {
                        return Model.INSTANCE.get(guild.getId());
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "RestAPI\n          .apiSe…atedGuild.id)\n          }");
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null), WidgetServerSettingsOverview.this, null, 2, null).k(o.i(new Action1<Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.7.3
                    @Override // rx.functions.Action1
                    public final void call(Model model2) {
                        WidgetServerSettingsOverview.this.configureUpdatedGuild(model2);
                    }
                }, WidgetServerSettingsOverview.this));
            }
        });
    }

    private final void configureUpdatedGuild(Model model) {
        StatefulViews.clear$default(this.state, false, 1, null);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        getBinding().f.fullScroll(33);
        configureUI(model);
        AppToast.i(this, R.string.server_settings_updated, 0, 4);
    }

    public static final void create(Context context, long j, boolean z2) {
        INSTANCE.create(context, j, z2);
    }

    private final WidgetServerSettingsOverviewBinding getBinding() {
        return (WidgetServerSettingsOverviewBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void openAvatarPicker(final String guildShortName, final String iconOriginal) {
        this.hasOpenedAvatarPicker = true;
        this.imageSelectedResult = new Action1<String>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.openAvatarPicker.1
            @Override // rx.functions.Action1
            public final void call(String str) {
                WidgetServerSettingsOverview.this.configureIcon(guildShortName, iconOriginal, str, true);
            }
        };
        openMediaChooser();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.imageSelectedResult, ImageUploadDialog.PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.imageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().e;
        TextInputLayout textInputLayout = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.header.overviewName");
        TextView textView = getBinding().f2582b.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.afk.afkTimeout");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout, textView);
        StatefulViews statefulViews2 = this.state;
        TextView textView2 = getBinding().f2582b.f242b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.afk.afkChannel");
        TextView textView3 = getBinding().g.f153b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.systemChannel.systemChannel");
        statefulViews2.addOptionalFields(textView2, textView3);
        TextView textView4 = getBinding().c.f140b;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.header.iconLabel");
        FormatUtils.m(textView4, R.string.minimum_size, new Object[]{"128", "128"}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinkifiedTextView linkifiedTextView = getBinding().i.f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.uploadSplash.uploadSplashLearnMore");
        AppHelpDesk appHelpDesk = AppHelpDesk.a;
        FormatUtils.m(linkifiedTextView, R.string.guild_settings_splash_recommend, new Object[]{appHelpDesk.a(4415841146391L, null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinkifiedTextView linkifiedTextView2 = getBinding().h.g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.uploadBanner.uploadBannerLearnMore");
        FormatUtils.m(linkifiedTextView2, R.string.guild_settings_banner_recommend, new Object[]{appHelpDesk.a(360028716472L, null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().e.hide();
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        companion.registerForResult(this, REQUEST_KEY_AFK_CHANNEL, true, new AnonymousClass1());
        companion.registerForResult(this, REQUEST_KEY_SYSTEM_CHANNEL, true, new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        setActionBarTitle(R.string.overview);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), (Class<?>) WidgetServerSettingsOverview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
