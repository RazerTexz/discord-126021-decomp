package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageStartEventBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStageStartEventBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageStartEventBottomSheetBinding;", 0)};
    public static final WidgetStageStartEventBottomSheet$Companion Companion = new WidgetStageStartEventBottomSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private Function0<Unit> onDismiss;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetStageStartEventBottomSheet() {
        super(true);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageStartEventBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetStageStartEventBottomSheet$channelId$2(this));
        WidgetStageStartEventBottomSheet$viewModel$2 widgetStageStartEventBottomSheet$viewModel$2 = new WidgetStageStartEventBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetStageStartEventBottomSheetViewModel.class), new WidgetStageStartEventBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetStageStartEventBottomSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet, WidgetStageStartEventBottomSheetViewModel$ViewState widgetStageStartEventBottomSheetViewModel$ViewState) {
        widgetStageStartEventBottomSheet.configureUI(widgetStageStartEventBottomSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetStageStartEventBottomSheetBinding access$getBinding$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getChannelId();
    }

    public static final /* synthetic */ WidgetStageStartEventBottomSheetViewModel access$getViewModel$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet, WidgetStageStartEventBottomSheetViewModel$Event widgetStageStartEventBottomSheetViewModel$Event) {
        widgetStageStartEventBottomSheet.handleEvent(widgetStageStartEventBottomSheetViewModel$Event);
    }

    private final void configureUI(WidgetStageStartEventBottomSheetViewModel$ViewState viewState) {
        if (viewState instanceof WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded) {
            MaterialButton materialButton = getBinding().c;
            m.checkNotNullExpressionValue(materialButton, "binding.startStageButton");
            WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded widgetStageStartEventBottomSheetViewModel$ViewState$Loaded = (WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded) viewState;
            ViewExtensions.setEnabledAndAlpha$default(materialButton, widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.getTopic().length() > 0, 0.0f, 2, null);
            String topic = widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.getTopic();
            TextInputLayout textInputLayout = getBinding().g;
            m.checkNotNullExpressionValue(textInputLayout, "binding.topicLayout");
            if (!m.areEqual(topic, ViewExtensions.getTextOrEmpty(textInputLayout))) {
                getBinding().f.setText(widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.getTopic());
            }
            TextView textView = getBinding().e;
            m.checkNotNullExpressionValue(textView, "binding.title");
            textView.setText(getString(widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.getStageInstance() == null ? 2131895873 : 2131888641));
            TextView textView2 = getBinding().d;
            m.checkNotNullExpressionValue(textView2, "binding.subtitle");
            textView2.setText(getString(widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.getStageInstance() == null ? 2131895872 : 2131888640));
            MaterialButton materialButton2 = getBinding().c;
            m.checkNotNullExpressionValue(materialButton2, "binding.startStageButton");
            materialButton2.setText(getString(widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.getStageInstance() == null ? 2131895870 : 2131895227));
            TextView textView3 = getBinding().f2658b;
            m.checkNotNullExpressionValue(textView3, "binding.speakerHint");
            textView3.setVisibility(widgetStageStartEventBottomSheetViewModel$ViewState$Loaded.getStageInstance() == null ? 0 : 8);
        }
    }

    private final WidgetStageStartEventBottomSheetBinding getBinding() {
        return (WidgetStageStartEventBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetStageStartEventBottomSheetViewModel getViewModel() {
        return (WidgetStageStartEventBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetStageStartEventBottomSheetViewModel$Event event) {
        if (event instanceof WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess) {
            AppBottomSheet.hideKeyboard$default(this, null, 1, null);
            dismiss();
        } else if (event instanceof WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure) {
            b.a.d.m.i(this, ((WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure) event).getFailureMessageStringRes(), 0, 4);
        } else if (event instanceof WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic) {
            TextInputLayout textInputLayout = getBinding().g;
            m.checkNotNullExpressionValue(textInputLayout, "binding.topicLayout");
            textInputLayout.setError(getString(((WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic) event).getFailureMessageStringRes()));
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_stage_start_event_bottom_sheet;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetStageStartEventBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStageStartEventBottomSheet$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStageStartEventBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStageStartEventBottomSheet$onResume$2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextInputEditText textInputEditText = getBinding().f;
        m.checkNotNullExpressionValue(textInputEditText, "binding.topicInput");
        TextWatcherKt.addBindedTextWatcher(textInputEditText, this, new WidgetStageStartEventBottomSheet$onViewCreated$1(this));
        getBinding().c.setOnClickListener(new WidgetStageStartEventBottomSheet$onViewCreated$2(this));
    }

    public final void setOnDismiss(Function0<Unit> function0) {
        this.onDismiss = function0;
    }
}
