package com.discord.widgets.chat.overlay;

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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.sticker.StickerView;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p025i.C1084x4;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChatOverlay.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatOverlayBinding;", 0)};

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
                Observable observableM11099Y = StoreStream.INSTANCE.getChannelsSelected().observeId().m11112r().m11099Y(new InterfaceC12589b<Long, Observable<? extends OldMessageModel>>() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetChatOverlay.OldMessageModel> call(final Long l) {
                        Observable observableM11076j;
                        if (l.longValue() <= 0) {
                            observableM11076j = new C12721k(Boolean.FALSE);
                        } else {
                            StoreStream.Companion companion = StoreStream.INSTANCE;
                            StoreMessages messages = companion.getMessages();
                            C12238m.checkNotNullExpressionValue(l, "selectedChannelId");
                            observableM11076j = Observable.m11076j(messages.observeIsDetached(l.longValue()), companion.getChat().observeInteractionState().m11118y(new InterfaceC12589b<StoreChat.InteractionState, Boolean>() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$1
                                @Override // p637j0.p641k.InterfaceC12589b
                                public final Boolean call(StoreChat.InteractionState interactionState) {
                                    long channelId = interactionState.getChannelId();
                                    Long l2 = l;
                                    return Boolean.valueOf((l2 == null || channelId != l2.longValue() || interactionState.getLastMessageId() == 0) ? false : true);
                                }
                            }).m11110p(200L, TimeUnit.MILLISECONDS), new Func2<Boolean, StoreChat.InteractionState, Boolean>() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$2
                                @Override // p658rx.functions.Func2
                                public final Boolean call(Boolean bool, StoreChat.InteractionState interactionState) {
                                    C12238m.checkNotNullExpressionValue(bool, "isDetached");
                                    return Boolean.valueOf(bool.booleanValue() || !(interactionState.isAtBottomIgnoringTouch() || interactionState.isNearBottomIgnoringTouch()));
                                }
                            });
                        }
                        return Observable.m11079m(new C12721k(Boolean.FALSE), observableM11076j).m11112r().m11083G(new InterfaceC12589b<Boolean, WidgetChatOverlay.OldMessageModel>() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final WidgetChatOverlay.OldMessageModel call(Boolean bool) {
                                Long l2 = l;
                                C12238m.checkNotNullExpressionValue(l2, "selectedChannelId");
                                long jLongValue = l2.longValue();
                                C12238m.checkNotNullExpressionValue(bool, "isViewingOldMessages");
                                return new WidgetChatOverlay.OldMessageModel(jLongValue, bool.booleanValue());
                            }
                        });
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …          }\n            }");
                return observableM11099Y;
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
            int iM3a = C0002b.m3a(this.channelId) * 31;
            boolean z2 = this.isViewingOldMessages;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iM3a + r1;
        }

        public final boolean isViewingOldMessages() {
            return this.isViewingOldMessages;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("OldMessageModel(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", isViewingOldMessages=");
            return C1643a.m827O(sbM833U, this.isViewingOldMessages, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final /* data */ class StickerAutocompleteState {
        private final boolean autocompleteVisible;
        private final FlexInputState flexInputState;
        private final boolean isForumPostDraftCreation;

        public StickerAutocompleteState(boolean z2, FlexInputState flexInputState, boolean z3) {
            C12238m.checkNotNullParameter(flexInputState, "flexInputState");
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
            C12238m.checkNotNullParameter(flexInputState, "flexInputState");
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
            return this.autocompleteVisible == stickerAutocompleteState.autocompleteVisible && C12238m.areEqual(this.flexInputState, stickerAutocompleteState.flexInputState) && this.isForumPostDraftCreation == stickerAutocompleteState.isForumPostDraftCreation;
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
            StringBuilder sbM833U = C1643a.m833U("StickerAutocompleteState(autocompleteVisible=");
            sbM833U.append(this.autocompleteVisible);
            sbM833U.append(", flexInputState=");
            sbM833U.append(this.flexInputState);
            sbM833U.append(", isForumPostDraftCreation=");
            return C1643a.m827O(sbM833U, this.isForumPostDraftCreation, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final class TypingIndicatorViewHolder {
        private final WidgetChatOverlayBinding binding;

        public TypingIndicatorViewHolder(WidgetChatOverlayBinding widgetChatOverlayBinding) {
            C12238m.checkNotNullParameter(widgetChatOverlayBinding, "binding");
            this.binding = widgetChatOverlayBinding;
        }

        private final void configureTyping(ChatTypingModel.Typing model) {
            if (model.getTypingUsers().isEmpty() && model.getChannelRateLimit() <= 0) {
                this.binding.f16365d.m8620c();
                RelativeLayout relativeLayout = this.binding.f16364c;
                C12238m.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
                relativeLayout.setVisibility(8);
                return;
            }
            RelativeLayout relativeLayout2 = this.binding.f16364c;
            C12238m.checkNotNullExpressionValue(relativeLayout2, "binding.chatOverlayTyping");
            relativeLayout2.setVisibility(0);
            ConstraintLayout constraintLayout = this.binding.f16362a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Resources resources = constraintLayout.getResources();
            C12238m.checkNotNullExpressionValue(resources, "binding.root.resources");
            CharSequence typingString = getTypingString(resources, model.getTypingUsers());
            CharSequence slowmodeText = getSlowmodeText(model.getCooldownSecs(), model.getChannelRateLimit(), !C12103t.isBlank(typingString));
            TextView textView = this.binding.f16368g;
            C12238m.checkNotNullExpressionValue(textView, "binding.chatTypingUsersTyping");
            ViewExtensions.setTextAndVisibilityBy(textView, typingString);
            TypingDots typingDots = this.binding.f16365d;
            C12238m.checkNotNullExpressionValue(typingDots, "binding.chatOverlayTypingDots");
            typingDots.setVisibility(model.getTypingUsers().isEmpty() ^ true ? 0 : 8);
            TypingDots typingDots2 = this.binding.f16365d;
            if (!model.getTypingUsers().isEmpty()) {
                TypingDots.m8618b(typingDots2, false, 1);
            } else {
                typingDots2.m8620c();
            }
            TextView textView2 = this.binding.f16366e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.chatTypingUsersSlowmode");
            ViewExtensions.setTextAndVisibilityBy(textView2, slowmodeText);
            ImageView imageView = this.binding.f16367f;
            C12238m.checkNotNullExpressionValue(imageView, "binding.chatTypingUsersSlowmodeIcon");
            imageView.setVisibility(model.getChannelRateLimit() > 0 ? 0 : 8);
        }

        private final CharSequence getSlowmodeText(int cooldownSecs, int channelRateLimit, boolean hasTypingText) {
            if (cooldownSecs > 0) {
                return TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, 1000 * ((long) cooldownSecs), null, null, 6, null);
            }
            if (channelRateLimit <= 0 || hasTypingText) {
                return "";
            }
            ConstraintLayout constraintLayout = this.binding.f16362a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            String string = constraintLayout.getResources().getString(C5419R.string.channel_slowmode_desc_short);
            C12238m.checkNotNullExpressionValue(string, "binding.root.resources.g…nnel_slowmode_desc_short)");
            return string;
        }

        private final CharSequence getTypingString(Resources resources, List<? extends CharSequence> typingUsers) {
            int size = typingUsers.size();
            if (size == 0) {
                return "";
            }
            if (size == 1) {
                return C1107b.m211c(resources, C5419R.string.one_user_typing, new Object[]{typingUsers.get(0)}, (4 & 4) != 0 ? C1107b.d.f1493j : null);
            }
            if (size != 2) {
                return size != 3 ? C1107b.m211c(resources, C5419R.string.several_users_typing, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null) : C1107b.m211c(resources, C5419R.string.three_users_typing, new Object[]{typingUsers.get(0), typingUsers.get(1), typingUsers.get(2)}, (4 & 4) != 0 ? C1107b.d.f1493j : null);
            }
            return C1107b.m211c(resources, C5419R.string.two_users_typing, new Object[]{typingUsers.get(0), typingUsers.get(1)}, (4 & 4) != 0 ? C1107b.d.f1493j : null);
        }

        public final void configureUI(ChatTypingModel model) {
            C12238m.checkNotNullParameter(model, "model");
            if (model instanceof ChatTypingModel.Hide) {
                RelativeLayout relativeLayout = this.binding.f16364c;
                C12238m.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
                relativeLayout.setVisibility(8);
            } else if (model instanceof ChatTypingModel.Typing) {
                configureTyping((ChatTypingModel.Typing) model);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final class C81973 extends AbstractC12240o implements Function1<OldMessageModel, Unit> {
        public C81973() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OldMessageModel oldMessageModel) {
            invoke2(oldMessageModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OldMessageModel oldMessageModel) {
            if (oldMessageModel.isViewingOldMessages()) {
                WidgetChatOverlay.this.getBinding().f16363b.show();
            } else {
                WidgetChatOverlay.this.getBinding().f16363b.hide();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final class C81984 extends AbstractC12240o implements Function1<ChatTypingModel, Unit> {
        public C81984() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatTypingModel chatTypingModel) {
            invoke2(chatTypingModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatTypingModel chatTypingModel) {
            TypingIndicatorViewHolder typingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p = WidgetChatOverlay.access$getTypingIndicatorViewHolder$p(WidgetChatOverlay.this);
            C12238m.checkNotNullExpressionValue(chatTypingModel, "it");
            typingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p.configureUI(chatTypingModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$6 */
    /* JADX INFO: compiled from: WidgetChatOverlay.kt */
    public static final /* synthetic */ class C82006 extends C12236k implements Function1<StickerAutocompleteState, Unit> {
        public C82006(WidgetChatOverlay widgetChatOverlay) {
            super(1, widgetChatOverlay, WidgetChatOverlay.class, "configureStickerSuggestions", "configureStickerSuggestions(Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerAutocompleteState stickerAutocompleteState) {
            invoke2(stickerAutocompleteState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerAutocompleteState stickerAutocompleteState) {
            C12238m.checkNotNullParameter(stickerAutocompleteState, "p1");
            ((WidgetChatOverlay) this.receiver).configureStickerSuggestions(stickerAutocompleteState);
        }
    }

    public WidgetChatOverlay() {
        super(C5419R.layout.widget_chat_overlay);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChatOverlay$binding$2.INSTANCE, null, 2, null);
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(AppFlexInputViewModel.class), new C8190xf3aa4753(this), new C0863f0(new WidgetChatOverlay$flexInputViewModel$2(this)));
        this.chatInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ChatInputViewModel.class), new C8192xf3aa4755(this), new C0863f0(WidgetChatOverlay$chatInputViewModel$2.INSTANCE));
    }

    public static final /* synthetic */ TypingIndicatorViewHolder access$getTypingIndicatorViewHolder$p(WidgetChatOverlay widgetChatOverlay) {
        TypingIndicatorViewHolder typingIndicatorViewHolder = widgetChatOverlay.typingIndicatorViewHolder;
        if (typingIndicatorViewHolder == null) {
            C12238m.throwUninitializedPropertyAccessException("typingIndicatorViewHolder");
        }
        return typingIndicatorViewHolder;
    }

    private final void configureStickerSuggestions(StickerAutocompleteState stickerAutocompleteState) {
        boolean autocompleteVisible = stickerAutocompleteState.getAutocompleteVisible();
        FlexInputState flexInputState = stickerAutocompleteState.getFlexInputState();
        boolean isForumPostDraftCreation = stickerAutocompleteState.getIsForumPostDraftCreation();
        if (!flexInputState.expressionSuggestionsEnabled || autocompleteVisible || isForumPostDraftCreation) {
            C1084x4 c1084x4 = getBinding().f16369h;
            C12238m.checkNotNullExpressionValue(c1084x4, "binding.stickersSuggestions");
            LinearLayout linearLayout = c1084x4.f1380a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
            linearLayout.setVisibility(8);
            return;
        }
        final List listTake = C12163u.take(getFlexInputViewModel().getMatchingStickers(flexInputState.inputText), 4);
        boolean z2 = SearchUtils.INSTANCE.getQueriesFromSearchText(flexInputState.inputText).size() == 1;
        if (listTake == null || listTake.isEmpty()) {
            C1084x4 c1084x5 = getBinding().f16369h;
            C12238m.checkNotNullExpressionValue(c1084x5, "binding.stickersSuggestions");
            LinearLayout linearLayout2 = c1084x5.f1380a;
            C12238m.checkNotNullExpressionValue(linearLayout2, "binding.stickersSuggestions.root");
            linearLayout2.setVisibility(8);
            return;
        }
        StoreStream.INSTANCE.getExpressionSuggestions().trackExpressionSuggestionsDisplayed(flexInputState.inputText);
        C1084x4 c1084x6 = getBinding().f16369h;
        C12238m.checkNotNullExpressionValue(c1084x6, "binding.stickersSuggestions");
        LinearLayout linearLayout3 = c1084x6.f1380a;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.stickersSuggestions.root");
        linearLayout3.setVisibility(0);
        int i = 0;
        for (Object obj : C12147n.listOf((Object[]) new StickerView[]{getBinding().f16369h.f1381b, getBinding().f16369h.f1382c, getBinding().f16369h.f1383d, getBinding().f16369h.f1384e})) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            final StickerView stickerView = (StickerView) obj;
            final Sticker sticker = i < listTake.size() ? (Sticker) listTake.get(i) : null;
            C12238m.checkNotNullExpressionValue(stickerView, "stickerView");
            stickerView.setVisibility(sticker != null ? 0 : 8);
            if (sticker != null) {
                StickerView.m8613e(stickerView, sticker, null, 2);
                final Sticker sticker2 = sticker;
                final boolean z3 = z2;
                stickerView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay$configureStickerSuggestions$$inlined$forEachIndexed$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AnalyticsTracker.INSTANCE.expressionSuggestionsSelected(sticker.getId(), StoreStream.INSTANCE.getExpressionSuggestions().getLastSuggestionTrigger());
                        C12238m.checkNotNullExpressionValue(view, "it");
                        Context context = view.getContext();
                        C12238m.checkNotNullExpressionValue(context, "it.context");
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
        C12238m.checkNotNullExpressionValue(binding, "binding");
        this.typingIndicatorViewHolder = new TypingIndicatorViewHolder(binding);
        C1084x4 c1084x4 = getBinding().f16369h;
        C12238m.checkNotNullExpressionValue(c1084x4, "binding.stickersSuggestions");
        LinearLayout linearLayout = c1084x4.f1380a;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
        Drawable background = linearLayout.getBackground();
        C12238m.checkNotNullExpressionValue(background, "binding.stickersSuggestions.root.background");
        background.setAlpha(216);
        getBinding().f16369h.f1385f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getExpressionSuggestions().setExpressionSuggestionsEnabled(false);
            }
        });
        getBinding().f16363b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getMessagesLoader().requestNewestMessages();
            }
        });
        Observable<OldMessageModel> observableM11112r = OldMessageModel.INSTANCE.get().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "OldMessageModel.get()\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), (Class<?>) WidgetChatOverlay.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C81973());
        Observable observableM11112r2 = ObservableExtensionsKt.computationLatest(ChatTypingModel.INSTANCE.get()).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r2, "ChatTypingModel\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r2, this, null, 2, null), (Class<?>) WidgetChatOverlay.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C81984());
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11075i = Observable.m11075i(companion.getAutocomplete().observeAutocompleteVisibility().m11112r(), getFlexInputViewModel().observeState().m11112r(), companion.getChannelsSelected().observeResolvedSelectedChannel(), new Func3<Boolean, FlexInputState, StoreChannelsSelected.ResolvedSelectedChannel, StickerAutocompleteState>() { // from class: com.discord.widgets.chat.overlay.WidgetChatOverlay.onViewBoundOrOnResume.5
            @Override // p658rx.functions.Func3
            public final StickerAutocompleteState call(Boolean bool, FlexInputState flexInputState, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                Channel parentChannel;
                if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
                    resolvedSelectedChannel = null;
                }
                StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel;
                C12238m.checkNotNullExpressionValue(bool, "autocompleteVisible");
                boolean zBooleanValue = bool.booleanValue();
                C12238m.checkNotNullExpressionValue(flexInputState, "flexInputState");
                return new StickerAutocompleteState(zBooleanValue, flexInputState, (threadDraft == null || (parentChannel = threadDraft.getParentChannel()) == null || !ChannelUtils.m7693q(parentChannel)) ? false : true);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…() == true,\n      )\n    }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11075i, this, null, 2, null), (Class<?>) WidgetChatOverlay.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82006(this));
    }
}
