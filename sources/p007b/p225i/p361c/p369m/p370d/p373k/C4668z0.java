package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import java.io.File;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.m.d.k.z0 */
/* JADX INFO: compiled from: MetaDataStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4668z0 {

    /* JADX INFO: renamed from: a */
    public static final Charset f12468a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b */
    public final File f12469b;

    public C4668z0(File file) {
        this.f12469b = file;
    }

    /* JADX INFO: renamed from: c */
    public static C4624f1 m6488c(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        C4624f1 c4624f1 = new C4624f1();
        c4624f1.f12290a = C4624f1.m6403b(jSONObject.isNull("userId") ? null : jSONObject.optString("userId", null));
        return c4624f1;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public File m6489a(String str) {
        return new File(this.f12469b, C1643a.m886y(str, "keys", ".meta"));
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public File m6490b(String str) {
        return new File(this.f12469b, C1643a.m886y(str, "user", ".meta"));
    }
}
