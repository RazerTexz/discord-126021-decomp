package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsEditIntegrationBinding;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.servers.WidgetServerSettingsEditIntegration;
import com.discord.widgets.servers.WidgetServerSettingsEditRole;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration extends AppFragment {
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_INTEGRATION_ID = "INTENT_EXTRA_INTEGRATION_ID";
    private static final int STATE_KEY_ENABLE_TWITCH_EMOTES = 2131363149;
    private static final int STATE_KEY_EXPIRE_BEHAVIOR = 2131363152;
    private static final int STATE_KEY_GRACE_PERIOD = 2131363153;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager expiryBehaviorRadioManager;

    /* JADX INFO: renamed from: expiryBehaviorRadios$delegate, reason: from kotlin metadata */
    private final Lazy expiryBehaviorRadios;
    private RadioManager gracePeriodRadioManager;

    /* JADX INFO: renamed from: gracePeriodRadios$delegate, reason: from kotlin metadata */
    private final Lazy gracePeriodRadios;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEditIntegration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEditIntegrationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] gracePeriodDays = {1, 3, 7, 14, 30};

    /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long guildId, long integrationId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetServerSettingsEditIntegration.INTENT_EXTRA_INTEGRATION_ID, integrationId);
            AppScreen2.d(context, WidgetServerSettingsEditIntegration.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final ModelGuildIntegration integration;
        private final GuildRole role;

        /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, long integrationId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableG = Observable.g(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getGuilds().observeRoles(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuildIntegrations().get(guildId, integrationId), new Func5<MeUser, Guild, Map<Long, ? extends GuildRole>, Long, ModelGuildIntegration, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$Model$Companion$get$1
                    @Override // rx.functions.Func5
                    public /* bridge */ /* synthetic */ WidgetServerSettingsEditIntegration.Model call(MeUser meUser, Guild guild, Map<Long, ? extends GuildRole> map, Long l, ModelGuildIntegration modelGuildIntegration) {
                        return call2(meUser, guild, (Map<Long, GuildRole>) map, l, modelGuildIntegration);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetServerSettingsEditIntegration.Model call2(MeUser meUser, Guild guild, Map<Long, GuildRole> map, Long l, ModelGuildIntegration modelGuildIntegration) {
                        if (guild == null || map == null || l == null || modelGuildIntegration == null) {
                            return null;
                        }
                        GuildRole guildRole = map.get(Long.valueOf(modelGuildIntegration.getRoleId()));
                        if (modelGuildIntegration.isEnabled() && PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel())) {
                            return new WidgetServerSettingsEditIntegration.Model(guild, modelGuildIntegration, guildRole);
                        }
                        return null;
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…  }\n          }\n        }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, ModelGuildIntegration modelGuildIntegration, GuildRole guildRole) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(modelGuildIntegration, "integration");
            this.guild = guild;
            this.integration = modelGuildIntegration;
            this.role = guildRole;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, ModelGuildIntegration modelGuildIntegration, GuildRole guildRole, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                modelGuildIntegration = model.integration;
            }
            if ((i & 4) != 0) {
                guildRole = model.role;
            }
            return model.copy(guild, modelGuildIntegration, guildRole);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ModelGuildIntegration getIntegration() {
            return this.integration;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        public final Model copy(Guild guild, ModelGuildIntegration integration, GuildRole role) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(integration, "integration");
            return new Model(guild, integration, role);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.integration, model.integration) && Intrinsics3.areEqual(this.role, model.role);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final ModelGuildIntegration getIntegration() {
            return this.integration;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            ModelGuildIntegration modelGuildIntegration = this.integration;
            int iHashCode2 = (iHashCode + (modelGuildIntegration != null ? modelGuildIntegration.hashCode() : 0)) * 31;
            GuildRole guildRole = this.role;
            return iHashCode2 + (guildRole != null ? guildRole.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", integration=");
            sbU.append(this.integration);
            sbU.append(", role=");
            sbU.append(this.role);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
            super(1, widgetServerSettingsEditIntegration, WidgetServerSettingsEditIntegration.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetServerSettingsEditIntegration) this.receiver).configureUI(model);
        }
    }

    public WidgetServerSettingsEditIntegration() {
        super(R.layout.widget_server_settings_edit_integration);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEditIntegration3.INSTANCE, null, 2, null);
        this.expiryBehaviorRadios = LazyJVM.lazy(new WidgetServerSettingsEditIntegration4(this));
        this.gracePeriodRadios = LazyJVM.lazy(new WidgetServerSettingsEditIntegration5(this));
        this.state = new StatefulViews(R.id.edit_integration_custom_emotes_toggle, R.id.edit_integration_expired_sub_container, R.id.edit_integration_grace_period_container);
    }

    public static final /* synthetic */ RadioManager access$getExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        RadioManager radioManager = widgetServerSettingsEditIntegration.expiryBehaviorRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("expiryBehaviorRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ RadioManager access$getGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        RadioManager radioManager = widgetServerSettingsEditIntegration.gracePeriodRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gracePeriodRadioManager");
        }
        return radioManager;
    }

    private final void configureUI(final Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setActionBarTitle(R.string.integration_settings);
        setActionBarSubtitle(model.getGuild().getName());
        boolean zAreEqual = Intrinsics3.areEqual(model.getIntegration().getType(), "twitch");
        TextView textView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.editIntegrationName");
        textView.setText(model.getIntegration().getDisplayName());
        TextView textView2 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.editIntegrationOwnerName");
        textView2.setText(model.getIntegration().getUser().getUsername());
        getBinding().l.setImageResource(zAreEqual ? R.drawable.asset_account_sync_twitch : R.drawable.asset_account_sync_youtube);
        getBinding().p.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditIntegration.configureUI.1

            /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
            public static final class C03071 extends Lambda implements Function1<Void, Unit> {
                public C03071() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r5) {
                    DimmerView.setDimmed$default(WidgetServerSettingsEditIntegration.this.getBinding().f2560b, true, false, 2, null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().syncIntegration(model.getGuild().getId(), model.getIntegration().getId()), false, 1, null), WidgetServerSettingsEditIntegration.this, null, 2, null);
                Class<?> cls = WidgetServerSettingsEditIntegration.this.getClass();
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                ObservableExtensionsKt.appSubscribe(observableUi$default, (Class<?>) cls, (58 & 2) != 0 ? null : view.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C03071());
            }
        });
        DimmerView.setDimmed$default(getBinding().f2560b, model.getIntegration().isSyncing(), false, 2, null);
        TextView textView3 = getBinding().p.f96b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.syncSettings.editIntegrationLastSyncTime");
        WidgetServerSettingsEditIntegrationBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        CoordinatorLayout coordinatorLayout = binding.a;
        Intrinsics3.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
        Context context = coordinatorLayout.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        textView3.setText(TimeUtils.toReadableTimeString$default(context, TimeUtils.parseUTCDate(model.getIntegration().getSyncedAt()), null, 4, null));
        TextView textView4 = getBinding().p.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.syncSettings.edi…ntegrationSubscriberCount");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        WidgetServerSettingsEditIntegrationBinding binding2 = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding2, "binding");
        CoordinatorLayout coordinatorLayout2 = binding2.a;
        Intrinsics3.checkNotNullExpressionValue(coordinatorLayout2, "binding.root");
        Context context2 = coordinatorLayout2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "binding.root.context");
        textView4.setText(FormatUtils.g(StringResourceUtils.getQuantityString(resources, context2, zAreEqual ? R.plurals.num_subscribers_subscribers : R.plurals.num_members_subscribers, model.getIntegration().getSubscriberCount(), Integer.valueOf(model.getIntegration().getSubscriberCount())), new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null));
        getBinding().p.f.setOnClickListener(model.getRole() != null ? new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditIntegration.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsEditRole.Companion companion = WidgetServerSettingsEditRole.INSTANCE;
                long id2 = model.getGuild().getId();
                long id3 = model.getRole().getId();
                Intrinsics3.checkNotNullExpressionValue(view, "v");
                Context context3 = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context3, "v.context");
                companion.launch(id2, id3, context3);
            }
        } : null);
        TextView textView5 = getBinding().p.e;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.syncSettings.editIntegrationSyncedRole");
        textView5.setText(model.getRole() != null ? model.getRole().getName() : "None");
        getBinding().p.e.setTextColor(RoleUtils.getOpaqueColor(model.getRole(), ColorCompat.getColor(this, R.color.primary_300)));
        int iIntValue = ((Number) this.state.get(R.id.edit_integration_expired_sub_container, Integer.valueOf(model.getIntegration().getExpireBehavior()))).intValue();
        RadioManager radioManager = this.expiryBehaviorRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("expiryBehaviorRadioManager");
        }
        radioManager.a(getExpiryBehaviorRadios().get(iIntValue));
        int iIntValue2 = ((Number) this.state.get(R.id.edit_integration_grace_period_container, Integer.valueOf(getGracePeriodPosition(model.getIntegration().getExpireGracePeriod())))).intValue();
        RadioManager radioManager2 = this.gracePeriodRadioManager;
        if (radioManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gracePeriodRadioManager");
        }
        radioManager2.a(getGracePeriodRadios().get(iIntValue2));
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.editIntegrationCustomEmotesContainer");
        linearLayout.setVisibility(zAreEqual ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
        StatefulViews statefulViews = this.state;
        CheckedSetting checkedSetting2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.editIntegrationCustomEmotesToggle");
        checkedSetting.setChecked(((Boolean) statefulViews.get(checkedSetting2.getId(), Boolean.valueOf(model.getIntegration().isEnableEmoticons()))).booleanValue());
        this.state.configureSaveActionView(getBinding().o);
        getBinding().o.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditIntegration.configureUI.3

            /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
            public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r1) {
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int iB = WidgetServerSettingsEditIntegration.access$getExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration.this).b();
                int i = WidgetServerSettingsEditIntegration.gracePeriodDays[WidgetServerSettingsEditIntegration.access$getGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration.this).b()];
                CheckedSetting checkedSetting3 = WidgetServerSettingsEditIntegration.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.editIntegrationCustomEmotesToggle");
                Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuildIntegration(model.getGuild().getId(), model.getIntegration().getId(), new RestAPIParams.GuildIntegration(iB, i, checkedSetting3.isChecked())), false, 1, null), WidgetServerSettingsEditIntegration.this, null, 2, null);
                Class<?> cls = WidgetServerSettingsEditIntegration.this.getClass();
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                ObservableExtensionsKt.appSubscribe(observableUi$default, (Class<?>) cls, (58 & 2) != 0 ? null : view.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
            }
        });
    }

    private final WidgetServerSettingsEditIntegrationBinding getBinding() {
        return (WidgetServerSettingsEditIntegrationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExpiryBehaviorRadios() {
        return (List) this.expiryBehaviorRadios.getValue();
    }

    private final int getGracePeriodPosition(int gracePeriodDays2) {
        if (gracePeriodDays2 == 1) {
            return 0;
        }
        if (gracePeriodDays2 == 3) {
            return 1;
        }
        if (gracePeriodDays2 == 7) {
            return 2;
        }
        if (gracePeriodDays2 != 14) {
            return gracePeriodDays2 != 30 ? 0 : 4;
        }
        return 3;
    }

    private final List<CheckedSetting> getGracePeriodRadios() {
        return (List) this.gracePeriodRadios.getValue();
    }

    private final RadioManager setupRadioManager(List<CheckedSetting> checkedSettings, final int stateKey) {
        final RadioManager radioManager = new RadioManager(checkedSettings);
        final int i = 0;
        for (Object obj : checkedSettings) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            final CheckedSetting checkedSetting = (CheckedSetting) obj;
            checkedSetting.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$setupRadioManager$$inlined$forEachIndexed$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    radioManager.a(checkedSetting);
                    this.state.put(stateKey, Integer.valueOf(i));
                    this.state.configureSaveActionView(this.getBinding().o);
                }
            });
            i = i2;
        }
        return radioManager;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        StoreStream.INSTANCE.getGuildIntegrations().onIntegrationScreenClosed();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.expiryBehaviorRadioManager = setupRadioManager(getExpiryBehaviorRadios(), R.id.edit_integration_expired_sub_container);
        this.gracePeriodRadioManager = setupRadioManager(getGracePeriodRadios(), R.id.edit_integration_grace_period_container);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.state.setupUnsavedChangesConfirmation(this);
        List<CheckedSetting> gracePeriodRadios = getGracePeriodRadios();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(gracePeriodRadios, 10));
        int i = 0;
        for (Object obj : gracePeriodRadios) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            Context context = checkedSetting.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "radio.context");
            int[] iArr = gracePeriodDays;
            checkedSetting.setText(StringResourceUtils.getQuantityString(resources, context, R.plurals.n_days_days, iArr[i], Integer.valueOf(iArr[i])));
            arrayList.add(Unit.a);
            i = i2;
        }
        getBinding().d.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditIntegration.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetServerSettingsEditIntegration.this.getBinding().d.toggle();
                StatefulViews statefulViews = WidgetServerSettingsEditIntegration.this.state;
                CheckedSetting checkedSetting2 = WidgetServerSettingsEditIntegration.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.editIntegrationCustomEmotesToggle");
                statefulViews.put(R.id.edit_integration_custom_emotes_toggle, Boolean.valueOf(checkedSetting2.isChecked()));
                WidgetServerSettingsEditIntegration.this.state.configureSaveActionView(WidgetServerSettingsEditIntegration.this.getBinding().o);
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_INTEGRATION_ID, -1L);
        StoreStream.INSTANCE.getGuildIntegrations().onIntegrationScreenOpened(longExtra);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra, longExtra2), this, null, 2, null), (Class<?>) WidgetServerSettingsEditIntegration.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
