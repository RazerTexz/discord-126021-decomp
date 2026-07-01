package com.discord.widgets.guilds.leave;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.LeaveGuildDialogBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel;
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

/* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetLeaveGuildDialog.class, "binding", "getBinding()Lcom/discord/databinding/LeaveGuildDialogBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<LeaveGuildDialogViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LeaveGuildDialogViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetLeaveGuildDialog.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<LeaveGuildDialogViewModel.Event, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LeaveGuildDialogViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetLeaveGuildDialog.this.handleEvent(event);
        }
    }

    public WidgetLeaveGuildDialog() {
        super(R.layout.leave_guild_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetLeaveGuildDialog2.INSTANCE, null, 2, null);
        WidgetLeaveGuildDialog3 widgetLeaveGuildDialog3 = new WidgetLeaveGuildDialog3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(LeaveGuildDialogViewModel.class), new WidgetLeaveGuildDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetLeaveGuildDialog3));
    }

    private final void configureUI(LeaveGuildDialogViewModel.ViewState viewState) {
        if (!(viewState instanceof LeaveGuildDialogViewModel.ViewState.Valid)) {
            if (Intrinsics3.areEqual(viewState, LeaveGuildDialogViewModel.ViewState.Invalid.INSTANCE)) {
                dismiss();
                return;
            }
            return;
        }
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.leaveGuildDialogHeader");
        LeaveGuildDialogViewModel.ViewState.Valid valid = (LeaveGuildDialogViewModel.ViewState.Valid) viewState;
        FormatUtils.m(textView, R.string.leave_server_title, new Object[]{valid.getGuild().getName()}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.leaveGuildDialogBody");
        FormatUtils.m(textView2, valid.getGuild().isHub() ? R.string.leave_hub_body : R.string.leave_server_body_mobile, new Object[]{valid.getGuild().getName()}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().c.setText(getString(valid.getGuild().isHub() ? R.string.leave_hub : R.string.leave_server));
        getBinding().c.setIsLoading(valid.isLoading());
    }

    private final LeaveGuildDialogBinding getBinding() {
        return (LeaveGuildDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final LeaveGuildDialogViewModel getViewModel() {
        return (LeaveGuildDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(LeaveGuildDialogViewModel.Event event) {
        if (Intrinsics3.areEqual(event, LeaveGuildDialogViewModel.Event.Dismiss.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog.onResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetLeaveGuildDialog.this.getViewModel().leaveGuild();
            }
        });
        getBinding().f2128b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog.onResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetLeaveGuildDialog.this.dismiss();
            }
        });
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetLeaveGuildDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetLeaveGuildDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
    }
}
