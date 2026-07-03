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
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.models.user.User;
import com.discord.utilities.channel.ChannelPermissionUtilsKt;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.permissions.PermissionOwner;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C0959g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelPermissionOwnerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPermissionOwnerView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0959g binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelPermissionOwnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        LayoutInflater.from(context).inflate(C5419R.layout.channel_permission_owner_view, this);
        int i = C5419R.id.crown;
        ImageView imageView = (ImageView) findViewById(C5419R.id.crown);
        if (imageView != null) {
            i = C5419R.id.description;
            TextView textView = (TextView) findViewById(C5419R.id.description);
            if (textView != null) {
                i = C5419R.id.image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.image);
                if (simpleDraweeView != null) {
                    i = C5419R.id.name;
                    TextView textView2 = (TextView) findViewById(C5419R.id.name);
                    if (textView2 != null) {
                        C0959g c0959g = new C0959g(this, imageView, textView, simpleDraweeView, textView2);
                        C12238m.checkNotNullExpressionValue(c0959g, "ChannelPermissionOwnerVi…ater.from(context), this)");
                        this.binding = c0959g;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8598a(PermissionOwner permissionOwner) {
        C12238m.checkNotNullParameter(permissionOwner, "permissionOwner");
        if (!(permissionOwner instanceof PermissionOwner.Role)) {
            if (permissionOwner instanceof PermissionOwner.Member) {
                PermissionOwner.Member member = (PermissionOwner.Member) permissionOwner;
                User user = member.getUser();
                SimpleDraweeView simpleDraweeView = this.binding.f855d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.image");
                IconUtils.setIcon$default(simpleDraweeView, member.getUser(), C5419R.dimen.avatar_size_large, null, null, null, 56, null);
                TextView textView = this.binding.f856e;
                C12238m.checkNotNullExpressionValue(textView, "binding.name");
                String nickname = member.getNickname();
                if (nickname == null) {
                    nickname = user.getUsername();
                }
                textView.setText(nickname);
                TextView textView2 = this.binding.f854c;
                C12238m.checkNotNullExpressionValue(textView2, "binding.description");
                textView2.setText(UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null));
                ImageView imageView = this.binding.f853b;
                C12238m.checkNotNullExpressionValue(imageView, "binding.crown");
                imageView.setVisibility(member.isOwner() ? 0 : 8);
                return;
            }
            return;
        }
        GuildRole role = ((PermissionOwner.Role) permissionOwner).getRole();
        Drawable drawable = ContextCompat.getDrawable(getContext(), C5419R.drawable.ic_person_shield_24dp);
        C12238m.checkNotNull(drawable);
        C12238m.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl….ic_person_shield_24dp)!!");
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        DrawableCompat.setTint(drawable, RoleUtils.getRoleColor$default(role, context, null, 2, null));
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView2 = this.binding.f855d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.image");
        MGImages.setImage$default(mGImages, simpleDraweeView2, drawable, (MGImages.ChangeDetector) null, 4, (Object) null);
        SimpleDraweeView simpleDraweeView3 = this.binding.f855d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.image");
        IconUtils.setIcon$default(simpleDraweeView3, (String) null, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView3 = this.binding.f856e;
        C12238m.checkNotNullExpressionValue(textView3, "binding.name");
        textView3.setText(role.getName());
        TextView textView4 = this.binding.f854c;
        C12238m.checkNotNullExpressionValue(textView4, "binding.description");
        textView4.setText(getContext().getText(ChannelPermissionUtilsKt.getChannelPermissionOwnerRoleLabel(role)));
        ImageView imageView2 = this.binding.f853b;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.crown");
        imageView2.setVisibility(8);
    }
}
