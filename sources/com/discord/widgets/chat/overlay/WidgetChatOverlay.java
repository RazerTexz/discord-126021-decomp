package com.discord.widgets.chat.overlay;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.i.x4;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatOverlayBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import d0.t.n;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChatOverlay.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatOverlayBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: chatInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy chatInputViewModel;

    /* JADX INFO: renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;
    private WidgetChatOverlay$TypingIndicatorViewHolder typingIndicatorViewHolder;

    public WidgetChatOverlay() {
        super(R$layout.widget_chat_overlay);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChatOverlay$binding$2.INSTANCE, null, 2, null);
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetChatOverlay$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetChatOverlay$flexInputViewModel$2(this)));
        this.chatInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ChatInputViewModel.class), new WidgetChatOverlay$appActivityViewModels$$inlined$activityViewModels$3(this), new f0(WidgetChatOverlay$chatInputViewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$configureStickerSuggestions(WidgetChatOverlay widgetChatOverlay, WidgetChatOverlay$StickerAutocompleteState widgetChatOverlay$StickerAutocompleteState) {
        widgetChatOverlay.configureStickerSuggestions(widgetChatOverlay$StickerAutocompleteState);
    }

    public static final /* synthetic */ WidgetChatOverlayBinding access$getBinding$p(WidgetChatOverlay widgetChatOverlay) {
        return widgetChatOverlay.getBinding();
    }

    public static final /* synthetic */ ChatInputViewModel access$getChatInputViewModel$p(WidgetChatOverlay widgetChatOverlay) {
        return widgetChatOverlay.getChatInputViewModel();
    }

    public static final /* synthetic */ AppFlexInputViewModel access$getFlexInputViewModel$p(WidgetChatOverlay widgetChatOverlay) {
        return widgetChatOverlay.getFlexInputViewModel();
    }

    public static final /* synthetic */ WidgetChatOverlay$TypingIndicatorViewHolder access$getTypingIndicatorViewHolder$p(WidgetChatOverlay widgetChatOverlay) {
        WidgetChatOverlay$TypingIndicatorViewHolder widgetChatOverlay$TypingIndicatorViewHolder = widgetChatOverlay.typingIndicatorViewHolder;
        if (widgetChatOverlay$TypingIndicatorViewHolder == null) {
            m.throwUninitializedPropertyAccessException("typingIndicatorViewHolder");
        }
        return widgetChatOverlay$TypingIndicatorViewHolder;
    }

    public static final /* synthetic */ void access$setTypingIndicatorViewHolder$p(WidgetChatOverlay widgetChatOverlay, WidgetChatOverlay$TypingIndicatorViewHolder widgetChatOverlay$TypingIndicatorViewHolder) {
        widgetChatOverlay.typingIndicatorViewHolder = widgetChatOverlay$TypingIndicatorViewHolder;
    }

    private final void configureStickerSuggestions(WidgetChatOverlay$StickerAutocompleteState stickerAutocompleteState) {
        boolean autocompleteVisible = stickerAutocompleteState.getAutocompleteVisible();
        FlexInputState flexInputState = stickerAutocompleteState.getFlexInputState();
        boolean isForumPostDraftCreation = stickerAutocompleteState.getIsForumPostDraftCreation();
        if (!flexInputState.expressionSuggestionsEnabled || autocompleteVisible || isForumPostDraftCreation) {
            x4 x4Var = getBinding().h;
            m.checkNotNullExpressionValue(x4Var, "binding.stickersSuggestions");
            LinearLayout linearLayout = x4Var.a;
            m.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
            linearLayout.setVisibility(8);
            return;
        }
        List listTake = u.take(getFlexInputViewModel().getMatchingStickers(flexInputState.inputText), 4);
        boolean z2 = SearchUtils.INSTANCE.getQueriesFromSearchText(flexInputState.inputText).size() == 1;
        if (listTake == null || listTake.isEmpty()) {
            x4 x4Var2 = getBinding().h;
            m.checkNotNullExpressionValue(x4Var2, "binding.stickersSuggestions");
            LinearLayout linearLayout2 = x4Var2.a;
            m.checkNotNullExpressionValue(linearLayout2, "binding.stickersSuggestions.root");
            linearLayout2.setVisibility(8);
            return;
        }
        StoreStream.Companion.getExpressionSuggestions().trackExpressionSuggestionsDisplayed(flexInputState.inputText);
        x4 x4Var3 = getBinding().h;
        m.checkNotNullExpressionValue(x4Var3, "binding.stickersSuggestions");
        LinearLayout linearLayout3 = x4Var3.a;
        m.checkNotNullExpressionValue(linearLayout3, "binding.stickersSuggestions.root");
        linearLayout3.setVisibility(0);
        int i = 0;
        for (Object obj : n.listOf((Object[]) new StickerView[]{getBinding().h.f230b, getBinding().h.c, getBinding().h.d, getBinding().h.e})) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            StickerView stickerView = (StickerView) obj;
            Sticker sticker = i < listTake.size() ? (Sticker) listTake.get(i) : null;
            m.checkNotNullExpressionValue(stickerView, "stickerView");
            stickerView.setVisibility(sticker != null ? 0 : 8);
            if (sticker != null) {
                StickerView.e(stickerView, sticker, null, 2);
                stickerView.setOnClickListener(new WidgetChatOverlay$configureStickerSuggestions$$inlined$forEachIndexed$lambda$1(sticker, stickerView, sticker, this, listTake, z2));
            }
            i = i2;
        }
    }

    private final WidgetChatOverlayBinding getBinding() {
        return (WidgetChatOverlayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChatInputViewModel getChatInputViewModel() {
        return (ChatInputViewModel) this.chatInputViewModel.getValue();
    }

    private final AppFlexInputViewModel getFlexInputViewModel() {
        return (AppFlexInputViewModel) this.flexInputViewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetChatOverlayBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        this.typingIndicatorViewHolder = new WidgetChatOverlay$TypingIndicatorViewHolder(binding);
        x4 x4Var = getBinding().h;
        m.checkNotNullExpressionValue(x4Var, "binding.stickersSuggestions");
        LinearLayout linearLayout = x4Var.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
        Drawable background = linearLayout.getBackground();
        m.checkNotNullExpressionValue(background, "binding.stickersSuggestions.root.background");
        background.setAlpha(216);
        getBinding().h.f.setOnClickListener(WidgetChatOverlay$onViewBoundOrOnResume$1.INSTANCE);
        getBinding().f2345b.setOnClickListener(WidgetChatOverlay$onViewBoundOrOnResume$2.INSTANCE);
        Observable<WidgetChatOverlay$OldMessageModel> observableR = WidgetChatOverlay$OldMessageModel.Companion.get().r();
        m.checkNotNullExpressionValue(observableR, "OldMessageModel.get()\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatOverlay$onViewBoundOrOnResume$3(this), 62, (Object) null);
        Observable observableR2 = ObservableExtensionsKt.computationLatest(ChatTypingModel.Companion.get()).r();
        m.checkNotNullExpressionValue(observableR2, "ChatTypingModel\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR2, this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatOverlay$onViewBoundOrOnResume$4(this), 62, (Object) null);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableI = Observable.i(storeStream$Companion.getAutocomplete().observeAutocompleteVisibility().r(), getFlexInputViewModel().observeState().r(), storeStream$Companion.getChannelsSelected().observeResolvedSelectedChannel(), WidgetChatOverlay$onViewBoundOrOnResume$5.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…() == true,\n      )\n    }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableI, this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatOverlay$onViewBoundOrOnResume$6(this), 62, (Object) null);
    }
}
