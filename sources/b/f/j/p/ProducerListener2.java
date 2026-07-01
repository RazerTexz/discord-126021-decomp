package b.f.j.p;

import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: renamed from: b.f.j.p.z0, reason: use source file name */
/* JADX INFO: compiled from: ProducerListener2.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ProducerListener2 {
    void a(@NonNull ProducerContext producerContext, @NonNull String str, @NonNull String str2);

    void c(@NonNull ProducerContext producerContext, @NonNull String str, boolean z2);

    void d(@NonNull ProducerContext producerContext, @NonNull String str, Map<String, String> map);

    void e(@NonNull ProducerContext producerContext, @NonNull String str);

    boolean g(@NonNull ProducerContext producerContext, @NonNull String str);

    void j(@NonNull ProducerContext producerContext, @NonNull String str, Map<String, String> map);

    void k(@NonNull ProducerContext producerContext, String str, Throwable th, Map<String, String> map);
}
