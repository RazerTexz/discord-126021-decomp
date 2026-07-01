package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.e4;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.presence.ClientStatus;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUserStatusUpdateBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Source;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserStatusSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", 0)};
    public static final WidgetUserStatusSheet$Companion Companion = new WidgetUserStatusSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetUserStatusSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserStatusSheet$binding$2.INSTANCE, null, 2, null);
        WidgetUserStatusSheet$viewModel$2 widgetUserStatusSheet$viewModel$2 = WidgetUserStatusSheet$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetUserStatusSheetViewModel.class), new WidgetUserStatusSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetUserStatusSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$clearCustomStatus(WidgetUserStatusSheet widgetUserStatusSheet) {
        widgetUserStatusSheet.clearCustomStatus();
    }

    public static final /* synthetic */ void access$openCustomStatusAndDismiss(WidgetUserStatusSheet widgetUserStatusSheet, Context context) {
        widgetUserStatusSheet.openCustomStatusAndDismiss(context);
    }

    public static final /* synthetic */ void access$updateStateAndDismiss(WidgetUserStatusSheet widgetUserStatusSheet, ClientStatus clientStatus) {
        widgetUserStatusSheet.updateStateAndDismiss(clientStatus);
    }

    public static final /* synthetic */ void access$updateView(WidgetUserStatusSheet widgetUserStatusSheet, WidgetUserStatusSheetViewModel$ViewState widgetUserStatusSheetViewModel$ViewState) {
        widgetUserStatusSheet.updateView(widgetUserStatusSheetViewModel$ViewState);
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
        AnalyticsTracker.INSTANCE.openModal("Custom Status Modal", new Traits$Source(null, "Account Panel", "Avatar", null, null, 25, null));
        WidgetUserSetCustomStatus.Companion.launch(context);
        dismiss();
    }

    @MainThread
    private final void updateStateAndDismiss(ClientStatus status) {
        getViewModel().setStatus(status);
        dismiss();
    }

    private final void updateView(WidgetUserStatusSheetViewModel$ViewState viewState) {
        if (viewState instanceof WidgetUserStatusSheetViewModel$ViewState$Loaded) {
            getBinding().f2698b.updateViewState(((WidgetUserStatusSheetViewModel$ViewState$Loaded) viewState).getCustomStatusViewState());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_user_status_update;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetUserStatusSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserStatusSheet$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f.f106b.setImageResource(2131232163);
        getBinding().f.d.setText(2131895916);
        e4 e4Var = getBinding().f;
        m.checkNotNullExpressionValue(e4Var, "binding.userStatusUpdateOnline");
        e4Var.a.setOnClickListener(new WidgetUserStatusSheet$onViewCreated$1(this));
        getBinding().d.f106b.setImageResource(2131232161);
        getBinding().d.d.setText(2131895912);
        e4 e4Var2 = getBinding().d;
        m.checkNotNullExpressionValue(e4Var2, "binding.userStatusUpdateIdle");
        e4Var2.a.setOnClickListener(new WidgetUserStatusSheet$onViewCreated$2(this));
        getBinding().c.f106b.setImageResource(2131232160);
        getBinding().c.d.setText(2131895910);
        getBinding().c.c.setText(2131895911);
        e4 e4Var3 = getBinding().c;
        m.checkNotNullExpressionValue(e4Var3, "binding.userStatusUpdateDnd");
        e4Var3.a.setOnClickListener(new WidgetUserStatusSheet$onViewCreated$3(this));
        getBinding().e.f106b.setImageResource(2131232162);
        getBinding().e.d.setText(2131895913);
        getBinding().e.c.setText(2131895914);
        e4 e4Var4 = getBinding().e;
        m.checkNotNullExpressionValue(e4Var4, "binding.userStatusUpdateInvisible");
        e4Var4.a.setOnClickListener(new WidgetUserStatusSheet$onViewCreated$4(this));
        getBinding().f2698b.setOnClickListener(new WidgetUserStatusSheet$onViewCreated$5(this));
        getBinding().f2698b.setOnClear(new WidgetUserStatusSheet$onViewCreated$6(this));
    }
}
