package com.discord.utilities.stickers;

import android.content.Context;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerType;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelSku$ModelPremiumSkuPrice;
import com.discord.models.domain.ModelSku$Price;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.sticker.dto.ModelStickerPackStoreListing;
import com.discord.models.user.User;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.file.DownloadUtils;
import com.discord.utilities.file.DownloadUtils$DownloadState;
import com.discord.utilities.file.DownloadUtils$DownloadState$Completed;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.premium.PremiumUtilsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
import d0.g;
import d0.g0.t;
import d0.g0.w;
import d0.t.m0;
import d0.t.n;
import d0.t.n0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import org.json.JSONException;
import org.json.JSONObject;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* JADX INFO: compiled from: StickerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerUtils {
    public static final int MAXIMUM_LENGTH_STICKER_TEXT_SUGGESTIONS = 50;
    private static final int MAXIMUM_WORD_COUNT_STICKER_TEXT_SUGGESTIONS = 5;
    public static final int MINIMUM_LENGTH_STICKER_TEXT_SUGGESTIONS = 3;
    public static final int NUM_STICKERS_AUTO_SUGGEST = 4;
    private static final long STICKER_APPLICATION_ID = 710982414301790216L;
    public static final StickerUtils INSTANCE = new StickerUtils();

    /* JADX INFO: renamed from: DEFAULT_STICKER_SIZE_PX$delegate, reason: from kotlin metadata */
    private static final Lazy DEFAULT_STICKER_SIZE_PX = g.lazy(StickerUtils$DEFAULT_STICKER_SIZE_PX$2.INSTANCE);

    private StickerUtils() {
    }

    public static /* synthetic */ Set findStickerMatches$default(StickerUtils stickerUtils, String str, List list, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return stickerUtils.findStickerMatches(str, list, z2);
    }

    public static /* synthetic */ String getBannerCDNAssetUrl$default(StickerUtils stickerUtils, ModelStickerPack modelStickerPack, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return stickerUtils.getBannerCDNAssetUrl(modelStickerPack, num);
    }

    public static /* synthetic */ String getCDNAssetUrl$default(StickerUtils stickerUtils, BaseSticker baseSticker, Integer num, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = Integer.valueOf(stickerUtils.getDEFAULT_STICKER_SIZE_PX());
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return stickerUtils.getCDNAssetUrl(baseSticker, num, z2);
    }

    public static /* synthetic */ Observable getGuildOrStandardSticker$default(StickerUtils stickerUtils, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return stickerUtils.getGuildOrStandardSticker(j, z2);
    }

    private final int getStickerPackPrice(PremiumTier premiumTier) {
        if (premiumTier.ordinal() != 4) {
            return 299;
        }
        return Opcodes.IFNONNULL;
    }

    private final Integer getStickerPackPriceForPremiumTier(ModelStickerPack stickerPack, PremiumTier premiumTier) {
        ModelSku sku;
        ModelSku$Price price;
        ModelSku$ModelPremiumSkuPrice modelSku$ModelPremiumSkuPrice;
        ModelStickerPackStoreListing storeListing = stickerPack.getStoreListing();
        if (storeListing == null || (sku = storeListing.getSku()) == null || (price = sku.getPrice()) == null) {
            return null;
        }
        Map<PremiumTier, ModelSku$ModelPremiumSkuPrice> premium = price.getPremium();
        return Integer.valueOf((premium == null || (modelSku$ModelPremiumSkuPrice = premium.get(premiumTier)) == null) ? price.getAmount() : modelSku$ModelPremiumSkuPrice.getAmount());
    }

    public static /* synthetic */ StickerUtils$StickerSendability getStickerSendability$default(StickerUtils stickerUtils, Sticker sticker, User user, Channel channel, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            channel = null;
        }
        if ((i & 8) != 0) {
            l = null;
        }
        return stickerUtils.getStickerSendability(sticker, user, channel, l);
    }

    public static /* synthetic */ List getStickersForAutocomplete$default(StickerUtils stickerUtils, StoreUser storeUser, StoreGuilds storeGuilds, StoreStickers storeStickers, StoreGuildSelected storeGuildSelected, StoreGuildStickers storeGuildStickers, int i, Object obj) {
        if ((i & 1) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        if ((i & 2) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        StoreGuilds storeGuilds2 = storeGuilds;
        if ((i & 4) != 0) {
            storeStickers = StoreStream.Companion.getStickers();
        }
        StoreStickers storeStickers2 = storeStickers;
        if ((i & 8) != 0) {
            storeGuildSelected = StoreStream.Companion.getGuildSelected();
        }
        StoreGuildSelected storeGuildSelected2 = storeGuildSelected;
        if ((i & 16) != 0) {
            storeGuildStickers = StoreStream.Companion.getGuildStickers();
        }
        return stickerUtils.getStickersForAutocomplete(storeUser, storeGuilds2, storeStickers2, storeGuildSelected2, storeGuildStickers);
    }

    public final int calculatePremiumStickerPackDiscount() {
        int stickerPackPrice = getStickerPackPrice(PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY);
        return (int) (((stickerPackPrice - getStickerPackPrice(PremiumTier.TIER_2)) * 100.0f) / stickerPackPrice);
    }

    public final Observable<DownloadUtils$DownloadState> fetchSticker(Context context, BaseSticker sticker) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(sticker, "sticker");
        File file = new File(context.getCacheDir(), "stickers");
        if (!file.exists()) {
            file.mkdir();
        }
        String str = sticker.getId() + sticker.b();
        File file2 = new File(file, str);
        if (!file2.exists()) {
            return DownloadUtils.downloadFile(context, getCDNAssetUrl$default(this, sticker, null, false, 6, null), str, file);
        }
        k kVar = new k(new DownloadUtils$DownloadState$Completed(file2));
        m.checkNotNullExpressionValue(kVar, "Observable.just(Download…oadState.Completed(file))");
        return kVar;
    }

    public final Set<Sticker> findStickerMatches(String searchText, List<Sticker> stickers, boolean allowPartialMatches) {
        boolean z2;
        boolean z3;
        m.checkNotNullParameter(searchText, "searchText");
        m.checkNotNullParameter(stickers, "stickers");
        if (searchText.length() == 0) {
            return n0.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        LinkedHashSet linkedHashSet5 = new LinkedHashSet();
        Set<String> queriesFromSearchText = SearchUtils.INSTANCE.getQueriesFromSearchText(searchText);
        if (queriesFromSearchText.size() > 5) {
            return n0.emptySet();
        }
        for (String str : queriesFromSearchText) {
            for (Sticker sticker : stickers) {
                if (t.equals(sticker.getName(), str, true)) {
                    linkedHashSet2.add(sticker);
                } else if (allowPartialMatches && t.startsWith(sticker.getName(), str, true)) {
                    linkedHashSet3.add(sticker);
                } else if (sticker.getType() == StickerType.GUILD) {
                    List listSplit$default = w.split$default((CharSequence) sticker.getName(), new String[]{" "}, false, 0, 6, (Object) null);
                    if (!(listSplit$default instanceof Collection) || !listSplit$default.isEmpty()) {
                        Iterator it = listSplit$default.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (t.equals((String) it.next(), str, true)) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        linkedHashSet3.add(sticker);
                    }
                }
                List<String> listSplit$default2 = w.split$default((CharSequence) sticker.getTags(), new String[]{","}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listSplit$default2, 10));
                for (String str2 : listSplit$default2) {
                    Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
                    arrayList.add(w.trim(str2).toString());
                }
                ArrayList<String> arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (!t.isBlank((String) obj)) {
                        arrayList2.add(obj);
                    }
                }
                String strReplace$default = t.replace$default(str, ":", "", false, 4, (Object) null);
                for (String str3 : arrayList2) {
                    if (t.equals(str3, strReplace$default, true)) {
                        linkedHashSet4.add(sticker);
                    } else if (allowPartialMatches && t.startsWith(str3, strReplace$default, true)) {
                        linkedHashSet5.add(sticker);
                    } else if (sticker.getType() == StickerType.GUILD) {
                        List listSplit$default3 = w.split$default((CharSequence) sticker.getTags(), new String[]{"_"}, false, 0, 6, (Object) null);
                        if (!(listSplit$default3 instanceof Collection) || !listSplit$default3.isEmpty()) {
                            Iterator it2 = listSplit$default3.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z3 = false;
                                    break;
                                }
                                if (t.equals((String) it2.next(), str, true)) {
                                    z3 = true;
                                    break;
                                }
                            }
                        } else {
                            z3 = false;
                            break;
                        }
                        if (z3) {
                            linkedHashSet5.add(sticker);
                        }
                    }
                }
            }
        }
        linkedHashSet.addAll(linkedHashSet2);
        linkedHashSet.addAll(linkedHashSet3);
        linkedHashSet.addAll(linkedHashSet4);
        linkedHashSet.addAll(linkedHashSet5);
        return linkedHashSet;
    }

    public final String getBannerCDNAssetUrl(ModelStickerPack stickerPack, Integer size) {
        String string;
        m.checkNotNullParameter(stickerPack, "stickerPack");
        StringBuilder sb = new StringBuilder();
        sb.append("https://cdn.discordapp.com/app-assets/710982414301790216/store/");
        sb.append(stickerPack.getBannerAssetId());
        sb.append('.');
        sb.append(StringUtilsKt.getSTATIC_IMAGE_EXTENSION());
        if (size != null) {
            StringBuilder sbU = a.U("?size=");
            sbU.append(IconUtils.getMediaProxySize(size.intValue()));
            string = sbU.toString();
        } else {
            string = "";
        }
        sb.append(string);
        return sb.toString();
    }

    public final String getCDNAssetUrl(BaseSticker sticker, Integer size, boolean passthrough) {
        m.checkNotNullParameter(sticker, "sticker");
        int iOrdinal = sticker.getFormatType().ordinal();
        String string = "";
        if (iOrdinal != 1 && iOrdinal != 2) {
            if (iOrdinal != 3) {
                return "";
            }
            StringBuilder sbU = a.U("https://discord.com/stickers/");
            sbU.append(sticker.getId());
            sbU.append(sticker.b());
            return sbU.toString();
        }
        StringBuilder sbU2 = a.U("https://media.discordapp.net/stickers/");
        sbU2.append(sticker.getId());
        sbU2.append(sticker.b());
        sbU2.append("?passthrough=");
        sbU2.append(passthrough);
        if (size != null) {
            StringBuilder sbU3 = a.U("&size=");
            sbU3.append(IconUtils.getMediaProxySize(size.intValue()));
            string = sbU3.toString();
        }
        sbU2.append(string);
        return sbU2.toString();
    }

    public final int getDEFAULT_STICKER_SIZE_PX() {
        return ((Number) DEFAULT_STICKER_SIZE_PX.getValue()).intValue();
    }

    public final Observable<Sticker> getGuildOrStandardSticker(long stickerId, boolean fetchIfMissing) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Sticker sticker = storeStream$Companion.getStickers().getStickers().get(Long.valueOf(stickerId));
        if (sticker != null) {
            k kVar = new k(sticker);
            m.checkNotNullExpressionValue(kVar, "Observable.just(fullStandardSticker)");
            return kVar;
        }
        Sticker guildSticker = storeStream$Companion.getGuildStickers().getGuildSticker(stickerId);
        if (guildSticker != null) {
            k kVar2 = new k(guildSticker);
            m.checkNotNullExpressionValue(kVar2, "Observable.just(fullGuildSticker)");
            return kVar2;
        }
        if (fetchIfMissing) {
            Observable<Sticker> observableU = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getSticker(stickerId), false, 1, null).u(StickerUtils$getGuildOrStandardSticker$1.INSTANCE);
            m.checkNotNullExpressionValue(observableU, "RestAPI\n        .api\n   …fetchedSticker)\n        }");
            return observableU;
        }
        k kVar3 = new k(null);
        m.checkNotNullExpressionValue(kVar3, "Observable.just(null)");
        return kVar3;
    }

    public final CharSequence getLimitedTimeLeftString(Context context, ModelStickerPackStoreListing stickerPackStoreListing) {
        m.checkNotNullParameter(context, "context");
        if ((stickerPackStoreListing != null ? stickerPackStoreListing.getUnpublishedAt() : null) == null) {
            return "";
        }
        long unpublishedAtDate = stickerPackStoreListing.getUnpublishedAtDate() - ClockFactory.get().currentTimeMillis();
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        int daysFromMillis = timeUtils.getDaysFromMillis(unpublishedAtDate);
        if (daysFromMillis > 0) {
            return StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_days_days, daysFromMillis, Integer.valueOf(daysFromMillis));
        }
        int hoursFromMillis = timeUtils.getHoursFromMillis(unpublishedAtDate);
        long j = unpublishedAtDate - (((long) hoursFromMillis) * 3600000);
        int minutesFromMillis = timeUtils.getMinutesFromMillis(j);
        int secondsFromMillis = timeUtils.getSecondsFromMillis(j - (((long) minutesFromMillis) * 60000));
        return (hoursFromMillis < 0 || minutesFromMillis < 0 || secondsFromMillis < 0) ? b.h(context, 2131895949, new Object[0], null, 4) : b.h(context, 2131888608, new Object[]{a.P(new Object[]{Integer.valueOf(hoursFromMillis)}, 1, "%02d", "java.lang.String.format(format, *args)"), a.P(new Object[]{Integer.valueOf(minutesFromMillis)}, 1, "%02d", "java.lang.String.format(format, *args)"), a.P(new Object[]{Integer.valueOf(secondsFromMillis)}, 1, "%02d", "java.lang.String.format(format, *args)")}, null, 4);
    }

    public final CharSequence getStickerPackPremiumPriceLabel(Context context, ModelStickerPack stickerPack, PremiumTier currentPremiumTier, boolean isPackEnabled) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(stickerPack, "stickerPack");
        m.checkNotNullParameter(currentPremiumTier, "currentPremiumTier");
        if (isPackEnabled && !PremiumUtilsKt.grantsAccessToPremiumStickers(currentPremiumTier)) {
            return b.h(context, 2131895930, new Object[0], null, 4);
        }
        PremiumTier premiumTier = PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY;
        if (currentPremiumTier != premiumTier) {
            Integer stickerPackPriceForPremiumTier = getStickerPackPriceForPremiumTier(stickerPack, premiumTier);
            Integer stickerPackPriceForPremiumTier2 = getStickerPackPriceForPremiumTier(stickerPack, currentPremiumTier);
            if (stickerPackPriceForPremiumTier != null && stickerPackPriceForPremiumTier2 != null && (!m.areEqual(stickerPackPriceForPremiumTier, stickerPackPriceForPremiumTier2))) {
                CharSequence formattedPriceUsd = com.discord.utilities.billing.PremiumUtilsKt.getFormattedPriceUsd(stickerPackPriceForPremiumTier.intValue(), context);
                return stickerPackPriceForPremiumTier2.intValue() == 0 ? b.b(context, 2131895939, new Object[]{formattedPriceUsd}, new StickerUtils$getStickerPackPremiumPriceLabel$1(context)) : b.b(context, 2131895940, new Object[]{com.discord.utilities.billing.PremiumUtilsKt.getFormattedPriceUsd(stickerPackPriceForPremiumTier2.intValue(), context), formattedPriceUsd}, new StickerUtils$getStickerPackPremiumPriceLabel$2(context));
            }
        }
        if (isStickerPackFreeForPremiumTier(stickerPack, currentPremiumTier)) {
            return b.h(context, 2131895931, new Object[0], null, 4);
        }
        PremiumTier premiumTier2 = PremiumTier.TIER_1;
        if (isStickerPackFreeForPremiumTier(stickerPack, premiumTier2) && !PremiumUtils.INSTANCE.isPremiumTierAtLeast(currentPremiumTier, premiumTier2)) {
            return b.h(context, 2131895932, new Object[0], null, 4);
        }
        PremiumTier premiumTier3 = PremiumTier.TIER_2;
        if (isStickerPackFreeForPremiumTier(stickerPack, premiumTier3) && !PremiumUtils.INSTANCE.isPremiumTierAtLeast(currentPremiumTier, premiumTier3)) {
            return b.h(context, 2131895933, new Object[0], null, 4);
        }
        PremiumTier premiumTier4 = PremiumTier.TIER_0;
        if (isStickerPackFreeForPremiumTier(stickerPack, premiumTier4) && !PremiumUtils.INSTANCE.isPremiumTierAtLeast(currentPremiumTier, premiumTier4) && currentPremiumTier != premiumTier2) {
            return b.h(context, 2131895933, new Object[0], null, 4);
        }
        CharSequence formattedPriceUsd2 = com.discord.utilities.billing.PremiumUtilsKt.getFormattedPriceUsd(getStickerPackPrice(premiumTier3), context);
        return PremiumUtilsKt.grantsAccessToPremiumStickers(currentPremiumTier) ? formattedPriceUsd2 : b.h(context, 2131895957, new Object[]{formattedPriceUsd2}, null, 4);
    }

    public final StickerUtils$StickerSendability getStickerSendability(Sticker sticker, User meUser, Channel currentChannel, Long currentChannelPermissions) {
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(meUser, "meUser");
        boolean canUsePremiumStickers = UserUtils.INSTANCE.getCanUsePremiumStickers(meUser);
        if (sticker.getType() == StickerType.STANDARD) {
            return canUsePremiumStickers ? StickerUtils$StickerSendability.SENDABLE : StickerUtils$StickerSendability.SENDABLE_WITH_PREMIUM;
        }
        if (sticker.getType() != StickerType.GUILD) {
            return StickerUtils$StickerSendability.NONSENDABLE;
        }
        if (m.areEqual(sticker.getAvailable(), Boolean.FALSE)) {
            return StickerUtils$StickerSendability.SENDABLE_WITH_PREMIUM_GUILD;
        }
        if (m.areEqual(sticker.getGuildId(), currentChannel != null ? Long.valueOf(currentChannel.getGuildId()) : null)) {
            return StickerUtils$StickerSendability.SENDABLE;
        }
        if (currentChannel == null || ChannelUtils.B(currentChannel) || PermissionUtils.can(Permission.USE_EXTERNAL_STICKERS, currentChannelPermissions)) {
            return canUsePremiumStickers ? StickerUtils$StickerSendability.SENDABLE : StickerUtils$StickerSendability.SENDABLE_WITH_PREMIUM;
        }
        return StickerUtils$StickerSendability.NONSENDABLE;
    }

    public final List<Sticker> getStickersForAutocomplete(StoreUser storeUser, StoreGuilds storeGuilds, StoreStickers storeStickers, StoreGuildSelected storeGuildSelected, StoreGuildStickers storeGuildStickers) {
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeStickers, "storeStickers");
        m.checkNotNullParameter(storeGuildSelected, "storeGuildSelected");
        m.checkNotNullParameter(storeGuildStickers, "storeGuildStickers");
        boolean canUsePremiumStickers = UserUtils.INSTANCE.getCanUsePremiumStickers(storeUser.getMeSnapshot());
        List<Sticker> enabledStickers = canUsePremiumStickers ? storeStickers.getEnabledStickers() : n.emptyList();
        Set<Long> setKeySet = canUsePremiumStickers ? storeGuilds.getGuilds().keySet() : m0.setOf(Long.valueOf(storeGuildSelected.getSelectedGuildId()));
        List<Sticker> allGuildStickersFlattened = storeGuildStickers.getAllGuildStickersFlattened();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allGuildStickersFlattened) {
            if (u.contains(setKeySet, ((Sticker) obj).getGuildId())) {
                arrayList.add(obj);
            }
        }
        return u.plus((Collection) enabledStickers, (Iterable) arrayList);
    }

    public final boolean isStickerPackFreeForPremiumTier(ModelStickerPack stickerPack, PremiumTier premiumTier) {
        m.checkNotNullParameter(stickerPack, "stickerPack");
        m.checkNotNullParameter(premiumTier, "premiumTier");
        boolean z2 = PremiumUtilsKt.grantsAccessToPremiumStickers(premiumTier) && stickerPack.isPremiumPack();
        Integer stickerPackPriceForPremiumTier = getStickerPackPriceForPremiumTier(stickerPack, premiumTier);
        return z2 || (stickerPackPriceForPremiumTier != null && stickerPackPriceForPremiumTier.intValue() == 0);
    }

    public final Sticker parseFromMessageNotificationJson(String data) {
        if (data == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(data).getJSONArray("stickers").getJSONObject(0);
            m.checkNotNullExpressionValue(jSONObject, "JSONObject(data).getJSON…ickers\").getJSONObject(0)");
            try {
                long j = Long.parseLong(jSONObject.get(ModelAuditLogEntry.CHANGE_KEY_ID).toString());
                Long lValueOf = Long.valueOf(Long.parseLong(jSONObject.get("pack_id").toString()));
                String string = jSONObject.getString(ModelAuditLogEntry.CHANGE_KEY_NAME);
                m.checkNotNullExpressionValue(string, "jsonSticker.getString(\"name\")");
                String string2 = jSONObject.getString(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
                m.checkNotNullExpressionValue(string2, "jsonSticker.getString(\"description\")");
                return new Sticker(j, lValueOf, Long.valueOf(Long.parseLong(jSONObject.get(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID).toString())), string, string2, StickerFormatType.Companion.a(Integer.parseInt(jSONObject.get(ModelAuditLogEntry.CHANGE_KEY_FORMAT_TYPE).toString())), jSONObject.has(ModelAuditLogEntry.CHANGE_KEY_TAGS) ? jSONObject.get(ModelAuditLogEntry.CHANGE_KEY_TAGS).toString() : "", StickerType.Companion.a(Integer.parseInt(jSONObject.get("type").toString())), null, 256);
            } catch (JSONException e) {
                Logger.e$default(AppLog.g, "Error parsing sticker from notification", e, null, 4, null);
                return null;
            }
        } catch (JSONException unused) {
            return null;
        }
    }
}
