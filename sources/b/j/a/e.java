package b.j.a;

import android.webkit.JavascriptInterface;
import b.d.b.a.outline;
import b.g.a.b.p.SegmentedStringWriter;
import b.g.a.b.t.BufferRecycler;
import b.g.a.b.t.TextBuffer;
import b.g.a.c.ObjectMapper;
import b.g.a.c.i0.ClassUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hcaptcha.sdk.HCaptchaConfig;
import com.hcaptcha.sdk.HCaptchaError;
import com.hcaptcha.sdk.HCaptchaException;
import com.hcaptcha.sdk.HCaptchaTokenResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class e implements Serializable {
    private final HCaptchaConfig hCaptchaConfig;
    private final b.j.a.f.a onFailureListener;
    private final b.j.a.f.b onLoadedListener;
    private final b.j.a.f.c<HCaptchaTokenResponse> onSuccessListener;

    public e(HCaptchaConfig hCaptchaConfig, b.j.a.f.b bVar, b.j.a.f.c<HCaptchaTokenResponse> cVar, b.j.a.f.a aVar) {
        this.hCaptchaConfig = hCaptchaConfig;
        this.onLoadedListener = bVar;
        this.onSuccessListener = cVar;
        this.onFailureListener = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        Objects.requireNonNull(eVar);
        HCaptchaConfig hCaptchaConfig = this.hCaptchaConfig;
        HCaptchaConfig hCaptchaConfig2 = eVar.hCaptchaConfig;
        if (hCaptchaConfig != null ? !hCaptchaConfig.equals(hCaptchaConfig2) : hCaptchaConfig2 != null) {
            return false;
        }
        b.j.a.f.b bVar = this.onLoadedListener;
        b.j.a.f.b bVar2 = eVar.onLoadedListener;
        if (bVar != null ? !bVar.equals(bVar2) : bVar2 != null) {
            return false;
        }
        b.j.a.f.c<HCaptchaTokenResponse> cVar = this.onSuccessListener;
        b.j.a.f.c<HCaptchaTokenResponse> cVar2 = eVar.onSuccessListener;
        if (cVar != null ? !cVar.equals(cVar2) : cVar2 != null) {
            return false;
        }
        b.j.a.f.a aVar = this.onFailureListener;
        b.j.a.f.a aVar2 = eVar.onFailureListener;
        return aVar != null ? aVar.equals(aVar2) : aVar2 == null;
    }

    @JavascriptInterface
    public String getConfig() throws JsonProcessingException {
        char[] cArr;
        ObjectMapper objectMapper = new ObjectMapper(null, null, null);
        HCaptchaConfig hCaptchaConfig = this.hCaptchaConfig;
        SegmentedStringWriter segmentedStringWriter = new SegmentedStringWriter(objectMapper._jsonFactory.a());
        try {
            objectMapper.b(objectMapper.c(segmentedStringWriter), hCaptchaConfig);
            String strC = segmentedStringWriter.j.c();
            TextBuffer textBuffer = segmentedStringWriter.j;
            textBuffer.c = -1;
            textBuffer.h = 0;
            textBuffer.j = null;
            if (textBuffer.e) {
                textBuffer.e = false;
                textBuffer.d.clear();
                textBuffer.f = 0;
                textBuffer.h = 0;
            }
            BufferRecycler bufferRecycler = textBuffer.f678b;
            if (bufferRecycler != null && (cArr = textBuffer.g) != null) {
                textBuffer.g = null;
                bufferRecycler.d.set(2, cArr);
            }
            return strC;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw new JsonMappingException(null, String.format("Unexpected IOException (of type %s): %s", e2.getClass().getName(), ClassUtil.h(e2)));
        }
    }

    public int hashCode() {
        HCaptchaConfig hCaptchaConfig = this.hCaptchaConfig;
        int iHashCode = hCaptchaConfig == null ? 43 : hCaptchaConfig.hashCode();
        b.j.a.f.b bVar = this.onLoadedListener;
        int iHashCode2 = ((iHashCode + 59) * 59) + (bVar == null ? 43 : bVar.hashCode());
        b.j.a.f.c<HCaptchaTokenResponse> cVar = this.onSuccessListener;
        int iHashCode3 = (iHashCode2 * 59) + (cVar == null ? 43 : cVar.hashCode());
        b.j.a.f.a aVar = this.onFailureListener;
        return (iHashCode3 * 59) + (aVar != null ? aVar.hashCode() : 43);
    }

    @JavascriptInterface
    public void onError(int i) {
        this.onFailureListener.onFailure(new HCaptchaException(HCaptchaError.fromId(i)));
    }

    @JavascriptInterface
    public void onLoaded() {
        c cVar = (c) this.onLoadedListener;
        cVar.k.post(new b(cVar));
    }

    @JavascriptInterface
    public void onPass(String str) {
        this.onSuccessListener.onSuccess(new HCaptchaTokenResponse(str));
    }

    public String toString() {
        StringBuilder sbU = outline.U("HCaptchaJSInterface(hCaptchaConfig=");
        sbU.append(this.hCaptchaConfig);
        sbU.append(", onLoadedListener=");
        sbU.append(this.onLoadedListener);
        sbU.append(", onSuccessListener=");
        sbU.append(this.onSuccessListener);
        sbU.append(", onFailureListener=");
        sbU.append(this.onFailureListener);
        sbU.append(")");
        return sbU.toString();
    }
}
