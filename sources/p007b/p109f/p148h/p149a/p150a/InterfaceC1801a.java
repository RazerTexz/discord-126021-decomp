package p007b.p109f.p148h.p149a.p150a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;

/* JADX INFO: renamed from: b.f.h.a.a.a */
/* JADX INFO: compiled from: AnimationBackend.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1801a extends InterfaceC1804d {
    void clear();

    /* JADX INFO: renamed from: d */
    void mo1136d(ColorFilter colorFilter);

    /* JADX INFO: renamed from: f */
    void mo1137f(@IntRange(from = 0, m76to = 255) int i);

    /* JADX INFO: renamed from: g */
    int mo1138g();

    /* JADX INFO: renamed from: h */
    void mo1139h(Rect rect);

    /* JADX INFO: renamed from: i */
    int mo1140i();

    /* JADX INFO: renamed from: j */
    boolean mo1141j(Drawable drawable, Canvas canvas, int i);
}
