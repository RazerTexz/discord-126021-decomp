package p007b.p225i.p226a.p242c.p266w2;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import p007b.p225i.p226a.p242c.p265v2.InterfaceC2954b;

/* JADX INFO: renamed from: b.i.a.c.w2.a0 */
/* JADX INFO: compiled from: ExoMediaDrm.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2966a0 {

    /* JADX INFO: renamed from: b.i.a.c.w2.a0$a */
    /* JADX INFO: compiled from: ExoMediaDrm.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final byte[] f7967a;

        /* JADX INFO: renamed from: b */
        public final String f7968b;

        public a(byte[] bArr, String str, int i) {
            this.f7967a = bArr;
            this.f7968b = str;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.w2.a0$b */
    /* JADX INFO: compiled from: ExoMediaDrm.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.i.a.c.w2.a0$c */
    /* JADX INFO: compiled from: ExoMediaDrm.java */
    public interface c {
        /* JADX INFO: renamed from: a */
        InterfaceC2966a0 mo3581a(UUID uuid);
    }

    /* JADX INFO: renamed from: b.i.a.c.w2.a0$d */
    /* JADX INFO: compiled from: ExoMediaDrm.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final byte[] f7969a;

        /* JADX INFO: renamed from: b */
        public final String f7970b;

        public d(byte[] bArr, String str) {
            this.f7969a = bArr;
            this.f7970b = str;
        }
    }

    /* JADX INFO: renamed from: a */
    Map<String, String> mo3569a(byte[] bArr);

    /* JADX INFO: renamed from: b */
    d mo3570b();

    /* JADX INFO: renamed from: c */
    InterfaceC2954b mo3571c(byte[] bArr) throws MediaCryptoException;

    /* JADX INFO: renamed from: d */
    byte[] mo3572d() throws MediaDrmException;

    /* JADX INFO: renamed from: e */
    boolean mo3573e(byte[] bArr, String str);

    /* JADX INFO: renamed from: f */
    void mo3574f(byte[] bArr, byte[] bArr2);

    /* JADX INFO: renamed from: g */
    void mo3575g(byte[] bArr);

    /* JADX INFO: renamed from: h */
    void mo3576h(@Nullable b bVar);

    @Nullable
    /* JADX INFO: renamed from: i */
    byte[] mo3577i(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    /* JADX INFO: renamed from: j */
    void mo3578j(byte[] bArr) throws DeniedByServerException;

    /* JADX INFO: renamed from: k */
    a mo3579k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException;

    /* JADX INFO: renamed from: l */
    int mo3580l();

    void release();
}
