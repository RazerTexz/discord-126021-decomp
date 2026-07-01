package b.i.a.c.b3;

import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Objects;

/* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements h {
    public final c a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f843b = new j();
    public final Deque<k> c = new ArrayDeque();
    public int d;
    public boolean e;

    public d() {
        for (int i = 0; i < 2; i++) {
            this.c.addFirst(new d$a(this));
        }
        this.d = 0;
    }

    @Override // b.i.a.c.b3.h
    public void a(long j) {
    }

    @Override // b.i.a.c.v2.d
    @Nullable
    public k b() throws DecoderException {
        b.c.a.a0.d.D(!this.e);
        if (this.d != 2 || this.c.isEmpty()) {
            return null;
        }
        k kVarRemoveFirst = this.c.removeFirst();
        if (this.f843b.n()) {
            kVarRemoveFirst.j(4);
        } else {
            j jVar = this.f843b;
            long j = jVar.n;
            c cVar = this.a;
            ByteBuffer byteBuffer = jVar.l;
            Objects.requireNonNull(byteBuffer);
            byte[] bArrArray = byteBuffer.array();
            Objects.requireNonNull(cVar);
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(bArrArray, 0, bArrArray.length);
            parcelObtain.setDataPosition(0);
            Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
            parcelObtain.recycle();
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("c");
            Objects.requireNonNull(parcelableArrayList);
            kVarRemoveFirst.r(this.f843b.n, new d$b(j, b.i.a.c.f3.f.a(b.k, parcelableArrayList)), 0L);
        }
        this.f843b.p();
        this.d = 0;
        return kVarRemoveFirst;
    }

    @Override // b.i.a.c.v2.d
    @Nullable
    public j c() throws DecoderException {
        b.c.a.a0.d.D(!this.e);
        if (this.d != 0) {
            return null;
        }
        this.d = 1;
        return this.f843b;
    }

    @Override // b.i.a.c.v2.d
    public void d(j jVar) throws DecoderException {
        j jVar2 = jVar;
        b.c.a.a0.d.D(!this.e);
        b.c.a.a0.d.D(this.d == 1);
        b.c.a.a0.d.j(this.f843b == jVar2);
        this.d = 2;
    }

    @Override // b.i.a.c.v2.d
    public void flush() {
        b.c.a.a0.d.D(!this.e);
        this.f843b.p();
        this.d = 0;
    }

    @Override // b.i.a.c.v2.d
    public void release() {
        this.e = true;
    }
}
