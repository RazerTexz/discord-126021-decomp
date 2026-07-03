package com.discord.widgets.guild_role_subscriptions;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: GuildRoleSubscriptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils {
    public static final GuildRoleSubscriptionUtils INSTANCE = new GuildRoleSubscriptionUtils();

    private GuildRoleSubscriptionUtils() {
    }

    private final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionDesign(RestAPI restApi, long guildId, Integer memberColor, String memberIcon, final GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Observable observableM11083G = restApi.updateRole(guildId, guildRoleSubscriptionTierListing.getRoleId(), new RestAPIParams.Role(null, null, null, memberColor, null, null, guildRoleSubscriptionTierListing.getRoleId(), memberIcon, 55, null)).m11083G(new InterfaceC12589b<Void, GuildRoleSubscriptionTierListing>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final GuildRoleSubscriptionTierListing call(Void r1) {
                return guildRoleSubscriptionTierListing;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "restApi\n          .updat…onTierListing\n          }");
        return observableM11083G;
    }

    private final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTrial(RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, final GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable<SubscriptionTrialInterval> trialInterval, NullSerializable<Integer> activeTrialUserLimit) {
        if (trialInterval == null && activeTrialUserLimit == null) {
            C12721k c12721k = new C12721k(guildRoleSubscriptionTierListing);
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(guildRoleSubscriptionTierListing)");
            return c12721k;
        }
        Observable observableM11083G = restApi.updateGuildRoleSubscriptionTierFreeTrial(guildId, guildRoleSubscriptionTierListing.getId(), new RestAPIParams.UpdateGuildRoleSubscriptionTierFreeTrial(trialInterval, activeTrialUserLimit)).m11115u(new Action1<GuildRoleSubscriptionTierFreeTrial>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial.1
            @Override // p658rx.functions.Action1
            public final void call(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                long id2 = guildRoleSubscriptionTierListing.getId();
                C12238m.checkNotNullExpressionValue(guildRoleSubscriptionTierFreeTrial, "it");
                storeGuildRoleSubscriptions2.handleGuildRoleSubscriptionTierTrialUpdate(j, id2, guildRoleSubscriptionTierFreeTrial);
            }
        }).m11083G(new InterfaceC12589b<GuildRoleSubscriptionTierFreeTrial, GuildRoleSubscriptionTierListing>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final GuildRoleSubscriptionTierListing call(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
                return guildRoleSubscriptionTierListing;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "restApi\n          .updat…SubscriptionTierListing }");
        return observableM11083G;
    }

    public final Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionGroupListing(final RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, String coverImage, String planDescription, Boolean isFullServerGating, final String tierName, final String tierDescription, final int priceTier, final String tierImage, final int memberColor, final String memberBadge, final boolean canAccessAllChannels, final List<? extends Benefit> channelBenefits, final List<? extends Benefit> intangibleBenefits) {
        C12238m.checkNotNullParameter(restApi, "restApi");
        C12238m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        C12238m.checkNotNullParameter(tierName, "tierName");
        C12238m.checkNotNullParameter(channelBenefits, "channelBenefits");
        C12238m.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        Observable<R> observableM11082A = restApi.createGuildRoleSubscriptionGroupListing(guildId, new RestAPIParams.CreateGuildRoleSubscriptionGroupListing(coverImage, planDescription, isFullServerGating)).m11082A(new InterfaceC12589b<GuildRoleSubscriptionGroupListing, Observable<? extends GuildRoleSubscriptionTierListing>>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.createGuildRoleSubscriptionGroupListing.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                C12238m.checkNotNullExpressionValue(guildRoleSubscriptionGroupListing, "subscriptionGroupListing");
                storeGuildRoleSubscriptions2.handleGuildRoleSubscriptionGroupUpdate(j, guildRoleSubscriptionGroupListing);
                return GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionTierListing(restApi, storeGuildRoleSubscriptions, guildId, guildRoleSubscriptionGroupListing.getId(), tierName, tierDescription, priceTier, tierImage, memberColor, memberBadge, canAccessAllChannels, channelBenefits, intangibleBenefits);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "restApi\n        .createG…ts,\n          )\n        }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableM11082A, false, 1, null);
    }

    public final Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTierListing(final RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, final long groupListingId, String tierName, String tierDescription, int priceTier, String tierImage, final int memberColor, final String memberIcon, boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits) {
        C12238m.checkNotNullParameter(restApi, "restApi");
        C12238m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        C12238m.checkNotNullParameter(tierName, "tierName");
        C12238m.checkNotNullParameter(channelBenefits, "channelBenefits");
        C12238m.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        List listPlus = C12163u.plus((Collection) channelBenefits, (Iterable) intangibleBenefits);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listPlus, 10));
        Iterator it = listPlus.iterator();
        while (it.hasNext()) {
            arrayList.add(((Benefit) it.next()).toGuildRoleSubscriptionBenefit());
        }
        Observable<R> observableM11082A = restApi.createGuildRoleSubscriptionTier(guildId, groupListingId, new RestAPIParams.CreateGuildRoleSubscriptionTierListing(tierName, tierImage, tierDescription, arrayList, priceTier, canAccessAllChannels)).m11082A(new InterfaceC12589b<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.createGuildRoleSubscriptionTierListing.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
                GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
                RestAPI restAPI = restApi;
                long j = guildId;
                Integer numValueOf = Integer.valueOf(memberColor);
                String str = memberIcon;
                C12238m.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
                return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign(restAPI, j, numValueOf, str, guildRoleSubscriptionTierListing);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "restApi\n        .createG…ng,\n          )\n        }");
        Observable<GuildRoleSubscriptionTierListing> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(observableM11082A, false, 1, null).m11115u(new Action1<GuildRoleSubscriptionTierListing>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.createGuildRoleSubscriptionTierListing.2
            @Override // p658rx.functions.Action1
            public final void call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                long j2 = groupListingId;
                C12238m.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "tierListing");
                storeGuildRoleSubscriptions2.handleGuildRoleSubscriptionTierListingCreate(j, j2, guildRoleSubscriptionTierListing);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "restApi\n        .createG…ing\n          )\n        }");
        return observableM11115u;
    }

    public final Observable<Void> deleteGuildRoleSubscriptionTierListing(RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, final long groupListingId, final long tierListingId) {
        C12238m.checkNotNullParameter(restApi, "restApi");
        C12238m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Observable<Void> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(restApi.deleteGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId), false, 1, null).m11115u(new Action1<Void>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.deleteGuildRoleSubscriptionTierListing.1
            @Override // p658rx.functions.Action1
            public final void call(Void r8) {
                storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierListingDelete(guildId, groupListingId, tierListingId);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "restApi\n        .deleteG…Id,\n          )\n        }");
        return observableM11115u;
    }

    public final Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, long groupListingId, String coverImage, String planDescription, Boolean isFullServerGating) {
        C12238m.checkNotNullParameter(restApi, "restApi");
        C12238m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Observable<GuildRoleSubscriptionGroupListing> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(restApi.updateGuildRoleSubscriptionGroupListing(guildId, groupListingId, new RestAPIParams.UpdateGuildRoleSubscriptionGroupListing(coverImage, planDescription, isFullServerGating)), false, 1, null).m11115u(new Action1<GuildRoleSubscriptionGroupListing>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionGroupListing.1
            @Override // p658rx.functions.Action1
            public final void call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                C12238m.checkNotNullExpressionValue(guildRoleSubscriptionGroupListing, "groupListing");
                storeGuildRoleSubscriptions2.handleGuildRoleSubscriptionGroupUpdate(j, guildRoleSubscriptionGroupListing);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "restApi\n        .updateG…, groupListing)\n        }");
        return observableM11115u;
    }

    public final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(final RestAPI restApi, final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, final long guildId, long groupListingId, long tierListingId, String tierName, String tierDescription, String tierImage, Integer priceTier, final Integer memberColor, final String memberIcon, Boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits, Boolean published, final NullSerializable<SubscriptionTrialInterval> trialInterval, final NullSerializable<Integer> activeTrialUserLimit) {
        List<? extends Benefit> listPlus;
        ArrayList arrayList;
        C12238m.checkNotNullParameter(restApi, "restApi");
        C12238m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        if (channelBenefits == null || intangibleBenefits == null) {
            listPlus = channelBenefits != null ? channelBenefits : intangibleBenefits;
        } else {
            listPlus = C12163u.plus((Collection) channelBenefits, (Iterable) intangibleBenefits);
        }
        if (listPlus != null) {
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(listPlus, 10));
            Iterator<T> it = listPlus.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Benefit) it.next()).toGuildRoleSubscriptionBenefit());
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Observable observableM11082A = restApi.updateGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId, new RestAPIParams.UpdateGuildRoleSubscriptionTierListing(tierName, tierImage, tierDescription, priceTier, arrayList, published, canAccessAllChannels)).m11082A(new InterfaceC12589b<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
                GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
                RestAPI restAPI = restApi;
                long j = guildId;
                Integer num = memberColor;
                String str = memberIcon;
                C12238m.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
                return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign(restAPI, j, num, str, guildRoleSubscriptionTierListing);
            }
        }).m11082A(new InterfaceC12589b<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing.3
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
                GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
                RestAPI restAPI = restApi;
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                C12238m.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
                return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial(restAPI, storeGuildRoleSubscriptions2, j, guildRoleSubscriptionTierListing, trialInterval, activeTrialUserLimit);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "restApi\n        .updateG…it,\n          )\n        }");
        Observable<GuildRoleSubscriptionTierListing> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(observableM11082A, false, 1, null).m11115u(new Action1<GuildRoleSubscriptionTierListing>() { // from class: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing.4
            @Override // p658rx.functions.Action1
            public final void call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions2 = storeGuildRoleSubscriptions;
                long j = guildId;
                C12238m.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "it");
                storeGuildRoleSubscriptions2.handleGuildRoleSubscriptionTierListingUpdate(j, guildRoleSubscriptionTierListing);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "restApi\n        .updateG…te(guildId, it)\n        }");
        return observableM11115u;
    }
}
