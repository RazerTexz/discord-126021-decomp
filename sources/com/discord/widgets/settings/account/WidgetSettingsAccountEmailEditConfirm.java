package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import b.a.d.o;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEmailEditConfirmBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams$UserEmailConfirmCode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAccountEmailEditConfirm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", 0)};
    public static final WidgetSettingsAccountEmailEditConfirm$Companion Companion = new WidgetSettingsAccountEmailEditConfirm$Companion(null);
    private static final String EXTRA_EMAIL = "extra_email";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;

    public WidgetSettingsAccountEmailEditConfirm() {
        super(R$layout.widget_settings_account_email_edit_confirm);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccountEmailEditConfirm$binding$2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.Companion.registerForResult(this, new WidgetSettingsAccountEmailEditConfirm$passwordVerifyLauncher$1(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm, MeUser meUser) {
        widgetSettingsAccountEmailEditConfirm.configureUI(meUser);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPasswordVerifyLauncher$p(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        return widgetSettingsAccountEmailEditConfirm.passwordVerifyLauncher;
    }

    public static final /* synthetic */ void access$resendVerificationCode(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        widgetSettingsAccountEmailEditConfirm.resendVerificationCode();
    }

    public static final /* synthetic */ void access$submitVerificationCode(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        widgetSettingsAccountEmailEditConfirm.submitVerificationCode();
    }

    private final void configureUI(MeUser meUser) {
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.editAccountEmailConfirmDescription");
        b.n(textView, 2131896804, new Object[]{meUser.getEmail()}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().e;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccountConfirmResend");
        b.m(linkifiedTextView, 2131896806, new Object[0], new WidgetSettingsAccountEmailEditConfirm$configureUI$1(this));
    }

    private final WidgetSettingsAccountEmailEditConfirmBinding getBinding() {
        return (WidgetSettingsAccountEmailEditConfirmBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void resendVerificationCode() {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().userEmail(), false, 1, null), this, null, 2, null).k(o.j(new WidgetSettingsAccountEmailEditConfirm$resendVerificationCode$1(this), requireContext(), null, 4));
    }

    private final void submitVerificationCode() {
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().userEmailVerifyCode(new RestAPIParams$UserEmailConfirmCode(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this, null, 2, null), getBinding().f2600b, 0L, 2, null).k(o.j(new WidgetSettingsAccountEmailEditConfirm$submitVerificationCode$1(this), requireContext(), null, 4));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131896808);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new WidgetSettingsAccountEmailEditConfirm$onViewBound$1(this), 1, null);
        getBinding().f.setOnClickListener(new WidgetSettingsAccountEmailEditConfirm$onViewBound$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.Companion.getUsers(), false, 1, null), this, null, 2, null), WidgetSettingsAccountEmailEditConfirm.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAccountEmailEditConfirm$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
