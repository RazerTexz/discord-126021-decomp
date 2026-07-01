package b.i.a.c.w2;

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
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.C;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.Util2;
import b.i.a.c.v2.CryptoConfig;
import b.i.a.c.w2.ExoMediaDrm;
import b.i.a.c.x2.i0.PsshAtomUtil;
import b.i.b.a.Charsets;
import com.discord.widgets.chat.input.MentionUtils;
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

/* JADX INFO: renamed from: b.i.a.c.w2.c0, reason: use source file name */
/* JADX INFO: compiled from: FrameworkMediaDrm.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public final class FrameworkMediaDrm implements ExoMediaDrm {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UUID f1151b;
    public final MediaDrm c;
    public int d;

    /* JADX INFO: renamed from: b.i.a.c.w2.c0$a */
    /* JADX INFO: compiled from: FrameworkMediaDrm.java */
    @RequiresApi(31)
    public static class a {
        @DoNotInline
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }
    }

    public FrameworkMediaDrm(UUID uuid) throws UnsupportedSchemeException {
        Objects.requireNonNull(uuid);
        UUID uuid2 = C.f1158b;
        AnimatableValueParser.m(!uuid2.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f1151b = uuid;
        MediaDrm mediaDrm = new MediaDrm((Util2.a >= 27 || !C.c.equals(uuid)) ? uuid : uuid2);
        this.c = mediaDrm;
        this.d = 1;
        if (C.d.equals(uuid) && "ASUS_Z00AD".equals(Util2.d)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public Map<String, String> a(byte[] bArr) {
        return this.c.queryKeyStatus(bArr);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public ExoMediaDrm.d b() {
        MediaDrm.ProvisionRequest provisionRequest = this.c.getProvisionRequest();
        return new ExoMediaDrm.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public CryptoConfig c(byte[] bArr) throws MediaCryptoException {
        int i = Util2.a;
        boolean z2 = i < 21 && C.d.equals(this.f1151b) && "L3".equals(this.c.getPropertyString("securityLevel"));
        UUID uuid = this.f1151b;
        if (i < 27 && C.c.equals(uuid)) {
            uuid = C.f1158b;
        }
        return new FrameworkCryptoConfig(uuid, bArr, z2);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public byte[] d() throws MediaDrmException {
        return this.c.openSession();
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public boolean e(byte[] bArr, String str) {
        if (Util2.a >= 31) {
            return a.a(this.c, str);
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

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void f(byte[] bArr, byte[] bArr2) {
        this.c.restoreKeys(bArr, bArr2);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void g(byte[] bArr) {
        this.c.closeSession(bArr);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public void h(@Nullable final ExoMediaDrm.b bVar) {
        this.c.setOnEventListener(new MediaDrm.OnEventListener() { // from class: b.i.a.c.w2.o
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                FrameworkMediaDrm frameworkMediaDrm = this.a;
                ExoMediaDrm.b bVar2 = bVar;
                Objects.requireNonNull(frameworkMediaDrm);
                DefaultDrmSessionManager.c cVar = ((DefaultDrmSessionManager.b) bVar2).a.f2931x;
                Objects.requireNonNull(cVar);
                cVar.obtainMessage(i, bArr).sendToTarget();
            }
        });
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    @Nullable
    public byte[] i(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (C.c.equals(this.f1151b) && Util2.a < 27) {
            try {
                JSONObject jSONObject = new JSONObject(Util2.l(bArr2));
                StringBuilder sb = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sb.append("{\"k\":\"");
                    sb.append(jSONObject2.getString("k").replace('-', '+').replace('_', MentionUtils.SLASH_CHAR));
                    sb.append("\",\"kid\":\"");
                    sb.append(jSONObject2.getString("kid").replace('-', '+').replace('_', MentionUtils.SLASH_CHAR));
                    sb.append("\",\"kty\":\"");
                    sb.append(jSONObject2.getString("kty"));
                    sb.append("\"}");
                }
                sb.append("]}");
                bArr2 = Util2.w(sb.toString());
            } catch (JSONException e) {
                String strL = Util2.l(bArr2);
                Log2.b("ClearKeyUtil", strL.length() != 0 ? "Failed to adjust response data: ".concat(strL) : new String("Failed to adjust response data: "), e);
            }
        }
        return this.c.provideKeyResponse(bArr, bArr2);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
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
    @Override // b.i.a.c.w2.ExoMediaDrm
    @SuppressLint({"WrongConstant"})
    public ExoMediaDrm.a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException {
        byte[] bArr2;
        String str;
        int i2;
        DrmInitData.SchemeData schemeData;
        PsshAtomUtil psshAtomUtilV1;
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
        DrmInitData.SchemeData schemeData2 = null;
        if (list != null) {
            if (C.d.equals(this.f1151b)) {
                if (Util2.a < 28 || list.size() <= 1) {
                    i2 = 0;
                    while (true) {
                        if (i2 < list.size()) {
                            DrmInitData.SchemeData schemeData3 = list.get(i2);
                            byte[] bArr3 = schemeData3.n;
                            Objects.requireNonNull(bArr3);
                            psshAtomUtilV1 = AnimatableValueParser.v1(bArr3);
                            if (psshAtomUtilV1 == null) {
                                i3 = -1;
                            } else {
                                i3 = psshAtomUtilV1.f1227b;
                            }
                            i4 = Util2.a;
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
                        byte[] bArr4 = schemeData5.n;
                        Objects.requireNonNull(bArr4);
                        if (Util2.a(schemeData5.m, schemeData4.m) && Util2.a(schemeData5.l, schemeData4.l)) {
                            if (AnimatableValueParser.v1(bArr4) != null) {
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
                        schemeData = new DrmInitData.SchemeData(schemeData4.k, schemeData4.l, schemeData4.m, bArr5);
                    } else {
                        i2 = 0;
                        while (true) {
                            if (i2 < list.size()) {
                                DrmInitData.SchemeData schemeData6 = list.get(i2);
                                byte[] bArr7 = schemeData6.n;
                                Objects.requireNonNull(bArr7);
                                psshAtomUtilV1 = AnimatableValueParser.v1(bArr7);
                                if (psshAtomUtilV1 == null) {
                                    i3 = -1;
                                } else {
                                    i3 = psshAtomUtilV1.f1227b;
                                }
                                i4 = Util2.a;
                                i2 = i4 >= 23 ? i2 + 1 : i2 + 1;
                                schemeData2 = schemeData6;
                            } else {
                                schemeData = list.get(0);
                            }
                        }
                    }
                }
                uuid = this.f1151b;
                bArrArray = schemeData2.n;
                Objects.requireNonNull(bArrArray);
                uuid2 = C.e;
                if (uuid2.equals(uuid)) {
                    bArrW2 = AnimatableValueParser.w1(bArrArray, uuid);
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
                        Charset charset = Charsets.d;
                        String str5 = new String(bArrArray, 10, s4, charset);
                        if (!str5.contains("<LA_URL>")) {
                            int iIndexOf = str5.indexOf("</DATA>");
                            if (iIndexOf == -1) {
                                Log.w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                            }
                            String strSubstring = str5.substring(0, iIndexOf);
                            String strSubstring2 = str5.substring(iIndexOf);
                            String strK = outline.k(outline.b(strSubstring2, outline.b(strSubstring, 26)), strSubstring, "<LA_URL>https://x</LA_URL>", strSubstring2);
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
                i5 = Util2.a;
                if (i5 < 23 || !C.d.equals(uuid)) {
                    if (uuid2.equals(uuid) && "Amazon".equals(Util2.c)) {
                        str2 = Util2.d;
                        if ("AFTB".equals(str2) || "AFTS".equals(str2) || "AFTM".equals(str2) || "AFTT".equals(str2)) {
                            bArrW1 = AnimatableValueParser.w1(bArrArray, uuid);
                            if (bArrW1 == null) {
                            }
                        }
                    }
                    bArrW1 = bArrArray;
                } else {
                    bArrW1 = AnimatableValueParser.w1(bArrArray, uuid);
                    if (bArrW1 == null) {
                        bArrW1 = bArrArray;
                    }
                }
                UUID uuid3 = this.f1151b;
                str3 = schemeData2.m;
                if (i5 >= 26 && C.c.equals(uuid3) && ("video/mp4".equals(str3) || "audio/mp4".equals(str3))) {
                    str4 = "cenc";
                } else {
                    str4 = str3;
                }
                bArr2 = bArrW1;
                str = str4;
            } else {
                schemeData = list.get(0);
            }
            schemeData2 = schemeData;
            uuid = this.f1151b;
            bArrArray = schemeData2.n;
            Objects.requireNonNull(bArrArray);
            uuid2 = C.e;
            if (uuid2.equals(uuid)) {
                bArrW2 = AnimatableValueParser.w1(bArrArray, uuid);
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
            i5 = Util2.a;
            if (i5 < 23) {
                if (uuid2.equals(uuid)) {
                    str2 = Util2.d;
                    if ("AFTB".equals(str2)) {
                        bArrW1 = AnimatableValueParser.w1(bArrArray, uuid);
                        if (bArrW1 == null) {
                        }
                    } else {
                        bArrW1 = AnimatableValueParser.w1(bArrArray, uuid);
                        if (bArrW1 == null) {
                        }
                    }
                    UUID uuid4 = this.f1151b;
                    str3 = schemeData2.m;
                    if (i5 >= 26) {
                        str4 = str3;
                    } else {
                        str4 = str3;
                    }
                    bArr2 = bArrW1;
                    str = str4;
                }
            } else if (uuid2.equals(uuid)) {
                str2 = Util2.d;
                if ("AFTB".equals(str2)) {
                    bArrW1 = AnimatableValueParser.w1(bArrArray, uuid);
                    if (bArrW1 == null) {
                    }
                } else {
                    bArrW1 = AnimatableValueParser.w1(bArrArray, uuid);
                    if (bArrW1 == null) {
                    }
                }
                UUID uuid5 = this.f1151b;
                str3 = schemeData2.m;
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
            str3 = schemeData2.m;
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
        MediaDrm.KeyRequest keyRequest = this.c.getKeyRequest(bArr, bArr2, str, i, map);
        UUID uuid7 = this.f1151b;
        byte[] data = keyRequest.getData();
        if (C.c.equals(uuid7) && Util2.a < 27) {
            data = Util2.w(Util2.l(data).replace('+', '-').replace(MentionUtils.SLASH_CHAR, '_'));
        }
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeData2 != null && !TextUtils.isEmpty(schemeData2.l)) {
            defaultUrl = schemeData2.l;
        }
        return new ExoMediaDrm.a(data, defaultUrl, Util2.a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public int l() {
        return 2;
    }

    @Override // b.i.a.c.w2.ExoMediaDrm
    public synchronized void release() {
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            this.c.release();
        }
    }
}
