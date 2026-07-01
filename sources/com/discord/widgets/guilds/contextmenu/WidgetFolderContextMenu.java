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
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.WidgetGuildFolderSettings;
import com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel;
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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFolderContextMenu.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0)};

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
            WidgetFolderContextMenuBinding widgetFolderContextMenuBindingA = WidgetFolderContextMenuBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_folder_context_menu, (ViewGroup) null, false));
            Intrinsics3.checkNotNullExpressionValue(widgetFolderContextMenuBindingA, "WidgetFolderContextMenuB…om(context), null, false)");
            CardView cardView = widgetFolderContextMenuBindingA.a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "WidgetFolderContextMenuB…ntext), null, false).root");
            cardView.measure(0, 0);
            return cardView.getMeasuredHeight();
        }

        private final WidgetFolderContextMenu newInstance(long folderId) {
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", folderId);
            WidgetFolderContextMenu widgetFolderContextMenu = new WidgetFolderContextMenu();
            widgetFolderContextMenu.setArguments(bundleT);
            return widgetFolderContextMenu;
        }

        public final void hide(FragmentActivity activity, boolean animate) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
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
                FrameLayout frameLayout = (FrameLayout) decorView2.getRootView().findViewWithTag(WidgetFolderContextMenu.VIEW_CONTAINER_TAG);
                if (frameLayout != null) {
                    viewGroup.removeView(frameLayout);
                }
                WidgetFolderContextMenu.isShowingContextMenu = false;
            }
        }

        public final void show(final FragmentActivity activity, PointF absolutePosition, long folderId) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(absolutePosition, "absolutePosition");
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
            Intrinsics3.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            Intrinsics3.checkNotNullExpressionValue(decorView, "activity.window.decorView");
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
            frameLayout2.setY(_Ranges.coerceAtMost(absolutePosition.y, (viewGroup.getHeight() - computeMaxContextMenuHeight(activity)) - WidgetFolderContextMenu.SCREEN_BOTTOM_BUFFER));
            activity.getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance(folderId), WidgetFolderContextMenu.FRAGMENT_TAG).commit();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FolderContextMenuViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetFolderContextMenu widgetFolderContextMenu) {
            super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderContextMenuViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetFolderContextMenu) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<FolderContextMenuViewModel.Event, Unit> {
        public AnonymousClass2(WidgetFolderContextMenu widgetFolderContextMenu) {
            super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderContextMenuViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetFolderContextMenu) this.receiver).handleEvent(event);
        }
    }

    public WidgetFolderContextMenu() {
        super(R.layout.widget_folder_context_menu);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFolderContextMenu3.INSTANCE, null, 2, null);
        WidgetFolderContextMenu4 widgetFolderContextMenu4 = new WidgetFolderContextMenu4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(FolderContextMenuViewModel.class), new WidgetFolderContextMenu$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetFolderContextMenu4));
    }

    private final void configureUI(FolderContextMenuViewModel.ViewState viewState) {
        if (viewState instanceof FolderContextMenuViewModel.ViewState.Valid) {
            configureValidUI((FolderContextMenuViewModel.ViewState.Valid) viewState);
        } else if (Intrinsics3.areEqual(viewState, FolderContextMenuViewModel.ViewState.Invalid.INSTANCE)) {
            Companion companion = INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.hide(fragmentActivityRequireActivity, false);
        }
    }

    private final void configureValidUI(final FolderContextMenuViewModel.ViewState.Valid viewState) {
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.folderContextMenuHeader");
        CharSequence name = viewState.getFolder().getName();
        if (name == null) {
            name = FormatUtils.e(this, R.string.guild_folder_unnamed, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
        }
        textView.setText(name);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu.configureValidUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetFolderContextMenu.this.doCircularRemove();
                WidgetFolderContextMenu.this.getViewModel().onMarkAsReadClicked();
            }
        });
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu.configureValidUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetFolderContextMenu.this.doCircularRemove();
                Long id2 = viewState.getFolder().getId();
                if (id2 != null) {
                    WidgetGuildFolderSettings.INSTANCE.create(outline.I(WidgetFolderContextMenu.this.getBinding().e, "binding.folderContextMenuSettings", "binding.folderContextMenuSettings.context"), id2.longValue());
                }
                WidgetFolderContextMenu.this.getViewModel().onSettingsClicked();
            }
        });
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.folderContextMenuMarkAsRead");
        textView2.setVisibility(viewState.getShowMarkAsRead() ? 0 : 8);
        getBinding().f2386b.setContentPadding(0, 0, 0, 0);
        CardView cardView = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
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
        CardView cardView = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        int height = cardView.getHeight() / 2;
        CardView cardView2 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
        int width = cardView2.getWidth();
        CardView cardView3 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        float fHypot = (float) Math.hypot(width, cardView3.getHeight() / 2);
        CardView cardView4 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
        if (!cardView4.isAttachedToWindow()) {
            CardView cardView5 = getBinding().f2386b;
            Intrinsics3.checkNotNullExpressionValue(cardView5, "binding.folderContextMenuCard");
            cardView5.setVisibility(8);
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2386b, 0, height, fHypot, 0.0f);
        this.animator = animatorCreateCircularReveal;
        this.animationState = animationState2;
        Intrinsics3.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu.doCircularRemove.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                FragmentActivity fragmentActivityE = WidgetFolderContextMenu.this.e();
                if (fragmentActivityE != null) {
                    Companion companion2 = WidgetFolderContextMenu.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(fragmentActivityE, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                    companion2.hide(fragmentActivityE, false);
                }
            }
        });
        animatorCreateCircularReveal.start();
    }

    private final void doCircularReveal() {
        CardView cardView = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        if (!cardView.isAttachedToWindow()) {
            CardView cardView2 = getBinding().f2386b;
            Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
            cardView2.setVisibility(0);
            return;
        }
        CardView cardView3 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        int height = cardView3.getHeight() / 2;
        CardView cardView4 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
        int width = cardView4.getWidth();
        CardView cardView5 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView5, "binding.folderContextMenuCard");
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2386b, 0, height, 0.0f, (float) Math.hypot(width, cardView5.getHeight() / 2));
        this.animator = animatorCreateCircularReveal;
        this.animationState = AnimationState.ANIMATING_IN;
        Intrinsics3.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu.doCircularReveal.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                WidgetFolderContextMenu.this.animationState = null;
            }
        });
        CardView cardView6 = getBinding().f2386b;
        Intrinsics3.checkNotNullExpressionValue(cardView6, "binding.folderContextMenuCard");
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
        if (Intrinsics3.areEqual(event, FolderContextMenuViewModel.Event.Dismiss.INSTANCE)) {
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetFolderContextMenu.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetFolderContextMenu.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
