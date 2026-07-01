package b.a.a;

import com.discord.models.user.MeUser;
import j0.k.b;

/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class w<T, R> implements b<MeUser, x$c> {
    public static final w j = new w();

    @Override // j0.k.b
    public x$c call(MeUser meUser) {
        MeUser meUser2 = meUser;
        d0.z.d.m.checkNotNullExpressionValue(meUser2, "meUser");
        return new x$c(meUser2);
    }
}
