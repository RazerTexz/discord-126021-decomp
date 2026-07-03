package p007b.p225i.p226a.p242c.p266w2;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2997x0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p265v2.InterfaceC2954b;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0;
import p007b.p225i.p226a.p242c.p267x2.p274i0.C3051j;
import p007b.p225i.p355b.p356a.C4483c;

/* JADX INFO: renamed from: b.i.a.c.w2.c0 */
/* JADX INFO: compiled from: FrameworkMediaDrm.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public final class C2970c0 implements InterfaceC2966a0 {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f7977a = 0;

    /* JADX INFO: renamed from: b */
    public final UUID f7978b;

    /* JADX INFO: renamed from: c */
    public final MediaDrm f7979c;

    /* JADX INFO: renamed from: d */
    public int f7980d;

    /* JADX INFO: renamed from: b.i.a.c.w2.c0$a */
    /* JADX INFO: compiled from: FrameworkMediaDrm.java */
    @RequiresApi(31)
    public static class a {
        @DoNotInline
        /* JADX INFO: renamed from: a */
        public static boolean m3582a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }
    }

    public C2970c0(UUID uuid) throws UnsupportedSchemeException {
        Objects.requireNonNull(uuid);
        UUID uuid2 = C2997x0.f8022b;
        C1460d.m543m(!uuid2.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f7978b = uuid;
        MediaDrm mediaDrm = new MediaDrm((C2738e0.f6708a >= 27 || !C2997x0.f8023c.equals(uuid)) ? uuid : uuid2);
        this.f7979c = mediaDrm;
        this.f7980d = 1;
        if (C2997x0.f8024d.equals(uuid) && "ASUS_Z00AD".equals(C2738e0.f6711d)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    /* JADX INFO: renamed from: a */
    public Map<String, String> mo3569a(byte[] bArr) {
        return this.f7979c.queryKeyStatus(bArr);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    /* JADX INFO: renamed from: b */
    public InterfaceC2966a0.d mo3570b() {
        MediaDrm.ProvisionRequest provisionRequest = this.f7979c.getProvisionRequest();
        return new InterfaceC2966a0.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    /* JADX INFO: renamed from: c */
    public InterfaceC2954b mo3571c(byte[] bArr) throws MediaCryptoException {
        int i = C2738e0.f6708a;
        boolean z2 = i < 21 && C2997x0.f8024d.equals(this.f7978b) && "L3".equals(this.f7979c.getPropertyString("securityLevel"));
        UUID uuid = this.f7978b;
        if (i < 27 && C2997x0.f8023c.equals(uuid)) {
            uuid = C2997x0.f8022b;
        }
        return new C2968b0(uuid, bArr, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    /* JADX INFO: renamed from: d */
    public byte[] mo3572d() throws MediaDrmException {
        return this.f7979c.openSession();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    /* JADX INFO: renamed from: e */
    public boolean mo3573e(byte[] bArr, String str) {
        if (C2738e0.f6708a >= 31) {
            return a.m3582a(this.f7979c, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f7978b, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    /* JADX INFO: renamed from: f */
    public void mo3574f(byte[] bArr, byte[] bArr2) {
        this.f7979c.restoreKeys(bArr, bArr2);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    /* JADX INFO: renamed from: g */
    public void mo3575g(byte[] bArr) {
        this.f7979c.closeSession(bArr);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    /* JADX INFO: renamed from: h */
    public void mo3576h(@Nullable final InterfaceC2966a0.b bVar) {
        this.f7979c.setOnEventListener(new MediaDrm.OnEventListener() { // from class: b.i.a.c.w2.o
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                C2970c0 c2970c0 = this.f8005a;
                InterfaceC2966a0.b bVar2 = bVar;
                Objects.requireNonNull(c2970c0);
                DefaultDrmSessionManager.HandlerC10706c handlerC10706c = ((DefaultDrmSessionManager.C10705b) bVar2).f19838a.f19837x;
                Objects.requireNonNull(handlerC10706c);
                handlerC10706c.obtainMessage(i, bArr).sendToTarget();
            }
        });
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    @Nullable
    /* JADX INFO: renamed from: i */
    public byte[] mo3577i(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (C2997x0.f8023c.equals(this.f7978b) && C2738e0.f6708a < 27) {
            try {
                JSONObject jSONObject = new JSONObject(C2738e0.m3004l(bArr2));
                StringBuilder sb = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sb.append("{\"k\":\"");
                    sb.append(jSONObject2.getString("k").replace('-', '+').replace('_', MentionUtilsKt.SLASH_CHAR));
                    sb.append("\",\"kid\":\"");
                    sb.append(jSONObject2.getString("kid").replace('-', '+').replace('_', MentionUtilsKt.SLASH_CHAR));
                    sb.append("\",\"kty\":\"");
                    sb.append(jSONObject2.getString("kty"));
                    sb.append("\"}");
                }
                sb.append("]}");
                bArr2 = C2738e0.m3015w(sb.toString());
            } catch (JSONException e) {
                String strM3004l = C2738e0.m3004l(bArr2);
                C2750q.m3039b("ClearKeyUtil", strM3004l.length() != 0 ? "Failed to adjust response data: ".concat(strM3004l) : new String("Failed to adjust response data: "), e);
            }
        }
        return this.f7979c.provideKeyResponse(bArr, bArr2);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    /* JADX INFO: renamed from: j */
    public void mo3578j(byte[] bArr) throws DeniedByServerException {
        this.f7979c.provideProvisionResponse(bArr);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x022f  */
    /* JADX WARN: Code duplicated, block: B:134:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0095  */
    /* JADX WARN: Code duplicated, block: B:35:0x009c  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:38:0x00af  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:66:0x018c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0193  */
    /* JADX WARN: Code duplicated, block: B:69:0x0195  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:82:0x01da  */
    /* JADX WARN: Code duplicated, block: B:86:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:92:0x0206  */
    /* JADX WARN: Code duplicated, block: B:98:0x0214  */
    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    @SuppressLint({"WrongConstant"})
    /* JADX INFO: renamed from: k */
    public InterfaceC2966a0.a mo3579k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException {
        byte[] bArr2;
        String str;
        int i2;
        DrmInitData.SchemeData schemeData;
        C3051j c3051jM581v1;
        int i3;
        int i4;
        boolean z2;
        UUID uuid;
        byte[] bArrArray;
        UUID uuid2;
        int i5;
        String str2;
        byte[] bArrM585w1;
        String str3;
        String str4;
        byte[] bArrM585w2;
        short s2;
        int length;
        ByteBuffer byteBufferAllocate;
        DrmInitData.SchemeData schemeData2 = null;
        if (list != null) {
            if (C2997x0.f8024d.equals(this.f7978b)) {
                if (C2738e0.f6708a < 28 || list.size() <= 1) {
                    i2 = 0;
                    while (true) {
                        if (i2 < list.size()) {
                            DrmInitData.SchemeData schemeData3 = list.get(i2);
                            byte[] bArr3 = schemeData3.f19855n;
                            Objects.requireNonNull(bArr3);
                            c3051jM581v1 = C1460d.m581v1(bArr3);
                            if (c3051jM581v1 == null) {
                                i3 = -1;
                            } else {
                                i3 = c3051jM581v1.f8450b;
                            }
                            i4 = C2738e0.f6708a;
                            if ((i4 >= 23 && i3 == 0) || (i4 >= 23 && i3 == 1)) {
                                schemeData2 = schemeData3;
                            }
                        } else {
                            schemeData = list.get(0);
                        }
                    }
                } else {
                    DrmInitData.SchemeData schemeData4 = list.get(0);
                    int i6 = 0;
                    int length2 = 0;
                    while (true) {
                        if (i6 >= list.size()) {
                            z2 = true;
                            break;
                        }
                        DrmInitData.SchemeData schemeData5 = list.get(i6);
                        byte[] bArr4 = schemeData5.f19855n;
                        Objects.requireNonNull(bArr4);
                        if (C2738e0.m2993a(schemeData5.f19854m, schemeData4.f19854m) && C2738e0.m2993a(schemeData5.f19853l, schemeData4.f19853l)) {
                            if (C1460d.m581v1(bArr4) != null) {
                                length2 += bArr4.length;
                                i6++;
                            }
                        }
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        byte[] bArr5 = new byte[length2];
                        int i7 = 0;
                        for (int i8 = 0; i8 < list.size(); i8++) {
                            byte[] bArr6 = list.get(i8).f19855n;
                            Objects.requireNonNull(bArr6);
                            int length3 = bArr6.length;
                            System.arraycopy(bArr6, 0, bArr5, i7, length3);
                            i7 += length3;
                        }
                        schemeData = new DrmInitData.SchemeData(schemeData4.f19852k, schemeData4.f19853l, schemeData4.f19854m, bArr5);
                    } else {
                        i2 = 0;
                        while (true) {
                            if (i2 < list.size()) {
                                DrmInitData.SchemeData schemeData6 = list.get(i2);
                                byte[] bArr7 = schemeData6.f19855n;
                                Objects.requireNonNull(bArr7);
                                c3051jM581v1 = C1460d.m581v1(bArr7);
                                if (c3051jM581v1 == null) {
                                    i3 = -1;
                                } else {
                                    i3 = c3051jM581v1.f8450b;
                                }
                                i4 = C2738e0.f6708a;
                                i2 = i4 >= 23 ? i2 + 1 : i2 + 1;
                                schemeData2 = schemeData6;
                            } else {
                                schemeData = list.get(0);
                            }
                        }
                    }
                }
                uuid = this.f7978b;
                bArrArray = schemeData2.f19855n;
                Objects.requireNonNull(bArrArray);
                uuid2 = C2997x0.f8025e;
                if (uuid2.equals(uuid)) {
                    bArrM585w2 = C1460d.m585w1(bArrArray, uuid);
                    if (bArrM585w2 != null) {
                        bArrArray = bArrM585w2;
                    }
                    int i9 = (bArrArray[0] & 255) | ((bArrArray[1] & 255) << 8) | ((bArrArray[2] & 255) << 16) | ((bArrArray[3] & 255) << 24);
                    s2 = (short) (((bArrArray[5] & 255) << 8) | (bArrArray[4] & 255));
                    short s3 = (short) (((bArrArray[7] & 255) << 8) | (bArrArray[6] & 255));
                    if (s2 == 1 || s3 != 1) {
                        Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                    } else {
                        short s4 = (short) (((bArrArray[9] & 255) << 8) | (bArrArray[8] & 255));
                        Charset charset = C4483c.f11946d;
                        String str5 = new String(bArrArray, 10, s4, charset);
                        if (!str5.contains("<LA_URL>")) {
                            int iIndexOf = str5.indexOf("</DATA>");
                            if (iIndexOf == -1) {
                                Log.w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                            }
                            String strSubstring = str5.substring(0, iIndexOf);
                            String strSubstring2 = str5.substring(iIndexOf);
                            String strM859k = C1643a.m859k(C1643a.m841b(strSubstring2, C1643a.m841b(strSubstring, 26)), strSubstring, "<LA_URL>https://x</LA_URL>", strSubstring2);
                            int i10 = i9 + 52;
                            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i10);
                            byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
                            byteBufferAllocate2.putInt(i10);
                            byteBufferAllocate2.putShort(s2);
                            byteBufferAllocate2.putShort(s3);
                            byteBufferAllocate2.putShort((short) (strM859k.length() * 2));
                            byteBufferAllocate2.put(strM859k.getBytes(charset));
                            bArrArray = byteBufferAllocate2.array();
                        }
                    }
                    if (bArrArray != null) {
                        length = bArrArray.length;
                    } else {
                        length = 0;
                    }
                    int i11 = length + 32;
                    byteBufferAllocate = ByteBuffer.allocate(i11);
                    byteBufferAllocate.putInt(i11);
                    byteBufferAllocate.putInt(1886614376);
                    byteBufferAllocate.putInt(0);
                    byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                    byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
                    if (bArrArray != null && bArrArray.length != 0) {
                        byteBufferAllocate.putInt(bArrArray.length);
                        byteBufferAllocate.put(bArrArray);
                    }
                    bArrArray = byteBufferAllocate.array();
                }
                i5 = C2738e0.f6708a;
                if (i5 < 23 || !C2997x0.f8024d.equals(uuid)) {
                    if (uuid2.equals(uuid) && "Amazon".equals(C2738e0.f6710c)) {
                        str2 = C2738e0.f6711d;
                        if ("AFTB".equals(str2) || "AFTS".equals(str2) || "AFTM".equals(str2) || "AFTT".equals(str2)) {
                            bArrM585w1 = C1460d.m585w1(bArrArray, uuid);
                            if (bArrM585w1 == null) {
                            }
                        }
                    }
                    bArrM585w1 = bArrArray;
                } else {
                    bArrM585w1 = C1460d.m585w1(bArrArray, uuid);
                    if (bArrM585w1 == null) {
                        bArrM585w1 = bArrArray;
                    }
                }
                UUID uuid3 = this.f7978b;
                str3 = schemeData2.f19854m;
                if (i5 >= 26 && C2997x0.f8023c.equals(uuid3) && ("video/mp4".equals(str3) || "audio/mp4".equals(str3))) {
                    str4 = "cenc";
                } else {
                    str4 = str3;
                }
                bArr2 = bArrM585w1;
                str = str4;
            } else {
                schemeData = list.get(0);
            }
            schemeData2 = schemeData;
            uuid = this.f7978b;
            bArrArray = schemeData2.f19855n;
            Objects.requireNonNull(bArrArray);
            uuid2 = C2997x0.f8025e;
            if (uuid2.equals(uuid)) {
                bArrM585w2 = C1460d.m585w1(bArrArray, uuid);
                if (bArrM585w2 != null) {
                    bArrArray = bArrM585w2;
                }
                int i12 = (bArrArray[0] & 255) | ((bArrArray[1] & 255) << 8) | ((bArrArray[2] & 255) << 16) | ((bArrArray[3] & 255) << 24);
                s2 = (short) (((bArrArray[5] & 255) << 8) | (bArrArray[4] & 255));
                short s5 = (short) (((bArrArray[7] & 255) << 8) | (bArrArray[6] & 255));
                if (s2 == 1) {
                    Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                } else {
                    Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                }
                if (bArrArray != null) {
                    length = bArrArray.length;
                } else {
                    length = 0;
                }
                int i13 = length + 32;
                byteBufferAllocate = ByteBuffer.allocate(i13);
                byteBufferAllocate.putInt(i13);
                byteBufferAllocate.putInt(1886614376);
                byteBufferAllocate.putInt(0);
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
                if (bArrArray != null) {
                    byteBufferAllocate.putInt(bArrArray.length);
                    byteBufferAllocate.put(bArrArray);
                }
                bArrArray = byteBufferAllocate.array();
            }
            i5 = C2738e0.f6708a;
            if (i5 < 23) {
                if (uuid2.equals(uuid)) {
                    str2 = C2738e0.f6711d;
                    if ("AFTB".equals(str2)) {
                        bArrM585w1 = C1460d.m585w1(bArrArray, uuid);
                        if (bArrM585w1 == null) {
                        }
                    } else {
                        bArrM585w1 = C1460d.m585w1(bArrArray, uuid);
                        if (bArrM585w1 == null) {
                        }
                    }
                    UUID uuid4 = this.f7978b;
                    str3 = schemeData2.f19854m;
                    if (i5 >= 26) {
                        str4 = str3;
                    } else {
                        str4 = str3;
                    }
                    bArr2 = bArrM585w1;
                    str = str4;
                }
            } else if (uuid2.equals(uuid)) {
                str2 = C2738e0.f6711d;
                if ("AFTB".equals(str2)) {
                    bArrM585w1 = C1460d.m585w1(bArrArray, uuid);
                    if (bArrM585w1 == null) {
                    }
                } else {
                    bArrM585w1 = C1460d.m585w1(bArrArray, uuid);
                    if (bArrM585w1 == null) {
                    }
                }
                UUID uuid5 = this.f7978b;
                str3 = schemeData2.f19854m;
                if (i5 >= 26) {
                    str4 = str3;
                } else {
                    str4 = str3;
                }
                bArr2 = bArrM585w1;
                str = str4;
            }
            bArrM585w1 = bArrArray;
            UUID uuid6 = this.f7978b;
            str3 = schemeData2.f19854m;
            if (i5 >= 26) {
                str4 = str3;
            } else {
                str4 = str3;
            }
            bArr2 = bArrM585w1;
            str = str4;
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f7979c.getKeyRequest(bArr, bArr2, str, i, map);
        UUID uuid7 = this.f7978b;
        byte[] data = keyRequest.getData();
        if (C2997x0.f8023c.equals(uuid7) && C2738e0.f6708a < 27) {
            data = C2738e0.m3015w(C2738e0.m3004l(data).replace('+', '-').replace(MentionUtilsKt.SLASH_CHAR, '_'));
        }
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeData2 != null && !TextUtils.isEmpty(schemeData2.f19853l)) {
            defaultUrl = schemeData2.f19853l;
        }
        return new InterfaceC2966a0.a(data, defaultUrl, C2738e0.f6708a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    /* JADX INFO: renamed from: l */
    public int mo3580l() {
        return 2;
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0
    public synchronized void release() {
        int i = this.f7980d - 1;
        this.f7980d = i;
        if (i == 0) {
            this.f7979c.release();
        }
    }
}
