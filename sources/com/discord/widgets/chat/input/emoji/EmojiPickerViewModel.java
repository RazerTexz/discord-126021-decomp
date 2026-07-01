package com.discord.widgets.chat.input.emoji;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreEmoji$EmojiContext;
import com.discord.stores.StoreEmoji$EmojiContext$Chat;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
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
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public class EmojiPickerViewModel extends d0<EmojiPickerViewModel$ViewState> {
    public static final EmojiPickerViewModel$Companion Companion = new EmojiPickerViewModel$Companion(null);
    private final EmojiPickerContextType emojiPickerContextType;
    private final PublishSubject<EmojiPickerViewModel$Event> eventSubject;
    private final Locale locale;
    private boolean logWhenUpsellHeaderIsViewed;
    private final BehaviorSubject<String> searchSubject;
    private final BehaviorSubject<Long> selectedCategoryItemIdSubject;
    private final StoreAnalytics storeAnalytics;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ EmojiPickerViewModel(EmojiPickerContextType emojiPickerContextType, Locale locale, BehaviorSubject behaviorSubject, BehaviorSubject behaviorSubject2, Observable observable, StoreAnalytics storeAnalytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubjectL0;
        BehaviorSubject behaviorSubjectL1;
        Observable observableObserveStoreState$default;
        if ((i & 4) != 0) {
            behaviorSubjectL0 = BehaviorSubject.l0("");
            m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        } else {
            behaviorSubjectL0 = behaviorSubject;
        }
        if ((i & 8) != 0) {
            behaviorSubjectL1 = BehaviorSubject.l0(Long.valueOf(EmojiCategoryItem.Companion.mapEmojiCategoryToItemId(EmojiCategory.FAVORITE)));
            m.checkNotNullExpressionValue(behaviorSubjectL1, "BehaviorSubject.create(\n…ojiCategory.FAVORITE)\n  )");
        } else {
            behaviorSubjectL1 = behaviorSubject2;
        }
        if ((i & 16) != 0) {
            EmojiPickerViewModel$Companion emojiPickerViewModel$Companion = Companion;
            observableObserveStoreState$default = EmojiPickerViewModel$Companion.observeStoreState$default(emojiPickerViewModel$Companion, EmojiPickerViewModel$Companion.getEmojiContextObservable$default(emojiPickerViewModel$Companion, emojiPickerContextType, null, 2, null), behaviorSubjectL0, behaviorSubjectL1, null, null, null, null, 120, null);
        } else {
            observableObserveStoreState$default = observable;
        }
        this(emojiPickerContextType, locale, behaviorSubjectL0, behaviorSubjectL1, observableObserveStoreState$default, (i & 32) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics);
    }

    public static final /* synthetic */ void access$handleStoreState(EmojiPickerViewModel emojiPickerViewModel, EmojiPickerViewModel$StoreState emojiPickerViewModel$StoreState) {
        emojiPickerViewModel.handleStoreState(emojiPickerViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(EmojiPickerViewModel$StoreState storeState) {
        List listMinus;
        EmojiPickerViewModel emojiPickerViewModel;
        LinkedHashMap<Long, Guild> linkedHashMap;
        int i;
        EmojiCategory emojiCategory;
        if (storeState instanceof EmojiPickerViewModel$StoreState$Emoji) {
            EmojiPickerViewModel$StoreState$Emoji emojiPickerViewModel$StoreState$Emoji = (EmojiPickerViewModel$StoreState$Emoji) storeState;
            EmojiSet emojiSet = emojiPickerViewModel$StoreState$Emoji.getEmojiSet();
            long selectedCategoryItemId = emojiPickerViewModel$StoreState$Emoji.getSelectedCategoryItemId();
            boolean allowEmojisToAnimate = emojiPickerViewModel$StoreState$Emoji.getAllowEmojisToAnimate();
            String searchInputStringUpper = emojiPickerViewModel$StoreState$Emoji.getSearchInputStringUpper();
            Locale locale = this.locale;
            Objects.requireNonNull(searchInputStringUpper, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = searchInputStringUpper.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            boolean z2 = lowerCase.length() > 0;
            ArrayList arrayList = new ArrayList();
            LinkedHashMap<Long, Guild> allGuilds = emojiPickerViewModel$StoreState$Emoji.getAllGuilds();
            Collection<Guild> collectionValues = emojiPickerViewModel$StoreState$Emoji.getAllGuilds().values();
            m.checkNotNullExpressionValue(collectionValues, "storeState.allGuilds.values");
            List list = u.toList(collectionValues);
            Collection<MGRecyclerDataPayload> linkedHashSet = z2 ? new LinkedHashSet() : new ArrayList();
            Collection linkedHashSet2 = z2 ? new LinkedHashSet() : new ArrayList();
            boolean z3 = !z2;
            EmojiPickerViewModel$Companion emojiPickerViewModel$Companion = Companion;
            LinkedHashMap<Long, Guild> linkedHashMap2 = allGuilds;
            EmojiPickerViewModel$Companion$EmojiItems emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems = EmojiPickerViewModel$Companion.access$buildEmojiListItems(emojiPickerViewModel$Companion, emojiPickerViewModel$StoreState$Emoji.getFavoriteEmoji(), new EmojiPickerViewModel$handleStoreState$favoriteItems$1(allGuilds), lowerCase, allowEmojisToAnimate, z2, z3);
            if (emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems instanceof EmojiPickerViewModel$Companion$EmojiItems$Partitioned) {
                EmojiPickerViewModel$Companion$EmojiItems$Partitioned emojiPickerViewModel$Companion$EmojiItems$Partitioned = (EmojiPickerViewModel$Companion$EmojiItems$Partitioned) emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems;
                linkedHashSet.addAll(emojiPickerViewModel$Companion$EmojiItems$Partitioned.getRegularItems());
                linkedHashSet2.addAll(emojiPickerViewModel$Companion$EmojiItems$Partitioned.getPremiumItems());
            } else if (emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems instanceof EmojiPickerViewModel$Companion$EmojiItems$Regular) {
                EmojiPickerViewModel$Companion$EmojiItems$Regular emojiPickerViewModel$Companion$EmojiItems$Regular = (EmojiPickerViewModel$Companion$EmojiItems$Regular) emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems;
                if (!emojiPickerViewModel$Companion$EmojiItems$Regular.getItems().isEmpty()) {
                    int size = linkedHashSet.size();
                    if (!z2) {
                        linkedHashSet.add(new WidgetEmojiAdapter$HeaderItem$StandardHeaderItem(EmojiCategory.FAVORITE));
                    }
                    linkedHashSet.addAll(emojiPickerViewModel$Companion$EmojiItems$Regular.getItems());
                    EmojiCategoryItem$Companion emojiCategoryItem$Companion = EmojiCategoryItem.Companion;
                    EmojiCategory emojiCategory2 = EmojiCategory.FAVORITE;
                    arrayList.add(new EmojiCategoryItem$StandardItem(emojiCategory2, new Pair(Integer.valueOf(size), Integer.valueOf(linkedHashSet.size())), emojiCategoryItem$Companion.mapEmojiCategoryToItemId(emojiCategory2) == selectedCategoryItemId));
                }
            }
            EmojiPickerViewModel$Companion$EmojiItems emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems2 = EmojiPickerViewModel$Companion.access$buildEmojiListItems(emojiPickerViewModel$Companion, emojiSet.recentEmojis, new EmojiPickerViewModel$handleStoreState$frequentItems$1(linkedHashMap2), lowerCase, allowEmojisToAnimate, z2, z3);
            if (emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems2 instanceof EmojiPickerViewModel$Companion$EmojiItems$Partitioned) {
                EmojiPickerViewModel$Companion$EmojiItems$Partitioned emojiPickerViewModel$Companion$EmojiItems$Partitioned2 = (EmojiPickerViewModel$Companion$EmojiItems$Partitioned) emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems2;
                linkedHashSet.addAll(emojiPickerViewModel$Companion$EmojiItems$Partitioned2.getRegularItems());
                linkedHashSet2.addAll(emojiPickerViewModel$Companion$EmojiItems$Partitioned2.getPremiumItems());
            } else if (emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems2 instanceof EmojiPickerViewModel$Companion$EmojiItems$Regular) {
                EmojiPickerViewModel$Companion$EmojiItems$Regular emojiPickerViewModel$Companion$EmojiItems$Regular2 = (EmojiPickerViewModel$Companion$EmojiItems$Regular) emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems2;
                if (!emojiPickerViewModel$Companion$EmojiItems$Regular2.getItems().isEmpty()) {
                    int size2 = linkedHashSet.size();
                    if (!z2) {
                        linkedHashSet.add(new WidgetEmojiAdapter$HeaderItem$StandardHeaderItem(EmojiCategory.RECENT));
                    }
                    linkedHashSet.addAll(emojiPickerViewModel$Companion$EmojiItems$Regular2.getItems());
                    EmojiCategoryItem$Companion emojiCategoryItem$Companion2 = EmojiCategoryItem.Companion;
                    EmojiCategory emojiCategory3 = EmojiCategory.RECENT;
                    arrayList.add(new EmojiCategoryItem$StandardItem(emojiCategory3, new Pair(Integer.valueOf(size2), Integer.valueOf(linkedHashSet.size())), emojiCategoryItem$Companion2.mapEmojiCategoryToItemId(emojiCategory3) == selectedCategoryItemId));
                }
            }
            StoreEmoji$EmojiContext emojiContext = emojiPickerViewModel$StoreState$Emoji.getEmojiContext();
            long guildId = emojiContext instanceof StoreEmoji$EmojiContext$Chat ? ((StoreEmoji$EmojiContext$Chat) emojiContext).getGuildId() : 0L;
            Guild guild = emojiPickerViewModel$StoreState$Emoji.getAllGuilds().get(Long.valueOf(guildId));
            List<Emoji> list2 = emojiSet.customEmojis.get(Long.valueOf(guildId));
            if (guild == null || list2 == null || !(!list2.isEmpty())) {
                listMinus = list;
            } else {
                EmojiPickerViewModel$Companion$EmojiItems emojiPickerViewModel$Companion$EmojiItemsAccess$buildGuildEmojiListItems = EmojiPickerViewModel$Companion.access$buildGuildEmojiListItems(emojiPickerViewModel$Companion, guild, emojiSet, lowerCase, allowEmojisToAnimate, z2, z3);
                if (emojiPickerViewModel$Companion$EmojiItemsAccess$buildGuildEmojiListItems instanceof EmojiPickerViewModel$Companion$EmojiItems$Partitioned) {
                    EmojiPickerViewModel$Companion$EmojiItems$Partitioned emojiPickerViewModel$Companion$EmojiItems$Partitioned3 = (EmojiPickerViewModel$Companion$EmojiItems$Partitioned) emojiPickerViewModel$Companion$EmojiItemsAccess$buildGuildEmojiListItems;
                    linkedHashSet.addAll(emojiPickerViewModel$Companion$EmojiItems$Partitioned3.getRegularItems());
                    linkedHashSet2.addAll(emojiPickerViewModel$Companion$EmojiItems$Partitioned3.getPremiumItems());
                } else if (emojiPickerViewModel$Companion$EmojiItemsAccess$buildGuildEmojiListItems instanceof EmojiPickerViewModel$Companion$EmojiItems$Regular) {
                    EmojiPickerViewModel$Companion$EmojiItems$Regular emojiPickerViewModel$Companion$EmojiItems$Regular3 = (EmojiPickerViewModel$Companion$EmojiItems$Regular) emojiPickerViewModel$Companion$EmojiItemsAccess$buildGuildEmojiListItems;
                    if (!emojiPickerViewModel$Companion$EmojiItems$Regular3.getItems().isEmpty()) {
                        int size3 = linkedHashSet.size();
                        if (!z2) {
                            linkedHashSet.add(new WidgetEmojiAdapter$HeaderItem$GuildHeaderItem(guild));
                        }
                        linkedHashSet.addAll(emojiPickerViewModel$Companion$EmojiItems$Regular3.getItems());
                        arrayList.add(new EmojiCategoryItem$GuildItem(guild, new Pair(Integer.valueOf(size3), Integer.valueOf(linkedHashSet.size())), EmojiCategoryItem.Companion.mapGuildToItemId(guild) == selectedCategoryItemId));
                    }
                }
                listMinus = u.minus(list, guild);
            }
            Iterator it = listMinus.iterator();
            while (it.hasNext()) {
                Guild guild2 = (Guild) it.next();
                Iterator it2 = it;
                EmojiPickerViewModel$Companion$EmojiItems emojiPickerViewModel$Companion$EmojiItemsAccess$buildGuildEmojiListItems2 = EmojiPickerViewModel$Companion.access$buildGuildEmojiListItems(Companion, guild2, emojiSet, lowerCase, allowEmojisToAnimate, z2, z3);
                if (emojiPickerViewModel$Companion$EmojiItemsAccess$buildGuildEmojiListItems2 instanceof EmojiPickerViewModel$Companion$EmojiItems$Partitioned) {
                    EmojiPickerViewModel$Companion$EmojiItems$Partitioned emojiPickerViewModel$Companion$EmojiItems$Partitioned4 = (EmojiPickerViewModel$Companion$EmojiItems$Partitioned) emojiPickerViewModel$Companion$EmojiItemsAccess$buildGuildEmojiListItems2;
                    linkedHashSet.addAll(emojiPickerViewModel$Companion$EmojiItems$Partitioned4.getRegularItems());
                    linkedHashSet2.addAll(emojiPickerViewModel$Companion$EmojiItems$Partitioned4.getPremiumItems());
                } else if (emojiPickerViewModel$Companion$EmojiItemsAccess$buildGuildEmojiListItems2 instanceof EmojiPickerViewModel$Companion$EmojiItems$Regular) {
                    EmojiPickerViewModel$Companion$EmojiItems$Regular emojiPickerViewModel$Companion$EmojiItems$Regular4 = (EmojiPickerViewModel$Companion$EmojiItems$Regular) emojiPickerViewModel$Companion$EmojiItemsAccess$buildGuildEmojiListItems2;
                    if (!emojiPickerViewModel$Companion$EmojiItems$Regular4.getItems().isEmpty()) {
                        int size4 = linkedHashSet.size();
                        if (!z2) {
                            m.checkNotNullExpressionValue(guild2, "guild");
                            linkedHashSet.add(new WidgetEmojiAdapter$HeaderItem$GuildHeaderItem(guild2));
                        }
                        linkedHashSet.addAll(emojiPickerViewModel$Companion$EmojiItems$Regular4.getItems());
                        EmojiCategoryItem$Companion emojiCategoryItem$Companion3 = EmojiCategoryItem.Companion;
                        m.checkNotNullExpressionValue(guild2, "guild");
                        arrayList.add(new EmojiCategoryItem$GuildItem(guild2, new Pair(Integer.valueOf(size4), Integer.valueOf(linkedHashSet.size())), emojiCategoryItem$Companion3.mapGuildToItemId(guild2) == selectedCategoryItemId));
                    }
                }
                it = it2;
            }
            Map<EmojiCategory, List<Emoji>> map = emojiSet.unicodeEmojis;
            EmojiCategory[] emojiCategoryArrValues = EmojiCategory.values();
            int i2 = 0;
            for (int i3 = 11; i2 < i3; i3 = 11) {
                EmojiCategory emojiCategory4 = emojiCategoryArrValues[i2];
                if (map.containsKey(emojiCategory4)) {
                    int size5 = linkedHashSet.size();
                    LinkedHashMap<Long, Guild> linkedHashMap3 = linkedHashMap2;
                    linkedHashMap = linkedHashMap3;
                    i = i2;
                    EmojiPickerViewModel$Companion$EmojiItems emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems3 = EmojiPickerViewModel$Companion.access$buildEmojiListItems(Companion, map.get(emojiCategory4), new EmojiPickerViewModel$handleStoreState$unicodeCategoryItems$1(linkedHashMap3), lowerCase, allowEmojisToAnimate, false, false);
                    if (emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems3 instanceof EmojiPickerViewModel$Companion$EmojiItems$Regular) {
                        EmojiPickerViewModel$Companion$EmojiItems$Regular emojiPickerViewModel$Companion$EmojiItems$Regular5 = (EmojiPickerViewModel$Companion$EmojiItems$Regular) emojiPickerViewModel$Companion$EmojiItemsAccess$buildEmojiListItems3;
                        if (!emojiPickerViewModel$Companion$EmojiItems$Regular5.getItems().isEmpty()) {
                            if (z2) {
                                emojiCategory = emojiCategory4;
                            } else {
                                emojiCategory = emojiCategory4;
                                linkedHashSet.add(new WidgetEmojiAdapter$HeaderItem$StandardHeaderItem(emojiCategory));
                            }
                            linkedHashSet.addAll(emojiPickerViewModel$Companion$EmojiItems$Regular5.getItems());
                            arrayList.add(new EmojiCategoryItem$StandardItem(emojiCategory, new Pair(Integer.valueOf(size5), Integer.valueOf(linkedHashSet.size())), EmojiCategoryItem.Companion.mapEmojiCategoryToItemId(emojiCategory) == selectedCategoryItemId));
                        }
                    }
                } else {
                    i = i2;
                    linkedHashMap = linkedHashMap2;
                }
                i2 = i + 1;
                linkedHashMap2 = linkedHashMap;
            }
            if (z2 && (!linkedHashSet2.isEmpty())) {
                linkedHashSet.add(new WidgetEmojiAdapter$HeaderItem$StringHeaderItem(2131888751));
                linkedHashSet.addAll(linkedHashSet2);
                linkedHashSet.add(WidgetEmojiAdapter$UpsellItem.INSTANCE);
            }
            if (z2) {
                emojiPickerViewModel = this;
                emojiPickerViewModel.logWhenUpsellHeaderIsViewed = true;
                int i4 = 0;
                int i5 = 0;
                for (MGRecyclerDataPayload mGRecyclerDataPayload : linkedHashSet) {
                    if (mGRecyclerDataPayload instanceof WidgetEmojiAdapter$EmojiItem) {
                        i4++;
                        if (!((WidgetEmojiAdapter$EmojiItem) mGRecyclerDataPayload).getEmoji().isUsable()) {
                            i5++;
                        }
                    }
                }
                if (i4 > 0) {
                    emojiPickerViewModel.storeAnalytics.trackSearchResultViewed(SearchType.EMOJI, i4, Integer.valueOf(i5), emojiPickerViewModel.storeAnalytics.getEmojiPickerUpsellLocation(), true);
                } else {
                    StoreAnalytics storeAnalytics = emojiPickerViewModel.storeAnalytics;
                    storeAnalytics.trackSearchResultsEmpty(SearchType.EMOJI, storeAnalytics.getEmojiPickerUpsellLocation(), true);
                }
            } else {
                emojiPickerViewModel = this;
            }
            if (linkedHashSet.isEmpty() && z2) {
                emojiPickerViewModel.updateViewState(new EmojiPickerViewModel$ViewState$EmptySearch(emojiPickerViewModel$StoreState$Emoji.getSearchInputStringUpper()));
                return;
            }
            List list3 = (List) (!(linkedHashSet instanceof List) ? null : linkedHashSet);
            if (list3 == null) {
                list3 = u.toList(linkedHashSet);
            }
            emojiPickerViewModel.updateViewState(new EmojiPickerViewModel$ViewState$Results(emojiPickerViewModel$StoreState$Emoji.getSearchInputStringUpper(), list3, arrayList));
        }
    }

    public final Observable<EmojiPickerViewModel$Event> observeEvents() {
        return this.eventSubject;
    }

    public final void onClickUnicodeEmojiCategories() {
        EmojiCategoryItem$StandardItem firstUnicodeEmojiCategoryItem;
        EmojiPickerViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof EmojiPickerViewModel$ViewState$Results)) {
            viewState = null;
        }
        EmojiPickerViewModel$ViewState$Results emojiPickerViewModel$ViewState$Results = (EmojiPickerViewModel$ViewState$Results) viewState;
        if (emojiPickerViewModel$ViewState$Results == null || (firstUnicodeEmojiCategoryItem = emojiPickerViewModel$ViewState$Results.getFirstUnicodeEmojiCategoryItem()) == null) {
            return;
        }
        setSelectedCategoryItemId(firstUnicodeEmojiCategoryItem.getStableId());
        this.eventSubject.k.onNext(new EmojiPickerViewModel$Event$ScrollToEmojiListPosition(firstUnicodeEmojiCategoryItem.getCategoryRange().getFirst().intValue()));
    }

    public final void onEmojiSelected(Emoji emoji, Function1<? super Emoji, Unit> validEmojiSelected) {
        int i;
        m.checkNotNullParameter(emoji, "emoji");
        m.checkNotNullParameter(validEmojiSelected, "validEmojiSelected");
        EmojiPickerViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof EmojiPickerViewModel$ViewState$Results)) {
            viewState = null;
        }
        EmojiPickerViewModel$ViewState$Results emojiPickerViewModel$ViewState$Results = (EmojiPickerViewModel$ViewState$Results) viewState;
        List<MGRecyclerDataPayload> resultItems = emojiPickerViewModel$ViewState$Results != null ? emojiPickerViewModel$ViewState$Results.getResultItems() : null;
        if (resultItems == null) {
            resultItems = n.emptyList();
        }
        boolean z2 = false;
        if ((resultItems instanceof Collection) && resultItems.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = resultItems.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if ((((MGRecyclerDataPayload) it.next()) instanceof WidgetEmojiAdapter$EmojiItem) && (i2 = i2 + 1) < 0) {
                    n.throwCountOverflow();
                }
            }
            i = i2;
        }
        StoreAnalytics storeAnalytics = this.storeAnalytics;
        StoreAnalytics.trackSearchResultSelected$default(storeAnalytics, SearchType.EMOJI, i, Traits$Location.copy$default(storeAnalytics.getEmojiPickerUpsellLocation(), null, null, "Search Result", null, null, 27, null), null, 8, null);
        if (emoji.isUsable()) {
            if (emoji.isAvailable()) {
                validEmojiSelected.invoke(emoji);
            }
        } else {
            if ((emoji instanceof ModelEmojiCustom) && ((ModelEmojiCustom) emoji).isAnimated()) {
                z2 = true;
            }
            this.eventSubject.k.onNext(new EmojiPickerViewModel$Event$ShowPremiumUpsellDialog(z2 ? 2 : 1, z2 ? 2131894490 : 2131894498, z2 ? 2131894491 : 2131894499, Traits$Location$Section.EMOJI_PICKER_POPOUT, false, false));
            this.storeAnalytics.emojiPickerUpsellLockedItemClicked(this.emojiPickerContextType, z2);
        }
    }

    public final void onUpsellHeaderVisible() {
        this.storeAnalytics.emojiPickerUpsellHeaderViewed(this.emojiPickerContextType);
        this.logWhenUpsellHeaderIsViewed = false;
    }

    public final void setSearchText(String searchText) {
        m.checkNotNullParameter(searchText, "searchText");
        this.searchSubject.onNext(searchText);
        StoreAnalytics storeAnalytics = this.storeAnalytics;
        storeAnalytics.trackSearchStarted(SearchType.EMOJI, storeAnalytics.getEmojiPickerUpsellLocation(), true);
    }

    public final void setSelectedCategoryItemId(long categoryId) {
        this.selectedCategoryItemIdSubject.onNext(Long.valueOf(categoryId));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel(EmojiPickerContextType emojiPickerContextType, Locale locale, BehaviorSubject<String> behaviorSubject, BehaviorSubject<Long> behaviorSubject2, Observable<EmojiPickerViewModel$StoreState> observable, StoreAnalytics storeAnalytics) {
        super(null);
        m.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        m.checkNotNullParameter(locale, "locale");
        m.checkNotNullParameter(behaviorSubject, "searchSubject");
        m.checkNotNullParameter(behaviorSubject2, "selectedCategoryItemIdSubject");
        m.checkNotNullParameter(observable, "storeStateObservable");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        this.emojiPickerContextType = emojiPickerContextType;
        this.locale = locale;
        this.searchSubject = behaviorSubject;
        this.selectedCategoryItemIdSubject = behaviorSubject2;
        this.storeAnalytics = storeAnalytics;
        PublishSubject<EmojiPickerViewModel$Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new EmojiPickerViewModel$1(this), 62, (Object) null);
    }
}
