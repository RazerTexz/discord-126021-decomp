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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAgeVerifyBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.auth.WidgetAgeVerifyViewModel;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.C0834k;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetAgeVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAgeVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_NSFW_CHANNEL = "INTENT_EXTRA_NSFW_CHANNEL";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

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
            C12238m.checkNotNullParameter(context, "context");
            AnalyticsTracker.openModal$default("Age Gate", "", null, 4, null);
            Bundle bundle = new Bundle();
            bundle.putBoolean(WidgetAgeVerify.INTENT_EXTRA_NSFW_CHANNEL, isNSFWChannel);
            C0870j.m156d(context, WidgetAgeVerify.class, new Intent().putExtras(bundle));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$configureBirthdayInput$1 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class C71531 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Long $timeOfBirth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71531(Long l) {
            super(1);
            this.$timeOfBirth = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            C0834k.Companion companion = C0834k.INSTANCE;
            FragmentManager parentFragmentManager = WidgetAgeVerify.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            CharSequence charSequenceM213e = C1107b.m213e(WidgetAgeVerify.this, C5419R.string.age_gate_date_of_birth, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
            Long l = this.$timeOfBirth;
            companion.m139a(parentFragmentManager, charSequenceM213e, l != null ? l.longValue() : BirthdayHelper.INSTANCE.defaultInputAge(), BirthdayHelper.INSTANCE.getMaxDateOfBirth()).onDatePicked = new C7154xf355b2f8(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class C71561 extends AbstractC12240o implements Function1<WidgetAgeVerifyViewModel.ViewState, Unit> {
        public C71561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAgeVerifyViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAgeVerifyViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetAgeVerify.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class C71572 extends AbstractC12240o implements Function1<WidgetAgeVerifyViewModel.Event, Unit> {
        public C71572() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAgeVerifyViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAgeVerifyViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "it");
            WidgetAgeVerify.this.handleEvent(event);
        }
    }

    public WidgetAgeVerify() {
        super(C5419R.layout.widget_age_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAgeVerify$binding$2.INSTANCE, null, 2, null);
        WidgetAgeVerify$viewModel$2 widgetAgeVerify$viewModel$2 = WidgetAgeVerify$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetAgeVerifyViewModel.class), new WidgetAgeVerify$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetAgeVerify$viewModel$2));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetAgeVerify$loggingConfig$1(this), 3);
    }

    private final void configureBirthdayInput(WidgetAgeVerifyViewModel.ViewState viewState) {
        Long dateOfBirth = viewState.getDateOfBirth();
        Calendar calendar = Calendar.getInstance();
        C12238m.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        calendar.setTimeInMillis(dateOfBirth != null ? dateOfBirth.longValue() : BirthdayHelper.INSTANCE.getMaxDateOfBirth());
        DateFormat dateInstance = DateFormat.getDateInstance(3);
        if (dateOfBirth != null) {
            C12238m.checkNotNullExpressionValue(dateInstance, "formatter");
            dateInstance.setTimeZone(calendar.getTimeZone());
            String str = dateInstance.format(Long.valueOf(calendar.getTimeInMillis()));
            TextInputLayout textInputLayout = getBinding().f15647e.f859c;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.verify.ageVerifyInputWrapper");
            ViewExtensions.setText(textInputLayout, new SpannableStringBuilder(str));
        }
        if (viewState.getErrorStringId() != null) {
            TextInputLayout textInputLayout2 = getBinding().f15647e.f859c;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.verify.ageVerifyInputWrapper");
            textInputLayout2.setError(C1107b.m213e(this, viewState.getErrorStringId().intValue(), new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        }
        TextInputLayout textInputLayout3 = getBinding().f15647e.f859c;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.verify.ageVerifyInputWrapper");
        ViewExtensions.setOnEditTextClickListener(textInputLayout3, new C71531(dateOfBirth));
    }

    private final void configureUI(WidgetAgeVerifyViewModel.ViewState viewState) {
        Long dateOfBirth;
        if (viewState.getShouldClose() && viewState.getDisplayedChild() != 2) {
            requireActivity().finish();
        }
        getBinding().f15647e.f860d.setIsLoading(viewState.isSubmitting());
        LoadingButton loadingButton = getBinding().f15647e.f860d;
        C12238m.checkNotNullExpressionValue(loadingButton, "binding.verify.ageVerifyNextButton");
        loadingButton.setEnabled(viewState.getDateOfBirth() != null);
        getBinding().f15645c.f897c.setIsLoading(viewState.isSubmitting());
        LoadingButton loadingButton2 = getBinding().f15645c.f897c;
        C12238m.checkNotNullExpressionValue(loadingButton2, "binding.confirm.ageVerifyConfirmButton");
        loadingButton2.setEnabled(viewState.getDateOfBirth() != null);
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), C5419R.plurals.age_gate_underage_existing_body_deletion_with_days_days, 30, 30);
        TextView textView = getBinding().f15646d.f940d;
        C12238m.checkNotNullExpressionValue(textView, "binding.underage.underageWarning");
        C1107b.m221m(textView, C5419R.string.age_gate_underage_existing_body_deletion_with_days, new Object[]{quantityString}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinkifiedTextView linkifiedTextView = getBinding().f15646d.f939c;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.underage.ageVerifyUnderageDescription");
        Object[] objArr = new Object[2];
        String underageMessage = viewState.getUnderageMessage();
        if (underageMessage == null) {
            underageMessage = "";
        }
        objArr[0] = underageMessage;
        objArr[1] = C0862f.f507a.m149a(360040724612L, null);
        C1107b.m221m(linkifiedTextView, C5419R.string.age_gate_underage_body, objArr, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        if (viewState.getDisplayedChild() == 2) {
            requireAppActivity().refreshEnabled = false;
            AppFragment.hideKeyboard$default(this, null, 1, null);
        }
        if (viewState.getDisplayedChild() == 1 && (dateOfBirth = viewState.getDateOfBirth()) != null) {
            int age = BirthdayHelper.INSTANCE.getAge(dateOfBirth.longValue());
            TextView textView2 = getBinding().f15645c.f899e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.confirm.ageVerifyConfirmTitle");
            C1107b.m221m(textView2, C5419R.string.age_gate_confirm_header, new Object[]{String.valueOf(age)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
        configureBirthdayInput(viewState);
        configureViewFlipper(viewState.getDisplayedChild());
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.auth.WidgetAgeVerify.configureUI.1
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                AppViewFlipper appViewFlipper = WidgetAgeVerify.this.getBinding().f15644b;
                C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
                int displayedChild = appViewFlipper.getDisplayedChild();
                if (displayedChild == 1) {
                    WidgetAgeVerify.this.getViewModel().onConfirmBackClicked();
                } else if (displayedChild == 2 || WidgetAgeVerify.this.getViewModel().backToSafety()) {
                    WidgetAgeVerify.this.requireAppActivity().m8349j(WidgetAgeVerify.this.requireContext());
                } else {
                    WidgetAgeVerify.this.requireActivity().finish();
                }
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }

    private final void configureViewFlipper(int displayedChild) {
        AppViewFlipper appViewFlipper = getBinding().f15644b;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
        if (displayedChild > appViewFlipper.getDisplayedChild()) {
            AppViewFlipper appViewFlipper2 = getBinding().f15644b;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.ageVerifyViewFlipper");
            appViewFlipper2.setInAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_open_in));
            AppViewFlipper appViewFlipper3 = getBinding().f15644b;
            C12238m.checkNotNullExpressionValue(appViewFlipper3, "binding.ageVerifyViewFlipper");
            appViewFlipper3.setOutAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_open_out));
        } else {
            AppViewFlipper appViewFlipper4 = getBinding().f15644b;
            C12238m.checkNotNullExpressionValue(appViewFlipper4, "binding.ageVerifyViewFlipper");
            if (displayedChild < appViewFlipper4.getDisplayedChild()) {
                AppViewFlipper appViewFlipper5 = getBinding().f15644b;
                C12238m.checkNotNullExpressionValue(appViewFlipper5, "binding.ageVerifyViewFlipper");
                appViewFlipper5.setInAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_close_in));
                AppViewFlipper appViewFlipper6 = getBinding().f15644b;
                C12238m.checkNotNullExpressionValue(appViewFlipper6, "binding.ageVerifyViewFlipper");
                appViewFlipper6.setOutAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_close_out));
            }
        }
        AppViewFlipper appViewFlipper7 = getBinding().f15644b;
        C12238m.checkNotNullExpressionValue(appViewFlipper7, "binding.ageVerifyViewFlipper");
        appViewFlipper7.setDisplayedChild(displayedChild);
    }

    private final WidgetAgeVerifyBinding getBinding() {
        return (WidgetAgeVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetAgeVerifyViewModel getViewModel() {
        return (WidgetAgeVerifyViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetAgeVerifyViewModel.Event event) {
        if (C12238m.areEqual(event, WidgetAgeVerifyViewModel.Event.Verified.INSTANCE)) {
            Context context = getContext();
            C0876m.m168f(this, context != null ? context.getString(C5419R.string.age_gate_age_verified) : null, 1);
            requireActivity().finish();
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetAgeVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71561());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetAgeVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71572());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f15646d.f938b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAgeVerify.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAgeVerify.this.requireAppActivity().refreshEnabled = true;
                WidgetAgeVerify.this.requireActivity().finish();
            }
        });
        final boolean booleanExtra = getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_NSFW_CHANNEL, false);
        LinkifiedTextView linkifiedTextView = getBinding().f15647e.f858b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.verify.ageVerifyDescription");
        C1107b.m221m(linkifiedTextView, booleanExtra ? C5419R.string.age_gate_nsfw_body : C5419R.string.age_gate_body, new Object[]{C0862f.f507a.m149a(360040724612L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinkifiedTextView linkifiedTextView2 = getBinding().f15645c.f898d;
        C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.confirm.ageVerifyConfirmDescription");
        LinkifiedTextView linkifiedTextView3 = getBinding().f15647e.f858b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView3, "binding.verify.ageVerifyDescription");
        linkifiedTextView2.setText(linkifiedTextView3.getText());
        getBinding().f15647e.f860d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAgeVerify.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAgeVerify.this.getViewModel().submit(booleanExtra);
            }
        });
        getBinding().f15645c.f897c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAgeVerify.onViewBoundOrOnResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAgeVerify.this.getViewModel().submit(booleanExtra);
            }
        });
        getBinding().f15645c.f896b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAgeVerify.onViewBoundOrOnResume.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAgeVerify.this.getViewModel().onConfirmBackClicked();
            }
        });
    }
}
