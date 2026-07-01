package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.DatePickerDialog;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAgeVerifyBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.auth.WidgetAgeVerifyViewModel;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.text.DateFormat;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAgeVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAgeVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_NSFW_CHANNEL = "INTENT_EXTRA_NSFW_CHANNEL";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            companion.start(context, z2);
        }

        public final void start(Context context, boolean isNSFWChannel) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AnalyticsTracker.openModal$default("Age Gate", "", null, 4, null);
            Bundle bundle = new Bundle();
            bundle.putBoolean(WidgetAgeVerify.INTENT_EXTRA_NSFW_CHANNEL, isNSFWChannel);
            AppScreen2.d(context, WidgetAgeVerify.class, new Intent().putExtras(bundle));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$configureBirthdayInput$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Long $timeOfBirth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(1);
            this.$timeOfBirth = l;
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
            FragmentManager parentFragmentManager = WidgetAgeVerify.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            CharSequence charSequenceE = FormatUtils.e(WidgetAgeVerify.this, R.string.age_gate_date_of_birth, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
            Long l = this.$timeOfBirth;
            companion.a(parentFragmentManager, charSequenceE, l != null ? l.longValue() : BirthdayHelper.INSTANCE.defaultInputAge(), BirthdayHelper.INSTANCE.getMaxDateOfBirth()).onDatePicked = new WidgetAgeVerify3(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetAgeVerifyViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAgeVerifyViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAgeVerifyViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetAgeVerify.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetAgeVerifyViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAgeVerifyViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAgeVerifyViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetAgeVerify.this.handleEvent(event);
        }
    }

    public WidgetAgeVerify() {
        super(R.layout.widget_age_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAgeVerify2.INSTANCE, null, 2, null);
        WidgetAgeVerify5 widgetAgeVerify5 = WidgetAgeVerify5.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetAgeVerifyViewModel.class), new WidgetAgeVerify$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetAgeVerify5));
        this.loggingConfig = new AppLogger2(false, null, new WidgetAgeVerify4(this), 3);
    }

    private final void configureBirthdayInput(WidgetAgeVerifyViewModel.ViewState viewState) {
        Long dateOfBirth = viewState.getDateOfBirth();
        Calendar calendar = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        calendar.setTimeInMillis(dateOfBirth != null ? dateOfBirth.longValue() : BirthdayHelper.INSTANCE.getMaxDateOfBirth());
        DateFormat dateInstance = DateFormat.getDateInstance(3);
        if (dateOfBirth != null) {
            Intrinsics3.checkNotNullExpressionValue(dateInstance, "formatter");
            dateInstance.setTimeZone(calendar.getTimeZone());
            String str = dateInstance.format(Long.valueOf(calendar.getTimeInMillis()));
            TextInputLayout textInputLayout = getBinding().e.c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.verify.ageVerifyInputWrapper");
            ViewExtensions.setText(textInputLayout, new SpannableStringBuilder(str));
        }
        if (viewState.getErrorStringId() != null) {
            TextInputLayout textInputLayout2 = getBinding().e.c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.verify.ageVerifyInputWrapper");
            textInputLayout2.setError(FormatUtils.e(this, viewState.getErrorStringId().intValue(), new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        }
        TextInputLayout textInputLayout3 = getBinding().e.c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.verify.ageVerifyInputWrapper");
        ViewExtensions.setOnEditTextClickListener(textInputLayout3, new AnonymousClass1(dateOfBirth));
    }

    private final void configureUI(WidgetAgeVerifyViewModel.ViewState viewState) {
        Long dateOfBirth;
        if (viewState.getShouldClose() && viewState.getDisplayedChild() != 2) {
            requireActivity().finish();
        }
        getBinding().e.d.setIsLoading(viewState.isSubmitting());
        LoadingButton loadingButton = getBinding().e.d;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.verify.ageVerifyNextButton");
        loadingButton.setEnabled(viewState.getDateOfBirth() != null);
        getBinding().c.c.setIsLoading(viewState.isSubmitting());
        LoadingButton loadingButton2 = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.confirm.ageVerifyConfirmButton");
        loadingButton2.setEnabled(viewState.getDateOfBirth() != null);
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.age_gate_underage_existing_body_deletion_with_days_days, 30, 30);
        TextView textView = getBinding().d.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.underage.underageWarning");
        FormatUtils.m(textView, R.string.age_gate_underage_existing_body_deletion_with_days, new Object[]{quantityString}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinkifiedTextView linkifiedTextView = getBinding().d.c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.underage.ageVerifyUnderageDescription");
        Object[] objArr = new Object[2];
        String underageMessage = viewState.getUnderageMessage();
        if (underageMessage == null) {
            underageMessage = "";
        }
        objArr[0] = underageMessage;
        objArr[1] = AppHelpDesk.a.a(360040724612L, null);
        FormatUtils.m(linkifiedTextView, R.string.age_gate_underage_body, objArr, (4 & 4) != 0 ? FormatUtils.g.j : null);
        if (viewState.getDisplayedChild() == 2) {
            requireAppActivity().refreshEnabled = false;
            AppFragment.hideKeyboard$default(this, null, 1, null);
        }
        if (viewState.getDisplayedChild() == 1 && (dateOfBirth = viewState.getDateOfBirth()) != null) {
            int age = BirthdayHelper.INSTANCE.getAge(dateOfBirth.longValue());
            TextView textView2 = getBinding().c.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.confirm.ageVerifyConfirmTitle");
            FormatUtils.m(textView2, R.string.age_gate_confirm_header, new Object[]{String.valueOf(age)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        }
        configureBirthdayInput(viewState);
        configureViewFlipper(viewState.getDisplayedChild());
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.auth.WidgetAgeVerify.configureUI.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                AppViewFlipper appViewFlipper = WidgetAgeVerify.this.getBinding().f2224b;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
                int displayedChild = appViewFlipper.getDisplayedChild();
                if (displayedChild == 1) {
                    WidgetAgeVerify.this.getViewModel().onConfirmBackClicked();
                } else if (displayedChild == 2 || WidgetAgeVerify.this.getViewModel().backToSafety()) {
                    WidgetAgeVerify.this.requireAppActivity().j(WidgetAgeVerify.this.requireContext());
                } else {
                    WidgetAgeVerify.this.requireActivity().finish();
                }
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }

    private final void configureViewFlipper(int displayedChild) {
        AppViewFlipper appViewFlipper = getBinding().f2224b;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
        if (displayedChild > appViewFlipper.getDisplayedChild()) {
            AppViewFlipper appViewFlipper2 = getBinding().f2224b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.ageVerifyViewFlipper");
            appViewFlipper2.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_open_in));
            AppViewFlipper appViewFlipper3 = getBinding().f2224b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.ageVerifyViewFlipper");
            appViewFlipper3.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_open_out));
        } else {
            AppViewFlipper appViewFlipper4 = getBinding().f2224b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.ageVerifyViewFlipper");
            if (displayedChild < appViewFlipper4.getDisplayedChild()) {
                AppViewFlipper appViewFlipper5 = getBinding().f2224b;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper5, "binding.ageVerifyViewFlipper");
                appViewFlipper5.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_close_in));
                AppViewFlipper appViewFlipper6 = getBinding().f2224b;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper6, "binding.ageVerifyViewFlipper");
                appViewFlipper6.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_close_out));
            }
        }
        AppViewFlipper appViewFlipper7 = getBinding().f2224b;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper7, "binding.ageVerifyViewFlipper");
        appViewFlipper7.setDisplayedChild(displayedChild);
    }

    private final WidgetAgeVerifyBinding getBinding() {
        return (WidgetAgeVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetAgeVerifyViewModel getViewModel() {
        return (WidgetAgeVerifyViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetAgeVerifyViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetAgeVerifyViewModel.Event.Verified.INSTANCE)) {
            Context context = getContext();
            AppToast.f(this, context != null ? context.getString(R.string.age_gate_age_verified) : null, 1);
            requireActivity().finish();
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetAgeVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetAgeVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().d.f131b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAgeVerify.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAgeVerify.this.requireAppActivity().refreshEnabled = true;
                WidgetAgeVerify.this.requireActivity().finish();
            }
        });
        final boolean booleanExtra = getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_NSFW_CHANNEL, false);
        LinkifiedTextView linkifiedTextView = getBinding().e.f117b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.verify.ageVerifyDescription");
        FormatUtils.m(linkifiedTextView, booleanExtra ? R.string.age_gate_nsfw_body : R.string.age_gate_body, new Object[]{AppHelpDesk.a.a(360040724612L, null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinkifiedTextView linkifiedTextView2 = getBinding().c.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.confirm.ageVerifyConfirmDescription");
        LinkifiedTextView linkifiedTextView3 = getBinding().e.f117b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "binding.verify.ageVerifyDescription");
        linkifiedTextView2.setText(linkifiedTextView3.getText());
        getBinding().e.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAgeVerify.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAgeVerify.this.getViewModel().submit(booleanExtra);
            }
        });
        getBinding().c.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAgeVerify.onViewBoundOrOnResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAgeVerify.this.getViewModel().submit(booleanExtra);
            }
        });
        getBinding().c.f124b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAgeVerify.onViewBoundOrOnResume.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAgeVerify.this.getViewModel().onConfirmBackClicked();
            }
        });
    }
}
