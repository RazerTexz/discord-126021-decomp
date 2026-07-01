package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.stickers.StickerUtils$StickerSendability;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.MessageManager;
import d0.g0.w;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public class StickerPickerViewModel extends d0<StickerPickerViewModel$ViewState> {
    public static final StickerPickerViewModel$Companion Companion = new StickerPickerViewModel$Companion(null);
    public static final long RECENT_SELECTED_ID = -1;
    private final StoreChannelsSelected channelSelectedStore;
    private final StoreChannels channelStore;
    private final PublishSubject<StickerPickerViewModel$Event> eventSubject;
    private final long initialStickerPackId;
    private final Locale locale;
    private final MessageManager messageManager;
    private final StorePermissions permissionStore;
    private final BehaviorSubject<String> searchSubject;
    private final BehaviorSubject<Long> selectedCategoryIdSubject;
    private int stickerCountToDisplayForStore;
    private final StoreStickers stickersStore;
    private final StoreUser userStore;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StickerPickerViewModel(BehaviorSubject behaviorSubject, BehaviorSubject behaviorSubject2, Locale locale, MessageManager messageManager, StoreStickers storeStickers, long j, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StorePermissions storePermissions, StoreUser storeUser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubjectL0;
        BehaviorSubject behaviorSubjectL1;
        if ((i & 1) != 0) {
            behaviorSubjectL0 = BehaviorSubject.l0("");
            m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        } else {
            behaviorSubjectL0 = behaviorSubject;
        }
        if ((i & 2) != 0) {
            behaviorSubjectL1 = BehaviorSubject.l0(null);
            m.checkNotNullExpressionValue(behaviorSubjectL1, "BehaviorSubject.create(null as Long?)");
        } else {
            behaviorSubjectL1 = behaviorSubject2;
        }
        this(behaviorSubjectL0, behaviorSubjectL1, locale, messageManager, (i & 16) != 0 ? StoreStream.Companion.getStickers() : storeStickers, j, (i & 64) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected, (i & 256) != 0 ? StoreStream.Companion.getPermissions() : storePermissions, (i & 512) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 1024) != 0 ? StickerPickerViewModel$Companion.observeStoreState$default(Companion, behaviorSubjectL0, behaviorSubjectL1, null, null, null, null, null, null, null, null, null, null, 4092, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(StickerPickerViewModel stickerPickerViewModel, StickerPickerViewModel$StoreState stickerPickerViewModel$StoreState) {
        stickerPickerViewModel.handleStoreState(stickerPickerViewModel$StoreState);
    }

    private final List<StickerCategoryItem> createCategoryItems(StickerPickerViewModel$StoreState$Loaded storeState, List<? extends MGRecyclerDataPayload> listItems, List<Sticker> frequentlyUsedStickers) {
        boolean z2;
        int size;
        Collection<Sticker> collectionValues;
        List list;
        ArrayList arrayList = new ArrayList();
        Long selectedCategoryId = storeState.getSelectedCategoryId();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        if ((!UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser()) && storeState.getGuildStickers().isEmpty()) || storeState.getEnabledStickerPacks().isEmpty()) {
            return n.emptyList();
        }
        if (listItems == null) {
            linkedHashSet.add(-1L);
            Iterator<T> it = storeState.getEnabledStickerPacks().iterator();
            while (it.hasNext()) {
                linkedHashSet.add(Long.valueOf(((ModelStickerPack) it.next()).getId()));
            }
        } else {
            for (MGRecyclerDataPayload mGRecyclerDataPayload : listItems) {
                if (mGRecyclerDataPayload instanceof StickerItem) {
                    Sticker sticker = ((StickerItem) mGRecyclerDataPayload).getSticker();
                    if (!(frequentlyUsedStickers instanceof Collection) || !frequentlyUsedStickers.isEmpty()) {
                        Iterator<T> it2 = frequentlyUsedStickers.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (((Sticker) it2.next()).getId() == sticker.getId()) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        linkedHashSet.add(-1L);
                    }
                    if (sticker.getPackId() != null) {
                        Long packId = sticker.getPackId();
                        Objects.requireNonNull(packId, "null cannot be cast to non-null type kotlin.Long");
                        linkedHashSet.add(packId);
                    }
                    if (sticker.getGuildId() != null) {
                        Long guildId = sticker.getGuildId();
                        Objects.requireNonNull(guildId, "null cannot be cast to non-null type kotlin.Long");
                        linkedHashSet2.add(guildId);
                    }
                }
            }
        }
        if (!frequentlyUsedStickers.isEmpty()) {
            size = frequentlyUsedStickers.size() + 1 + 0;
            if (linkedHashSet.contains(-1L)) {
                arrayList.add(new StickerCategoryItem$RecentItem(selectedCategoryId != null && selectedCategoryId.longValue() == -1, new Pair(0, Integer.valueOf(size))));
            }
        } else {
            size = 0;
        }
        for (Map$Entry<Long, Guild> map$Entry : storeState.getAllGuilds().entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            Guild value = map$Entry.getValue();
            Map<Long, Sticker> map = storeState.getGuildStickers().get(Long.valueOf(jLongValue));
            if (map != null && (collectionValues = map.values()) != null && (list = u.toList(collectionValues)) != null) {
                boolean z3 = selectedCategoryId != null && selectedCategoryId.longValue() == value.getId();
                if (storeState.canUseExternalStickersInCurrentChannel(jLongValue)) {
                    int size2 = list.size() + 1 + size;
                    if (linkedHashSet2.contains(Long.valueOf(jLongValue))) {
                        arrayList.add(new StickerCategoryItem$GuildItem(value, list, new Pair(Integer.valueOf(size), Integer.valueOf(size2)), z3));
                    }
                    size = size2;
                }
            }
        }
        if (UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser())) {
            for (ModelStickerPack modelStickerPack : storeState.getEnabledStickerPacks()) {
                boolean z4 = selectedCategoryId != null && selectedCategoryId.longValue() == modelStickerPack.getId();
                int size3 = modelStickerPack.getStickers().size() + 1 + size;
                if (linkedHashSet.contains(Long.valueOf(modelStickerPack.getId()))) {
                    arrayList.add(new StickerCategoryItem$PackItem(modelStickerPack, new Pair(Integer.valueOf(size), Integer.valueOf(size3)), z4));
                }
                size = size3;
            }
        }
        return arrayList;
    }

    private final Map<Long, Sticker> getAllStickersById(StickerPickerViewModel$StoreState$Loaded storeState) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = storeState.getEnabledStickerPacks().iterator();
        while (it.hasNext()) {
            for (Sticker sticker : ((ModelStickerPack) it.next()).getStickers()) {
                linkedHashMap.put(Long.valueOf(sticker.getId()), sticker);
            }
        }
        Iterator<T> it2 = storeState.getGuildStickers().values().iterator();
        while (it2.hasNext()) {
            for (Sticker sticker2 : ((Map) it2.next()).values()) {
                linkedHashMap.put(Long.valueOf(sticker2.getId()), sticker2);
            }
        }
        return h0.toMap(linkedHashMap);
    }

    @MainThread
    private final void handleStoreState(StickerPickerViewModel$StoreState storeState) {
        if (storeState instanceof StickerPickerViewModel$StoreState$Loaded) {
            StickerPickerViewModel$StoreState$Loaded stickerPickerViewModel$StoreState$Loaded = (StickerPickerViewModel$StoreState$Loaded) storeState;
            Long lValueOf = stickerPickerViewModel$StoreState$Loaded.getSelectedCategoryId() == null ? Long.valueOf(this.initialStickerPackId) : null;
            handleStoreStateForPage(stickerPickerViewModel$StoreState$Loaded);
            scrollToPackId(lValueOf);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00dc  */
    private final void handleStoreStateForPage(StickerPickerViewModel$StoreState$Loaded storeState) {
        boolean z2;
        List<? extends MGRecyclerDataPayload> list;
        Collection<Sticker> collectionValues;
        List list2;
        Map<Long, Sticker> allStickersById = getAllStickersById(storeState);
        List<ModelStickerPack> enabledStickerPacks = storeState.getEnabledStickerPacks();
        int stickerAnimationSettings = storeState.getStickerAnimationSettings();
        String searchInputStringUpper = storeState.getSearchInputStringUpper();
        Locale locale = this.locale;
        Objects.requireNonNull(searchInputStringUpper, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = searchInputStringUpper.toLowerCase(locale);
        String str = "(this as java.lang.String).toLowerCase(locale)";
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<Long> frequentlyUsedStickerIds = storeState.getFrequentlyUsedStickerIds();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = frequentlyUsedStickerIds.iterator();
        while (it.hasNext()) {
            Sticker sticker = allStickersById.get(Long.valueOf(((Number) it.next()).longValue()));
            if (sticker != null) {
                arrayList.add(sticker);
            }
        }
        ArrayList<Sticker> arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (true) {
            z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (StickerUtils.INSTANCE.getStickerSendability((Sticker) next, storeState.getMeUser(), storeState.getCurrentChannel(), Long.valueOf(storeState.getCurrentChannelPermissions())) != StickerUtils$StickerSendability.NONSENDABLE) {
                arrayList2.add(next);
            }
        }
        List<? extends MGRecyclerDataPayload> arrayList3 = new ArrayList<>();
        int i = 2;
        if (!arrayList2.isEmpty()) {
            for (Sticker sticker2 : arrayList2) {
                String name = sticker2.getName();
                Locale locale2 = this.locale;
                Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = name.toLowerCase(locale2);
                m.checkNotNullExpressionValue(lowerCase2, str);
                if (w.contains$default(lowerCase2, lowerCase, z2, i, (Object) null)) {
                    arrayList3.add(new StickerItem(sticker2, stickerAnimationSettings, StickerItem$Mode.OWNED, StickerUtils.INSTANCE.getStickerSendability(sticker2, storeState.getMeUser(), storeState.getCurrentChannel(), Long.valueOf(storeState.getCurrentChannelPermissions()))));
                } else {
                    String tags = sticker2.getTags();
                    Locale locale3 = this.locale;
                    Objects.requireNonNull(tags, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase3 = tags.toLowerCase(locale3);
                    m.checkNotNullExpressionValue(lowerCase3, str);
                    if (w.contains$default(lowerCase3, lowerCase, z2, i, (Object) null)) {
                        arrayList3.add(new StickerItem(sticker2, stickerAnimationSettings, StickerItem$Mode.OWNED, StickerUtils.INSTANCE.getStickerSendability(sticker2, storeState.getMeUser(), storeState.getCurrentChannel(), Long.valueOf(storeState.getCurrentChannelPermissions()))));
                    }
                }
                str = str;
                i = 2;
                z2 = false;
            }
            if (!arrayList3.isEmpty()) {
                arrayList3.add(0, new HeaderItem(HeaderType$Recent.INSTANCE));
            }
        }
        for (Map$Entry<Long, Guild> map$Entry : storeState.getAllGuilds().entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            Guild value = map$Entry.getValue();
            Map<Long, Sticker> map = storeState.getGuildStickers().get(Long.valueOf(jLongValue));
            if (map == null || (collectionValues = map.values()) == null || (list2 = u.toList(collectionValues)) == null || !storeState.canUseExternalStickersInCurrentChannel(jLongValue)) {
                list = arrayList3;
            } else {
                list = arrayList3;
                list.addAll(StickerPickerViewModel$Companion.access$buildGuildStickersListItems(Companion, list2, value, stickerAnimationSettings, lowerCase, storeState.getMeUser(), this.locale, storeState.getCurrentChannel(), storeState.getCurrentChannelPermissions()));
            }
            arrayList3 = list;
        }
        List<? extends MGRecyclerDataPayload> list3 = arrayList3;
        if (UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser())) {
            Iterator<ModelStickerPack> it3 = enabledStickerPacks.iterator();
            while (it3.hasNext()) {
                list3.addAll(StickerPickerViewModel$Companion.access$buildStickerListItems(Companion, it3.next(), lowerCase, stickerAnimationSettings, this.locale, storeState.getMeUser()));
            }
        }
        List<StickerCategoryItem> listCreateCategoryItems = createCategoryItems(storeState, list3, arrayList2);
        if (!UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser()) && storeState.getGuildStickers().isEmpty()) {
            updateViewState(new StickerPickerViewModel$ViewState$EmptyNonPremium(n.listOfNotNull((Object[]) new Sticker[]{this.stickersStore.getStickers().get(781323769960202280L), this.stickersStore.getStickers().get(809209266556764241L), this.stickersStore.getStickers().get(818597810047680532L), this.stickersStore.getStickers().get(819129296374595614L)}), storeState.isStickersSelectedTab()));
            return;
        }
        if (list3.isEmpty()) {
            if (lowerCase.length() > 0) {
                updateViewState(new StickerPickerViewModel$ViewState$EmptySearchResults(storeState.getSearchInputStringUpper(), listCreateCategoryItems));
                return;
            }
        }
        updateViewState(new StickerPickerViewModel$ViewState$Stickers(storeState.getSearchInputStringUpper(), list3, listCreateCategoryItems, storeState.isStickersSelectedTab(), storeState.isOnCooldown()));
    }

    public final Observable<StickerPickerViewModel$Event> observeEvents() {
        return this.eventSubject;
    }

    public final boolean onStickerSelected(Sticker sticker) {
        long id2;
        Channel channelFindChannelById;
        m.checkNotNullParameter(sticker, "sticker");
        if ((getViewState() instanceof StickerPickerViewModel$ViewState$Stickers) && (channelFindChannelById = this.channelStore.findChannelById((id2 = this.channelSelectedStore.getId()))) != null) {
            Long l = this.permissionStore.getPermissionsByChannel().get(Long.valueOf(id2));
            boolean zHasAccessWrite = PermissionUtils.INSTANCE.hasAccessWrite(channelFindChannelById, l);
            StickerUtils$StickerSendability stickerSendability = StickerUtils.INSTANCE.getStickerSendability(sticker, this.userStore.getMeSnapshot(), channelFindChannelById, l);
            if (stickerSendability == StickerUtils$StickerSendability.SENDABLE_WITH_PREMIUM) {
                this.eventSubject.k.onNext(StickerPickerViewModel$Event$ShowStickerPremiumUpsell.INSTANCE);
                return false;
            }
            StickerPickerViewModel$ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.chat.input.sticker.StickerPickerViewModel.ViewState.Stickers");
            if (((StickerPickerViewModel$ViewState$Stickers) viewState).isOnCooldown()) {
                this.eventSubject.k.onNext(StickerPickerViewModel$Event$SlowMode.INSTANCE);
                return false;
            }
            if (zHasAccessWrite && stickerSendability == StickerUtils$StickerSendability.SENDABLE) {
                this.stickersStore.onStickerUsed(sticker);
                MessageManager.sendMessage$default(this.messageManager, null, null, null, null, d0.t.m.listOf(sticker), false, null, null, null, 495, null);
                this.searchSubject.onNext("");
                return true;
            }
        }
        return false;
    }

    public final void scrollToPackId(Long packId) {
        StickerPickerViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof StickerPickerViewModel$ViewState$Stickers)) {
            viewState = null;
        }
        StickerPickerViewModel$ViewState$Stickers stickerPickerViewModel$ViewState$Stickers = (StickerPickerViewModel$ViewState$Stickers) viewState;
        if (stickerPickerViewModel$ViewState$Stickers == null || packId == null) {
            return;
        }
        packId.longValue();
        int size = stickerPickerViewModel$ViewState$Stickers.getStickerItems().size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            MGRecyclerDataPayload mGRecyclerDataPayload = stickerPickerViewModel$ViewState$Stickers.getStickerItems().get(i2);
            if (mGRecyclerDataPayload instanceof HeaderItem) {
                HeaderItem headerItem = (HeaderItem) mGRecyclerDataPayload;
                if ((headerItem.getHeaderType() instanceof HeaderType$PackItem) && ((HeaderType$PackItem) headerItem.getHeaderType()).getPack().getId() == packId.longValue()) {
                    i = i2;
                    break;
                }
            }
        }
        PublishSubject<StickerPickerViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new StickerPickerViewModel$Event$ScrollToStickerItemPosition(i));
    }

    public final void setSearchText(String searchText) {
        m.checkNotNullParameter(searchText, "searchText");
        this.searchSubject.onNext(searchText);
    }

    public final void setSelectedCategoryId(long categoryId) {
        this.selectedCategoryIdSubject.onNext(Long.valueOf(categoryId));
    }

    public final void setStickerCountToDisplayForStore(int count) {
        this.stickerCountToDisplayForStore = count;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPickerViewModel(BehaviorSubject<String> behaviorSubject, BehaviorSubject<Long> behaviorSubject2, Locale locale, MessageManager messageManager, StoreStickers storeStickers, long j, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StorePermissions storePermissions, StoreUser storeUser, Observable<StickerPickerViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(behaviorSubject, "searchSubject");
        m.checkNotNullParameter(behaviorSubject2, "selectedCategoryIdSubject");
        m.checkNotNullParameter(locale, "locale");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(storeStickers, "stickersStore");
        m.checkNotNullParameter(storeChannels, "channelStore");
        m.checkNotNullParameter(storeChannelsSelected, "channelSelectedStore");
        m.checkNotNullParameter(storePermissions, "permissionStore");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.searchSubject = behaviorSubject;
        this.selectedCategoryIdSubject = behaviorSubject2;
        this.locale = locale;
        this.messageManager = messageManager;
        this.stickersStore = storeStickers;
        this.initialStickerPackId = j;
        this.channelStore = storeChannels;
        this.channelSelectedStore = storeChannelsSelected;
        this.permissionStore = storePermissions;
        this.userStore = storeUser;
        PublishSubject<StickerPickerViewModel$Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        this.stickerCountToDisplayForStore = 4;
        storeStickers.fetchEnabledStickerDirectory();
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StickerPickerViewModel$1(this), 62, (Object) null);
    }
}
