package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.user.User;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserPasswordVerifyBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManager3;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPasswordVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserPasswordVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
        public enum Action {
            UpdateAccountInfo,
            RemovePhoneNumber,
            UpdatePhoneNumber
        }

        private Companion() {
        }

        private final void launch(Context context, ActivityResultLauncher<Intent> launcher, Bundle extras) {
            AnalyticsTracker.openModal$default("Account Settings Password Verification", "", null, 4, null);
            AppScreen2.g.f(context, launcher, WidgetUserPasswordVerify.class, new Intent().putExtras(extras));
        }

        public final void launchRemovePhoneNumber(Context context, ActivityResultLauncher<Intent> launcher) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetUserPasswordVerify.INTENT_EXTRA_ACTION, Action.RemovePhoneNumber);
            launch(context, launcher, bundle);
        }

        public final void launchUpdateAccountSettings(Context context, ActivityResultLauncher<Intent> launcher, String email, String username, String discriminator, String email_token) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetUserPasswordVerify.INTENT_EXTRA_ACTION, Action.UpdateAccountInfo);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_EMAIL, email);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_USERNAME, username);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_DISCRIMINATOR, discriminator);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_EMAIL_TOKEN, email_token);
            launch(context, launcher, bundle);
        }

        public final void launchUpdatePhoneNumber(Context context, ActivityResultLauncher<Intent> launcher, String phoneToken, String source) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(phoneToken, "phoneToken");
            Intrinsics3.checkNotNullParameter(source, "source");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetUserPasswordVerify.INTENT_EXTRA_ACTION, Action.UpdatePhoneNumber);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_PHONE_TOKEN, phoneToken);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_SOURCE_TYPE, source);
            launch(context, launcher, bundle);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.user.WidgetUserPasswordVerify$Companion$registerForResult$1
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

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Companion.Action.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[Companion.Action.UpdateAccountInfo.ordinal()] = 1;
            iArr[Companion.Action.RemovePhoneNumber.ordinal()] = 2;
            iArr[Companion.Action.UpdatePhoneNumber.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
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
            WidgetUserPasswordVerify.this.saveInfo();
        }
    }

    public WidgetUserPasswordVerify() {
        super(R.layout.widget_user_password_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserPasswordVerify3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.edit_account_password_wrap);
        this.validationManager = LazyJVM.lazy(new WidgetUserPasswordVerify4(this));
    }

    private final void finishWithSuccess() {
        StatefulViews.clear$default(this.state, false, 1, null);
        AppToast.i(this, R.string.saved_settings, 0, 4);
        FragmentActivity fragmentActivityE = e();
        if (fragmentActivityE != null) {
            fragmentActivityE.setResult(-1);
        }
        FragmentActivity fragmentActivityE2 = e();
        if (fragmentActivityE2 != null) {
            fragmentActivityE2.onBackPressed();
        }
    }

    private final WidgetUserPasswordVerifyBinding getBinding() {
        return (WidgetUserPasswordVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final boolean maybeHandleApiError(Error error) {
        if (error.getType() != Error.Type.DISCORD_BAD_REQUEST) {
            return false;
        }
        ValidationManager validationManager = getValidationManager();
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
        return validationManager.setErrors(messages).isEmpty();
    }

    private final void removePhoneNumber(String password) {
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userPhoneDelete(new RestAPIParams.DeletePhone(password)), false, 1, null), this, null, 2, null), getBinding().f2686b, 0L, 2, null).k(o.h(new Action1<Void>() { // from class: com.discord.widgets.user.WidgetUserPasswordVerify.removePhoneNumber.1
            @Override // rx.functions.Action1
            public final void call(Void r1) {
                WidgetUserPasswordVerify.this.finishWithSuccess();
            }
        }, getContext(), new Action1<Error>() { // from class: com.discord.widgets.user.WidgetUserPasswordVerify.removePhoneNumber.2
            @Override // rx.functions.Action1
            public final void call(Error error) {
                WidgetUserPasswordVerify widgetUserPasswordVerify = WidgetUserPasswordVerify.this;
                Intrinsics3.checkNotNullExpressionValue(error, "it");
                error.setShowErrorToasts(!widgetUserPasswordVerify.maybeHandleApiError(error));
            }
        }));
    }

    private final void saveInfo() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            AppFragment.hideKeyboard$default(this, null, 1, null);
            TextInputLayout textInputLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountPasswordWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(INTENT_EXTRA_ACTION);
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.user.WidgetUserPasswordVerify.Companion.Action");
            int iOrdinal = ((Companion.Action) serializableExtra).ordinal();
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

    private final void updateAccountInfo(final String password) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_USERNAME);
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_DISCRIMINATOR);
        final String stringExtra3 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_EMAIL);
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().patchUser(new RestAPIParams.UserInfo(null, stringExtra3, getMostRecentIntent().getStringExtra(INTENT_EXTRA_EMAIL_TOKEN), password, null, stringExtra, StoreStream.INSTANCE.getNotifications().getPushToken(), null, stringExtra2, null, null, 1681, null)), false, 1, null), this, null, 2, null), getBinding().f2686b, 0L, 2, null).k(o.h(new Action1<User>() { // from class: com.discord.widgets.user.WidgetUserPasswordVerify.updateAccountInfo.1
            @Override // rx.functions.Action1
            public final void call(User user) {
                GoogleSmartLockManager googleSmartLockManager;
                StoreStream.INSTANCE.getAuthentication().setAuthed(user.getToken());
                Context context = WidgetUserPasswordVerify.this.getContext();
                if (context != null && (googleSmartLockManager = GoogleSmartLockManager3.googleSmartLockManager(context)) != null) {
                    googleSmartLockManager.updateAccountInfo(stringExtra3, password);
                }
                WidgetUserPasswordVerify.this.finishWithSuccess();
            }
        }, getContext(), new Action1<Error>() { // from class: com.discord.widgets.user.WidgetUserPasswordVerify.updateAccountInfo.2
            @Override // rx.functions.Action1
            public final void call(Error error) {
                WidgetUserPasswordVerify widgetUserPasswordVerify = WidgetUserPasswordVerify.this;
                Intrinsics3.checkNotNullExpressionValue(error, "it");
                error.setShowErrorToasts(!widgetUserPasswordVerify.maybeHandleApiError(error));
            }
        }));
    }

    private final void updatePhoneNumber(String password) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE_TOKEN);
        Intrinsics3.checkNotNull(stringExtra);
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…TENT_EXTRA_PHONE_TOKEN)!!");
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_SOURCE_TYPE);
        Intrinsics3.checkNotNull(stringExtra2);
        Intrinsics3.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…TENT_EXTRA_SOURCE_TYPE)!!");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userPhoneWithToken(new RestAPIParams.VerificationPhoneCode(stringExtra, password, stringExtra2)), false, 1, null), this, null, 2, null), getBinding().f2686b, 0L, 2, null).k(o.h(new Action1<Void>() { // from class: com.discord.widgets.user.WidgetUserPasswordVerify.updatePhoneNumber.1
            @Override // rx.functions.Action1
            public final void call(Void r1) {
                WidgetUserPasswordVerify.this.finishWithSuccess();
            }
        }, getContext(), new Action1<Error>() { // from class: com.discord.widgets.user.WidgetUserPasswordVerify.updatePhoneNumber.2
            @Override // rx.functions.Action1
            public final void call(Error error) {
                WidgetUserPasswordVerify widgetUserPasswordVerify = WidgetUserPasswordVerify.this;
                Intrinsics3.checkNotNullExpressionValue(error, "it");
                error.setShowErrorToasts(!widgetUserPasswordVerify.maybeHandleApiError(error));
            }
        }));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.user_settings_account_verify_password_title_in_title_case);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().d;
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountPasswordWrap");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountPasswordWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new AnonymousClass1(), 1, null);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserPasswordVerify.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserPasswordVerify.this.saveInfo();
            }
        });
    }
}
