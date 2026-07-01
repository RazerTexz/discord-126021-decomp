package defpackage;

import d0.z.d.k;
import d0.z.d.m;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsAddUserRequestsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v extends k implements Function2<Set<? extends Long>, Set<? extends Long>, WidgetFriendsAddUserRequestsModel> {
    public static final v j = new v();

    public v() {
        super(2, WidgetFriendsAddUserRequestsModel.class, "<init>", "<init>(Ljava/util/Set;Ljava/util/Set;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public WidgetFriendsAddUserRequestsModel invoke(Set<? extends Long> set, Set<? extends Long> set2) {
        Set<? extends Long> set3 = set;
        Set<? extends Long> set4 = set2;
        m.checkNotNullParameter(set3, "p1");
        m.checkNotNullParameter(set4, "p2");
        return new WidgetFriendsAddUserRequestsModel(set3, set4);
    }
}
