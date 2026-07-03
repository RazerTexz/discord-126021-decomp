package p007b.p225i.p226a.p288f.p298d;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zza;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p313h.p319f.HandlerC3480a;

/* JADX INFO: renamed from: b.i.a.f.d.y */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class HandlerC3250y extends HandlerC3480a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C3227b f9294a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3250y(C3227b c3227b, Looper looper) {
        super(looper);
        this.f9294a = c3227b;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        C3227b c3227b = this.f9294a;
        Objects.requireNonNull(c3227b);
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zza.C10798a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zza) {
                        c3227b.f9252j = (zza) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        c3227b.f9251i = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("Rpc", 3)) {
                        String strValueOf = String.valueOf(action);
                        Log.d("Rpc", strValueOf.length() != 0 ? "Unexpected response action: ".concat(strValueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", stringExtra.length() != 0 ? "Unexpected response string: ".concat(stringExtra) : new String("Unexpected response string: "));
                            return;
                        }
                        return;
                    }
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    if (strGroup != null) {
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", strGroup2);
                        c3227b.m3999a(strGroup, extras);
                        return;
                    }
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String strValueOf2 = String.valueOf(intent2.getExtras());
                    C1643a.m854h0(strValueOf2.length() + 49, "Unexpected response, no error or registration id ", strValueOf2, "Rpc");
                    return;
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", stringExtra2.length() != 0 ? "Received InstanceID error ".concat(stringExtra2) : new String("Received InstanceID error "));
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (c3227b.f9246d) {
                        for (int i = 0; i < c3227b.f9246d.size(); i++) {
                            c3227b.m3999a(c3227b.f9246d.keyAt(i), intent2.getExtras());
                        }
                    }
                    return;
                }
                String[] strArrSplit = stringExtra2.split("\\|");
                if (strArrSplit.length <= 2 || !"ID".equals(strArrSplit[1])) {
                    Log.w("Rpc", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                    return;
                }
                String str = strArrSplit[2];
                String strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(":")) {
                    strSubstring = strSubstring.substring(1);
                }
                c3227b.m3999a(str, intent2.putExtra("error", strSubstring).getExtras());
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }
}
