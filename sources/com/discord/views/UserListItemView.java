package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.C0940d4;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserListItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserListItemView extends RelativeLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19171j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C0940d4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_user_list_item, this);
        int i = C5419R.id.user_list_item_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.user_list_item_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.user_list_item_name;
            TextView textView = (TextView) findViewById(C5419R.id.user_list_item_name);
            if (textView != null) {
                i = C5419R.id.user_list_item_name_secondary;
                TextView textView2 = (TextView) findViewById(C5419R.id.user_list_item_name_secondary);
                if (textView2 != null) {
                    i = C5419R.id.user_list_item_status;
                    StatusView statusView = (StatusView) findViewById(C5419R.id.user_list_item_status);
                    if (statusView != null) {
                        C0940d4 c0940d4 = new C0940d4(this, simpleDraweeView, textView, textView2, statusView);
                        C12238m.checkNotNullExpressionValue(c0940d4, "ViewUserListItemBinding.…ater.from(context), this)");
                        this.binding = c0940d4;
                        setClickable(true);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
