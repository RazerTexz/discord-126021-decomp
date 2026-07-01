package b.i.c.w;

import android.content.Intent;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class m$a implements b.i.c.p.c<m> {
    /* JADX WARN: Code duplicated, block: B:30:0x009e  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:68:0x0163  */
    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        int iIntValue;
        m mVar = (m) obj;
        b.i.c.p.d dVar2 = dVar;
        Intent intent = mVar.f1796b;
        Object obj2 = intent.getExtras().get("google.ttl");
        int i = 0;
        if (obj2 instanceof Integer) {
            iIntValue = ((Integer) obj2).intValue();
        } else if (obj2 instanceof String) {
            try {
                iIntValue = Integer.parseInt((String) obj2);
            } catch (NumberFormatException unused) {
                String strValueOf = String.valueOf(obj2);
                b.d.b.a.a.h0(strValueOf.length() + 13, "Invalid TTL: ", strValueOf, "FirebaseMessaging");
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        dVar2.c("ttl", iIntValue);
        dVar2.f("event", mVar.a);
        FirebaseInstanceId firebaseInstanceId = FirebaseInstanceId.getInstance(b.i.c.c.b());
        FirebaseInstanceId.c(firebaseInstanceId.f);
        if (firebaseInstanceId.p(firebaseInstanceId.j())) {
            synchronized (firebaseInstanceId) {
                if (!firebaseInstanceId.k) {
                    firebaseInstanceId.o(0L);
                }
            }
        }
        dVar2.f("instanceId", firebaseInstanceId.e());
        String stringExtra = intent.getStringExtra("google.delivered_priority");
        if (stringExtra != null) {
            if (Constants.HIGH.equals(stringExtra)) {
                i = 1;
            } else if (Constants.NORMAL.equals(stringExtra)) {
                i = 2;
            }
        } else if ("1".equals(intent.getStringExtra("google.priority_reduced"))) {
            i = 2;
        } else {
            stringExtra = intent.getStringExtra("google.priority");
            if (Constants.HIGH.equals(stringExtra)) {
                i = 1;
            } else if (Constants.NORMAL.equals(stringExtra)) {
                i = 2;
            }
        }
        dVar2.c("priority", i);
        b.i.c.c cVarB = b.i.c.c.b();
        cVarB.a();
        dVar2.f("packageName", cVarB.d.getPackageName());
        dVar2.f("sdkPlatform", "ANDROID");
        dVar2.f("messageType", (intent.getExtras() == null || !r.f(intent.getExtras())) ? "DATA_MESSAGE" : "DISPLAY_NOTIFICATION");
        String stringExtra2 = intent.getStringExtra("google.message_id");
        if (stringExtra2 == null) {
            stringExtra2 = intent.getStringExtra("message_id");
        }
        if (stringExtra2 != null) {
            dVar2.f("messageId", stringExtra2);
        }
        String strA = q.a(intent);
        if (strA != null) {
            dVar2.f(ModelAuditLogEntry.CHANGE_KEY_TOPIC, strA);
        }
        String stringExtra3 = intent.getStringExtra("collapse_key");
        if (stringExtra3 != null) {
            dVar2.f("collapseKey", stringExtra3);
        }
        if (intent.getStringExtra("google.c.a.m_l") != null) {
            dVar2.f("analyticsLabel", intent.getStringExtra("google.c.a.m_l"));
        }
        if (intent.getStringExtra("google.c.a.c_l") != null) {
            dVar2.f("composerLabel", intent.getStringExtra("google.c.a.c_l"));
        }
        b.i.c.c cVarB2 = b.i.c.c.b();
        cVarB2.a();
        String str = cVarB2.f.e;
        if (str == null) {
            cVarB2.a();
            str = cVarB2.f.f1655b;
            if (str.startsWith("1:")) {
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length < 2) {
                    str = null;
                } else {
                    str = strArrSplit[1];
                    if (str.isEmpty()) {
                        str = null;
                    }
                }
            }
        }
        if (str != null) {
            dVar2.f("projectNumber", str);
        }
    }
}
