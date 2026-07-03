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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEmailEditConfirmBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelEmailChangeConfirm;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsAccountEmailEditConfirm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent();
            intent.putExtra(WidgetSettingsAccountEmailEditConfirm.EXTRA_EMAIL, email);
            C0870j.f524g.m160f(context, launcher, WidgetSettingsAccountEmailEditConfirm.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function0<Unit> callback) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    C12238m.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() == -1) {
                        callback.invoke();
                    }
                }
            });
            C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$configureUI$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class C97631 extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$configureUI$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
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
                C12238m.checkNotNullParameter(view, "it");
                WidgetSettingsAccountEmailEditConfirm.this.resendVerificationCode();
            }
        }

        public C97631() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("onResend", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class C97641 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C97641() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            C12238m.checkNotNullParameter(textView, "it");
            WidgetSettingsAccountEmailEditConfirm.this.submitVerificationCode();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class C97661 extends AbstractC12240o implements Function1<MeUser, Unit> {
        public C97661() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            C12238m.checkNotNullParameter(meUser, "it");
            WidgetSettingsAccountEmailEditConfirm.this.configureUI(meUser);
        }
    }

    public WidgetSettingsAccountEmailEditConfirm() {
        super(C5419R.layout.widget_settings_account_email_edit_confirm);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccountEmailEditConfirm$binding$2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetSettingsAccountEmailEditConfirm$passwordVerifyLauncher$1(this));
    }

    private final void configureUI(MeUser meUser) {
        TextView textView = getBinding().f17843d;
        C12238m.checkNotNullExpressionValue(textView, "binding.editAccountEmailConfirmDescription");
        C1107b.m221m(textView, C5419R.string.user_settings_account_change_email_confirm_description, new Object[]{meUser.getEmail()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinkifiedTextView linkifiedTextView = getBinding().f17844e;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccountConfirmResend");
        C1107b.m221m(linkifiedTextView, C5419R.string.user_settings_account_change_email_confirm_resend, new Object[0], new C97631());
    }

    private final WidgetSettingsAccountEmailEditConfirmBinding getBinding() {
        return (WidgetSettingsAccountEmailEditConfirmBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void resendVerificationCode() {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmail(), false, 1, null), this, null, 2, null).m11108k(C0879o.m183j(new Action1<Void>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm.resendVerificationCode.1
            @Override // p658rx.functions.Action1
            public final void call(Void r5) {
                C0876m.m169g(WidgetSettingsAccountEmailEditConfirm.this.requireContext(), C5419R.string.user_settings_account_change_email_confirm_code_sent, 0, null, 12);
            }
        }, requireContext(), null, 4));
    }

    private final void submitVerificationCode() {
        TextInputLayout textInputLayout = getBinding().f17842c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmailVerifyCode(new RestAPIParams.UserEmailConfirmCode(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this, null, 2, null), getBinding().f17841b, 0L, 2, null).m11108k(C0879o.m183j(new Action1<ModelEmailChangeConfirm>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm.submitVerificationCode.1
            @Override // p658rx.functions.Action1
            public final void call(ModelEmailChangeConfirm modelEmailChangeConfirm) {
                WidgetUserPasswordVerify.INSTANCE.launchUpdateAccountSettings(WidgetSettingsAccountEmailEditConfirm.this.requireContext(), WidgetSettingsAccountEmailEditConfirm.this.passwordVerifyLauncher, (56 & 4) != 0 ? null : WidgetSettingsAccountEmailEditConfirm.this.getMostRecentIntent().getStringExtra(WidgetSettingsAccountEmailEditConfirm.EXTRA_EMAIL), (56 & 8) != 0 ? null : null, (56 & 16) != 0 ? null : null, (56 & 32) != 0 ? null : modelEmailChangeConfirm != null ? modelEmailChangeConfirm.getToken() : null);
            }
        }, requireContext(), null, 4));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.user_settings_account_change_email_confirm_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f17842c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C97641(), 1, null);
        getBinding().f17845f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccountEmailEditConfirm.this.submitVerificationCode();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), (Class<?>) WidgetSettingsAccountEmailEditConfirm.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97661());
    }
}
