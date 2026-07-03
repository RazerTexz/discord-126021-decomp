package com.discord.widgets.voice.sheet;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceNoiseCancellationBottomSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheetViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetNoiseCancellationBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", 0)};

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
            C12238m.checkNotNullParameter(fragment, "fragment");
            WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet = new WidgetNoiseCancellationBottomSheet();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetNoiseCancellationBottomSheet.show(parentFragmentManager, WidgetNoiseCancellationBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
    public static final class C105741 extends AbstractC12240o implements Function1<WidgetNoiseCancellationBottomSheetViewModel.Event, Unit> {
        public C105741() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetNoiseCancellationBottomSheet.this.handleEvent(event);
        }
    }

    public WidgetNoiseCancellationBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNoiseCancellationBottomSheet$binding$2.INSTANCE, null, 2, null);
        WidgetNoiseCancellationBottomSheet$viewModel$2 widgetNoiseCancellationBottomSheet$viewModel$2 = WidgetNoiseCancellationBottomSheet$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetNoiseCancellationBottomSheetViewModel.class), new C10572xfbbb891c(c0865g0), new C0869i0(widgetNoiseCancellationBottomSheet$viewModel$2));
    }

    private final void configureUI() {
        TextView textView = getBinding().f18481c;
        C12238m.checkNotNullExpressionValue(textView, "binding.noiseCancellationLearnMore");
        C1107b.m221m(textView, C5419R.string.learn_more_link, new Object[]{C0862f.f507a.m149a(360040843952L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = getBinding().f18481c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.noiseCancellationLearnMore");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().f18480b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet.configureUI.1
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
            C0876m.m169g(requireContext(), ((WidgetNoiseCancellationBottomSheetViewModel.Event.ShowToast) event).getToastResId(), 0, null, 12);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_voice_noise_cancellation_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetNoiseCancellationBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C105741());
        configureUI();
    }
}
