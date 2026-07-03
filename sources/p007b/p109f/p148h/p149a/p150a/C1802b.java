package p007b.p109f.p148h.p149a.p150a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import p007b.p109f.p148h.p149a.p150a.InterfaceC1801a;

/* JADX INFO: renamed from: b.f.h.a.a.b */
/* JADX INFO: compiled from: AnimationBackendDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class C1802b<T extends InterfaceC1801a> implements InterfaceC1801a {

    /* JADX INFO: renamed from: a */
    public T f3488a;

    public C1802b(T t) {
        this.f3488a = t;
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1804d
    /* JADX INFO: renamed from: a */
    public int mo1142a() {
        T t = this.f3488a;
        if (t == null) {
            return 0;
        }
        return t.mo1142a();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1804d
    /* JADX INFO: renamed from: b */
    public int mo1143b() {
        T t = this.f3488a;
        if (t == null) {
            return 0;
        }
        return t.mo1143b();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    public void clear() {
        T t = this.f3488a;
        if (t != null) {
            t.clear();
        }
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: d */
    public void mo1136d(ColorFilter colorFilter) {
        T t = this.f3488a;
        if (t != null) {
            t.mo1136d(colorFilter);
        }
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1804d
    /* JADX INFO: renamed from: e */
    public int mo1144e(int i) {
        T t = this.f3488a;
        if (t == null) {
            return 0;
        }
        return t.mo1144e(i);
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: f */
    public void mo1137f(@IntRange(from = 0, m76to = 255) int i) {
        T t = this.f3488a;
        if (t != null) {
            t.mo1137f(i);
        }
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: g */
    public int mo1138g() {
        T t = this.f3488a;
        if (t == null) {
            return -1;
        }
        return t.mo1138g();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: h */
    public void mo1139h(Rect rect) {
        T t = this.f3488a;
        if (t != null) {
            t.mo1139h(rect);
        }
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: i */
    public int mo1140i() {
        T t = this.f3488a;
        if (t == null) {
            return -1;
        }
        return t.mo1140i();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: j */
    public boolean mo1141j(Drawable drawable, Canvas canvas, int i) {
        T t = this.f3488a;
        return t != null && t.mo1141j(drawable, canvas, i);
    }
}
