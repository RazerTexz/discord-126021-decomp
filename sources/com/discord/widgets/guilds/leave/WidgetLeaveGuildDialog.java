package com.discord.widgets.guilds.leave;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.LeaveGuildDialogBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetLeaveGuildDialog.class, "binding", "getBinding()Lcom/discord/databinding/LeaveGuildDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            WidgetLeaveGuildDialog widgetLeaveGuildDialog = new WidgetLeaveGuildDialog();
            widgetLeaveGuildDialog.setArguments(bundle);
            widgetLeaveGuildDialog.show(fragmentManager, WidgetLeaveGuildDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$3 */
    /* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
    public static final class C87323 extends AbstractC12240o implements Function1<LeaveGuildDialogViewModel.ViewState, Unit> {
        public C87323() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LeaveGuildDialogViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetLeaveGuildDialog.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$4 */
    /* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
    public static final class C87334 extends AbstractC12240o implements Function1<LeaveGuildDialogViewModel.Event, Unit> {
        public C87334() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LeaveGuildDialogViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetLeaveGuildDialog.this.handleEvent(event);
        }
    }

    public WidgetLeaveGuildDialog() {
        super(C5419R.layout.leave_guild_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetLeaveGuildDialog$binding$2.INSTANCE, null, 2, null);
        WidgetLeaveGuildDialog$viewModel$2 widgetLeaveGuildDialog$viewModel$2 = new WidgetLeaveGuildDialog$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(LeaveGuildDialogViewModel.class), new WidgetLeaveGuildDialog$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetLeaveGuildDialog$viewModel$2));
    }

    private final void configureUI(LeaveGuildDialogViewModel.ViewState viewState) {
        if (!(viewState instanceof LeaveGuildDialogViewModel.ViewState.Valid)) {
            if (C12238m.areEqual(viewState, LeaveGuildDialogViewModel.ViewState.Invalid.INSTANCE)) {
                dismiss();
                return;
            }
            return;
        }
        TextView textView = getBinding().f15181e;
        C12238m.checkNotNullExpressionValue(textView, "binding.leaveGuildDialogHeader");
        LeaveGuildDialogViewModel.ViewState.Valid valid = (LeaveGuildDialogViewModel.ViewState.Valid) viewState;
        C1107b.m221m(textView, C5419R.string.leave_server_title, new Object[]{valid.getGuild().getName()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = getBinding().f15180d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.leaveGuildDialogBody");
        C1107b.m221m(textView2, valid.getGuild().isHub() ? C5419R.string.leave_hub_body : C5419R.string.leave_server_body_mobile, new Object[]{valid.getGuild().getName()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f15179c.setText(getString(valid.getGuild().isHub() ? C5419R.string.leave_hub : C5419R.string.leave_server));
        getBinding().f15179c.setIsLoading(valid.isLoading());
    }

    private final LeaveGuildDialogBinding getBinding() {
        return (LeaveGuildDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final LeaveGuildDialogViewModel getViewModel() {
        return (LeaveGuildDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(LeaveGuildDialogViewModel.Event event) {
        if (C12238m.areEqual(event, LeaveGuildDialogViewModel.Event.Dismiss.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().f15179c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog.onResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetLeaveGuildDialog.this.getViewModel().leaveGuild();
            }
        });
        getBinding().f15178b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog.onResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetLeaveGuildDialog.this.dismiss();
            }
        });
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetLeaveGuildDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87323());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetLeaveGuildDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87334());
    }
}
