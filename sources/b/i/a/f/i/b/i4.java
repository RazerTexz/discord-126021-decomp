package b.i.a.f.i.b;

import android.content.SharedPreferences$Editor;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i4 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f1536b;
    public boolean c;
    public Bundle d;
    public final /* synthetic */ d4 e;

    public i4(d4 d4Var, String str) {
        this.e = d4Var;
        b.c.a.a0.d.w(str);
        this.a = str;
        this.f1536b = new Bundle();
    }

    @WorkerThread
    public final Bundle a() {
        if (!this.c) {
            this.c = true;
            String string = this.e.w().getString(this.a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            byte b2 = -1;
                            int iHashCode = string3.hashCode();
                            if (iHashCode != 100) {
                                if (iHashCode != 108) {
                                    if (iHashCode == 115 && string3.equals("s")) {
                                        b2 = 0;
                                    }
                                } else if (string3.equals("l")) {
                                    b2 = 2;
                                }
                            } else if (string3.equals("d")) {
                                b2 = 1;
                            }
                            if (b2 == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (b2 == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (b2 != 2) {
                                this.e.g().f.b("Unrecognized persisted bundle type. Type", string3);
                            } else {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.e.g().f.a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.d = bundle;
                } catch (JSONException unused2) {
                    this.e.g().f.a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.d == null) {
                this.d = this.f1536b;
            }
        }
        return this.d;
    }

    @WorkerThread
    public final void b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.e.w().edit();
        if (bundle.size() == 0) {
            sharedPreferences$EditorEdit.remove(this.a);
        } else {
            String str = this.a;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            this.e.g().f.b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        this.e.g().f.b("Cannot serialize bundle value to SharedPreferences", e);
                    }
                }
            }
            sharedPreferences$EditorEdit.putString(str, jSONArray.toString());
        }
        sharedPreferences$EditorEdit.apply();
        this.d = bundle;
    }
}
