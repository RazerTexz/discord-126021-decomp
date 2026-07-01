package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import b.a.d.f;
import b.a.d.o;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEmailEditBinding;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.WidgetUserPasswordVerify$Companion;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAccountEmailEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEmailEditBinding;", 0)};
    public static final WidgetSettingsAccountEmailEdit$Companion Companion = new WidgetSettingsAccountEmailEdit$Companion(null);
    private static final String EXTRA_SHOULD_CONFIRM_EMAIL = "extra_should_confirm_email";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> nextScreenLauncher;
    private final StatefulViews state;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    public WidgetSettingsAccountEmailEdit() {
        super(R$layout.widget_settings_account_email_edit);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccountEmailEdit$binding$2.INSTANCE, null, 2, null);
        this.nextScreenLauncher = WidgetUserPasswordVerify.Companion.registerForResult(this, new WidgetSettingsAccountEmailEdit$nextScreenLauncher$1(this));
        this.state = new StatefulViews(R$id.edit_account_email_wrap);
        this.validationManager = g.lazy(new WidgetSettingsAccountEmailEdit$validationManager$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit, MeUser meUser) {
        widgetSettingsAccountEmailEdit.configureUI(meUser);
    }

    public static final /* synthetic */ WidgetSettingsAccountEmailEditBinding access$getBinding$p(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        return widgetSettingsAccountEmailEdit.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getNextScreenLauncher$p(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        return widgetSettingsAccountEmailEdit.nextScreenLauncher;
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        return widgetSettingsAccountEmailEdit.state;
    }

    public static final /* synthetic */ void access$showCodeVerification(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        widgetSettingsAccountEmailEdit.showCodeVerification();
    }

    public static final /* synthetic */ void access$showPasswordVerification(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        widgetSettingsAccountEmailEdit.showPasswordVerification();
    }

    private final void configureUI(MeUser meUser) {
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountEmailWrap");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountEmailWrap");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), meUser.getEmail()));
    }

    private final WidgetSettingsAccountEmailEditBinding getBinding() {
        return (WidgetSettingsAccountEmailEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void showCodeVerification() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().userEmail(), false, 1, null), this, null, 2, null), getBinding().f2599b, 0L, 2, null).k(o.j(new WidgetSettingsAccountEmailEdit$showCodeVerification$1(this), requireContext(), null, 4));
        }
    }

    private final void showPasswordVerification() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            WidgetUserPasswordVerify$Companion widgetUserPasswordVerify$Companion = WidgetUserPasswordVerify.Companion;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.nextScreenLauncher;
            TextInputLayout textInputLayout = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountEmailWrap");
            WidgetUserPasswordVerify$Companion.launchUpdateAccountSettings$default(widgetUserPasswordVerify$Companion, contextRequireContext, activityResultLauncher, ViewExtensions.getTextOrEmpty(textInputLayout), null, null, null, 56, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131896816);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        if (!getMostRecentIntent().getBooleanExtra(EXTRA_SHOULD_CONFIRM_EMAIL, false)) {
            TextInputLayout textInputLayout = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountEmailWrap");
            ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new WidgetSettingsAccountEmailEdit$onViewBound$3(this), 1, null);
            getBinding().f.setOnClickListener(new WidgetSettingsAccountEmailEdit$onViewBound$4(this));
            StatefulViews statefulViews = this.state;
            FloatingActionButton floatingActionButton = getBinding().f;
            TextInputLayout textInputLayout2 = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountEmailWrap");
            statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2);
            return;
        }
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.editAccountEmailWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout3, false, new WidgetSettingsAccountEmailEdit$onViewBound$1(this), 1, null);
        getBinding().e.setOnClickListener(new WidgetSettingsAccountEmailEdit$onViewBound$2(this));
        StatefulViews statefulViews2 = this.state;
        Button button = getBinding().e;
        TextInputLayout textInputLayout4 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.editAccountEmailWrap");
        statefulViews2.setupTextWatcherWithSaveAction(this, button, textInputLayout4);
        LinkifiedTextView linkifiedTextView = getBinding().c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.editAccountEmailDescription");
        linkifiedTextView.setVisibility(0);
        LinkifiedTextView linkifiedTextView2 = getBinding().c;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.editAccountEmailDescription");
        b.n(linkifiedTextView2, 2131896823, new Object[]{f.c()}, null, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.Companion.getUsers(), false, 1, null), this, null, 2, null), WidgetSettingsAccountEmailEdit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAccountEmailEdit$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
