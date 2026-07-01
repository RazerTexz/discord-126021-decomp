package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEmailEditConfirmBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelEmailChangeConfirm;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccountEmailEditConfirm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMAIL = "extra_email";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;

    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, ActivityResultLauncher activityResultLauncher, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                str = null;
            }
            companion.launch(context, activityResultLauncher, str);
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, String email) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent();
            intent.putExtra(WidgetSettingsAccountEmailEditConfirm.EXTRA_EMAIL, email);
            AppScreen2.g.f(context, launcher, WidgetSettingsAccountEmailEditConfirm.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() == -1) {
                        callback.invoke();
                    }
                }
            });
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
        public static final class C03351 extends Lambda implements Function1<View, Unit> {
            public C03351() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                WidgetSettingsAccountEmailEditConfirm.this.resendVerificationCode();
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onResend", new C03351());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetSettingsAccountEmailEditConfirm.this.submitVerificationCode();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<MeUser, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "it");
            WidgetSettingsAccountEmailEditConfirm.this.configureUI(meUser);
        }
    }

    public WidgetSettingsAccountEmailEditConfirm() {
        super(R.layout.widget_settings_account_email_edit_confirm);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountEmailEditConfirm3.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetSettingsAccountEmailEditConfirm4(this));
    }

    private final void configureUI(MeUser meUser) {
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.editAccountEmailConfirmDescription");
        FormatUtils.m(textView, R.string.user_settings_account_change_email_confirm_description, new Object[]{meUser.getEmail()}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinkifiedTextView linkifiedTextView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccountConfirmResend");
        FormatUtils.m(linkifiedTextView, R.string.user_settings_account_change_email_confirm_resend, new Object[0], new AnonymousClass1());
    }

    private final WidgetSettingsAccountEmailEditConfirmBinding getBinding() {
        return (WidgetSettingsAccountEmailEditConfirmBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void resendVerificationCode() {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmail(), false, 1, null), this, null, 2, null).k(o.j(new Action1<Void>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm.resendVerificationCode.1
            @Override // rx.functions.Action1
            public final void call(Void r5) {
                AppToast.g(WidgetSettingsAccountEmailEditConfirm.this.requireContext(), R.string.user_settings_account_change_email_confirm_code_sent, 0, null, 12);
            }
        }, requireContext(), null, 4));
    }

    private final void submitVerificationCode() {
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmailVerifyCode(new RestAPIParams.UserEmailConfirmCode(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this, null, 2, null), getBinding().f2600b, 0L, 2, null).k(o.j(new Action1<ModelEmailChangeConfirm>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm.submitVerificationCode.1
            @Override // rx.functions.Action1
            public final void call(ModelEmailChangeConfirm modelEmailChangeConfirm) {
                WidgetUserPasswordVerify.INSTANCE.launchUpdateAccountSettings(WidgetSettingsAccountEmailEditConfirm.this.requireContext(), WidgetSettingsAccountEmailEditConfirm.this.passwordVerifyLauncher, (56 & 4) != 0 ? null : WidgetSettingsAccountEmailEditConfirm.this.getMostRecentIntent().getStringExtra(WidgetSettingsAccountEmailEditConfirm.EXTRA_EMAIL), (56 & 8) != 0 ? null : null, (56 & 16) != 0 ? null : null, (56 & 32) != 0 ? null : modelEmailChangeConfirm != null ? modelEmailChangeConfirm.getToken() : null);
            }
        }, requireContext(), null, 4));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.user_settings_account_change_email_confirm_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass1(), 1, null);
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccountEmailEditConfirm.this.submitVerificationCode();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), (Class<?>) WidgetSettingsAccountEmailEditConfirm.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
