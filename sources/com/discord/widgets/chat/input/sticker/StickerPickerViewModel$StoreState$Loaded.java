package com.discord.widgets.chat.input.sticker;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerPickerViewModel$StoreState$Loaded extends StickerPickerViewModel$StoreState {
    private final LinkedHashMap<Long, Guild> allGuilds;
    private final Channel currentChannel;
    private final long currentChannelPermissions;
    private final List<ModelStickerPack> enabledStickerPacks;
    private final List<Long> frequentlyUsedStickerIds;
    private final Map<Long, Map<Long, Sticker>> guildStickers;
    private final boolean isOnCooldown;
    private final boolean isStickersSelectedTab;
    private final MeUser meUser;
    private final String searchInputStringUpper;
    private final Long selectedCategoryId;
    private final int stickerAnimationSettings;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StickerPickerViewModel$StoreState$Loaded(LinkedHashMap<Long, Guild> linkedHashMap, Map<Long, ? extends Map<Long, Sticker>> map, List<ModelStickerPack> list, List<Long> list2, String str, int i, Long l, MeUser meUser, boolean z2, Channel channel, long j, boolean z3) {
        super(null);
        m.checkNotNullParameter(linkedHashMap, "allGuilds");
        m.checkNotNullParameter(map, "guildStickers");
        m.checkNotNullParameter(list, "enabledStickerPacks");
        m.checkNotNullParameter(list2, "frequentlyUsedStickerIds");
        m.checkNotNullParameter(str, "searchInputStringUpper");
        m.checkNotNullParameter(meUser, "meUser");
        this.allGuilds = linkedHashMap;
        this.guildStickers = map;
        this.enabledStickerPacks = list;
        this.frequentlyUsedStickerIds = list2;
        this.searchInputStringUpper = str;
        this.stickerAnimationSettings = i;
        this.selectedCategoryId = l;
        this.meUser = meUser;
        this.isStickersSelectedTab = z2;
        this.currentChannel = channel;
        this.currentChannelPermissions = j;
        this.isOnCooldown = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerPickerViewModel$StoreState$Loaded copy$default(StickerPickerViewModel$StoreState$Loaded stickerPickerViewModel$StoreState$Loaded, LinkedHashMap linkedHashMap, Map map, List list, List list2, String str, int i, Long l, MeUser meUser, boolean z2, Channel channel, long j, boolean z3, int i2, Object obj) {
        return stickerPickerViewModel$StoreState$Loaded.copy((i2 & 1) != 0 ? stickerPickerViewModel$StoreState$Loaded.allGuilds : linkedHashMap, (i2 & 2) != 0 ? stickerPickerViewModel$StoreState$Loaded.guildStickers : map, (i2 & 4) != 0 ? stickerPickerViewModel$StoreState$Loaded.enabledStickerPacks : list, (i2 & 8) != 0 ? stickerPickerViewModel$StoreState$Loaded.frequentlyUsedStickerIds : list2, (i2 & 16) != 0 ? stickerPickerViewModel$StoreState$Loaded.searchInputStringUpper : str, (i2 & 32) != 0 ? stickerPickerViewModel$StoreState$Loaded.stickerAnimationSettings : i, (i2 & 64) != 0 ? stickerPickerViewModel$StoreState$Loaded.selectedCategoryId : l, (i2 & 128) != 0 ? stickerPickerViewModel$StoreState$Loaded.meUser : meUser, (i2 & 256) != 0 ? stickerPickerViewModel$StoreState$Loaded.isStickersSelectedTab : z2, (i2 & 512) != 0 ? stickerPickerViewModel$StoreState$Loaded.currentChannel : channel, (i2 & 1024) != 0 ? stickerPickerViewModel$StoreState$Loaded.currentChannelPermissions : j, (i2 & 2048) != 0 ? stickerPickerViewModel$StoreState$Loaded.isOnCooldown : z3);
    }

    public final boolean canUseExternalStickersInCurrentChannel(long externalStickerGuildId) {
        Channel channel = this.currentChannel;
        if ((channel != null && ChannelUtils.B(channel)) || PermissionUtils.can(Permission.USE_EXTERNAL_STICKERS, Long.valueOf(this.currentChannelPermissions))) {
            return true;
        }
        Channel channel2 = this.currentChannel;
        return channel2 != null && externalStickerGuildId == channel2.getGuildId();
    }

    public final LinkedHashMap<Long, Guild> component1() {
        return this.allGuilds;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Channel getCurrentChannel() {
        return this.currentChannel;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getCurrentChannelPermissions() {
        return this.currentChannelPermissions;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsOnCooldown() {
        return this.isOnCooldown;
    }

    public final Map<Long, Map<Long, Sticker>> component2() {
        return this.guildStickers;
    }

    public final List<ModelStickerPack> component3() {
        return this.enabledStickerPacks;
    }

    public final List<Long> component4() {
        return this.frequentlyUsedStickerIds;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSearchInputStringUpper() {
        return this.searchInputStringUpper;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getStickerAnimationSettings() {
        return this.stickerAnimationSettings;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getSelectedCategoryId() {
        return this.selectedCategoryId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsStickersSelectedTab() {
        return this.isStickersSelectedTab;
    }

    public final StickerPickerViewModel$StoreState$Loaded copy(LinkedHashMap<Long, Guild> allGuilds, Map<Long, ? extends Map<Long, Sticker>> guildStickers, List<ModelStickerPack> enabledStickerPacks, List<Long> frequentlyUsedStickerIds, String searchInputStringUpper, int stickerAnimationSettings, Long selectedCategoryId, MeUser meUser, boolean isStickersSelectedTab, Channel currentChannel, long currentChannelPermissions, boolean isOnCooldown) {
        m.checkNotNullParameter(allGuilds, "allGuilds");
        m.checkNotNullParameter(guildStickers, "guildStickers");
        m.checkNotNullParameter(enabledStickerPacks, "enabledStickerPacks");
        m.checkNotNullParameter(frequentlyUsedStickerIds, "frequentlyUsedStickerIds");
        m.checkNotNullParameter(searchInputStringUpper, "searchInputStringUpper");
        m.checkNotNullParameter(meUser, "meUser");
        return new StickerPickerViewModel$StoreState$Loaded(allGuilds, guildStickers, enabledStickerPacks, frequentlyUsedStickerIds, searchInputStringUpper, stickerAnimationSettings, selectedCategoryId, meUser, isStickersSelectedTab, currentChannel, currentChannelPermissions, isOnCooldown);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPickerViewModel$StoreState$Loaded)) {
            return false;
        }
        StickerPickerViewModel$StoreState$Loaded stickerPickerViewModel$StoreState$Loaded = (StickerPickerViewModel$StoreState$Loaded) other;
        return m.areEqual(this.allGuilds, stickerPickerViewModel$StoreState$Loaded.allGuilds) && m.areEqual(this.guildStickers, stickerPickerViewModel$StoreState$Loaded.guildStickers) && m.areEqual(this.enabledStickerPacks, stickerPickerViewModel$StoreState$Loaded.enabledStickerPacks) && m.areEqual(this.frequentlyUsedStickerIds, stickerPickerViewModel$StoreState$Loaded.frequentlyUsedStickerIds) && m.areEqual(this.searchInputStringUpper, stickerPickerViewModel$StoreState$Loaded.searchInputStringUpper) && this.stickerAnimationSettings == stickerPickerViewModel$StoreState$Loaded.stickerAnimationSettings && m.areEqual(this.selectedCategoryId, stickerPickerViewModel$StoreState$Loaded.selectedCategoryId) && m.areEqual(this.meUser, stickerPickerViewModel$StoreState$Loaded.meUser) && this.isStickersSelectedTab == stickerPickerViewModel$StoreState$Loaded.isStickersSelectedTab && m.areEqual(this.currentChannel, stickerPickerViewModel$StoreState$Loaded.currentChannel) && this.currentChannelPermissions == stickerPickerViewModel$StoreState$Loaded.currentChannelPermissions && this.isOnCooldown == stickerPickerViewModel$StoreState$Loaded.isOnCooldown;
    }

    public final LinkedHashMap<Long, Guild> getAllGuilds() {
        return this.allGuilds;
    }

    public final Channel getCurrentChannel() {
        return this.currentChannel;
    }

    public final long getCurrentChannelPermissions() {
        return this.currentChannelPermissions;
    }

    public final List<ModelStickerPack> getEnabledStickerPacks() {
        return this.enabledStickerPacks;
    }

    public final List<Long> getFrequentlyUsedStickerIds() {
        return this.frequentlyUsedStickerIds;
    }

    public final Map<Long, Map<Long, Sticker>> getGuildStickers() {
        return this.guildStickers;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final String getSearchInputStringUpper() {
        return this.searchInputStringUpper;
    }

    public final Long getSelectedCategoryId() {
        return this.selectedCategoryId;
    }

    public final int getStickerAnimationSettings() {
        return this.stickerAnimationSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        LinkedHashMap<Long, Guild> linkedHashMap = this.allGuilds;
        int iHashCode = (linkedHashMap != null ? linkedHashMap.hashCode() : 0) * 31;
        Map<Long, Map<Long, Sticker>> map = this.guildStickers;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        List<ModelStickerPack> list = this.enabledStickerPacks;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.frequentlyUsedStickerIds;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.searchInputStringUpper;
        int iHashCode5 = (((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.stickerAnimationSettings) * 31;
        Long l = this.selectedCategoryId;
        int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        MeUser meUser = this.meUser;
        int iHashCode7 = (iHashCode6 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        boolean z2 = this.isStickersSelectedTab;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode7 + r2) * 31;
        Channel channel = this.currentChannel;
        int iA = (b.a(this.currentChannelPermissions) + ((i + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
        boolean z3 = this.isOnCooldown;
        return iA + (z3 ? 1 : z3);
    }

    public final boolean isOnCooldown() {
        return this.isOnCooldown;
    }

    public final boolean isStickersSelectedTab() {
        return this.isStickersSelectedTab;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(allGuilds=");
        sbU.append(this.allGuilds);
        sbU.append(", guildStickers=");
        sbU.append(this.guildStickers);
        sbU.append(", enabledStickerPacks=");
        sbU.append(this.enabledStickerPacks);
        sbU.append(", frequentlyUsedStickerIds=");
        sbU.append(this.frequentlyUsedStickerIds);
        sbU.append(", searchInputStringUpper=");
        sbU.append(this.searchInputStringUpper);
        sbU.append(", stickerAnimationSettings=");
        sbU.append(this.stickerAnimationSettings);
        sbU.append(", selectedCategoryId=");
        sbU.append(this.selectedCategoryId);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(", isStickersSelectedTab=");
        sbU.append(this.isStickersSelectedTab);
        sbU.append(", currentChannel=");
        sbU.append(this.currentChannel);
        sbU.append(", currentChannelPermissions=");
        sbU.append(this.currentChannelPermissions);
        sbU.append(", isOnCooldown=");
        return a.O(sbU, this.isOnCooldown, ")");
    }
}
