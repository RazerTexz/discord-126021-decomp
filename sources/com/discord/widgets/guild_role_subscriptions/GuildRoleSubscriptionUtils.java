package com.discord.widgets.guild_role_subscriptions;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils {
    public static final GuildRoleSubscriptionUtils INSTANCE = new GuildRoleSubscriptionUtils();

    private GuildRoleSubscriptionUtils() {
    }

    private final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionDesign(RestAPI restApi, long guildId, Integer memberColor, String memberIcon, final GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Observable observableG = restApi.updateRole(guildId, guildRoleSubscriptionTierListing.getRoleId(), new RestAPIParams.Role(null, null, null, memberColor, null, null, guildRoleSubscriptionTierListing.getRoleId(), memberIcon, 55, null)).G(new Func1<Void, GuildRoleSubscriptionTierListing>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign.1
            @Override // j0.k.Func1
            public final GuildRoleSubscriptionTierListing call(Void r1) {
                return guildRoleSubscriptionTierListing;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "restApi\n          .updat…onTierListing\n          }");
        return observableG;
    }

    private final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTrial(RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, final GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable<SubscriptionTrialInterval> trialInterval, NullSerializable<Integer> activeTrialUserLimit) {
        if (trialInterval == null && activeTrialUserLimit == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(guildRoleSubscriptionTierListing);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(guildRoleSubscriptionTierListing)");
            return scalarSynchronousObservable;
        }
        Observable observableG = restApi.updateGuildRoleSubscriptionTierFreeTrial(guildId, guildRoleSubscriptionTierListing.getId(), new RestAPIParams.UpdateGuildRoleSubscriptionTierFreeTrial(trialInterval, activeTrialUserLimit)).u(new Action1<GuildRoleSubscriptionTierFreeTrial>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial.1
            @Override // rx.functions.Action1
            public final void call(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                long id2 = guildRoleSubscriptionTierListing.getId();
                Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierFreeTrial, "it");
                storeGuildRoleSubscriptions2.handleGuildRoleSubscriptionTierTrialUpdate(j, id2, guildRoleSubscriptionTierFreeTrial);
            }
        }).G(new Func1<GuildRoleSubscriptionTierFreeTrial, GuildRoleSubscriptionTierListing>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial.2
            @Override // j0.k.Func1
            public final GuildRoleSubscriptionTierListing call(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
                return guildRoleSubscriptionTierListing;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "restApi\n          .updat…SubscriptionTierListing }");
        return observableG;
    }

    public final Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionGroupListing(final RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, String coverImage, String planDescription, Boolean isFullServerGating, final String tierName, final String tierDescription, final int priceTier, final String tierImage, final int memberColor, final String memberBadge, final boolean canAccessAllChannels, final List<? extends Benefit> channelBenefits, final List<? extends Benefit> intangibleBenefits) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(tierName, "tierName");
        Intrinsics3.checkNotNullParameter(channelBenefits, "channelBenefits");
        Intrinsics3.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        Observable<R> observableA = restApi.createGuildRoleSubscriptionGroupListing(guildId, new RestAPIParams.CreateGuildRoleSubscriptionGroupListing(coverImage, planDescription, isFullServerGating)).A(new Func1<GuildRoleSubscriptionGroupListing, Observable<? extends GuildRoleSubscriptionTierListing>>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.createGuildRoleSubscriptionGroupListing.1
            @Override // j0.k.Func1
            public final Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionGroupListing, "subscriptionGroupListing");
                storeGuildRoleSubscriptions2.handleGuildRoleSubscriptionGroupUpdate(j, guildRoleSubscriptionGroupListing);
                return GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionTierListing(restApi, storeGuildRoleSubscriptions, guildId, guildRoleSubscriptionGroupListing.getId(), tierName, tierDescription, priceTier, tierImage, memberColor, memberBadge, canAccessAllChannels, channelBenefits, intangibleBenefits);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "restApi\n        .createG…ts,\n          )\n        }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null);
    }

    public final Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTierListing(final RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, final long groupListingId, String tierName, String tierDescription, int priceTier, String tierImage, final int memberColor, final String memberIcon, boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(tierName, "tierName");
        Intrinsics3.checkNotNullParameter(channelBenefits, "channelBenefits");
        Intrinsics3.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        List listPlus = _Collections.plus((Collection) channelBenefits, (Iterable) intangibleBenefits);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
        Iterator it = listPlus.iterator();
        while (it.hasNext()) {
            arrayList.add(((Benefit) it.next()).toGuildRoleSubscriptionBenefit());
        }
        Observable<R> observableA = restApi.createGuildRoleSubscriptionTier(guildId, groupListingId, new RestAPIParams.CreateGuildRoleSubscriptionTierListing(tierName, tierImage, tierDescription, arrayList, priceTier, canAccessAllChannels)).A(new Func1<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.createGuildRoleSubscriptionTierListing.1
            @Override // j0.k.Func1
            public final Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
                GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
                RestAPI restAPI = restApi;
                long j = guildId;
                Integer numValueOf = Integer.valueOf(memberColor);
                String str = memberIcon;
                Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
                return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign(restAPI, j, numValueOf, str, guildRoleSubscriptionTierListing);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "restApi\n        .createG…ng,\n          )\n        }");
        Observable<GuildRoleSubscriptionTierListing> observableU = ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null).u(new Action1<GuildRoleSubscriptionTierListing>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.createGuildRoleSubscriptionTierListing.2
            @Override // rx.functions.Action1
            public final void call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                long j2 = groupListingId;
                Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "tierListing");
                storeGuildRoleSubscriptions2.handleGuildRoleSubscriptionTierListingCreate(j, j2, guildRoleSubscriptionTierListing);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "restApi\n        .createG…ing\n          )\n        }");
        return observableU;
    }

    public final Observable<Void> deleteGuildRoleSubscriptionTierListing(RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, final long groupListingId, final long tierListingId) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Observable<Void> observableU = ObservableExtensionsKt.restSubscribeOn$default(restApi.deleteGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId), false, 1, null).u(new Action1<Void>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.deleteGuildRoleSubscriptionTierListing.1
            @Override // rx.functions.Action1
            public final void call(Void r8) {
                storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierListingDelete(guildId, groupListingId, tierListingId);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "restApi\n        .deleteG…Id,\n          )\n        }");
        return observableU;
    }

    public final Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, long groupListingId, String coverImage, String planDescription, Boolean isFullServerGating) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Observable<GuildRoleSubscriptionGroupListing> observableU = ObservableExtensionsKt.restSubscribeOn$default(restApi.updateGuildRoleSubscriptionGroupListing(guildId, groupListingId, new RestAPIParams.UpdateGuildRoleSubscriptionGroupListing(coverImage, planDescription, isFullServerGating)), false, 1, null).u(new Action1<GuildRoleSubscriptionGroupListing>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionGroupListing.1
            @Override // rx.functions.Action1
            public final void call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionGroupListing, "groupListing");
                storeGuildRoleSubscriptions2.handleGuildRoleSubscriptionGroupUpdate(j, guildRoleSubscriptionGroupListing);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "restApi\n        .updateG…, groupListing)\n        }");
        return observableU;
    }

    public final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(final RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, long groupListingId, long tierListingId, String tierName, String tierDescription, String tierImage, Integer priceTier, final Integer memberColor, final String memberIcon, Boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits, Boolean published, final NullSerializable<SubscriptionTrialInterval> trialInterval, final NullSerializable<Integer> activeTrialUserLimit) {
        List<? extends Benefit> listPlus;
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        if (channelBenefits == null || intangibleBenefits == null) {
            listPlus = channelBenefits != null ? channelBenefits : intangibleBenefits;
        } else {
            listPlus = _Collections.plus((Collection) channelBenefits, (Iterable) intangibleBenefits);
        }
        if (listPlus != null) {
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
            Iterator<T> it = listPlus.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Benefit) it.next()).toGuildRoleSubscriptionBenefit());
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Observable observableA = restApi.updateGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId, new RestAPIParams.UpdateGuildRoleSubscriptionTierListing(tierName, tierImage, tierDescription, priceTier, arrayList, published, canAccessAllChannels)).A(new Func1<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing.2
            @Override // j0.k.Func1
            public final Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
                GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
                RestAPI restAPI = restApi;
                long j = guildId;
                Integer num = memberColor;
                String str = memberIcon;
                Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
                return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign(restAPI, j, num, str, guildRoleSubscriptionTierListing);
            }
        }).A(new Func1<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing.3
            @Override // j0.k.Func1
            public final Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
                GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
                RestAPI restAPI = restApi;
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
                return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial(restAPI, storeGuildRoleSubscriptions2, j, guildRoleSubscriptionTierListing, trialInterval, activeTrialUserLimit);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "restApi\n        .updateG…it,\n          )\n        }");
        Observable<GuildRoleSubscriptionTierListing> observableU = ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null).u(new Action1<GuildRoleSubscriptionTierListing>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing.4
            @Override // rx.functions.Action1
            public final void call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "it");
                storeGuildRoleSubscriptions2.handleGuildRoleSubscriptionTierListingUpdate(j, guildRoleSubscriptionTierListing);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "restApi\n        .updateG…te(guildId, it)\n        }");
        return observableU;
    }
}
