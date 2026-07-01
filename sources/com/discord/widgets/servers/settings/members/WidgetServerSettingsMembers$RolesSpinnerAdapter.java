package com.discord.widgets.servers.settings.members;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import b.a.i.k1;
import b.a.i.l1;
import com.discord.R$layout;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers$RolesSpinnerAdapter extends ArrayAdapter<GuildRole> {
    private final ArrayList<GuildRole> roles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsMembers$RolesSpinnerAdapter(Context context, ArrayList<GuildRole> arrayList) {
        super(context, R$layout.server_settings_members_role_spinner_item, arrayList);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(arrayList, "roles");
        this.roles = arrayList;
    }

    private final void configureLabel(TextView label, int position) {
        GuildRole item = getItem(position);
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        label.setTextColor(RoleUtils.getRoleColor$default(item, context, null, 2, null));
        label.setText(item.getName());
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.roles.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        l1 l1Var;
        m.checkNotNullParameter(parent, "parent");
        if (convertView == null) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.server_settings_members_role_spinner_item_open, (ViewGroup) null, false);
            Objects.requireNonNull(viewInflate, "rootView");
            TextView textView = (TextView) viewInflate;
            l1Var = new l1(textView, textView);
        } else {
            TextView textView2 = (TextView) convertView;
            l1Var = new l1(textView2, textView2);
        }
        m.checkNotNullExpressionValue(l1Var, "if (convertView == null)…bind(convertView)\n      }");
        TextView textView3 = l1Var.f151b;
        m.checkNotNullExpressionValue(textView3, "binding.roleSpinnerItemTextview");
        configureLabel(textView3, position);
        TextView textView4 = l1Var.a;
        m.checkNotNullExpressionValue(textView4, "binding.root");
        return textView4;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int i) {
        return getItem(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        k1 k1Var;
        m.checkNotNullParameter(parent, "parent");
        if (convertView == null) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.server_settings_members_role_spinner_item, (ViewGroup) null, false);
            Objects.requireNonNull(viewInflate, "rootView");
            TextView textView = (TextView) viewInflate;
            k1Var = new k1(textView, textView);
        } else {
            TextView textView2 = (TextView) convertView;
            k1Var = new k1(textView2, textView2);
        }
        m.checkNotNullExpressionValue(k1Var, "if (convertView == null)…bind(convertView)\n      }");
        TextView textView3 = k1Var.f145b;
        m.checkNotNullExpressionValue(textView3, "binding.roleSpinnerItemTextview");
        configureLabel(textView3, position);
        TextView textView4 = k1Var.a;
        m.checkNotNullExpressionValue(textView4, "binding.root");
        return textView4;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public GuildRole getItem(int position) {
        GuildRole guildRole = this.roles.get(position);
        m.checkNotNullExpressionValue(guildRole, "roles[position]");
        return guildRole;
    }
}
