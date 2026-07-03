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
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppActivity;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func5;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsOverview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsOverviewBinding;", 0)};

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
    private final LoggingConfig loggingConfig;
    private final StatefulViews state;

    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class AfkBottomSheet extends AppBottomSheet {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(AfkBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsOverviewAfkTimeoutBinding;", 0)};

        /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;

        public AfkBottomSheet() {
            super(false, 1, null);
            this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsOverview$AfkBottomSheet$binding$2.INSTANCE, null, 2, null);
        }

        private final WidgetServerSettingsOverviewAfkTimeoutBinding getBinding() {
            return (WidgetServerSettingsOverviewAfkTimeoutBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        private final List<TextView> getTimeouts() {
            TextView textView = getBinding().f17725b;
            C12238m.checkNotNullExpressionValue(textView, "binding.serverSettingsOverviewAfkTimeout01");
            TextView textView2 = getBinding().f17726c;
            C12238m.checkNotNullExpressionValue(textView2, "binding.serverSettingsOverviewAfkTimeout05");
            TextView textView3 = getBinding().f17727d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.serverSettingsOverviewAfkTimeout15");
            TextView textView4 = getBinding().f17728e;
            C12238m.checkNotNullExpressionValue(textView4, "binding.serverSettingsOverviewAfkTimeout30");
            TextView textView5 = getBinding().f17729f;
            C12238m.checkNotNullExpressionValue(textView5, "binding.serverSettingsOverviewAfkTimeout60");
            return C12147n.listOf((Object[]) new TextView[]{textView, textView2, textView3, textView4, textView5});
        }

        @Override // com.discord.app.AppBottomSheet
        public int getContentViewResId() {
            return C5419R.layout.widget_server_settings_overview_afk_timeout;
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle savedInstanceState) {
            C12238m.checkNotNullParameter(view, "view");
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
                C12238m.checkNotNullExpressionValue(context, "it.context");
                final CharSequence afkTimeout = companion.getAfkTimeout(context, i);
                textView.setText(afkTimeout);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview$AfkBottomSheet$onViewCreated$$inlined$forEach$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        WidgetServerSettingsOverview widgetServerSettingsOverview2 = widgetServerSettingsOverview;
                        StatefulViews statefulViews = widgetServerSettingsOverview2.state;
                        TextView textView2 = widgetServerSettingsOverview2.getBinding().f17731b.f1452d;
                        C12238m.checkNotNullExpressionValue(textView2, "binding.afk.afkTimeout");
                        statefulViews.put(textView2.getId(), afkTimeout);
                        StatefulViews statefulViews2 = widgetServerSettingsOverview2.state;
                        LinearLayout linearLayout = widgetServerSettingsOverview2.getBinding().f17731b.f1453e;
                        C12238m.checkNotNullExpressionValue(linearLayout, "binding.afk.afkTimeoutWrap");
                        statefulViews2.put(linearLayout.getId(), Integer.valueOf(i));
                        TextView textView3 = widgetServerSettingsOverview2.getBinding().f17731b.f1452d;
                        C12238m.checkNotNullExpressionValue(textView3, "binding.afk.afkTimeout");
                        textView3.setText(afkTimeout);
                        LinearLayout linearLayout2 = widgetServerSettingsOverview2.getBinding().f17731b.f1453e;
                        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.afk.afkTimeoutWrap");
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
            C12238m.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("OVERVIEW", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId).putExtra(WidgetServerSettingsOverview.INTENT_EXTRA_OPEN_AVATAR_PICKER, openAvatarPicker);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…PICKER, openAvatarPicker)");
            C0870j.m156d(context, WidgetServerSettingsOverview.class, intentPutExtra);
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
                Observable<R> observableM11099Y = StoreStream.INSTANCE.getGuilds().observeGuild(guildId).m11099Y(new InterfaceC12589b<Guild, Observable<? extends Model>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview$Model$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetServerSettingsOverview.Model> call(final Guild guild) {
                        if (guild == null) {
                            return new C12721k(null);
                        }
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
                        StoreChannels channels = companion.getChannels();
                        Long afkChannelId = guild.getAfkChannelId();
                        Observable<Channel> observableObserveChannel = channels.observeChannel(afkChannelId != null ? afkChannelId.longValue() : 0L);
                        StoreChannels channels2 = companion.getChannels();
                        Long systemChannelId = guild.getSystemChannelId();
                        return Observable.m11072g(observableObserveMe$default, observableObserveChannel, channels2.observeChannel(systemChannelId != null ? systemChannelId.longValue() : 0L), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuildProfiles().observeGuildProfile(guildId), new Func5<MeUser, Channel, Channel, Long, StoreGuildProfiles.GuildProfileData, WidgetServerSettingsOverview.Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview$Model$Companion$get$1.1
                            @Override // p658rx.functions.Func5
                            public final WidgetServerSettingsOverview.Model call(MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles.GuildProfileData guildProfileData) {
                                Guild guild2 = guild;
                                C12238m.checkNotNullExpressionValue(meUser, "me");
                                return new WidgetServerSettingsOverview.Model(guild2, meUser, channel, channel2, l, guildProfileData);
                            }
                        });
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        }\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public final CharSequence getAfkTimeout(Context context, int afkTimeout) {
                C12238m.checkNotNullParameter(context, "context");
                if (afkTimeout == 60) {
                    Resources resources = context.getResources();
                    C12238m.checkNotNullExpressionValue(resources, "context.resources");
                    return StringResourceUtilsKt.getQuantityString(resources, context, C5419R.plurals.duration_minutes_minutes, 1, 1);
                }
                if (afkTimeout == 300) {
                    Resources resources2 = context.getResources();
                    C12238m.checkNotNullExpressionValue(resources2, "context.resources");
                    return StringResourceUtilsKt.getQuantityString(resources2, context, C5419R.plurals.duration_minutes_minutes, 5, 5);
                }
                if (afkTimeout == 900) {
                    Resources resources3 = context.getResources();
                    C12238m.checkNotNullExpressionValue(resources3, "context.resources");
                    return StringResourceUtilsKt.getQuantityString(resources3, context, C5419R.plurals.duration_minutes_minutes, 15, 15);
                }
                if (afkTimeout == 1800) {
                    Resources resources4 = context.getResources();
                    C12238m.checkNotNullExpressionValue(resources4, "context.resources");
                    return StringResourceUtilsKt.getQuantityString(resources4, context, C5419R.plurals.duration_minutes_minutes, 30, 30);
                }
                if (afkTimeout != 3600) {
                    return "";
                }
                Resources resources5 = context.getResources();
                C12238m.checkNotNullExpressionValue(resources5, "context.resources");
                return StringResourceUtilsKt.getQuantityString(resources5, context, C5419R.plurals.duration_hours_hours, 1, 1);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles.GuildProfileData guildProfileData) {
            GuildPreview data;
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(meUser, "me");
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

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerSection$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class C92781 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Guild $guild;

        /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerSection$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "view");
                WidgetGuildBoost.Companion companion = WidgetGuildBoost.INSTANCE;
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "view.context");
                companion.create(context, C92781.this.$guild.getId());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C92781(Guild guild) {
            super(1);
            this.$guild = guild;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("tierStatus", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureSplashSection$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class C92851 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Guild $guild;

        /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureSplashSection$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "view");
                WidgetGuildBoost.Companion companion = WidgetGuildBoost.INSTANCE;
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "view.context");
                companion.create(context, C92851.this.$guild.getId());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C92851(Guild guild) {
            super(1);
            this.$guild = guild;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("tierInfo", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class C92941 extends AbstractC12240o implements Function2<Long, String, Unit> {
        public C92941() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            Channel channel = StoreStream.INSTANCE.getChannels().getChannel(j);
            WidgetServerSettingsOverview.this.state.put(C5419R.id.afk_channel, channel);
            WidgetServerSettingsOverview.this.state.configureSaveActionView(WidgetServerSettingsOverview.this.getBinding().f17734e);
            WidgetServerSettingsOverview.this.configureAfkChannel(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class C92952 extends AbstractC12240o implements Function2<Long, String, Unit> {
        public C92952() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            Channel channel = StoreStream.INSTANCE.getChannels().getChannel(j);
            WidgetServerSettingsOverview.this.state.put(C5419R.id.system_channel, channel);
            WidgetServerSettingsOverview.this.state.configureSaveActionView(WidgetServerSettingsOverview.this.getBinding().f17734e);
            WidgetServerSettingsOverview.this.configureSystemChannel(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
    public static final class C92961 extends AbstractC12240o implements Function1<Model, Unit> {
        public C92961() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsOverview.this.configureUI(model);
        }
    }

    public WidgetServerSettingsOverview() {
        super(C5419R.layout.widget_server_settings_overview);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsOverview$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(C5419R.id.server_settings_overview_icon, C5419R.id.overview_name, C5419R.id.afk_channel, C5419R.id.afk_timeout, C5419R.id.afk_timeout_wrap, C5419R.id.system_channel, C5419R.id.upload_splash, C5419R.id.upload_banner, C5419R.id.system_channel_join, C5419R.id.system_channel_join_replies, C5419R.id.system_channel_boost, STATE_ID_NOTIFICATION_DEFAULT);
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsOverview$loggingConfig$1.INSTANCE, 3);
    }

    private final void configureAfkChannel(Channel selectedChannel) {
        TextView textView = getBinding().f17731b.f1450b;
        C12238m.checkNotNullExpressionValue(textView, "binding.afk.afkChannel");
        configureChannel(textView, selectedChannel, C5419R.string.no_afk_channel, C5419R.drawable.ic_channel_voice_16dp);
    }

    private final void configureAnimatedBannerUpsellSection(final Guild guild) {
        int premiumTier = guild.getPremiumTier();
        Integer minimumBoostTierForGuildFeature = PremiumUtils.INSTANCE.getMinimumBoostTierForGuildFeature(GuildFeature.ANIMATED_BANNER);
        boolean z2 = premiumTier == (minimumBoostTierForGuildFeature != null ? minimumBoostTierForGuildFeature.intValue() : 0) - 1;
        boolean zCanHaveAnimatedBanner = guild.canHaveAnimatedBanner();
        LinearLayout linearLayout = getBinding().f17737h.f1078b.f1051c;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.uploadBanner.ani…atedBannerUpsellContainer");
        linearLayout.setVisibility(zCanHaveAnimatedBanner || z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f17737h.f1078b.f1050b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.uploadBanner.ani…nimatedBannerUpsellButton");
        materialButton.setVisibility(z2 ? 0 : 8);
        TextView textView = getBinding().f17737h.f1078b.f1052d;
        C12238m.checkNotNullExpressionValue(textView, "binding.uploadBanner.ani….animatedBannerUpsellText");
        C1107b.m221m(textView, zCanHaveAnimatedBanner ? C5419R.string.guild_settings_animated_banner_try_it : C5419R.string.guild_settings_animated_banner_upsell, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        MaterialButton materialButton2 = getBinding().f17737h.f1078b.f1050b;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.uploadBanner.ani…nimatedBannerUpsellButton");
        if (materialButton2.getVisibility() == 0) {
            getBinding().f17737h.f1078b.f1050b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureAnimatedBannerUpsellSection.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildBoost.INSTANCE.create(C1643a.m885x(view, "it", "it.context"), guild.getId());
                }
            });
        }
    }

    private final void configureBannerImage(final String bannerOriginalUrl, String bannerUpdatedUrl, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().f17737h.f1081e;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.uploadBanner.uploadBanner");
            statefulViews.put(simpleDraweeView.getId(), bannerUpdatedUrl != null ? bannerUpdatedUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().f17737h.f1081e;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadBanner.uploadBanner");
            bannerUpdatedUrl = (String) statefulViews2.get(simpleDraweeView2.getId(), bannerOriginalUrl);
        }
        getBinding().f17737h.f1079c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureBannerImage.1

            /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerImage$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
            public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetServerSettingsOverview.this.openMediaChooser();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.imageSelectedResult = new Action1<String>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureBannerImage.1.1
                    @Override // p658rx.functions.Action1
                    public final void call(String str) {
                        ViewOnClickListenerC92761 viewOnClickListenerC92761 = ViewOnClickListenerC92761.this;
                        WidgetServerSettingsOverview.this.configureBannerImage(bannerOriginalUrl, str, true);
                    }
                };
                WidgetServerSettingsOverview.this.requestMedia(new AnonymousClass2());
            }
        });
        SimpleDraweeView simpleDraweeView3 = getBinding().f17737h.f1081e;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadBanner.uploadBanner");
        IconUtils.setIcon$default(simpleDraweeView3, bannerUpdatedUrl, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView = getBinding().f17737h.f1080d;
        C12238m.checkNotNullExpressionValue(textView, "binding.uploadBanner.ser…verviewUploadBannerRemove");
        textView.setVisibility((bannerUpdatedUrl == null || C12103t.isBlank(bannerUpdatedUrl)) ^ true ? 0 : 8);
        getBinding().f17737h.f1080d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureBannerImage.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.configureBannerImage(bannerOriginalUrl, null, true);
            }
        });
        this.state.configureSaveActionView(getBinding().f17734e);
    }

    private final void configureBannerSection(final Guild guild) {
        boolean z2 = true;
        if (!guild.canHaveBanner()) {
            TextView textView = getBinding().f17737h.f1084h;
            C12238m.checkNotNullExpressionValue(textView, "binding.uploadBanner.uploadBannerNitroTier");
            C1107b.m221m(textView, C5419R.string.guild_settings_overview_tier_info, new Object[]{ExifInterface.GPS_MEASUREMENT_2D, "tierStatus"}, new C92781(guild));
            TextView textView2 = getBinding().f17737h.f1084h;
            C12238m.checkNotNullExpressionValue(textView2, "binding.uploadBanner.uploadBannerNitroTier");
            textView2.setVisibility(0);
            FloatingActionButton floatingActionButton = getBinding().f17737h.f1082f;
            C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.uploadBanner.uploadBannerFab");
            ViewExtensions.setEnabledAlpha$default(floatingActionButton, false, 0.0f, 2, null);
            int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guild.getId(), 2, null, null, 12, null) - guild.getPremiumSubscriptionCount();
            Resources resources = getResources();
            C12238m.checkNotNullExpressionValue(resources, "resources");
            CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), C5419R.plurals.guild_settings_overview_boost_unlock_boosts, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default));
            TextView textView3 = getBinding().f17737h.f1085i;
            C12238m.checkNotNullExpressionValue(textView3, "binding.uploadBanner.uploadBannerUnlock");
            ViewExtensions.setTextAndVisibilityBy(textView3, C1107b.m213e(this, C5419R.string.guild_settings_overview_boost_unlock, new Object[]{quantityString}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            TextView textView4 = getBinding().f17737h.f1085i;
            C12238m.checkNotNullExpressionValue(textView4, "binding.uploadBanner.uploadBannerUnlock");
            DrawableCompat.setCompoundDrawablesCompat$default(textView4, 0, C5419R.drawable.ic_perk_lock, 0, 0, 13, (Object) null);
            getBinding().f17737h.f1085i.setTextColor(ColorCompat.getThemedColor(requireContext(), C5419R.attr.primary_300));
            getBinding().f17737h.f1081e.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), C5419R.attr.primary_630));
            getBinding().f17737h.f1084h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureBannerSection.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildBoost.INSTANCE.create(C1643a.m885x(view, "it", "it.context"), guild.getId());
                }
            });
            return;
        }
        getBinding().f17737h.f1081e.setBackgroundResource(C5419R.drawable.drawable_bg_nitro_gradient);
        TextView textView5 = getBinding().f17737h.f1084h;
        C12238m.checkNotNullExpressionValue(textView5, "binding.uploadBanner.uploadBannerNitroTier");
        textView5.setVisibility(8);
        TextView textView6 = getBinding().f17737h.f1085i;
        C12238m.checkNotNullExpressionValue(textView6, "binding.uploadBanner.uploadBannerUnlock");
        C1107b.m221m(textView6, C5419R.string.guild_settings_overview_boost_unlocked, new Object[]{ExifInterface.GPS_MEASUREMENT_2D}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView7 = getBinding().f17737h.f1085i;
        C12238m.checkNotNullExpressionValue(textView7, "binding.uploadBanner.uploadBannerUnlock");
        DrawableCompat.setCompoundDrawablesCompat$default(textView7, 0, C5419R.drawable.ic_perk_tier_1_boosted, 0, 0, 13, (Object) null);
        getBinding().f17737h.f1085i.setTextColor(ColorCompat.getColor(requireContext(), C5419R.color.white));
        TextView textView8 = getBinding().f17737h.f1085i;
        C12238m.checkNotNullExpressionValue(textView8, "binding.uploadBanner.uploadBannerUnlock");
        String banner = guild.getBanner();
        if (banner != null && banner.length() != 0) {
            z2 = false;
        }
        textView8.setVisibility(z2 ? 0 : 8);
        IconUtils iconUtils = IconUtils.INSTANCE;
        Resources resources2 = getResources();
        C12238m.checkNotNullExpressionValue(resources2, "resources");
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        configureBannerImage(IconUtils.getBannerForGuild$default(iconUtils, guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null, false, 4, null), null, false);
    }

    private final void configureChannel(TextView textView, Channel channel, @StringRes int i, @DrawableRes int i2) {
        CharSequence charSequenceM216h;
        if (channel != null) {
            charSequenceM216h = ChannelUtils.m7679c(channel);
        } else {
            Context context = textView.getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            charSequenceM216h = C1107b.m216h(context, i, new Object[0], null, 4);
        }
        textView.setText(charSequenceM216h);
        DrawableCompat.setCompoundDrawablesCompat$default(textView, channel == null ? 0 : i2, 0, 0, 0, 14, (Object) null);
    }

    private final void configureIcon(final String guildShortName, final String iconOriginal, String iconUpdated, boolean stateShouldUpdate) {
        boolean z2 = true;
        if (!this.hasOpenedAvatarPicker && getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_OPEN_AVATAR_PICKER, false)) {
            openAvatarPicker(guildShortName, iconOriginal);
        }
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().f17732c.f976d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.header.serverSettingsOverviewIcon");
            statefulViews.put(simpleDraweeView.getId(), iconUpdated != null ? iconUpdated : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().f17732c.f976d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.header.serverSettingsOverviewIcon");
            iconUpdated = (String) statefulViews2.get(simpleDraweeView2.getId(), iconOriginal);
        }
        getBinding().f17732c.f976d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureIcon.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.openAvatarPicker(guildShortName, iconOriginal);
            }
        });
        SimpleDraweeView simpleDraweeView3 = getBinding().f17732c.f976d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.header.serverSettingsOverviewIcon");
        IconUtils.setIcon$default(simpleDraweeView3, iconUpdated, C5419R.dimen.avatar_size_extra_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        if (iconUpdated != null && !C12103t.isBlank(iconUpdated)) {
            z2 = false;
        }
        TextView textView = getBinding().f17732c.f974b;
        C12238m.checkNotNullExpressionValue(textView, "binding.header.iconLabel");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = getBinding().f17732c.f977e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.header.serverSettingsOverviewIconRemove");
        textView2.setVisibility(z2 ^ true ? 0 : 8);
        getBinding().f17732c.f977e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureIcon.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.configureIcon(guildShortName, iconOriginal, null, true);
            }
        });
        TextView textView3 = getBinding().f17732c.f978f;
        C12238m.checkNotNullExpressionValue(textView3, "binding.header.serverSettingsOverviewIconText");
        textView3.setVisibility(z2 ? 0 : 8);
        TextView textView4 = getBinding().f17732c.f978f;
        C12238m.checkNotNullExpressionValue(textView4, "binding.header.serverSettingsOverviewIconText");
        textView4.setText(guildShortName);
        this.state.configureSaveActionView(getBinding().f17734e);
    }

    private final void configureRadios(final int stateId, final int activeRadioIndex, final boolean isAboveNotifyAllSize, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            this.state.put(stateId, Integer.valueOf(activeRadioIndex));
        }
        final int i = 0;
        for (Object obj : C12147n.listOf((Object[]) new CheckedSetting[]{getBinding().f17733d.f1002b, getBinding().f17733d.f1003c})) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            C12238m.checkNotNullExpressionValue(checkedSetting, "checkedSetting");
            checkedSetting.setChecked(i == activeRadioIndex);
            if (isAboveNotifyAllSize && checkedSetting.getId() == C5419R.id.server_settings_overview_notification_all) {
                checkedSetting.m8530h(C1107b.m213e(this, C5419R.string.guild_settings_default_notifications_large_guild_notify_all, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), false);
            } else {
                checkedSetting.m8530h(null, false);
            }
            checkedSetting.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview$configureRadios$$inlined$forEachIndexed$lambda$1
                @Override // p658rx.functions.Action1
                public final void call(Boolean bool) {
                    this.configureRadios(stateId, i, isAboveNotifyAllSize, true);
                }
            });
            i = i2;
        }
        this.state.configureSaveActionView(getBinding().f17734e);
    }

    private final void configureSplashImage(final String splashOriginalUrl, String splashUpdatedUrl, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().f17738i.f1110e;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.uploadSplash.uploadSplash");
            statefulViews.put(simpleDraweeView.getId(), splashUpdatedUrl != null ? splashUpdatedUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().f17738i.f1110e;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadSplash.uploadSplash");
            splashUpdatedUrl = (String) statefulViews2.get(simpleDraweeView2.getId(), splashOriginalUrl);
        }
        getBinding().f17738i.f1107b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureSplashImage.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.imageSelectedResult = new Action1<String>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureSplashImage.1.1
                    @Override // p658rx.functions.Action1
                    public final void call(String str) {
                        ViewOnClickListenerC92831 viewOnClickListenerC92831 = ViewOnClickListenerC92831.this;
                        WidgetServerSettingsOverview.this.configureSplashImage(splashOriginalUrl, str, true);
                    }
                };
                WidgetServerSettingsOverview.this.openMediaChooser();
            }
        });
        SimpleDraweeView simpleDraweeView3 = getBinding().f17738i.f1110e;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadSplash.uploadSplash");
        IconUtils.setIcon$default(simpleDraweeView3, splashUpdatedUrl, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView = getBinding().f17738i.f1109d;
        C12238m.checkNotNullExpressionValue(textView, "binding.uploadSplash.ser…verviewUploadSplashRemove");
        textView.setVisibility((splashUpdatedUrl == null || C12103t.isBlank(splashUpdatedUrl)) ^ true ? 0 : 8);
        getBinding().f17738i.f1109d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureSplashImage.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsOverview.this.configureSplashImage(splashOriginalUrl, null, true);
            }
        });
        this.state.configureSaveActionView(getBinding().f17734e);
    }

    private final void configureSplashSection(final Guild guild) {
        boolean z2 = true;
        if (!guild.canHaveSplash()) {
            TextView textView = getBinding().f17738i.f1112g;
            C12238m.checkNotNullExpressionValue(textView, "binding.uploadSplash.uploadSplashNitroTier");
            C1107b.m221m(textView, C5419R.string.guild_settings_overview_tier_info, new Object[]{"1", "tierInfo"}, new C92851(guild));
            TextView textView2 = getBinding().f17738i.f1112g;
            C12238m.checkNotNullExpressionValue(textView2, "binding.uploadSplash.uploadSplashNitroTier");
            textView2.setVisibility(0);
            FloatingActionButton floatingActionButton = getBinding().f17738i.f1108c;
            C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.uploadSplash.ser…gsOverviewUploadSplashFab");
            ViewExtensions.setEnabledAlpha$default(floatingActionButton, false, 0.0f, 2, null);
            int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guild.getId(), 1, null, null, 12, null) - guild.getPremiumSubscriptionCount();
            Resources resources = getResources();
            C12238m.checkNotNullExpressionValue(resources, "resources");
            CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), C5419R.plurals.guild_settings_overview_boost_unlock_boosts, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default));
            TextView textView3 = getBinding().f17738i.f1113h;
            C12238m.checkNotNullExpressionValue(textView3, "binding.uploadSplash.uploadSplashUnlock");
            ViewExtensions.setTextAndVisibilityBy(textView3, C1107b.m213e(this, C5419R.string.guild_settings_overview_boost_unlock, new Object[]{quantityString}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            TextView textView4 = getBinding().f17738i.f1113h;
            C12238m.checkNotNullExpressionValue(textView4, "binding.uploadSplash.uploadSplashUnlock");
            DrawableCompat.setCompoundDrawablesCompat$default(textView4, 0, C5419R.drawable.ic_perk_lock, 0, 0, 13, (Object) null);
            getBinding().f17738i.f1113h.setTextColor(ColorCompat.getThemedColor(requireContext(), C5419R.attr.primary_300));
            getBinding().f17738i.f1110e.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), C5419R.attr.primary_630));
            getBinding().f17738i.f1112g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureSplashSection.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildBoost.INSTANCE.create(C1643a.m885x(view, "it", "it.context"), guild.getId());
                }
            });
            return;
        }
        TextView textView5 = getBinding().f17738i.f1112g;
        C12238m.checkNotNullExpressionValue(textView5, "binding.uploadSplash.uploadSplashNitroTier");
        textView5.setVisibility(8);
        getBinding().f17738i.f1110e.setBackgroundResource(C5419R.drawable.drawable_bg_nitro_gradient);
        TextView textView6 = getBinding().f17738i.f1113h;
        C12238m.checkNotNullExpressionValue(textView6, "binding.uploadSplash.uploadSplashUnlock");
        C1107b.m221m(textView6, C5419R.string.guild_settings_overview_boost_unlocked, new Object[]{"1"}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView7 = getBinding().f17738i.f1113h;
        C12238m.checkNotNullExpressionValue(textView7, "binding.uploadSplash.uploadSplashUnlock");
        DrawableCompat.setCompoundDrawablesCompat$default(textView7, 0, C5419R.drawable.ic_perk_tier_1_boosted, 0, 0, 13, (Object) null);
        getBinding().f17738i.f1113h.setTextColor(ColorCompat.getColor(requireContext(), C5419R.color.white));
        TextView textView8 = getBinding().f17738i.f1113h;
        C12238m.checkNotNullExpressionValue(textView8, "binding.uploadSplash.uploadSplashUnlock");
        String splash = guild.getSplash();
        if (splash != null && splash.length() != 0) {
            z2 = false;
        }
        textView8.setVisibility(z2 ? 0 : 8);
        IconUtils iconUtils = IconUtils.INSTANCE;
        Resources resources2 = getResources();
        C12238m.checkNotNullExpressionValue(resources2, "resources");
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        configureSplashImage(iconUtils.getGuildSplashUrl(guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null), null, false);
    }

    private final void configureSystemChannel(Channel selectedChannel) {
        TextView textView = getBinding().f17736g.f1026b;
        C12238m.checkNotNullExpressionValue(textView, "binding.systemChannel.systemChannel");
        configureChannel(textView, selectedChannel, C5419R.string.no_system_channel, C5419R.drawable.ic_channel_text_16dp);
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
        TextInputLayout textInputLayout = getBinding().f17732c.f975c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.header.overviewName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f17732c.f975c;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.header.overviewName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), model.getGuild().getName()));
        StatefulViews statefulViews2 = this.state;
        TextView textView = getBinding().f17731b.f1450b;
        C12238m.checkNotNullExpressionValue(textView, "binding.afk.afkChannel");
        configureAfkChannel((Channel) statefulViews2.get(textView.getId(), model.getAfkChannelModel()));
        getBinding().f17731b.f1451c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSelector.INSTANCE.launchForVoice(WidgetServerSettingsOverview.this, model.getGuild().getId(), WidgetServerSettingsOverview.REQUEST_KEY_AFK_CHANNEL, true, C5419R.string.no_afk_channel);
            }
        });
        TextView textView2 = getBinding().f17731b.f1452d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.afk.afkTimeout");
        StatefulViews statefulViews3 = this.state;
        TextView textView3 = getBinding().f17731b.f1452d;
        C12238m.checkNotNullExpressionValue(textView3, "binding.afk.afkTimeout");
        textView2.setText((CharSequence) statefulViews3.get(textView3.getId(), Model.INSTANCE.getAfkTimeout(C1643a.m821I(getBinding().f17731b.f1452d, "binding.afk.afkTimeout", "binding.afk.afkTimeout.context"), model.getGuild().getAfkTimeout())));
        getBinding().f17731b.f1453e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AfkBottomSheet afkBottomSheet = new AfkBottomSheet();
                FragmentManager childFragmentManager = WidgetServerSettingsOverview.this.getChildFragmentManager();
                C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                afkBottomSheet.show(childFragmentManager, C12216a0.getOrCreateKotlinClass(AfkBottomSheet.class).toString());
            }
        });
        LinearLayout linearLayout = getBinding().f17731b.f1453e;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.afk.afkTimeoutWrap");
        linearLayout.setTag(Integer.valueOf(model.getGuild().getAfkTimeout()));
        StatefulViews statefulViews4 = this.state;
        TextView textView4 = getBinding().f17736g.f1026b;
        C12238m.checkNotNullExpressionValue(textView4, "binding.systemChannel.systemChannel");
        configureSystemChannel((Channel) statefulViews4.get(textView4.getId(), model.getSystemChannelModel()));
        getBinding().f17736g.f1030f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSelector.INSTANCE.launchForText(WidgetServerSettingsOverview.this, model.getGuild().getId(), WidgetServerSettingsOverview.REQUEST_KEY_SYSTEM_CHANNEL, true, C5419R.string.no_system_channel);
            }
        });
        LinearLayout linearLayout2 = getBinding().f17736g.f1030f;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.systemChannel.systemChannelWrap");
        StatefulViews statefulViews5 = this.state;
        LinearLayout linearLayout3 = getBinding().f17736g.f1030f;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.systemChannel.systemChannelWrap");
        linearLayout2.setTag(statefulViews5.get(linearLayout3.getId(), model.getGuild().getSystemChannelId()));
        configureRadios(STATE_ID_NOTIFICATION_DEFAULT, ((Number) this.state.get(STATE_ID_NOTIFICATION_DEFAULT, Integer.valueOf(model.getGuild().getDefaultMessageNotifications()))).intValue(), model.getIsAboveNotifyAllSize(), false);
        configureSplashSection(model.getGuild());
        configureBannerSection(model.getGuild());
        configureAnimatedBannerUpsellSection(model.getGuild());
        boolean z2 = (model.getGuild().getSystemChannelFlags() & 1) == 0;
        CheckedSetting checkedSetting = getBinding().f17736g.f1028d;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelJoin");
        StatefulViews statefulViews6 = this.state;
        CheckedSetting checkedSetting2 = getBinding().f17736g.f1028d;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelJoin");
        checkedSetting.setChecked(((Boolean) statefulViews6.get(checkedSetting2.getId(), Boolean.valueOf(z2))).booleanValue());
        if (model.getSystemChannelModel() != null) {
            getBinding().f17736g.f1028d.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting3 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1028d;
                    C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelJoin");
                    CheckedSetting checkedSetting4 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1028d;
                    C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.systemChannel.systemChannelJoin");
                    checkedSetting3.setChecked(!checkedSetting4.isChecked());
                    StatefulViews statefulViews7 = WidgetServerSettingsOverview.this.state;
                    CheckedSetting checkedSetting5 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1028d;
                    C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.systemChannel.systemChannelJoin");
                    int id2 = checkedSetting5.getId();
                    CheckedSetting checkedSetting6 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1028d;
                    C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.systemChannel.systemChannelJoin");
                    statefulViews7.put(id2, Boolean.valueOf(checkedSetting6.isChecked()));
                    WidgetServerSettingsOverview.this.state.configureSaveActionView(WidgetServerSettingsOverview.this.getBinding().f17734e);
                }
            });
        } else {
            CheckedSetting.m8523d(getBinding().f17736g.f1028d, null, 1);
        }
        boolean z3 = (model.getGuild().getSystemChannelFlags() & 2) == 0;
        CheckedSetting checkedSetting3 = getBinding().f17736g.f1027c;
        C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelBoost");
        StatefulViews statefulViews7 = this.state;
        CheckedSetting checkedSetting4 = getBinding().f17736g.f1027c;
        C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.systemChannel.systemChannelBoost");
        checkedSetting3.setChecked(((Boolean) statefulViews7.get(checkedSetting4.getId(), Boolean.valueOf(z3))).booleanValue());
        if (model.getSystemChannelModel() != null) {
            getBinding().f17736g.f1027c.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting5 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1027c;
                    C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.systemChannel.systemChannelBoost");
                    CheckedSetting checkedSetting6 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1027c;
                    C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.systemChannel.systemChannelBoost");
                    checkedSetting5.setChecked(!checkedSetting6.isChecked());
                    StatefulViews statefulViews8 = WidgetServerSettingsOverview.this.state;
                    CheckedSetting checkedSetting7 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1027c;
                    C12238m.checkNotNullExpressionValue(checkedSetting7, "binding.systemChannel.systemChannelBoost");
                    int id2 = checkedSetting7.getId();
                    CheckedSetting checkedSetting8 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1027c;
                    C12238m.checkNotNullExpressionValue(checkedSetting8, "binding.systemChannel.systemChannelBoost");
                    statefulViews8.put(id2, Boolean.valueOf(checkedSetting8.isChecked()));
                    WidgetServerSettingsOverview.this.state.configureSaveActionView(WidgetServerSettingsOverview.this.getBinding().f17734e);
                }
            });
        } else {
            CheckedSetting.m8523d(getBinding().f17736g.f1027c, null, 1);
        }
        boolean z4 = (model.getGuild().getSystemChannelFlags() & 8) == 0;
        CheckedSetting checkedSetting5 = getBinding().f17736g.f1029e;
        C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.systemChannel.systemChannelJoinReplies");
        StatefulViews statefulViews8 = this.state;
        CheckedSetting checkedSetting6 = getBinding().f17736g.f1029e;
        C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.systemChannel.systemChannelJoinReplies");
        checkedSetting5.setChecked(((Boolean) statefulViews8.get(checkedSetting6.getId(), Boolean.valueOf(z4))).booleanValue());
        if (model.getSystemChannelModel() != null) {
            getBinding().f17736g.f1029e.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting7 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1029e;
                    C12238m.checkNotNullExpressionValue(checkedSetting7, "binding.systemChannel.systemChannelJoinReplies");
                    CheckedSetting checkedSetting8 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1029e;
                    C12238m.checkNotNullExpressionValue(checkedSetting8, "binding.systemChannel.systemChannelJoinReplies");
                    checkedSetting7.setChecked(!checkedSetting8.isChecked());
                    StatefulViews statefulViews9 = WidgetServerSettingsOverview.this.state;
                    CheckedSetting checkedSetting9 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1029e;
                    C12238m.checkNotNullExpressionValue(checkedSetting9, "binding.systemChannel.systemChannelJoinReplies");
                    int id2 = checkedSetting9.getId();
                    CheckedSetting checkedSetting10 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1029e;
                    C12238m.checkNotNullExpressionValue(checkedSetting10, "binding.systemChannel.systemChannelJoinReplies");
                    statefulViews9.put(id2, Boolean.valueOf(checkedSetting10.isChecked()));
                    WidgetServerSettingsOverview.this.state.configureSaveActionView(WidgetServerSettingsOverview.this.getBinding().f17734e);
                }
            });
        } else {
            CheckedSetting.m8523d(getBinding().f17736g.f1029e, null, 1);
        }
        this.state.configureSaveActionView(getBinding().f17734e);
        getBinding().f17734e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatefulViews statefulViews9 = WidgetServerSettingsOverview.this.state;
                CheckedSetting checkedSetting7 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1028d;
                C12238m.checkNotNullExpressionValue(checkedSetting7, "binding.systemChannel.systemChannelJoin");
                int id2 = checkedSetting7.getId();
                CheckedSetting checkedSetting8 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1028d;
                C12238m.checkNotNullExpressionValue(checkedSetting8, "binding.systemChannel.systemChannelJoin");
                int i = !((Boolean) statefulViews9.get(id2, Boolean.valueOf(checkedSetting8.isChecked()))).booleanValue() ? 1 : 0;
                StatefulViews statefulViews10 = WidgetServerSettingsOverview.this.state;
                CheckedSetting checkedSetting9 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1029e;
                C12238m.checkNotNullExpressionValue(checkedSetting9, "binding.systemChannel.systemChannelJoinReplies");
                int id3 = checkedSetting9.getId();
                CheckedSetting checkedSetting10 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1029e;
                C12238m.checkNotNullExpressionValue(checkedSetting10, "binding.systemChannel.systemChannelJoinReplies");
                if (!((Boolean) statefulViews10.get(id3, Boolean.valueOf(checkedSetting10.isChecked()))).booleanValue()) {
                    i |= 8;
                }
                StatefulViews statefulViews11 = WidgetServerSettingsOverview.this.state;
                CheckedSetting checkedSetting11 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1027c;
                C12238m.checkNotNullExpressionValue(checkedSetting11, "binding.systemChannel.systemChannelBoost");
                int id4 = checkedSetting11.getId();
                CheckedSetting checkedSetting12 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1027c;
                C12238m.checkNotNullExpressionValue(checkedSetting12, "binding.systemChannel.systemChannelBoost");
                if (!((Boolean) statefulViews11.get(id4, Boolean.valueOf(checkedSetting12.isChecked()))).booleanValue()) {
                    i |= 2;
                }
                RestAPI apiSerializeNulls = RestAPI.INSTANCE.getApiSerializeNulls();
                long id5 = model.getGuild().getId();
                StatefulViews statefulViews12 = WidgetServerSettingsOverview.this.state;
                TextView textView5 = WidgetServerSettingsOverview.this.getBinding().f17731b.f1450b;
                C12238m.checkNotNullExpressionValue(textView5, "binding.afk.afkChannel");
                Channel channel = (Channel) statefulViews12.get(textView5.getId(), model.getAfkChannelModel());
                Long lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
                StatefulViews statefulViews13 = WidgetServerSettingsOverview.this.state;
                LinearLayout linearLayout4 = WidgetServerSettingsOverview.this.getBinding().f17731b.f1453e;
                C12238m.checkNotNullExpressionValue(linearLayout4, "binding.afk.afkTimeoutWrap");
                Integer num = (Integer) statefulViews13.get(linearLayout4.getId(), Integer.valueOf(model.getGuild().getAfkTimeout()));
                StatefulViews statefulViews14 = WidgetServerSettingsOverview.this.state;
                TextView textView6 = WidgetServerSettingsOverview.this.getBinding().f17736g.f1026b;
                C12238m.checkNotNullExpressionValue(textView6, "binding.systemChannel.systemChannel");
                Channel channel2 = (Channel) statefulViews14.get(textView6.getId(), model.getSystemChannelModel());
                Long lValueOf2 = channel2 != null ? Long.valueOf(channel2.getId()) : null;
                Integer num2 = (Integer) WidgetServerSettingsOverview.this.state.get(WidgetServerSettingsOverview.STATE_ID_NOTIFICATION_DEFAULT, Integer.valueOf(model.getGuild().getDefaultMessageNotifications()));
                StatefulViews statefulViews15 = WidgetServerSettingsOverview.this.state;
                SimpleDraweeView simpleDraweeView = WidgetServerSettingsOverview.this.getBinding().f17732c.f976d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.header.serverSettingsOverviewIcon");
                String str = (String) statefulViews15.get(simpleDraweeView.getId(), IconUtils.getForGuild$default(model.getGuild(), null, false, null, 14, null));
                StatefulViews statefulViews16 = WidgetServerSettingsOverview.this.state;
                TextInputLayout textInputLayout3 = WidgetServerSettingsOverview.this.getBinding().f17732c.f975c;
                C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.header.overviewName");
                String str2 = (String) statefulViews16.get(textInputLayout3.getId(), model.getGuild().getName());
                GuildVerificationLevel verificationLevel = model.getGuild().getVerificationLevel();
                GuildExplicitContentFilter explicitContentFilter = model.getGuild().getExplicitContentFilter();
                StatefulViews statefulViews17 = WidgetServerSettingsOverview.this.state;
                SimpleDraweeView simpleDraweeView2 = WidgetServerSettingsOverview.this.getBinding().f17738i.f1110e;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadSplash.uploadSplash");
                String str3 = (String) statefulViews17.get(simpleDraweeView2.getId(), model.getGuild().getSplash());
                StatefulViews statefulViews18 = WidgetServerSettingsOverview.this.state;
                SimpleDraweeView simpleDraweeView3 = WidgetServerSettingsOverview.this.getBinding().f17737h.f1081e;
                C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadBanner.uploadBanner");
                Observable observableM11099Y = ObservableExtensionsKt.restSubscribeOn$default(apiSerializeNulls.updateGuild(id5, new RestAPIParams.UpdateGuild(lValueOf, num, lValueOf2, num2, str, str2, verificationLevel, explicitContentFilter, str3, (String) statefulViews18.get(simpleDraweeView3.getId(), model.getGuild().getBanner()), Integer.valueOf(i), C12163u.toList(model.getGuild().getFeatures()), model.getGuild().getRulesChannelId(), model.getGuild().getPublicUpdatesChannelId(), model.getGuild().getPreferredLocale())), false, 1, null).m11099Y(new InterfaceC12589b<com.discord.api.guild.Guild, Observable<? extends Guild>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.7.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends Guild> call(com.discord.api.guild.Guild guild) {
                        Observable<R> observableM11083G = StoreStream.INSTANCE.getGuilds().observeGuild(guild.getId()).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
                        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
                        return observableM11083G;
                    }
                }).m11099Y(new InterfaceC12589b<Guild, Observable<? extends Model>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.7.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends Model> call(Guild guild) {
                        return Model.INSTANCE.get(guild.getId());
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "RestAPI\n          .apiSe…atedGuild.id)\n          }");
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11099Y, 0L, false, 3, null), WidgetServerSettingsOverview.this, null, 2, null).m11108k(C0879o.m182i(new Action1<Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsOverview.configureUI.7.3
                    @Override // p658rx.functions.Action1
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
        getBinding().f17735f.fullScroll(33);
        configureUI(model);
        C0876m.m171i(this, C5419R.string.server_settings_updated, 0, 4);
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
            @Override // p658rx.functions.Action1
            public final void call(String str) {
                WidgetServerSettingsOverview.this.configureIcon(guildShortName, iconOriginal, str, true);
            }
        };
        openMediaChooser();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.imageSelectedResult, ImageUploadDialog.PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.imageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().f17734e;
        TextInputLayout textInputLayout = getBinding().f17732c.f975c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.header.overviewName");
        TextView textView = getBinding().f17731b.f1452d;
        C12238m.checkNotNullExpressionValue(textView, "binding.afk.afkTimeout");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout, textView);
        StatefulViews statefulViews2 = this.state;
        TextView textView2 = getBinding().f17731b.f1450b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.afk.afkChannel");
        TextView textView3 = getBinding().f17736g.f1026b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.systemChannel.systemChannel");
        statefulViews2.addOptionalFields(textView2, textView3);
        TextView textView4 = getBinding().f17732c.f974b;
        C12238m.checkNotNullExpressionValue(textView4, "binding.header.iconLabel");
        C1107b.m221m(textView4, C5419R.string.minimum_size, new Object[]{"128", "128"}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinkifiedTextView linkifiedTextView = getBinding().f17738i.f1111f;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.uploadSplash.uploadSplashLearnMore");
        C0862f c0862f = C0862f.f507a;
        C1107b.m221m(linkifiedTextView, C5419R.string.guild_settings_splash_recommend, new Object[]{c0862f.m149a(4415841146391L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinkifiedTextView linkifiedTextView2 = getBinding().f17737h.f1083g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.uploadBanner.uploadBannerLearnMore");
        C1107b.m221m(linkifiedTextView2, C5419R.string.guild_settings_banner_recommend, new Object[]{c0862f.m149a(360028716472L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f17734e.hide();
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        companion.registerForResult(this, REQUEST_KEY_AFK_CHANNEL, true, new C92941());
        companion.registerForResult(this, REQUEST_KEY_SYSTEM_CHANNEL, true, new C92952());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        setActionBarTitle(C5419R.string.overview);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), (Class<?>) WidgetServerSettingsOverview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C92961());
    }
}
