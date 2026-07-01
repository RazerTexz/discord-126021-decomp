package b.i.a.b.i.e;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: compiled from: LogResponse.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class n {
    @NonNull
    public static n a(@NonNull Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    if (jsonReader.peek() == JsonToken.STRING) {
                        h hVar = new h(Long.parseLong(jsonReader.nextString()));
                        jsonReader.close();
                        return hVar;
                    }
                    h hVar2 = new h(jsonReader.nextLong());
                    jsonReader.close();
                    return hVar2;
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } catch (Throwable th) {
            jsonReader.close();
            throw th;
        }
    }

    public abstract long b();
}
