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
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.notice.WidgetNoticeDialog;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", 0)};

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

        public final void show(FragmentManager fragmentManager, GuildScheduledEventDetailsArgs args) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(args, "args");
            WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet = new WidgetGuildScheduledEventDetailsExtrasBottomSheet();
            widgetGuildScheduledEventDetailsExtrasBottomSheet.setArguments(C1460d.m514e2(args));
            widgetGuildScheduledEventDetailsExtrasBottomSheet.show(fragmentManager, WidgetGuildScheduledEventDetailsExtrasBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    public static final class ViewOnClickListenerC88805 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState $viewState;

        /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
            public static final class C132861 extends AbstractC12240o implements Function0<Unit> {
                public C132861() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
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
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "it");
                GuildScheduledEventDetailsViewModel viewModel = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.getViewModel();
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                viewModel.onDeleteButtonClicked(contextRequireContext, new C132861());
            }
        }

        public ViewOnClickListenerC88805(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            FragmentManager childFragmentManager = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.getChildFragmentManager();
            C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext().getString(C5419R.string.delete_event);
            Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetNoticeDialog.Companion.show$default(companion, childFragmentManager, string, C1107b.m210b(contextRequireContext, C5419R.string.delete_stage_event_confirmation_description, new Object[]{((GuildScheduledEventDetailsViewModel.ViewState.Initialized) this.$viewState).getGuildScheduledEvent().getName()}, (4 & 4) != 0 ? C1107b.b.f1491j : null), WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext().getString(C5419R.string.delete_event), WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext().getString(C5419R.string.back), C12134g0.mapOf(C12116o.m10073to(Integer.valueOf(C5419R.id.notice_ok), new AnonymousClass1())), null, null, null, null, null, null, 0, null, 16320, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    public static final /* synthetic */ class C88831 extends C12236k implements Function1<GuildScheduledEventDetailsViewModel.ViewState, Unit> {
        public C88831(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
            super(1, widgetGuildScheduledEventDetailsExtrasBottomSheet, WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildScheduledEventDetailsExtrasBottomSheet) this.receiver).configureUi(viewState);
        }
    }

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventDetailsExtrasBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.args = C12083g.lazy(new C8874x86406bd1(this, "intent_args_key"));
        WidgetGuildScheduledEventDetailsExtrasBottomSheet$viewModel$2 widgetGuildScheduledEventDetailsExtrasBottomSheet$viewModel$2 = new WidgetGuildScheduledEventDetailsExtrasBottomSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildScheduledEventDetailsViewModel.class), new C8875xf108016c(c0865g0), new C0869i0(widgetGuildScheduledEventDetailsExtrasBottomSheet$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new C8884xeb9cb6fc(this));
    }

    private final void configureUi(final GuildScheduledEventDetailsViewModel.ViewState viewState) {
        String string;
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel.ViewState.Initialized)) {
            dismiss();
            return;
        }
        GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized = (GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState;
        final boolean canStartEvent = initialized.getCanStartEvent();
        final GuildScheduledEventTiming eventTiming = GuildScheduledEventUtilitiesKt.getEventTiming(initialized.getGuildScheduledEvent());
        TextView textView = getBinding().f17006f;
        textView.setVisibility(canStartEvent && eventTiming.isStartable() ? 0 : 8);
        boolean zIsRsvped = initialized.isRsvped();
        if (zIsRsvped) {
            string = getString(C5419R.string.event_mark_not_interested);
        } else {
            if (zIsRsvped) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(C5419R.string.event_mark_interested);
        }
        textView.setText(string);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().onRsvpButtonClicked();
            }
        });
        TextView textView2 = getBinding().f17008h;
        C12238m.checkNotNullExpressionValue(textView2, "binding.startEvent");
        textView2.setVisibility(canStartEvent && eventTiming.isLongStartable() ? 0 : 8);
        getBinding().f17008h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launch(contextRequireContext, GuildScheduledEventModelKt.toModel(((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent()), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.previewLauncher, (24 & 16) != 0 ? false : false);
            }
        });
        TextView textView3 = getBinding().f17004d;
        C12238m.checkNotNullExpressionValue(textView3, "binding.editEvent");
        textView3.setVisibility(canStartEvent ? 0 : 8);
        getBinding().f17004d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.dismissWithActionTaken();
                WidgetGuildScheduledEventLocationSelect.Companion companion = WidgetGuildScheduledEventLocationSelect.INSTANCE;
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launchForEdit(contextRequireContext, ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getGuildId(), ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getId());
            }
        });
        boolean z2 = eventTiming == GuildScheduledEventTiming.LIVE;
        TextView textView4 = getBinding().f17005e;
        C12238m.checkNotNullExpressionValue(textView4, "binding.endEvent");
        textView4.setVisibility(canStartEvent && z2 ? 0 : 8);
        getBinding().f17005e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi.4

            /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$4$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
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
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                viewModel.endEventClicked(contextRequireContext, new AnonymousClass1());
            }
        });
        TextView textView5 = getBinding().f17002b;
        C12238m.checkNotNullExpressionValue(textView5, "binding.cancelEvent");
        textView5.setVisibility(initialized.getCanStartEvent() && !z2 ? 0 : 8);
        getBinding().f17002b.setOnClickListener(new ViewOnClickListenerC88805(viewState));
        getBinding().f17007g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.dismissWithActionTaken();
                WidgetMobileReports.Companion companion = WidgetMobileReports.INSTANCE;
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launchGuildScheduledEventReport(contextRequireContext, ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getGuildId(), ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getId());
            }
        });
        TextView textView6 = getBinding().f17003c;
        C12238m.checkNotNullExpressionValue(textView6, "binding.copyId");
        textView6.setVisibility(initialized.isDeveloperMode() ? 0 : 8);
        getBinding().f17003c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.dismissWithActionTaken();
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                C0876m.m165c(contextRequireContext, String.valueOf(((GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState).getGuildScheduledEvent().getId()), 0, 4);
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

    public final GuildScheduledEventDetailsArgs getArgs() {
        return (GuildScheduledEventDetailsArgs) this.args.getValue();
    }

    public final WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_scheduled_event_details_extras_bottom_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        C12238m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.actionTaken) {
            return;
        }
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, getArgs());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88831(this));
    }
}
