package com.discord.widgets.chat.input;

import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.b.a.h.a;
import b.b.a.h.a$a;
import b.b.a.h.a$b;
import b.b.a.h.a$c;
import b.b.a.h.a$d;
import b.b.a.h.a$e;
import b.i.a.f.e.o.f;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppPermissionsRequests;
import com.discord.panels.PanelState;
import com.discord.panels.PanelState$a;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreExpressionSuggestions;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.home.WidgetHome;
import com.lytefast.flexinput.FlexInputAttachmentListener;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.t.n;
import d0.t.n0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.e0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFlexInputViewModel extends d0<FlexInputState> implements FlexInputViewModel {
    private static final String CHAT_GIFTING_NOTICE = "CHAT_GIFTING_NOTICE";
    public static final AppFlexInputViewModel$Companion Companion = new AppFlexInputViewModel$Companion(null);
    private boolean attachmentView;
    private PublishSubject<a> eventSubject;
    private final AppPermissionsRequests permissionRequests;
    private FlexInputAttachmentListener singleAttachmentSelectedListener;
    private boolean singleSelectMode;
    private final StoreAnalytics storeAnalytics;
    private final StoreExpressionSuggestions storeExpressionSuggestions;
    private final StoreStickers storeStickers;

    public /* synthetic */ AppFlexInputViewModel(AppPermissionsRequests appPermissionsRequests, FlexInputState flexInputState, Observable observable, StoreStickers storeStickers, StoreAnalytics storeAnalytics, StoreExpressionSuggestions storeExpressionSuggestions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appPermissionsRequests, (i & 2) != 0 ? new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191) : flexInputState, (i & 4) != 0 ? AppFlexInputViewModel$Companion.access$observeStores(Companion) : observable, (i & 8) != 0 ? StoreStream.Companion.getStickers() : storeStickers, (i & 16) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics, (i & 32) != 0 ? StoreStream.Companion.getExpressionSuggestions() : storeExpressionSuggestions);
    }

    public static final /* synthetic */ void access$handleStoreState(AppFlexInputViewModel appFlexInputViewModel, AppFlexInputViewModel$StoreState appFlexInputViewModel$StoreState) {
        appFlexInputViewModel.handleStoreState(appFlexInputViewModel$StoreState);
    }

    public static /* synthetic */ void clean$default(AppFlexInputViewModel appFlexInputViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        appFlexInputViewModel.clean(z2);
    }

    private final void handleStoreState(AppFlexInputViewModel$StoreState storeState) {
        boolean zCan;
        boolean z2;
        boolean z3;
        FlexInputState flexInputStateRequireViewState = requireViewState();
        Channel selectedChannel = storeState.getSelectedChannel();
        Long channelPermission = storeState.getChannelPermission();
        PanelState leftPanelState = storeState.getLeftPanelState();
        PanelState$a panelState$a = PanelState$a.a;
        boolean z4 = (m.areEqual(leftPanelState, panelState$a) ^ true) || (m.areEqual(storeState.getRightPanelState(), panelState$a) ^ true);
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
        PublishSubject<a> publishSubject = this.eventSubject;
        publishSubject.k.onNext(a$c.a);
    }

    @MainThread
    public final void clean(boolean clearText) {
        FlexInputState viewState = getViewState();
        if (viewState != null) {
            updateViewState(FlexInputState.a(viewState, clearText ? "" : viewState.inputText, true, n.emptyList(), false, false, null, false, false, false, false, false, null, null, 8152));
        }
    }

    public final void focus() {
        PublishSubject<a> publishSubject = this.eventSubject;
        publishSubject.k.onNext(a$a.a);
    }

    public final boolean getAttachmentView() {
        return this.attachmentView;
    }

    public final List<Sticker> getMatchingStickers(String inputText) {
        m.checkNotNullParameter(inputText, "inputText");
        AppFlexInputViewModel$getMatchingStickers$1 appFlexInputViewModel$getMatchingStickers$1 = AppFlexInputViewModel$getMatchingStickers$1.INSTANCE;
        int length = inputText.length();
        return u.toList(3 <= length && 50 >= length ? appFlexInputViewModel$getMatchingStickers$1.invoke2(inputText) : n0.emptySet());
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
        updateViewState(FlexInputState.a(viewState, null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        return true;
    }

    public final void hideKeyboard() {
        PublishSubject<a> publishSubject = this.eventSubject;
        publishSubject.k.onNext(a$b.a);
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
    public Observable<a> observeEvents() {
        PublishSubject<a> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
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
        m.checkNotNullParameter(attachments, "attachments");
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
                ChannelSelector.openCreateThread$default(ChannelSelector.Companion.getInstance(), l2.longValue(), l.longValue(), null, "Plus Button", 4, null);
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
            PublishSubject<a> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new a$e(2131887440));
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onGiftButtonClicked() {
        hideKeyboard();
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice(CHAT_GIFTING_NOTICE, null, 0L, 0, false, d0.t.m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, AppFlexInputViewModel$onGiftButtonClicked$1.INSTANCE, 150, null));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onInputTextAppended(String appendText) {
        m.checkNotNullParameter(appendText, "appendText");
        f.P0(this, b.d.b.a.a.J(new StringBuilder(), requireViewState().inputText, appendText), null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onInputTextChanged(String inputText, Boolean focused) {
        boolean z2;
        m.checkNotNullParameter(inputText, "inputText");
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (m.areEqual(inputText, flexInputStateRequireViewState.inputText) || !flexInputStateRequireViewState.ableToSendMessages) {
            return;
        }
        if (m.areEqual(focused, Boolean.TRUE)) {
            showKeyboard();
        } else if (m.areEqual(focused, Boolean.FALSE)) {
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
        inputListener.onSend(viewState.inputText, viewState.attachments, new AppFlexInputViewModel$onSendButtonClicked$1(this));
    }

    @MainThread
    public void onShowDialog() {
        hideKeyboard();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void onSingleAttachmentSelected(Attachment<? extends Object> attachment) {
        m.checkNotNullParameter(attachment, "attachment");
        FlexInputAttachmentListener flexInputAttachmentListener = this.singleAttachmentSelectedListener;
        if (flexInputAttachmentListener != null) {
            flexInputAttachmentListener.onAttachmentSelected(attachment);
        }
    }

    @MainThread
    public final void onStickerSuggestionSent(boolean shouldClearInput) {
        FlexInputState viewState = getViewState();
        if (viewState != null) {
            updateViewState(FlexInputState.a(viewState, shouldClearInput ? "" : viewState.inputText, true, n.emptyList(), false, false, null, false, false, false, false, false, null, null, 8152));
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
        m.checkNotNullParameter(button, "button");
        PublishSubject<a> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new a$d(button.getContentDescription().toString()));
        return true;
    }

    public void removeAttachment(Attachment<?> attachment) {
        List<? extends Attachment<? extends Object>> mutableList;
        List<Attachment<Object>> list;
        m.checkNotNullParameter(attachment, "attachment");
        FlexInputState viewState = getViewState();
        if (viewState == null || (list = viewState.attachments) == null || (mutableList = u.toMutableList((Collection) list)) == null) {
            mutableList = null;
        } else {
            e0.asMutableCollection(mutableList).remove(attachment);
        }
        if (mutableList != null) {
            onAttachmentsUpdated(mutableList);
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void requestMediaPermissions(Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        this.permissionRequests.requestMedia(onSuccess);
    }

    public void setAttachmentSelectedListener(FlexInputAttachmentListener attachmentListener) {
        m.checkNotNullParameter(attachmentListener, "attachmentListener");
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
        updateViewState(FlexInputState.a(viewState, null, false, null, false, false, null, false, false, true, false, false, null, null, 7935));
        return true;
    }

    public final void showKeyboardAndHideExpressionTray() {
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        showKeyboard();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFlexInputViewModel(AppPermissionsRequests appPermissionsRequests, FlexInputState flexInputState, Observable<AppFlexInputViewModel$StoreState> observable, StoreStickers storeStickers, StoreAnalytics storeAnalytics, StoreExpressionSuggestions storeExpressionSuggestions) {
        super(flexInputState);
        m.checkNotNullParameter(appPermissionsRequests, "permissionRequests");
        m.checkNotNullParameter(flexInputState, "initialViewState");
        m.checkNotNullParameter(observable, "storeObservable");
        m.checkNotNullParameter(storeStickers, "storeStickers");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(storeExpressionSuggestions, "storeExpressionSuggestions");
        this.permissionRequests = appPermissionsRequests;
        this.storeStickers = storeStickers;
        this.storeAnalytics = storeAnalytics;
        this.storeExpressionSuggestions = storeExpressionSuggestions;
        this.eventSubject = PublishSubject.k0();
        Observable observableR = ObservableExtensionsKt.computationLatest(observable).r();
        m.checkNotNullExpressionValue(observableR, "storeObservable\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), AppFlexInputViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AppFlexInputViewModel$1(this), 62, (Object) null);
        this.attachmentView = true;
    }
}
