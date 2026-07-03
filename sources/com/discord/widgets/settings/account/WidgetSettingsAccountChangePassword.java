package com.discord.widgets.settings.account;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.api.user.User;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountChangePasswordBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManagerKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetSettingsAccountChangePassword extends AppFragment {
    public static final String CURRENT_PASSWORD_FIELD = "password";
    public static final String MFA_FIELD = "mfa";
    public static final String NEW_PASSWORD_FIELD = "new_password";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GoogleSmartLockManager googleSmartLockManager;
    private final StatefulViews state;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsAccountChangePassword.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountChangePasswordBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsAccountChangePassword.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
    public static final class C97431 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C97431() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountChangePassword.this.getBinding().f17820c;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordCurrentPasswordInput");
            textInputLayout.setError(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
    public static final class C97442 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C97442() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountChangePassword.this.getBinding().f17821d;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordNewPasswordInput");
            textInputLayout.setError(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
    public static final class C97453 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C97453() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountChangePassword.this.getBinding().f17823f;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
            textInputLayout.setError(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
    public static final class C97461 extends AbstractC12240o implements Function1<MeUser, Unit> {
        public C97461() {
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
            WidgetSettingsAccountChangePassword.this.configureUI(meUser);
        }
    }

    public WidgetSettingsAccountChangePassword() {
        super(C5419R.layout.widget_settings_account_change_password);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccountChangePassword$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(C5419R.id.change_password_new_password_input);
        this.validationManager = C12083g.lazy(new WidgetSettingsAccountChangePassword$validationManager$2(this));
    }

    private final void configureUI(final MeUser meUser) {
        TextView textView = getBinding().f17824g;
        C12238m.checkNotNullExpressionValue(textView, "binding.changePasswordTwoFactorTitle");
        textView.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().f17823f;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
        textInputLayout.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        if (meUser.getMfaEnabled()) {
            ValidationManager validationManager = getValidationManager();
            TextInputLayout textInputLayout2 = getBinding().f17823f;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordTwoFactor");
            validationManager.addInput(new Input.TextInputLayoutInput(MFA_FIELD, textInputLayout2, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.two_fa_token_required)));
        } else {
            getValidationManager().removeInput(MFA_FIELD);
        }
        getBinding().f17822e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccountChangePassword.this.saveNewPassword(meUser);
            }
        });
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleError(Error error) {
        ValidationManager validationManager = getValidationManager();
        Error.Response response = error.getResponse();
        C12238m.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        C12238m.checkNotNullExpressionValue(messages, "error.response.messages");
        int size = validationManager.setErrors(messages).size();
        Error.Response response2 = error.getResponse();
        C12238m.checkNotNullExpressionValue(response2, "error.response");
        error.setShowErrorToasts(!(size < response2.getMessages().size()));
    }

    private final void saveNewPassword(MeUser meUser) {
        String textOrEmpty;
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            if (meUser.getMfaEnabled()) {
                TextInputLayout textInputLayout = getBinding().f17823f;
                C12238m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
                textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            } else {
                textOrEmpty = null;
            }
            TextInputLayout textInputLayout2 = getBinding().f17820c;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordCurrentPasswordInput");
            String textOrEmpty2 = ViewExtensions.getTextOrEmpty(textInputLayout2);
            TextInputLayout textInputLayout3 = getBinding().f17821d;
            C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.changePasswordNewPasswordInput");
            final String textOrEmpty3 = ViewExtensions.getTextOrEmpty(textInputLayout3);
            RestAPIParams.UserInfo userInfo = new RestAPIParams.UserInfo(null, null, null, textOrEmpty2, textOrEmpty3, null, StoreStream.INSTANCE.getNotifications().getPushToken(), textOrEmpty, null, null, null, 1831, null);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            getBinding().f17822e.setIsLoading(true);
            ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().patchUser(userInfo), false, 1, null), this, null, 2, null), getBinding().f17825h, 0L, 2, null).m11108k(C0879o.m181h(new Action1<User>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword.saveNewPassword.1
                @Override // p658rx.functions.Action1
                public final void call(User user) {
                    GoogleSmartLockManager googleSmartLockManager;
                    Context context = WidgetSettingsAccountChangePassword.this.getContext();
                    if (context != null && (googleSmartLockManager = GoogleSmartLockManagerKt.googleSmartLockManager(context)) != null) {
                        googleSmartLockManager.updateAccountInfo(null, textOrEmpty3);
                    }
                    StoreStream.INSTANCE.getAuthentication().onPasswordChanged(user.getToken());
                    WidgetSettingsAccountChangePassword.this.onChangePasswordSuccess();
                }
            }, requireContext(), new Action1<Error>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword.saveNewPassword.2
                @Override // p658rx.functions.Action1
                public final void call(Error error) {
                    WidgetSettingsAccountChangePassword.this.getBinding().f17822e.setIsLoading(false);
                    WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword = WidgetSettingsAccountChangePassword.this;
                    C12238m.checkNotNullExpressionValue(error, "error");
                    widgetSettingsAccountChangePassword.handleError(error);
                }
            }));
        }
    }

    public final WidgetSettingsAccountChangePasswordBinding getBinding() {
        return (WidgetSettingsAccountChangePasswordBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public void onChangePasswordSuccess() {
        C0876m.m171i(this, C5419R.string.saved_settings, 0, 4);
        FragmentActivity fragmentActivityM95e = m95e();
        if (fragmentActivityM95e != null) {
            fragmentActivityM95e.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Context context = view.getContext();
        C12238m.checkNotNullExpressionValue(context, "view.context");
        this.googleSmartLockManager = new GoogleSmartLockManager(context, null, 2, null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.state.setupUnsavedChangesConfirmation(this);
        getBinding().f17822e.setIsLoading(false);
        getBinding().f17822e.setText(getText(C5419R.string.change_password));
        TextInputLayout textInputLayout = getBinding().f17820c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordCurrentPasswordInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C97431());
        TextInputLayout textInputLayout2 = getBinding().f17821d;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordNewPasswordInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C97442());
        TextInputLayout textInputLayout3 = getBinding().f17823f;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.changePasswordTwoFactor");
        ViewExtensions.addBindedTextWatcher(textInputLayout3, this, new C97453());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97461());
    }
}
