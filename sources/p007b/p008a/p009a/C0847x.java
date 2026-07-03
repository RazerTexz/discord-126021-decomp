package p007b.p008a.p009a;

import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.x */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0847x extends AbstractC0859d0<d> {

    /* JADX INFO: renamed from: j */
    public static final a f446j = new a(null);

    /* JADX INFO: renamed from: k */
    public final PublishSubject<b> f447k;

    /* JADX INFO: renamed from: l */
    public final RestAPI f448l;

    /* JADX INFO: renamed from: b.a.a.x$a */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.x$b */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
    public static abstract class b {

        /* JADX INFO: renamed from: b.a.a.x$b$a */
        /* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
        public static final class a extends b {

            /* JADX INFO: renamed from: a */
            public static final a f449a = new a();

            public a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: b.a.a.x$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
        public static final class C13210b extends b {

            /* JADX INFO: renamed from: a */
            public static final C13210b f450a = new C13210b();

            public C13210b() {
                super(null);
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.x$c */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final User f451a;

        public c(User user) {
            C12238m.checkNotNullParameter(user, "user");
            this.f451a = user;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && C12238m.areEqual(this.f451a, ((c) obj).f451a);
            }
            return true;
        }

        public int hashCode() {
            User user = this.f451a;
            if (user != null) {
                return user.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(user=");
            sbM833U.append(this.f451a);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: b.a.a.x$d */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final Integer f452a;

        /* JADX INFO: renamed from: b */
        public final boolean f453b;

        public d(Integer num, boolean z2) {
            this.f452a = num;
            this.f453b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return C12238m.areEqual(this.f452a, dVar.f452a) && this.f453b == dVar.f453b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            Integer num = this.f452a;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            boolean z2 = this.f453b;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(userFlags=");
            sbM833U.append(this.f452a);
            sbM833U.append(", isBusy=");
            return C1643a.m827O(sbM833U, this.f453b, ")");
        }
    }

    public C0847x() {
        this(null, null, null, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0847x(RestAPI restAPI, StoreUser storeUser, Observable observable, int i) {
        Observable observableM11083G;
        DefaultConstructorMarker defaultConstructorMarker = null;
        RestAPI api = (i & 1) != 0 ? RestAPI.INSTANCE.getApi() : null;
        StoreUser users = (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : null;
        int i2 = 1;
        if ((i & 4) != 0) {
            observableM11083G = StoreUser.observeMe$default(users, false, 1, null).m11083G(C0846w.f445j);
            C12238m.checkNotNullExpressionValue(observableM11083G, "storeUser.observeMe().ma…oreState(user = meUser) }");
        } else {
            observableM11083G = null;
        }
        C12238m.checkNotNullParameter(api, "restAPI");
        C12238m.checkNotNullParameter(users, "storeUser");
        C12238m.checkNotNullParameter(observableM11083G, "storeObservable");
        super(defaultConstructorMarker, i2, defaultConstructorMarker);
        this.f448l = api;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11083G), this, null, 2, null), (Class<?>) C0847x.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C0845v(this));
        this.f447k = PublishSubject.m11133k0();
    }
}
