package b.o.a;

import androidx.annotation.NonNull;
import b.o.a.m.Audio;
import b.o.a.m.AudioCodec;
import b.o.a.m.Control;
import b.o.a.m.Engine;
import b.o.a.m.Facing;
import b.o.a.m.Flash;
import b.o.a.m.Grid;
import b.o.a.m.Hdr;
import b.o.a.m.Mode3;
import b.o.a.m.PictureFormat;
import b.o.a.m.Preview;
import b.o.a.m.VideoCodec;
import b.o.a.m.WhiteBalance;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: b.o.a.c, reason: use source file name */
/* JADX INFO: compiled from: CameraOptions.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraOptions {
    public Set<WhiteBalance> a = new HashSet(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<Facing> f1911b = new HashSet(2);
    public Set<Flash> c = new HashSet(4);
    public Set<Hdr> d = new HashSet(2);
    public Set<Size3> e = new HashSet(15);
    public Set<Size3> f = new HashSet(5);
    public Set<AspectRatio2> g = new HashSet(4);
    public Set<AspectRatio2> h = new HashSet(3);
    public Set<PictureFormat> i = new HashSet(2);
    public Set<Integer> j = new HashSet(2);
    public boolean k;
    public boolean l;
    public float m;
    public float n;
    public boolean o;
    public float p;
    public float q;

    @NonNull
    public final Collection<Facing> a() {
        return Collections.unmodifiableSet(this.f1911b);
    }

    @NonNull
    public final Collection<Flash> b() {
        return Collections.unmodifiableSet(this.c);
    }

    public final boolean c(@NonNull Control control) {
        Collection collectionUnmodifiableSet;
        Class<?> cls = control.getClass();
        if (cls.equals(Audio.class)) {
            collectionUnmodifiableSet = Arrays.asList(Audio.values());
        } else if (cls.equals(Facing.class)) {
            collectionUnmodifiableSet = a();
        } else if (cls.equals(Flash.class)) {
            collectionUnmodifiableSet = b();
        } else if (cls.equals(Grid.class)) {
            collectionUnmodifiableSet = Arrays.asList(Grid.values());
        } else if (cls.equals(Hdr.class)) {
            collectionUnmodifiableSet = Collections.unmodifiableSet(this.d);
        } else if (cls.equals(Mode3.class)) {
            collectionUnmodifiableSet = Arrays.asList(Mode3.values());
        } else if (cls.equals(VideoCodec.class)) {
            collectionUnmodifiableSet = Arrays.asList(VideoCodec.values());
        } else if (cls.equals(AudioCodec.class)) {
            collectionUnmodifiableSet = Arrays.asList(AudioCodec.values());
        } else if (cls.equals(WhiteBalance.class)) {
            collectionUnmodifiableSet = Collections.unmodifiableSet(this.a);
        } else if (cls.equals(Engine.class)) {
            collectionUnmodifiableSet = Arrays.asList(Engine.values());
        } else if (cls.equals(Preview.class)) {
            collectionUnmodifiableSet = Arrays.asList(Preview.values());
        } else {
            collectionUnmodifiableSet = cls.equals(PictureFormat.class) ? Collections.unmodifiableSet(this.i) : Collections.emptyList();
        }
        return collectionUnmodifiableSet.contains(control);
    }
}
