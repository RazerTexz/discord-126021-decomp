package com.discord.views.permissions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import b.a.i.g;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.role.GuildRole;
import com.discord.models.user.User;
import com.discord.utilities.channel.ChannelPermissionUtilsKt;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.permissions.PermissionOwner;
import com.discord.widgets.channels.permissions.PermissionOwner$Member;
import com.discord.widgets.channels.permissions.PermissionOwner$Role;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelPermissionOwnerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPermissionOwnerView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final g binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelPermissionOwnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        LayoutInflater.from(context).inflate(R$layout.channel_permission_owner_view, this);
        int i = R$id.crown;
        ImageView imageView = (ImageView) findViewById(R$id.crown);
        if (imageView != null) {
            i = R$id.description;
            TextView textView = (TextView) findViewById(R$id.description);
            if (textView != null) {
                i = 2131364034;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(2131364034);
                if (simpleDraweeView != null) {
                    i = R$id.name;
                    TextView textView2 = (TextView) findViewById(R$id.name);
                    if (textView2 != null) {
                        g gVar = new g(this, imageView, textView, simpleDraweeView, textView2);
                        m.checkNotNullExpressionValue(gVar, "ChannelPermissionOwnerVi…ater.from(context), this)");
                        this.binding = gVar;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(PermissionOwner permissionOwner) {
        m.checkNotNullParameter(permissionOwner, "permissionOwner");
        if (!(permissionOwner instanceof PermissionOwner$Role)) {
            if (permissionOwner instanceof PermissionOwner$Member) {
                PermissionOwner$Member permissionOwner$Member = (PermissionOwner$Member) permissionOwner;
                User user = permissionOwner$Member.getUser();
                SimpleDraweeView simpleDraweeView = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.image");
                IconUtils.setIcon$default(simpleDraweeView, permissionOwner$Member.getUser(), 2131165293, null, null, null, 56, null);
                TextView textView = this.binding.e;
                m.checkNotNullExpressionValue(textView, "binding.name");
                String nickname = permissionOwner$Member.getNickname();
                if (nickname == null) {
                    nickname = user.getUsername();
                }
                textView.setText(nickname);
                TextView textView2 = this.binding.c;
                m.checkNotNullExpressionValue(textView2, "binding.description");
                textView2.setText(UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null));
                ImageView imageView = this.binding.f116b;
                m.checkNotNullExpressionValue(imageView, "binding.crown");
                imageView.setVisibility(permissionOwner$Member.isOwner() ? 0 : 8);
                return;
            }
            return;
        }
        GuildRole role = ((PermissionOwner$Role) permissionOwner).getRole();
        Drawable drawable = ContextCompat.getDrawable(getContext(), 2131232011);
        m.checkNotNull(drawable);
        m.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl….ic_person_shield_24dp)!!");
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        DrawableCompat.setTint(drawable, RoleUtils.getRoleColor$default(role, context, null, 2, null));
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView2 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.image");
        MGImages.setImage$default(mGImages, simpleDraweeView2, drawable, (MGImages$ChangeDetector) null, 4, (Object) null);
        SimpleDraweeView simpleDraweeView3 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.image");
        IconUtils.setIcon$default(simpleDraweeView3, (String) null, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        TextView textView3 = this.binding.e;
        m.checkNotNullExpressionValue(textView3, "binding.name");
        textView3.setText(role.getName());
        TextView textView4 = this.binding.c;
        m.checkNotNullExpressionValue(textView4, "binding.description");
        textView4.setText(getContext().getText(ChannelPermissionUtilsKt.getChannelPermissionOwnerRoleLabel(role)));
        ImageView imageView2 = this.binding.f116b;
        m.checkNotNullExpressionValue(imageView2, "binding.crown");
        imageView2.setVisibility(8);
    }
}
