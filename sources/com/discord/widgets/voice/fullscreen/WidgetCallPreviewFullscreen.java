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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.home.WidgetHomePanelNsfw;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import com.google.android.material.button.MaterialButton;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.C0836m;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p025i.C1031q0;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Action2;
import p658rx.functions.Func0;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetCallPreviewFullscreen.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) WidgetCallFullscreen.class);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("transition", transition);
            C0870j.m156d(context, WidgetCallPreviewFullscreen.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$1 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final /* synthetic */ class C105251 extends C12236k implements Function1<StreamContext, Unit> {
        public C105251(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onStreamPreviewClicked", "onStreamPreviewClicked(Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
            invoke2(streamContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamContext streamContext) {
            C12238m.checkNotNullParameter(streamContext, "p1");
            ((WidgetCallPreviewFullscreen) this.receiver).onStreamPreviewClicked(streamContext);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$2 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class C105262 extends AbstractC12240o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105262(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            C12238m.checkNotNullParameter(voiceUser, "clickedUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(this.$channel.getId());
            FragmentManager childFragmentManager = WidgetCallPreviewFullscreen.this.getChildFragmentManager();
            C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, childFragmentManager, Long.valueOf(this.$channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$3 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class C105273 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105273(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetCallPreviewFullscreen.this, this.$channel, WidgetCallPreviewFullscreen.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$4 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class C105284 extends AbstractC12240o implements Function0<Unit> {
        public C105284() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentManager parentFragmentManager = WidgetCallPreviewFullscreen.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Context contextRequireContext = WidgetCallPreviewFullscreen.this.requireContext();
            C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(contextRequireContext, "context");
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            String string = contextRequireContext.getString(C5419R.string.embedded_activities_desktop_only_modal_title);
            String string2 = contextRequireContext.getString(C5419R.string.embedded_activities_desktop_only_modal_description);
            C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…p_only_modal_description)");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$3 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final /* synthetic */ class C105313 extends C12236k implements Function1<Boolean, Unit> {
        public C105313(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onNsfwToggle", "onNsfwToggle(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            ((WidgetCallPreviewFullscreen) this.receiver).onNsfwToggle(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$4 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final /* synthetic */ class C105324 extends C12236k implements Function0<Unit> {
        public C105324(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(0, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onDenyNsfw", "onDenyNsfw()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetCallPreviewFullscreen) this.receiver).onDenyNsfw();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onStreamPreviewClicked$1 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class C105331 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ StreamContext $streamContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105331(StreamContext streamContext) {
            super(0);
            this.$streamContext = streamContext;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallPreviewFullscreen.this.getViewModel().onStreamPreviewClicked(this.$streamContext.getStream().getEncodedStreamKey());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$6 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class C105396 extends AbstractC12240o implements Function1<GuildScheduledEvent, Unit> {
        public C105396() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            C12238m.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetCallPreviewFullscreen.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForGuild(parentFragmentManager, guildScheduledEvent.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$7 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class C105407 extends AbstractC12240o implements Function1<GuildScheduledEvent, Unit> {
        public C105407() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            C12238m.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            WidgetCallPreviewFullscreenBinding binding = WidgetCallPreviewFullscreen.this.getBinding();
            C12238m.checkNotNullExpressionValue(binding, "binding");
            ConstraintLayout constraintLayout = binding.f15783a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.root.context");
            companion.launch(context, GuildScheduledEventModelKt.toModel(guildScheduledEvent), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(guildScheduledEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? false : false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class C105411 extends AbstractC12240o implements Function1<WidgetCallPreviewFullscreenViewModel.ViewState, Unit> {
        public C105411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetCallPreviewFullscreen.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final /* synthetic */ class C105422 extends C12236k implements Function1<WidgetCallPreviewFullscreenViewModel.Event, Unit> {
        public C105422(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallPreviewFullscreenViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetCallPreviewFullscreen) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
    public static final class C105433 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C105433() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetCallPreviewFullscreen.this.viewModelEventSubscription = subscription;
        }
    }

    public WidgetCallPreviewFullscreen() {
        super(C5419R.layout.widget_call_preview_fullscreen);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCallPreviewFullscreen$binding$2.INSTANCE, null, 2, null);
        WidgetCallPreviewFullscreen$viewModel$2 widgetCallPreviewFullscreen$viewModel$2 = new WidgetCallPreviewFullscreen$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetCallPreviewFullscreenViewModel.class), new WidgetCallPreviewFullscreen$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetCallPreviewFullscreen$viewModel$2));
    }

    private final void configureActionBar(final WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        boolean z2 = viewState.getOtherChannelsMentionsCount() > 0;
        TextView textView = getBinding().f15787e;
        C12238m.checkNotNullExpressionValue(textView, "binding.callFullscreenMentions");
        textView.setText(String.valueOf(viewState.getOtherChannelsMentionsCount()));
        TextView textView2 = getBinding().f15787e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.callFullscreenMentions");
        textView2.setVisibility(z2 ? 0 : 8);
        Toolbar toolbar = getBinding().f15784b;
        C12238m.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        toolbar.setNavigationIcon(ContextCompat.getDrawable(requireContext(), z2 ? C5419R.drawable.ic_call_toolbar_stage_minimize_cutout : C5419R.drawable.ic_call_toolbar_stage_minimize));
        getBinding().f15784b.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureActionBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallPreviewFullscreen.finishActivity$default(WidgetCallPreviewFullscreen.this, true, false, 2, null);
            }
        });
        setActionBarOptionsMenu(C5419R.menu.menu_call_preview_fullscreen, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureActionBar.2
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_invite) {
                    return;
                }
                ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetCallPreviewFullscreen.this, viewState.getVoiceChannel(), WidgetCallPreviewFullscreen.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureActionBar.3
            @Override // p658rx.functions.Action1
            public final void call(Menu menu) {
                boolean z3 = viewState.isChannelNsfw() && (viewState.isNsfwUnconsented() || viewState.getNsfwAllowed() == NsfwAllowance.DISALLOWED);
                MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_text_in_voice);
                boolean z4 = viewState.getTextInVoiceEnabled() && viewState.isConnectEnabled() && !z3;
                C12238m.checkNotNullExpressionValue(menuItemFindItem, "textInVoiceMenuItem");
                menuItemFindItem.setVisible(z4);
                if (z4) {
                    View actionView = menuItemFindItem.getActionView();
                    TextView textView3 = actionView != null ? (TextView) actionView.findViewById(C5419R.id.text_in_voice_count) : null;
                    View actionView2 = menuItemFindItem.getActionView();
                    ImageView imageView = actionView2 != null ? (ImageView) actionView2.findViewById(C5419R.id.text_in_voice_icon) : null;
                    int channelMentionsCount = viewState.getChannelMentionsCount();
                    if (channelMentionsCount > 0) {
                        if (textView3 != null) {
                            ViewKt.setVisible(textView3, true);
                        }
                        if (imageView != null) {
                            imageView.setImageResource(C5419R.drawable.ic_text_in_voice_cutout);
                        }
                        if (textView3 != null) {
                            textView3.setBackground(ContextCompat.getDrawable(WidgetCallPreviewFullscreen.this.requireContext(), C5419R.drawable.drawable_circle_red));
                        }
                        if (textView3 != null) {
                            textView3.setText(String.valueOf(Math.min(99, channelMentionsCount)));
                        }
                        if (textView3 != null) {
                            textView3.setTextColor(ContextCompat.getColor(WidgetCallPreviewFullscreen.this.requireContext(), C5419R.color.white));
                        }
                    } else {
                        if (textView3 != null) {
                            ViewKt.setVisible(textView3, false);
                        }
                        if (imageView != null) {
                            imageView.setImageResource(C5419R.drawable.ic_text_in_voice);
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
                MenuItem menuItemFindItem2 = menu.findItem(C5419R.id.menu_invite);
                C12238m.checkNotNullExpressionValue(menuItemFindItem2, "inviteMenuItem");
                menuItemFindItem2.setVisible(!z3);
            }
        });
        int color = ColorCompat.getColor(this, C5419R.color.transparent);
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
            C1031q0 c1031q0 = getBinding().f15794l;
            C12238m.checkNotNullExpressionValue(c1031q0, "binding.empty");
            ConstraintLayout constraintLayout = c1031q0.f1142a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.empty.root");
            constraintLayout.setVisibility(0);
            RecyclerView recyclerView = getBinding().f15793k;
            C12238m.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
            WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty empty = (WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty) participantsList;
            recyclerView.setVisibility(empty.getItems().isEmpty() ^ true ? 0 : 8);
            CallParticipantsAdapter callParticipantsAdapter = this.participantsAdapter;
            if (callParticipantsAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
            }
            callParticipantsAdapter.setData(empty.getItems());
            return;
        }
        C1031q0 c1031q1 = getBinding().f15794l;
        C12238m.checkNotNullExpressionValue(c1031q1, "binding.empty");
        ConstraintLayout constraintLayout2 = c1031q1.f1142a;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.empty.root");
        constraintLayout2.setVisibility(4);
        RecyclerView recyclerView2 = getBinding().f15793k;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.callPreviewVoiceSheetRecycler");
        recyclerView2.setVisibility(0);
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setData(((WidgetCallPreviewFullscreenViewModel.ParticipantsList.ListItems) participantsList).getItems());
        CallParticipantsAdapter callParticipantsAdapter3 = this.participantsAdapter;
        if (callParticipantsAdapter3 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter3.setOnStreamPreviewClicked(new C105251(this));
        CallParticipantsAdapter callParticipantsAdapter4 = this.participantsAdapter;
        if (callParticipantsAdapter4 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter4.setOnVoiceUserClicked(new C105262(channel));
        CallParticipantsAdapter callParticipantsAdapter5 = this.participantsAdapter;
        if (callParticipantsAdapter5 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter5.setOnInviteFriendsClicked(new C105273(channel));
        CallParticipantsAdapter callParticipantsAdapter6 = this.participantsAdapter;
        if (callParticipantsAdapter6 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter6.setOnEmbeddedActivityClicked(new C105284());
    }

    private final void configureUI(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        configureActionBar(viewState);
        configureParticipants(viewState.getParticipantsList(), viewState.getVoiceChannel());
        if (viewState.isConnectEnabled()) {
            getBinding().f15791i.setText(C5419R.string.join_voice);
            getBinding().f15790h.setText(C5419R.string.join_muted);
            MaterialButton materialButton = getBinding().f15791i;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.callPreviewJoinVoice");
            materialButton.setEnabled(true);
            MaterialButton materialButton2 = getBinding().f15790h;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.callPreviewJoinMuted");
            materialButton2.setEnabled(true);
        } else {
            getBinding().f15791i.setText(C5419R.string.channel_locked_short);
            MaterialButton materialButton3 = getBinding().f15791i;
            C12238m.checkNotNullExpressionValue(materialButton3, "binding.callPreviewJoinVoice");
            materialButton3.setEnabled(false);
            getBinding().f15790h.setText(C5419R.string.channel_locked_short);
            MaterialButton materialButton4 = getBinding().f15790h;
            C12238m.checkNotNullExpressionValue(materialButton4, "binding.callPreviewJoinMuted");
            materialButton4.setEnabled(false);
        }
        getBinding().f15791i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureUI.1

            /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
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
                    WidgetCallPreviewFullscreenViewModel.tryConnectToVoice$default(WidgetCallPreviewFullscreen.this.getViewModel(), false, 1, null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1460d.m473S1(WidgetCallPreviewFullscreen.this, null, new AnonymousClass1(), 1, null);
            }
        });
        getBinding().f15790h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.configureUI.2

            /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
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
                    WidgetCallPreviewFullscreen.this.getViewModel().tryConnectToVoice(true);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1460d.m473S1(WidgetCallPreviewFullscreen.this, null, new AnonymousClass1(), 1, null);
            }
        });
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            widgetHomePanelNsfw.configureUI(viewState.getVoiceChannel().getGuildId(), viewState.isChannelNsfw(), viewState.isNsfwUnconsented(), viewState.getNsfwAllowed(), getBinding().f15792j, new C105313(this), new C105324(this));
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
            requireAppActivity().overridePendingTransition(0, C5419R.anim.anim_slide_out_down);
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
        if (C12238m.areEqual(event, WidgetCallPreviewFullscreenViewModel.Event.ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            C0836m.Companion aVar = C0836m.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            aVar.m140a(parentFragmentManager);
            return;
        }
        if (C12238m.areEqual(event, WidgetCallPreviewFullscreenViewModel.Event.ShowOverlayNux.INSTANCE)) {
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
        ConstraintLayout constraintLayout = getBinding().f15786d;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenBody");
        constraintLayout.setVisibility(isHidden ^ true ? 0 : 8);
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        C1460d.m473S1(this, null, new C105331(streamContext), 1, null);
    }

    private final void transitionActivity() {
        finishActivity$default(this, false, false, 3, null);
        requireAppActivity().overridePendingTransition(C5419R.anim.activity_slide_horizontal_open_in, C5419R.anim.activity_slide_horizontal_open_out);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f15789g, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBound.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                C12238m.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
                C12238m.checkNotNullExpressionValue(view2, "view");
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
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f15794l.f1143b, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBound.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                C12238m.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
                C12238m.checkNotNullExpressionValue(view2, "view");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(insets.left);
                layoutParams2.setMarginEnd(insets.right);
                view2.setLayoutParams(layoutParams2);
                return windowInsetsCompat;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f15793k, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBound.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                C12238m.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
                C12238m.checkNotNullExpressionValue(view2, "view");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(insets.left);
                layoutParams2.setMarginEnd(insets.right);
                view2.setLayoutParams(layoutParams2);
                return windowInsetsCompat;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f15785c, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBound.4
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullExpressionValue(view2, "view");
                C12238m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view2.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), view2.getPaddingBottom());
                return windowInsetsCompat;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f15787e, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBound.5
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullExpressionValue(view2, "windowView");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                C12238m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
                WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
                Resources resources = WidgetCallPreviewFullscreen.this.getResources();
                C12238m.checkNotNullExpressionValue(resources, "resources");
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginLeftDp(resources)) + systemWindowInsetLeft;
                int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                Resources resources2 = WidgetCallPreviewFullscreen.this.getResources();
                C12238m.checkNotNullExpressionValue(resources2, "resources");
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginDp(resources2)) + systemWindowInsetTop;
                view2.setLayoutParams(layoutParams2);
                return windowInsetsCompat;
            }
        });
        ConstraintLayout constraintLayout = getBinding().f15788f;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenParent");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f15793k;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
        CallParticipantsAdapter callParticipantsAdapter = (CallParticipantsAdapter) companion.configure(new CallParticipantsAdapter(recyclerView, true, true));
        this.participantsAdapter = callParticipantsAdapter;
        if (callParticipantsAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter.setOnEventClicked(new C105396());
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setOnStartEventClicked(new C105407());
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetCallPreviewFullscreen.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C105411());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetCallPreviewFullscreen.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C105433()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C105422(this));
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen.onViewBoundOrOnResume.4
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetCallPreviewFullscreen.finishActivity$default(WidgetCallPreviewFullscreen.this, true, false, 2, null);
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }
}
