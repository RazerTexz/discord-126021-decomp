package b.i.a.f.e.k;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public final List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1388b;

    public j(Object obj) {
        Objects.requireNonNull(obj, "null reference");
        this.f1388b = obj;
        this.a = new ArrayList();
    }

    @RecentlyNonNull
    public j a(@RecentlyNonNull String str, @Nullable Object obj) {
        List<String> list = this.a;
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
        sb.append(this.f1388b.getClass().getSimpleName());
        sb.append('{');
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.a.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
