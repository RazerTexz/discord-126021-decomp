package p007b.p085c.p086a.p099z;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.browser.trusted.sharing.ShareTarget;
import com.discord.restapi.RestAPIBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.C1506e;
import p007b.p085c.p086a.C1517p;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.z.c */
/* JADX INFO: compiled from: NetworkFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class C1613c {

    /* JADX INFO: renamed from: a */
    public final Context f2928a;

    /* JADX INFO: renamed from: b */
    public final String f2929b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final C1612b f2930c;

    public C1613c(Context context, String str, @Nullable String str2) {
        Context applicationContext = context.getApplicationContext();
        this.f2928a = applicationContext;
        this.f2929b = str;
        if (str2 == null) {
            this.f2930c = null;
        } else {
            this.f2930c = new C1612b(applicationContext);
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final C1517p<C1505d> m796a() throws IOException {
        StringBuilder sbM833U = C1643a.m833U("Fetching ");
        sbM833U.append(this.f2929b);
        C1495c.m639a(sbM833U.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f2929b).openConnection();
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                C1517p<C1505d> c1517pM798c = m798c(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(c1517pM798c.f2449a != null);
                C1495c.m639a(sb.toString());
                return c1517pM798c;
            }
            return new C1517p<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.f2929b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + m797b(httpURLConnection)));
        } catch (Exception e) {
            return new C1517p<>((Throwable) e);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    /* JADX INFO: renamed from: b */
    public final String m797b(HttpURLConnection httpURLConnection) throws IOException {
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
    /* JADX INFO: renamed from: c */
    public final C1517p<C1505d> m798c(HttpURLConnection httpURLConnection) throws IOException {
        EnumC1611a enumC1611a;
        C1517p<C1505d> c1517pM675b;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = RestAPIBuilder.CONTENT_TYPE_JSON;
        }
        if (contentType.contains("application/zip")) {
            C1495c.m639a("Handling zip response.");
            enumC1611a = EnumC1611a.ZIP;
            C1612b c1612b = this.f2930c;
            c1517pM675b = c1612b == null ? C1506e.m677d(new ZipInputStream(httpURLConnection.getInputStream()), null) : C1506e.m677d(new ZipInputStream(new FileInputStream(c1612b.m795c(this.f2929b, httpURLConnection.getInputStream(), enumC1611a))), this.f2929b);
        } else {
            C1495c.m639a("Received json response.");
            enumC1611a = EnumC1611a.JSON;
            C1612b c1612b2 = this.f2930c;
            c1517pM675b = c1612b2 == null ? C1506e.m675b(httpURLConnection.getInputStream(), null) : C1506e.m675b(new FileInputStream(new File(c1612b2.m795c(this.f2929b, httpURLConnection.getInputStream(), enumC1611a).getAbsolutePath())), this.f2929b);
        }
        C1612b c1612b3 = this.f2930c;
        if (c1612b3 != null && c1517pM675b.f2449a != null) {
            File file = new File(c1612b3.m794b(), C1612b.m793a(this.f2929b, enumC1611a, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean zRenameTo = file.renameTo(file2);
            C1495c.m639a("Copying temp file to real file (" + file2 + ")");
            if (!zRenameTo) {
                StringBuilder sbM833U = C1643a.m833U("Unable to rename cache file ");
                sbM833U.append(file.getAbsolutePath());
                sbM833U.append(" to ");
                sbM833U.append(file2.getAbsolutePath());
                sbM833U.append(".");
                C1495c.m640b(sbM833U.toString());
            }
        }
        return c1517pM675b;
    }
}
