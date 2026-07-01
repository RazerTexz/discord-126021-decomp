package b.i.a.g.a;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1603b;
    public int c;
    public int d;
    public int e;
    public boolean f = true;
    public boolean g = true;

    public d(View view) {
        this.a = view;
    }

    public void a() {
        View view = this.a;
        ViewCompat.offsetTopAndBottom(view, this.d - (view.getTop() - this.f1603b));
        View view2 = this.a;
        ViewCompat.offsetLeftAndRight(view2, this.e - (view2.getLeft() - this.c));
    }

    public boolean b(int i) {
        if (!this.f || this.d == i) {
            return false;
        }
        this.d = i;
        a();
        return true;
    }
}
