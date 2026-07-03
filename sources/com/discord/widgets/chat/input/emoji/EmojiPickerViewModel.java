package com.discord.widgets.chat.input.emoji;

import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func6;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public class EmojiPickerViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final EmojiPickerContextType emojiPickerContextType;
    private final PublishSubject<Event> eventSubject;
    private final Locale locale;
    private boolean logWhenUpsellHeaderIsViewed;
    private final BehaviorSubject<String> searchSubject;
    private final BehaviorSubject<Long> selectedCategoryItemIdSubject;
    private final StoreAnalytics storeAnalytics;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.EmojiPickerViewModel$1 */
    /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
    public static final class C78121 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C78121() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            EmojiPickerViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
        public static abstract class EmojiItems {

            /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
            public static final /* data */ class Partitioned extends EmojiItems {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private static final Partitioned Empty = new Partitioned(C12147n.emptyList(), C12147n.emptyList());
                private final List<MGRecyclerDataPayload> premiumItems;
                private final List<MGRecyclerDataPayload> regularItems;

                /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
                public static final class Companion {
                    private Companion() {
                    }

                    public final Partitioned getEmpty() {
                        return Partitioned.Empty;
                    }

                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public Partitioned(List<? extends MGRecyclerDataPayload> list, List<? extends MGRecyclerDataPayload> list2) {
                    super(null);
                    C12238m.checkNotNullParameter(list, "regularItems");
                    C12238m.checkNotNullParameter(list2, "premiumItems");
                    this.regularItems = list;
                    this.premiumItems = list2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Partitioned copy$default(Partitioned partitioned, List list, List list2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = partitioned.regularItems;
                    }
                    if ((i & 2) != 0) {
                        list2 = partitioned.premiumItems;
                    }
                    return partitioned.copy(list, list2);
                }

                public final List<MGRecyclerDataPayload> component1() {
                    return this.regularItems;
                }

                public final List<MGRecyclerDataPayload> component2() {
                    return this.premiumItems;
                }

                public final Partitioned copy(List<? extends MGRecyclerDataPayload> regularItems, List<? extends MGRecyclerDataPayload> premiumItems) {
                    C12238m.checkNotNullParameter(regularItems, "regularItems");
                    C12238m.checkNotNullParameter(premiumItems, "premiumItems");
                    return new Partitioned(regularItems, premiumItems);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Partitioned)) {
                        return false;
                    }
                    Partitioned partitioned = (Partitioned) other;
                    return C12238m.areEqual(this.regularItems, partitioned.regularItems) && C12238m.areEqual(this.premiumItems, partitioned.premiumItems);
                }

                public final List<MGRecyclerDataPayload> getPremiumItems() {
                    return this.premiumItems;
                }

                public final List<MGRecyclerDataPayload> getRegularItems() {
                    return this.regularItems;
                }

                public int hashCode() {
                    List<MGRecyclerDataPayload> list = this.regularItems;
                    int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                    List<MGRecyclerDataPayload> list2 = this.premiumItems;
                    return iHashCode + (list2 != null ? list2.hashCode() : 0);
                }

                public String toString() {
                    StringBuilder sbM833U = C1643a.m833U("Partitioned(regularItems=");
                    sbM833U.append(this.regularItems);
                    sbM833U.append(", premiumItems=");
                    return C1643a.m824L(sbM833U, this.premiumItems, ")");
                }

                /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
                public Partitioned(Pair<? extends List<? extends MGRecyclerDataPayload>, ? extends List<? extends MGRecyclerDataPayload>> pair) {
                    this(pair.getFirst(), pair.getSecond());
                    C12238m.checkNotNullParameter(pair, "p");
                }
            }

            /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
            public static final /* data */ class Regular extends EmojiItems {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private static final Regular Empty = new Regular(C12147n.emptyList());
                private final List<MGRecyclerDataPayload> items;

                /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
                public static final class Companion {
                    private Companion() {
                    }

                    public final Regular getEmpty() {
                        return Regular.Empty;
                    }

                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public Regular(List<? extends MGRecyclerDataPayload> list) {
                    super(null);
                    C12238m.checkNotNullParameter(list, "items");
                    this.items = list;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Regular copy$default(Regular regular, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = regular.items;
                    }
                    return regular.copy(list);
                }

                public final List<MGRecyclerDataPayload> component1() {
                    return this.items;
                }

                public final Regular copy(List<? extends MGRecyclerDataPayload> items) {
                    C12238m.checkNotNullParameter(items, "items");
                    return new Regular(items);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof Regular) && C12238m.areEqual(this.items, ((Regular) other).items);
                    }
                    return true;
                }

                public final List<MGRecyclerDataPayload> getItems() {
                    return this.items;
                }

                public int hashCode() {
                    List<MGRecyclerDataPayload> list = this.items;
                    if (list != null) {
                        return list.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    return C1643a.m824L(C1643a.m833U("Regular(items="), this.items, ")");
                }
            }

            private EmojiItems() {
            }

            public /* synthetic */ EmojiItems(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        private final EmojiItems buildEmojiListItems(Collection<? extends Emoji> emojis, Function1<? super Long, Guild> getGuild, String searchInputLower, boolean allowEmojisToAnimate, boolean partition, boolean includeUnavailable) {
            if (emojis == null) {
                emojis = C12147n.emptyList();
            }
            Sequence sequenceMapNotNull = C12078q.mapNotNull(C12078q.filter(C12163u.asSequence(emojis), new EmojiPickerViewModel$Companion$buildEmojiListItems$items$1(includeUnavailable)), new EmojiPickerViewModel$Companion$buildEmojiListItems$items$2(searchInputLower, getGuild, allowEmojisToAnimate));
            if (!partition) {
                return new EmojiItems.Regular(C12078q.toList(sequenceMapNotNull));
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : sequenceMapNotNull) {
                if (((WidgetEmojiAdapter.EmojiItem) obj).getEmoji().isUsable()) {
                    arrayList.add(obj);
                } else {
                    arrayList2.add(obj);
                }
            }
            return new EmojiItems.Partitioned(new Pair(arrayList, arrayList2));
        }

        /* JADX WARN: Code duplicated, block: B:6:0x002b  */
        private final EmojiItems buildGuildEmojiListItems(Guild guild, EmojiSet emojiSet, String searchInputLower, boolean allowEmojisToAnimate, boolean partition, boolean includeUnavailable) {
            EmojiItems emojiItemsBuildEmojiListItems;
            if (guild != null) {
                List<Emoji> list = emojiSet.customEmojis.get(Long.valueOf(guild.getId()));
                if (list != null) {
                    emojiItemsBuildEmojiListItems = EmojiPickerViewModel.INSTANCE.buildEmojiListItems(list, new C7813x8d1f8ac3(guild, searchInputLower, allowEmojisToAnimate, partition, includeUnavailable), searchInputLower, allowEmojisToAnimate, partition, includeUnavailable);
                } else {
                    emojiItemsBuildEmojiListItems = null;
                }
            } else {
                emojiItemsBuildEmojiListItems = null;
            }
            if (emojiItemsBuildEmojiListItems != null) {
                return emojiItemsBuildEmojiListItems;
            }
            return partition ? EmojiItems.Partitioned.INSTANCE.getEmpty() : EmojiItems.Regular.INSTANCE.getEmpty();
        }

        private final Observable<StoreEmoji.EmojiContext> getEmojiContextObservable(EmojiPickerContextType emojiPickerContextType, StoreChannelsSelected storeChannelsSelected) {
            if (C12238m.areEqual(emojiPickerContextType, EmojiPickerContextType.Global.INSTANCE)) {
                C12721k c12721k = new C12721k(StoreEmoji.EmojiContext.Global.INSTANCE);
                C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(\n       …ontext.Global\n          )");
                return c12721k;
            }
            if (emojiPickerContextType instanceof EmojiPickerContextType.Guild) {
                C12721k c12721k2 = new C12721k(new StoreEmoji.EmojiContext.Guild(((EmojiPickerContextType.Guild) emojiPickerContextType).getGuildId()));
                C12238m.checkNotNullExpressionValue(c12721k2, "Observable.just(\n       …pe.guildId)\n            )");
                return c12721k2;
            }
            Observable observableM11083G = storeChannelsSelected.observeResolvedSelectedChannel().m11083G(new InterfaceC12589b<StoreChannelsSelected.ResolvedSelectedChannel, StoreEmoji.EmojiContext>() { // from class: com.discord.widgets.chat.input.emoji.EmojiPickerViewModel$Companion$getEmojiContextObservable$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final StoreEmoji.EmojiContext call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                    Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
                    if (channelOrParent == null) {
                        return null;
                    }
                    return new StoreEmoji.EmojiContext.Chat(channelOrParent.getGuildId(), resolvedSelectedChannel.getId());
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "storeChannelsSelected.ob…      }\n                }");
            return observableM11083G;
        }

        public static /* synthetic */ Observable getEmojiContextObservable$default(Companion companion, EmojiPickerContextType emojiPickerContextType, StoreChannelsSelected storeChannelsSelected, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
            }
            return companion.getEmojiContextObservable(emojiPickerContextType, storeChannelsSelected);
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, Observable observable, BehaviorSubject behaviorSubject, BehaviorSubject behaviorSubject2, StoreEmoji storeEmoji, StoreGuildsSorted storeGuildsSorted, StoreUserSettings storeUserSettings, StoreAccessibility storeAccessibility, int i, Object obj) {
            return companion.observeStoreState(observable, behaviorSubject, behaviorSubject2, (i & 8) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji, (i & 16) != 0 ? StoreStream.INSTANCE.getGuildsSorted() : storeGuildsSorted, (i & 32) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 64) != 0 ? StoreStream.INSTANCE.getAccessibility() : storeAccessibility);
        }

        public final Observable<StoreState> observeStoreState(Observable<StoreEmoji.EmojiContext> emojiContextObservable, final BehaviorSubject<String> searchSubject, final BehaviorSubject<Long> selectedCategoryItemIdSubject, final StoreEmoji storeEmoji, final StoreGuildsSorted storeGuildsSorted, final StoreUserSettings storeUserSettings, final StoreAccessibility storeAccessibility) {
            C12238m.checkNotNullParameter(emojiContextObservable, "emojiContextObservable");
            C12238m.checkNotNullParameter(searchSubject, "searchSubject");
            C12238m.checkNotNullParameter(selectedCategoryItemIdSubject, "selectedCategoryItemIdSubject");
            C12238m.checkNotNullParameter(storeEmoji, "storeEmoji");
            C12238m.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
            C12238m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
            C12238m.checkNotNullParameter(storeAccessibility, "storeAccessibility");
            Observable observableM11099Y = emojiContextObservable.m11099Y(new InterfaceC12589b<StoreEmoji.EmojiContext, Observable<? extends StoreState>>() { // from class: com.discord.widgets.chat.input.emoji.EmojiPickerViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends EmojiPickerViewModel.StoreState> call(final StoreEmoji.EmojiContext emojiContext) {
                    return emojiContext == null ? new C12721k(EmojiPickerViewModel.StoreState.Uninitialized.INSTANCE) : Observable.m11071f(storeEmoji.getEmojiSet(emojiContext, true, true), storeGuildsSorted.observeOrderedGuilds(), searchSubject, StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeUserSettings, false, 1, null), storeAccessibility.observeReducedMotionEnabled(), selectedCategoryItemIdSubject, new Func6<EmojiSet, LinkedHashMap<Long, Guild>, String, Boolean, Boolean, Long, EmojiPickerViewModel.StoreState>() { // from class: com.discord.widgets.chat.input.emoji.EmojiPickerViewModel$Companion$observeStoreState$1.1
                        @Override // p658rx.functions.Func6
                        public /* bridge */ /* synthetic */ EmojiPickerViewModel.StoreState call(EmojiSet emojiSet, LinkedHashMap<Long, Guild> linkedHashMap, String str, Boolean bool, Boolean bool2, Long l) {
                            return call(emojiSet, linkedHashMap, str, bool.booleanValue(), bool2.booleanValue(), l.longValue());
                        }

                        public final EmojiPickerViewModel.StoreState call(EmojiSet emojiSet, LinkedHashMap<Long, Guild> linkedHashMap, String str, boolean z2, boolean z3, long j) {
                            C12238m.checkNotNullParameter(linkedHashMap, "allGuilds");
                            C12238m.checkNotNullParameter(str, "searchInputString");
                            if (emojiSet == null) {
                                return EmojiPickerViewModel.StoreState.Uninitialized.INSTANCE;
                            }
                            StoreEmoji.EmojiContext emojiContext2 = emojiContext;
                            boolean z4 = z2 && !z3;
                            Set<Emoji> set = emojiSet.favoriteEmoji;
                            C12238m.checkNotNullExpressionValue(set, "emojiSet.favoriteEmoji");
                            return new EmojiPickerViewModel.StoreState.Emoji(emojiSet, emojiContext2, linkedHashMap, str, z4, j, set);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "emojiContextObservable.s…  )\n          }\n        }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
        public static final /* data */ class ScrollToEmojiListPosition extends Event {
            private final int position;

            public ScrollToEmojiListPosition(int i) {
                super(null);
                this.position = i;
            }

            public static /* synthetic */ ScrollToEmojiListPosition copy$default(ScrollToEmojiListPosition scrollToEmojiListPosition, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = scrollToEmojiListPosition.position;
                }
                return scrollToEmojiListPosition.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getPosition() {
                return this.position;
            }

            public final ScrollToEmojiListPosition copy(int position) {
                return new ScrollToEmojiListPosition(position);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ScrollToEmojiListPosition) && this.position == ((ScrollToEmojiListPosition) other).position;
                }
                return true;
            }

            public final int getPosition() {
                return this.position;
            }

            public int hashCode() {
                return this.position;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("ScrollToEmojiListPosition(position="), this.position, ")");
            }
        }

        /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
        public static final /* data */ class ShowPremiumUpsellDialog extends Event {
            private final int body;
            private final int header;
            private final int pageNumber;
            private final String sectionName;
            private final boolean showLearnMore;
            private final boolean showOtherPages;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowPremiumUpsellDialog(int i, @StringRes int i2, @StringRes int i3, String str, boolean z2, boolean z3) {
                super(null);
                C12238m.checkNotNullParameter(str, "sectionName");
                this.pageNumber = i;
                this.header = i2;
                this.body = i3;
                this.sectionName = str;
                this.showOtherPages = z2;
                this.showLearnMore = z3;
            }

            public static /* synthetic */ ShowPremiumUpsellDialog copy$default(ShowPremiumUpsellDialog showPremiumUpsellDialog, int i, int i2, int i3, String str, boolean z2, boolean z3, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i = showPremiumUpsellDialog.pageNumber;
                }
                if ((i4 & 2) != 0) {
                    i2 = showPremiumUpsellDialog.header;
                }
                int i5 = i2;
                if ((i4 & 4) != 0) {
                    i3 = showPremiumUpsellDialog.body;
                }
                int i6 = i3;
                if ((i4 & 8) != 0) {
                    str = showPremiumUpsellDialog.sectionName;
                }
                String str2 = str;
                if ((i4 & 16) != 0) {
                    z2 = showPremiumUpsellDialog.showOtherPages;
                }
                boolean z4 = z2;
                if ((i4 & 32) != 0) {
                    z3 = showPremiumUpsellDialog.showLearnMore;
                }
                return showPremiumUpsellDialog.copy(i, i5, i6, str2, z4, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getPageNumber() {
                return this.pageNumber;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getHeader() {
                return this.header;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getBody() {
                return this.body;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getSectionName() {
                return this.sectionName;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getShowOtherPages() {
                return this.showOtherPages;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getShowLearnMore() {
                return this.showLearnMore;
            }

            public final ShowPremiumUpsellDialog copy(int pageNumber, @StringRes int header, @StringRes int body, String sectionName, boolean showOtherPages, boolean showLearnMore) {
                C12238m.checkNotNullParameter(sectionName, "sectionName");
                return new ShowPremiumUpsellDialog(pageNumber, header, body, sectionName, showOtherPages, showLearnMore);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowPremiumUpsellDialog)) {
                    return false;
                }
                ShowPremiumUpsellDialog showPremiumUpsellDialog = (ShowPremiumUpsellDialog) other;
                return this.pageNumber == showPremiumUpsellDialog.pageNumber && this.header == showPremiumUpsellDialog.header && this.body == showPremiumUpsellDialog.body && C12238m.areEqual(this.sectionName, showPremiumUpsellDialog.sectionName) && this.showOtherPages == showPremiumUpsellDialog.showOtherPages && this.showLearnMore == showPremiumUpsellDialog.showLearnMore;
            }

            public final int getBody() {
                return this.body;
            }

            public final int getHeader() {
                return this.header;
            }

            public final int getPageNumber() {
                return this.pageNumber;
            }

            public final String getSectionName() {
                return this.sectionName;
            }

            public final boolean getShowLearnMore() {
                return this.showLearnMore;
            }

            public final boolean getShowOtherPages() {
                return this.showOtherPages;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                int i = ((((this.pageNumber * 31) + this.header) * 31) + this.body) * 31;
                String str = this.sectionName;
                int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.showOtherPages;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i2 = (iHashCode + r1) * 31;
                boolean z3 = this.showLearnMore;
                return i2 + (z3 ? 1 : z3);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ShowPremiumUpsellDialog(pageNumber=");
                sbM833U.append(this.pageNumber);
                sbM833U.append(", header=");
                sbM833U.append(this.header);
                sbM833U.append(", body=");
                sbM833U.append(this.body);
                sbM833U.append(", sectionName=");
                sbM833U.append(this.sectionName);
                sbM833U.append(", showOtherPages=");
                sbM833U.append(this.showOtherPages);
                sbM833U.append(", showLearnMore=");
                return C1643a.m827O(sbM833U, this.showLearnMore, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
    public static final class Inline extends EmojiPickerViewModel {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Inline(EmojiPickerContextType emojiPickerContextType, Locale locale) {
            super(emojiPickerContextType, locale, null, null, null, null, 60, null);
            C12238m.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
            C12238m.checkNotNullParameter(locale, "locale");
        }
    }

    /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
    public static final class Sheet extends EmojiPickerViewModel {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Sheet(EmojiPickerContextType emojiPickerContextType, Locale locale) {
            super(emojiPickerContextType, locale, null, null, null, null, 60, null);
            C12238m.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
            C12238m.checkNotNullParameter(locale, "locale");
        }
    }

    /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
        public static final /* data */ class Emoji extends StoreState {
            private final LinkedHashMap<Long, Guild> allGuilds;
            private final boolean allowEmojisToAnimate;
            private final StoreEmoji.EmojiContext emojiContext;
            private final EmojiSet emojiSet;
            private final Set<com.discord.models.domain.emoji.Emoji> favoriteEmoji;
            private final String searchInputStringUpper;
            private final long selectedCategoryItemId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Emoji(EmojiSet emojiSet, StoreEmoji.EmojiContext emojiContext, LinkedHashMap<Long, Guild> linkedHashMap, String str, boolean z2, long j, Set<? extends com.discord.models.domain.emoji.Emoji> set) {
                super(null);
                C12238m.checkNotNullParameter(emojiSet, "emojiSet");
                C12238m.checkNotNullParameter(emojiContext, "emojiContext");
                C12238m.checkNotNullParameter(linkedHashMap, "allGuilds");
                C12238m.checkNotNullParameter(str, "searchInputStringUpper");
                C12238m.checkNotNullParameter(set, "favoriteEmoji");
                this.emojiSet = emojiSet;
                this.emojiContext = emojiContext;
                this.allGuilds = linkedHashMap;
                this.searchInputStringUpper = str;
                this.allowEmojisToAnimate = z2;
                this.selectedCategoryItemId = j;
                this.favoriteEmoji = set;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final EmojiSet getEmojiSet() {
                return this.emojiSet;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final StoreEmoji.EmojiContext getEmojiContext() {
                return this.emojiContext;
            }

            public final LinkedHashMap<Long, Guild> component3() {
                return this.allGuilds;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getSearchInputStringUpper() {
                return this.searchInputStringUpper;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getAllowEmojisToAnimate() {
                return this.allowEmojisToAnimate;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final long getSelectedCategoryItemId() {
                return this.selectedCategoryItemId;
            }

            public final Set<com.discord.models.domain.emoji.Emoji> component7() {
                return this.favoriteEmoji;
            }

            public final Emoji copy(EmojiSet emojiSet, StoreEmoji.EmojiContext emojiContext, LinkedHashMap<Long, Guild> allGuilds, String searchInputStringUpper, boolean allowEmojisToAnimate, long selectedCategoryItemId, Set<? extends com.discord.models.domain.emoji.Emoji> favoriteEmoji) {
                C12238m.checkNotNullParameter(emojiSet, "emojiSet");
                C12238m.checkNotNullParameter(emojiContext, "emojiContext");
                C12238m.checkNotNullParameter(allGuilds, "allGuilds");
                C12238m.checkNotNullParameter(searchInputStringUpper, "searchInputStringUpper");
                C12238m.checkNotNullParameter(favoriteEmoji, "favoriteEmoji");
                return new Emoji(emojiSet, emojiContext, allGuilds, searchInputStringUpper, allowEmojisToAnimate, selectedCategoryItemId, favoriteEmoji);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Emoji)) {
                    return false;
                }
                Emoji emoji = (Emoji) other;
                return C12238m.areEqual(this.emojiSet, emoji.emojiSet) && C12238m.areEqual(this.emojiContext, emoji.emojiContext) && C12238m.areEqual(this.allGuilds, emoji.allGuilds) && C12238m.areEqual(this.searchInputStringUpper, emoji.searchInputStringUpper) && this.allowEmojisToAnimate == emoji.allowEmojisToAnimate && this.selectedCategoryItemId == emoji.selectedCategoryItemId && C12238m.areEqual(this.favoriteEmoji, emoji.favoriteEmoji);
            }

            public final LinkedHashMap<Long, Guild> getAllGuilds() {
                return this.allGuilds;
            }

            public final boolean getAllowEmojisToAnimate() {
                return this.allowEmojisToAnimate;
            }

            public final StoreEmoji.EmojiContext getEmojiContext() {
                return this.emojiContext;
            }

            public final EmojiSet getEmojiSet() {
                return this.emojiSet;
            }

            public final Set<com.discord.models.domain.emoji.Emoji> getFavoriteEmoji() {
                return this.favoriteEmoji;
            }

            public final String getSearchInputStringUpper() {
                return this.searchInputStringUpper;
            }

            public final long getSelectedCategoryItemId() {
                return this.selectedCategoryItemId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r2v10, types: [int] */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r2v20 */
            public int hashCode() {
                EmojiSet emojiSet = this.emojiSet;
                int iHashCode = (emojiSet != null ? emojiSet.hashCode() : 0) * 31;
                StoreEmoji.EmojiContext emojiContext = this.emojiContext;
                int iHashCode2 = (iHashCode + (emojiContext != null ? emojiContext.hashCode() : 0)) * 31;
                LinkedHashMap<Long, Guild> linkedHashMap = this.allGuilds;
                int iHashCode3 = (iHashCode2 + (linkedHashMap != null ? linkedHashMap.hashCode() : 0)) * 31;
                String str = this.searchInputStringUpper;
                int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.allowEmojisToAnimate;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int iM3a = (C0002b.m3a(this.selectedCategoryItemId) + ((iHashCode4 + r2) * 31)) * 31;
                Set<com.discord.models.domain.emoji.Emoji> set = this.favoriteEmoji;
                return iM3a + (set != null ? set.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Emoji(emojiSet=");
                sbM833U.append(this.emojiSet);
                sbM833U.append(", emojiContext=");
                sbM833U.append(this.emojiContext);
                sbM833U.append(", allGuilds=");
                sbM833U.append(this.allGuilds);
                sbM833U.append(", searchInputStringUpper=");
                sbM833U.append(this.searchInputStringUpper);
                sbM833U.append(", allowEmojisToAnimate=");
                sbM833U.append(this.allowEmojisToAnimate);
                sbM833U.append(", selectedCategoryItemId=");
                sbM833U.append(this.selectedCategoryItemId);
                sbM833U.append(", favoriteEmoji=");
                return C1643a.m826N(sbM833U, this.favoriteEmoji, ")");
            }
        }

        /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
        public static final class Uninitialized extends StoreState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
    public static abstract class ViewState {
        private final String searchQuery;

        /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
        public static final /* data */ class EmptySearch extends ViewState {
            private final String searchQuery;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmptySearch(String str) {
                super(str, null);
                C12238m.checkNotNullParameter(str, "searchQuery");
                this.searchQuery = str;
            }

            public static /* synthetic */ EmptySearch copy$default(EmptySearch emptySearch, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = emptySearch.getSearchQuery();
                }
                return emptySearch.copy(str);
            }

            public final String component1() {
                return getSearchQuery();
            }

            public final EmptySearch copy(String searchQuery) {
                C12238m.checkNotNullParameter(searchQuery, "searchQuery");
                return new EmptySearch(searchQuery);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof EmptySearch) && C12238m.areEqual(getSearchQuery(), ((EmptySearch) other).getSearchQuery());
                }
                return true;
            }

            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerViewModel.ViewState
            public String getSearchQuery() {
                return this.searchQuery;
            }

            public int hashCode() {
                String searchQuery = getSearchQuery();
                if (searchQuery != null) {
                    return searchQuery.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("EmptySearch(searchQuery=");
                sbM833U.append(getSearchQuery());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: EmojiPickerViewModel.kt */
        public static final /* data */ class Results extends ViewState {
            private final List<EmojiCategoryItem> categoryItems;

            /* JADX INFO: renamed from: firstUnicodeEmojiCategoryItem$delegate, reason: from kotlin metadata */
            private final Lazy firstUnicodeEmojiCategoryItem;
            private final List<MGRecyclerDataPayload> resultItems;
            private final String searchQuery;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Results(String str, List<? extends MGRecyclerDataPayload> list, List<? extends EmojiCategoryItem> list2) {
                super(str, null);
                C12238m.checkNotNullParameter(str, "searchQuery");
                C12238m.checkNotNullParameter(list, "resultItems");
                C12238m.checkNotNullParameter(list2, "categoryItems");
                this.searchQuery = str;
                this.resultItems = list;
                this.categoryItems = list2;
                this.firstUnicodeEmojiCategoryItem = C12083g.lazy(new C7815xf92f8d5e(this));
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Results copy$default(Results results, String str, List list, List list2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = results.getSearchQuery();
                }
                if ((i & 2) != 0) {
                    list = results.resultItems;
                }
                if ((i & 4) != 0) {
                    list2 = results.categoryItems;
                }
                return results.copy(str, list, list2);
            }

            public final String component1() {
                return getSearchQuery();
            }

            public final List<MGRecyclerDataPayload> component2() {
                return this.resultItems;
            }

            public final List<EmojiCategoryItem> component3() {
                return this.categoryItems;
            }

            public final Results copy(String searchQuery, List<? extends MGRecyclerDataPayload> resultItems, List<? extends EmojiCategoryItem> categoryItems) {
                C12238m.checkNotNullParameter(searchQuery, "searchQuery");
                C12238m.checkNotNullParameter(resultItems, "resultItems");
                C12238m.checkNotNullParameter(categoryItems, "categoryItems");
                return new Results(searchQuery, resultItems, categoryItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Results)) {
                    return false;
                }
                Results results = (Results) other;
                return C12238m.areEqual(getSearchQuery(), results.getSearchQuery()) && C12238m.areEqual(this.resultItems, results.resultItems) && C12238m.areEqual(this.categoryItems, results.categoryItems);
            }

            public final List<EmojiCategoryItem> getCategoryItems() {
                return this.categoryItems;
            }

            public final EmojiCategoryItem.StandardItem getFirstUnicodeEmojiCategoryItem() {
                return (EmojiCategoryItem.StandardItem) this.firstUnicodeEmojiCategoryItem.getValue();
            }

            public final List<MGRecyclerDataPayload> getResultItems() {
                return this.resultItems;
            }

            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerViewModel.ViewState
            public String getSearchQuery() {
                return this.searchQuery;
            }

            public final boolean getShowBottomBar() {
                return getSearchQuery().length() == 0;
            }

            public int hashCode() {
                String searchQuery = getSearchQuery();
                int iHashCode = (searchQuery != null ? searchQuery.hashCode() : 0) * 31;
                List<MGRecyclerDataPayload> list = this.resultItems;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                List<EmojiCategoryItem> list2 = this.categoryItems;
                return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Results(searchQuery=");
                sbM833U.append(getSearchQuery());
                sbM833U.append(", resultItems=");
                sbM833U.append(this.resultItems);
                sbM833U.append(", categoryItems=");
                return C1643a.m824L(sbM833U, this.categoryItems, ")");
            }
        }

        private ViewState(String str) {
            this.searchQuery = str;
        }

        public String getSearchQuery() {
            return this.searchQuery;
        }

        public /* synthetic */ ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ EmojiPickerViewModel(EmojiPickerContextType emojiPickerContextType, Locale locale, BehaviorSubject behaviorSubject, BehaviorSubject behaviorSubject2, Observable observable, StoreAnalytics storeAnalytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubjectM11130l0;
        BehaviorSubject behaviorSubjectM11130l1;
        Observable observableObserveStoreState$default;
        if ((i & 4) != 0) {
            behaviorSubjectM11130l0 = BehaviorSubject.m11130l0("");
            C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(\"\")");
        } else {
            behaviorSubjectM11130l0 = behaviorSubject;
        }
        if ((i & 8) != 0) {
            behaviorSubjectM11130l1 = BehaviorSubject.m11130l0(Long.valueOf(EmojiCategoryItem.INSTANCE.mapEmojiCategoryToItemId(EmojiCategory.FAVORITE)));
            C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l1, "BehaviorSubject.create(\n…ojiCategory.FAVORITE)\n  )");
        } else {
            behaviorSubjectM11130l1 = behaviorSubject2;
        }
        if ((i & 16) != 0) {
            Companion companion = INSTANCE;
            observableObserveStoreState$default = Companion.observeStoreState$default(companion, Companion.getEmojiContextObservable$default(companion, emojiPickerContextType, null, 2, null), behaviorSubjectM11130l0, behaviorSubjectM11130l1, null, null, null, null, 120, null);
        } else {
            observableObserveStoreState$default = observable;
        }
        this(emojiPickerContextType, locale, behaviorSubjectM11130l0, behaviorSubjectM11130l1, observableObserveStoreState$default, (i & 32) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        List listMinus;
        EmojiPickerViewModel emojiPickerViewModel;
        LinkedHashMap<Long, Guild> linkedHashMap;
        int i;
        EmojiCategory emojiCategory;
        if (storeState instanceof StoreState.Emoji) {
            StoreState.Emoji emoji = (StoreState.Emoji) storeState;
            EmojiSet emojiSet = emoji.getEmojiSet();
            long selectedCategoryItemId = emoji.getSelectedCategoryItemId();
            boolean allowEmojisToAnimate = emoji.getAllowEmojisToAnimate();
            String searchInputStringUpper = emoji.getSearchInputStringUpper();
            Locale locale = this.locale;
            Objects.requireNonNull(searchInputStringUpper, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = searchInputStringUpper.toLowerCase(locale);
            C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            boolean z2 = lowerCase.length() > 0;
            ArrayList arrayList = new ArrayList();
            LinkedHashMap<Long, Guild> allGuilds = emoji.getAllGuilds();
            Collection<Guild> collectionValues = emoji.getAllGuilds().values();
            C12238m.checkNotNullExpressionValue(collectionValues, "storeState.allGuilds.values");
            List list = C12163u.toList(collectionValues);
            Collection<MGRecyclerDataPayload> linkedHashSet = z2 ? new LinkedHashSet() : new ArrayList();
            Collection linkedHashSet2 = z2 ? new LinkedHashSet() : new ArrayList();
            boolean z3 = !z2;
            Companion companion = INSTANCE;
            LinkedHashMap<Long, Guild> linkedHashMap2 = allGuilds;
            Companion.EmojiItems emojiItemsBuildEmojiListItems = companion.buildEmojiListItems(emoji.getFavoriteEmoji(), new EmojiPickerViewModel$handleStoreState$favoriteItems$1(allGuilds), lowerCase, allowEmojisToAnimate, z2, z3);
            if (emojiItemsBuildEmojiListItems instanceof Companion.EmojiItems.Partitioned) {
                Companion.EmojiItems.Partitioned partitioned = (Companion.EmojiItems.Partitioned) emojiItemsBuildEmojiListItems;
                linkedHashSet.addAll(partitioned.getRegularItems());
                linkedHashSet2.addAll(partitioned.getPremiumItems());
            } else if (emojiItemsBuildEmojiListItems instanceof Companion.EmojiItems.Regular) {
                Companion.EmojiItems.Regular regular = (Companion.EmojiItems.Regular) emojiItemsBuildEmojiListItems;
                if (!regular.getItems().isEmpty()) {
                    int size = linkedHashSet.size();
                    if (!z2) {
                        linkedHashSet.add(new WidgetEmojiAdapter.HeaderItem.StandardHeaderItem(EmojiCategory.FAVORITE));
                    }
                    linkedHashSet.addAll(regular.getItems());
                    EmojiCategoryItem.Companion companion2 = EmojiCategoryItem.INSTANCE;
                    EmojiCategory emojiCategory2 = EmojiCategory.FAVORITE;
                    arrayList.add(new EmojiCategoryItem.StandardItem(emojiCategory2, new Pair(Integer.valueOf(size), Integer.valueOf(linkedHashSet.size())), companion2.mapEmojiCategoryToItemId(emojiCategory2) == selectedCategoryItemId));
                }
            }
            Companion.EmojiItems emojiItemsBuildEmojiListItems2 = companion.buildEmojiListItems(emojiSet.recentEmojis, new EmojiPickerViewModel$handleStoreState$frequentItems$1(linkedHashMap2), lowerCase, allowEmojisToAnimate, z2, z3);
            if (emojiItemsBuildEmojiListItems2 instanceof Companion.EmojiItems.Partitioned) {
                Companion.EmojiItems.Partitioned partitioned2 = (Companion.EmojiItems.Partitioned) emojiItemsBuildEmojiListItems2;
                linkedHashSet.addAll(partitioned2.getRegularItems());
                linkedHashSet2.addAll(partitioned2.getPremiumItems());
            } else if (emojiItemsBuildEmojiListItems2 instanceof Companion.EmojiItems.Regular) {
                Companion.EmojiItems.Regular regular2 = (Companion.EmojiItems.Regular) emojiItemsBuildEmojiListItems2;
                if (!regular2.getItems().isEmpty()) {
                    int size2 = linkedHashSet.size();
                    if (!z2) {
                        linkedHashSet.add(new WidgetEmojiAdapter.HeaderItem.StandardHeaderItem(EmojiCategory.RECENT));
                    }
                    linkedHashSet.addAll(regular2.getItems());
                    EmojiCategoryItem.Companion companion3 = EmojiCategoryItem.INSTANCE;
                    EmojiCategory emojiCategory3 = EmojiCategory.RECENT;
                    arrayList.add(new EmojiCategoryItem.StandardItem(emojiCategory3, new Pair(Integer.valueOf(size2), Integer.valueOf(linkedHashSet.size())), companion3.mapEmojiCategoryToItemId(emojiCategory3) == selectedCategoryItemId));
                }
            }
            StoreEmoji.EmojiContext emojiContext = emoji.getEmojiContext();
            long guildId = emojiContext instanceof StoreEmoji.EmojiContext.Chat ? ((StoreEmoji.EmojiContext.Chat) emojiContext).getGuildId() : 0L;
            Guild guild = emoji.getAllGuilds().get(Long.valueOf(guildId));
            List<Emoji> list2 = emojiSet.customEmojis.get(Long.valueOf(guildId));
            if (guild == null || list2 == null || !(!list2.isEmpty())) {
                listMinus = list;
            } else {
                Companion.EmojiItems emojiItemsBuildGuildEmojiListItems = companion.buildGuildEmojiListItems(guild, emojiSet, lowerCase, allowEmojisToAnimate, z2, z3);
                if (emojiItemsBuildGuildEmojiListItems instanceof Companion.EmojiItems.Partitioned) {
                    Companion.EmojiItems.Partitioned partitioned3 = (Companion.EmojiItems.Partitioned) emojiItemsBuildGuildEmojiListItems;
                    linkedHashSet.addAll(partitioned3.getRegularItems());
                    linkedHashSet2.addAll(partitioned3.getPremiumItems());
                } else if (emojiItemsBuildGuildEmojiListItems instanceof Companion.EmojiItems.Regular) {
                    Companion.EmojiItems.Regular regular3 = (Companion.EmojiItems.Regular) emojiItemsBuildGuildEmojiListItems;
                    if (!regular3.getItems().isEmpty()) {
                        int size3 = linkedHashSet.size();
                        if (!z2) {
                            linkedHashSet.add(new WidgetEmojiAdapter.HeaderItem.GuildHeaderItem(guild));
                        }
                        linkedHashSet.addAll(regular3.getItems());
                        arrayList.add(new EmojiCategoryItem.GuildItem(guild, new Pair(Integer.valueOf(size3), Integer.valueOf(linkedHashSet.size())), EmojiCategoryItem.INSTANCE.mapGuildToItemId(guild) == selectedCategoryItemId));
                    }
                }
                listMinus = C12163u.minus(list, guild);
            }
            Iterator it = listMinus.iterator();
            while (it.hasNext()) {
                Guild guild2 = (Guild) it.next();
                Iterator it2 = it;
                Companion.EmojiItems emojiItemsBuildGuildEmojiListItems2 = INSTANCE.buildGuildEmojiListItems(guild2, emojiSet, lowerCase, allowEmojisToAnimate, z2, z3);
                if (emojiItemsBuildGuildEmojiListItems2 instanceof Companion.EmojiItems.Partitioned) {
                    Companion.EmojiItems.Partitioned partitioned4 = (Companion.EmojiItems.Partitioned) emojiItemsBuildGuildEmojiListItems2;
                    linkedHashSet.addAll(partitioned4.getRegularItems());
                    linkedHashSet2.addAll(partitioned4.getPremiumItems());
                } else if (emojiItemsBuildGuildEmojiListItems2 instanceof Companion.EmojiItems.Regular) {
                    Companion.EmojiItems.Regular regular4 = (Companion.EmojiItems.Regular) emojiItemsBuildGuildEmojiListItems2;
                    if (!regular4.getItems().isEmpty()) {
                        int size4 = linkedHashSet.size();
                        if (!z2) {
                            C12238m.checkNotNullExpressionValue(guild2, "guild");
                            linkedHashSet.add(new WidgetEmojiAdapter.HeaderItem.GuildHeaderItem(guild2));
                        }
                        linkedHashSet.addAll(regular4.getItems());
                        EmojiCategoryItem.Companion companion4 = EmojiCategoryItem.INSTANCE;
                        C12238m.checkNotNullExpressionValue(guild2, "guild");
                        arrayList.add(new EmojiCategoryItem.GuildItem(guild2, new Pair(Integer.valueOf(size4), Integer.valueOf(linkedHashSet.size())), companion4.mapGuildToItemId(guild2) == selectedCategoryItemId));
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
                    Companion.EmojiItems emojiItemsBuildEmojiListItems3 = INSTANCE.buildEmojiListItems(map.get(emojiCategory4), new EmojiPickerViewModel$handleStoreState$unicodeCategoryItems$1(linkedHashMap3), lowerCase, allowEmojisToAnimate, false, false);
                    if (emojiItemsBuildEmojiListItems3 instanceof Companion.EmojiItems.Regular) {
                        Companion.EmojiItems.Regular regular5 = (Companion.EmojiItems.Regular) emojiItemsBuildEmojiListItems3;
                        if (!regular5.getItems().isEmpty()) {
                            if (z2) {
                                emojiCategory = emojiCategory4;
                            } else {
                                emojiCategory = emojiCategory4;
                                linkedHashSet.add(new WidgetEmojiAdapter.HeaderItem.StandardHeaderItem(emojiCategory));
                            }
                            linkedHashSet.addAll(regular5.getItems());
                            arrayList.add(new EmojiCategoryItem.StandardItem(emojiCategory, new Pair(Integer.valueOf(size5), Integer.valueOf(linkedHashSet.size())), EmojiCategoryItem.INSTANCE.mapEmojiCategoryToItemId(emojiCategory) == selectedCategoryItemId));
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
                linkedHashSet.add(new WidgetEmojiAdapter.HeaderItem.StringHeaderItem(C5419R.string.emoji_available_with_premium));
                linkedHashSet.addAll(linkedHashSet2);
                linkedHashSet.add(WidgetEmojiAdapter.UpsellItem.INSTANCE);
            }
            if (z2) {
                emojiPickerViewModel = this;
                emojiPickerViewModel.logWhenUpsellHeaderIsViewed = true;
                int i4 = 0;
                int i5 = 0;
                for (MGRecyclerDataPayload mGRecyclerDataPayload : linkedHashSet) {
                    if (mGRecyclerDataPayload instanceof WidgetEmojiAdapter.EmojiItem) {
                        i4++;
                        if (!((WidgetEmojiAdapter.EmojiItem) mGRecyclerDataPayload).getEmoji().isUsable()) {
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
                emojiPickerViewModel.updateViewState(new ViewState.EmptySearch(emoji.getSearchInputStringUpper()));
                return;
            }
            List list3 = (List) (!(linkedHashSet instanceof List) ? null : linkedHashSet);
            if (list3 == null) {
                list3 = C12163u.toList(linkedHashSet);
            }
            emojiPickerViewModel.updateViewState(new ViewState.Results(emoji.getSearchInputStringUpper(), list3, arrayList));
        }
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    public final void onClickUnicodeEmojiCategories() {
        EmojiCategoryItem.StandardItem firstUnicodeEmojiCategoryItem;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Results)) {
            viewState = null;
        }
        ViewState.Results results = (ViewState.Results) viewState;
        if (results == null || (firstUnicodeEmojiCategoryItem = results.getFirstUnicodeEmojiCategoryItem()) == null) {
            return;
        }
        setSelectedCategoryItemId(firstUnicodeEmojiCategoryItem.getStableId());
        this.eventSubject.f27650k.onNext(new Event.ScrollToEmojiListPosition(firstUnicodeEmojiCategoryItem.getCategoryRange().getFirst().intValue()));
    }

    public final void onEmojiSelected(Emoji emoji, Function1<? super Emoji, Unit> validEmojiSelected) {
        int i;
        C12238m.checkNotNullParameter(emoji, "emoji");
        C12238m.checkNotNullParameter(validEmojiSelected, "validEmojiSelected");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Results)) {
            viewState = null;
        }
        ViewState.Results results = (ViewState.Results) viewState;
        List<MGRecyclerDataPayload> resultItems = results != null ? results.getResultItems() : null;
        if (resultItems == null) {
            resultItems = C12147n.emptyList();
        }
        boolean z2 = false;
        if ((resultItems instanceof Collection) && resultItems.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = resultItems.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if ((((MGRecyclerDataPayload) it.next()) instanceof WidgetEmojiAdapter.EmojiItem) && (i2 = i2 + 1) < 0) {
                    C12147n.throwCountOverflow();
                }
            }
            i = i2;
        }
        StoreAnalytics storeAnalytics = this.storeAnalytics;
        StoreAnalytics.trackSearchResultSelected$default(storeAnalytics, SearchType.EMOJI, i, Traits.Location.copy$default(storeAnalytics.getEmojiPickerUpsellLocation(), null, null, "Search Result", null, null, 27, null), null, 8, null);
        if (emoji.isUsable()) {
            if (emoji.isAvailable()) {
                validEmojiSelected.invoke(emoji);
            }
        } else {
            if ((emoji instanceof ModelEmojiCustom) && ((ModelEmojiCustom) emoji).isAnimated()) {
                z2 = true;
            }
            this.eventSubject.f27650k.onNext(new Event.ShowPremiumUpsellDialog(z2 ? 2 : 1, z2 ? C5419R.string.premium_upsell_animated_emojis_active_mobile : C5419R.string.premium_upsell_emoji_active_mobile, z2 ? C5419R.string.premium_upsell_animated_emojis_description_mobile : C5419R.string.premium_upsell_emoji_description_mobile, Traits.Location.Section.EMOJI_PICKER_POPOUT, false, false));
            this.storeAnalytics.emojiPickerUpsellLockedItemClicked(this.emojiPickerContextType, z2);
        }
    }

    public final void onUpsellHeaderVisible() {
        this.storeAnalytics.emojiPickerUpsellHeaderViewed(this.emojiPickerContextType);
        this.logWhenUpsellHeaderIsViewed = false;
    }

    public final void setSearchText(String searchText) {
        C12238m.checkNotNullParameter(searchText, "searchText");
        this.searchSubject.onNext(searchText);
        StoreAnalytics storeAnalytics = this.storeAnalytics;
        storeAnalytics.trackSearchStarted(SearchType.EMOJI, storeAnalytics.getEmojiPickerUpsellLocation(), true);
    }

    public final void setSelectedCategoryItemId(long categoryId) {
        this.selectedCategoryItemIdSubject.onNext(Long.valueOf(categoryId));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel(EmojiPickerContextType emojiPickerContextType, Locale locale, BehaviorSubject<String> behaviorSubject, BehaviorSubject<Long> behaviorSubject2, Observable<StoreState> observable, StoreAnalytics storeAnalytics) {
        super(null);
        C12238m.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        C12238m.checkNotNullParameter(locale, "locale");
        C12238m.checkNotNullParameter(behaviorSubject, "searchSubject");
        C12238m.checkNotNullParameter(behaviorSubject2, "selectedCategoryItemIdSubject");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        C12238m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        this.emojiPickerContextType = emojiPickerContextType;
        this.locale = locale;
        this.searchSubject = behaviorSubject;
        this.selectedCategoryItemIdSubject = behaviorSubject2;
        this.storeAnalytics = storeAnalytics;
        PublishSubject<Event> publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.eventSubject = publishSubjectM11133k0;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78121());
    }
}
