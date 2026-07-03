package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEditBinding;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.PremiumUtilsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p012b.C0811c;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsAccountUsernameEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;
    private final StatefulViews state;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsAccountUsernameEdit.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
    public static final class C97701 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C97701() {
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
            TextInputLayout textInputLayout = WidgetSettingsAccountUsernameEdit.this.getBinding().f17831b;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountDiscriminatorWrap");
            textInputLayout.setError(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
    public static final class C97712 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C97712() {
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
            WidgetSettingsAccountUsernameEdit.this.showPasswordVerification();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
    public static final class C97731 extends AbstractC12240o implements Function1<MeUser, Unit> {
        public C97731() {
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
            WidgetSettingsAccountUsernameEdit.this.configureUI(meUser);
        }
    }

    public WidgetSettingsAccountUsernameEdit() {
        super(C5419R.layout.widget_settings_account_edit);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccountUsernameEdit$binding$2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetSettingsAccountUsernameEdit$passwordVerifyLauncher$1(this));
        this.state = new StatefulViews(C5419R.id.edit_account_username_wrap, C5419R.id.edit_account_discriminator_wrap);
        this.validationManager = C12083g.lazy(new WidgetSettingsAccountUsernameEdit$validationManager$2(this));
    }

    private final void configureUI(MeUser meUser) {
        TextInputLayout textInputLayout = getBinding().f17832c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountUsernameWrap");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f17832c;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountUsernameWrap");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), meUser.getUsername()));
        TextInputLayout textInputLayout3 = getBinding().f17831b;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.editAccountDiscriminatorWrap");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout4 = getBinding().f17831b;
        C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.editAccountDiscriminatorWrap");
        int id2 = textInputLayout4.getId();
        String str = String.format("%04d", Arrays.copyOf(new Object[]{Integer.valueOf(meUser.getDiscriminator())}, 1));
        C12238m.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        ViewExtensions.setText(textInputLayout3, (CharSequence) statefulViews2.get(id2, str));
        TextInputLayout textInputLayout5 = getBinding().f17832c;
        C12238m.checkNotNullExpressionValue(textInputLayout5, "binding.editAccountUsernameWrap");
        EditText editText = textInputLayout5.getEditText();
        Editable text = editText != null ? editText.getText() : null;
        TextInputLayout textInputLayout6 = getBinding().f17832c;
        C12238m.checkNotNullExpressionValue(textInputLayout6, "binding.editAccountUsernameWrap");
        Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout6).length());
        boolean zGrantsAccessToCustomTagAndAnimatedAvatarFeatures = PremiumUtilsKt.grantsAccessToCustomTagAndAnimatedAvatarFeatures(meUser.getPremiumTier());
        TextInputLayout textInputLayout7 = getBinding().f17831b;
        C12238m.checkNotNullExpressionValue(textInputLayout7, "binding.editAccountDiscriminatorWrap");
        textInputLayout7.setLongClickable(zGrantsAccessToCustomTagAndAnimatedAvatarFeatures);
        if (zGrantsAccessToCustomTagAndAnimatedAvatarFeatures) {
            return;
        }
        TextInputLayout textInputLayout8 = getBinding().f17831b;
        C12238m.checkNotNullExpressionValue(textInputLayout8, "binding.editAccountDiscriminatorWrap");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout8, new View.OnFocusChangeListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit.configureUI.1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                if (z2) {
                    WidgetSettingsAccountUsernameEdit.this.getBinding().f17831b.post(new Runnable() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit.configureUI.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            WidgetSettingsAccountUsernameEdit.this.getBinding().f17831b.clearFocus();
                        }
                    });
                    C0811c.Companion bVar = C0811c.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetSettingsAccountUsernameEdit.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    C0811c.Companion.m114a(bVar, parentFragmentManager, 0, WidgetSettingsAccountUsernameEdit.this.getString(C5419R.string.premium_upsell_tag_active_mobile), null, Traits.Location.Page.USER_SETTINGS, "Edit Account", null, null, false, false, 968);
                }
            }
        });
    }

    private final WidgetSettingsAccountEditBinding getBinding() {
        return (WidgetSettingsAccountEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void showPasswordVerification() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            WidgetUserPasswordVerify.Companion companion = WidgetUserPasswordVerify.INSTANCE;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.passwordVerifyLauncher;
            TextInputLayout textInputLayout = getBinding().f17832c;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountUsernameWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            TextInputLayout textInputLayout2 = getBinding().f17831b;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountDiscriminatorWrap");
            companion.launchUpdateAccountSettings(contextRequireContext, activityResultLauncher, (56 & 4) != 0 ? null : null, (56 & 8) != 0 ? null : textOrEmpty, (56 & 16) != 0 ? null : ViewExtensions.getTextOrEmpty(textInputLayout2), (56 & 32) != 0 ? null : null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.user_settings_account_change_username_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f17831b;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountDiscriminatorWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C97701());
        TextInputLayout textInputLayout2 = getBinding().f17831b;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountDiscriminatorWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new C97712(), 1, null);
        getBinding().f17833d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccountUsernameEdit.this.showPasswordVerification();
            }
        });
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().f17833d;
        TextInputLayout textInputLayout3 = getBinding().f17832c;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.editAccountUsernameWrap");
        TextInputLayout textInputLayout4 = getBinding().f17831b;
        C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.editAccountDiscriminatorWrap");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout3, textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), (Class<?>) WidgetSettingsAccountUsernameEdit.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97731());
    }
}
