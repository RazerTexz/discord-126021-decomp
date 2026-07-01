package b.a.y;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.i.OauthTokenPermissionListItemBinding;
import com.discord.R;
import com.discord.views.OAuthPermissionViews;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: b.a.y.h, reason: use source file name */
/* JADX INFO: compiled from: OAuthPermissionViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OAuthPermissionViews2 extends Lambda implements Function2<LayoutInflater, ViewGroup, OAuthPermissionViews.a> {
    public static final OAuthPermissionViews2 j = new OAuthPermissionViews2();

    public OAuthPermissionViews2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public OAuthPermissionViews.a invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        Intrinsics3.checkNotNullParameter(layoutInflater2, "inflater");
        Intrinsics3.checkNotNullParameter(viewGroup2, "parent");
        View viewInflate = layoutInflater2.inflate(R.layout.oauth_token_permission_list_item, viewGroup2, false);
        Objects.requireNonNull(viewInflate, "rootView");
        OauthTokenPermissionListItemBinding oauthTokenPermissionListItemBinding = new OauthTokenPermissionListItemBinding((TextView) viewInflate);
        Intrinsics3.checkNotNullExpressionValue(oauthTokenPermissionListItemBinding, "OauthTokenPermissionList…(inflater, parent, false)");
        return new OAuthPermissionViews.a(oauthTokenPermissionListItemBinding);
    }
}
