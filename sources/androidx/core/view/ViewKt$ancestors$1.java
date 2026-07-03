package androidx.core.view;

import android.view.ViewParent;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends C12236k implements Function1<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ViewParent invoke(ViewParent viewParent) {
        C12238m.checkNotNullParameter(viewParent, "p0");
        return viewParent.getParent();
    }
}
