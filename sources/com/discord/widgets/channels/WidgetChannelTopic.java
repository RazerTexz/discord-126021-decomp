package com.discord.widgets.channels;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.Lifecycle;
import androidx.view.Lifecycle$State;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelTopicBinding;
import com.discord.models.member.GuildMember;
import com.discord.utilities.channel.GuildChannelIconType$Text;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.badge.BadgeDrawable;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelTopic.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelTopicBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean isDm;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetChannelTopic() {
        super(R$layout.widget_channel_topic);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelTopic$binding$2.INSTANCE, null, 2, null);
        WidgetChannelTopic$viewModel$2 widgetChannelTopic$viewModel$2 = WidgetChannelTopic$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetChannelTopicViewModel.class), new WidgetChannelTopic$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChannelTopic$viewModel$2));
    }

    public static final /* synthetic */ void access$configureEllipsis(WidgetChannelTopic widgetChannelTopic) {
        widgetChannelTopic.configureEllipsis();
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelTopic widgetChannelTopic, WidgetChannelTopicViewModel$ViewState widgetChannelTopicViewModel$ViewState) {
        widgetChannelTopic.configureUI(widgetChannelTopicViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetChannelTopicBinding access$getBinding$p(WidgetChannelTopic widgetChannelTopic) {
        return widgetChannelTopic.getBinding();
    }

    public static final /* synthetic */ WidgetChannelTopicViewModel access$getViewModel$p(WidgetChannelTopic widgetChannelTopic) {
        return widgetChannelTopic.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetChannelTopic widgetChannelTopic, WidgetChannelTopicViewModel$Event widgetChannelTopicViewModel$Event) {
        widgetChannelTopic.handleEvent(widgetChannelTopicViewModel$Event);
    }

    public static final /* synthetic */ void access$onClickMore(WidgetChannelTopic widgetChannelTopic, WidgetChannelTopicViewModel$ViewState widgetChannelTopicViewModel$ViewState) {
        widgetChannelTopic.onClickMore(widgetChannelTopicViewModel$ViewState);
    }

    public static final /* synthetic */ void access$onToggleTopicExpansionState(WidgetChannelTopic widgetChannelTopic) {
        widgetChannelTopic.onToggleTopicExpansionState();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    private final void configureChannelTopicTitle(WidgetChannelTopic$RenderedTopic renderedTopic) {
        boolean z2;
        LinkifiedTextView linkifiedTextView = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        CharSequence topic = renderedTopic.getTopic();
        if (topic != null) {
            z2 = topic.length() > 0;
        }
        linkifiedTextView.setVisibility(z2 ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.channelTopicTitle");
        linkifiedTextView2.setAutoLinkMask(renderedTopic.getAutoLinkMask());
        CharSequence topic2 = renderedTopic.getTopic();
        if (topic2 instanceof DraweeSpanStringBuilder) {
            getBinding().g.setDraweeSpanStringBuilder((DraweeSpanStringBuilder) topic2);
            return;
        }
        LinkifiedTextView linkifiedTextView3 = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView3, "binding.channelTopicTitle");
        linkifiedTextView3.setText(topic2);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0058  */
    private final void configureEllipsis() {
        boolean z2;
        Lifecycle lifecycle = getLifecycle();
        m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle$State.INITIALIZED)) {
            getBinding().d.setOnClickListener(new WidgetChannelTopic$configureEllipsis$1(this));
            ImageView imageView = getBinding().d;
            m.checkNotNullExpressionValue(imageView, "binding.channelTopicEllipsis");
            if (this.isDm) {
                z2 = false;
            } else {
                LinkifiedTextView linkifiedTextView = getBinding().g;
                m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
                if (linkifiedTextView.getLineCount() > 2) {
                    LinkifiedTextView linkifiedTextView2 = getBinding().g;
                    m.checkNotNullExpressionValue(linkifiedTextView2, "binding.channelTopicTitle");
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

    private final void configureUI(WidgetChannelTopicViewModel$ViewState viewState) {
        WidgetChannelTopic$RenderedTopic renderedTopicForGDM;
        boolean z2;
        if (viewState instanceof WidgetChannelTopicViewModel$ViewState$NoChannel) {
            View view = getView();
            if (view != null) {
                ViewKt.setVisible(view, false);
            }
            ImageView imageView = getBinding().e;
            m.checkNotNullExpressionValue(imageView, "binding.channelTopicMoreIcon");
            imageView.setVisibility(8);
            setChannelIcon(GuildChannelIconUtilsKt.mapGuildChannelTypeToIcon(GuildChannelIconType$Text.INSTANCE));
            renderedTopicForGDM = new WidgetChannelTopic$RenderedTopic(null, null, 0, 7, null);
        } else if (viewState instanceof WidgetChannelTopicViewModel$ViewState$Guild) {
            View view2 = getView();
            if (view2 != null) {
                ViewKt.setVisible(view2, true);
            }
            ImageView imageView2 = getBinding().e;
            m.checkNotNullExpressionValue(imageView2, "binding.channelTopicMoreIcon");
            imageView2.setVisibility(8);
            setChannelIcon(GuildChannelIconUtilsKt.mapGuildChannelTypeToIcon(((WidgetChannelTopicViewModel$ViewState$Guild) viewState).getChannelIconType()));
            if (viewState instanceof WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic) {
                renderedTopicForGDM = getRenderedTopicForDefaultTopic((WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic) viewState);
            } else {
                Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild.Topic");
                renderedTopicForGDM = getRenderedTopicForTopic((WidgetChannelTopicViewModel$ViewState$Guild$Topic) viewState);
            }
        } else if (viewState instanceof WidgetChannelTopicViewModel$ViewState$DM) {
            View view3 = getView();
            if (view3 != null) {
                ViewKt.setVisible(view3, true);
            }
            ImageView imageView3 = getBinding().e;
            m.checkNotNullExpressionValue(imageView3, "binding.channelTopicMoreIcon");
            imageView3.setVisibility(0);
            setChannelIcon(2131231716);
            WidgetChannelTopicViewModel$ViewState$DM widgetChannelTopicViewModel$ViewState$DM = (WidgetChannelTopicViewModel$ViewState$DM) viewState;
            getBinding().f2281b.configure(widgetChannelTopicViewModel$ViewState$DM.getGuildMembers());
            renderedTopicForGDM = new WidgetChannelTopic$RenderedTopic(widgetChannelTopicViewModel$ViewState$DM.getRecipientName(), null, 0, 6, null);
        } else {
            if (!(viewState instanceof WidgetChannelTopicViewModel$ViewState$GDM)) {
                throw new NoWhenBranchMatchedException();
            }
            View view4 = getView();
            if (view4 != null) {
                ViewKt.setVisible(view4, true);
            }
            ImageView imageView4 = getBinding().e;
            m.checkNotNullExpressionValue(imageView4, "binding.channelTopicMoreIcon");
            imageView4.setVisibility(0);
            WidgetChannelTopicViewModel$ViewState$GDM widgetChannelTopicViewModel$ViewState$GDM = (WidgetChannelTopicViewModel$ViewState$GDM) viewState;
            setChannelIconForGDM(widgetChannelTopicViewModel$ViewState$GDM.getChannel());
            renderedTopicForGDM = getRenderedTopicForGDM(widgetChannelTopicViewModel$ViewState$GDM);
        }
        configureChannelTopicTitle(renderedTopicForGDM);
        boolean z3 = viewState instanceof WidgetChannelTopicViewModel$ViewState$DM;
        if (z3) {
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.DM");
            WidgetChannelTopicViewModel$ViewState$DM widgetChannelTopicViewModel$ViewState$DM2 = (WidgetChannelTopicViewModel$ViewState$DM) viewState;
            Set<String> recipientNicknames = widgetChannelTopicViewModel$ViewState$DM2.getRecipientNicknames();
            List<GuildMember> guildMembers = widgetChannelTopicViewModel$ViewState$DM2.getGuildMembers();
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
            getBinding().f2281b.setOnClickListener(new WidgetChannelTopic$configureUI$1(this, viewState));
            UserAkaView userAkaView = getBinding().f2281b;
            m.checkNotNullExpressionValue(userAkaView, "binding.channelAka");
            userAkaView.setVisibility(!(recipientNicknames == null || recipientNicknames.isEmpty()) || z2 ? 0 : 8);
        } else {
            UserAkaView userAkaView2 = getBinding().f2281b;
            m.checkNotNullExpressionValue(userAkaView2, "binding.channelAka");
            userAkaView2.setVisibility(8);
        }
        this.isDm = z3;
        LinkifiedTextView linkifiedTextView = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        CharSequence topic = renderedTopicForGDM.getTopic();
        linkifiedTextView.setVisibility(((topic == null || t.isBlank(topic)) || z3) ? false : true ? 0 : 8);
        configureEllipsis();
        TextView textView = getBinding().f;
        m.checkNotNullExpressionValue(textView, "binding.channelTopicName");
        textView.setText(renderedTopicForGDM.getChannelName());
        getBinding().e.setOnClickListener(new WidgetChannelTopic$configureUI$2(this, viewState));
    }

    private final WidgetChannelTopicBinding getBinding() {
        return (WidgetChannelTopicBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChannelTopic$RenderedTopic getRenderedTopicForDefaultTopic(WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic viewState) {
        return new WidgetChannelTopic$RenderedTopic(ChannelUtils.d(viewState.getChannel(), requireContext(), false), "", 0);
    }

    private final WidgetChannelTopic$RenderedTopic getRenderedTopicForGDM(WidgetChannelTopicViewModel$ViewState$GDM viewState) {
        return new WidgetChannelTopic$RenderedTopic(ChannelUtils.d(viewState.getChannel(), requireContext(), false), null, 0, 4, null);
    }

    private final WidgetChannelTopic$RenderedTopic getRenderedTopicForTopic(WidgetChannelTopicViewModel$ViewState$Guild$Topic viewState) {
        LinkifiedTextView linkifiedTextView = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        Context context = linkifiedTextView.getContext();
        m.checkNotNullExpressionValue(context, "binding.channelTopicTitle.context");
        DraweeSpanStringBuilder draweeSpanStringBuilderRender = AstRenderer.render(viewState.getAst(), new MessageRenderContext(context, 0L, viewState.getAllowAnimatedEmojis(), viewState.getUserNames(), viewState.getChannelNames(), viewState.getRoles(), 0, null, WidgetChannelTopic$getRenderedTopicForTopic$renderContext$1.INSTANCE, 0, 0, new WidgetChannelTopic$getRenderedTopicForTopic$renderContext$2(getViewModel()), null, null, 14016, null));
        return new WidgetChannelTopic$RenderedTopic(ChannelUtils.d(viewState.getChannel(), requireContext(), false), draweeSpanStringBuilderRender, (draweeSpanStringBuilderRender.length() > 200 || viewState.isLinkifyConflicting()) ? 0 : 15);
    }

    private final WidgetChannelTopicViewModel getViewModel() {
        return (WidgetChannelTopicViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetChannelTopicViewModel$Event event) {
        if (event instanceof WidgetChannelTopicViewModel$Event$FocusFirstElement) {
            getBinding().f.sendAccessibilityEvent(8);
        }
    }

    private final void onClickMore(WidgetChannelTopicViewModel$ViewState viewState) {
        if (viewState instanceof WidgetChannelTopicViewModel$ViewState$GDM) {
            WidgetChannelTopicViewModel$ViewState$GDM widgetChannelTopicViewModel$ViewState$GDM = (WidgetChannelTopicViewModel$ViewState$GDM) viewState;
            showContextMenu(true, widgetChannelTopicViewModel$ViewState$GDM.getChannelId(), ChannelUtils.d(widgetChannelTopicViewModel$ViewState$GDM.getChannel(), requireContext(), false), widgetChannelTopicViewModel$ViewState$GDM.getDeveloperModeEnabled());
        } else if (viewState instanceof WidgetChannelTopicViewModel$ViewState$DM) {
            WidgetChannelTopicViewModel$ViewState$DM widgetChannelTopicViewModel$ViewState$DM = (WidgetChannelTopicViewModel$ViewState$DM) viewState;
            showContextMenu$default(this, false, widgetChannelTopicViewModel$ViewState$DM.getChannelId(), null, widgetChannelTopicViewModel$ViewState$DM.getDeveloperModeEnabled(), 4, null);
        }
    }

    private final void onToggleTopicExpansionState() {
        WidgetChannelTopic$onToggleTopicExpansionState$1 widgetChannelTopic$onToggleTopicExpansionState$1 = new WidgetChannelTopic$onToggleTopicExpansionState$1(this);
        LinkifiedTextView linkifiedTextView = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        if (linkifiedTextView.getMaxLines() != 40) {
            widgetChannelTopic$onToggleTopicExpansionState$1.invoke(40);
        } else {
            widgetChannelTopic$onToggleTopicExpansionState$1.invoke(2);
        }
    }

    private final void setChannelIcon(@DrawableRes int channelIconResource) {
        getBinding().c.setImageResource(channelIconResource);
        SimpleDraweeView simpleDraweeView = getBinding().c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelTopicChannelIcon");
        ViewGroup$LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.setMargins(viewGroup$MarginLayoutParams.leftMargin, viewGroup$MarginLayoutParams.topMargin, DimenUtils.dpToPixels(4), viewGroup$MarginLayoutParams.bottomMargin);
    }

    private final void setChannelIconForGDM(Channel channel) {
        SimpleDraweeView simpleDraweeView = getBinding().c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelTopicChannelIcon");
        IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForChannel$default(channel, null, 2, null), 2131165293, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
        SimpleDraweeView simpleDraweeView2 = getBinding().c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelTopicChannelIcon");
        ViewGroup$LayoutParams layoutParams = simpleDraweeView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.setMargins(viewGroup$MarginLayoutParams.leftMargin, viewGroup$MarginLayoutParams.topMargin, DimenUtils.dpToPixels(8), viewGroup$MarginLayoutParams.bottomMargin);
    }

    private final void showContextMenu(boolean isGroup, long channelId, CharSequence channelTitle, boolean developerModeEnabled) {
        ImageView imageView = getBinding().e;
        m.checkNotNullExpressionValue(imageView, "binding.channelTopicMoreIcon");
        PopupMenu popupMenu = new PopupMenu(imageView.getContext(), getBinding().e, BadgeDrawable.BOTTOM_START);
        popupMenu.inflate(R$menu.menu_private_channel_sidebar);
        popupMenu.getMenu().findItem(R$id.menu_private_channel_sidebar_pinned_messages).setOnMenuItemClickListener(new WidgetChannelTopic$showContextMenu$1(this, channelId));
        MenuItem menuItemFindItem = popupMenu.getMenu().findItem(R$id.menu_private_channel_sidebar_copy_id);
        m.checkNotNullExpressionValue(menuItemFindItem, "copyChannelIdAction");
        menuItemFindItem.setVisible(developerModeEnabled);
        menuItemFindItem.setOnMenuItemClickListener(new WidgetChannelTopic$showContextMenu$2(this, channelId));
        MenuItem menuItemFindItem2 = popupMenu.getMenu().findItem(R$id.menu_private_channel_sidebar_customize_gorup);
        m.checkNotNullExpressionValue(menuItemFindItem2, "customizeGroupAction");
        menuItemFindItem2.setVisible(isGroup);
        menuItemFindItem2.setOnMenuItemClickListener(new WidgetChannelTopic$showContextMenu$3(this, channelId));
        MenuItem menuItemFindItem3 = popupMenu.getMenu().findItem(R$id.menu_private_channel_sidebar_close);
        if (isGroup) {
            menuItemFindItem3.setTitle(2131892526);
            menuItemFindItem3.setOnMenuItemClickListener(new WidgetChannelTopic$showContextMenu$4(this, channelTitle));
        } else {
            menuItemFindItem3.setTitle(2131887681);
            menuItemFindItem3.setOnMenuItemClickListener(new WidgetChannelTopic$showContextMenu$5(this));
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().g.setOnClickListener(new WidgetChannelTopic$onViewBound$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), WidgetChannelTopic.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelTopic$onViewBoundOrOnResume$1(this), 62, (Object) null);
        Observable<WidgetChannelTopicViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetChannelTopic.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelTopic$onViewBoundOrOnResume$2(this), 62, (Object) null);
        LinkifiedTextView linkifiedTextView = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.channelTopicTitle");
        linkifiedTextView.setMaxLines(2);
    }
}
