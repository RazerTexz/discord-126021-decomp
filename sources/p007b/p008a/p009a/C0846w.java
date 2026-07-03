package p007b.p008a.p009a;

import com.discord.models.user.MeUser;
import p007b.p008a.p009a.C0847x;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;

/* JADX INFO: renamed from: b.a.a.w */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0846w<T, R> implements InterfaceC12589b<MeUser, C0847x.c> {

    /* JADX INFO: renamed from: j */
    public static final C0846w f445j = new C0846w();

    @Override // p637j0.p641k.InterfaceC12589b
    public C0847x.c call(MeUser meUser) {
        MeUser meUser2 = meUser;
        C12238m.checkNotNullExpressionValue(meUser2, "meUser");
        return new C0847x.c(meUser2);
    }
}
