package com.discord.widgets.user.email;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserEmailUpdateBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserEmailUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailUpdate extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUserEmailUpdate.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetUserEmailUpdate.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void launch$default(Companion companion, Context context, WidgetUserAccountVerifyBase.Mode mode, ActivityResultLauncher activityResultLauncher, int i, Object obj) {
            if ((i & 4) != 0) {
                activityResultLauncher = null;
            }
            companion.launch(context, mode, activityResultLauncher);
        }

        public final void launch(Context context, WidgetUserAccountVerifyBase.Mode mode, ActivityResultLauncher<Intent> launcher) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(mode, "mode");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, false, true);
            if (launcher != null) {
                C0870j.f524g.m160f(context, launcher, WidgetUserEmailUpdate.class, launchIntent);
            } else {
                C0870j.m156d(context, WidgetUserEmailUpdate.class, launchIntent);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function0<Unit> callback) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.user.email.WidgetUserEmailUpdate$Companion$registerForResult$1
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

    /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetUserEmailUpdate.kt */
    public static final class C102531 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C102531() {
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
            WidgetUserEmailUpdate.this.handleTextChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetUserEmailUpdate.kt */
    public static final class C102542 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C102542() {
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
            WidgetUserEmailUpdate.this.handleTextChanged();
        }
    }

    public WidgetUserEmailUpdate() {
        super(C5419R.layout.widget_user_email_update);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserEmailUpdate$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetUserEmailUpdateBinding getBinding() {
        return (WidgetUserEmailUpdateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0033  */
    private final void handleTextChanged() {
        boolean z2;
        TextInputLayout textInputLayout = getBinding().f18328d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangePassword");
        if (ViewExtensions.getTextOrEmpty(textInputLayout).length() >= 3) {
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            TextInputLayout textInputLayout2 = getBinding().f18327c;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangeEmail");
            if (pattern.matcher(ViewExtensions.getTextOrEmpty(textInputLayout2)).matches()) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        MaterialButton materialButton = getBinding().f18326b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.alertVerifyEmailChange");
        materialButton.setEnabled(z2);
    }

    private final void onEmailUpdated() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(-1);
        }
        AppActivity appActivity2 = getAppActivity();
        if (appActivity2 != null) {
            appActivity2.finish();
        }
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f18327c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangeEmail");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C102531());
        TextInputLayout textInputLayout2 = getBinding().f18328d;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangePassword");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C102542());
        getBinding().f18326b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.email.WidgetUserEmailUpdate.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RestAPI api = RestAPI.INSTANCE.getApi();
                RestAPIParams.UserInfo.Companion companion = RestAPIParams.UserInfo.INSTANCE;
                TextInputLayout textInputLayout3 = WidgetUserEmailUpdate.this.getBinding().f18327c;
                C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.alertVerifyEmailChangeEmail");
                String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout3);
                TextInputLayout textInputLayout4 = WidgetUserEmailUpdate.this.getBinding().f18328d;
                C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.alertVerifyEmailChangePassword");
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(api.patchUser(companion.createForEmail(textOrEmpty, ViewExtensions.getTextOrEmpty(textInputLayout4))), false, 1, null), WidgetUserEmailUpdate.this.getBinding().f18329e, 0L, 2, null), WidgetUserEmailUpdate.this, null, 2, null).m11108k(C0879o.m182i(new Action1<User>() { // from class: com.discord.widgets.user.email.WidgetUserEmailUpdate.onViewBound.3.1
                    @Override // p658rx.functions.Action1
                    public final void call(User user) {
                        WidgetUserEmailUpdate.this.onEmailUpdated();
                    }
                }, WidgetUserEmailUpdate.this));
            }
        });
    }
}
