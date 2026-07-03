package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.EmojiAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import com.discord.widgets.chat.input.emoji.EmojiAutocompletePremiumUpsellFeatureFlag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: EmojiAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiAutocompletableSource {
    private final StoreEmoji emojiStore;
    private final StoreUserSettings userSettingsStore;

    public EmojiAutocompletableSource(StoreEmoji storeEmoji, StoreUserSettings storeUserSettings) {
        C12238m.checkNotNullParameter(storeEmoji, "emojiStore");
        C12238m.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        this.emojiStore = storeEmoji;
        this.userSettingsStore = storeUserSettings;
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createFromEmojiSet(EmojiSet emojiSet, boolean animationsEnabled) {
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        Iterator<T> it = emojiSet.unicodeEmojis.values().iterator();
        while (it.hasNext()) {
            List<Emoji> list = (List) it.next();
            C12238m.checkNotNullExpressionValue(list, "categoryEmojis");
            for (Emoji emoji : list) {
                C12238m.checkNotNullExpressionValue(emoji, "emoji");
                treeSet.add(new EmojiAutocompletable(emoji, animationsEnabled));
            }
        }
        Iterator<T> it2 = emojiSet.customEmojis.values().iterator();
        while (it2.hasNext()) {
            List list2 = (List) it2.next();
            ArrayList<Emoji> arrayListM840a0 = C1643a.m840a0(list2, "guildEmojis");
            for (Object obj : list2) {
                Emoji emoji2 = (Emoji) obj;
                C12238m.checkNotNullExpressionValue(emoji2, "it");
                if (emoji2.isAvailable()) {
                    arrayListM840a0.add(obj);
                }
            }
            for (Emoji emoji3 : arrayListM840a0) {
                C12238m.checkNotNullExpressionValue(emoji3, "emoji");
                treeSet.add(new EmojiAutocompletable(emoji3, animationsEnabled));
            }
        }
        return C12134g0.mapOf(C12116o.m10073to(LeadingIdentifier.EMOJI_AND_STICKERS, treeSet));
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeEmojiAutocompletables(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        Observable observableM11076j = Observable.m11076j(ObservableExtensionsKt.computationLatest(this.emojiStore.getEmojiSet(channel.getGuildId(), channel.getId(), EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE.getINSTANCE().isEnabled(), false)), ObservableExtensionsKt.computationLatest(this.userSettingsStore.observeIsAnimatedEmojisEnabled(true)), new Func2<EmojiSet, Boolean, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource.observeEmojiAutocompletables.1
            @Override // p658rx.functions.Func2
            public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call(EmojiSet emojiSet, Boolean bool) {
                EmojiAutocompletableSource emojiAutocompletableSource = EmojiAutocompletableSource.this;
                C12238m.checkNotNullExpressionValue(emojiSet, "emojiSet");
                C12238m.checkNotNullExpressionValue(bool, "animationsEnabled");
                return emojiAutocompletableSource.createFromEmojiSet(emojiSet, bool.booleanValue());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest… animationsEnabled)\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11076j).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableM11112r;
    }
}
