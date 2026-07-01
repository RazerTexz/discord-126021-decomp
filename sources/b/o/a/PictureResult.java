package b.o.a;

import android.location.Location;
import androidx.annotation.NonNull;
import b.o.a.m.Facing;
import b.o.a.m.PictureFormat;
import b.o.a.x.Size3;

/* JADX INFO: renamed from: b.o.a.l, reason: use source file name */
/* JADX INFO: compiled from: PictureResult.java */
/* JADX INFO: loaded from: classes3.dex */
public class PictureResult {
    public final byte[] a;

    /* JADX INFO: renamed from: b.o.a.l$a */
    /* JADX INFO: compiled from: PictureResult.java */
    public static class a {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Location f1912b;
        public int c;
        public Size3 d;
        public Facing e;
        public byte[] f;
        public PictureFormat g;
    }

    public PictureResult(@NonNull a aVar) {
        boolean z2 = aVar.a;
        this.a = aVar.f;
    }
}
