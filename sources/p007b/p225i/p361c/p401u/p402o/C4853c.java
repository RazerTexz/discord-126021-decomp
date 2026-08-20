package p007b.p225i.p361c.p401u.p402o;

import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.C4542c;

/* JADX INFO: renamed from: b.i.c.u.o.c */
/* JADX INFO: compiled from: PersistedInstallation.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4853c {

    /* JADX INFO: renamed from: a */
    public final File f12969a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C4542c f12970b;

    /* JADX INFO: renamed from: b.i.c.u.o.c$a */
    /* JADX INFO: compiled from: PersistedInstallation.java */
    public enum a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public C4853c(@NonNull C4542c c4542c) {
        c4542c.m6330a();
        File filesDir = c4542c.f12118d.getFilesDir();
        StringBuilder sbM833U = C1643a.m833U("PersistedInstallation.");
        sbM833U.append(c4542c.m6331c());
        sbM833U.append(".json");
        this.f12969a = new File(filesDir, sbM833U.toString());
        this.f12970b = c4542c;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public AbstractC4854d m6787a(@NonNull AbstractC4854d abstractC4854d) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", abstractC4854d.mo6776c());
            jSONObject.put("Status", abstractC4854d.mo6779f().ordinal());
            jSONObject.put("AuthToken", abstractC4854d.mo6774a());
            jSONObject.put("RefreshToken", abstractC4854d.mo6778e());
            jSONObject.put("TokenCreationEpochInSecs", abstractC4854d.mo6780g());
            jSONObject.put("ExpiresInSecs", abstractC4854d.mo6775b());
            jSONObject.put("FisError", abstractC4854d.mo6777d());
            C4542c c4542c = this.f12970b;
            c4542c.m6330a();
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", c4542c.f12118d.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(Constants.ENCODING));
            fileOutputStream.close();
            if (!fileCreateTempFile.renameTo(this.f12969a)) {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
        return abstractC4854d;
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public AbstractC4854d m6788b() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f12969a);
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
        a aVar = a.ATTEMPT_MIGRATION;
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int i2 = AbstractC4854d.f12977a;
        C4851a.b bVar = new C4851a.b();
        bVar.m6785d(0L);
        bVar.mo6783b(aVar);
        bVar.m6784c(0L);
        bVar.f12959a = strOptString;
        bVar.mo6783b(a.values()[iOptInt]);
        bVar.f12961c = strOptString2;
        bVar.f12962d = strOptString3;
        bVar.m6785d(jOptLong);
        bVar.m6784c(jOptLong2);
        bVar.f12965g = strOptString4;
        return bVar.mo6782a();
    }
}
