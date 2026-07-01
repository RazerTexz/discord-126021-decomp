package com.discord.widgets.voice.sheet;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceNoiseCancellationBottomSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheetViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetNoiseCancellationBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Fragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet = new WidgetNoiseCancellationBottomSheet();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetNoiseCancellationBottomSheet.show(parentFragmentManager, WidgetNoiseCancellationBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetNoiseCancellationBottomSheetViewModel.Event, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetNoiseCancellationBottomSheet.this.handleEvent(event);
        }
    }

    public WidgetNoiseCancellationBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNoiseCancellationBottomSheet2.INSTANCE, null, 2, null);
        WidgetNoiseCancellationBottomSheet3 widgetNoiseCancellationBottomSheet3 = WidgetNoiseCancellationBottomSheet3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetNoiseCancellationBottomSheetViewModel.class), new WidgetNoiseCancellationBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetNoiseCancellationBottomSheet3));
    }

    private final void configureUI() {
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noiseCancellationLearnMore");
        FormatUtils.m(textView, R.string.learn_more_link, new Object[]{AppHelpDesk.a.a(360040843952L, null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.noiseCancellationLearnMore");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().f2704b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetNoiseCancellationBottomSheet.this.getViewModel().onNoiseCancellationButtonPressed();
                WidgetNoiseCancellationBottomSheet.this.dismiss();
            }
        });
    }

    private final WidgetVoiceNoiseCancellationBottomSheetBinding getBinding() {
        return (WidgetVoiceNoiseCancellationBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetNoiseCancellationBottomSheetViewModel getViewModel() {
        return (WidgetNoiseCancellationBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
        if (event instanceof WidgetNoiseCancellationBottomSheetViewModel.Event.ShowToast) {
            AppToast.g(requireContext(), ((WidgetNoiseCancellationBottomSheetViewModel.Event.ShowToast) event).getToastResId(), 0, null, 12);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_voice_noise_cancellation_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetNoiseCancellationBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        configureUI();
    }
}
