package p000;

import java.util.Set;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: v */
/* JADX INFO: compiled from: WidgetFriendsAddUserRequestsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C13174v extends C12236k implements Function2<Set<? extends Long>, Set<? extends Long>, WidgetFriendsAddUserRequestsModel> {

    /* JADX INFO: renamed from: j */
    public static final C13174v f27929j = new C13174v();

    public C13174v() {
        super(2, WidgetFriendsAddUserRequestsModel.class, "<init>", "<init>(Ljava/util/Set;Ljava/util/Set;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public WidgetFriendsAddUserRequestsModel invoke(Set<? extends Long> set, Set<? extends Long> set2) {
        Set<? extends Long> set3 = set;
        Set<? extends Long> set4 = set2;
        C12238m.checkNotNullParameter(set3, "p1");
        C12238m.checkNotNullParameter(set4, "p2");
        return new WidgetFriendsAddUserRequestsModel(set3, set4);
    }
}
