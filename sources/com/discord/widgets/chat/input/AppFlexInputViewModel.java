package com.discord.widgets.chat.input;

import android.view.View;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppPermissionsRequests;
import com.discord.panels.PanelState;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExpressionSuggestions;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import com.lytefast.flexinput.FlexInputAttachmentListener;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p076b.p077a.p083h.AbstractC1451a;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func6;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFlexInputViewModel extends AbstractC0859d0<FlexInputState> implements FlexInputViewModel {
    private static final String CHAT_GIFTING_NOTICE = "CHAT_GIFTING_NOTICE";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean attachmentView;
    private PublishSubject<AbstractC1451a> eventSubject;
    private final AppPermissionsRequests permissionRequests;
    private FlexInputAttachmentListener singleAttachmentSelectedListener;
    private boolean singleSelectMode;
    private final StoreAnalytics storeAnalytics;
    private final StoreExpressionSuggestions storeExpressionSuggestions;
    private final StoreStickers storeStickers;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$1 */
    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final /* synthetic */ class C76771 extends C12236k implements Function1<StoreState, Unit> {
        public C76771(AppFlexInputViewModel appFlexInputViewModel) {
            super(1, appFlexInputViewModel, AppFlexInputViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
            ((AppFlexInputViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores() {
            Observable observableM11099Y = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().m11099Y(new InterfaceC12589b<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.chat.input.AppFlexInputViewModel$Companion$observeStores$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends AppFlexInputViewModel.StoreState> call(final StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                    final Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
                    StoreStream.Companion companion = StoreStream.INSTANCE;
                    return Observable.m11071f(companion.getNavigation().observeLeftPanelState(), companion.getNavigation().observeRightPanelState(), companion.getPermissions().observePermissionsForChannel(channelOrParent != null ? channelOrParent.getId() : 0L), companion.getNotices().getNotices(), companion.getUserSettings().observeIsStickerSuggestionsEnabled(), companion.getExpressionSuggestions().observeSuggestionsEnabled(), new Func6<PanelState, PanelState, Long, StoreNotices.Notice, Boolean, Boolean, AppFlexInputViewModel.StoreState>() { // from class: com.discord.widgets.chat.input.AppFlexInputViewModel$Companion$observeStores$1.1
                        /* JADX WARN: Code duplicated, block: B:7:0x0028  */
                        @Override // p658rx.functions.Func6
                        public final AppFlexInputViewModel.StoreState call(PanelState panelState, PanelState panelState2, Long l, StoreNotices.Notice notice, Boolean bool, Boolean bool2) {
                            boolean z2;
                            C12238m.checkNotNullExpressionValue(panelState, "leftPanelState");
                            C12238m.checkNotNullExpressionValue(panelState2, "rightPanelState");
                            Channel channel = channelOrParent;
                            C12238m.checkNotNullExpressionValue(bool, "stickerSuggestionsEnabled");
                            if (bool.booleanValue()) {
                                C12238m.checkNotNullExpressionValue(bool2, "expressionSuggestionsEnabled");
                                if (bool2.booleanValue()) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                            }
                            return new AppFlexInputViewModel.StoreState(panelState, panelState2, channel, l, notice, z2, resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n          .g…            }\n          }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final /* data */ class StoreState {
        private final Long channelPermission;
        private final boolean isThreadCreation;
        private final PanelState leftPanelState;
        private final StoreNotices.Notice notice;
        private final PanelState rightPanelState;
        private final Channel selectedChannel;
        private final boolean stickerSuggestionsEnabled;

        public StoreState(PanelState panelState, PanelState panelState2, Channel channel, Long l, StoreNotices.Notice notice, boolean z2, boolean z3) {
            C12238m.checkNotNullParameter(panelState, "leftPanelState");
            C12238m.checkNotNullParameter(panelState2, "rightPanelState");
            this.leftPanelState = panelState;
            this.rightPanelState = panelState2;
            this.selectedChannel = channel;
            this.channelPermission = l;
            this.notice = notice;
            this.stickerSuggestionsEnabled = z2;
            this.isThreadCreation = z3;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, PanelState panelState, PanelState panelState2, Channel channel, Long l, StoreNotices.Notice notice, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                panelState = storeState.leftPanelState;
            }
            if ((i & 2) != 0) {
                panelState2 = storeState.rightPanelState;
            }
            PanelState panelState3 = panelState2;
            if ((i & 4) != 0) {
                channel = storeState.selectedChannel;
            }
            Channel channel2 = channel;
            if ((i & 8) != 0) {
                l = storeState.channelPermission;
            }
            Long l2 = l;
            if ((i & 16) != 0) {
                notice = storeState.notice;
            }
            StoreNotices.Notice notice2 = notice;
            if ((i & 32) != 0) {
                z2 = storeState.stickerSuggestionsEnabled;
            }
            boolean z4 = z2;
            if ((i & 64) != 0) {
                z3 = storeState.isThreadCreation;
            }
            return storeState.copy(panelState, panelState3, channel2, l2, notice2, z4, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Channel getSelectedChannel() {
            return this.selectedChannel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getChannelPermission() {
            return this.channelPermission;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final StoreNotices.Notice getNotice() {
            return this.notice;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getStickerSuggestionsEnabled() {
            return this.stickerSuggestionsEnabled;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsThreadCreation() {
            return this.isThreadCreation;
        }

        public final StoreState copy(PanelState leftPanelState, PanelState rightPanelState, Channel selectedChannel, Long channelPermission, StoreNotices.Notice notice, boolean stickerSuggestionsEnabled, boolean isThreadCreation) {
            C12238m.checkNotNullParameter(leftPanelState, "leftPanelState");
            C12238m.checkNotNullParameter(rightPanelState, "rightPanelState");
            return new StoreState(leftPanelState, rightPanelState, selectedChannel, channelPermission, notice, stickerSuggestionsEnabled, isThreadCreation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.leftPanelState, storeState.leftPanelState) && C12238m.areEqual(this.rightPanelState, storeState.rightPanelState) && C12238m.areEqual(this.selectedChannel, storeState.selectedChannel) && C12238m.areEqual(this.channelPermission, storeState.channelPermission) && C12238m.areEqual(this.notice, storeState.notice) && this.stickerSuggestionsEnabled == storeState.stickerSuggestionsEnabled && this.isThreadCreation == storeState.isThreadCreation;
        }

        public final Long getChannelPermission() {
            return this.channelPermission;
        }

        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        public final StoreNotices.Notice getNotice() {
            return this.notice;
        }

        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        public final Channel getSelectedChannel() {
            return this.selectedChannel;
        }

        public final boolean getStickerSuggestionsEnabled() {
            return this.stickerSuggestionsEnabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        public int hashCode() {
            PanelState panelState = this.leftPanelState;
            int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
            PanelState panelState2 = this.rightPanelState;
            int iHashCode2 = (iHashCode + (panelState2 != null ? panelState2.hashCode() : 0)) * 31;
            Channel channel = this.selectedChannel;
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Long l = this.channelPermission;
            int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
            StoreNotices.Notice notice = this.notice;
            int iHashCode5 = (iHashCode4 + (notice != null ? notice.hashCode() : 0)) * 31;
            boolean z2 = this.stickerSuggestionsEnabled;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode5 + r1) * 31;
            boolean z3 = this.isThreadCreation;
            return i + (z3 ? 1 : z3);
        }

        public final boolean isThreadCreation() {
            return this.isThreadCreation;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(leftPanelState=");
            sbM833U.append(this.leftPanelState);
            sbM833U.append(", rightPanelState=");
            sbM833U.append(this.rightPanelState);
            sbM833U.append(", selectedChannel=");
            sbM833U.append(this.selectedChannel);
            sbM833U.append(", channelPermission=");
            sbM833U.append(this.channelPermission);
            sbM833U.append(", notice=");
            sbM833U.append(this.notice);
            sbM833U.append(", stickerSuggestionsEnabled=");
            sbM833U.append(this.stickerSuggestionsEnabled);
            sbM833U.append(", isThreadCreation=");
            return C1643a.m827O(sbM833U, this.isThreadCreation, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$getMatchingStickers$1 */
    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final class C76791 extends AbstractC12240o implements Function1<String, Set<? extends Sticker>> {
        public static final C76791 INSTANCE = new C76791();

        public C76791() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Set<Sticker> invoke(String str) {
            C12238m.checkNotNullParameter(str, "inputText");
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            return StickerUtils.findStickerMatches$default(stickerUtils, str, StickerUtils.getStickersForAutocomplete$default(stickerUtils, null, null, null, null, null, 31, null), false, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$onGiftButtonClicked$1 */
    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final class C76801 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
        public static final C76801 INSTANCE = new C76801();

        public C76801() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            C12238m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Channel channelFindChannelById = companion.getChannels().findChannelById(companion.getChannelsSelected().getId());
            WidgetSettingsGifting.INSTANCE.launch(fragmentActivity, new Traits.Location((channelFindChannelById == null || channelFindChannelById.getGuildId() != 0) ? Traits.Location.Page.GUILD_CHANNEL : "DM Channel", Traits.Location.Section.CHANNEL_TEXT_AREA, "Button Icon", "gift", null, 16, null));
            StoreNotices.markSeen$default(companion.getNotices(), AppFlexInputViewModel.CHAT_GIFTING_NOTICE, 0L, 2, null);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$onSendButtonClicked$1 */
    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final class C76811 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public C76811() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            if (z2) {
                AppFlexInputViewModel.clean$default(AppFlexInputViewModel.this, false, 1, null);
            }
        }
    }

    public /* synthetic */ AppFlexInputViewModel(AppPermissionsRequests appPermissionsRequests, FlexInputState flexInputState, Observable observable, StoreStickers storeStickers, StoreAnalytics storeAnalytics, StoreExpressionSuggestions storeExpressionSuggestions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appPermissionsRequests, (i & 2) != 0 ? new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191) : flexInputState, (i & 4) != 0 ? INSTANCE.observeStores() : observable, (i & 8) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers, (i & 16) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (i & 32) != 0 ? StoreStream.INSTANCE.getExpressionSuggestions() : storeExpressionSuggestions);
    }

    public static /* synthetic */ void clean$default(AppFlexInputViewModel appFlexInputViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        appFlexInputViewModel.clean(z2);
    }

    private final void handleStoreState(StoreState storeState) {
        boolean zCan;
        boolean z2;
        boolean z3;
        FlexInputState flexInputStateRequireViewState = requireViewState();
        Channel selectedChannel = storeState.getSelectedChannel();
        Long channelPermission = storeState.getChannelPermission();
        PanelState leftPanelState = storeState.getLeftPanelState();
        PanelState.C5578a c5578a = PanelState.C5578a.f18640a;
        boolean z4 = (C12238m.areEqual(leftPanelState, c5578a) ^ true) || (C12238m.areEqual(storeState.getRightPanelState(), c5578a) ^ true);
        boolean z5 = (storeState.getNotice() == null || storeState.getNotice().isInAppNotification() || storeState.getNotice().isPopup()) ? false : true;
        if (selectedChannel == null) {
            zCan = false;
        } else {
            zCan = storeState.isThreadCreation() ? PermissionUtils.can(Permission.SEND_MESSAGES_IN_THREADS, channelPermission) : PermissionUtils.INSTANCE.hasAccessWrite(selectedChannel, channelPermission);
        }
        Integer numValueOf = selectedChannel != null ? Integer.valueOf(selectedChannel.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 15) {
            z2 = zCan && storeState.isThreadCreation();
        } else {
            z2 = zCan;
        }
        boolean z6 = selectedChannel != null && (ChannelUtils.m7667B(selectedChannel) || PermissionUtils.can(Permission.ATTACH_FILES, channelPermission));
        boolean z7 = flexInputStateRequireViewState.showExpressionTray;
        if (z5 || z4) {
            hideKeyboard();
            z3 = false;
        } else {
            z3 = z7;
        }
        updateViewState(FlexInputState.m9302a(flexInputStateRequireViewState, null, false, null, false, false, null, z2, z6, z3, false, storeState.getStickerSuggestionsEnabled(), selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null, selectedChannel != null ? Long.valueOf(selectedChannel.getGuildId()) : null, 575));
    }

    private final void showKeyboard() {
        PublishSubject<AbstractC1451a> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(AbstractC1451a.c.f2204a);
    }

    @MainThread
    public final void clean(boolean clearText) {
        FlexInputState viewState = getViewState();
        if (viewState != null) {
            updateViewState(FlexInputState.m9302a(viewState, clearText ? "" : viewState.inputText, true, C12147n.emptyList(), false, false, null, false, false, false, false, false, null, null, 8152));
        }
    }

    public final void focus() {
        PublishSubject<AbstractC1451a> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(AbstractC1451a.a.f2202a);
    }

    public final boolean getAttachmentView() {
        return this.attachmentView;
    }

    public final List<Sticker> getMatchingStickers(String inputText) {
        C12238m.checkNotNullParameter(inputText, "inputText");
        C76791 c76791 = C76791.INSTANCE;
        int length = inputText.length();
        return C12163u.toList(3 <= length && 50 >= length ? c76791.invoke(inputText) : C12148n0.emptySet());
    }

    public final FlexInputAttachmentListener getSingleAttachmentSelectedListener() {
        return this.singleAttachmentSelectedListener;
    }

    public final boolean getSingleSelectMode() {
        return this.singleSelectMode;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public boolean hasMediaPermissions() {
        return this.permissionRequests.hasMedia();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public boolean hideExpressionTray() {
        FlexInputState viewState = getViewState();
        if (viewState == null || !viewState.showExpressionTray) {
            return false;
        }
        updateViewState(FlexInputState.m9302a(viewState, null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        return true;
    }

    public final void hideKeyboard() {
        PublishSubject<AbstractC1451a> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(AbstractC1451a.b.f2203a);
    }

    public boolean isAttachmentViewEnabled() {
        return this.attachmentView;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public boolean isSingleSelectMode() {
        return this.singleSelectMode;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public Observable<AbstractC1451a> observeEvents() {
        PublishSubject<AbstractC1451a> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public Observable<FlexInputState> observeState() {
        return observeViewState();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onAttachmentsUpdated(List<? extends Attachment<? extends Object>> attachments) {
        C12238m.checkNotNullParameter(attachments, "attachments");
        updateViewState(FlexInputState.m9302a(requireViewState(), null, false, new ArrayList(attachments), false, false, null, false, false, false, false, false, null, null, 8187));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onContentDialogDismissed(boolean showKeyboard) {
        if (showKeyboard) {
            showKeyboard();
        }
        updateViewState(FlexInputState.m9302a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 8159));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onContentDialogPageChanged(int index) {
        updateViewState(FlexInputState.m9302a(requireViewState(), null, false, null, false, false, Integer.valueOf(index), false, false, false, false, false, null, null, 8159));
        if (index == 0) {
            this.storeAnalytics.trackChatInputComponentViewed(ChatInputComponentTypes.MEDIA_PICKER);
        } else if (index == 1) {
            this.storeAnalytics.trackChatInputComponentViewed(ChatInputComponentTypes.FILES);
        } else {
            if (index != 2) {
                return;
            }
            this.storeAnalytics.trackChatInputComponentViewed(ChatInputComponentTypes.CAMERA);
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void onCreateThreadSelected() {
        Long l = requireViewState().channelId;
        Long l2 = requireViewState().guildId;
        if (l != null) {
            l.longValue();
            if (l2 != null) {
                l2.longValue();
                ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), l2.longValue(), l.longValue(), null, "Plus Button", 4, null);
                onContentDialogDismissed(false);
            }
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onExpandButtonClicked() {
        updateViewState(FlexInputState.m9302a(requireViewState(), null, true, null, false, false, null, false, false, false, false, false, null, null, 8189));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onExpressionTrayButtonClicked() {
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (flexInputStateRequireViewState.showExpressionTray) {
            showKeyboard();
        } else {
            hideKeyboard();
        }
        updateViewState(FlexInputState.m9302a(flexInputStateRequireViewState, null, false, null, false, false, null, false, false, !flexInputStateRequireViewState.showExpressionTray, false, false, null, null, 7935));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onFlexInputFragmentPause() {
        hideKeyboard();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onGalleryButtonClicked() {
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (flexInputStateRequireViewState.ableToAttachFiles) {
            hideKeyboard();
            updateViewState(FlexInputState.m9302a(flexInputStateRequireViewState, null, false, null, false, false, 0, false, false, false, false, false, null, null, 7903));
        } else {
            PublishSubject<AbstractC1451a> publishSubject = this.eventSubject;
            publishSubject.f27650k.onNext(new AbstractC1451a.e(C5419R.string.cannot_attach_files));
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onGiftButtonClicked() {
        hideKeyboard();
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(CHAT_GIFTING_NOTICE, null, 0L, 0, false, C12145m.listOf(C12216a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, C76801.INSTANCE, 150, null));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onInputTextAppended(String appendText) {
        C12238m.checkNotNullParameter(appendText, "appendText");
        C3404f.m4235P0(this, C1643a.m822J(new StringBuilder(), requireViewState().inputText, appendText), null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onInputTextChanged(String inputText, Boolean focused) {
        boolean z2;
        C12238m.checkNotNullParameter(inputText, "inputText");
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (C12238m.areEqual(inputText, flexInputStateRequireViewState.inputText) || !flexInputStateRequireViewState.ableToSendMessages) {
            return;
        }
        if (C12238m.areEqual(focused, Boolean.TRUE)) {
            showKeyboard();
        } else if (C12238m.areEqual(focused, Boolean.FALSE)) {
            hideKeyboard();
        }
        if (flexInputStateRequireViewState.showExpandedButtons) {
            if (inputText.length() > 0) {
                z2 = false;
            } else {
                z2 = flexInputStateRequireViewState.showExpandedButtons;
            }
        } else {
            z2 = flexInputStateRequireViewState.showExpandedButtons;
        }
        if (inputText.length() > 0) {
            this.storeStickers.fetchEnabledStickerDirectory();
        }
        if (inputText.length() == 0) {
            this.storeExpressionSuggestions.setExpressionSuggestionsEnabled(true);
        }
        updateViewState(FlexInputState.m9302a(flexInputStateRequireViewState, inputText, z2, null, false, false, null, false, false, false, false, false, null, null, 8188));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public boolean onInputTextClicked() {
        showKeyboard();
        updateViewState(FlexInputState.m9302a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        return false;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onSendButtonClicked(FlexInputListener inputListener) {
        FlexInputState viewState = getViewState();
        if (viewState == null || inputListener == null) {
            return;
        }
        inputListener.onSend(viewState.inputText, viewState.attachments, new C76811());
    }

    @MainThread
    public void onShowDialog() {
        hideKeyboard();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void onSingleAttachmentSelected(Attachment<? extends Object> attachment) {
        C12238m.checkNotNullParameter(attachment, "attachment");
        FlexInputAttachmentListener flexInputAttachmentListener = this.singleAttachmentSelectedListener;
        if (flexInputAttachmentListener != null) {
            flexInputAttachmentListener.onAttachmentSelected(attachment);
        }
    }

    @MainThread
    public final void onStickerSuggestionSent(boolean shouldClearInput) {
        FlexInputState viewState = getViewState();
        if (viewState != null) {
            updateViewState(FlexInputState.m9302a(viewState, shouldClearInput ? "" : viewState.inputText, true, C12147n.emptyList(), false, false, null, false, false, false, false, false, null, null, 8152));
            if (shouldClearInput) {
                hideKeyboard();
            } else {
                this.storeExpressionSuggestions.setExpressionSuggestionsEnabled(false);
            }
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public boolean onToolTipButtonLongPressed(View button) {
        C12238m.checkNotNullParameter(button, "button");
        PublishSubject<AbstractC1451a> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new AbstractC1451a.d(button.getContentDescription().toString()));
        return true;
    }

    public void removeAttachment(Attachment<?> attachment) {
        List<? extends Attachment<? extends Object>> mutableList;
        List<Attachment<Object>> list;
        C12238m.checkNotNullParameter(attachment, "attachment");
        FlexInputState viewState = getViewState();
        if (viewState == null || (list = viewState.attachments) == null || (mutableList = C12163u.toMutableList((Collection) list)) == null) {
            mutableList = null;
        } else {
            C12224e0.asMutableCollection(mutableList).remove(attachment);
        }
        if (mutableList != null) {
            onAttachmentsUpdated(mutableList);
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void requestMediaPermissions(Function0<Unit> onSuccess) {
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        this.permissionRequests.requestMedia(onSuccess);
    }

    public void setAttachmentSelectedListener(FlexInputAttachmentListener attachmentListener) {
        C12238m.checkNotNullParameter(attachmentListener, "attachmentListener");
        this.singleAttachmentSelectedListener = attachmentListener;
    }

    public final void setAttachmentView(boolean z2) {
        this.attachmentView = z2;
    }

    public void setAttachmentViewEnabled(boolean enabled) {
        this.attachmentView = enabled;
        FlexInputState viewState = getViewState();
        if (viewState == null || viewState.attachmentViewEnabled != enabled) {
            FlexInputState viewState2 = getViewState();
            if (viewState2 == null) {
                viewState2 = new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191);
            }
            updateViewState(FlexInputState.m9302a(viewState2, null, false, null, enabled, false, null, false, false, false, false, false, null, null, 8183));
        }
    }

    public void setModeSingleSelect(boolean singleSelect) {
        this.singleSelectMode = singleSelect;
        FlexInputState viewState = getViewState();
        if (viewState == null || viewState.singleSelectMode != singleSelect) {
            FlexInputState viewState2 = getViewState();
            if (viewState2 == null) {
                viewState2 = new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191);
            }
            updateViewState(FlexInputState.m9302a(viewState2, null, false, null, false, singleSelect, null, false, false, false, false, false, null, null, 8175));
        }
    }

    public void setShowExpressionTrayButtonBadge(boolean showBadge) {
        updateViewState(FlexInputState.m9302a(requireViewState(), null, false, null, false, false, null, false, false, false, showBadge, false, null, null, 7679));
    }

    public final void setSingleAttachmentSelectedListener(FlexInputAttachmentListener flexInputAttachmentListener) {
        this.singleAttachmentSelectedListener = flexInputAttachmentListener;
    }

    public final void setSingleSelectMode(boolean z2) {
        this.singleSelectMode = z2;
    }

    @MainThread
    public boolean showExpressionTray() {
        FlexInputState viewState = getViewState();
        if (viewState == null || viewState.showExpressionTray) {
            return false;
        }
        updateViewState(FlexInputState.m9302a(viewState, null, false, null, false, false, null, false, false, true, false, false, null, null, 7935));
        return true;
    }

    public final void showKeyboardAndHideExpressionTray() {
        updateViewState(FlexInputState.m9302a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        showKeyboard();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFlexInputViewModel(AppPermissionsRequests appPermissionsRequests, FlexInputState flexInputState, Observable<StoreState> observable, StoreStickers storeStickers, StoreAnalytics storeAnalytics, StoreExpressionSuggestions storeExpressionSuggestions) {
        super(flexInputState);
        C12238m.checkNotNullParameter(appPermissionsRequests, "permissionRequests");
        C12238m.checkNotNullParameter(flexInputState, "initialViewState");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        C12238m.checkNotNullParameter(storeStickers, "storeStickers");
        C12238m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        C12238m.checkNotNullParameter(storeExpressionSuggestions, "storeExpressionSuggestions");
        this.permissionRequests = appPermissionsRequests;
        this.storeStickers = storeStickers;
        this.storeAnalytics = storeAnalytics;
        this.storeExpressionSuggestions = storeExpressionSuggestions;
        this.eventSubject = PublishSubject.m11133k0();
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(observable).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "storeObservable\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), (Class<?>) AppFlexInputViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76771(this));
        this.attachmentView = true;
    }
}
