package p007b.p452o.p453a;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p007b.p452o.p453a.p454m.EnumC5114a;
import p007b.p452o.p453a.p454m.EnumC5115b;
import p007b.p452o.p453a.p454m.EnumC5117d;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5119f;
import p007b.p452o.p453a.p454m.EnumC5120g;
import p007b.p452o.p453a.p454m.EnumC5121h;
import p007b.p452o.p453a.p454m.EnumC5122i;
import p007b.p452o.p453a.p454m.EnumC5123j;
import p007b.p452o.p453a.p454m.EnumC5124k;
import p007b.p452o.p453a.p454m.EnumC5125l;
import p007b.p452o.p453a.p454m.EnumC5126m;
import p007b.p452o.p453a.p454m.InterfaceC5116c;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.c */
/* JADX INFO: compiled from: CameraOptions.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5104c {

    /* JADX INFO: renamed from: a */
    public Set<EnumC5126m> f13682a = new HashSet(5);

    /* JADX INFO: renamed from: b */
    public Set<EnumC5118e> f13683b = new HashSet(2);

    /* JADX INFO: renamed from: c */
    public Set<EnumC5119f> f13684c = new HashSet(4);

    /* JADX INFO: renamed from: d */
    public Set<EnumC5121h> f13685d = new HashSet(2);

    /* JADX INFO: renamed from: e */
    public Set<C5236b> f13686e = new HashSet(15);

    /* JADX INFO: renamed from: f */
    public Set<C5236b> f13687f = new HashSet(5);

    /* JADX INFO: renamed from: g */
    public Set<C5235a> f13688g = new HashSet(4);

    /* JADX INFO: renamed from: h */
    public Set<C5235a> f13689h = new HashSet(3);

    /* JADX INFO: renamed from: i */
    public Set<EnumC5123j> f13690i = new HashSet(2);

    /* JADX INFO: renamed from: j */
    public Set<Integer> f13691j = new HashSet(2);

    /* JADX INFO: renamed from: k */
    public boolean f13692k;

    /* JADX INFO: renamed from: l */
    public boolean f13693l;

    /* JADX INFO: renamed from: m */
    public float f13694m;

    /* JADX INFO: renamed from: n */
    public float f13695n;

    /* JADX INFO: renamed from: o */
    public boolean f13696o;

    /* JADX INFO: renamed from: p */
    public float f13697p;

    /* JADX INFO: renamed from: q */
    public float f13698q;

    @NonNull
    /* JADX INFO: renamed from: a */
    public final Collection<EnumC5118e> m7161a() {
        return Collections.unmodifiableSet(this.f13683b);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public final Collection<EnumC5119f> m7162b() {
        return Collections.unmodifiableSet(this.f13684c);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m7163c(@NonNull InterfaceC5116c interfaceC5116c) {
        Collection collectionUnmodifiableSet;
        Class<?> cls = interfaceC5116c.getClass();
        if (cls.equals(EnumC5114a.class)) {
            collectionUnmodifiableSet = Arrays.asList(EnumC5114a.values());
        } else if (cls.equals(EnumC5118e.class)) {
            collectionUnmodifiableSet = m7161a();
        } else if (cls.equals(EnumC5119f.class)) {
            collectionUnmodifiableSet = m7162b();
        } else if (cls.equals(EnumC5120g.class)) {
            collectionUnmodifiableSet = Arrays.asList(EnumC5120g.values());
        } else if (cls.equals(EnumC5121h.class)) {
            collectionUnmodifiableSet = Collections.unmodifiableSet(this.f13685d);
        } else if (cls.equals(EnumC5122i.class)) {
            collectionUnmodifiableSet = Arrays.asList(EnumC5122i.values());
        } else if (cls.equals(EnumC5125l.class)) {
            collectionUnmodifiableSet = Arrays.asList(EnumC5125l.values());
        } else if (cls.equals(EnumC5115b.class)) {
            collectionUnmodifiableSet = Arrays.asList(EnumC5115b.values());
        } else if (cls.equals(EnumC5126m.class)) {
            collectionUnmodifiableSet = Collections.unmodifiableSet(this.f13682a);
        } else if (cls.equals(EnumC5117d.class)) {
            collectionUnmodifiableSet = Arrays.asList(EnumC5117d.values());
        } else if (cls.equals(EnumC5124k.class)) {
            collectionUnmodifiableSet = Arrays.asList(EnumC5124k.values());
        } else {
            collectionUnmodifiableSet = cls.equals(EnumC5123j.class) ? Collections.unmodifiableSet(this.f13690i) : Collections.emptyList();
        }
        return collectionUnmodifiableSet.contains(interfaceC5116c);
    }
}
