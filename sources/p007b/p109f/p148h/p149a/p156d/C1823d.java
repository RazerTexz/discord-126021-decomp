package p007b.p109f.p148h.p149a.p156d;

import android.graphics.Rect;
import com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl;
import p007b.p109f.p161j.p162a.p163a.C1838e;
import p007b.p109f.p161j.p162a.p163a.InterfaceC1834a;
import p007b.p109f.p161j.p162a.p165c.C1845a;
import p007b.p109f.p161j.p162a.p165c.InterfaceC1846b;
import p007b.p109f.p161j.p162a.p166d.C1849a;

/* JADX INFO: renamed from: b.f.h.a.d.d */
/* JADX INFO: compiled from: AnimatedFactoryV2Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class C1823d implements InterfaceC1846b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnimatedFactoryV2Impl f3551a;

    public C1823d(AnimatedFactoryV2Impl animatedFactoryV2Impl) {
        this.f3551a = animatedFactoryV2Impl;
    }

    @Override // p007b.p109f.p161j.p162a.p165c.InterfaceC1846b
    /* JADX INFO: renamed from: a */
    public InterfaceC1834a mo1164a(C1838e c1838e, Rect rect) {
        AnimatedFactoryV2Impl animatedFactoryV2Impl = this.f3551a;
        if (animatedFactoryV2Impl.f19537g == null) {
            animatedFactoryV2Impl.f19537g = new C1849a();
        }
        return new C1845a(animatedFactoryV2Impl.f19537g, c1838e, rect, animatedFactoryV2Impl.f19534d);
    }
}
