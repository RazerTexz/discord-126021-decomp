package b.a.d;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import rx.functions.Action1;
import rx.functions.Action2;

/* JADX INFO: renamed from: b.a.d.b, reason: use source file name */
/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity2 implements Toolbar.OnMenuItemClickListener {
    public final /* synthetic */ Toolbar a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Action2 f57b;
    public final /* synthetic */ Action1 c;

    public AppActivity2(Toolbar toolbar, int i, Action2 action2, Action1 action1) {
        this.a = toolbar;
        this.f57b = action2;
        this.c = action1;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Action2 action2 = this.f57b;
        if (action2 == null) {
            return true;
        }
        action2.call(menuItem, this.a.getContext());
        return true;
    }
}
