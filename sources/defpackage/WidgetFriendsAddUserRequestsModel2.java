package defpackage;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: v, reason: use source file name */
/* JADX INFO: compiled from: WidgetFriendsAddUserRequestsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsAddUserRequestsModel2 extends FunctionReferenceImpl implements Function2<Set<? extends Long>, Set<? extends Long>, WidgetFriendsAddUserRequestsModel> {
    public static final WidgetFriendsAddUserRequestsModel2 j = new WidgetFriendsAddUserRequestsModel2();

    public WidgetFriendsAddUserRequestsModel2() {
        super(2, WidgetFriendsAddUserRequestsModel.class, "<init>", "<init>(Ljava/util/Set;Ljava/util/Set;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public WidgetFriendsAddUserRequestsModel invoke(Set<? extends Long> set, Set<? extends Long> set2) {
        Set<? extends Long> set3 = set;
        Set<? extends Long> set4 = set2;
        Intrinsics3.checkNotNullParameter(set3, "p1");
        Intrinsics3.checkNotNullParameter(set4, "p2");
        return new WidgetFriendsAddUserRequestsModel(set3, set4);
    }
}
