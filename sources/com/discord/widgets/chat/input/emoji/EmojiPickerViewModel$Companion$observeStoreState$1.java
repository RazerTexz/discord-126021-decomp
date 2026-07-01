package com.discord.widgets.chat.input.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreEmoji$EmojiContext;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreUserSettings;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$observeStoreState$1<T, R> implements b<StoreEmoji$EmojiContext, Observable<? extends EmojiPickerViewModel$StoreState>> {
    public final /* synthetic */ BehaviorSubject $searchSubject;
    public final /* synthetic */ BehaviorSubject $selectedCategoryItemIdSubject;
    public final /* synthetic */ StoreAccessibility $storeAccessibility;
    public final /* synthetic */ StoreEmoji $storeEmoji;
    public final /* synthetic */ StoreGuildsSorted $storeGuildsSorted;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;

    public EmojiPickerViewModel$Companion$observeStoreState$1(StoreEmoji storeEmoji, StoreGuildsSorted storeGuildsSorted, BehaviorSubject behaviorSubject, StoreUserSettings storeUserSettings, StoreAccessibility storeAccessibility, BehaviorSubject behaviorSubject2) {
        this.$storeEmoji = storeEmoji;
        this.$storeGuildsSorted = storeGuildsSorted;
        this.$searchSubject = behaviorSubject;
        this.$storeUserSettings = storeUserSettings;
        this.$storeAccessibility = storeAccessibility;
        this.$selectedCategoryItemIdSubject = behaviorSubject2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends EmojiPickerViewModel$StoreState> call(StoreEmoji$EmojiContext storeEmoji$EmojiContext) {
        return call2(storeEmoji$EmojiContext);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends EmojiPickerViewModel$StoreState> call2(StoreEmoji$EmojiContext storeEmoji$EmojiContext) {
        return storeEmoji$EmojiContext == null ? new k(EmojiPickerViewModel$StoreState$Uninitialized.INSTANCE) : Observable.f(this.$storeEmoji.getEmojiSet(storeEmoji$EmojiContext, true, true), this.$storeGuildsSorted.observeOrderedGuilds(), this.$searchSubject, StoreUserSettings.observeIsAnimatedEmojisEnabled$default(this.$storeUserSettings, false, 1, null), this.$storeAccessibility.observeReducedMotionEnabled(), this.$selectedCategoryItemIdSubject, new EmojiPickerViewModel$Companion$observeStoreState$1$1(storeEmoji$EmojiContext));
    }
}
