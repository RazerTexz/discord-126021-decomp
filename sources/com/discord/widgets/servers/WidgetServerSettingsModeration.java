package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsModerationBinding;
import com.discord.restapi.RestAPIParams$UpdateGuild;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import d0.g;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsModeration extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsModeration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", 0)};
    public static final WidgetServerSettingsModeration$Companion Companion = new WidgetServerSettingsModeration$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String VERIFICATION_LEVEL_HIGH_MINUTES = "10";
    private static final String VERIFICATION_LEVEL_MEDIUM_MINUTES = "5";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;
    private RadioManager radioManagerExplicit;
    private RadioManager radioManagerVerification;

    public WidgetServerSettingsModeration() {
        super(R$layout.widget_server_settings_moderation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsModeration$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetServerSettingsModeration$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsModeration$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsModeration widgetServerSettingsModeration, WidgetServerSettingsModeration$Model widgetServerSettingsModeration$Model) {
        widgetServerSettingsModeration.configureUI(widgetServerSettingsModeration$Model);
    }

    public static final /* synthetic */ void access$updateGuild(WidgetServerSettingsModeration widgetServerSettingsModeration, long j, RestAPIParams$UpdateGuild restAPIParams$UpdateGuild) {
        widgetServerSettingsModeration.updateGuild(j, restAPIParams$UpdateGuild);
    }

    private final void configureExplicitContentRadio(WidgetServerSettingsModeration$Model model, CheckedSetting radio, GuildExplicitContentFilter explicitContentLevel) {
        RadioManager radioManager;
        if (!model.getGuild().getFeatures().contains(GuildFeature.COMMUNITY) || explicitContentLevel.compareTo(GuildExplicitContentFilter.ALL) >= 0) {
            radio.e(new WidgetServerSettingsModeration$configureExplicitContentRadio$1(this, model, explicitContentLevel));
        } else {
            radio.b(2131896462);
        }
        if (this.radioManagerExplicit == null || model.getGuild().getExplicitContentFilter() != explicitContentLevel || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final void configureUI(WidgetServerSettingsModeration$Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setActionBarSubtitle(model.getGuild().getName());
        configureVerificationLevelRadio(model, getVerificationViews().get(0), GuildVerificationLevel.NONE);
        configureVerificationLevelRadio(model, getVerificationViews().get(1), GuildVerificationLevel.LOW);
        configureVerificationLevelRadio(model, getVerificationViews().get(2), GuildVerificationLevel.MEDIUM);
        configureVerificationLevelRadio(model, getVerificationViews().get(3), GuildVerificationLevel.HIGH);
        configureVerificationLevelRadio(model, getVerificationViews().get(4), GuildVerificationLevel.HIGHEST);
        configureExplicitContentRadio(model, getExplicitContentViews().get(0), GuildExplicitContentFilter.NONE);
        configureExplicitContentRadio(model, getExplicitContentViews().get(1), GuildExplicitContentFilter.SOME);
        configureExplicitContentRadio(model, getExplicitContentViews().get(2), GuildExplicitContentFilter.ALL);
    }

    private final void configureVerificationLevelRadio(WidgetServerSettingsModeration$Model model, CheckedSetting radio, GuildVerificationLevel verificationLevel) {
        RadioManager radioManager;
        if (model.getGuild().getFeatures().contains(GuildFeature.COMMUNITY) && verificationLevel == GuildVerificationLevel.NONE) {
            radio.b(2131896462);
        } else {
            radio.e(new WidgetServerSettingsModeration$configureVerificationLevelRadio$1(this, model, verificationLevel));
        }
        if (this.radioManagerVerification == null || model.getGuild().getVerificationLevel() != verificationLevel || (radioManager = this.radioManagerVerification) == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final WidgetServerSettingsModerationBinding getBinding() {
        return (WidgetServerSettingsModerationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExplicitContentViews() {
        CheckedSetting checkedSetting = getBinding().f2580b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationExplicit1");
        CheckedSetting checkedSetting2 = getBinding().c;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationExplicit2");
        CheckedSetting checkedSetting3 = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationExplicit3");
        return n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final List<CheckedSetting> getVerificationViews() {
        CheckedSetting checkedSetting = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationVerification1");
        CheckedSetting checkedSetting2 = getBinding().g;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationVerification2");
        CheckedSetting checkedSetting3 = getBinding().h;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationVerification3");
        CheckedSetting checkedSetting4 = getBinding().i;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.serverSettingsModerationVerification4");
        CheckedSetting checkedSetting5 = getBinding().j;
        m.checkNotNullExpressionValue(checkedSetting5, "binding.serverSettingsModerationVerification5");
        return n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, checkedSetting5});
    }

    private final void updateGuild(long guildId, RestAPIParams$UpdateGuild updateGuild) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateGuild(guildId, updateGuild), false, 1, null), this, null, 2, null), WidgetServerSettingsModeration.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsModeration$updateGuild$1(this), 60, (Object) null);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131893064);
        TextView textView = getBinding().k;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsModerationVerificationHelp");
        b.n(textView, 2131889122, new Object[0], null, 4);
        TextView textView2 = getBinding().e;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsModerationExplicitHelp");
        b.n(textView2, 2131889094, new Object[0], null, 4);
        this.radioManagerVerification = new RadioManager(getVerificationViews());
        this.radioManagerExplicit = new RadioManager(getExplicitContentViews());
        CheckedSetting.i(getVerificationViews().get(2), b.k(this, 2131897046, new Object[]{VERIFICATION_LEVEL_MEDIUM_MINUTES}, null, 4), false, 2);
        CheckedSetting.i(getVerificationViews().get(3), b.k(this, 2131897042, new Object[]{VERIFICATION_LEVEL_HIGH_MINUTES}, null, 4), false, 2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsModeration$Model.Companion.get(getGuildId()), this, null, 2, null), WidgetServerSettingsModeration.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsModeration$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
