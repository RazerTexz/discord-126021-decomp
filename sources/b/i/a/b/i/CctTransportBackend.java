package b.i.a.b.i;

import androidx.browser.trusted.sharing.ShareTarget;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.b.i.CctTransportBackend3;
import b.i.a.b.i.e.AutoValue_LogResponse;
import b.i.a.b.i.e.LogResponse;
import b.i.c.p.h.JsonDataEncoderBuilder4;
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

/* JADX INFO: renamed from: b.i.a.b.i.b, reason: use source file name */
/* JADX INFO: compiled from: CctTransportBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CctTransportBackend {
    public final CctTransportBackend3 a;

    public CctTransportBackend(CctTransportBackend3 cctTransportBackend3) {
        this.a = cctTransportBackend3;
    }

    public Object a(Object obj) throws IOException {
        CctTransportBackend3 cctTransportBackend3 = this.a;
        CctTransportBackend3.a aVar = (CctTransportBackend3.a) obj;
        Objects.requireNonNull(cctTransportBackend3);
        AnimatableValueParser.X("CctTransportBackend", "Making request to: %s", aVar.a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(cctTransportBackend3.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "2.3.2"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", RestAPIBuilder.CONTENT_TYPE_JSON);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    ((JsonDataEncoderBuilder4) cctTransportBackend3.a).b(aVar.f745b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    AnimatableValueParser.L0("CctTransportBackend", "Status Code: " + responseCode);
                    AnimatableValueParser.L0("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    AnimatableValueParser.L0("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new CctTransportBackend3.b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new CctTransportBackend3.b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            CctTransportBackend3.b bVar = new CctTransportBackend3.b(responseCode, null, ((AutoValue_LogResponse) LogResponse.a(new BufferedReader(new InputStreamReader(gZIPInputStream)))).a);
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
            AnimatableValueParser.c0("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new CctTransportBackend3.b(400, null, 0L);
        } catch (ConnectException e2) {
            e = e2;
            AnimatableValueParser.c0("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new CctTransportBackend3.b(500, null, 0L);
        } catch (UnknownHostException e3) {
            e = e3;
            AnimatableValueParser.c0("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new CctTransportBackend3.b(500, null, 0L);
        } catch (IOException e4) {
            e = e4;
            AnimatableValueParser.c0("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new CctTransportBackend3.b(400, null, 0L);
        }
    }
}
