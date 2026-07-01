package b.a.a.d;

import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.d.f, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialogViewModel5 extends AppViewModel<d> {
    public static final a j = new a(null);
    public final PublishSubject<b> k;
    public final long l;
    public final RestAPI m;

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
            public final int a;

            public a(int i) {
                super(null);
                this.a = i;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && this.a == ((a) obj).a;
                }
                return true;
            }

            public int hashCode() {
                return this.a;
            }

            public String toString() {
                return outline.B(outline.U("Failure(failureMessageStringRes="), this.a, ")");
            }
        }

        /* JADX INFO: renamed from: b.a.a.d.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
        public static final class C0011b extends b {
            public final int a;

            public C0011b(int i) {
                super(null);
                this.a = i;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C0011b) && this.a == ((C0011b) obj).a;
                }
                return true;
            }

            public int hashCode() {
                return this.a;
            }

            public String toString() {
                return outline.B(outline.U("Success(successMessageStringRes="), this.a, ")");
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
        public final User a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f46b;
        public final GuildMember c;

        public c(User user, Integer num, GuildMember guildMember) {
            this.a = user;
            this.f46b = num;
            this.c = guildMember;
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.f$d */
    /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
    public static abstract class d {

        /* JADX INFO: renamed from: b.a.a.d.f$d$a */
        /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
        public static final class a extends d {
            public final User a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f47b;
            public final boolean c;
            public final boolean d;
            public final boolean e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(User user, String str, boolean z2, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(user, "user");
                this.a = user;
                this.f47b = str;
                this.c = z2;
                this.d = z3;
                this.e = z4;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return Intrinsics3.areEqual(this.a, aVar.a) && Intrinsics3.areEqual(this.f47b, aVar.f47b) && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e;
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
                User user = this.a;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                String str = this.f47b;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.c;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode2 + r1) * 31;
                boolean z3 = this.d;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.e;
                return i2 + (z4 ? 1 : z4);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(user=");
                sbU.append(this.a);
                sbU.append(", userNickname=");
                sbU.append(this.f47b);
                sbU.append(", showBlockItem=");
                sbU.append(this.c);
                sbU.append(", showUnblockItem=");
                sbU.append(this.d);
                sbU.append(", showRemoveFriendItem=");
                return outline.O(sbU, this.e, ")");
            }
        }

        /* JADX INFO: renamed from: b.a.a.d.f$d$b */
        /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
        public static final class b extends d {
            public static final b a = new b();

            public b() {
                super(null);
            }
        }

        public d(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.f$e */
    /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
    public static final class e extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Void r3) {
            UserActionsDialogViewModel5 userActionsDialogViewModel5 = UserActionsDialogViewModel5.this;
            int i = this.$successMessageStringRes;
            PublishSubject<b> publishSubject = userActionsDialogViewModel5.k;
            publishSubject.k.onNext(new b.C0011b(i));
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.f$f */
    /* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
    public static final class f extends Lambda implements Function1<Error, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PublishSubject<b> publishSubject = UserActionsDialogViewModel5.this.k;
            publishSubject.k.onNext(new b.a(R.string.default_failure_to_perform_action_message));
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserActionsDialogViewModel5(long j2, long j3, RestAPI restAPI, Observable observable, int i) {
        Observable observableR;
        super(d.b.a);
        RestAPI api = (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : null;
        if ((i & 8) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreUser users = companion.getUsers();
            StoreUserRelationships userRelationships = companion.getUserRelationships();
            StoreGuilds guilds = companion.getGuilds();
            StoreChannels channels = companion.getChannels();
            Observable<User> observableObserveUser = users.observeUser(j2);
            Observable<Integer> observableObserve = userRelationships.observe(j2);
            Observable observableR2 = channels.observeChannel(j3).Y(new UserActionsDialogViewModel3(guilds, j2)).r();
            Intrinsics3.checkNotNullExpressionValue(observableR2, "storeChannels\n          …  .distinctUntilChanged()");
            observableR = Observable.i(observableObserveUser, observableObserve, observableR2, UserActionsDialogViewModel4.a).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        } else {
            observableR = null;
        }
        Intrinsics3.checkNotNullParameter(api, "restAPI");
        Intrinsics3.checkNotNullParameter(observableR, "storeObservable");
        this.l = j2;
        this.m = api;
        this.k = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) UserActionsDialogViewModel5.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new UserActionsDialogViewModel(this));
    }

    public final void removeRelationship(@StringRes int i) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.m.removeRelationship("User Profile", this.l), false, 1, null), this, null, 2, null), (Class<?>) UserActionsDialogViewModel5.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new f()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new e(i));
    }
}
