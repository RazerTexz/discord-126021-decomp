package com.discord.widgets.channels;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.Lifecycle;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelTopicBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.utilities.channel.GuildChannelIconType;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelTopicViewModel;
import com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.user.WidgetUserMutualGuilds;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12134g0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelTopic.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelTopicBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean isDm;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetChannelTopic.kt */
    public static final /* data */ class RenderedTopic {
        public static final int MAX_LINES = 40;
        public static final int MIN_LINES = 2;
        private final int autoLinkMask;
        private final CharSequence channelName;
        private final CharSequence topic;

        public RenderedTopic() {
            this(null, null, 0, 7, null);
        }

        public RenderedTopic(CharSequence charSequence, CharSequence charSequence2, int i) {
            this.channelName = charSequence;
            this.topic = charSequence2;
            this.autoLinkMask = i;
        }

        public static /* synthetic */ RenderedTopic copy$default(RenderedTopic renderedTopic, CharSequence charSequence, CharSequence charSequence2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = renderedTopic.channelName;
            }
            if ((i2 & 2) != 0) {
                charSequence2 = renderedTopic.topic;
            }
            if ((i2 & 4) != 0) {
                i = renderedTopic.autoLinkMask;
            }
            return renderedTopic.copy(charSequence, charSequence2, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharSequence getChannelName() {
            return this.channelName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CharSequence getTopic() {
            return this.topic;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getAutoLinkMask() {
            return this.autoLinkMask;
        }

        public final RenderedTopic copy(CharSequence channelName, CharSequence topic, int autoLinkMask) {
            return new RenderedTopic(channelName, topic, autoLinkMask);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RenderedTopic)) {
                return false;
            }
            RenderedTopic renderedTopic = (RenderedTopic) other;
            return C12238m.areEqual(this.channelName, renderedTopic.channelName) && C12238m.areEqual(this.topic, renderedTopic.topic) && this.autoLinkMask == renderedTopic.autoLinkMask;
        }

        public final int getAutoLinkMask() {
            return this.autoLinkMask;
        }

        public final CharSequence getChannelName() {
            return this.channelName;
        }

        public final CharSequence getTopic() {
            return this.topic;
        }

        public int hashCode() {
            CharSequence charSequence = this.channelName;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.topic;
            return ((iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31) + this.autoLinkMask;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("RenderedTopic(channelName=");
            sbM833U.append(this.channelName);
            sbM833U.append(", topic=");
            sbM833U.append(this.topic);
            sbM833U.append(", autoLinkMask=");
            return C1643a.m814B(sbM833U, this.autoLinkMask, ")");
        }

        public /* synthetic */ RenderedTopic(String str, CharSequence charSequence, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : charSequence, (i2 & 4) != 0 ? 0 : i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopic$onToggleTopicExpansionState$1 */
    /* JADX INFO: compiled from: WidgetChannelTopic.kt */
    public static final class C73531 extends AbstractC12240o implements Function1<Integer, Unit> {
        public C73531() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(WidgetChannelTopic.this.getBinding().f15967g, "maxLines", i);
            C12238m.checkNotNullExpressionValue(objectAnimatorOfInt, "animation");
            objectAnimatorOfInt.setDuration(150L);
            objectAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.discord.widgets.channels.WidgetChannelTopic$onToggleTopicExpansionState$1$animateMaxLines$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    C12238m.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    C12238m.checkNotNullParameter(animator, "animator");
                    WidgetChannelTopic.this.configureEllipsis();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    C12238m.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    C12238m.checkNotNullParameter(animator, "animator");
                }
            });
            objectAnimatorOfInt.start();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopic$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelTopic.kt */
    public static final class C73561 extends AbstractC12240o implements Function1<WidgetChannelTopicViewModel.Event, Unit> {
        public C73561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelTopicViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelTopicViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetChannelTopic.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopic$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChannelTopic.kt */
    public static final class C73572 extends AbstractC12240o implements Function1<WidgetChannelTopicViewModel.ViewState, Unit> {
        public C73572() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelTopicViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelTopicViewModel.ViewState viewState) {
            WidgetChannelTopic widgetChannelTopic = WidgetChannelTopic.this;
            C12238m.checkNotNullExpressionValue(viewState, "viewState");
            widgetChannelTopic.configureUI(viewState);
        }
    }

    public WidgetChannelTopic() {
        super(C5419R.layout.widget_channel_topic);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelTopic$binding$2.INSTANCE, null, 2, null);
        WidgetChannelTopic$viewModel$2 widgetChannelTopic$viewModel$2 = WidgetChannelTopic$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetChannelTopicViewModel.class), new WidgetChannelTopic$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetChannelTopic$viewModel$2));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    private final void configureChannelTopicTitle(RenderedTopic renderedTopic) {
        boolean z2;
        LinkifiedTextView linkifiedTextView = getBinding().f15967g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        CharSequence topic = renderedTopic.getTopic();
        if (topic != null) {
            z2 = topic.length() > 0;
        }
        linkifiedTextView.setVisibility(z2 ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = getBinding().f15967g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.channelTopicTitle");
        linkifiedTextView2.setAutoLinkMask(renderedTopic.getAutoLinkMask());
        CharSequence topic2 = renderedTopic.getTopic();
        if (topic2 instanceof DraweeSpanStringBuilder) {
            getBinding().f15967g.setDraweeSpanStringBuilder((DraweeSpanStringBuilder) topic2);
            return;
        }
        LinkifiedTextView linkifiedTextView3 = getBinding().f15967g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView3, "binding.channelTopicTitle");
        linkifiedTextView3.setText(topic2);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0058  */
    private final void configureEllipsis() {
        boolean z2;
        Lifecycle lifecycle = getLifecycle();
        C12238m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.INITIALIZED)) {
            getBinding().f15964d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetChannelTopic.configureEllipsis.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChannelTopic.this.onToggleTopicExpansionState();
                }
            });
            ImageView imageView = getBinding().f15964d;
            C12238m.checkNotNullExpressionValue(imageView, "binding.channelTopicEllipsis");
            if (this.isDm) {
                z2 = false;
            } else {
                LinkifiedTextView linkifiedTextView = getBinding().f15967g;
                C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
                if (linkifiedTextView.getLineCount() > 2) {
                    LinkifiedTextView linkifiedTextView2 = getBinding().f15967g;
                    C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.channelTopicTitle");
                    if (linkifiedTextView2.getMaxLines() != 40) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
            }
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    private final void configureUI(final WidgetChannelTopicViewModel.ViewState viewState) {
        RenderedTopic renderedTopicForGDM;
        boolean z2;
        if (viewState instanceof WidgetChannelTopicViewModel.ViewState.NoChannel) {
            View view = getView();
            if (view != null) {
                ViewKt.setVisible(view, false);
            }
            ImageView imageView = getBinding().f15965e;
            C12238m.checkNotNullExpressionValue(imageView, "binding.channelTopicMoreIcon");
            imageView.setVisibility(8);
            setChannelIcon(GuildChannelIconUtilsKt.mapGuildChannelTypeToIcon(GuildChannelIconType.Text.INSTANCE));
            renderedTopicForGDM = new RenderedTopic(null, null, 0, 7, null);
        } else if (viewState instanceof WidgetChannelTopicViewModel.ViewState.Guild) {
            View view2 = getView();
            if (view2 != null) {
                ViewKt.setVisible(view2, true);
            }
            ImageView imageView2 = getBinding().f15965e;
            C12238m.checkNotNullExpressionValue(imageView2, "binding.channelTopicMoreIcon");
            imageView2.setVisibility(8);
            setChannelIcon(GuildChannelIconUtilsKt.mapGuildChannelTypeToIcon(((WidgetChannelTopicViewModel.ViewState.Guild) viewState).getChannelIconType()));
            if (viewState instanceof WidgetChannelTopicViewModel.ViewState.Guild.DefaultTopic) {
                renderedTopicForGDM = getRenderedTopicForDefaultTopic((WidgetChannelTopicViewModel.ViewState.Guild.DefaultTopic) viewState);
            } else {
                Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild.Topic");
                renderedTopicForGDM = getRenderedTopicForTopic((WidgetChannelTopicViewModel.ViewState.Guild.Topic) viewState);
            }
        } else if (viewState instanceof WidgetChannelTopicViewModel.ViewState.C7368DM) {
            View view3 = getView();
            if (view3 != null) {
                ViewKt.setVisible(view3, true);
            }
            ImageView imageView3 = getBinding().f15965e;
            C12238m.checkNotNullExpressionValue(imageView3, "binding.channelTopicMoreIcon");
            imageView3.setVisibility(0);
            setChannelIcon(C5419R.drawable.ic_direct_message_header);
            WidgetChannelTopicViewModel.ViewState.C7368DM c7368dm = (WidgetChannelTopicViewModel.ViewState.C7368DM) viewState;
            getBinding().f15962b.configure(c7368dm.getGuildMembers());
            renderedTopicForGDM = new RenderedTopic(c7368dm.getRecipientName(), null, 0, 6, null);
        } else {
            if (!(viewState instanceof WidgetChannelTopicViewModel.ViewState.GDM)) {
                throw new NoWhenBranchMatchedException();
            }
            View view4 = getView();
            if (view4 != null) {
                ViewKt.setVisible(view4, true);
            }
            ImageView imageView4 = getBinding().f15965e;
            C12238m.checkNotNullExpressionValue(imageView4, "binding.channelTopicMoreIcon");
            imageView4.setVisibility(0);
            WidgetChannelTopicViewModel.ViewState.GDM gdm = (WidgetChannelTopicViewModel.ViewState.GDM) viewState;
            setChannelIconForGDM(gdm.getChannel());
            renderedTopicForGDM = getRenderedTopicForGDM(gdm);
        }
        configureChannelTopicTitle(renderedTopicForGDM);
        boolean z3 = viewState instanceof WidgetChannelTopicViewModel.ViewState.C7368DM;
        if (z3) {
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.DM");
            WidgetChannelTopicViewModel.ViewState.C7368DM c7368dm2 = (WidgetChannelTopicViewModel.ViewState.C7368DM) viewState;
            Set<String> recipientNicknames = c7368dm2.getRecipientNicknames();
            List<GuildMember> guildMembers = c7368dm2.getGuildMembers();
            if (!(guildMembers instanceof Collection) || !guildMembers.isEmpty()) {
                Iterator<T> it = guildMembers.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    } else if (((GuildMember) it.next()).hasAvatar()) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            getBinding().f15962b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetChannelTopic.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    Long recipientUserId = ((WidgetChannelTopicViewModel.ViewState.C7368DM) viewState).getRecipientUserId();
                    if (recipientUserId != null) {
                        WidgetUserMutualGuilds.INSTANCE.show(WidgetChannelTopic.this.requireContext(), recipientUserId.longValue());
                    }
                }
            });
            UserAkaView userAkaView = getBinding().f15962b;
            C12238m.checkNotNullExpressionValue(userAkaView, "binding.channelAka");
            userAkaView.setVisibility(!(recipientNicknames == null || recipientNicknames.isEmpty()) || z2 ? 0 : 8);
        } else {
            UserAkaView userAkaView2 = getBinding().f15962b;
            C12238m.checkNotNullExpressionValue(userAkaView2, "binding.channelAka");
            userAkaView2.setVisibility(8);
        }
        this.isDm = z3;
        LinkifiedTextView linkifiedTextView = getBinding().f15967g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        CharSequence topic = renderedTopicForGDM.getTopic();
        linkifiedTextView.setVisibility(((topic == null || C12103t.isBlank(topic)) || z3) ? false : true ? 0 : 8);
        configureEllipsis();
        TextView textView = getBinding().f15966f;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelTopicName");
        textView.setText(renderedTopicForGDM.getChannelName());
        getBinding().f15965e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetChannelTopic.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                WidgetChannelTopic.this.onClickMore(viewState);
            }
        });
    }

    private final WidgetChannelTopicBinding getBinding() {
        return (WidgetChannelTopicBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final RenderedTopic getRenderedTopicForDefaultTopic(WidgetChannelTopicViewModel.ViewState.Guild.DefaultTopic viewState) {
        return new RenderedTopic(ChannelUtils.m7680d(viewState.getChannel(), requireContext(), false), "", 0);
    }

    private final RenderedTopic getRenderedTopicForGDM(WidgetChannelTopicViewModel.ViewState.GDM viewState) {
        return new RenderedTopic(ChannelUtils.m7680d(viewState.getChannel(), requireContext(), false), null, 0, 4, null);
    }

    private final RenderedTopic getRenderedTopicForTopic(WidgetChannelTopicViewModel.ViewState.Guild.Topic viewState) {
        LinkifiedTextView linkifiedTextView = getBinding().f15967g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        Context context = linkifiedTextView.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.channelTopicTitle.context");
        DraweeSpanStringBuilder draweeSpanStringBuilderRender = AstRenderer.render(viewState.getAst(), new MessageRenderContext(context, 0L, viewState.getAllowAnimatedEmojis(), viewState.getUserNames(), viewState.getChannelNames(), viewState.getRoles(), 0, null, WidgetChannelTopic$getRenderedTopicForTopic$renderContext$1.INSTANCE, 0, 0, new WidgetChannelTopic$getRenderedTopicForTopic$renderContext$2(getViewModel()), null, null, 14016, null));
        return new RenderedTopic(ChannelUtils.m7680d(viewState.getChannel(), requireContext(), false), draweeSpanStringBuilderRender, (draweeSpanStringBuilderRender.length() > 200 || viewState.isLinkifyConflicting()) ? 0 : 15);
    }

    private final WidgetChannelTopicViewModel getViewModel() {
        return (WidgetChannelTopicViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetChannelTopicViewModel.Event event) {
        if (event instanceof WidgetChannelTopicViewModel.Event.FocusFirstElement) {
            getBinding().f15966f.sendAccessibilityEvent(8);
        }
    }

    private final void onClickMore(WidgetChannelTopicViewModel.ViewState viewState) {
        if (viewState instanceof WidgetChannelTopicViewModel.ViewState.GDM) {
            WidgetChannelTopicViewModel.ViewState.GDM gdm = (WidgetChannelTopicViewModel.ViewState.GDM) viewState;
            showContextMenu(true, gdm.getChannelId(), ChannelUtils.m7680d(gdm.getChannel(), requireContext(), false), gdm.getDeveloperModeEnabled());
        } else if (viewState instanceof WidgetChannelTopicViewModel.ViewState.C7368DM) {
            WidgetChannelTopicViewModel.ViewState.C7368DM c7368dm = (WidgetChannelTopicViewModel.ViewState.C7368DM) viewState;
            showContextMenu$default(this, false, c7368dm.getChannelId(), null, c7368dm.getDeveloperModeEnabled(), 4, null);
        }
    }

    private final void onToggleTopicExpansionState() {
        C73531 c73531 = new C73531();
        LinkifiedTextView linkifiedTextView = getBinding().f15967g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        if (linkifiedTextView.getMaxLines() != 40) {
            c73531.invoke(40);
        } else {
            c73531.invoke(2);
        }
    }

    private final void setChannelIcon(@DrawableRes int channelIconResource) {
        getBinding().f15963c.setImageResource(channelIconResource);
        SimpleDraweeView simpleDraweeView = getBinding().f15963c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelTopicChannelIcon");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, DimenUtils.dpToPixels(4), marginLayoutParams.bottomMargin);
    }

    private final void setChannelIconForGDM(Channel channel) {
        SimpleDraweeView simpleDraweeView = getBinding().f15963c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelTopicChannelIcon");
        IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForChannel$default(channel, null, 2, null), C5419R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        SimpleDraweeView simpleDraweeView2 = getBinding().f15963c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelTopicChannelIcon");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, DimenUtils.dpToPixels(8), marginLayoutParams.bottomMargin);
    }

    private final void showContextMenu(boolean isGroup, final long channelId, final CharSequence channelTitle, boolean developerModeEnabled) {
        ImageView imageView = getBinding().f15965e;
        C12238m.checkNotNullExpressionValue(imageView, "binding.channelTopicMoreIcon");
        PopupMenu popupMenu = new PopupMenu(imageView.getContext(), getBinding().f15965e, BadgeDrawable.BOTTOM_START);
        popupMenu.inflate(C5419R.menu.menu_private_channel_sidebar);
        popupMenu.getMenu().findItem(C5419R.id.menu_private_channel_sidebar_pinned_messages).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.discord.widgets.channels.WidgetChannelTopic.showContextMenu.1
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WidgetChannelPinnedMessages.INSTANCE.show(WidgetChannelTopic.this.requireContext(), channelId);
                return true;
            }
        });
        MenuItem menuItemFindItem = popupMenu.getMenu().findItem(C5419R.id.menu_private_channel_sidebar_copy_id);
        C12238m.checkNotNullExpressionValue(menuItemFindItem, "copyChannelIdAction");
        menuItemFindItem.setVisible(developerModeEnabled);
        menuItemFindItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.discord.widgets.channels.WidgetChannelTopic.showContextMenu.2
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                C0876m.m165c(WidgetChannelTopic.this.requireContext(), String.valueOf(channelId), 0, 4);
                return true;
            }
        });
        MenuItem menuItemFindItem2 = popupMenu.getMenu().findItem(C5419R.id.menu_private_channel_sidebar_customize_gorup);
        C12238m.checkNotNullExpressionValue(menuItemFindItem2, "customizeGroupAction");
        menuItemFindItem2.setVisible(isGroup);
        menuItemFindItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.discord.widgets.channels.WidgetChannelTopic.showContextMenu.3
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WidgetChannelGroupDMSettings.INSTANCE.create(channelId, WidgetChannelTopic.this.requireContext());
                return true;
            }
        });
        MenuItem menuItemFindItem3 = popupMenu.getMenu().findItem(C5419R.id.menu_private_channel_sidebar_close);
        if (isGroup) {
            menuItemFindItem3.setTitle(C5419R.string.leave_group_dm);
            menuItemFindItem3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.discord.widgets.channels.WidgetChannelTopic.showContextMenu.4

                /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopic$showContextMenu$4$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetChannelTopic.kt */
                public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
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
                        C12238m.checkNotNullParameter(view, "v");
                        WidgetChannelTopicViewModel viewModel = WidgetChannelTopic.this.getViewModel();
                        Context context = view.getContext();
                        C12238m.checkNotNullExpressionValue(context, "v.context");
                        viewModel.handleClosePrivateChannel(context);
                    }
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetChannelTopic.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, C1107b.m213e(WidgetChannelTopic.this, C5419R.string.leave_group_dm_title, new Object[]{channelTitle}, (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(WidgetChannelTopic.this, C5419R.string.leave_group_dm_body, new Object[]{channelTitle}, (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(WidgetChannelTopic.this, C5419R.string.leave_group_dm, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(WidgetChannelTopic.this, C5419R.string.cancel, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C12134g0.mapOf(C12116o.m10073to(Integer.valueOf(C5419R.id.notice_ok), new AnonymousClass1())), null, null, null, Integer.valueOf(C5419R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
                    return true;
                }
            });
        } else {
            menuItemFindItem3.setTitle(C5419R.string.close_dm);
            menuItemFindItem3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.discord.widgets.channels.WidgetChannelTopic.showContextMenu.5
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    WidgetChannelTopic.this.getViewModel().handleClosePrivateChannel(WidgetChannelTopic.this.requireContext());
                    return true;
                }
            });
        }
        popupMenu.show();
    }

    public static /* synthetic */ void showContextMenu$default(WidgetChannelTopic widgetChannelTopic, boolean z2, long j, CharSequence charSequence, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            charSequence = null;
        }
        widgetChannelTopic.showContextMenu(z2, j, charSequence, (i & 8) != 0 ? false : z3);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f15967g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetChannelTopic.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChannelTopic.this.onToggleTopicExpansionState();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), (Class<?>) WidgetChannelTopic.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C73561());
        Observable<WidgetChannelTopicViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetChannelTopic.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C73572());
        LinkifiedTextView linkifiedTextView = getBinding().f15967g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        linkifiedTextView.setMaxLines(2);
    }
}
