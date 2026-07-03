package p007b.p225i.p226a.p341g.p342a;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: b.i.a.g.a.d */
/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4386d {

    /* JADX INFO: renamed from: a */
    public final View f11530a;

    /* JADX INFO: renamed from: b */
    public int f11531b;

    /* JADX INFO: renamed from: c */
    public int f11532c;

    /* JADX INFO: renamed from: d */
    public int f11533d;

    /* JADX INFO: renamed from: e */
    public int f11534e;

    /* JADX INFO: renamed from: f */
    public boolean f11535f = true;

    /* JADX INFO: renamed from: g */
    public boolean f11536g = true;

    public C4386d(View view) {
        this.f11530a = view;
    }

    /* JADX INFO: renamed from: a */
    public void m6033a() {
        View view = this.f11530a;
        ViewCompat.offsetTopAndBottom(view, this.f11533d - (view.getTop() - this.f11531b));
        View view2 = this.f11530a;
        ViewCompat.offsetLeftAndRight(view2, this.f11534e - (view2.getLeft() - this.f11532c));
    }

    /* JADX INFO: renamed from: b */
    public boolean m6034b(int i) {
        if (!this.f11535f || this.f11533d == i) {
            return false;
        }
        this.f11533d = i;
        m6033a();
        return true;
    }
}
