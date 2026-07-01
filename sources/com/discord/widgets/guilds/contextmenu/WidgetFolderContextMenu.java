package com.discord.widgets.guilds.contextmenu;

import android.animation.Animator;
import android.content.Context;
import android.view.ViewAnimationUtils;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFolderContextMenu extends AppFragment {
    private static final String FRAGMENT_TAG = "WidgetFolderContextMenu";
    private static final String VIEW_CONTAINER_TAG = "WidgetFolderContextMenuViewContainer";
    private static boolean isShowingContextMenu;
    private WidgetFolderContextMenu$AnimationState animationState;
    private Animator animator;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFolderContextMenu.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0)};
    public static final WidgetFolderContextMenu$Companion Companion = new WidgetFolderContextMenu$Companion(null);
    private static final int SCREEN_BOTTOM_BUFFER = DimenUtils.dpToPixels(96);

    public WidgetFolderContextMenu() {
        super(R$layout.widget_folder_context_menu);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFolderContextMenu$binding$2.INSTANCE, null, 2, null);
        WidgetFolderContextMenu$viewModel$2 widgetFolderContextMenu$viewModel$2 = new WidgetFolderContextMenu$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(FolderContextMenuViewModel.class), new WidgetFolderContextMenu$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetFolderContextMenu$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetFolderContextMenu widgetFolderContextMenu, FolderContextMenuViewModel$ViewState folderContextMenuViewModel$ViewState) {
        widgetFolderContextMenu.configureUI(folderContextMenuViewModel$ViewState);
    }

    public static final /* synthetic */ void access$doCircularRemove(WidgetFolderContextMenu widgetFolderContextMenu) {
        widgetFolderContextMenu.doCircularRemove();
    }

    public static final /* synthetic */ WidgetFolderContextMenu$AnimationState access$getAnimationState$p(WidgetFolderContextMenu widgetFolderContextMenu) {
        return widgetFolderContextMenu.animationState;
    }

    public static final /* synthetic */ WidgetFolderContextMenuBinding access$getBinding$p(WidgetFolderContextMenu widgetFolderContextMenu) {
        return widgetFolderContextMenu.getBinding();
    }

    public static final /* synthetic */ int access$getSCREEN_BOTTOM_BUFFER$cp() {
        return SCREEN_BOTTOM_BUFFER;
    }

    public static final /* synthetic */ FolderContextMenuViewModel access$getViewModel$p(WidgetFolderContextMenu widgetFolderContextMenu) {
        return widgetFolderContextMenu.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetFolderContextMenu widgetFolderContextMenu, FolderContextMenuViewModel$Event folderContextMenuViewModel$Event) {
        widgetFolderContextMenu.handleEvent(folderContextMenuViewModel$Event);
    }

    public static final /* synthetic */ boolean access$isShowingContextMenu$cp() {
        return isShowingContextMenu;
    }

    public static final /* synthetic */ void access$setAnimationState$p(WidgetFolderContextMenu widgetFolderContextMenu, WidgetFolderContextMenu$AnimationState widgetFolderContextMenu$AnimationState) {
        widgetFolderContextMenu.animationState = widgetFolderContextMenu$AnimationState;
    }

    public static final /* synthetic */ void access$setShowingContextMenu$cp(boolean z2) {
        isShowingContextMenu = z2;
    }

    private final void configureUI(FolderContextMenuViewModel$ViewState viewState) {
        if (viewState instanceof FolderContextMenuViewModel$ViewState$Valid) {
            configureValidUI((FolderContextMenuViewModel$ViewState$Valid) viewState);
        } else if (m.areEqual(viewState, FolderContextMenuViewModel$ViewState$Invalid.INSTANCE)) {
            WidgetFolderContextMenu$Companion widgetFolderContextMenu$Companion = Companion;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            widgetFolderContextMenu$Companion.hide(fragmentActivityRequireActivity, false);
        }
    }

    private final void configureValidUI(FolderContextMenuViewModel$ViewState$Valid viewState) {
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.folderContextMenuHeader");
        CharSequence name = viewState.getFolder().getName();
        if (name == null) {
            name = b.k(this, 2131890230, new Object[0], null, 4);
        }
        textView.setText(name);
        getBinding().d.setOnClickListener(new WidgetFolderContextMenu$configureValidUI$1(this));
        getBinding().e.setOnClickListener(new WidgetFolderContextMenu$configureValidUI$2(this, viewState));
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.folderContextMenuMarkAsRead");
        textView2.setVisibility(viewState.getShowMarkAsRead() ? 0 : 8);
        getBinding().f2386b.setContentPadding(0, 0, 0, 0);
        CardView cardView = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        if (cardView.getVisibility() == 0) {
            return;
        }
        doCircularReveal();
    }

    private final void doCircularRemove() {
        WidgetFolderContextMenu$AnimationState widgetFolderContextMenu$AnimationState = this.animationState;
        if (widgetFolderContextMenu$AnimationState == WidgetFolderContextMenu$AnimationState.ANIMATING_IN) {
            Animator animator = this.animator;
            if (animator != null) {
                animator.cancel();
            }
            WidgetFolderContextMenu$Companion widgetFolderContextMenu$Companion = Companion;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            widgetFolderContextMenu$Companion.hide(fragmentActivityRequireActivity, false);
            return;
        }
        WidgetFolderContextMenu$AnimationState widgetFolderContextMenu$AnimationState2 = WidgetFolderContextMenu$AnimationState.ANIMATING_OUT;
        if (widgetFolderContextMenu$AnimationState == widgetFolderContextMenu$AnimationState2) {
            return;
        }
        CardView cardView = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        int height = cardView.getHeight() / 2;
        CardView cardView2 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
        int width = cardView2.getWidth();
        CardView cardView3 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        float fHypot = (float) Math.hypot(width, cardView3.getHeight() / 2);
        CardView cardView4 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
        if (!cardView4.isAttachedToWindow()) {
            CardView cardView5 = getBinding().f2386b;
            m.checkNotNullExpressionValue(cardView5, "binding.folderContextMenuCard");
            cardView5.setVisibility(8);
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2386b, 0, height, fHypot, 0.0f);
        this.animator = animatorCreateCircularReveal;
        this.animationState = widgetFolderContextMenu$AnimationState2;
        m.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new WidgetFolderContextMenu$doCircularRemove$1(this));
        animatorCreateCircularReveal.start();
    }

    private final void doCircularReveal() {
        CardView cardView = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView, "binding.folderContextMenuCard");
        if (!cardView.isAttachedToWindow()) {
            CardView cardView2 = getBinding().f2386b;
            m.checkNotNullExpressionValue(cardView2, "binding.folderContextMenuCard");
            cardView2.setVisibility(0);
            return;
        }
        CardView cardView3 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView3, "binding.folderContextMenuCard");
        int height = cardView3.getHeight() / 2;
        CardView cardView4 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView4, "binding.folderContextMenuCard");
        int width = cardView4.getWidth();
        CardView cardView5 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView5, "binding.folderContextMenuCard");
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2386b, 0, height, 0.0f, (float) Math.hypot(width, cardView5.getHeight() / 2));
        this.animator = animatorCreateCircularReveal;
        this.animationState = WidgetFolderContextMenu$AnimationState.ANIMATING_IN;
        m.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new WidgetFolderContextMenu$doCircularReveal$1(this));
        CardView cardView6 = getBinding().f2386b;
        m.checkNotNullExpressionValue(cardView6, "binding.folderContextMenuCard");
        cardView6.setVisibility(0);
        animatorCreateCircularReveal.start();
    }

    private final WidgetFolderContextMenuBinding getBinding() {
        return (WidgetFolderContextMenuBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FolderContextMenuViewModel getViewModel() {
        return (FolderContextMenuViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(FolderContextMenuViewModel$Event event) {
        if (m.areEqual(event, FolderContextMenuViewModel$Event$Dismiss.INSTANCE)) {
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetFolderContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFolderContextMenu$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetFolderContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetFolderContextMenu$onResume$2(this), 62, (Object) null);
    }
}
