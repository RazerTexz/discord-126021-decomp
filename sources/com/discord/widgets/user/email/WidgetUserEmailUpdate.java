package com.discord.widgets.user.email;

import android.util.Patterns;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserEmailUpdateBinding;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import java.util.regex.Pattern;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUserEmailUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailUpdate extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserEmailUpdate.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", 0)};
    public static final WidgetUserEmailUpdate$Companion Companion = new WidgetUserEmailUpdate$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetUserEmailUpdate() {
        super(R$layout.widget_user_email_update);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserEmailUpdate$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetUserEmailUpdateBinding access$getBinding$p(WidgetUserEmailUpdate widgetUserEmailUpdate) {
        return widgetUserEmailUpdate.getBinding();
    }

    public static final /* synthetic */ void access$handleTextChanged(WidgetUserEmailUpdate widgetUserEmailUpdate) {
        widgetUserEmailUpdate.handleTextChanged();
    }

    public static final /* synthetic */ void access$onEmailUpdated(WidgetUserEmailUpdate widgetUserEmailUpdate) {
        widgetUserEmailUpdate.onEmailUpdated();
    }

    private final WidgetUserEmailUpdateBinding getBinding() {
        return (WidgetUserEmailUpdateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0033  */
    private final void handleTextChanged() {
        boolean z2;
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangePassword");
        if (ViewExtensions.getTextOrEmpty(textInputLayout).length() >= 3) {
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            TextInputLayout textInputLayout2 = getBinding().c;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangeEmail");
            if (pattern.matcher(ViewExtensions.getTextOrEmpty(textInputLayout2)).matches()) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        MaterialButton materialButton = getBinding().f2680b;
        m.checkNotNullExpressionValue(materialButton, "binding.alertVerifyEmailChange");
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangeEmail");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetUserEmailUpdate$onViewBound$1(this));
        TextInputLayout textInputLayout2 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangePassword");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new WidgetUserEmailUpdate$onViewBound$2(this));
        getBinding().f2680b.setOnClickListener(new WidgetUserEmailUpdate$onViewBound$3(this));
    }
}
