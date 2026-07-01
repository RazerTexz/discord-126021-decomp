package b.i.c.m.d.k;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: b.i.c.m.d.k.y0, reason: use source file name */
/* JADX INFO: compiled from: MetaDataStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class MetaDataStore extends JSONObject {
    public final /* synthetic */ UserMetadata a;

    public MetaDataStore(UserMetadata userMetadata) throws JSONException {
        this.a = userMetadata;
        put("userId", userMetadata.a);
    }
}
