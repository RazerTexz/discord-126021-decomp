package com.discord.widgets.chat.input;

import android.view.View;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppViewModel;
import b.b.a.h.FlexInputEvent;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppPermissions2;
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
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.FlexInputListener2;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import d0.z.d.TypeIntrinsics;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func6;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFlexInputViewModel extends AppViewModel<FlexInputState> implements FlexInputViewModel {
    private static final String CHAT_GIFTING_NOTICE = "CHAT_GIFTING_NOTICE";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean attachmentView;
    private PublishSubject<FlexInputEvent> eventSubject;
    private final AppPermissions2 permissionRequests;
    private FlexInputListener2 singleAttachmentSelectedListener;
    private boolean singleSelectMode;
    private final StoreAnalytics storeAnalytics;
    private final StoreExpressionSuggestions storeExpressionSuggestions;
    private final StoreStickers storeStickers;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(AppFlexInputViewModel appFlexInputViewModel) {
            super(1, appFlexInputViewModel, AppFlexInputViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((AppFlexInputViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores() {
            Observable observableY = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().Y(new Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.chat.input.AppFlexInputViewModel$Companion$observeStores$1
                @Override // j0.k.Func1
                public final Observable<? extends AppFlexInputViewModel.StoreState> call(final StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                    final Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
                    StoreStream.Companion companion = StoreStream.INSTANCE;
                    return Observable.f(companion.getNavigation().observeLeftPanelState(), companion.getNavigation().observeRightPanelState(), companion.getPermissions().observePermissionsForChannel(channelOrParent != null ? channelOrParent.getId() : 0L), companion.getNotices().getNotices(), companion.getUserSettings().observeIsStickerSuggestionsEnabled(), companion.getExpressionSuggestions().observeSuggestionsEnabled(), new Func6<PanelState, PanelState, Long, StoreNotices.Notice, Boolean, Boolean, AppFlexInputViewModel.StoreState>() { // from class: com.discord.widgets.chat.input.AppFlexInputViewModel$Companion$observeStores$1.1
                        /* JADX WARN: Code duplicated, block: B:7:0x0028  */
                        @Override // rx.functions.Func6
                        public final AppFlexInputViewModel.StoreState call(PanelState panelState, PanelState panelState2, Long l, StoreNotices.Notice notice, Boolean bool, Boolean bool2) {
                            boolean z2;
                            Intrinsics3.checkNotNullExpressionValue(panelState, "leftPanelState");
                            Intrinsics3.checkNotNullExpressionValue(panelState2, "rightPanelState");
                            Channel channel = channelOrParent;
                            Intrinsics3.checkNotNullExpressionValue(bool, "stickerSuggestionsEnabled");
                            if (bool.booleanValue()) {
                                Intrinsics3.checkNotNullExpressionValue(bool2, "expressionSuggestionsEnabled");
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
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
            return observableY;
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
            Intrinsics3.checkNotNullParameter(panelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(panelState2, "rightPanelState");
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
            Intrinsics3.checkNotNullParameter(leftPanelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(rightPanelState, "rightPanelState");
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
            return Intrinsics3.areEqual(this.leftPanelState, storeState.leftPanelState) && Intrinsics3.areEqual(this.rightPanelState, storeState.rightPanelState) && Intrinsics3.areEqual(this.selectedChannel, storeState.selectedChannel) && Intrinsics3.areEqual(this.channelPermission, storeState.channelPermission) && Intrinsics3.areEqual(this.notice, storeState.notice) && this.stickerSuggestionsEnabled == storeState.stickerSuggestionsEnabled && this.isThreadCreation == storeState.isThreadCreation;
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
            StringBuilder sbU = outline.U("StoreState(leftPanelState=");
            sbU.append(this.leftPanelState);
            sbU.append(", rightPanelState=");
            sbU.append(this.rightPanelState);
            sbU.append(", selectedChannel=");
            sbU.append(this.selectedChannel);
            sbU.append(", channelPermission=");
            sbU.append(this.channelPermission);
            sbU.append(", notice=");
            sbU.append(this.notice);
            sbU.append(", stickerSuggestionsEnabled=");
            sbU.append(this.stickerSuggestionsEnabled);
            sbU.append(", isThreadCreation=");
            return outline.O(sbU, this.isThreadCreation, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$getMatchingStickers$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Set<? extends Sticker>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Set<Sticker> invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "inputText");
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            return StickerUtils.findStickerMatches$default(stickerUtils, str, StickerUtils.getStickersForAutocomplete$default(stickerUtils, null, null, null, null, null, 31, null), false, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$onGiftButtonClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Channel channelFindChannelById = companion.getChannels().findChannelById(companion.getChannelsSelected().getId());
            WidgetSettingsGifting.INSTANCE.launch(fragmentActivity, new Traits.Location((channelFindChannelById == null || channelFindChannelById.getGuildId() != 0) ? Traits.Location.Page.GUILD_CHANNEL : "DM Channel", Traits.Location.Section.CHANNEL_TEXT_AREA, "Button Icon", "gift", null, 16, null));
            StoreNotices.markSeen$default(companion.getNotices(), AppFlexInputViewModel.CHAT_GIFTING_NOTICE, 0L, 2, null);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$onSendButtonClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            if (z2) {
                AppFlexInputViewModel.clean$default(AppFlexInputViewModel.this, false, 1, null);
            }
        }
    }

    public /* synthetic */ AppFlexInputViewModel(AppPermissions2 appPermissions2, FlexInputState flexInputState, Observable observable, StoreStickers storeStickers, StoreAnalytics storeAnalytics, StoreExpressionSuggestions storeExpressionSuggestions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appPermissions2, (i & 2) != 0 ? new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191) : flexInputState, (i & 4) != 0 ? INSTANCE.observeStores() : observable, (i & 8) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers, (i & 16) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (i & 32) != 0 ? StoreStream.INSTANCE.getExpressionSuggestions() : storeExpressionSuggestions);
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
        PanelState.a aVar = PanelState.a.a;
        boolean z4 = (Intrinsics3.areEqual(leftPanelState, aVar) ^ true) || (Intrinsics3.areEqual(storeState.getRightPanelState(), aVar) ^ true);
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
        boolean z6 = selectedChannel != null && (ChannelUtils.B(selectedChannel) || PermissionUtils.can(Permission.ATTACH_FILES, channelPermission));
        boolean z7 = flexInputStateRequireViewState.showExpressionTray;
        if (z5 || z4) {
            hideKeyboard();
            z3 = false;
        } else {
            z3 = z7;
        }
        updateViewState(FlexInputState.a(flexInputStateRequireViewState, null, false, null, false, false, null, z2, z6, z3, false, storeState.getStickerSuggestionsEnabled(), selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null, selectedChannel != null ? Long.valueOf(selectedChannel.getGuildId()) : null, 575));
    }

    private final void showKeyboard() {
        PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
        publishSubject.k.onNext(FlexInputEvent.c.a);
    }

    @MainThread
    public final void clean(boolean clearText) {
        FlexInputState viewState = getViewState();
        if (viewState != null) {
            updateViewState(FlexInputState.a(viewState, clearText ? "" : viewState.inputText, true, Collections2.emptyList(), false, false, null, false, false, false, false, false, null, null, 8152));
        }
    }

    public final void focus() {
        PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
        publishSubject.k.onNext(FlexInputEvent.a.a);
    }

    public final boolean getAttachmentView() {
        return this.attachmentView;
    }

    public final List<Sticker> getMatchingStickers(String inputText) {
        Intrinsics3.checkNotNullParameter(inputText, "inputText");
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        int length = inputText.length();
        return _Collections.toList(3 <= length && 50 >= length ? anonymousClass1.invoke(inputText) : Sets5.emptySet());
    }

    public final FlexInputListener2 getSingleAttachmentSelectedListener() {
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
        updateViewState(FlexInputState.a(viewState, null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        return true;
    }

    public final void hideKeyboard() {
        PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
        publishSubject.k.onNext(FlexInputEvent.b.a);
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
    public Observable<FlexInputEvent> observeEvents() {
        PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
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
        Intrinsics3.checkNotNullParameter(attachments, "attachments");
        updateViewState(FlexInputState.a(requireViewState(), null, false, new ArrayList(attachments), false, false, null, false, false, false, false, false, null, null, 8187));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onContentDialogDismissed(boolean showKeyboard) {
        if (showKeyboard) {
            showKeyboard();
        }
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 8159));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onContentDialogPageChanged(int index) {
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, Integer.valueOf(index), false, false, false, false, false, null, null, 8159));
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
        updateViewState(FlexInputState.a(requireViewState(), null, true, null, false, false, null, false, false, false, false, false, null, null, 8189));
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
        updateViewState(FlexInputState.a(flexInputStateRequireViewState, null, false, null, false, false, null, false, false, !flexInputStateRequireViewState.showExpressionTray, false, false, null, null, 7935));
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
            updateViewState(FlexInputState.a(flexInputStateRequireViewState, null, false, null, false, false, 0, false, false, false, false, false, null, null, 7903));
        } else {
            PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new FlexInputEvent.e(R.string.cannot_attach_files));
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onGiftButtonClicked() {
        hideKeyboard();
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(CHAT_GIFTING_NOTICE, null, 0L, 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, AnonymousClass1.INSTANCE, 150, null));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onInputTextAppended(String appendText) {
        Intrinsics3.checkNotNullParameter(appendText, "appendText");
        f.P0(this, outline.J(new StringBuilder(), requireViewState().inputText, appendText), null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onInputTextChanged(String inputText, Boolean focused) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(inputText, "inputText");
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (Intrinsics3.areEqual(inputText, flexInputStateRequireViewState.inputText) || !flexInputStateRequireViewState.ableToSendMessages) {
            return;
        }
        if (Intrinsics3.areEqual(focused, Boolean.TRUE)) {
            showKeyboard();
        } else if (Intrinsics3.areEqual(focused, Boolean.FALSE)) {
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
        updateViewState(FlexInputState.a(flexInputStateRequireViewState, inputText, z2, null, false, false, null, false, false, false, false, false, null, null, 8188));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public boolean onInputTextClicked() {
        showKeyboard();
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        return false;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onSendButtonClicked(FlexInputListener inputListener) {
        FlexInputState viewState = getViewState();
        if (viewState == null || inputListener == null) {
            return;
        }
        inputListener.onSend(viewState.inputText, viewState.attachments, new AnonymousClass1());
    }

    @MainThread
    public void onShowDialog() {
        hideKeyboard();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void onSingleAttachmentSelected(Attachment<? extends Object> attachment) {
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        FlexInputListener2 flexInputListener2 = this.singleAttachmentSelectedListener;
        if (flexInputListener2 != null) {
            flexInputListener2.onAttachmentSelected(attachment);
        }
    }

    @MainThread
    public final void onStickerSuggestionSent(boolean shouldClearInput) {
        FlexInputState viewState = getViewState();
        if (viewState != null) {
            updateViewState(FlexInputState.a(viewState, shouldClearInput ? "" : viewState.inputText, true, Collections2.emptyList(), false, false, null, false, false, false, false, false, null, null, 8152));
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
        Intrinsics3.checkNotNullParameter(button, "button");
        PublishSubject<FlexInputEvent> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FlexInputEvent.d(button.getContentDescription().toString()));
        return true;
    }

    public void removeAttachment(Attachment<?> attachment) {
        List<? extends Attachment<? extends Object>> mutableList;
        List<Attachment<Object>> list;
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        FlexInputState viewState = getViewState();
        if (viewState == null || (list = viewState.attachments) == null || (mutableList = _Collections.toMutableList((Collection) list)) == null) {
            mutableList = null;
        } else {
            TypeIntrinsics.asMutableCollection(mutableList).remove(attachment);
        }
        if (mutableList != null) {
            onAttachmentsUpdated(mutableList);
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void requestMediaPermissions(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        this.permissionRequests.requestMedia(onSuccess);
    }

    public void setAttachmentSelectedListener(FlexInputListener2 attachmentListener) {
        Intrinsics3.checkNotNullParameter(attachmentListener, "attachmentListener");
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
            updateViewState(FlexInputState.a(viewState2, null, false, null, enabled, false, null, false, false, false, false, false, null, null, 8183));
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
            updateViewState(FlexInputState.a(viewState2, null, false, null, false, singleSelect, null, false, false, false, false, false, null, null, 8175));
        }
    }

    public void setShowExpressionTrayButtonBadge(boolean showBadge) {
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, showBadge, false, null, null, 7679));
    }

    public final void setSingleAttachmentSelectedListener(FlexInputListener2 flexInputListener2) {
        this.singleAttachmentSelectedListener = flexInputListener2;
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
        updateViewState(FlexInputState.a(viewState, null, false, null, false, false, null, false, false, true, false, false, null, null, 7935));
        return true;
    }

    public final void showKeyboardAndHideExpressionTray() {
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        showKeyboard();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFlexInputViewModel(AppPermissions2 appPermissions2, FlexInputState flexInputState, Observable<StoreState> observable, StoreStickers storeStickers, StoreAnalytics storeAnalytics, StoreExpressionSuggestions storeExpressionSuggestions) {
        super(flexInputState);
        Intrinsics3.checkNotNullParameter(appPermissions2, "permissionRequests");
        Intrinsics3.checkNotNullParameter(flexInputState, "initialViewState");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(storeStickers, "storeStickers");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeExpressionSuggestions, "storeExpressionSuggestions");
        this.permissionRequests = appPermissions2;
        this.storeStickers = storeStickers;
        this.storeAnalytics = storeAnalytics;
        this.storeExpressionSuggestions = storeExpressionSuggestions;
        this.eventSubject = PublishSubject.k0();
        Observable observableR = ObservableExtensionsKt.computationLatest(observable).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeObservable\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), (Class<?>) AppFlexInputViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        this.attachmentView = true;
    }
}
