package b.i.c.w;

import android.content.Intent;
import androidx.annotation.NonNull;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.c.FirebaseApp2;
import b.i.c.p.ObjectEncoder;
import b.i.c.p.ObjectEncoderContext;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f1796b;

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static class a implements ObjectEncoder<m> {
        /* JADX WARN: Code duplicated, block: B:30:0x009e  */
        /* JADX WARN: Code duplicated, block: B:31:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:68:0x0163  */
        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            int iIntValue;
            m mVar = (m) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
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
                    outline.h0(strValueOf.length() + 13, "Invalid TTL: ", strValueOf, "FirebaseMessaging");
                    iIntValue = 0;
                }
            } else {
                iIntValue = 0;
            }
            objectEncoderContext2.c("ttl", iIntValue);
            objectEncoderContext2.f("event", mVar.a);
            FirebaseInstanceId firebaseInstanceId = FirebaseInstanceId.getInstance(FirebaseApp2.b());
            FirebaseInstanceId.c(firebaseInstanceId.f);
            if (firebaseInstanceId.p(firebaseInstanceId.j())) {
                synchronized (firebaseInstanceId) {
                    if (!firebaseInstanceId.k) {
                        firebaseInstanceId.o(0L);
                    }
                }
            }
            objectEncoderContext2.f("instanceId", firebaseInstanceId.e());
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
            objectEncoderContext2.c("priority", i);
            FirebaseApp2 firebaseApp2B = FirebaseApp2.b();
            firebaseApp2B.a();
            objectEncoderContext2.f("packageName", firebaseApp2B.d.getPackageName());
            objectEncoderContext2.f("sdkPlatform", "ANDROID");
            objectEncoderContext2.f("messageType", (intent.getExtras() == null || !r.f(intent.getExtras())) ? "DATA_MESSAGE" : "DISPLAY_NOTIFICATION");
            String stringExtra2 = intent.getStringExtra("google.message_id");
            if (stringExtra2 == null) {
                stringExtra2 = intent.getStringExtra("message_id");
            }
            if (stringExtra2 != null) {
                objectEncoderContext2.f("messageId", stringExtra2);
            }
            String strA = q.a(intent);
            if (strA != null) {
                objectEncoderContext2.f(ModelAuditLogEntry.CHANGE_KEY_TOPIC, strA);
            }
            String stringExtra3 = intent.getStringExtra("collapse_key");
            if (stringExtra3 != null) {
                objectEncoderContext2.f("collapseKey", stringExtra3);
            }
            if (intent.getStringExtra("google.c.a.m_l") != null) {
                objectEncoderContext2.f("analyticsLabel", intent.getStringExtra("google.c.a.m_l"));
            }
            if (intent.getStringExtra("google.c.a.c_l") != null) {
                objectEncoderContext2.f("composerLabel", intent.getStringExtra("google.c.a.c_l"));
            }
            FirebaseApp2 firebaseApp2B2 = FirebaseApp2.b();
            firebaseApp2B2.a();
            String str = firebaseApp2B2.f.e;
            if (str == null) {
                firebaseApp2B2.a();
                str = firebaseApp2B2.f.f1655b;
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
                objectEncoderContext2.f("projectNumber", str);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class b {
        public final m a;

        public b(@NonNull m mVar) {
            this.a = mVar;
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class c implements ObjectEncoder<b> {
        @Override // b.i.c.p.Encoder
        public final void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f("messaging_client_event", ((b) obj).a);
        }
    }

    public m(@NonNull String str, @NonNull Intent intent) {
        AnimatableValueParser.v(str, "evenType must be non-null");
        this.a = str;
        AnimatableValueParser.z(intent, "intent must be non-null");
        this.f1796b = intent;
    }
}
