package com.discord.widgets.stage.start;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity$Transition;
import com.discord.databinding.WidgetModeratorStartStageBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.calls.CallEventsButtonView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion$Action;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$Companion;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetModeratorStartStage extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetModeratorStartStage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetModeratorStartStageBinding;", 0)};
    public static final WidgetModeratorStartStage$Companion Companion = new WidgetModeratorStartStage$Companion(null);
    private ModeratorStartStageAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetModeratorStartStage() {
        super(R$layout.widget_moderator_start_stage);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetModeratorStartStage$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetModeratorStartStage$channelId$2(this));
        this.guildId = g.lazy(new WidgetModeratorStartStage$guildId$2(this));
        WidgetModeratorStartStage$viewModel$2 widgetModeratorStartStage$viewModel$2 = new WidgetModeratorStartStage$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ModeratorStartStageViewModel.class), new WidgetModeratorStartStage$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetModeratorStartStage$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.Companion.createJoinOnStartActivityRegistration(this, new WidgetModeratorStartStage$previewLauncher$1(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetModeratorStartStage widgetModeratorStartStage, ModeratorStartStageViewModel$ViewState moderatorStartStageViewModel$ViewState) {
        widgetModeratorStartStage.configureUi(moderatorStartStageViewModel$ViewState);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetModeratorStartStage widgetModeratorStartStage) {
        return widgetModeratorStartStage.getChannelId();
    }

    public static final /* synthetic */ ModeratorStartStageViewModel access$getViewModel$p(WidgetModeratorStartStage widgetModeratorStartStage) {
        return widgetModeratorStartStage.getViewModel();
    }

    public static final /* synthetic */ void access$handleListItemClick(WidgetModeratorStartStage widgetModeratorStartStage, ModeratorStartStageItem moderatorStartStageItem) {
        widgetModeratorStartStage.handleListItemClick(moderatorStartStageItem);
    }

    public static final /* synthetic */ void access$launchStageCall(WidgetModeratorStartStage widgetModeratorStartStage, long j) {
        widgetModeratorStartStage.launchStageCall(j);
    }

    private final void configureToolbar(ModeratorStartStageViewModel$ViewState viewState) {
        CallEventsButtonView callEventsButtonView = getBinding().d;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        callEventsButtonView.a(parentFragmentManager, getGuildId(), getChannelId(), viewState.getChannelEvents());
    }

    private final void configureUi(ModeratorStartStageViewModel$ViewState viewState) {
        if (viewState.getChannelEventActive()) {
            launchStageCall(getChannelId());
            return;
        }
        configureToolbar(viewState);
        ModeratorStartStageAdapter moderatorStartStageAdapter = this.adapter;
        if (moderatorStartStageAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        moderatorStartStageAdapter.setData(viewState.getItems());
    }

    private final WidgetModeratorStartStageBinding getBinding() {
        return (WidgetModeratorStartStageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final ModeratorStartStageViewModel getViewModel() {
        return (ModeratorStartStageViewModel) this.viewModel.getValue();
    }

    private final void handleListItemClick(ModeratorStartStageItem item) {
        if (item instanceof ModeratorStartStageItem$ListItem$StaticOption$StartStage) {
            WidgetStageStartEventBottomSheet$Companion widgetStageStartEventBottomSheet$Companion = WidgetStageStartEventBottomSheet.Companion;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetStageStartEventBottomSheet$Companion.show(parentFragmentManager, getChannelId(), new WidgetModeratorStartStage$handleListItemClick$1(this));
            return;
        }
        if (item instanceof ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent) {
            WidgetGuildScheduledEventLocationSelect.Companion.launch(requireContext(), getGuildId(), Long.valueOf(getChannelId()));
            return;
        }
        if (!(item instanceof ModeratorStartStageItem$ListItem$Event)) {
            if (item instanceof ModeratorStartStageItem$Continue) {
                launchStageCall(getChannelId());
            }
        } else {
            ModeratorStartStageItem$ListItem$Event moderatorStartStageItem$ListItem$Event = (ModeratorStartStageItem$ListItem$Event) item;
            WidgetPreviewGuildScheduledEvent$Companion.launch$default(WidgetPreviewGuildScheduledEvent.Companion, requireContext(), GuildScheduledEventModelKt.toModel(moderatorStartStageItem$ListItem$Event.getEvent()), new WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData(moderatorStartStageItem$ListItem$Event.getEvent().getId(), WidgetPreviewGuildScheduledEvent$Companion$Action.START_EVENT), this.previewLauncher, false, 16, null);
        }
    }

    private final void launchStageCall(long channelId) {
        WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, requireContext(), channelId, true, null, AppTransitionActivity$Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 8, null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = new ModeratorStartStageAdapter(recyclerView, new WidgetModeratorStartStage$onViewBound$1(this));
        RecyclerView recyclerView2 = getBinding().c;
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        ModeratorStartStageAdapter moderatorStartStageAdapter = this.adapter;
        if (moderatorStartStageAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(moderatorStartStageAdapter);
        getBinding().f2497b.setOnClickListener(new WidgetModeratorStartStage$onViewBound$3(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetModeratorStartStage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetModeratorStartStage$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
