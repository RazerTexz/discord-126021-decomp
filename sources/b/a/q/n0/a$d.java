package b.a.q.n0;

import com.discord.rtcconnection.socket.io.Payloads$Stream;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public interface a$d {
    void a(String str, String str2);

    void b(boolean z2, Integer num, String str);

    void c(String str, List<Integer> list);

    void d(String str);

    void e(long j, int i, int i2, List<Payloads$Stream> list);

    void f(Map<String, Integer> map);

    void g(long j);

    void h();

    void i();

    void j(long j);

    void k(int i, int i2, String str, List<Payloads$Stream> list);

    void onConnecting();

    void onSpeaking(long j, int i, boolean z2);
}
