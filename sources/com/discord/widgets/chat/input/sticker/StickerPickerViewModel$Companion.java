package com.discord.widgets.chat.input.sticker;

import com.discord.api.channel.Channel;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExpressionPickerNavigation;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.stickers.StickerUtils;
import d0.g0.w;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPickerViewModel$Companion {
    private StickerPickerViewModel$Companion() {
    }

    public static final /* synthetic */ List access$buildGuildStickersListItems(StickerPickerViewModel$Companion stickerPickerViewModel$Companion, List list, Guild guild, int i, String str, MeUser meUser, Locale locale, Channel channel, long j) {
        return stickerPickerViewModel$Companion.buildGuildStickersListItems(list, guild, i, str, meUser, locale, channel, j);
    }

    public static final /* synthetic */ List access$buildStickerListItems(StickerPickerViewModel$Companion stickerPickerViewModel$Companion, ModelStickerPack modelStickerPack, String str, int i, Locale locale, MeUser meUser) {
        return stickerPickerViewModel$Companion.buildStickerListItems(modelStickerPack, str, i, locale, meUser);
    }

    private final List<MGRecyclerDataPayload> buildGuildStickersListItems(List<Sticker> stickers, Guild guild, int stickerAnimationSettings, String searchInputLower, MeUser meUser, Locale locale, Channel currentChannel, long currentChannelPermissions) {
        ArrayList arrayList = new ArrayList();
        for (Sticker sticker : stickers) {
            String name = sticker.getName();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!w.contains$default((CharSequence) lowerCase, (CharSequence) searchInputLower, false, 2, (Object) null)) {
                String tags = sticker.getTags();
                Objects.requireNonNull(tags, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = tags.toLowerCase(locale);
                m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                if (w.contains$default((CharSequence) lowerCase2, (CharSequence) searchInputLower, false, 2, (Object) null)) {
                }
            }
            arrayList.add(new StickerItem(sticker, stickerAnimationSettings, StickerItem$Mode.OWNED, StickerUtils.INSTANCE.getStickerSendability(sticker, meUser, currentChannel, Long.valueOf(currentChannelPermissions))));
        }
        if ((searchInputLower.length() > 0) && arrayList.isEmpty()) {
            return n.emptyList();
        }
        arrayList.add(0, new HeaderItem(new HeaderType$GuildItem(guild)));
        return arrayList;
    }

    private final List<MGRecyclerDataPayload> buildStickerListItems(ModelStickerPack stickerPack, String searchInputLower, int stickerAnimationSettings, Locale locale, MeUser meUser) {
        ArrayList arrayList = new ArrayList();
        if (stickerPack.getStickers().isEmpty()) {
            return n.emptyList();
        }
        for (Sticker sticker : stickerPack.getStickers()) {
            String name = sticker.getName();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!w.contains$default((CharSequence) lowerCase, (CharSequence) searchInputLower, false, 2, (Object) null)) {
                String tags = sticker.getTags();
                Objects.requireNonNull(tags, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = tags.toLowerCase(locale);
                m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                if (w.contains$default((CharSequence) lowerCase2, (CharSequence) searchInputLower, false, 2, (Object) null)) {
                }
            }
            arrayList.add(new StickerItem(sticker, stickerAnimationSettings, StickerItem$Mode.OWNED, StickerUtils.getStickerSendability$default(StickerUtils.INSTANCE, sticker, meUser, null, null, 12, null)));
        }
        if ((searchInputLower.length() > 0) && arrayList.isEmpty()) {
            return n.emptyList();
        }
        arrayList.add(0, new HeaderItem(new HeaderType$PackItem(stickerPack)));
        return arrayList;
    }

    private final Observable<StickerPickerViewModel$StoreState> observeStoreState(BehaviorSubject<String> searchSubject, BehaviorSubject<Long> selectedPackIdSubject, StoreGuildsSorted storeGuildsSorted, StoreGuildStickers storeGuildStickers, StoreStickers storeStickers, StoreUserSettings storeUserSettings, StoreUser storeUser, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelSelected, StorePermissions storePermissions, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds) {
        Observable observableY = storeChannelSelected.observeResolvedSelectedChannel().Y(new StickerPickerViewModel$Companion$observeStoreState$1(storeGuilds, storeGuildsSorted, storeGuildStickers, storeStickers, searchSubject, storeUserSettings, selectedPackIdSubject, storeUser, storeExpressionPickerNavigation, storePermissions, storeSlowMode));
        m.checkNotNullExpressionValue(observableY, "storeChannelSelected.obs…      )\n        }\n      }");
        return observableY;
    }

    public static /* synthetic */ Observable observeStoreState$default(StickerPickerViewModel$Companion stickerPickerViewModel$Companion, BehaviorSubject behaviorSubject, BehaviorSubject behaviorSubject2, StoreGuildsSorted storeGuildsSorted, StoreGuildStickers storeGuildStickers, StoreStickers storeStickers, StoreUserSettings storeUserSettings, StoreUser storeUser, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StorePermissions storePermissions, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, int i, Object obj) {
        return stickerPickerViewModel$Companion.observeStoreState(behaviorSubject, behaviorSubject2, (i & 4) != 0 ? StoreStream.Companion.getGuildsSorted() : storeGuildsSorted, (i & 8) != 0 ? StoreStream.Companion.getGuildStickers() : storeGuildStickers, (i & 16) != 0 ? StoreStream.Companion.getStickers() : storeStickers, (i & 32) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings, (i & 64) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 128) != 0 ? StoreStream.Companion.getExpressionPickerNavigation() : storeExpressionPickerNavigation, (i & 256) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected, (i & 512) != 0 ? StoreStream.Companion.getPermissions() : storePermissions, (i & 1024) != 0 ? StoreStream.Companion.getSlowMode() : storeSlowMode, (i & 2048) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds);
    }

    public /* synthetic */ StickerPickerViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
