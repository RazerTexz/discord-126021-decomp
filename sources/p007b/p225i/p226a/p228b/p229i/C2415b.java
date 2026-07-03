package p007b.p225i.p226a.p228b.p229i;

import androidx.browser.trusted.sharing.ShareTarget;
import com.discord.restapi.RestAPIBuilder;
import com.google.firebase.encoders.EncodingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p228b.p229i.C2417d;
import p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2431n;
import p007b.p225i.p226a.p228b.p229i.p230e.C2425h;
import p007b.p225i.p361c.p393p.p395h.C4793d;

/* JADX INFO: renamed from: b.i.a.b.i.b */
/* JADX INFO: compiled from: CctTransportBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2415b {

    /* JADX INFO: renamed from: a */
    public final C2417d f5130a;

    public C2415b(C2417d c2417d) {
        this.f5130a = c2417d;
    }

    /* JADX INFO: renamed from: a */
    public Object m2295a(Object obj) throws IOException {
        C2417d c2417d = this.f5130a;
        C2417d.a aVar = (C2417d.a) obj;
        Objects.requireNonNull(c2417d);
        C1460d.m486X("CctTransportBackend", "Making request to: %s", aVar.f5139a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f5139a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(c2417d.f5138g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "2.3.2"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", RestAPIBuilder.CONTENT_TYPE_JSON);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f5141c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    ((C4793d) c2417d.f5132a).m6712b(aVar.f5140b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    C1460d.m451L0("CctTransportBackend", "Status Code: " + responseCode);
                    C1460d.m451L0("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    C1460d.m451L0("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new C2417d.b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new C2417d.b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            C2417d.b bVar = new C2417d.b(responseCode, null, ((C2425h) AbstractC2431n.m2333a(new BufferedReader(new InputStreamReader(gZIPInputStream)))).f5188a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } catch (Throwable th) {
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        } catch (EncodingException e) {
            e = e;
            C1460d.m504c0("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new C2417d.b(400, null, 0L);
        } catch (ConnectException e2) {
            e = e2;
            C1460d.m504c0("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new C2417d.b(500, null, 0L);
        } catch (UnknownHostException e3) {
            e = e3;
            C1460d.m504c0("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new C2417d.b(500, null, 0L);
        } catch (IOException e4) {
            e = e4;
            C1460d.m504c0("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new C2417d.b(400, null, 0L);
        }
    }
}
