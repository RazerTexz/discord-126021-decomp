package b.i.a.c.w2;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrm$KeyRequest;
import android.media.MediaDrm$ProvisionRequest;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.x0;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
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

/* JADX INFO: compiled from: FrameworkMediaDrm.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public final class c0 implements a0 {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UUID f1151b;
    public final MediaDrm c;
    public int d;

    public c0(UUID uuid) throws UnsupportedSchemeException {
        Objects.requireNonNull(uuid);
        UUID uuid2 = x0.f1158b;
        b.c.a.a0.d.m(!uuid2.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f1151b = uuid;
        MediaDrm mediaDrm = new MediaDrm((b.i.a.c.f3.e0.a >= 27 || !x0.c.equals(uuid)) ? uuid : uuid2);
        this.c = mediaDrm;
        this.d = 1;
        if (x0.d.equals(uuid) && "ASUS_Z00AD".equals(b.i.a.c.f3.e0.d)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // b.i.a.c.w2.a0
    public Map<String, String> a(byte[] bArr) {
        return this.c.queryKeyStatus(bArr);
    }

    @Override // b.i.a.c.w2.a0
    public a0$d b() {
        MediaDrm$ProvisionRequest provisionRequest = this.c.getProvisionRequest();
        return new a0$d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // b.i.a.c.w2.a0
    public b.i.a.c.v2.b c(byte[] bArr) throws MediaCryptoException {
        int i = b.i.a.c.f3.e0.a;
        boolean z2 = i < 21 && x0.d.equals(this.f1151b) && "L3".equals(this.c.getPropertyString("securityLevel"));
        UUID uuid = this.f1151b;
        if (i < 27 && x0.c.equals(uuid)) {
            uuid = x0.f1158b;
        }
        return new b0(uuid, bArr, z2);
    }

    @Override // b.i.a.c.w2.a0
    public byte[] d() throws MediaDrmException {
        return this.c.openSession();
    }

    @Override // b.i.a.c.w2.a0
    public boolean e(byte[] bArr, String str) {
        if (b.i.a.c.f3.e0.a >= 31) {
            return c0$a.a(this.c, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f1151b, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // b.i.a.c.w2.a0
    public void f(byte[] bArr, byte[] bArr2) {
        this.c.restoreKeys(bArr, bArr2);
    }

    @Override // b.i.a.c.w2.a0
    public void g(byte[] bArr) {
        this.c.closeSession(bArr);
    }

    @Override // b.i.a.c.w2.a0
    public void h(@Nullable a0$b a0_b) {
        this.c.setOnEventListener(new o(this, a0_b));
    }

    @Override // b.i.a.c.w2.a0
    @Nullable
    public byte[] i(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (x0.c.equals(this.f1151b) && b.i.a.c.f3.e0.a < 27) {
            try {
                JSONObject jSONObject = new JSONObject(b.i.a.c.f3.e0.l(bArr2));
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
                bArr2 = b.i.a.c.f3.e0.w(sb.toString());
            } catch (JSONException e) {
                String strL = b.i.a.c.f3.e0.l(bArr2);
                b.i.a.c.f3.q.b("ClearKeyUtil", strL.length() != 0 ? "Failed to adjust response data: ".concat(strL) : new String("Failed to adjust response data: "), e);
            }
        }
        return this.c.provideKeyResponse(bArr, bArr2);
    }

    @Override // b.i.a.c.w2.a0
    public void j(byte[] bArr) throws DeniedByServerException {
        this.c.provideProvisionResponse(bArr);
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
    @Override // b.i.a.c.w2.a0
    @SuppressLint({"WrongConstant"})
    public a0$a k(byte[] bArr, @Nullable List<DrmInitData$SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException {
        byte[] bArr2;
        String str;
        int i2;
        DrmInitData$SchemeData drmInitData$SchemeData;
        b.i.a.c.x2.i0.j jVarV1;
        int i3;
        int i4;
        boolean z2;
        UUID uuid;
        byte[] bArrArray;
        UUID uuid2;
        int i5;
        String str2;
        byte[] bArrW1;
        String str3;
        String str4;
        byte[] bArrW2;
        short s2;
        int length;
        ByteBuffer byteBufferAllocate;
        DrmInitData$SchemeData drmInitData$SchemeData2 = null;
        if (list != null) {
            if (x0.d.equals(this.f1151b)) {
                if (b.i.a.c.f3.e0.a < 28 || list.size() <= 1) {
                    i2 = 0;
                    while (true) {
                        if (i2 < list.size()) {
                            DrmInitData$SchemeData drmInitData$SchemeData3 = list.get(i2);
                            byte[] bArr3 = drmInitData$SchemeData3.n;
                            Objects.requireNonNull(bArr3);
                            jVarV1 = b.c.a.a0.d.v1(bArr3);
                            if (jVarV1 == null) {
                                i3 = -1;
                            } else {
                                i3 = jVarV1.f1227b;
                            }
                            i4 = b.i.a.c.f3.e0.a;
                            if ((i4 >= 23 && i3 == 0) || (i4 >= 23 && i3 == 1)) {
                                drmInitData$SchemeData2 = drmInitData$SchemeData3;
                            }
                        } else {
                            drmInitData$SchemeData = list.get(0);
                        }
                    }
                } else {
                    DrmInitData$SchemeData drmInitData$SchemeData4 = list.get(0);
                    int i6 = 0;
                    int length2 = 0;
                    while (true) {
                        if (i6 >= list.size()) {
                            z2 = true;
                            break;
                        }
                        DrmInitData$SchemeData drmInitData$SchemeData5 = list.get(i6);
                        byte[] bArr4 = drmInitData$SchemeData5.n;
                        Objects.requireNonNull(bArr4);
                        if (b.i.a.c.f3.e0.a(drmInitData$SchemeData5.m, drmInitData$SchemeData4.m) && b.i.a.c.f3.e0.a(drmInitData$SchemeData5.l, drmInitData$SchemeData4.l)) {
                            if (b.c.a.a0.d.v1(bArr4) != null) {
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
                            byte[] bArr6 = list.get(i8).n;
                            Objects.requireNonNull(bArr6);
                            int length3 = bArr6.length;
                            System.arraycopy(bArr6, 0, bArr5, i7, length3);
                            i7 += length3;
                        }
                        drmInitData$SchemeData = new DrmInitData$SchemeData(drmInitData$SchemeData4.k, drmInitData$SchemeData4.l, drmInitData$SchemeData4.m, bArr5);
                    } else {
                        i2 = 0;
                        while (true) {
                            if (i2 < list.size()) {
                                DrmInitData$SchemeData drmInitData$SchemeData6 = list.get(i2);
                                byte[] bArr7 = drmInitData$SchemeData6.n;
                                Objects.requireNonNull(bArr7);
                                jVarV1 = b.c.a.a0.d.v1(bArr7);
                                if (jVarV1 == null) {
                                    i3 = -1;
                                } else {
                                    i3 = jVarV1.f1227b;
                                }
                                i4 = b.i.a.c.f3.e0.a;
                                i2 = i4 >= 23 ? i2 + 1 : i2 + 1;
                                drmInitData$SchemeData2 = drmInitData$SchemeData6;
                            } else {
                                drmInitData$SchemeData = list.get(0);
                            }
                        }
                    }
                }
                uuid = this.f1151b;
                bArrArray = drmInitData$SchemeData2.n;
                Objects.requireNonNull(bArrArray);
                uuid2 = x0.e;
                if (uuid2.equals(uuid)) {
                    bArrW2 = b.c.a.a0.d.w1(bArrArray, uuid);
                    if (bArrW2 != null) {
                        bArrArray = bArrW2;
                    }
                    int i9 = (bArrArray[0] & 255) | ((bArrArray[1] & 255) << 8) | ((bArrArray[2] & 255) << 16) | ((bArrArray[3] & 255) << 24);
                    s2 = (short) (((bArrArray[5] & 255) << 8) | (bArrArray[4] & 255));
                    short s3 = (short) (((bArrArray[7] & 255) << 8) | (bArrArray[6] & 255));
                    if (s2 == 1 || s3 != 1) {
                        Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                    } else {
                        short s4 = (short) (((bArrArray[9] & 255) << 8) | (bArrArray[8] & 255));
                        Charset charset = b.i.b.a.c.d;
                        String str5 = new String(bArrArray, 10, s4, charset);
                        if (!str5.contains("<LA_URL>")) {
                            int iIndexOf = str5.indexOf("</DATA>");
                            if (iIndexOf == -1) {
                                Log.w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                            }
                            String strSubstring = str5.substring(0, iIndexOf);
                            String strSubstring2 = str5.substring(iIndexOf);
                            String strK = b.d.b.a.a.k(b.d.b.a.a.b(strSubstring2, b.d.b.a.a.b(strSubstring, 26)), strSubstring, "<LA_URL>https://x</LA_URL>", strSubstring2);
                            int i10 = i9 + 52;
                            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i10);
                            byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
                            byteBufferAllocate2.putInt(i10);
                            byteBufferAllocate2.putShort(s2);
                            byteBufferAllocate2.putShort(s3);
                            byteBufferAllocate2.putShort((short) (strK.length() * 2));
                            byteBufferAllocate2.put(strK.getBytes(charset));
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
                i5 = b.i.a.c.f3.e0.a;
                if (i5 < 23 || !x0.d.equals(uuid)) {
                    if (uuid2.equals(uuid) && "Amazon".equals(b.i.a.c.f3.e0.c)) {
                        str2 = b.i.a.c.f3.e0.d;
                        if ("AFTB".equals(str2) || "AFTS".equals(str2) || "AFTM".equals(str2) || "AFTT".equals(str2)) {
                            bArrW1 = b.c.a.a0.d.w1(bArrArray, uuid);
                            if (bArrW1 == null) {
                            }
                        }
                    }
                    bArrW1 = bArrArray;
                } else {
                    bArrW1 = b.c.a.a0.d.w1(bArrArray, uuid);
                    if (bArrW1 == null) {
                        bArrW1 = bArrArray;
                    }
                }
                UUID uuid3 = this.f1151b;
                str3 = drmInitData$SchemeData2.m;
                if (i5 >= 26 && x0.c.equals(uuid3) && ("video/mp4".equals(str3) || "audio/mp4".equals(str3))) {
                    str4 = "cenc";
                } else {
                    str4 = str3;
                }
                bArr2 = bArrW1;
                str = str4;
            } else {
                drmInitData$SchemeData = list.get(0);
            }
            drmInitData$SchemeData2 = drmInitData$SchemeData;
            uuid = this.f1151b;
            bArrArray = drmInitData$SchemeData2.n;
            Objects.requireNonNull(bArrArray);
            uuid2 = x0.e;
            if (uuid2.equals(uuid)) {
                bArrW2 = b.c.a.a0.d.w1(bArrArray, uuid);
                if (bArrW2 != null) {
                    bArrArray = bArrW2;
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
            i5 = b.i.a.c.f3.e0.a;
            if (i5 < 23) {
                if (uuid2.equals(uuid)) {
                    str2 = b.i.a.c.f3.e0.d;
                    if ("AFTB".equals(str2)) {
                        bArrW1 = b.c.a.a0.d.w1(bArrArray, uuid);
                        if (bArrW1 == null) {
                        }
                    } else {
                        bArrW1 = b.c.a.a0.d.w1(bArrArray, uuid);
                        if (bArrW1 == null) {
                        }
                    }
                    UUID uuid4 = this.f1151b;
                    str3 = drmInitData$SchemeData2.m;
                    if (i5 >= 26) {
                        str4 = str3;
                    } else {
                        str4 = str3;
                    }
                    bArr2 = bArrW1;
                    str = str4;
                }
            } else if (uuid2.equals(uuid)) {
                str2 = b.i.a.c.f3.e0.d;
                if ("AFTB".equals(str2)) {
                    bArrW1 = b.c.a.a0.d.w1(bArrArray, uuid);
                    if (bArrW1 == null) {
                    }
                } else {
                    bArrW1 = b.c.a.a0.d.w1(bArrArray, uuid);
                    if (bArrW1 == null) {
                    }
                }
                UUID uuid5 = this.f1151b;
                str3 = drmInitData$SchemeData2.m;
                if (i5 >= 26) {
                    str4 = str3;
                } else {
                    str4 = str3;
                }
                bArr2 = bArrW1;
                str = str4;
            }
            bArrW1 = bArrArray;
            UUID uuid6 = this.f1151b;
            str3 = drmInitData$SchemeData2.m;
            if (i5 >= 26) {
                str4 = str3;
            } else {
                str4 = str3;
            }
            bArr2 = bArrW1;
            str = str4;
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm$KeyRequest keyRequest = this.c.getKeyRequest(bArr, bArr2, str, i, map);
        UUID uuid7 = this.f1151b;
        byte[] data = keyRequest.getData();
        if (x0.c.equals(uuid7) && b.i.a.c.f3.e0.a < 27) {
            data = b.i.a.c.f3.e0.w(b.i.a.c.f3.e0.l(data).replace('+', '-').replace(MentionUtilsKt.SLASH_CHAR, '_'));
        }
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && drmInitData$SchemeData2 != null && !TextUtils.isEmpty(drmInitData$SchemeData2.l)) {
            defaultUrl = drmInitData$SchemeData2.l;
        }
        return new a0$a(data, defaultUrl, b.i.a.c.f3.e0.a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // b.i.a.c.w2.a0
    public int l() {
        return 2;
    }

    @Override // b.i.a.c.w2.a0
    public synchronized void release() {
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            this.c.release();
        }
    }
}
