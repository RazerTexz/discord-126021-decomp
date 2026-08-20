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
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.WidgetGuildFolderSettings;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFolderContextMenu extends AppFragment {
    private static final String FRAGMENT_TAG = "WidgetFolderContextMenu";
    private static final String VIEW_CONTAINER_TAG = "WidgetFolderContextMenuViewContainer";
    private static boolean isShowingContextMenu;
    private AnimationState animationState;
    private Animator animator;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetFolderContextMenu.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int SCREEN_BOTTOM_BUFFER = DimenUtils.dpToPixels(96);

    /* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
    public enum AnimationState {
        ANIMATING_IN,
        ANIMATING_OUT
    }

    /* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
    public static final class Companion {
        private Companion() {
        }

        private final int computeMaxContextMenuHeight(Context context) {
            WidgetFolderContextMenuBinding widgetFolderContextMenuBindingM8414a = WidgetFolderContextMenuBinding.m8414a(LayoutInflater.from(context).inflate(C5419R.layout.widget_folder_context_menu, (ViewGroup) null, false));
            C12238m.checkNotNullExpressionValue(widgetFolderContextMenuBindingM8414a, "WidgetFolderContextMenuB…om(context), null, false)");
            CardView cardView = widgetFolderContextMenuBindingM8414a.f16628a;
            C12238m.checkNotNullExpressionValue(cardView, "WidgetFolderContextMenuB…ntext), null, false).root");
            cardView.measure(0, 0);
            return cardView.getMeasuredHeight();
        }

        private final WidgetFolderContextMenu newInstance(long folderId) {
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", folderId);
            WidgetFolderContextMenu widgetFolderContextMenu = new WidgetFolderContextMenu();
            widgetFolderContextMenu.setArguments(bundleM832T);
            return widgetFolderContextMenu;
        }

        public final void hide(FragmentActivity activity, boolean animate) {
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Fragment fragmentFindFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(WidgetFolderContextMenu.FRAGMENT_TAG);
            if (!(fragmentFindFragmentByTag instanceof WidgetFolderContextMenu)) {
                fragmentFindFragmentByTag = null;
            }
            WidgetFolderContextMenu widgetFolderContextMenu = (WidgetFolderContextMenu) fragmentFindFragmentByTag;
            if (widgetFolderContextMenu != null) {
                if (animate) {
                    widgetFolderContextMenu.doCircularRemove();
                    return;
                }
                activity.getSupportFragmentManager().beginTransaction().remove(widgetFolderContextMenu).commitAllowingStateLoss();
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
                FrameLayout frameLayout = (FrameLayout) decorView2.getRootView().findViewWithTag(WidgetFolderContextMenu.VIEW_CONTAINER_TAG);
                if (frameLayout != null) {
                    viewGroup.removeView(frameLayout);
                }
                WidgetFolderContextMenu.isShowingContextMenu = false;
            }
        }

        public final void show(final FragmentActivity activity, PointF absolutePosition, long folderId) {
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            C12238m.checkNotNullParameter(absolutePosition, "absolutePosition");
            if (WidgetFolderContextMenu.isShowingContextMenu) {
                return;
            }
            WidgetFolderContextMenu.isShowingContextMenu = true;
            computeMaxContextMenuHeight(activity);
            hide(activity, false);
            FrameLayout frameLayout = new FrameLayout(activity);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setTag(WidgetFolderContextMenu.VIEW_CONTAINER_TAG);
            Window window = activity.getWindow();
            C12238m.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            C12238m.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            View rootView = decorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) rootView;
            viewGroup.addView(frameLayout);
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$Companion$show$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetFolderContextMenu.INSTANCE.hide(activity, true);
                }
            });
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout2.setId(View.generateViewId());
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            frameLayout.addView(frameLayout2);
            frameLayout2.setX(absolutePosition.x);
            frameLayout2.setY(C11226f.coerceAtMost(absolutePosition.y, (viewGroup.getHeight() - computeMaxContextMenuHeight(activity)) - WidgetFolderContextMenu.SCREEN_BOTTOM_BUFFER));
            activity.getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance(folderId), WidgetFolderContextMenu.FRAGMENT_TAG).commit();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$onResume$1 */
    /* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
    public static final /* synthetic */ class C85911 extends C12236k implements Function1<FolderContextMenuViewModel.ViewState, Unit> {
        public C85911(WidgetFolderContextMenu widgetFolderContextMenu) {
            super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderContextMenuViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetFolderContextMenu) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$onResume$2 */
    /* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
    public static final /* synthetic */ class C85922 extends C12236k implements Function1<FolderContextMenuViewModel.Event, Unit> {
        public C85922(WidgetFolderContextMenu widgetFolderContextMenu) {
            super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderContextMenuViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetFolderContextMenu) this.receiver).handleEvent(event);
        }
    }

    public WidgetFolderContextMenu() {
        super(C5419R.layout.widget_folder_context_menu);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFolderContextMenu$binding$2.INSTANCE, null, 2, null);
        WidgetFolderContextMenu$viewModel$2 widgetFolderContextMenu$viewModel$2 = new WidgetFolderContextMenu$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(FolderContextMenuViewModel.class), new WidgetFolderContextMenu$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetFolderContextMenu$viewModel$2));
    }

    private final void configureUI(FolderContextMenuViewModel.ViewState viewState) {
        if (viewState instanceof FolderContextMenuViewModel.ViewState.Valid) {
            configureValidUI((FolderContextMenuViewModel.ViewState.Valid) viewState);
        } else if (C12238m.areEqual(viewState, FolderContextMenuViewModel.ViewState.Invalid.INSTANCE)) {
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
        }
    }

    private final void configureValidUI(final FolderContextMenuViewModel.ViewState.Valid viewState) {
        TextView textView = getBinding().f16630c;
        C12238m.checkNotNullExpressionValue(textView, "binding.folderContextMenuHeader");
        CharSequence name = viewState.getFolder().getName();
        if (name == null) {
            name = C1107b.m213e(this, C5419R.string.guild_folder_unnamed, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
        }
        textView.setText(name);
        getBinding().f16631d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu.configureValidUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetFolderContextMenu.this.doCircularRemove();
                WidgetFolderContextMenu.this.getViewModel().onMarkAsReadClicked();
            }
        });
        getBinding().f16632e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu.configureValidUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetFolderContextMenu.this.doCircularRemove();
                Long id2 = viewState.getFolder().getId();
                if (id2 != null) {
                    WidgetGuildFolderSettings.INSTANCE.create(C1643a.m821I(WidgetFolderContextMenu.this.getBinding().f16632e, "binding.folderContextMenuSettings", "binding.folderContextMenuSettings.context"), id2.longValue());
                }
                WidgetFolderContextMenu.this.getViewModel().onSettingsClicked();
            }
        });
        TextView textView2 = getBinding().f16631d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.folderContextMenuMarkAsRead");
        textView2.setVisibility(viewState.getShowMarkAsRead() ? 0 : 8);
        getBinding().f16629b.setContentPadding(0, 0, 0, 0);
        CardView cardView = getBinding().f16629b;
        C12238m.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
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
        CardView cardView = getBinding().f16629b;
        C12238m.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        int height = cardView.getHeight() / 2;
        CardView cardView2 = getBinding().f16629b;
        C12238m.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
        int width = cardView2.getWidth();
        CardView cardView3 = getBinding().f16629b;
        C12238m.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        float fHypot = (float) Math.hypot(width, cardView3.getHeight() / 2);
        CardView cardView4 = getBinding().f16629b;
        C12238m.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
        if (!cardView4.isAttachedToWindow()) {
            CardView cardView5 = getBinding().f16629b;
            C12238m.checkNotNullExpressionValue(cardView5, "binding.folderContextMenuCard");
            cardView5.setVisibility(8);
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f16629b, 0, height, fHypot, 0.0f);
        this.animator = animatorCreateCircularReveal;
        this.animationState = animationState2;
        C12238m.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu.doCircularRemove.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                FragmentActivity fragmentActivityM95e = WidgetFolderContextMenu.this.m95e();
                if (fragmentActivityM95e != null) {
                    Companion companion2 = WidgetFolderContextMenu.INSTANCE;
                    C12238m.checkNotNullExpressionValue(fragmentActivityM95e, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                    companion2.hide(fragmentActivityM95e, false);
                }
            }
        });
        animatorCreateCircularReveal.start();
    }

    private final void doCircularReveal() {
        CardView cardView = getBinding().f16629b;
        C12238m.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        if (!cardView.isAttachedToWindow()) {
            CardView cardView2 = getBinding().f16629b;
            C12238m.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
            cardView2.setVisibility(0);
            return;
        }
        CardView cardView3 = getBinding().f16629b;
        C12238m.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        int height = cardView3.getHeight() / 2;
        CardView cardView4 = getBinding().f16629b;
        C12238m.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
        int width = cardView4.getWidth();
        CardView cardView5 = getBinding().f16629b;
        C12238m.checkNotNullExpressionValue(cardView5, "binding.folderContextMenuCard");
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f16629b, 0, height, 0.0f, (float) Math.hypot(width, cardView5.getHeight() / 2));
        this.animator = animatorCreateCircularReveal;
        this.animationState = AnimationState.ANIMATING_IN;
        C12238m.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu.doCircularReveal.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                WidgetFolderContextMenu.this.animationState = null;
            }
        });
        CardView cardView6 = getBinding().f16629b;
        C12238m.checkNotNullExpressionValue(cardView6, "binding.folderContextMenuCard");
        cardView6.setVisibility(0);
        animatorCreateCircularReveal.start();
    }

    private final WidgetFolderContextMenuBinding getBinding() {
        return (WidgetFolderContextMenuBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FolderContextMenuViewModel getViewModel() {
        return (FolderContextMenuViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(FolderContextMenuViewModel.Event event) {
        if (C12238m.areEqual(event, FolderContextMenuViewModel.Event.Dismiss.INSTANCE)) {
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetFolderContextMenu.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85911(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetFolderContextMenu.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85922(this));
    }
}
