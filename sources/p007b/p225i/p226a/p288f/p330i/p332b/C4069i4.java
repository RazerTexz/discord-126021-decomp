package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.i4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4069i4 {

    /* JADX INFO: renamed from: a */
    public final String f10805a;

    /* JADX INFO: renamed from: b */
    public final Bundle f10806b;

    /* JADX INFO: renamed from: c */
    public boolean f10807c;

    /* JADX INFO: renamed from: d */
    public Bundle f10808d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C4009d4 f10809e;

    public C4069i4(C4009d4 c4009d4, String str) {
        this.f10809e = c4009d4;
        C1460d.m583w(str);
        this.f10805a = str;
        this.f10806b = new Bundle();
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final Bundle m5681a() {
        if (!this.f10807c) {
            this.f10807c = true;
            String string = this.f10809e.m5579w().getString(this.f10805a, null);
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
                                this.f10809e.mo5726g().f11141f.m5861b("Unrecognized persisted bundle type. Type", string3);
                            } else {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.f10809e.mo5726g().f11141f.m5860a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.f10808d = bundle;
                } catch (JSONException unused2) {
                    this.f10809e.mo5726g().f11141f.m5860a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.f10808d == null) {
                this.f10808d = this.f10806b;
            }
        }
        return this.f10808d;
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public final void m5682b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor editorEdit = this.f10809e.m5579w().edit();
        if (bundle.size() == 0) {
            editorEdit.remove(this.f10805a);
        } else {
            String str = this.f10805a;
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
                            this.f10809e.mo5726g().f11141f.m5861b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        this.f10809e.mo5726g().f11141f.m5861b("Cannot serialize bundle value to SharedPreferences", e);
                    }
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.f10808d = bundle;
    }
}
