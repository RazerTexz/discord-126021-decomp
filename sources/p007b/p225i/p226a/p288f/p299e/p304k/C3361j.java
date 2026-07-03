package p007b.p225i.p226a.p288f.p299e.p304k;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.e.k.j */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3361j {

    /* JADX INFO: renamed from: a */
    public final List<String> f9527a;

    /* JADX INFO: renamed from: b */
    public final Object f9528b;

    public C3361j(Object obj) {
        Objects.requireNonNull(obj, "null reference");
        this.f9528b = obj;
        this.f9527a = new ArrayList();
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: a */
    public C3361j m4162a(@RecentlyNonNull String str, @Nullable Object obj) {
        List<String> list = this.f9527a;
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(str.length() + 1 + strValueOf.length());
        sb.append(str);
        sb.append("=");
        sb.append(strValueOf);
        list.add(sb.toString());
        return this;
    }

    @RecentlyNonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.f9528b.getClass().getSimpleName());
        sb.append('{');
        int size = this.f9527a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.f9527a.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
