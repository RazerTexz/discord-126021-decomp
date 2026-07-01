package b.a.a;

import b.d.b.a.a;
import com.discord.models.user.User;

/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class x$c {
    public final User a;

    public x$c(User user) {
        d0.z.d.m.checkNotNullParameter(user, "user");
        this.a = user;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof x$c) && d0.z.d.m.areEqual(this.a, ((x$c) obj).a);
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
        StringBuilder sbU = a.U("StoreState(user=");
        sbU.append(this.a);
        sbU.append(")");
        return sbU.toString();
    }
}
