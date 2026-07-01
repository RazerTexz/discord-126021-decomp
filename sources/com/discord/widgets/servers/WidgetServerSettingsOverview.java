package com.discord.widgets.servers;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.f;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsOverviewBinding;
import com.discord.dialogs.ImageUploadDialog$PreviewType;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.channels.WidgetChannelSelector$Companion;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.t.n;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsOverview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsOverviewBinding;", 0)};
    public static final WidgetServerSettingsOverview$Companion Companion = new WidgetServerSettingsOverview$Companion(null);
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

    public WidgetServerSettingsOverview() {
        super(R$layout.widget_server_settings_overview);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsOverview$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R$id.server_settings_overview_icon, R$id.overview_name, R$id.afk_channel, R$id.afk_timeout, R$id.afk_timeout_wrap, R$id.system_channel, R$id.upload_splash, R$id.upload_banner, R$id.system_channel_join, R$id.system_channel_join_replies, R$id.system_channel_boost, STATE_ID_NOTIFICATION_DEFAULT);
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsOverview$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureAfkChannel(WidgetServerSettingsOverview widgetServerSettingsOverview, Channel channel) {
        widgetServerSettingsOverview.configureAfkChannel(channel);
    }

    public static final /* synthetic */ void access$configureBannerImage(WidgetServerSettingsOverview widgetServerSettingsOverview, String str, String str2, boolean z2) {
        widgetServerSettingsOverview.configureBannerImage(str, str2, z2);
    }

    public static final /* synthetic */ void access$configureIcon(WidgetServerSettingsOverview widgetServerSettingsOverview, String str, String str2, String str3, boolean z2) {
        widgetServerSettingsOverview.configureIcon(str, str2, str3, z2);
    }

    public static final /* synthetic */ void access$configureRadios(WidgetServerSettingsOverview widgetServerSettingsOverview, int i, int i2, boolean z2, boolean z3) {
        widgetServerSettingsOverview.configureRadios(i, i2, z2, z3);
    }

    public static final /* synthetic */ void access$configureSplashImage(WidgetServerSettingsOverview widgetServerSettingsOverview, String str, String str2, boolean z2) {
        widgetServerSettingsOverview.configureSplashImage(str, str2, z2);
    }

    public static final /* synthetic */ void access$configureSystemChannel(WidgetServerSettingsOverview widgetServerSettingsOverview, Channel channel) {
        widgetServerSettingsOverview.configureSystemChannel(channel);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsOverview widgetServerSettingsOverview, WidgetServerSettingsOverview$Model widgetServerSettingsOverview$Model) {
        widgetServerSettingsOverview.configureUI(widgetServerSettingsOverview$Model);
    }

    public static final /* synthetic */ void access$configureUpdatedGuild(WidgetServerSettingsOverview widgetServerSettingsOverview, WidgetServerSettingsOverview$Model widgetServerSettingsOverview$Model) {
        widgetServerSettingsOverview.configureUpdatedGuild(widgetServerSettingsOverview$Model);
    }

    public static final /* synthetic */ WidgetServerSettingsOverviewBinding access$getBinding$p(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        return widgetServerSettingsOverview.getBinding();
    }

    public static final /* synthetic */ Action1 access$getImageSelectedResult$p(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        return widgetServerSettingsOverview.imageSelectedResult;
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        return widgetServerSettingsOverview.state;
    }

    public static final /* synthetic */ void access$openAvatarPicker(WidgetServerSettingsOverview widgetServerSettingsOverview, String str, String str2) {
        widgetServerSettingsOverview.openAvatarPicker(str, str2);
    }

    public static final /* synthetic */ void access$setImageSelectedResult$p(WidgetServerSettingsOverview widgetServerSettingsOverview, Action1 action1) {
        widgetServerSettingsOverview.imageSelectedResult = action1;
    }

    private final void configureAfkChannel(Channel selectedChannel) {
        TextView textView = getBinding().f2582b.f242b;
        m.checkNotNullExpressionValue(textView, "binding.afk.afkChannel");
        configureChannel(textView, selectedChannel, 2131893234, 2131231640);
    }

    private final void configureAnimatedBannerUpsellSection(Guild guild) {
        int premiumTier = guild.getPremiumTier();
        Integer minimumBoostTierForGuildFeature = PremiumUtils.INSTANCE.getMinimumBoostTierForGuildFeature(GuildFeature.ANIMATED_BANNER);
        boolean z2 = premiumTier == (minimumBoostTierForGuildFeature != null ? minimumBoostTierForGuildFeature.intValue() : 0) - 1;
        boolean zCanHaveAnimatedBanner = guild.canHaveAnimatedBanner();
        LinearLayout linearLayout = getBinding().h.f167b.c;
        m.checkNotNullExpressionValue(linearLayout, "binding.uploadBanner.ani…atedBannerUpsellContainer");
        linearLayout.setVisibility(zCanHaveAnimatedBanner || z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().h.f167b.f160b;
        m.checkNotNullExpressionValue(materialButton, "binding.uploadBanner.ani…nimatedBannerUpsellButton");
        materialButton.setVisibility(z2 ? 0 : 8);
        TextView textView = getBinding().h.f167b.d;
        m.checkNotNullExpressionValue(textView, "binding.uploadBanner.ani….animatedBannerUpsellText");
        b.n(textView, zCanHaveAnimatedBanner ? 2131890787 : 2131890789, new Object[0], null, 4);
        MaterialButton materialButton2 = getBinding().h.f167b.f160b;
        m.checkNotNullExpressionValue(materialButton2, "binding.uploadBanner.ani…nimatedBannerUpsellButton");
        if (materialButton2.getVisibility() == 0) {
            getBinding().h.f167b.f160b.setOnClickListener(new WidgetServerSettingsOverview$configureAnimatedBannerUpsellSection$1(guild));
        }
    }

    private final void configureBannerImage(String bannerOriginalUrl, String bannerUpdatedUrl, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().h.e;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.uploadBanner.uploadBanner");
            statefulViews.put(simpleDraweeView.getId(), bannerUpdatedUrl != null ? bannerUpdatedUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().h.e;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadBanner.uploadBanner");
            bannerUpdatedUrl = (String) statefulViews2.get(simpleDraweeView2.getId(), bannerOriginalUrl);
        }
        getBinding().h.c.setOnClickListener(new WidgetServerSettingsOverview$configureBannerImage$1(this, bannerOriginalUrl));
        SimpleDraweeView simpleDraweeView3 = getBinding().h.e;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadBanner.uploadBanner");
        IconUtils.setIcon$default(simpleDraweeView3, bannerUpdatedUrl, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        TextView textView = getBinding().h.d;
        m.checkNotNullExpressionValue(textView, "binding.uploadBanner.ser…verviewUploadBannerRemove");
        textView.setVisibility((bannerUpdatedUrl == null || t.isBlank(bannerUpdatedUrl)) ^ true ? 0 : 8);
        getBinding().h.d.setOnClickListener(new WidgetServerSettingsOverview$configureBannerImage$2(this, bannerOriginalUrl));
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureBannerSection(Guild guild) {
        boolean z2 = true;
        if (!guild.canHaveBanner()) {
            TextView textView = getBinding().h.h;
            m.checkNotNullExpressionValue(textView, "binding.uploadBanner.uploadBannerNitroTier");
            b.m(textView, 2131891311, new Object[]{ExifInterface.GPS_MEASUREMENT_2D, "tierStatus"}, new WidgetServerSettingsOverview$configureBannerSection$1(guild));
            TextView textView2 = getBinding().h.h;
            m.checkNotNullExpressionValue(textView2, "binding.uploadBanner.uploadBannerNitroTier");
            textView2.setVisibility(0);
            FloatingActionButton floatingActionButton = getBinding().h.f;
            m.checkNotNullExpressionValue(floatingActionButton, "binding.uploadBanner.uploadBannerFab");
            ViewExtensions.setEnabledAlpha$default(floatingActionButton, false, 0.0f, 2, null);
            int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guild.getId(), 2, null, null, 12, null) - guild.getPremiumSubscriptionCount();
            Resources resources = getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), R$plurals.guild_settings_overview_boost_unlock_boosts, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default));
            TextView textView3 = getBinding().h.i;
            m.checkNotNullExpressionValue(textView3, "binding.uploadBanner.uploadBannerUnlock");
            ViewExtensions.setTextAndVisibilityBy(textView3, b.k(this, 2131891309, new Object[]{quantityString}, null, 4));
            TextView textView4 = getBinding().h.i;
            m.checkNotNullExpressionValue(textView4, "binding.uploadBanner.uploadBannerUnlock");
            DrawableCompat.setCompoundDrawablesCompat$default(textView4, 0, 2131231999, 0, 0, 13, (Object) null);
            getBinding().h.i.setTextColor(ColorCompat.getThemedColor(requireContext(), 2130969978));
            getBinding().h.e.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), 2130969991));
            getBinding().h.h.setOnClickListener(new WidgetServerSettingsOverview$configureBannerSection$2(guild));
            return;
        }
        getBinding().h.e.setBackgroundResource(2131231117);
        TextView textView5 = getBinding().h.h;
        m.checkNotNullExpressionValue(textView5, "binding.uploadBanner.uploadBannerNitroTier");
        textView5.setVisibility(8);
        TextView textView6 = getBinding().h.i;
        m.checkNotNullExpressionValue(textView6, "binding.uploadBanner.uploadBannerUnlock");
        b.n(textView6, 2131891310, new Object[]{ExifInterface.GPS_MEASUREMENT_2D}, null, 4);
        TextView textView7 = getBinding().h.i;
        m.checkNotNullExpressionValue(textView7, "binding.uploadBanner.uploadBannerUnlock");
        DrawableCompat.setCompoundDrawablesCompat$default(textView7, 0, 2131232000, 0, 0, 13, (Object) null);
        getBinding().h.i.setTextColor(ColorCompat.getColor(requireContext(), 2131100487));
        TextView textView8 = getBinding().h.i;
        m.checkNotNullExpressionValue(textView8, "binding.uploadBanner.uploadBannerUnlock");
        String banner = guild.getBanner();
        if (banner != null && banner.length() != 0) {
            z2 = false;
        }
        textView8.setVisibility(z2 ? 0 : 8);
        IconUtils iconUtils = IconUtils.INSTANCE;
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        configureBannerImage(IconUtils.getBannerForGuild$default(iconUtils, guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null, false, 4, null), null, false);
    }

    private final void configureChannel(TextView textView, Channel channel, @StringRes int i, @DrawableRes int i2) {
        CharSequence charSequenceH;
        if (channel != null) {
            charSequenceH = ChannelUtils.c(channel);
        } else {
            Context context = textView.getContext();
            m.checkNotNullExpressionValue(context, "context");
            charSequenceH = b.h(context, i, new Object[0], null, 4);
        }
        textView.setText(charSequenceH);
        DrawableCompat.setCompoundDrawablesCompat$default(textView, channel == null ? 0 : i2, 0, 0, 0, 14, (Object) null);
    }

    private final void configureIcon(String guildShortName, String iconOriginal, String iconUpdated, boolean stateShouldUpdate) {
        boolean z2 = true;
        if (!this.hasOpenedAvatarPicker && getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_OPEN_AVATAR_PICKER, false)) {
            openAvatarPicker(guildShortName, iconOriginal);
        }
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().c.d;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.header.serverSettingsOverviewIcon");
            statefulViews.put(simpleDraweeView.getId(), iconUpdated != null ? iconUpdated : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().c.d;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.header.serverSettingsOverviewIcon");
            iconUpdated = (String) statefulViews2.get(simpleDraweeView2.getId(), iconOriginal);
        }
        getBinding().c.d.setOnClickListener(new WidgetServerSettingsOverview$configureIcon$1(this, guildShortName, iconOriginal));
        SimpleDraweeView simpleDraweeView3 = getBinding().c.d;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.header.serverSettingsOverviewIcon");
        IconUtils.setIcon$default(simpleDraweeView3, iconUpdated, 2131165289, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
        if (iconUpdated != null && !t.isBlank(iconUpdated)) {
            z2 = false;
        }
        TextView textView = getBinding().c.f140b;
        m.checkNotNullExpressionValue(textView, "binding.header.iconLabel");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = getBinding().c.e;
        m.checkNotNullExpressionValue(textView2, "binding.header.serverSettingsOverviewIconRemove");
        textView2.setVisibility(z2 ^ true ? 0 : 8);
        getBinding().c.e.setOnClickListener(new WidgetServerSettingsOverview$configureIcon$2(this, guildShortName, iconOriginal));
        TextView textView3 = getBinding().c.f;
        m.checkNotNullExpressionValue(textView3, "binding.header.serverSettingsOverviewIconText");
        textView3.setVisibility(z2 ? 0 : 8);
        TextView textView4 = getBinding().c.f;
        m.checkNotNullExpressionValue(textView4, "binding.header.serverSettingsOverviewIconText");
        textView4.setText(guildShortName);
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureRadios(int stateId, int activeRadioIndex, boolean isAboveNotifyAllSize, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            this.state.put(stateId, Integer.valueOf(activeRadioIndex));
        }
        int i = 0;
        for (Object obj : n.listOf((Object[]) new CheckedSetting[]{getBinding().d.f147b, getBinding().d.c})) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            m.checkNotNullExpressionValue(checkedSetting, "checkedSetting");
            checkedSetting.setChecked(i == activeRadioIndex);
            if (isAboveNotifyAllSize && checkedSetting.getId() == 2131365240) {
                checkedSetting.h(b.k(this, 2131891092, new Object[0], null, 4), false);
            } else {
                checkedSetting.h(null, false);
            }
            checkedSetting.setOnCheckedListener(new WidgetServerSettingsOverview$configureRadios$$inlined$forEachIndexed$lambda$1(i, this, activeRadioIndex, isAboveNotifyAllSize, stateId));
            i = i2;
        }
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureSplashImage(String splashOriginalUrl, String splashUpdatedUrl, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().i.e;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.uploadSplash.uploadSplash");
            statefulViews.put(simpleDraweeView.getId(), splashUpdatedUrl != null ? splashUpdatedUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().i.e;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadSplash.uploadSplash");
            splashUpdatedUrl = (String) statefulViews2.get(simpleDraweeView2.getId(), splashOriginalUrl);
        }
        getBinding().i.f174b.setOnClickListener(new WidgetServerSettingsOverview$configureSplashImage$1(this, splashOriginalUrl));
        SimpleDraweeView simpleDraweeView3 = getBinding().i.e;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadSplash.uploadSplash");
        IconUtils.setIcon$default(simpleDraweeView3, splashUpdatedUrl, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        TextView textView = getBinding().i.d;
        m.checkNotNullExpressionValue(textView, "binding.uploadSplash.ser…verviewUploadSplashRemove");
        textView.setVisibility((splashUpdatedUrl == null || t.isBlank(splashUpdatedUrl)) ^ true ? 0 : 8);
        getBinding().i.d.setOnClickListener(new WidgetServerSettingsOverview$configureSplashImage$2(this, splashOriginalUrl));
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureSplashSection(Guild guild) {
        boolean z2 = true;
        if (!guild.canHaveSplash()) {
            TextView textView = getBinding().i.g;
            m.checkNotNullExpressionValue(textView, "binding.uploadSplash.uploadSplashNitroTier");
            b.m(textView, 2131891311, new Object[]{"1", "tierInfo"}, new WidgetServerSettingsOverview$configureSplashSection$1(guild));
            TextView textView2 = getBinding().i.g;
            m.checkNotNullExpressionValue(textView2, "binding.uploadSplash.uploadSplashNitroTier");
            textView2.setVisibility(0);
            FloatingActionButton floatingActionButton = getBinding().i.c;
            m.checkNotNullExpressionValue(floatingActionButton, "binding.uploadSplash.ser…gsOverviewUploadSplashFab");
            ViewExtensions.setEnabledAlpha$default(floatingActionButton, false, 0.0f, 2, null);
            int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guild.getId(), 1, null, null, 12, null) - guild.getPremiumSubscriptionCount();
            Resources resources = getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), R$plurals.guild_settings_overview_boost_unlock_boosts, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default));
            TextView textView3 = getBinding().i.h;
            m.checkNotNullExpressionValue(textView3, "binding.uploadSplash.uploadSplashUnlock");
            ViewExtensions.setTextAndVisibilityBy(textView3, b.k(this, 2131891309, new Object[]{quantityString}, null, 4));
            TextView textView4 = getBinding().i.h;
            m.checkNotNullExpressionValue(textView4, "binding.uploadSplash.uploadSplashUnlock");
            DrawableCompat.setCompoundDrawablesCompat$default(textView4, 0, 2131231999, 0, 0, 13, (Object) null);
            getBinding().i.h.setTextColor(ColorCompat.getThemedColor(requireContext(), 2130969978));
            getBinding().i.e.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), 2130969991));
            getBinding().i.g.setOnClickListener(new WidgetServerSettingsOverview$configureSplashSection$2(guild));
            return;
        }
        TextView textView5 = getBinding().i.g;
        m.checkNotNullExpressionValue(textView5, "binding.uploadSplash.uploadSplashNitroTier");
        textView5.setVisibility(8);
        getBinding().i.e.setBackgroundResource(2131231117);
        TextView textView6 = getBinding().i.h;
        m.checkNotNullExpressionValue(textView6, "binding.uploadSplash.uploadSplashUnlock");
        b.n(textView6, 2131891310, new Object[]{"1"}, null, 4);
        TextView textView7 = getBinding().i.h;
        m.checkNotNullExpressionValue(textView7, "binding.uploadSplash.uploadSplashUnlock");
        DrawableCompat.setCompoundDrawablesCompat$default(textView7, 0, 2131232000, 0, 0, 13, (Object) null);
        getBinding().i.h.setTextColor(ColorCompat.getColor(requireContext(), 2131100487));
        TextView textView8 = getBinding().i.h;
        m.checkNotNullExpressionValue(textView8, "binding.uploadSplash.uploadSplashUnlock");
        String splash = guild.getSplash();
        if (splash != null && splash.length() != 0) {
            z2 = false;
        }
        textView8.setVisibility(z2 ? 0 : 8);
        IconUtils iconUtils = IconUtils.INSTANCE;
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        configureSplashImage(iconUtils.getGuildSplashUrl(guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null), null, false);
    }

    private final void configureSystemChannel(Channel selectedChannel) {
        TextView textView = getBinding().g.f153b;
        m.checkNotNullExpressionValue(textView, "binding.systemChannel.systemChannel");
        configureChannel(textView, selectedChannel, 2131893286, 2131231631);
    }

    private final void configureUI(WidgetServerSettingsOverview$Model widgetServerSettingsOverview$Model) {
        if (widgetServerSettingsOverview$Model == null || !widgetServerSettingsOverview$Model.getCanManage()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        configureIcon(widgetServerSettingsOverview$Model.getGuild().getShortName(), IconUtils.getForGuild$default(widgetServerSettingsOverview$Model.getGuild(), null, true, null, 10, null), null, false);
        TextInputLayout textInputLayout = getBinding().c.c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.header.overviewName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().c.c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.header.overviewName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), widgetServerSettingsOverview$Model.getGuild().getName()));
        StatefulViews statefulViews2 = this.state;
        TextView textView = getBinding().f2582b.f242b;
        m.checkNotNullExpressionValue(textView, "binding.afk.afkChannel");
        configureAfkChannel((Channel) statefulViews2.get(textView.getId(), widgetServerSettingsOverview$Model.getAfkChannelModel()));
        getBinding().f2582b.c.setOnClickListener(new WidgetServerSettingsOverview$configureUI$1(this, widgetServerSettingsOverview$Model));
        TextView textView2 = getBinding().f2582b.d;
        m.checkNotNullExpressionValue(textView2, "binding.afk.afkTimeout");
        StatefulViews statefulViews3 = this.state;
        TextView textView3 = getBinding().f2582b.d;
        m.checkNotNullExpressionValue(textView3, "binding.afk.afkTimeout");
        textView2.setText((CharSequence) statefulViews3.get(textView3.getId(), WidgetServerSettingsOverview$Model.Companion.getAfkTimeout(a.I(getBinding().f2582b.d, "binding.afk.afkTimeout", "binding.afk.afkTimeout.context"), widgetServerSettingsOverview$Model.getGuild().getAfkTimeout())));
        getBinding().f2582b.e.setOnClickListener(new WidgetServerSettingsOverview$configureUI$2(this));
        LinearLayout linearLayout = getBinding().f2582b.e;
        m.checkNotNullExpressionValue(linearLayout, "binding.afk.afkTimeoutWrap");
        linearLayout.setTag(Integer.valueOf(widgetServerSettingsOverview$Model.getGuild().getAfkTimeout()));
        StatefulViews statefulViews4 = this.state;
        TextView textView4 = getBinding().g.f153b;
        m.checkNotNullExpressionValue(textView4, "binding.systemChannel.systemChannel");
        configureSystemChannel((Channel) statefulViews4.get(textView4.getId(), widgetServerSettingsOverview$Model.getSystemChannelModel()));
        getBinding().g.f.setOnClickListener(new WidgetServerSettingsOverview$configureUI$3(this, widgetServerSettingsOverview$Model));
        LinearLayout linearLayout2 = getBinding().g.f;
        m.checkNotNullExpressionValue(linearLayout2, "binding.systemChannel.systemChannelWrap");
        StatefulViews statefulViews5 = this.state;
        LinearLayout linearLayout3 = getBinding().g.f;
        m.checkNotNullExpressionValue(linearLayout3, "binding.systemChannel.systemChannelWrap");
        linearLayout2.setTag(statefulViews5.get(linearLayout3.getId(), widgetServerSettingsOverview$Model.getGuild().getSystemChannelId()));
        configureRadios(STATE_ID_NOTIFICATION_DEFAULT, ((Number) this.state.get(STATE_ID_NOTIFICATION_DEFAULT, Integer.valueOf(widgetServerSettingsOverview$Model.getGuild().getDefaultMessageNotifications()))).intValue(), widgetServerSettingsOverview$Model.getIsAboveNotifyAllSize(), false);
        configureSplashSection(widgetServerSettingsOverview$Model.getGuild());
        configureBannerSection(widgetServerSettingsOverview$Model.getGuild());
        configureAnimatedBannerUpsellSection(widgetServerSettingsOverview$Model.getGuild());
        boolean z2 = (widgetServerSettingsOverview$Model.getGuild().getSystemChannelFlags() & 1) == 0;
        CheckedSetting checkedSetting = getBinding().g.d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelJoin");
        StatefulViews statefulViews6 = this.state;
        CheckedSetting checkedSetting2 = getBinding().g.d;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelJoin");
        checkedSetting.setChecked(((Boolean) statefulViews6.get(checkedSetting2.getId(), Boolean.valueOf(z2))).booleanValue());
        if (widgetServerSettingsOverview$Model.getSystemChannelModel() != null) {
            getBinding().g.d.e(new WidgetServerSettingsOverview$configureUI$4(this));
        } else {
            CheckedSetting.d(getBinding().g.d, null, 1);
        }
        boolean z3 = (widgetServerSettingsOverview$Model.getGuild().getSystemChannelFlags() & 2) == 0;
        CheckedSetting checkedSetting3 = getBinding().g.c;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelBoost");
        StatefulViews statefulViews7 = this.state;
        CheckedSetting checkedSetting4 = getBinding().g.c;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.systemChannel.systemChannelBoost");
        checkedSetting3.setChecked(((Boolean) statefulViews7.get(checkedSetting4.getId(), Boolean.valueOf(z3))).booleanValue());
        if (widgetServerSettingsOverview$Model.getSystemChannelModel() != null) {
            getBinding().g.c.e(new WidgetServerSettingsOverview$configureUI$5(this));
        } else {
            CheckedSetting.d(getBinding().g.c, null, 1);
        }
        boolean z4 = (widgetServerSettingsOverview$Model.getGuild().getSystemChannelFlags() & 8) == 0;
        CheckedSetting checkedSetting5 = getBinding().g.e;
        m.checkNotNullExpressionValue(checkedSetting5, "binding.systemChannel.systemChannelJoinReplies");
        StatefulViews statefulViews8 = this.state;
        CheckedSetting checkedSetting6 = getBinding().g.e;
        m.checkNotNullExpressionValue(checkedSetting6, "binding.systemChannel.systemChannelJoinReplies");
        checkedSetting5.setChecked(((Boolean) statefulViews8.get(checkedSetting6.getId(), Boolean.valueOf(z4))).booleanValue());
        if (widgetServerSettingsOverview$Model.getSystemChannelModel() != null) {
            getBinding().g.e.e(new WidgetServerSettingsOverview$configureUI$6(this));
        } else {
            CheckedSetting.d(getBinding().g.e, null, 1);
        }
        this.state.configureSaveActionView(getBinding().e);
        getBinding().e.setOnClickListener(new WidgetServerSettingsOverview$configureUI$7(this, widgetServerSettingsOverview$Model));
    }

    private final void configureUpdatedGuild(WidgetServerSettingsOverview$Model widgetServerSettingsOverview$Model) {
        StatefulViews.clear$default(this.state, false, 1, null);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        getBinding().f.fullScroll(33);
        configureUI(widgetServerSettingsOverview$Model);
        b.a.d.m.i(this, 2131895592, 0, 4);
    }

    public static final void create(Context context, long j, boolean z2) {
        Companion.create(context, j, z2);
    }

    private final WidgetServerSettingsOverviewBinding getBinding() {
        return (WidgetServerSettingsOverviewBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void openAvatarPicker(String guildShortName, String iconOriginal) {
        this.hasOpenedAvatarPicker = true;
        this.imageSelectedResult = new WidgetServerSettingsOverview$openAvatarPicker$1(this, guildShortName, iconOriginal);
        openMediaChooser();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.imageSelectedResult, ImageUploadDialog$PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.imageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().e;
        TextInputLayout textInputLayout = getBinding().c.c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.header.overviewName");
        TextView textView = getBinding().f2582b.d;
        m.checkNotNullExpressionValue(textView, "binding.afk.afkTimeout");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout, textView);
        StatefulViews statefulViews2 = this.state;
        TextView textView2 = getBinding().f2582b.f242b;
        m.checkNotNullExpressionValue(textView2, "binding.afk.afkChannel");
        TextView textView3 = getBinding().g.f153b;
        m.checkNotNullExpressionValue(textView3, "binding.systemChannel.systemChannel");
        statefulViews2.addOptionalFields(textView2, textView3);
        TextView textView4 = getBinding().c.f140b;
        m.checkNotNullExpressionValue(textView4, "binding.header.iconLabel");
        b.n(textView4, 2131893003, new Object[]{"128", "128"}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().i.f;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.uploadSplash.uploadSplashLearnMore");
        f fVar = f.a;
        b.n(linkifiedTextView, 2131891439, new Object[]{fVar.a(4415841146391L, null)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = getBinding().h.g;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.uploadBanner.uploadBannerLearnMore");
        b.n(linkifiedTextView2, 2131891053, new Object[]{fVar.a(360028716472L, null)}, null, 4);
        getBinding().e.hide();
        WidgetChannelSelector$Companion widgetChannelSelector$Companion = WidgetChannelSelector.Companion;
        widgetChannelSelector$Companion.registerForResult(this, REQUEST_KEY_AFK_CHANNEL, true, new WidgetServerSettingsOverview$onViewBound$1(this));
        widgetChannelSelector$Companion.registerForResult(this, REQUEST_KEY_SYSTEM_CHANNEL, true, new WidgetServerSettingsOverview$onViewBound$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        setActionBarTitle(2131893602);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsOverview$Model.Companion.get(getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), WidgetServerSettingsOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsOverview$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
