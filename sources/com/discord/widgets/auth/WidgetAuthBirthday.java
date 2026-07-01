package com.discord.widgets.auth;

import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthBirthdayBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.auth.RegistrationFlowRepo$Companion;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.m;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthBirthday.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthBirthdayBinding;", 0)};
    public static final WidgetAuthBirthday$Companion Companion = new WidgetAuthBirthday$Companion(null);
    private static final String RESULT_EXTRA_BIRTHDAY = "RESULT_EXTRA_BIRTHDAY";
    private static final String VALIDATOR_DATE_OF_BIRTH = "dateOfBirth";
    private static final String VALIDATOR_TOS = "tos";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final DateFormat formatter;
    private boolean isConsentRequired;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    public WidgetAuthBirthday() {
        super(R$layout.widget_auth_birthday);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthBirthday$binding$2.INSTANCE, null, 2, null);
        this.isConsentRequired = true;
        this.formatter = DateFormat.getDateInstance(3);
        this.validationManager = g.lazy(new WidgetAuthBirthday$validationManager$2(this));
    }

    public static final /* synthetic */ WidgetAuthBirthdayBinding access$getBinding$p(WidgetAuthBirthday widgetAuthBirthday) {
        return widgetAuthBirthday.getBinding();
    }

    public static final /* synthetic */ Long access$getBirthday(WidgetAuthBirthday widgetAuthBirthday) {
        return widgetAuthBirthday.getBirthday();
    }

    public static final /* synthetic */ boolean access$isConsentRequired$p(WidgetAuthBirthday widgetAuthBirthday) {
        return widgetAuthBirthday.isConsentRequired;
    }

    public static final /* synthetic */ void access$setBirthday(WidgetAuthBirthday widgetAuthBirthday, long j) {
        widgetAuthBirthday.setBirthday(j);
    }

    public static final /* synthetic */ void access$setConsentRequired$p(WidgetAuthBirthday widgetAuthBirthday, boolean z2) {
        widgetAuthBirthday.isConsentRequired = z2;
    }

    private final WidgetAuthBirthdayBinding getBinding() {
        return (WidgetAuthBirthdayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getBirthday() {
        try {
            DateFormat dateFormat = this.formatter;
            TextInputLayout textInputLayout = getBinding().c;
            m.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
            Date date = dateFormat.parse(ViewExtensions.getTextOrEmpty(textInputLayout));
            if (date != null) {
                return Long.valueOf(date.getTime());
            }
            return null;
        } catch (ParseException unused) {
            return null;
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void setBirthday(long date) {
        String str = this.formatter.format(Long.valueOf(date));
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        ViewExtensions.setText(textInputLayout, new SpannableStringBuilder(str));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Age Gate", "viewed", null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Calendar calendar = Calendar.getInstance();
        m.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        DateFormat dateFormat = this.formatter;
        m.checkNotNullExpressionValue(dateFormat, "formatter");
        dateFormat.setTimeZone(calendar.getTimeZone());
        this.isConsentRequired = StoreStream.Companion.getAuthentication().isConsentRequired();
        MaterialCheckBox materialCheckBox = getBinding().e;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.authTosOptIn");
        materialCheckBox.setVisibility(this.isConsentRequired ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().f2230b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.authPolicyLinks");
        b.n(linkifiedTextView, this.isConsentRequired ? 2131896293 : 2131896290, new Object[]{getString(2131896289), getString(2131894539)}, null, 4);
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        ViewExtensions.setOnEditTextClickListener(textInputLayout, new WidgetAuthBirthday$onViewBoundOrOnResume$1(this));
        getBinding().d.setOnClickListener(new WidgetAuthBirthday$onViewBoundOrOnResume$2(this));
    }

    public final void submit() {
        RegistrationFlowRepo$Companion registrationFlowRepo$Companion = RegistrationFlowRepo.Companion;
        RegistrationFlowRepo.trackTransition$default(registrationFlowRepo$Companion.getINSTANCE(), "Age Gate", "submitted", null, 4, null);
        if (!ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            RegistrationFlowRepo.trackTransition$default(registrationFlowRepo$Companion.getINSTANCE(), "Age Gate", "input_error", null, 4, null);
            return;
        }
        RegistrationFlowRepo.trackTransition$default(registrationFlowRepo$Companion.getINSTANCE(), "Age Gate", "success", null, 4, null);
        Intent intent = new Intent();
        intent.putExtra(RESULT_EXTRA_BIRTHDAY, getBirthday());
        requireActivity().setResult(-1, intent);
        requireActivity().onBackPressed();
    }
}
