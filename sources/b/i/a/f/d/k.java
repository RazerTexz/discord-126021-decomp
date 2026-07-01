package b.i.a.f.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zza;
import com.google.android.gms.cloudmessaging.zzp;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {
    public final g j;

    public k(g gVar) {
        this.j = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final g gVar = this.j;
        while (true) {
            synchronized (gVar) {
                if (gVar.j != 2) {
                    return;
                }
                if (gVar.m.isEmpty()) {
                    gVar.c();
                    return;
                }
                final q<?> qVarPoll = gVar.m.poll();
                gVar.n.put(qVarPoll.a, qVarPoll);
                gVar.o.c.schedule(new Runnable(gVar, qVarPoll) { // from class: b.i.a.f.d.m
                    public final g j;
                    public final q k;

                    {
                        this.j = gVar;
                        this.k = qVarPoll;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        g gVar2 = this.j;
                        int i = this.k.a;
                        synchronized (gVar2) {
                            q<?> qVar = gVar2.n.get(i);
                            if (qVar != null) {
                                StringBuilder sb = new StringBuilder(31);
                                sb.append("Timing out request: ");
                                sb.append(i);
                                Log.w("MessengerIpcClient", sb.toString());
                                gVar2.n.remove(i);
                                qVar.b(new zzp(3, "Timed out waiting for response"));
                                gVar2.c();
                            }
                        }
                    }
                }, 30L, TimeUnit.SECONDS);
                if (Log.isLoggable("MessengerIpcClient", 3)) {
                    String strValueOf = String.valueOf(qVarPoll);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
                    sb.append("Sending ");
                    sb.append(strValueOf);
                    Log.d("MessengerIpcClient", sb.toString());
                }
                Context context = gVar.o.f1339b;
                Messenger messenger = gVar.k;
                Message messageObtain = Message.obtain();
                messageObtain.what = qVarPoll.c;
                messageObtain.arg1 = qVarPoll.a;
                messageObtain.replyTo = messenger;
                Bundle bundle = new Bundle();
                bundle.putBoolean("oneWay", qVarPoll.d());
                bundle.putString("pkg", context.getPackageName());
                bundle.putBundle("data", qVarPoll.d);
                messageObtain.setData(bundle);
                try {
                    p pVar = gVar.l;
                    Messenger messenger2 = pVar.a;
                    if (messenger2 != null) {
                        messenger2.send(messageObtain);
                    } else {
                        zza zzaVar = pVar.f1340b;
                        if (zzaVar == null) {
                            throw new IllegalStateException("Both messengers are null");
                        }
                        Messenger messenger3 = zzaVar.j;
                        Objects.requireNonNull(messenger3);
                        messenger3.send(messageObtain);
                    }
                } catch (RemoteException e) {
                    gVar.a(2, e.getMessage());
                }
            }
        }
    }
}
