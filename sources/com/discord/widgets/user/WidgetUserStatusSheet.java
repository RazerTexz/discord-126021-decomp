package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.presence.ClientStatus;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUserStatusUpdateBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserStatusSheetViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p025i.C0948e4;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUserStatusSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Fragment fragment) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            WidgetUserStatusSheet widgetUserStatusSheet = new WidgetUserStatusSheet();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetUserStatusSheet.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final /* synthetic */ class C102391 extends C12236k implements Function1<WidgetUserStatusSheetViewModel.ViewState, Unit> {
        public C102391(WidgetUserStatusSheet widgetUserStatusSheet) {
            super(1, widgetUserStatusSheet, WidgetUserStatusSheet.class, "updateView", "updateView(Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserStatusSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserStatusSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetUserStatusSheet) this.receiver).updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$6 */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final class C102456 extends AbstractC12240o implements Function0<Unit> {
        public C102456() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserStatusSheet.this.clearCustomStatus();
        }
    }

    public WidgetUserStatusSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserStatusSheet$binding$2.INSTANCE, null, 2, null);
        WidgetUserStatusSheet$viewModel$2 widgetUserStatusSheet$viewModel$2 = WidgetUserStatusSheet$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetUserStatusSheetViewModel.class), new WidgetUserStatusSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetUserStatusSheet$viewModel$2));
    }

    @MainThread
    private final void clearCustomStatus() {
        getViewModel().clearCustomStatus();
    }

    private final WidgetUserStatusUpdateBinding getBinding() {
        return (WidgetUserStatusUpdateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetUserStatusSheetViewModel getViewModel() {
        return (WidgetUserStatusSheetViewModel) this.viewModel.getValue();
    }

    @MainThread
    private final void openCustomStatusAndDismiss(Context context) {
        AnalyticsTracker.INSTANCE.openModal("Custom Status Modal", new Traits.Source(null, "Account Panel", "Avatar", null, null, 25, null));
        WidgetUserSetCustomStatus.INSTANCE.launch(context);
        dismiss();
    }

    @MainThread
    private final void updateStateAndDismiss(ClientStatus status) {
        getViewModel().setStatus(status);
        dismiss();
    }

    private final void updateView(WidgetUserStatusSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetUserStatusSheetViewModel.ViewState.Loaded) {
            getBinding().f18432b.updateViewState(((WidgetUserStatusSheetViewModel.ViewState.Loaded) viewState).getCustomStatusViewState());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_user_status_update;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetUserStatusSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C102391(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f18436f.f814b.setImageResource(C5419R.drawable.ic_status_online_16dp);
        getBinding().f18436f.f816d.setText(C5419R.string.status_online);
        C0948e4 c0948e4 = getBinding().f18436f;
        C12238m.checkNotNullExpressionValue(c0948e4, "binding.userStatusUpdateOnline");
        c0948e4.f813a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserStatusSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet.this.updateStateAndDismiss(ClientStatus.ONLINE);
            }
        });
        getBinding().f18434d.f814b.setImageResource(C5419R.drawable.ic_status_idle_16dp);
        getBinding().f18434d.f816d.setText(C5419R.string.status_idle);
        C0948e4 c0948e5 = getBinding().f18434d;
        C12238m.checkNotNullExpressionValue(c0948e5, "binding.userStatusUpdateIdle");
        c0948e5.f813a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserStatusSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet.this.updateStateAndDismiss(ClientStatus.IDLE);
            }
        });
        getBinding().f18433c.f814b.setImageResource(C5419R.drawable.ic_status_dnd_16dp);
        getBinding().f18433c.f816d.setText(C5419R.string.status_dnd);
        getBinding().f18433c.f815c.setText(C5419R.string.status_dnd_help);
        C0948e4 c0948e6 = getBinding().f18433c;
        C12238m.checkNotNullExpressionValue(c0948e6, "binding.userStatusUpdateDnd");
        c0948e6.f813a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserStatusSheet.onViewCreated.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet.this.updateStateAndDismiss(ClientStatus.DND);
            }
        });
        getBinding().f18435e.f814b.setImageResource(C5419R.drawable.ic_status_invisible_16dp);
        getBinding().f18435e.f816d.setText(C5419R.string.status_invisible);
        getBinding().f18435e.f815c.setText(C5419R.string.status_invisible_helper);
        C0948e4 c0948e7 = getBinding().f18435e;
        C12238m.checkNotNullExpressionValue(c0948e7, "binding.userStatusUpdateInvisible");
        c0948e7.f813a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserStatusSheet.onViewCreated.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet.this.updateStateAndDismiss(ClientStatus.INVISIBLE);
            }
        });
        getBinding().f18432b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserStatusSheet.onViewCreated.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet widgetUserStatusSheet = WidgetUserStatusSheet.this;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                widgetUserStatusSheet.openCustomStatusAndDismiss(context);
            }
        });
        getBinding().f18432b.setOnClear(new C102456());
    }
}
