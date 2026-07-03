package com.discord.widgets.roles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.google.android.material.chip.ChipGroup;
import java.util.List;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C1086y;
import p007b.p008a.p027k.C1107b;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RolesListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RolesListView extends ChipGroup {
    private List<GuildRole> roles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RolesListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        this.roles = C12147n.emptyList();
        int iDpToPixels = DimenUtils.dpToPixels(4);
        setChipSpacingVertical(iDpToPixels);
        setChipSpacingHorizontal(iDpToPixels);
    }

    public final List<GuildRole> getRoles() {
        return this.roles;
    }

    public final void setRoles(List<GuildRole> list) {
        C12238m.checkNotNullParameter(list, "<set-?>");
        this.roles = list;
    }

    public final void updateView(List<GuildRole> roles, final int roleDefaultColor, final long guildId) {
        C12238m.checkNotNullParameter(roles, "roles");
        if (C12238m.areEqual(roles, this.roles)) {
            return;
        }
        final boolean isDeveloperMode = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
        this.roles = roles;
        removeAllViews();
        for (final GuildRole guildRole : roles) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.guild_role_chip, (ViewGroup) null, false);
            int i = C5419R.id.role_chip_dot;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.role_chip_dot);
            if (imageView != null) {
                i = C5419R.id.role_chip_icon;
                RoleIconView roleIconView = (RoleIconView) viewInflate.findViewById(C5419R.id.role_chip_icon);
                if (roleIconView != null) {
                    i = C5419R.id.role_chip_text;
                    TextView textView = (TextView) viewInflate.findViewById(C5419R.id.role_chip_text);
                    if (textView != null) {
                        CardView cardView = (CardView) viewInflate;
                        C12238m.checkNotNullExpressionValue(new C1086y(cardView, imageView, roleIconView, textView), "GuildRoleChipBinding.inf…om(context), null, false)");
                        C12238m.checkNotNullExpressionValue(textView, "binding.roleChipText");
                        textView.setText(guildRole.getName());
                        int opaqueColor = RoleUtils.isDefaultColor(guildRole) ? roleDefaultColor : RoleUtils.getOpaqueColor(guildRole);
                        C12238m.checkNotNullExpressionValue(imageView, "binding.roleChipDot");
                        ColorCompatKt.tintWithColor(imageView, opaqueColor);
                        roleIconView.setRole(guildRole, Long.valueOf(guildId));
                        if (isDeveloperMode) {
                            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.roles.RolesListView$updateView$$inlined$forEach$lambda$1
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    Context context = this.getContext();
                                    C12238m.checkNotNullExpressionValue(context, "context");
                                    C0876m.m164b(context, String.valueOf(guildRole.getId()), C1107b.m212d(this, C5419R.string.role_id_copied, new Object[]{guildRole.getName()}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
                                }
                            });
                        }
                        addView(cardView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
    }
}
