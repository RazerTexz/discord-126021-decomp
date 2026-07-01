package com.discord.widgets.chat.overlay;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.a.i.WidgetChatInputStickerSuggestionsBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatOverlayBinding;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.sticker.StickerView;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import com.discord.widgets.chat.overlay.WidgetChatOverlay;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChatOverlay.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatOverlayBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: chatInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy chatInputViewModel;

    /* JADX INFO: renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;
    private TypingIndicatorViewHolder typingIndicatorViewHolder;

    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final /* data */ class OldMessageModel {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long channelId;
        private final boolean isViewingOldMessages;

        /* JADX INFO: compiled from: WidgetChatOverlay.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<OldMessageModel> get() {
                Observable observableY = StoreStream.INSTANCE.getChannelsSelected().observeId().r().Y(new Func1<Long, Observable<? extends OldMessageModel>>() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1
                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetChatOverlay.OldMessageModel> call(final Long l) {
                        Observable observableJ;
                        if (l.longValue() <= 0) {
                            observableJ = new ScalarSynchronousObservable(Boolean.FALSE);
                        } else {
                            StoreStream.Companion companion = StoreStream.INSTANCE;
                            StoreMessages messages = companion.getMessages();
                            Intrinsics3.checkNotNullExpressionValue(l, "selectedChannelId");
                            observableJ = Observable.j(messages.observeIsDetached(l.longValue()), companion.getChat().observeInteractionState().y(new Func1<StoreChat.InteractionState, Boolean>() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$1
                                @Override // j0.k.Func1
                                public final Boolean call(StoreChat.InteractionState interactionState) {
                                    long channelId = interactionState.getChannelId();
                                    Long l2 = l;
                                    return Boolean.valueOf((l2 == null || channelId != l2.longValue() || interactionState.getLastMessageId() == 0) ? false : true);
                                }
                            }).p(200L, TimeUnit.MILLISECONDS), new Func2<Boolean, StoreChat.InteractionState, Boolean>() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$2
                                @Override // rx.functions.Func2
                                public final Boolean call(Boolean bool, StoreChat.InteractionState interactionState) {
                                    Intrinsics3.checkNotNullExpressionValue(bool, "isDetached");
                                    return Boolean.valueOf(bool.booleanValue() || !(interactionState.isAtBottomIgnoringTouch() || interactionState.isNearBottomIgnoringTouch()));
                                }
                            });
                        }
                        return Observable.m(new ScalarSynchronousObservable(Boolean.FALSE), observableJ).r().G(new Func1<Boolean, WidgetChatOverlay.OldMessageModel>() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1.1
                            @Override // j0.k.Func1
                            public final WidgetChatOverlay.OldMessageModel call(Boolean bool) {
                                Long l2 = l;
                                Intrinsics3.checkNotNullExpressionValue(l2, "selectedChannelId");
                                long jLongValue = l2.longValue();
                                Intrinsics3.checkNotNullExpressionValue(bool, "isViewingOldMessages");
                                return new WidgetChatOverlay.OldMessageModel(jLongValue, bool.booleanValue());
                            }
                        });
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
                return observableY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public OldMessageModel(long j, boolean z2) {
            this.channelId = j;
            this.isViewingOldMessages = z2;
        }

        public static /* synthetic */ OldMessageModel copy$default(OldMessageModel oldMessageModel, long j, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = oldMessageModel.channelId;
            }
            if ((i & 2) != 0) {
                z2 = oldMessageModel.isViewingOldMessages;
            }
            return oldMessageModel.copy(j, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsViewingOldMessages() {
            return this.isViewingOldMessages;
        }

        public final OldMessageModel copy(long channelId, boolean isViewingOldMessages) {
            return new OldMessageModel(channelId, isViewingOldMessages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OldMessageModel)) {
                return false;
            }
            OldMessageModel oldMessageModel = (OldMessageModel) other;
            return this.channelId == oldMessageModel.channelId && this.isViewingOldMessages == oldMessageModel.isViewingOldMessages;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            boolean z2 = this.isViewingOldMessages;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iA + r1;
        }

        public final boolean isViewingOldMessages() {
            return this.isViewingOldMessages;
        }

        public String toString() {
            StringBuilder sbU = outline.U("OldMessageModel(channelId=");
            sbU.append(this.channelId);
            sbU.append(", isViewingOldMessages=");
            return outline.O(sbU, this.isViewingOldMessages, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final /* data */ class StickerAutocompleteState {
        private final boolean autocompleteVisible;
        private final FlexInputState flexInputState;
        private final boolean isForumPostDraftCreation;

        public StickerAutocompleteState(boolean z2, FlexInputState flexInputState, boolean z3) {
            Intrinsics3.checkNotNullParameter(flexInputState, "flexInputState");
            this.autocompleteVisible = z2;
            this.flexInputState = flexInputState;
            this.isForumPostDraftCreation = z3;
        }

        public static /* synthetic */ StickerAutocompleteState copy$default(StickerAutocompleteState stickerAutocompleteState, boolean z2, FlexInputState flexInputState, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = stickerAutocompleteState.autocompleteVisible;
            }
            if ((i & 2) != 0) {
                flexInputState = stickerAutocompleteState.flexInputState;
            }
            if ((i & 4) != 0) {
                z3 = stickerAutocompleteState.isForumPostDraftCreation;
            }
            return stickerAutocompleteState.copy(z2, flexInputState, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getAutocompleteVisible() {
            return this.autocompleteVisible;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FlexInputState getFlexInputState() {
            return this.flexInputState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsForumPostDraftCreation() {
            return this.isForumPostDraftCreation;
        }

        public final StickerAutocompleteState copy(boolean autocompleteVisible, FlexInputState flexInputState, boolean isForumPostDraftCreation) {
            Intrinsics3.checkNotNullParameter(flexInputState, "flexInputState");
            return new StickerAutocompleteState(autocompleteVisible, flexInputState, isForumPostDraftCreation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StickerAutocompleteState)) {
                return false;
            }
            StickerAutocompleteState stickerAutocompleteState = (StickerAutocompleteState) other;
            return this.autocompleteVisible == stickerAutocompleteState.autocompleteVisible && Intrinsics3.areEqual(this.flexInputState, stickerAutocompleteState.flexInputState) && this.isForumPostDraftCreation == stickerAutocompleteState.isForumPostDraftCreation;
        }

        public final boolean getAutocompleteVisible() {
            return this.autocompleteVisible;
        }

        public final FlexInputState getFlexInputState() {
            return this.flexInputState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean z2 = this.autocompleteVisible;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            FlexInputState flexInputState = this.flexInputState;
            int iHashCode = (i + (flexInputState != null ? flexInputState.hashCode() : 0)) * 31;
            boolean z3 = this.isForumPostDraftCreation;
            return iHashCode + (z3 ? 1 : z3);
        }

        public final boolean isForumPostDraftCreation() {
            return this.isForumPostDraftCreation;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StickerAutocompleteState(autocompleteVisible=");
            sbU.append(this.autocompleteVisible);
            sbU.append(", flexInputState=");
            sbU.append(this.flexInputState);
            sbU.append(", isForumPostDraftCreation=");
            return outline.O(sbU, this.isForumPostDraftCreation, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final class TypingIndicatorViewHolder {
        private final WidgetChatOverlayBinding binding;

        public TypingIndicatorViewHolder(WidgetChatOverlayBinding widgetChatOverlayBinding) {
            Intrinsics3.checkNotNullParameter(widgetChatOverlayBinding, "binding");
            this.binding = widgetChatOverlayBinding;
        }

        private final void configureTyping(ChatTypingModel.Typing model) {
            if (model.getTypingUsers().isEmpty() && model.getChannelRateLimit() <= 0) {
                this.binding.d.c();
                RelativeLayout relativeLayout = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
                relativeLayout.setVisibility(8);
                return;
            }
            RelativeLayout relativeLayout2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.chatOverlayTyping");
            relativeLayout2.setVisibility(0);
            ConstraintLayout constraintLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Resources resources = constraintLayout.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "binding.root.resources");
            CharSequence typingString = getTypingString(resources, model.getTypingUsers());
            CharSequence slowmodeText = getSlowmodeText(model.getCooldownSecs(), model.getChannelRateLimit(), !StringsJVM.isBlank(typingString));
            TextView textView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatTypingUsersTyping");
            ViewExtensions.setTextAndVisibilityBy(textView, typingString);
            TypingDots typingDots = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(typingDots, "binding.chatOverlayTypingDots");
            typingDots.setVisibility(model.getTypingUsers().isEmpty() ^ true ? 0 : 8);
            TypingDots typingDots2 = this.binding.d;
            if (!model.getTypingUsers().isEmpty()) {
                TypingDots.b(typingDots2, false, 1);
            } else {
                typingDots2.c();
            }
            TextView textView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatTypingUsersSlowmode");
            ViewExtensions.setTextAndVisibilityBy(textView2, slowmodeText);
            ImageView imageView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatTypingUsersSlowmodeIcon");
            imageView.setVisibility(model.getChannelRateLimit() > 0 ? 0 : 8);
        }

        private final CharSequence getSlowmodeText(int cooldownSecs, int channelRateLimit, boolean hasTypingText) {
            if (cooldownSecs > 0) {
                return TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, 1000 * ((long) cooldownSecs), null, null, 6, null);
            }
            if (channelRateLimit <= 0 || hasTypingText) {
                return "";
            }
            ConstraintLayout constraintLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            String string = constraintLayout.getResources().getString(R.string.channel_slowmode_desc_short);
            Intrinsics3.checkNotNullExpressionValue(string, "binding.root.resources.g…nnel_slowmode_desc_short)");
            return string;
        }

        private final CharSequence getTypingString(Resources resources, List<? extends CharSequence> typingUsers) {
            int size = typingUsers.size();
            if (size == 0) {
                return "";
            }
            if (size == 1) {
                return FormatUtils.c(resources, R.string.one_user_typing, new Object[]{typingUsers.get(0)}, (4 & 4) != 0 ? FormatUtils.d.j : null);
            }
            if (size != 2) {
                return size != 3 ? FormatUtils.c(resources, R.string.several_users_typing, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null) : FormatUtils.c(resources, R.string.three_users_typing, new Object[]{typingUsers.get(0), typingUsers.get(1), typingUsers.get(2)}, (4 & 4) != 0 ? FormatUtils.d.j : null);
            }
            return FormatUtils.c(resources, R.string.two_users_typing, new Object[]{typingUsers.get(0), typingUsers.get(1)}, (4 & 4) != 0 ? FormatUtils.d.j : null);
        }

        public final void configureUI(ChatTypingModel model) {
            Intrinsics3.checkNotNullParameter(model, "model");
            if (model instanceof ChatTypingModel.Hide) {
                RelativeLayout relativeLayout = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
                relativeLayout.setVisibility(8);
            } else if (model instanceof ChatTypingModel.Typing) {
                configureTyping((ChatTypingModel.Typing) model);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<OldMessageModel, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OldMessageModel oldMessageModel) {
            invoke2(oldMessageModel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OldMessageModel oldMessageModel) {
            if (oldMessageModel.isViewingOldMessages()) {
                WidgetChatOverlay.this.getBinding().f2345b.show();
            } else {
                WidgetChatOverlay.this.getBinding().f2345b.hide();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<ChatTypingModel, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatTypingModel chatTypingModel) {
            invoke2(chatTypingModel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatTypingModel chatTypingModel) {
            TypingIndicatorViewHolder typingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p = WidgetChatOverlay.access$getTypingIndicatorViewHolder$p(WidgetChatOverlay.this);
            Intrinsics3.checkNotNullExpressionValue(chatTypingModel, "it");
            typingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p.configureUI(chatTypingModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<StickerAutocompleteState, Unit> {
        public AnonymousClass6(WidgetChatOverlay widgetChatOverlay) {
            super(1, widgetChatOverlay, WidgetChatOverlay.class, "configureStickerSuggestions", "configureStickerSuggestions(Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerAutocompleteState stickerAutocompleteState) {
            invoke2(stickerAutocompleteState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerAutocompleteState stickerAutocompleteState) {
            Intrinsics3.checkNotNullParameter(stickerAutocompleteState, "p1");
            ((WidgetChatOverlay) this.receiver).configureStickerSuggestions(stickerAutocompleteState);
        }
    }

    public WidgetChatOverlay() {
        super(R.layout.widget_chat_overlay);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChatOverlay5.INSTANCE, null, 2, null);
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetChatOverlay$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetChatOverlay8(this)));
        this.chatInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ChatInputViewModel.class), new WidgetChatOverlay$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(WidgetChatOverlay6.INSTANCE));
    }

    public static final /* synthetic */ TypingIndicatorViewHolder access$getTypingIndicatorViewHolder$p(WidgetChatOverlay widgetChatOverlay) {
        TypingIndicatorViewHolder typingIndicatorViewHolder = widgetChatOverlay.typingIndicatorViewHolder;
        if (typingIndicatorViewHolder == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("typingIndicatorViewHolder");
        }
        return typingIndicatorViewHolder;
    }

    private final void configureStickerSuggestions(StickerAutocompleteState stickerAutocompleteState) {
        boolean autocompleteVisible = stickerAutocompleteState.getAutocompleteVisible();
        FlexInputState flexInputState = stickerAutocompleteState.getFlexInputState();
        boolean isForumPostDraftCreation = stickerAutocompleteState.getIsForumPostDraftCreation();
        if (!flexInputState.expressionSuggestionsEnabled || autocompleteVisible || isForumPostDraftCreation) {
            WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding, "binding.stickersSuggestions");
            LinearLayout linearLayout = widgetChatInputStickerSuggestionsBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
            linearLayout.setVisibility(8);
            return;
        }
        final List listTake = _Collections.take(getFlexInputViewModel().getMatchingStickers(flexInputState.inputText), 4);
        boolean z2 = SearchUtils.INSTANCE.getQueriesFromSearchText(flexInputState.inputText).size() == 1;
        if (listTake == null || listTake.isEmpty()) {
            WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding2 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding2, "binding.stickersSuggestions");
            LinearLayout linearLayout2 = widgetChatInputStickerSuggestionsBinding2.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.stickersSuggestions.root");
            linearLayout2.setVisibility(8);
            return;
        }
        StoreStream.INSTANCE.getExpressionSuggestions().trackExpressionSuggestionsDisplayed(flexInputState.inputText);
        WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding3 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding3, "binding.stickersSuggestions");
        LinearLayout linearLayout3 = widgetChatInputStickerSuggestionsBinding3.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.stickersSuggestions.root");
        linearLayout3.setVisibility(0);
        int i = 0;
        for (Object obj : Collections2.listOf((Object[]) new StickerView[]{getBinding().h.f230b, getBinding().h.c, getBinding().h.d, getBinding().h.e})) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            final StickerView stickerView = (StickerView) obj;
            final Sticker sticker = i < listTake.size() ? (Sticker) listTake.get(i) : null;
            Intrinsics3.checkNotNullExpressionValue(stickerView, "stickerView");
            stickerView.setVisibility(sticker != null ? 0 : 8);
            if (sticker != null) {
                StickerView.e(stickerView, sticker, null, 2);
                final Sticker sticker2 = sticker;
                final boolean z3 = z2;
                stickerView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay$configureStickerSuggestions$$inlined$forEachIndexed$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AnalyticsTracker.INSTANCE.expressionSuggestionsSelected(sticker.getId(), StoreStream.INSTANCE.getExpressionSuggestions().getLastSuggestionTrigger());
                        Intrinsics3.checkNotNullExpressionValue(view, "it");
                        Context context = view.getContext();
                        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                        this.getChatInputViewModel().sendSticker(sticker2, new MessageManager(context, null, null, null, null, null, null, null, null, 510, null));
                        this.getFlexInputViewModel().onStickerSuggestionSent(z3);
                    }
                });
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
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        this.typingIndicatorViewHolder = new TypingIndicatorViewHolder(binding);
        WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding, "binding.stickersSuggestions");
        LinearLayout linearLayout = widgetChatInputStickerSuggestionsBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
        Drawable background = linearLayout.getBackground();
        Intrinsics3.checkNotNullExpressionValue(background, "binding.stickersSuggestions.root.background");
        background.setAlpha(216);
        getBinding().h.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getExpressionSuggestions().setExpressionSuggestionsEnabled(false);
            }
        });
        getBinding().f2345b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getMessagesLoader().requestNewestMessages();
            }
        });
        Observable<OldMessageModel> observableR = OldMessageModel.INSTANCE.get().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "OldMessageModel.get()\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) WidgetChatOverlay.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
        Observable observableR2 = ObservableExtensionsKt.computationLatest(ChatTypingModel.INSTANCE.get()).r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "ChatTypingModel\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableR2, this, null, 2, null), (Class<?>) WidgetChatOverlay.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableI = Observable.i(companion.getAutocomplete().observeAutocompleteVisibility().r(), getFlexInputViewModel().observeState().r(), companion.getChannelsSelected().observeResolvedSelectedChannel(), new Func3<Boolean, FlexInputState, StoreChannelsSelected.ResolvedSelectedChannel, StickerAutocompleteState>() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay.onViewBoundOrOnResume.5
            @Override // rx.functions.Func3
            public final StickerAutocompleteState call(Boolean bool, FlexInputState flexInputState, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                Channel parentChannel;
                if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
                    resolvedSelectedChannel = null;
                }
                StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel;
                Intrinsics3.checkNotNullExpressionValue(bool, "autocompleteVisible");
                boolean zBooleanValue = bool.booleanValue();
                Intrinsics3.checkNotNullExpressionValue(flexInputState, "flexInputState");
                return new StickerAutocompleteState(zBooleanValue, flexInputState, (threadDraft == null || (parentChannel = threadDraft.getParentChannel()) == null || !ChannelUtils.q(parentChannel)) ? false : true);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…() == true,\n      )\n    }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableI, this, null, 2, null), (Class<?>) WidgetChatOverlay.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass6(this));
    }
}
