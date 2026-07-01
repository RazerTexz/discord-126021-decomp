package b.i.c.u.o;

import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PersistedInstallation.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final b.i.c.c f1787b;

    public c(@NonNull b.i.c.c cVar) {
        cVar.a();
        File filesDir = cVar.d.getFilesDir();
        StringBuilder sbU = b.d.b.a.a.U("PersistedInstallation.");
        sbU.append(cVar.c());
        sbU.append(".json");
        this.a = new File(filesDir, sbU.toString());
        this.f1787b = cVar;
    }

    @NonNull
    public d a(@NonNull d dVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", dVar.c());
            jSONObject.put("Status", dVar.f().ordinal());
            jSONObject.put("AuthToken", dVar.a());
            jSONObject.put("RefreshToken", dVar.e());
            jSONObject.put("TokenCreationEpochInSecs", dVar.g());
            jSONObject.put("ExpiresInSecs", dVar.b());
            jSONObject.put("FisError", dVar.d());
            b.i.c.c cVar = this.f1787b;
            cVar.a();
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", cVar.d.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(Constants.ENCODING));
            fileOutputStream.close();
            if (!fileCreateTempFile.renameTo(this.a)) {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
        return dVar;
    }

    @NonNull
    public d b() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(this.a);
            while (true) {
                try {
                    int i = fileInputStream.read(bArr, 0, 16384);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused2) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        c$a c_a = c$a.ATTEMPT_MIGRATION;
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int i2 = d.a;
        a$b a_b = new a$b();
        a_b.d(0L);
        a_b.b(c_a);
        a_b.c(0L);
        a_b.a = strOptString;
        a_b.b(c$a.values()[iOptInt]);
        a_b.c = strOptString2;
        a_b.d = strOptString3;
        a_b.d(jOptLong);
        a_b.c(jOptLong2);
        a_b.g = strOptString4;
        return a_b.a();
    }
}
