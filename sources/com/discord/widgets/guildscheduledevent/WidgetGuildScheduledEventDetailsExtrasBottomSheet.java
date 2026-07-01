package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.notice.WidgetNoticeDialog;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean actionTaken;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet2 args) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(args, "args");
            WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet = new WidgetGuildScheduledEventDetailsExtrasBottomSheet();
            widgetGuildScheduledEventDetailsExtrasBottomSheet.setArguments(AnimatableValueParser.e2(args));
            widgetGuildScheduledEventDetailsExtrasBottomSheet.show(fragmentManager, WidgetGuildScheduledEventDetailsExtrasBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState $viewState;

        /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
            public static final class C02961 extends Lambda implements Function0<Unit> {
                public C02961() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.dismiss();
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                GuildScheduledEventDetailsViewModel viewModel = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.getViewModel();
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                viewModel.onDeleteButtonClicked(contextRequireContext, new C02961());
            }
        }

        public AnonymousClass5(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            FragmentManager childFragmentManager = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext().getString(R.string.delete_event);
            Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetNoticeDialog.Companion.show$default(companion, childFragmentManager, string, FormatUtils.b(contextRequireContext, R.string.delete_stage_event_confirmation_description, new Object[]{((GuildScheduledEventDetailsViewModel.ViewState.Initialized) this.$viewState).getGuildScheduledEvent().getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null), WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext().getString(R.string.delete_event), WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext().getString(R.string.back), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1())), null, null, null, null, null, null, 0, null, 16320, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildScheduledEventDetailsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
            super(1, widgetGuildScheduledEventDetailsExtrasBottomSheet, WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildScheduledEventDetailsExtrasBottomSheet) this.receiver).configureUi(viewState);
        }
    }

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventDetailsExtrasBottomSheet2.INSTANCE, null, 2, null);
        this.args = LazyJVM.lazy(new WidgetGuildScheduledEventDetailsExtrasBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetGuildScheduledEventDetailsExtrasBottomSheet5 widgetGuildScheduledEventDetailsExtrasBottomSheet5 = new WidgetGuildScheduledEventDetailsExtrasBottomSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildScheduledEventDetailsViewModel.class), new WidgetGuildScheduledEventDetailsExtrasBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventDetailsExtrasBottomSheet5));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventDetailsExtrasBottomSheet4(this));
    }

    private final void configureUi(final GuildScheduledEventDetailsViewModel.ViewState viewState) {
        String string;
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel.ViewState.Initialized)) {
            dismiss();
            return;
        }
        GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized = (GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState;
        final boolean canStartEvent = initialized.getCanStartEvent();
        final GuildScheduledEventUtilities2 eventTiming = GuildScheduledEventUtilities5.getEventTiming(initialized.getGuildScheduledEvent());
        TextView textView = getBinding().f;
        textView.setVisibility(canStartEvent && eventTiming.isStartable() ? 0 : 8);
        boolean zIsRsvped = initialized.isRsvped();
        if (zIsRsvped) {
            string = getString(R.string.event_mark_not_interested);
        } else {
            if (zIsRsvped) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(R.string.event_mark_interested);
        }
        textView.setText(string);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().onRsvpButtonClicked();
            }
        });
        TextView textView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.startEvent");
        textView2.setVisibility(canStartEvent && eventTiming.isLongStartable() ? 0 : 8);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launch(contextRequireContext, GuildScheduledEventModel2.toModel(((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent()), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.previewLauncher, (24 & 16) != 0 ? false : false);
            }
        });
        TextView textView3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.editEvent");
        textView3.setVisibility(canStartEvent ? 0 : 8);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.dismissWithActionTaken();
                WidgetGuildScheduledEventLocationSelect.Companion companion = WidgetGuildScheduledEventLocationSelect.INSTANCE;
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launchForEdit(contextRequireContext, ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getGuildId(), ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getId());
            }
        });
        boolean z2 = eventTiming == GuildScheduledEventUtilities2.LIVE;
        TextView textView4 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.endEvent");
        textView4.setVisibility(canStartEvent && z2 ? 0 : 8);
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi.4

            /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$4$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.dismissWithActionTaken();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildScheduledEventDetailsViewModel viewModel = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.getViewModel();
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                viewModel.endEventClicked(contextRequireContext, new AnonymousClass1());
            }
        });
        TextView textView5 = getBinding().f2445b;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.cancelEvent");
        textView5.setVisibility(initialized.getCanStartEvent() && !z2 ? 0 : 8);
        getBinding().f2445b.setOnClickListener(new AnonymousClass5(viewState));
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.dismissWithActionTaken();
                WidgetMobileReports.Companion companion = WidgetMobileReports.INSTANCE;
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launchGuildScheduledEventReport(contextRequireContext, ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getGuildId(), ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getId());
            }
        });
        TextView textView6 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.copyId");
        textView6.setVisibility(initialized.isDeveloperMode() ? 0 : 8);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.dismissWithActionTaken();
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                AppToast.c(contextRequireContext, String.valueOf(((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getId()), 0, 4);
            }
        });
    }

    private final void dismissWithActionTaken() {
        this.actionTaken = true;
        dismiss();
    }

    private final GuildScheduledEventDetailsViewModel getViewModel() {
        return (GuildScheduledEventDetailsViewModel) this.viewModel.getValue();
    }

    public final WidgetGuildScheduledEventDetailsBottomSheet2 getArgs() {
        return (WidgetGuildScheduledEventDetailsBottomSheet2) this.args.getValue();
    }

    public final WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_scheduled_event_details_extras_bottom_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.actionTaken) {
            return;
        }
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, getArgs());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
