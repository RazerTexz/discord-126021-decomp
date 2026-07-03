package p007b.p008a.p009a.p013d;

import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.d.f */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0822f extends AbstractC0859d0<d> {

    /* JADX INFO: renamed from: j */
    public static final a f329j = new a(null);

    /* JADX INFO: renamed from: k */
    public final PublishSubject<b> f330k;

    /* JADX INFO: renamed from: l */
    public final long f331l;

    /* JADX INFO: renamed from: m */
    public final RestAPI f332m;

    /* JADX INFO: renamed from: b.a.a.d.f$a */
    /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.f$b */
    /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
    public static abstract class b {

        /* JADX INFO: renamed from: b.a.a.d.f$b$a */
        /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
        public static final class a extends b {

            /* JADX INFO: renamed from: a */
            public final int f333a;

            public a(int i) {
                super(null);
                this.f333a = i;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && this.f333a == ((a) obj).f333a;
                }
                return true;
            }

            public int hashCode() {
                return this.f333a;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("Failure(failureMessageStringRes="), this.f333a, ")");
            }
        }

        /* JADX INFO: renamed from: b.a.a.d.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
        public static final class C13207b extends b {

            /* JADX INFO: renamed from: a */
            public final int f334a;

            public C13207b(int i) {
                super(null);
                this.f334a = i;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C13207b) && this.f334a == ((C13207b) obj).f334a;
                }
                return true;
            }

            public int hashCode() {
                return this.f334a;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("Success(successMessageStringRes="), this.f334a, ")");
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.f$c */
    /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final User f335a;

        /* JADX INFO: renamed from: b */
        public final Integer f336b;

        /* JADX INFO: renamed from: c */
        public final GuildMember f337c;

        public c(User user, Integer num, GuildMember guildMember) {
            this.f335a = user;
            this.f336b = num;
            this.f337c = guildMember;
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.f$d */
    /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
    public static abstract class d {

        /* JADX INFO: renamed from: b.a.a.d.f$d$a */
        /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
        public static final class a extends d {

            /* JADX INFO: renamed from: a */
            public final User f338a;

            /* JADX INFO: renamed from: b */
            public final String f339b;

            /* JADX INFO: renamed from: c */
            public final boolean f340c;

            /* JADX INFO: renamed from: d */
            public final boolean f341d;

            /* JADX INFO: renamed from: e */
            public final boolean f342e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(User user, String str, boolean z2, boolean z3, boolean z4) {
                super(null);
                C12238m.checkNotNullParameter(user, "user");
                this.f338a = user;
                this.f339b = str;
                this.f340c = z2;
                this.f341d = z3;
                this.f342e = z4;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return C12238m.areEqual(this.f338a, aVar.f338a) && C12238m.areEqual(this.f339b, aVar.f339b) && this.f340c == aVar.f340c && this.f341d == aVar.f341d && this.f342e == aVar.f342e;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            public int hashCode() {
                User user = this.f338a;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                String str = this.f339b;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.f340c;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode2 + r1) * 31;
                boolean z3 = this.f341d;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.f342e;
                return i2 + (z4 ? 1 : z4);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(user=");
                sbM833U.append(this.f338a);
                sbM833U.append(", userNickname=");
                sbM833U.append(this.f339b);
                sbM833U.append(", showBlockItem=");
                sbM833U.append(this.f340c);
                sbM833U.append(", showUnblockItem=");
                sbM833U.append(this.f341d);
                sbM833U.append(", showRemoveFriendItem=");
                return C1643a.m827O(sbM833U, this.f342e, ")");
            }
        }

        /* JADX INFO: renamed from: b.a.a.d.f$d$b */
        /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
        public static final class b extends d {

            /* JADX INFO: renamed from: a */
            public static final b f343a = new b();

            public b() {
                super(null);
            }
        }

        public d(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.f$e */
    /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
    public static final class e extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Void r3) {
            C0822f c0822f = C0822f.this;
            int i = this.$successMessageStringRes;
            PublishSubject<b> publishSubject = c0822f.f330k;
            publishSubject.f27650k.onNext(new b.C13207b(i));
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.f$f */
    /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
    public static final class f extends AbstractC12240o implements Function1<Error, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            PublishSubject<b> publishSubject = C0822f.this.f330k;
            publishSubject.f27650k.onNext(new b.a(C5419R.string.default_failure_to_perform_action_message));
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0822f(long j, long j2, RestAPI restAPI, Observable observable, int i) {
        Observable observableM11112r;
        super(d.b.f343a);
        RestAPI api = (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : null;
        if ((i & 8) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreUser users = companion.getUsers();
            StoreUserRelationships userRelationships = companion.getUserRelationships();
            StoreGuilds guilds = companion.getGuilds();
            StoreChannels channels = companion.getChannels();
            Observable<User> observableObserveUser = users.observeUser(j);
            Observable<Integer> observableObserve = userRelationships.observe(j);
            Observable observableM11112r2 = channels.observeChannel(j2).m11099Y(new C0820d(guilds, j)).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r2, "storeChannels\n          …  .distinctUntilChanged()");
            observableM11112r = Observable.m11075i(observableObserveUser, observableObserve, observableM11112r2, C0821e.f328a).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        } else {
            observableM11112r = null;
        }
        C12238m.checkNotNullParameter(api, "restAPI");
        C12238m.checkNotNullParameter(observableM11112r, "storeObservable");
        this.f331l = j;
        this.f332m = api;
        this.f330k = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), (Class<?>) C0822f.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C0818b(this));
    }

    public final void removeRelationship(@StringRes int i) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.f332m.removeRelationship("User Profile", this.f331l), false, 1, null), this, null, 2, null), (Class<?>) C0822f.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new f()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new e(i));
    }
}
