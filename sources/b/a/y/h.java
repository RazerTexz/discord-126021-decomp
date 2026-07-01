package b.a.y;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.i.x0;
import com.discord.R$layout;
import com.discord.views.OAuthPermissionViews$a;
import java.util.Objects;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: OAuthPermissionViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends d0.z.d.o implements Function2<LayoutInflater, ViewGroup, OAuthPermissionViews$a> {
    public static final h j = new h();

    public h() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public OAuthPermissionViews$a invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        d0.z.d.m.checkNotNullParameter(layoutInflater2, "inflater");
        d0.z.d.m.checkNotNullParameter(viewGroup2, "parent");
        View viewInflate = layoutInflater2.inflate(R$layout.oauth_token_permission_list_item, viewGroup2, false);
        Objects.requireNonNull(viewInflate, "rootView");
        x0 x0Var = new x0((TextView) viewInflate);
        d0.z.d.m.checkNotNullExpressionValue(x0Var, "OauthTokenPermissionList…(inflater, parent, false)");
        return new OAuthPermissionViews$a(x0Var);
    }
}
