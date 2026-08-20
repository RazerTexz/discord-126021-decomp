package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsModerationBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsModeration extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsModeration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("MODERATION", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            C0870j.m156d(context, WidgetServerSettingsModeration.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;

        /* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11075i = Observable.m11075i(companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), new Func3<Guild, MeUser, Long, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsModeration$Model$Companion$get$1
                    @Override // p658rx.functions.Func3
                    public final WidgetServerSettingsModeration.Model call(Guild guild, MeUser meUser, Long l) {
                        C12238m.checkNotNullParameter(meUser, "me");
                        if (guild == null) {
                            return null;
                        }
                        if (guild.isOwner(meUser.getId()) || PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel())) {
                            return new WidgetServerSettingsModeration.Model(guild);
                        }
                        return null;
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11075i, "Observable\n             …        }\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11075i).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n             …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild) {
            C12238m.checkNotNullParameter(guild, "guild");
            this.guild = guild;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            return model.copy(guild);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Model copy(Guild guild) {
            C12238m.checkNotNullParameter(guild, "guild");
            return new Model(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && C12238m.areEqual(this.guild, ((Model) other).guild);
            }
            return true;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public int hashCode() {
            Guild guild = this.guild;
            if (guild != null) {
                return guild.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
    public static final /* synthetic */ class C92711 extends C12236k implements Function1<Model, Unit> {
        public C92711(WidgetServerSettingsModeration widgetServerSettingsModeration) {
            super(1, widgetServerSettingsModeration, WidgetServerSettingsModeration.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetServerSettingsModeration) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$updateGuild$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
    public static final class C92721 extends AbstractC12240o implements Function1<com.discord.api.guild.Guild, Unit> {
        public C92721() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            C12238m.checkNotNullParameter(guild, "it");
            C0876m.m171i(WidgetServerSettingsModeration.this, C5419R.string.server_settings_updated, 0, 4);
        }
    }

    public WidgetServerSettingsModeration() {
        super(C5419R.layout.widget_server_settings_moderation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsModeration$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetServerSettingsModeration$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsModeration$loggingConfig$1.INSTANCE, 3);
    }

    private final void configureExplicitContentRadio(final Model model, CheckedSetting radio, final GuildExplicitContentFilter explicitContentLevel) {
        RadioManager radioManager;
        if (!model.getGuild().getFeatures().contains(GuildFeature.COMMUNITY) || explicitContentLevel.compareTo(GuildExplicitContentFilter.ALL) >= 0) {
            radio.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsModeration.configureExplicitContentRadio.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetServerSettingsModeration.this.updateGuild(model.getGuild().getId(), RestAPIParams.UpdateGuild.INSTANCE.createForExplicitContentFilter(explicitContentLevel));
                }
            });
        } else {
            radio.m8525b(C5419R.string.tooltip_community_feature_disabled);
        }
        if (this.radioManagerExplicit == null || model.getGuild().getExplicitContentFilter() != explicitContentLevel || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.m8550a(radio);
    }

    private final void configureUI(Model model) {
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

    private final void configureVerificationLevelRadio(final Model model, CheckedSetting radio, final GuildVerificationLevel verificationLevel) {
        RadioManager radioManager;
        if (model.getGuild().getFeatures().contains(GuildFeature.COMMUNITY) && verificationLevel == GuildVerificationLevel.NONE) {
            radio.m8525b(C5419R.string.tooltip_community_feature_disabled);
        } else {
            radio.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsModeration.configureVerificationLevelRadio.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetServerSettingsModeration.this.updateGuild(model.getGuild().getId(), RestAPIParams.UpdateGuild.INSTANCE.createForVerificationLevel(verificationLevel));
                }
            });
        }
        if (this.radioManagerVerification == null || model.getGuild().getVerificationLevel() != verificationLevel || (radioManager = this.radioManagerVerification) == null) {
            return;
        }
        radioManager.m8550a(radio);
    }

    private final WidgetServerSettingsModerationBinding getBinding() {
        return (WidgetServerSettingsModerationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExplicitContentViews() {
        CheckedSetting checkedSetting = getBinding().f17714b;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationExplicit1");
        CheckedSetting checkedSetting2 = getBinding().f17715c;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationExplicit2");
        CheckedSetting checkedSetting3 = getBinding().f17716d;
        C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationExplicit3");
        return C12147n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final List<CheckedSetting> getVerificationViews() {
        CheckedSetting checkedSetting = getBinding().f17718f;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationVerification1");
        CheckedSetting checkedSetting2 = getBinding().f17719g;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationVerification2");
        CheckedSetting checkedSetting3 = getBinding().f17720h;
        C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationVerification3");
        CheckedSetting checkedSetting4 = getBinding().f17721i;
        C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.serverSettingsModerationVerification4");
        CheckedSetting checkedSetting5 = getBinding().f17722j;
        C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.serverSettingsModerationVerification5");
        return C12147n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, checkedSetting5});
    }

    private final void updateGuild(long guildId, RestAPIParams.UpdateGuild updateGuild) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuild(guildId, updateGuild), false, 1, null), this, null, 2, null), (Class<?>) WidgetServerSettingsModeration.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C92721());
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.moderation);
        TextView textView = getBinding().f17723k;
        C12238m.checkNotNullExpressionValue(textView, "binding.serverSettingsModerationVerificationHelp");
        C1107b.m221m(textView, C5419R.string.form_help_verification_level, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = getBinding().f17717e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.serverSettingsModerationExplicitHelp");
        C1107b.m221m(textView2, C5419R.string.form_help_explicit_content_filter, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        this.radioManagerVerification = new RadioManager(getVerificationViews());
        this.radioManagerExplicit = new RadioManager(getExplicitContentViews());
        CheckedSetting.m8524i(getVerificationViews().get(2), C1107b.m213e(this, C5419R.string.verification_level_medium_criteria, new Object[]{VERIFICATION_LEVEL_MEDIUM_MINUTES}, (4 & 4) != 0 ? C1107b.a.f1490j : null), false, 2);
        CheckedSetting.m8524i(getVerificationViews().get(3), C1107b.m213e(this, C5419R.string.verification_level_high_criteria, new Object[]{VERIFICATION_LEVEL_HIGH_MINUTES}, (4 & 4) != 0 ? C1107b.a.f1490j : null), false, 2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), (Class<?>) WidgetServerSettingsModeration.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C92711(this));
    }
}
