package b.a.i;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: compiled from: WidgetUserProfileAdapterItemFriendMutualServerBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class f6 implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f115b;

    @NonNull
    public final TextView c;

    public f6(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.a = relativeLayout;
        this.f115b = simpleDraweeView;
        this.c = textView;
    }

    @NonNull
    public static f6 a(@NonNull View view) {
        int i = R$id.user_profile_adapter_item_friend_mutual_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.user_profile_adapter_item_friend_mutual_image);
        if (simpleDraweeView != null) {
            i = R$id.user_profile_adapter_item_friend_mutual_text;
            TextView textView = (TextView) view.findViewById(R$id.user_profile_adapter_item_friend_mutual_text);
            if (textView != null) {
                return new f6((RelativeLayout) view, simpleDraweeView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
