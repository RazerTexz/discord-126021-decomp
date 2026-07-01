package b.i.a.c.w2;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ExoMediaDrm.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a0 {
    Map<String, String> a(byte[] bArr);

    a0$d b();

    b.i.a.c.v2.b c(byte[] bArr) throws MediaCryptoException;

    byte[] d() throws MediaDrmException;

    boolean e(byte[] bArr, String str);

    void f(byte[] bArr, byte[] bArr2);

    void g(byte[] bArr);

    void h(@Nullable a0$b a0_b);

    @Nullable
    byte[] i(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    void j(byte[] bArr) throws DeniedByServerException;

    a0$a k(byte[] bArr, @Nullable List<DrmInitData$SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException;

    int l();

    void release();
}
