package com.discord.widgets.guilds.leave;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.LeaveGuildDialogBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetLeaveGuildDialog.class, "binding", "getBinding()Lcom/discord/databinding/LeaveGuildDialogBinding;", 0)};
    public static final WidgetLeaveGuildDialog$Companion Companion = new WidgetLeaveGuildDialog$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetLeaveGuildDialog() {
        super(R$layout.leave_guild_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetLeaveGuildDialog$binding$2.INSTANCE, null, 2, null);
        WidgetLeaveGuildDialog$viewModel$2 widgetLeaveGuildDialog$viewModel$2 = new WidgetLeaveGuildDialog$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(LeaveGuildDialogViewModel.class), new WidgetLeaveGuildDialog$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetLeaveGuildDialog$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetLeaveGuildDialog widgetLeaveGuildDialog, LeaveGuildDialogViewModel$ViewState leaveGuildDialogViewModel$ViewState) {
        widgetLeaveGuildDialog.configureUI(leaveGuildDialogViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetLeaveGuildDialog widgetLeaveGuildDialog) {
        return widgetLeaveGuildDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ LeaveGuildDialogViewModel access$getViewModel$p(WidgetLeaveGuildDialog widgetLeaveGuildDialog) {
        return widgetLeaveGuildDialog.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetLeaveGuildDialog widgetLeaveGuildDialog, LeaveGuildDialogViewModel$Event leaveGuildDialogViewModel$Event) {
        widgetLeaveGuildDialog.handleEvent(leaveGuildDialogViewModel$Event);
    }

    private final void configureUI(LeaveGuildDialogViewModel$ViewState viewState) {
        if (!(viewState instanceof LeaveGuildDialogViewModel$ViewState$Valid)) {
            if (m.areEqual(viewState, LeaveGuildDialogViewModel$ViewState$Invalid.INSTANCE)) {
                dismiss();
                return;
            }
            return;
        }
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.leaveGuildDialogHeader");
        LeaveGuildDialogViewModel$ViewState$Valid leaveGuildDialogViewModel$ViewState$Valid = (LeaveGuildDialogViewModel$ViewState$Valid) viewState;
        b.n(textView, 2131892539, new Object[]{leaveGuildDialogViewModel$ViewState$Valid.getGuild().getName()}, null, 4);
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.leaveGuildDialogBody");
        b.n(textView2, leaveGuildDialogViewModel$ViewState$Valid.getGuild().isHub() ? 2131892535 : 2131892538, new Object[]{leaveGuildDialogViewModel$ViewState$Valid.getGuild().getName()}, null, 4);
        getBinding().c.setText(getString(leaveGuildDialogViewModel$ViewState$Valid.getGuild().isHub() ? 2131892534 : 2131892536));
        getBinding().c.setIsLoading(leaveGuildDialogViewModel$ViewState$Valid.isLoading());
    }

    private final LeaveGuildDialogBinding getBinding() {
        return (LeaveGuildDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final LeaveGuildDialogViewModel getViewModel() {
        return (LeaveGuildDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(LeaveGuildDialogViewModel$Event event) {
        if (m.areEqual(event, LeaveGuildDialogViewModel$Event$Dismiss.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().c.setOnClickListener(new WidgetLeaveGuildDialog$onResume$1(this));
        getBinding().f2128b.setOnClickListener(new WidgetLeaveGuildDialog$onResume$2(this));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetLeaveGuildDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetLeaveGuildDialog$onResume$3(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetLeaveGuildDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetLeaveGuildDialog$onResume$4(this), 62, (Object) null);
    }
}
