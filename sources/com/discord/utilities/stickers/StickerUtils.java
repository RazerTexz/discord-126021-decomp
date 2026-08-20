package com.discord.utilities.stickers;

import android.content.Context;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerType;
import com.discord.app.AppLog;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSku;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.sticker.dto.ModelStickerPackStoreListing;
import com.discord.models.user.User;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.file.DownloadUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.premium.PremiumUtilsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Action1;

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
    private static final Lazy DEFAULT_STICKER_SIZE_PX = C12083g.lazy(StickerUtils$DEFAULT_STICKER_SIZE_PX$2.INSTANCE);

    /* JADX INFO: compiled from: StickerUtils.kt */
    public enum StickerSendability {
        SENDABLE,
        SENDABLE_WITH_PREMIUM,
        SENDABLE_WITH_PREMIUM_GUILD,
        NONSENDABLE
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            StickerFormatType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[StickerFormatType.LOTTIE.ordinal()] = 1;
            iArr[StickerFormatType.APNG.ordinal()] = 2;
            iArr[StickerFormatType.PNG.ordinal()] = 3;
            PremiumTier.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[PremiumTier.TIER_2.ordinal()] = 1;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.stickers.StickerUtils$getStickerPackPremiumPriceLabel$1 */
    /* JADX INFO: compiled from: StickerUtils.kt */
    public static final class C69261 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69261(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.strikethroughColor = Integer.valueOf(ColorCompat.getColor(this.$context, C5419R.color.white));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.stickers.StickerUtils$getStickerPackPremiumPriceLabel$2 */
    /* JADX INFO: compiled from: StickerUtils.kt */
    public static final class C69272 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69272(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.strikethroughColor = Integer.valueOf(ColorCompat.getColor(this.$context, C5419R.color.white));
        }
    }

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
        ModelSku.Price price;
        ModelSku.ModelPremiumSkuPrice modelPremiumSkuPrice;
        ModelStickerPackStoreListing storeListing = stickerPack.getStoreListing();
        if (storeListing == null || (sku = storeListing.getSku()) == null || (price = sku.getPrice()) == null) {
            return null;
        }
        Map<PremiumTier, ModelSku.ModelPremiumSkuPrice> premium = price.getPremium();
        return Integer.valueOf((premium == null || (modelPremiumSkuPrice = premium.get(premiumTier)) == null) ? price.getAmount() : modelPremiumSkuPrice.getAmount());
    }

    public static /* synthetic */ StickerSendability getStickerSendability$default(StickerUtils stickerUtils, Sticker sticker, User user, Channel channel, Long l, int i, Object obj) {
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
            storeUser = StoreStream.INSTANCE.getUsers();
        }
        if ((i & 2) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        StoreGuilds storeGuilds2 = storeGuilds;
        if ((i & 4) != 0) {
            storeStickers = StoreStream.INSTANCE.getStickers();
        }
        StoreStickers storeStickers2 = storeStickers;
        if ((i & 8) != 0) {
            storeGuildSelected = StoreStream.INSTANCE.getGuildSelected();
        }
        StoreGuildSelected storeGuildSelected2 = storeGuildSelected;
        if ((i & 16) != 0) {
            storeGuildStickers = StoreStream.INSTANCE.getGuildStickers();
        }
        return stickerUtils.getStickersForAutocomplete(storeUser, storeGuilds2, storeStickers2, storeGuildSelected2, storeGuildStickers);
    }

    public final int calculatePremiumStickerPackDiscount() {
        int stickerPackPrice = getStickerPackPrice(PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY);
        return (int) (((stickerPackPrice - getStickerPackPrice(PremiumTier.TIER_2)) * 100.0f) / stickerPackPrice);
    }

    public final Observable<DownloadUtils.DownloadState> fetchSticker(Context context, BaseSticker sticker) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(sticker, "sticker");
        File file = new File(context.getCacheDir(), "stickers");
        if (!file.exists()) {
            file.mkdir();
        }
        String str = sticker.getId() + sticker.mo8228b();
        File file2 = new File(file, str);
        if (!file2.exists()) {
            return DownloadUtils.downloadFile(context, getCDNAssetUrl$default(this, sticker, null, false, 6, null), str, file);
        }
        C12721k c12721k = new C12721k(new DownloadUtils.DownloadState.Completed(file2));
        C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(Download…oadState.Completed(file))");
        return c12721k;
    }

    public final Set<Sticker> findStickerMatches(String searchText, List<Sticker> stickers, boolean allowPartialMatches) {
        boolean z2;
        boolean z3;
        C12238m.checkNotNullParameter(searchText, "searchText");
        C12238m.checkNotNullParameter(stickers, "stickers");
        if (searchText.length() == 0) {
            return C12148n0.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        LinkedHashSet linkedHashSet5 = new LinkedHashSet();
        Set<String> queriesFromSearchText = SearchUtils.INSTANCE.getQueriesFromSearchText(searchText);
        if (queriesFromSearchText.size() > 5) {
            return C12148n0.emptySet();
        }
        for (String str : queriesFromSearchText) {
            for (Sticker sticker : stickers) {
                if (C12103t.equals(sticker.getName(), str, true)) {
                    linkedHashSet2.add(sticker);
                } else if (allowPartialMatches && C12103t.startsWith(sticker.getName(), str, true)) {
                    linkedHashSet3.add(sticker);
                } else if (sticker.getType() == StickerType.GUILD) {
                    List listSplit$default = C12106w.split$default((CharSequence) sticker.getName(), new String[]{" "}, false, 0, 6, (Object) null);
                    if (!(listSplit$default instanceof Collection) || !listSplit$default.isEmpty()) {
                        Iterator it = listSplit$default.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (C12103t.equals((String) it.next(), str, true)) {
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
                List<String> listSplit$default2 = C12106w.split$default((CharSequence) sticker.getTags(), new String[]{","}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listSplit$default2, 10));
                for (String str2 : listSplit$default2) {
                    Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
                    arrayList.add(C12106w.trim(str2).toString());
                }
                ArrayList<String> arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (!C12103t.isBlank((String) obj)) {
                        arrayList2.add(obj);
                    }
                }
                String strReplace$default = C12103t.replace$default(str, ":", "", false, 4, (Object) null);
                for (String str3 : arrayList2) {
                    if (C12103t.equals(str3, strReplace$default, true)) {
                        linkedHashSet4.add(sticker);
                    } else if (allowPartialMatches && C12103t.startsWith(str3, strReplace$default, true)) {
                        linkedHashSet5.add(sticker);
                    } else if (sticker.getType() == StickerType.GUILD) {
                        List listSplit$default3 = C12106w.split$default((CharSequence) sticker.getTags(), new String[]{"_"}, false, 0, 6, (Object) null);
                        if (!(listSplit$default3 instanceof Collection) || !listSplit$default3.isEmpty()) {
                            Iterator it2 = listSplit$default3.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z3 = false;
                                    break;
                                }
                                if (C12103t.equals((String) it2.next(), str, true)) {
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
        C12238m.checkNotNullParameter(stickerPack, "stickerPack");
        StringBuilder sb = new StringBuilder();
        sb.append("https://cdn.discordapp.com/app-assets/710982414301790216/store/");
        sb.append(stickerPack.getBannerAssetId());
        sb.append('.');
        sb.append(StringUtilsKt.getSTATIC_IMAGE_EXTENSION());
        if (size != null) {
            StringBuilder sbM833U = C1643a.m833U("?size=");
            sbM833U.append(IconUtils.getMediaProxySize(size.intValue()));
            string = sbM833U.toString();
        } else {
            string = "";
        }
        sb.append(string);
        return sb.toString();
    }

    public final String getCDNAssetUrl(BaseSticker sticker, Integer size, boolean passthrough) {
        C12238m.checkNotNullParameter(sticker, "sticker");
        int iOrdinal = sticker.getFormatType().ordinal();
        String string = "";
        if (iOrdinal != 1 && iOrdinal != 2) {
            if (iOrdinal != 3) {
                return "";
            }
            StringBuilder sbM833U = C1643a.m833U("https://discord.com/stickers/");
            sbM833U.append(sticker.getId());
            sbM833U.append(sticker.mo8228b());
            return sbM833U.toString();
        }
        StringBuilder sbM833U2 = C1643a.m833U("https://media.discordapp.net/stickers/");
        sbM833U2.append(sticker.getId());
        sbM833U2.append(sticker.mo8228b());
        sbM833U2.append("?passthrough=");
        sbM833U2.append(passthrough);
        if (size != null) {
            StringBuilder sbM833U3 = C1643a.m833U("&size=");
            sbM833U3.append(IconUtils.getMediaProxySize(size.intValue()));
            string = sbM833U3.toString();
        }
        sbM833U2.append(string);
        return sbM833U2.toString();
    }

    public final int getDEFAULT_STICKER_SIZE_PX() {
        return ((Number) DEFAULT_STICKER_SIZE_PX.getValue()).intValue();
    }

    public final Observable<Sticker> getGuildOrStandardSticker(long stickerId, boolean fetchIfMissing) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Sticker sticker = companion.getStickers().getStickers().get(Long.valueOf(stickerId));
        if (sticker != null) {
            C12721k c12721k = new C12721k(sticker);
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(fullStandardSticker)");
            return c12721k;
        }
        Sticker guildSticker = companion.getGuildStickers().getGuildSticker(stickerId);
        if (guildSticker != null) {
            C12721k c12721k2 = new C12721k(guildSticker);
            C12238m.checkNotNullExpressionValue(c12721k2, "Observable.just(fullGuildSticker)");
            return c12721k2;
        }
        if (fetchIfMissing) {
            Observable<Sticker> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getSticker(stickerId), false, 1, null).m11115u(new Action1<Sticker>() { // from class: com.discord.utilities.stickers.StickerUtils.getGuildOrStandardSticker.1
                @Override // p658rx.functions.Action1
                public final void call(Sticker sticker2) {
                    StoreStream.Companion companion2 = StoreStream.INSTANCE;
                    companion2.getStickers().handleFetchedSticker(sticker2);
                    companion2.getGuildStickers().handleFetchedSticker(sticker2);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11115u, "RestAPI\n        .api\n   …fetchedSticker)\n        }");
            return observableM11115u;
        }
        C12721k c12721k3 = new C12721k(null);
        C12238m.checkNotNullExpressionValue(c12721k3, "Observable.just(null)");
        return c12721k3;
    }

    public final CharSequence getLimitedTimeLeftString(Context context, ModelStickerPackStoreListing stickerPackStoreListing) {
        C12238m.checkNotNullParameter(context, "context");
        if ((stickerPackStoreListing != null ? stickerPackStoreListing.getUnpublishedAt() : null) == null) {
            return "";
        }
        long unpublishedAtDate = stickerPackStoreListing.getUnpublishedAtDate() - ClockFactory.get().currentTimeMillis();
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        int daysFromMillis = timeUtils.getDaysFromMillis(unpublishedAtDate);
        if (daysFromMillis > 0) {
            return StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.duration_days_days, daysFromMillis, Integer.valueOf(daysFromMillis));
        }
        int hoursFromMillis = timeUtils.getHoursFromMillis(unpublishedAtDate);
        long j = unpublishedAtDate - (((long) hoursFromMillis) * 3600000);
        int minutesFromMillis = timeUtils.getMinutesFromMillis(j);
        int secondsFromMillis = timeUtils.getSecondsFromMillis(j - (((long) minutesFromMillis) * 60000));
        return (hoursFromMillis < 0 || minutesFromMillis < 0 || secondsFromMillis < 0) ? C1107b.m216h(context, C5419R.string.sticker_picker_pack_expiring_soon, new Object[0], null, 4) : C1107b.m216h(context, C5419R.string.duration_hours_minutes_seconds, new Object[]{C1643a.m828P(new Object[]{Integer.valueOf(hoursFromMillis)}, 1, "%02d", "java.lang.String.format(format, *args)"), C1643a.m828P(new Object[]{Integer.valueOf(minutesFromMillis)}, 1, "%02d", "java.lang.String.format(format, *args)"), C1643a.m828P(new Object[]{Integer.valueOf(secondsFromMillis)}, 1, "%02d", "java.lang.String.format(format, *args)")}, null, 4);
    }

    public final CharSequence getStickerPackPremiumPriceLabel(Context context, ModelStickerPack stickerPack, PremiumTier currentPremiumTier, boolean isPackEnabled) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(stickerPack, "stickerPack");
        C12238m.checkNotNullParameter(currentPremiumTier, "currentPremiumTier");
        if (isPackEnabled && !PremiumUtilsKt.grantsAccessToPremiumStickers(currentPremiumTier)) {
            return C1107b.m216h(context, C5419R.string.sticker_pack_premium_cta, new Object[0], null, 4);
        }
        PremiumTier premiumTier = PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY;
        if (currentPremiumTier != premiumTier) {
            Integer stickerPackPriceForPremiumTier = getStickerPackPriceForPremiumTier(stickerPack, premiumTier);
            Integer stickerPackPriceForPremiumTier2 = getStickerPackPriceForPremiumTier(stickerPack, currentPremiumTier);
            if (stickerPackPriceForPremiumTier != null && stickerPackPriceForPremiumTier2 != null && (!C12238m.areEqual(stickerPackPriceForPremiumTier, stickerPackPriceForPremiumTier2))) {
                CharSequence formattedPriceUsd = com.discord.utilities.billing.PremiumUtilsKt.getFormattedPriceUsd(stickerPackPriceForPremiumTier.intValue(), context);
                return stickerPackPriceForPremiumTier2.intValue() == 0 ? C1107b.m210b(context, C5419R.string.sticker_picker_discounted_free_android, new Object[]{formattedPriceUsd}, new C69261(context)) : C1107b.m210b(context, C5419R.string.sticker_picker_discounted_price_android, new Object[]{com.discord.utilities.billing.PremiumUtilsKt.getFormattedPriceUsd(stickerPackPriceForPremiumTier2.intValue(), context), formattedPriceUsd}, new C69272(context));
            }
        }
        if (isStickerPackFreeForPremiumTier(stickerPack, currentPremiumTier)) {
            return C1107b.m216h(context, C5419R.string.sticker_pack_price_free, new Object[0], null, 4);
        }
        PremiumTier premiumTier2 = PremiumTier.TIER_1;
        if (isStickerPackFreeForPremiumTier(stickerPack, premiumTier2) && !PremiumUtils.INSTANCE.isPremiumTierAtLeast(currentPremiumTier, premiumTier2)) {
            return C1107b.m216h(context, C5419R.string.sticker_pack_price_free_with_premium_tier_1, new Object[0], null, 4);
        }
        PremiumTier premiumTier3 = PremiumTier.TIER_2;
        if (isStickerPackFreeForPremiumTier(stickerPack, premiumTier3) && !PremiumUtils.INSTANCE.isPremiumTierAtLeast(currentPremiumTier, premiumTier3)) {
            return C1107b.m216h(context, C5419R.string.sticker_pack_price_free_with_premium_tier_2, new Object[0], null, 4);
        }
        PremiumTier premiumTier4 = PremiumTier.TIER_0;
        if (isStickerPackFreeForPremiumTier(stickerPack, premiumTier4) && !PremiumUtils.INSTANCE.isPremiumTierAtLeast(currentPremiumTier, premiumTier4) && currentPremiumTier != premiumTier2) {
            return C1107b.m216h(context, C5419R.string.sticker_pack_price_free_with_premium_tier_2, new Object[0], null, 4);
        }
        CharSequence formattedPriceUsd2 = com.discord.utilities.billing.PremiumUtilsKt.getFormattedPriceUsd(getStickerPackPrice(premiumTier3), context);
        return PremiumUtilsKt.grantsAccessToPremiumStickers(currentPremiumTier) ? formattedPriceUsd2 : C1107b.m216h(context, C5419R.string.sticker_picker_price_with_premium_tier_2, new Object[]{formattedPriceUsd2}, null, 4);
    }

    public final StickerSendability getStickerSendability(Sticker sticker, User meUser, Channel currentChannel, Long currentChannelPermissions) {
        C12238m.checkNotNullParameter(sticker, "sticker");
        C12238m.checkNotNullParameter(meUser, "meUser");
        boolean canUsePremiumStickers = UserUtils.INSTANCE.getCanUsePremiumStickers(meUser);
        if (sticker.getType() == StickerType.STANDARD) {
            return canUsePremiumStickers ? StickerSendability.SENDABLE : StickerSendability.SENDABLE_WITH_PREMIUM;
        }
        if (sticker.getType() != StickerType.GUILD) {
            return StickerSendability.NONSENDABLE;
        }
        if (C12238m.areEqual(sticker.getAvailable(), Boolean.FALSE)) {
            return StickerSendability.SENDABLE_WITH_PREMIUM_GUILD;
        }
        if (C12238m.areEqual(sticker.getGuildId(), currentChannel != null ? Long.valueOf(currentChannel.getGuildId()) : null)) {
            return StickerSendability.SENDABLE;
        }
        if (currentChannel == null || ChannelUtils.m7667B(currentChannel) || PermissionUtils.can(Permission.USE_EXTERNAL_STICKERS, currentChannelPermissions)) {
            return canUsePremiumStickers ? StickerSendability.SENDABLE : StickerSendability.SENDABLE_WITH_PREMIUM;
        }
        return StickerSendability.NONSENDABLE;
    }

    public final List<Sticker> getStickersForAutocomplete(StoreUser storeUser, StoreGuilds storeGuilds, StoreStickers storeStickers, StoreGuildSelected storeGuildSelected, StoreGuildStickers storeGuildStickers) {
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeStickers, "storeStickers");
        C12238m.checkNotNullParameter(storeGuildSelected, "storeGuildSelected");
        C12238m.checkNotNullParameter(storeGuildStickers, "storeGuildStickers");
        boolean canUsePremiumStickers = UserUtils.INSTANCE.getCanUsePremiumStickers(storeUser.getMeSnapshot());
        List<Sticker> enabledStickers = canUsePremiumStickers ? storeStickers.getEnabledStickers() : C12147n.emptyList();
        Set<Long> setKeySet = canUsePremiumStickers ? storeGuilds.getGuilds().keySet() : C12146m0.setOf(Long.valueOf(storeGuildSelected.getSelectedGuildId()));
        List<Sticker> allGuildStickersFlattened = storeGuildStickers.getAllGuildStickersFlattened();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allGuildStickersFlattened) {
            if (C12163u.contains(setKeySet, ((Sticker) obj).getGuildId())) {
                arrayList.add(obj);
            }
        }
        return C12163u.plus((Collection) enabledStickers, (Iterable) arrayList);
    }

    public final boolean isStickerPackFreeForPremiumTier(ModelStickerPack stickerPack, PremiumTier premiumTier) {
        C12238m.checkNotNullParameter(stickerPack, "stickerPack");
        C12238m.checkNotNullParameter(premiumTier, "premiumTier");
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
            C12238m.checkNotNullExpressionValue(jSONObject, "JSONObject(data).getJSON…ickers\").getJSONObject(0)");
            try {
                long j = Long.parseLong(jSONObject.get(ModelAuditLogEntry.CHANGE_KEY_ID).toString());
                Long lValueOf = Long.valueOf(Long.parseLong(jSONObject.get("pack_id").toString()));
                String string = jSONObject.getString(ModelAuditLogEntry.CHANGE_KEY_NAME);
                C12238m.checkNotNullExpressionValue(string, "jsonSticker.getString(\"name\")");
                String string2 = jSONObject.getString(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
                C12238m.checkNotNullExpressionValue(string2, "jsonSticker.getString(\"description\")");
                return new Sticker(j, lValueOf, Long.valueOf(Long.parseLong(jSONObject.get(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID).toString())), string, string2, StickerFormatType.INSTANCE.m8242a(Integer.parseInt(jSONObject.get(ModelAuditLogEntry.CHANGE_KEY_FORMAT_TYPE).toString())), jSONObject.has(ModelAuditLogEntry.CHANGE_KEY_TAGS) ? jSONObject.get(ModelAuditLogEntry.CHANGE_KEY_TAGS).toString() : "", StickerType.INSTANCE.m8244a(Integer.parseInt(jSONObject.get("type").toString())), null, 256);
            } catch (JSONException e) {
                Logger.e$default(AppLog.f14950g, "Error parsing sticker from notification", e, null, 4, null);
                return null;
            }
        } catch (JSONException unused) {
            return null;
        }
    }
}
