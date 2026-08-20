package com.discord.widgets.servers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsSecurityBinding;
import com.discord.databinding.WidgetServerSettingsSecurityDialogBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsSecurity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsSecurityBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String TAG_TOGGLE_MFA_DIALOG = "TAG_TOGGLE_MFA_DIALOG";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("SECURITY", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            C0870j.m156d(context, WidgetServerSettingsSecurity.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long guildId;
        private final String guildName;
        private final boolean isMfaEnabled;

        /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11076j = Observable.m11076j(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), new Func2<MeUser, Guild, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsSecurity$Model$Companion$get$1
                    @Override // p658rx.functions.Func2
                    public final WidgetServerSettingsSecurity.Model call(MeUser meUser, Guild guild) {
                        if (meUser == null || guild == null || guild.getOwnerId() != meUser.getId()) {
                            return null;
                        }
                        return new WidgetServerSettingsSecurity.Model(guild.getId(), guild.getName(), guild.getMfaLevel() > 0);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n             …        )\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11076j).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n             …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(long j, String str, boolean z2) {
            this.guildId = j;
            this.guildName = str;
            this.isMfaEnabled = z2;
        }

        public static /* synthetic */ Model copy$default(Model model, long j, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = model.guildId;
            }
            if ((i & 2) != 0) {
                str = model.guildName;
            }
            if ((i & 4) != 0) {
                z2 = model.isMfaEnabled;
            }
            return model.copy(j, str, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsMfaEnabled() {
            return this.isMfaEnabled;
        }

        public final Model copy(long guildId, String guildName, boolean isMfaEnabled) {
            return new Model(guildId, guildName, isMfaEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.guildId == model.guildId && C12238m.areEqual(this.guildName, model.guildName) && this.isMfaEnabled == model.isMfaEnabled;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int iM3a = C0002b.m3a(this.guildId) * 31;
            String str = this.guildName;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isMfaEnabled;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final boolean isMfaEnabled() {
            return this.isMfaEnabled;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", guildName=");
            sbM833U.append(this.guildName);
            sbM833U.append(", isMfaEnabled=");
            return C1643a.m827O(sbM833U, this.isMfaEnabled, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
    public static final class ToggleMfaDialog extends AppDialog {
        private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
        private static final String ARG_MFA_ENABLED = "ARG_MFA_ENABLED";

        /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;

        /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
        private final Lazy guildId;

        /* JADX INFO: renamed from: mfaEnabled$delegate, reason: from kotlin metadata */
        private final Lazy mfaEnabled;
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(ToggleMfaDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", 0)};

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
        public static final class Companion {
            private Companion() {
            }

            public final void show(FragmentManager fragmentManager, long guildId, boolean mfaEnabled) {
                C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
                ToggleMfaDialog toggleMfaDialog = new ToggleMfaDialog();
                Bundle bundle = new Bundle();
                bundle.putLong(ToggleMfaDialog.ARG_GUILD_ID, guildId);
                bundle.putBoolean(ToggleMfaDialog.ARG_MFA_ENABLED, mfaEnabled);
                toggleMfaDialog.setArguments(bundle);
                toggleMfaDialog.show(fragmentManager, WidgetServerSettingsSecurity.TAG_TOGGLE_MFA_DIALOG);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ToggleMfaDialog() {
            super(C5419R.layout.widget_server_settings_security_dialog);
            this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2.INSTANCE, null, 2, null);
            this.guildId = C12083g.lazy(new WidgetServerSettingsSecurity$ToggleMfaDialog$guildId$2(this));
            this.mfaEnabled = C12083g.lazy(new WidgetServerSettingsSecurity$ToggleMfaDialog$mfaEnabled$2(this));
        }

        private final WidgetServerSettingsSecurityDialogBinding getBinding() {
            return (WidgetServerSettingsSecurityDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        private final long getGuildId() {
            return ((Number) this.guildId.getValue()).longValue();
        }

        private final boolean getMfaEnabled() {
            return ((Boolean) this.mfaEnabled.getValue()).booleanValue();
        }

        public final void configure(final long guildId, final boolean mfaEnabled) {
            if (guildId <= 0) {
                dismiss();
            }
            getBinding().f17757c.setText(mfaEnabled ? C5419R.string.disable : C5419R.string.enable);
            MaterialButton materialButton = getBinding().f17757c;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.serverSettingsSecurityDialogConfirm");
            WidgetServerSettingsSecurityDialogBinding binding = getBinding();
            C12238m.checkNotNullExpressionValue(binding, "binding");
            LinearLayout linearLayout = binding.f17755a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(linearLayout.getContext(), mfaEnabled ? C5419R.color.status_red_500 : C5419R.color.status_green_600)));
            getBinding().f17757c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1

                /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1$1 */
                /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
                public static final class C93091 extends AbstractC12240o implements Function1<Void, Unit> {
                    public C93091() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                        invoke2(r1);
                        return Unit.f27425a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Void r1) {
                        WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1.this.this$0.dismiss();
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i = !mfaEnabled ? 1 : 0;
                    TextInputLayout textInputLayout = this.this$0.getBinding().f17758d;
                    C12238m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsSecurityServerMfaCode");
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().setMfaLevel(guildId, new RestAPIParams.GuildMFA(i, ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this.this$0, null, 2, null), (Class<?>) this.this$0.getClass(), (58 & 2) != 0 ? null : this.this$0.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93091());
                }
            });
            getBinding().f17756b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsSecurity$ToggleMfaDialog$configure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.dismiss();
                }
            });
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialog) {
            C12238m.checkNotNullParameter(dialog, "dialog");
            super.onDismiss(dialog);
            AppDialog.hideKeyboard$default(this, null, 1, null);
        }

        @Override // com.discord.app.AppDialog
        public void onViewBoundOrOnResume() {
            super.onViewBoundOrOnResume();
            configure(getGuildId(), getMfaEnabled());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsSecurity$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
    public static final /* synthetic */ class C93111 extends C12236k implements Function1<Model, Unit> {
        public C93111(WidgetServerSettingsSecurity widgetServerSettingsSecurity) {
            super(1, widgetServerSettingsSecurity, WidgetServerSettingsSecurity.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            ((WidgetServerSettingsSecurity) this.receiver).configureUI(model);
        }
    }

    public WidgetServerSettingsSecurity() {
        super(C5419R.layout.widget_server_settings_security);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsSecurity$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetServerSettingsSecurity$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsSecurity$loggingConfig$1.INSTANCE, 3);
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
        setActionBarTitle(C5419R.string.security);
        setActionBarSubtitle(model.getGuildName());
        if (model.isMfaEnabled()) {
            getBinding().f17754c.setText(C5419R.string.guild_security_req_mfa_turn_off);
            MaterialButton materialButton = getBinding().f17754c;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.serverSettingsSecurityToggleMfaButton");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), C5419R.color.status_red_500)));
        } else {
            getBinding().f17754c.setText(C5419R.string.guild_security_req_mfa_turn_on);
            MaterialButton materialButton2 = getBinding().f17754c;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.serverSettingsSecurityToggleMfaButton");
            materialButton2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), C5419R.color.status_green_600)));
        }
        Fragment fragmentFindFragmentByTag = getParentFragmentManager().findFragmentByTag(TAG_TOGGLE_MFA_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            ((ToggleMfaDialog) fragmentFindFragmentByTag).configure(model.getGuildId(), model.isMfaEnabled());
        }
        getBinding().f17754c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsSecurity.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToggleMfaDialog.Companion companion = ToggleMfaDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetServerSettingsSecurity.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, model.getGuildId(), model.isMfaEnabled());
            }
        });
    }

    private final WidgetServerSettingsSecurityBinding getBinding() {
        return (WidgetServerSettingsSecurityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
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
        Fragment fragmentFindFragmentByTag = getParentFragmentManager().findFragmentByTag(TAG_TOGGLE_MFA_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            getParentFragmentManager().beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        TextView textView = getBinding().f17753b;
        C12238m.checkNotNullExpressionValue(textView, "binding.mfaDescriptionText");
        C1107b.m221m(textView, C5419R.string.guild_security_req_mfa_body, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), (Class<?>) WidgetServerSettingsSecurity.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93111(this));
    }
}
