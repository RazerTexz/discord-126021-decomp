package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsModerationBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.servers.WidgetServerSettingsModeration;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsModeration extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsModeration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String VERIFICATION_LEVEL_HIGH_MINUTES = "10";
    private static final String VERIFICATION_LEVEL_MEDIUM_MINUTES = "5";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;
    private RadioManager radioManagerExplicit;
    private RadioManager radioManagerVerification;

    /* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("MODERATION", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsModeration.class, intentPutExtra);
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
                Observable observableI = Observable.i(companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), new Func3<Guild, MeUser, Long, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsModeration$Model$Companion$get$1
                    @Override // rx.functions.Func3
                    public final WidgetServerSettingsModeration.Model call(Guild guild, MeUser meUser, Long l) {
                        Intrinsics3.checkNotNullParameter(meUser, "me");
                        if (guild == null) {
                            return null;
                        }
                        if (guild.isOwner(meUser.getId()) || PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel())) {
                            return new WidgetServerSettingsModeration.Model(guild);
                        }
                        return null;
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n             …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
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
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new Model(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && Intrinsics3.areEqual(this.guild, ((Model) other).guild);
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
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsModeration widgetServerSettingsModeration) {
            super(1, widgetServerSettingsModeration, WidgetServerSettingsModeration.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetServerSettingsModeration) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$updateGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            AppToast.i(WidgetServerSettingsModeration.this, R.string.server_settings_updated, 0, 4);
        }
    }

    public WidgetServerSettingsModeration() {
        super(R.layout.widget_server_settings_moderation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsModeration3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsModeration4(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsModeration5.INSTANCE, 3);
    }

    private final void configureExplicitContentRadio(final Model model, CheckedSetting radio, final GuildExplicitContentFilter explicitContentLevel) {
        RadioManager radioManager;
        if (!model.getGuild().getFeatures().contains(GuildFeature.COMMUNITY) || explicitContentLevel.compareTo(GuildExplicitContentFilter.ALL) >= 0) {
            radio.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsModeration.configureExplicitContentRadio.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetServerSettingsModeration.this.updateGuild(model.getGuild().getId(), RestAPIParams.UpdateGuild.INSTANCE.createForExplicitContentFilter(explicitContentLevel));
                }
            });
        } else {
            radio.b(R.string.tooltip_community_feature_disabled);
        }
        if (this.radioManagerExplicit == null || model.getGuild().getExplicitContentFilter() != explicitContentLevel || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.a(radio);
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
            radio.b(R.string.tooltip_community_feature_disabled);
        } else {
            radio.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsModeration.configureVerificationLevelRadio.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetServerSettingsModeration.this.updateGuild(model.getGuild().getId(), RestAPIParams.UpdateGuild.INSTANCE.createForVerificationLevel(verificationLevel));
                }
            });
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
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationExplicit1");
        CheckedSetting checkedSetting2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationExplicit2");
        CheckedSetting checkedSetting3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationExplicit3");
        return Collections2.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final List<CheckedSetting> getVerificationViews() {
        CheckedSetting checkedSetting = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationVerification1");
        CheckedSetting checkedSetting2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationVerification2");
        CheckedSetting checkedSetting3 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationVerification3");
        CheckedSetting checkedSetting4 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.serverSettingsModerationVerification4");
        CheckedSetting checkedSetting5 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.serverSettingsModerationVerification5");
        return Collections2.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, checkedSetting5});
    }

    private final void updateGuild(long guildId, RestAPIParams.UpdateGuild updateGuild) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuild(guildId, updateGuild), false, 1, null), this, null, 2, null), (Class<?>) WidgetServerSettingsModeration.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.moderation);
        TextView textView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsModerationVerificationHelp");
        FormatUtils.m(textView, R.string.form_help_verification_level, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsModerationExplicitHelp");
        FormatUtils.m(textView2, R.string.form_help_explicit_content_filter, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        this.radioManagerVerification = new RadioManager(getVerificationViews());
        this.radioManagerExplicit = new RadioManager(getExplicitContentViews());
        CheckedSetting.i(getVerificationViews().get(2), FormatUtils.e(this, R.string.verification_level_medium_criteria, new Object[]{VERIFICATION_LEVEL_MEDIUM_MINUTES}, (4 & 4) != 0 ? FormatUtils.a.j : null), false, 2);
        CheckedSetting.i(getVerificationViews().get(3), FormatUtils.e(this, R.string.verification_level_high_criteria, new Object[]{VERIFICATION_LEVEL_HIGH_MINUTES}, (4 & 4) != 0 ? FormatUtils.a.j : null), false, 2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), (Class<?>) WidgetServerSettingsModeration.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
