package b.b.a.h;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.z.d.m;

/* JADX INFO: compiled from: FlexInputEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$d extends a {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$d(String str) {
        super(null);
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof a$d) && m.areEqual(this.a, ((a$d) obj).a);
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
        return b.d.b.a.a.J(b.d.b.a.a.U("ShowToast(text="), this.a, ")");
    }
}
