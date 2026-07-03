package p007b.p008a.p009a.p010a;

import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.a.a.k */
/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0801k extends AbstractC0859d0<c> {

    /* JADX INFO: renamed from: j */
    public static final a f212j = new a(null);

    /* JADX INFO: renamed from: k */
    public final long f213k;

    /* JADX INFO: renamed from: l */
    public final StoreSubscriptions f214l;

    /* JADX INFO: renamed from: m */
    public final StoreGuildBoost f215m;

    /* JADX INFO: renamed from: n */
    public final RestAPI f216n;

    /* JADX INFO: renamed from: b.a.a.a.k$a */
    /* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.k$b */
    /* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final StoreSubscriptions.SubscriptionsState f217a;

        public b(StoreSubscriptions.SubscriptionsState subscriptionsState) {
            C12238m.checkNotNullParameter(subscriptionsState, "subscriptionState");
            this.f217a = subscriptionsState;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && C12238m.areEqual(this.f217a, ((b) obj).f217a);
            }
            return true;
        }

        public int hashCode() {
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.f217a;
            if (subscriptionsState != null) {
                return subscriptionsState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(subscriptionState=");
            sbM833U.append(this.f217a);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.k$c */
    /* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: b.a.a.a.k$c$a */
        /* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
        public static final class a extends c {

            /* JADX INFO: renamed from: a */
            public final Integer f218a;

            public a() {
                this(null, 1);
            }

            public a(Integer num) {
                super(null);
                this.f218a = num;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && C12238m.areEqual(this.f218a, ((a) obj).f218a);
                }
                return true;
            }

            public int hashCode() {
                Integer num = this.f218a;
                if (num != null) {
                    return num.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m818F(C1643a.m833U("Dismiss(errorToastStringResId="), this.f218a, ")");
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ a(Integer num, int i) {
                this(null);
                int i2 = i & 1;
            }
        }

        /* JADX INFO: renamed from: b.a.a.a.k$c$b */
        /* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
        public static final class b extends c {

            /* JADX INFO: renamed from: a */
            public final ModelSubscription f219a;

            /* JADX INFO: renamed from: b */
            public final boolean f220b;

            /* JADX INFO: renamed from: c */
            public final boolean f221c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ModelSubscription modelSubscription, boolean z2, boolean z3) {
                super(null);
                C12238m.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
                this.f219a = modelSubscription;
                this.f220b = z2;
                this.f221c = z3;
            }

            /* JADX INFO: renamed from: a */
            public static b m102a(b bVar, ModelSubscription modelSubscription, boolean z2, boolean z3, int i) {
                ModelSubscription modelSubscription2 = (i & 1) != 0 ? bVar.f219a : null;
                if ((i & 2) != 0) {
                    z2 = bVar.f220b;
                }
                if ((i & 4) != 0) {
                    z3 = bVar.f221c;
                }
                Objects.requireNonNull(bVar);
                C12238m.checkNotNullParameter(modelSubscription2, Traits.Payment.Type.SUBSCRIPTION);
                return new b(modelSubscription2, z2, z3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return C12238m.areEqual(this.f219a, bVar.f219a) && this.f220b == bVar.f220b && this.f221c == bVar.f221c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                ModelSubscription modelSubscription = this.f219a;
                int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
                boolean z2 = this.f220b;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z3 = this.f221c;
                return i + (z3 ? 1 : z3);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(subscription=");
                sbM833U.append(this.f219a);
                sbM833U.append(", uncancelInProgress=");
                sbM833U.append(this.f220b);
                sbM833U.append(", error=");
                return C1643a.m827O(sbM833U, this.f221c, ")");
            }
        }

        /* JADX INFO: renamed from: b.a.a.a.k$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
        public static final class C13205c extends c {

            /* JADX INFO: renamed from: a */
            public static final C13205c f222a = new C13205c();

            public C13205c() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: b.a.a.a.k$c$d */
        /* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
        public static final class d extends c {

            /* JADX INFO: renamed from: a */
            public static final d f223a = new d();

            public d() {
                super(null);
            }
        }

        public c() {
        }

        public c(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0801k(long j, StoreSubscriptions storeSubscriptions, StoreGuildBoost storeGuildBoost, RestAPI restAPI, Observable observable, int i) {
        Observable observableM11083G;
        super(c.C13205c.f222a);
        StoreSubscriptions subscriptions = (i & 2) != 0 ? StoreStream.INSTANCE.getSubscriptions() : null;
        StoreGuildBoost guildBoosts = (i & 4) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : null;
        RestAPI api = (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : null;
        if ((i & 16) != 0) {
            observableM11083G = subscriptions.observeSubscriptions().m11083G(C0800j.f211j);
            C12238m.checkNotNullExpressionValue(observableM11083G, "storeSubscriptions\n     …toreState(it)\n          }");
        } else {
            observableM11083G = null;
        }
        C12238m.checkNotNullParameter(subscriptions, "storeSubscriptions");
        C12238m.checkNotNullParameter(guildBoosts, "storeGuildBoost");
        C12238m.checkNotNullParameter(api, "restAPI");
        C12238m.checkNotNullParameter(observableM11083G, "storeObservable");
        this.f213k = j;
        this.f214l = subscriptions;
        this.f215m = guildBoosts;
        this.f216n = api;
        subscriptions.fetchSubscriptions();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11083G), this, null, 2, null), (Class<?>) C0801k.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C0799i(this));
    }
}
