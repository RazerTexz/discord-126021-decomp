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
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetForumPostStatusBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.ReactionView;
import com.discord.widgets.forums.ForumUtils;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetForumPostStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumPostStatusBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: defaultReactionMeTextColor$delegate, reason: from kotlin metadata */
    private final Lazy defaultReactionMeTextColor;

    /* JADX INFO: renamed from: reactionMeTextColor$delegate, reason: from kotlin metadata */
    private final Lazy reactionMeTextColor;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetForumPostStatus() {
        super(R$layout.widget_forum_post_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetForumPostStatus$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetForumPostStatusViewModel.class), new WidgetForumPostStatus$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetForumPostStatus$viewModel$2(this)));
        this.defaultReactionMeTextColor = g.lazy(new WidgetForumPostStatus$defaultReactionMeTextColor$2(this));
        this.reactionMeTextColor = g.lazy(new WidgetForumPostStatus$reactionMeTextColor$2(this));
    }

    public static final /* synthetic */ WidgetForumPostStatusViewModel access$getViewModel$p(WidgetForumPostStatus widgetForumPostStatus) {
        return widgetForumPostStatus.getViewModel();
    }

    private final void configureFollow(WidgetForumPostStatusViewModel$ViewState$Valid viewState) {
        int i = viewState.isFollowedThread() ? 2131889428 : 2131889364;
        int color = viewState.isFollowedThread() ? ColorCompat.getColor(getContext(), 2131099738) : ColorCompat.getThemedColor(getContext(), 2130969978);
        Drawable drawable = viewState.isFollowedThread() ? ContextCompat.getDrawable(requireContext(), 2131231651) : ContextCompat.getDrawable(requireContext(), 2131231575);
        ProgressBar progressBar = getBinding().f2389b;
        m.checkNotNullExpressionValue(progressBar, "binding.followLoadingIndicator");
        progressBar.setVisibility(viewState.getFollowRequestInProgress() ? 0 : 8);
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.following");
        textView.setVisibility(viewState.getFollowRequestInProgress() ^ true ? 0 : 8);
        TextView textView2 = getBinding().c;
        m.checkNotNullExpressionValue(textView2, "binding.following");
        b.n(textView2, i, new Object[0], null, 4);
        getBinding().c.setTextColor(color);
        TextView textView3 = getBinding().c;
        m.checkNotNullExpressionValue(textView3, "binding.following");
        DrawableCompat.setCompoundDrawablesCompat$default(textView3, drawable, (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
        TextView textView4 = getBinding().c;
        m.checkNotNullExpressionValue(textView4, "binding.following");
        ColorCompatKt.setDrawableColor(textView4, color);
        getBinding().d.setOnClickListener(new WidgetForumPostStatus$configureFollow$1(this, viewState));
    }

    private final void configureMessageCount(WidgetForumPostStatusViewModel$ViewState$Valid viewState) {
        String messageCountString = ForumUtils.INSTANCE.getMessageCountString(Integer.valueOf(viewState.getMessageCount()));
        if (messageCountString == null) {
            messageCountString = "0";
        }
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.messageCount");
        textView.setText(messageCountString);
    }

    private final void configureReactions(WidgetForumPostStatusViewModel$ViewState$Valid viewState) {
        ReactionView reactionView = getBinding().f;
        m.checkNotNullExpressionValue(reactionView, "binding.reaction");
        reactionView.setVisibility(viewState.getReaction() != null ? 0 : 8);
        if (viewState.getReaction() == null || viewState.getMessageId() == null) {
            return;
        }
        ColorStateList defaultReactionMeTextColor = viewState.isDefaultReaction() ? getDefaultReactionMeTextColor() : getReactionMeTextColor();
        if (defaultReactionMeTextColor != null) {
            getBinding().f.setMeTextColor(defaultReactionMeTextColor);
        }
        getBinding().f.a(viewState.getReaction(), viewState.getMessageId().longValue(), true);
        ReactionView reactionView2 = getBinding().f;
        m.checkNotNullExpressionValue(reactionView2, "binding.reaction");
        reactionView2.setBackground(viewState.getHasAddReactionPermission() ? ContextCompat.getDrawable(requireContext(), 2131231027) : null);
        getBinding().f.setOnClickListener(new WidgetForumPostStatus$configureReactions$2(this, viewState));
        ReactionView reactionView3 = getBinding().f;
        m.checkNotNullExpressionValue(reactionView3, "binding.reaction");
        ViewExtensions.setOnLongClickListenerConsumeClick(reactionView3, new WidgetForumPostStatus$configureReactions$3(this, viewState));
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

    public final void configureUI(WidgetForumPostStatusViewModel$ViewState$Valid viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        if (viewState.getMessageId() == null) {
            WidgetForumPostStatusBinding binding = getBinding();
            m.checkNotNullExpressionValue(binding, "binding");
            ConstraintLayout constraintLayout = binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            constraintLayout.setVisibility(8);
            return;
        }
        WidgetForumPostStatusBinding binding2 = getBinding();
        m.checkNotNullExpressionValue(binding2, "binding");
        ConstraintLayout constraintLayout2 = binding2.a;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        constraintLayout2.setVisibility(0);
        View view = getBinding().g;
        m.checkNotNullExpressionValue(view, "binding.separatorTwo");
        view.setVisibility(viewState.getReaction() != null ? 0 : 8);
        configureMessageCount(viewState);
        configureReactions(viewState);
        configureFollow(viewState);
    }

    public final void handleViewState(WidgetForumPostStatusViewModel$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        if (viewState instanceof WidgetForumPostStatusViewModel$ViewState$Valid) {
            configureUI((WidgetForumPostStatusViewModel$ViewState$Valid) viewState);
            return;
        }
        WidgetForumPostStatusBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        ConstraintLayout constraintLayout = binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setVisibility(8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<WidgetForumPostStatusViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetForumPostStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetForumPostStatus$onResume$1(this), 62, (Object) null);
    }
}
