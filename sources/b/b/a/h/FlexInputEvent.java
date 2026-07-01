package b.b.a.h;

import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.b.a.h.a, reason: use source file name */
/* JADX INFO: compiled from: FlexInputEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FlexInputEvent {

    /* JADX INFO: renamed from: b.b.a.h.a$a */
    /* JADX INFO: compiled from: FlexInputEvent.kt */
    public static final class a extends FlexInputEvent {
        public static final a a = new a();

        public a() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: b.b.a.h.a$b */
    /* JADX INFO: compiled from: FlexInputEvent.kt */
    public static final class b extends FlexInputEvent {
        public static final b a = new b();

        public b() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: b.b.a.h.a$c */
    /* JADX INFO: compiled from: FlexInputEvent.kt */
    public static final class c extends FlexInputEvent {
        public static final c a = new c();

        public c() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: b.b.a.h.a$d */
    /* JADX INFO: compiled from: FlexInputEvent.kt */
    public static final class d extends FlexInputEvent {
        public final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.a = str;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof d) && Intrinsics3.areEqual(this.a, ((d) obj).a);
            }
            return true;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("ShowToast(text="), this.a, ")");
        }
    }

    /* JADX INFO: renamed from: b.b.a.h.a$e */
    /* JADX INFO: compiled from: FlexInputEvent.kt */
    public static final class e extends FlexInputEvent {
        public final int a;

        public e(@StringRes int i) {
            super(null);
            this.a = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof e) && this.a == ((e) obj).a;
            }
            return true;
        }

        public int hashCode() {
            return this.a;
        }

        public String toString() {
            return outline.B(outline.U("ShowToastStringRes(textResId="), this.a, ")");
        }
    }

    public FlexInputEvent() {
    }

    public FlexInputEvent(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
