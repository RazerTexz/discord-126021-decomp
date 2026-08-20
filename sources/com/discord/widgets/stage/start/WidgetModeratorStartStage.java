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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetModeratorStartStageBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.calls.CallEventsButtonView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetModeratorStartStage extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetModeratorStartStage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetModeratorStartStageBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long channelId, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            C0870j.m156d(context, WidgetModeratorStartStage.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$handleListItemClick$1 */
    /* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
    public static final class C100711 extends AbstractC12240o implements Function0<Unit> {
        public C100711() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetModeratorStartStage widgetModeratorStartStage = WidgetModeratorStartStage.this;
            widgetModeratorStartStage.launchStageCall(widgetModeratorStartStage.getChannelId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
    public static final /* synthetic */ class C100721 extends C12236k implements Function1<ModeratorStartStageItem, Unit> {
        public C100721(WidgetModeratorStartStage widgetModeratorStartStage) {
            super(1, widgetModeratorStartStage, WidgetModeratorStartStage.class, "handleListItemClick", "handleListItemClick(Lcom/discord/widgets/stage/start/ModeratorStartStageItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModeratorStartStageItem moderatorStartStageItem) {
            invoke2(moderatorStartStageItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModeratorStartStageItem moderatorStartStageItem) {
            C12238m.checkNotNullParameter(moderatorStartStageItem, "p1");
            ((WidgetModeratorStartStage) this.receiver).handleListItemClick(moderatorStartStageItem);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
    public static final /* synthetic */ class C100741 extends C12236k implements Function1<ModeratorStartStageViewModel.ViewState, Unit> {
        public C100741(WidgetModeratorStartStage widgetModeratorStartStage) {
            super(1, widgetModeratorStartStage, WidgetModeratorStartStage.class, "configureUi", "configureUi(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModeratorStartStageViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModeratorStartStageViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetModeratorStartStage) this.receiver).configureUi(viewState);
        }
    }

    public WidgetModeratorStartStage() {
        super(C5419R.layout.widget_moderator_start_stage);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetModeratorStartStage$binding$2.INSTANCE, null, 2, null);
        this.channelId = C12083g.lazy(new WidgetModeratorStartStage$channelId$2(this));
        this.guildId = C12083g.lazy(new WidgetModeratorStartStage$guildId$2(this));
        WidgetModeratorStartStage$viewModel$2 widgetModeratorStartStage$viewModel$2 = new WidgetModeratorStartStage$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ModeratorStartStageViewModel.class), new WidgetModeratorStartStage$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetModeratorStartStage$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetModeratorStartStage$previewLauncher$1(this));
    }

    private final void configureToolbar(ModeratorStartStageViewModel.ViewState viewState) {
        CallEventsButtonView callEventsButtonView = getBinding().f17273d;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        callEventsButtonView.m8573a(parentFragmentManager, getGuildId(), getChannelId(), viewState.getChannelEvents());
    }

    private final void configureUi(ModeratorStartStageViewModel.ViewState viewState) {
        if (viewState.getChannelEventActive()) {
            launchStageCall(getChannelId());
            return;
        }
        configureToolbar(viewState);
        ModeratorStartStageAdapter moderatorStartStageAdapter = this.adapter;
        if (moderatorStartStageAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
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
        if (item instanceof ModeratorStartStageItem.ListItem.StaticOption.StartStage) {
            WidgetStageStartEventBottomSheet.Companion companion = WidgetStageStartEventBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, getChannelId(), new C100711());
            return;
        }
        if (item instanceof ModeratorStartStageItem.ListItem.StaticOption.ScheduleEvent) {
            WidgetGuildScheduledEventLocationSelect.INSTANCE.launch(requireContext(), getGuildId(), Long.valueOf(getChannelId()));
            return;
        }
        if (!(item instanceof ModeratorStartStageItem.ListItem.Event)) {
            if (item instanceof ModeratorStartStageItem.Continue) {
                launchStageCall(getChannelId());
            }
        } else {
            ModeratorStartStageItem.ListItem.Event event = (ModeratorStartStageItem.ListItem.Event) item;
            WidgetPreviewGuildScheduledEvent.INSTANCE.launch(requireContext(), GuildScheduledEventModelKt.toModel(event.getEvent()), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(event.getEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : this.previewLauncher, (24 & 16) != 0 ? false : false);
        }
    }

    private final void launchStageCall(long channelId) {
        WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), channelId, true, null, AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 8, null);
        FragmentActivity fragmentActivityM95e = m95e();
        if (fragmentActivityM95e != null) {
            fragmentActivityM95e.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f17272c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = new ModeratorStartStageAdapter(recyclerView, new C100721(this));
        RecyclerView recyclerView2 = getBinding().f17272c;
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        ModeratorStartStageAdapter moderatorStartStageAdapter = this.adapter;
        if (moderatorStartStageAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(moderatorStartStageAdapter);
        getBinding().f17271b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.start.WidgetModeratorStartStage.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetModeratorStartStage.this.getViewModel().disconnectFromStage();
                FragmentActivity fragmentActivityM95e = WidgetModeratorStartStage.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.finish();
                }
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetModeratorStartStage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100741(this));
    }
}
