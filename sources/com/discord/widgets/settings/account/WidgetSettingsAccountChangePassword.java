package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.o;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountChangePasswordBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams$UserInfo;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input$TextInputLayoutInput;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAccountChangePassword.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountChangePasswordBinding;", 0)};
    public static final WidgetSettingsAccountChangePassword$Companion Companion = new WidgetSettingsAccountChangePassword$Companion(null);

    public WidgetSettingsAccountChangePassword() {
        super(R$layout.widget_settings_account_change_password);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccountChangePassword$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R$id.change_password_new_password_input);
        this.validationManager = g.lazy(new WidgetSettingsAccountChangePassword$validationManager$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword, MeUser meUser) {
        widgetSettingsAccountChangePassword.configureUI(meUser);
    }

    public static final /* synthetic */ void access$handleError(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword, Error error) {
        widgetSettingsAccountChangePassword.handleError(error);
    }

    public static final /* synthetic */ void access$saveNewPassword(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword, MeUser meUser) {
        widgetSettingsAccountChangePassword.saveNewPassword(meUser);
    }

    private final void configureUI(MeUser meUser) {
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.changePasswordTwoFactorTitle");
        textView.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
        textInputLayout.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        if (meUser.getMfaEnabled()) {
            ValidationManager validationManager = getValidationManager();
            TextInputLayout textInputLayout2 = getBinding().f;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordTwoFactor");
            validationManager.addInput(new Input$TextInputLayoutInput(MFA_FIELD, textInputLayout2, BasicTextInputValidator.Companion.createRequiredInputValidator(2131896542)));
        } else {
            getValidationManager().removeInput(MFA_FIELD);
        }
        getBinding().e.setOnClickListener(new WidgetSettingsAccountChangePassword$configureUI$1(this, meUser));
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleError(Error error) {
        ValidationManager validationManager = getValidationManager();
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        m.checkNotNullExpressionValue(messages, "error.response.messages");
        int size = validationManager.setErrors(messages).size();
        Error$Response response2 = error.getResponse();
        m.checkNotNullExpressionValue(response2, "error.response");
        error.setShowErrorToasts(!(size < response2.getMessages().size()));
    }

    private final void saveNewPassword(MeUser meUser) {
        String textOrEmpty;
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            if (meUser.getMfaEnabled()) {
                TextInputLayout textInputLayout = getBinding().f;
                m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
                textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            } else {
                textOrEmpty = null;
            }
            TextInputLayout textInputLayout2 = getBinding().c;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordCurrentPasswordInput");
            String textOrEmpty2 = ViewExtensions.getTextOrEmpty(textInputLayout2);
            TextInputLayout textInputLayout3 = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout3, "binding.changePasswordNewPasswordInput");
            String textOrEmpty3 = ViewExtensions.getTextOrEmpty(textInputLayout3);
            RestAPIParams$UserInfo restAPIParams$UserInfo = new RestAPIParams$UserInfo(null, null, null, textOrEmpty2, textOrEmpty3, null, StoreStream.Companion.getNotifications().getPushToken(), textOrEmpty, null, null, null, 1831, null);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            getBinding().e.setIsLoading(true);
            ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().patchUser(restAPIParams$UserInfo), false, 1, null), this, null, 2, null), getBinding().h, 0L, 2, null).k(o.h(new WidgetSettingsAccountChangePassword$saveNewPassword$1(this, textOrEmpty3), requireContext(), new WidgetSettingsAccountChangePassword$saveNewPassword$2(this)));
        }
    }

    public final WidgetSettingsAccountChangePasswordBinding getBinding() {
        return (WidgetSettingsAccountChangePasswordBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public void onChangePasswordSuccess() {
        b.a.d.m.i(this, 2131895235, 0, 4);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        this.googleSmartLockManager = new GoogleSmartLockManager(context, null, 2, null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.state.setupUnsavedChangesConfirmation(this);
        getBinding().e.setIsLoading(false);
        getBinding().e.setText(getText(2131887525));
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordCurrentPasswordInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetSettingsAccountChangePassword$onViewBound$1(this));
        TextInputLayout textInputLayout2 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordNewPasswordInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new WidgetSettingsAccountChangePassword$onViewBound$2(this));
        TextInputLayout textInputLayout3 = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.changePasswordTwoFactor");
        ViewExtensions.addBindedTextWatcher(textInputLayout3, this, new WidgetSettingsAccountChangePassword$onViewBound$3(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.Companion.getUsers(), false, 1, null), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAccountChangePassword$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
