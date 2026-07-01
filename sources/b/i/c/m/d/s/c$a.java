package b.i.c.m.d.s;

import android.content.SharedPreferences$Editor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.o.h;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: SettingsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a implements b.i.a.f.n.f<Void, Void> {
    public final /* synthetic */ c a;

    public c$a(c cVar) {
        this.a = cVar;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<Void> a(@Nullable Void r11) throws Exception {
        JSONObject jSONObjectG;
        FileWriter fileWriter;
        c cVar = this.a;
        b.i.c.m.d.s.i.d dVar = cVar.f;
        b.i.c.m.d.s.h.g gVar = cVar.f1747b;
        b.i.c.m.d.s.i.c cVar2 = (b.i.c.m.d.s.i.c) dVar;
        Objects.requireNonNull(cVar2);
        FileWriter fileWriter2 = null;
        try {
            Map<String, String> mapF = cVar2.f(gVar);
            b.i.c.m.d.n.a aVarC = cVar2.c(mapF);
            cVar2.d(aVarC, gVar);
            cVar2.f.b("Requesting settings from " + cVar2.f1676b);
            cVar2.f.b("Settings query params were: " + mapF);
            b.i.c.m.d.n.c cVarA = aVarC.a();
            cVar2.f.b("Settings request ID: " + cVarA.c.c("X-REQUEST-ID"));
            jSONObjectG = cVar2.g(cVarA);
        } catch (IOException e) {
            if (cVar2.f.a(6)) {
                Log.e("FirebaseCrashlytics", "Settings request failed.", e);
            }
            jSONObjectG = null;
        }
        if (jSONObjectG != null) {
            b.i.c.m.d.s.h.f fVarA = this.a.c.a(jSONObjectG);
            a aVar = this.a.e;
            long j = fVarA.d;
            Objects.requireNonNull(aVar);
            b.i.c.m.d.b.a.b("Writing settings to cache file...");
            try {
                jSONObjectG.put("expires_at", j);
                fileWriter = new FileWriter(new File(new h(aVar.a).a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObjectG.toString());
                    fileWriter.flush();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (b.i.c.m.d.b.a.a(6)) {
                            Log.e("FirebaseCrashlytics", "Failed to cache settings", e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileWriter2 = fileWriter;
                        fileWriter = fileWriter2;
                        b.i.c.m.d.k.h.c(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    b.i.c.m.d.k.h.c(fileWriter, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
            } catch (Throwable th3) {
                th = th3;
                fileWriter = fileWriter2;
                b.i.c.m.d.k.h.c(fileWriter, "Failed to close settings writer.");
                throw th;
            }
            b.i.c.m.d.k.h.c(fileWriter, "Failed to close settings writer.");
            this.a.e(jSONObjectG, "Loaded settings: ");
            c cVar3 = this.a;
            String str = cVar3.f1747b.f;
            SharedPreferences$Editor sharedPreferences$EditorEdit = b.i.c.m.d.k.h.o(cVar3.a).edit();
            sharedPreferences$EditorEdit.putString("existing_instance_identifier", str);
            sharedPreferences$EditorEdit.apply();
            this.a.h.set(fVarA);
            this.a.i.get().b(fVarA.a);
            TaskCompletionSource<b.i.c.m.d.s.h.b> taskCompletionSource = new TaskCompletionSource<>();
            taskCompletionSource.b(fVarA.a);
            this.a.i.set(taskCompletionSource);
        }
        return b.i.a.f.e.o.f.Z(null);
    }
}
