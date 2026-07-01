package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.i.d4;
import com.discord.R$id;
import com.discord.R$layout;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: UserListItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserListItemView extends RelativeLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final d4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_user_list_item, this);
        int i = R$id.user_list_item_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R$id.user_list_item_avatar);
        if (simpleDraweeView != null) {
            i = R$id.user_list_item_name;
            TextView textView = (TextView) findViewById(R$id.user_list_item_name);
            if (textView != null) {
                i = R$id.user_list_item_name_secondary;
                TextView textView2 = (TextView) findViewById(R$id.user_list_item_name_secondary);
                if (textView2 != null) {
                    i = R$id.user_list_item_status;
                    StatusView statusView = (StatusView) findViewById(R$id.user_list_item_status);
                    if (statusView != null) {
                        d4 d4Var = new d4(this, simpleDraweeView, textView, textView2, statusView);
                        m.checkNotNullExpressionValue(d4Var, "ViewUserListItemBinding.…ater.from(context), this)");
                        this.binding = d4Var;
                        setClickable(true);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
