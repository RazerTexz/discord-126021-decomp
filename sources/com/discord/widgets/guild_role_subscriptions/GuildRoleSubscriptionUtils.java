package com.discord.widgets.guild_role_subscriptions;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams$CreateGuildRoleSubscriptionGroupListing;
import com.discord.restapi.RestAPIParams$CreateGuildRoleSubscriptionTierListing;
import com.discord.restapi.RestAPIParams$Role;
import com.discord.restapi.RestAPIParams$UpdateGuildRoleSubscriptionGroupListing;
import com.discord.restapi.RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial;
import com.discord.restapi.RestAPIParams$UpdateGuildRoleSubscriptionTierListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils {
    public static final GuildRoleSubscriptionUtils INSTANCE = new GuildRoleSubscriptionUtils();

    private GuildRoleSubscriptionUtils() {
    }

    public static final /* synthetic */ Observable access$updateGuildRoleSubscriptionDesign(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, long j, Integer num, String str, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign(restAPI, j, num, str, guildRoleSubscriptionTierListing);
    }

    public static final /* synthetic */ Observable access$updateGuildRoleSubscriptionTrial(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable nullSerializable, NullSerializable nullSerializable2) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial(restAPI, storeGuildRoleSubscriptions, j, guildRoleSubscriptionTierListing, nullSerializable, nullSerializable2);
    }

    public static /* synthetic */ Observable createGuildRoleSubscriptionGroupListing$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, String str, String str2, Boolean bool, String str3, String str4, int i, String str5, int i2, String str6, boolean z2, List list, List list2, int i3, Object obj) {
        return guildRoleSubscriptionUtils.createGuildRoleSubscriptionGroupListing(restAPI, storeGuildRoleSubscriptions, j, str, str2, bool, str3, str4, i, (i3 & 512) != 0 ? null : str5, i2, (i3 & 2048) != 0 ? null : str6, z2, list, list2);
    }

    public static /* synthetic */ Observable createGuildRoleSubscriptionTierListing$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2, String str, String str2, int i, String str3, int i2, String str4, boolean z2, List list, List list2, int i3, Object obj) {
        return guildRoleSubscriptionUtils.createGuildRoleSubscriptionTierListing(restAPI, storeGuildRoleSubscriptions, j, j2, str, str2, i, (i3 & 128) != 0 ? null : str3, i2, (i3 & 512) != 0 ? null : str4, z2, list, list2);
    }

    private final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionDesign(RestAPI restApi, long guildId, Integer memberColor, String memberIcon, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Observable observableG = restApi.updateRole(guildId, guildRoleSubscriptionTierListing.getRoleId(), new RestAPIParams$Role(null, null, null, memberColor, null, null, guildRoleSubscriptionTierListing.getRoleId(), memberIcon, 55, null)).G(new GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionDesign$1(guildRoleSubscriptionTierListing));
        m.checkNotNullExpressionValue(observableG, "restApi\n          .updat…onTierListing\n          }");
        return observableG;
    }

    public static /* synthetic */ Observable updateGuildRoleSubscriptionDesign$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, long j, Integer num, String str, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, int i, Object obj) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign(restAPI, j, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str, guildRoleSubscriptionTierListing);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable updateGuildRoleSubscriptionTierListing$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2, long j3, String str, String str2, String str3, Integer num, Integer num2, String str4, Boolean bool, List list, List list2, Boolean bool2, NullSerializable nullSerializable, NullSerializable nullSerializable2, int i, Object obj) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing(restAPI, storeGuildRoleSubscriptions, j, j2, j3, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : str4, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : list, (i & 8192) != 0 ? null : list2, (i & 16384) != 0 ? null : bool2, (32768 & i) != 0 ? null : nullSerializable, (i & 65536) != 0 ? null : nullSerializable2);
    }

    private final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTrial(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable<SubscriptionTrialInterval> trialInterval, NullSerializable<Integer> activeTrialUserLimit) {
        if (trialInterval == null && activeTrialUserLimit == null) {
            k kVar = new k(guildRoleSubscriptionTierListing);
            m.checkNotNullExpressionValue(kVar, "Observable.just(guildRoleSubscriptionTierListing)");
            return kVar;
        }
        Observable observableG = restApi.updateGuildRoleSubscriptionTierFreeTrial(guildId, guildRoleSubscriptionTierListing.getId(), new RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial(trialInterval, activeTrialUserLimit)).u(new GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTrial$1(storeGuildRoleSubscriptions, guildId, guildRoleSubscriptionTierListing)).G(new GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTrial$2(guildRoleSubscriptionTierListing));
        m.checkNotNullExpressionValue(observableG, "restApi\n          .updat…SubscriptionTierListing }");
        return observableG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable updateGuildRoleSubscriptionTrial$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable nullSerializable, NullSerializable nullSerializable2, int i, Object obj) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial(restAPI, storeGuildRoleSubscriptions, j, guildRoleSubscriptionTierListing, (i & 16) != 0 ? null : nullSerializable, (i & 32) != 0 ? null : nullSerializable2);
    }

    public final Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionGroupListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, String coverImage, String planDescription, Boolean isFullServerGating, String tierName, String tierDescription, int priceTier, String tierImage, int memberColor, String memberBadge, boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits) {
        m.checkNotNullParameter(restApi, "restApi");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        m.checkNotNullParameter(tierName, "tierName");
        m.checkNotNullParameter(channelBenefits, "channelBenefits");
        m.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        Observable<R> observableA = restApi.createGuildRoleSubscriptionGroupListing(guildId, new RestAPIParams$CreateGuildRoleSubscriptionGroupListing(coverImage, planDescription, isFullServerGating)).A(new GuildRoleSubscriptionUtils$createGuildRoleSubscriptionGroupListing$1(storeGuildRoleSubscriptions, guildId, restApi, tierName, tierDescription, priceTier, tierImage, memberColor, memberBadge, canAccessAllChannels, channelBenefits, intangibleBenefits));
        m.checkNotNullExpressionValue(observableA, "restApi\n        .createG…ts,\n          )\n        }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null);
    }

    public final Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTierListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, String tierName, String tierDescription, int priceTier, String tierImage, int memberColor, String memberIcon, boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits) {
        m.checkNotNullParameter(restApi, "restApi");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        m.checkNotNullParameter(tierName, "tierName");
        m.checkNotNullParameter(channelBenefits, "channelBenefits");
        m.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        List listPlus = u.plus((Collection) channelBenefits, (Iterable) intangibleBenefits);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listPlus, 10));
        Iterator it = listPlus.iterator();
        while (it.hasNext()) {
            arrayList.add(((Benefit) it.next()).toGuildRoleSubscriptionBenefit());
        }
        Observable<R> observableA = restApi.createGuildRoleSubscriptionTier(guildId, groupListingId, new RestAPIParams$CreateGuildRoleSubscriptionTierListing(tierName, tierImage, tierDescription, arrayList, priceTier, canAccessAllChannels)).A(new GuildRoleSubscriptionUtils$createGuildRoleSubscriptionTierListing$1(restApi, guildId, memberColor, memberIcon));
        m.checkNotNullExpressionValue(observableA, "restApi\n        .createG…ng,\n          )\n        }");
        Observable<GuildRoleSubscriptionTierListing> observableU = ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null).u(new GuildRoleSubscriptionUtils$createGuildRoleSubscriptionTierListing$2(storeGuildRoleSubscriptions, guildId, groupListingId));
        m.checkNotNullExpressionValue(observableU, "restApi\n        .createG…ing\n          )\n        }");
        return observableU;
    }

    public final Observable<Void> deleteGuildRoleSubscriptionTierListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, long tierListingId) {
        m.checkNotNullParameter(restApi, "restApi");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Observable<Void> observableU = ObservableExtensionsKt.restSubscribeOn$default(restApi.deleteGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId), false, 1, null).u(new GuildRoleSubscriptionUtils$deleteGuildRoleSubscriptionTierListing$1(storeGuildRoleSubscriptions, guildId, groupListingId, tierListingId));
        m.checkNotNullExpressionValue(observableU, "restApi\n        .deleteG…Id,\n          )\n        }");
        return observableU;
    }

    public final Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, String coverImage, String planDescription, Boolean isFullServerGating) {
        m.checkNotNullParameter(restApi, "restApi");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Observable<GuildRoleSubscriptionGroupListing> observableU = ObservableExtensionsKt.restSubscribeOn$default(restApi.updateGuildRoleSubscriptionGroupListing(guildId, groupListingId, new RestAPIParams$UpdateGuildRoleSubscriptionGroupListing(coverImage, planDescription, isFullServerGating)), false, 1, null).u(new GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionGroupListing$1(storeGuildRoleSubscriptions, guildId));
        m.checkNotNullExpressionValue(observableU, "restApi\n        .updateG…, groupListing)\n        }");
        return observableU;
    }

    public final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, long tierListingId, String tierName, String tierDescription, String tierImage, Integer priceTier, Integer memberColor, String memberIcon, Boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits, Boolean published, NullSerializable<SubscriptionTrialInterval> trialInterval, NullSerializable<Integer> activeTrialUserLimit) {
        List<? extends Benefit> listPlus;
        ArrayList arrayList;
        m.checkNotNullParameter(restApi, "restApi");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        if (channelBenefits == null || intangibleBenefits == null) {
            listPlus = channelBenefits != null ? channelBenefits : intangibleBenefits;
        } else {
            listPlus = u.plus((Collection) channelBenefits, (Iterable) intangibleBenefits);
        }
        if (listPlus != null) {
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(listPlus, 10));
            Iterator<T> it = listPlus.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Benefit) it.next()).toGuildRoleSubscriptionBenefit());
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Observable observableA = restApi.updateGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId, new RestAPIParams$UpdateGuildRoleSubscriptionTierListing(tierName, tierImage, tierDescription, priceTier, arrayList, published, canAccessAllChannels)).A(new GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$2(restApi, guildId, memberColor, memberIcon)).A(new GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$3(restApi, storeGuildRoleSubscriptions, guildId, trialInterval, activeTrialUserLimit));
        m.checkNotNullExpressionValue(observableA, "restApi\n        .updateG…it,\n          )\n        }");
        Observable<GuildRoleSubscriptionTierListing> observableU = ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null).u(new GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$4(storeGuildRoleSubscriptions, guildId));
        m.checkNotNullExpressionValue(observableU, "restApi\n        .updateG…te(guildId, it)\n        }");
        return observableU;
    }
}
