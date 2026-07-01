package b.i.a.c.w2;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.v2.CryptoConfig;
import b.i.a.c.w2.ExoMediaDrm;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.c.w2.y, reason: use source file name */
/* JADX INFO: compiled from: DummyExoMediaDrm.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public final class DummyExoMediaDrm implements ExoMediaDrm {
    @Override // b.i.a.c.w2.ExoMediaDrm
    public Map<String, String> a(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public ExoMediaDrm.d b() {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public CryptoConfig c(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public byte[] d() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public boolean e(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void f(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void g(byte[] bArr) {
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void h(@Nullable ExoMediaDrm.b bVar) {
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    @Nullable
    public byte[] i(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void j(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public ExoMediaDrm.a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public int l() {
        return 1;
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void release() {
    }
}
