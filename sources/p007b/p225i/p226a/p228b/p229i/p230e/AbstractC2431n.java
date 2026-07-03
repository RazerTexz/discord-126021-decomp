package p007b.p225i.p226a.p228b.p229i.p230e;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: renamed from: b.i.a.b.i.e.n */
/* JADX INFO: compiled from: LogResponse.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class AbstractC2431n {
    @NonNull
    /* JADX INFO: renamed from: a */
    public static AbstractC2431n m2333a(@NonNull Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    if (jsonReader.peek() == JsonToken.STRING) {
                        C2425h c2425h = new C2425h(Long.parseLong(jsonReader.nextString()));
                        jsonReader.close();
                        return c2425h;
                    }
                    C2425h c2425h2 = new C2425h(jsonReader.nextLong());
                    jsonReader.close();
                    return c2425h2;
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } catch (Throwable th) {
            jsonReader.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract long mo2330b();
}
