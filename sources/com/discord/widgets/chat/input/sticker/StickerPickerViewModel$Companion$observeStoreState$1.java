package com.discord.widgets.chat.input.sticker;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreExpressionPickerNavigation;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreSlowMode$Type$MessageSend;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPickerViewModel$Companion$observeStoreState$1<T, R> implements b<StoreChannelsSelected$ResolvedSelectedChannel, Observable<? extends StickerPickerViewModel$StoreState>> {
    public final /* synthetic */ BehaviorSubject $searchSubject;
    public final /* synthetic */ BehaviorSubject $selectedPackIdSubject;
    public final /* synthetic */ StoreExpressionPickerNavigation $storeExpressionPickerNavigation;
    public final /* synthetic */ StoreGuildStickers $storeGuildStickers;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreGuildsSorted $storeGuildsSorted;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreSlowMode $storeSlowMode;
    public final /* synthetic */ StoreStickers $storeStickers;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;

    public StickerPickerViewModel$Companion$observeStoreState$1(StoreGuilds storeGuilds, StoreGuildsSorted storeGuildsSorted, StoreGuildStickers storeGuildStickers, StoreStickers storeStickers, BehaviorSubject behaviorSubject, StoreUserSettings storeUserSettings, BehaviorSubject behaviorSubject2, StoreUser storeUser, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StorePermissions storePermissions, StoreSlowMode storeSlowMode) {
        this.$storeGuilds = storeGuilds;
        this.$storeGuildsSorted = storeGuildsSorted;
        this.$storeGuildStickers = storeGuildStickers;
        this.$storeStickers = storeStickers;
        this.$searchSubject = behaviorSubject;
        this.$storeUserSettings = storeUserSettings;
        this.$selectedPackIdSubject = behaviorSubject2;
        this.$storeUser = storeUser;
        this.$storeExpressionPickerNavigation = storeExpressionPickerNavigation;
        this.$storePermissions = storePermissions;
        this.$storeSlowMode = storeSlowMode;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends StickerPickerViewModel$StoreState> call(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return call2(storeChannelsSelected$ResolvedSelectedChannel);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StickerPickerViewModel$StoreState> call2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        Guild guild;
        Channel channelOrParent = storeChannelsSelected$ResolvedSelectedChannel.getChannelOrParent();
        if (channelOrParent != null) {
            guild = this.$storeGuilds.getGuild(channelOrParent.getGuildId());
            if (guild == null) {
                guild = null;
            }
        } else {
            guild = null;
        }
        Observable<R> observableR = this.$storeGuildsSorted.observeOrderedGuilds().G(new StickerPickerViewModel$Companion$observeStoreState$1$1(guild)).r();
        m.checkNotNullExpressionValue(observableR, "storeGuildsSorted.observ… }.distinctUntilChanged()");
        return ObservableCombineLatestOverloadsKt.combineLatest(observableR, this.$storeGuildStickers.observeGuildStickers(), this.$storeStickers.observeEnabledStickerPacks(), this.$storeStickers.observeFrequentlyUsedStickerIds(), this.$searchSubject, StoreUserSettings.observeStickerAnimationSettings$default(this.$storeUserSettings, false, 1, null), this.$selectedPackIdSubject, StoreUser.observeMe$default(this.$storeUser, false, 1, null), this.$storeExpressionPickerNavigation.observeSelectedTab(), this.$storePermissions.observePermissionsForAllChannels(), this.$storeSlowMode.observeCooldownSecs(Long.valueOf(storeChannelsSelected$ResolvedSelectedChannel.getId()), StoreSlowMode$Type$MessageSend.INSTANCE), new StickerPickerViewModel$Companion$observeStoreState$1$2(channelOrParent));
    }
}
