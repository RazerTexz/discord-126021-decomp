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
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventListBottomSheetBinding;
import com.discord.utilities.recycler.SpaceBetweenItemDecoration;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.voice.VoiceUtils;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildScheduledEventListBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventListBottomSheetBinding;", 0)};
    public static final WidgetGuildScheduledEventListBottomSheet$Companion Companion = new WidgetGuildScheduledEventListBottomSheet$Companion(null);
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

    public WidgetGuildScheduledEventListBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventListBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetGuildScheduledEventListBottomSheet$guildId$2(this));
        this.channelId = g.lazy(new WidgetGuildScheduledEventListBottomSheet$channelId$2(this));
        WidgetGuildScheduledEventListBottomSheet$viewModel$2 widgetGuildScheduledEventListBottomSheet$viewModel$2 = new WidgetGuildScheduledEventListBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildScheduledEventListViewModel.class), new WidgetGuildScheduledEventListBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildScheduledEventListBottomSheet$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.Companion.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventListBottomSheet$previewLauncher$1(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListViewModel$ViewState guildScheduledEventListViewModel$ViewState) {
        widgetGuildScheduledEventListBottomSheet.configureUi(guildScheduledEventListViewModel$ViewState);
    }

    public static final /* synthetic */ Long access$getChannelId$p(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        return widgetGuildScheduledEventListBottomSheet.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        return widgetGuildScheduledEventListBottomSheet.getGuildId();
    }

    public static final /* synthetic */ void access$onEventCardClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem$Event guildScheduledEventListItem$Event) {
        widgetGuildScheduledEventListBottomSheet.onEventCardClicked(guildScheduledEventListItem$Event);
    }

    public static final /* synthetic */ void access$onEventStartClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem$Event guildScheduledEventListItem$Event) {
        widgetGuildScheduledEventListBottomSheet.onEventStartClicked(guildScheduledEventListItem$Event);
    }

    public static final /* synthetic */ void access$onJoinClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem$Event guildScheduledEventListItem$Event) {
        widgetGuildScheduledEventListBottomSheet.onJoinClicked(guildScheduledEventListItem$Event);
    }

    public static final /* synthetic */ void access$onRsvpClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem$Event guildScheduledEventListItem$Event) {
        widgetGuildScheduledEventListBottomSheet.onRsvpClicked(guildScheduledEventListItem$Event);
    }

    public static final /* synthetic */ void access$onShareClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem$Event guildScheduledEventListItem$Event) {
        widgetGuildScheduledEventListBottomSheet.onShareClicked(guildScheduledEventListItem$Event);
    }

    private final void configureUi(GuildScheduledEventListViewModel$ViewState viewState) {
        if (!(viewState instanceof GuildScheduledEventListViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        GuildScheduledEventListViewModel$ViewState$Loaded guildScheduledEventListViewModel$ViewState$Loaded = (GuildScheduledEventListViewModel$ViewState$Loaded) viewState;
        if (guildScheduledEventListViewModel$ViewState$Loaded != null) {
            TextView textView = getBinding().e;
            m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventListToolbarTitle");
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(StringResourceUtilsKt.getI18nPluralString(contextRequireContext, R$plurals.guild_events_plural_number, guildScheduledEventListViewModel$ViewState$Loaded.getGuildScheduledEvents().size(), Integer.valueOf(guildScheduledEventListViewModel$ViewState$Loaded.getGuildScheduledEvents().size())));
            GuildScheduledEventListAdapter guildScheduledEventListAdapter = this.adapter;
            if (guildScheduledEventListAdapter == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            guildScheduledEventListAdapter.setData(guildScheduledEventListViewModel$ViewState$Loaded.getGuildScheduledEvents());
            TextView textView2 = getBinding().f2446b;
            m.checkNotNullExpressionValue(textView2, "binding.createEventButton");
            textView2.setVisibility(guildScheduledEventListViewModel$ViewState$Loaded.getCanCreateEvents() ? 0 : 8);
            ConstraintLayout constraintLayout = getBinding().c;
            m.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventListEmptyState");
            constraintLayout.setVisibility(guildScheduledEventListViewModel$ViewState$Loaded.getGuildScheduledEvents().isEmpty() ? 0 : 8);
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

    private final void onEventCardClicked(GuildScheduledEventListItem$Event item) {
        WidgetGuildScheduledEventDetailsBottomSheet$Companion widgetGuildScheduledEventDetailsBottomSheet$Companion = WidgetGuildScheduledEventDetailsBottomSheet.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGuildScheduledEventDetailsBottomSheet$Companion.showForGuild(parentFragmentManager, item.getEvent().getId());
    }

    private final void onEventStartClicked(GuildScheduledEventListItem$Event item) {
        if (item.getCanStartEvent()) {
            WidgetPreviewGuildScheduledEvent$Companion widgetPreviewGuildScheduledEvent$Companion = WidgetPreviewGuildScheduledEvent.Companion;
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetPreviewGuildScheduledEvent$Companion.launch$default(widgetPreviewGuildScheduledEvent$Companion, contextRequireContext, GuildScheduledEventModelKt.toModel(item.getEvent()), new WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData(item.getEvent().getId(), WidgetPreviewGuildScheduledEvent$Companion$Action.START_EVENT), this.previewLauncher, false, 16, null);
        }
    }

    private final void onJoinClicked(GuildScheduledEventListItem$Event item) {
        Channel channel = item.getChannel();
        if (channel != null) {
            dismiss();
            VoiceUtils.handleCallChannel(channel, this);
        }
    }

    private final void onRsvpClicked(GuildScheduledEventListItem$Event item) {
        if (!item.isRsvped()) {
            b.a.d.m.g(getContext(), 2131890086, 0, null, 12);
        }
        getViewModel().toggleRsvp(item.getEvent());
    }

    private final void onShareClicked(GuildScheduledEventListItem$Event item) {
        getViewModel().onShareClicked(item.getEvent(), new WeakReference<>(requireContext()), new WeakReference<>(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_guild_scheduled_event_list_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventListBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildScheduledEventListBottomSheet$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventListRecyclerView");
        this.adapter = new GuildScheduledEventListAdapter(recyclerView, new WidgetGuildScheduledEventListBottomSheet$onViewCreated$2(this), new WidgetGuildScheduledEventListBottomSheet$onViewCreated$3(this), new WidgetGuildScheduledEventListBottomSheet$onViewCreated$1(this), new WidgetGuildScheduledEventListBottomSheet$onViewCreated$4(this), new WidgetGuildScheduledEventListBottomSheet$onViewCreated$5(this));
        RecyclerView recyclerView2 = getBinding().d;
        GuildScheduledEventListAdapter guildScheduledEventListAdapter = this.adapter;
        if (guildScheduledEventListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(guildScheduledEventListAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        Context context = recyclerView2.getContext();
        m.checkNotNullExpressionValue(context, "context");
        RecyclerView$LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        GuildScheduledEventListAdapter guildScheduledEventListAdapter2 = this.adapter;
        if (guildScheduledEventListAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.addItemDecoration(new SpaceBetweenItemDecoration(context, orientation, guildScheduledEventListAdapter2, 0, 0, 24, null));
        recyclerView2.setItemAnimator(null);
        getBinding().f2446b.setOnClickListener(new WidgetGuildScheduledEventListBottomSheet$onViewCreated$7(this));
    }
}
