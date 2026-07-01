package b.a.z.a.a;

import com.discord.api.permission.PermissionOverwrite;
import com.discord.models.user.User;
import java.util.List;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements j0.k.b {
    public final /* synthetic */ List j;

    public /* synthetic */ l(List list) {
        this.j = list;
    }

    @Override // j0.k.b
    public final Object call(Object obj) {
        List list = this.j;
        User user = (User) obj;
        if (list == null) {
            return Boolean.TRUE;
        }
        for (int i = 0; i < list.size(); i++) {
            if (((PermissionOverwrite) list.get(i)).e() == user.getId()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
