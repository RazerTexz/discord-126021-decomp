package b.i.a.f.c.a.f.b;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public static final b.i.a.f.e.l.a j = new b.i.a.f.e.l.a("RevokeAccessOperation", new String[0]);
    public final String k;
    public final b.i.a.f.e.h.j.o l;

    public e(String str) {
        b.c.a.a0.d.w(str);
        this.k = str;
        this.l = new b.i.a.f.e.h.j.o(null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.l;
        try {
            String strValueOf = String.valueOf(this.k);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strValueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(strValueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.j;
            } else {
                j.b("Unable to revoke access!", new Object[0]);
            }
            b.i.a.f.e.l.a aVar = j;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            aVar.a(sb.toString(), new Object[0]);
        } catch (IOException e) {
            b.i.a.f.e.l.a aVar2 = j;
            String strValueOf2 = String.valueOf(e.toString());
            aVar2.b(strValueOf2.length() != 0 ? "IOException when revoking access: ".concat(strValueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e2) {
            b.i.a.f.e.l.a aVar3 = j;
            String strValueOf3 = String.valueOf(e2.toString());
            aVar3.b(strValueOf3.length() != 0 ? "Exception when revoking access: ".concat(strValueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.l.g(status);
    }
}
