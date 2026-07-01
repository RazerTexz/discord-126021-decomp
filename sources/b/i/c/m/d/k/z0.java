package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import java.io.File;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MetaDataStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class z0 {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f1706b;

    public z0(File file) {
        this.f1706b = file;
    }

    public static f1 c(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        f1 f1Var = new f1();
        f1Var.a = f1.b(jSONObject.isNull("userId") ? null : jSONObject.optString("userId", null));
        return f1Var;
    }

    @NonNull
    public File a(String str) {
        return new File(this.f1706b, b.d.b.a.a.y(str, "keys", ".meta"));
    }

    @NonNull
    public File b(String str) {
        return new File(this.f1706b, b.d.b.a.a.y(str, "user", ".meta"));
    }
}
