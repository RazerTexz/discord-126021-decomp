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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildContextMenuBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.servers.WidgetServerNotifications;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildContextMenu.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildContextMenuBinding;", 0)};

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
            WidgetGuildContextMenuBinding widgetGuildContextMenuBindingM8416a = WidgetGuildContextMenuBinding.m8416a(LayoutInflater.from(context).inflate(C5419R.layout.widget_guild_context_menu, (ViewGroup) null, false));
            C12238m.checkNotNullExpressionValue(widgetGuildContextMenuBindingM8416a, "WidgetGuildContextMenuBi…om(context), null, false)");
            CardView cardView = widgetGuildContextMenuBindingM8416a.f16761a;
            C12238m.checkNotNullExpressionValue(cardView, "WidgetGuildContextMenuBi…ntext), null, false).root");
            cardView.measure(0, 0);
            return cardView.getMeasuredHeight();
        }

        private final WidgetGuildContextMenu newInstance(long guildId) {
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            WidgetGuildContextMenu widgetGuildContextMenu = new WidgetGuildContextMenu();
            widgetGuildContextMenu.setArguments(bundleM832T);
            return widgetGuildContextMenu;
        }

        public final void hide(FragmentActivity activity, boolean animate) {
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
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
                C12238m.checkNotNullExpressionValue(window, "activity.window");
                View decorView = window.getDecorView();
                C12238m.checkNotNullExpressionValue(decorView, "activity.window.decorView");
                View rootView = decorView.getRootView();
                Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) rootView;
                Window window2 = activity.getWindow();
                C12238m.checkNotNullExpressionValue(window2, "activity.window");
                View decorView2 = window2.getDecorView();
                C12238m.checkNotNullExpressionValue(decorView2, "activity.window.decorView");
                FrameLayout frameLayout = (FrameLayout) decorView2.getRootView().findViewWithTag(WidgetGuildContextMenu.VIEW_CONTAINER_TAG);
                if (frameLayout != null) {
                    viewGroup.removeView(frameLayout);
                }
                WidgetGuildContextMenu.isShowingContextMenu = false;
            }
        }

        public final void show(final FragmentActivity activity, PointF absolutePosition, long guildId) {
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            C12238m.checkNotNullParameter(absolutePosition, "absolutePosition");
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
            C12238m.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            C12238m.checkNotNullExpressionValue(decorView, "activity.window.decorView");
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
            frameLayout2.setY(C11226f.coerceAtMost(absolutePosition.y, (viewGroup.getHeight() - computeMaxContextMenuHeight(activity)) - WidgetGuildContextMenu.SCREEN_BOTTOM_BUFFER));
            activity.getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance(guildId), WidgetGuildContextMenu.FRAGMENT_TAG).commit();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
    public static final /* synthetic */ class C85991 extends C12236k implements Function1<GuildContextMenuViewModel.ViewState, Unit> {
        public C85991(WidgetGuildContextMenu widgetGuildContextMenu) {
            super(1, widgetGuildContextMenu, WidgetGuildContextMenu.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildContextMenuViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildContextMenuViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildContextMenu) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$onResume$2 */
    /* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
    public static final /* synthetic */ class C86002 extends C12236k implements Function1<GuildContextMenuViewModel.Event, Unit> {
        public C86002(WidgetGuildContextMenu widgetGuildContextMenu) {
            super(1, widgetGuildContextMenu, WidgetGuildContextMenu.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildContextMenuViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildContextMenuViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetGuildContextMenu) this.receiver).handleEvent(event);
        }
    }

    public WidgetGuildContextMenu() {
        super(C5419R.layout.widget_guild_context_menu);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildContextMenu$binding$2.INSTANCE, null, 2, null);
        WidgetGuildContextMenu$viewModel$2 widgetGuildContextMenu$viewModel$2 = new WidgetGuildContextMenu$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildContextMenuViewModel.class), new WidgetGuildContextMenu$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGuildContextMenu$viewModel$2));
    }

    private final void configureUI(GuildContextMenuViewModel.ViewState viewState) {
        if (viewState instanceof GuildContextMenuViewModel.ViewState.Valid) {
            configureValidUI((GuildContextMenuViewModel.ViewState.Valid) viewState);
        } else if (C12238m.areEqual(viewState, GuildContextMenuViewModel.ViewState.Invalid.INSTANCE)) {
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
        }
    }

    private final void configureValidUI(final GuildContextMenuViewModel.ViewState.Valid viewState) {
        TextView textView = getBinding().f16763c;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildContextMenuHeader");
        textView.setText(viewState.getGuild().getName());
        getBinding().f16765e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.configureValidUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildContextMenu.this.doCircularRemove();
                WidgetGuildContextMenu.this.getViewModel().onMarkAsReadClicked();
            }
        });
        getBinding().f16767g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.configureValidUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildContextMenu.this.doCircularRemove();
                WidgetServerNotifications.Companion companion = WidgetServerNotifications.INSTANCE;
                long id2 = viewState.getGuild().getId();
                FragmentActivity fragmentActivityRequireActivity = WidgetGuildContextMenu.this.requireActivity();
                C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.launch(id2, fragmentActivityRequireActivity);
            }
        });
        getBinding().f16764d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.configureValidUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildContextMenu.this.doCircularRemove();
                WidgetLeaveGuildDialog.Companion companion = WidgetLeaveGuildDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetGuildContextMenu.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, viewState.getGuild().getId());
            }
        });
        getBinding().f16766f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.configureValidUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildContextMenu.this.doCircularRemove();
                WidgetGuildProfileSheet.Companion companion = WidgetGuildProfileSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetGuildContextMenu.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, viewState.isGuildSelected(), viewState.getGuild().getId(), (8 & 8) != 0 ? 0L : 0L, (8 & 16) != 0 ? false : false);
            }
        });
        TextView textView2 = getBinding().f16764d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildContextMenuLeaveGuild");
        textView2.setVisibility(viewState.getShowLeaveGuild() ? 0 : 8);
        TextView textView3 = getBinding().f16765e;
        C12238m.checkNotNullExpressionValue(textView3, "binding.guildContextMenuMarkAsRead");
        textView3.setVisibility(viewState.getShowMarkAsRead() ? 0 : 8);
        getBinding().f16762b.setContentPadding(0, 0, 0, 0);
        CardView cardView = getBinding().f16762b;
        C12238m.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
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
            C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
            return;
        }
        AnimationState animationState2 = AnimationState.ANIMATING_OUT;
        if (animationState == animationState2) {
            return;
        }
        CardView cardView = getBinding().f16762b;
        C12238m.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        int height = cardView.getHeight() / 2;
        CardView cardView2 = getBinding().f16762b;
        C12238m.checkNotNullExpressionValue(cardView2, "binding.guildContextMenuCard");
        int width = cardView2.getWidth();
        CardView cardView3 = getBinding().f16762b;
        C12238m.checkNotNullExpressionValue(cardView3, "binding.guildContextMenuCard");
        float fHypot = (float) Math.hypot(width, cardView3.getHeight() / 2);
        CardView cardView4 = getBinding().f16762b;
        C12238m.checkNotNullExpressionValue(cardView4, "binding.guildContextMenuCard");
        if (!cardView4.isAttachedToWindow()) {
            CardView cardView5 = getBinding().f16762b;
            C12238m.checkNotNullExpressionValue(cardView5, "binding.guildContextMenuCard");
            cardView5.setVisibility(8);
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f16762b, 0, height, fHypot, 0.0f);
        this.animator = animatorCreateCircularReveal;
        this.animationState = animationState2;
        C12238m.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.doCircularRemove.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                FragmentActivity fragmentActivityM95e = WidgetGuildContextMenu.this.m95e();
                if (fragmentActivityM95e != null) {
                    Companion companion2 = WidgetGuildContextMenu.INSTANCE;
                    C12238m.checkNotNullExpressionValue(fragmentActivityM95e, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                    companion2.hide(fragmentActivityM95e, false);
                }
            }
        });
        animatorCreateCircularReveal.start();
    }

    private final void doCircularReveal() {
        CardView cardView = getBinding().f16762b;
        C12238m.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        if (!cardView.isAttachedToWindow()) {
            CardView cardView2 = getBinding().f16762b;
            C12238m.checkNotNullExpressionValue(cardView2, "binding.guildContextMenuCard");
            cardView2.setVisibility(0);
            return;
        }
        CardView cardView3 = getBinding().f16762b;
        C12238m.checkNotNullExpressionValue(cardView3, "binding.guildContextMenuCard");
        int height = cardView3.getHeight() / 2;
        CardView cardView4 = getBinding().f16762b;
        C12238m.checkNotNullExpressionValue(cardView4, "binding.guildContextMenuCard");
        int width = cardView4.getWidth();
        CardView cardView5 = getBinding().f16762b;
        C12238m.checkNotNullExpressionValue(cardView5, "binding.guildContextMenuCard");
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f16762b, 0, height, 0.0f, (float) Math.hypot(width, cardView5.getHeight() / 2));
        this.animator = animatorCreateCircularReveal;
        this.animationState = AnimationState.ANIMATING_IN;
        C12238m.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu.doCircularReveal.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                WidgetGuildContextMenu.this.animationState = null;
            }
        });
        CardView cardView6 = getBinding().f16762b;
        C12238m.checkNotNullExpressionValue(cardView6, "binding.guildContextMenuCard");
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
        if (C12238m.areEqual(event, GuildContextMenuViewModel.Event.Dismiss.INSTANCE)) {
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildContextMenu.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85991(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildContextMenu.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86002(this));
    }
}
