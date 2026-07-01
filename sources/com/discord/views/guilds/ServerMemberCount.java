package com.discord.views.guilds;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.i3;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.utilities.resources.StringResourceUtilsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerMemberCount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerMemberCount extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final i3 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerMemberCount(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_server_member_count, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.item_invite_online_dot;
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.item_invite_online_dot);
        if (imageView != null) {
            i = R$id.item_invite_online_text;
            TextView textView = (TextView) viewInflate.findViewById(R$id.item_invite_online_text);
            if (textView != null) {
                i = R$id.item_invite_total_member_dot;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R$id.item_invite_total_member_dot);
                if (imageView2 != null) {
                    i = R$id.item_invite_total_member_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(R$id.item_invite_total_member_text);
                    if (textView2 != null) {
                        i3 i3Var = new i3((LinearLayout) viewInflate, imageView, textView, imageView2, textView2);
                        m.checkNotNullExpressionValue(i3Var, "ViewServerMemberCountBin…rom(context), this, true)");
                        this.binding = i3Var;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setInvalidText(CharSequence charSequence) {
        ImageView imageView = this.binding.f134b;
        m.checkNotNullExpressionValue(imageView, "binding.itemInviteOnlineDot");
        imageView.setVisibility(8);
        ImageView imageView2 = this.binding.d;
        m.checkNotNullExpressionValue(imageView2, "binding.itemInviteTotalMemberDot");
        imageView2.setVisibility(8);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.itemInviteOnlineText");
        b.a(textView, charSequence);
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.itemInviteTotalMemberText");
        b.a(textView2, null);
    }

    public final void setMembers(Integer members) {
        CharSequence i18nPluralString;
        ImageView imageView = this.binding.d;
        m.checkNotNullExpressionValue(imageView, "binding.itemInviteTotalMemberDot");
        imageView.setVisibility(members != null ? 0 : 8);
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.itemInviteTotalMemberText");
        if (members != null) {
            members.intValue();
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            i18nPluralString = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.members_header_members, members.intValue(), members);
        } else {
            i18nPluralString = null;
        }
        b.a(textView, i18nPluralString);
    }

    public final void setOnline(Integer active) {
        ImageView imageView = this.binding.f134b;
        m.checkNotNullExpressionValue(imageView, "binding.itemInviteOnlineDot");
        imageView.setVisibility(active != null ? 0 : 8);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.itemInviteOnlineText");
        CharSequence charSequenceJ = null;
        if (active != null) {
            active.intValue();
            charSequenceJ = b.j(this, 2131892068, new Object[]{active}, null, 4);
        }
        b.a(textView, charSequenceJ);
    }
}
