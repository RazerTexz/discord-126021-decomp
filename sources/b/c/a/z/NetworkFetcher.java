package b.c.a.z;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.browser.trusted.sharing.ShareTarget;
import b.c.a.LottieComposition;
import b.c.a.LottieCompositionFactory;
import b.c.a.LottieResult;
import b.c.a.b0.Logger2;
import b.d.b.a.outline;
import com.discord.restapi.RestAPIBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* JADX INFO: renamed from: b.c.a.z.c, reason: use source file name */
/* JADX INFO: compiled from: NetworkFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class NetworkFetcher {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f447b;

    @Nullable
    public final NetworkCache c;

    public NetworkFetcher(Context context, String str, @Nullable String str2) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f447b = str;
        if (str2 == null) {
            this.c = null;
        } else {
            this.c = new NetworkCache(applicationContext);
        }
    }

    @WorkerThread
    public final LottieResult<LottieComposition> a() throws IOException {
        StringBuilder sbU = outline.U("Fetching ");
        sbU.append(this.f447b);
        Logger2.a(sbU.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f447b).openConnection();
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                LottieResult<LottieComposition> lottieResultC = c(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(lottieResultC.a != null);
                Logger2.a(sb.toString());
                return lottieResultC;
            }
            return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.f447b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + b(httpURLConnection)));
        } catch (Exception e) {
            return new LottieResult<>((Throwable) e);
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
    public final LottieResult<LottieComposition> c(HttpURLConnection httpURLConnection) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> lottieResultB;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = RestAPIBuilder.CONTENT_TYPE_JSON;
        }
        if (contentType.contains("application/zip")) {
            Logger2.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            NetworkCache networkCache = this.c;
            lottieResultB = networkCache == null ? LottieCompositionFactory.d(new ZipInputStream(httpURLConnection.getInputStream()), null) : LottieCompositionFactory.d(new ZipInputStream(new FileInputStream(networkCache.c(this.f447b, httpURLConnection.getInputStream(), fileExtension))), this.f447b);
        } else {
            Logger2.a("Received json response.");
            fileExtension = FileExtension.JSON;
            NetworkCache networkCache2 = this.c;
            lottieResultB = networkCache2 == null ? LottieCompositionFactory.b(httpURLConnection.getInputStream(), null) : LottieCompositionFactory.b(new FileInputStream(new File(networkCache2.c(this.f447b, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f447b);
        }
        NetworkCache networkCache3 = this.c;
        if (networkCache3 != null && lottieResultB.a != null) {
            File file = new File(networkCache3.b(), NetworkCache.a(this.f447b, fileExtension, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean zRenameTo = file.renameTo(file2);
            Logger2.a("Copying temp file to real file (" + file2 + ")");
            if (!zRenameTo) {
                StringBuilder sbU = outline.U("Unable to rename cache file ");
                sbU.append(file.getAbsolutePath());
                sbU.append(" to ");
                sbU.append(file2.getAbsolutePath());
                sbU.append(".");
                Logger2.b(sbU.toString());
            }
        }
        return lottieResultB;
    }
}
