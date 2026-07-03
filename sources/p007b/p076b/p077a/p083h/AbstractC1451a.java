package p007b.p076b.p077a.p083h;

import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.h.a */
/* JADX INFO: compiled from: FlexInputEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1451a {

    /* JADX INFO: renamed from: b.b.a.h.a$a */
    /* JADX INFO: compiled from: FlexInputEvent.kt */
    public static final class a extends AbstractC1451a {

        /* JADX INFO: renamed from: a */
        public static final a f2202a = new a();

        public a() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: b.b.a.h.a$b */
    /* JADX INFO: compiled from: FlexInputEvent.kt */
    public static final class b extends AbstractC1451a {

        /* JADX INFO: renamed from: a */
        public static final b f2203a = new b();

        public b() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: b.b.a.h.a$c */
    /* JADX INFO: compiled from: FlexInputEvent.kt */
    public static final class c extends AbstractC1451a {

        /* JADX INFO: renamed from: a */
        public static final c f2204a = new c();

        public c() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: b.b.a.h.a$d */
    /* JADX INFO: compiled from: FlexInputEvent.kt */
    public static final class d extends AbstractC1451a {

        /* JADX INFO: renamed from: a */
        public final String f2205a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(null);
            C12238m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.f2205a = str;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof d) && C12238m.areEqual(this.f2205a, ((d) obj).f2205a);
            }
            return true;
        }

        public int hashCode() {
            String str = this.f2205a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return C1643a.m822J(C1643a.m833U("ShowToast(text="), this.f2205a, ")");
        }
    }

    /* JADX INFO: renamed from: b.b.a.h.a$e */
    /* JADX INFO: compiled from: FlexInputEvent.kt */
    public static final class e extends AbstractC1451a {

        /* JADX INFO: renamed from: a */
        public final int f2206a;

        public e(@StringRes int i) {
            super(null);
            this.f2206a = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof e) && this.f2206a == ((e) obj).f2206a;
            }
            return true;
        }

        public int hashCode() {
            return this.f2206a;
        }

        public String toString() {
            return C1643a.m814B(C1643a.m833U("ShowToastStringRes(textResId="), this.f2206a, ")");
        }
    }

    public AbstractC1451a() {
    }

    public AbstractC1451a(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
