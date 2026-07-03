package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3309o;
import p007b.p225i.p226a.p288f.p299e.p305l.C3395a;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.e */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3202e implements Runnable {

    /* JADX INFO: renamed from: j */
    public static final C3395a f9231j = new C3395a("RevokeAccessOperation", new String[0]);

    /* JADX INFO: renamed from: k */
    public final String f9232k;

    /* JADX INFO: renamed from: l */
    public final C3309o f9233l;

    public RunnableC3202e(String str) {
        C1460d.m583w(str);
        this.f9232k = str;
        this.f9233l = new C3309o(null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.f20491l;
        try {
            String strValueOf = String.valueOf(this.f9232k);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strValueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(strValueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f20489j;
            } else {
                f9231j.m4180b("Unable to revoke access!", new Object[0]);
            }
            C3395a c3395a = f9231j;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            c3395a.m4179a(sb.toString(), new Object[0]);
        } catch (IOException e) {
            C3395a c3395a2 = f9231j;
            String strValueOf2 = String.valueOf(e.toString());
            c3395a2.m4180b(strValueOf2.length() != 0 ? "IOException when revoking access: ".concat(strValueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e2) {
            C3395a c3395a3 = f9231j;
            String strValueOf3 = String.valueOf(e2.toString());
            c3395a3.m4180b(strValueOf3.length() != 0 ? "Exception when revoking access: ".concat(strValueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.f9233l.mo3989b(status);
    }
}
