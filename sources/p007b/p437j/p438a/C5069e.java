package p007b.p437j.p438a;

import android.webkit.JavascriptInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hcaptcha.sdk.HCaptchaConfig;
import com.hcaptcha.sdk.HCaptchaError;
import com.hcaptcha.sdk.HCaptchaException;
import com.hcaptcha.sdk.HCaptchaTokenResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.p200p.C2129i;
import p007b.p195g.p196a.p198b.p204t.C2139a;
import p007b.p195g.p196a.p198b.p204t.C2149k;
import p007b.p195g.p196a.p205c.C2368r;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p437j.p438a.p439f.InterfaceC5070a;
import p007b.p437j.p438a.p439f.InterfaceC5071b;
import p007b.p437j.p438a.p439f.InterfaceC5072c;

/* JADX INFO: renamed from: b.j.a.e */
/* JADX INFO: loaded from: classes3.dex */
public class C5069e implements Serializable {
    private final HCaptchaConfig hCaptchaConfig;
    private final InterfaceC5070a onFailureListener;
    private final InterfaceC5071b onLoadedListener;
    private final InterfaceC5072c<HCaptchaTokenResponse> onSuccessListener;

    public C5069e(HCaptchaConfig hCaptchaConfig, InterfaceC5071b interfaceC5071b, InterfaceC5072c<HCaptchaTokenResponse> interfaceC5072c, InterfaceC5070a interfaceC5070a) {
        this.hCaptchaConfig = hCaptchaConfig;
        this.onLoadedListener = interfaceC5071b;
        this.onSuccessListener = interfaceC5072c;
        this.onFailureListener = interfaceC5070a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5069e)) {
            return false;
        }
        C5069e c5069e = (C5069e) obj;
        Objects.requireNonNull(c5069e);
        HCaptchaConfig hCaptchaConfig = this.hCaptchaConfig;
        HCaptchaConfig hCaptchaConfig2 = c5069e.hCaptchaConfig;
        if (hCaptchaConfig != null ? !hCaptchaConfig.equals(hCaptchaConfig2) : hCaptchaConfig2 != null) {
            return false;
        }
        InterfaceC5071b interfaceC5071b = this.onLoadedListener;
        InterfaceC5071b interfaceC5071b2 = c5069e.onLoadedListener;
        if (interfaceC5071b != null ? !interfaceC5071b.equals(interfaceC5071b2) : interfaceC5071b2 != null) {
            return false;
        }
        InterfaceC5072c<HCaptchaTokenResponse> interfaceC5072c = this.onSuccessListener;
        InterfaceC5072c<HCaptchaTokenResponse> interfaceC5072c2 = c5069e.onSuccessListener;
        if (interfaceC5072c != null ? !interfaceC5072c.equals(interfaceC5072c2) : interfaceC5072c2 != null) {
            return false;
        }
        InterfaceC5070a interfaceC5070a = this.onFailureListener;
        InterfaceC5070a interfaceC5070a2 = c5069e.onFailureListener;
        return interfaceC5070a != null ? interfaceC5070a.equals(interfaceC5070a2) : interfaceC5070a2 == null;
    }

    @JavascriptInterface
    public String getConfig() throws JsonProcessingException {
        char[] cArr;
        C2368r c2368r = new C2368r(null, null, null);
        HCaptchaConfig hCaptchaConfig = this.hCaptchaConfig;
        C2129i c2129i = new C2129i(c2368r._jsonFactory.m1626a());
        try {
            c2368r.m2224b(c2368r.m2225c(c2129i), hCaptchaConfig);
            String strM1741c = c2129i.f4557j.m1741c();
            C2149k c2149k = c2129i.f4557j;
            c2149k.f4606c = -1;
            c2149k.f4611h = 0;
            c2149k.f4613j = null;
            if (c2149k.f4608e) {
                c2149k.f4608e = false;
                c2149k.f4607d.clear();
                c2149k.f4609f = 0;
                c2149k.f4611h = 0;
            }
            C2139a c2139a = c2149k.f4605b;
            if (c2139a != null && (cArr = c2149k.f4610g) != null) {
                c2149k.f4610g = null;
                c2139a.f4594d.set(2, cArr);
            }
            return strM1741c;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw new JsonMappingException(null, String.format("Unexpected IOException (of type %s): %s", e2.getClass().getName(), C2342d.m2176h(e2)));
        }
    }

    public int hashCode() {
        HCaptchaConfig hCaptchaConfig = this.hCaptchaConfig;
        int iHashCode = hCaptchaConfig == null ? 43 : hCaptchaConfig.hashCode();
        InterfaceC5071b interfaceC5071b = this.onLoadedListener;
        int iHashCode2 = ((iHashCode + 59) * 59) + (interfaceC5071b == null ? 43 : interfaceC5071b.hashCode());
        InterfaceC5072c<HCaptchaTokenResponse> interfaceC5072c = this.onSuccessListener;
        int iHashCode3 = (iHashCode2 * 59) + (interfaceC5072c == null ? 43 : interfaceC5072c.hashCode());
        InterfaceC5070a interfaceC5070a = this.onFailureListener;
        return (iHashCode3 * 59) + (interfaceC5070a != null ? interfaceC5070a.hashCode() : 43);
    }

    @JavascriptInterface
    public void onError(int i) {
        this.onFailureListener.onFailure(new HCaptchaException(HCaptchaError.fromId(i)));
    }

    @JavascriptInterface
    public void onLoaded() {
        C5067c c5067c = (C5067c) this.onLoadedListener;
        c5067c.f13583k.post(new RunnableC5066b(c5067c));
    }

    @JavascriptInterface
    public void onPass(String str) {
        this.onSuccessListener.onSuccess(new HCaptchaTokenResponse(str));
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("HCaptchaJSInterface(hCaptchaConfig=");
        sbM833U.append(this.hCaptchaConfig);
        sbM833U.append(", onLoadedListener=");
        sbM833U.append(this.onLoadedListener);
        sbM833U.append(", onSuccessListener=");
        sbM833U.append(this.onSuccessListener);
        sbM833U.append(", onFailureListener=");
        sbM833U.append(this.onFailureListener);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
