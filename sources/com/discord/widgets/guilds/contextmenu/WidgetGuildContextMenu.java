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
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildContextMenuBinding;
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

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildContextMenu extends AppFragment {
    private static final String FRAGMENT_TAG = "WidgetGuildContextMenu";
    private static final String VIEW_CONTAINER_TAG = "WidgetGuildContextMenuViewContainer";
    private static boolean isShowingContextMenu;
    private WidgetGuildContextMenu$AnimationState animationState;
    private Animator animator;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildContextMenu.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildContextMenuBinding;", 0)};
    public static final WidgetGuildContextMenu$Companion Companion = new WidgetGuildContextMenu$Companion(null);
    private static final int SCREEN_BOTTOM_BUFFER = DimenUtils.dpToPixels(96);

    public WidgetGuildContextMenu() {
        super(R$layout.widget_guild_context_menu);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildContextMenu$binding$2.INSTANCE, null, 2, null);
        WidgetGuildContextMenu$viewModel$2 widgetGuildContextMenu$viewModel$2 = new WidgetGuildContextMenu$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildContextMenuViewModel.class), new WidgetGuildContextMenu$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildContextMenu$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildContextMenu widgetGuildContextMenu, GuildContextMenuViewModel$ViewState guildContextMenuViewModel$ViewState) {
        widgetGuildContextMenu.configureUI(guildContextMenuViewModel$ViewState);
    }

    public static final /* synthetic */ void access$doCircularRemove(WidgetGuildContextMenu widgetGuildContextMenu) {
        widgetGuildContextMenu.doCircularRemove();
    }

    public static final /* synthetic */ WidgetGuildContextMenu$AnimationState access$getAnimationState$p(WidgetGuildContextMenu widgetGuildContextMenu) {
        return widgetGuildContextMenu.animationState;
    }

    public static final /* synthetic */ int access$getSCREEN_BOTTOM_BUFFER$cp() {
        return SCREEN_BOTTOM_BUFFER;
    }

    public static final /* synthetic */ GuildContextMenuViewModel access$getViewModel$p(WidgetGuildContextMenu widgetGuildContextMenu) {
        return widgetGuildContextMenu.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildContextMenu widgetGuildContextMenu, GuildContextMenuViewModel$Event guildContextMenuViewModel$Event) {
        widgetGuildContextMenu.handleEvent(guildContextMenuViewModel$Event);
    }

    public static final /* synthetic */ boolean access$isShowingContextMenu$cp() {
        return isShowingContextMenu;
    }

    public static final /* synthetic */ void access$setAnimationState$p(WidgetGuildContextMenu widgetGuildContextMenu, WidgetGuildContextMenu$AnimationState widgetGuildContextMenu$AnimationState) {
        widgetGuildContextMenu.animationState = widgetGuildContextMenu$AnimationState;
    }

    public static final /* synthetic */ void access$setShowingContextMenu$cp(boolean z2) {
        isShowingContextMenu = z2;
    }

    private final void configureUI(GuildContextMenuViewModel$ViewState viewState) {
        if (viewState instanceof GuildContextMenuViewModel$ViewState$Valid) {
            configureValidUI((GuildContextMenuViewModel$ViewState$Valid) viewState);
        } else if (m.areEqual(viewState, GuildContextMenuViewModel$ViewState$Invalid.INSTANCE)) {
            WidgetGuildContextMenu$Companion widgetGuildContextMenu$Companion = Companion;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            widgetGuildContextMenu$Companion.hide(fragmentActivityRequireActivity, false);
        }
    }

    private final void configureValidUI(GuildContextMenuViewModel$ViewState$Valid viewState) {
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.guildContextMenuHeader");
        textView.setText(viewState.getGuild().getName());
        getBinding().e.setOnClickListener(new WidgetGuildContextMenu$configureValidUI$1(this));
        getBinding().g.setOnClickListener(new WidgetGuildContextMenu$configureValidUI$2(this, viewState));
        getBinding().d.setOnClickListener(new WidgetGuildContextMenu$configureValidUI$3(this, viewState));
        getBinding().f.setOnClickListener(new WidgetGuildContextMenu$configureValidUI$4(this, viewState));
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.guildContextMenuLeaveGuild");
        textView2.setVisibility(viewState.getShowLeaveGuild() ? 0 : 8);
        TextView textView3 = getBinding().e;
        m.checkNotNullExpressionValue(textView3, "binding.guildContextMenuMarkAsRead");
        textView3.setVisibility(viewState.getShowMarkAsRead() ? 0 : 8);
        getBinding().f2411b.setContentPadding(0, 0, 0, 0);
        CardView cardView = getBinding().f2411b;
        m.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        if (cardView.getVisibility() == 0) {
            return;
        }
        doCircularReveal();
    }

    private final void doCircularRemove() {
        WidgetGuildContextMenu$AnimationState widgetGuildContextMenu$AnimationState = this.animationState;
        if (widgetGuildContextMenu$AnimationState == WidgetGuildContextMenu$AnimationState.ANIMATING_IN) {
            Animator animator = this.animator;
            if (animator != null) {
                animator.cancel();
            }
            WidgetGuildContextMenu$Companion widgetGuildContextMenu$Companion = Companion;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            widgetGuildContextMenu$Companion.hide(fragmentActivityRequireActivity, false);
            return;
        }
        WidgetGuildContextMenu$AnimationState widgetGuildContextMenu$AnimationState2 = WidgetGuildContextMenu$AnimationState.ANIMATING_OUT;
        if (widgetGuildContextMenu$AnimationState == widgetGuildContextMenu$AnimationState2) {
            return;
        }
        CardView cardView = getBinding().f2411b;
        m.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        int height = cardView.getHeight() / 2;
        CardView cardView2 = getBinding().f2411b;
        m.checkNotNullExpressionValue(cardView2, "binding.guildContextMenuCard");
        int width = cardView2.getWidth();
        CardView cardView3 = getBinding().f2411b;
        m.checkNotNullExpressionValue(cardView3, "binding.guildContextMenuCard");
        float fHypot = (float) Math.hypot(width, cardView3.getHeight() / 2);
        CardView cardView4 = getBinding().f2411b;
        m.checkNotNullExpressionValue(cardView4, "binding.guildContextMenuCard");
        if (!cardView4.isAttachedToWindow()) {
            CardView cardView5 = getBinding().f2411b;
            m.checkNotNullExpressionValue(cardView5, "binding.guildContextMenuCard");
            cardView5.setVisibility(8);
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2411b, 0, height, fHypot, 0.0f);
        this.animator = animatorCreateCircularReveal;
        this.animationState = widgetGuildContextMenu$AnimationState2;
        m.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new WidgetGuildContextMenu$doCircularRemove$1(this));
        animatorCreateCircularReveal.start();
    }

    private final void doCircularReveal() {
        CardView cardView = getBinding().f2411b;
        m.checkNotNullExpressionValue(cardView, "binding.guildContextMenuCard");
        if (!cardView.isAttachedToWindow()) {
            CardView cardView2 = getBinding().f2411b;
            m.checkNotNullExpressionValue(cardView2, "binding.guildContextMenuCard");
            cardView2.setVisibility(0);
            return;
        }
        CardView cardView3 = getBinding().f2411b;
        m.checkNotNullExpressionValue(cardView3, "binding.guildContextMenuCard");
        int height = cardView3.getHeight() / 2;
        CardView cardView4 = getBinding().f2411b;
        m.checkNotNullExpressionValue(cardView4, "binding.guildContextMenuCard");
        int width = cardView4.getWidth();
        CardView cardView5 = getBinding().f2411b;
        m.checkNotNullExpressionValue(cardView5, "binding.guildContextMenuCard");
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(getBinding().f2411b, 0, height, 0.0f, (float) Math.hypot(width, cardView5.getHeight() / 2));
        this.animator = animatorCreateCircularReveal;
        this.animationState = WidgetGuildContextMenu$AnimationState.ANIMATING_IN;
        m.checkNotNullExpressionValue(animatorCreateCircularReveal, "animator");
        animatorCreateCircularReveal.setDuration(200L);
        animatorCreateCircularReveal.addListener(new WidgetGuildContextMenu$doCircularReveal$1(this));
        CardView cardView6 = getBinding().f2411b;
        m.checkNotNullExpressionValue(cardView6, "binding.guildContextMenuCard");
        cardView6.setVisibility(0);
        animatorCreateCircularReveal.start();
    }

    private final WidgetGuildContextMenuBinding getBinding() {
        return (WidgetGuildContextMenuBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildContextMenuViewModel getViewModel() {
        return (GuildContextMenuViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GuildContextMenuViewModel$Event event) {
        if (m.areEqual(event, GuildContextMenuViewModel$Event$Dismiss.INSTANCE)) {
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildContextMenu$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildContextMenu.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildContextMenu$onResume$2(this), 62, (Object) null);
    }
}
