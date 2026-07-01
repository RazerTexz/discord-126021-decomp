package com.discord.widgets.guilds.contextmenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildContextMenuBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel;
import com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.servers.WidgetServerNotifications;
import d0.d0._Ranges;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildContextMenu extends AppFragment {
    private static final String FRAGMENT_TAG = "WidgetGuildContextMenu";
    private static final String VIEW_CONTAINER_TAG = "WidgetGuildContextMenuViewContainer";
    private static boolean isShowingContextMenu;
    private AnimationState animationState;
    private Animator animator;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildContextMenu.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildContextMenuBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int SCREEN_BOTTOM_BUFFER = DimenUtils.dpToPixels(96);

    /* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
    public enum AnimationState {
        ANIMATING_IN,
        ANIMATING_OUT
    }

    /* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
    public static final class Companion {
        private Companion() {
        }

        private final int computeMaxContextMenuHeight(Context context) {
            WidgetGuildContextMenuBinding widgetGuildContextMenuBindingA = WidgetGuildContextMenuBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_guild_context_menu, (ViewGroup) null, false));
            Intrinsics3.checkNotNullExpressionValue(widgetGuildContextMenuBindingA, "WidgetGuildContextMenuBi…om(context), null, false)");
            CardView cardView = widgetGuildContextMenuBindingA.a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "WidgetGuildContextMenuBi…ntext), null, false).root");
            cardView.measure(0, 0);
            return cardView.getMeasuredHeight();
        }

        private final WidgetGuildContextMenu newInstance(long guildId) {
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            WidgetGuildContextMenu widgetGuildContextMenu = new WidgetGuildContextMenu();
            widgetGuildContextMenu.setArguments(bundleT);
            return widgetGuildContextMenu;
        }

        public final void hide(FragmentActivity activity, boolean animate) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Fragment fragmentFindFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(WidgetGuildContextMenu.FRAGMENT_TAG);
            if (!(fragmentFindFragmentByTag instanceof WidgetGuildContextMenu)) {
                fragmentFindFragmentByTag = null;
            }
            WidgetGuildContextMenu widgetGuildContextMenu = (WidgetGuildContextMenu) fragmentFindFragmentByTag;
            if (widgetGuildContextMenu != null) {
                if (animate) {
                    widgetGuildContextMenu.doCircularRemove();
                    return;
                }
                activity.getSupportFragmentManager().beginTransaction().remove(widgetGuildContextMenu).commitAllowingStateLoss();
                Window window = activity.getWindow();
                Intrinsics3.checkNotNullExpressionValue(window, "activity.window");
                View decorView = window.getDecorView();
                Intrinsics3.checkNotNullExpressionValue(decorView, "activity.window.decorView");
                View rootView = decorView.getRootView();
                Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) rootView;
                Window window2 = activity.getWindow();
                Intrinsics3.checkNotNullExpressionValue(window2, "activity.window");
                View decorView2 = window2.getDecorView();
                Intrinsics3.checkNotNullExpressionValue(decorView2, "activity.window.decorView");
                FrameLayout frameLayout = (FrameLayout) decorView2.getRootView().findViewWithTag(WidgetGuildContextMenu.VIEW_CONTAINER_TAG);
                if (frameLayout != null) {
                    viewGroup.removeView(frameLayout);
                }
                WidgetGuildContextMenu.isShowingContextMenu = false;
            }
        }

        public final void show(final FragmentActivity activity, PointF absolutePosition, long guildId) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(absolutePosition, "absolutePosition");
            if (WidgetGuildContextMenu.isShowingContextMenu) {
                return;
            }
            WidgetGuildContextMenu.isShowingContextMenu = true;
            computeMaxContextMenuHeight(activity);
            hide(activity, false);
            FrameLayout frameLayout = new FrameLayout(activity);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setTag(WidgetGuildContextMenu.VIEW_CONTAINER_TAG);
            Window window = activity.getWindow();
            Intrinsics3.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            Intrinsics3.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            View rootView = decorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) rootView;
            viewGroup.addView(frameLayout);
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$Companion$show$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildContextMenu.INSTANCE.hide(activity, true);
                }
            });
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout2.setId(View.generateViewId());
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            frameLayout.addView(frameLayout2);
            frameLayout2.setX(absolutePosition.x);
            frameLayout2.setY(_Ranges.coerceAtMost(absolutePosition.y, (viewGroup.getHeight() - computeMaxContextMenuHeight(activity)) - WidgetGuildContextMenu.SCREEN_BOTTOM_BUFFER));
            activity.getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance(guildId), WidgetGuildContextMenu.FRAGMENT_TAG).commit();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildContextMenuViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildContextMenu widgetGuildContextMenu) {
            super(1, widgetGuildContextMenu, WidgetGuildContextMenu.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildContextMenuViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildContextMenuViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildContextMenu) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<GuildContextMenuViewModel.Event, Unit> {
        public AnonymousClass2(WidgetGuildContextMenu widgetGuildContextMenu) {
            super(1, widgetGuildContextMenu, WidgetGuildContextMenu.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildContextMenuViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildContextMenuViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetGuildContextMenu) this.receiver).handleEvent(event);
        }
    }

    public WidgetGuildContextMenu() {
        super(R.layout.widget_guild_context_menu);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildContextMenu3.INSTANCE, null, 2, null);
        WidgetGuildContextMenu4 widgetGuildContextMenu4 = new WidgetGuildContextMenu4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildContextMenuViewModel.class), new WidgetGuildContextMenu$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildContextMenu4));
    }

    private final void configureUI(GuildContextMenuViewModel.ViewState viewState) {
        if (viewState instanceof GuildContextMenuViewModel.ViewState.Valid) {
            configureValidUI((GuildContextMenuViewModel.ViewState.Valid) viewState);
        } else if (Intrinsics3.areEqual(viewState, GuildContextMenuViewModel.ViewState.Invalid.INSTANCE)) {
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
        }
    }

    private final void configureValidUI(final GuildContextMenuViewModel.ViewState.Valid viewState) {
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildContextMenuHeader");
        textView.setText(viewState.getGuild().getName());
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.configureValidUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildContextMenu.this.doCircularRemove();
                WidgetGuildContextMenu.this.getViewModel().onMarkAsReadClicked();
            }
        });
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.configureValidUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildContextMenu.this.doCircularRemove();
                WidgetServerNotifications.Companion companion = WidgetServerNotifications.INSTANCE;
                long id2 = viewState.getGuild().getId();
                FragmentActivity fragmentActivityRequireActivity = WidgetGuildContextMenu.this.requireActivity();
                Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.launch(id2, fragmentActivityRequireActivity);
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.configureValidUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildContextMenu.this.doCircularRemove();
                WidgetLeaveGuildDialog.Companion companion = WidgetLeaveGuildDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetGuildContextMenu.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, viewState.getGuild().getId());
            }
        });
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.configureValidUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildContextMenu.this.doCircularRemove();
                WidgetGuildProfileSheet.Companion companion = WidgetGuildProfileSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetGuildContextMenu.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, viewState.isGuildSelected(), viewState.getGuild().getId(), (8 & 8) != 0 ? 0L : 0L, (8 & 16) != 0 ? false : false);
            }
        });
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildContextMenuLeaveGuild");
        textView2.setVisibility(viewState.getShowLeaveGuild() ? 0 : 8);
        TextView textView3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildContextMenuMarkAsRead");
        textView3.setVisibility(viewState.getShowMarkAsRead() ? 0 : 8);
        getBinding().f2411b.setContentPadding(0, 0, 0, 0);
        CardView cardView = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        if (cardView.getVisibility() == 0) {
            return;
        }
        doCircularReveal();
    }

    private final void doCircularRemove() {
        AnimationState animationState = this.animationState;
        if (animationState == AnimationState.ANIMATING_IN) {
            Animator animator = this.animator;
            if (animator != null) {
                animator.cancel();
            }
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
            return;
        }
        AnimationState animationState2 = AnimationState.ANIMATING_OUT;
        if (animationState == animationState2) {
            return;
        }
        CardView cardView = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        int height = cardView.getHeight() / 2;
        CardView cardView2 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.guildContextMenuCard");
        int width = cardView2.getWidth();
        CardView cardView3 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.guildContextMenuCard");
        float fHypot = (float) Math.hypot(width, cardView3.getHeight() / 2);
        CardView cardView4 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.guildContextMenuCard");
        if (!cardView4.isAttachedToWindow()) {
            CardView cardView5 = getBinding().f2411b;
            Intrinsics3.checkNotNullExpressionValue(cardView5, "binding.guildContextMenuCard");
            cardView5.setVisibility(8);
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2411b, 0, height, fHypot, 0.0f);
        this.animator = animatorCreateCircularReveal;
        this.animationState = animationState2;
        Intrinsics3.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.doCircularRemove.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                FragmentActivity fragmentActivityE = WidgetGuildContextMenu.this.e();
                if (fragmentActivityE != null) {
                    Companion companion2 = WidgetGuildContextMenu.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(fragmentActivityE, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                    companion2.hide(fragmentActivityE, false);
                }
            }
        });
        animatorCreateCircularReveal.start();
    }

    private final void doCircularReveal() {
        CardView cardView = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        if (!cardView.isAttachedToWindow()) {
            CardView cardView2 = getBinding().f2411b;
            Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.guildContextMenuCard");
            cardView2.setVisibility(0);
            return;
        }
        CardView cardView3 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.guildContextMenuCard");
        int height = cardView3.getHeight() / 2;
        CardView cardView4 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.guildContextMenuCard");
        int width = cardView4.getWidth();
        CardView cardView5 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView5, "binding.guildContextMenuCard");
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2411b, 0, height, 0.0f, (float) Math.hypot(width, cardView5.getHeight() / 2));
        this.animator = animatorCreateCircularReveal;
        this.animationState = AnimationState.ANIMATING_IN;
        Intrinsics3.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.doCircularReveal.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                WidgetGuildContextMenu.this.animationState = null;
            }
        });
        CardView cardView6 = getBinding().f2411b;
        Intrinsics3.checkNotNullExpressionValue(cardView6, "binding.guildContextMenuCard");
        cardView6.setVisibility(0);
        animatorCreateCircularReveal.start();
    }

    private final WidgetGuildContextMenuBinding getBinding() {
        return (WidgetGuildContextMenuBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildContextMenuViewModel getViewModel() {
        return (GuildContextMenuViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GuildContextMenuViewModel.Event event) {
        if (Intrinsics3.areEqual(event, GuildContextMenuViewModel.Event.Dismiss.INSTANCE)) {
            doCircularRemove();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        isShowingContextMenu = false;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildContextMenu.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildContextMenu.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
