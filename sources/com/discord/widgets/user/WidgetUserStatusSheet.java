package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.ViewUserStatusPresenceBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.presence.ClientStatus;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUserStatusUpdateBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserStatusSheetViewModel;
import d0.z.d.FunctionReferenceImpl;
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

/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserStatusSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            WidgetUserStatusSheet widgetUserStatusSheet = new WidgetUserStatusSheet();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetUserStatusSheet.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetUserStatusSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetUserStatusSheet widgetUserStatusSheet) {
            super(1, widgetUserStatusSheet, WidgetUserStatusSheet.class, "updateView", "updateView(Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserStatusSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserStatusSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetUserStatusSheet) this.receiver).updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserStatusSheet.this.clearCustomStatus();
        }
    }

    public WidgetUserStatusSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserStatusSheet2.INSTANCE, null, 2, null);
        WidgetUserStatusSheet3 widgetUserStatusSheet3 = WidgetUserStatusSheet3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetUserStatusSheetViewModel.class), new WidgetUserStatusSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetUserStatusSheet3));
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
            getBinding().f2698b.updateViewState(((WidgetUserStatusSheetViewModel.ViewState.Loaded) viewState).getCustomStatusViewState());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_user_status_update;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetUserStatusSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f.f106b.setImageResource(R.drawable.ic_status_online_16dp);
        getBinding().f.d.setText(R.string.status_online);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding, "binding.userStatusUpdateOnline");
        viewUserStatusPresenceBinding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserStatusSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet.this.updateStateAndDismiss(ClientStatus.ONLINE);
            }
        });
        getBinding().d.f106b.setImageResource(R.drawable.ic_status_idle_16dp);
        getBinding().d.d.setText(R.string.status_idle);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding2, "binding.userStatusUpdateIdle");
        viewUserStatusPresenceBinding2.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserStatusSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet.this.updateStateAndDismiss(ClientStatus.IDLE);
            }
        });
        getBinding().c.f106b.setImageResource(R.drawable.ic_status_dnd_16dp);
        getBinding().c.d.setText(R.string.status_dnd);
        getBinding().c.c.setText(R.string.status_dnd_help);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding3, "binding.userStatusUpdateDnd");
        viewUserStatusPresenceBinding3.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserStatusSheet.onViewCreated.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet.this.updateStateAndDismiss(ClientStatus.DND);
            }
        });
        getBinding().e.f106b.setImageResource(R.drawable.ic_status_invisible_16dp);
        getBinding().e.d.setText(R.string.status_invisible);
        getBinding().e.c.setText(R.string.status_invisible_helper);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding4 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding4, "binding.userStatusUpdateInvisible");
        viewUserStatusPresenceBinding4.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserStatusSheet.onViewCreated.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet.this.updateStateAndDismiss(ClientStatus.INVISIBLE);
            }
        });
        getBinding().f2698b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserStatusSheet.onViewCreated.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserStatusSheet widgetUserStatusSheet = WidgetUserStatusSheet.this;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                widgetUserStatusSheet.openCustomStatusAndDismiss(context);
            }
        });
        getBinding().f2698b.setOnClear(new AnonymousClass6());
    }
}
