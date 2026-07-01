package com.discord.widgets.status;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.m;
import b.d.b.a.a;
import com.discord.R$attr;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadStatusBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import d0.z.d.a0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetThreadStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadStatusBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetThreadStatus() {
        super(R$layout.widget_thread_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadStatus$binding$2.INSTANCE, null, 2, null);
        WidgetThreadStatus$viewModel$2 widgetThreadStatus$viewModel$2 = WidgetThreadStatus$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetThreadStatusViewModel.class), new WidgetThreadStatus$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetThreadStatus$viewModel$2));
    }

    public static final /* synthetic */ WidgetThreadStatusViewModel access$getViewModel$p(WidgetThreadStatus widgetThreadStatus) {
        return widgetThreadStatus.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetThreadStatus widgetThreadStatus, WidgetThreadStatus$Event widgetThreadStatus$Event) {
        widgetThreadStatus.handleEvent(widgetThreadStatus$Event);
    }

    public static final /* synthetic */ void access$updateView(WidgetThreadStatus widgetThreadStatus, WidgetThreadStatusViewModel$ViewState widgetThreadStatusViewModel$ViewState) {
        widgetThreadStatus.updateView(widgetThreadStatusViewModel$ViewState);
    }

    private final WidgetThreadStatusBinding getBinding() {
        return (WidgetThreadStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadStatusViewModel getViewModel() {
        return (WidgetThreadStatusViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetThreadStatus$Event event) {
        if (event instanceof WidgetThreadStatus$Event$Error) {
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(((WidgetThreadStatus$Event$Error) event).getCode());
            m.i(this, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : 2131893169, 0, 4);
        }
    }

    @MainThread
    private final void updateView(WidgetThreadStatusViewModel$ViewState viewState) {
        getBinding().c.setIsLoading(viewState.isLoading());
        WidgetThreadStatusViewModel$Status threadStatus = viewState.getThreadStatus();
        if (threadStatus instanceof WidgetThreadStatusViewModel$Status$Hide) {
            ConstraintLayout constraintLayout = getBinding().f2673b;
            d0.z.d.m.checkNotNullExpressionValue(constraintLayout, "binding.threadStatus");
            constraintLayout.setVisibility(8);
            return;
        }
        if (threadStatus instanceof WidgetThreadStatusViewModel$Status$Archived) {
            ConstraintLayout constraintLayout2 = getBinding().f2673b;
            d0.z.d.m.checkNotNullExpressionValue(constraintLayout2, "binding.threadStatus");
            constraintLayout2.setVisibility(0);
            LoadingButton loadingButton = getBinding().c;
            d0.z.d.m.checkNotNullExpressionValue(loadingButton, "binding.threadStatusButton");
            WidgetThreadStatusViewModel$Status$Archived widgetThreadStatusViewModel$Status$Archived = (WidgetThreadStatusViewModel$Status$Archived) threadStatus;
            loadingButton.setVisibility(widgetThreadStatusViewModel$Status$Archived.getCanArchive() ? 0 : 8);
            LinkifiedTextView linkifiedTextView = getBinding().d;
            d0.z.d.m.checkNotNullExpressionValue(linkifiedTextView, "binding.threadStatusText");
            linkifiedTextView.setText(widgetThreadStatusViewModel$Status$Archived.isLocked() ? getResources().getString(2131896378) : getResources().getString(2131896376));
            getBinding().c.setText(getResources().getString(2131896563));
            LoadingButton loadingButton2 = getBinding().c;
            d0.z.d.m.checkNotNullExpressionValue(loadingButton2, "binding.threadStatusButton");
            loadingButton2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), 2130968896)));
            getBinding().c.setOnClickListener(new WidgetThreadStatus$updateView$1(this));
            return;
        }
        if (threadStatus instanceof WidgetThreadStatusViewModel$Status$Unjoined) {
            ConstraintLayout constraintLayout3 = getBinding().f2673b;
            d0.z.d.m.checkNotNullExpressionValue(constraintLayout3, "binding.threadStatus");
            constraintLayout3.setVisibility(0);
            LoadingButton loadingButton3 = getBinding().c;
            d0.z.d.m.checkNotNullExpressionValue(loadingButton3, "binding.threadStatusButton");
            loadingButton3.setVisibility(0);
            LinkifiedTextView linkifiedTextView2 = getBinding().d;
            d0.z.d.m.checkNotNullExpressionValue(linkifiedTextView2, "binding.threadStatusText");
            linkifiedTextView2.setText(getResources().getString(2131896377));
            getBinding().c.setText(getResources().getString(2131892378));
            LoadingButton loadingButton4 = getBinding().c;
            d0.z.d.m.checkNotNullExpressionValue(loadingButton4, "binding.threadStatusButton");
            loadingButton4.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R$attr.color_brand_500)));
            getBinding().c.setOnClickListener(new WidgetThreadStatus$updateView$2(this));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadStatus$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetThreadStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadStatus$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
