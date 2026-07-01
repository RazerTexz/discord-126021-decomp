package b.f.h.a.d;

import android.graphics.Rect;
import com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl;

/* JADX INFO: compiled from: AnimatedFactoryV2Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements b.f.j.a.c.b {
    public final /* synthetic */ AnimatedFactoryV2Impl a;

    public d(AnimatedFactoryV2Impl animatedFactoryV2Impl) {
        this.a = animatedFactoryV2Impl;
    }

    @Override // b.f.j.a.c.b
    public b.f.j.a.a.a a(b.f.j.a.a.e eVar, Rect rect) {
        AnimatedFactoryV2Impl animatedFactoryV2Impl = this.a;
        if (animatedFactoryV2Impl.g == null) {
            animatedFactoryV2Impl.g = new b.f.j.a.d.a();
        }
        return new b.f.j.a.c.a(animatedFactoryV2Impl.g, eVar, rect, animatedFactoryV2Impl.d);
    }
}
