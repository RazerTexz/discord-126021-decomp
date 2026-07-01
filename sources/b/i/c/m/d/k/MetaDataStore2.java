package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import java.io.File;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: b.i.c.m.d.k.z0, reason: use source file name */
/* JADX INFO: compiled from: MetaDataStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class MetaDataStore2 {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f1706b;

    public MetaDataStore2(File file) {
        this.f1706b = file;
    }

    public static UserMetadata c(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        UserMetadata userMetadata = new UserMetadata();
        userMetadata.a = UserMetadata.b(jSONObject.isNull("userId") ? null : jSONObject.optString("userId", null));
        return userMetadata;
    }

    @NonNull
    public File a(String str) {
        return new File(this.f1706b, outline.y(str, "keys", ".meta"));
    }

    @NonNull
    public File b(String str) {
        return new File(this.f1706b, outline.y(str, "user", ".meta"));
    }
}
