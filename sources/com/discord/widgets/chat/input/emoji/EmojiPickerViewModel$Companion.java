package com.discord.widgets.chat.input.emoji;

import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreEmoji$EmojiContext;
import com.discord.stores.StoreEmoji$EmojiContext$Global;
import com.discord.stores.StoreEmoji$EmojiContext$Guild;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import d0.f0.q;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion {
    private EmojiPickerViewModel$Companion() {
    }

    public static final /* synthetic */ EmojiPickerViewModel$Companion$EmojiItems access$buildEmojiListItems(EmojiPickerViewModel$Companion emojiPickerViewModel$Companion, Collection collection, Function1 function1, String str, boolean z2, boolean z3, boolean z4) {
        return emojiPickerViewModel$Companion.buildEmojiListItems(collection, function1, str, z2, z3, z4);
    }

    public static final /* synthetic */ EmojiPickerViewModel$Companion$EmojiItems access$buildGuildEmojiListItems(EmojiPickerViewModel$Companion emojiPickerViewModel$Companion, Guild guild, EmojiSet emojiSet, String str, boolean z2, boolean z3, boolean z4) {
        return emojiPickerViewModel$Companion.buildGuildEmojiListItems(guild, emojiSet, str, z2, z3, z4);
    }

    private final EmojiPickerViewModel$Companion$EmojiItems buildEmojiListItems(Collection<? extends Emoji> emojis, Function1<? super Long, Guild> getGuild, String searchInputLower, boolean allowEmojisToAnimate, boolean partition, boolean includeUnavailable) {
        if (emojis == null) {
            emojis = n.emptyList();
        }
        Sequence sequenceMapNotNull = q.mapNotNull(q.filter(u.asSequence(emojis), new EmojiPickerViewModel$Companion$buildEmojiListItems$items$1(includeUnavailable)), new EmojiPickerViewModel$Companion$buildEmojiListItems$items$2(searchInputLower, getGuild, allowEmojisToAnimate));
        if (!partition) {
            return new EmojiPickerViewModel$Companion$EmojiItems$Regular(q.toList(sequenceMapNotNull));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : sequenceMapNotNull) {
            if (((WidgetEmojiAdapter$EmojiItem) obj).getEmoji().isUsable()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        return new EmojiPickerViewModel$Companion$EmojiItems$Partitioned(new Pair(arrayList, arrayList2));
    }

    /* JADX WARN: Code duplicated, block: B:6:0x002b  */
    private final EmojiPickerViewModel$Companion$EmojiItems buildGuildEmojiListItems(Guild guild, EmojiSet emojiSet, String searchInputLower, boolean allowEmojisToAnimate, boolean partition, boolean includeUnavailable) {
        EmojiPickerViewModel$Companion$EmojiItems emojiPickerViewModel$Companion$EmojiItemsBuildEmojiListItems;
        if (guild != null) {
            List<Emoji> list = emojiSet.customEmojis.get(Long.valueOf(guild.getId()));
            if (list != null) {
                emojiPickerViewModel$Companion$EmojiItemsBuildEmojiListItems = EmojiPickerViewModel.Companion.buildEmojiListItems(list, new EmojiPickerViewModel$Companion$buildGuildEmojiListItems$$inlined$let$lambda$1(guild, searchInputLower, allowEmojisToAnimate, partition, includeUnavailable), searchInputLower, allowEmojisToAnimate, partition, includeUnavailable);
            } else {
                emojiPickerViewModel$Companion$EmojiItemsBuildEmojiListItems = null;
            }
        } else {
            emojiPickerViewModel$Companion$EmojiItemsBuildEmojiListItems = null;
        }
        if (emojiPickerViewModel$Companion$EmojiItemsBuildEmojiListItems != null) {
            return emojiPickerViewModel$Companion$EmojiItemsBuildEmojiListItems;
        }
        return partition ? EmojiPickerViewModel$Companion$EmojiItems$Partitioned.Companion.getEmpty() : EmojiPickerViewModel$Companion$EmojiItems$Regular.Companion.getEmpty();
    }

    private final Observable<StoreEmoji$EmojiContext> getEmojiContextObservable(EmojiPickerContextType emojiPickerContextType, StoreChannelsSelected storeChannelsSelected) {
        if (m.areEqual(emojiPickerContextType, EmojiPickerContextType$Global.INSTANCE)) {
            k kVar = new k(StoreEmoji$EmojiContext$Global.INSTANCE);
            m.checkNotNullExpressionValue(kVar, "Observable.just(\n       …ontext.Global\n          )");
            return kVar;
        }
        if (emojiPickerContextType instanceof EmojiPickerContextType$Guild) {
            k kVar2 = new k(new StoreEmoji$EmojiContext$Guild(((EmojiPickerContextType$Guild) emojiPickerContextType).getGuildId()));
            m.checkNotNullExpressionValue(kVar2, "Observable.just(\n       …pe.guildId)\n            )");
            return kVar2;
        }
        Observable observableG = storeChannelsSelected.observeResolvedSelectedChannel().G(EmojiPickerViewModel$Companion$getEmojiContextObservable$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "storeChannelsSelected.ob…      }\n                }");
        return observableG;
    }

    public static /* synthetic */ Observable getEmojiContextObservable$default(EmojiPickerViewModel$Companion emojiPickerViewModel$Companion, EmojiPickerContextType emojiPickerContextType, StoreChannelsSelected storeChannelsSelected, int i, Object obj) {
        if ((i & 2) != 0) {
            storeChannelsSelected = StoreStream.Companion.getChannelsSelected();
        }
        return emojiPickerViewModel$Companion.getEmojiContextObservable(emojiPickerContextType, storeChannelsSelected);
    }

    public static /* synthetic */ Observable observeStoreState$default(EmojiPickerViewModel$Companion emojiPickerViewModel$Companion, Observable observable, BehaviorSubject behaviorSubject, BehaviorSubject behaviorSubject2, StoreEmoji storeEmoji, StoreGuildsSorted storeGuildsSorted, StoreUserSettings storeUserSettings, StoreAccessibility storeAccessibility, int i, Object obj) {
        return emojiPickerViewModel$Companion.observeStoreState(observable, behaviorSubject, behaviorSubject2, (i & 8) != 0 ? StoreStream.Companion.getEmojis() : storeEmoji, (i & 16) != 0 ? StoreStream.Companion.getGuildsSorted() : storeGuildsSorted, (i & 32) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings, (i & 64) != 0 ? StoreStream.Companion.getAccessibility() : storeAccessibility);
    }

    public final Observable<EmojiPickerViewModel$StoreState> observeStoreState(Observable<StoreEmoji$EmojiContext> emojiContextObservable, BehaviorSubject<String> searchSubject, BehaviorSubject<Long> selectedCategoryItemIdSubject, StoreEmoji storeEmoji, StoreGuildsSorted storeGuildsSorted, StoreUserSettings storeUserSettings, StoreAccessibility storeAccessibility) {
        m.checkNotNullParameter(emojiContextObservable, "emojiContextObservable");
        m.checkNotNullParameter(searchSubject, "searchSubject");
        m.checkNotNullParameter(selectedCategoryItemIdSubject, "selectedCategoryItemIdSubject");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        m.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
        m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        m.checkNotNullParameter(storeAccessibility, "storeAccessibility");
        Observable observableY = emojiContextObservable.Y(new EmojiPickerViewModel$Companion$observeStoreState$1(storeEmoji, storeGuildsSorted, searchSubject, storeUserSettings, storeAccessibility, selectedCategoryItemIdSubject));
        m.checkNotNullExpressionValue(observableY, "emojiContextObservable.s…  )\n          }\n        }");
        return observableY;
    }

    public /* synthetic */ EmojiPickerViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
