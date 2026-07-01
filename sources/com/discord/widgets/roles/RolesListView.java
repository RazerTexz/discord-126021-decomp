package com.discord.widgets.roles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.i.y;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.role.GuildRole;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.google.android.material.chip.ChipGroup;
import d0.t.n;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: RolesListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RolesListView extends ChipGroup {
    private List<GuildRole> roles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RolesListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        this.roles = n.emptyList();
        int iDpToPixels = DimenUtils.dpToPixels(4);
        setChipSpacingVertical(iDpToPixels);
        setChipSpacingHorizontal(iDpToPixels);
    }

    public final List<GuildRole> getRoles() {
        return this.roles;
    }

    public final void setRoles(List<GuildRole> list) {
        m.checkNotNullParameter(list, "<set-?>");
        this.roles = list;
    }

    public final void updateView(List<GuildRole> roles, int roleDefaultColor, long guildId) {
        m.checkNotNullParameter(roles, "roles");
        if (m.areEqual(roles, this.roles)) {
            return;
        }
        boolean isDeveloperMode = StoreStream.Companion.getUserSettings().getIsDeveloperMode();
        this.roles = roles;
        removeAllViews();
        for (GuildRole guildRole : roles) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.guild_role_chip, (ViewGroup) null, false);
            int i = R$id.role_chip_dot;
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.role_chip_dot);
            if (imageView != null) {
                i = R$id.role_chip_icon;
                RoleIconView roleIconView = (RoleIconView) viewInflate.findViewById(R$id.role_chip_icon);
                if (roleIconView != null) {
                    i = R$id.role_chip_text;
                    TextView textView = (TextView) viewInflate.findViewById(R$id.role_chip_text);
                    if (textView != null) {
                        CardView cardView = (CardView) viewInflate;
                        m.checkNotNullExpressionValue(new y(cardView, imageView, roleIconView, textView), "GuildRoleChipBinding.inf…om(context), null, false)");
                        m.checkNotNullExpressionValue(textView, "binding.roleChipText");
                        textView.setText(guildRole.getName());
                        int opaqueColor = RoleUtils.isDefaultColor(guildRole) ? roleDefaultColor : RoleUtils.getOpaqueColor(guildRole);
                        m.checkNotNullExpressionValue(imageView, "binding.roleChipDot");
                        ColorCompatKt.tintWithColor(imageView, opaqueColor);
                        roleIconView.setRole(guildRole, Long.valueOf(guildId));
                        if (isDeveloperMode) {
                            cardView.setOnClickListener(new RolesListView$updateView$$inlined$forEach$lambda$1(guildRole, this, roleDefaultColor, guildId, isDeveloperMode));
                        }
                        addView(cardView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
    }
}
