package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventListBottomSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.SpaceBetweenItemDecoration;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.voice.VoiceUtils;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildScheduledEventListBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventListBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private GuildScheduledEventListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            companion.show(fragmentManager, j, l);
        }

        public final void show(FragmentManager fragmentManager, long guildId, Long channelId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet = new WidgetGuildScheduledEventListBottomSheet();
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            if (channelId != null) {
                bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            widgetGuildScheduledEventListBottomSheet.setArguments(bundleM832T);
            widgetGuildScheduledEventListBottomSheet.show(fragmentManager, WidgetGuildScheduledEventListBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    public static final /* synthetic */ class C88861 extends C12236k implements Function1<GuildScheduledEventListViewModel.ViewState, Unit> {
        public C88861(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildScheduledEventListBottomSheet) this.receiver).configureUi(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    public static final /* synthetic */ class C88871 extends C12236k implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public C88871(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onEventCardClicked", "onEventCardClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetGuildScheduledEventListBottomSheet) this.receiver).onEventCardClicked(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    public static final /* synthetic */ class C88882 extends C12236k implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public C88882(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onRsvpClicked", "onRsvpClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetGuildScheduledEventListBottomSheet) this.receiver).onRsvpClicked(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$3 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    public static final /* synthetic */ class C88893 extends C12236k implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public C88893(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onEventStartClicked", "onEventStartClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetGuildScheduledEventListBottomSheet) this.receiver).onEventStartClicked(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$4 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    public static final /* synthetic */ class C88904 extends C12236k implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public C88904(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onJoinClicked", "onJoinClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetGuildScheduledEventListBottomSheet) this.receiver).onJoinClicked(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$5 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    public static final /* synthetic */ class C88915 extends C12236k implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public C88915(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onShareClicked", "onShareClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetGuildScheduledEventListBottomSheet) this.receiver).onShareClicked(event);
        }
    }

    public WidgetGuildScheduledEventListBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventListBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetGuildScheduledEventListBottomSheet$guildId$2(this));
        this.channelId = C12083g.lazy(new WidgetGuildScheduledEventListBottomSheet$channelId$2(this));
        WidgetGuildScheduledEventListBottomSheet$viewModel$2 widgetGuildScheduledEventListBottomSheet$viewModel$2 = new WidgetGuildScheduledEventListBottomSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildScheduledEventListViewModel.class), new C8885x80b84fbb(c0865g0), new C0869i0(widgetGuildScheduledEventListBottomSheet$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventListBottomSheet$previewLauncher$1(this));
    }

    private final void configureUi(GuildScheduledEventListViewModel.ViewState viewState) {
        if (!(viewState instanceof GuildScheduledEventListViewModel.ViewState.Loaded)) {
            viewState = null;
        }
        GuildScheduledEventListViewModel.ViewState.Loaded loaded = (GuildScheduledEventListViewModel.ViewState.Loaded) viewState;
        if (loaded != null) {
            TextView textView = getBinding().f17013e;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventListToolbarTitle");
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(StringResourceUtilsKt.getI18nPluralString(contextRequireContext, C5419R.plurals.guild_events_plural_number, loaded.getGuildScheduledEvents().size(), Integer.valueOf(loaded.getGuildScheduledEvents().size())));
            GuildScheduledEventListAdapter guildScheduledEventListAdapter = this.adapter;
            if (guildScheduledEventListAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("adapter");
            }
            guildScheduledEventListAdapter.setData(loaded.getGuildScheduledEvents());
            TextView textView2 = getBinding().f17010b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.createEventButton");
            textView2.setVisibility(loaded.getCanCreateEvents() ? 0 : 8);
            ConstraintLayout constraintLayout = getBinding().f17011c;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventListEmptyState");
            constraintLayout.setVisibility(loaded.getGuildScheduledEvents().isEmpty() ? 0 : 8);
        }
    }

    private final WidgetGuildScheduledEventListBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventListBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getChannelId() {
        return (Long) this.channelId.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildScheduledEventListViewModel getViewModel() {
        return (GuildScheduledEventListViewModel) this.viewModel.getValue();
    }

    private final void onEventCardClicked(GuildScheduledEventListItem.Event item) {
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForGuild(parentFragmentManager, item.getEvent().getId());
    }

    private final void onEventStartClicked(GuildScheduledEventListItem.Event item) {
        if (item.getCanStartEvent()) {
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.launch(contextRequireContext, GuildScheduledEventModelKt.toModel(item.getEvent()), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(item.getEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : this.previewLauncher, (24 & 16) != 0 ? false : false);
        }
    }

    private final void onJoinClicked(GuildScheduledEventListItem.Event item) {
        Channel channel = item.getChannel();
        if (channel != null) {
            dismiss();
            VoiceUtils.handleCallChannel(channel, this);
        }
    }

    private final void onRsvpClicked(GuildScheduledEventListItem.Event item) {
        if (!item.isRsvped()) {
            C0876m.m169g(getContext(), C5419R.string.guild_event_interested_notification, 0, null, 12);
        }
        getViewModel().toggleRsvp(item.getEvent());
    }

    private final void onShareClicked(GuildScheduledEventListItem.Event item) {
        getViewModel().onShareClicked(item.getEvent(), new WeakReference<>(requireContext()), new WeakReference<>(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_scheduled_event_list_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildScheduledEventListBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88861(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().f17012d;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventListRecyclerView");
        this.adapter = new GuildScheduledEventListAdapter(recyclerView, new C88882(this), new C88893(this), new C88871(this), new C88904(this), new C88915(this));
        RecyclerView recyclerView2 = getBinding().f17012d;
        GuildScheduledEventListAdapter guildScheduledEventListAdapter = this.adapter;
        if (guildScheduledEventListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(guildScheduledEventListAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        Context context = recyclerView2.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        GuildScheduledEventListAdapter guildScheduledEventListAdapter2 = this.adapter;
        if (guildScheduledEventListAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.addItemDecoration(new SpaceBetweenItemDecoration(context, orientation, guildScheduledEventListAdapter2, 0, 0, 24, null));
        recyclerView2.setItemAnimator(null);
        getBinding().f17010b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet.onViewCreated.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildScheduledEventLocationSelect.Companion companion = WidgetGuildScheduledEventLocationSelect.INSTANCE;
                Context contextRequireContext = WidgetGuildScheduledEventListBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launch(contextRequireContext, WidgetGuildScheduledEventListBottomSheet.this.getGuildId(), WidgetGuildScheduledEventListBottomSheet.this.getChannelId());
            }
        });
    }
}
