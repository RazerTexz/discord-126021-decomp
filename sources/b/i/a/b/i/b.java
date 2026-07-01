package b.i.a.b.i;

import androidx.browser.trusted.sharing.ShareTarget;
import b.i.a.b.i.e.h;
import b.i.a.b.i.e.n;
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

/* JADX INFO: compiled from: CctTransportBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b {
    public final d a;

    public b(d dVar) {
        this.a = dVar;
    }

    public Object a(Object obj) throws IOException {
        d dVar = this.a;
        d$a d_a = (d$a) obj;
        Objects.requireNonNull(dVar);
        b.c.a.a0.d.X("CctTransportBackend", "Making request to: %s", d_a.a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) d_a.a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(dVar.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "2.3.2"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", RestAPIBuilder.CONTENT_TYPE_JSON);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = d_a.c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    ((b.i.c.p.h.d) dVar.a).b(d_a.f745b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    b.c.a.a0.d.L0("CctTransportBackend", "Status Code: " + responseCode);
                    b.c.a.a0.d.L0("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    b.c.a.a0.d.L0("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new d$b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new d$b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            d$b d_b = new d$b(responseCode, null, ((h) n.a(new BufferedReader(new InputStreamReader(gZIPInputStream)))).a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return d_b;
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
            b.c.a.a0.d.c0("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new d$b(400, null, 0L);
        } catch (ConnectException e2) {
            e = e2;
            b.c.a.a0.d.c0("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new d$b(500, null, 0L);
        } catch (UnknownHostException e3) {
            e = e3;
            b.c.a.a0.d.c0("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new d$b(500, null, 0L);
        } catch (IOException e4) {
            e = e4;
            b.c.a.a0.d.c0("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new d$b(400, null, 0L);
        }
    }
}
