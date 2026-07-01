package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.GuildVideoAtCapacityDialog;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.LayoutFullscreenCallPreviewEmptyBinding;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetCallPreviewFullscreenBinding;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.home.WidgetHomePanelNsfw;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen extends AppFragment {
    private static final String ANALYTICS_SOURCE = "Fullscreen Voice Channel Preview";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetHomePanelNsfw panelNsfw;
    private CallParticipantsAdapter participantsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private Subscription viewModelEventSubscription;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCallPreviewFullscreen.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, long j, AppTransitionActivity.Transition transition, int i, Object obj) {
            if ((i & 4) != 0) {
                transition = null;
            }
            companion.launch(context, j, transition);
        }

        public final void launch(Context context, long channelId, AppTransitionActivity.Transition transition) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) WidgetCallFullscreen.class);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("transition", transition);
            AppScreen2.d(context, WidgetCallPreviewFullscreen.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StreamContext, Unit> {
        public AnonymousClass1(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onStreamPreviewClicked", "onStreamPreviewClicked(Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
            invoke2(streamContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamContext streamContext) {
            Intrinsics3.checkNotNullParameter(streamContext, "p1");
            ((WidgetCallPreviewFullscreen) this.receiver).onStreamPreviewClicked(streamContext);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "clickedUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(this.$channel.getId());
            FragmentManager childFragmentManager = WidgetCallPreviewFullscreen.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, childFragmentManager, Long.valueOf(this.$channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetCallPreviewFullscreen.this, this.$channel, WidgetCallPreviewFullscreen.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentManager parentFragmentManager = WidgetCallPreviewFullscreen.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Context contextRequireContext = WidgetCallPreviewFullscreen.this.requireContext();
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            String string = contextRequireContext.getString(R.string.embedded_activities_desktop_only_modal_title);
            String string2 = contextRequireContext.getString(R.string.embedded_activities_desktop_only_modal_description);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…p_only_modal_description)");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass3(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onNsfwToggle", "onNsfwToggle(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            ((WidgetCallPreviewFullscreen) this.receiver).onNsfwToggle(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass4(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(0, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onDenyNsfw", "onDenyNsfw()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetCallPreviewFullscreen) this.receiver).onDenyNsfw();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onStreamPreviewClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StreamContext $streamContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StreamContext streamContext) {
            super(0);
            this.$streamContext = streamContext;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallPreviewFullscreen.this.getViewModel().onStreamPreviewClicked(this.$streamContext.getStream().getEncodedStreamKey());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class AnonymousClass6 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetCallPreviewFullscreen.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForGuild(parentFragmentManager, guildScheduledEvent.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$7, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class AnonymousClass7 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            WidgetCallPreviewFullscreenBinding binding = WidgetCallPreviewFullscreen.this.getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            ConstraintLayout constraintLayout = binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            companion.launch(context, GuildScheduledEventModel2.toModel(guildScheduledEvent), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(guildScheduledEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? false : false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetCallPreviewFullscreenViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetCallPreviewFullscreen.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetCallPreviewFullscreenViewModel.Event, Unit> {
        public AnonymousClass2(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallPreviewFullscreenViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetCallPreviewFullscreen) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetCallPreviewFullscreen.this.viewModelEventSubscription = subscription;
        }
    }

    public WidgetCallPreviewFullscreen() {
        super(R.layout.widget_call_preview_fullscreen);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCallPreviewFullscreen2.INSTANCE, null, 2, null);
        WidgetCallPreviewFullscreen3 widgetCallPreviewFullscreen3 = new WidgetCallPreviewFullscreen3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetCallPreviewFullscreenViewModel.class), new WidgetCallPreviewFullscreen$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetCallPreviewFullscreen3));
    }

    private final void configureActionBar(final WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        boolean z2 = viewState.getOtherChannelsMentionsCount() > 0;
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.callFullscreenMentions");
        textView.setText(String.valueOf(viewState.getOtherChannelsMentionsCount()));
        TextView textView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.callFullscreenMentions");
        textView2.setVisibility(z2 ? 0 : 8);
        Toolbar toolbar = getBinding().f2249b;
        Intrinsics3.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        toolbar.setNavigationIcon(ContextCompat.getDrawable(requireContext(), z2 ? R.drawable.ic_call_toolbar_stage_minimize_cutout : R.drawable.ic_call_toolbar_stage_minimize));
        getBinding().f2249b.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureActionBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallPreviewFullscreen.finishActivity$default(WidgetCallPreviewFullscreen.this, true, false, 2, null);
            }
        });
        setActionBarOptionsMenu(R.menu.menu_call_preview_fullscreen, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureActionBar.2
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != R.id.menu_invite) {
                    return;
                }
                ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetCallPreviewFullscreen.this, viewState.getVoiceChannel(), WidgetCallPreviewFullscreen.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureActionBar.3
            @Override // rx.functions.Action1
            public final void call(Menu menu) {
                boolean z3 = viewState.isChannelNsfw() && (viewState.isNsfwUnconsented() || viewState.getNsfwAllowed() == NsfwAllowance.DISALLOWED);
                MenuItem menuItemFindItem = menu.findItem(R.id.menu_text_in_voice);
                boolean z4 = viewState.getTextInVoiceEnabled() && viewState.isConnectEnabled() && !z3;
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "textInVoiceMenuItem");
                menuItemFindItem.setVisible(z4);
                if (z4) {
                    View actionView = menuItemFindItem.getActionView();
                    TextView textView3 = actionView != null ? (TextView) actionView.findViewById(R.id.text_in_voice_count) : null;
                    View actionView2 = menuItemFindItem.getActionView();
                    ImageView imageView = actionView2 != null ? (ImageView) actionView2.findViewById(R.id.text_in_voice_icon) : null;
                    int channelMentionsCount = viewState.getChannelMentionsCount();
                    if (channelMentionsCount > 0) {
                        if (textView3 != null) {
                            ViewKt.setVisible(textView3, true);
                        }
                        if (imageView != null) {
                            imageView.setImageResource(R.drawable.ic_text_in_voice_cutout);
                        }
                        if (textView3 != null) {
                            textView3.setBackground(ContextCompat.getDrawable(WidgetCallPreviewFullscreen.this.requireContext(), R.drawable.drawable_circle_red));
                        }
                        if (textView3 != null) {
                            textView3.setText(String.valueOf(Math.min(99, channelMentionsCount)));
                        }
                        if (textView3 != null) {
                            textView3.setTextColor(ContextCompat.getColor(WidgetCallPreviewFullscreen.this.requireContext(), R.color.white));
                        }
                    } else {
                        if (textView3 != null) {
                            ViewKt.setVisible(textView3, false);
                        }
                        if (imageView != null) {
                            imageView.setImageResource(R.drawable.ic_text_in_voice);
                        }
                    }
                    menuItemFindItem.getActionView().setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureActionBar.3.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WidgetCallPreviewFullscreen.this.transitionActivity();
                            WidgetCallPreviewFullscreen.this.getViewModel().onTextInVoiceTapped();
                        }
                    });
                }
                MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_invite);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "inviteMenuItem");
                menuItemFindItem2.setVisible(!z3);
            }
        });
        int color = ColorCompat.getColor(this, R.color.transparent);
        String titleText = viewState.getTitleText();
        if (titleText == null) {
            titleText = "";
        }
        setActionBarTitle(titleText);
        setActionBarTitleColor(-1);
        ColorCompat.setStatusBarTranslucent(this);
        ColorCompat.setStatusBarColor((Fragment) this, color, true);
    }

    private final void configureParticipants(WidgetCallPreviewFullscreenViewModel.ParticipantsList participantsList, Channel channel) {
        if (!(participantsList instanceof WidgetCallPreviewFullscreenViewModel.ParticipantsList.ListItems)) {
            if (!(participantsList instanceof WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty)) {
                throw new NoWhenBranchMatchedException();
            }
            LayoutFullscreenCallPreviewEmptyBinding layoutFullscreenCallPreviewEmptyBinding = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(layoutFullscreenCallPreviewEmptyBinding, "binding.empty");
            ConstraintLayout constraintLayout = layoutFullscreenCallPreviewEmptyBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.empty.root");
            constraintLayout.setVisibility(0);
            RecyclerView recyclerView = getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
            WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty empty = (WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty) participantsList;
            recyclerView.setVisibility(empty.getItems().isEmpty() ^ true ? 0 : 8);
            CallParticipantsAdapter callParticipantsAdapter = this.participantsAdapter;
            if (callParticipantsAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
            }
            callParticipantsAdapter.setData(empty.getItems());
            return;
        }
        LayoutFullscreenCallPreviewEmptyBinding layoutFullscreenCallPreviewEmptyBinding2 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(layoutFullscreenCallPreviewEmptyBinding2, "binding.empty");
        ConstraintLayout constraintLayout2 = layoutFullscreenCallPreviewEmptyBinding2.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.empty.root");
        constraintLayout2.setVisibility(4);
        RecyclerView recyclerView2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.callPreviewVoiceSheetRecycler");
        recyclerView2.setVisibility(0);
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setData(((WidgetCallPreviewFullscreenViewModel.ParticipantsList.ListItems) participantsList).getItems());
        CallParticipantsAdapter callParticipantsAdapter3 = this.participantsAdapter;
        if (callParticipantsAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter3.setOnStreamPreviewClicked(new AnonymousClass1(this));
        CallParticipantsAdapter callParticipantsAdapter4 = this.participantsAdapter;
        if (callParticipantsAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter4.setOnVoiceUserClicked(new AnonymousClass2(channel));
        CallParticipantsAdapter callParticipantsAdapter5 = this.participantsAdapter;
        if (callParticipantsAdapter5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter5.setOnInviteFriendsClicked(new AnonymousClass3(channel));
        CallParticipantsAdapter callParticipantsAdapter6 = this.participantsAdapter;
        if (callParticipantsAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter6.setOnEmbeddedActivityClicked(new AnonymousClass4());
    }

    private final void configureUI(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        configureActionBar(viewState);
        configureParticipants(viewState.getParticipantsList(), viewState.getVoiceChannel());
        if (viewState.isConnectEnabled()) {
            getBinding().i.setText(R.string.join_voice);
            getBinding().h.setText(R.string.join_muted);
            MaterialButton materialButton = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.callPreviewJoinVoice");
            materialButton.setEnabled(true);
            MaterialButton materialButton2 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.callPreviewJoinMuted");
            materialButton2.setEnabled(true);
        } else {
            getBinding().i.setText(R.string.channel_locked_short);
            MaterialButton materialButton3 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.callPreviewJoinVoice");
            materialButton3.setEnabled(false);
            getBinding().h.setText(R.string.channel_locked_short);
            MaterialButton materialButton4 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.callPreviewJoinMuted");
            materialButton4.setEnabled(false);
        }
        getBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureUI.1

            /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
            public static final class C03641 extends Lambda implements Function0<Unit> {
                public C03641() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetCallPreviewFullscreenViewModel.tryConnectToVoice$default(WidgetCallPreviewFullscreen.this.getViewModel(), false, 1, null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnimatableValueParser.S1(WidgetCallPreviewFullscreen.this, null, new C03641(), 1, null);
            }
        });
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureUI.2

            /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
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
                    WidgetCallPreviewFullscreen.this.getViewModel().tryConnectToVoice(true);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnimatableValueParser.S1(WidgetCallPreviewFullscreen.this, null, new AnonymousClass1(), 1, null);
            }
        });
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            widgetHomePanelNsfw.configureUI(viewState.getVoiceChannel().getGuildId(), viewState.isChannelNsfw(), viewState.isNsfwUnconsented(), viewState.getNsfwAllowed(), getBinding().j, new AnonymousClass3(this), new AnonymousClass4(this));
        }
    }

    private final void finishActivity(boolean selectTextChannel, boolean transition) {
        if (selectTextChannel) {
            getViewModel().selectTextChannelAfterFinish();
        }
        Subscription subscription = this.viewModelEventSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        requireAppActivity().finish();
        if (transition) {
            requireAppActivity().overridePendingTransition(0, R.anim.anim_slide_out_down);
        }
    }

    public static /* synthetic */ void finishActivity$default(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        widgetCallPreviewFullscreen.finishActivity(z2, z3);
    }

    private final WidgetCallPreviewFullscreenBinding getBinding() {
        return (WidgetCallPreviewFullscreenBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetCallPreviewFullscreenViewModel getViewModel() {
        return (WidgetCallPreviewFullscreenViewModel) this.viewModel.getValue();
    }

    private final long getVoiceChannelId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
    }

    private final void handleEvent(WidgetCallPreviewFullscreenViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetCallPreviewFullscreenViewModel.Event.ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            GuildVideoAtCapacityDialog.Companion aVar = GuildVideoAtCapacityDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            aVar.a(parentFragmentManager);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetCallPreviewFullscreenViewModel.Event.ShowOverlayNux.INSTANCE)) {
            WidgetNoticeNuxOverlay.INSTANCE.enqueue();
        } else {
            if (!(event instanceof WidgetCallPreviewFullscreenViewModel.Event.LaunchVideoCall)) {
                throw new NoWhenBranchMatchedException();
            }
            finishActivity$default(this, false, false, 1, null);
            WidgetCallPreviewFullscreenViewModel.Event.LaunchVideoCall launchVideoCall = (WidgetCallPreviewFullscreenViewModel.Event.LaunchVideoCall) event;
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), launchVideoCall.getChannelId(), false, launchVideoCall.getAutoTargetStreamKey(), null, 20, null);
        }
    }

    public static final void launch(Context context, long j, AppTransitionActivity.Transition transition) {
        INSTANCE.launch(context, j, transition);
    }

    private final void onDenyNsfw() {
        finishActivity$default(this, true, false, 2, null);
    }

    private final void onNsfwToggle(boolean isHidden) {
        ConstraintLayout constraintLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenBody");
        constraintLayout.setVisibility(isHidden ^ true ? 0 : 8);
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        AnimatableValueParser.S1(this, null, new AnonymousClass1(streamContext), 1, null);
    }

    private final void transitionActivity() {
        finishActivity$default(this, false, false, 3, null);
        requireAppActivity().overridePendingTransition(R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_open_out);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().g, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBound.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
                Intrinsics3.checkNotNullExpressionValue(view2, "view");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = insets.bottom;
                layoutParams2.setMarginStart(insets.left);
                layoutParams2.setMarginEnd(insets.right);
                view2.setLayoutParams(layoutParams2);
                return windowInsetsCompat;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().l.f183b, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBound.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
                Intrinsics3.checkNotNullExpressionValue(view2, "view");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(insets.left);
                layoutParams2.setMarginEnd(insets.right);
                view2.setLayoutParams(layoutParams2);
                return windowInsetsCompat;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().k, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBound.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
                Intrinsics3.checkNotNullExpressionValue(view2, "view");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(insets.left);
                layoutParams2.setMarginEnd(insets.right);
                view2.setLayoutParams(layoutParams2);
                return windowInsetsCompat;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBound.4
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullExpressionValue(view2, "view");
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view2.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), view2.getPaddingBottom());
                return windowInsetsCompat;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().e, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBound.5
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullExpressionValue(view2, "windowView");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
                WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
                Resources resources = WidgetCallPreviewFullscreen.this.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginLeftDp(resources)) + systemWindowInsetLeft;
                int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                Resources resources2 = WidgetCallPreviewFullscreen.this.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginDp(resources2)) + systemWindowInsetTop;
                view2.setLayoutParams(layoutParams2);
                return windowInsetsCompat;
            }
        });
        ConstraintLayout constraintLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenParent");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
        CallParticipantsAdapter callParticipantsAdapter = (CallParticipantsAdapter) companion.configure(new CallParticipantsAdapter(recyclerView, true, true));
        this.participantsAdapter = callParticipantsAdapter;
        if (callParticipantsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter.setOnEventClicked(new AnonymousClass6());
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setOnStartEventClicked(new AnonymousClass7());
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetCallPreviewFullscreen.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetCallPreviewFullscreen.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass3()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBoundOrOnResume.4
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetCallPreviewFullscreen.finishActivity$default(WidgetCallPreviewFullscreen.this, true, false, 2, null);
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }
}
