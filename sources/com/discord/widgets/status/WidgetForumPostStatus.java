package com.discord.widgets.status;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetForumPostStatusBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.ReactionView;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.status.WidgetForumPostStatusViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetForumPostStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumPostStatusBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: defaultReactionMeTextColor$delegate, reason: from kotlin metadata */
    private final Lazy defaultReactionMeTextColor;

    /* JADX INFO: renamed from: reactionMeTextColor$delegate, reason: from kotlin metadata */
    private final Lazy reactionMeTextColor;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatus$configureReactions$3 */
    /* JADX INFO: compiled from: WidgetForumPostStatus.kt */
    public static final class C100883 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ WidgetForumPostStatusViewModel.ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100883(WidgetForumPostStatusViewModel.ViewState.Valid valid) {
            super(1);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetForumPostStatusViewModel viewModel = WidgetForumPostStatus.this.getViewModel();
            Context contextRequireContext = WidgetForumPostStatus.this.requireContext();
            FragmentManager parentFragmentManager = WidgetForumPostStatus.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            viewModel.onReactionLongPress(contextRequireContext, parentFragmentManager, this.$viewState.getMessageId().longValue(), this.$viewState.getGuildId(), this.$viewState.getChannelId(), this.$viewState.isArchivedThread(), this.$viewState.getReaction());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetForumPostStatus$onResume$1 */
    /* JADX INFO: compiled from: WidgetForumPostStatus.kt */
    public static final class C100891 extends AbstractC12240o implements Function1<WidgetForumPostStatusViewModel.ViewState, Unit> {
        public C100891() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetForumPostStatusViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetForumPostStatusViewModel.ViewState viewState) {
            WidgetForumPostStatus widgetForumPostStatus = WidgetForumPostStatus.this;
            C12238m.checkNotNullExpressionValue(viewState, "viewState");
            widgetForumPostStatus.handleViewState(viewState);
        }
    }

    public WidgetForumPostStatus() {
        super(C5419R.layout.widget_forum_post_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetForumPostStatus$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetForumPostStatusViewModel.class), new C10084x1c3e7cae(this), new C0863f0(new WidgetForumPostStatus$viewModel$2(this)));
        this.defaultReactionMeTextColor = C12083g.lazy(new WidgetForumPostStatus$defaultReactionMeTextColor$2(this));
        this.reactionMeTextColor = C12083g.lazy(new WidgetForumPostStatus$reactionMeTextColor$2(this));
    }

    private final void configureFollow(final WidgetForumPostStatusViewModel.ViewState.Valid viewState) {
        int i = viewState.isFollowedThread() ? C5419R.string.forum_unfollow_button : C5419R.string.forum_follow_button;
        int color = viewState.isFollowedThread() ? ColorCompat.getColor(getContext(), C5419R.color.brand_500) : ColorCompat.getThemedColor(getContext(), C5419R.attr.primary_300);
        Drawable drawable = viewState.isFollowedThread() ? ContextCompat.getDrawable(requireContext(), C5419R.drawable.ic_check_16dp) : ContextCompat.getDrawable(requireContext(), C5419R.drawable.ic_bell_16dp);
        ProgressBar progressBar = getBinding().f16644b;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.followLoadingIndicator");
        progressBar.setVisibility(viewState.getFollowRequestInProgress() ? 0 : 8);
        TextView textView = getBinding().f16645c;
        C12238m.checkNotNullExpressionValue(textView, "binding.following");
        textView.setVisibility(viewState.getFollowRequestInProgress() ^ true ? 0 : 8);
        TextView textView2 = getBinding().f16645c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.following");
        C1107b.m221m(textView2, i, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f16645c.setTextColor(color);
        TextView textView3 = getBinding().f16645c;
        C12238m.checkNotNullExpressionValue(textView3, "binding.following");
        DrawableCompat.setCompoundDrawablesCompat$default(textView3, drawable, (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
        TextView textView4 = getBinding().f16645c;
        C12238m.checkNotNullExpressionValue(textView4, "binding.following");
        ColorCompatKt.setDrawableColor(textView4, color);
        getBinding().f16646d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetForumPostStatus.configureFollow.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (viewState.getFollowRequestInProgress()) {
                    return;
                }
                WidgetForumPostStatusViewModel viewModel = WidgetForumPostStatus.this.getViewModel();
                Context contextRequireContext = WidgetForumPostStatus.this.requireContext();
                FragmentManager parentFragmentManager = WidgetForumPostStatus.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                viewModel.onFollowPress(contextRequireContext, parentFragmentManager, viewState.getGuildId(), viewState.getChannelId(), viewState.isArchivedThread(), viewState.isFollowedThread());
            }
        });
    }

    private final void configureMessageCount(WidgetForumPostStatusViewModel.ViewState.Valid viewState) {
        String messageCountString = ForumUtils.INSTANCE.getMessageCountString(Integer.valueOf(viewState.getMessageCount()));
        if (messageCountString == null) {
            messageCountString = "0";
        }
        TextView textView = getBinding().f16647e;
        C12238m.checkNotNullExpressionValue(textView, "binding.messageCount");
        textView.setText(messageCountString);
    }

    private final void configureReactions(final WidgetForumPostStatusViewModel.ViewState.Valid viewState) {
        ReactionView reactionView = getBinding().f16648f;
        C12238m.checkNotNullExpressionValue(reactionView, "binding.reaction");
        reactionView.setVisibility(viewState.getReaction() != null ? 0 : 8);
        if (viewState.getReaction() == null || viewState.getMessageId() == null) {
            return;
        }
        ColorStateList defaultReactionMeTextColor = viewState.isDefaultReaction() ? getDefaultReactionMeTextColor() : getReactionMeTextColor();
        if (defaultReactionMeTextColor != null) {
            getBinding().f16648f.setMeTextColor(defaultReactionMeTextColor);
        }
        getBinding().f16648f.m8552a(viewState.getReaction(), viewState.getMessageId().longValue(), true);
        ReactionView reactionView2 = getBinding().f16648f;
        C12238m.checkNotNullExpressionValue(reactionView2, "binding.reaction");
        reactionView2.setBackground(viewState.getHasAddReactionPermission() ? ContextCompat.getDrawable(requireContext(), C5419R.drawable.bg_pressed_highlight) : null);
        getBinding().f16648f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetForumPostStatus.configureReactions.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetForumPostStatusViewModel viewModel = WidgetForumPostStatus.this.getViewModel();
                Context contextRequireContext = WidgetForumPostStatus.this.requireContext();
                FragmentManager parentFragmentManager = WidgetForumPostStatus.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                viewModel.onReactionPress(contextRequireContext, parentFragmentManager, viewState.getMyUserId(), viewState.getMessageId().longValue(), viewState.getGuildId(), viewState.getChannelId(), viewState.isArchivedThread(), viewState.getReaction(), viewState.getHasAddReactionPermission());
            }
        });
        ReactionView reactionView3 = getBinding().f16648f;
        C12238m.checkNotNullExpressionValue(reactionView3, "binding.reaction");
        ViewExtensions.setOnLongClickListenerConsumeClick(reactionView3, new C100883(viewState));
    }

    private final WidgetForumPostStatusBinding getBinding() {
        return (WidgetForumPostStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ColorStateList getDefaultReactionMeTextColor() {
        return (ColorStateList) this.defaultReactionMeTextColor.getValue();
    }

    private final ColorStateList getReactionMeTextColor() {
        return (ColorStateList) this.reactionMeTextColor.getValue();
    }

    private final WidgetForumPostStatusViewModel getViewModel() {
        return (WidgetForumPostStatusViewModel) this.viewModel.getValue();
    }

    public final void configureUI(WidgetForumPostStatusViewModel.ViewState.Valid viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        if (viewState.getMessageId() == null) {
            WidgetForumPostStatusBinding binding = getBinding();
            C12238m.checkNotNullExpressionValue(binding, "binding");
            ConstraintLayout constraintLayout = binding.f16643a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            constraintLayout.setVisibility(8);
            return;
        }
        WidgetForumPostStatusBinding binding2 = getBinding();
        C12238m.checkNotNullExpressionValue(binding2, "binding");
        ConstraintLayout constraintLayout2 = binding2.f16643a;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        constraintLayout2.setVisibility(0);
        View view = getBinding().f16649g;
        C12238m.checkNotNullExpressionValue(view, "binding.separatorTwo");
        view.setVisibility(viewState.getReaction() != null ? 0 : 8);
        configureMessageCount(viewState);
        configureReactions(viewState);
        configureFollow(viewState);
    }

    public final void handleViewState(WidgetForumPostStatusViewModel.ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        if (viewState instanceof WidgetForumPostStatusViewModel.ViewState.Valid) {
            configureUI((WidgetForumPostStatusViewModel.ViewState.Valid) viewState);
            return;
        }
        WidgetForumPostStatusBinding binding = getBinding();
        C12238m.checkNotNullExpressionValue(binding, "binding");
        ConstraintLayout constraintLayout = binding.f16643a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setVisibility(8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<WidgetForumPostStatusViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetForumPostStatus.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100891());
    }
}
