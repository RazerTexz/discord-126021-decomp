package b.a.a;

import b.a.a.WidgetUrgentMessageDialogViewModel3;
import com.discord.models.user.MeUser;
import d0.z.d.Intrinsics3;
import j0.k.Func1;

/* JADX INFO: renamed from: b.a.a.w, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialogViewModel2<T, R> implements Func1<MeUser, WidgetUrgentMessageDialogViewModel3.c> {
    public static final WidgetUrgentMessageDialogViewModel2 j = new WidgetUrgentMessageDialogViewModel2();

    @Override // j0.k.Func1
    public WidgetUrgentMessageDialogViewModel3.c call(MeUser meUser) {
        MeUser meUser2 = meUser;
        Intrinsics3.checkNotNullExpressionValue(meUser2, "meUser");
        return new WidgetUrgentMessageDialogViewModel3.c(meUser2);
    }
}
