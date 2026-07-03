package p007b.p008a.p018d;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import p658rx.functions.Action1;
import p658rx.functions.Action2;

/* JADX INFO: renamed from: b.a.d.b */
/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0854b implements Toolbar.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Toolbar f502a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Action2 f503b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Action1 f504c;

    public C0854b(Toolbar toolbar, int i, Action2 action2, Action1 action1) {
        this.f502a = toolbar;
        this.f503b = action2;
        this.f504c = action1;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Action2 action2 = this.f503b;
        if (action2 == null) {
            return true;
        }
        action2.call(menuItem, this.f502a.getContext());
        return true;
    }
}
