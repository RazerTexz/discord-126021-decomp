package b.a.a;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.x, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialogViewModel3 extends AppViewModel<d> {
    public static final a j = new a(null);
    public final PublishSubject<b> k;
    public final RestAPI l;

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
            public static final a a = new a();

            public a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: b.a.a.x$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
        public static final class C0014b extends b {
            public static final C0014b a = new C0014b();

            public C0014b() {
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
        public final User a;

        public c(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.a = user;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && Intrinsics3.areEqual(this.a, ((c) obj).a);
            }
            return true;
        }

        public int hashCode() {
            User user = this.a;
            if (user != null) {
                return user.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.a);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: b.a.a.x$d */
    /* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
    public static final class d {
        public final Integer a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f50b;

        public d(Integer num, boolean z2) {
            this.a = num;
            this.f50b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics3.areEqual(this.a, dVar.a) && this.f50b == dVar.f50b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            boolean z2 = this.f50b;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(userFlags=");
            sbU.append(this.a);
            sbU.append(", isBusy=");
            return outline.O(sbU, this.f50b, ")");
        }
    }

    public WidgetUrgentMessageDialogViewModel3() {
        this(null, null, null, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetUrgentMessageDialogViewModel3(RestAPI restAPI, StoreUser storeUser, Observable observable, int i) {
        Observable observableG;
        DefaultConstructorMarker defaultConstructorMarker = null;
        RestAPI api = (i & 1) != 0 ? RestAPI.INSTANCE.getApi() : null;
        StoreUser users = (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : null;
        int i2 = 1;
        if ((i & 4) != 0) {
            observableG = StoreUser.observeMe$default(users, false, 1, null).G(WidgetUrgentMessageDialogViewModel2.j);
            Intrinsics3.checkNotNullExpressionValue(observableG, "storeUser.observeMe().ma…oreState(user = meUser) }");
        } else {
            observableG = null;
        }
        Intrinsics3.checkNotNullParameter(api, "restAPI");
        Intrinsics3.checkNotNullParameter(users, "storeUser");
        Intrinsics3.checkNotNullParameter(observableG, "storeObservable");
        super(defaultConstructorMarker, i2, defaultConstructorMarker);
        this.l = api;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), (Class<?>) WidgetUrgentMessageDialogViewModel3.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new WidgetUrgentMessageDialogViewModel(this));
        this.k = PublishSubject.k0();
    }
}
