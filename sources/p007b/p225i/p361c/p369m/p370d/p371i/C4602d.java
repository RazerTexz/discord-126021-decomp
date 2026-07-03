package p007b.p225i.p361c.p369m.p370d.p371i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p372j.InterfaceC4605a;
import p007b.p225i.p361c.p369m.p370d.p373k.C4632i0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4638k0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p373k.CallableC4643n;

/* JADX INFO: renamed from: b.i.c.m.d.i.d */
/* JADX INFO: compiled from: BreadcrumbAnalyticsEventReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4602d implements InterfaceC4600b, InterfaceC4605a {

    /* JADX INFO: renamed from: a */
    @Nullable
    public C4632i0 f12250a;

    @NonNull
    /* JADX INFO: renamed from: c */
    public static String m6388c(@NonNull String str, @NonNull Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put(ModelAuditLogEntry.CHANGE_KEY_NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p372j.InterfaceC4605a
    /* JADX INFO: renamed from: a */
    public void mo6389a(@Nullable C4632i0 c4632i0) {
        this.f12250a = c4632i0;
        C4592b.f12227a.m6371b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p371i.InterfaceC4600b
    /* JADX INFO: renamed from: b */
    public void mo6387b(@NonNull String str, @NonNull Bundle bundle) {
        C4632i0 c4632i0 = this.f12250a;
        if (c4632i0 != null) {
            try {
                String str2 = "$A$:" + m6388c(str, bundle);
                C4638k0 c4638k0 = c4632i0.f12320a;
                Objects.requireNonNull(c4638k0);
                long jCurrentTimeMillis = System.currentTimeMillis() - c4638k0.f12332d;
                C4663x c4663x = c4638k0.f12336h;
                c4663x.f12433m.m6437b(new CallableC4643n(c4663x, jCurrentTimeMillis, str2));
            } catch (JSONException unused) {
                C4592b.f12227a.m6376g("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
