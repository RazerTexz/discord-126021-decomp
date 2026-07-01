package com.discord.widgets.servers;

import a0.a.a.b;
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
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsSecurityBinding;
import com.discord.databinding.WidgetServerSettingsSecurityDialogBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.WidgetServerSettingsSecurity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsSecurity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsSecurityBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String TAG_TOGGLE_MFA_DIALOG = "TAG_TOGGLE_MFA_DIALOG";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("SECURITY", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsSecurity.class, intentPutExtra);
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
                Observable observableJ = Observable.j(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), new Func2<MeUser, Guild, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsSecurity$Model$Companion$get$1
                    @Override // rx.functions.Func2
                    public final WidgetServerSettingsSecurity.Model call(MeUser meUser, Guild guild) {
                        if (meUser == null || guild == null || guild.getOwnerId() != meUser.getId()) {
                            return null;
                        }
                        return new WidgetServerSettingsSecurity.Model(guild.getId(), guild.getName(), guild.getMfaLevel() > 0);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n             …        )\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableJ).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
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
            return this.guildId == model.guildId && Intrinsics3.areEqual(this.guildName, model.guildName) && this.isMfaEnabled == model.isMfaEnabled;
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
            int iA = b.a(this.guildId) * 31;
            String str = this.guildName;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
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
            StringBuilder sbU = outline.U("Model(guildId=");
            sbU.append(this.guildId);
            sbU.append(", guildName=");
            sbU.append(this.guildName);
            sbU.append(", isMfaEnabled=");
            return outline.O(sbU, this.isMfaEnabled, ")");
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
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(ToggleMfaDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", 0)};

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
        public static final class Companion {
            private Companion() {
            }

            public final void show(FragmentManager fragmentManager, long guildId, boolean mfaEnabled) {
                Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
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
            super(R.layout.widget_server_settings_security_dialog);
            this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2.INSTANCE, null, 2, null);
            this.guildId = LazyJVM.lazy(new WidgetServerSettingsSecurity$ToggleMfaDialog$guildId$2(this));
            this.mfaEnabled = LazyJVM.lazy(new WidgetServerSettingsSecurity$ToggleMfaDialog$mfaEnabled$2(this));
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
            getBinding().c.setText(mfaEnabled ? R.string.disable : R.string.enable);
            MaterialButton materialButton = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverSettingsSecurityDialogConfirm");
            WidgetServerSettingsSecurityDialogBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            LinearLayout linearLayout = binding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(linearLayout.getContext(), mfaEnabled ? R.color.status_red_500 : R.color.status_green_600)));
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1

                /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
                public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
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
                        WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1.this.this$0.dismiss();
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i = !mfaEnabled ? 1 : 0;
                    TextInputLayout textInputLayout = this.this$0.getBinding().d;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsSecurityServerMfaCode");
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().setMfaLevel(guildId, new RestAPIParams.GuildMFA(i, ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this.this$0, null, 2, null), (Class<?>) this.this$0.getClass(), (58 & 2) != 0 ? null : this.this$0.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
                }
            });
            getBinding().f2587b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsSecurity$ToggleMfaDialog$configure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.dismiss();
                }
            });
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialog) {
            Intrinsics3.checkNotNullParameter(dialog, "dialog");
            super.onDismiss(dialog);
            AppDialog.hideKeyboard$default(this, null, 1, null);
        }

        @Override // com.discord.app.AppDialog
        public void onViewBoundOrOnResume() {
            super.onViewBoundOrOnResume();
            configure(getGuildId(), getMfaEnabled());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsSecurity$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsSecurity widgetServerSettingsSecurity) {
            super(1, widgetServerSettingsSecurity, WidgetServerSettingsSecurity.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            ((WidgetServerSettingsSecurity) this.receiver).configureUI(model);
        }
    }

    public WidgetServerSettingsSecurity() {
        super(R.layout.widget_server_settings_security);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsSecurity$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsSecurity$guildId$2(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsSecurity$loggingConfig$1.INSTANCE, 3);
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
        setActionBarTitle(R.string.security);
        setActionBarSubtitle(model.getGuildName());
        if (model.isMfaEnabled()) {
            getBinding().c.setText(R.string.guild_security_req_mfa_turn_off);
            MaterialButton materialButton = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverSettingsSecurityToggleMfaButton");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), R.color.status_red_500)));
        } else {
            getBinding().c.setText(R.string.guild_security_req_mfa_turn_on);
            MaterialButton materialButton2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.serverSettingsSecurityToggleMfaButton");
            materialButton2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), R.color.status_green_600)));
        }
        Fragment fragmentFindFragmentByTag = getParentFragmentManager().findFragmentByTag(TAG_TOGGLE_MFA_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            ((ToggleMfaDialog) fragmentFindFragmentByTag).configure(model.getGuildId(), model.isMfaEnabled());
        }
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsSecurity.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToggleMfaDialog.Companion companion = ToggleMfaDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetServerSettingsSecurity.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        Fragment fragmentFindFragmentByTag = getParentFragmentManager().findFragmentByTag(TAG_TOGGLE_MFA_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            getParentFragmentManager().beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        TextView textView = getBinding().f2586b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mfaDescriptionText");
        FormatUtils.m(textView, R.string.guild_security_req_mfa_body, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), (Class<?>) WidgetServerSettingsSecurity.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
