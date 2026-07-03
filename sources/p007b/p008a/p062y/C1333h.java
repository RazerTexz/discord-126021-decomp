package p007b.p008a.p062y;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.views.OAuthPermissionViews;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.C1080x0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.h */
/* JADX INFO: compiled from: OAuthPermissionViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1333h extends AbstractC12240o implements Function2<LayoutInflater, ViewGroup, OAuthPermissionViews.C7080a> {

    /* JADX INFO: renamed from: j */
    public static final C1333h f2026j = new C1333h();

    public C1333h() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public OAuthPermissionViews.C7080a invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        C12238m.checkNotNullParameter(layoutInflater2, "inflater");
        C12238m.checkNotNullParameter(viewGroup2, "parent");
        View viewInflate = layoutInflater2.inflate(C5419R.layout.oauth_token_permission_list_item, viewGroup2, false);
        Objects.requireNonNull(viewInflate, "rootView");
        C1080x0 c1080x0 = new C1080x0((TextView) viewInflate);
        C12238m.checkNotNullExpressionValue(c1080x0, "OauthTokenPermissionList…(inflater, parent, false)");
        return new OAuthPermissionViews.C7080a(c1080x0);
    }
}
