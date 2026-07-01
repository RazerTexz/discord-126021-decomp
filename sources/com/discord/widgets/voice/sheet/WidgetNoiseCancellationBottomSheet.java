package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceNoiseCancellationBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetNoiseCancellationBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", 0)};
    public static final WidgetNoiseCancellationBottomSheet$Companion Companion = new WidgetNoiseCancellationBottomSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetNoiseCancellationBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNoiseCancellationBottomSheet$binding$2.INSTANCE, null, 2, null);
        WidgetNoiseCancellationBottomSheet$viewModel$2 widgetNoiseCancellationBottomSheet$viewModel$2 = WidgetNoiseCancellationBottomSheet$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetNoiseCancellationBottomSheetViewModel.class), new WidgetNoiseCancellationBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetNoiseCancellationBottomSheet$viewModel$2));
    }

    public static final /* synthetic */ WidgetNoiseCancellationBottomSheetViewModel access$getViewModel$p(WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet) {
        return widgetNoiseCancellationBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet, WidgetNoiseCancellationBottomSheetViewModel$Event widgetNoiseCancellationBottomSheetViewModel$Event) {
        widgetNoiseCancellationBottomSheet.handleEvent(widgetNoiseCancellationBottomSheetViewModel$Event);
    }

    private final void configureUI() {
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.noiseCancellationLearnMore");
        b.n(textView, 2131892523, new Object[]{f.a.a(360040843952L, null)}, null, 4);
        TextView textView2 = getBinding().c;
        m.checkNotNullExpressionValue(textView2, "binding.noiseCancellationLearnMore");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().f2704b.setOnClickListener(new WidgetNoiseCancellationBottomSheet$configureUI$1(this));
    }

    private final WidgetVoiceNoiseCancellationBottomSheetBinding getBinding() {
        return (WidgetVoiceNoiseCancellationBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetNoiseCancellationBottomSheetViewModel getViewModel() {
        return (WidgetNoiseCancellationBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetNoiseCancellationBottomSheetViewModel$Event event) {
        if (event instanceof WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast) {
            b.a.d.m.g(requireContext(), ((WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast) event).getToastResId(), 0, null, 12);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_voice_noise_cancellation_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetNoiseCancellationBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetNoiseCancellationBottomSheet$onResume$1(this), 62, (Object) null);
        configureUI();
    }
}
