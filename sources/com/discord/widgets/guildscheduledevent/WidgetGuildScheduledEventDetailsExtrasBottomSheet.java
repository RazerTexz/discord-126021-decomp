package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", 0)};
    public static final WidgetGuildScheduledEventDetailsExtrasBottomSheet$Companion Companion = new WidgetGuildScheduledEventDetailsExtrasBottomSheet$Companion(null);
    private boolean actionTaken;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventDetailsExtrasBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.args = g.lazy(new WidgetGuildScheduledEventDetailsExtrasBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetGuildScheduledEventDetailsExtrasBottomSheet$viewModel$2 widgetGuildScheduledEventDetailsExtrasBottomSheet$viewModel$2 = new WidgetGuildScheduledEventDetailsExtrasBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildScheduledEventDetailsViewModel.class), new WidgetGuildScheduledEventDetailsExtrasBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildScheduledEventDetailsExtrasBottomSheet$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.Companion.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventDetailsExtrasBottomSheet$previewLauncher$1(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet, GuildScheduledEventDetailsViewModel$ViewState guildScheduledEventDetailsViewModel$ViewState) {
        widgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi(guildScheduledEventDetailsViewModel$ViewState);
    }

    public static final /* synthetic */ void access$dismissWithActionTaken(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
        widgetGuildScheduledEventDetailsExtrasBottomSheet.dismissWithActionTaken();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPreviewLauncher$p(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
        return widgetGuildScheduledEventDetailsExtrasBottomSheet.previewLauncher;
    }

    public static final /* synthetic */ GuildScheduledEventDetailsViewModel access$getViewModel$p(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
        return widgetGuildScheduledEventDetailsExtrasBottomSheet.getViewModel();
    }

    private final void configureUi(GuildScheduledEventDetailsViewModel$ViewState viewState) {
        String string;
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel$ViewState$Initialized)) {
            dismiss();
            return;
        }
        GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized = (GuildScheduledEventDetailsViewModel$ViewState$Initialized) viewState;
        boolean canStartEvent = guildScheduledEventDetailsViewModel$ViewState$Initialized.getCanStartEvent();
        GuildScheduledEventTiming eventTiming = GuildScheduledEventUtilitiesKt.getEventTiming(guildScheduledEventDetailsViewModel$ViewState$Initialized.getGuildScheduledEvent());
        TextView textView = getBinding().f;
        textView.setVisibility(canStartEvent && eventTiming.isStartable() ? 0 : 8);
        boolean zIsRsvped = guildScheduledEventDetailsViewModel$ViewState$Initialized.isRsvped();
        if (zIsRsvped) {
            string = getString(2131888894);
        } else {
            if (zIsRsvped) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(2131888893);
        }
        textView.setText(string);
        textView.setOnClickListener(new WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$$inlined$apply$lambda$1(this, canStartEvent, eventTiming, viewState));
        TextView textView2 = getBinding().h;
        m.checkNotNullExpressionValue(textView2, "binding.startEvent");
        textView2.setVisibility(canStartEvent && eventTiming.isLongStartable() ? 0 : 8);
        getBinding().h.setOnClickListener(new WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$2(this, viewState));
        TextView textView3 = getBinding().d;
        m.checkNotNullExpressionValue(textView3, "binding.editEvent");
        textView3.setVisibility(canStartEvent ? 0 : 8);
        getBinding().d.setOnClickListener(new WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$3(this, viewState));
        boolean z2 = eventTiming == GuildScheduledEventTiming.LIVE;
        TextView textView4 = getBinding().e;
        m.checkNotNullExpressionValue(textView4, "binding.endEvent");
        textView4.setVisibility(canStartEvent && z2 ? 0 : 8);
        getBinding().e.setOnClickListener(new WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$4(this));
        TextView textView5 = getBinding().f2445b;
        m.checkNotNullExpressionValue(textView5, "binding.cancelEvent");
        textView5.setVisibility(guildScheduledEventDetailsViewModel$ViewState$Initialized.getCanStartEvent() && !z2 ? 0 : 8);
        getBinding().f2445b.setOnClickListener(new WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5(this, viewState));
        getBinding().g.setOnClickListener(new WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$6(this, viewState));
        TextView textView6 = getBinding().c;
        m.checkNotNullExpressionValue(textView6, "binding.copyId");
        textView6.setVisibility(guildScheduledEventDetailsViewModel$ViewState$Initialized.isDeveloperMode() ? 0 : 8);
        getBinding().c.setOnClickListener(new WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$7(this, viewState));
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
        return R$layout.widget_guild_scheduled_event_details_extras_bottom_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.actionTaken) {
            return;
        }
        WidgetGuildScheduledEventDetailsBottomSheet$Companion widgetGuildScheduledEventDetailsBottomSheet$Companion = WidgetGuildScheduledEventDetailsBottomSheet.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGuildScheduledEventDetailsBottomSheet$Companion.show(parentFragmentManager, getArgs());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildScheduledEventDetailsExtrasBottomSheet$onResume$1(this), 62, (Object) null);
    }
}
