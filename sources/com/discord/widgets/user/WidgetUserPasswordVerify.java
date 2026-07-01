package com.discord.widgets.user;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.m;
import b.a.d.o;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserPasswordVerifyBinding;
import com.discord.restapi.RestAPIParams$DeletePhone;
import com.discord.restapi.RestAPIParams$UserInfo;
import com.discord.restapi.RestAPIParams$VerificationPhoneCode;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.error.Error$Type;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPasswordVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserPasswordVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", 0)};
    public static final WidgetUserPasswordVerify$Companion Companion = new WidgetUserPasswordVerify$Companion(null);
    private static final String INTENT_EXTRA_ACTION = "INTENT_EXTRA_ACTION";
    private static final String INTENT_EXTRA_DISCRIMINATOR = "INTENT_EXTRA_DISCRIMINATOR";
    private static final String INTENT_EXTRA_EMAIL = "INTENT_EXTRA_EMAIL";
    private static final String INTENT_EXTRA_EMAIL_TOKEN = "INTENT_EXTRA_EMAIL_TOKEN";
    private static final String INTENT_EXTRA_PHONE_TOKEN = "INTENT_EXTRA_PHONE_TOKEN";
    private static final String INTENT_EXTRA_SOURCE_TYPE = "INTENT_EXTRA_SOURCE_TYPE";
    private static final String INTENT_EXTRA_USERNAME = "INTENT_EXTRA_USERNAME";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    public WidgetUserPasswordVerify() {
        super(R$layout.widget_user_password_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserPasswordVerify$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R$id.edit_account_password_wrap);
        this.validationManager = g.lazy(new WidgetUserPasswordVerify$validationManager$2(this));
    }

    public static final /* synthetic */ void access$finishWithSuccess(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        widgetUserPasswordVerify.finishWithSuccess();
    }

    public static final /* synthetic */ WidgetUserPasswordVerifyBinding access$getBinding$p(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        return widgetUserPasswordVerify.getBinding();
    }

    public static final /* synthetic */ boolean access$maybeHandleApiError(WidgetUserPasswordVerify widgetUserPasswordVerify, Error error) {
        return widgetUserPasswordVerify.maybeHandleApiError(error);
    }

    public static final /* synthetic */ void access$saveInfo(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        widgetUserPasswordVerify.saveInfo();
    }

    private final void finishWithSuccess() {
        StatefulViews.clear$default(this.state, false, 1, null);
        m.i(this, 2131895235, 0, 4);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
    }

    private final WidgetUserPasswordVerifyBinding getBinding() {
        return (WidgetUserPasswordVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final boolean maybeHandleApiError(Error error) {
        if (error.getType() != Error$Type.DISCORD_BAD_REQUEST) {
            return false;
        }
        ValidationManager validationManager = getValidationManager();
        Error$Response response = error.getResponse();
        d0.z.d.m.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        d0.z.d.m.checkNotNullExpressionValue(messages, "error.response.messages");
        return validationManager.setErrors(messages).isEmpty();
    }

    private final void removePhoneNumber(String password) {
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().userPhoneDelete(new RestAPIParams$DeletePhone(password)), false, 1, null), this, null, 2, null), getBinding().f2686b, 0L, 2, null).k(o.h(new WidgetUserPasswordVerify$removePhoneNumber$1(this), getContext(), new WidgetUserPasswordVerify$removePhoneNumber$2(this)));
    }

    private final void saveInfo() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            AppFragment.hideKeyboard$default(this, null, 1, null);
            TextInputLayout textInputLayout = getBinding().c;
            d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountPasswordWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(INTENT_EXTRA_ACTION);
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.user.WidgetUserPasswordVerify.Companion.Action");
            int iOrdinal = ((WidgetUserPasswordVerify$Companion$Action) serializableExtra).ordinal();
            if (iOrdinal == 0) {
                updateAccountInfo(textOrEmpty);
            } else if (iOrdinal == 1) {
                removePhoneNumber(textOrEmpty);
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                updatePhoneNumber(textOrEmpty);
            }
        }
    }

    private final void updateAccountInfo(String password) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_USERNAME);
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_DISCRIMINATOR);
        String stringExtra3 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_EMAIL);
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().patchUser(new RestAPIParams$UserInfo(null, stringExtra3, getMostRecentIntent().getStringExtra(INTENT_EXTRA_EMAIL_TOKEN), password, null, stringExtra, StoreStream.Companion.getNotifications().getPushToken(), null, stringExtra2, null, null, 1681, null)), false, 1, null), this, null, 2, null), getBinding().f2686b, 0L, 2, null).k(o.h(new WidgetUserPasswordVerify$updateAccountInfo$1(this, stringExtra3, password), getContext(), new WidgetUserPasswordVerify$updateAccountInfo$2(this)));
    }

    private final void updatePhoneNumber(String password) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE_TOKEN);
        d0.z.d.m.checkNotNull(stringExtra);
        d0.z.d.m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…TENT_EXTRA_PHONE_TOKEN)!!");
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_SOURCE_TYPE);
        d0.z.d.m.checkNotNull(stringExtra2);
        d0.z.d.m.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…TENT_EXTRA_SOURCE_TYPE)!!");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().userPhoneWithToken(new RestAPIParams$VerificationPhoneCode(stringExtra, password, stringExtra2)), false, 1, null), this, null, 2, null), getBinding().f2686b, 0L, 2, null).k(o.h(new WidgetUserPasswordVerify$updatePhoneNumber$1(this), getContext(), new WidgetUserPasswordVerify$updatePhoneNumber$2(this)));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131896838);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().d;
        TextInputLayout textInputLayout = getBinding().c;
        d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountPasswordWrap");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
        TextInputLayout textInputLayout2 = getBinding().c;
        d0.z.d.m.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountPasswordWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new WidgetUserPasswordVerify$onViewBound$1(this), 1, null);
        getBinding().d.setOnClickListener(new WidgetUserPasswordVerify$onViewBound$2(this));
    }
}
