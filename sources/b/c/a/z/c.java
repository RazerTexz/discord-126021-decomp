package b.c.a.z;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.browser.trusted.sharing.ShareTarget;
import b.c.a.d;
import b.c.a.e;
import b.c.a.p;
import com.discord.restapi.RestAPIBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: NetworkFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f447b;

    @Nullable
    public final b c;

    public c(Context context, String str, @Nullable String str2) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f447b = str;
        if (str2 == null) {
            this.c = null;
        } else {
            this.c = new b(applicationContext);
        }
    }

    @WorkerThread
    public final p<d> a() throws IOException {
        StringBuilder sbU = b.d.b.a.a.U("Fetching ");
        sbU.append(this.f447b);
        b.c.a.b0.c.a(sbU.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f447b).openConnection();
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                p<d> pVarC = c(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(pVarC.a != null);
                b.c.a.b0.c.a(sb.toString());
                return pVarC;
            }
            return new p<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.f447b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + b(httpURLConnection)));
        } catch (Exception e) {
            return new p<>((Throwable) e);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public final String b(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                            sb.append('\n');
                        } else {
                            try {
                                break;
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    throw th;
                }
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Nullable
    public final p<d> c(HttpURLConnection httpURLConnection) throws IOException {
        a aVar;
        p<d> pVarB;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = RestAPIBuilder.CONTENT_TYPE_JSON;
        }
        if (contentType.contains("application/zip")) {
            b.c.a.b0.c.a("Handling zip response.");
            aVar = a.ZIP;
            b bVar = this.c;
            pVarB = bVar == null ? e.d(new ZipInputStream(httpURLConnection.getInputStream()), null) : e.d(new ZipInputStream(new FileInputStream(bVar.c(this.f447b, httpURLConnection.getInputStream(), aVar))), this.f447b);
        } else {
            b.c.a.b0.c.a("Received json response.");
            aVar = a.JSON;
            b bVar2 = this.c;
            pVarB = bVar2 == null ? e.b(httpURLConnection.getInputStream(), null) : e.b(new FileInputStream(new File(bVar2.c(this.f447b, httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f447b);
        }
        b bVar3 = this.c;
        if (bVar3 != null && pVarB.a != null) {
            File file = new File(bVar3.b(), b.a(this.f447b, aVar, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean zRenameTo = file.renameTo(file2);
            b.c.a.b0.c.a("Copying temp file to real file (" + file2 + ")");
            if (!zRenameTo) {
                StringBuilder sbU = b.d.b.a.a.U("Unable to rename cache file ");
                sbU.append(file.getAbsolutePath());
                sbU.append(" to ");
                sbU.append(file2.getAbsolutePath());
                sbU.append(".");
                b.c.a.b0.c.b(sbU.toString());
            }
        }
        return pVarB;
    }
}
