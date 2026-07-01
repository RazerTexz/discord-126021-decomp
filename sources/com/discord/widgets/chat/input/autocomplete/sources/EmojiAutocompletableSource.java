package com.discord.widgets.chat.input.autocomplete.sources;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.EmojiAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import com.discord.widgets.chat.input.emoji.EmojiAutocompletePremiumUpsellFeatureFlag;
import d0.Tuples;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: EmojiAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiAutocompletableSource {
    private final StoreEmoji emojiStore;
    private final StoreUserSettings userSettingsStore;

    public EmojiAutocompletableSource(StoreEmoji storeEmoji, StoreUserSettings storeUserSettings) {
        Intrinsics3.checkNotNullParameter(storeEmoji, "emojiStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        this.emojiStore = storeEmoji;
        this.userSettingsStore = storeUserSettings;
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createFromEmojiSet(EmojiSet emojiSet, boolean animationsEnabled) {
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        Iterator<T> it = emojiSet.unicodeEmojis.values().iterator();
        while (it.hasNext()) {
            List<Emoji> list = (List) it.next();
            Intrinsics3.checkNotNullExpressionValue(list, "categoryEmojis");
            for (Emoji emoji : list) {
                Intrinsics3.checkNotNullExpressionValue(emoji, "emoji");
                treeSet.add(new EmojiAutocompletable(emoji, animationsEnabled));
            }
        }
        Iterator<T> it2 = emojiSet.customEmojis.values().iterator();
        while (it2.hasNext()) {
            List list2 = (List) it2.next();
            ArrayList<Emoji> arrayListA0 = outline.a0(list2, "guildEmojis");
            for (Object obj : list2) {
                Emoji emoji2 = (Emoji) obj;
                Intrinsics3.checkNotNullExpressionValue(emoji2, "it");
                if (emoji2.isAvailable()) {
                    arrayListA0.add(obj);
                }
            }
            for (Emoji emoji3 : arrayListA0) {
                Intrinsics3.checkNotNullExpressionValue(emoji3, "emoji");
                treeSet.add(new EmojiAutocompletable(emoji3, animationsEnabled));
            }
        }
        return MapsJVM.mapOf(Tuples.to(LeadingIdentifier.EMOJI_AND_STICKERS, treeSet));
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeEmojiAutocompletables(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Observable observableJ = Observable.j(ObservableExtensionsKt.computationLatest(this.emojiStore.getEmojiSet(channel.getGuildId(), channel.getId(), EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE.getINSTANCE().isEnabled(), false)), ObservableExtensionsKt.computationLatest(this.userSettingsStore.observeIsAnimatedEmojisEnabled(true)), new Func2<EmojiSet, Boolean, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource.observeEmojiAutocompletables.1
            @Override // rx.functions.Func2
            public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call(EmojiSet emojiSet, Boolean bool) {
                EmojiAutocompletableSource emojiAutocompletableSource = EmojiAutocompletableSource.this;
                Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojiSet");
                Intrinsics3.checkNotNullExpressionValue(bool, "animationsEnabled");
                return emojiAutocompletableSource.createFromEmojiSet(emojiSet, bool.booleanValue());
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest… animationsEnabled)\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableR = ObservableExtensionsKt.computationLatest(observableJ).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }
}
