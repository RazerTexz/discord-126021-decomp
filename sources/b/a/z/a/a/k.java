package b.a.z.a.a;

import com.discord.models.user.User;
import java.util.Locale;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k implements j0.k.b {
    public final /* synthetic */ String j;

    public /* synthetic */ k(String str) {
        this.j = str;
    }

    @Override // j0.k.b
    public final Object call(Object obj) {
        return Boolean.valueOf(((User) obj).getUsername().toLowerCase(Locale.ROOT).contains(this.j));
    }
}
