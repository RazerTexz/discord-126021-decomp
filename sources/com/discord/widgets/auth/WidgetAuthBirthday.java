package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.a.DatePickerDialog;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthBirthdayBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthBirthday.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthBirthdayBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String RESULT_EXTRA_BIRTHDAY = "RESULT_EXTRA_BIRTHDAY";
    private static final String VALIDATOR_DATE_OF_BIRTH = "dateOfBirth";
    private static final String VALIDATOR_TOS = "tos";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final DateFormat formatter;
    private boolean isConsentRequired;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: compiled from: WidgetAuthBirthday.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            AppScreen2.g.f(context, launcher, WidgetAuthBirthday.class, null);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function1<? super Long, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.auth.WidgetAuthBirthday$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
                    Intent data = activityResult.getData();
                    Long lValueOf = data != null ? Long.valueOf(data.getLongExtra("RESULT_EXTRA_BIRTHDAY", 0L)) : null;
                    if (lValueOf != null) {
                        callback.invoke(lValueOf);
                    }
                }
            });
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…ay)\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthBirthday$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthBirthday.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            DatePickerDialog.Companion companion = DatePickerDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetAuthBirthday.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String string = WidgetAuthBirthday.this.getString(R.string.age_gate_date_of_birth);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.age_gate_date_of_birth)");
            Long birthday = WidgetAuthBirthday.this.getBirthday();
            companion.a(parentFragmentManager, string, birthday != null ? birthday.longValue() : BirthdayHelper.INSTANCE.defaultInputAge(), BirthdayHelper.INSTANCE.getMaxDateOfBirth()).onDatePicked = new WidgetAuthBirthday4(this);
        }
    }

    public WidgetAuthBirthday() {
        super(R.layout.widget_auth_birthday);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthBirthday3.INSTANCE, null, 2, null);
        this.isConsentRequired = true;
        this.formatter = DateFormat.getDateInstance(3);
        this.validationManager = LazyJVM.lazy(new WidgetAuthBirthday5(this));
    }

    private final WidgetAuthBirthdayBinding getBinding() {
        return (WidgetAuthBirthdayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getBirthday() {
        try {
            DateFormat dateFormat = this.formatter;
            TextInputLayout textInputLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
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
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        ViewExtensions.setText(textInputLayout, new SpannableStringBuilder(str));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Age Gate", "viewed", null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Calendar calendar = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        DateFormat dateFormat = this.formatter;
        Intrinsics3.checkNotNullExpressionValue(dateFormat, "formatter");
        dateFormat.setTimeZone(calendar.getTimeZone());
        this.isConsentRequired = StoreStream.INSTANCE.getAuthentication().isConsentRequired();
        MaterialCheckBox materialCheckBox = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.authTosOptIn");
        materialCheckBox.setVisibility(this.isConsentRequired ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().f2230b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.authPolicyLinks");
        FormatUtils.m(linkifiedTextView, this.isConsentRequired ? R.string.terms_privacy_opt_in : R.string.terms_privacy, new Object[]{getString(R.string.terms_of_service_url), getString(R.string.privacy_policy_url)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        ViewExtensions.setOnEditTextClickListener(textInputLayout, new AnonymousClass1());
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthBirthday.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAuthBirthday.this.submit();
            }
        });
    }

    public final void submit() {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "submitted", null, 4, null);
        if (!ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "input_error", null, 4, null);
            return;
        }
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "success", null, 4, null);
        Intent intent = new Intent();
        intent.putExtra(RESULT_EXTRA_BIRTHDAY, getBirthday());
        requireActivity().setResult(-1, intent);
        requireActivity().onBackPressed();
    }
}
