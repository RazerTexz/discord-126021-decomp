package com.discord.views.directories;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.GuildView;
import com.discord.views.guilds.ServerMemberCount;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.C0963g3;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ServerDiscoveryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerDiscoveryItem extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0963g3 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerDiscoveryItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_server_discovery_item, this);
        int i = C5419R.id.button_barrier;
        Barrier barrier = (Barrier) findViewById(C5419R.id.button_barrier);
        if (barrier != null) {
            i = C5419R.id.server_discovery_item_barrier;
            Barrier barrier2 = (Barrier) findViewById(C5419R.id.server_discovery_item_barrier);
            if (barrier2 != null) {
                i = C5419R.id.server_discovery_item_button;
                MaterialButton materialButton = (MaterialButton) findViewById(C5419R.id.server_discovery_item_button);
                if (materialButton != null) {
                    i = C5419R.id.server_discovery_item_button_joined;
                    MaterialButton materialButton2 = (MaterialButton) findViewById(C5419R.id.server_discovery_item_button_joined);
                    if (materialButton2 != null) {
                        i = C5419R.id.server_discovery_item_count_container;
                        ServerMemberCount serverMemberCount = (ServerMemberCount) findViewById(C5419R.id.server_discovery_item_count_container);
                        if (serverMemberCount != null) {
                            i = C5419R.id.server_discovery_item_description;
                            TextView textView = (TextView) findViewById(C5419R.id.server_discovery_item_description);
                            if (textView != null) {
                                i = C5419R.id.server_discovery_item_image;
                                GuildView guildView = (GuildView) findViewById(C5419R.id.server_discovery_item_image);
                                if (guildView != null) {
                                    i = C5419R.id.server_discovery_item_title;
                                    TextView textView2 = (TextView) findViewById(C5419R.id.server_discovery_item_title);
                                    if (textView2 != null) {
                                        C0963g3 c0963g3 = new C0963g3(this, barrier, barrier2, materialButton, materialButton2, serverMemberCount, textView, guildView, textView2);
                                        C12238m.checkNotNullExpressionValue(c0963g3, "ViewServerDiscoveryItemB…ater.from(context), this)");
                                        this.binding = c0963g3;
                                        guildView.m8546b();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setDescription(CharSequence description) {
        TextView textView = this.binding.f871e;
        C12238m.checkNotNullExpressionValue(textView, "binding.serverDiscoveryItemDescription");
        C1107b.m209a(textView, description);
    }

    public final void setJoinButtonOnClickListener(View.OnClickListener listener) {
        this.binding.f868b.setOnClickListener(listener);
    }

    public final void setJoinedButtonOnClickListener(View.OnClickListener listener) {
        this.binding.f869c.setOnClickListener(listener);
    }

    public final void setJoinedGuild(boolean joinedGuild) {
        MaterialButton materialButton = this.binding.f868b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.serverDiscoveryItemButton");
        materialButton.setVisibility(joinedGuild ^ true ? 0 : 8);
        MaterialButton materialButton2 = this.binding.f869c;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.serverDiscoveryItemButtonJoined");
        materialButton2.setVisibility(joinedGuild ? 0 : 8);
    }

    public final void setMembers(int members) {
        this.binding.f870d.setMembers(Integer.valueOf(members));
    }

    public final void setOnline(int active) {
        this.binding.f870d.setOnline(Integer.valueOf(active));
    }

    public final void setTitle(CharSequence title) {
        TextView textView = this.binding.f873g;
        C12238m.checkNotNullExpressionValue(textView, "binding.serverDiscoveryItemTitle");
        textView.setText(title);
    }
}
