package com.discord.widgets.auth;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$anim;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAgeVerifyBinding;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.a0;
import d0.z.d.m;
import java.text.DateFormat;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAgeVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAgeVerifyBinding;", 0)};
    public static final WidgetAgeVerify$Companion Companion = new WidgetAgeVerify$Companion(null);
    private static final String INTENT_EXTRA_NSFW_CHANNEL = "INTENT_EXTRA_NSFW_CHANNEL";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetAgeVerify() {
        super(R$layout.widget_age_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAgeVerify$binding$2.INSTANCE, null, 2, null);
        WidgetAgeVerify$viewModel$2 widgetAgeVerify$viewModel$2 = WidgetAgeVerify$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetAgeVerifyViewModel.class), new WidgetAgeVerify$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetAgeVerify$viewModel$2));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetAgeVerify$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetAgeVerify widgetAgeVerify, WidgetAgeVerifyViewModel$ViewState widgetAgeVerifyViewModel$ViewState) {
        widgetAgeVerify.configureUI(widgetAgeVerifyViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetAgeVerifyBinding access$getBinding$p(WidgetAgeVerify widgetAgeVerify) {
        return widgetAgeVerify.getBinding();
    }

    public static final /* synthetic */ WidgetAgeVerifyViewModel access$getViewModel$p(WidgetAgeVerify widgetAgeVerify) {
        return widgetAgeVerify.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetAgeVerify widgetAgeVerify, WidgetAgeVerifyViewModel$Event widgetAgeVerifyViewModel$Event) {
        widgetAgeVerify.handleEvent(widgetAgeVerifyViewModel$Event);
    }

    private final void configureBirthdayInput(WidgetAgeVerifyViewModel$ViewState viewState) {
        Long dateOfBirth = viewState.getDateOfBirth();
        Calendar calendar = Calendar.getInstance();
        m.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        calendar.setTimeInMillis(dateOfBirth != null ? dateOfBirth.longValue() : BirthdayHelper.INSTANCE.getMaxDateOfBirth());
        DateFormat dateInstance = DateFormat.getDateInstance(3);
        if (dateOfBirth != null) {
            m.checkNotNullExpressionValue(dateInstance, "formatter");
            dateInstance.setTimeZone(calendar.getTimeZone());
            String str = dateInstance.format(Long.valueOf(calendar.getTimeInMillis()));
            TextInputLayout textInputLayout = getBinding().e.c;
            m.checkNotNullExpressionValue(textInputLayout, "binding.verify.ageVerifyInputWrapper");
            ViewExtensions.setText(textInputLayout, new SpannableStringBuilder(str));
        }
        if (viewState.getErrorStringId() != null) {
            TextInputLayout textInputLayout2 = getBinding().e.c;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.verify.ageVerifyInputWrapper");
            textInputLayout2.setError(b.k(this, viewState.getErrorStringId().intValue(), new Object[0], null, 4));
        }
        TextInputLayout textInputLayout3 = getBinding().e.c;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.verify.ageVerifyInputWrapper");
        ViewExtensions.setOnEditTextClickListener(textInputLayout3, new WidgetAgeVerify$configureBirthdayInput$1(this, dateOfBirth));
    }

    private final void configureUI(WidgetAgeVerifyViewModel$ViewState viewState) {
        Long dateOfBirth;
        if (viewState.getShouldClose() && viewState.getDisplayedChild() != 2) {
            requireActivity().finish();
        }
        getBinding().e.d.setIsLoading(viewState.isSubmitting());
        LoadingButton loadingButton = getBinding().e.d;
        m.checkNotNullExpressionValue(loadingButton, "binding.verify.ageVerifyNextButton");
        loadingButton.setEnabled(viewState.getDateOfBirth() != null);
        getBinding().c.c.setIsLoading(viewState.isSubmitting());
        LoadingButton loadingButton2 = getBinding().c.c;
        m.checkNotNullExpressionValue(loadingButton2, "binding.confirm.ageVerifyConfirmButton");
        loadingButton2.setEnabled(viewState.getDateOfBirth() != null);
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), R$plurals.age_gate_underage_existing_body_deletion_with_days_days, 30, 30);
        TextView textView = getBinding().d.d;
        m.checkNotNullExpressionValue(textView, "binding.underage.underageWarning");
        b.n(textView, 2131886402, new Object[]{quantityString}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().d.c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.underage.ageVerifyUnderageDescription");
        Object[] objArr = new Object[2];
        String underageMessage = viewState.getUnderageMessage();
        if (underageMessage == null) {
            underageMessage = "";
        }
        objArr[0] = underageMessage;
        objArr[1] = f.a.a(360040724612L, null);
        b.n(linkifiedTextView, 2131886397, objArr, null, 4);
        if (viewState.getDisplayedChild() == 2) {
            requireAppActivity().refreshEnabled = false;
            AppFragment.hideKeyboard$default(this, null, 1, null);
        }
        if (viewState.getDisplayedChild() == 1 && (dateOfBirth = viewState.getDateOfBirth()) != null) {
            int age = BirthdayHelper.INSTANCE.getAge(dateOfBirth.longValue());
            TextView textView2 = getBinding().c.e;
            m.checkNotNullExpressionValue(textView2, "binding.confirm.ageVerifyConfirmTitle");
            b.n(textView2, 2131886381, new Object[]{String.valueOf(age)}, null, 4);
        }
        configureBirthdayInput(viewState);
        configureViewFlipper(viewState.getDisplayedChild());
        AppFragment.setOnBackPressed$default(this, new WidgetAgeVerify$configureUI$1(this), 0, 2, null);
    }

    private final void configureViewFlipper(int displayedChild) {
        AppViewFlipper appViewFlipper = getBinding().f2224b;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
        if (displayedChild > appViewFlipper.getDisplayedChild()) {
            AppViewFlipper appViewFlipper2 = getBinding().f2224b;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.ageVerifyViewFlipper");
            appViewFlipper2.setInAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.activity_slide_horizontal_open_in));
            AppViewFlipper appViewFlipper3 = getBinding().f2224b;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.ageVerifyViewFlipper");
            appViewFlipper3.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.activity_slide_horizontal_open_out));
        } else {
            AppViewFlipper appViewFlipper4 = getBinding().f2224b;
            m.checkNotNullExpressionValue(appViewFlipper4, "binding.ageVerifyViewFlipper");
            if (displayedChild < appViewFlipper4.getDisplayedChild()) {
                AppViewFlipper appViewFlipper5 = getBinding().f2224b;
                m.checkNotNullExpressionValue(appViewFlipper5, "binding.ageVerifyViewFlipper");
                appViewFlipper5.setInAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.activity_slide_horizontal_close_in));
                AppViewFlipper appViewFlipper6 = getBinding().f2224b;
                m.checkNotNullExpressionValue(appViewFlipper6, "binding.ageVerifyViewFlipper");
                appViewFlipper6.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.activity_slide_horizontal_close_out));
            }
        }
        AppViewFlipper appViewFlipper7 = getBinding().f2224b;
        m.checkNotNullExpressionValue(appViewFlipper7, "binding.ageVerifyViewFlipper");
        appViewFlipper7.setDisplayedChild(displayedChild);
    }

    private final WidgetAgeVerifyBinding getBinding() {
        return (WidgetAgeVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetAgeVerifyViewModel getViewModel() {
        return (WidgetAgeVerifyViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetAgeVerifyViewModel$Event event) {
        if (m.areEqual(event, WidgetAgeVerifyViewModel$Event$Verified.INSTANCE)) {
            Context context = getContext();
            b.a.d.m.f(this, context != null ? context.getString(2131886376) : null, 1);
            requireActivity().finish();
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetAgeVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAgeVerify$onViewBound$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetAgeVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAgeVerify$onViewBound$2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().d.f131b.setOnClickListener(new WidgetAgeVerify$onViewBoundOrOnResume$1(this));
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_NSFW_CHANNEL, false);
        LinkifiedTextView linkifiedTextView = getBinding().e.f117b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.verify.ageVerifyDescription");
        b.n(linkifiedTextView, booleanExtra ? 2131886391 : 2131886378, new Object[]{f.a.a(360040724612L, null)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = getBinding().c.d;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.confirm.ageVerifyConfirmDescription");
        LinkifiedTextView linkifiedTextView3 = getBinding().e.f117b;
        m.checkNotNullExpressionValue(linkifiedTextView3, "binding.verify.ageVerifyDescription");
        linkifiedTextView2.setText(linkifiedTextView3.getText());
        getBinding().e.d.setOnClickListener(new WidgetAgeVerify$onViewBoundOrOnResume$2(this, booleanExtra));
        getBinding().c.c.setOnClickListener(new WidgetAgeVerify$onViewBoundOrOnResume$3(this, booleanExtra));
        getBinding().c.f124b.setOnClickListener(new WidgetAgeVerify$onViewBoundOrOnResume$4(this));
    }
}
