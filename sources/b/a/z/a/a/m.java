package b.a.z.a.a;

import com.discord.models.user.User;
import java.util.Map;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m implements j0.k.b {
    public final /* synthetic */ Map j;

    public /* synthetic */ m(Map map) {
        this.j = map;
    }

    @Override // j0.k.b
    public final Object call(Object obj) {
        return Boolean.valueOf(b.d.b.a.a.f((User) obj, this.j) != null);
    }
}
