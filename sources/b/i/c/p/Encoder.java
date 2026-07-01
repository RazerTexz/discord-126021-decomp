package b.i.c.p;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.c.p.b, reason: use source file name */
/* JADX INFO: compiled from: Encoder.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Encoder<TValue, TContext> {
    void a(@NonNull TValue tvalue, @NonNull TContext tcontext) throws IOException;
}
